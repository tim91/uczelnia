using PluginInterface;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace paint_tpal
{
    public partial class Paint : Form
    {
        public Paint()
        {
            InitializeComponent();
            InitApplication();
        }

        private void InitApplication()
        {
            LoadPlugins();
        }
        private Dictionary<int, IPaintPlugin> plugins = new Dictionary<int, IPaintPlugin>(2);

        private String currentImagePath;
        private Bitmap mainBitMap;
        UndoRedoManager undoRedoManager = new UndoRedoManager();

        private void LoadPlugins()
        {
            DirectoryInfo di = new DirectoryInfo("./pluginy");
            foreach (FileInfo f in di.GetFiles("*.dll"))
            {
                Assembly a = Assembly.LoadFile(f.FullName);
                Type[] types = a.GetTypes();
                foreach (Type t in types)
                {
                    if (t.GetInterfaces().Contains(typeof(IPaintPlugin)))
                    {
                        IPaintPlugin plugin = Activator.CreateInstance(t) as IPaintPlugin;
                        ToolStripMenuItem newItem = new ToolStripMenuItem(plugin.getName());
                        newItem.Click += newItem_Click;
                        int index = addPlugin(newItem);
                        plugins.Add(index, plugin);
                        Console.WriteLine("index: " + index + " name: " + plugin.getName());
                    }
                }
            }

        }

        void newItem_Click(object sender, EventArgs e)
        {
            if (mainBitMap != null)
            {
                ToolStripMenuItem item = sender as ToolStripMenuItem;
                if (item != null)
                {
                    int index = (item.OwnerItem as ToolStripMenuItem).DropDownItems.IndexOf(item);
                    Console.WriteLine("Click: " + index);
                    IPaintPlugin plugin;
                    if (plugins.TryGetValue(index, out plugin))
                    {
                        ICommand transformationCommand = new TransformCommand(plugin, mainBitMap,this.pictureBox1);
                        transformationCommand.Execute();
                        undoRedoManager.registerExecutedCommand(transformationCommand);
                        //mainBitMap = plugin.transaform(mainBitMap);
                        //displayImage(mainBitMap);
                    }
                }
            }
            else
            {
                MessageBox.Show("Najpierw wczytaj obraz");
            }


        }

        private int addPlugin(ToolStripMenuItem it)
        {
            ToolStripMenuItem item = (ToolStripMenuItem)menuStrip1.Items["pluginyToolStripMenuItem"];
            return item.DropDownItems.Add(it);
        }

        private void openFileDialog1_FileOk(object sender, CancelEventArgs e)
        {
            Console.WriteLine("plik ok");
            OpenFileDialog fileDialog = sender as OpenFileDialog;
            currentImagePath = fileDialog.FileName;
            mainBitMap = (Bitmap)Bitmap.FromFile(currentImagePath);
            if (mainBitMap != null)
            {
                this.pictureBox1.Image = mainBitMap;
                this.pictureBox1.SizeMode = PictureBoxSizeMode.Zoom;
                this.pictureBox1.Refresh();
            }
            
        }


        private void wczytajToolStripMenuItem_Click(object sender, EventArgs e)
        {
            openFileDialog1.ShowDialog();
        }

        private void zamknijToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void wyczyscToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Console.WriteLine("Czyszczenie...");
            if (currentImagePath != null && mainBitMap != null)
            {
                ICommand clearComm = new ClearCommand(this.currentImagePath, this.mainBitMap, this.pictureBox1);
                clearComm.Execute();
                undoRedoManager.registerExecutedCommand(clearComm);
            }

        }

        private void undoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.undoRedoManager.Undo();
        }

        private void redoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.undoRedoManager.Redo();
        }


    }
}

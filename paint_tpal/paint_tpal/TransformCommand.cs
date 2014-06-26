using PluginInterface;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace paint_tpal
{
    class TransformCommand : BaseCommand, ICommand
    {
        private IPaintPlugin plugin;
        private Bitmap bitMap;
        private Bitmap bforeTransaformation;

        public TransformCommand(IPaintPlugin p, Bitmap bm,PictureBox pBox) : base(pBox)
        {
            this.plugin = p;
            this.bitMap = bm;
        }

        public Bitmap Execute()
        {
            this.bforeTransaformation = (Bitmap)this.bitMap.Clone();
            this.bitMap = this.plugin.transaform(this.bitMap);
            this.bitMap = this.plugin.transaform(this.bitMap);
            displayImage(this.bitMap);
            return this.bitMap;
        }

        public Bitmap Undo()
        {
            this.bitMap = this.bforeTransaformation;
            Console.WriteLine(this.bitMap);
            displayImage(this.bforeTransaformation);
            return this.bitMap;
            //this.bforeTransaformation = null;
        }
    }
}

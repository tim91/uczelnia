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

        public void Execute()
        {
            this.bforeTransaformation = (Bitmap)this.bitMap.Clone();
            displayImage(this.plugin.transaform(bitMap));
        }

        public void Undo()
        {
            this.bitMap = this.bforeTransaformation;
            displayImage(this.bforeTransaformation);
            
            //this.bforeTransaformation = null;
        }
    }
}

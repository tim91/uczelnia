using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace paint_tpal
{
    class ClearCommand : BaseCommand, ICommand
    {
        private String imagePath;
        private Bitmap bitMap;
        private Bitmap bforeTransaformation;

        public ClearCommand(String path,Bitmap map,PictureBox pb) : base(pb)
        {
            this.imagePath = path;
            this.bitMap = map;
        }

        public void Execute()
        {
            this.bforeTransaformation = (Bitmap)this.bitMap.Clone();
            this.bitMap = (Bitmap)Bitmap.FromFile(this.imagePath);
            displayImage(this.bitMap);
        }

        public void Undo()
        {
            this.bitMap = this.bforeTransaformation;
            displayImage(this.bitMap);
            //this.bforeTransaformation = null;
        }
    }
}

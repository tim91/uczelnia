using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace paint_tpal
{
    abstract class BaseCommand
    {
        private PictureBox pBox;
        public BaseCommand(PictureBox pb)
        {
            this.pBox = pb;
        }

        public void displayImage(Bitmap bm)
        {
            this.pBox.Image = bm;
            this.pBox.SizeMode = PictureBoxSizeMode.Zoom;
            this.pBox.Refresh();
        }
    }
}

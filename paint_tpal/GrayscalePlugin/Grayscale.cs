using PluginInterface;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GrayscalePlugin
{
    public class Grayscale1 : IPaintPlugin
    {
        public String getName()
        {
            return "Grayscale";
        }

        public Bitmap transaform(Bitmap m)
        {
            SetGrayscale(m);
            return m;
        }

        public void SetGrayscale(Bitmap bmap)
        {
            Color c;
            for (int i = 0; i < bmap.Width; i++)
            {
                for (int j = 0; j < bmap.Height; j++)
                {
                    c = bmap.GetPixel(i, j);
                    byte gray = (byte)(.299 * c.R + .587 * c.G + .114 * c.B);

                    bmap.SetPixel(i, j, Color.FromArgb(gray, gray, gray));
                }
            }
        }
    }
}

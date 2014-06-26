using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace PluginInterface
{
    public interface IPaintPlugin
    {
        String getName();
        Bitmap transaform(Bitmap m);
    }
}

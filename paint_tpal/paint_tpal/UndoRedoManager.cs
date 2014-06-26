using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace paint_tpal
{
    class UndoRedoManager
    {
        private Stack<ICommand> undoStack = new Stack<ICommand>();
        private Stack<ICommand> redoStack = new Stack<ICommand>();

        public Bitmap Redo()
        {
            if (redoStack.Count != 0)
            {
               ICommand command = redoStack.Pop();
               Bitmap mm = command.Execute();
               undoStack.Push(command);
               return mm;
            }
            return null;
        }

        public Bitmap Undo()
        {
           if (undoStack.Count != 0)
           {
              ICommand command = undoStack.Pop();
              Bitmap mm = command.Undo();
              redoStack.Push(command);
              return mm;
           }
           return null;
        }

        public void registerExecutedCommand(ICommand com)
        {
            undoStack.Push(com);
            //nie ma wiecej operacji w przod na tej sciezce
            redoStack.Clear();
        }
    }
}

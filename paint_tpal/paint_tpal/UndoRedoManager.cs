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

        public void Redo()
        {
            if (redoStack.Count != 0)
            {
               ICommand command = redoStack.Pop();
               command.Execute();
               undoStack.Push(command);
            }
        }

        public void Undo()
        {
           if (undoStack.Count != 0)
           {
              ICommand command = undoStack.Pop();
              command.Undo();
              redoStack.Push(command);
           }
        }

        public void registerExecutedCommand(ICommand com)
        {
            undoStack.Push(com);
            //nie ma wiecej operacji w przod na tej sciezce
            redoStack.Clear();
        }

        public void clearHistory()
        {
            this.undoStack.Clear();
            this.redoStack.Clear();
        }
    }
}

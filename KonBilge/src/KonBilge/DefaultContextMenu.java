/*

 This file is part of KonBilge.

KonBilge is free software: you can redistribute it and/or 
modify it under the terms of the GNU General Public 
License as published by the Free Software Foundation, 
either version 3 of the License, or (at your option)
any later version.

KonBilge is distributed in the hope that it will be 
useful, but WITHOUT ANY WARRANTY; without even 
the implied warranty of MERCHANTABILITY or 
FITNESS FOR A PARTICULAR PURPOSE. 
See the GNU General Public License for more details.

You should have received a copy of the GNU General 
Public License along with Foobar. 
If not, see <https://www.gnu.org/licenses/>.
 
 */
package KonBilge;

/**
 *
 * @author Nusret BAŞÇİFCİ
 */
import javax.swing.*;
import javax.swing.text.JTextComponent;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultContextMenu extends JPopupMenu
{
    private Clipboard clipboard;

    private UndoManager undoManager;

    private JMenuItem undo;
    private JMenuItem redo;
    private JMenuItem cut;
    private JMenuItem copy;
    private JMenuItem paste;
    private JMenuItem delete;
    private JMenuItem selectAll;

    private JTextComponent textComponent;

    public DefaultContextMenu()
    {
        undoManager = new UndoManager();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        addPopupMenuItems();
    }

    private void addPopupMenuItems()
    {
        undo = new JMenuItem("Geri al");
        undo.setEnabled(false);
        undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        undo.addActionListener(event -> undoManager.undo());
        add(undo);

        redo = new JMenuItem("İleri al");
        redo.setEnabled(false);
        redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        redo.addActionListener(event -> undoManager.redo());
        add(redo);

        add(new JSeparator());

        cut = new JMenuItem("Kes");
        cut.setEnabled(false);
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        cut.addActionListener(event -> textComponent.cut());
        add(cut);

        copy = new JMenuItem("Kopyala");
        copy.setEnabled(false);
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        copy.addActionListener(event -> textComponent.copy());
        add(copy);

        paste = new JMenuItem("Yapıştır");
        paste.setEnabled(false);
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        paste.addActionListener(event -> textComponent.paste());
//        
        add(paste);

        delete = new JMenuItem("Sil");
        delete.setEnabled(false);
        delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
        delete.addActionListener(event -> textComponent.replaceSelection(""));
        add(delete);

        add(new JSeparator());

        selectAll = new JMenuItem("Tümünü Seç");
        selectAll.setEnabled(false);
        selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        selectAll.addActionListener(event -> textComponent.selectAll());
        add(selectAll);
    }

    private void addTo(JTextComponent textComponent)
    {
        textComponent.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent pressedEvent)
            {
                if ((pressedEvent.getKeyCode() == KeyEvent.VK_Z)
                        && ((pressedEvent.getModifiersEx() & Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()) != 0))
                {
                    if (undoManager.canUndo())
                    {
                        undoManager.undo();
                    }
                }

                if ((pressedEvent.getKeyCode() == KeyEvent.VK_Y)
                        && ((pressedEvent.getModifiersEx() & Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()) != 0))
                {
                    if (undoManager.canRedo())
                    {
                        undoManager.redo();
                    }
                }
            }
        });

        textComponent.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent releasedEvent)
            {
                handleContextMenu(releasedEvent);
            }

            @Override
            public void mouseReleased(MouseEvent releasedEvent)
            {
                handleContextMenu(releasedEvent);
            }
        });

        textComponent.getDocument().addUndoableEditListener(event -> undoManager.addEdit(event.getEdit()));
    }

    private void handleContextMenu(MouseEvent releasedEvent)
    {
        if (releasedEvent.getButton() == MouseEvent.BUTTON3)
        {
            processClick(releasedEvent);
        }
    }

    private void processClick(MouseEvent event)
    {
        textComponent = (JTextComponent) event.getSource();
        textComponent.requestFocus();

        boolean enableUndo = undoManager.canUndo();
        boolean enableRedo = undoManager.canRedo();
        boolean enableCut = false;
        boolean enableCopy = false;
        boolean enablePaste = false;
        boolean enableDelete = false;
        boolean enableSelectAll = false;

        String selectedText = textComponent.getSelectedText();
        String text = textComponent.getText();

        if (text != null)
        {
            if (text.length() > 0)
            {
                enableSelectAll = true;
            }
        }

        if (selectedText != null)
        {
            if (selectedText.length() > 0)
            {
                enableCut = true;
                enableCopy = true;
                enableDelete = true;
            }
        }

        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor) && textComponent.isEnabled())
        {
            enablePaste = true;
        }

        undo.setEnabled(enableUndo);
        redo.setEnabled(enableRedo);
        cut.setEnabled(enableCut);
        copy.setEnabled(enableCopy);
        paste.setEnabled(enablePaste);
        delete.setEnabled(enableDelete);
        selectAll.setEnabled(enableSelectAll);

        // Shows the popup menu
        show(textComponent, event.getX(), event.getY());
    }

    public static void addDefaultContextMenu(JTextComponent component)
    {
        DefaultContextMenu defaultContextMenu = new DefaultContextMenu();
        defaultContextMenu.addTo(component);
    }

    void addTo(JMenu component) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

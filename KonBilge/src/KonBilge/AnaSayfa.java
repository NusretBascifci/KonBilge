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

import javax.swing.ButtonGroup;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import static java.awt.event.InputEvent.CTRL_MASK;
import static javax.swing.KeyStroke.getKeyStroke;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;


import java.awt.dnd.DropTarget;

import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.KeyStroke;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.Element;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;

import javax.swing.text.StyleConstants;

import javax.swing.text.StyledDocument;

import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

import org.jdesktop.beansbinding.AutoBinding;


/**
 *
 * @author abc
 */
public class AnaSayfa extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
	/**
     * Creates new form AnaSayfa
     */
    JMenuItem cut, copy, paste, undo, redo;
    ButtonGroup group = new ButtonGroup();
    CetiEditorKit CT = new CetiEditorKit();
    Document stilkdokuman = new DefaultStyledDocument();
    private UndoManager undoManager;

    public AnaSayfa() {

        initComponents();
        ////JMenu2 Kes başlangıcı

////JMenu2 Kes bitişi
        //CT.PAGE_WIDTH=jTextPane19.getWidth();
        jTextPane1.setEditorKit(CT);
        jButton1.setText("Kabartmaya çevir");

//JOptionPane.showMessageDialog(null, initializeAccessBridge());
        //////////////////////////// başlar
//bu bölüm ctrl+z ve ctrl+y(ileri ve geri alma işlemlerini) nin görevini yapıyor
// In the constructor
        cut = new JMenuItem("Kes");
        cut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        cut.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        cut.setSelected(true);
        cut.addActionListener((java.awt.event.ActionEvent evt) -> {
            //  jMenuItem1ActionPerformed(evt);
            jTextPane1.cut();
        });

        copy = new JMenuItem("Kopyala");
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        copy.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        copy.setSelected(true);
        copy.addActionListener((java.awt.event.ActionEvent evt) -> {
            //  jMenuItem1ActionPerformed(evt);
            jTextPane1.copy();
        });

        paste = new JMenuItem("Yapıştır");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
        paste.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        paste.setSelected(true);
        paste.addActionListener((java.awt.event.ActionEvent evt) -> {
            //  jMenuItem1ActionPerformed(evt);
            jTextPane1.paste();
        });

        undo = new JMenuItem("Geri al");
        undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
        undo.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        undo.setSelected(true);
        undo.addActionListener((java.awt.event.ActionEvent evt) -> {
            //  jMenuItem1ActionPerformed(evt);
            if (undoManager.canUndo()) {
                undoManager.undo();
            }
        });

        redo = new JMenuItem("İleri al");
        redo.setAccelerator(getKeyStroke(KeyEvent.VK_Y, CTRL_MASK));
        redo.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        redo.setSelected(true);
        redo.addActionListener((java.awt.event.ActionEvent evt) -> {
            //  jMenuItem1ActionPerformed(evt);
            if (undoManager.canRedo()) {
                undoManager.redo();
            }
        });
        jMenu2.add(cut);
        jMenu2.add(copy);
        jMenu2.add(paste);
        jMenu2.addSeparator();
        jMenu2.add(undo);
        jMenu2.add(redo);
        group.add(jCheckBoxMenuItem6);
        group.add(jCheckBoxMenuItem8);
        group.add(jCheckBoxMenuItem1);
        group.add(jCheckBoxMenuItem2);
        group.add(jCheckBoxMenuItem4);
        group.add(jCheckBoxMenuItem5);

////////
///
//
        undoManager = new UndoManager();
        Document doc = jTextPane1.getDocument();
        doc.addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {

                //System.out.println("Add edit");
                undoManager.addEdit(e.getEdit());

            }
        });

        InputMap im = jTextPane1.getInputMap(JComponent.WHEN_FOCUSED);
        ActionMap am = jTextPane1.getActionMap();

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "Undo");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Y, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "Redo");

        am.put("Undo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (undoManager.canUndo()) {
                        undoManager.undo();
                    }
                } catch (CannotUndoException exp) {
                    exp.printStackTrace();
                }
            }

        });
        am.put("Redo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (undoManager.canRedo()) {
                        undoManager.redo();
                    }
                } catch (CannotUndoException exp) {
                    exp.printStackTrace();
                }
            }
        });
        //////////////////////////biter
        /////////////////////////başlar

        //bu bölüm sürükle bırak işini yapar
        DropTarget dropTarget2 = new DropTarget() {
            public synchronized void drop(DropTargetDropEvent evt) {
                try {
                    evt.acceptDrop(DnDConstants.ACTION_COPY);
                    List<File> transferData = extracted(evt);
					List<File> droppedFiles = transferData;
                    Dosya_Konum_Penceresi dkp = new Dosya_Konum_Penceresi();
                    for (File file : droppedFiles) {
                        dkp.dosya = file;
                    }
                    dkp.dosya_konum2();

                    Font font = new Font("Times New Roman", Font.ROMAN_BASELINE, 28);
                    jTextPane1.setFont(font);
                    jTextPane1.setDocument(dkp.stydoc);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

			private List<File> extracted(DropTargetDropEvent evt) throws UnsupportedFlavorException, IOException {
				return (List<File>) evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
			}
        };
		DropTarget dropTarget = dropTarget2;
		jTextPane1.setDropTarget(dropTarget);
        ///////////////////////////////////
        DefaultContextMenu.addDefaultContextMenu(jTextPane1);
        ////// başla alt tuşuna basınca dosya menüsüne odaklanır
        Action action = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jMenu1.doClick();
            }
        };
        jPanel1.getActionMap().put("myAction", action);
        jPanel1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ALT, KeyEvent.ALT_DOWN_MASK), "myAction");
////////////son
//        Action cutAction = new DefaultEditorKit.CutAction();
//      cutAction.putValue(Action.NAME, "Kes");
//    cutAction.putValue(Action.DEFAULT, KeyEvent.VK_X);
//      jMenu2.add(cutAction);
    }

    /*
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    seri_port seri1 = new seri_port();
    String gelen1 = "";

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        label1 = new java.awt.Label();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu4 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jCheckBoxMenuItem6 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem8 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem4 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem5 = new javax.swing.JCheckBoxMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        jCheckBoxMenuItem3.setSelected(true);
        jCheckBoxMenuItem3.setText("jCheckBoxMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("KonBilge S1");
        setFont(new java.awt.Font("Calibri", 2, 12)); // NOI18N
        setLocationByPlatform(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });

        jTextPane1.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jTextPane1.setToolTipText("");
        jTextPane1.setDragEnabled(true);
        jTextPane1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextPane1CaretUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(jTextPane1);

        label1.setName(""); // NOI18N
        label1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label1MouseClicked(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 0));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setFocusCycleRoot(true);
        jMenuBar1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N

        jMenu1.setMnemonic('d');
        jMenu1.setText("      Dosya       ");
        jMenu1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jMenuItem1.setText("Yeni");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jMenuItem2.setText("Aç");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem7.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jMenuItem7.setText("Kabartmaya Çevir");
        jMenuItem7.setToolTipText("");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuBar1.add(jMenu1);

        jMenu2.setMnemonic('z');
        jMenu2.setText("   Düzen    ");
        jMenu2.setToolTipText("");
        jMenu2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem10.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jMenuItem10.setText("italic");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);
        jMenu2.add(jSeparator2);

        jMenuBar1.add(jMenu2);

        jMenu4.setMnemonic('A');
        jMenu4.setText("      Araçlar    ");
        jMenu4.setToolTipText("");
        jMenu4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        jMenu6.setText("Kısaltma Seçenekleri");
        jMenu6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jMenu6.setRolloverEnabled(false);

        jCheckBoxMenuItem6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jCheckBoxMenuItem6.setSelected(true);
        jCheckBoxMenuItem6.setText("Kısaltmasız");
        jMenu6.add(jCheckBoxMenuItem6);

        jCheckBoxMenuItem8.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jCheckBoxMenuItem8.setSelected(true);
        jCheckBoxMenuItem8.setText("Bir Harfli Kısaltmalar");
        jMenu6.add(jCheckBoxMenuItem8);

        jCheckBoxMenuItem1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("İki Harfli Kısaltmalar");
        jMenu6.add(jCheckBoxMenuItem1);

        jCheckBoxMenuItem2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("Hece Kısaltmaları");
        jMenu6.add(jCheckBoxMenuItem2);

        jCheckBoxMenuItem4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jCheckBoxMenuItem4.setSelected(true);
        jCheckBoxMenuItem4.setText("Kelime Kökü Kısaltmaları");
        jMenu6.add(jCheckBoxMenuItem4);

        jCheckBoxMenuItem5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jCheckBoxMenuItem5.setSelected(true);
        jCheckBoxMenuItem5.setText("Kelime Parçası Kısaltmaları(Son Kademe)");
        jMenu6.add(jCheckBoxMenuItem5);

        jMenu4.add(jMenu6);

        jMenuBar1.add(jMenu4);

        jMenu5.setMnemonic('Y');
        jMenu5.setText("     Yazıcı    ");
        jMenu5.setToolTipText("");
        jMenu5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        jMenuItem3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jMenuItem3.setText("Bağlan");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jMenuItem4.setText("Gönder");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem4);

        jMenuBar1.add(jMenu5);

        jMenu3.setMnemonic('R');
        jMenu3.setText("    Yardım  ");
        jMenu3.setToolTipText("");
        jMenu3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        jMenuItem6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jMenuItem6.setText("Hakkımızda");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem5.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jMenuItem5.setText("Lisans");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
        CT.PAGE_WIDTH = jTextPane1.getWidth() - 15;
    }//GEN-LAST:event_formComponentResized

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        new AnaSayfa().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    int a = 0;

    String metin = "";
    String metinkabartma = "";
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        StyledDocument doc1 = (StyledDocument) jTextPane1.getDocument();
        Element element;
        boolean dogrula = false;
        int italic_uzunluğu = 0;
        int italic_baslangic_noktasi = 0;
        for (int i = 0; i < doc1.getLength(); i++) {

            element = doc1.getCharacterElement(i);

            AttributeSet as = element.getAttributes();
            //apply a new style based on previous 
            MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());

            if (StyleConstants.isItalic(asNew)) {

                if (dogrula == false) {
                    italic_baslangic_noktasi = i;
                    try {
                        doc1.insertString(italic_baslangic_noktasi, "\u017e", as);
                    } catch (BadLocationException ex) {
                        Logger.getLogger(AnaSayfa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                // belgenin en son kelimesi italic ise en sona italic işareti koyar
                if (doc1.getLength() == i + 1) {
                    try {
                        doc1.insertString(i + 1, "\u017e", as);
                        break;
                    } catch (BadLocationException ex) {
                        Logger.getLogger(AnaSayfa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                dogrula = true;
                italic_uzunluğu++;

            } else {
                if (dogrula) {

                    try {
                        doc1.insertString(i, "\u017e", as);

                    } catch (BadLocationException ex) {
                        Logger.getLogger(AnaSayfa.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    italic_uzunluğu = 0;
                    dogrula = false;

                }

            }
        }

        /*   try {
            JOptionPane.showMessageDialog(null, doc.getText(0, doc.getLength()).toString());
        } catch (BadLocationException ex) {
            Logger.getLogger(AnaSayfa.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
        if (a == 0) {
            stilkdokuman = (StyledDocument) jTextPane1.getDocument();

            Font font = new Font("Times New Roman", Font.PLAIN, 28);

            jTextPane1.setFont(font);
            try {

                metin = doc1.getText(0, doc1.getLength());

            } catch (BadLocationException ex) {
                Logger.getLogger(AnaSayfa.class.getName()).log(Level.SEVERE, null, ex);
            }
            //////////////////////////////////////////////////////////////
            ////
            //
            //â
            //braille de çift tırnak işareti yoktur. Onun yerine çift tırnak açma(2,3 ve 6) ve çift tırnak kapatma(3,5 ve 6) işaretleri vardır.
            //Hepsi büyük harflerden oluşan kelimenin önüne 2 tane 6. nokta atar
            // iki tane 6. nokta ve geçici karakteri(\u0111)đ de ekler.

            metin = metin.replaceAll("([A-ZİŞÇÜÖĞÂÛÎ']{2,})", "\u00B6\u00B6\u0111$1");
            //metin = metin.replaceAll("¶¶\\u0111 ", " ¶¶\u0111");
            //Başlık harici tamamı büyük kelimelerin başına 2 tane 6 nokta atar.

            metin = metin.replaceAll("([A-ZİŞÇÜÖĞÂÛÎ])([a-zışçüöğâûî])", "\u00B6\u0111$1$2");
            // bir tane 6. nokta ve geçici karakteri(\u0111)đ de ekler.
            //geçici karakterin amacı bir harfli kı saltmalarda önünde harf var mı yok mu
            //diye bakar. büyük harf işaretini harf olarak algıladığı için kısaltma yapmaz 
            //bu durumu çözmek için geçici harf đ(\u0111) yi kullandık işi bitince sildik
            metin = metin.replaceAll("(^[A-ZİŞÇÜÖĞÂÛÎ]) ", "\u00B6\u0111$1 ");
            metin = metin.replaceAll(" ([A-ZİŞÇÜÖĞÂÛÎ]) ", " \u00B6\u0111$1 ");
            //metin=metin.replaceAll("\\u00c2", "\u00e2");
            //bütün harfleri küçük harfe çevir
            metin = metin.toLowerCase();
            //sigma işareti & yerine  ve yazıyor
            metin = metin.replaceAll("\\u0026", "\u0111v\u0111e\u0111");
            metin = metin.replaceAll("\\u0024", "\u0111\u0178\u0111d\u0111");
            //şapkalı a ların hepsini normal a ile değiştir.
            metin = metin.replaceAll("\\u00e2", "\u00FFa");
            metin = metin.replaceAll("\\u00fb", "\u00FFu");
            metin = metin.replaceAll("\\u00ee", "\u00FFi");
            //$ işareti kelimenin sonunda "( \")olan kelimeye çift tırnak kapatma işaretini(\u201D) koyar. 
            metin = metin.replaceAll("\"$", "\u201D");
            metin = metin.replaceAll("\\u0022$", "\u201D");
            //^ işareti kelimenin başında "( \")olan kelimenin başına çift tırnak açma işaretini(\u201C) koyar.
            metin = metin.replaceAll("^\"", "\u201C\u0111");
            metin = metin.replaceAll("^\\u0022", "\u201C\u0111");
            //çift tırnaktan sonra nokta gelirse çift tırnak kapama işareti ve nokta koy.
            metin = metin.replace("\".", "\u201D.");
            metin = metin.replace("\\u0022.", "\u201D.");
            //çift tırnaktan sonra boşluk gelirse çift tırnak kapama işareti ve boşluk işareti koy.
            metin = metin.replace("\" ", "\u201D ");
            metin = metin.replace("\\u0022 ", "\u201D ");
            // çift tırnaktan önce boşluk varsa boşluk koy sonra geçici işaret(\u0111)đ koy
            //(\u0111)đ işareti tek harfli kısaltmaların uygulanabilmesi için çift tırnakla
            //kelime arasına girer ve kısaltma  yapılmasını sağlar
            //sonra çift tırnak açma işareti koy
            // metin = metin.replaceAll("^\"", "\u201C\u0111");//**
            metin = metin.replaceAll(" \"", " \u201C\u0111");
            metin = metin.replaceAll("([^a-zışçüöğ])(\")", "$1\u201C\u0111");//**

            //matematikte kullanılan parantez açma ve kapama için
            metin = metin.replaceAll("([\\u0028])(\\d+)", "ğ$2");
            metin = metin.replaceAll("(\\d+)([\\u0029])", "$1\u00ef");
            //sayı ve rakamların önlerine sayı işareti ekliyor
            metin = metin.replaceAll("(\\d+)", "\u00E8$1");
            //matematiksel işaretlerin (+,-,/,=,x) önlerine işlem işareti ekliyor
            metin = metin.replaceAll("(\\d+)([+,-,x,*,/,=])", "$1\u00E1$2\u0111");

            metin = metin.replaceAll("^\\u0028", "\u0028\u0111");
            metin = metin.replaceAll(" \\u0028", " \u0028\u0111");
            //Parantez ile başlayan veya boşluk parantez ile(\u0028)başlayan
            //kelimelerde parantezden sonra (\u0111)đ geçici 
            //karakteri koyar. Tek harfli kısaltmaların önüne geçici işareti koymalı ki
            //kısaltma yapabilsin.
            // büyüktür ve küçüktür işaretleri
            metin = metin.replaceAll("<", "'\u00f6");
            metin = metin.replaceAll(">", "'o");
            // yumuşak parantez(küme parantezi açma ve kapama
            metin = metin.replaceAll("\\{", "\u00fa'");
            metin = metin.replaceAll("\\}", "\u00B6\u00f5");
            ///////////////////////////////////////////////////////////////////
            ////////////////////////////////////////
            ////////////////////////////////
            Kisaltma kisaltmalar = new Kisaltma();
            if (jCheckBoxMenuItem6.getState() == true) {/*Kısaltmasız*/
            }

            if (jCheckBoxMenuItem8.getState() == true) {
                metin = kisaltmalar.Bir_Harfli_Kisaltmalar(metin);
            }
            if (jCheckBoxMenuItem1.getState() == true) {
                metin = kisaltmalar.Bir_Harfli_Kisaltmalar(metin);
                metin = kisaltmalar.Iki_Harfli_Kisaltmalar(metin);
            }

            if (jCheckBoxMenuItem2.getState() == true) {
                metin = kisaltmalar.Bir_Harfli_Kisaltmalar(metin);
                metin = kisaltmalar.Iki_Harfli_Kisaltmalar(metin);
                metin = kisaltmalar.Hece_Kisaltmalari(metin);

            }
            if (jCheckBoxMenuItem4.getState() == true) {
                metin = kisaltmalar.Bir_Harfli_Kisaltmalar(metin);
                metin = kisaltmalar.Iki_Harfli_Kisaltmalar(metin);
                metin = kisaltmalar.Kelime_Koku_Kisaltmalari(metin);
                metin = kisaltmalar.Hece_Kisaltmalari(metin);

            }
            if (jCheckBoxMenuItem5.getState() == true) {
                metin = kisaltmalar.Bir_Harfli_Kisaltmalar(metin);
                metin = kisaltmalar.Iki_Harfli_Kisaltmalar(metin);
                metin = kisaltmalar.Kelime_Koku_Kisaltmalari(metin);
                metin = kisaltmalar.Kelime_Parcasi_Kisaltmalari(metin);
                metin = kisaltmalar.Hece_Kisaltmalari(metin);

            }

            /////////////////////////////////7
            ///////////////////
            ////////////
            /////
            //
            //İki harfli kısaltmaların hece kısaltmaları ile karışmaması için
            //(bedene bde***de gibi) u017C karakteri geçici olarak kullanılmıştı
            //bu satırda o karakter kaldırılıyor.
            metin = metin.replaceAll("\u017C", "");
            //Büyük harf işareti eklenmiş tek harfli kısaltmaların
            //büyük harf işeretini karakter olarak almamısı için büyük harf işareti ile
            //kelimenin arasına đ(\u0111) karakteri eklemiştik onu kaldırıyoruz.
            metin = metin.replaceAll("\u0111", "");

            font = new Font("Kabartma", Font.PLAIN, 28);
            jTextPane1.setFont(font);

            StyledDocument stydokuman = new DefaultStyledDocument();
            SimpleAttributeSet normal = new SimpleAttributeSet();
            normal.addAttribute(StyleConstants.CharacterConstants.Italic, Boolean.FALSE);

            String boslukmu;
            try {
                stydokuman.insertString(0, metin, normal);
                int karaktersay = 0;
                int g1 = 0;
                for (int i = 0; i < stydokuman.getLength(); i++) {

                    try {
                        boslukmu = stydokuman.getText(i, 1);
                        if ("\n".equals(boslukmu)) {
                            karaktersay = 0;
                        }
                        // Stilkdokuman'ı karakter karakter işleme yeri
                        // JOptionPane.showMessageDialog(null, stilkdokuman.getText(i, 1).toString());
                        if (karaktersay == 50) {
                            boslukmu = stydokuman.getText(i, 1);
                            while (!" ".equals(boslukmu)) {
                                i = i - 1;
                                karaktersay = karaktersay - 1;
                                boslukmu = stydokuman.getText(i, 1);
                                g1 = 1;
                                if (karaktersay == 0) {
                                    g1 = 0;
                                    break;
                                }
                            }
                            if (g1 == 1) {
                                g1 = 0;
                            }
                            //JOptionPane.showMessageDialog(null, i);
                            //italic karakteri kaldırılıyor.
                            stydokuman.insertString(i, "\n", null);
                            karaktersay = -1;
                        }
                    } catch (BadLocationException ex) {
                        Logger.getLogger(AnaSayfa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    karaktersay++;
                }
                jTextPane1.setDocument(stydokuman);
            } catch (BadLocationException ex) {
                Logger.getLogger(AnaSayfa.class.getName()).log(Level.SEVERE, null, ex);
            }
            a = 1;
            jButton1.setText("Gören Yazıya Çevir");
            jMenuItem7.setText("Gören Yazıya Çevir");
            jMenuItem10.setEnabled(false);
        } else {
            Font font = new Font("Times New Roman", Font.PLAIN, 28);
            for (int i = 0; i < stilkdokuman.getLength(); i++) {
                try {
                    // Stilkdokuman'ı karakter karakter işleme yeri
                    // JOptionPane.showMessageDialog(null, stilkdokuman.getText(i, 1).toString());
                    if (stilkdokuman.getText(i, 1).equals("ž")) {
                        //JOptionPane.showMessageDialog(null, "buldu");
                        //italic karakteri kaldırılıyor.
                        stilkdokuman.remove(i, 1);
                    }
                } catch (BadLocationException ex) {
                    Logger.getLogger(AnaSayfa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            jTextPane1.setFont(font);
            jTextPane1.setDocument(stilkdokuman);
            a = 0;
            jButton1.setText("Kabartmaya çevir");
            jMenuItem7.setText("Kabartmaya çevir");
            jMenuItem10.setEnabled(true);

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        new Yardım().setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here: burası
        Dosya_Konum_Penceresi dk = new Dosya_Konum_Penceresi();
        try {
            dk.dosya_konum();
        } catch (Exception ex) {
            Logger.getLogger(AnaSayfa.class.getName()).log(Level.SEVERE, null, ex);
        }
        Font font = new Font("Times New Roman", Font.ROMAN_BASELINE, 28);
        jTextPane1.setFont(font);
        jTextPane1.setDocument(dk.stydoc);


    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void label1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label1MouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_label1MouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        // surukle_birak();
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jTextPane1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextPane1CaretUpdate
        // TODO add your handling code here:
        //imleç satır değiştirdiğinde satırı labela aktarıyor

        int pos = jTextPane1.getCaretPosition();
        Element map = jTextPane1.getDocument().getDefaultRootElement();
        int row = map.getElementIndex(pos);
        String[] lines = jTextPane1.getText().split("\r?\n|\r", -1);
        label1.setText(lines[row]);
    }//GEN-LAST:event_jTextPane1CaretUpdate

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        int start = jTextPane1.getSelectionStart();
        int end = jTextPane1.getSelectionEnd();

        if (start == end) {
            JOptionPane.showMessageDialog(null, "Seçim yapılması gerekir");
            return;
        }
        StyledDocument doc = (StyledDocument) jTextPane1.getDocument();

        Element element = doc.getCharacterElement(start);
        AttributeSet as = element.getAttributes();
        //apply a new style based on previous 
        MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
        StyleConstants.setForeground(asNew, Color.BLACK);
        StyleConstants.setFontSize(asNew, 28);
        StyleConstants.setFontFamily(asNew, "Times New Roman");

        if (StyleConstants.isItalic(asNew)) {
            StyleConstants.setItalic(asNew, Boolean.FALSE);
        } else {
            StyleConstants.setForeground(asNew, Color.DARK_GRAY);
            StyleConstants.setItalic(asNew, Boolean.TRUE);
        }

        StyleConstants.setFontSize(asNew, 28);
        doc.setCharacterAttributes(start, jTextPane1.getSelectedText().length(), asNew, true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        jButton1ActionPerformed(evt);

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        seri1.yaziciya_gonder(gelen1);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        String durum = seri1.baglan();
        if (durum == "1") {
            // durumlabel.setText("----Bağlantı sağlandı---");
            JOptionPane.showMessageDialog(null, "--Bağlantı sağlandı.--");
        }
        if (durum == "0") {
            //durumlabel.setText("----Bağlantı Hatası---");
            JOptionPane.showMessageDialog(null, "                            --Bağlantı Hatası--             \n Sadece geliştirilmekte olan yazıcımız için bağlantı sağlar ");
        }
        if (durum == "2") {
            //durumlabel.setText("----Önceden bağlantı kurulmuş---");
            JOptionPane.showMessageDialog(null, "--Önceden bağlantı kurulmuş.--");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
           new Lisans().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed
    StyledDocument docyazdir;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AnaSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnaSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnaSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnaSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new AnaSayfa().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem4;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem5;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem6;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextPane jTextPane1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}

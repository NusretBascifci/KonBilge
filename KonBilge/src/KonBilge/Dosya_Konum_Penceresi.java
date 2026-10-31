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

import java.awt.Color;
import java.awt.Font;
import java.io.FileInputStream;
import java.util.Scanner;
import javax.swing.JFileChooser;

import java.util.Scanner;
import java.io.*;
import javax.print.Doc;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleConstants;
import static javax.swing.text.StyleConstants.Bold;
import static javax.swing.text.StyleConstants.Italic;
import javax.swing.text.StyledEditorKit;
//import static junit.framework.Assert.assertTrue;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import javax.swing.text.StyleConstants.*;
import static javax.swing.text.StyleConstants.Italic;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;

import org.apache.poi.xwpf.usermodel.UnderlinePatterns;


public class Dosya_Konum_Penceresi {

    JFileChooser dosyasec = new JFileChooser();
    StringBuilder sb = new StringBuilder();

    java.io.File dosya;
    String DosyaAdı;
    boolean deger = false;
    StyledDocument stydoc = new DefaultStyledDocument();
    SimpleAttributeSet italic = new SimpleAttributeSet();
    SimpleAttributeSet normal = new SimpleAttributeSet();

    public void dosya_konum() throws Exception {

        if (dosyasec.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            dosya = dosyasec.getSelectedFile();

            if (dosya.getName().substring(dosya.getName().length() - 1).equals("x")) {
                try {
                    deger = true;
                    XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(dosya));
                    italic.addAttribute(StyleConstants.CharacterConstants.Italic, Boolean.TRUE);
                    normal.addAttribute(StyleConstants.CharacterConstants.Italic, Boolean.FALSE);
                    for (XWPFParagraph paragraphs : xdoc.getParagraphs()) {
                        /* stydoc.insertString(stydoc.getLength(),"\n" , normal);*/
                        //paragraphs.insertNewRun(paragraphs.getIndentationRight());

                        for (XWPFRun run : paragraphs.getRuns()) {
                            boolean isUnderline = run.getUnderline() != UnderlinePatterns.NONE;
                            if (isUnderline || run.isBold() || run.isItalic()) {
                                stydoc.insertString(stydoc.getLength(), run.text(), italic);
                            } else {

                                stydoc.insertString(stydoc.getLength(), run.text(), normal);
                            }
                        }

                        stydoc.insertString(stydoc.getLength(), "\n", normal);
                        //  XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
                        // sb.append(extractor.getText());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if (dosya.getName().substring(dosya.getName().length() - 1).equals("c")) {
                    try {
                        deger = true;
                        FileInputStream fis;
                        fis = new FileInputStream(new File(dosya.getPath()));
                        HWPFDocument doc = new HWPFDocument(fis);
                        WordExtractor we = new WordExtractor(doc);
  
                        italic.addAttribute(StyleConstants.CharacterConstants.Italic, Boolean.TRUE);
                        normal.addAttribute(StyleConstants.CharacterConstants.Italic, Boolean.FALSE);
                        Range range = doc.getRange();
                        for (int k = 0; k < range.numParagraphs(); k++) {
                            Paragraph paragraph = range.getParagraph(k);
                            for (int j = 0; j < paragraph.numCharacterRuns(); j++) {

                                CharacterRun cr = paragraph.getCharacterRun(j);
                                if (cr.text().equals("\r")) {
                                    stydoc.insertString(stydoc.getLength(), "\n", normal);

                                } else {
                                    if (cr.isBold() || cr.isItalic() || (cr.getUnderlineCode() != 0)) {

                                        stydoc.insertString(stydoc.getLength(), cr.text(), italic);
                                    } else {

                                        stydoc.insertString(stydoc.getLength(), cr.text(), normal);

                                    }
                                }
                            }

                        }
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();

                    }
                }

                //buraya pdf okuma da eklenebilir
            }
        }
        if (deger == false) {
            JOptionPane.showMessageDialog(null, "Desteklenmeyen dosya biçimi  \nSadece .doc ve .docx dosyarı");
        }
    }

    public void dosya_konum2() throws Exception {

        if (dosya.getName().substring(dosya.getName().length() - 1).equals("x")) {
            try {
                deger = true;
                XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(dosya));
                italic.addAttribute(StyleConstants.CharacterConstants.Italic, Boolean.TRUE);
                normal.addAttribute(StyleConstants.CharacterConstants.Italic, Boolean.FALSE);
                for (XWPFParagraph paragraphs : xdoc.getParagraphs()) {
                    /* stydoc.insertString(stydoc.getLength(),"\n" , normal);*/
                    //paragraphs.insertNewRun(paragraphs.getIndentationRight());
                    for (XWPFRun run : paragraphs.getRuns()) {
                        boolean isUnderline = run.getUnderline() != UnderlinePatterns.NONE;
                        if (isUnderline || run.isBold() || run.isItalic()) {
                            stydoc.insertString(stydoc.getLength(), run.text(), italic);
                        } else {
                            stydoc.insertString(stydoc.getLength(), run.text(), normal);
                        }
                    }
                    stydoc.insertString(stydoc.getLength(), "\n", normal);
                    //  XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
                    // sb.append(extractor.getText());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (dosya.getName().substring(dosya.getName().length() - 1).equals("c")) {
            try {
                deger = true;
                FileInputStream fis;
                fis = new FileInputStream(new File(dosya.getPath()));
                HWPFDocument doc = new HWPFDocument(fis);
                WordExtractor we = new WordExtractor(doc);

                italic.addAttribute(StyleConstants.CharacterConstants.Italic, Boolean.TRUE);
                italic.addAttribute(StyleConstants.CharacterConstants.Foreground, Color.darkGray);
                normal.addAttribute(StyleConstants.CharacterConstants.Italic, Boolean.FALSE);
                Range range = doc.getRange();
                for (int k = 0; k < range.numParagraphs(); k++) {
                    Paragraph paragraph = range.getParagraph(k);
                    for (int j = 0; j < paragraph.numCharacterRuns(); j++) {
                        CharacterRun cr = paragraph.getCharacterRun(j);
                        if (cr.text().equals("\r?") || cr.text().equals("\r")) {
                            stydoc.insertString(stydoc.getLength(), "\n", normal);
                        } else {
                            if (cr.isBold() || cr.isItalic() || (cr.getUnderlineCode() != 0)) {
                                stydoc.insertString(stydoc.getLength(), cr.text(), italic);
                            } else {
                                stydoc.insertString(stydoc.getLength(), cr.text(), normal);
                            }
                        }
                    }
                }
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Desteklenmeyen dosya Biçimi");
            }
        }
        if (deger == false) {
            JOptionPane.showMessageDialog(null, "Desteklenmeyen dosya biçimi  \nSadece .doc ve .docx dosyarı");
        }
    }
    //buraya pdf okuma da eklenebilir
}

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
 * @author abc
 */
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ikiliksistem {

    private String gelen_cumle;

    public ikiliksistem(String cumle) {
        gelen_cumle = cumle;
        JOptionPane.showMessageDialog(null, gelen_cumle);
    }

    public String cevirici() {

        String cizgi1 = "";
        String cizgi2 = "";
        String cizgi3 = "";
        String toplam = "";

        //  int karakter_sayisi;
        // karakter_sayisi=gelen_cumle.length();
        String[] satirlar = gelen_cumle.split("\n");
        for (int i = 0; satirlar.length > i; i++) {
            cizgi1 = satirlar[i];
            cizgi2 = satirlar[i];
            cizgi3 = satirlar[i];

            //a harfi için
            cizgi1 = cizgi1.replace("a", "10");
            cizgi2 = cizgi2.replace("a", "00");
            cizgi3 = cizgi3.replace("a", "00");

            //b harfi için
            cizgi1 = cizgi1.replace("b", "10");
            cizgi2 = cizgi2.replace("b", "10");
            cizgi3 = cizgi3.replace("b", "00");

            //c harfi için
            cizgi1 = cizgi1.replace("c", "11");
            cizgi2 = cizgi2.replace("c", "00");
            cizgi3 = cizgi3.replace("c", "00");

            //d harfi için
            cizgi1 = cizgi1.replace("d", "11");
            cizgi2 = cizgi2.replace("d", "11");
            cizgi3 = cizgi3.replace("d", "11");

            //' ' boşluk harfi için
            cizgi1 = cizgi1.replace(" ", "00");
            cizgi2 = cizgi2.replace(" ", "00");
            cizgi3 = cizgi3.replace(" ", "00");

            // #bil# in kısaltması § harfi için
            cizgi1 = cizgi1.replace("§", "00");
            cizgi2 = cizgi2.replace("§", "01");
            cizgi3 = cizgi3.replace("§", "00");

            // #tab tuşu# in kısaltması tab boşluğu için
            cizgi1 = cizgi1.replace("\t", "000000");
            cizgi2 = cizgi2.replace("\t", "000000");
            cizgi3 = cizgi3.replace("\t", "000000");
            toplam = toplam + cizgi1 + "\n" + cizgi2 + "\n" + cizgi3 + "\n";
        }

        return toplam;
    }
}

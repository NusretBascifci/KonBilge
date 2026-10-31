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
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import com.fazecast.jSerialComm.SerialPort;

/**
 *
 * @author abc
 */
public class seri_port {

    private SerialPort comPort;
    private String comPortName = "COM4";
    private int boudRate = 9600;
    static PrintWriter outPut;

    public seri_port() {
        comPort = SerialPort.getCommPort(comPortName);
        comPort.setBaudRate(boudRate);
    }

    public String baglan() {

        if (comPort.isOpen() == false) {

            try {
                comPort.openPort();
                Thread.sleep(1000);
                outPut = new PrintWriter(comPort.getOutputStream());
                return "1";
            } catch (Exception c) {
                return "0";//try gerekli olduğu için
            }
        } else {
            return "2";
        }
    }//baglantı sonu

    public void yak(String gelen) {
        try {
            if (comPort.isOpen() == true) {
                if (gelen == "yak") {
                    outPut.print("yak");
                    outPut.flush();
                } else {
                    outPut.print("kapat");
                    outPut.flush();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Bağlantıyı kontrol edin", "Uyarı", 1);
            }
        } catch (Exception c) {
            JOptionPane.showMessageDialog(null, "Bağlantıyı kontrol edin", "Uyarı", 1);//try gerekli olduğu için
        }

    }

    public void yaziciya_gonder(String gelen) {
        try {
            if (comPort.isOpen() == true) {

                outPut.print(gelen);
                outPut.flush();

            } else {
                JOptionPane.showMessageDialog(null, "Bağlantıyı kontrol edin", "Uyarı", 1);
            }
        } catch (Exception c) {
            JOptionPane.showMessageDialog(null, "Bağlantıyı kontrol edin", "Uyarı", 1);//try gerekli olduğu için
        }

    }

}

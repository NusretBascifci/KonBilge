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
public class Kisaltma {

    String metin;

    public String Bir_Harfli_Kisaltmalar(String gelen) {
        /* BİR (tek) HARFLİ KISALTMALARIN BAŞLANGICI*/
        ////////////////////////////////////////////////
        //a harfli kısaltma ž
        metin = gelen;
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(aynı)([,|.|\u201D|\u017E|!|?|:|;|)])", "$1a$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(aynı)([\\S])", "$1a'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u017E|\u0111)(aynı)", "$1a");

        //b harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(büyük)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1b$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(büyük)([\\S])", "$1b'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(büyük)", "$1b");

        //c harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(can)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1c$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(can)([\\S])", "$1c'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(can)", "$1c");

        //ç harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(çok)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1ç$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(çok)([\\S])", "$1ç'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(çok)", "$1ç");

        //d harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(daha)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1d$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(daha)([\\S])", "$1d'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(daha)", "$1d");

        //e harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(ekonomi)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1e$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(ekonomi)([\\S])", "$1e'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(ekonomi)", "$1e");

        //f harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(fakat)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1f$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(fakat)([\\S])", "$1f'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(fakat)", "$1f");

        //g harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(göre)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1g$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(göre)([\\S])", "$1g'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(göre)", "$1g");

        //ğ harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(eğer)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1ğ$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(eğer)([\\S])", "$1ğ'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(eğer)", "$1ğ");

        //h harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(her)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1h$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(her)([\\S])", "$1h'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(her)", "$1h");

        //ı harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(kısa)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1ı$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(kısa)([\\S])", "$1ı'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(kısa)", "$1ı");

        //i harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(için)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1i$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(için)([\\S])", "$1i'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(için)", "$1i");

        //j harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(gün)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1j$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(gün)([\\S])", "$1j'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(gün)", "$1j");

        //k harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(kadar)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1k$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(kadar)([\\S])", "$1k'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(kadar)", "$1k");

        //l harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(ilgi)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1l$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(ilgi)([\\S])", "$1l'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(ilgi)", "$1l");

        //m harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(meydan)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1m$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(meydan)([\\S])", "$1m'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(meydan)", "$1m");

        //n harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(neden)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1n$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(neden)([\\S])", "$1n'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(neden)", "$1n");

        //ö harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(öyle)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1ö$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(öyle)([\\S])", "$1ö'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(öyle)", "$1ö");

        //p harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(para)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1p$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(para)([\\S])", "$1p'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(para)", "$1p");

        //r harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(artık)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1r$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(artık)([\\S])", "$1r'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(artık)", "$1r");

        //s harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(sonra)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1s$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(sonra)([\\S])", "$1s'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(sonra)", "$1s");

        //ş harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(şey)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1ş$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(şey)([\\S])", "$1ş'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(şey)", "$1ş");

        //t harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(taraf)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1t$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(taraf)([\\S])", "$1t'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(taraf)", "$1t");

        //u harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(uygun)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1u$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(uygun)([\\S])", "$1u'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(uygun)", "$1u");

        //ü harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(dünya)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1ü$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(dünya)([\\S])", "$1ü'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(dünya)", "$1ü");

        //v harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(var)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1v$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(var)([\\S])", "$1v'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(var)", "$1v");

        //y harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(yok)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1y$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(yok)([\\S])", "$1y'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(yok)", "$1y");

        //z harfli kısaltma
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(zaman)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1z$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi en sonuna da noktalama işareti ekler.
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(zaman)([\\S])", "$1z'$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp başka eklerle bitiyorsa
        //önce önündeki katakter sonra kısaltma harfi sonra 3.nokta(kesme işareti) 
        //en sonuna da ekleri ekler
        metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(zaman)", "$1z");
        /* BİR HARFLİ KISALTMALARIN BİTİŞİ*/
        return metin;
    }

    public String Iki_Harfli_Kisaltmalar(String gelen) {
        metin = gelen;
        /* İKİ HARFLİ KISALTMALARIN BAŞLANGICI*/
        //b ile başlayan iki harfli kısaltmalar
        //
        metin = metin.replaceAll("^beden", "bd\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(beden)", "$1bd\u017C");

        metin = metin.replaceAll("^bilgi", "bl\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(bilgi)", "$1bl\u017C");

        metin = metin.replaceAll("^beraber", "br\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(beraber)", "$1br\u017C");

        metin = metin.replaceAll("^başka", "bş\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(başka)", "$1bş\u017C");

        metin = metin.replaceAll("^böyle", "by\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(böyle)", "$1by\u017C");

        metin = metin.replaceAll("^bağımsız", "bğ\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(bağımsız)", "$1bğ\u017C");

        metin = metin.replaceAll("^bundan", "bn\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(bundan)", "$1bn\u017C");

        metin = metin.replaceAll("^basit", "bs\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(basit)", "$1bs\u017C");

        metin = metin.replaceAll("^bütün", "bt\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(bütün)", "$1bt\u017C");

        metin = metin.replaceAll("^bazı", "bz\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(bazı)", "$1bz\u017C");

        //c ve ç ile başlayan iki harfli kısaltmalar
        metin = metin.replaceAll("^cumhuriyet", "cm\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(cumhuriyet)", "$1cm\u017C");

        metin = metin.replaceAll("^cisim", "cs\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(cisim)", "$1cs\u017C");

        metin = metin.replaceAll("^cevap", "cv\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(cevap)", "$1cv\u017C");

        metin = metin.replaceAll("^cevab", "cv\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(cevab)", "$1cv\u017C");

        metin = metin.replaceAll("^çocuk", "çc\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(çocuk)", "$1çc\u017C");

        metin = metin.replaceAll("^çocuğ", "çc\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(çocuğ)", "$1çc\u017C");

        metin = metin.replaceAll("^çoğu", "çğ\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(çoğu)", "$1çğ\u017C");

        metin = metin.replaceAll("^çalışkan", "çl\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(çalışkan)", "$1çl\u017C");

        metin = metin.replaceAll("^çünkü", "çn\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(çünkü)", "$1çn\u017C");

        metin = metin.replaceAll("^çeşit", "çş\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(çeşit)", "$1çş\u017C");

        metin = metin.replaceAll("^çeşid", "çş\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(çeşid)", "$1çş\u017C");

        metin = metin.replaceAll("^çevre", "çv\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(çevre)", "$1çv\u017C");

        //d ile başlayan iki harfli kısaltmalar
        metin = metin.replaceAll("^değil", "dğ\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(değil)", "$1dğ\u017C");

        metin = metin.replaceAll("^dolayı", "dl\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(dolayı)", "$1dl\u017C");

        metin = metin.replaceAll("^demek", "dm\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(demek)", "$1dm\u017C");

        metin = metin.replaceAll("^deney", "dn\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(deney)", "$1dn\u017C");

        metin = metin.replaceAll("^devlet", "dv\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(devlet)", "$1dv\u017C");
        //m ve n ile başlayan iki harfli kısaltmalar
        metin = metin.replaceAll("^madde", "md\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(madde)", "$1md\u017C");

        metin = metin.replaceAll("^millet", "ml\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(millet)", "$1ml\u017C");

        metin = metin.replaceAll("^memleket", "mm\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(memleket)", "$1mm\u017C");

        metin = metin.replaceAll("^ancak", "nc\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(ancak)", "$1nc\u017C");

        metin = metin.replaceAll("^niçin", "nç\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(niçin)", "$1nç\u017C");

        metin = metin.replaceAll("^anadolu", "nd\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(anadolu)", "$1nd\u017C");

        metin = metin.replaceAll("^nehir", "nh\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(nehir)", "$1nh\u017C");

        metin = metin.replaceAll("^anne", "nn\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(anne)", "$1nn\u017C");

        metin = metin.replaceAll("^insan", "ns\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(insan)", "$1ns\u017C");

        //r,s ve ş ile başlayan iki harfli kısaltmalar
        metin = metin.replaceAll("^arka", "rk\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(arka)", "$1rk\u017C");

        metin = metin.replaceAll("^örneğin", "rn\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(örneğin)", "$1rn\u017C");

        metin = metin.replaceAll("^arası", "rs\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(arası)", "$1rs\u017C");

        metin = metin.replaceAll("^orta", "rt\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(orta)", "$1rt\u017C");

        metin = metin.replaceAll("^sebep", "sb\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(sebep)", "$1sb\u017C");

        metin = metin.replaceAll("^sebeb", "sb\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(sebeb)", "$1sb\u017C");

        metin = metin.replaceAll("^sıcak", "sc\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(sıcak)", "$1sc\u017C");

        metin = metin.replaceAll("^sıcağ", "sc\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(sıcağ)", "$1sc\u017C");

        metin = metin.replaceAll("^soğuk", "sğ\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(soğuk)", "$1sğ\u017C");

        metin = metin.replaceAll("^soğuğ", "sğ\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(soğuğ)", "$1sğ\u017C");

        metin = metin.replaceAll("^eski", "sk\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(eski)", "$1sk\u017C");

        metin = metin.replaceAll("^osmanlı", "sm\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(osmanlı)", "$1sm\u017C");

        metin = metin.replaceAll("^soru", "sr\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(soru)", "$1sr\u017C");

        metin = metin.replaceAll("^savaş", "sv\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(savaş)", "$1sv\u017C");

        metin = metin.replaceAll("^aşağı", "şğ\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(aşağı)", "$1şğ\u017C");

        metin = metin.replaceAll("^şehir", "şh\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(şehir)", "$1şh\u017C");

        metin = metin.replaceAll("^şekil", "şk\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(şekil)", "$1şk\u017C");

        metin = metin.replaceAll("^şimdi", "şm\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(şimdi)", "$1şm\u017C");

        metin = metin.replaceAll("^işte", "şt\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(işte)", "$1şt\u017C");

        metin = metin.replaceAll("^şöyle", "şy\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(şöyle)", "$1şy\u017C");

        metin = metin.replaceAll("^fazla", "fz\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(fazla)", "$1fz\u017C");

        metin = metin.replaceAll("^gibi", "gb\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(gibi)", "$1gb\u017C");

        metin = metin.replaceAll("^gece", "gc\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(gece)", "$1gc\u017C");

        metin = metin.replaceAll("^genel", "gn\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(gn)", "$1gn\u017C");

        metin = metin.replaceAll("^güzel", "gz\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(güzel)", "$1gz\u017C");

        metin = metin.replaceAll("^haber", "hb\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(haber)", "$1hb\u017C");

        metin = metin.replaceAll("^hiç", "hç\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(hiç)", "$1hç\u017C");

        metin = metin.replaceAll("^halk", "hl\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(halk)", "$1hl\u017C");

        metin = metin.replaceAll("^hemen", "hm\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(hemen)", "$1hm\u017C");

        metin = metin.replaceAll("^hangi", "hn\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(hangi)", "$1hn\u017C");

        metin = metin.replaceAll("^hepsi", "hp\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(hepsi)", "$1hp\u017C");

        metin = metin.replaceAll("^hayat", "hy\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(hayat)", "$1hy\u017C");

        metin = metin.replaceAll("^hazır", "hz\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(hazır)", "$1hz\u017C");

        metin = metin.replaceAll("^kabul", "kb\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(kabul)", "$1kb\u017C");

        metin = metin.replaceAll("^küçük", "kç\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(küçük)", "$1kç\u017C");

        metin = metin.replaceAll("^küçüğ", "kç\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(küçüğ)", "$1kç\u017C");

        metin = metin.replaceAll("^kadın", "kd\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(kadın)", "$1kd\u017C");

        metin = metin.replaceAll("^kahraman", "kh\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(kahraman)", "$1kh\u017C");

        metin = metin.replaceAll("^kolay", "kl\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(kolay)", "$1kl\u017C");

        metin = metin.replaceAll("^kendi", "kn\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(kendi)", "$1kn\u017C");

        metin = metin.replaceAll("^kısım", "ks\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(kısım)", "$1ks\u017C");

        metin = metin.replaceAll("^kitap", "kt\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(kitap)", "$1kt\u017C");

        metin = metin.replaceAll("^kitab", "kt\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(kitab)", "$1kt\u017C");

        metin = metin.replaceAll("^kuvvet", "kv\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(kuvvet)", "$1kv\u017C");

        metin = metin.replaceAll("^kuzey", "kz\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(kuzey)", "$1kz\u017C");

        metin = metin.replaceAll("^lazım", "lz\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(lazım)", "$1lz\u017C");

        metin = metin.replaceAll("^tabiat", "tb\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(tabiat)", "$1tb\u017C");

        metin = metin.replaceAll("^toprak", "tp\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(toprak)", "$1tp\u017C");

        metin = metin.replaceAll("^toprağ", "tp\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(toprağ)", "$1tp\u017C");

        metin = metin.replaceAll("^vatan", "vt\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(vatan)", "$1vt\u017C");

        metin = metin.replaceAll("^aydın", "yd\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(aydın)", "$1yd\u017C");

        metin = metin.replaceAll("^yukarı", "yk\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(yukarı)", "$1yk\u017C");

        metin = metin.replaceAll("^yalnız", "yl\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(yalnız)", "$1yl\u017C");

        metin = metin.replaceAll("^yeni", "yn\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(yeni)", "$1yn\u017C");

        metin = metin.replaceAll("^yarar", "yr\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(yarar)", "$1yr\u017C");

        metin = metin.replaceAll("^yavaş", "yv\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(yavaş)", "$1yv\u017C");

        metin = metin.replaceAll("^yüzyıl", "yz\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(yüzyıl)", "$1yz\u017C");

        metin = metin.replaceAll("^özel", "zl\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(özel)", "$1zl\u017C");

        metin = metin.replaceAll("^uzun", "zn\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(uzun)", "$1zn\u017C");

        metin = metin.replaceAll("^üzere", "zr\u017C");
        metin = metin.replaceAll("([^a-zışçüöğ])(üzere)", "$1zr\u017C");

        /* İKİ HARFLİ KISALTMALARIN BİTİŞİ*/
        return metin;
    }

    public String Kelime_Koku_Kisaltmalari(String gelen) {
        metin = gelen;
        /* KELİME KÖKÜ 5.NOKTALI  KISALTMALARIN BAŞLANGICI*/
        metin = metin.replaceAll("(^|\\s|\u0111)(bil)([\\S])", "$1\u0160b\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(bil)", "$1\u0160b\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(incele)([\\S])", "$1\u0160c\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(incele)", "$1\u0160c\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(çalış)([\\S])", "$1\u0160ç\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(çalış)", "$1\u0160ç\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(dur)([\\S])", "$1\u0160d\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(dur)", "$1\u0160d\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(eğit)([\\S])", "$1\u0160e\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(eğit)", "$1\u0160e\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(faydalan)([\\S])", "$1\u0160f\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(faydalan)", "$1\u0160f\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(gel)([\\S])", "$1\u0160g\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(gel)", "$1\u0160g\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(öğren)([\\S])", "$1\u0160ğ\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(öğren)", "$1\u0160ğ\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(harca)([\\S])", "$1\u0160h\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(harca)", "$1\u0160h\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(kır)([\\S])", "$1\u0160ı\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(kır)", "$1\u0160ı\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(iste)([\\S])", "$1\u0160i\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(iste)", "$1\u0160i\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(kullan)([\\S])", "$1\u0160k\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(kullan)", "$1\u0160k\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(alış)([\\S])", "$1\u0160l\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(alış)", "$1\u0160l\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(tamamla)([\\S])", "$1\u0160m\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(tamamla)", "$1\u0160m\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(anla)([\\S])", "$1\u0160n\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(anla)", "$1\u0160n\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(sor)([\\S])", "$1\u0160o\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(sor)", "$1\u0160o\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(gör)([\\S])", "$1\u0160ö\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(gör)", "$1\u0160ö\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(topla)([\\S])", "$1\u0160p\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(topla)", "$1\u0160p\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(bırak)([\\S])", "$1\u0160r\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(bırak)", "$1\u0160r\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(söyle)([\\S])", "$1\u0160s\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(söyle)", "$1\u0160s\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(başla)([\\S])", "$1\u0160ş\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(başla)", "$1\u0160ş\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(tut)([\\S])", "$1\u0160t\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(tut)", "$1\u0160t\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(uğra)([\\S])", "$1\u0160u\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(uğra)", "$1\u0160u\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(yürü)([\\S])", "$1\u0160ü\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(yürü)", "$1\u0160ü\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(vur)([\\S])", "$1\u0160v\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(vur)", "$1\u0160v\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(yetiş)([\\S])", "$1\u0160y\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(yetiş)", "$1\u0160y");
        metin = metin.replaceAll("(^|\\s|\u0111)(gözle)([\\S])", "$1\u0160z\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(gözle)", "$1\u0160z");
        //
        metin = metin.replaceAll("(^|\\s|\u0111)(bekle)([\\S])", "$1\u0160\u00E4\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(bekle)", "$1\u0160\u00E4");
        metin = metin.replaceAll("(^|\\s|\u0111)(bulun)([\\S])", "$1\u0160\u00E3\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(bulun)", "$1\u0160\u00E3");
        metin = metin.replaceAll("(^|\\s|\u0111)(koş)([\\S])", "$1\u0160\u00E9\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(koş)", "$1\u0160\u00E9");
        metin = metin.replaceAll("(^|\\s|\u0111)(yüksel)([\\S])", "$1\u0160\u00EA\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(yüksel)", "$1\u0160\u00EA");
        metin = metin.replaceAll("(^|\\s|\u0111)(geç)([\\S])", "$1\u0160\u00EB\u0111\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(geç)", "$1\u0160\u00EB\u0111");
        metin = metin.replaceAll("(^|\\s|\u0111)(düşün)([\\S])", "$1\u0160\u00FB\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(düşün)", "$1\u0160\u00FB");
        metin = metin.replaceAll("(^|\\s|\u0111)(kalk)([\\S])", "$1\u0160\u00E5\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(kalk)", "$1\u0160\u00E5");
        metin = metin.replaceAll("(^|\\s|\u0111)(koy)([\\S])", "$1\u0160\u00E8\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(koy)", "$1\u0160\u00E8");
        metin = metin.replaceAll("(^|\\s|\u0111)(konuş)([\\S])", "$1\u0160\u00EC\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(konuş)", "$1\u0160\u00EC");
        metin = metin.replaceAll("(^|\\s|\u0111)(öğret)([\\S])", "$1\u0160\u00F2\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(öğret)", "$1\u0160\u00F2");
        metin = metin.replaceAll("(^|\\s|\u0111)(oyna)([\\S])", "$1\u0160\u00ED\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(oyna)", "$1\u0160\u00ED");
        metin = metin.replaceAll("(^|\\s|\u0111)(oku)([\\S])", "$1\u0160\u00F3\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(oku)", "$1\u0160\u00F3");
        metin = metin.replaceAll("(^|\\s|\u0111)(göster)([\\S])", "$1\u0160\u00EE\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(göster)", "$1\u0160\u00EE");
        metin = metin.replaceAll("(^|\\s|\u0111)(yerleş)([\\S])", "$1\u0160\u00F4\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(yerleş)", "$1\u0160\u00F4");
        metin = metin.replaceAll("(^|\\s|\u0111)(yara)([\\S])", "$1\u0160\u00EF\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(yara)", "$1\u0160\u00EF");
        metin = metin.replaceAll("(^|\\s|\u0111)(getir)([\\S])", "$1\u0160\u00F5\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(getir)", "$1\u0160\u00F5");
        metin = metin.replaceAll("(^|\\s|\u0111)(götür)([\\S])", "$1\u0160\u00F0\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(götür)", "$1\u0160\u00F0");
        metin = metin.replaceAll("(^|\\s|\u0111)(yaşa)([\\S])", "$1\u0160\u00F1\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(yaşa)", "$1\u0160\u00F1");
        metin = metin.replaceAll("(^|\\s|\u0111)(büyü)([\\S])", "$1\u0160\u00FA\u0111$3");
        metin = metin.replaceAll("(^|\\s|\u0111)(büyü)", "$1\u0160\u00FA");

        /* KELİME KÖKÜ 5.NOKTALI  KISALTMALARIN BİTİŞİ*/
        return metin;
    }

    public String Kelime_Parcasi_Kisaltmalari(String gelen) {
        metin = gelen;
        /* KELİME PARÇASI  KISALTMALARI BAŞLANGICI*/
        
        ///keime parçası 4. kural işletiliyor başlangıç
        metin = metin.replaceAll("([ \u0111])([bcçdfgğhjklmnprsştvyzż'])(ınca)", "$1\u0111$2ı\u0111n\u0111c\u0111a\u0111");
        metin = metin.replaceAll("(^)([bcçdfgğhjklmnprsştvyzż'])(ınca)", "$1\u0111$2ı\u0111n\u0111c\u0111a\u0111");
      
        metin = metin.replaceAll("([ \u0111])([bcçdfgğhjklmnprsştvyzż'])(ince)", "$1\u0111$2i\u0111n\u0111c\u0111e\u0111");
        metin = metin.replaceAll("(^)([bcçdfgğhjklmnprsştvyzż'])(ince)", "$1\u0111$2i\u0111n\u0111c\u0111e\u0111");
      
        metin = metin.replaceAll("([ \u0111])([bcçdfgğhjklmnprsştvyzż'])(unca)", "$1\u0111$2u\u0111n\u0111c\u0111a\u0111");
        metin = metin.replaceAll("(^)([bcçdfgğhjklmnprsştvyzż'])(unca)", "$1\u0111$2u\u0111n\u0111c\u0111a\u0111");
        
        metin = metin.replaceAll("([ \u0111])([bcçdfgğhjklmnprsştvyzż'])(ünce)", "$1\u0111$2ü\u0111n\u0111c\u0111e\u0111");
        metin = metin.replaceAll("(^)([bcçdfgğhjklmnprsştvyzż'])(ünce)", "$1\u0111$2ü\u0111n\u0111c\u0111e\u0111");
        ///keime parçası 4. kural işletiliyor bitiş
        
        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(ınca|ince|unca|ünce)", "$1\u0161c\u0111");
        
        //\u0161'ın eşiti 4. ve 5. noktalardır
        //eklerin önünde ż(geçici harf Büyük harf işaretini engellemek için)
        //ve boşluk haricinde harhangi bir harf varsa kısaltır
        
        ///keime parçası 4. kural işletiliyor başlangıç
        metin = metin.replaceAll("([ \u0111])([bcçdfgğhjklmnprsştvyzż'])(ıncı)", "$1\u0111$2ı\u0111n\u0111c\u0111ı\u0111");
        metin = metin.replaceAll("(^)([bcçdfgğhjklmnprsştvyzż'])(ıncı)", "$1\u0111$2ı\u0111n\u0111c\u0111ı\u0111");
      
        metin = metin.replaceAll("([ \u0111])([bcçdfgğhjklmnprsştvyzż'])(inci)", "$1\u0111$2i\u0111n\u0111c\u0111i\u0111");
        metin = metin.replaceAll("(^)([bcçdfgğhjklmnprsştvyzż'])(inci)", "$1\u0111$2i\u0111n\u0111c\u0111i\u0111");
      
        metin = metin.replaceAll("([ \u0111])([bcçdfgğhjklmnprsştvyzż'])(uncu)", "$1\u0111$2u\u0111n\u0111c\u0111u\u0111");
        metin = metin.replaceAll("(^)([bcçdfgğhjklmnprsştvyzż'])(uncu)", "$1\u0111$2u\u0111n\u0111c\u0111u\u0111");
      
        metin = metin.replaceAll("([ \u0111])([bcçdfgğhjklmnprsştvyzż'])(üncü)", "$1\u0111$2ü\u0111n\u0111c\u0111ü\u0111");
        metin = metin.replaceAll("(^)([bcçdfgğhjklmnprsştvyzż'])(üncü)", "$1\u0111$2ü\u0111n\u0111c\u0111ü\u0111");
       ///keime parçası 4. kural işletiliyor bitiş
        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(ıncı|inci|uncu|üncü)", "$1\u0178c\u0111");

        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(tıkça|tikçe|tukça|tükçe)", "$1\u0161ç\u0111");
        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(dıkça|dikçe|dukça|dükçe)", "$1\u0178ç\u0111");

        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(tıkları|tikleri|tukları|tükleri)", "$1\u0161d\u0111");
        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(dıkları|dikleri|dukları|dükleri)", "$1\u0178d\u0111");

        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(lara|lere)", "$1\u0161e\u0111");
        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(ları|leri)", "$1\u0178e\u0111");

        metin = metin.replaceAll("([aeıioöuü\u0111])(gan|gen)", "$1\u0161g\u0111");
        metin = metin.replaceAll("([a-zışçüöğż'\u0111])([a-zışçüöğż'\u0111])(gan|gen)", "$1$2\u0161g\u0111");
        
        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(gın|gin|gun|gün)", "$1\u0178g\u0111");

        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(mayı|meyi)", "$1\u0161ğ\u0111");
        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(mağa|meğe)", "$1\u0178ğ\u0111");

        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(tığı|tiği|tuğu|tüğü)", "$1\u0161i\u0111");
        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(dığı|diği|duğu|düğü)", "$1\u0178i\u0111");

        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(tır|tir|tur|tür)", "$1\u0161j\u0111");
        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(dır|dir|dur|dür)", "$1\u0178j\u0111");

        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(ken)", "$1\u0178k\u0111");
        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(luk|lük)", "$1\u0161l\u0111");

        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(lık|lik)", "$1\u0178l\u0111");
        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(madan|meden)", "$1\u0178m\u0111");

        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(nun|nün)", "$1\u0161n\u0111");
        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(nın|nin)", "$1\u0178n\u0111");

        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(yor)", "$1\u0178o\u0111");
        
         ///keime parçası 4. kural işletiliyor başlangıç
        metin = metin.replaceAll("([ \u0111])([bcçdfgğhjklmnprsştvyzż'])(arak)", "$1\u0111$2a\u0111r\u0111a\u0111k\u0111");
        metin = metin.replaceAll("(^)([bcçdfgğhjklmnprsştvyzż'])(arak)", "$1\u0111$2a\u0111r\u0111a\u0111k\u0111");
      
        metin = metin.replaceAll("([ \u0111])([bcçdfgğhjklmnprsştvyzż'])(erek)", "$1\u0111$2e\u0111r\u0111e\u0111k\u0111");
        metin = metin.replaceAll("(^)([bcçdfgğhjklmnprsştvyzż'])(erek)", "$1\u0111$2e\u0111r\u0111e\u0111k\u0111");
      
      
        ///keime parçası 4. kural işletiliyor bitiş
        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(arak|erek)", "$1\u0178r\u0111");

        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(ması|mesi)", "$1\u0178s\u0111");
        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(muş|müş)", "$1\u0161ş\u0111");

        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(mış|miş)", "$1\u0178ş\u0111");
        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(tıktan|tikten|tuktan|tükten)", "$1\u0161t\u0111");

        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(dıktan|dikten|duktan|dükten)", "$1\u0178t\u0111");
        
        
         ///keime parçası 4. kural işletiliyor başlangıç
        metin = metin.replaceAll("([ \u0111])([bcçdfgğhjklmnprsştvyzż'])(ıyla)", "$1\u0111$2ı\u0111y\u0111l\u0111a\u0111");
        metin = metin.replaceAll("(^)([bcçdfgğhjklmnprsştvyzż'])(ıyla)", "$1\u0111$2ı\u0111y\u0111l\u0111a\u0111");
      
        metin = metin.replaceAll("([ \u0111])([bcçdfgğhjklmnprsştvyzż'])(iyle)", "$1\u0111$2i\u0111y\u0111l\u0111e\u0111");
        metin = metin.replaceAll("(^)([bcçdfgğhjklmnprsştvyzż'])(iyle)", "$1\u0111$2i\u0111y\u0111l\u0111e\u0111");
      
        metin = metin.replaceAll("([ \u0111])([bcçdfgğhjklmnprsştvyzż'])(uyla)", "$1\u0111$2u\u0111y\u0111l\u0111a\u0111");
        metin = metin.replaceAll("(^)([bcçdfgğhjklmnprsştvyzż'])(uyla)", "$1\u0111$2u\u0111y\u0111l\u0111a\u0111");
      
        metin = metin.replaceAll("([ \u0111])([bcçdfgğhjklmnprsştvyzż'])(üyle)", "$1\u0111$2ü\u0111y\u0111l\u0111e\u0111");
        metin = metin.replaceAll("(^)([bcçdfgğhjklmnprsştvyzż'])(üyle)", "$1\u0111$2ü\u0111y\u0111l\u0111e\u0111");
       ///keime parçası 4. kural işletiliyor bitiş
        
        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(ıyla|iyle|uyla|üyle)", "$1\u0178y\u0111");

        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(suz|süz)", "$1\u0161z\u0111");
        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(sız|siz)", "$1\u0178z\u0111");

        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(sun|sün)", "$1\u0161\u00E9\u0111");
        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(sın|sin)", "$1\u0178\u00E9\u0111");

        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(lığa|liğe|luğa|lüğe)", "$1\u0161\u00EE\u0111");
        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(lığı|liği|luğu|lüğü)", "$1\u0178\u00EE");

        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(malı|meli)", "$1\u0178\u002F\u0111");
        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(cak|cek)", "$1\u0161\u00F0\u0111");

        metin = metin.replaceAll("([a-zışçüöğż'\u0111])(cağı|ceği)", "$1\u0178\u00F0\u0111");

        //([\\S])(ki)([\\S])
        /* KELİME PARÇASI   KISALTMALARI BİTİŞİ*/
        return metin;
    }

    public String Hece_Kisaltmalari(String gelen) {
        metin = gelen;
        /* HECE KISALTMALARI BAŞLANGICI*/
        //baba,bebe ve kaka için özel durum
        //sonunda boşluk geldiğinde kısaltmayacak fakat sonunda noktalama işaretleri 
        //veya çift tırnak gibi işaretler geldiğinde kısaltacak
        metin = metin.replaceAll("ba$", "b\u0111a");
        metin = metin.replaceAll("ba\\n", "b\u0111a\n");
        metin = metin.replaceAll("ba\\s", "b\u0111a ");
        //b ile a'nın arasına özel(geçici) işareti ekledik
        // (ba) hece kısaltması için unicodu 00E3 seçildi ve değişim yapılıyor
        //ba dan sonra herhangi bir karakter(boşluk dışında) gelirse ba ikini kısalt(2,3,5)
        metin = metin.replaceAll("ba", "\u00E3");
        //ba dan sonra boşluk gelirse yani ba eki kelime sonunda ise kısaltma yapma

        
       // metin = metin.replaceAll("(^|\\s|\u0111|\u017E)(fakat)([,|\u017E|.|\u201D|!|?|:|;|)])", "$1f$3");
        //kendisi, boşluk veya geçici işaret ile başlayıp noktalama işareti ile bitiyorsa
       
        metin = metin.replaceAll("(^|\u0111|\\u0022|\\u005b|\\u005d)(bu)(\\s)", "$1\u00E2$3"); //\u0022çift tırnak işareti
        metin = metin.replaceAll("(\\s)(bu)(\\s)", " \u00E2 ");
        //sonradan eklenen bölüm faruk hoca
        metin = metin.replaceAll("bu$", "b\u0111u");
        metin = metin.replaceAll("bu\\n", "b\u0111u\n");
        metin = metin.replaceAll("bu\\s", "b\u0111u ");
        //bu dan sonra boşluk gelirse yani bu eki kelime sonunda ise kısaltma yapma
        metin = metin.replaceAll("bu", "\u00E2");
        // (bu) hece kısaltması için unicodu 00E2 seçildi ve değişim yapılıyor
        //bu dan sonra herhangi bir karakter(boşluk dışında) gelirse ba ikini kısalt(2,3)

        metin = metin.replaceAll("be$", "b\u0111e");
        metin = metin.replaceAll("be\\n", "b\u0111e\n");
        metin = metin.replaceAll("be\\s", "b\u0111e ");
        //be dan sonra boşluk gelirse yani be eki kelime sonunda ise kısaltma yapma

        metin = metin.replaceAll("be", "\u00E4");
        // (be) hece kısaltması için unicodu 00E4 seçildi ve değişim yapılıyor
        //be den sonra herhangi bir karakter(boşluk dışında) gelirse be ikini kısalt(3,5,6)

        metin = metin.replaceAll("ha$", "h\u0111a");
        metin = metin.replaceAll("ha\\n", "h\u0111a\n");
        metin = metin.replaceAll("ha\\s", "h\u0111a ");
        //ha dan sonra boşluk gelirse yani ha eki kelime sonunda ise kısaltma yapma

        metin = metin.replaceAll("ha", "\u00E6");
        // (ha) hece kısaltması için unicodu 00E6 seçildi ve değişim yapılıyor
        //ha dan sonra herhangi bir karakter(boşluk dışında) gelirse ha ikini kısalt(2,5)

        metin = metin.replaceAll("ka$", "k\u0111a");
        metin = metin.replaceAll("ka\\n", "k\u0111a\n");

        metin = metin.replaceAll("ka\\s", "k\u0111a ");
        //ka dan sonra boşluk gelirse yani ka eki kelime sonunda ise kısaltma yapma

        metin = metin.replaceAll("ka", "\u00E5");
        // (ka) hece kısaltması için unicodu 00E5 seçildi ve değişim yapılıyor
        //ka dan sonra herhangi bir karakter(boşluk dışında) gelirse ka ikini kısalt(2,5,6)
        //metin = metin.replaceAll(" ki$", " k\u0111i"); nisan da kaldırdım
        
        metin = metin.replaceAll("([\\S])(ki)([\\S])", "$1\u00E8$3");
        metin = metin.replaceAll("([\\s])(ki)([\\s])", "$1k\u0111i$3");
        metin = metin.replaceAll("ki ", "\u00E8 ");//levoya sor ki yalnız başına kullanılamıyor.
        metin = metin.replaceAll("^ki", "\u00E8");
        metin = metin.replaceAll("ki$", "\u00E8");
        metin = metin.replaceAll(" ki", " \u00E8");
        // (ki) hece kısaltması için unicodu 00E8 seçildi ve değişim yapılıyor
        //ki dan sonra herhangi bir karakter(boşluk dışında) gelirse ka ekini kısalt(2,5,6)

        metin = metin.replaceAll("bir", "\u00E9");
        // (bir) hece kısaltması için unicodu 00E9 seçildi ve değişim yapılıyor(2,3,4,6)
        metin = metin.replaceAll("da", "\u00EA");
        // (da) hece kısaltması için unicodu 00EA seçildi ve değişim yapılıyor(1,4,5,6)
        metin = metin.replaceAll("di", "\u00FB");
        // (di) hece kısaltması için unicodu 00FB seçildi ve değişim yapılıyor(1,2,3,4,6)
        metin = metin.replaceAll("la", "\u00EC");
        // (la) hece kısaltması için unicodu 00EC seçildi ve değişim yapılıyor(1,2,3,4,5,6)
        metin = metin.replaceAll("ma", "\u00ED");
        // (ma) hece kısaltması için unicodu 00ED seçildi ve değişim yapılıyor(3,4)
        metin = metin.replaceAll("ne", "\u00EE");
        // (ne) hece kısaltması için unicodu 00EE seçildi ve değişim yapılıyor(1,2,3,4,5)
        metin = metin.replaceAll("se", "\u00EF");
        // (se) hece kısaltması için unicodu 00EF seçildi ve değişim yapılıyor(3,4,5)
        metin = metin.replaceAll("te", "\u00E0");
        // (te) hece kısaltması için unicodu 00E0 seçildi ve değişim yapılıyor(1,2,4,5,6)
        metin = metin.replaceAll("ya", "\u00F1");
        // (ya) hece kısaltması için unicodu 00F1 seçildi ve değişim yapılıyor(1,2,4,6)
        metin = metin.replaceAll("de", "\u00EB");
        // (de) hece kısaltması için unicodu 00EB seçildi ve değişim yapılıyor(2,4,5,6)
        metin = metin.replaceAll("le", "\u00F2");
        // (le) hece kısaltması için unicodu 00F2 seçildi ve değişim yapılıyor(3,4,6)
        metin = metin.replaceAll("na", "\u00F3");
        // (na) hece kısaltması için unicodu 00F3 seçildi ve değişim yapılıyor(1,3,4,6)
        metin = metin.replaceAll("sa", "\u00F4");
        // (sa) hece kısaltması için unicodu 00F4 seçildi ve değişim yapılıyor(1,5,6)
        metin = metin.replaceAll("ta", "\u00F5");
        // (ta) hece kısaltması için unicodu 00F5 seçildi ve değişim yapılıyor(2,3,4,5,6)
        metin = metin.replaceAll("ve", "\u00F9");
        // (ve) hece kısaltması için unicodu 00F9 seçildi ve değişim yapılıyor(2,6)
        metin = metin.replaceAll("ye", "\u00FA");
        // (ye) hece kısaltması için unicodu 00FA seçildi ve değişim yapılıyor(1,2,3,5,6)
        /* metin = metin.replaceAll("baba", "\u00E3\u00E3");
            metin = metin.replaceAll("bebe", "\u00E4\u00E4");
            metin = metin.replaceAll("kaka", "\u00E5\u00E5");*/
 /* HECE KISALTMALARI BİTİŞİ*/



        return metin;
    }
}

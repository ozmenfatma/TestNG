package techproed.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Practise_ConfigReader {// test ile properties clasi arssinda aracilik yapar
    public static  Properties properties ;
    /*
    METHOD'U DEVREYE SOKABILMEK ICIN FileInputStream ILE DOSYA YOLUNU BELIRTMEMIZ GEREKIR
 METHOD'DAN ONCE CALISMASI ICIN STATIC BLOCK ICERISINE FileInputStream'i OLUSTURMAMIZ GEREKIR.
 */
    static{
        String dosyaYolu="config.properties";
        try {
            FileInputStream fis= new FileInputStream(dosyaYolu);
            properties=new Properties();// properties clasindan properties objesi olusturup deegr atamasi yaptik
            properties.load(fis);// fis 'in okudugu bilgileri properties e yukler
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getProperty(String Key){

    /*
    Test methodundan gonderdigimiz String Key
     */

        return properties.getProperty(Key);
    }
}

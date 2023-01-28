package techproed.tests.excelautomation;

import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

public class Day23_ExcelLogin {  //28.01.2023
    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    ExcelUtils excelUtils;
    List<Map<String ,String>> excelDatalari;


    //bu method bizi login sayfasina goturur
    public void login () {
        //sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        //home page login tikla
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();

        //        ------SADECE ILK GIRIS-------
//        loginLink butonu sadece ilk giriste sayfada gorunur
//        Ikinci ve ucuncu girislerde sayfada gorunmeyeceginden NoSuchElementException alinir
//        Biz bu exception'i try-catch kullanarak yakalariz ve test case calismaya devam eder

        try {
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1);// 1 sn bekle
        } catch (Exception e) {
        }

//     -----------SONRAKI GIRISLER   ----------
        try{
//            kullanici ID ye tikla      --->>> try catch
            blueRentalHomePage.userID.click();
            ReusableMethods.waitFor(1);
//            Logout linkine tikla       --->>> try catch
            blueRentalHomePage.logoutLink.click();
            ReusableMethods.waitFor(1);
//            OK e tikla                --->>> try catch
            blueRentalHomePage.OK.click();
            ReusableMethods.waitFor(1);
//            home page logine tikla    --->>> try catch
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1);
            //Login sayfasindayiz

        }catch (Exception e){
        }
    }


    @Test
    public void customerLogin() {
   String path="./src/test/java/resources/mysmoketestdata.xlsx";///  ./ onceki tum dosyalari icerir. Relative path kullandik. bunu kullanmassak onceki dosyalari gormez

   String sheetName="customer_info";

   //DATALARI EXCEL UTILS METHODLARI KULLANARAK BU SINIFA ALACAGZ

        excelUtils=new ExcelUtils(path,sheetName);

   // excel datalarini getdataList methodu ile cekecegz
       excelDatalari= excelUtils.getDataList();

   //LOOP kullaranak datalari tek tek testcase de kullan

        for (Map<String,String> data : excelDatalari) {

            login();  //Her loop da login sayfasina goturecek

   //    Kullanici adini
            ReusableMethods.waitFor(1);
         blueRentalLoginPage.emailBox.sendKeys(data.get("username"));


   //    Kullanici sifresini gir
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.passwordBox.sendKeys(data.get("password"));

   //   Login butonuna tikla
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.loginButton.click();
            ReusableMethods.waitFor(1);




        }





    }

    /*
sam.walker@bluerentalcars.com   c!fas_art
kate.brown@bluerentalcars.com   tad1$Fas
raj.khan@bluerentalcars.com v7Hg_va^
pam.raymond@bluerentalcars.com  Nga^g6!
------ILK GIRIS---------
HOME PAGE DEYIZ
home page logine tikla    ---> try catch
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini git(excelden al)
login page login buttonuna tikla

------2. GIRIS-----
HOME PAGE DEYIZ
kullanici ID ye tikla
Logout linkine tikla
OK e tikla
home page logine tikla
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini git(excelden al)
login page login buttonuna tikla

------3. GIRIS---------
HOME PAGE DEYIZ
kullanici ID ye tikla
Logout linkine tikla
OK e tikla
home page logine tikla
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini git(excelden al)
login page login buttonuna tikla

---------4. GIRIS------------
HOME PAGE DEYIZ
kullanici ID ye tikla
Logout linkine tikla
OK e tikla
home page logine tikla
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini git(excelden al)
login page login buttonuna tikla
 */

}

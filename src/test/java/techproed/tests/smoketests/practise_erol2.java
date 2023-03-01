package techproed.tests.smoketests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.pages.HerokuPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class practise_erol2 {
    @DataProvider
    public static Object[][] kullanici() {
        return new Object[][]{{ConfigReader.getProperty("email1"),ConfigReader.getProperty("password1")},
                {ConfigReader.getProperty("email2"),ConfigReader.getProperty("password2")},
                {ConfigReader.getProperty("email3"),ConfigReader.getProperty("password3")}};

    }

    /*
    Negative Test
    1.  https://id.heroku.com/login sayfasina gidin
    2.  Data provider kullanarak mail adres ve passwordleri giriniz
    3.  Login butonuna tiklayiniz
    4.  "There was a problem with your login." texti gorunur olduğunu test edin
    5.  sayfalari kapatiniz

 */

    @Test(dataProvider = "kullanici")
    public void test1(String email,String password) throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("herokuUrl"));



        HerokuPage obj=new HerokuPage();
        obj.kabul.click();

        obj.email.sendKeys(email);
        Thread.sleep(2000);
        obj.password.sendKeys(password);
        Thread.sleep(2000);
        obj.loginButton.click();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(obj.yazi.isDisplayed());

        softAssert.assertAll();/// bunu kullanmasssam test calisir . soft assert varsa assertAll kullanilmali perform gibi

        Driver.closeDriver();


    }
}

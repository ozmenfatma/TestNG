package techproed.tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.utilities.Practise_Driver;

public class Practıse_PageKullanimi {
    @Test
    public void testName() {
        AmazonPage amazonPage = new AmazonPage();

        //amazona gidelim
        Practise_Driver.getDriver().get("https://amazon.com");

        //iphone aratalım
        amazonPage.aramaKutusu.sendKeys("iphone", Keys.ENTER);

        //sonuc yazısının iphone içerdiğini test edelim

        String actualSonuc=amazonPage.sonucYazisi.getText();
        String arananKelime= "iphone";
        actualSonuc.contains(arananKelime);
        Practise_Driver.closeDriver();
    }
}
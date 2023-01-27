package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TechproHomePage;
import techproed.pages.TechproLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day21_TechProTestCenter {

    @Test
    public void testName() {
        Driver.getDriver().get(ConfigReader.getProperty("techpro_test_url"));
        TechproLoginPage techproLoginPage = new TechproLoginPage();
        TechproHomePage techproHomePage = new TechproHomePage();

        techproLoginPage.username.sendKeys(ConfigReader.getProperty("techpro_test_username"));
        techproLoginPage.password.sendKeys(ConfigReader.getProperty("techpro_test_password"));
        techproLoginPage.submit.click();

//      ASSERTION
//        Login yapildi. Driver su an Home Pagede
        Assert.assertTrue(techproHomePage.homeHeader.isDisplayed());

//        Sayfadan cikis yap ve cikis yapildigini test et
        techproHomePage.logoutButton.click();

        // cikis olduguna dair assertion yap
        Assert.assertTrue(techproLoginPage.submit.isDisplayed());

        //Driver i kapat
        Driver.closeDriver();

    }
}

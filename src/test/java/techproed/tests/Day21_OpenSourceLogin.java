package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourceDashboardPage;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day21_OpenSourceLogin {

    @Test
    public void openSourceLogin() throws InterruptedException {
       // OpenSourcePage openSourcePage;
        //1.Adim  sayfaya git
        //        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Driver.getDriver().get(ConfigReader.getProperty("open_source_url"));

        //2. page objesi olustur// class duzeyinde de olusabilir

       OpenSourcePage openSourcePage=new OpenSourcePage();
       // openSourcePage=new OpenSourcePage(); bu sekildede olusabilir

        //3. Bu objeyi kullanarak o siniftaki objelere ulas
        openSourcePage.username.sendKeys(ConfigReader.getProperty("open_source_username"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("open_source_password"));
        openSourcePage.submitButton.click();

        //4.Asssertion
        OpenSourceDashboardPage openSourceDashboardPage=new OpenSourceDashboardPage();
        Thread.sleep(3);
        Assert.assertTrue(openSourceDashboardPage.dashboardHeader.isDisplayed());


    }
}

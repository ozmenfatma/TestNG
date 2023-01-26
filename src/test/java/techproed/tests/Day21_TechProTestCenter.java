package techproed.tests;

import org.testng.annotations.Test;
import techproed.pages.TechproLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day21_TechProTestCenter {

    @Test
    public void testName() {
        Driver.getDriver().get("https://testcenter.techproeducation.com/index.php?page=form-authentication");
        TechproLoginPage techproLoginPage=new TechproLoginPage();
        techproLoginPage.username.sendKeys("techproed");
        techproLoginPage.password.sendKeys(ConfigReader.getProperty("techpro_test_password"));
        techproLoginPage.submit.click();
    }
}

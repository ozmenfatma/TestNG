package techproed.tests.smoketests;

import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class pratık_kendimce {


    /*
    	•Name: US100201_Admin_Login
	•Description:
	•Admin bilgileriyle giriş
	•Acceptance Criteria:
	•Admin olarak, uygulamaya giriş yapabilmeliyim
	•https://www.bluerentalcars.com/
	•Admin email: jack@gmail.com
	•Admin password: 12345
     */

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;

    @Test
    public void testName() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage=new BlueRentalHomePage();
        blueRentalLoginPage=new BlueRentalLoginPage();

        blueRentalHomePage.loginLink.click();
        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("admin_email"));
        ReusableMethods.waitFor(1);
        blueRentalLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("admin_sifre"));
        ReusableMethods.waitFor(1);
        blueRentalLoginPage.loginButton.click();
        ReusableMethods.waitFor(1);

        blueRentalHomePage.userID.click();
        blueRentalHomePage.logoutLink.click();
        blueRentalHomePage.OK.click();

    }
}

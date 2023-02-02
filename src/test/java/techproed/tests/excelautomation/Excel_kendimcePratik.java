package techproed.tests.excelautomation;

import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Excel_kendimcePratik {

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    ExcelUtils excelUtils;
    List<Map<String, String>> exceldatalari;

    public void login() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();

        try {
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(2);
        } catch (Exception e) {
        }

        try {
            blueRentalHomePage.userID.click();
            ReusableMethods.waitFor(1);
            blueRentalHomePage.logoutLink.click();
            ReusableMethods.waitFor(1);
            blueRentalHomePage.OK.click();
            ReusableMethods.waitFor(1);
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1);

        } catch (Exception e) {

        }
    }

    @Test
    public void testName() throws IOException {
        String path="./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetname="customer_info";

        excelUtils=new ExcelUtils(path,sheetname);

        exceldatalari=excelUtils.getDataList();

        for (Map<String,String> data : exceldatalari){
            login();

            ReusableMethods.waitFor(1);

            blueRentalLoginPage.emailBox.sendKeys(data.get("username"));

            ReusableMethods.waitFor(1);

            blueRentalLoginPage.passwordBox.sendKeys(data.get("password"));

            ReusableMethods.waitFor(1);

            blueRentalLoginPage.loginButton.click();
           ReusableMethods.verifyElementDisplayed(blueRentalHomePage.userID);
           ReusableMethods.getScreenshot("EkranGoruntu");
        }

        Driver.closeDriver();
    }
}
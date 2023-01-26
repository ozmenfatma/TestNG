package techproed.tests;

import org.testng.annotations.Test;
import techproed.utilities.Practise_ConfigReader;
import techproed.utilities.Practise_Driver;

public class Practise_YeniDriver {

    @Test
    public void testName() {
        //Driver.getDriver().get("https://amazon.com");
        Practise_Driver.getDriver().get(Practise_ConfigReader.getProperty("amazonUrl"));
        Practise_Driver.closeDriver();


     //   Driver.getDriver().get("https://techproeducation.com");
      //  Driver.getDriver().get("https://facebook.com");

    }
}

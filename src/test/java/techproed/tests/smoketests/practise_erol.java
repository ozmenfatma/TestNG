package techproed.tests.smoketests;

import com.beust.ah.A;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import techproed.pages.DhtmlPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import javax.swing.*;

public class practise_erol {

    @Test
    public void test(){
        Driver.getDriver().get(ConfigReader.getProperty("dhtmlUrl"));

        DhtmlPage dhtmlPage=new DhtmlPage();
        for (WebElement w: dhtmlPage.ulkeler){
            System.out.println(w.getText());
        }
        Actions actions=new Actions(Driver.getDriver());

        actions.dragAndDrop(dhtmlPage.Seoul,dhtmlPage.Korea).
                dragAndDrop(dhtmlPage.oslo,dhtmlPage.Norway).
                dragAndDrop(dhtmlPage.Stockholm,dhtmlPage.Sweden).
                dragAndDrop(dhtmlPage.Rome,dhtmlPage.Italy).
                dragAndDrop(dhtmlPage.Madrid,dhtmlPage.Spain).
                dragAndDrop(dhtmlPage.Washington,dhtmlPage.abd).
                dragAndDrop(dhtmlPage.Copenhagen, dhtmlPage.Denmark).perform();

    }
}

package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import techproed.utilities.Driver;

public class TechproHomePage {

    public TechproHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath="//div[contains(text(),'logged')]") public WebElement homeHeader;
    @FindBy(xpath="//a[@class='btn btn-dark']") public WebElement logoutButton;

}

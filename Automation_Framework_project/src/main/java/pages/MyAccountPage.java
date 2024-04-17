package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.WebTestBase;
import utility.WebDriverUtil;

public class MyAccountPage extends WebTestBase {
    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement myAccountText;

    public  MyAccountPage(){
        PageFactory.initElements(driver,this);
    }
    public String getTextOfMyAccount(){
        return WebDriverUtil.getTextOfElement(myAccountText);
    }
}

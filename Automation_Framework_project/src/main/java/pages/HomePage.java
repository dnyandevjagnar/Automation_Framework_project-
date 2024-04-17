package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.WebTestBase;
import utility.WebDriverUtil;

public class HomePage extends WebTestBase {


        @FindBy(xpath = "//a[@class='user-controls__ul__li__a']")
        WebElement loginUserBtn;
        @FindBy(xpath ="//a[@class='newsletter__close newsletter__trigger']")
        WebElement firstAd;
        public HomePage(){
            PageFactory.initElements(driver,this);
        }
        public void closedAd(){
            WebDriverUtil.waitUntilElementToBeClickable(firstAd);
        }
        public void clickOnLoginBtn(){
            WebDriverUtil.waitUntilElementToBeClickable(loginUserBtn);
        }

}

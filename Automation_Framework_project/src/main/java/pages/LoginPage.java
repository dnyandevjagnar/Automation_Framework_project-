package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.WebTestBase;
import utility.WebDriverUtil;

public class LoginPage extends WebTestBase {
    @FindBy(id="username")
    WebElement userNameTextBox;

    @FindBy(id="password")
    WebElement passwordTextBox;

    @FindBy(xpath = "//input[@value='Log in']")
    WebElement loginBtn;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
    public void  login(String userName,String password){
        WebDriverUtil.sendKeysByElement(userNameTextBox,userName);
        WebDriverUtil.sendKeysByElement(passwordTextBox,password);
        WebDriverUtil.waitUntilElementToBeClickable(loginBtn);
    }
}

package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import testBase.WebTestBase;

public class LoginTest extends WebTestBase {
    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;

    @BeforeMethod
    public void preRequisite(){
        initialization();
        homePage =new HomePage();
        loginPage =new LoginPage();
        myAccountPage=new MyAccountPage();
    }
    @Test(description = "verify login with valid username and password ")
    public void verifyValidUserNameValidPassword(){
        SoftAssert softAssert=new SoftAssert();
          homePage.closedAd();
          homePage.clickOnLoginBtn();
          loginPage.login(prop.getProperty("username"),prop.getProperty("password") );
          softAssert.assertEquals(myAccountPage.getTextOfMyAccount(),"MY ACCOUNT","MY ACCOUNT should be match");
          softAssert.assertAll();

    }
    @AfterMethod
    public  void tearDown(){
     driver.close();
    }

}

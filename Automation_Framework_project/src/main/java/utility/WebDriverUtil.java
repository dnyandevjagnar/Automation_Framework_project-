package utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBase.WebTestBase;

import java.time.Duration;

public class WebDriverUtil extends WebTestBase {
    public static final long PAGE_LOAD_TIMEOUT=40;
    public static final long IMPLICIT_WAIT=40;

    public static WebDriverWait webDriverWait;
    public static long explicitWait=40;
    public static void  waitUntilElementToBeClickable(WebElement element){
        webDriverWait =new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public static void sendKeysByElement(WebElement element ,String text){
         element.sendKeys(text);
    }
    public static  String getTextOfElement(WebElement element){
        return element.getText();
    }

}

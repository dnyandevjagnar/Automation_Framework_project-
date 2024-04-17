package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.WebDriverUtil;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class WebTestBase {
    public static WebDriver driver;
    public Properties prop;
    public WebTestBase(){
        FileInputStream fileInputStream=null;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir")+ "/src/main/resources/properties/config.properties");
        }catch (Exception e){
            e.printStackTrace();

        }
        prop=new Properties();
        try {
            prop.load(fileInputStream);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public void initialization(){
        String browser=prop.getProperty("browserName");

        if(browser.equalsIgnoreCase("chrome")){
            System.getProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/src/main/resources/driver/chromedriver.exe");
            driver=new ChromeDriver();

        }
        else if (browser.equalsIgnoreCase("firefox")) {
            System.getProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ "/src/main/resources/driver/geckodriver.exe");
            driver=new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("edge")) {
            System.getProperty("webdriver.edge.driver",System.getProperty("user.dir")+ "/src/main/resources/driver/msedgedriver.exe");
            driver=new EdgeDriver();
        }else {
            throw new RuntimeException("please select the correct browser name chrome ,firefox ,edge.....");
        }
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WebDriverUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WebDriverUtil.IMPLICIT_WAIT));
    }
}

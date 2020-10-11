package utils;

import common.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Map;

public class BrowserSetUp {

    public static WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
//    String browser = "chrome";

    public static void setBrowser(){

        if(Constants.browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            // Initialize browser
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        }

        if(Constants.browser.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");
            // Initialize browser
            driver = new InternetExplorerDriver();
        }
    }

    public static void navigateToUrl(String url){
        driver.navigate().to(url);
    }

    public static void tearDown(){
        driver.quit();
    }

}

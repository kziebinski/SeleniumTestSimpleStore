package test.setupTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSetup {
    private WebDriver driver;

    public WebDriver setup(String browser) throws Exception {
        //chrome
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriver/chromedriver.exe");
            driver = new ChromeDriver();
        }
        //firefox
        else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/webdriver/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        //edge
        else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "src/main/resources/webdriver/MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
        }
        //If no browser
        else {
            throw new Exception("Browser is not correct");
        }
        return driver;
    }
}

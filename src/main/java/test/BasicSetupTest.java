package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BasicSetupTest {

    protected WebDriver driver;
    protected HomePage homePage;
    private final String baseUrl = "http://automationpractice.com/index.php";
    private final Logger log = LogManager.getLogger(BasicSetupTest.class.getName());

    @Parameters("browser")
    @BeforeMethod()
    public void beforeRun(String browser) throws Exception {
        //chrome
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriver/chromedriver.exe");
            driver = new ChromeDriver();
        }
        //firefox
        else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "src/main/resources/webdriver/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        //edge
        else if (browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver","src/main/resources/webdriver/MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
        }
        //If no browser
        else {
            throw new Exception("Browser is not correct");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        homePage = new HomePage(driver);
        log.info("Setup complete -> Start testing...");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
        log.info("test completed ");
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }
}

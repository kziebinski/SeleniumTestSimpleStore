package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BasicSetupTest {

    protected WebDriver driver;
    protected HomePage homePage;
    private final String baseUrl = "http://automationpractice.com/index.php";
    private final Logger log = LogManager.getLogger(BasicSetupTest.class.getName());

    @BeforeMethod
    public void beforeRun(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        homePage = new HomePage(driver);
        log.info("Setup complete -> Start testing...");
    }

    @AfterMethod
    public  void closeBrowser(){
        driver.quit();
        log.info("test completed ");
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }
}

package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BasicSetupTest {

    protected WebDriver driver;
    protected HomePage homePage;
    private BrowserSetup browserSetup = new BrowserSetup();
    private final String baseUrl = "http://automationpractice.com/index.php";
    private final Logger log = LogManager.getLogger(BasicSetupTest.class.getName());

    @Parameters("browser")
    @BeforeMethod()
    public void beforeRun(String browser) throws Exception {
        driver = browserSetup.setup(browser);
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

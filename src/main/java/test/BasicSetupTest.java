package test;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.HelpTest;
import pages.homePage.HomePage;
import test.setupTest.BrowserSetup;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BasicSetupTest {

    protected WebDriver driver;
    protected HomePage homePage;
    private BrowserSetup browserSetup = new BrowserSetup();
    private final String baseUrl = "http://automationpractice.com/index.php";
    private final Logger log = LogManager.getLogger(BasicSetupTest.class.getName());
    private HelpTest helpTest = new HelpTest();

    @Parameters("browser")
    @BeforeMethod()
    public void beforeRun(String browser) throws Exception {
        driver = browserSetup.setup(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        homePage = new HomePage(driver);
        helpTest.setNameClass(this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1));
        log.info("Setup complete -> Start testing...");
        Reporter.log("Setup complete -> Start testing...");
    }

    @AfterMethod
    public void closeBrowser(ITestResult result) {
        takeScreenshotWhenFail(result);
        driver.quit();
        log.info("test completed ");
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void takeScreenshotWhenFail(ITestResult result) {
        String simpleDate = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        if (ITestResult.FAILURE == result.getStatus()) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File("src/main/log/screenshots/scr_" + result.getName() + simpleDate + ".png"));
            } catch (IOException e) {
                log.info("Error takeScreenshotWhenFail: " + e);
            }
        }
    }
}

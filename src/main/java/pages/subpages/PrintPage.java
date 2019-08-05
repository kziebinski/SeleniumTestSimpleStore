package pages.subpages;

import org.openqa.selenium.WebDriver;
import pages.BasicPage;

public class PrintPage extends BasicPage {

    public PrintPage(WebDriver driver){
        super(driver);
    }
    public String getCurrentlyUrl(){
        return driver.getCurrentUrl();
    }
}

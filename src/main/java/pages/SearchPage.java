package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li")
    List<WebElement> listItem;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ArrayList<String> listElement(){
        ArrayList<String> tempListItem = new ArrayList<>();
        for(WebElement element:listItem){
            tempListItem.add(element.getText());
        }
        return tempListItem;
    }
}

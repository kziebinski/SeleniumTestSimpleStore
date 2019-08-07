package pages.subpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasicPage;

import java.util.ArrayList;
import java.util.List;

public class BestSellersPage extends BasicPage {

    private List<Float> listNotSort;
    private List<Float> listSortByHigherPrice = new ArrayList<>();
    private List<Float> listSortByLowestPrice = new ArrayList<>();
    private final String sortPriceDESC = "price:desc";
    private final String sortPriceASC = "price:asc";

    @FindBy(id = "selectProductSort")
    WebElement sortByButton;

    public BestSellersPage(WebDriver driver) {
        super(driver);
        this.listNotSort = listPriceOfProduct();
    }

    private BestSellersPage clickSortAndSelectValue(String value) {
        Select sortByDropDown = new Select(sortByButton);
        sortByDropDown.selectByValue(value);
        return this;
    }

    public BestSellersPage clickSortHighestPrice() {
        clickSortAndSelectValue(sortPriceDESC);
        return this;
    }

    public BestSellersPage clickSortLowestPrice() {
        clickSortAndSelectValue(sortPriceASC);
        return this;
    }

    private List<Float> listPriceOfProduct() {
        List<Float> listTemp = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            List<WebElement> listPrice = driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li[" + i + "]/div/div[2]/div[1]/span[1]"));
            for (WebElement element : listPrice) {
                listTemp.add(Float.parseFloat(element.getText().substring(1)));
            }
        }
        return listTemp;
    }

    public List<Float> getListNotSort() {
        return listNotSort;
    }

    public List<Float> getListSortByHigherPrice() {
        this.listSortByHigherPrice = listPriceOfProduct();
        return this.listSortByHigherPrice;
    }

    public List<Float> getListSortByLowestPrice() {
        this.listSortByLowestPrice = listPriceOfProduct();
        return this.listSortByLowestPrice;
    }
}
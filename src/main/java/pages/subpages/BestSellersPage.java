package pages.subpages;

import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.BasicPage;
import pages.HelpTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BestSellersPage<T> extends BasicPage {

    private int countItem;
    private int tempValueItem;
    private T listNotSort;
    private T listAfterSort;
    private HelpTest helpTest = new HelpTest();
    private Product currentProduct;

    @FindBy(id = "selectProductSort")
    WebElement sortByButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/div[2]/form/button")
    WebElement compareButton;

    public BestSellersPage(WebDriver driver) {
        super(driver);
        countItem = driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li")).size();
        if (helpTest.getNameClass().equals("SortProductsByPrice")) {
            this.listNotSort = (T) listPriceOfProduct();
        } else if (helpTest.getNameClass().equals("SortProdcutsByName")) {
            this.listNotSort = (T) listNameProduct();
        }
    }

    private BestSellersPage clickSortAndSelectValue(String value) {
        Select sortByDropDown = new Select(sortByButton);
        sortByDropDown.selectByValue(value);
        return this;
    }

    public BestSellersPage clickSortHighestPrice() {
        clickSortAndSelectValue(BestSellersSort.PRICE_DESC.getNameSort());
        return this;
    }

    public BestSellersPage clickSortLowestPrice() {
        clickSortAndSelectValue(BestSellersSort.PRICE_ASC.getNameSort());
        return this;
    }

    public BestSellersPage clickSortNameA_Z() {
        clickSortAndSelectValue(BestSellersSort.NAME_ASC.getNameSort());
        return this;
    }

    private List<Float> listPriceOfProduct() {
        List<Float> listTemp = new ArrayList<>();
        for (int i = 1; i <= countItem + 1; i++) {
            List<WebElement> listPrice = driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li[" + i + "]/div/div[2]/div[1]/span[1]"));
            for (WebElement element : listPrice) {
                listTemp.add(Float.parseFloat(element.getText().substring(1)));
            }
        }
        return listTemp;
    }

    public List<String> listNameProduct() {
        List<String> listTemp = new ArrayList<>();
        for (int i = 1; i <= countItem + 1; i++) {
            List<WebElement> listName = driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li[" + i + "]/div/div[2]/h5/a"));
            for (WebElement element : listName) {
                listTemp.add(element.getText());
            }
        }
        return listTemp;
    }

    public T getListNotSort() {
        return listNotSort;
    }

    public T getListAfterSort() {
        if (helpTest.getNameClass().equals("SortProductsByPrice")) {
            this.listAfterSort = (T) listPriceOfProduct();
        } else if ((helpTest.getNameClass().equals("SortProdcutsByName"))) {
            this.listAfterSort = (T) listNameProduct();
        }
        return this.listAfterSort;
    }

    public BestSellersPage addProductToCompare() {
        Random rnd = new Random();
        tempValueItem = rnd.nextInt(countItem) + 1;
        WebElement randomProduct = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[" + tempValueItem + "]/div/div[2]/h5/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", randomProduct);
        Actions actions = new Actions(driver);
        actions.moveToElement(randomProduct).perform();
        String tempProductName = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[" + tempValueItem + "]/div/div[2]/h5/a")).getText();
        String tempProdcutValue = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[" + tempValueItem + "]/div/div[1]/div/div[2]/span")).getText();
        currentProduct = new Product(Float.parseFloat(tempProdcutValue.substring(1)), tempProductName);
        WebElement addToCompareButton = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[" + tempValueItem + "]/div/div[3]/div[2]/a"));
        addToCompareButton.click();
        return this;
    }

    public CompareProductPage clickAndGoToCompareProductPage() {
        wait.until(ExpectedConditions.elementToBeClickable(compareButton)).click();
        return new CompareProductPage(driver, currentProduct);
    }
}
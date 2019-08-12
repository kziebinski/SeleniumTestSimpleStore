package pages.subpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasicPage;
import pages.HelpTest;

import java.util.ArrayList;
import java.util.List;

public class BestSellersPage<T> extends BasicPage {

    private int countItem = 7;
    private T listNotSort;
    private T listAfterSort;
    private HelpTest helpTest = new HelpTest();

    @FindBy(id = "selectProductSort")
    WebElement sortByButton;

    public BestSellersPage(WebDriver driver) {
        super(driver);
        if(helpTest.getNameClass().equals("SortProductsByPrice")){
            this.listNotSort = (T) listPriceOfProduct();
        }
        else if(helpTest.getNameClass().equals("SortProdcutsByName")){
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

    public BestSellersPage clickSortNameA_Z(){
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
    public List<String> listNameProduct(){
        List<String> listTemp = new ArrayList<>();
        for (int i = 1; i <= countItem + 1; i++){
            List<WebElement> listName = driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li["+i+"]/div/div[2]/h5/a"));
            for (WebElement element : listName){
                listTemp.add(element.getText());
            }
        }
        return listTemp;
    }

    public T getListNotSort() {
        return listNotSort;
    }

    public T getListAfterSort(){
        if(helpTest.getNameClass().equals("SortProductsByPrice")){
            this.listAfterSort = (T) listPriceOfProduct();
        }
        else if((helpTest.getNameClass().equals("SortProdcutsByName"))){
            this.listAfterSort = (T) listNameProduct();
        }
        return this.listAfterSort;
    }
}
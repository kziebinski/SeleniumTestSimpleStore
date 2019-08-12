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

public class BestSellersPage extends BasicPage {

    private int countItem = 7;
    private List<Float> listPriceNotSort;
    private List<String> listNameNotSort;
    private List<Float> listSortByHigherPrice = new ArrayList<>();
    private List<Float> listSortByLowestPrice = new ArrayList<>();
    private List<String> listSortByNameA_Z = new ArrayList<>();
    private final String sortPriceDESC = "price:desc";
    private final String sortPriceASC = "price:asc";
    private final String sortNameASC = "name:asc";
    private HelpTest helpTest = new HelpTest();

    @FindBy(id = "selectProductSort")
    WebElement sortByButton;

    public BestSellersPage(WebDriver driver) {
        super(driver);
        if(helpTest.getNameClass().equals("SortProductsByPrice")){
            this.listPriceNotSort = listPriceOfProduct();
        }
        else if(helpTest.getNameClass().equals("SortProductsByName")){
            this.listNameNotSort =  listNameProduct();
        }
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

    public BestSellersPage clickSortNameA_Z(){
        clickSortAndSelectValue(sortNameASC);
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

    public List<Float> getListPriceNotSort() {
        return listPriceNotSort;
    }

    public List<Float> getListSortByHigherPrice() {
        this.listSortByHigherPrice = listPriceOfProduct();
        return this.listSortByHigherPrice;
    }

    public List<Float> getListSortByLowestPrice() {
        this.listSortByLowestPrice = listPriceOfProduct();
        return this.listSortByLowestPrice;
    }
    public List<String> getListNameNotSort(){
        return listNameNotSort;
    }
    public List<String> getListSortByNameA_Z(){
        this.listSortByNameA_Z = listNameProduct();
        return this.listSortByNameA_Z;
    }
}
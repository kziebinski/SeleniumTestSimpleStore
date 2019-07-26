package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.paymentFlow.CartSummary;
import pages.socialMediaPage.FacebookPage;
import pages.socialMediaPage.TwitterPage;
import pages.subpages.AuthenticationPage;
import pages.subpages.SearchPage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomePage extends BasicPage {

    private int tempValueItem;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"social_block\"]/ul/li[1]/a")
    WebElement facebookButton;

    @FindBy(xpath = "//*[@id=\"social_block\"]/ul/li[2]/a")
    WebElement twitterButton;

    @FindBy(css = "img")
    List<WebElement> allImages;

    @FindBy(id = "search_query_top")
    WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"searchbox\"]/button")
    WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]")
    WebElement firstItemAddToCartButton;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]")
    WebElement takeFirstItem;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public AuthenticationPage goToAuthenticationPage() {
        signInButton.click();
        return new AuthenticationPage(driver);
    }

    public FacebookPage goToFacebookPage() {
        facebookButton.click();
        for (String facebookTab : driver.getWindowHandles()) {
            driver.switchTo().window(facebookTab);
        }
        return new FacebookPage(driver);
    }

    public TwitterPage goToTwitterPage() {
        twitterButton.click();
        for (String twitterTab : driver.getWindowHandles()) {
            driver.switchTo().window(twitterTab);
        }
        return new TwitterPage(driver);
    }

    public ArrayList<String> listImages() throws IOException {
        ArrayList<String> tempListImages = new ArrayList<>();
        for (int iElement = 0; iElement < allImages.size(); iElement++) {
            String url = allImages.get(iElement).getAttribute("src");
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            if (String.valueOf(con.getResponseCode()).equals("200")) {
                tempListImages.add("200 " + url);
            } else
                tempListImages.add("Bad " + url);
        }
        return tempListImages;
    }

    public SearchPage fillSearchFieldAndSubmit(String inputText) {
        searchInput.sendKeys(inputText);
        searchButton.click();
        return new SearchPage(driver);
    }

    public CartSummary clickAddItemToCartAndConfirm() {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", takeFirstItem);
//        Actions actions = new Actions(driver);
//        actions.moveToElement(takeFirstItem).perform();
        randomChooseItemDisplayInHomePage();
        firstItemAddToCartButton.click();
        proceedToCheckoutButton.click();
        return new CartSummary(driver);
    }
    public HomePage randomChooseItemDisplayInHomePage() {
        int sizeItem = driver.findElements(By.xpath("//*[@id=\"homefeatured\"]/li")).size();
        Random rnd = new Random();
        tempValueItem =  rnd.nextInt(sizeItem) + 1;
        WebElement randomProduct = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[" + tempValueItem  + "]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", randomProduct);
        Actions actions = new Actions(driver);
        actions.moveToElement(randomProduct).perform();
        return this;
    }
}

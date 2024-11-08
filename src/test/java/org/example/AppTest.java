package org.example;

import org.example.Helpers.SortProductByPrice;
import org.example.Models.HomePageModel;
import org.example.Models.SearchListPageModel;
import org.example.Pojo.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppTest {

    WebDriver driver;
    ChromeOptions options;

    @BeforeTest
    public void initializeWebDriver(){
        options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @DataProvider (name = "searchData")
    public Object[][] dpMethod(){
        return new Object[][] {
                {"Samsung"},
                {"Oneplus"},
                {"Apple"},
        };
    }


    @Test(testName = "To get the title and price in ascending order in amazon for different search data",
            dataProvider = "searchData")
    public void test(String input){
        HomePageModel homePage = new HomePageModel(driver);
        homePage.loadPage();
        homePage.searchForItem(input);

        SearchListPageModel searchListPage = new SearchListPageModel(driver);

        List<WebElement> products = searchListPage.getProducts();

        List<Product> productsList = new ArrayList<>();

        for(WebElement p : products){
            Product product = new Product();
            try {
                WebElement productTitle = searchListPage.getProductTitle(p);
                product.title = productTitle.getText();
            }
            catch (Exception e){
                product.title = "";
            }
            try {
                WebElement productPrice = searchListPage.getProductPrice(p);
                product.price = productPrice.getText();
            }
            catch (Exception e){
                product.price = "";
            }
            productsList.add(product);
        }

        productsList.sort(new SortProductByPrice());

        for(Product p : productsList){
            System.out.print(p.title);
            System.out.print("  ");
            System.out.println(p.price);
        }
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
package org.example.Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchListPageModel {
    WebDriver driver;

    private final By productsDetail = By.xpath("//div[@data-component-type='s-search-result']");
    private final By productTitle = By.xpath("(.//span[@class='a-size-medium a-color-base a-text-normal']) | (.//span[@class='a-size-base-plus a-color-base a-text-normal'])");
    private final By productPrice = By.xpath(".//span[@class = 'a-price-whole']");

    public SearchListPageModel(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> getProducts(){
        return driver.findElements(productsDetail);
    }

    public WebElement getProductTitle(WebElement productDetail){
        return productDetail.findElement(productTitle);
    }

    public WebElement getProductPrice(WebElement productDetail){
        return productDetail.findElement(productPrice);
    }
}

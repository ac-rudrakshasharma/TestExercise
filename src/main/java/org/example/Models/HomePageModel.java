package org.example.Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageModel {

    WebDriver driver;

    private final By searchBox = By.id("twotabsearchtextbox");

    public HomePageModel(WebDriver driver){
        this.driver = driver;
    }

    public void loadPage() {
        driver.get("https://www.amazon.in");
    }

    public void searchForItem(String searchText) {
        WebElement searchTab = driver.findElement(searchBox);
        searchTab.clear();
        searchTab.sendKeys(searchText);
        searchTab.submit();
    }
}

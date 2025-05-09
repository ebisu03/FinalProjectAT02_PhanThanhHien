package com.nanon.FinalProject.pages;

import com.nanon.keywords.WebUI;
import org.openqa.selenium.By;

public class BasePage {
    public By menuDashboard = By.xpath("//div[@class='d-flex align-items-start']//span[normalize-space()='Dashboard']");
    public By menuManageProfile = By.xpath("//div[@class='d-flex align-items-start']//span[normalize-space()='Manage Profile']");
    public By menuHome = By.xpath("//a[contains(text(),'Home')]");
    public By buttonRemoveAdver = By.xpath("//button[@data-key='website-popup']");
    public By searchBar = By.xpath("//input[@id='search']");
    public By firstItem = By.xpath("(//div[@id='search-content']//ul//li)[1]");
    public By iconCart = By.xpath("//span[normalize-space()='Cart']");
    public By buttonCheckout = By.xpath("//a[normalize-space()='Checkout']");
    public By buttonPolicy = By.xpath("//button[normalize-space()='Ok. I Understood']");

    public CartPage clickIconCart() {
        WebUI.scrollToElement(iconCart);
        WebUI.clickElement(iconCart);
        WebUI.waitForElementVisible(buttonCheckout);
        if (WebUI.isElementDisplayed(buttonCheckout)) {
            WebUI.clickElement(buttonCheckout);
        }
        return new CartPage();
    }

    public DashboardPage clickMenuDashboard() {
        WebUI.waitForElementVisible(menuDashboard);
        WebUI.clickElement(menuDashboard);
        return new DashboardPage();
    }

    public HomePage clickMenuHomePage() {
        WebUI.clickElement(buttonRemoveAdver);
        WebUI.waitForElementVisible(menuHome);
        WebUI.clickElement(menuHome);
        WebUI.clickElement(buttonPolicy);
        return new HomePage();
    }

    public ProfilePage clickMenuManageProfile() {

        WebUI.clickElement(buttonRemoveAdver);
        WebUI.waitForElementVisible(menuManageProfile);
        WebUI.clickElement(menuManageProfile);
        return new ProfilePage();
    }

    public ProductPage clickDetailProduct(String productName) {
        WebUI.clickElement(buttonRemoveAdver);
        WebUI.setText(searchBar, productName);
        WebUI.sleep(3);
        WebUI.clickElement(firstItem);
        WebUI.waitForPageLoaded();
        WebUI.sleep(1);
        return new ProductPage();
    }

    //-----------------------------------------------
    //Hàm và biến dành cho Admin
    private By menuProduct = By.xpath("//span[normalize-space()='Products']");
    private By addNewProduct = By.xpath("//span[normalize-space()='Add New Product']");

    public ProductPage clickMenuAddNewProduct() {
        WebUI.clickElement(menuProduct);
        WebUI.clickElement(addNewProduct);
        return new ProductPage();
    }
}

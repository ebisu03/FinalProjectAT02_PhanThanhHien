package com.nanon.FinalProject.pages;

import com.nanon.keywords.WebUI;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private By titleNewProduct = By.xpath("//span[normalize-space()='New Products']");
    private By addFirstProductToCart = By.xpath("(//div[@id='section_newest']//div[@class='position-relative'])[1]//a[@data-title='Add to cart']");
    private By addSecondProductToCart = By.xpath("(//div[@id='section_newest']//div[@class='position-relative'])[2]//a[@data-title='Add to cart']");
    private By buttonAddToCart = By.xpath("//form[@id='option-choice-form']/following-sibling::div//span[normalize-space()='Add to cart']");
    private By buttonClose = By.xpath("//button[@aria-label='Close']//span");
    private By messageSuccess = By.xpath("//h3[normalize-space()='Item added to your cart!']");
    private By totalProductInCart = By.xpath("(//div[@id='cart_items']//span[normalize-space()='Cart']/parent::span//span)[1]");
    private By lastestProduct = By.xpath("(//div[@id='section_newest']//div[@class='position-relative'])[1]");

    public void addProductToCart() {
        WebUI.scrollToElementAtTop(titleNewProduct);
        WebUI.moveToElement(addFirstProductToCart);
        WebUI.clickElement(addFirstProductToCart);
        WebUI.sleep(1);
        WebUI.clickElement(buttonAddToCart);
        WebUI.sleep(1);
        WebUI.assertContains(WebUI.getElementText(messageSuccess), "Item added to your cart!", "Add to cart fail");
        WebUI.clickElement(buttonClose);
        WebUI.sleep(1);
        WebUI.moveToElement(addSecondProductToCart);
        WebUI.clickElement(addSecondProductToCart);
        WebUI.sleep(1);
        WebUI.clickElement(buttonAddToCart);
        WebUI.assertContains(WebUI.getElementText(messageSuccess), "Item added to your cart!", "Add to cart fail");
        WebUI.clickElement(buttonClose);
        WebUI.assertEquals(WebUI.getElementText(totalProductInCart), "2", "Add two product to cart");
    }

    public ProductPage clickLatestProduct() {
        WebUI.waitForPageLoaded();
        WebUI.scrollToElement(lastestProduct);
        WebUI.clickElement(lastestProduct);
        return new ProductPage();
    }
}

package com.nanon.FinalProject.pages;

import com.nanon.keywords.WebUI;
import com.nanon.utils.LogUtils;
import org.openqa.selenium.By;

public class CartPage extends BasePage {
    private By formShipInfo = By.xpath("(//form[@data-toggle='validator']//span[normalize-space()='Address:'])[1]");
    private By buttonContinueDelivery = By.xpath("//button[normalize-space()='Continue to Delivery Info']");
    private By buttonContnueToPayment = By.xpath("//button[normalize-space()='Continue to Payment']");
    private By namefirstName = By.xpath("(//tbody/tr[@class='cart_item'])[1]//td[@class='product-name']");
    private By namesecondName = By.xpath("(//tbody/tr[@class='cart_item'])[2]//td[@class='product-name']");
    private By totalFirstName = By.xpath("(//tbody/tr[@class='cart_item'])[1]//td[@class='product-total text-right']//span");
    private By totalSecondName = By.xpath("(//tbody/tr[@class='cart_item'])[2]//td[@class='product-total text-right']//span");
    private By subtotal = By.xpath("//tr[@class='cart-subtotal']//span");
    private By totalTax = By.xpath("//tr[@class='cart-shipping']//th[normalize-space()='Tax']//following-sibling::td//span");
    private By totalShipping = By.xpath("//tr[@class='cart-shipping']//th[normalize-space()='Total Shipping']//following-sibling::td//span");
    private By totalSummary = By.xpath("//tr[@class='cart-total']//th[normalize-space()='Total']//following-sibling::td//span");
    private By countFirstProduct = By.xpath("(//tbody/tr[@class='cart_item'])[1]//td[@class='product-name']//strong");
    private By countSecondProduct = By.xpath("(//tbody/tr[@class='cart_item'])[2]//td[@class='product-name']//strong");
    private By buttonCompleteOrder = By.xpath("//button[normalize-space()='Complete Order']");
    private By checkboxPolicy = By.xpath("//span[normalize-space()='I agree to the']");
    private By messageSuccess = By.xpath("//span[normalize-space()='Your order has been placed successfully']");

    public void CheckOut() {
        WebUI.waitForPageLoaded();
        WebUI.sleep(1);
        WebUI.clickElement(formShipInfo);
        WebUI.scrollToElement(buttonContinueDelivery);
        WebUI.clickElement(buttonContinueDelivery);
        WebUI.sleep(1);
        WebUI.scrollToElement(buttonContnueToPayment);
        WebUI.clickElement(buttonContnueToPayment);
        WebUI.sleep(1);
        WebUI.scrollToElement(buttonCompleteOrder);
        LogUtils.info("Name First Product: " + WebUI.getElementText(namefirstName));
        LogUtils.info("Price First Product: " + WebUI.getElementText(totalFirstName));
        LogUtils.info("Name Second Product: " + WebUI.getElementText(namesecondName));
        LogUtils.info("Price Second Product: " + WebUI.getElementText(totalSecondName));
        WebUI.assertTrue(WebUI.getElementText(totalFirstName), "$138,000.00", "Price not match");
        WebUI.assertTrue(WebUI.getElementText(totalSecondName), "$138,000.00", "Price not match");
        int firstProductCount = Integer.parseInt(WebUI.getElementText(countFirstProduct).replaceAll("[^0-9]", ""));
        int secondProdcutCount = Integer.parseInt(WebUI.getElementText(countSecondProduct).replaceAll("[^0-9]", ""));
        int sub = (Integer.parseInt(WebUI.getElementText(totalFirstName).replaceAll("[^0-9]", "")) * firstProductCount + Integer.parseInt(WebUI.getElementText(totalSecondName).replaceAll("[^0-9]", "")) * secondProdcutCount) / 100;
        WebUI.assertEquals(sub, (Integer.parseInt(WebUI.getElementText(subtotal).replaceAll("[^0-9]", ""))) / 100, "Subtotal wrong");
        int totalCount = firstProductCount + secondProdcutCount;
        LogUtils.info("Total Count: " + totalCount);
        WebUI.assertEquals((totalCount * 5000), (Integer.parseInt(WebUI.getElementText(totalTax).replaceAll("[^0-9]", ""))) / 100, "Total tax wrong");
        WebUI.assertEquals(WebUI.getElementText(totalShipping), "$30,000.00", "Total Shingpping wrong");
        int Total = sub + totalCount * 5000 + 30000;
        WebUI.assertEquals(Total, (Integer.parseInt(WebUI.getElementText(totalSummary).replaceAll("[^0-9]", ""))) / 100, "Total Summary wrong");
        WebUI.clickElement(checkboxPolicy);
        WebUI.clickElement(buttonCompleteOrder);
        WebUI.assertContains(WebUI.getElementText(messageSuccess), "Your order has been placed successfully", "Check out fail");
    }
}

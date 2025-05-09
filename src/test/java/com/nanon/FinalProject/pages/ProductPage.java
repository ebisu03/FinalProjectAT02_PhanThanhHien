package com.nanon.FinalProject.pages;

import com.nanon.helpers.ExcelHelper;
import com.nanon.keywords.WebUI;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {


    private By nameProduct = By.xpath("//h1[normalize-space()='Cosy Thanh 2025/03/27-12:16:18 OML']");
    private By sizeProduct = By.xpath("//span[normalize-space()='22']");
    private By avaiableQuantity = By.xpath("//span[@id='available-quantity']");
    private By totalPrice = By.xpath("//strong[@id='chosen_price']");
    private By descriptionProduct = By.xpath("//p[contains(text(),'Buy Cozy Seed Butter Cookies 336g paper box (TET T')]");

    private By nameLastestProduct = By.xpath("//h1[normalize-space()='Nanon Cosy']");
    private By priceLatestProduct = By.xpath("(//h1[normalize-space()='Nanon Cosy']/parent::div//strong)[1]");
    private By miniumPurchaseLatestProduct = By.xpath("//input[@placeholder='1']");
    private By quantityAvailableLatestProduct = By.xpath("//span[@id='available-quantity']");
    private By unit = By.xpath("//span[@class='opacity-70']");
    private By descriptionLatestProduct = By.xpath("//div[@id='tab_default_1']");

    public void getDataProductToExcel(int row) {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataProduct.xlsx", "Sheet1");
        excelHelper.setCellData(WebUI.getElementText(nameProduct), 0, row);
        excelHelper.setCellData(WebUI.getElementText(sizeProduct), 1, row);
        excelHelper.setCellData(WebUI.getElementText(avaiableQuantity), 2, row);
        excelHelper.setCellData(WebUI.getElementText(totalPrice), 3, row);
        excelHelper.setCellData(WebUI.getElementText(descriptionProduct), 4, row);

    }

    public void CheckDetailLatestProduct() {
        WebUI.waitForPageLoaded();
        WebUI.assertContains(WebUI.getElementText(nameLastestProduct), "Nanon Cosy", "Name Latest Product not match");
        WebUI.assertContains(WebUI.getElementText(priceLatestProduct), "$143,000.00", "Price Latest Product not match");
        WebUI.assertContains(WebUI.getElementAttribute(miniumPurchaseLatestProduct, "value"), "1", "Minium Purchase Latest Product not match");
        WebUI.assertContains(WebUI.getElementText(quantityAvailableLatestProduct), "30", " Quantity Available Product not match");
        WebUI.assertContains(WebUI.getElementText(unit), "/KG", "Unit Latest Product not match");
        WebUI.assertContains(WebUI.getElementText(descriptionLatestProduct), "This is Nanon Cosy", "Descrptioin Latest Product not match");
    }


    //-----------------------------------------------
    //Hàm và biến dành cho Admin
    private By inputProductName = By.xpath("//input[@placeholder='Product Name']");
    private By dropdownCategory = By.xpath("//button[@title='Sport shoes']");
    private By optionCategory = By.xpath("//span[normalize-space()='Sport shoes']");
    private By dropdownBrand = By.xpath("//div[contains(text(),'Select Brand')]");
    private By optionBrand = By.xpath("//a[@id='bs-select-2-1']//span[@class='text'][normalize-space()='MiuMiu']");
    private By inputUnit = By.xpath("//input[@placeholder='Unit (e.g. KG, Pc etc)']");
    private By inputMiniumPucharse = By.xpath("//input[@name='min_qty']");
    private By inputTag = By.xpath("//tags[@role='tagslist']");
    private By buttonChooseFileGallery = By.xpath("//div[@data-multiple='true']//div[@class='form-control file-amount'][normalize-space()='Choose File']");
    private By imgLastest = By.xpath("(//div[@id='aiz-select-file']//img)[1]");
    private By buttonAddFile = By.xpath("//button[normalize-space()='Add Files']");
    private By buttonChooseThumbnail = By.xpath("//small[normalize-space()='(300x300)']/parent::label//following-sibling::div//div[normalize-space()='Choose File']");
    private By inputUnitPrice = By.xpath("//input[@placeholder='Unit price']");
    private By inputDiscountDate = By.xpath("//input[@placeholder='Select Date']");
    private By inputDiscount = By.xpath("//input[@placeholder='Discount']");
    private By inputQuantity = By.xpath("//input[@placeholder='Quantity']");
    private By textareaDescription = By.xpath("//div[@role='textbox']");
    private By buttonSaveAndPublish = By.xpath("//button[normalize-space()='Save & Publish']");
    private By messageSuccess = By.xpath("//span[normalize-space()='Product has been inserted successfully']");
    private By titleProductImage = By.xpath("//h5[normalize-space()='Product Images']");

    public void AddNewProduct() {
        WebUI.waitForPageLoaded();
        WebUI.clearText(inputProductName);
        WebUI.setText(inputProductName, "Nanon Cosy");
        WebUI.clickElement(dropdownCategory);
        WebUI.sleep(1);
        WebUI.clickElement(optionCategory);
        WebUI.clickElement(dropdownBrand);
        WebUI.sleep(1);
        WebUI.clickElement(optionBrand);
        WebUI.clearText(inputUnit);
        WebUI.setText(inputUnit, "KG");
        WebUI.clearText(inputMiniumPucharse);
        WebUI.setText(inputMiniumPucharse, "1");
        WebUI.scrollToElement(titleProductImage);
        WebUI.setText(inputTag, "Nanon Cosy");
        WebUI.clickElement(buttonChooseFileGallery);
        WebUI.sleep(1);
        WebUI.clickElement(imgLastest);
        WebUI.clickElement(buttonAddFile);
        WebUI.sleep(1);
        WebUI.clickElement(buttonChooseThumbnail);
        WebUI.sleep(1);
        WebUI.clickElement(imgLastest);
        WebUI.clickElement(buttonAddFile);
        WebUI.sleep(1);
        WebUI.scrollToElementAtTop(inputUnitPrice);
        WebUI.clearText(inputUnitPrice);
        WebUI.setText(inputUnitPrice, "143000");
        WebUI.clearText(inputDiscountDate);
        WebUI.setText(inputDiscountDate, "02-05-2025 00:00:00 to 08-05-2025 23:59:00");
        WebUI.clearText(inputDiscount);
        WebUI.setText(inputDiscount, "0");
        WebUI.clearText(inputQuantity);
        WebUI.setText(inputQuantity, "30");
        WebUI.clearText(textareaDescription);
        WebUI.setText(textareaDescription, "This is Nanon Cosy");
        WebUI.clickElement(buttonSaveAndPublish);
        WebUI.assertContains(WebUI.getElementText(messageSuccess), "Product has been inserted successfully", "Add not success");

    }


}

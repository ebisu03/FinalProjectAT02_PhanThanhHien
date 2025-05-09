package com.nanon.FinalProject.pages;


import com.nanon.keywords.WebUI;
import org.openqa.selenium.By;

public class ProfilePage extends BasePage {

    private By inputName = By.xpath("//input[@placeholder='Your name']");
    private By inputPhone = By.xpath("//input[@placeholder='Your Phone']");
    private By inputPassword = By.xpath("//input[@placeholder='New Password']");
    private By inputConfirmPassword = By.xpath("//input[@placeholder='Confirm Password']");
    private By iconRemove = By.xpath("//div[@class='remove']//i");
    private By chooseFile = By.xpath("//div[@class='form-control file-amount']");
    private By uploadNew = By.xpath("//a[normalize-space()='Upload New']");
    private By buttonBrowse = By.xpath("//button[normalize-space()='Browse']");
    private By buttonAddFile = By.xpath("//button[normalize-space()='Add Files']");
    private By imgLastest = By.xpath("(//div[@id='aiz-select-file']//img)[1]");
    private By nameImage = By.xpath("//h6//span[@class='text-truncate title'][1]");
    private By buttonUpdateProfile = By.xpath("//button[normalize-space()='Update Profile']");
    private By successmessage = By.xpath("//div[@role='alert']//span");

    public void UpdateProfileSuccess(String filePath, String nameImg) {
        WebUI.waitForPageLoaded();
        WebUI.scrollToElement(buttonUpdateProfile);
        WebUI.clearText(inputName);
        WebUI.setText(inputName, "Nanon");
        WebUI.clearText(inputPhone);
        WebUI.setText(inputPhone, "012345678");
        WebUI.clickElement(iconRemove);
        WebUI.clickElement(chooseFile);
//        Upload ảnh từ ổ đĩa máy tính
//        WebUI.clickElement(uploadNew);
//        WebUI.uploadFileWithRobotClass(buttonBrowse, filePath);
//        WebUI.clickElement(buttonAddFile);
//        WebUI.clickElement(chooseFile);
        WebUI.sleep(2);
        WebUI.clickElement(imgLastest);
        WebUI.clickElement(buttonAddFile);
        WebUI.sleep(1);
        WebUI.assertContains(WebUI.getElementText(nameImage), nameImg, "Upload file not successful");
        WebUI.clickElement(buttonUpdateProfile);
        WebUI.assertContains(WebUI.getElementText(successmessage), "Your Profile has been updated successfully!", "Update not successful");

    }
}

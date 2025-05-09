package com.nanon.FinalProject.pages;

import com.nanon.helpers.PropertiesHelper;
import com.nanon.keywords.WebUI;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    //Khai báo các element dạng đối tượng tìm kiếm By
    private final By inputEmail = By.xpath("//input[@id='email']");
    private final By inputPassword = By.xpath("//input[@id='password']");
    private final By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private final By errorMessage = By.xpath("//span[normalize-space()='Invalid login credentials']");

    public void clickLoginButton() {
        WebUI.clickElement(buttonLogin);
    }

    public void verifyLoginSuccess() {
        WebUI.assertNotContains(WebUI.getCurrentUrl(), "login", "Login Fail");
    }

    public void verifyLoginFail() {
        WebUI.assertContains(WebUI.getCurrentUrl(), "login", "Login Sucess");
        WebUI.assertEquals(WebUI.getWebElement(errorMessage).getText(), "Invalid login credentials", "Error message not display");
    }

    public void loginCRM(String email, String password) {
        WebUI.openURL(PropertiesHelper.getValue("URL"));
        WebUI.waitForPageLoaded();
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
    }

    public DashboardPage loginCRM() {
        WebUI.openURL(PropertiesHelper.getValue("URL"));
        WebUI.waitForPageLoaded();
        WebUI.setText(inputEmail, "customer@example.com");
        WebUI.setText(inputPassword, "123456");
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        return new DashboardPage();
    }

    //-----------------------------------------------
    //Hàm dành cho Admin
    private By avatarAdmin = By.xpath("//span[@class='d-flex align-items-center']");
    private By buttonLogout = By.xpath("//span[normalize-space()='Logout']");

    public DashboardPage loginAdminCRM() {
        WebUI.openURL(PropertiesHelper.getValue("URL"));
        WebUI.waitForPageLoaded();
        WebUI.setText(inputEmail, "admin@example.com");
        WebUI.setText(inputPassword, "123456");
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        return new DashboardPage();
    }

    public void logoutAdminCRM() {
        WebUI.clickElement(avatarAdmin);
        WebUI.sleep(1);
        WebUI.clickElement(buttonLogout);
    }

}

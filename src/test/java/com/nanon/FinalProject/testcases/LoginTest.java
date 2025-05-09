package com.nanon.FinalProject.testcases;

import com.nanon.FinalProject.pages.LoginPage;
import com.nanon.common.BaseTest;
import com.nanon.dataproviders.DataProviderFactory;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @Feature("Login")
    @Story("LoginWithInvalidEmail")
    @Owner("Hien")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test login funtion with invalid email")
    @Test()
    public void LoginFailWithInvalidEmail() {
        loginPage = new LoginPage();
        loginPage.loginCRM("hien@gmail.com", "123456");
        loginPage.verifyLoginFail();
    }

    @Feature("Login")
    @Story("LoginWithInvalidPassword")
    @Owner("Hien")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test login funtion with invalid password")
    @Test()
    public void LoginFailWithInvalidPassword() {
        loginPage = new LoginPage();
        loginPage.loginCRM("hien@gmail.com", "1234");
        loginPage.verifyLoginFail();
    }

    @Feature("LoginUser")
    @Story("LoginSuccess")
    @Owner("Hien")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test login funtion with valid email and password")
    @Test(dataProvider = "data_provider_login_hashtable", dataProviderClass = DataProviderFactory.class)
    public void LoginSuccess(Hashtable<String, String> data) {
        loginPage = new LoginPage();
        loginPage.loginCRM(data.get("Email"), data.get("Password"));
        loginPage.verifyLoginSuccess();
    }

}

package com.nanon.FinalProject.testcases;

import com.nanon.FinalProject.pages.CartPage;
import com.nanon.FinalProject.pages.DashboardPage;
import com.nanon.FinalProject.pages.HomePage;
import com.nanon.FinalProject.pages.LoginPage;
import com.nanon.common.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    HomePage homePage = new HomePage();
    CartPage cartPage;

    @Feature("Checkout")
    @Story("CheckoutSuccess")
    @Owner("Hien")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test checkout funtion")
    @Test()
    public void CheckoutSuccess() {
        dashboardPage = loginPage.loginCRM();
        homePage = dashboardPage.clickMenuHomePage();
        homePage.addProductToCart();
        cartPage = homePage.clickIconCart();
        cartPage.CheckOut();

    }
}

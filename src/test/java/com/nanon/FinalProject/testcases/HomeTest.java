package com.nanon.FinalProject.testcases;

import com.nanon.FinalProject.pages.DashboardPage;
import com.nanon.FinalProject.pages.HomePage;
import com.nanon.FinalProject.pages.LoginPage;
import com.nanon.common.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    HomePage homePage;

    @Feature("AddProductToCart")
    @Owner("Hien")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test add product to cart funtion")
    @Test()
    public void addProductToCart() {
        dashboardPage = loginPage.loginCRM();
        homePage = dashboardPage.clickMenuHomePage();
        homePage.addProductToCart();
    }
}

package com.nanon.FinalProject.testcases;

import com.nanon.FinalProject.pages.DashboardPage;
import com.nanon.FinalProject.pages.HomePage;
import com.nanon.FinalProject.pages.LoginPage;
import com.nanon.FinalProject.pages.ProductPage;
import com.nanon.common.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    HomePage homePage = new HomePage();
    ProductPage productPage;

    @Feature("DetailProduct")
    @Story("Set data product to excel")
    @Owner("Hien")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test set data product to excel funtion")
    @Test()
    public void setDataProductToExcel() {
        dashboardPage = loginPage.loginCRM();
        productPage = dashboardPage.clickDetailProduct("Cosy Thanh 2025/03/27-12:16:18 OML");
        productPage.getDataProductToExcel(1);
    }

    //Hàm test cho Admni
    @Feature("AddNewProduct")
    @Owner("Hien")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test add new product funtion")
    @Test()
    public void addNewAProduct() {
        dashboardPage = loginPage.loginAdminCRM();
        productPage = dashboardPage.clickMenuAddNewProduct();
        productPage.AddNewProduct();
    }

    @Feature("CheckDetailNewAddProduct")
    @Owner("Hien")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test detail new add product funtion")
    @Test()
    public void CheckDetailNewAddProduct() {
        dashboardPage = loginPage.loginCRM();
        homePage = dashboardPage.clickMenuHomePage();
        productPage = homePage.clickLatestProduct();
        productPage.CheckDetailLatestProduct();

    }
}

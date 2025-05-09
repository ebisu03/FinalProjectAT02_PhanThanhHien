package com.nanon.FinalProject.testcases;

import com.nanon.FinalProject.pages.DashboardPage;
import com.nanon.FinalProject.pages.LoginPage;
import com.nanon.FinalProject.pages.ProfilePage;
import com.nanon.common.BaseTest;
import com.nanon.helpers.SystemHelper;
import com.nanon.utils.LogUtils;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    ProfilePage profilePage;

    @Feature("ManageProfile")
    @Story("UpdateProfile")
    @Owner("Hien")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test update profile funtion")
    @Test()
    public void UpdateProfile() {
        dashboardPage = loginPage.loginCRM();
        profilePage = dashboardPage.clickMenuManageProfile();
        String filePath = SystemHelper.getCurrentDir() + "src\\test\\resources\\testdata\\nanon.webp";
        LogUtils.info(filePath);
        profilePage.UpdateProfileSuccess(filePath, "nanon");
    }
}

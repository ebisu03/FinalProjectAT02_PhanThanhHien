package com.nanon.common;

import com.nanon.drivers.DriverManager;
import com.nanon.helpers.CaptureHelper;
import com.nanon.helpers.PropertiesHelper;
import com.nanon.listeners.TestListener;
import com.nanon.utils.LogUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;

@Listeners(TestListener.class)
public class BaseTest {
    @BeforeSuite
    public void setupEnvironment()
    {
        PropertiesHelper.loadAllFiles();
    }
    @BeforeMethod
    @Parameters({"browser"})
    @Step("Run with browser {0}")
    public void createDriver(@Optional("edge") String browser){
        WebDriver driver;
        if(PropertiesHelper.getValue("BROWSER").isEmpty()||PropertiesHelper.getValue("BROWSER").isBlank())
        {
            browser=browser;
        }else{
            browser=PropertiesHelper.getValue("BROWSER");
        }
        switch (browser) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();

                // Chạy chế độ ẩn danh
                options.addArguments("--incognito");

                // Tắt thông báo lưu mật khẩu & cảnh báo rò rỉ
                options.addArguments("--disable-save-password-bubble");
                options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "load-extension"));

                // Tắt Password Manager của Chrome
                HashMap<String, Object> prefs = new HashMap<>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                options.setExperimentalOption("prefs", prefs);

                driver = new ChromeDriver(options);
                LogUtils.info("Khởi chạy trình duyệt Chrome ở chế độ ẩn danh...");
                break;
            case "edge":
                driver=new EdgeDriver();
                LogUtils.info("Khởi chạy trình duyệt Edge ....");
                break;
            case "safari":
                driver=new SafariDriver();
                LogUtils.info("Khởi chạy trình duyệt Safari ....");
                break;
            case "firefox":
                driver=new FirefoxDriver();
                LogUtils.info("Khởi chạy trình duyệt FireFox ....");
                break;
            default:
                driver=new ChromeDriver();
                LogUtils.info("Khởi chạy trình duyệt Chrome mặc định ....");
                break;
        }
        DriverManager.setDriver(driver);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    }
    @AfterMethod
    @Step("Closed browser")
    public void closeDriver(){
        CaptureHelper.stopRecord();
        if(DriverManager.getDriver()!=null)
            DriverManager.getDriver().quit();

    }


}

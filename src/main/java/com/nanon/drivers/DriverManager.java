package com.nanon.drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private final static ThreadLocal<WebDriver> driver=new ThreadLocal<>();
    private DriverManager(){}
    public static WebDriver getDriver(){
        return driver.get();
    }
    public static void setDriver(WebDriver driver){
        DriverManager.driver.set(driver);
    }
    public static void quit(){
        DriverManager.driver.get().quit();
        driver.remove();
    }

}

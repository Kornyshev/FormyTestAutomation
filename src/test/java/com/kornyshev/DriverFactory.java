package com.kornyshev;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver create() {
        String path = "C:\\Projects\\FormyTestAutomation\\src\\test\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        return new ChromeDriver();
    }

    public static WebDriver createWithParams(boolean max, boolean wait) {
        WebDriver driver = create();
        if (max) {
            driver.manage().window().maximize();
        }
        if (wait) {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return driver;
    }
}
package com.kornyshev.tests;

import com.kornyshev.DriverFactory;
import com.kornyshev.pages.MainPage;
import com.kornyshev.pages.SwitchWindowPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SwitchWindowPageTest {

    WebDriver driver;
    SwitchWindowPage switchWindowPage;

    @BeforeClass
    @Parameters("mainUrl")
    public void setUp(String mainUrl) {
        driver = DriverFactory.createWithParams(true, true);
        driver.get(mainUrl);
        new MainPage(driver).switchWindowPageLink.click();
        switchWindowPage = new SwitchWindowPage(driver);
    }

    @Test(priority = 0)
    public void testMethod() {

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
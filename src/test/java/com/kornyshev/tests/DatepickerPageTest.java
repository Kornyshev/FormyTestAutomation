package com.kornyshev.tests;

import com.kornyshev.DriverFactory;
import com.kornyshev.pages.DatepickerPage;
import com.kornyshev.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DatepickerPageTest {

    WebDriver driver;
    DatepickerPage datepickerPage;

    @BeforeClass
    @Parameters("mainUrl")
    public void setUp(String mainUrl) {
        driver = DriverFactory.createWithParams(true, true);
        driver.get(mainUrl);
        new MainPage(driver).datepickerPageLink.click();
        datepickerPage = new DatepickerPage(driver);
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
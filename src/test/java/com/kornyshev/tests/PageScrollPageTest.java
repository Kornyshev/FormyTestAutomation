package com.kornyshev.tests;

import com.kornyshev.DriverFactory;
import com.kornyshev.pages.MainPage;
import com.kornyshev.pages.PageScrollPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PageScrollPageTest {

    WebDriver driver;
    PageScrollPage pageScrollPage;

    @BeforeClass
    @Parameters("mainUrl")
    public void setUp(String mainUrl) {
        driver = DriverFactory.createWithParams(true, true);
        driver.get(mainUrl);
        new MainPage(driver).scrollPageLink.click();
        pageScrollPage = new PageScrollPage(driver);
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
package com.kornyshev.tests;

import com.kornyshev.DriverFactory;
import com.kornyshev.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MainPageTest {

    WebDriver driver;
    MainPage mainPage;

    @BeforeClass
    @Parameters("mainUrl")
    public void setUp(String mainUrl) {
        driver = DriverFactory.createWithParams(true, true);
        driver.get(mainUrl);
        mainPage = new MainPage(driver);
    }

    @Test(priority = 0)
    public void testMainHeader() {
        String expectedHeader = "Welcome to Formy";
        assertEquals(mainPage.getMainHeaderTest(), expectedHeader);
    }

    @Test(priority = 10)
    public void testAnotherHeader() {
        String expectedHeader = "This is a simple site that has form components that can be used for testing purposes.";
        assertEquals(mainPage.getSecondHeaderTest(), expectedHeader);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
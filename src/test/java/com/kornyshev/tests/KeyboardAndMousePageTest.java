package com.kornyshev.tests;

import com.kornyshev.DriverFactory;
import com.kornyshev.pages.KeyAndMousePage;
import com.kornyshev.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class KeyboardAndMousePageTest {

    WebDriver driver;
    KeyAndMousePage keyAndMousePage;

    @BeforeClass
    @Parameters("mainUrl")
    public void setUp(String mainUrl) {
        driver = DriverFactory.createWithParams(true, true);
        driver.get(mainUrl);
        new MainPage(driver).keyAndMousePageLink.click();
        keyAndMousePage = new KeyAndMousePage(driver);
    }

    @Test(priority = 0)
    public void testMainHeader() {
        String expectedHeader = "Keyboard and Mouse Input";
        assertEquals(keyAndMousePage.getMainHeaderText(), expectedHeader);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
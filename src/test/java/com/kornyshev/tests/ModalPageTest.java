package com.kornyshev.tests;

import com.kornyshev.DriverFactory;
import com.kornyshev.pages.MainPage;
import com.kornyshev.pages.ModalPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ModalPageTest {

    WebDriver driver;
    ModalPage modalPage;

    @BeforeClass
    @Parameters("mainUrl")
    public void setUp(String mainUrl) {
        driver = DriverFactory.createWithParams(true, true);
        driver.get(mainUrl);
        new MainPage(driver).modalPageLink.click();
        modalPage = new ModalPage(driver);
    }

    @Test(priority = 0)
    public void testMainHeader() {
        String expectedHeader = "Modal";
        assertEquals(modalPage.getMainHeaderText(), expectedHeader);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
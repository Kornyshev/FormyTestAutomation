package com.kornyshev.tests;

import com.kornyshev.DriverFactory;
import com.kornyshev.pages.EnabledAndDisabledElementsPage;
import com.kornyshev.pages.MainPage;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EnabledAndDisabledElementsPageTest {

    WebDriver driver;
    EnabledAndDisabledElementsPage enabledAndDisabledElementsPage;

    @BeforeClass
    @Parameters("mainUrl")
    public void setUp(String mainUrl) {
        driver = DriverFactory.createWithParams(true, true);
        driver.get(mainUrl);
        new MainPage(driver).enabledAndDisabledPageLink.click();
        enabledAndDisabledElementsPage = new EnabledAndDisabledElementsPage(driver);
    }

    @Test(priority = 0)
    public void testMainHeader() {
        String expectedHeader = "Enabled and Disabled elements";
        assertEquals(enabledAndDisabledElementsPage.getMainHeaderText(), expectedHeader);
    }

    @Test(priority = 10, expectedExceptions = ElementNotInteractableException.class)
    public void testDisabledField() {
        enabledAndDisabledElementsPage.setDisabledField("Test");
    }

    @Test(priority = 20)
    public void testEnabledField() {
        enabledAndDisabledElementsPage.setEnabledField("Test");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
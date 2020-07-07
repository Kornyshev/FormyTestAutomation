package com.kornyshev.tests;

import com.kornyshev.DriverFactory;
import com.kornyshev.pages.ButtonsPage;
import com.kornyshev.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ButtonsPageTest {

    WebDriver driver;
    ButtonsPage buttonsPage;

    @BeforeClass
    @Parameters("mainUrl")
    public void setUp(String mainUrl) {
        driver = DriverFactory.createWithParams(true, true);
        driver.get(mainUrl);
        new MainPage(driver).buttonsPageLink.click();
        buttonsPage = new ButtonsPage(driver);
    }

    @Test(priority = 0)
    public void testPrimaryButtonVisibility() {
        assertTrue(buttonsPage.primaryButtonIsDisplayed());
    }

    @Test(priority = 10)
    public void testRemainingButtonsVisibility() {
        assertTrue(buttonsPage.remainingButtonsAreDisplayed());
    }

    @Test(priority = 20)
    public void testDropdownButtons() {
        buttonsPage.clickDropdownButton();
        assertTrue(buttonsPage.dropdownElementsAreDisplayed());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
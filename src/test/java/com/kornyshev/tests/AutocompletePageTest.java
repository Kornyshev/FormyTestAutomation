package com.kornyshev.tests;

import com.kornyshev.DriverFactory;
import com.kornyshev.pages.AutocompletePage;
import com.kornyshev.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AutocompletePageTest {

    WebDriver driver;
    AutocompletePage autocompletePage;

    @BeforeClass
    @Parameters("mainUrl")
    public void setUp(String mainUrl) {
        driver = DriverFactory.createWithParams(true, true);
        driver.get(mainUrl);
        new MainPage(driver).autocompletePageLink.click();
        autocompletePage = new AutocompletePage(driver);
    }

    @Test(priority = 0)
    public void testMainHeader() {
        String expectedHeader = "Autocomplete";
        assertEquals(autocompletePage.getMainHeader(), expectedHeader);
    }

    @Test(priority = 10)
    public void testAutocomplete() {
        String address = "Beverly Hills, CA 90210, USA";
        autocompletePage.autocompleteForm(address);
        assertTrue(true);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
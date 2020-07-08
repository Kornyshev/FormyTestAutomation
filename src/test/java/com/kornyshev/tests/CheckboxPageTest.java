package com.kornyshev.tests;

import com.kornyshev.DriverFactory;
import com.kornyshev.pages.CheckboxPage;
import com.kornyshev.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CheckboxPageTest {

    WebDriver driver;
    CheckboxPage checkboxPage;

    @BeforeClass
    @Parameters("mainUrl")
    public void setUp(String mainUrl) {
        driver = DriverFactory.createWithParams(true, true);
        driver.get(mainUrl);
        new MainPage(driver).checkboxPageLink.click();
        checkboxPage = new CheckboxPage(driver);
    }

    @Test(priority = 0)
    public void testMainHeader() {
        String expectedHeader = "Checkboxes";
        assertEquals(checkboxPage.getMainHeaderText(), expectedHeader);
    }

    @Test(priority = 10)
    public void testCheckboxesVisibility() {
        assertTrue(checkboxPage.checkboxesAreDisplayed());
    }

    @Test(priority = 20)
    public void testCheckbox1() {
        assertFalse(checkboxPage.isCheckbox1Selected());
        checkboxPage.setCheckbox1();
        assertTrue(checkboxPage.isCheckbox1Selected());
        checkboxPage.clickCheckbox1();
    }

    @Test(priority = 30)
    public void testAllCheckboxes() {
        assertFalse(checkboxPage.isCheckbox1Selected());
        assertFalse(checkboxPage.isCheckbox2Selected());
        assertFalse(checkboxPage.isCheckbox3Selected());
        checkboxPage.setCheckbox1();
        checkboxPage.setCheckbox2();
        checkboxPage.setCheckbox3();
        assertTrue(checkboxPage.isCheckbox1Selected());
        assertTrue(checkboxPage.isCheckbox2Selected());
        assertTrue(checkboxPage.isCheckbox3Selected());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
package com.kornyshev.tests;

import com.kornyshev.DriverFactory;
import com.kornyshev.pages.DatepickerPage;
import com.kornyshev.pages.DropdownPage;
import com.kornyshev.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DropdownPageTest {

    WebDriver driver;
    DropdownPage dropdownPage;
    DatepickerPage datepickerPage;

    @BeforeClass
    @Parameters("mainUrl")
    public void setUp(String mainUrl) {
        driver = DriverFactory.createWithParams(true, true);
        driver.get(mainUrl);
        new MainPage(driver).dropdownPageLink.click();
        dropdownPage = new DropdownPage(driver);
    }

    @Test(priority = 0)
    public void testMainHeader() {
        String expectedHeader = "Dropdown";
        assertEquals(dropdownPage.getMainHeaderText(), expectedHeader);
    }

    @Test(priority = 10)
    public void testDropdownMenuWork() throws InterruptedException {
        String expectedHeader = "Datepicker";
        dropdownPage.clickDropdownMenuButton();
        dropdownPage.clickMenuItem();
        Thread.sleep(3000);
        /*
        If I want to get rid of Thread.sleep, I should rewrite all methods
        which return text of Main Header and all their initializations -
        to replace them by explicit waiters. But I do not want. :)
         */
        datepickerPage = new DatepickerPage(driver);
        assertEquals(datepickerPage.getMainHeaderText(), expectedHeader);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
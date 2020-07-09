package com.kornyshev.tests;

import com.kornyshev.DriverFactory;
import com.kornyshev.pages.DragAndDropPage;
import com.kornyshev.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DragAndDropPageTest {

    WebDriver driver;
    DragAndDropPage dragAndDropPage;

    @BeforeClass
    @Parameters("mainUrl")
    public void setUp(String mainUrl) {
        driver = DriverFactory.createWithParams(true, true);
        driver.get(mainUrl);
        new MainPage(driver).dragAndDropPageLink.click();
        dragAndDropPage = new DragAndDropPage(driver);
    }

    @Test(priority = 0)
    public void testMainHeader() {
        String expectedHeader = "Drag the image into the box";
        assertEquals(dragAndDropPage.getMainHeaderText(), expectedHeader);
    }

    @Test(priority = 10)
    public void testBoxTextBeforeDrop() {
        String expectedText = "Drop here";
        assertEquals(dragAndDropPage.getBoxAreaText(), expectedText);
    }

    /*
    This test does not work correctly!!!
     */
    @Test(priority = 20)
    public void testBoxTextAfterDrop() {
        String expectedText = "Dropped!";
        dragAndDropPage.dragAndDrop();
        assertEquals(dragAndDropPage.getBoxAreaText(), expectedText);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
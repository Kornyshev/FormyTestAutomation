package com.kornyshev.tests;

import com.kornyshev.DriverFactory;
import com.kornyshev.pages.CompleteFormPage;
import com.kornyshev.pages.MainPage;
import com.kornyshev.pages.SuccessSubmittingPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class CompleteFormPageTest {

    WebDriver driver;
    CompleteFormPage completeFormPage;
    private String url;

    @BeforeClass
    @Parameters("mainUrl")
    public void setUp(String mainUrl) {
        driver = DriverFactory.createWithParams(true, true);
        driver.get(mainUrl);
        new MainPage(driver).completeFormPageLink.click();
        completeFormPage = new CompleteFormPage(driver);
        url = driver.getCurrentUrl();
    }

    @DataProvider(name = "FormInfo")
    public Object[][] getSomeData() {
        return new Object[][]{
                {"John", "Doe", "QA", "1", "08/07/2020"},
                {"Agent", "Smith", "PM", "4", "08/07/2020"}
        };
    }

    @Test(priority = 0)
    public void testMainHeader() {
        String expectedHeader = "Complete Web Form";
        assertEquals(completeFormPage.getMainHeaderText(), expectedHeader);
    }

    @Test(priority = 10, expectedExceptions = IllegalArgumentException.class)
    public void testSelectIncorrectNumber() {
        completeFormPage.setExperienceSelect("7");
    }

    @Test(priority = 20, expectedExceptions = NumberFormatException.class)
    public void testSelectNotNumber() {
        completeFormPage.setExperienceSelect("abc");
    }

    @Test(priority = 30, dataProvider = "FormInfo")
    public void testFormPopulation
            (String first, String last, String job, String n, String date) {
        if (!url.equalsIgnoreCase(driver.getCurrentUrl())) {
            driver.get(url);
        }
        String[] data = {first, last, job, n, date};
        completeFormPage.populateForm(data);
        SuccessSubmittingPage resultPage = new SuccessSubmittingPage(driver);
        String expectedAlert = "The form was successfully submitted!";
        assertEquals(resultPage.getSuccessAlertText(), expectedAlert);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
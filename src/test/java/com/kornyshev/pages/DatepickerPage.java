package com.kornyshev.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DatepickerPage extends Page {
    public DatepickerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='container']/child::h1")
    WebElement mainHeader;

    @FindBy(css = "#datepicker")
    WebElement datepickerField;

    public String getMainHeaderText() {
        return mainHeader.getText();
    }

    public void setDatepickerField(String s) {
        datepickerField.sendKeys(s);
        datepickerField.sendKeys(Keys.ENTER);
    }
}
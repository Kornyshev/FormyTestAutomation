package com.kornyshev.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnabledAndDisabledElementsPage extends Page {
    public EnabledAndDisabledElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='container']/child::h1")
    WebElement mainHeader;

    @FindBy(css = "#disabledInput")
    WebElement disabledField;

    @FindBy(css = "#input")
    WebElement enabledField;

    public String getMainHeaderText() {
        return mainHeader.getText();
    }

    public void setDisabledField(String s) {
        disabledField.sendKeys(s);
    }

    public void setEnabledField(String s) {
        enabledField.sendKeys(s);
    }
}
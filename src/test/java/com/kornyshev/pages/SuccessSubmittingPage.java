package com.kornyshev.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessSubmittingPage extends Page {
    public SuccessSubmittingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".alert.alert-success")
    WebElement successAlert;

    public String getSuccessAlertText() {
        return successAlert.getText();
    }
}

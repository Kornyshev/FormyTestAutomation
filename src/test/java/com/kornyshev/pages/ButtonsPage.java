package com.kornyshev.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends Page {
    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".btn.btn-lg.btn-primary")
    WebElement primaryButton;

    @FindBy(css = ".btn.btn-lg.btn-success")
    WebElement successButton;

    @FindBy(css = ".btn.btn-lg.btn-info")
    WebElement infoButton;

    @FindBy(css = ".btn.btn-lg.btn-warning")
    WebElement warningButton;

    @FindBy(css = ".btn.btn-lg.btn-danger")
    WebElement dangerButton;

    @FindBy(css = "#btnGroupDrop1")
    WebElement dropdownButton;

    @FindBy(xpath = "//a[contains(text(),'Dropdown link 1')]")
    WebElement dropdownElement1;

    @FindBy(xpath = "//a[contains(text(),'Dropdown link 2')]")
    WebElement dropdownElement2;

    public boolean primaryButtonIsDisplayed() {
        return primaryButton.isDisplayed();
    }

    public boolean remainingButtonsAreDisplayed() {
        return successButton.isDisplayed() &&
                infoButton.isDisplayed() &&
                warningButton.isDisplayed() &&
                dangerButton.isDisplayed();
    }

    public boolean dropdownElementsAreDisplayed() {
        return dropdownElement1.isDisplayed() && dropdownElement2.isDisplayed();
    }

    public void clickDropdownButton() {
        dropdownButton.click();
    }
}
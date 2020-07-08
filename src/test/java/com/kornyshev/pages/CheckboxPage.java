package com.kornyshev.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckboxPage extends Page {
    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='container']/child::h1")
    WebElement mainHeader;

    @FindBy(css = "#checkbox-1")
    WebElement checkbox1;

    @FindBy(css = "#checkbox-2")
    WebElement checkbox2;

    @FindBy(css = "#checkbox-3")
    WebElement checkbox3;

    public String getMainHeaderText() {
        return mainHeader.getText();
    }

    public boolean checkboxesAreDisplayed() {
        return checkbox1.isDisplayed() && checkbox2.isDisplayed() && checkbox3.isDisplayed();
    }

    public void setCheckbox1() {
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
    }

    public void setCheckbox2() {
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }
    }

    public void setCheckbox3() {
        if (!checkbox3.isSelected()) {
            checkbox3.click();
        }
    }

    public void clickCheckbox1() {
        checkbox1.click();
    }

    public void clickCheckbox2() {
        checkbox2.click();
    }

    public void clickCheckbox3() {
        checkbox3.click();
    }

    public boolean isCheckbox1Selected() {
        return checkbox1.isSelected();
    }

    public boolean isCheckbox2Selected() {
        return checkbox2.isSelected();
    }

    public boolean isCheckbox3Selected() {
        return checkbox3.isSelected();
    }
}
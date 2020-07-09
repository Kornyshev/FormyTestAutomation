package com.kornyshev.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModalPage extends Page {
    public ModalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='container']/child::h1")
    WebElement mainHeader;

    public String getMainHeaderText() {
        return mainHeader.getText();
    }
}
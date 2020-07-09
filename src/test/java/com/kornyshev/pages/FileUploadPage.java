package com.kornyshev.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends Page {
    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='container']/child::h1")
    WebElement mainHeader;

    @FindBy(css = "#file-upload-field")
    WebElement fileUploadField;

    public String getMainHeaderText() {
        return mainHeader.getText();
    }

    public void setFileUploadField(String s) {
        fileUploadField.sendKeys(s);
    }
}
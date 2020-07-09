package com.kornyshev.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends Page {
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='container']/child::h1")
    WebElement mainHeader;

    @FindBy(css = "#image")
    WebElement image;

    @FindBy(css = "#box")
    WebElement boxArea;

    public String getMainHeaderText() {
        return mainHeader.getText();
    }

    public String getBoxAreaText() {
        return boxArea.getText();
    }

    public void dragAndDrop() {
        new Actions(driver).dragAndDrop(image, boxArea).build().perform();
    }
}
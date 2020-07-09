package com.kornyshev.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropdownPage extends Page {
    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='container']/child::h1")
    WebElement mainHeader;

    @FindBy(css = "#dropdownMenuButton")
    WebElement dropdownMenuButton;

    /*
    Datepicker
     */
    @FindBy(css = ".dropdown-menu.show a:nth-child(4)")
    WebElement menuItemForTesting;

    public String getMainHeaderText() {
        return mainHeader.getText();
    }

    public void clickDropdownMenuButton() {
        dropdownMenuButton.click();
    }

    public void clickMenuItem() {
        menuItemForTesting.click();
    }
}
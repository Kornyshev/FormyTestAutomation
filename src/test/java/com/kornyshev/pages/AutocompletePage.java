package com.kornyshev.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutocompletePage extends Page {
    public AutocompletePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='container']/child::h1")
    WebElement mainHeader;

    @FindBy(css = "#autocomplete")
    WebElement addressEditField;

    @FindBy(css = ".pac-item")
    WebElement searchSuggestion;

    @FindBy(css = "input[placeholder='City']")
    WebElement cityField;

    @FindBy(css = "input[placeholder='State']")
    WebElement stateField;

    public String getMainHeader() {
        return mainHeader.getText();
    }

    public String getCityFieldText() {
        throw new UnsupportedOperationException();
    }

    public String getStateFieldText() {
        throw new UnsupportedOperationException();
    }

    public void sendAddressToField(String s) {
        addressEditField.sendKeys(s);
    }

    public void clickSearchSuggestion() {
        searchSuggestion.click();
    }

    public void autocompleteForm(String s) {
        this.sendAddressToField(s);
        if (!searchSuggestion.isDisplayed()) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            searchSuggestion = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pac-item")));
        }
        clickSearchSuggestion();
    }
}
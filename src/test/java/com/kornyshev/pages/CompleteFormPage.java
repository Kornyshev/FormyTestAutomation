package com.kornyshev.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CompleteFormPage extends Page {
    public CompleteFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='container']/child::h1")
    WebElement mainHeader;

    @FindBy(css = "#first-name")
    WebElement firstNameField;

    @FindBy(css = "#last-name")
    WebElement lastNameField;

    @FindBy(css = "#job-title")
    WebElement jobTitleField;

    @FindBy(css = "#radio-button-2")
    WebElement educationRadioButton;

    @FindBy(css = "#checkbox-1")
    WebElement sexCheckbox;

    @FindBy(css = "#select-menu")
    WebElement experienceSelect;

    @FindBy(css = "#datepicker")
    WebElement datepickerField;

    @FindBy(css = ".btn.btn-lg.btn-primary")
    WebElement submitButton;

    public String getMainHeaderText() {
        return mainHeader.getText();
    }

    public void setFirstNameField(String s) {
        firstNameField.sendKeys(s);
    }

    public void setLastNameField(String s) {
        lastNameField.sendKeys(s);
    }

    public void setJobTitle(String s) {
        jobTitleField.sendKeys(s);
    }

    public void setEducationRadioButton() {
        educationRadioButton.click();
    }

    public void setSexCheckbox() {
        sexCheckbox.click();
    }

    public void setExperienceSelect(String n) {
        if (Integer.parseInt(n) < 1 || Integer.parseInt(n) > 4) {
            throw new IllegalArgumentException();
        }
        Select select = new Select(experienceSelect);
        select.selectByValue(n);
    }

    public void setDatepickerField(String s) {
        datepickerField.sendKeys(s);
        datepickerField.sendKeys(Keys.ENTER);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void populateForm(String[] strings) {
        if (strings.length != 5) {
            throw new IllegalArgumentException();
        }
        setFirstNameField(strings[0]);
        setLastNameField(strings[1]);
        setJobTitle(strings[2]);
        setEducationRadioButton();
        setSexCheckbox();
        setExperienceSelect(strings[3]);
        setDatepickerField(strings[4]);
        clickSubmitButton();
    }
}
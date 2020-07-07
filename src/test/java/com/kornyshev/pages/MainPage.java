package com.kornyshev.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".display-3")
    WebElement mainHeader;

    @FindBy(css = ".lead")
    WebElement secondHeader;

    @FindBy(xpath = "//div[@class='jumbotron-fluid']/child::li[1]/a")
    public WebElement autocompletePageLink;

    @FindBy(xpath = "//div[@class='jumbotron-fluid']/child::li[2]/a")
    public WebElement buttonsPageLink;

    @FindBy(xpath = "//div[@class='jumbotron-fluid']/child::li[3]/a")
    public WebElement checkboxPageLink;

    @FindBy(xpath = "//div[@class='jumbotron-fluid']/child::li[4]/a")
    public WebElement completeFormPageLink;

    @FindBy(xpath = "//div[@class='jumbotron-fluid']/child::li[5]/a")
    public WebElement datepickerPageLink;

    @FindBy(xpath = "//div[@class='jumbotron-fluid']/child::li[6]/a")
    public WebElement dragAndDropPageLink;

    @FindBy(xpath = "//div[@class='jumbotron-fluid']/child::li[7]/a")
    public WebElement dropdownPageLink;

    @FindBy(xpath = "//div[@class='jumbotron-fluid']/child::li[8]/a")
    public WebElement enabledAndDisabledPageLink;

    @FindBy(xpath = "//div[@class='jumbotron-fluid']/child::li[9]/a")
    public WebElement fileUploadPageLink;

    @FindBy(xpath = "//div[@class='jumbotron-fluid']/child::li[10]/a")
    public WebElement keyAndMousePageLink;

    @FindBy(xpath = "//div[@class='jumbotron-fluid']/child::li[11]/a")
    public WebElement modalPageLink;

    @FindBy(xpath = "//div[@class='jumbotron-fluid']/child::li[12]/a")
    public WebElement scrollPageLink;

    @FindBy(xpath = "//div[@class='jumbotron-fluid']/child::li[13]/a")
    public WebElement radioButtonPageLink;

    @FindBy(xpath = "//div[@class='jumbotron-fluid']/child::li[14]/a")
    public WebElement switchWindowPageLink;

    public String getMainHeaderTest() {
        return mainHeader.getText();
    }

    public String getSecondHeaderTest() {
        return secondHeader.getText();
    }
}
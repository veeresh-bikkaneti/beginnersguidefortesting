package com.guide.beginners.testng.theinternet.frameworktestng.pages;

import org.openqa.selenium.By;

public class LoginPO {

    private By headerText = By.tagName("h2");
    private By formFieldUserName = By.cssSelector("input#username");
    private By formFieldPassword = By.cssSelector("input#password");
    private By submitButton = By.cssSelector("button.radius");
    private By homepageSuccessMessage = By.cssSelector("div#flash");
    private By homePgeHeader = By.tagName("h2");
    private By logoutButton = By.cssSelector("a.button.secondary.radius");

    public By getHeaderText() {
        return headerText;
    }

    public By getFormFieldUserName() {
        return formFieldUserName;
    }

    public By getFormFieldPassword() {
        return formFieldPassword;
    }

    public By getSubmitButton() {
        return submitButton;
    }

    public By getHomepageSuccessMessage() {
        return homepageSuccessMessage;
    }

    public By getHomePgeHeader() {
        return homePgeHeader;
    }

    public By getLogoutButton() {
        return logoutButton;
    }
}

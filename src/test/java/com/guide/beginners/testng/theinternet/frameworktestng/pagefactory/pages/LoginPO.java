package com.guide.beginners.testng.theinternet.frameworktestng.pagefactory.pages;

/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-02-2020
 * Time: 12:34 PM
 */

import org.openqa.selenium.By;

/*
declearing Page Objects as simple java object
 */
public class LoginPO {

    private By headerText = By.tagName("h2");
    private By formFieldUserName = By.cssSelector("input#username");
    private By formFieldPassword = By.cssSelector("input#password");
    private By loginButton = By.cssSelector("button.radius");
    private By failuremessage=By.cssSelector("#flash.error");

    public By getFailuremessage() {
        return failuremessage;
    }

    public By getHeaderText() {
        return headerText;
    }

    public By getFormFieldUserName() {
        return formFieldUserName;
    }

    public By getFormFieldPassword() {
        return formFieldPassword;
    }

    public By getLoginButton() {
        return loginButton;
    }


}

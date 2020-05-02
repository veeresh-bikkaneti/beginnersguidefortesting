package com.guide.beginners.testng.theinternet.frameworktestng.pagefactory.pageactions;

import com.guide.beginners.testng.theinternet.frameworktestng.pagefactory.BasePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-02-2020
 * Time: 01:09 PM
 */
public class LoginPage extends BasePageObject {
    private By headerText = By.tagName("h2");
    private By formFieldUserName = By.cssSelector("input#username");
    private By formFieldPassword = By.cssSelector("input#password");
    private By logInButton = By.cssSelector("button.radius");
    private By failuremessage=By.cssSelector("#flash.error");
    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Execute log in */
    public SecureAreaPage logIn(String username, String password) {
        logger.info("Executing LogIn with username [" + username + "] and password [" + password + "]");
        type(username, formFieldUserName);
        type(password, formFieldPassword);
        click(logInButton);
        return new SecureAreaPage(driver, logger);
    }


    public void negativeLogIn(String username, String password) {
        logger.info("Executing Negative LogIn with username [" + username + "] and password [" + password + "]");
        type(username, formFieldUserName);
        type(password, formFieldPassword);
        click(logInButton);
    }

    /** Wait for error message to be visible on the page */
    public void waitForErrorMessage() {
        waitForVisibilityOf(failuremessage, WAIT_FOR_ELE);
    }

    public String getErrorMessageText() {
        return find(failuremessage).getText();
    }

}

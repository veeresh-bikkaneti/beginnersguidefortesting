package com.guide.beginners.testng.theinternet.frameworktestng.testcases.usinglocators;
/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-02-2020
 * Time: 12:34 PM
 */


import com.guide.beginners.testng.theinternet.frameworktestng.hooks.HookupTests;
import com.guide.beginners.testng.theinternet.frameworktestng.pagefactory.pages.LoginPO;
import com.guide.beginners.testng.theinternet.frameworktestng.pagefactory.pages.SecureAreaPO;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


/*
Using Page locators in com.guide.beginners.testng.theinternet.frameworktestng.pagefactory.pages;
We are building the page objects here in the test class by referring the locators in pages.
 */
public class PositiveScenarioLoginPageValidation extends HookupTests {
    private LoginPO loginPO;
    private SecureAreaPO secureAreaPO;


    public PositiveScenarioLoginPageValidation() {
        this.loginPO = new LoginPO( );
        this.secureAreaPO=new SecureAreaPO();
    }

    @Parameters("url")
    @Test
    void validateCurrentURl(@Optional("https://the-internet.herokuapp.com/login") String aut) {
        assertThat(driver.getCurrentUrl( ).equalsIgnoreCase(aut));
    }

    @Parameters("url")
    @Test
    void validateFormFieldsAreVisible(@Optional("https://the-internet.herokuapp.com/login") String aut) {
        assertThat(driver.getCurrentUrl( ).equalsIgnoreCase(aut));
    }

    @Test
    void validateVisibilityOfHeader() {
        assertThat(getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(loginPO.getHeaderText( ))).isDisplayed( ));
    }

    @Test
    void validateVisbilityOfUserNameField() {
        assertThat(getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(loginPO.getFormFieldUserName( ))).isDisplayed( ));
    }

    @Test
    void validateVisbilityOfPasswordField() {
        assertThat(getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(loginPO.getFormFieldPassword( ))).isDisplayed( ));
    }

    @Test
    void validateVisbilityOfLoginButton() {
        assertThat(getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(loginPO.getLoginButton( ))).isDisplayed( ));
    }

    @Test
    void validateVisbilityOfHeaderText() {
        assertThat(getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(loginPO.getHeaderText( ))).getText( ).equalsIgnoreCase("Login Page"));
    }

    @Parameters({"username", "password", "successmessage", "h2"})
    @Test
    void validateLoginFunctionality(@Optional("tomsmith") String username, @Optional("SuperSecretPassword!") String password, @Optional("You logged into a secure area!") String expectedmessage, @Optional("Secure Area") String securearea) {
        logger.info("Entering UserName:" + username);
        logger.info("Entering password:" + password);
        driver.findElement(loginPO.getFormFieldUserName( )).sendKeys(username);
        driver.findElement(loginPO.getFormFieldPassword( )).sendKeys(password);
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(loginPO.getLoginButton( ))).click( );
        assertThat(getWebDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(secureAreaPO.getHomepageSuccessMessage( ), expectedmessage)));
        assertThat(getWebDriverWait().until(ExpectedConditions.textToBe(secureAreaPO.getHomePgeHeader( ), securearea)));
        assertThat(getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(secureAreaPO.getLogoutButton( ))).isDisplayed( ));
        driver.findElement(secureAreaPO.getLogoutButton( )).click( );
    }


}

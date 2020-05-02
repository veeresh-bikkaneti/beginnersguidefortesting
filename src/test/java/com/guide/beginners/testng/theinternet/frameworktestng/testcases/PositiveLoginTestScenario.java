package com.guide.beginners.testng.theinternet.frameworktestng.testcases;

import com.guide.beginners.testng.theinternet.frameworktestng.base.BaseTest;
import com.guide.beginners.testng.theinternet.frameworktestng.hooks.HookupTests;
import com.guide.beginners.testng.theinternet.frameworktestng.pages.LoginPO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositiveLoginTestScenario extends HookupTests {
    private LoginPO loginPO;

    public PositiveLoginTestScenario() {
        this.loginPO = new LoginPO( );
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
        assertThat(getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(loginPO.getSubmitButton( ))).isDisplayed( ));
    }

    @Test
    void validateVisbilityOfHeaderText() {
        assertThat(getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(loginPO.getHeaderText( ))).getText( ).equalsIgnoreCase("Login Page"));
    }

    @Parameters({"username", "password", "expectedmessage", "h2"})
    @Test
    void validateLoginFunctionality(@Optional("tomsmith") String username, @Optional("SuperSecretPassword!") String password, @Optional("You logged into a secure area!") String expectedmessage, @Optional("Secure Area") String securearea) {
        logger.info("Entering UserName:" + username);
        logger.info("Entering password:" + password);
        driver.findElement(loginPO.getFormFieldUserName( )).sendKeys(username);
        driver.findElement(loginPO.getFormFieldPassword( )).sendKeys(password);
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(loginPO.getSubmitButton( ))).click( );
        assertThat(getWebDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(loginPO.getHomepageSuccessMessage( ), expectedmessage)));
        assertThat(getWebDriverWait().until(ExpectedConditions.textToBe(loginPO.getHomePgeHeader( ), securearea)));
        assertThat(getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(loginPO.getLogoutButton( ))).isDisplayed( ));
        driver.findElement(loginPO.getLogoutButton( )).click( );
    }


}

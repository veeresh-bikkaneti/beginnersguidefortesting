package com.guide.beginners.testng.theinternet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class PositiveTest {
    private static Logger logger = LogManager.getLogger(PositiveTest.class.getName( ));
    private final long MAX_TIMEOUT = 20l;
    private WebDriver driver;
    private String aut = "https://the-internet.herokuapp.com/login";
    private By headerText = By.tagName("h2");
    private By formFieldUserName = By.cssSelector("input#username");
    private By formFieldPassword = By.cssSelector("input#password");
    private By submitButton = By.cssSelector("button[type='submit']");
    private String username = "tomsmith";
    private String password = "SuperSecretPassword!";

    @BeforeClass
    void startbroweser() {
        WebDriverManager.chromedriver( ).setup( );
        driver = new ChromeDriver( );
        driver.manage( ).timeouts( ).implicitlyWait(MAX_TIMEOUT, TimeUnit.SECONDS);
        logger.info("WebDriver Setup");
        if (Objects.isNull(driver)) {
            logger.throwing(Level.FATAL, new NullPointerException( ));
        }
    }

    @BeforeMethod
    void BeforeMethod() {
        driver.get(aut);
        driver.manage( ).timeouts( ).pageLoadTimeout(MAX_TIMEOUT, TimeUnit.SECONDS);
        driver.manage( ).timeouts( ).setScriptTimeout(MAX_TIMEOUT, TimeUnit.SECONDS);
        logger.info("launching aut:" + aut);
    }

    @Test
    void validateCurrentURl() {
        assertThat(driver.getCurrentUrl( ).equalsIgnoreCase(aut));
    }

    @Test
    void validateFormFieldsAreVisible() {
        assertThat(driver.getCurrentUrl( ).equalsIgnoreCase(aut));
    }

    @Test
    void validateVisibilityOfHeader() {
        assertThat(new WebDriverWait(driver, MAX_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(headerText)).isDisplayed( ));
    }

    @Test
    void validateVisbilityOfUserNameField() {
        assertThat(new WebDriverWait(driver, MAX_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(formFieldUserName)).isDisplayed( ));
    }

    @Test
    void validateVisbilityOfPasswordField() {
        assertThat(new WebDriverWait(driver, MAX_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(formFieldPassword)).isDisplayed( ));
    }

    @Test
    void validateVisbilityOfLoginButton() {
        assertThat(new WebDriverWait(driver, MAX_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(submitButton)).isDisplayed( ));
    }

    @Test
    void validateVisbilityOfHeaderText() {
        assertThat(new WebDriverWait(driver, MAX_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(headerText)).getText( ).equalsIgnoreCase("Login Page"));
    }

    @Test
    void validateLoginFunctionality() {
        new WebDriverWait(driver, MAX_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(formFieldUserName)).sendKeys(username);
        logger.info("Entering UserName:"+username);
        new WebDriverWait(driver, MAX_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(formFieldPassword)).sendKeys(password);
        logger.info("Entering password:"+password);
        new WebDriverWait(driver, MAX_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(submitButton)).click( );
    }

    @AfterMethod
    void validateSessionRest(){
        driver.navigate().refresh();
        logger.info("Refresh the session");
    }


    @AfterClass
    void quitBrowser(){
        logger.info("Closing the WebDriver");
        driver.close();
        logger.info("Quit the WebDriver");
        driver.quit();
    }


}

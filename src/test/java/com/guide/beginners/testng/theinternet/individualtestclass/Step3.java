package com.guide.beginners.testng.theinternet.individualtestclass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/*
With the understanding gained from Testng JAva classes shown as a part of samplejava
We can pass the test parametes in 3 ways:
    1.declaring class level local variable; Challenge with this would be if we have 100+ tests spread all over multiple packages; maintenance of the test data is a challenge.
 */
public class Step3 {
    private static Logger logger = LogManager.getLogger(Step3.class.getName( ));
    private final long MAX_TIMEOUT = 20l;
    private WebDriver driver;
    private By headerText = By.tagName("h2");
    private By formFieldUserName = By.cssSelector("input#username");
    private By formFieldPassword = By.cssSelector("input#password");
    private By submitButton = By.cssSelector("button[type='submit']");
    private By homepageSuccessMessage = By.cssSelector("div#flash");
    private By homePgeHeader = By.tagName("h2");
    private By logoutButton = By.cssSelector("a.button.secondary.radius");
    private WebDriverWait webDriverWait;

    @Parameters({"browser"})
    @BeforeClass
    private void setUp(@Optional("chrome") String browser) {
        // Create driver
        logger.info("Create driver: " + browser);

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver( ).setup( );
                driver = new ChromeDriver( );
                break;

            case "firefox":
                WebDriverManager.firefoxdriver( ).setup( );
                driver = new FirefoxDriver( );
                break;

            case "ie":
                WebDriverManager.edgedriver( ).setup( );
                driver = new EdgeDriver( );
                break;

            default:
                System.out.println("Do not know how to start: " + browser + ", starting chrome.");
                WebDriverManager.chromedriver( ).setup( );
                break;
        }
        webDriverWait = new WebDriverWait(driver, MAX_TIMEOUT);
        driver.manage( ).timeouts( ).implicitlyWait(MAX_TIMEOUT, TimeUnit.SECONDS);
        logger.info("WebDriver Setup");
        if (Objects.isNull(driver)) {
            logger.throwing(Level.FATAL, new NullPointerException( ));
        }
    }

    @Parameters("url")
    @BeforeMethod
    void BeforeMethod(@Optional("https://the-internet.herokuapp.com/login") String aut) {
        driver.get(aut);
        driver.manage( ).timeouts( ).pageLoadTimeout(MAX_TIMEOUT, TimeUnit.SECONDS);
        driver.manage( ).timeouts( ).setScriptTimeout(MAX_TIMEOUT, TimeUnit.SECONDS);
        logger.info("launching url:" + aut);
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
        assertThat(webDriverWait.until(ExpectedConditions.presenceOfElementLocated(headerText)).isDisplayed( ));
    }

    @Test
    void validateVisbilityOfUserNameField() {
        assertThat(webDriverWait.until(ExpectedConditions.presenceOfElementLocated(formFieldUserName)).isDisplayed( ));
    }

    @Test
    void validateVisbilityOfPasswordField() {
        assertThat(webDriverWait.until(ExpectedConditions.presenceOfElementLocated(formFieldPassword)).isDisplayed( ));
    }

    @Test
    void validateVisbilityOfLoginButton() {
        assertThat(webDriverWait.until(ExpectedConditions.presenceOfElementLocated(submitButton)).isDisplayed( ));
    }

    @Test
    void validateVisbilityOfHeaderText() {
        assertThat(webDriverWait.until(ExpectedConditions.presenceOfElementLocated(headerText)).getText( ).equalsIgnoreCase("Login Page"));
    }

    @Parameters({"username", "password", "expectedmessage", "h2"})
    @Test
    void validateLoginFunctionality(@Optional("tomsmith") String username, @Optional("SuperSecretPassword!") String password, @Optional("You logged into a secure area!") String expectedmessage, @Optional("Secure Area") String securearea) {
        logger.info("Entering UserName:" + username);
        logger.info("Entering password:" + password);
        driver.findElement(formFieldUserName).sendKeys(username);
        driver.findElement(formFieldPassword).sendKeys(password);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(submitButton)).click( );
        assertThat(webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(homepageSuccessMessage, expectedmessage)));
        assertThat(webDriverWait.until(ExpectedConditions.textToBe(homePgeHeader, securearea)));
        assertThat(webDriverWait.until(ExpectedConditions.presenceOfElementLocated(logoutButton)).isDisplayed( ));
        driver.findElement(logoutButton).click( );
    }


    @AfterMethod
    void validateSessionRest() {
        logger.info("Refresh the session");
    }


    @AfterClass
    void quitBrowser() {
        logger.info("Closing the WebDriver");
        driver.close( );
        logger.info("Quit the WebDriver");
        driver.quit( );
    }

}

package com.guide.beginners.testng.theinternet.individualtestclass;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-03-2020
 * Time: 09:08 AM
 */
public class GridTest {
    RemoteWebDriver driver = null;
    private String aut = "https://the-internet.herokuapp.com/login";
    private By formFieldUserName = By.cssSelector("input#username");
    private By formFieldPassword = By.cssSelector("input#password");
    private By submitButton = By.cssSelector("button[type='submit']");
    private String username = "tomsmith";
    private String password = "SuperSecretPassword!";
    private By homepageSuccessMessage = By.cssSelector("div#flash");
    private By logoutButton = By.cssSelector("a.button.secondary.radius");

    @BeforeTest
    @Parameters("myBrowser")
    public void beforeClass(@Optional("chrome") String myBrowser) throws MalformedURLException {
        DesiredCapabilities capability = new DesiredCapabilities( );
        // Creating driver
        switch (myBrowser) {
            case "chrome":
                capability.setBrowserName("chrome");
                capability.setPlatform(Platform.WINDOWS);
                ChromeOptions chromeOptions = new ChromeOptions( );
                chromeOptions.merge(capability);
                break;
            case "internet explorer":
                capability.setBrowserName("internet explorer");
                capability.setPlatform(Platform.WINDOWS);
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions( );
                internetExplorerOptions.merge(capability);
                break;
            case "firefox":
                capability.setBrowserName("firefox");
                capability.setPlatform(Platform.WINDOWS);
                FirefoxOptions firefoxOptions = new FirefoxOptions( );
                firefoxOptions.merge(capability);
                break;
        }
        driver=(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability));


    }


    @Test
    void LoginTest() throws InterruptedException {
        driver.get(aut);
        driver.findElement(formFieldUserName).sendKeys(username);
        driver.findElement(formFieldPassword).sendKeys(password);
        driver.findElement(submitButton).click( );
        assertThat(driver.findElement(homepageSuccessMessage).getText( ).contains("You logged into a secure area!"));
        driver.findElement(logoutButton).click( );
    }

    @AfterClass
    public void afterClass() {
        driver.close( );
    }
}

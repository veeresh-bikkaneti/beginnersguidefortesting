package com.guide.beginners.testng.theinternet.frameworktestng.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BrowserFactory {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>( );
    private String browsername;
    private Logger logger;

    public BrowserFactory(String browsername,Logger logger) {
        this.browsername = browsername.toLowerCase( );
        this.logger=logger;
    }

    public WebDriver getWebDriver() {
        logger.info("Webdriver created: "+browsername);
        switch (browsername) {
            case "chrome":
                WebDriverManager.chromedriver( ).setup( );
                driver.set(new ChromeDriver( ));
                break;

            case "firefox":
                WebDriverManager.firefoxdriver( ).setup( );
                driver.set(new FirefoxDriver( ));
                break;

            case "opera":
                WebDriverManager.operadriver( ).setup( );
                driver.set(new OperaDriver( ));
                break;

            default:
                logger.info("Do not know how to start: " + browsername + ", starting chrome.");
                WebDriverManager.chromedriver( ).setup( );
                driver.set(new ChromeDriver( ));
                break;
        }
        return driver.get( );
    }
}

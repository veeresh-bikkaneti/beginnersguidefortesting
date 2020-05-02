package com.guide.beginners.testng.theinternet.frameworktestng.pagefactory.pageactions;

import com.guide.beginners.testng.theinternet.frameworktestng.pagefactory.BasePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-02-2020
 * Time: 01:12 PM
 */
public class WelcomePageObject extends BasePageObject {
    private String pageUrl = "http://the-internet.herokuapp.com/";
    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");

    public WelcomePageObject(WebDriver driver, Logger logger) {
        super(driver, logger);
    }
}

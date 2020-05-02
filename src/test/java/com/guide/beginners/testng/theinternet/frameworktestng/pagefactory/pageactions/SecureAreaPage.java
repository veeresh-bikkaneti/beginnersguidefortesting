package com.guide.beginners.testng.theinternet.frameworktestng.pagefactory.pageactions;

import com.guide.beginners.testng.theinternet.frameworktestng.pagefactory.BasePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-02-2020
 * Time: 01:10 PM
 */
public class SecureAreaPage extends BasePageObject {
    private By homepageSuccessMessage = By.cssSelector("div#flash");
    private By homePgeHeader = By.tagName("h2");
    private By logoutButton = By.cssSelector("a.button.secondary.radius");

    public SecureAreaPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
}

package com.guide.beginners.testng.theinternet.frameworktestng.pagefactory.pages;

import org.openqa.selenium.By;

/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-02-2020
 * Time: 01:19 PM
 */
public class SecureAreaPO {
    private By homepageSuccessMessage = By.cssSelector("div#flash");
    private By homePgeHeader = By.tagName("h2");
    private By logoutButton = By.cssSelector("a.button.secondary.radius");

    public By getHomepageSuccessMessage() {
        return homepageSuccessMessage;
    }

    public By getHomePgeHeader() {
        return homePgeHeader;
    }

    public By getLogoutButton() {
        return logoutButton;
    }
}

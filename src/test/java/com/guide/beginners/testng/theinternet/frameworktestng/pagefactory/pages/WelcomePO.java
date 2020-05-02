package com.guide.beginners.testng.theinternet.frameworktestng.pagefactory.pages;

import org.openqa.selenium.By;

/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-02-2020
 * Time: 02:30 PM
 */
public class WelcomePO {
    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");

    public By getFormAuthenticationLinkLocator() {
        return formAuthenticationLinkLocator;
    }
}

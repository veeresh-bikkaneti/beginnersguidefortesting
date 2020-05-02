package com.guide.beginners.testng.theinternet.frameworktestng.base;

import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForSync extends BaseTest {
    private WebDriverWait webDriverWait;

    public WebDriverWait getWebDriverWait() {
        this.webDriverWait = new WebDriverWait(driver, MAX_TIMEOUT);
        return webDriverWait;
    }


    public void sleep(Long mill) {
        try {
            Thread.sleep(mill);
        } catch (InterruptedException e) {
            e.printStackTrace( );
        }
    }

}

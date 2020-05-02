package com.guide.beginners.testng.theinternet.frameworktestng.base;
/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-02-2020
 * Time: 12:34 PM
 */
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

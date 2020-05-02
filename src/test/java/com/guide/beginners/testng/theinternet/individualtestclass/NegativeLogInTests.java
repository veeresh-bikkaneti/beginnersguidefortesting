package com.guide.beginners.testng.theinternet.individualtestclass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class NegativeLogInTests {
    WebDriver driver;


    @Parameters({"browser"})
    @BeforeClass
    private void setUp(@Optional("chrome") String browser) {
        // Create driver
        System.out.println("Create driver: " + browser);

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

    }


    @Parameters({"username", "password", "expectedMessage"})
    @Test
    public void negativeTest(String username, String password, String expectedErrorMessage) {
        System.out.println("Starting negativeTest");

        // open main page
        String url = "http://the-internet.herokuapp.com/";
        driver.get(url);
        System.out.println("Main page is opened.");

        // Click on Form Authentication link
        driver.findElement(By.linkText("Form Authentication")).click( );

        // enter username and password
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        // push log in button
        driver.findElement(By.className("radius")).click( );

        // Verification
        String actualErrorMessage = driver.findElement(By.id("flash")).getText( );
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
                        + expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
    }


    @AfterMethod
    private void tearDown() {
        System.out.println("Close driver");
        // Close browser
        driver.quit( );
    }
}

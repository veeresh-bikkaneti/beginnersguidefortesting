package com.guide.beginners.testng.theinternet.individualtestclass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-30-2020
 * Time: 11:48 AM
 */
public class HandlingTables {
    WebDriver webDriver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver( ).setup( );
        webDriver = new ChromeDriver( );

    }

    @Test(dependsOnMethods = "testinternetTable")
    public void testComplexXpath() {
        String mailinator = "https://www.mailinator.com/";
        webDriver.get(mailinator);
        webDriver.findElement(By.linkText("Pricing")).click( );
        System.out.println("---using getText---" );
        assertTrue(webDriver.findElement(By.cssSelector("div#pricing_table_pane")).getText( ).contains("Mailinator Subscription Plans"), "Pricing page is open");
        By getText = By.xpath("((//div[@class='title']/parent::div/parent::div/parent::div//ul)//li)");
        System.out.println(webDriver.findElements(getText).stream( ).map(WebElement::getText).collect(Collectors.toList( )));
        System.out.println("---Using Inner HTML Attribute---" );

        By innerHTML = By.xpath("((//div[@class='title']/parent::div/parent::div/parent::div//ul)//li)");
        System.out.println(webDriver.findElements(innerHTML).stream( ).map(webElement -> webElement.getAttribute("innerHTML")).collect(Collectors.toList( )));

    }

    @Test
    public void testinternetTable() {
        String table="http://the-internet.herokuapp.com/tables";
        webDriver.get(table);
        System.out.println("---Complex cssSelector----" );
        System.out.println("emailIDinSecondRow:"+webDriver.findElement(By.cssSelector("table#table1 tr:nth-of-type(2) > td:nth-of-type(5)")).getText( ));
        System.out.println("---Complex xpath----" );
        System.out.println("emailIDinSecondRow:"+webDriver.findElement(By.xpath("(//tr[2]) [1]//td[5]")).getText( ));
    }

    @AfterClass
    public void tearDown() {
        webDriver.close();
        webDriver.quit();
    }

}

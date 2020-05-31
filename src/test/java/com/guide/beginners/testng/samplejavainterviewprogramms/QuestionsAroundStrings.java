package com.guide.beginners.testng.samplejavainterviewprogramms;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.testng.Assert.assertTrue;

public class QuestionsAroundStrings {

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("tom", "bob", "garry");
        System.out.println("name stream count:" + stringStream.count( ));
        System.out.println("------------------");
        IntStream intStream = IntStream.range(1, 5);
        System.out.println("int stream count:" + intStream.count( ));
        System.out.println("------------------");
        intStream = IntStream.of(1, 5, 8);
        System.out.println("int stream count:" + intStream.count( ));
        System.out.println("------------------");
        String[] nameArray = {"tom", "bob", "garry"};
        Stream<String> stringStream1 = Stream.of(nameArray);
        System.out.println("name stream count:" + stringStream1.count( ));
        System.out.println("------------------");
        ArrayList arrayList = new ArrayList( );
        arrayList.add("toom");
        arrayList.add("garry");
        arrayList.add("harry");
        Stream<String> stringStream2 = arrayList.stream( );
        System.out.println("Arrays list as stream: " + stringStream2.count( ));
        System.out.println("------------------");
        Stream<String> stringStream3 = Stream.empty( );
        System.out.println("Stream empty count: " + stringStream3.count( ));
        System.out.println("------------------");
        Stream.Builder<String> stringBuilder = Stream.builder( );
        stringBuilder.accept("Tom");
        stringBuilder.accept("harry");
        stringBuilder.accept("Garry");
        System.out.println("Stream builder count: " + stringBuilder.build( ).count( ));
        System.out.println("------------------");
//        By bs = By.cssSelector("");
//        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");


        //Setup chromedriver
        WebDriverManager.chromedriver( ).setup( );

        //instantiating the webdriver
        WebDriver webDriverInstance = new ChromeDriver( );

        //navigate to the url
        webDriverInstance.navigate( ).to("https://www.google.com/");

        //navigate to the url
        webDriverInstance.get("https://www.google.com/");

        //Sets the amount of time to wait for a page load to complete before throwing an error.
        webDriverInstance
                .manage( )
                .timeouts( )
                .pageLoadTimeout(Long.valueOf(20), TimeUnit.SECONDS);

        //Specifies the amount of time the driver should wait when searching for an element if it is not immediately present.
        //Max amount of time that a Webdriver Instance will wait before throwing NoSuchElementException
        webDriverInstance
                .manage( )
                .timeouts( )
                .implicitlyWait(Long.valueOf(20), TimeUnit.MILLISECONDS);
        System.out.println(webDriverInstance.getTitle( ));

        /*
    Wait will ignore instances of NotFoundException that are encountered (thrown) by default in
   the 'until' condition, and immediately propagate all others.  You can add more to the ignore
   list by calling ignoring(exceptions to add).
         */

        assertTrue(new WebDriverWait(webDriverInstance, Long.valueOf(20))
                .until(ExpectedConditions.titleIs("Google")).booleanValue( ), "*****Url not loaded*****");

        /*
        Simple search box WebElementLocation using multiple strategies
         */
        By searchByName = By.name("q");
        /*By searchByCSSselector = By.cssSelector(".a4bIc > input[role='combobox']");
        By searchByRelativeXpath = By.xpath("//input[@title='Search']");
        By searchByAbsoluteXpath = By.xpath("/html/body/div/div[4]/form/div[2]/div[1]/div[1]/div/div[2]/input");*/


        WebElement inputTextBoxSearchforaPhrase = webDriverInstance.findElement(searchByName);

        assertTrue(webDriverInstance.findElement(searchByName).isEnabled( ), "Element is not Enebled for operarion");
        webDriverInstance.findElement(searchByName).clear( );
        webDriverInstance.findElement(searchByName).sendKeys("Sample Selenium");
        webDriverInstance.findElement(searchByName).sendKeys(Keys.TAB);
        webDriverInstance.findElement(By.cssSelector(".FPdoLc [value='Google Search']")).click( );


    }
}

package com.guide.beginners.testng.theinternet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class PositiveTest {
    private static Logger logger = LogManager.getLogger(PositiveTest.class.getName( ));
    private WebDriver driver;
    private String aut = "https://the-internet.herokuapp.com/login";
/*By
    @BeforeClass*/
    void startbroweser() {
        WebDriverManager.chromedriver( ).setup( );
        driver = new ChromeDriver( );
        logger.info("WebDriver Setup");
        if (Objects.isNull(driver)) {
            logger.throwing(Level.FATAL, new NullPointerException( ));
        }
    }


    @BeforeMethod
    void BeforeMethod() {
        driver.get(aut);
        logger.info("launching aut:" + aut);
    }
    @Test
    void validateCurrentURl(){
        assertThat(driver.getCurrentUrl().equalsIgnoreCase(aut));
    }

    @Test
    void validateFormFieldsAreVisible(){
        assertThat(driver.getCurrentUrl().equalsIgnoreCase(aut));
    }



}

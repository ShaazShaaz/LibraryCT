package com.LibraryCT.utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


// THIS CLASS IS MEANT TO BE SUPER CLASS
// TO PROVIDE DRIVER SETUP AND CLOSING BROWSER
// FOR ITS SUBCLASSES

public abstract class TestBase {
    protected WebDriver driver ; // can make public as well
    // setting up all driver stuff here directly in @BeforeEach method
    @BeforeEach
    public void setupWebDriver(){
        //  WebDriverManager.chromedriver().setup();
        //  driver = new ChromeDriver();
        //  driver.manage().window().maximize();
        driver=WebDriverFactory.get("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    public void closeBrowser(){
        driver.quit();
    }
}

package com.LibraryCT.userstory1;

import com.LibraryCT.utilities.Methods;
import com.LibraryCT.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LibraryCT_InvalidLogIn extends TestBase {
    /*
    AC #3 [negative]:
    Given user is on the loginPage
    When user enters invalid email address or password
    And student click sign in button
    Then verify the error message “Sorry, Wrong Email or Password”
     */

    // ABSTRACT CLASS TESTBASE DETAILS:
    // WEBDRIVER SETUP USING BEFORE EACH ANNOTATION
    // DRIVER CLOSES USING AFTER EACH
    @Test
    public void invalidLogin() throws Exception{

        //user on login page:
        driver.get("http://library2.cybertekschool.com/login.html");
        Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory1-InvalidLogin/1.png");

        //user enters incorrect credentials:
        WebElement email= driver.findElement(By.id("inputEmail"));
        email.sendKeys("librarian000@library");
        WebElement password=driver.findElement(By.id("inputPassword"));
        password.sendKeys("Sdet20*");
        Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory1-InvalidLogin/2.png");
        WebElement loginButton= driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginButton.submit();
        Thread.sleep(3000);
        Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory1-InvalidLogin/3.png");

        // expected result==login failed/error message displayed

    }
}

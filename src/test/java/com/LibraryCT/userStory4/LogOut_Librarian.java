package com.LibraryCT.userStory4;

import com.LibraryCT.utilities.Methods;
import com.LibraryCT.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class LogOut_Librarian extends TestBase {
    /*
       As a librarian, I want to log out from the library homepage.
        AC #1:  Given user is on the homePage
        When user click username on the right top corner
        And user click Log Out
        Then verify user navigate back to login page.
        */

    // ABSTRACT CLASS TESTBASE DETAILS:
    // WEBDRIVER SETUP USING BEFORE EACH ANNOTATION
    // DRIVER CLOSES USING AFTER EACH
    @Test
    public void useLogOutFunctionality() throws Exception {

        // user on login page:
        driver.get("http://library2.cybertekschool.com/login.html");
        // Ev 1:
        Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory4-LogOut/1.png");

        // testing user logOut functionality for 2 users through for-each loop:
        ArrayList<String> admins=new ArrayList<>(Arrays.asList("librarian53@library","librarian21@library"));
        for (String each:admins) {

            // user enters correct credentials:
            WebElement email = driver.findElement(By.id("inputEmail"));
            email.sendKeys(each);
            WebElement password = driver.findElement(By.id("inputPassword"));
            password.sendKeys("Sdet2022*");
            // Ev 2:
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory4-LogOut/2.png");

            WebElement loginButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
            loginButton.submit();
            Thread.sleep(3000);

            //user in homepage
            // Ev 3:
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory4-LogOut/3.png");

            // user locates and clicks the logOut drop button on top right
            WebElement logOutDropBtn = driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]"));
            logOutDropBtn.click();
            // Ev 4:
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory4-LogOut/4.png");

            // user clicks logOut option from dropdown list:
            driver.findElement(By.cssSelector("a.dropdown-item")).click();
            // Ev 5:
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory4-LogOut/5.png");
        }


    }
}

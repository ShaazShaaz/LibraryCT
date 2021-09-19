package com.LibraryCT.userStory6;

import com.LibraryCT.utilities.Methods;
import com.LibraryCT.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectUserStatus extends TestBase {
    /*
        User Story 6:
        As a librarian, I want to select user status - active vs inactive.
        AC #1:
         Given librarian is on the homePage
         When librarian click Users module
         And librarian click Status dropdown
         Then verify there are 2 status options
         */

    // ABSTRACT CLASS TESTBASE DETAILS:
    // WEBDRIVER SETUP USING BEFORE EACH ANNOTATION
    // DRIVER CLOSES USING AFTER EACH
    @Test
    public void selectUserstatus() throws Exception {

        // user on login page:
        driver.navigate().to("https://library2.cybertekschool.com/login.html");
        // Ev 1:
        Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory6-UserStatus/1.png");

        // testing the select user status functionality for 2 users through for-each loop:
        ArrayList<String> userNames=new ArrayList<>(Arrays.asList("librarian21@library","librarian53@library"));
        for (String each:userNames){

            // user enters correct credentials:
            WebElement loginID = driver.findElement(By.xpath("//input[@type='email']"));
            loginID.sendKeys(each);
            WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
            password.sendKeys("Sdet2022*");
            // Ev 2:
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory6-UserStatus/2.png");

            driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();

            // user in homepage and clicks the user module on top of the page:
            WebElement usersModule = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
            usersModule.click();

            // user is on user management page
            // Ev 3:
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory6-UserStatus/3.png");

            // user locates and clicks status button
            WebElement statusBtn= driver.findElement(By.cssSelector("#user_status"));
            statusBtn.click();

            // 2 options are displayed in the dropdown button
            // Ev 4:
            Thread.sleep(3000);
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory6-UserStatus/4.png");

            // verifying if the number of options is as expected==2:
            List<WebElement> list= driver.findElements(By.xpath("//select[@id='user_status']/option"));
            if (list.size()==2){
                System.out.println("Test passed");
            }else {
                System.out.println("Test failed");
            }

            // user logs out:
            WebElement logOutDropBtn = driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]"));
            logOutDropBtn.click();
            driver.findElement(By.cssSelector("a.dropdown-item")).click();

        }

    }
}

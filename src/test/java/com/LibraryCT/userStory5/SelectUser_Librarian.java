package com.LibraryCT.userStory5;

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
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectUser_Librarian extends TestBase {
    /*
       User Story 5
        As a librarian, I want to select user groups.
        AC #1:  Given librarian is on the homePage
        When librarian click Users module
        And librarian click user group dropdown
        Then verify librarian have 3 options
        */

    // ABSTRACT CLASS TESTBASE DETAILS:
    // WEBDRIVER SETUP USING BEFORE EACH ANNOTATION
    // DRIVER CLOSES USING AFTER EACH
    @Test
    public void selectUserFunctionality() throws Exception {

        // user on login page
        driver.get("http://library2.cybertekschool.com/login.html");
        // Ev 1:
        Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory5-SelectUser/1.png");

        // testing the select user category functionality for 2 users through for-each loop:
        ArrayList<String> list=new ArrayList<>(Arrays.asList("librarian21@library","librarian53@library"));
        for (String each:list) {

            // user enters correct credentials:
            WebElement email = driver.findElement(By.id("inputEmail"));
            email.sendKeys(each);
            WebElement password = driver.findElement(By.id("inputPassword"));
            password.sendKeys("Sdet2022*");
            // Ev 2:
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory5-SelectUser/2.png");

            WebElement loginButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
            loginButton.submit();
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Users')]")));
            // user on homepage
            // Ev 3:
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory5-SelectUser/3.png");

            // user locates and clicks users module on top of the page:
            WebElement usersModule = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
            usersModule.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='user_groups']")));
            // user on user management page
            // Ev 4:
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory5-SelectUser/4.png");

            // user locates and clicks the user group dropdown button
            WebElement userGroupDropButton = driver.findElement(By.xpath("//select[@id='user_groups']"));
            userGroupDropButton.click();

            // 3 options are displayed in the dropdown list
            // Ev 5:
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbarDropdown\"]")));
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory5-SelectUser/5.png");

            // verifying if the number of options is as expected==3:
            List<WebElement> list2= driver.findElements(By.xpath("//select[@id='user_groups']/option"));
            System.out.println(list2.size());

            if (list2.size()==3){
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

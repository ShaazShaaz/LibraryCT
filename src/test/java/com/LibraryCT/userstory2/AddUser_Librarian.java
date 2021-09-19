package com.LibraryCT.userstory2;

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
import java.util.concurrent.TimeUnit;

public class AddUser_Librarian extends TestBase {
    /*
    User Story 2 As a librarian, I should be able to add a new user.
    AC #1:  Given librarian is on the homePage
     When librarian click Users module
     And librarian click “+Add User” button
     When librarian enter full name, password, email and address
     And librarian click save changes
     Then verify a new user is created
     */

    // ABSTRACT CLASS TESTBASE DETAILS:
    // WEBDRIVER SETUP USING BEFORE EACH ANNOTATION
    // DRIVER CLOSES USING AFTER EACH
    @Test
    public void addUserFunctionality() throws Exception {

        // user on login page
        driver.navigate().to("https://library2.cybertekschool.com/login.html");
        // Ev 1:
        Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory2-AddUser/1.png");

        // testing add user functionality for 2 users through for-each loop:
        ArrayList<String> admins=new ArrayList<>(Arrays.asList("librarian53@library","librarian21@library"));
        for (String each:admins) {

            // user enters correct credentials:
            WebElement loginID = driver.findElement(By.xpath("//input[@type='email']"));
            loginID.sendKeys(each);

            WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
            password.sendKeys("Sdet2022*");
            //Ev 2:
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory2-AddUser/2.png");

            driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();

            // user in homepage
            // user clicks users module on top of homepage:
            WebElement usersModule = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
            usersModule.click();
            //Ev 3:
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory2-AddUser/3.png");

            // user locates and clicks add user button on top right
            WebElement addUserButton = driver.findElement(By.xpath("//*[@id=\"users\"]/div[1]/div[1]/span/a"));
            addUserButton.click();

            // information entry window pops up, user enters personal information
            WebElement fullName = driver.findElement(By.xpath("//input[@name='full_name']"));
            fullName.sendKeys("Az1 Seno1");
            WebElement password2 = driver.findElement(By.xpath("//input[@name='password']"));
            password2.sendKeys("1234567");
            WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
            email.sendKeys("az1seno1@gmail.com");
            WebElement address = driver.findElement(By.cssSelector("#address"));
            address.sendKeys("623 Kelso Rd, Pittsburgh PA, 15243");
            // Ev 4
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory2-AddUser/4.png");

            // user clicks submit button:
            WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"add_user_form\"]/div[2]/button[2]"));
            submitButton.click();

            // new user is added and displayed in the list.
            // Ev 5:
            Thread.sleep(3000);
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory2-AddUser/7.png");

            // user logs out:
            WebElement logOutDropBtn = driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]"));
            logOutDropBtn.click();
            driver.findElement(By.cssSelector("a.dropdown-item")).click();
        }


    }
}

package com.LibraryCT.userStory7;

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

public class FilterBooks extends TestBase {
    /*
As a user, I want to filter book categories.
AC #1:  Given user is on the homePage
When user click Books module
And user click book category dropdown
Then verify there are 21 options
 */

    // ABSTRACT CLASS TESTBASE DETAILS:
    // WEBDRIVER SETUP USING BEFORE EACH ANNOTATION
    // DRIVER CLOSES USING AFTER EACH
    @Test
    public void filterBooksFunctionality()throws Exception {
        // user on login page:
        driver.navigate().to("https://library2.cybertekschool.com/login.html");
        // Ev 1:
        Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory7.1-FilterBooks/1.png");

        // testing filter books functionality for 5 users using for-each loop:
        ArrayList<String> userNames=new ArrayList<>(Arrays.asList("librarian21@library","librarian53@library","student66@library","student67@library","student68@library"));
        for (String each:userNames) {

            // user enters correct credentials:
            WebElement loginID = driver.findElement(By.xpath("//input[@type='email']"));
            loginID.sendKeys(each);
            WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
            password.sendKeys("Sdet2022*");
            // Ev 2:
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory7.1-FilterBooks/2.png");
            driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();

            // user in on homepage
            // Ev 2:
            Thread.sleep(3000);
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory7.1-FilterBooks/3.png");

            // user locates and clicks books module on the top of the page:
            WebElement booksModule = driver.findElement(By.xpath("//span[contains(text(),'Books')]"));
            booksModule.click();
            // Ev 3:
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory7.1-FilterBooks/4.png");

            // user is on books management page
            // user locates and clicks books category button:
            WebElement booksCategory= driver.findElement(By.xpath("//*[@id=\"book_categories\"]"));
            booksCategory.click();
            // Ev 4:
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory7.1-FilterBooks/5.png");

            // options of book category are displayed once dropdown button is clicked
            List<WebElement> list= driver.findElements(By.xpath("//select[@id='book_categories']/option"));
            System.out.println("list.size() = " + list.size());

            // verifying if the number of options displayed is as expected==21:
            if (list.size()==21){
                System.out.println("Expected result==21==Actual Result");
            }else {
                System.out.println("test failed");
            }

            // user logs out:
            WebElement logOutDropBtn = driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]"));
            logOutDropBtn.click();
            driver.findElement(By.cssSelector("a.dropdown-item")).click();

        }
    }
}

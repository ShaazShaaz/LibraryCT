package com.LibraryCT.userStory7;

import com.LibraryCT.utilities.Methods;
import com.LibraryCT.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class SelectDrama extends TestBase {
    /*
     * As a user, I want to filter book categories.
     *
     * AC #2:
     * Given user is on the homePage
     * When user click Books module
     * And user click book category dropdown
     * Then verify user is able to select the “Drama” option
     */

    // ABSTRACT CLASS TESTBASE DETAILS:
    // WEBDRIVER SETUP USING BEFORE EACH ANNOTATION
    // DRIVER CLOSES USING AFTER EACH
    @Test
    public void selectDramaOption() throws Exception {

        // user on login page:
        driver.navigate().to("https://library2.cybertekschool.com/login.html");
        // ev 1:
        Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory7.2-SelectDrama/1.png");

        // testing the select Book category functionality for 5 users using for-each loop:
        ArrayList<String> userNames=new ArrayList<>(Arrays.asList("librarian21@library","librarian53@library","student66@library","student67@library","student68@library"));
        for (String each:userNames) {

            // user enters correct credentials:
            WebElement loginID = driver.findElement(By.xpath("//input[@type='email']"));
            loginID.sendKeys(each);
            WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
            password.sendKeys("Sdet2022*");
            // Ev 2:
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory7.2-SelectDrama/2.png");
            driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();

            // user is on homepage
            // Ev 3:
            Thread.sleep(3000);
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory7.2-SelectDrama/3.png");

            // user locates and clicks books module on top of the page:
            WebElement booksModule = driver.findElement(By.xpath("//span[contains(text(),'Books')]"));
            booksModule.click();

            //user is on books management page
            // user locates and clicks books category dropdown button:
            WebElement booksCategory= driver.findElement(By.xpath("//*[@id=\"book_categories\"]"));
            booksCategory.click();

            // user clicks on Drama category:
            WebElement categories = driver.findElement(By.cssSelector("#book_categories"));
            Select drama = new Select(categories);
            drama.selectByValue("6"); // 6== Drama
            // Ev 4:
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory7.2-SelectDrama/4.png");

            // user logs out:
            WebElement logOutDropBtn = driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]"));
            logOutDropBtn.click();
            driver.findElement(By.cssSelector("a.dropdown-item")).click();


        }

    }
}
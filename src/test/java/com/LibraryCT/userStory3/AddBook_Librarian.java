package com.LibraryCT.userStory3;

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

public class AddBook_Librarian extends TestBase {
    /*
    User Story 3 As a librarian, I should be able to add a new book.
    AC #1:
    Given librarian is on the homePage
    When librarian click Books module
    And librarian click “+Add Book” button
    When librarian enter BookName, ISBN, Year, Author, and Description
    And librarian click save changes
    Then verify a new book is added
     */

    // ABSTRACT CLASS TESTBASE DETAILS:
    // WEBDRIVER SETUP USING BEFORE EACH ANNOTATION
    // DRIVER CLOSES USING AFTER EACH
    @Test
    public void addBook() throws Exception {

        // user on homepage:
        driver.navigate().to("https://library2.cybertekschool.com/login.html");
        //Ev 1:
        Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory3-AddBook/1.png");

        // testing add book functionality for 2 users through for-each loop:
        ArrayList<String> admins=new ArrayList<>(Arrays.asList("librarian53@library","librarian21@library"));
        for (String each:admins) {

            // user enters correct credentials:
            WebElement loginID = driver.findElement(By.xpath("//input[@type='email']"));
            loginID.sendKeys(each);
            WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
            password.sendKeys("Sdet2022*");
            // Ev 2:
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory3-AddBook/2.png");

            driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();


            //user is on homepage
            // users is able to locate and click books module on top of page:
            WebElement booksModule = driver.findElement(By.xpath("//span[contains(text(),'Books')]"));
            booksModule.click();

            // user is able to locate and click add book button on top right:
            WebElement addBook = driver.findElement(By.xpath("//a[@class='btn btn-lg btn-outline btn-primary btn-sm add_book_btn']"));
            addBook.click();
            // Ev 3:
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory3-AddBook/3.png");

            // user enters information about the book in the information entry window:
            WebElement nameOfBook = driver.findElement(By.xpath("//input[@name='name']"));
            nameOfBook.sendKeys("Attack on Titan2");

            WebElement isbn = driver.findElement(By.xpath("//input[@name='isbn']"));
            isbn.sendKeys("978-1-63236-828-72");

            WebElement year = driver.findElement(By.xpath("//input[@name='year']"));
            year.sendKeys("2019");

            WebElement author = driver.findElement(By.xpath("//input[@name='author']"));
            author.sendKeys("Hajime Isayama");

            WebElement description = driver.findElement(By.cssSelector("#description"));
            description.sendKeys("a visceral and fantastically intense action/horror story");
            // Ev 4
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory3-AddBook/4.png");

            // user save the changes by clicking on the submit button:
            WebElement saveChanges = driver.findElement(By.xpath("//button[@type='submit']"));
            saveChanges.click();

            // verifying if book has been added or not by entering the name of book i n search button on the right:
            WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
            search.sendKeys("Attack on Titan");
            Thread.sleep(3000);

            //newly added book information is displayed in the book list:
            // Ev 5:
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory3-AddBook/5.png");

            // user logs out:
            WebElement logOutDropBtn = driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]"));
            logOutDropBtn.click();
            driver.findElement(By.cssSelector("a.dropdown-item")).click();
        }


    }
}

package com.LibraryCT.userstory1;

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

public class LibraryCT_Student extends TestBase {
    /*
    Given student is on the loginPage
    Then verify that the URL is “https://library2.cybertekschool.com/login.html”
    When student enters valid email address and password
    And student click sign in button
    Then verify that there are 2 models on the page
     */

    // ABSTRACT CLASS TESTBASE DETAILS:
    // WEBDRIVER SETUP USING BEFORE EACH ANNOTATION
    // DRIVER CLOSES USING AFTER EACH
    @Test
    public void logInFunctionality() throws Exception {

        // user on login page:
        driver.get("http://library2.cybertekschool.com/login.html");
        // Ev 1:
        Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory1-UserLogin/s1.png");

        //testing functionality for 3 users through for-each loop:
        ArrayList<String> admins=new ArrayList<>(Arrays.asList("student66@library","student67@library","student68@library"));
        for (String each:admins) {
            if (driver.getTitle().equals("Login - Library")) {
                System.out.println("Title is “Login - Library”(Expected==Actual Result");
            } else {
                System.out.println("Title does not match");
            }

            // user enters correct credentials:
            WebElement email = driver.findElement(By.id("inputEmail"));
            email.sendKeys(each);
            WebElement password = driver.findElement(By.id("inputPassword"));
            password.sendKeys("Sdet2022*");
            //Ev 2:
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory1-UserLogin/s2.png");

            WebElement loginButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
            loginButton.submit();

            Thread.sleep(3000);
            // user on homepage
            // verifying if number of modules on homepage is as expected==2:
            List<WebElement> list = driver.findElements(By.xpath("//li[@class='nav-item']"));
            if (list.size() == 2) {
                System.out.println("Expected Result==2==Actual Result");
            } else {
                System.out.println("Results dont match");
            }
            //Ev 3:
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory1-UserLogin/s3.png");

            // user logout:
            WebElement logOutDropBtn = driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]"));
            logOutDropBtn.click();
            driver.findElement(By.cssSelector("a.dropdown-item")).click();
        }

    }
}

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

public class LibraryCT_Librarian extends TestBase {
    /*
       LIBRARIAN 1: "librarian53@library"
       As a user, I should be able to login to LibraryCT.
       AC #1:  Given librarian is on the loginPage
       Then verify that the title is “Login - Library”
       When librarian enters valid email address and password
       And librarian click sign in button
       Then verify that there are3 models on the page
        */

    // ABSTRACT CLASS TESTBASE DETAILS:
    // WEBDRIVER SETUP USING BEFORE EACH ANNOTATION
    // DRIVER CLOSES USING AFTER EACH
    @Test
    public void logInFunctionality() throws Exception {

        //user on login page:
        driver.get("http://library2.cybertekschool.com/login.html");

        // testing functionality for 2 users through for-each loop:
        ArrayList<String> admins=new ArrayList<>(Arrays.asList("librarian53@library","librarian21@library"));
        for (String each:admins) {

            //verifying if the title is as expected:"Login - Library"
            if (driver.getTitle().equals("Login - Library")){
                System.out.println("Title is “Login - Library”(Expected==Actual Result");
            }else {
                System.out.println("Title does not match");
            }
            // Ev.1:
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory1-UserLogin/1.png");

            // user enters correct credentials:
            WebElement email = driver.findElement(By.id("inputEmail"));
            email.sendKeys(each);
            WebElement password = driver.findElement(By.id("inputPassword"));
            password.sendKeys("Sdet2022*");
            //Ev 2:
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory1-UserLogin/2.png");

            WebElement loginButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
            loginButton.submit();
            Thread.sleep(3000);
            //Evidence 3: user on homepage-
            Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/userStory1-UserLogin/3.png");

            // verifying if the number of modules are as expected==3
            List<WebElement> list = driver.findElements(By.xpath("//li[@class='nav-item']"));
            System.out.println("list.size() = " + list.size());
            String module1 = list.get(0).getText();
            String module2 = list.get(1).getText();
            String module3 = list.get(2).getText();
            System.out.println(module1);
            System.out.println(module2);
            System.out.println(module3);

            if (list.size() == 3 && module1.equals("Dashboard") && module2.equals("Users") && module3.equals("Books")) {
                System.out.println("Test passed: Expected Result==3==Actual Result");
            } else {
                System.out.println("Test Failed: Expected Result==3 != Actual Result");
            }

            // user logout
            WebElement logOutDropBtn = driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]"));
            logOutDropBtn.click();
            driver.findElement(By.cssSelector("a.dropdown-item")).click();
        }


    }
}

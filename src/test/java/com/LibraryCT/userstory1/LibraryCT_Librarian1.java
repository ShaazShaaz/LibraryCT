package com.LibraryCT.userstory1;


import com.LibraryCT.utilities.Methods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LibraryCT_Librarian1 {
    public static void main(String[] args)throws Exception {
        /*
        LIBRARIAN 1: "librarian53@library"
        As a user, I should be able to login to LibraryCT.
        AC #1:  Given librarian is on the loginPage
        Then verify that the title is “Login - Library”
        When librarian enters valid email address and password
        And librarian click sign in button
        Then verify that there are3 models on the page
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://library2.cybertekschool.com/login.html");
        if (driver.getTitle().equals("Login - Library")){
            System.out.println("Title is “Login - Library”(Expected==Actual Result");
        }else {
            System.out.println("Title does not match");
        }
        //Evidence 1:
        Methods.takeSnapShot(driver,"//Users/olcaysenol/Desktop/library/login2.png");

        // Enter Credentials:
        WebElement email= driver.findElement(By.id("inputEmail"));
        email.sendKeys("librarian53@library");
        WebElement password=driver.findElement(By.id("inputPassword"));
        password.sendKeys("Sdet2022*");
        //Evidence 2:
        Methods.takeSnapShot(driver,"//Users/olcaysenol/Desktop/library/login2.png");

        WebElement loginButton= driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginButton.submit();
        Thread.sleep(3000);
        //Evidence 3:
        Methods.takeSnapShot(driver,"//Users/olcaysenol/Desktop/library/login2.png");


        List<WebElement> list= driver.findElements(By.xpath("//li[@class='nav-item']"));
        System.out.println("list.size() = " + list.size());
        String module1=list.get(0).getText();
        String module2=list.get(1).getText();
        String module3=list.get(2).getText();
        System.out.println(module1);
        System.out.println(module2);
        System.out.println(module3);

        if (list.size()==3 && module1.equals("Dashboard") && module2.equals("Users") && module3.equals("Books")){
            System.out.println("Test passed: Expected Result==3==Actual Result");
        }else {
            System.out.println("Test Failed: Expected Result==3 != Actual Result");
        }

    }
}

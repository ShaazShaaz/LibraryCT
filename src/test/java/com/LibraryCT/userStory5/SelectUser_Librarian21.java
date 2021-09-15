package com.LibraryCT.userStory5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectUser_Librarian21 {
    public static void main(String[] args) {
        /*
        User Story 5
         As a librarian, I want to select user groups.
         AC #1:  Given librarian is on the homePage
         When librarian click Users module
         And librarian click user group dropdown
         Then verify librarian have 3 options
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://library2.cybertekschool.com/login.html");

        ArrayList<String> list=new ArrayList<>(Arrays.asList("librarian21@library","librarian53@library"));
        for (String each:list) {
            WebElement email = driver.findElement(By.id("inputEmail"));
            email.sendKeys(each);
            WebElement password = driver.findElement(By.id("inputPassword"));
            password.sendKeys("Sdet2022*");

            WebElement loginButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
            loginButton.submit();
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Users')]")));

            WebElement usersModule = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
            usersModule.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='user_groups']")));

            WebElement userGroupDropButton = driver.findElement(By.xpath("//select[@id='user_groups']"));
            userGroupDropButton.click();

            List<WebElement> list2= driver.findElements(By.xpath("//select[@id='user_groups']/option"));
            System.out.println(list2.size());

            if (list2.size()==3){
                System.out.println("Test passed");
            }else {
                System.out.println("Test failed");
            }

            // driver.quit()


        }
    }
}

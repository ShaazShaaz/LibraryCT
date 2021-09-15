package com.LibraryCT.userstory1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LibraryCT_Student2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://library2.cybertekschool.com/login.html");

        WebElement email= driver.findElement(By.id("inputEmail"));
        email.sendKeys("student67@library");
        WebElement password=driver.findElement(By.id("inputPassword"));
        password.sendKeys("Sdet2022*");

        WebElement loginButton= driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginButton.submit();

    }
}
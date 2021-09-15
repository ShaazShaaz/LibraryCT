package com.LibraryCT.userstory1;

import com.LibraryCT.utilities.Methods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LibraryCT_Student3 {
    public static void main(String[] args)throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://library2.cybertekschool.com/login.html");
// we r trying to add screenshot code here
        Methods.takeSnapShot(driver,"//Users/olcaysenol/Desktop/library/student3.png");
        WebElement email= driver.findElement(By.id("inputEmail"));
        email.sendKeys("student68@library");
        WebElement password=driver.findElement(By.id("inputPassword"));
        password.sendKeys("Sdet2022*");

        WebElement loginButton= driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginButton.submit();

    }
}

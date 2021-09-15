package com.LibraryCT.userstory1;

import com.LibraryCT.utilities.Methods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LibraryCT_Student1 {
    public static void main(String[] args)throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://library2.cybertekschool.com/login.html");
        Methods.takeSnapShot(driver,"//Users/olcaysenol/Desktop/library/login3.png");

        WebElement email= driver.findElement(By.id("inputEmail"));
        email.sendKeys("student66@library");
        WebElement password=driver.findElement(By.id("inputPassword"));
        password.sendKeys("Sdet2022*");
        Methods.takeSnapShot(driver,"//Users/olcaysenol/Desktop/library/credentials3.png");

        WebElement loginButton= driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginButton.submit();

        Thread.sleep(3000);

        List<WebElement> list= driver.findElements(By.xpath("//li[@class='nav-item']"));
        if (list.size()==2){
            System.out.println("Expected Result==2==Actual Result");
        }else {
            System.out.println("Results dont match");
        }
        Methods.takeSnapShot(driver,"//Users/olcaysenol/Desktop/library/homepage3.png");

    }
}

package com.LibraryCT.userStory4;

import com.LibraryCT.utilities.Methods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LogOut_Librarian1 {
    public static void main(String[] args)throws Exception {
        /*
        As a librarian, I want to log out from the library homepage.
         AC #1:  Given user is on the homePage
         When user click username on the right top corner
         And user click Log Out
         Then verify user navigate back to login page.
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://library2.cybertekschool.com/login.html");

        Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/logout1.png");
        WebElement email = driver.findElement(By.id("inputEmail"));
        email.sendKeys("librarian21@library");
        WebElement password = driver.findElement(By.id("inputPassword"));
        password.sendKeys("Sdet2022*");
        Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/logout2.png");
        WebElement loginButton= driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginButton.submit();

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbarDropdown\"]")));

        WebElement logOutDropBtn = driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]"));
        logOutDropBtn.click();

        Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/logout3.png");


        driver.findElement(By.cssSelector("a.dropdown-item")).click();
        Methods.takeSnapShot(driver, "//Users/olcaysenol/Desktop/library/logout4.png");
        driver.close();

    }
}

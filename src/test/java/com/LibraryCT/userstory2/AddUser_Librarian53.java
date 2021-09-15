package com.LibraryCT.userstory2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AddUser_Librarian53 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();


        driver.navigate().to("https://library2.cybertekschool.com/login.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement loginID= driver.findElement(By.xpath("//input[@type='email']"));
        loginID.sendKeys("librarian53@library");

        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("Sdet2022*");
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();

        WebElement usersModule = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
        usersModule.click();

        WebElement addUserButton= driver.findElement(By.xpath("//*[@id=\"users\"]/div[1]/div[1]/span/a"));
        addUserButton.click();

        WebElement fullName= driver.findElement(By.xpath("//input[@name='full_name']"));
        fullName.sendKeys("Beyza Senol");
        WebElement password2= driver.findElement(By.xpath("//input[@name='password']"));
        password2.sendKeys("1234567");
        WebElement email= driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("beyzasenol@gmail.com");
        WebElement address= driver.findElement(By.cssSelector("#address"));
        address.sendKeys("622 Kelso Rd, Pittsburgh PA, 15243");
        WebElement submitButton= driver.findElement(By.xpath("//*[@id=\"add_user_form\"]/div[2]/button[2]"));
        submitButton.click();











    }
}

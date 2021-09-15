package com.LibraryCT.userStory3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AddBook_Librarian21 {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.navigate().to("https://library2.cybertekschool.com/login.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebElement loginID= driver.findElement(By.xpath("//input[@type='email']"));
        loginID.sendKeys("librarian21@library");

        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("Sdet2022*");

        driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();

        //driver.findElement(By.xpath("//span[.='Books']")).sendKeys(Keys.ENTER);
        WebElement booksModule = driver.findElement(By.xpath("//span[contains(text(),'Books')]"));
        booksModule.click();
        WebElement addBook= driver.findElement(By.xpath("//a[@class='btn btn-lg btn-outline btn-primary btn-sm add_book_btn']"));
        addBook.click();

        WebElement nameOfBook= driver.findElement(By.xpath("//input[@name='name']"));
        nameOfBook.sendKeys("Attack on Titan");

        WebElement isbn= driver.findElement(By.xpath("//input[@name='isbn']"));
        isbn.sendKeys("978-1-63236-828-7");

        WebElement year= driver.findElement(By.xpath("//input[@name='year']"));
        year.sendKeys("2019");

        WebElement author= driver.findElement(By.xpath("//input[@name='author']"));
        author.sendKeys("Hajime Isayama");

        WebElement description= driver.findElement(By.cssSelector("#description"));
        description.sendKeys("a visceral and fantastically intense action/horror story");

        WebElement saveChanges= driver.findElement(By.xpath("//button[@type='submit']"));
        saveChanges.click();

        WebElement search= driver.findElement(By.xpath("//input[@type='search']"));
        search.sendKeys("Attack on Titan");


    }
}

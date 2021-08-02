package com.testng;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MultipleBrowsing {

    static {
        System.setProperty("webdriver.gecko.driver","C:\\Users\\Nishi\\IdeaProjects\\driver\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Nishi\\IdeaProjects\\driver\\chromedriver.exe");
    }
//    String driverPath = "C:\\Users\\Nishi\\IdeaProjects\\driver\\chromedriver.exe";
    WebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public void loadingBrowser (String browser) {
        if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }
    }


    @Test
    @Parameters({"Username","Password"})
    public void testParametersWithXML (String USERNAME, String PASSWORD) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", driverPath);
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://en-gb.facebook.com/");

        WebElement user = driver.findElement(By.cssSelector("#email"));
        user.sendKeys(USERNAME);
        WebElement pass = driver.findElement(By.cssSelector("#pass"));
        pass.sendKeys(PASSWORD);

        System.out.println("Your Credentials for Username : " + USERNAME + " and Password is : " + PASSWORD);
//        Thread.sleep(3000);
        System.out.println(user);
        System.out.println(pass);
    }
}

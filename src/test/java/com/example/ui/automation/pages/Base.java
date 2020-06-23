package com.example.ui.automation.pages;

import com.example.ui.automation.setup.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Base {
    @Autowired
    DriverManager dm;

    public String fetchPageTitle(){
       return dm.getDriver().getTitle();
    }

    public void jsClick(By locator){
        JavascriptExecutor executor = (JavascriptExecutor)dm.getDriver();
        executor.executeScript("arguments[0].click();", waitForElement(locator));
    }

    public void sleep(int t){
        try {
            Thread.sleep(t*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement waitForElement(By locator){
        Wait<WebDriver> wait= new FluentWait<>(dm.getDriver())
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        return wait.until(new Function<WebDriver, WebElement>(){
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
    }


}

package com.example.ui.automation.pages;

import com.example.ui.automation.setup.DriverManager;
import com.example.ui.automation.world.FBWorld;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public class Facebook extends Base {
    @Autowired
    DriverManager dm;
    @Autowired
    FBWorld fbw;

    public boolean login(String username, String password){
        waitForElement(By.id("email")).sendKeys(username);
        waitForElement(By.id("pass")).sendKeys(password);
        waitForElement(By.id("loginbutton")).click();
        return dm.getDriver().findElements(By.xpath("//a[@aria-label='Home']")).size() == 1;
    }
    public boolean postStatus(String message){
        waitForElement(By.xpath("//div[text()=\"What's on your mind, "+fbw.getFirstName()+"?\"]")).click();

        waitForElement(By.xpath("//div[text()=\"What's on your mind, "+fbw.getFirstName()+"?\" and contains(@id,'placeholder')]/parent::div/following-sibling::div//div[@role='textbox']")).sendKeys(message);

        waitForElement(By.xpath("//div[@role='button' and text()='Post']")).click();

        return false;
    }

    public void validateLogin(){
        WebDriverWait wait = new WebDriverWait(dm.getDriver(), 20);
        if(!waitForElement(By.xpath("//a[@href='/me/']//span")).isDisplayed())
            Assert.fail("Login failed!");
        fbw.setFirstName(waitForElement(By.xpath("//a[@href='/me/']//span")).getText());
    }


}

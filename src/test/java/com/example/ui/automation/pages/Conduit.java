package com.example.ui.automation.pages;

import com.example.ui.automation.setup.DriverManager;
import com.example.ui.automation.world.ConduitWorld;
import com.example.ui.automation.world.FBWorld;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public class Conduit extends Base {
    @Autowired
    DriverManager dm;
    @Autowired
    ConduitWorld cdw;

    public boolean login(String username, String password){
        waitForElement(By.xpath("//a[@ui-sref='app.login']")).click();
        waitForElement(By.xpath("//input[@placeholder='Email']")).sendKeys(username);
        waitForElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        waitForElement(By.xpath("//button[@type='submit']")).click();
        return dm.getDriver().findElements(By.xpath("//a[@ui-sref='app.home' and @ui-sref-active='active']")).size() >= 1;
    }

    public void postArticle(String description, String title, String content, String... tags){
        sleep(2);
        jsClick(By.xpath("//a[@ui-sref='app.editor']"));
        sleep(1);
        waitForElement(By.xpath("//input[@ng-model='$ctrl.article.title']")).sendKeys(title);
        sleep(1);
        waitForElement(By.xpath("//input[@ng-model='$ctrl.article.description']")).sendKeys(description);
        sleep(2);
        waitForElement(By.xpath("//textarea[@ng-model='$ctrl.article.body']")).sendKeys(content);
        sleep(1);
        if (tags.length>0) waitForElement(By.xpath("//input[@ng-model='$ctrl.tagField']")).sendKeys(tags[0]);
        sleep(2);
        waitForElement(By.xpath("//button[contains(text(),'Publish Article')]")).click();
    }
    public void verifyArticle(){
        Assert.assertEquals(cdw.getArticleTitle(),waitForElement(By.xpath("//h1")).getText());

    }
}

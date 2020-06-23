package com.example.ui.automation.stepdefinitions;

import com.example.ui.automation.pages.Conduit;
import com.example.ui.automation.world.ConduitWorld;
import io.cucumber.java8.En;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class ConduitSteps extends Conduit implements En {
    @Autowired
    ConduitWorld cdw;

    public ConduitSteps() {
        Given("^user has access to the conduit application$", () -> {
            Assert.assertTrue("Invalid Page Title!",fetchPageTitle().contains("Conduit"));
        });
        When("^user logs in with \"([^\"]*)\" and \"([^\"]*)\"$", (String username, String password) -> {
            if(!username.isEmpty() || !password.isEmpty())
                Assert.assertTrue("Login Failed!",login(username,password));
            else
                Assert.assertTrue("Login Failed!",login(cdw.getUsername(), cdw.getPassword()));
        });

        Then("^user posts an article about \"([^\"]*)\" with title as \"([^\"]*)\" and having content \"([^\"]*)\"$", (String description, String title, String content) -> {
            cdw.setArticleTitle(title);
            postArticle(description,title,content);
        });
        And("^verifies that the article is posted$", this::verifyArticle);
    }
}

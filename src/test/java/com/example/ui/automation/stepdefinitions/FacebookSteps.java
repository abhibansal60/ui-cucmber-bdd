package com.example.ui.automation.stepdefinitions;

import com.example.ui.automation.pages.Facebook;
import com.example.ui.automation.world.FBWorld;
import io.cucumber.java8.En;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class FacebookSteps extends Facebook implements En {
    @Autowired
    FBWorld fbw;

    public FacebookSteps() {

        Given("^user has access to the application$", () -> {
            Assert.assertTrue("Facebook",fetchPageTitle().startsWith("Facebook"));
        });
        When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$", (String username, String password) -> {
            if(!username.isEmpty() || !password.isEmpty())
                login(username,password);
            else
                login(fbw.getUsername(), fbw.getPassword());
        });

        Then("^validate user is logged in$", this::validateLogin);

        And("^post the status \"([^\"]*)\"$", this::postStatus);
    }
}

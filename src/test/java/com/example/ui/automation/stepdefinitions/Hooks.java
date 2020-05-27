package com.example.ui.automation.stepdefinitions;

import com.example.ui.automation.config.ServiceConfig;
import com.example.ui.automation.setup.DriverManager;
import com.example.ui.automation.world.FBWorld;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {ServiceConfig.class})
public class Hooks {
    @Autowired
    DriverManager dm;
    @Autowired
    FBWorld fbw;
    @Before
    public void beforeScenario(){
        dm.getDriver().get(fbw.getBaseURL());
    }
    @After
    public void tearDown(){
        //dm.closeBrowser();
    }
}

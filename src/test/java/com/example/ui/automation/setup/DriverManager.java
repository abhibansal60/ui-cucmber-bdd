package com.example.ui.automation.setup;

import com.example.ui.automation.world.BrowserWorld;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DriverManager {
    @Autowired
    BrowserWorld bw;
    private WebDriver driver;

    public WebDriver getDriver(){
        if(driver==null){
            DesiredCapabilities capabilities=DesiredCapabilities.chrome();;
            String chromeDriver=bw.getChromeWindows();
            switch (bw.getBrowser()){
                case "chrome":
                case "google chrome":
                    // Detailed reference, https://chromium.googlesource.com/chromium/src/+/master/chrome/common/chrome_switches.cc
                    ChromeOptions options= new ChromeOptions();
                    options.addArguments("no-sandbox");
                    options.addArguments("start-maximized");
                    options.addArguments("disable-extensions");
                    options.setExperimentalOption("useAutomationExtension",false);
                    if (bw.isHeadless()) options.addArguments("--headless");
                    if(bw.getOs().equals("linux")){
                        System.out.println("Running on a Linux machine...");
                        options.addArguments("--silent");
                        options.addArguments("ignore-certificate-errors");
                        options.addArguments("-allow-running-insecure-content");
                        options.addArguments("-window-size=1920,1080");
                        options.addArguments("--headless");
                        chromeDriver=bw.getChromeLinux();
                        //options.setBinary(bw.getChromeLinuxBinary());
                    }
                    System.setProperty("webdriver.chrome.driver",chromeDriver);
                    capabilities.setCapability(ChromeOptions.CAPABILITY,options);
                    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
                    driver=new ChromeDriver(capabilities);
                    break;
            }

        }
        return driver;
    }

    public void closeBrowser(){
        if (driver!=null) driver.quit();
    }

}

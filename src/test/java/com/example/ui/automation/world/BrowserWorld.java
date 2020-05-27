package com.example.ui.automation.world;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BrowserWorld {
    private String browser;
    private String os;
    boolean isHeadless;
    @Value("${driver.chrome.windows}")
    private String chromeWindows;
    @Value("${driver.chrome.linux}")
    private String chromeLinux;
    @Value("${driver.chrome.linux.binary}")
    private String chromeLinuxBinary;
    @Value("${driver.ff.windows}")
    private String firefox;
    @Value("${driver.ie.windows}")
    private String ie;



    public String getBrowser() {
        //If command linke argument browser is not set, use chrome browser
        return System.getProperty("browser") == null ? "chrome" : System.getProperty("browser").toLowerCase();
    }

    public String getOs() {
        return System.getProperty("os.name").toLowerCase();
    }

    public String getChromeWindows() {
        return chromeWindows;
    }

    public String getChromeLinux() {
        return chromeLinux;
    }

    public String getChromeLinuxBinary() {
        return chromeLinuxBinary;
    }

    public String getFirefox() {
        return firefox;
    }

    public String getIe() {
        return ie;
    }

    public boolean isHeadless() {
        return (System.getProperty("headless")!=null && System.getProperty("headless").equals("true"));
    }
}

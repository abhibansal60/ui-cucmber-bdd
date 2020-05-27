package com.example.ui.automation.world;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FBWorld {
    @Value("${fb.base.url}")
    private String baseURL;
    @Value("${fb.username}")
    private String username;
    @Value("${fb.password}")
    private String password;
    private String firstName;

    public String getBaseURL() {
        return baseURL;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}

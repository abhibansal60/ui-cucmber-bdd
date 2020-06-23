package com.example.ui.automation.world;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConduitWorld {
    @Value("${conduit.base.url}")
    private String baseURL;
    @Value("${conduit.username}")
    private String username;
    @Value("${conduit.password}")
    private String password;
    private String articleTitle;

    public String getBaseURL() {
        return baseURL;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }
}

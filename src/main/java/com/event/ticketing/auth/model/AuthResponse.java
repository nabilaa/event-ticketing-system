package com.event.ticketing.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class AuthResponse {
    private String accessToken;
    private String tokenType;
    private Long expiresIn;
    private UserModel user;

    public AuthResponse() {
    }

    public AuthResponse(String accessToken, String tokenType, Long expiresIn, UserModel user) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
        this.user = user;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}

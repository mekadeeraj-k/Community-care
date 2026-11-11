package com.community.dao;

public enum PresidentCredentials {

    PRESIDENT("president_url", "president_password");

    private final String email;
    private final String password;

    PresidentCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
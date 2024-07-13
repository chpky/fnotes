package com.chpky.fnotes.model;

public class User {
    private final String id;
    private final String username;
    private final String password;
    private final String family;

    public User(String id, String username, String password, String family) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.family = family;
    }
    public boolean IsSameUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public String getId() {
        return id;
    }

    public String getFamily() {
        return family;
    }

    @Override
    public String toString() {
        return "User: " + username + "\nPassword: " + password;
    }
}

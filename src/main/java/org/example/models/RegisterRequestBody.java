package org.example.models;

public class RegisterRequestBody {
    private boolean accepted_terms;
    private String username;
    private String full_name;
    private String email;
    private String password;
    private String type;

    public boolean isAccepted_terms() {
        return accepted_terms;
    }

    public void setAccepted_terms(boolean accepted_terms) {
        this.accepted_terms = accepted_terms;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

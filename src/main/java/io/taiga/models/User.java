package io.taiga.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    public int id;
    private String username;
    private String full_name;
    private String full_name_display;
    private String bio;
    private String lang;
    private String color;
    private Boolean is_active;
    private String email;
    private String uuid;
    private String theme;
    private String timezone;
    private String photo;
    private String big_photo;
    private String gravatar_id;
    private String[] roles;
    private Boolean accepted_terms;
    private Boolean verified_email;
    private Boolean read_new_terms;
    private String auth_token;
    private String refresh;
    private String date_joined;
    public int total_private_projects;
    public int total_public_projects;
    public int max_private_projects;
    public int max_public_projects;
    public int max_memberships_private_projects;
    public int max_memberships_public_projects;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBig_photo() {
        return big_photo;
    }

    public void setBig_photo(String big_photo) {
        this.big_photo = big_photo;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public void setGravatar_id(String gravatar_id) {
        this.gravatar_id = gravatar_id;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public Boolean getRead_new_terms() {
        return read_new_terms;
    }

    public void setRead_new_terms(Boolean read_new_terms) {
        this.read_new_terms = read_new_terms;
    }

    public String getRefresh() {
        return refresh;
    }

    public void setRefresh(String refresh) {
        this.refresh = refresh;
    }

    public String getDate_joined() {
        return date_joined;
    }

    public void setDate_joined(String date_joined) {
        this.date_joined = date_joined;
    }

    public int getTotal_private_projects() {
        return total_private_projects;
    }

    public void setTotal_private_projects(int total_private_projects) {
        this.total_private_projects = total_private_projects;
    }

    public int getTotal_public_projects() {
        return total_public_projects;
    }

    public void setTotal_public_projects(int total_public_projects) {
        this.total_public_projects = total_public_projects;
    }

    public int getMax_private_projects() {
        return max_private_projects;
    }

    public void setMax_private_projects(int max_private_projects) {
        this.max_private_projects = max_private_projects;
    }

    public int getMax_public_projects() {
        return max_public_projects;
    }

    public void setMax_public_projects(int max_public_projects) {
        this.max_public_projects = max_public_projects;
    }

    public int getMax_memberships_private_projects() {
        return max_memberships_private_projects;
    }

    public void setMax_memberships_private_projects(int max_memberships_private_projects) {
        this.max_memberships_private_projects = max_memberships_private_projects;
    }

    public int getMax_memberships_public_projects() {
        return max_memberships_public_projects;
    }

    public void setMax_memberships_public_projects(int max_memberships_public_projects) {
        this.max_memberships_public_projects = max_memberships_public_projects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFull_name_display() {
        return full_name_display;
    }

    public void setFull_name_display(String full_name_display) {
        this.full_name_display = full_name_display;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Boolean getAccepted_terms() {
        return accepted_terms;
    }

    public void setAccepted_terms(Boolean accepted_terms) {
        this.accepted_terms = accepted_terms;
    }

    public Boolean getVerified_email() {
        return verified_email;
    }

    public void setVerified_email(Boolean verified_email) {
        this.verified_email = verified_email;
    }

    public String getAuth_token() {
        return auth_token;
    }

    public void setAuth_token(String auth_token) {
        this.auth_token = auth_token;
    }
}

package io.taiga.models;

public class Owner{
    public String username;
    public String full_name_display;
    public Object photo;
    public Object big_photo;
    public String gravatar_id;
    public boolean is_active;
    public int id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFull_name_display() {
        return full_name_display;
    }

    public void setFull_name_display(String full_name_display) {
        this.full_name_display = full_name_display;
    }

    public Object getPhoto() {
        return photo;
    }

    public void setPhoto(Object photo) {
        this.photo = photo;
    }

    public Object getBig_photo() {
        return big_photo;
    }

    public void setBig_photo(Object big_photo) {
        this.big_photo = big_photo;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public void setGravatar_id(String gravatar_id) {
        this.gravatar_id = gravatar_id;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

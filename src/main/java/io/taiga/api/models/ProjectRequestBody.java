package io.taiga.api.models;

public class ProjectRequestBody {

    private String name;
    private String description;
    private int creation_template;
    private boolean is_private;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreation_template() {
        return creation_template;
    }

    public void setCreation_template(int creation_template) {
        this.creation_template = creation_template;
    }

    public boolean isIs_private() {
        return is_private;
    }

    public void setIs_private(boolean is_private) {
        this.is_private = is_private;
    }
}

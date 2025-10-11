package org.example.models;

public class TaskDuedate{
    public int id;
    public String name;
    public int order;
    public boolean by_default;
    public String color;
    public int days_to_due;
    public int project_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isBy_default() {
        return by_default;
    }

    public void setBy_default(boolean by_default) {
        this.by_default = by_default;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDays_to_due() {
        return days_to_due;
    }

    public void setDays_to_due(int days_to_due) {
        this.days_to_due = days_to_due;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }
}

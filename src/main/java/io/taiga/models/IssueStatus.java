package io.taiga.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class IssueStatus{
    private int id;
    private String name;
    private int order;
    private boolean is_closed;
    private String color;
    private int project_id;
    private String slug;
}

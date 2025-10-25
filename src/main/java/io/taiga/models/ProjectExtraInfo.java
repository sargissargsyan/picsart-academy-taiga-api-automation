package io.taiga.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectExtraInfo {
    public String name;
    public String slug;
    public Object logo_small_url;
    public Integer id;
}

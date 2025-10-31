package io.taiga.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OwnerExtraInfo {
    public String username;
    public String full_name_display;
    public Object photo;
    public Object big_photo;
    public String gravatar_id;
    public Boolean is_active;
    public Integer id;
}

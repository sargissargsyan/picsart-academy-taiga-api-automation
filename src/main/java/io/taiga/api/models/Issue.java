package io.taiga.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Issue {
    private ArrayList<Object> tags;
    private Date due_date;
    private String due_date_reason;
    private String due_date_status;
    private ArrayList<Object> attachments;
    private int project;
    private Project project_extra_info;
    private Integer status;
    private IssueStatus status_extra_info;
    private User assigned_to;
    private Object assigned_to_extra_info;
    private Integer owner;
    private Owner owner_extra_info;
    private Boolean is_watcher;
    private Integer total_watchers;
    private Boolean is_voter;
    private Integer total_voters;
    private Integer id;
    private Integer ref;
    private Integer severity;
    private Integer priority;
    private Integer type;
    private Object milestone;
    private Date created_date;
    private Date modified_date;
    private Object finished_date;
    private String subject;
    private Object external_reference;
    private Integer version;
    private ArrayList<Object> watchers;
    private Boolean is_blocked;
    private String blocked_note;
    private Boolean is_closed;
    private String comment;
    private Object generated_user_stories;
    private String blocked_note_html;
    private String description;
    private String description_html;
}
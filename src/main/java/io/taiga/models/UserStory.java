package io.taiga.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserStory {
    public Date due_date;
    public String due_date_reason;
    public String due_date_status;
    public int total_comments;
    public ArrayList<Object> tags;
    public ArrayList<Object> attachments;
    public Integer status;
    public StatusExtraInfo status_extra_info;
    public User assigned_to;
    public Object assigned_to_extra_info;
    public Integer owner;
    public OwnerExtraInfo owner_extra_info;
    public Boolean is_watcher;
    public Integer total_watchers;
    public Boolean is_voter;
    public Integer total_voters;
    public Integer project;
    public ProjectExtraInfo project_extra_info;
    public Integer id;
    public Integer ref;
    public Object milestone;
    public Object milestone_slug;
    public Object milestone_name;
    public boolean is_closed;
    public Map<String, Integer> points;
    public Long backlog_order;
    public Long sprint_order;
    public Long kanban_order;
    public Date created_date;
    public Date modified_date;
    public Date finish_date;
    public String subject;
    public Boolean client_requirement;
    public Boolean team_requirement;
    public Object generated_from_issue;
    public Object generated_from_task;
    public Object from_task_ref;
    public Object external_reference;
    public Object tribe_gig;
    public Integer version;
    public ArrayList<Object> watchers;
    public Boolean is_blocked;
    public String blocked_note;
    public Object total_points;
    public String comment;
    public Issue origin_issue;
    public Object origin_task;
    public Object epics;
    public Object epic_order;
    public ArrayList<Object> tasks;
    public Integer total_attachments;
    public Object swimlane;
    public ArrayList<User> assigned_users;
    public String blocked_note_html;
    public String description;
    public String description_html;
}

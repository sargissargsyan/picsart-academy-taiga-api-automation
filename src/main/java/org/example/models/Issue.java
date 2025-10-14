package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
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

    public ArrayList<Object> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Object> tags) {
        this.tags = tags;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public String getDue_date_reason() {
        return due_date_reason;
    }

    public void setDue_date_reason(String due_date_reason) {
        this.due_date_reason = due_date_reason;
    }

    public String getDue_date_status() {
        return due_date_status;
    }

    public void setDue_date_status(String due_date_status) {
        this.due_date_status = due_date_status;
    }

    public ArrayList<Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(ArrayList<Object> attachments) {
        this.attachments = attachments;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public Project getProject_extra_info() {
        return project_extra_info;
    }

    public void setProject_extra_info(Project project_extra_info) {
        this.project_extra_info = project_extra_info;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public IssueStatus getStatus_extra_info() {
        return status_extra_info;
    }

    public void setStatus_extra_info(IssueStatus status_extra_info) {
        this.status_extra_info = status_extra_info;
    }

    public User getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(User assigned_to) {
        this.assigned_to = assigned_to;
    }

    public Object getAssigned_to_extra_info() {
        return assigned_to_extra_info;
    }

    public void setAssigned_to_extra_info(Object assigned_to_extra_info) {
        this.assigned_to_extra_info = assigned_to_extra_info;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public Owner getOwner_extra_info() {
        return owner_extra_info;
    }

    public void setOwner_extra_info(Owner owner_extra_info) {
        this.owner_extra_info = owner_extra_info;
    }

    public Boolean isIs_watcher() {
        return is_watcher;
    }

    public void setIs_watcher(Boolean is_watcher) {
        this.is_watcher = is_watcher;
    }

    public Integer getTotal_watchers() {
        return total_watchers;
    }

    public void setTotal_watchers(Integer total_watchers) {
        this.total_watchers = total_watchers;
    }

    public Boolean isIs_voter() {
        return is_voter;
    }

    public void setIs_voter(Boolean is_voter) {
        this.is_voter = is_voter;
    }

    public Integer getTotal_voters() {
        return total_voters;
    }

    public void setTotal_voters(Integer total_voters) {
        this.total_voters = total_voters;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRef() {
        return ref;
    }

    public void setRef(Integer ref) {
        this.ref = ref;
    }

    public Integer getSeverity() {
        return severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Object getMilestone() {
        return milestone;
    }

    public void setMilestone(Object milestone) {
        this.milestone = milestone;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getModified_date() {
        return modified_date;
    }

    public void setModified_date(Date modified_date) {
        this.modified_date = modified_date;
    }

    public Object getFinished_date() {
        return finished_date;
    }

    public void setFinished_date(Object finished_date) {
        this.finished_date = finished_date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Object getExternal_reference() {
        return external_reference;
    }

    public void setExternal_reference(Object external_reference) {
        this.external_reference = external_reference;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public ArrayList<Object> getWatchers() {
        return watchers;
    }

    public void setWatchers(ArrayList<Object> watchers) {
        this.watchers = watchers;
    }

    public Boolean isIs_blocked() {
        return is_blocked;
    }

    public void setIs_blocked(Boolean is_blocked) {
        this.is_blocked = is_blocked;
    }

    public String getBlocked_note() {
        return blocked_note;
    }

    public void setBlocked_note(String blocked_note) {
        this.blocked_note = blocked_note;
    }

    public Boolean isIs_closed() {
        return is_closed;
    }

    public void setIs_closed(Boolean is_closed) {
        this.is_closed = is_closed;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Object getGenerated_user_stories() {
        return generated_user_stories;
    }

    public void setGenerated_user_stories(Object generated_user_stories) {
        this.generated_user_stories = generated_user_stories;
    }

    public String getBlocked_note_html() {
        return blocked_note_html;
    }

    public void setBlocked_note_html(String blocked_note_html) {
        this.blocked_note_html = blocked_note_html;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription_html() {
        return description_html;
    }

    public void setDescription_html(String description_html) {
        this.description_html = description_html;
    }
}
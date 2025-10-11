package org.example.models;

import java.util.ArrayList;
import java.util.Date;

public class Project {
    private int id;
    private String name;
    private String slug;
    private String description;
    private Date created_date;
    private Date modified_date;
    private Owner owner;
    private ArrayList<Member> members;
    private Object total_milestones;
    private Object total_story_points;
    private boolean is_contact_activated;
    private boolean is_epics_activated;
    private boolean is_backlog_activated;
    private boolean is_kanban_activated;
    private boolean is_wiki_activated;
    private boolean is_issues_activated;
    private Object videoconferences;
    private Object videoconferences_extra_data;
    private int creation_template;
    private boolean is_private;
    private ArrayList<String> anon_permissions;
    private ArrayList<String> public_permissions;
    private boolean is_featured;
    private boolean is_looking_for_people;
    private String looking_for_people_note;
    private Object blocked_code;
    private Date totals_updated_datetime;
    private int total_fans;
    private int total_fans_last_week;
    private int total_fans_last_month;
    private int total_fans_last_year;
    private int total_activity;
    private int total_activity_last_week;
    private int total_activity_last_month;
    private int total_activity_last_year;
    private ArrayList<Object> tags;
    private TagsColors tags_colors;
    private int default_epic_status;
    private int default_points;
    private int default_us_status;
    private int default_task_status;
    private int default_priority;
    private int default_severity;
    private int default_issue_status;
    private int default_issue_type;
    private Object default_swimlane;
    private ArrayList<String> my_permissions;
    private boolean i_am_owner;
    private boolean i_am_admin;
    private boolean i_am_member;
    private int notify_level;
    private int total_closed_milestones;
    private boolean is_watcher;
    private int total_watchers;
    private Object logo_small_url;
    private Object logo_big_url;
    private boolean is_fan;
    private boolean my_homepage;
    private ArrayList<EpicStatus> epic_statuses;
    private Object swimlanes;
    private ArrayList<UsStatus> us_statuses;
    private ArrayList<UsDuedate> us_duedates;
    private ArrayList<Point> points;
    private ArrayList<TaskStatus> task_statuses;
    private ArrayList<TaskDuedate> task_duedates;
    private ArrayList<IssueStatus> issue_statuses;
    private ArrayList<IssueType> issue_types;
    private ArrayList<IssueDuedate> issue_duedates;
    private ArrayList<Priority> priorities;
    private ArrayList<Severity> severities;
    private Object epic_custom_attributes;
    private Object userstory_custom_attributes;
    private Object task_custom_attributes;
    private Object issue_custom_attributes;
    private ArrayList<Role> roles;
    private int total_memberships;
    private boolean is_out_of_owner_limits;
    private PrivateExtraInfo is_private_extra_info;
    private Object max_memberships;
    private Object epics_csv_uuid;
    private Object userstories_csv_uuid;
    private Object tasks_csv_uuid;
    private Object issues_csv_uuid;
    private Object transfer_token;
    private ArrayList<Object> milestones;

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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public Object getTotal_milestones() {
        return total_milestones;
    }

    public void setTotal_milestones(Object total_milestones) {
        this.total_milestones = total_milestones;
    }

    public Object getTotal_story_points() {
        return total_story_points;
    }

    public void setTotal_story_points(Object total_story_points) {
        this.total_story_points = total_story_points;
    }

    public boolean isIs_contact_activated() {
        return is_contact_activated;
    }

    public void setIs_contact_activated(boolean is_contact_activated) {
        this.is_contact_activated = is_contact_activated;
    }

    public boolean isIs_epics_activated() {
        return is_epics_activated;
    }

    public void setIs_epics_activated(boolean is_epics_activated) {
        this.is_epics_activated = is_epics_activated;
    }

    public boolean isIs_backlog_activated() {
        return is_backlog_activated;
    }

    public void setIs_backlog_activated(boolean is_backlog_activated) {
        this.is_backlog_activated = is_backlog_activated;
    }

    public boolean isIs_kanban_activated() {
        return is_kanban_activated;
    }

    public void setIs_kanban_activated(boolean is_kanban_activated) {
        this.is_kanban_activated = is_kanban_activated;
    }

    public boolean isIs_wiki_activated() {
        return is_wiki_activated;
    }

    public void setIs_wiki_activated(boolean is_wiki_activated) {
        this.is_wiki_activated = is_wiki_activated;
    }

    public boolean isIs_issues_activated() {
        return is_issues_activated;
    }

    public void setIs_issues_activated(boolean is_issues_activated) {
        this.is_issues_activated = is_issues_activated;
    }

    public Object getVideoconferences() {
        return videoconferences;
    }

    public void setVideoconferences(Object videoconferences) {
        this.videoconferences = videoconferences;
    }

    public Object getVideoconferences_extra_data() {
        return videoconferences_extra_data;
    }

    public void setVideoconferences_extra_data(Object videoconferences_extra_data) {
        this.videoconferences_extra_data = videoconferences_extra_data;
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

    public ArrayList<String> getAnon_permissions() {
        return anon_permissions;
    }

    public void setAnon_permissions(ArrayList<String> anon_permissions) {
        this.anon_permissions = anon_permissions;
    }

    public ArrayList<String> getPublic_permissions() {
        return public_permissions;
    }

    public void setPublic_permissions(ArrayList<String> public_permissions) {
        this.public_permissions = public_permissions;
    }

    public boolean isIs_featured() {
        return is_featured;
    }

    public void setIs_featured(boolean is_featured) {
        this.is_featured = is_featured;
    }

    public boolean isIs_looking_for_people() {
        return is_looking_for_people;
    }

    public void setIs_looking_for_people(boolean is_looking_for_people) {
        this.is_looking_for_people = is_looking_for_people;
    }

    public String getLooking_for_people_note() {
        return looking_for_people_note;
    }

    public void setLooking_for_people_note(String looking_for_people_note) {
        this.looking_for_people_note = looking_for_people_note;
    }

    public Object getBlocked_code() {
        return blocked_code;
    }

    public void setBlocked_code(Object blocked_code) {
        this.blocked_code = blocked_code;
    }

    public Date getTotals_updated_datetime() {
        return totals_updated_datetime;
    }

    public void setTotals_updated_datetime(Date totals_updated_datetime) {
        this.totals_updated_datetime = totals_updated_datetime;
    }

    public int getTotal_fans() {
        return total_fans;
    }

    public void setTotal_fans(int total_fans) {
        this.total_fans = total_fans;
    }

    public int getTotal_fans_last_week() {
        return total_fans_last_week;
    }

    public void setTotal_fans_last_week(int total_fans_last_week) {
        this.total_fans_last_week = total_fans_last_week;
    }

    public int getTotal_fans_last_month() {
        return total_fans_last_month;
    }

    public void setTotal_fans_last_month(int total_fans_last_month) {
        this.total_fans_last_month = total_fans_last_month;
    }

    public int getTotal_fans_last_year() {
        return total_fans_last_year;
    }

    public void setTotal_fans_last_year(int total_fans_last_year) {
        this.total_fans_last_year = total_fans_last_year;
    }

    public int getTotal_activity() {
        return total_activity;
    }

    public void setTotal_activity(int total_activity) {
        this.total_activity = total_activity;
    }

    public int getTotal_activity_last_week() {
        return total_activity_last_week;
    }

    public void setTotal_activity_last_week(int total_activity_last_week) {
        this.total_activity_last_week = total_activity_last_week;
    }

    public int getTotal_activity_last_month() {
        return total_activity_last_month;
    }

    public void setTotal_activity_last_month(int total_activity_last_month) {
        this.total_activity_last_month = total_activity_last_month;
    }

    public int getTotal_activity_last_year() {
        return total_activity_last_year;
    }

    public void setTotal_activity_last_year(int total_activity_last_year) {
        this.total_activity_last_year = total_activity_last_year;
    }

    public ArrayList<Object> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Object> tags) {
        this.tags = tags;
    }

    public TagsColors getTags_colors() {
        return tags_colors;
    }

    public void setTags_colors(TagsColors tags_colors) {
        this.tags_colors = tags_colors;
    }

    public int getDefault_epic_status() {
        return default_epic_status;
    }

    public void setDefault_epic_status(int default_epic_status) {
        this.default_epic_status = default_epic_status;
    }

    public int getDefault_points() {
        return default_points;
    }

    public void setDefault_points(int default_points) {
        this.default_points = default_points;
    }

    public int getDefault_us_status() {
        return default_us_status;
    }

    public void setDefault_us_status(int default_us_status) {
        this.default_us_status = default_us_status;
    }

    public int getDefault_task_status() {
        return default_task_status;
    }

    public void setDefault_task_status(int default_task_status) {
        this.default_task_status = default_task_status;
    }

    public int getDefault_priority() {
        return default_priority;
    }

    public void setDefault_priority(int default_priority) {
        this.default_priority = default_priority;
    }

    public int getDefault_severity() {
        return default_severity;
    }

    public void setDefault_severity(int default_severity) {
        this.default_severity = default_severity;
    }

    public int getDefault_issue_status() {
        return default_issue_status;
    }

    public void setDefault_issue_status(int default_issue_status) {
        this.default_issue_status = default_issue_status;
    }

    public int getDefault_issue_type() {
        return default_issue_type;
    }

    public void setDefault_issue_type(int default_issue_type) {
        this.default_issue_type = default_issue_type;
    }

    public Object getDefault_swimlane() {
        return default_swimlane;
    }

    public void setDefault_swimlane(Object default_swimlane) {
        this.default_swimlane = default_swimlane;
    }

    public ArrayList<String> getMy_permissions() {
        return my_permissions;
    }

    public void setMy_permissions(ArrayList<String> my_permissions) {
        this.my_permissions = my_permissions;
    }

    public boolean isI_am_owner() {
        return i_am_owner;
    }

    public void setI_am_owner(boolean i_am_owner) {
        this.i_am_owner = i_am_owner;
    }

    public boolean isI_am_admin() {
        return i_am_admin;
    }

    public void setI_am_admin(boolean i_am_admin) {
        this.i_am_admin = i_am_admin;
    }

    public boolean isI_am_member() {
        return i_am_member;
    }

    public void setI_am_member(boolean i_am_member) {
        this.i_am_member = i_am_member;
    }

    public int getNotify_level() {
        return notify_level;
    }

    public void setNotify_level(int notify_level) {
        this.notify_level = notify_level;
    }

    public int getTotal_closed_milestones() {
        return total_closed_milestones;
    }

    public void setTotal_closed_milestones(int total_closed_milestones) {
        this.total_closed_milestones = total_closed_milestones;
    }

    public boolean isIs_watcher() {
        return is_watcher;
    }

    public void setIs_watcher(boolean is_watcher) {
        this.is_watcher = is_watcher;
    }

    public int getTotal_watchers() {
        return total_watchers;
    }

    public void setTotal_watchers(int total_watchers) {
        this.total_watchers = total_watchers;
    }

    public Object getLogo_small_url() {
        return logo_small_url;
    }

    public void setLogo_small_url(Object logo_small_url) {
        this.logo_small_url = logo_small_url;
    }

    public Object getLogo_big_url() {
        return logo_big_url;
    }

    public void setLogo_big_url(Object logo_big_url) {
        this.logo_big_url = logo_big_url;
    }

    public boolean isIs_fan() {
        return is_fan;
    }

    public void setIs_fan(boolean is_fan) {
        this.is_fan = is_fan;
    }

    public boolean isMy_homepage() {
        return my_homepage;
    }

    public void setMy_homepage(boolean my_homepage) {
        this.my_homepage = my_homepage;
    }

    public ArrayList<EpicStatus> getEpic_statuses() {
        return epic_statuses;
    }

    public void setEpic_statuses(ArrayList<EpicStatus> epic_statuses) {
        this.epic_statuses = epic_statuses;
    }

    public Object getSwimlanes() {
        return swimlanes;
    }

    public void setSwimlanes(Object swimlanes) {
        this.swimlanes = swimlanes;
    }

    public ArrayList<UsStatus> getUs_statuses() {
        return us_statuses;
    }

    public void setUs_statuses(ArrayList<UsStatus> us_statuses) {
        this.us_statuses = us_statuses;
    }

    public ArrayList<UsDuedate> getUs_duedates() {
        return us_duedates;
    }

    public void setUs_duedates(ArrayList<UsDuedate> us_duedates) {
        this.us_duedates = us_duedates;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    public ArrayList<TaskStatus> getTask_statuses() {
        return task_statuses;
    }

    public void setTask_statuses(ArrayList<TaskStatus> task_statuses) {
        this.task_statuses = task_statuses;
    }

    public ArrayList<TaskDuedate> getTask_duedates() {
        return task_duedates;
    }

    public void setTask_duedates(ArrayList<TaskDuedate> task_duedates) {
        this.task_duedates = task_duedates;
    }

    public ArrayList<IssueStatus> getIssue_statuses() {
        return issue_statuses;
    }

    public void setIssue_statuses(ArrayList<IssueStatus> issue_statuses) {
        this.issue_statuses = issue_statuses;
    }

    public ArrayList<IssueType> getIssue_types() {
        return issue_types;
    }

    public void setIssue_types(ArrayList<IssueType> issue_types) {
        this.issue_types = issue_types;
    }

    public ArrayList<IssueDuedate> getIssue_duedates() {
        return issue_duedates;
    }

    public void setIssue_duedates(ArrayList<IssueDuedate> issue_duedates) {
        this.issue_duedates = issue_duedates;
    }

    public ArrayList<Priority> getPriorities() {
        return priorities;
    }

    public void setPriorities(ArrayList<Priority> priorities) {
        this.priorities = priorities;
    }

    public ArrayList<Severity> getSeverities() {
        return severities;
    }

    public void setSeverities(ArrayList<Severity> severities) {
        this.severities = severities;
    }

    public Object getEpic_custom_attributes() {
        return epic_custom_attributes;
    }

    public void setEpic_custom_attributes(Object epic_custom_attributes) {
        this.epic_custom_attributes = epic_custom_attributes;
    }

    public Object getUserstory_custom_attributes() {
        return userstory_custom_attributes;
    }

    public void setUserstory_custom_attributes(Object userstory_custom_attributes) {
        this.userstory_custom_attributes = userstory_custom_attributes;
    }

    public Object getTask_custom_attributes() {
        return task_custom_attributes;
    }

    public void setTask_custom_attributes(Object task_custom_attributes) {
        this.task_custom_attributes = task_custom_attributes;
    }

    public Object getIssue_custom_attributes() {
        return issue_custom_attributes;
    }

    public void setIssue_custom_attributes(Object issue_custom_attributes) {
        this.issue_custom_attributes = issue_custom_attributes;
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Role> roles) {
        this.roles = roles;
    }

    public int getTotal_memberships() {
        return total_memberships;
    }

    public void setTotal_memberships(int total_memberships) {
        this.total_memberships = total_memberships;
    }

    public boolean isIs_out_of_owner_limits() {
        return is_out_of_owner_limits;
    }

    public void setIs_out_of_owner_limits(boolean is_out_of_owner_limits) {
        this.is_out_of_owner_limits = is_out_of_owner_limits;
    }

    public PrivateExtraInfo getIs_private_extra_info() {
        return is_private_extra_info;
    }

    public void setIs_private_extra_info(PrivateExtraInfo is_private_extra_info) {
        this.is_private_extra_info = is_private_extra_info;
    }

    public Object getMax_memberships() {
        return max_memberships;
    }

    public void setMax_memberships(Object max_memberships) {
        this.max_memberships = max_memberships;
    }

    public Object getEpics_csv_uuid() {
        return epics_csv_uuid;
    }

    public void setEpics_csv_uuid(Object epics_csv_uuid) {
        this.epics_csv_uuid = epics_csv_uuid;
    }

    public Object getUserstories_csv_uuid() {
        return userstories_csv_uuid;
    }

    public void setUserstories_csv_uuid(Object userstories_csv_uuid) {
        this.userstories_csv_uuid = userstories_csv_uuid;
    }

    public Object getTasks_csv_uuid() {
        return tasks_csv_uuid;
    }

    public void setTasks_csv_uuid(Object tasks_csv_uuid) {
        this.tasks_csv_uuid = tasks_csv_uuid;
    }

    public Object getIssues_csv_uuid() {
        return issues_csv_uuid;
    }

    public void setIssues_csv_uuid(Object issues_csv_uuid) {
        this.issues_csv_uuid = issues_csv_uuid;
    }

    public Object getTransfer_token() {
        return transfer_token;
    }

    public void setTransfer_token(Object transfer_token) {
        this.transfer_token = transfer_token;
    }

    public ArrayList<Object> getMilestones() {
        return milestones;
    }

    public void setMilestones(ArrayList<Object> milestones) {
        this.milestones = milestones;
    }
}

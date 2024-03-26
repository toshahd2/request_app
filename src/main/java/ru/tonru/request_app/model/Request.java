package ru.tonru.request_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Request {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String company;
    private String contact;
    private String task;
    private String status;
    private String comment;
    public Request() {
    }

    public Request(String company, String contact, String task, String status, String comment) {
        this.company = company;
        this.contact = contact;
        this.task = task;
        this.status = status;
        this.comment = comment;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    public String getCompany() {
        return company;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getContact() {
        return contact;
    }
    public void setTask(String task) {
        this.task = task;
    }
    public String getTask() {
        return task;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}

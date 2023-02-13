package com.javaguides.sample.model;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="user_id")
    private Integer user_id;
    @Column(name="task_name")
    private String taskname;
    @Column(name="task_desc")
    private String taskdesc;
    @Column(name="status")
    private Integer status;
    
    
//    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    public Date date_added = new Date(System.currentTimeMillis());
    
//    @PrePersist
//    private void onCreate() {
//    	date_added = new Date();
//    }
   
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Integer getUser_id() {
        return user_id;
    }
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    public String getTaskname() {
        return taskname;
    }
    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }
    public String getTaskdesc() {
        return taskdesc;
    }
    public void setTaskdesc(String taskdesc) {
        this.taskdesc = taskdesc;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }   
    }
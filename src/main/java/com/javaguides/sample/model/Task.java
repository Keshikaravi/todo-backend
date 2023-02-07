package com.javaguides.sample.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="task")
public class Task {
    @Id
   // @Column(name="task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="task_name")
    private String taskname;
    @Column(name="task_desc")
    private String taskdesc;
    @Column(name="status")
    private Integer status;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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

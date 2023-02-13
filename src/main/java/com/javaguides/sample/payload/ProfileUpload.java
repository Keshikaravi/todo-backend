package com.javaguides.sample.payload;

import org.springframework.web.multipart.MultipartFile;

public class ProfileUpload {

    private String firstname;

    private String lastname;

    private int age;

    private String mail;
    
    private MultipartFile file;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setfile(MultipartFile file) {
        this.file = file;
    }

    
}

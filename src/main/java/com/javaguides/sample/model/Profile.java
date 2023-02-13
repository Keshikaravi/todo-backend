package com.javaguides.sample.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="profile")
public class Profile {
    @Id
   // @Column(name="task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
   
    @Column(name="first_name")
    private String firstname;
    @Column(name="last_name")
    private String lastname;
    @Column(name="age")
    private Integer age;
    @Column(name="mail_id")
    private String mail;
    @Column(name = "photo")
    private byte[] photo;
    
    
    public Profile() {
    	super();
    }
    		
    public Profile(String firstname, String lastname, Integer age, String mail, byte[] photo) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.mail = mail;
		this.photo = photo;
	}
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
   
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
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
   
    public byte[] getPhoto() {
        return photo;
    }
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
     
    }
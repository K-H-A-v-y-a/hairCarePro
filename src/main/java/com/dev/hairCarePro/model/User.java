package com.dev.hairCarePro.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fname", nullable = false, length = 255)
    private String fname;

    @Column(name = "lname", nullable = false, length = 255)
    private String lname;

    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "passwrd", nullable = false, length = 255)
    private String passwrd;

    @Column(name = "user_type", nullable = false, length = 50)
    private String userType;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswrd() {
        return passwrd;
    }

    public void setPasswrd(String passwrd) {
        this.passwrd = passwrd;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    // Constructors

    public User() {
        this.userType = "user";  // Default value for new users
    }

    public User(String fname, String lname, String email, String passwrd) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.passwrd = passwrd;
        this.userType = "user";  // Default value for new users
    }

    // toString() method

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", passwrd='" + passwrd + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }

    // Automatically set the userType before persisting the user entity
    @PrePersist
    public void prePersist() {
        if (this.userType == null) {
            this.userType = "user"; // Default to "user" if not set
        }
    }
}

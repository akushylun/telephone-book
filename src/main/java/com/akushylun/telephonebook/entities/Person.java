package com.akushylun.telephonebook.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "u_id")
    private int id;

    @Column(name = "u_full_name")
    @NotNull
    @Size(min = 5, max = 50)
    private String fullName;

    @Column(name = "u_username", unique = true)
    @NotNull
    @Size(min = 3, max = 50)
    @Pattern(regexp = "^[a-zA-Z]+")
    private String username;

    @Column(name = "u_password")
    @NotNull
    @Size(min = 5, max = 50)
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    private List<Record> records;

    public Person() {
    }

    public Person(int id, String fullName, String username, String password) {
	this.id = id;
	this.fullName = fullName;
	this.username = username;
	this.password = password;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getFullName() {
	return fullName;
    }

    public void setFullName(String fullName) {
	this.fullName = fullName;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public List<Record> getRecords() {
	return records;
    }

    public void setRecords(List<Record> records) {
	this.records = records;
    }

    @Override
    public String toString() {
	return "User [id=" + id + ", fullName=" + fullName + ", username=" + username + ", password=" + password + "]";
    }

}

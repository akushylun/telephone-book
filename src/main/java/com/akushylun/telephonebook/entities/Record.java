package com.akushylun.telephonebook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * Entity class, built on pattern Builder
 */

@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "r_id")
    private int id;

    @NotNull
    @Size(min = 4, max = 50)
    @Column(name = "r_surname")
    private String surname;

    @NotNull
    @Size(min = 4, max = 50)
    @Column(name = "r_name")
    private String name;

    @NotNull
    @Size(min = 4, max = 50)
    @Column(name = "r_middle_name")
    private String middleName;

    @NotNull
    @Column(name = "r_mobile_tel")
    @Pattern(regexp = "^(\\+38\\(0)(67|93|66|39|50|63|68|91|92){1}(\\))\\d{7}$")
    private String mobileTel;

    @Column(name = "r_home_tel")
    private String homeTel;

    @Column(name = "r_address")
    private String address;

    @Email
    @Column(name = "r_email")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "r_user_id")
    private Person person;

    public Record() {
    }

    private Record(Builder builder) {
	this.id = builder.id;
	this.surname = builder.surname;
	this.name = builder.name;
	this.middleName = builder.middleName;
	this.mobileTel = builder.mobileTel;
	this.homeTel = builder.homeTel;
	this.address = builder.address;
	this.email = builder.email;
	this.person = builder.person;
    }

    public int getId() {
	return id;
    }

    public String getSurname() {
	return surname;
    }

    public String getName() {
	return name;
    }

    public String getMiddleName() {
	return middleName;
    }

    public String getMobileTel() {
	return mobileTel;
    }

    public String getHomeTel() {
	return homeTel;
    }

    public String getAddress() {
	return address;
    }

    public String getEmail() {
	return email;
    }

    public void setId(int id) {
	this.id = id;
    }

    public void setSurname(String surname) {
	this.surname = surname;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setMiddleName(String middleName) {
	this.middleName = middleName;
    }

    public void setMobileTel(String mobileTel) {
	this.mobileTel = mobileTel;
    }

    public void setHomeTel(String homeTel) {
	this.homeTel = homeTel;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public Person getUser() {
	return person;
    }

    public void setUser(Person person) {
	this.person = person;
    }

    public static class Builder {
	private int id;
	private String surname;
	private String name;
	private String middleName;
	private String mobileTel;
	private String homeTel;
	private String address;
	private String email;
	private Person person;

	public Builder withId(int id) {
	    this.id = id;
	    return this;
	}

	public Builder withSurname(String surname) {
	    this.surname = surname;
	    return this;
	}

	public Builder withName(String name) {
	    this.name = name;
	    return this;
	}

	public Builder withMiddleName(String middleName) {
	    this.middleName = middleName;
	    return this;
	}

	public Builder withMobileTel(String mobileTel) {
	    this.mobileTel = mobileTel;
	    return this;
	}

	public Builder withHomeTel(String homeTel) {
	    this.homeTel = homeTel;
	    return this;
	}

	public Builder withAddress(String address) {
	    this.address = address;
	    return this;
	}

	public Builder withEmail(String email) {
	    this.email = email;
	    return this;
	}

	public Builder withUser(Person person) {
	    this.person = person;
	    return this;
	}

	public Record build() {
	    return new Record(this);
	}
    }

    @Override
    public String toString() {
	return "User [id=" + id + ", surname=" + surname + ", name=" + name + ", middleName=" + middleName
		+ ", mobileTel=" + mobileTel + ", homeTel=" + homeTel + ", address=" + address + ", email=" + email
		+ "]";
    }

}

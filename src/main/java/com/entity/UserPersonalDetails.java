package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_personal_details")
public class UserPersonalDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_personal_details_id")
	private int userPersonalDetailsId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;

	public UserPersonalDetails() {
		
	}
	
	public UserPersonalDetails(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getUserPersonalDetailsId() {
		return userPersonalDetailsId;
	}

	@Override
	public String toString() {
		return "UserPersonalData [userPersonalDetailsId=" + userPersonalDetailsId + ", name=" + name + ", surname=" + surname
				+ "]";
	}
	
	
	
}

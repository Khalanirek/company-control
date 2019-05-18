package com.khalanirek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="user_personal_details")
public class UserPersonalDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_personal_details_id")
	private long userPersonalDetailsId;

	@Column(name="name")
	private String name;

	@Column(name="surname")
	private String surname;

}

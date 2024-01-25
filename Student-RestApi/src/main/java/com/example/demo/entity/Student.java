package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	long studentId;
	
	@Column(name = "fname")
	String firstName;
	
	@Column(name = "lname")
	String lastName;
	
	@Column(name = "age")
	int studentAge;
	
	@Column(name = "address")
	String address;
	
	@Column(name = "bloodgrp")
	String bloodGroup;
}

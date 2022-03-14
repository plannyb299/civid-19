package com.flightech.covid19.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.flightech.covid19.entity.enums.City;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "patients", indexes = {@Index(name = "indx_patient", columnList = "patientid", unique = true)})
public class  Patient {

	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Problem> problems;

	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Admission> admissions;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@SequenceGenerator(sequenceName = "AA_PATIENT_SEQ", allocationSize = 1, name = "AA_PATIENT_SEQ")
	@Column(name = "patientid")
	private Long patientid;
	@Column(name = "name",  unique = true, nullable = false)
	private String name;
	@Column(name = "lastname",  unique = true, nullable = false)
	private String lastname;
	@Column(name = "phoneNo",  unique = true, nullable = false)
	private String phoneNo;
	@Column(name = "bornDate", length = 2, unique = false, nullable = false)
	private Date bornDate;
	@Column(name="gender", nullable = false)
	private String gender;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="city", nullable = false)
	private City city;

	@Column(name = "email",  unique = true, nullable = false)
	private String email;
	@Column(name="status",nullable = false)
	private int status;


	public Patient(String name, String lastname,Date bornDate, String gender, String age, City city, String email, int status) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.bornDate = bornDate;
		this.gender = gender;
		this.city = city;
		this.email = email;
		this.status = status;
	}
	public Patient(String name, String lastname, String gender,  City city, String email, int status) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.gender = gender;
		this.city = city;
		this.email = email;
		this.status = status;
	}

}

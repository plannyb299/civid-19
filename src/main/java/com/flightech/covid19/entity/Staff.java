package com.flightech.covid19.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.flightech.covid19.entity.enums.City;

import com.flightech.covid19.entity.enums.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "staffs", indexes = {@Index(name = "indx_staff", columnList = "staffid", unique = true)})
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AA_PATIENT_SEQ")
	@SequenceGenerator(sequenceName = "AA_PATIENT_SEQ", allocationSize = 1, name = "AA_PATIENT_SEQ")
	@Column(name = "staffid")
	private Long staffid;
	@Column(name = "staffname")
	private String staffname;
	@Column(name = "stafflastname")
	private String stafflastname;
	@Column(name = "gender")
	private String gender;

	
	@Column(name = "email", unique = true)
	private String email;
	@Enumerated(EnumType.ORDINAL)
	private City city;
	
	@Column(name = "department", length = 100)
	@Enumerated(EnumType.ORDINAL)
	private Department department;
	
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date bornDate;
    
	@OneToMany(mappedBy = "staff", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Admission> admissions;
	
	private int status;
}

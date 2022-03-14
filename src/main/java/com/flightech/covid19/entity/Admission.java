package com.flightech.covid19.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "admissions", indexes = {@Index(name = "indx_admission", columnList = "admissionid", unique = true)})
public class Admission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@SequenceGenerator(sequenceName = "AA_PATIENT_SEQ", allocationSize = 1, name = "AA_PATIENT_SEQ")
	@Column(name = "admissionid")
	private Long admissionid;
    @Column(name = "patientid")
	private Long patientid;
    @Column(name = "staffid")
	private Long staffid;
	
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "patientid", insertable = false, updatable = false)
    private Patient patient;
    
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "staffid", insertable = false, updatable = false)
    private Staff staff;
     
	private int status;
}

package com.flightech.covid19.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.flightech.covid19.entity.enums.ProblemStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "receipes", indexes = {@Index(name = "indx_receipe", columnList = "receipeid", unique = true)})
public class Receipe {
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "problemid", insertable = false, updatable = false)
	private Problem problem;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(sequenceName = "AA_PATIENT_SEQ", allocationSize = 1, name = "AA_PATIENT_SEQ")
	@Column(name = "receipeid", unique = true, nullable = false)
	private Long receipeid;
	@Column(name = "detail", unique = true, nullable = false)
	private String detail;
	@Column(name = "barcode", unique = true, nullable = false)
	private String barcode;
	@Column(name = "drug_detail", unique = true, nullable = false )
	private String drug_detail;
	@Column(name = "usage", unique = true, nullable = false)
	private String usage;
	@Column(name = "delivery_date", unique = true, nullable = false)
	private String delivery_date;
	@Column(name = "problemid", unique = true, nullable = false)
	private Long problemid;
	@Column(name = "patientid", unique = true, nullable = false)
	private Long patientid;
	@Column(name = "status", unique = true, nullable = false)
	private int status;

	
}

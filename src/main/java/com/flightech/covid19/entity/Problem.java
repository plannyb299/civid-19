package com.flightech.covid19.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.flightech.covid19.entity.enums.ProblemStatus;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "problems", indexes = {@Index(name = "indx_problem", columnList = "problemid", unique = true)})
public class Problem{
	@NotNull
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "patientid", insertable = false, updatable = false)
	private Patient patient;


	@OneToMany(mappedBy = "problem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Receipe> receipes;
//	SEQUENCE, generator = "AA_PATIENT_SEQ"
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(sequenceName = "AA_PATIENT_SEQ", alloSEQUENCE, generator = "AA_PATIENT_SEQ"cationSize = 1, name = "AA_PATIENT_SEQ")
	@Column(name = "problemid")
	private Long problemid;
	@Column(name = "problemName")
	private String problemName;
	@Column(name = "problemDetail")
	private String problemDetail;
	@Column(name="qrcode")
	private byte[] qrcode;

	@Enumerated(EnumType.STRING)
	private ProblemStatus problemStatus;
	private int status;
	private Long patientid;
	private Long admissionid;

    @Temporal(TemporalType.TIMESTAMP)
    Date creationDate;

}

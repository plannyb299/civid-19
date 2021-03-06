package com.flightech.covid19.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.example.demo.entity.enums.City;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientDtoForProblemGetDto implements Serializable {
	private Long patientid;
	private String name;
	private String lastname;
	private String phoneNo;
	private Date bornDate;
	private String gender;
	private City city;
	private String email;
	private int status;
	
}

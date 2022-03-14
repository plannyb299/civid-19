package com.flightech.covid19.repository;

import java.util.List;
import java.util.Optional;

import com.flightech.covid19.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	public List<Patient> findAllByOrderByPatientidAsc();

	public List<Patient> findAllByOrderByNameAsc();

	public Optional<Patient> findByEmail(String email);

//	@Query("select p from Patient p where p.name like %:name%")
	List<Patient> findByName(String name);

	@Query("SELECT p FROM Patient p WHERE p.status = 1 ORDER BY p.patientid ASC")
	List<Patient> findAllByStatusEqualsOne();

	@Query("SELECT  p FROM Patient p WHERE p.status = 0")
	List<Patient> findAllByStatusEqualsZero();
}

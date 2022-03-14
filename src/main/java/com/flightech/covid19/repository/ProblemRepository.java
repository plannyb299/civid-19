package com.flightech.covid19.repository;

import java.util.List;
import java.util.Optional;

import com.flightech.covid19.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flightech.covid19.entity.Patient;
;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {

	Optional<Problem> findById(long problemid);
	@Query("select p from Problem p where p.status = 1 order by p.problemid ASC")
	List<Problem> findAllByStatusEquelsOne();
	@Query("select p from Problem p where patientid=:patientid and p.status = 1 order by p.problemid ASC")
	List<Problem> findByPatientidWithStatusOne(Long patientid);
}

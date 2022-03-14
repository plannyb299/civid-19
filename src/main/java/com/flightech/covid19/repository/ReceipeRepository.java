package com.flightech.covid19.repository;

import java.util.List;
import java.util.Optional;

import com.flightech.covid19.entity.Receipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flightech.covid19.entity.Patient;

import org.springframework.stereotype.Repository;


@Repository
public interface ReceipeRepository extends JpaRepository<Receipe, Long> {

	@Query("select p from Receipe p where p.status = 1 order by p.receipeid ASC")
	List<Receipe> findAllByStatusEquelsOne();
	
//	@Query("select p from Receipe p where p.status = 1 and p.problemid=:problemid order by p.receipeid ASC")
	List<Receipe> findAllByProblemid(@Param("problem_id") Long problemid);
}

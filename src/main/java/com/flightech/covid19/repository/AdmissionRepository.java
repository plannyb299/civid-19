package com.flightech.covid19.repository;

import com.flightech.covid19.entity.Admission;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRepository extends JpaRepository<Admission, Long> {

}

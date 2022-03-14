package com.flightech.covid19.repository;



import com.flightech.covid19.entity.Problem;
import com.flightech.covid19.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long > {
    public void save(long certificateid);
    @Query("select c from Certificate c where c.patientid = c.certificateid order by c.certificateid ASC")
    Optional<Certificate> findById(long certificateid);
}

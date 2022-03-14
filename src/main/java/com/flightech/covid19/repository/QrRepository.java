package com.flightech.covid19.repository;

import com.flightech.covid19.entity.Certificate;
import com.flightech.covid19.entity.Qrcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Component
public interface QrRepository extends JpaRepository<Qrcode, Byte[]> {

//    byte[] getQRCodeImage(long qrcodeid);
    @Query("select q from Qrcode q where q.qrcodeid = q.patientid order by q.qrcodeid ASC")
    Optional<Qrcode> findById();

}

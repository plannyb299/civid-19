package com.flightech.covid19.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "certificates", indexes = {@Index(name = "indx_certificate", columnList = "certificateid", unique = true)})
public class Certificate {
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "patientid", insertable = false, updatable = false)
    private Patient patient;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "certificateid")
    private Long certificateid;
    @Column(name = "name",  unique = true, nullable = false)
    private String name;
    @Column(name = "lastname",  unique = true, nullable = false)
    private String lastname;
    @Column(name = "date", length = 2, unique = false, nullable = false)
    private Date date;
    @Column(name="gender", nullable = false)
    private String gender;
    @Column(name="patientid")
    private Long patientid;
    @Column(name = "qrcode")
    private byte[] qrcode;

}

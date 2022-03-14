package com.flightech.covid19.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.*;

@Configurable
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "qrcodes", indexes = {@Index(name = "indx_qrcode", columnList = "qrcodeid", unique = true)})
public class Qrcode {
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "certificateid", insertable = false, updatable = false)
    private Certificate certificate;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY )
    @Column(name = "qrcodeid")
    private Long qrcodeid;
    @Column(name="qrcode")
    private byte[] qrcode;
    @Column(name = "patientid")
    private Long patientid;

}

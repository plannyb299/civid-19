package com.flightech.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


@Data
@ToString
public class CertificateDto implements Serializable {
    private String name;
    private String lastname;
    private Date date;
    private String gender;
    private String results;
    private byte[] qrcode;

}

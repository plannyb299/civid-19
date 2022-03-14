package com.flightech.covid19.service;

import com.flightech.covid19.dto.CertificateDto;
import com.flightech.covid19.entity.Certificate;
import com.flightech.covid19.exception.PatientNotFoundException;
import com.flightech.covid19.helpers.Pdf;
import com.flightech.covid19.repository.CertificateRepository;
import com.flightech.covid19.repository.QrRepository;
import com.google.zxing.WriterException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class CertificateService {
    private final CertificateRepository certificateRepository;
    private final Pdf pdfGenaratorUtil;
    private final Logger logger;
    private final ModelMapper modelMapper;
    private final QrService qrService;
    private final QrRepository qrRepository;
//    private final int WIDTH = 250;
//    private final int HEIGHT = 250;
//    private final String QR_TEXT = "Qrcode";

    public CertificateService(CertificateRepository certificateRepository, Pdf pdfGenaratorUtil, Logger logger, ModelMapper modelMapper, QrService qrService, QrRepository qrRepository) {
        this.certificateRepository = certificateRepository;
        this.pdfGenaratorUtil = pdfGenaratorUtil;
        this.logger = logger;
        this.modelMapper = modelMapper;
        this.qrService = qrService;
        this.qrRepository = qrRepository;
    }

    public Certificate save(Certificate certificate) throws IOException, WriterException {
//          certificateRepository.createCertificate(certificate.getCertificateid());
//        certificate.setStatus(1);
//        Optional<Qrcode> qrImage = qrRepository.findById();

//        certificate.setQrcode(qrImage);
//        certificate.setQrcode(qrService.createQRCode());
        certificate = certificateRepository.save(certificate);

        if (certificate.getCertificateid() > -1) {

            return certificate;
        }
        else{
            logger.error("A problem occurred during saving certificate" );
            throw new PatientNotFoundException("A problem occurred during saving certificate" );
        }
//        Map<String,String> data = new HashMap<String,String>();
//        data.put("name","PLanny");
//        pdfGenaratorUtil.createPdf("greeting",data);
//
//        return certificate;

    }
    public CertificateDto findByCertificateId(Long certificateid) throws Exception {
        Optional<Certificate> optCertificate = certificateRepository.findById(certificateid);
        if (optCertificate.isPresent()) {
//            optCertificate.get().getCertificate().removeIf(problem -> certificate.getPatientid() == 0);
            CertificateDto dto = modelMapper.map(optCertificate.get(), CertificateDto.class);
            return dto;
        } else {
            logger.error("--Certificate does not exist with this id " + certificateid);
            throw new PatientNotFoundException("Certificate does not exist with this id " + certificateid);
        }
    }
}

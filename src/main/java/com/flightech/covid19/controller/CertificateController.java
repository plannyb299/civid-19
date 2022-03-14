package com.flightech.covid19.controller;


;
import com.flightech.covid19.dto.CertificateDto;
import com.flightech.covid19.entity.Certificate;
import com.flightech.covid19.service.CertificateService;
import com.flightech.covid19.util.ApiPaths;
import com.google.zxing.WriterException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(ApiPaths.CertificateCtrl.CTRL)
public class CertificateController {
    private final CertificateService certificateService;

    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }
    @PostMapping("/certificate")
        public ResponseEntity<Certificate> createCertificates(@Valid @RequestBody Certificate certificate) throws Exception {
        return ResponseEntity.ok(certificateService.save(certificate));
    }

    @GetMapping("/certificate/{certificateid}")
    public ResponseEntity<CertificateDto> getCertificate(@PathVariable(name = "certificarteid") Long certificateid) throws Exception {
        return ResponseEntity.ok(certificateService.findByCertificateId(certificateid));
    }
}

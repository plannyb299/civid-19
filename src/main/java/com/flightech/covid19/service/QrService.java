package com.flightech.covid19.service;

import com.flightech.covid19.entity.Qrcode;
import com.flightech.covid19.exception.PatientNotFoundException;
import com.flightech.covid19.repository.QrRepository;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
//import com.sun.tools.javac.util.ArrayUtils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;

@Service
public class QrService {

    private final QrRepository qrRepository;
    private final ModelMapper modelMapper;
    private final Logger logger;

    public QrService(QrRepository qrRepository, ModelMapper modelMapper, Logger logger) {
        this.qrRepository = qrRepository;
        this.modelMapper = modelMapper;
        this.logger = logger;
    }
    public Qrcode save(Qrcode qrcode) throws IOException, WriterException {

//        patient.setStatus(1);
        qrcode.setQrcode(createQRCode());
        qrcode = qrRepository.save(qrcode);


        if (qrcode.getQrcodeid() > -1) {

            return qrcode;
        }
        else{
            logger.error("A problem occurred during saving patient" );
            throw new PatientNotFoundException("A problem occurred during saving patient" );
        }
    }
    public byte[] createQRCode() {
        String text = "";
        int width = 200;
        int height = 200;
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return null;
        }
    }

    public Optional<Qrcode> findById(Byte[] qrcodeid) throws Exception {
        Optional<Qrcode> optQrcode = qrRepository.findById(qrcodeid);
        if (optQrcode.isPresent()) {
            optQrcode.get().getQrcode();
//            PatientSingleDto dto = modelMapper.map(optPatient.get(), PatientSingleDto.class);
            return optQrcode;
        } else {
            logger.error("--Patient does not exist with this id " + qrcodeid);
            throw new PatientNotFoundException("Patient does not exist with this id " + qrcodeid);
        }
    }
}


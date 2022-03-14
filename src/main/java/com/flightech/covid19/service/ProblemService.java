package com.flightech.covid19.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


import com.flightech.covid19.dto.ProblemDto;
import com.flightech.covid19.dto.ProblemDtoForPatientSingleDto;
import com.flightech.covid19.dto.ProblemGetDto;
import com.flightech.covid19.entity.Patient;
import com.flightech.covid19.entity.Problem;
import com.flightech.covid19.repository.PatientRepository;
import com.flightech.covid19.repository.ProblemRepository;
import com.flightech.covid19.repository.QrRepository;
import com.google.zxing.WriterException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class ProblemService {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private final ProblemRepository problemRepository;
	private final QrRepository qrRepository;
	private final PatientRepository patientRepository;
	private final ModelMapper modelMapper;  
	private final Logger logger;
//	private final int WIDTH = 250;
//	private final int HEIGHT = 250;
//	private final String QR_TEXT = "Qrcode";

	public ProblemService(ProblemRepository problemRepository, QrRepository qrRepository, PatientRepository patientRepository,
						  ModelMapper modelMapper, Logger logger) {
		this.qrRepository = qrRepository;
		this.patientRepository = patientRepository;
		this.problemRepository = problemRepository;
		this.modelMapper = modelMapper;
		this.logger = logger;
	}

	public ProblemDtoForPatientSingleDto save(ProblemDto dto) throws NotFoundException, WriterException, IOException {
		Optional<Patient> patient = patientRepository.findById(dto.getPId());
		if (!patient.isPresent()) {
			logger.error("Patient does already exist with patientid : " + dto.getPId());
			throw new NotFoundException("Patient does already exist with patientid : " + dto.getPId());
		}
//		QR_TEXT, WIDTH, HEIGHT
//		byte[] qrImage = qrRepository.getQRCodeImage();

		Problem problem = modelMapper.map(dto, Problem.class);
//		problem.setQrcode(qrImage);
		problem.setPatient(patient.get());
		problem.setPatientid(patient.get().getPatientid());
		problemRepository.save(problem);
		ProblemDtoForPatientSingleDto getDto = modelMapper.map(problem, ProblemDtoForPatientSingleDto.class);
		return getDto;
	}

	public Boolean delete(Long problemid) throws NotFoundException {
		Optional<Problem> optional = problemRepository.findById(problemid);
		if (!optional.isPresent()) {
			logger.error("Problem does not exist with problemid : " + problemid);
			throw new NotFoundException("Problem does not exist with problemid : " + problemid);
		}
		optional.get().setStatus(0);
		problemRepository.save(optional.get());
		// problemRepository.delete(optional.get());
		return true;
	}

	public ProblemGetDto findByProblemid(Long problemid) throws NotFoundException {
		Optional<Problem> optional = problemRepository.findById(problemid);
		if (!optional.isPresent()) {
			logger.error("Problem does not exist wtih problemid : " + problemid);
			throw new NotFoundException("Problem does not exist with problemid : " + problemid);
		}
		ProblemGetDto dto = modelMapper.map(optional.get(), ProblemGetDto.class);
		return dto;
	}

	public Boolean update(Long problemid, @Valid ProblemDtoForPatientSingleDto dto) throws NotFoundException {
		Optional<Problem> optional = problemRepository.findById(problemid);
		if (!optional.isPresent()) {
			logger.error("Problem does not exist wtih problemid : " + problemid);
			throw new NotFoundException("Problem does not exist with problemid : " + problemid);
		}
		return true;
	}

	public List<ProblemDtoForPatientSingleDto> findAllByPatientid(Long patientid) throws NotFoundException {
		List<Problem> list = problemRepository.findByPatientidWithStatusOne(patientid);
		if(list.size()>0) {

			return Arrays.asList(modelMapper.map(list, ProblemDtoForPatientSingleDto[].class));
		}
		logger.error("Problem does not exist wtih patientid : " + patientid);
		throw new NotFoundException("Problem does not exist with patientid : " + patientid);
	}

}

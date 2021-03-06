package com.flightech.covid19.util;

public class ApiPaths {
	private static final String BASE_PATH = "/api";
	private static final String PATIENT_PATH = "/patient";
	private static final String PROBLEM_PATH = "/problem";
	private static final String RECEIPE_PATH = "/receipe";
	private static final String CERTIFICATE_PATH = "/certificate";
	
	public static final class PatientCtrl {
		public static final String CTRL = BASE_PATH + PATIENT_PATH;
	}
	public static final class ProblemCtrl {
		public static final String CTRL = BASE_PATH + PROBLEM_PATH;
	}
	public static final class ReceipeCtrl {
		public static final String CTRL = BASE_PATH + RECEIPE_PATH;
	}

    public class CertificateCtrl {
		public static final String CTRL = BASE_PATH + CERTIFICATE_PATH;
    }
}

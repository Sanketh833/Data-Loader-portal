package com.cognizant.uploadfile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.cognizant.entity.Patient;

public class CSVFileUpload {
	public static String TYPE = "text/csv";
	static String[] HEADERs = { "patient_id", "patient_name", "patient_address", "dob", "patient_email",
			"patient_contactnumber", "drug_id", "drug_name" };

	public static boolean hasCSVFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<Patient> csvToPatient(InputStream is) {
		System.out.println("at csvhelper");
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			List<Patient> patientlist = new ArrayList<Patient>();
			System.out.println("sdf");

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			System.out.println("dfgh");
			for (CSVRecord csvRecord : csvRecords) {
				System.out.println("hjiuy");
				Patient patient = new Patient(Long.parseLong(csvRecord.get("patient_id")),
						csvRecord.get("patient_name"),
						csvRecord.get("patient_address"), 
						csvRecord.get("dob"), 
						csvRecord.get("patient_email"),
						Long.parseLong(csvRecord.get("patient_contactnumber")),
						Integer.parseInt(csvRecord.get("drug_id")), 
						csvRecord.get("drug_name"));
//				 System.out.println(patient.getPatient_id());
				// System.out.println(patient.getPatientName());
				// System.out.println(patient.getPatientAddress());
				// System.out.println(patient.getPatientdob());
				// System.out.println(patient.getEmailId());

				// list.forEach(System.out::println);
				patientlist.add(patient);

			}
			// patientlist.forEach(System.out::println);
			return patientlist;

		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

}
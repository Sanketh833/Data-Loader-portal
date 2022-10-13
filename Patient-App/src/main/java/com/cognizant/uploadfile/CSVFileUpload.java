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
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			List<Patient> patientlist = new ArrayList<Patient>(); 

			Iterable<CSVRecord> csvRecords = csvParser.getRecords(); 
			for (CSVRecord csvRecord : csvRecords) { 
				if (csvRecord.get("patient_email").isBlank() || (csvRecord.get("patient_email").isEmpty())) {

					throw new NullPointerException("patient_email is null");
				}
				if (csvRecord.get("patient_name").isBlank() || (csvRecord.get("patient_name").isEmpty())) {

					throw new NullPointerException("patient_name is null");
				}
				if (csvRecord.get("patient_address").isBlank() || (csvRecord.get("patient_address").isEmpty())) {

					throw new NullPointerException("patient_address is null");
				}
				if (csvRecord.get("dob").isBlank() || (csvRecord.get("dob").isEmpty())) {

					throw new NullPointerException("dob is null");
				}
				if (csvRecord.get ("drug_name").isBlank() || (csvRecord.get("drug_name").isEmpty())) {

					throw new NullPointerException("drug_name is null");
				} 
				
				Patient patient = new Patient(Long.parseLong(csvRecord.get("patient_id")),
						csvRecord.get("patient_name"), csvRecord.get("patient_address"), csvRecord.get("dob"),
						csvRecord.get("patient_email"), Long.parseLong(csvRecord.get("patient_contactnumber")),
						Integer.parseInt(csvRecord.get("drug_id")), csvRecord.get("drug_name"));
				System.out.println(patient.getPatient_id());
				 
				patientlist.add(patient);

			}
			// patientlist.forEach(System.out::println);
			return patientlist;

		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

}
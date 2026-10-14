package application;

import java.util.*;

public abstract class Visit implements Reportable {
	private Date visitDate;
	private String symptoms;
	private String diagnosis;
	private Patient patient;
	private Clinic clinic;

	public Visit() {

	}

	public Visit(Date visitDate, String symptoms, String diagnosis, Patient patient,Clinic clinic) {
		this.visitDate = visitDate;
		this.symptoms = symptoms;
		this.diagnosis = diagnosis;
		this.patient=patient;
		this.clinic=clinic;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	
 public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

 @Override
public abstract void generateReport();

}

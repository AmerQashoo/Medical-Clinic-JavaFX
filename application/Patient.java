package application;

import java.util.*;

public class Patient {
	private String name;
	private String dateOfBirth;
	private String gender;
	private String city;
	private String occupation;
	private String hasInsurance;
	private ArrayList<Visit>visit;
	
	public Patient() {

	}
	public Patient(String name, String dateOfBirth, String gender, String city, String occupation, String hasInsurance) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.city = city;
		this.occupation = occupation;
		this.hasInsurance = hasInsurance;
		this.visit = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getHasInsurance() {
		return hasInsurance;
	}
	public void setHasInsurance(String hasInsurance) {
		this.hasInsurance = hasInsurance;
	}
	 public void addVisit(Visit v) {
		 visit.add(v);
	 }
	public ArrayList<Visit> giveVisit(){
		return visit;
	}

	
}
package group2;

import java.util.ArrayList;

public class User {

	private int id;
	private String password;

	private String givenName;


	private int addressStreetNumber;
	private String addressStreetName;
	private String addressState;
	private int addressZIPCode;
	private String Country;
	private String County;

	private double gpa;

	private String emailAddress;
	private String phoneNumber;

	// Debate: Where should we keep track of semesters? Courses have different
	// semesters with different attributes.
	private ArrayList<UserContact> emergencyContact = new ArrayList<>();
	private ArrayList<Course> studentEnrolledCourses = new ArrayList<>();
	private ArrayList<Semester> userEnrolledSemester = new ArrayList<>();

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAddressStreetNumber() {
		return addressStreetNumber;
	}
	public void setAddressStreetNumber(int addressStreetNumber) {
		this.addressStreetNumber = addressStreetNumber;
	}
	public String getAddressStreetName() {
		return addressStreetName;
	}
	public void setAddressStreetName(String addressStreetName) {
		this.addressStreetName = addressStreetName;
	}
	public String getAddressState() {
		return addressState;
	}
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}
	public int getAddressZIPCode() {
		return addressZIPCode;
	}
	public void setAddressZIPCode(int addressZIPCode) {
		this.addressZIPCode = addressZIPCode;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getCounty() {
		return County;
	}
	public void setCounty(String county) {
		County = county;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public ArrayList<Semester> getUserEnrolledSemester() {
		return userEnrolledSemester;
	}
	public void setUserEnrolledSemester(ArrayList<Semester> userEnrolledSemester) {
		this.userEnrolledSemester = userEnrolledSemester;
	}
	public ArrayList<UserContact> getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(ArrayList<UserContact> emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	public ArrayList<Course> getStudentEnrolledCourses() {
		return studentEnrolledCourses;
	}
	public void setStudentEnrolledCourses(ArrayList<Course> studentEnrolledCourses) {
		this.studentEnrolledCourses = studentEnrolledCourses;
	}
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}



}

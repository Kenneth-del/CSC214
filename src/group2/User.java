package group2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

//Static class that retrieves and holds student data during use. 
public class User {

    private static int id;

    private String password;

    private static String firstName;
    private static String middleName;
    private static String lastName;
    private static String social;


    private static int addressID;
    private static int addressStreetNumber;
    private static String addressStreetName;
    private static String addressSuite;
    private static String addressState;
    private static String addressCity;
    private static String addressZIPCode;

    private static double gpa;

    private static String emailAddress;
    private static String phoneNumber;

    //TODO: Write course classes and code to download courses into arraylist
    // Stores static instance of enrolled courses
    private static ArrayList < Course > studentEnrolledCourses = new ArrayList < > ();

    //TODO: Write EmergencyContact class and code to download emergency
    //      contacts into arraylist
    // Stores static instance of emergency contacts
    private static ArrayList < EmergencyContact > emergencyContacts = new ArrayList < > ();


    //Downloads student data from database for local use
    public static void setStudent(int sid) throws SQLException {
        PreparedStatement ps;
        setId(sid);

        String query1 = "SELECT * FROM Student WHERE id =?";
        String query3 = "SELECT * FROM Registration WHERE Student_id =?";


        ps = MyConnection.getConnection().prepareStatement(query1);

        ps.setInt(1, sid);

        ResultSet rs = ps.executeQuery();

        // Retrieves data from Student table
        while (rs.next()) {
            firstName = rs.getString(2);
            middleName = rs.getString(3);
            lastName = rs.getString(4);
            phoneNumber = rs.getString(5);
            emailAddress = rs.getString(6);
            social = rs.getString(7);
            gpa = rs.getDouble(8);
            addressID = rs.getInt(9);
        }
        
        retrieveAddress();

            // TODO: Retrieve data from Registration table and get enrolled 
            //       courses from Section table.
        }
    
    public static void retrieveAddress() throws SQLException {
    	PreparedStatement ps;
    	
        String query = "SELECT * FROM Address WHERE id =?";

    	ps = MyConnection.getConnection().prepareStatement(query);
    	
        ps.setInt(1, addressID);

        ResultSet rs = ps.executeQuery();
        
        // Retrieves data from Student table
        while (rs.next()) {
            addressStreetNumber = rs.getInt(2);
            addressStreetName = rs.getString(4);
            addressSuite = rs.getString(3);
            addressState = rs.getString(6);
            addressCity = rs.getString(5);
            addressZIPCode = rs.getString(7);

        }
    }
    
    public static void retrieveRegistration() throws SQLException {
    	
    	int[] crns;
    	
    	PreparedStatement ps;
    	
        String query = "SELECT s.* FROM person p INNER JOIN shirt s\r\n" + 
        		"   ON s.owner = p.id\r\n" + 
        		" WHERE p.name LIKE 'Lilliana%'\r\n" + 
        		"   AND s.color <> 'white';";

    	ps = MyConnection.getConnection().prepareStatement(query);
    	
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
        	
        }
    	
    }
    
    
    //TODO: Figure out what methods stay here and change them to static

    public static int getId() {
        return id;
    }
    public static void setId(int sid) {
        sid = id;
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
    public String getAddressZIPCode() {
        return addressZIPCode;
    }
    public void setAddressZIPCode(String addressZIPCode) {
        this.addressZIPCode = addressZIPCode;
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

    public ArrayList < Course > getStudentEnrolledCourses() {
        return studentEnrolledCourses;
    }
    public void setStudentEnrolledCourses(ArrayList < Course > studentEnrolledCourses) {
        this.studentEnrolledCourses = studentEnrolledCourses;
    }
    public static String getFirstName() {
        return firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getLastName() {
        return lastName;
    }



}
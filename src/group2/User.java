package group2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {

    private static int id;

    private static String firstName;
    private static String middleName;
    private static String lastName;
    private static String social;


    private static Address studentAddress;

    private static double gpa;

    private static String emailAddress;
    private static String phoneNumber;

    public static Registration userRegistration;

    
    private static ArrayList < EmergencyContact > emergencyContacts = new ArrayList < > ();


    //Downloads student data from Student table in database
    public static void setUser(int sid) throws SQLException {
        PreparedStatement ps;
        setId(sid);

        //Selects any row in table with matching ID parameter
        String query = "SELECT * FROM Student WHERE id =?";


        ps = MyConnection.getConnection().prepareStatement(query);

        //Places User's ID in prepared statement
        ps.setInt(1, sid);

        //Stores database query result
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
            //Creates new address object that class will retrieve attributes for
            studentAddress = new Address(rs.getInt(9));
        }

      //Creates new Registration the represents all courses taken by student based on semester.
        //Registration class retrieves and stores all registration data that can be accessed
        userRegistration = new Registration(id);
        
        //Test making sure course information is being saved properly
        System.out.println(userRegistration.getCourse("Spring 2020", 32947));

    }


    //Retrieves emergency contact and stores in ArrayList. Each user has 2 emergency contacts
    public static void retrieveEmergencyContact() throws SQLException {


        PreparedStatement ps;

        //Retrieves all rows in StudentEmergencyContact table that match student ID parameter
        String query = "SELECT * FROM StudentEmergencyContact " +
            "WHERE Student_id =?";

        ps = MyConnection.getConnection().prepareStatement(query);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
        	//Creates EmergencyConact instance and places in ArrayList
            emergencyContacts.add(new EmergencyContact(rs.getInt(2)));
        }
    }



    // @return User's student ID
    public static int getId() {
        return id;
    }
    
    // @param sid User's student iD
    public static void setId(int sid) {
        id = sid;
    }

    // @return User's current GPA
    public static double getGpa() {
        return gpa;
    }
    
    // @return User's email address
    public String getEmailAddress() {
        return emailAddress;
    }
    // @param User's email address
    public static void setEmailAddress(String emailAddress) {
        User.emailAddress = emailAddress;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        User.phoneNumber = phoneNumber;
    }

    public static String getFirstName() {
        return firstName;
    }
    
    public static String getMiddleName() {
        return middleName;
    }
    public static String getLastName() {
        return lastName;
    }



}
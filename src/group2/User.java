package group2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


    /**
     *Sets user for current session. Retrieves user information from database for local use.
     *@param sid User's student ID
     *@throws SQLException
     */
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

    }


    /**
     * Retrieves emergency contact and stores in ArrayList. Each user has 2 emergency contacts
     * @throws SQLException
     */
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
            System.out.println(emergencyContacts.size());
        }
        emergencyContacts.trimToSize();
    }



    /**
     * Returns user's student ID number.
     * @return user's student ID number; 
     */    public static int getId() {
        return id;
    }

    /**
     * Set's student ID used in all lgoical operations and database queries.
     * @param sid User's student iD
    */
    public static void setId(int sid) {
        id = sid;
    }

    /**
     * Returns user's current GPA.
     * @return user's current GPA; 
     */
    public static double getGpa() {
        return gpa;
    }

    /**
     * Returns user's email address.
     * @return user's address; 
     */
    public String getEmailAddress() {
        return emailAddress;
    }
    
    /**
    * Updates user's email address in database.
    * @param emailAddress User's email address
    * @return true email matches format and was updated to database; 
    * false if Email doesn't match format or could not be updated
     */
    public static boolean updateEmailAddress(String emailAddress) throws SQLException {

        //Format of email address
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

        //Compiled pattern of email format
        Pattern pattern = Pattern.compile(regex);

        //Compares email to pattern
        Matcher matcher = pattern.matcher(emailAddress);

        //If email matched pattern, information is updated
        if (matcher.matches() && emailAddress.length() < 119) {

            PreparedStatement ps;

            //mySQL UPDATE query 
            String query = "UPDATE Student "
            		+ "SET Email = ? "
            		+ "where id = ?";

            ps = MyConnection.getConnection().prepareStatement(query);

            ps.setString(1, emailAddress);
            ps.setInt(2, id);

            // Updates locally after database is successfully updated
            if (ps.executeUpdate() > 0) {

                User.emailAddress = emailAddress;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Returns user's phone number.
     * @return user's phone number; 
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    /**
     * Updates user's phone number in database.
     * @param phoneNumber User's new phone number
     * @return true phone number was updated to database; 
     * false if phone number could not be updated
      */
    public static boolean updatePhoneNumber(String phoneNumber) throws SQLException {
    	
    	// Makes sure phone number is 10 digits
    	if(phoneNumber.length() == 10) {
        PreparedStatement ps;

        //mySQL UPDATE query 
        String query = "UPDATE Student "
        		+ "SET PhoneNumber = ? "
        		+ "where id = ?";

        ps = MyConnection.getConnection().prepareStatement(query);

        //Inserts items into prepared statement 
        ps.setString(1, phoneNumber);
        ps.setInt(2, id);


        // Updates locally after database is successfully updated
        if (ps.executeUpdate() > 0) {

            User.phoneNumber = phoneNumber;
            
            return true;
        }
    }
    
	return false;
    }

    /**
     * Returns user's first name.
     * @return user's first name; 
      */
    public static String getFirstName() {
        return firstName;
    }

    /**
     * Returns user's middle name.
     * @return user's last name; 
     */
    public static String getMiddleName() {
        return middleName;
    }
    
    /**
     * Returns user's last name.
     * @return user's last name; 
     */
    public static String getLastName() {
        return lastName;
    }
    
    /**
     * Returns user's social security number.
     * @return user's social security number; 
     */
    public static String getSocial() {
    	return social;
    }
    
    /**
     * Returns user's address.
     * @return user's address; 
     */
    public static Address getAddress() {
    	return studentAddress;
    }
    
    /**
     * Returns user's emergency contacts in ArrayList. 
     * @return ArrayList of user's emergency contacts; 
     */
    public static ArrayList<EmergencyContact> getEmergencyContacts(){
    	return emergencyContacts;
    }

    /**
     * Returns user's registration
     * @return user's registration; 
     */
    public static Registration getRegistration() {
    	return userRegistration;
    }
}
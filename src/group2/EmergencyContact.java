package group2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmergencyContact {

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Address address;
    
    //TODO: Figure why ArrayList isn't being filled. 
    //TODO: Add update methods

    /**
     * Retrieves emergency contacts associated with given Student ID number
     * @param id Student ID number used to query Emergency Contacts with matching foreighn key
     */
    public EmergencyContact(int id) throws SQLException {

        this.id = id;

        PreparedStatement ps;

        String query = "SELECT s.* FROM StudentEmergencyContact p INNER JOIN EmergencyContact s " +
            "ON s.id = p.EmergencyContact_id " +
            "WHERE p.Student_id LIKE ?";

        ps = MyConnection.getConnection().prepareStatement(query);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        // Retrieves data from Student table
        while (rs.next()) {
            firstName = rs.getString(2);
            lastName = rs.getString(2);
            phoneNumber = rs.getString(4);
            email = rs.getString(5);
            address = new Address(rs.getInt(6));
        }

        rs.close();

    }
    
    /**
     * Updates emergency contact's phone number in database.
     * @param phoneNumber Emergency contact's new phone number
     * @return true phone number was updated to database; 
     * false if phone number could not be updated
      */
    public boolean updatePhoneNumber(String phoneNumber) throws SQLException {
    	
    	// Makes sure phone number is 10 digits
    	if(phoneNumber.length() == 10) {
        PreparedStatement ps;

        //mySQL UPDATE query 
        String query = "UPDATE EmergencyContact "
        		+ "SET PhoneNumber = ? "
        		+ "where id = ?";

        ps = MyConnection.getConnection().prepareStatement(query);

        //Inserts items into prepared statement 
        ps.setString(1, phoneNumber);
        ps.setInt(2, id);


        // Updates locally after database is successfully updated
        if (ps.executeUpdate() > 0) {

            this.phoneNumber = phoneNumber;
            
            return true;
        }
    }
    
	return false;
    }

    /**
     * Updates emergency contact's email address in database.
     * @param emailAddress emergency contact's email address
     * @return true email matches format and was updated to database; 
     * false if Email doesn't match format or could not be updated
      */
     public boolean updateEmailAddress(String emailAddress) throws SQLException {

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

                 this.email = emailAddress;
                 return true;
             }
         }
         return false;
     }
    
    /**
     * Returns emergency contact's first name.
     * @return emergency contact's first name; 
      */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns emergency contact's last name.
     * @return emergency contact's first name; 
      */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns emergency contact's phone number.
     * @return emergency contact's phone number; 
      */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Returns emergency contact's email.
     * @return emergency contact's email; 
      */
    public String getEmail() {
        return email;
    }

    /**
     * Returns emergency contact's first name.
     * @return emergency contact's first name; 
      */
    public Address getAddress() {
        return address;
    }
    
    @Override
    public String toString() {
    	return firstName + " " + lastName + " " + phoneNumber + " " + email + " " + address;
    }

}
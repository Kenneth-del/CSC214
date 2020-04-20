package group2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmergencyContact {

    private int id;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String email;
    private Address address;

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
            phoneNumber = rs.getInt(4);
            email = rs.getString(5);
            address = new Address(rs.getInt(6));
        }

        rs.close();

    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
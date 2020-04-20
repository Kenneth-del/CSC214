package group2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Address {

    private int addressID;
    private int streetNumber;
    private String streetName;
    private String suite;
    private String state;
    private String city;
    private String zipCode;


    public Address(int id) throws SQLException {
        PreparedStatement ps;

        String query = "SELECT * FROM Address " +
            "WHERE id =?";

        ps = MyConnection.getConnection().prepareStatement(query);

        ps.setInt(1, addressID);

        ResultSet rs = ps.executeQuery();

        // Retrieves data from Student table
        while (rs.next()) {
            streetNumber = rs.getInt(2);
            streetName = rs.getString(4);
            suite = rs.getString(3);
            state = rs.getString(6);
            city = rs.getString(5);
            zipCode = rs.getString(7);

        }
        rs.close();
    }

    public int getStreetNumber() {
        return streetNumber;
    }
    public void setStreetNumber(int addressStreetNumber) {
        this.streetNumber = addressStreetNumber;
    }
    public String getStreetName() {
        return streetName;
    }
    public void setStreetName(String addressStreetName) {
        this.streetName = addressStreetName;
    }
    public String getState() {
        return state;
    }
    public void setState(String addressState) {
        this.state = addressState;
    }
    public String getZIPCode() {
        return zipCode;
    }
    public void setZIPCode(String addressZIPCode) {
        this.zipCode = addressZIPCode;
    }

    @Override
    public String toString() {
        if (suite == null) {
            return streetNumber + " " +
                streetName + " " +
                city + ", " +
                state + " " +
                zipCode;
        } else {
            return streetNumber + " " +
                streetName + " " +
                suite + " " +
                city + ", " +
                state + " " +
                zipCode;
        }
    }

}
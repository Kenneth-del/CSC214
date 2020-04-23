import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Address {

    private int addressID;
    private String streetNumber;
    private String streetName;
    private String suite;
    private String state;
    private String city;
    private String zipCode;

    /**
     * Retrieves Address data from Database using Address ID
     * @param id Address ID of address being retrieved
     */
    public Address(int id) throws SQLException {
    	addressID = id;
        PreparedStatement ps;

        String query = "SELECT * FROM Address " +
            "WHERE id =?";

        ps = MyConnection.getConnection().prepareStatement(query);

        ps.setInt(1, addressID);

        ResultSet rs = ps.executeQuery();

        // Retrieves data from Student table
        while (rs.next()) {
            streetNumber = rs.getString(2);
            streetName = rs.getString(4);
            suite = rs.getString(3);
            state = rs.getString(6);
            city = rs.getString(5);
            zipCode = rs.getString(7);
      }
    }

    /**
     * Returns address street number
     * @return Address street number
     */
    public String getStreetNumber() {
        return streetNumber;
    }

    /**
     * Returns address street name
     * @return Address street name
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Returns address state
     * @return Address state
     */
    public String getState() {
        return state;
    }

    /**
     * Returns address ZIP Code
     * @return Address ZIP Code
     */
    public String getZIPCode() {
        return zipCode;
    }


    /**
     * Updates address in database
     * @param streetNumber House Number
     * @param streetName Street Name
     * @param city Address city
     * @param state Address state
     * @param zipCode Address ZipCode
     * @return true if address was updated; false otherwise
     */
     public boolean update(String streetNumber, String streetName, String city,
     							String state, String zipCode) throws SQLException {

             PreparedStatement ps;

             //mySQL UPDATE query
             String query = "UPDATE Address "
             		+ "SET AddressNumber = ? "
             		+ "AND StreetName = ? "
             		+ "AND City = ? "
             		+ "AND State "
             		+ "AND ZipCode = ? "
             		+ "where id = ?";

             ps = MyConnection.getConnection().prepareStatement(query);

             //Inserts items into prepared statement
             ps.setString(1, streetNumber);
             ps.setString(2, streetName);
             ps.setString(3, city);
             ps.setString(4, state);
             ps.setString(5, zipCode);

             // Updates locally after database is successfully updated
             if (ps.executeUpdate() > 0) {

                 this.streetNumber = streetNumber;
                 this.streetName = streetName;
                 this.city = city;
                 this.state = state;
                 this.zipCode = zipCode;
                 return true;
             }

     	return false;
     }

    /**
    * Updates address in database if address has suite
    * @param streetNumber House Number
    * @param streetName Street Name
    * @param suite Unit Suite
    * @param city Address city
    * @param state Address state
    * @param zipCode Address ZipCode
    * @return true if address was updated; false otherwise
    */
    public boolean update(String streetNumber, String streetName, String suite, String city,
    							String state, String zipCode) throws SQLException {

            PreparedStatement ps;

            //mySQL UPDATE query
            String query = "UPDATE Address "
            		+ "SET AddressNumber = ? "
            		+ ", StreetName = ? "
            		+ ", Suite = ? "
            		+ ", City = ? "
            		+ ", State "
            		+ ", ZipCode = ? "
            		+ "where id = ?";

            ps = MyConnection.getConnection().prepareStatement(query);

            //Inserts items into prepared statement
            ps.setString(1, streetNumber);
            ps.setString(2, streetName);
            ps.setString(3, suite);
            ps.setString(4, city);
            ps.setString(5, state);
            ps.setString(6, zipCode);

            // Updates locally after database is successfully updated
            if (ps.executeUpdate() > 0) {

                this.streetNumber = streetNumber;
                this.streetName = streetName;
                this.suite = suite;
                this.city = city;
                this.state = state;
                this.zipCode = zipCode;
                return true;
            }

    	return false;
    }

    /**
     * Returns String representation of Address instance.
     * @return String of user's address;
     */
    @Override
    public String toString() {
        if (suite == "") {
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
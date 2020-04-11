package group2;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * Adapted from code found here: https://www.geeksforgeeks.org/sha-256-hash-in-java/
 */
public class Security {

    public boolean authenticateUser(String UID, String UPW) throws NoSuchAlgorithmException {
    	boolean authenticated = false;
        PreparedStatement ps;

        String query = "SELECT * FROM Credentials WHERE auth_hash =?";


        try {
            ps = MyConnection.getConnection().prepareStatement(query);

            ps.setString(1, getAuthHash(UID, UPW));

            ResultSet rs = ps.executeQuery();


        if (rs.next())
            authenticated = true;
            else
            	System.out.println("Failed");
        }catch (SQLException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        }

        return authenticated;
    }

    static String SecurityHash(String password) throws NoSuchAlgorithmException {
        return toHex(hashPassword(password));
    }
    Security() {

    }

    private static byte[] hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest algo = MessageDigest.getInstance("SHA-256");

        return algo.digest(password.getBytes(StandardCharsets.UTF_8));
    }
    private static String toHex(byte[] hash)

    {
        BigInteger hashHex = new BigInteger(1, hash);

        StringBuilder hexString = new StringBuilder(hashHex.toString(16));

        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }

    public static String getAuthHash(String UID, String UPW) throws NoSuchAlgorithmException {
        String authHash = SecurityHash(SecurityHash(UID) + SecurityHash(UPW));
        System.out.println(authHash);
        return authHash;
    }

}
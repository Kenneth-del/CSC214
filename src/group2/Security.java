package group2;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {
	private String passwordHash;
	private String password;

	String SecurityHash(String password) throws NoSuchAlgorithmException
	{
		return toHex(hashPassword(password));
	}
	Security()
	{

	}

	private byte[] hashPassword(String password) throws NoSuchAlgorithmException
	{
		MessageDigest algo = MessageDigest.getInstance("SHA-256");

		return algo.digest(password.getBytes(StandardCharsets.UTF_8));
	}
	private String toHex(byte[] hash)

	{
		BigInteger hashHex = new BigInteger(1,hash);

		StringBuilder hexString = new StringBuilder(hashHex.toString(16));

		while (hexString.length() <32)
		{
			hexString.insert(0,'0');
		}
		return hexString.toString();
	}
}

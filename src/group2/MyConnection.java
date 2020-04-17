package group2;

import java.sql.Connection;
import java.sql.DriverManager;
public class MyConnection {

	//Defines connection to AWS mySQL database 
    public static Connection getConnection() {

    	//Database url
        String url = "jdbc:mysql://localhost/mydb";
        //Database username (Only used for the program)
        String user = "root";
        //Database password
        String password = "root123";
        //Creates connection object
        Connection con = null;
        try {
        	//Loads mySQL drive
            Class.forName("com.mysql.jdbc.Driver");
            //Attempts to connect to database using defined credentials
            con = DriverManager.getConnection(url, user, password);
            //Here for Debub Purpsoses 
            System.out.println("Connection created");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //            TO DO: Find in program to close connection
        //            con.close();  
        //            System.out.println("Connection closed");  
        return con;
    }
}

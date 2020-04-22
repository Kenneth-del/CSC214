import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Registration {

	//ArrayList of semesters with active registration
    public static ArrayList < String > semesters = new ArrayList < String > ();


    //2D ArrayList where each row is different semester and row contains ArrayList of courses in that semester.
    //The semester of each row is represented by the corresponding index in semesters ArrayList
    public static ArrayList < ArrayList < Course >> registration = new ArrayList < ArrayList < Course >> ();

    public Registration(int id) throws SQLException {
    	/*
        PreparedStatement ps;
        String query = "SELECT " +
            "h.CRN " +
            ", h.Semester " +
            "FROM Registration s " +
            "INNER JOIN Section h " +
            "on s.Section_CRN = h.CRN " +
            "WHERE s.Student_id =?";;

        ps = MyConnection.getConnection().prepareStatement(query);

        ps.setInt(1, User.getId());

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

        	// Tests to see if Semester has already been retrieved
            if (!semesters.contains(rs.getString(2))) {

            	//If semester hasn't been recorded, it is indexed in semesters array list
                semesters.add(rs.getString(2));

                //Adds new row to to store courses from semester
                registration.add(new ArrayList < Course > ());

                //Creates course object and stores it in ArrayList with same index in registration
                //as corresponding semester does in semester ArrayList
                registration.get(semesters.indexOf(rs.getString(2))).add(new Course(rs.getInt(1)));
            } else

            	// Places course in ArrayList with same index as semester ArrayList
                registration.get(semesters.indexOf(rs.getString(2))).add(new Course(rs.getInt(1)));
        }

        rs.close();
*/
    }

    //TODO: Decide how course information is passed to UI
    public ArrayList<Course> getSemester(String semester){
    	if(semesters.contains(semester))
    		return registration.get(semesters.indexOf(semester));
    	else
    		return null;
    }

    //Should return requested course instance
    public Course getCourse(String semester, int CRN) {
    	for(int i = 0; i <= registration.get(semesters.indexOf(semester)).size(); i++) {
    		if(registration.get(semesters.indexOf(semester)).get(i).getCRN() == CRN) {
    			return registration.get(semesters.indexOf(semester)).get(i);
    		}
    	}
    	return null;
    }









    //TODO: Write course registration method. Method must confirm correct changes were made to database
    // 		before allowing user to continue.

    //TODO: Write course drop method.

}
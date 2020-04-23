import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Course {

	public String courseName;
	private String subject;
	private int courseNumber;
	private int creditHours;

	private String startDate;
	private String endDate;
	private String meetingTimes;
	private String startTime;
	private String endTime;

	private int instructorID;
	private String instructor;
	private String room;
	private String building;


	private int CRN;
	private int time;
	private int date;

	public Course(int CRN) throws SQLException {
		
		this.CRN = CRN;

		PreparedStatement ps;
        String query = "SELECT " +
        		"h.CourseName" +
        		", h.Subject" +
        		", h.CourseNumber" +
        		", h.CreditHours" +
        		", s.StartDate" +
        		", s.EndDate" +
        		", s.MeetingTimes" +
        		", s.StartTime" +
        		", s.EndTime" +
        		", s.Building" +
        		", s.Room" +
        		", p.id" +
        		", p.LastName" +
        		", p.FirstName " +
        		"FROM Section s, Course h, Instructor p " +
        		"WHERE s.Course_id = h.id " +
        		"AND s.Instructor_id = p.id " +
        		"AND s.CRN = ?";

        ps = MyConnection.getConnection().prepareStatement(query);

        ps.setInt(1, CRN);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
        	courseName = rs.getString(1);
        	subject = rs.getString(2);
        	courseNumber = rs.getInt(3);
        	creditHours = rs.getInt(4);
        	startDate = rs.getDate(5).toString();
        	endDate = rs.getDate(6).toString();
        	meetingTimes = rs.getString(7);
        	startTime = rs.getString(8);
        	endTime = rs.getString(9);
        	building = rs.getString(10);
        	room = rs.getString(11);
        	instructorID = rs.getInt(12);
        	instructor = rs.getString(13) + ", " + rs.getString(14);

        }

        rs.close();
	}

	public String getCourseName() {
		return courseName;
	}

	public String getSubject() {
		return subject;
	}

	public int getCourseNumber() {
		return courseNumber;
	}

	public int getCreditHours() {
		return creditHours;
	}

	public String getStartDate() {
		return startDate;
	}
	public String getEndDate() {
		return endDate;
	}

	public String getMeetingTimes() {
		return meetingTimes;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public int getInstructorID() {
		return instructorID;
	}

	public String getInstructor() {
		return instructor;
	}

	public String getRoom() {
		return room;
	}

	public String getBuilding() {
		return building;
	}

	public int getCRN() {
		return CRN;
	}

	public int getTime() {
		return time;
	}

	public int getDate() {
		return date;
	}

	@Override
	public String toString() {
		return courseName + " " +
				subject + " " +
				courseNumber + " " +
				creditHours + " " +
				startDate + " " +
				endDate + " " +
				meetingTimes + " " +
				startTime + " " +
				endTime + " " +
				building + " " +
				room + " " +
				instructor;
	}

}
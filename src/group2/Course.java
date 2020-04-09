package group2;

public class Course {

	private String activeSemester;
	private String instructor;
	private String room;
	private String campus;
	private String courseName;
	

	private int cRN;
	private int time;
	private int date;
	
	public String getActiveSemester() {
		return activeSemester;
	}


	public void setActiveSemester(String activeSemester) {
		this.activeSemester = activeSemester;
	}


	public String getInstructor() {
		return instructor;
	}


	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}


	public String getRoom() {
		return room;
	}


	public void setRoom(String room) {
		this.room = room;
	}


	public String getCampus() {
		return campus;
	}


	public void setCampus(String campus) {
		this.campus = campus;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public int getcRN() {
		return cRN;
	}


	public void setcRN(int cRN) {
		this.cRN = cRN;
	}


	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}


	public int getDate() {
		return date;
	}


	public void setDate(int date) {
		this.date = date;
	}
	
	Course()
	{
		
	}
	
}

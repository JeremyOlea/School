import java.util.ArrayList;

public class Course {
	
	private String courseName;
	private int courseNum;
	private ArrayList <Course> preReq;
	private ArrayList <CourseOffering> courseSessions;
	
	public Course (String courseName, int num){
		this.setCourseName(courseName);
		courseNum = num;
		preReq = new ArrayList<Course>();
		setCourseSessions(new ArrayList <CourseOffering>());
	}
	void addPreReq (Course c){
		preReq.add(c);
	}
	void addPreReq (ArrayList <Course> p){
		preReq = p;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public void assignSessions(ArrayList<CourseOffering> sessions) {
		// TODO Auto-generated method stub
		setCourseSessions(sessions);
	}
	public ArrayList <CourseOffering> getCourseSessions() {
		return courseSessions;
	}
	public void setCourseSessions(ArrayList <CourseOffering> courseSessions) {
		this.courseSessions = courseSessions;
	}
	public String toString (){
		return courseName + " " + courseNum;
	}

}

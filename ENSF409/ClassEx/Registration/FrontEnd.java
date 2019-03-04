import java.util.ArrayList;

public class FrontEnd {
	
	public static void main (String [] args){
		
		//In real life, the courses would be loaded from a database, or at least a file on disk
		ArrayList <Course>  courseList = new ArrayList <Course> ();
		courseList.add(new Course ("ENGG", 233));
		courseList.add(new Course ("PHYS", 259));
		courseList.add(new Course ("ENSF", 409));
		
		ArrayList <CourseOffering> engg233CourseSessions = new ArrayList <CourseOffering> ();
		engg233CourseSessions.add(new CourseOffering (1, 40));
		engg233CourseSessions.add(new CourseOffering (2, 40));
		
		courseList.get(0).assignSessions (engg233CourseSessions);
		
		CourseCatalogue cat = new CourseCatalogue (courseList);
		
		Student s1 = new Student ("Sam", 123);
		
		s1.addCourse(cat, "ENGG", 1);
		
		System.out.println(s1.getStudentCourseList().get(0));
		
		System.out.println(cat.getCourseList().get(0).getCourseSessions().get(0).getStudentList().get(0));
		s1.setName("Joe");
		System.out.println(cat.getCourseList().get(0).getCourseSessions().get(0).getStudentList().get(0));
	}

}

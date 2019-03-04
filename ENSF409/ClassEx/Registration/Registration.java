
public class Registration {

	private Student theStudent;
	private CourseOffering theOffering;
	private char grade;
	
	public void setTheStudent (Student st){
		theStudent = st;
	}
	public Student getTheStudent (){
		return theStudent;
	}

	public void setOffering (CourseOffering of){
		theOffering = of;
	}
	public CourseOffering getOffering (){
		return theOffering;
	}
	public String toString (){
		return theStudent + "\n" + theOffering;
	}
}

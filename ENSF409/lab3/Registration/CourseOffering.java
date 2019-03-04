import java.util.ArrayList;

public class CourseOffering {
	
	private int secNum;
	private int cap;
   // private ArrayList <Student> studentList;
	private ArrayList <Registration> studentList;
    private Course theCourse;
    private boolean minStudents;
    
    public CourseOffering (int secNum, int cap){
    	this.setSecNum(secNum);
    	this.cap = cap;
    	setStudentList(new ArrayList <Registration> ());//Not assigning studentList
    	                                       //only creating an arraylist of type student
    }
    public void setTheCourse (Course c){
    	theCourse = c;
    }
    public Course getTheCourse (){
    	return theCourse;
    }
    public void addRegistration (Registration reg, Course c){
        if(studentList.size() >= cap) {
            System.out.printf("\nClass is full\n");
        }
        else {
            getStudentList().add(reg);
			setTheCourse (c);
			if(studentList.size() >= 8) {
				minStudents = true;
			}
        }
    }
	public int getSecNum() {
		return secNum;
	}
	public void setSecNum(int secNum) {
		this.secNum = secNum;
	}
	public String toString (){
		return "Section Number: " + secNum;
	}
	public ArrayList <Registration> getStudentList() {
		return studentList;
	}
	public void setStudentList(ArrayList <Registration> studentList) {
		this.studentList = studentList;
	}
	
	

}

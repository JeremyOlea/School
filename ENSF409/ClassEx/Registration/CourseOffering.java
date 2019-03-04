import java.util.ArrayList;

public class CourseOffering {
	
	private int secNum;
	private int cap;
   // private ArrayList <Student> studentList;
	private ArrayList <Registration> studentList;
    
    public CourseOffering (int secNum, int cap){
    	this.setSecNum(secNum);
    	this.cap = cap;
    	setStudentList(new ArrayList <Registration> ());//Not assigning studentList
    	                                       //only creating an arraylist of type student
    }
    public void addRegistration (Registration reg){
    	getStudentList().add(reg);
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

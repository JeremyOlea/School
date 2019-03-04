import java.util.ArrayList;

public class Student {
	
	private String name;
	private int id;
	//private ArrayList <CourseOffering> studentCourseList;
	private ArrayList <Registration> studentRegList;
	//private CourseCatalogue courseCat; //why do I need this data in student? 
	
	public Student (String name, int id){
		this.name = name;
		this.id = id;
		studentRegList = new ArrayList<Registration>();
	}
	
	public Registration addCourse (CourseCatalogue cat, String courseName, int secNum){
		if(studentRegList.size() >= 6) {
            System.out.printf("\nStudent has maximum amount of courses already\n");
        }
        else {
            Registration reg = cat.addCourse (courseName, secNum, this);
		    if (reg == null){
			    System.err.println("Can't add course!");
			    return null;
		    }
		    studentRegList.add(reg);
			return reg;
        }
		return null;
	}

	public ArrayList <Registration> getStudentCourseList() {
		return studentRegList;
	}

	public void setStudentRegList(ArrayList <Registration> studentCourseList) {
		this.studentRegList = studentRegList;
	}
	public String toString (){
		return name + " " + id;
	}
	public void setName (String st){
		name = st;
    }

	public String getName() {
		return name;
	}
    
    public void deleteCourse(String name, CourseCatalogue courseCat, int secNum) {
        Boolean exist = false;
        CourseOffering offering = courseCat.searchCourseOffering(this, name, secNum);
        for(int i = 0; i < studentRegList.size(); i++) {
            if(studentRegList.get(i).getOffering() == offering) {
                studentRegList.remove(i);
                exist = true;
            }
        }
        if(exist == false) {
            System.out.printf("\nCourse does not exist\n");
        }
            
    }
	

}

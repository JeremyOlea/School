import java.util.*;

public class FrontEnd {
	
	public static void main (String [] args){
		
		//In real life, the courses would be loaded from a database, or at least a file on disk
        ArrayList <Course>  courseList = new ArrayList <Course> ();
        ArrayList<Student> students = new ArrayList<Student>();
		courseList.add(new Course ("ENGG", 233));
		courseList.add(new Course ("PHYS", 259));
		courseList.add(new Course ("ENSF", 409));
		
		ArrayList <CourseOffering> engg233CourseSessions = new ArrayList <CourseOffering> ();
		engg233CourseSessions.add(new CourseOffering (1, 40));
		engg233CourseSessions.add(new CourseOffering (2, 40));
		CourseCatalogue courseCat = new CourseCatalogue(courseList);

		Student s1 = new Student ("Sam", 123);
		Student s2 = new Student ("Ray", 321);
        students.add(s1);
        students.add(s2);
        
        ArrayList <CourseOffering> ensf409 = new ArrayList <CourseOffering> ();
        ensf409.add(new CourseOffering (1, 40));
        ensf409.add(new CourseOffering (2, 40));

        ArrayList <CourseOffering> phys259 = new ArrayList <CourseOffering> ();
        phys259.add(new CourseOffering (1, 40));

        courseList.get(0).assignSessions(engg233CourseSessions);
        courseList.get(1).assignSessions(ensf409);
        courseList.get(2).assignSessions(phys259);

        Boolean isRunning = true;
        Scanner scan = new Scanner(System.in);
        while(isRunning) {
            System.out.printf("\nMenu: Please select one");
            System.out.printf("\n1. Search catalogue courses");
            System.out.printf("\n2. Add course from student courses");
            System.out.printf("\n3. Remove course from student courses");
            System.out.printf("\n4. View all courses in catalogue");
            System.out.printf("\n5. View all courses taken by student");
            System.out.printf("\n6. Quit\n");
            int input = scan.nextInt();
            String name = "";
            String student = "";
            int secNum;
            Student stu = null;
            switch(input) {
                case 1:
                    System.out.printf("\nWhat course are you looking for?\n");
                    scan.nextLine();
                    name = scan.nextLine();
                    Course course = courseCat.searchCatalogue(name);
                    if(course == null) {
                        System.out.printf("\nCourse does not exist\n");
                    }
                    else {
                        System.out.println(course);
                    }
                    break;

                case 2:
                    scan.nextLine();
                    System.out.printf("\nChoose a student\n");
					for(int i = 0; i < students.size(); i++) {
						System.out.println(students.get(i).getName());
					}
                    student = scan.nextLine();
                    for(int i = 0; i < students.size(); i++) {
                        if(student.toLowerCase().equals(students.get(i).getName().toLowerCase())) {
                            stu = students.get(i);
                        }
                    }
                    System.out.printf("\nWhat course would you like to add?\n");
                    name = scan.nextLine();
                    System.out.printf("\nWhat course section are you looking for?\n");
                    secNum = scan.nextInt();
                    Registration reg = stu.addCourse(courseCat, name, secNum);
                    if(reg == null) {
                        System.out.printf("\nCourse does not exist\n");
                    }
                    else {
                        System.out.println("Course added successfully");
                    }
                    break;

                case 3:
                    scan.nextLine();
                    System.out.printf("\nChoose a student\n");
					for(int i = 0; i < students.size(); i++) {
						System.out.println(students.get(i).getName());
					}
                    student = scan.nextLine();
                    for(int i = 0; i < students.size(); i++) {
                        if(student.toLowerCase().equals(students.get(i).getName().toLowerCase())) {
                            stu = students.get(i);
                        }
                    }
                    System.out.printf("\nWhat course would you like to delete?\n");
                    name = scan.nextLine();
                    System.out.printf("\nWhat course section are you looking for?\n");
                    secNum = scan.nextInt();
                    stu.deleteCourse(name, courseCat, secNum);
                    break;

                case 4:
                    System.out.println(courseCat);
                    break;

                case 5:
                    scan.nextLine();
                    System.out.printf("\nChoose a student\n");
					for(int i = 0; i < students.size(); i++) {
						System.out.println(students.get(i).getName());
					}
                    student = scan.nextLine();
                    for(int i = 0; i < students.size(); i++) {
                        if(student.toLowerCase().equals(students.get(i).getName().toLowerCase())) {
                            stu = students.get(i);
                        }
                    }
                    for(int i = 0; i < stu.getStudentCourseList().size(); i++) {
                        System.out.println(stu.getStudentCourseList().get(i));
                    }
                    break;

                case 6:
                    isRunning = false;
                    scan.close();
                    break;

                default:
                    System.out.printf("\nInvalid input\n");
                    break;
            }

        }
	}

}

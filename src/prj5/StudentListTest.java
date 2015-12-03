package prj5;

public class StudentListTest extends student.TestCase {

    private StudentList students;
    private Student student;
    private int[] num1 = {1, 0, 1};
    private int[] num2 = {1, 0, 0};
    private int[] num3 = {1, 1, 1};
    private int[] num4 = {0, 0, 0};
    
	public void  setUp() {
		students = new StudentList();
		student = new Student();
		student.setMajor("Math");
		student.setHobby("reading");
		student.setRegion("north");
		student.setHeard(num1);
		student.setLikes(num2);
		students.add(student);
		student = new Student();
        student.setMajor("Math");
        student.setHobby("reading");
        student.setRegion("north");
        student.setHeard(num3);
        student.setLikes(num4);
        students.add(student);
	}
	
	public void testGetTallyHeard() {
	    int tmp = students.getTallyHeard(1, "hobby", "reading");
	    assertEquals(tmp, students.getTallyHeard(1, "hobby", "reading"));
	    assertEquals(0, students.getTallyHeard(1, "hobby", "sports"));
	    assertEquals(0, students.getTallyHeard(1, "region", "reading"));
	    students = new StudentList();
	    assertEquals(0, students.getTallyHeard(1, "region", "reading"));
	}
	
	public void testGetTallyLike() {
	    int tmp = students.getTallyLike(1, "hobby", "reading");
        assertEquals(tmp, students.getTallyLike(1, "hobby", "reading"));
        assertEquals(0, students.getTallyLike(1, "hobby", "sports"));
        assertEquals(0, students.getTallyLike(1, "region", "reading"));
        students = new StudentList();
        assertEquals(0, students.getTallyLike(1, "region", "reading"));
	}

}

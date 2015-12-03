package prj5;

/**
 * This class test the Student list class
 * @author Broulaye Doumbia (broulaye)
 * @version 12-02-2015
 *
 */
public class StudentListTest extends student.TestCase {

    private StudentList studentList;
    private int[] num1 = {1, 0, 1};
    private int[] num2 = {1, 0, 0};
    private int[] num3 = {1, 1, 1};
    private int[] num4 = {0, 0, 0};
    private int[] num5 = {1, 0, -1};
    private int[] num6 = {-1, -1, -1};
    
    /**
     * test setup
     */
    public void  setUp() {
        studentList = new StudentList();
        Student student1 = new Student();
        student1.setMajor("Math");
        student1.setHobby("reading");
        student1.setRegion("north");
        student1.setHeard(num1);
        student1.setLikes(num2);
        studentList.add(student1);
        Student student2 = new Student();
        student2.setMajor("Math");
        student2.setHobby("reading");
        student2.setRegion("north");
        student2.setHeard(num3);
        student2.setLikes(num4);
        studentList.add(student2);
        Student student3 = new Student();
        student3.setMajor("Math");
        student3.setHobby("reading");
        student3.setRegion("north");
        student3.setHeard(num1);
        student3.setLikes(num5);
        studentList.add(student3);
        student3 = new Student();
        student3.setMajor("Math");
        student3.setHobby("reading");
        student3.setRegion("north");
        student3.setHeard(num5);
        student3.setLikes(num1);
        studentList.add(student3);
        student3 = new Student();
        student3.setMajor("Math");
        student3.setHobby("reading");
        student3.setRegion("north");
        student3.setHeard(num6);
        student3.setLikes(num6);
        studentList.add(student3);
        student3 = new Student();
        student3.setMajor("Math");
        student3.setHobby("reading");
        student3.setRegion("north");
        student3.setHeard(num3);
        student3.setLikes(num3);
        studentList.add(student3);

    }
    
    /**
     * test tally heard for hobby
     */
    public void testGetTallyHeard() {
        int tmp = studentList.getTallyHeard(1, "hobby", "reading");
        assertEquals(tmp, studentList.getTallyHeard(1, "hobby", "reading"));
        assertEquals(0, studentList.getTallyHeard(1, "hobby", "sports"));
        assertEquals(0, studentList.getTallyHeard(1, "region", "reading"));
        studentList = new StudentList();
        assertEquals(0, studentList.getTallyHeard(1, "region", "reading"));
    }
    
    /**
     * test tally like for hobby
     */
    public void testGetTallyLike() {
        int tmp = studentList.getTallyLike(1, "hobby", "reading");
        assertEquals(tmp, studentList.getTallyLike(1, "hobby", "reading"));
        assertEquals(0, studentList.getTallyLike(1, "hobby", "sports"));
        assertEquals(0, studentList.getTallyLike(1, "region", "reading"));
        studentList = new StudentList();
        assertEquals(0, studentList.getTallyLike(1, "region", "reading"));
    }
    
    /**
     * test tally heard for major
     */
    public void testGetTallyHeard2() {
        int tmp = studentList.getTallyHeard(1, "major", "Math");
        assertEquals(tmp, studentList.getTallyHeard(1, "major", "Math"));
        assertEquals(0, studentList.getTallyHeard(1, "major", "CS"));
        assertEquals(0, studentList.getTallyHeard(1, "region", "Math"));
        studentList = new StudentList();
        assertEquals(0, studentList.getTallyHeard(1, "region", "Math"));
    }
    
    /**
     * test tally like for major
     */
    public void testGetTallyLike2() {
        int tmp = studentList.getTallyLike(1, "major", "Math");
        assertEquals(tmp, studentList.getTallyLike(1, "major", "Math"));
        assertEquals(0, studentList.getTallyLike(1, "major", "CS"));
        assertEquals(0, studentList.getTallyLike(1, "region", "Math"));
        studentList = new StudentList();
        assertEquals(0, studentList.getTallyLike(1, "region", "Math"));
    }
    
    /**
     * test tally heard for region
     */
    public void testGetTallyHeard3() {
        int tmp = studentList.getTallyHeard(1, "region", "north");
        assertEquals(tmp, studentList.getTallyHeard(1, "region", "north"));
        assertEquals(0, studentList.getTallyHeard(1, "region", "south"));
        assertEquals(0, studentList.getTallyHeard(1, "major", "north"));
        studentList = new StudentList();
        assertEquals(0, studentList.getTallyHeard(1, "major", "north"));
    }
    
    /**
     * test tally like for region
     */
    public void testGetTallyLike3() {
        int tmp = studentList.getTallyLike(1, "region", "north");
        assertEquals(tmp, studentList.getTallyLike(1, "region", "north"));
        assertEquals(0, studentList.getTallyLike(1, "region", "south"));
        assertEquals(0, studentList.getTallyLike(1, "major", "north"));
        studentList = new StudentList();
        assertEquals(0, studentList.getTallyLike(1, "major", "north"));
    }

}
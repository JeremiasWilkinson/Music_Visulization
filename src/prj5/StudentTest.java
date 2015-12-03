package prj5;

/**
 * This class test the student class 
 * @author Broulaye Doumbia (broulaye)
 * @version 12-02-2015
 *
 */
public class StudentTest extends student.TestCase {

    private Student student;
    private SongList songList;
    private int[] num1 = {1, 1, 1};
    private int[] num2 = {1, 1, 0};
    private int[] num3 = {1, 0, 1};
    private int[] num5 = {0, 0, 0};
    private String major = "Math";
    private String hobby = "reading";
    private String region = "north";
    
    /**
     * setup test
     */
    public void setUp() {
        student = new Student();
        songList = new SongList();
        songList.add(new Song("Hotline Bling",
                "Drake", 2015, "Rap", 0));
        student.setList(songList);
        student.setMajor(major);
        student.setHobby(hobby);
        student.setRegion(region);
        student.setHeard(num1);
        student.setLikes(num3);
    }

    /**
     * test get major
     */
    public void testGetMajor() {
        assertTrue(student.getMajor().equals(major));
    }
    
    /**
     * test get hobby
     */
    public void testGetHobby() {
        assertTrue(student.getHobby().equals(hobby));
    }
    
    /**
     * test get region
     */
    public void testGetRegion() {
        assertTrue(student.getRegion().equals(region));
    }
    
    /**
     * test set major
     */
    public void testSetMajor() {
        student.setMajor(major);
        assertTrue(student.getMajor().equals(major));
    }
    
    /**
     * test set =hobby
     */
    public void testSetHobby() {
        student.setHobby(hobby);
        assertTrue(student.getHobby().equals(hobby));
    }
    
    /**
     * test set region
     */
    public void testSetRegion() {
        student.setRegion(region);
        assertTrue(student.getRegion().equals(region));
    }
    
    /**
     * test get list
     */
    public void testGetList() {
        assertTrue(student.getList().equals(songList));
    }
    
    /**
     * test Setlist
     */
    public void testSetList() {
        student.setList(songList);
        assertTrue(student.getList().equals(songList));
    }
    
    /**
     * test get Likes
     */
    public void testGetLikes() {
        assertEquals(student.getLikes(), num3);
    }
    
    /**
     * test get heard
     */
    public void testGetHeard() {
        assertEquals(student.getHeard(), num1);
    }
    
    /**
     * test set likes
     */
    public void testSetLikes() {
        student.setLikes(num2);
        assertEquals(student.getLikes(), num2);
    }
    
    /**
     * test set heard
     */
    public void testSetHeard() {
        student.setHeard(num5);
        assertEquals(student.getHeard(), num5);
    }
    
    /**
     * test equals
     */
    public void testEquals() {
        Student student3 = null;
        assertFalse(student.equals(student3));
        assertTrue(student.equals(student));
        assertFalse(student.equals(new Object()));

        Student sameStudent = new Student();
        sameStudent.setHobby(hobby);
        sameStudent.setMajor(major);
        sameStudent.setRegion(region);
        assertTrue(student.equals(sameStudent));

        Student diffStudent = new Student();
        diffStudent.setHobby("x");
        diffStudent.setMajor(major);
        diffStudent.setRegion(region);
        assertFalse(student.equals(diffStudent));
        diffStudent.setMajor("x");
        assertFalse(student.equals(diffStudent));
        diffStudent.setRegion("x");
        assertFalse(student.equals(diffStudent));
        diffStudent.setHobby(hobby);
        assertFalse(student.equals(diffStudent));
        diffStudent.setRegion(region);
        assertFalse(student.equals(diffStudent));
        diffStudent.setHobby(hobby);
        assertFalse(student.equals(diffStudent));
    }
    
    /**
     * Test comparator
     */
    public void testComparator() {
        Exception exception = null;
        student = new Student();
        student.setList(songList);
        student.setMajor(major);
        student.setHobby(hobby);
        student.setRegion(region);
        student.setHeard(num1);
        student.setLikes(num3);
        Student student2 = new Student();
        student2.setList(songList);
        student2.setMajor("asdf");
        student2.setHobby("asdf");
        student2.setRegion("asd");
        student2.setHeard(num3);
        student2.setLikes(num1);
        Type type = Type.ARTIST;
        
        try {
            student.compare(student2, type);
        } 
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof UnsupportedOperationException);
    }
}
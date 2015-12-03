package prj5;

public class StudentTest extends student.TestCase {

    private Student student;
    private SongList songList;
    int[] num1 = {1, 1, 1};
    int[] num2 = {1, 1, 0};
    int[] num3 = {1, 0, 1};
    int[] num4 = {1, 0, 0};
    int[] num5 = {0, 0, 0};
    int[] num6 = {0, 1, 1};
    int[] num7 = {0, 0, 1};
    String major = "Math";
    String hobby = "reading";
    String region = "north";
    
	public void setUp() {
		student = new Student();
		songList = new SongList();
		songList.add(new Song("Hotline Bling",
		        "Drake", 2015, "Rap", 0));
		student.setList(songList);
		student.setMajor("Math");
		student.setHobby("reading");
		student.setRegion("north");
		student.setHeard(num1);
		student.setLikes(num3);
	}

	public void testGetMajor() {
	    assertTrue(student.getMajor().equals(major));
	}
	
	public void testGetHobby() {
	    assertTrue(student.getHobby().equals(hobby));
	}
	
	public void testGetRegion() {
	    assertTrue(student.getRegion().equals(region));
	}
	
	public void testSetMajor() {
	    student.setMajor(major);
	    assertTrue(student.getMajor().equals(major));
	}
	
	public void testSetHobby() {
	    student.setHobby(hobby);
	    assertTrue(student.getHobby().equals(hobby));
	}
	
	public void testSetRegion() {
	    student.setRegion(region);
	    assertTrue(student.getRegion().equals(region));
	}
	
	public void testGetList() {
	    assertTrue(student.getList().equals(songList));
	}
	
	public void testSetList() {
	    student.setList(songList);
	    assertTrue(student.getList().equals(songList));
	}
	
	public void testGetLikes() {
	    assertEquals(student.getLikes(), num3);
	}
	
	public void testGetHeard() {
	    assertEquals(student.getHeard(), num1);
	}
	
	public void testSetLikes() {
	    student.setLikes(num2);
	    assertEquals(student.getLikes(), num2);
	}
	
	public void testSetHeard() {
	    student.setHeard(num5);
	    assertEquals(student.getHeard(), num5);
	}
	
	public void testEquals() {
	    
	}
}

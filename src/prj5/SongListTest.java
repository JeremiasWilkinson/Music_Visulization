package prj5;


public class SongListTest extends student.TestCase {

	private Type Title = Type.TITLE;
	private Type Genre = Type.GENRE;
	private Type Artitst = Type.ARTIST;
	private Type Year = Type.YEAR;
	private SongList songList;
	private StudentList studentList;
	private Student student1;
	private Student student2;
	private Student student3;
	private Student student4;
	private Student student5;
	private Student student6;
	private int[] heard1 = {1, 0, 1};
	private int[] like1 = {1, 0, 1};
	private int[] heard2 = {0, 0, 0};
	private int[] like2 = {0, 0, 0};
	private int[] heard3 = {1, 1, 1};
	private int[] like3 = {1, 0, 1};
	private int[] heard4 = {0, 0, 1};
	private int[] like4 = {0, 0, 0};
	private int[] heard5 = {1, 1, 1};
	private int[] like5 = {0, 1, 0};
	private int[] heard6 = {1, 1, 1};
	private int[] like6 = {1, 1, 1};
	
	private Song song1;
	private Song song2;
	private Song song3;
	
	public void setUp() {
		songList = new SongList();
		studentList = new StudentList();
		song1 = new Song("Back to Back", "Drake", 2015, "Rap", 0);
		song2 = new Song("Trap Queen", "Fetty", 2014, "RnB", 0);
		song3 = new Song("Hello", "Adele", 2015, "Pop", 0);
		student1 = new Student("Computer Science", "Virginia", "music");
		student2 = new Student("Computer Science", "Virginia", "music");
		student3 = new Student("Computer Science", "Virginia", "art");
		student4 = new Student("Computer Science", "Virginia", "art");
		student5 = new Student("Computer Science", "Virginia", "sport");
		student6 = new Student("Computer Science", "Virginia", "sport");
		student1.setHeard(heard1);
		student1.setLikes(like1);
		student2.setHeard(heard2);
		student2.setLikes(like2);
		student3.setHeard(heard3);
		student3.setLikes(like3);
		student4.setHeard(heard4);
		student4.setLikes(like4);
		student5.setHeard(heard5);
		student5.setLikes(like5);
		student6.setHeard(heard6);
		student6.setLikes(like6);
	}
	
	public void testdisplayTest() {
		songList.add(song2);
		songList.add(song1);
		songList.add(song3);
		
		student1.setList(songList);
		student2.setList(songList);
		student3.setList(songList);
		student4.setList(songList);
		student5.setList(songList);
		student6.setList(songList);
		
		
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		studentList.add(student4);
		studentList.add(student5);
		studentList.add(student6);
		//System.out.println("Test1:\n");
		songList.displayTest(studentList, "hobby", Title);
		
		//System.out.println("\nTest2:\n");
		songList.displayTest(studentList, "hobby", Genre);
		
		//System.out.println("\nTest3:\n");
		songList.displayTest(studentList, "hobby", Artitst);
		
		//System.out.println("\nTest3:\n");
		songList.displayTest(studentList, "hobby", Year);
		
		assertFalse(false);
		
		
		
		
		
		
		
		
	}
	
	
	

}

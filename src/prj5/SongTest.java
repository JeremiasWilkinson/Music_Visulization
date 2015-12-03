package prj5;


/**
 * Tests that the Song class works.
 * @author Edgar Han (edgarh)
 * @author Shannon Hsu (shsu)
 * @author Broulaye Doumbia (broulaye)
 * @version 2015.11.20
 */
public class SongTest extends student.TestCase {

    private Song song;
    private Type type = Type.TITLE;
    private String title1 = "Clarity";
    private String title2 = "Face Down";
    private String artist1 = "Bed";
    private String artist2 = "Red Jumpsuite Apparatus";
    private String genre1 = "EDM";
    private String genre2 = "Alternative";

    /**
     * Sets up each method.
     */
    protected void setUp() {
        song = new Song(title1, artist1, 2014, genre1, 0);
    }


    /**
     * Tests that getTitle works.
     */
    public void testGetTitle() {
        assertTrue(song.getTitle().equals(title1));
    }

    /**
     * Tests that getArtist works.
     */
    public void testGetArtist() {
        assertTrue(song.getArtist().equals(artist1));
    }

    /**
     * Test method for getIndex.
     */
    public void testGetIndex() {
        assertEquals(song.getIndex(), 0);
    }

    /**
     * Test method for getGenre.
     */
    public void testGetGenre() {
        assertTrue(song.getGenre().equals(genre1));
    }

    /**
     * Test method for getYear.
     */
    public void testGetYear() {
        assertEquals(song.getYear(), 2014);
    }

    /**
     * Test method for setTitle.
     */
    public void testSetTitle() {
        song.setTitle(title2);
        assertTrue(song.getTitle().equals(title2));
    }

    /**
     * Test method for setArtist.
     */
    public void testSetArtist() {
        song.setArtist(artist2);
        assertTrue(song.getArtist().equals(artist2));
    }

    /**
     * Test method for setGenre.
     */
    public void testSetGenre() {
        song.setGenre(genre2);
        assertTrue(song.getGenre().equals(genre2));
    }

    /**
     * Test method for setYear.
     */
    public void testSetYear() {
        song.setYear(1994);
        assertEquals(1994, song.getYear());
    }

    /**
     * Test method for equals.
     */
    public void testEqualsObject() {
        String song2 = "null";
        Song song3 = null;
        assertFalse(song.equals(song3));
        assertTrue(song.equals(song));

        assertTrue(song.equals(new Song(title1, 
                artist1, 2014, genre1, 0)));
        assertFalse(song.equals(new Song("x", 
                artist1, 2014, genre1, 0)));
        assertFalse(song.equals(new Song(title1, 
                "x", 2014, genre1, 0)));
        assertFalse(song.equals(new Song(title1, 
                artist1, 2015, genre1, 0)));
        assertFalse(song.equals(new Song(title1, 
                artist1, 2014, "x", 0)));
        assertFalse(song.equals(new Song(title1, 
                "x", 2015, "x", 0)));
        assertFalse(song.equals(song2));
    }


    /**
     * Test method for compare.
     */
    public void testCompare() {
        Song song2 = new Song();
        song2.setTitle(title1);
        song2.setArtist(artist1);
        song2.setGenre(genre1);
        song2.setYear(2014);
        
        assertEquals(song.compare(song2, type), 0);
        song2.setTitle("A");
        assertEquals(song.compare(song2, type), 2);
        song2.setTitle("D");
        assertEquals(song.compare(song2, type), -1);
        
        type = Type.ARTIST;
        
        assertEquals(song.compare(song2, type), 0);
        song2.setArtist("A");
        assertEquals(song.compare(song2, type), 1);
        song2.setArtist("C");
        assertEquals(song.compare(song2, type), -1);
        
        type = Type.GENRE;
        
        assertEquals(song.compare(song2, type), 0);
        song2.setGenre("A");
        assertEquals(song.compare(song2, type), 4);
        song2.setGenre("F");
        assertEquals(song.compare(song2, type), -1);
        
        type = Type.YEAR;
        
        assertEquals(song.compare(song2, type), 0);
        song2.setYear(2013);
        assertEquals(song.compare(song2, type), 1);
        song2.setYear(2015);
        assertEquals(song.compare(song2, type), -1);
        
    }

    /**
     * Tests toString.
     */
    public void testToString() {
        String tmp = song.toString();
        assertTrue(song.toString().equals(tmp));
    }

}
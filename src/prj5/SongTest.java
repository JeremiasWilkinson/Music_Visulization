/**
 * 
 */
package prj5;


/**
 * @author Edger
 *
 */
public class SongTest extends student.TestCase {
    
    private Song song;
    private String title1 = "Clarity";
    private String title2 = "Face Down";
    private String artist1 = "Zed";
    private String artist2 = "Red Jumpsuite Apparatus";
    private String genre1 = "EDM";
    private String genre2 = "Alternative";

    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() {
        song = new Song(title1, artist1, 2014, genre1, 0);
    }


    /**
     * Test method for {@link prj5.Song#getTitle()}.
     */
    public void testGetTitle() {
        assertTrue(song.getTitle().equals(title1));
    }

    /**
     * Test method for {@link prj5.Song#getArtist()}.
     */
    public void testGetArtist() {
        assertTrue(song.getArtist().equals(artist1));
    }

    /**
     * Test method for {@link prj5.Song#getIndex()}.
     */
    public void testGetIndex() {
        assertEquals(song.getIndex(), 0);
    }

    /**
     * Test method for {@link prj5.Song#getGenre()}.
     */
    public void testGetGenre() {
        assertTrue(song.getGenre().equals(genre1));
    }

    /**
     * Test method for {@link prj5.Song#getYear()}.
     */
    public void testGetYear() {
        assertEquals(song.getYear(), 2014);
    }

    /**
     * Test method for {@link prj5.Song#setTitle(java.lang.String)}.
     */
    public void testSetTitle() {
        song.setTitle(title2);
        assertTrue(song.getTitle().equals(title2));
    }

    /**
     * Test method for {@link prj5.Song#setArtist(java.lang.String)}.
     */
    public void testSetArtist() {
        song.setArtist(artist2);
        assertTrue(song.getArtist().equals(artist2));
    }

    /**
     * Test method for {@link prj5.Song#setGenre(java.lang.String)}.
     */
    public void testSetGenre() {
        song.setGenre(genre2);
        assertTrue(song.getGenre().equals(genre2));
    }

    /**
     * Test method for {@link prj5.Song#setYear(int)}.
     */
    public void testSetYear() {
        song.setYear(1994);
        assertEquals(1994, song.getYear());
    }

    /**
     * Test method for {@link prj5.Song#equals(java.lang.Object)}.
     */
    public void testEqualsObject() {
        
    }

    /**
     * Test method for compare().
     */
    public void testCompare() {
    	Song song2 = new Song(title2, artist2, 2015, genre2, 0);
        assertTrue(song.compare(song2, Type.TITLE) < 0);
        assertEquals(song.compare(song, Type.TITLE), 0);
        assertTrue(song.compare(song2, Type.ARTIST) > 0);
        assertTrue(song.compare(song2, Type.GENRE) > 0);
        assertTrue(song.compare(song2, Type.YEAR) < 0);

        Exception caught = null;
        try {
            song.compare(song2, song2);
        }
        catch (Exception e) {
            caught = e;
        }
        System.out.println(caught);
        assertTrue(caught instanceof IllegalArgumentException);
    }
    
    public void testToString() {
        String tmp = song.toString();
        assertTrue(song.toString().equals(tmp));
    }

}

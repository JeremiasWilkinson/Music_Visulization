package prj5;

import student.TestCase;

/**
 * This class test the Type class
 * @author Broulaye Doumbia
 * @version 12-02-2015
 *
 */
public class TypeTest extends TestCase {

    private Type title = Type.TITLE;
    private Type artist = Type.ARTIST;
    private Type genre = Type.GENRE;
    private Type year = Type.YEAR;
    
    /**
     * test Type class
     */
    public void testType() {
        assertEquals(title, Type.TITLE);
        assertEquals(artist, Type.ARTIST);
        assertEquals(genre, Type.GENRE);
        assertEquals(year, Type.YEAR);
    }
}

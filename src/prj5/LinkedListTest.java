package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class test the linkedList class
 * @author Broulaye Doumbia
 * @version 11-21-1015
 */
public class LinkedListTest extends student.TestCase {

    private Song song1;
    private Song song2;
    private Song song3;
    private Song song4;
    private Song song5;
    private Song song6;
    private LinkedList<Song> list1;
    private LinkedList<Song> list2;
    private Exception exception;

    /**
     * set up the variables
     */
    public void setUp() {
        list1 = new LinkedList<Song>();
        list2 = new LinkedList<Song>();
        exception = null;
        song1  = new Song("Back to Back", "Drake", 2015, "Rap", 0);
        song2 = new Song("Hotel California", "Eagles", 1984, "Rock", 0);
        song3 = new Song("Facedown", "Red jumpsuit apparatus",
        		2004, "Alternatine", 0);
        song4 = new Song("Hello", "Adele", 2015, "Pop", 0);
        song5 = new Song("R.I.C.O", "Meek Mill", 2015, "Rap", 0);
        song6 = new Song("End Of the Road", "Boys to Man",
        		1991, "R'NB", 0);
    }

    /**
     * test size method
     */
    public void testsize() {
        assertEquals(list1.size(), 0);
        list1.add(song1);
        list1.add(song2);
        assertEquals(list1.size(), 2);
        list1.remove(1);
        assertEquals(list1.size(), 1);

    }

    /**
     * test add at a specific location method
     */
    public void testadd1() {
        try {
            list1.add(-1, song1);
        } 
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);
        list2.add(1, song1);
        assertEquals(list2.getEntry(1), song1);
        assertEquals(list2.size(), 1);
        list2.add(2, song3);
        assertEquals(list2.getEntry(2), song3);
        list2.add(2, song2);
        assertEquals(list2.getEntry(2), song2);
        assertEquals(list2.getEntry(3), song3);
        list2.add(4, song4);
        assertEquals(list2.getEntry(4), song4);
        list2.add(1, song6);
        assertEquals(list2.getEntry(1), song6);
        assertEquals(list2.getEntry(2), song1);
        list2.add(4, song5);
        assertEquals(list2.getEntry(4), song5);
        assertEquals(list2.getEntry(5), song3);

        try {
            list1.add(0, null);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);
        try {
            list1.add(6, song2);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);

    }

    /**
     * test add an entry method
     */
    public void testadd2() {
        assertTrue(list1.isEmpty());
        list1.add(song1);
        assertEquals(list1.getEntry(1), song1);
        list1.add(song2);
        assertEquals(list1.getEntry(1), song2);
        assertEquals(list1.getEntry(2), song1);
        list1.add(song3);
        assertEquals(list1.getEntry(1), song3);
        assertEquals(list1.getEntry(2), song2);
        assertEquals(list1.getEntry(3), song1);
        try {
            list1.add(null);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);

    }

    /**
     * test isEmpty method
     */
    public void testisEmpty() {
        assertTrue(list1.isEmpty());
        list1.add(song1);
        assertFalse(list1.isEmpty());
        list1.remove(1);
        assertTrue(list1.isEmpty());
    }

    /**
     * test remove entry at a specific index method
     */
    public void testremove2() {
        try {
            list1.remove(0);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);

        list1.add(song1);
        list1.add(song2);
        list1.add(song3);
        list1.add(song4);
        list1.add(song5);

        assertEquals(list1.size(), 5);
        assertEquals(list1.remove(4), song2);
        assertEquals(list1.size(), 4);
        assertEquals(list1.remove(1), song5);
        assertEquals(list1.size(), 3);

        try {
            list1.remove(3);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }

    /**
     * test get method
     */
    public void testgetEntry() {
        try {
            list1.getEntry(0);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);

        list1.add(song1);
        list1.add(song2);
        list1.add(song3);
        list1.add(song4);
        list1.add(song5);

        assertEquals(list1.getEntry(1), song5);
        assertEquals(list1.getEntry(2), song4);
        assertEquals(list1.getEntry(4), song2);

        try {
            list1.getEntry(6);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }

    /**
     * test contains method
     */
    public void testcontains() {
        list1.add(song1);
        list1.add(song2);
        list1.add(song3);
        list1.add(song4);
        list1.add(song5);

        assertFalse(list1.contains(song6));
        assertTrue(list1.contains(song1));
        assertTrue(list1.contains(song5));
        list1.add(song6);
        assertTrue(list1.contains(song6));
        assertTrue(list1.contains(song3));
    }
    
    /**
     * Test getFront method
     */
    public void testGetFront() {
        assertEquals(list1.getFront(), null);
        list1.add(song1);
        assertEquals(list1.getFront(), song1);
    }

    /**
     * test clear method
     */
    public void testclear() {
        assertTrue(list1.isEmpty());
        list1.clear();
        assertTrue(list1.isEmpty());
        list1.add(song1);
        list1.add(song2);
        list1.add(song3);
        list1.add(song4);
        list1.add(song5);
        assertFalse(list1.isEmpty());
        list1.clear();
        assertTrue(list1.isEmpty());
    }

    /**
     * Test toString method
     */
    public void testtoString() {
        assertEquals(list1.toString(), "");
        list1.add(song1);
        list1.add(song2);
        list1.add(song3);
        list1.add(song4);
        list1.add(song5);
        assertEquals(list1.toString(), song5.toString() + ", " 
                + song4.toString() + ", " + song3.toString() + ", "
                + song2.toString() + ", " + song1.toString());
        list1.remove(1);
        assertEquals(list1.toString(), song4.toString() + 
                ", " + song3.toString() + ", "
                + song2.toString() + ", " + 
                song1.toString());        
        list1.remove(3);
        assertEquals(list1.toString(), song4.toString() + 
                ", " + song3.toString() + ", "
                + song1.toString());
        list1.remove(1);
        assertEquals(list1.toString(), song3.toString() + ", "
                + song1.toString());
        list1.remove(1);
        assertEquals(list1.toString(), song1.toString());
    }
    
     /**
     * test iterator method
     */
    public void testIterator() {
        list1.add(song1);
        list1.add(song2);
        Iterator<Song> listIterator = list1.iterator();
        assertEquals(listIterator.next(), song2);
        assertTrue(listIterator.hasNext());
        
        assertEquals(listIterator.next(), song1);
        assertFalse(listIterator.hasNext());
        try {
            listIterator.next();
        } 
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof NoSuchElementException);
    }
    
    /**
     * test ReverseIterator method
     */
    public void testReverseIterator() {
        list1.add(song1);
        list1.add(song2);
        Iterator<Song> listIterator = list1.Reverseiterator();
        assertEquals(listIterator.next(), song1);
        assertTrue(listIterator.hasNext());
        
        assertEquals(listIterator.next(), song2);
        assertFalse(listIterator.hasNext());
        try {
            listIterator.next();
        } 
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof NoSuchElementException);
    }
    
    /**
     * test sorting method
     */
    public void testInsertionSort() {

        
        Type title = Type.TITLE;
        Type artist = Type.ARTIST;
        Type genre = Type.GENRE;
        Type year = Type.YEAR;
        
        list2.add(song1);
        list2.add(song2);
        list2.add(song3);
        list2.add(song4);
        list2.add(song5);
        list2.add(song6);
        
        list2.insertionSort(title);
        assertEquals(list2.getEntry(1), song1);
        assertEquals(list2.getEntry(2), song6);
        assertEquals(list2.getEntry(3), song3);
        assertEquals(list2.getEntry(4), song4);
        assertEquals(list2.getEntry(5), song2);
        assertEquals(list2.getEntry(6), song5);
        
        list2.insertionSort(artist);
        assertEquals(list2.getEntry(1), song4);
        assertEquals(list2.getEntry(2), song6);
        assertEquals(list2.getEntry(3), song1);
        assertEquals(list2.getEntry(4), song2);
        assertEquals(list2.getEntry(5), song5);
        assertEquals(list2.getEntry(6), song3);
        
        list2.insertionSort(genre);
        assertEquals(list2.getEntry(1), song3);
        assertEquals(list2.getEntry(2), song4);
        assertEquals(list2.getEntry(3), song6);
        assertEquals(list2.getEntry(4), song5);
        assertEquals(list2.getEntry(5), song1);
        assertEquals(list2.getEntry(6), song2);
        
        list2.insertionSort(year);
        assertEquals(list2.getEntry(1), song2);
        assertEquals(list2.getEntry(2), song6);
        assertEquals(list2.getEntry(3), song3);
        assertEquals(list2.getEntry(4), song1);
        assertEquals(list2.getEntry(5), song5);
        assertEquals(list2.getEntry(6), song4);
        
    }
    
    /**
     * Test to array method
     
    public void testToArray() {
        Song [] array1 = list1.toArray();
        list2.add(song1);
        list2.add(song2);
        list2.add(song3);
        list2.add(song4);
        list2.add(song5);
        list2.add(song6);
        Song[] array2 = list2.toArray();
        
        assertEquals(array1.length, 0);
        
        assertEquals(array2[1], song6);
        
    }
   */
}

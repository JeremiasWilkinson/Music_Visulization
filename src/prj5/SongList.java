package prj5;

import java.util.Iterator;

/**
 * This class represent a list of song
 * 
 * @author Broulaye Doumbia (broulaye)
 * @author Edgar Han (edgarh)
 * @author Shannon Hsu (shsu)
 * @version 12-02-2015
 */
public class SongList extends LinkedList<Song> {

    /**
     * constructor that set up the list it uses the constructor from the parent
     * class to do so
     */
    public SongList() {
        super();
    }
    
    /**
     * to output to console the heard/like of all songs
     * 
     * @param option
     *            represent what you want to represent the songs by
     * @param students
     *            represent the student list
     * @param sortBy
     *            represent what you want to sort by
     */
    public void displayTest(StudentList students, String option, Type sortBy) {
        insertionSort(sortBy);

        Iterator<Song> songListIterator = iterator();

        while (songListIterator.hasNext()) {
            Song tmp = songListIterator.next();
            System.out.println("Song Title: " + tmp.getTitle());
            System.out.println("Song Artist: " + tmp.getArtist());
            System.out.println("Song Genre: " + tmp.getGenre());
            System.out.println("Song Year: " + tmp.getYear());
            System.out.println("Heard");
            // --- make this next chunk of code as a method
            System.out.println("reading:" + 
                students.getTallyHeard(tmp.getIndex(), 
                    "hobby", "reading") + " art:"
                    + students.getTallyHeard(tmp.getIndex(), "hobby", "art")
                    + " sports:"
                    + students.getTallyHeard(tmp.getIndex(), "hobby", "sports")
                    + " music:"
                    + students.getTallyHeard(tmp.getIndex(), "hobby", "music"));
            System.out.println("Likes");
            System.out.println("reading:" + 
                students.getTallyLike(tmp.getIndex(), 
                    "hobby", "reading") + " art:"
                    + students.getTallyLike(tmp.getIndex(), "hobby", "art") +
                    " sports:"
                    + students.getTallyLike(tmp.getIndex(), "hobby", "sports") +
                    " music:"
                    + students.getTallyLike(tmp.getIndex(), 
                            "hobby", "music") + "\n");
        }

    } // end displayTest

}
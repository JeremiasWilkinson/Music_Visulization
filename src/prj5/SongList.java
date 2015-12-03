package prj5;

import java.util.Iterator;

/**
 * This class represent a list of song
 * @author Broulaye Doumbia (broulaye)
 *
 */
public class SongList extends LinkedList<Song> {
	

	/**
	 * constructor that set up the list
	 * it uses the constructor from the
	 * parent class to do so
	 */
	public SongList() {
		super();
	}
	/**
	public void setData(StudentList list) {
		for(int i = 1; i <= list.size(); i++) {
			Student newStudent = list.getEntry(i);
			SongList studentList = newStudent.getList();
			for(int j = 1; j <= studentList.size(); j++) {
				Song newSong = studentList.getEntry(j);
				if(newSong.getHeard() == 1) {
					this.getEntry(newSong).getData().incrementHeard();
				}
				if(newSong.getLike() == 1) {
					this.getEntry(newSong).getData().incrementLike();
				}
			}
		}
	}
	*/
	
	/**
	 * to output to console the heard/like of all songs
	 * @param option
	 */
	public void displayTest(StudentList students, String option, Type sortBy) {
	    insertionSort(sortBy);
	    //Node tmp = this.getHead();
	    //int position = 0;
	    // replace this with iterator
	    
	    Iterator<Song> songListIterator = iterator();
	    
	    while (songListIterator.hasNext()) {
	    	Song tmp = songListIterator.next();
	    	System.out.println("Song Title: " + tmp.getTitle());
	        System.out.println("Song Artist: " + tmp.getArtist());
	        System.out.println("Song Genre: " + tmp.getGenre());
	        System.out.println("Song Year: " + tmp.getYear());
	        System.out.println("Heard");
	        //--- make this next chunk of code as a method
	        System.out.println("reading:" + students.getTallyHeard
	        		(tmp.getIndex(), "hobby", "reading") +
	                " art:" + students.getTallyHeard
	                (tmp.getIndex(), "hobby", "art") +
	                " sports:" + students.getTallyHeard
	                (tmp.getIndex(), "hobby", "sports") +
	                " music:" + students.getTallyHeard
	                (tmp.getIndex(), "hobby", "music"));
	        System.out.println("Likes");
	        System.out.println("reading:" + students.getTallyLike
	        		(tmp.getIndex(), "hobby", "reading") +
                    " art:" + students.getTallyLike
                    (tmp.getIndex(), "hobby", "art") +
                    " sports:" + students.getTallyLike
                    (tmp.getIndex(), "hobby", "sports") +
                    " music:" + students.getTallyLike
                    (tmp.getIndex(), "hobby", "music") + "\n");
	    }
	    
	    /**
	    while (tmp != null) { // go through each song in list
	        System.out.println("\nSong Title: " + tmp.getData().getTitle());
	        System.out.println("Song Artist: " + tmp.getData().getArtist());
	        System.out.println("Song Genre: " + tmp.getData().getGenre());
	        System.out.println("Song Year: " + tmp.getData().getYear());
	        System.out.println("Heard");
	        //--- make this next chunk of code as a method
	        System.out.println("reading:" + students.getTallyHeard(tmp.getData().getIndex(), "hobby", "reading") +
	                " art:" + students.getTallyHeard(position, "hobby", "art") +
	                " sports:" + students.getTallyHeard(position, "hobby", "sports") +
	                " music:" + students.getTallyHeard(position, "hobby", "music"));
	        System.out.println("Likes");
	        System.out.println("reading:" + students.getTallyLike(position, "hobby", "reading") +
                    " art:" + students.getTallyLike(position, "hobby", "art") +
                    " sports:" + students.getTallyLike(position, "hobby", "sports") +
                    " music:" + students.getTallyLike(position, "hobby", "music"));
	        tmp = tmp.getNext();
	        position++;
	    } // end while
	    */
	} // end displayTest
	

	

}
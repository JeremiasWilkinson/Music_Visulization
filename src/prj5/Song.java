package prj5;

import java.util.Comparator;

/**
 * This class represent each song in the survey
 * each song has a title, artist, year of release 
 * and genre
 * @author Edgar Han (edgarh)
 * @author Shannon Hsu (shsu) 
 * @author Broulaye Doumbia (broulaye)
 * @version 11-24-1015
 *
 */
public class Song implements Comparator<Object> {

    private String title;
    private String artist;
    private String genre;
    private int year;
    private int heard;
    private int like;
    private int index;
    
    /**
     * Constructor that set value of parameters
     * @param t represent title
     * @param a represent artist
     * @param y represent year
     * @param g represent genre
     * @param pos represent the position of the song
     */
    public Song(String t, String a, int y, String g, int pos) {
        title = t;
        artist = a;
        year = y;
        genre = g;
        heard = 0;
        like = 0;
        index = pos;
    }
    
    /**
     * Constructor that set value of parameter 
     * to default value
     */
    public Song() {
        
        this("", "", 0, "", 0);
    }
    
    /**
     * get the heard
     * @return heard
     */
    public int getHeard() {
        return heard;
    }
    
    /**
     * get likes
     * @return likes
     */
    public int getLike() {
        return like;
    }
    
    /**
    public void incrementHeard() {
        heard++;
    }
    
    public void incrementLike() {
        like++;
    }
    */
    
    /**
     * get the title of the song
     * @return the song title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * get the artist name
     * @return artist name
     */
    public String getArtist() {
        return artist;
    }
    
    /**
     * get the index of the song
     * @return index of the song
     */
    public int getIndex() {
        return index;
    }
    
    /**
     * get the song genre
     * @return the song genre
     */
    public String getGenre() {
        return genre;
    }
    
    /**
     * get the song year of release
     * @return song year of release
     */
    public int getYear() {
        return year;
    }
    
    /**
     * set the song title
     * @param newTitle represent the new title
     */
    public void setTitle(String newTitle) {
        title = newTitle;
    }
    
    /**
     * set the artist name
     * @param newArtist represent the new artist
     */
    public void setArtist(String newArtist) {
        artist = newArtist;
    }
    
    /**
     * set the song genre
     * @param newGenre represent new genre
     */
    public void setGenre(String newGenre) {
        genre = newGenre;
    }
    
    /**
     * set the song release year
     * @param newYear represent new year
     */
    public void setYear(int newYear) {
        year = newYear;
    }
    /**
     * This equal method check if two songs are equal
     * to be equal the song need to have the same title
     * artist, year, and genre.
     * @param obj represent the second song
     * @return true if the two students are equal
     */
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        Song tmp = (Song)object;
        if ((title.equals(tmp.title))) {
            if (artist.equals(tmp.artist)) {
                if (year == tmp.year) {
                    if (genre.equals(tmp.genre)) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    } // end equals
    
    /**
     * 
     * These methods are to sort the list i will explain 
     * when we see each other
     * @param type
     * @return
     
    public String Data(Type type) {
        String returned= "";
        switch(type) {
        case TITLE:
            returned = title;
            break;
        case ARTIST: 
            returned = artist;
            break;
        case GENRE:
            returned = genre;
            break;
        case YEAR:
            returned = String.valueOf(year);
            break;
        }
        return returned;
    }
    */

    @Override
    /**
     * this compare method compare two songs
     * according to a specific Type
     * @return -1 if the song comes before, 1 
     * if it comes after, 0 if they have the same
     * position
     * @param o1 represent song to be compared to
     * @param o2 represent type to be compared by
     */
    public int compare(Object o1, Object o2) {
        Song song = (Song)o1;
        Type type;

        try {
            type = (Type)o2;
        }
        catch (Exception e) {
                throw new IllegalArgumentException("Illegal type given to compare");
        }

        switch(type) {
        case TITLE:
            return this.title.compareTo(song.title);
        case ARTIST:
            return this.artist.compareTo(song.artist);
        case GENRE:
            return this.genre.compareTo(song.genre);
        case YEAR:
            return this.year - song.year;
        default:
            throw new IllegalArgumentException("Illegal type given to compare");
        }
        
    }
    
    /**
     * get string representation of a song
     * @return string representation of the song
     */
    public String toString() {
         
        return "Song Title: " + this.title + "\nSong Artist: " + this.artist +
                 "\nSong Genre: " + this.genre + "\nSong Year: " + this.year;
    }

}
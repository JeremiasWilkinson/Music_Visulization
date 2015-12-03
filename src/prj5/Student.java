package prj5;

import java.util.Comparator;

/**
 * This is the person class, it represent each student 
 * who took the survey. Each student has a major, hobby
 * region, song list and an array of answers
 * @author Broulaye Doumbia
 * @version 11.14.2015
 */
public class Student implements Comparator<Object> {

    private String major;
    private String hobby;
    private String region;
    private SongList list;
    private int[] heard;
    private int[] like;
    
    /**
     * Constructor that set every parameter to a default
     * value
     */
    public Student() {
        this(null);
    }
    
    /**
     * Constructor that set the list 
     * to a new list provided
     * @param newList represent the new list
     */
    public Student(SongList newList) {
        list = newList;
        region = "";
        hobby = "";
        major = "";
        like = null;
        heard = null;
    }
    
    /**
     * constrotor create a student
     * @param m represent major
     * @param r represent region
     * @param h represent hobby
     */
    public Student(String m, String r, String h) {
        major = m;
        region = r;
        hobby = h;
    }
    
    /**
     * get the student major
     * @return string representing student major
     */
    public String getMajor() {
        return major;
    }
    
    /**
     * get the student hobby
     * @return string representing student hobby
     */
    public String getHobby() {
        return hobby;
    }
    
    /**
     * get the student region
     * @return string representing student region
     */
    public String getRegion() {
        return region;
    }
    
    /**
     * get a song list representing the list 
     * of song each student looked at in the survey
     * @return a song list
     */
    public SongList getList() {
        return list;
    }
    
    
    /**
     * set the list parameter to a new song list provided
     * @param newList represent the new list
     */
    public void setList(SongList newList) {
        list = newList;
    }
    
    /**
     * set the major parameter to a new one provided
     * @param newMajor represent the new hobby
      */
    public void setMajor(String newMajor) {
        major = newMajor;
    }
    
    /**
     * set the hobby parameter to a new one provided
     * @param newHobby represent the new hobby
     */
    public void setHobby(String newHobby) {
        hobby = newHobby;
    }
    
    /**
     * set the region parameter to a new one provided
     * @param newRegion represent the new region
     */
    public void setRegion(String newRegion) {
        region = newRegion;
    }
    
    /**
     * Set the like parameter to a new one provide
     * @param newLikes represent the provided array
     */
    public void setLikes(int[] newLikes) {
        like = newLikes;
    }
    
    /**
     * Set the heard parameter to a new one provide
     * @param newHeard represent the provided array
     */
    public void setHeard(int[] newHeard) {
        heard = newHeard;
    }
    
    /**
     * get an array of integer representing the song
     * the student liked and didn't like
     * @return an array of integer
     */
    public int[] getLikes() {
        return like;
    }
    
    /**
     * get an array of integer representing the song
     * the student heard and didn't hear
     * @return an array of integer
     */
    public int[] getHeard() {
        return heard;
    }
    
    
    /**
     * This equal method check if two students are equal
     * to be equal the students need to have the same major
     * region and hobby
     * @param obj represent the second student
     * @return true if the two students are equal
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        else {
            Student newPerson = (Student)obj;
            if (newPerson.major.equals(this.major)) {
                if (newPerson.hobby.equals(this.hobby)) {
                    if (newPerson.region.equals(this.region)) {
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
    }

    @Override
    /**
     * This compare method is not used 
     * it's just here for display
     * @param o1 represent first object
     * @param o2 represent second object
     * @return 0;
     */
    public int compare(Object o1, Object o2) {
        return 0;
    }

}

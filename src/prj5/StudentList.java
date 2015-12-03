package prj5;

import java.util.Iterator;

/**
 * This class represent a list of students 
 * @author Broulaye Doumbia (broulaye)
 * @author Edgar Han (edgarh)
 * @author Shannon Hsu (shsu) 
 * @version 11/20/2015
 */
public class StudentList extends LinkedList<Student> {
    
    //private LinkedList<Student> StudentList;
    
    /**
     * Constructor that initialize the StudentList
     * it does so using the parent class
     * constructor
     */
    public StudentList() {
        super();
        //StudentList = new LinkedList<Student>();
    }
    
    /**
     * get the tally of heard of a song according to
     * the position of the song, the type that is 
     * represented (hobby, major, region), and the
     * options of the type
     * @param pos represent position of song
     * @param type represent type
     * @param option represent option
     * @return integer representation the tally
     */
    public int getTallyHeard(int pos, String type, String option) {
        //Node tmp = getHead();
        
        Iterator<Student> studentListIterator = iterator();
        double count = 0;
        double total = 0;
        while (studentListIterator.hasNext()) {
            Student temp = studentListIterator.next();
            
            if (type.equals("hobby") && 
                    temp.getHobby().equals(option)) {
                if (temp.getHeard()[pos] > -1) {
                    total++;
                }
                if (temp.getHeard()[pos] == 1) {
                    count++;
                }
            }
            else if (type.equals("major") && 
                    temp.getMajor().equals(option)) {
                if (temp.getHeard()[pos] > -1) {
                    total++;
                }
                if (temp.getHeard()[pos] == 1) {
                    count++;
                }
            }
            else if (type.equals("region") &&
                    temp.getRegion().equals(option)) {
                if (temp.getHeard()[pos] > -1) {
                    total++;
                }
                if (temp.getHeard()[pos] == 1) {
                    count++;
                }
            }
        }
        if (total != 0) {
            return (int)((count / total) * 100);
        }
        else {
            return 0;
        }
        /** 
        while (tmp != null) { // probably better to use iterator here.
            Student temp = (Student)tmp.getData();
            if (type.equals("hobby")) {
                if (temp.getHobby().equals(option)) {
                    if (temp.getHeard()[pos] == 1) {
                        count++;
                    }
                }
            }
            tmp = tmp.getNext();
        } // end while
        return count;
        */
    }
    
    /**
     * get the tally of likes of a song according to
     * the position of the song, the type that is 
     * represented (hobby, major, region), and the
     * options of the type
     * @param pos represent position of song
     * @param type represent type
     * @param option represent option
     * @return integer representation the tally
     */
    public int getTallyLike(int pos, String type, String option) {
       // Node tmp = getHead();
        
        Iterator<Student> studentListIterator = iterator();
        double count = 0;
        double total = 0;
        while (studentListIterator.hasNext()) {
            Student temp = studentListIterator.next();
            
            if (type.equals("hobby") && 
                    temp.getHobby().equals(option)) {
                if (temp.getLikes()[pos] > -1) {
                    total++;
                }
                if (temp.getLikes()[pos] == 1) {
                    count++;
                }
            }
            else if (type.equals("region") &&
                    temp.getRegion().equals(option)) {
                if (temp.getLikes()[pos] > -1) {
                    total++;
                }
                if (temp.getLikes()[pos] == 1) {
                    count++;
                }
            }
            else if (type.equals("major") && 
                    temp.getMajor().equals(option)) {
                if (temp.getLikes()[pos] > -1) {
                    total++;
                }
                if (temp.getLikes()[pos] == 1) {
                    count++;
                }
            }
        }
        if (total != 0) {
            return (int)((count / total) * 100);
        }
        else {
            return 0;
        }
        /**
        while (tmp != null) { // probably better to use iterator here.
            Student temp = (Student)tmp.getData();
            if (type.equals("hobby")) {
                if (temp.getHobby().equals(option)) {
                    if (temp.getLikes()[pos] == 1) {
                        count++;
                    }
                }
            }
            tmp = tmp.getNext();
        } // end while
        return count;
        */
    }
    
    /**
     * get the list of student
     * @return a list of students
     
    public LinkedList<Student> getListt() {
        return StudentList;
    }
    
    /**
     * Set the student list to a new list provided
     * @param newStudentList represent the provided list
     
    public void setList(LinkedList<Student> newStudentList) {
        StudentList = newStudentList;
    }
    */
}

package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class takes given files and creates lists of songs and students, 
 * and makes a new GUI. 
 * 
 * @author Edgar Han (edgarh)
 * @author Broulaye Doumbia (broulaye)
 * @author Shannon Hsu (shsu) 
 * @version 2015.11.30
 */
public class Input {

    private static int totalSongs = 59;

    public static StudentList parseFile(String inFile, SongList songList) {
        Scanner file;
        String[] tmp;
        String major;
        String region;
        String hobby;
        StudentList students = new StudentList();
        Student student;

        try {
            file = new Scanner(new File(inFile));
            //file.nextLine(); // skip the first line, contains headers
            //for (int i=0; i<46; i++){file.nextLine();}
            //String tmp2 = file.nextLine();
            //tmp = file.nextLine().split(",");
            //System.out.println(tmp2);
            //for (int i = 0; i < tmp.length; i++) {System.out.println(tmp[i]);}
            //int debug = 0;
            while (file.hasNextLine()) {
                String str = file.nextLine();
                tmp = str.split(",", -5);
                //System.out.println(tmp.length + " @ " + debug);
                //debug++;
                if (!(tmp[2].equals("")) && 
                        !(tmp[3].equals("")) &&
                        !(tmp[4].equals("")) &&
                        !(tmp[0].equals("Nr"))) { // validate the correct number of
                                         // entries
                    major = tmp[2];
                    region = tmp[3];
                    hobby = tmp[4];
                    student = new Student();
                    student.setList(songList);
                    student.setMajor(major);
                    student.setRegion(region);
                    student.setHobby(hobby);
                    // ------ this next part will parse the yes and no

                    int[] heard = new int[totalSongs];
                    int[] like = new int[totalSongs];
                    int counter = 0;
                    //for(int i=5;i<tmp.length;i++){System.out.print(tmp[i]);}System.out.print("\n");
                    for (int i = 5; i < tmp.length; i++) {
                        if (tmp[i].equals("Yes")) {
                            heard[counter] = 1;
                        } 
                        else if(tmp[i].equals("No")) {
                            heard[counter] = 0;
                        }
                        else {
                            heard[counter] = -1;
                        }
                        i++;
                        if (tmp[i].equals("Yes")) {
                            like[counter] = 1;
                        } 
                        else if(tmp[i].equals("No")) {
                            like[counter] = 0;
                        }
                        else {
                            like[counter] = -1;
                        }
                        counter++;
                    }
                    student.setHeard(heard);
                    student.setLikes(like);
                    //System.out.print(debug + ") ");
                    //for(int i=0;i<totalSongs;i++){System.out.print(student.getHeard()[i]);System.out.print(student.getLikes()[i]);}System.out.println();
                    students.add(student);
                }
                //debug++;
            } // end while
        }
        catch (Exception e) {
            System.out.println(e);
        }
        //System.out.println("total song: " + songList.size());
        //System.out.println("total students: " + students.size());
        
        //------ sample code to display desired output
        //------ display each song title and tally by hobbies
        return students;
    }

    public static SongList parseSongs(String inFile) {
        SongList songList = new SongList();
        Scanner file;
        String[] tmp;
        try {
            file = new Scanner(new File(inFile));
            file.nextLine(); // skip the first line, contains headers
            int position = 0;
            while (file.hasNextLine()) {
                tmp = file.nextLine().split(",");
                songList.add(new Song(tmp[0], tmp[1], Integer.parseInt(tmp[2]), tmp[3], position));
                position++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        totalSongs = songList.size();
        return songList;
    }
    
    

    /**
     * Runs the program.
     * @param inFile The
     * @throws FileNotFoundException
     */
    public static void main(String[] inFile) {
    	SongList songList = parseSongs("SongList.csv");
    	songList.displayTest(parseFile("MusicSurveyData.csv",
    	parseSongs("SongList.csv")), "hobby", Type.GENRE);
    	            songList.displayTest(parseFile("MusicSurveyData.csv",
    	parseSongs("SongList.csv")), "hobby", Type.TITLE);
    	            new GUISongWindow(songList,
    	parseFile("MusicSurveyData.csv", parseSongs("SongList.csv")));
    }
}
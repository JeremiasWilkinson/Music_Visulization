package prj5;

import java.awt.Color;
import java.util.Iterator;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * This class creates a visualization of the sorting of the data 
 * and displays it as glyphs. 
 * 
 * @author Shannon Hsu (shsu) 
 * @version 2015.11.17
 */
public class GUISongWindow {

	private Window window; 
	private SongList songs; 
	private StudentList students; 
	private Button sortArtist; 
	private Button sortTitle; 
	private Button sortYear; 
	private Button sortGenre; 
	private Button nextButton; 
	private Button prevButton; 
	private Button repHobby; 
	private Button repMajor; 
	private Button repRegion; 
	private Button quitButton;
	private Shape legendBox; 
	private TextShape legendRep; 
	private TextShape cat1; 
	private TextShape cat2;
	private TextShape cat3; 
	private TextShape cat4;
	private TextShape legendSort; 
	private Shape legendVertBar; 
	private TextShape legendGlyphText; 
	private TextShape initMessage; 
	private String currRep; 
	private String currChar; 
	private Iterator<Song> iterator;	
	private Boolean changeDisplayedSongs; 
	private Song[] currSongs; 
	
	/**
	 * The height of the bar that indicates the number of 
	 * students who have heard/liked the song.  
	 */
	private static final int BAR_HEIGHT = 11; 

	/** 
	 * The x-location of the glyph in the top left corner. 
	 */
	private static int GLYPH1_X = 10; 
	
	/**
	 * The y-location of the glyph in the top left corner. 
	 */
	private static int GLYPH1_Y = 10; 
	
	/**
	 * Creates a new window. 
	 */
	public GUISongWindow(SongList inSongs, StudentList inStudents) {
		//song and student lists
		songs = inSongs; 
		students = inStudents; 
		
		//variables regarding the nine songs currently displayed 
		changeDisplayedSongs = true; 
		currSongs = new Song[9]; 
		
		//creates a new window
		window = new Window("Project 5 (broulaye, shsu, edgarh)");
		
		//adds the buttons
		prevButton = new Button("<-- Prev");
		window.addButton(prevButton, WindowSide.NORTH);
		prevButton.onClick(this, "goPrev");
		
		sortArtist = new Button("Sort by Artist Name");
		window.addButton(sortArtist, WindowSide.NORTH);
		sortArtist.onClick(this, "sortByArtist");
		
		sortTitle = new Button("Sort by Song Title"); 
		window.addButton(sortTitle, WindowSide.NORTH);
		sortTitle.onClick(this, "sortByTitle");
		
		sortYear = new Button("Sort by Release Year"); 
		window.addButton(sortYear, WindowSide.NORTH);
		sortYear.onClick(this, "sortByYear");

		sortGenre = new Button("Sort by Song Genre"); 
		window.addButton(sortGenre, WindowSide.NORTH);
		sortGenre.onClick(this, "sortByGenre");
		
		nextButton = new Button("Next -->"); 
		window.addButton(nextButton, WindowSide.NORTH);
		nextButton.onClick(this, "goNext");
		
		repHobby = new Button("Represent Hobby"); 
		window.addButton(repHobby, WindowSide.SOUTH);
		repHobby.onClick(this, "repByHobby");
		
		repMajor = new Button("Represent Major"); 
		window.addButton(repMajor, WindowSide.SOUTH);
		repMajor.onClick(this, "repByMajor");
		
		repRegion = new Button("Represent Region"); 
		window.addButton(repRegion, WindowSide.SOUTH);
		repRegion.onClick(this, "repByRegion");
		
		quitButton = new Button("Quit"); 
		window.addButton(quitButton, WindowSide.SOUTH);
		quitButton.onClick(this, "quit");	
		
		//the initial message 
		initMessage = new TextShape(260, 120, "Please select how to represent songs.");
		window.addShape(initMessage);
		
		//the way the data is currently sorted and represented
		currRep = ""; 
		currChar = "title";

		//an iterator for the song list
		iterator = songs.iterator();				
	}
	
	/** 
	 * Updates the legend when the data is represented by a new student characteristic. 
	 * @param characteristic The new characteristic. 
	 */
	private void updateLegend(String characteristic) {
		window.removeAllShapes();
		
		legendRep = new TextShape(window.getGraphPanelWidth() - 115 , window.getGraphPanelHeight() - 215, "Student Legend"); 
		legendRep.setBackgroundColor(Color.WHITE);
		window.addShape(legendRep);
		window.moveToFront(legendRep);
		
		cat1 = new TextShape(window.getGraphPanelWidth() - 115, window.getGraphPanelHeight() - 185, "category 1"); 
		cat1.setBackgroundColor(Color.PINK);
		window.addShape(cat1);

		cat2 = new TextShape(window.getGraphPanelWidth() - 115, window.getGraphPanelHeight() - 165, "category 2"); 
		cat2.setBackgroundColor(Color.CYAN);
		window.addShape(cat2);
		
		cat3 = new TextShape(window.getGraphPanelWidth() - 115, window.getGraphPanelHeight() - 145, "category 3"); 
		cat3.setBackgroundColor(Color.YELLOW);
		window.addShape(cat3);

		cat4 = new TextShape(window.getGraphPanelWidth() - 115, window.getGraphPanelHeight() - 125, "category 4"); 
		cat4.setBackgroundColor(Color.GREEN);
		window.addShape(cat4);

		legendGlyphText = new TextShape(window.getGraphPanelWidth() - 115, window.getGraphPanelHeight() - 62, "heard     likes"); 
		legendGlyphText.setBackgroundColor(Color.WHITE);
		window.addShape(legendGlyphText);
		
		legendSort = new TextShape(window.getGraphPanelWidth() - 115, window.getGraphPanelHeight() - 95, "Song Info"); 
		legendSort.setBackgroundColor(Color.WHITE);
		window.addShape(legendSort);
		
		legendVertBar = new Shape(window.getGraphPanelWidth() - 67, window.getGraphPanelHeight() - 75, 5, 45);
		legendVertBar.setBackgroundColor(Color.BLACK);
		legendVertBar.setForegroundColor(Color.BLACK);
		window.addShape(legendVertBar);
		window.moveToFront(legendVertBar);
		
		legendBox = new Shape(legendRep.getX() - 5, legendRep.getY() - 5, legendRep.getWidth() + 13, 200);
		legendBox.setBackgroundColor(Color.WHITE);
		legendBox.setForegroundColor(Color.BLACK); 
		window.addShape(legendBox);
		window.moveToBack(legendBox);
		
		//change the labels in the legend		
		if (characteristic.equals("hobby")) {
			legendRep.setText("Hobby Legend");
			cat1.setText("reading");
			cat2.setText("art");
			cat3.setText("sports");
			cat4.setText("music");
			window.repaint(); 
		}
		else if (characteristic.equals("major")) {
			legendRep.setText("Major Legend");
			cat1.setText("comp sci");
			cat2.setText("other engr");
			cat3.setText("math/CMDA");
			cat4.setText("other");		
			window.repaint();
		}
		else if (characteristic.equals("region")) {
			legendRep.setText("Region Legend");
			cat1.setText("N.E. US");
			cat2.setText("S.E. US");
			cat3.setText("rest of US");
			cat4.setText("outside US");		
			window.repaint();
		}		
		
		if (currChar.equals("title")) {
			legendSort.setText("Song Title");			
		}
		else if (currChar.equals("genre")) {
			legendSort.setText("Song Genre");
		}
		else if (currChar.equals("artist")) {
			legendSort.setText("Song Artist");
		}
		else if (currChar.equals("year")) {
			legendSort.setText("Release Year");
		}
		
		window.repaint();
	}
	
	/** 
	 * Determines which songs will be displayed on the screen. 
	 */
	private void setDisplayedSongs() {
		//get the next nine songs if they should be changed
		if (changeDisplayedSongs) {
			int count = 0; 
			while (iterator.hasNext() && count < 9) {
				currSongs[count] = iterator.next(); 
				count++; 
			}
			while (count < 9 && !iterator.hasNext()) {
				currSongs[count] = null;
				count++; 
			}
		}
		changeDisplayedSongs = false; 		

		//if the songs are the last in the list, disable the next button 
		if (!iterator.hasNext()) {
			nextButton.disable();
		}
		else {
			nextButton.enable();
		}
	}
	
	/** 
	 * Updates the glyphs when the data to be displayed is changed.
	 * @param characteristic The student characteristic to represent the data by. 
	 */
	private void drawGlyphs(String characteristic) {		
		window.removeAllShapes();
		updateLegend(currRep);
		setDisplayedSongs(); 
			
		//goes through all the songs that will be displayed 
		for (int count = 0; count < currSongs.length; count++) {
			
			//determines the location of the current glyph 
			if (count == 0) {
				GLYPH1_X = 10; 
				GLYPH1_Y = 10; 
			}
			if (count == 1) {
				GLYPH1_X = 240; 
			}
			if (count == 2) {
				GLYPH1_X = 480; 
			}
			if (count == 3) {
				GLYPH1_X = 10; 
				GLYPH1_Y = 110; 
			}
			if (count == 4) {
				GLYPH1_X = 240; 
			}
			if (count == 5) {
				GLYPH1_X = 480; 
			}
			if (count == 6) {
				GLYPH1_X = 10; 
				GLYPH1_Y = 210;
			}
			if (count == 7) {
				GLYPH1_X = 240; 
			}
			if (count == 8) {
				GLYPH1_X = 480; 
				GLYPH1_Y = 210; 
			}
			
			//adds the current song's data to the screen 
			//@throws NullPointerException if the end of the list is reached 
			Song currSong = currSongs[count]; 			
			try {
				TextShape currTitle = new TextShape(GLYPH1_X, GLYPH1_Y, currSong.getTitle());
				currTitle.setBackgroundColor(Color.WHITE);
				window.addShape(currTitle);
				
				//determines the song information to display 
				if (currChar.equals("artist") || currChar.equals("title")) {
					TextShape currArtist = new TextShape(GLYPH1_X, GLYPH1_Y + 15, "by " + currSong.getArtist());
					currArtist.setBackgroundColor(Color.WHITE);
					window.addShape(currArtist);
				}
				else if (currChar.equals("year")) {
					TextShape currYear = new TextShape(GLYPH1_X, GLYPH1_Y + 15, "year: " + currSong.getYear());
					currYear.setBackgroundColor(Color.WHITE);
					window.addShape(currYear);
				}
				else if (currChar.equals("genre")) {
					TextShape currGenre = new TextShape(GLYPH1_X, GLYPH1_Y + 15, "genre: " + currSong.getGenre());
					currGenre.setBackgroundColor(Color.WHITE);
					window.addShape(currGenre);
				} //end if
				
				Shape vertBar = new Shape(GLYPH1_X + 40, GLYPH1_Y + 35, 5, BAR_HEIGHT * 4);
				vertBar.setBackgroundColor(Color.BLACK);
				vertBar.setForegroundColor(Color.BLACK);
				window.addShape(vertBar);				

				drawSingleGlyph(currSong);
			}
			catch (Exception e) {
				if (e instanceof NullPointerException) {
					System.out.println("\nEnd of song list reached.");
					break; 
				}
			} //end try-catch
		} //end for		
	}
	
	/** 
	 * Represents the data by the students' hobbies. 
	 * @param b The button that is clicked. 
	 */
	public void repByHobby(Button b) {
		currRep = "hobby";
		updateLegend("hobby");
		drawGlyphs("hobby"); 
	}
	
	/** 
	 * Represents the data by the students' majors. 
	 * @param b The button that is clicked. 
	 */
	public void repByMajor(Button b) {
		currRep = "major"; 
		updateLegend("major");
		drawGlyphs("major");
	}

	/**
	 * Represents the data by the students' regions. 
	 * @param b The button that is clicked. 
	 */
	public void repByRegion(Button b) {
		currRep = "region";
		updateLegend("region"); 
		drawGlyphs("region");
	}
	
	/** 
	 * Closes the window. 
	 * @param b The button that is clicked. 
	 */
	public void quit(Button b) {
		System.exit(0);
	}
	
	/**
	 * Sorts the songs by their titles. 
	 * @param b The button that is clicked. 
	 */
	public void sortByTitle(Button b) {
		iterator = songs.iterator();
		changeDisplayedSongs = true; 
		setDisplayedSongs(); 
		currChar = "title";
		drawGlyphs("title");
	}
	
	/** 
	 * Sorts the songs by their artists. 
	 * @param b The button that is clicked. 
	 */
	public void sortByArtist(Button b) {
		songs.insertionSort(Type.ARTIST);
		iterator = songs.iterator();
		changeDisplayedSongs = true; 
		setDisplayedSongs(); 
		currChar = "artist"; 
		drawGlyphs("artist");
	}
	
	/**
	 * Sorts the songs by their release years. 
	 * @param b The button that is clicked.
	 */
	public void sortByYear(Button b) {
		songs.insertionSort(Type.YEAR);
		iterator = songs.iterator(); 
		changeDisplayedSongs = true; 
		setDisplayedSongs(); 
		currChar = "year";
		drawGlyphs("year");
	}
	
	/** 
	 * Sorts the songs by their genres. 
	 * @param b The button that is clicked. 
	 */
	public void sortByGenre(Button b) {
		songs.insertionSort(Type.GENRE);
		iterator = songs.iterator();
		changeDisplayedSongs = true; 
		setDisplayedSongs(); 
		currChar = "genre"; 
		drawGlyphs("genre");
	}
	
	/**
	 * Displays the next songs in the list. 
	 * @param b The button that is clicked. 
	 */
	public void goNext(Button b) {
		changeDisplayedSongs = true; 
		setDisplayedSongs(); 
		drawGlyphs("currChar");
	}
	
	/**
	 * Displays the previous songs in the list. 
	 * @param b The button that is clicked. 
	 */
	public void goPrev(Button b) {
		
	}
	
	/** 
	 * Draws a glyph for a single song. 
	 * @param curr The song to use. 
	 */
	private void drawSingleGlyph(Song curr) {
		//the lengths of the bars 
		int length1 = 0; 
		int length2 = 0; 
		int length3 = 0; 
		int length4 = 0; 
		int length5 = 0; 
		int length6 = 0; 
		int length7 = 0; 
		int length8 = 0; 
		
		//determines the lengths of the bars 
		if (currRep.equals("hobby") && students.size() != 0) {
			length1 = students.getTallyHeard(curr.getIndex(), "hobby", "reading") * 150 / students.size();
			length2 = students.getTallyHeard(curr.getIndex(), "hobby", "art") * 150 / students.size();
			length3 = students.getTallyHeard(curr.getIndex(), "hobby", "sports") * 150 / students.size();
			length4 = students.getTallyHeard(curr.getIndex(), "hobby", "music") * 150 / students.size();
			
			length5 = students.getTallyLike(curr.getIndex(), "hobby", "reading") * 150 / students.size();
			length6 = students.getTallyLike(curr.getIndex(), "hobby", "art") * 150 / students.size();
			length7 = students.getTallyLike(curr.getIndex(), "hobby", "sports") * 150 / students.size();
			length8 = students.getTallyLike(curr.getIndex(), "hobby", "music") * 150 / students.size();		
		}
		else if (currRep.equals("major")) {
			/*length1 = students.getTallyHeard(curr.getIndex(), "major", "reading") * 150 / students.size();
			length2 = students.getTallyHeard(curr.getIndex(), "major", "art") * 150 / students.size();
			length3 = students.getTallyHeard(curr.getIndex(), "major", "sports") * 150 / students.size();
			length4 = students.getTallyHeard(curr.getIndex(), "major", "music") * 150 / students.size();
			
			length5 = students.getTallyLike(curr.getIndex(), "major", "reading") * 150 / students.size();
			length6 = students.getTallyLike(curr.getIndex(), "major", "art") * 150 / students.size();
			length7 = students.getTallyLike(curr.getIndex(), "major", "sports") * 150 / students.size();
			length8 = students.getTallyLike(curr.getIndex(), "major", "music") * 150 / students.size(); */			
		}
		else if (currRep.equals("region")) {
			/*length1 = students.getTallyHeard(curr.getIndex(), "region", "reading") * 150 / students.size();
			length2 = students.getTallyHeard(curr.getIndex(), "region", "art") * 150 / students.size();
			length3 = students.getTallyHeard(curr.getIndex(), "region", "sports") * 150 / students.size();
			length4 = students.getTallyHeard(curr.getIndex(), "region", "music") * 150 / students.size();
			
			length5 = students.getTallyLike(curr.getIndex(), "region", "reading") * 150 / students.size();
			length6 = students.getTallyLike(curr.getIndex(), "region", "art") * 150 / students.size();
			length7 = students.getTallyLike(curr.getIndex(), "region", "sports") * 150 / students.size();
			length8 = students.getTallyLike(curr.getIndex(), "region", "music") * 150 / students.size(); */
		}	
		
		//adds the eight bars for the song 
		
		Shape l1 = new Shape(GLYPH1_X + 40 - length1, GLYPH1_Y + 35, length1, BAR_HEIGHT);
		l1.setBackgroundColor(Color.PINK);
		l1.setForegroundColor(Color.PINK);
		window.addShape(l1);
		
		Shape l2 = new Shape(GLYPH1_X + 40 - length2, GLYPH1_Y + 35 + BAR_HEIGHT, length2, BAR_HEIGHT);
		l2.setBackgroundColor(Color.CYAN);
		l2.setForegroundColor(Color.CYAN);
		window.addShape(l2);
		
		Shape l3 = new Shape(GLYPH1_X + 40 - length3, GLYPH1_Y + 35 + (2 * BAR_HEIGHT), length3, BAR_HEIGHT);
		l3.setBackgroundColor(Color.YELLOW);
		l3.setForegroundColor(Color.YELLOW);
		window.addShape(l3);

		Shape l4 = new Shape(GLYPH1_X + 40 - length4, GLYPH1_Y + 35 + (3 * BAR_HEIGHT), length4, BAR_HEIGHT);
		l4.setBackgroundColor(Color.GREEN);
		l4.setForegroundColor(Color.GREEN);
		window.addShape(l4);
		
		Shape r5 = new Shape(GLYPH1_X + 45, GLYPH1_Y + 35, length5, BAR_HEIGHT);
		r5.setBackgroundColor(Color.PINK);
		r5.setForegroundColor(Color.PINK);
		window.addShape(r5);
		
		Shape r6 = new Shape(GLYPH1_X + 45, GLYPH1_Y + 35 + BAR_HEIGHT, length6, BAR_HEIGHT);
		r6.setBackgroundColor(Color.CYAN);
		r6.setForegroundColor(Color.CYAN);
		window.addShape(r6);
		
		Shape r7 = new Shape(GLYPH1_X + 45, GLYPH1_Y + 35 + (2 * BAR_HEIGHT), length7, BAR_HEIGHT);
		r7.setBackgroundColor(Color.YELLOW);
		r7.setForegroundColor(Color.YELLOW);
		window.addShape(r7);
		
		Shape r8 = new Shape(GLYPH1_X + 45, GLYPH1_Y + 35 + (3 * BAR_HEIGHT), length8, BAR_HEIGHT);
		r8.setBackgroundColor(Color.GREEN);
		r8.setForegroundColor(Color.GREEN);
		window.addShape(r8);
	}
}
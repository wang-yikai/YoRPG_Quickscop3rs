/*
Team Quickscop3rs - Yikai Wang, Ziyan Lin, and Dhruba Roy
APCS1 pd9
HW31 -- Ye Olde Role Playing Game, Unchained
2015-11-16
*/

/*=============================================
  class YoRPG -- Driver file for Ye Olde Role Playing Game.
  Simulates monster encounters of a wandering adventurer.
  Required classes: Character
  =============================================*/

//NOTICE:
//compiler ran into a huge error... so the driver file is modified... alot

import java.io.*;
import java.util.*;

public class YoRPG {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

    //change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 7;

    //each round, a Warrior and a Monster will be instantiated
    private static Character user;
    private static Monster enemy; //Friendly generic monster name, eh?


    private static int moveCount = 0;
    private static boolean gameOver = false;
    private static int difficulty;

    private static InputStreamReader isr = new InputStreamReader( System.in );;
    private static BufferedReader in = new BufferedReader( isr );
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~ not used for simplicity and possible cause of compiler failure
    /*public YoRPG() {
	moveCount = 0;
	gameOver = false;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	newGame();
    } */

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

    //not used, somehow caused compiler failure
    /*============================================= 
      void newGame() -- facilitates info gathering to begin a new game
      pre:  
      post: according to user input, modifies instance var for difficulty 
      and instantiates a Warrior
      =============================================*/

      public static String charClass( String name) { //method for user to choose class

      System.out.println( "There are 5 availble classes to choose from:\nAdmin\nWarrior\nRogue\nMage\nQuickscoper\n");

	String want = "yes";
	String type = "";

	while( want.equals( "yes" ) ) { //instantiate the player's character

		System.out.println( "What class would you like to play as? (case-sensitive)"); //asks what class user would like to be

		try {
	    type = in.readLine();
		}
		catch ( IOException e ) { }

		if( type.equals( "Admin") ){
			user = new Admin(name);
			System.out.println( ( (Admin) user).about() );
		}

		else if( type.equals( "Warrior") ){
			user = new Warrior(name);
			System.out.println( ( (Warrior) user).about() );
		}

		else if( type.equals( "Rogue") ){
			 user = new Rogue(name);
			 System.out.println( ( (Rogue) user).about() );
		}

		else if( type.equals( "Mage") ){
			 user = new Mage( name );
			 System.out.println( ( (Mage) user).about() );
		}

		else if( type.equals( "Quickscoper" ) ){
			 user = new Quickscoper( name );
			 System.out.println( ( (Quickscoper) user).about() );
		}

		else {
			System.out.println( "So you wanna be a Quickscoper... ?");
			 user = new Quickscoper( name );
			 System.out.println( ( (Quickscoper) user).about() );
		}
		System.out.println( "Do you want to switch classes? (yes/no)" );
		try {
	    	want = in.readLine();
		}
			catch ( IOException e ) { want = "no"; }
	}

		return type;
      }

    /*=============================================
      boolean playTurn -- simulates a round of combat
      pre:  Warrior pat has been initialized
      post: Returns true if player wins (monster dies).
            Returns false if monster wins (player dies).
      =============================================*/



    public static void main( String[] args ) {

	//As usual, move the begin-comment bar down as you progressively 
	//test each new bit of functionality...

	//loading...
	//YoRPG game = new YoRPG();

	int encounters = 0;

	String s;

	s = "Welcome to Ye Olde RPG!\n";

	s += "\nChoose your difficulty: \n";
	s += "\t1: Easy\n";
	s += "\t2: Not so easy\n";
	s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
	s += "Selection: ";
	System.out.print( s );

	try {
	    difficulty = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }
	
	
	String name = "";

	s = "Intrepid warrior, what doth thy call thyself? (State your name): ";
	System.out.print( s );

	try {
	    name = in.readLine();
	}
	catch ( IOException e ) { }

	charClass( name );

	int i = 1;
	int d1 = 0; int d2 = 0;

	while( ( !gameOver ) && (encounters <= MAX_ENCOUNTERS ) ) {
		if ( Math.random() >= ( difficulty / 3.0 ) ) {
	    	System.out.println( "Nothing to see here. Move along!" );
	    	gameOver = false;
	    }
	    else {

		System.out.println( "Lo, yonder monster approacheth!" );

	    enemy = new Monster();

	    while( enemy.isAlive() && user.isAlive() ) {

		// Give user the option of using a special attack:
		// If you land a hit, you incur greater damage,
		// ...but if you get hit, you take more damage.
		try {
		    System.out.println( "Do you feel lucky?" );
		    System.out.println( "\t1: Nay.\n\t2: Aye!" );
		    i = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }

		if ( i == 2 )
		    user.specialize();
		else
		    user.normalize();

		//chance for monster to do special attack
		double mspec = Math.random();
		if ( mspec < 0.5 )
			enemy.specialize();
		else
			enemy.normalize();

		if ( !user.getType().equals( "Admin")) { //for non-admins
			d1 = user.attack( enemy );
		}
		else { //admin attack
			enemy.getBanned();
		}

		d2 = enemy.attack( user );

		if ( !user.getType().equals( "Admin")) { //for non-admins
			if ( user.getType().equals( "Quickscoper") ) {
				if (d1 == 0) {
					System.out.println( "You missed :( " );
				}
				else if( d1 == 100 ) {
					System.out.println( "BOOM! Headshot!" );
				}
				else if( d1 == 200 ) {
					System.out.println( "360 noscope! GJ Bro!" );
				}
				else if( d1 == 30 ) {
					System.out.println( "Limb shot... Could've been worse" );
				}
			}

			System.out.println( user.getName() + " dealt " + d1 +
				    " points of damage.");
		}

		else {
			System.out.println( "Feeling lucky regardless, you swing your ban hammer." );
			enemy.getBanned();
			enemy.lowerHP( 0 );
		}

		System.out.println( "Ye Olde Monster hit back for " + d2 +
				    " points of damage.");
	    }//end while

	    //option 1: you & the monster perish
	    if ( !enemy.isAlive() && !user.isAlive() ) {
		System.out.println( "'Twas an epic battle, to be sure... " + 
				    "You cut ye olde monster down, but " +
				    "with its dying breath ye olde monster. " +
				    "laid a fatal blow upon thy skull." );
		gameOver = true;
	    }
	    //option 2: you ban the beast
	    else if ( enemy.isBanned() ) {
	    System.out.println( "Nevertheless, the monster has been banned!" );
	    gameOver = false;
	    }
	    //option 3: the beast slays you
	    else if ( !user.isAlive() ) {
		System.out.println( "Ye olde self hath expired. You got dead." );
		gameOver = true;
	    }
	    //option 4: the beast gets killed
	    else {
	    System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
		gameOver = false;
	    }
	    	encounters++;
		}
	}

	System.out.println( "Thy game doth be over." );
	/*=============================================

	  =============================================*/

    }//end main

}//end class YoRPG




/*=============================================
  =============================================*/

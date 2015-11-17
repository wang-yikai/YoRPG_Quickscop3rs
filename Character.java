/*
Team Quickscop3rs - Yikai Wang, Ziyan Lin, and Dhruba Roy
APCS1 pd9
HW31 -- Ye Olde Role Playing Game, Unchained
2015-11-16
*/

public abstract class Character{

      protected int HP;        //health (public because no accessors)
      protected int strength;          //strength;
      protected int D;		//defense
      protected double AR;            //attack rating
      protected boolean alive; //alive?
      protected String N; //name

      //other attributes
      protected int speed; //speed rating higher for rogues
      protected int MP;  //for mages
      protected double chance; //for quickscopers
      protected boolean ban; //sees if the monster is banned
      protected String chr_type; //type of character
      protected String s; //for about()

      public String getType() { //tells what class type
            return chr_type;
      }

	public boolean isAlive() { //it's alive!
            return alive;
       }

      public boolean getBanned() { //Admin bans
            ban = true;
            return ban;
      }

      public boolean isBanned() { //did the Admin ban?
            return ban;
       }

      public int getDefense(){//returns defense rating
             return D;
       }

      public void lowerHP( int num ) {//hp lowered from attack
	     HP -= num; 
	     if (HP <= 0) {
		    alive = false;
	     }
      }
       
      public int attack( Character m ){//attacks
      int b;

      if( chr_type.equals( "Admin") ) { //for Admin
            m.getBanned();
            b = 0;
      }

      else if( ( MP == 0 ) && !chr_type.equals( "Quickscoper") ) { //Monsters, Warriors, and Rogues
            b = ( int ) ((strength * AR * speed) - m.getDefense());
      }

      else if( ( MP != 0 )) { //for mages
            b = ( int ) ( ( MP * speed * AR ) - m.getDefense() );
      }

      else { //for quicksopers
            chance += Math.random();

            if( chance <= 0.60 ) {
                  b = 60; //body shot
            }
            else if( chance < 0.90 ) {
                  b = 30; //limb
            }
            else if( chance < 1.2 ) {
                  b = 200; //360 no-scope insta-kill;
            }
            else if( chance < 1.60 ) {
                  b = 100; //BOOM - headshot
            }
            else {
                  b = 0; //misses
            }
            chance = 0;
      }
            m.lowerHP( b );
            return b;        
      }
      
      public String getName(){ //gives name
            return N;
       }
       
    public abstract void specialize(); //prepares special attack
   
    public abstract void normalize(); //normal attack preparation
    
    public abstract String about();
      
}

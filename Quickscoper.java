/*
Team Quickscop3rs - Yikai Wang, Ziyan Lin, and Dhruba Roy
APCS1 pd9
HW31 -- Ye Olde Role Playing Game, Unchained
2015-11-16
*/

public class Quickscoper extends Character{

       public String about() {
            s = "The god of all FPS Shooters. Carries a sniper rifle that pierces armor. Has a chance to miss.\n";
            s += "Stats: \n";
            s += "HP : 100 \nStrength : 30\nDefense : 50\nAttack Rating : 1\nSpeed : 1\nMP : 0\n";
            return s;
       }

    public void normalize(){
	   chance = 0.0;
    }
    
    public void specialize(){
        chance = 0.9;   
    }
       public Quickscoper(){ //default constructor for warrior
            N = "Bot";
            HP = 100;
            strength = 30;
            D = 50;
            AR =  1;
            alive = true;

            speed = 1;
            MP = 0;
            chance = 0.0;
            ban = false;
            chr_type = "Quickscoper";
       }
       
       public Quickscoper(String a){//custom constructor
            N = a;
            HP = 100;
            strength = 30;
            D = 50;
            AR =  1.2 ;
            alive = true;

            speed = 1;
            MP = 0;
            chance = 0.0;
            ban = false;
            chr_type = "Quickscoper";
       }
}

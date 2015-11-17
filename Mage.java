/*
Team Quickscop3rs - Yikai Wang, Ziyan Lin, and Dhruba Roy
APCS1 pd9
HW31 -- Ye Olde Role Playing Game, Unchained
2015-11-16
*/

public class Mage extends Character{

    public String about() {
        s = "The one who loves magic. Decent defense and offense.\n";
        s += "Stats: \n";
        s += "HP : 90 \nStrength : 1\nDefense : 36\nAttack Rating : 1\nSpeed : 1\nMP : 34\n";
        return s;
    }

    public void normalize(){
	   D = 36;
	   MP = 34;
	   AR = 1;
    }

    public void specialize(){
       D *= 0.4;
       MP *= 1.6;
       AR *= 1.3;
    }

       public Mage(){ //default constructor for warrior
            N = "Bot";
            HP = 90;
            strength = 1;
            D = 36;
            AR =  1;
            alive = true;

            speed = 1;
            MP = 34;
            chance = 0.0;
            ban = false;
            chr_type = "Mage";
       }
       
       public Mage(String a){//custom constructor
            N = a;
            HP = 90 ;
            strength = 1;
            D = 36;
            AR =  1;
            alive = true;

            speed = 1;
            MP = 34;
            chance = 0.0;
            ban = false;
            chr_type = "Mage";
       }
}

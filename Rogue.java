/*
Team Quickscop3rs - Yikai Wang, Ziyan Lin, and Dhruba Roy
APCS1 pd9
HW31 -- Ye Olde Role Playing Game, Unchained
2015-11-16
*/

public class Rogue extends Character{
    
    public String about() {
        s = "The speedy type, who is frail, but deadly.\n";
        s += "Stats: \n";
        s += "HP : 85 \nStrength : 20\nDefense : 25\nAttack Rating : 1\nSpeed : 3\nMP : 0\n";
        return s;
       }

    public void normalize(){
	   D = 25;
	   speed = 3;
	   AR = 1;
    }

    public void specialize(){
        D *= 0.25;
        speed *= 2;
        AR *= 1.2;
    }
       public Rogue(){ //default constructor for warrior
            N = "Bot";
            HP = 85;
            strength = 20;
            D = 25;
            AR =  1;
            alive = true;

            speed = 3;
            MP = 0;
            chance = 0.0;
            ban = false;
            chr_type = "Rogue";
       }
       
       public Rogue(String a){//custom constructor
            N = a;
            HP = 85;
            strength = 20;
            D = 25;
            AR =  1;
            alive = true;

            speed = 3;
            MP = 0;
            chance = 0.0;
            ban = false;
            chr_type = "Rogue";
       }
}

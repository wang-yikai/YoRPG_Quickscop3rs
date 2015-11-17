/*
Team Quickscop3rs - Yikai Wang, Ziyan Lin, and Dhruba Roy
APCS1 pd9
HW31 -- Ye Olde Role Playing Game, Unchained
2015-11-16
*/

public class Monster extends Character{

    public String about(){
	    s = "I'm just a monster...leave me alone!QwQ";
        return s;
    }

    public void normalize(){
	   D = 20;
	   AR = 1;
    }

    public void specialize(){
        D *= 0.5;
        AR *= 1.5;
    }


      public Monster(){ //default constructor for monster
	    	N = "Trololol";
            HP = 150;
            strength = (int)(Math.random() * 46 + 20);
            D = 20;
            AR =  1;
            alive = true;

            speed = 1;
            MP = 0;
            chance = 0.0;
            ban = false;
            chr_type = "Monster";
       }      
}

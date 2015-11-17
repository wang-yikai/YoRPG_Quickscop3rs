/*
Team Quickscop3rs - Yikai Wang, Ziyan Lin, and Dhruba Roy
APCS1 pd9
HW31 -- Ye Olde Role Playing Game, Unchained
2015-11-16
*/

public class Warrior extends Character{
    
    public String about(){
       s = "The common, brolic warrior in heavy armor. A mix between defense and offense.\n";
       s += "Stats: \n";
       s += "HP : 100 \nStrength : 50\nDefense : 40\nAttack Rating : 1.2\nSpeed : 1\nMP : 0\n"; 
       return s;
    }
    
    public void normalize(){
	   D = 40;
	   AR = 1.2;
    }
    
    public void specialize(){
        D *= 0.5;
        AR *= 1.5; 
    }
       public Warrior(){ //default constructor for warrior
            N = "Bot";
            HP = 100;
            strength = 50;
            D = 40;
            AR =  1.2;
            alive = true;

            speed = 1;
            MP = 0;
            chance = 0.0;
            ban = false;
            chr_type = "Warrior";
       }
       
       public Warrior(String a){//custom constructor
            N = a;
            HP = 100;
            strength = 50;
            D = 40;
            AR =  1.2;
            alive = true;

            speed = 1;
            MP = 0;
            chance = 0.0;
            ban = false;
            chr_type = "Warrior";
       }
}

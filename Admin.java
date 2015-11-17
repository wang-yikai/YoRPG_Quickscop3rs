/*
Team Quickscop3rs - Yikai Wang, Ziyan Lin, and Dhruba Roy
APCS1 pd9
HW30 -- Ye Olde Role Playing Game, Expanded
2015-11-13
*/

public class Admin extends Character{

       public String about(){
            s = "The ultimate, immortal boss who weilds the ban hammer and can erase characters from existance.";
            s += "Stats: \n";
            s += "HP : 1 \nStrength : 0\nDefense : 999999\nAttack Rating : 0\nSpeed : 0\nMP : 0\n";
            return s;
    }
    public void normalize(){
	alive = true;
	HP = 1;
    }
   
    public void specialize(){
        alive = true; //prevents hp from going over the limit
        HP = 1;
    }
       
       public Admin(){ //default constructor for warrior
            N = "The Boss";
            HP = 1;
            strength = 0;
            D = 999999;
            AR =  0;
            alive = true;

            speed = 0;
            MP = 0;
            chance = 0.0;
            ban = false;
            chr_type = "Admin";
       }
       
       public Admin(String a){//custom constructor
            N = a;
            HP = 1;
            strength = 0;
            D = 999999;
            AR =  0;
            alive = true;

            speed = 0;
            MP = 0;
            chance = 0.0;
            ban = false;
            chr_type = "Admin";
       }
}

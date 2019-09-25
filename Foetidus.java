import java.util.Scanner;
import java.util.Random;



public class Foetidus extends Mainfile
{

static String choice;
static Scanner scanner = new Scanner(System.in);
static Random rand = new Random();

static int lvlMimic;
static double expRec = 50;
static double exp;
static int playerLvl = 1;


static int hpPlayer = 20;
static int damage;
static int enemyDamage;
static int totalPotions;
static int weaponS = 10;
static int lvlBandit;
static int lvlPirter;
static int maxHp = 20;
public static DamageSystem DamageSystem = new DamageSystem();
public static Hud hud = new Hud();
public static Sounds sound = new Sounds();

public static void main(String[] args)
  {
    dungeonEntrance();

  }

  public static void dungeonEntrance()
  {
    while(true){
      hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),


                                      "You have found a Dungeon, enter it? y / n",   "",   "",   "",   "",   "",   "",    "",
                                      "",   "",   "",   "",   "",   "",   "",
                                      "",   "",   "",   "",   "",   "",   "");
      String choice = scanner.nextLine();

      if(choice.equals("n"))
      {
        break;
      }

      else if (choice.equals("y"))//a
      {
        roomOne();
        break;
      }
      else
      {
        hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),


                                      "That is not an option!",   "",   "",   "",   "",   "",   "",    "",
                                      "",   "",   "",   "",   "",   "",   "",
                                      "",   "",   "",   "",   "",   "",   "");
      }
      continue;
    }
  }


    public static void roomOne()
    {

      while(true){
        hud.callHud(  7,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
     Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                        Integer.toString(fo),


                                        "You enter the Dungeon and see two doors.",   "Do you take the left or right door? l / r",   "",   "",   "",   "",   "",    "",
                                        "",   "",   "",   "",   "",   "",   "",
                                        "",   "",   "",   "",   "",   "",   "");
      String choice = scanner.nextLine();

      if (choice.equals("l"))
      {
        arrowTrap();
        break;
      }

      else if (choice.equals("r"))
      {
        roomTwo();
        break;
      }
      else
      {
        hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),


                                      "That is not an option!",   "",   "",   "",   "",   "",   "",    "",
                                      "",   "",   "",   "",   "",   "",   "",
                                      "",   "",   "",   "",   "",   "",   "");
      }
      continue;
    }
   }



      public static void roomTwo()
      {


      while(true){
        hud.callHud(  7,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
     Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                        Integer.toString(fo),


                                        "You see nothing but two other doors.",   "Do you enter the left or the right door? l / r",   "",   "",   "",   "",   "",    "",
                                        "",   "",   "",   "",   "",   "",   "",
                                        "",   "",   "",   "",   "",   "",   "");
      choice = scanner.nextLine();

      if (choice.equals("l"))
      {
        roomThree();
        break;
      }
      else if (choice.equals("r"))
      {
        poisonBearTrap();
        break;
      }
      continue;
    }

    }
      public static void roomThree()
      {
      while(true){
        hud.callHud(  7,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
     Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                        Integer.toString(fo),


                                        "And yet there is another empty room.",   "Wich door do you enter? Left or right? l / r",   "",   "",   "",   "",   "",    "",
                                        "",   "",   "",   "",   "",   "",   "",
                                        "",   "",   "",   "",   "",   "",   "");
      choice = scanner.nextLine();

      if (choice.equals("l"))
      {
        hud.callHud(  2,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),


                                      "You see and an old looking object.",   "You approach the object.",   "",   "",   "",   "",   "",    "",
                                      "",   "",   "",   "",   "",   "",   "",
                                      "",   "",   "",   "",   "",   "",   "");
        chest();
        break;
      }

      else if (choice.equals("r"))
      {
        roomFour();
        break;
      }
      else
      {
        hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),


                                      "That is not an option!",   "",   "",   "",   "",   "",   "",    "",
                                      "",   "",   "",   "",   "",   "",   "",
                                      "",   "",   "",   "",   "",   "",   "");
      }

    }
    }
    public static void roomFour()
    {
      hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),


                                      "You find nothing but a dead end, so you decide",   "to head back to the exit.",   "",   "",   "",   "",   "",    "",
                                      "",   "",   "",   "",   "",   "",   "",
                                      "",   "",   "",   "",   "",   "",   "");
    }







//###########################Traps#####################################################
    public static void arrowTrap()
   {
     hpPlayer = hpPlayer - 4;
     hud.callHud(  6,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),


                                      "You accedently stepped on a pressureplate and ",   "triggered an Arrow Trap.",   "",   "The trap hit you, You have " + hpPlayer + " health left.",   "",   "",   "",    "",
                                      "",   "",   "",   "",   "",   "",   "",
                                      "",   "",   "",   "",   "",   "",   "");
   }

   public static void poisonBearTrap()
  {

    if (species.equals("suruma"))
    {
      hpPlayer = hpPlayer - 16;
      hud.callHud(  5,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),


                                      "You accedently stepped in a poisoned bear trap",   "The poison quicly runs trough your system.",   "The trap hit you, You have " + hpPlayer + " health left.",   "",   "",   "",   "",    "",
                                      "",   "",   "",   "",   "",   "",   "",
                                      "",   "",   "",   "",   "",   "",   "");
    }
    else
    {
     hpPlayer = hpPlayer - 3;
     hud.callHud(  5,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),


                                      "You accedently stepped in a poisoned bear trap.",   "The trap hit you, You have " + hpPlayer + " health left.",   "",   "",   "",   "",   "",    "",
                                      "",   "",   "",   "",   "",   "",   "",
                                      "",   "",   "",   "",   "",   "",   "");
     }
}


public static void chest()
{
  hud.callHud(  2,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
                                      "You found a Chest, do you want to open it? y / n",   "",   "",   "",   "",   "",   "",    "",
                                      "",   "",   "",   "",   "",   "",   "",
                                      "",   "",   "",   "",   "",   "",   "");
  choice = scanner.nextLine();

  while(true){
    if(choice.equals("y"))
    {
      hud.callHud(  3,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
                                      "You open the chest.",   "You obtained 30 Gold",   "You obtained 1 Potion",   "",   "",   "",   "",    "",
                                      "",   "",   "",   "",   "",   "",   "",
                                      "",   "",   "",   "",   "",   "",   "");

      go = go + 30;
      totalPotions = totalPotions + 1;

      Random mimicChance = new Random();
      int chanceM = rand.nextInt(5) + 1;

      switch (chanceM)
      {
        case 1: case 2:
        break;

        case 3: case 4: case 5:
        mimicEncounter();
        break;
      }


    }
    else if (choice.equals("n"))
    {
      hud.callHud(  2,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
     Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                        Integer.toString(fo),
                                        "You leave the chest and return to the exit.",   "",   "",   "",   "",   "",   "",    "",
                                        "",   "",   "",   "",   "",   "",   "",
                                        "",   "",   "",   "",   "",   "",   "");
    break;
    }
    continue;
  }

}

     public static void mimicEncounter()
     {
       int mimic = 7;

       hud.callHud(  4,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
                                      "The chest appears to be a Mimic and bites",   "you in your arm!",   "",   "",   "",   "",   "",    "",
                                      "",   "",   "",   "",   "",   "",   "",
                                      "",   "",   "",   "",   "",   "",   "");
       Random rand = new Random();
       int lvlMimic = rand.nextInt(3) + playerLvl;

       if (lvlMimic == 1)
       {
        hpPlayer = hpPlayer - 2;
       }
       else{
       mimic = mimic + (2 * lvlMimic);
       hpPlayer = hpPlayer - lvlMimic;
     }



       while (true){
       Scanner scanner = new Scanner(System.in);
       hud.callHud(  4,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
    Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                     Integer.toString(fo),
                                     "You have " + hpPlayer + " Health remaining",   "A Mimic (lvl " + lvlMimic + ") has engaged you.",   "",   "What will you do?",   "",   "<fight>",   "<potion>",    "",
                                     "",   "",   "",   "",   "",   "",   "",
                                     "",   "",   "",   "",   "",   "",   "");
       choice = scanner.nextLine();
       if (choice.equals("fight"))
       {
           int finalDamage = DamageSystem.calculateWeaponDMG(0001001, 0, 0);
           mimic = mimic - finalDamage;

           sound.playSoundHit();

           hud.callHud(  4,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
                                      "You attacked the enemy.",   "",   "You did " + finalDamage + " damage.",   "",   "The Mimic(lvl " + lvlMimic + ") has " + mimic + " health remaining.",   "",   "",    "",
                                      "",   "",   "",   "",   "",   "",   "",
                                      "",   "",   "",   "",   "",   "",   "");
       }
       //potions to heal
       else if (choice.equals("potion"))
       {

       if (totalPotions == 0){

         hud.callHud(  8,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
                                      "You are out of potions!",   "",   "",   "",   "",   "",   "",    "",
                                      "",   "",   "",   "",   "",   "",   "",
                                      "",   "",   "",   "",   "",   "",   "");
       }

         else if (totalPotions > 0){
           int heal = rand.nextInt(10) + 7;
           hpPlayer = hpPlayer + heal;
           totalPotions = totalPotions - 1;

           hud.callHud(  8,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
                                      "You used a potion and healed.",   "",   "You have " + totalPotions + " remaining.",   "",   "You gained " + heal + " hp.",   "",   "",    "",
                                      "",   "",   "",   "",   "",   "",   "",
                                      "",   "",   "",   "",   "",   "",   "");
         }
         //maxhealth
         if (hpPlayer >= 21){
         hpPlayer = hpPlayer - hpPlayer + 20;

         hud.callHud(  8,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
                                      "You now have " + hpPlayer + " health.",   "",   "",   "",   "",   "",   "",    "",
                                      "",   "",   "",   "",   "",   "",   "",
                                      "",   "",   "",   "",   "",   "",   "");
         }

         else {

           hud.callHud(  8,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
     Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                        Integer.toString(fo),
                                        "You now have " + hpPlayer + " health.",   "",   "",   "",   "",   "",   "",    "",
                                        "",   "",   "",   "",   "",   "",   "",
                                        "",   "",   "",   "",   "",   "",   "");
         }

       }
       //debug exit v
       else if (choice.equals("/exit"))
       {

         hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
                                      "Shutting Down",   "",   "",   "",   "",   "",   "",    "",
                                      "",   "",   "",   "",   "",   "",   "",
                                      "",   "",   "",   "",   "",   "",   "");
       System.exit(0);
       }
       //debug exit ^
       else
       {

         hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
                                      "That is not an option!",   "",   "",   "",   "",   "",   "",    "",
                                      "",   "",   "",   "",   "",   "",   "",
                                      "",   "",   "",   "",   "",   "",   "");
       }

       //defeated enemy
       if (mimic < 1) {

         Random experience = new Random();
         double expRand = experience.nextInt(12) + 7;
         exp = exp + expRand;

         hud.callHud(  4,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
                                      "You have defeated the Mimic(lvl " + lvlMimic + ")",   "",   "You gained " + expRand + " Experience.",   "",   "You now have " + exp + " out of " + expRec + " Experience.",   "",   "",    "",
                                      "",   "",   "",   "",   "",   "",   "",
                                      "",   "",   "",   "",   "",   "",   "");
       if (exp >= expRec)
       {
       exp = expRec - exp;
       expRec = expRec * 1.7;
       expRec = Math.ceil(expRec);
       playerLvl = playerLvl + 1;
       maxHp = maxHp + 2;

       hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
                                      "You leveled up to Level " + playerLvl,   "",   "Your Max Health increased by 2Hp.",   "",   "After defeating the Mimic you leave the dungeon.",
                                         "",   "",    "",
                                      "",   "",   "",   "",   "",   "",   "",
                                      "",   "",   "",   "",   "",   "",   "");
     } else {

       hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
                                      "After defeating the Mimic you leave the dungeon.",   "",   "",   "",   "",   "",   "",    "",
                                      "",   "",   "",   "",   "",   "",   "",
                                      "",   "",   "",   "",   "",   "",   "");
        }

       break;
       }


       //enemy attack
       else
       {
         int enemyDamage = rand.nextInt(4) + 0;

         hud.callHud(  4,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
                                      "The Mimic(lvl " + lvlMimic + ") attacked you.",   "",   "The Mimic(lvl " + lvlMimic + ") did " + enemyDamage + " damage.",   "",   "",   "",   "",    "",
                                      "",   "",   "",   "",   "",   "",   "",
                                      "",   "",   "",   "",   "",   "",   "");
         hpPlayer = hpPlayer - enemyDamage;

         //game over
         if (hpPlayer < 1) {

           hud.callHud(  4,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
                                      "You have " + hpPlayer + " health remaining.",   "",   "You are defeated, GAME OVER!!!",   "",   "",   "",   "",    "",
                                      "",   "",   "",   "",   "",   "",   "",
                                      "",   "",   "",   "",   "",   "",   "");
         System.exit(0);
         }
         else{
           hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
                                      "You have " + hpPlayer + " health remaining.",   "",   "",   "",   "",   "",   "",    "",
                                      "",   "",   "",   "",   "",   "",   "",
                                      "",   "",   "",   "",   "",   "",   "");
         }
         }
         continue;
       }

  }
}

import java.util.Random;
import java.util.Scanner;

class TeraPirter extends Mainfile {

  public static Sounds sound = new Sounds();

public static void TeraPirterAttack() {


  String choice;
  boolean bloodRage = false;
  int teraPirter = 13;
  int enemyAttack = 5;



  Random rand = new Random();
  int lvlTeraPirter = rand.nextInt(3) + playerLvl;

  teraPirter = teraPirter + (2 * lvlTeraPirter);

  {
    while (true){
      Scanner scanner = new Scanner(System.in);

      hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
      Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
                                      "A Tera Pirter (lvl " + lvlTeraPirter + ") has engaged you.", "", "What will you do?", "", "<fight>", "<potion>", "", "",
                                      "", "", "", "", "", "", "",
                                      "", "", "", "", "", "", "");
      choice = scanner.nextLine();
  if (choice.equals("fight"))
  {
    int finalDamage = DamageSystem.calculateWeaponDMG(0001001, 0, 0);
    teraPirter = teraPirter - finalDamage;

    sound.playSoundHit();

    hud.callHud(  1,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
    Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
                                      "You attacked the enemy.", "", "You did " + finalDamage + " damage.", "", "The Tera Pirter(lvl " + lvlTeraPirter + ") has " + teraPirter + " health remaining.", "", "", "",
                                      "Press enter to continue", "", "", "", "", "", "",
                                      "", "", "", "", "", "", "");
                                      ec = scanner.nextLine();
  }
  //potions to heal
  else if (choice.equals("potion"))
  {
    if (totalPotions == 0){
      hud.callHud(  8,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   	  Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
                                      "You are out of potions!", "", "", "", "", "", "", "",
                                      "", "", "", "", "", "", "",
                                      "", "", "", "", "", "", "");
    }

      else if (totalPotions > 0){
        int heal = rand.nextInt(10) + 7;
        hpPlayer = hpPlayer + heal;
        totalPotions = totalPotions - 1;
      }
      //maxhealth
      if (hpPlayer >= maxHp){
        hpPlayer = maxHp;
        hud.callHud(  8,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
        Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                    Integer.toString(fo),
                                    "You used a potion and healed.", "", "You have " + totalPotions + " remaining.", "", "You gained " + heal + " hp.", "", "You now have " + hpPlayer + " health.", "",
                                    "press enter to continue", "", "", "", "", "", "",
                                    "", "", "", "", "", "", "");
                                    ec = scanner.nextLine();
      }
      else {
        hud.callHud(  8,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   	    Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
                                      "You used a potion and healed.", "", "You have " + totalPotions + " remaining.", "", "You gained " + heal + " hp.", "", "You now have " + hpPlayer + " health.", "",
                                      "press enter to continue", "", "", "", "", "", "",
                                      "", "", "", "", "", "", "");
                                      ec = scanner.nextLine();
      }

    }
  //debug exit v
  else if (choice.equals("/exit"))
  {
    System.out.println("Shutting Down");
    System.exit(0);
  }
  //debug exit ^
  else
  {
    hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   	Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
                                      "That is not an option!", "", "", "", "", "", "", "",
                                      "press enter to continue", "", "", "", "", "", "",
                                      "", "", "", "", "", "", "");
                                      ec = scanner.nextLine();
  }



  //defeated enemy
  if (teraPirter < 1) {
    Random experience = new Random();
    double expRand = experience.nextInt(12) + 7;
    exp = exp + expRand;
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
                                    "You have defeated the Tera Pirter(lvl " + lvlTeraPirter + ")", "", "You gained " + expRand + " Experience.", "", "You now have " + exp + " out of " + expRec + " Experience.", "", "You leveled up to Level " + playerLvl, "",
                                    "Your Max Health increased by 2", "", "", "press enter to continue", "", "", "",
                                    "", "", "", "", "", "", "");
                                    ec = scanner.nextLine();
    }
    else{
      hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   	  Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
                                      "You have defeated the Tera Pirter(lvl " + lvlTeraPirter + ")", "", "You gained " + expRand + " Experience.", "", "You now have " + exp + " out of " + expRec + " Experience.", "", "", "",
                                      "press enter to continue", "", "", "", "", "", "",
                                      "", "", "", "", "", "", "");
                                      ec = scanner.nextLine();
    }

    break;
  }


  //enemy attack
    else
    {
    int enemyDamage = rand.nextInt(enemyAttack) + 0;
      hpPlayer = hpPlayer - enemyDamage;
      if(bloodRage == false)
      {
        bloodRage = true;
        enemyAttack = enemyAttack * 2;
        teraPirter = teraPirter + 3;
        hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   	    Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
                                      "The Tera Pirter(lvl " + lvlTeraPirter + ") attacked you.", "", "The Tera Pirter(lvl " + lvlTeraPirter + ") did " + enemyDamage + " damage.", "", "The Tera Pirter(lvl " + lvlTeraPirter + ") is in a Blood Rage.", "", "The Tera Pirter(lvl " + lvlTeraPirter + ") now has double attack and ", "" + teraPirter + " Health.",
                                      "press enter to continue", "", "", "", "", "", "",
                                      "", "", "", "", "", "", "");
                                      ec = scanner.nextLine();
      }
      else{
        hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   	    Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
                                      "The Tera Pirter(lvl " + lvlTeraPirter + ") attacked you.", "", "The Tera Pirter(lvl " + lvlTeraPirter + ") did " + enemyDamage + " damage.", "", "", "", "", "",
                                      "", "", "", "", "", "", "",
                                      "", "", "", "", "", "", "");
                                      ec = scanner.nextLine();
                                      restart();
                                      String[] test = {};
                                      main(test);
      }

    //game over
    if (hpPlayer < 1) {
      hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   	  Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
                                      "You have " + hpPlayer + " health remaining.", "", "You are defeated, GAME OVER!!!", "", "", "", "", "",
                                      "press enter to continue", "", "", "", "", "", "",
                                      "", "", "", "", "", "", "");
                                      ec = scanner.nextLine();
                                      restart();
                                      String[] test = {};
                                      main(test);

      System.exit(0);
    }
    }
    continue;
    }

    }
  }

public static void main(String[] args)
{
    TeraPirterAttack();
}

}

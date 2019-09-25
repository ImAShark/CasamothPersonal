import java.util.Scanner;
import java.util.Random;
import java.net.URL;
import javax.sound.sampled.*;

public class Mainfile
{

	//link
	public static Foetidus foetidus = new Foetidus();
	public static DamageSystem DamageSystem = new DamageSystem();
	public static TeraPirter TeraPirter = new TeraPirter();
	public static Hud hud = new Hud();
	public static Sounds sound = new Sounds();
	public static Mainfile self = new Mainfile();
	public static HomeScreen HomeScreen = new HomeScreen();
	//inventory
	static int po;  //health potion
	static int fo;  //food
	static int go;	//gold
	static String fopo;//chooice between the two items
	static int res; //resting
	//travel
	static double tv1; //travel1
	static double tv2; //travel2
	static double sn;  //stamina
	static double sl;  //start location
	static double el;  //end location
	static double l;   //location....
	static String slb;  //start first travel
	static String slbt;  //start city
	static double x;   //x
	static double y;   //y
	static double tvy1;//travel2
	static double tvy2;//travel2
	//battle
	static int hpPlayer = 20;
	static int damage;
	static int enemyDamage;
	static int totalPotions;
	static int weaponS = 10;
	static int lvlBandit;
	static int lvlPirter;
	static int maxHp = 20;
	static int heal = 7 + (int)Math.ceil(Math.random() * 10);

	//character creation
	static String species;
	static String username;
	static String factionName;
	//making Scanner
	static Scanner scanner = new Scanner(System.in);
	//making random
	static Random random = new Random();
	// enter to continue
	static String ec;
	//Experience
	static double expRec = 50;
	static double exp;
	static int playerLvl = 1;
	//dungeon complete
	static boolean Foetidus = false;
	//quest book
	static String questBook = "this is your QuestBook: \n";
	//alchemist no name quest
	static boolean iooiooi;// quest alchemist accepted
	static boolean iooiooia; // quest alchemist grabbed item
	static boolean iooiooib; // quest completed no Bandit
	static boolean iooiooic; // quest completed bandits
	static int iooiooid; //amount of lilly's
	static int iooiooie = 7; //max lilly's without bandits
	static int iooiooif = 5; //max lilly's with bandits
	static boolean iooiooig; //first leave went off
	static String iooiooiz = " I need to get black lilly's for the alchemist\n She said there where some at 246 123.\n and the second one was at 222 128.\n";
	static boolean lfwbaw = false; //lilly field without bandits already went
	static boolean lfbaw = false; // lilly field with bandits already went
	// music
	public static String audio;
	public static URL url;
	public static AudioInputStream input;
	public static DataLine.Info info;
	public static Clip clip;
	public static int themeSong;

public static void main(String[] args)
	{
		if  (themeSong != 1){
			try{
				self.playMusic(1);
				url = (URL) self.getClass().getResource("sounds/sound_tracks/"+audio+".wav");
				input = AudioSystem.getAudioInputStream(url);
				info = new DataLine.Info(Clip.class, input.getFormat());
				clip = (Clip) AudioSystem.getLine(info);
				clip.open(input);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
			catch (Exception e) {
			 System.out.println(e.toString());
			}
		}


		HomeScreen.printHomeScreen();
		ec = scanner.nextLine();
		tutorial();
		tTutorial();
		System.out.println("");
		sn = 25;


		while (true)
		{

			//to no name town
			if (tv1 == 199 && tvy1 == 100)
			{

				while (true)
				{
					String nn;
					String nnst;

					if (themeSong != 1){
						themeSong = 1;
						if (clip.isRunning()) clip.stop();
						try{
							self.playMusic(1);
							url = (URL) self.getClass().getResource("sounds/sound_tracks/"+audio+".wav");
							input = AudioSystem.getAudioInputStream(url);
							info = new DataLine.Info(Clip.class, input.getFormat());
							clip = (Clip) AudioSystem.getLine(info);
							clip.open(input);
							clip.start();
							clip.loop(Clip.LOOP_CONTINUOUSLY);
						}
						catch (Exception e) {
						 System.out.println(e.toString());
						}
					}

					Scanner nns = new Scanner(System.in);
					hud.callHud(/*int image*/11, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
					/*int food*/Integer.toString(fo),
					/*r 1*/"You made it to the city of no name.", /*r 2*/"What do you want to do?", /*r 3*/"", /*r 4*/"<tavern>", /*r 5*/"<quest book>", /*r 6*/"<inventory>", /*r 7*/"<travel>", /*r 8*/ "<market>",
					/*r 9*/"", /*r 10*/"", /*r 11*/"", /*r 12*/"", /*r 13*/"", /*r 14*/"", /*r 15*/"",
					/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");
					nn = scanner.nextLine();

					if (nn.equals ("inventory"))
					{
						Scanner fopos = new Scanner(System.in);
						hud.callHud(/*int image*/11, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
						/*int food*/Integer.toString(fo),
						/*r 1*/"gold: " + go, /*r 2*/"", /*r 3*/"", /*r 4*/"you have " + fo + " food.", /*r 5*/"you have " + po + " potion's.", /*r 6*/"What do you want to use?", /*r 7*/"", /*r 8*/ "<potion>",
						/*r 9*/"<food>", /*r 10*/"", /*r 11*/"<leave>", /*r 12*/"", /*r 13*/"", /*r 14*/"", /*r 15*/"",
						/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");
						fopo = scanner.nextLine();
						if (fopo.equals ("food"))
						{
							eatFood();
							continue;
						}
						else if (fopo.equals ("potion"))
						{
							break;
						}
						else if (fopo.equals ("nothing"))
						{
							hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   						Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
              Integer.toString(fo),
        			"You used nothing.", "", "", "", "", "", "", "",
        			"", "", "", "", "", "", "",
        			"", "", "", "", "", "", "");
							break;
						}
					}
					if (nn.equals ("tavern"))
					{
						//making no name taffern
						String nnt;

						Scanner nnts = new Scanner(System.in);
						hud.callHud(/*int image*/0, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
						/*int food*/Integer.toString(fo),
						/*r 1*/"Do you want to rest?", /*r 2*/"Your staimina will be reffilled to 25.", /*r 3*/"It will cost you 20 gold for the night. y / n", /*r 4*/"", /*r 5*/"", /*r 6*/"", /*r 7*/"", /*r 8*/ "",
						/*r 9*/"", /*r 10*/"", /*r 11*/"", /*r 12*/"", /*r 13*/"", /*r 14*/"", /*r 15*/"",
						/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");
						nnt = scanner.nextLine();
							if (nnt.equals ("y") && go > 20)
							{
								sn = 25;
								hpPlayer = 20;
								go = go - 20;
								hud.callHud(/*int image*/0, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
								/*int food*/Integer.toString(fo),
								/*r 1*/"Do you want to rest?", /*r 2*/"Your staimina will be reffilled to 25.", /*r 3*/"It will cost you 20 gold for the night. y / n", /*r 4*/"", /*r 5*/"You have rested up to 25 stamina.", /*r 6*/"", /*r 7*/"", /*r 8*/ "",
								/*r 9*/"", /*r 10*/"", /*r 11*/"", /*r 12*/"", /*r 13*/"", /*r 14*/"", /*r 15*/"",
								/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");
							}
							else if (nnt.equals ("n"))
							{
								hud.callHud(/*int image*/10, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
								/*int food*/Integer.toString(fo),
								/*r 1*/"Do you want to rest?", /*r 2*/"Your staimina will be reffilled to 25.", /*r 3*/"It will cost you 20 gold for the night. y / n", /*r 4*/"", /*r 5*/"Remember we have warm beds.", /*r 6*/"", /*r 7*/"", /*r 8*/ "",
								/*r 9*/"", /*r 10*/"", /*r 11*/"", /*r 12*/"", /*r 13*/"", /*r 14*/"", /*r 15*/"",
								/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");
							}
							else
							{
								hud.callHud(/*int image*/0, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
								/*int food*/Integer.toString(fo),
								/*r 1*/"Do you want to rest?", /*r 2*/"Your staimina will be reffilled to 25.", /*r 3*/"It will cost you 20 gold for the night. y / n", /*r 4*/"", /*r 5*/"We aren't working charity.", /*r 6*/"Get out!!!", /*r 7*/"", /*r 8*/ "",
								/*r 9*/"Press enter to continue.", /*r 10*/"", /*r 11*/"", /*r 12*/"", /*r 13*/"", /*r 14*/"", /*r 15*/"",
								/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");
								ec = scanner.nextLine();
							}
					}
					else if (nn.equals ("market"))
					{
						while (true)
						{
							String nnm;

							Scanner nnms = new Scanner(System.in);
							hud.callHud(/*int image*/0, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
							/*int food*/Integer.toString(fo),
							/*r 1*/"You have approuched the market.", /*r 2*/"Where do you want to go?", /*r 3*/"", /*r 4*/"<bakkery>", /*r 5*/"<alchemist>", /*r 6*/"", /*r 7*/"<leave>", /*r 8*/ "",
							/*r 9*/"", /*r 10*/"", /*r 11*/"", /*r 12*/"", /*r 13*/"", /*r 14*/"", /*r 15*/"",
							/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");
							nnm = scanner.nextLine();

							if (nnm.equals ("alchemist"))
							{
								String nna;
								int nnpa;
								if (themeSong != 3){
									themeSong = 3;
									if (clip.isRunning()) clip.stop();
									try{
										self.playMusic(3);
										url = (URL) self.getClass().getResource("sounds/sound_tracks/"+audio+".wav");
										input = AudioSystem.getAudioInputStream(url);
										info = new DataLine.Info(Clip.class, input.getFormat());
										clip = (Clip) AudioSystem.getLine(info);
										clip.open(input);
										clip.start();
										clip.loop(Clip.LOOP_CONTINUOUSLY);
									}
									catch (Exception e) {
									 System.out.println(e.toString());
									}
								}

								Scanner nnas = new Scanner(System.in);
								if (iooiooib == true || iooiooic == true)
								{
									hud.callHud(/*int image*/13, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
									/*int food*/Integer.toString(fo),
									/*r 1*/"Thank you again.", /*r 2*/"Just like i said.", /*r 3*/"My potions will now cost you 20 gold.", /*r 4*/"", /*r 5*/"What do you want to do?", /*r 6*/"", /*r 7*/"<potion>", /*r 8*/ "<ask>",
									/*r 9*/"<leave>", /*r 10*/"", /*r 11*/"", /*r 12*/"", /*r 13*/"", /*r 14*/"", /*r 15*/"",
									/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");
								}
								else if (iooiooi == true || iooiooi == true)
								{
									hud.callHud(/*int image*/13, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
									/*int food*/Integer.toString(fo),
									/*r 1*/"Have you done it?", /*r 2*/"Have you gathered the black lilly's?", /*r 3*/"", /*r 4*/"", /*r 5*/"", /*r 6*/"", /*r 7*/"", /*r 8*/ "",
									/*r 9*/"What do you want to do?", /*r 10*/"", /*r 11*/"<potion>", /*r 12*/"<ask>", /*r 13*/"", /*r 14*/"<leave>", /*r 15*/"",
									/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");
								}
								else if (iooiooia == true || iooiooia == true)
								{
									hud.callHud(/*int image*/13, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
									/*int food*/Integer.toString(fo),
									/*r 1*/"Have you done it?", /*r 2*/"Have you gathered the black lilly's?", /*r 3*/"", /*r 4*/"", /*r 5*/"", /*r 6*/"", /*r 7*/"", /*r 8*/ "",
									/*r 9*/"What do you want to do?", /*r 10*/"", /*r 11*/"<potion>", /*r 12*/"<ask>", /*r 13*/"<complete quest>", /*r 14*/"<leave>", /*r 15*/"",
									/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");
								}
								else if (iooiooi == false || iooiooi == false)
								{
									hud.callHud(/*int image*/13, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
									/*int food*/Integer.toString(fo),
									/*r 1*/"Welcome. I don't have much.", /*r 2*/"I could sell you some health potion's.", /*r 3*/"It will cost you 30 gold per potion.", /*r 4*/"I know it isn't cheap.", /*r 5*/"But this will at least it won't kill you.", /*r 6*/"Like what those proditions will make.", /*r 7*/"", /*r 8*/ "",
									/*r 9*/"What do you want to do?", /*r 10*/"", /*r 11*/"<potion>", /*r 12*/"<ask>", /*r 13*/"", /*r 14*/"<leave>", /*r 15*/"",
									/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");
								}
								//include option's for potion's and begin a quest
								nna = scanner.nextLine();
								switch (nna)
								{
									case "complete quest":
										if (iooiooia == true)
										{
											hud.callHud(  13,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
	   									Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
	                                      Integer.toString(fo),
	        							"You got the black lilly's?", "", "Thank you so much here is the money for the", "" +iooiooid +" lilly's.", "", "", "", "",
	        							"press enter to continue", "", "", "", "", "", "",
	        							"", "", "", "", "", "", "");
												ec = scanner.nextLine();
											go = go + (iooiooid * 10);
											iooiooia = false;
											iooiooib = true;
											questBook.replace(iooiooiz, "");
											break;
										}
									case "potion":
										if (iooiooib == false && iooiooic == false)
										{

											hud.callHud(  13,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   										Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
        								"As I said it will cost you 30 gold per potion,", "but I brew them at home.", "", "How many would you like to buy?", "", "<insert amount>", "", "",
        								"", "", "", "", "", "", "",
        								"", "", "", "", "", "", "");
											nnpa = scanner.nextInt();
											if (nnpa * 30 <= go && nnpa > 0)
											{

												hud.callHud(  13,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   											Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
        									"Ok let me grab them for you.", "", "Alright here are the " + nnpa + " health potion's.", "", "", "", "", "",
        									"", "", "", "", "", "", "",
        									"", "", "", "", "", "", "");
												go = go - (nnpa * 30);
												totalPotions = totalPotions + nnpa;
												break;
											}
											else if (nnpa * 30 >= go)
											{
												hud.callHud(  13,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   											Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
        									"Really???", "", "Come back when you have some money.", "", "<leave>", "", "", "",
        									"", "", "", "", "", "", "",
        									"", "", "", "", "", "", "");
													ec = scanner.next();
													break;
											}
											else if (nnpa < 0)
											{

												hud.callHud(  13,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   											Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
        									"Well, if you are not gonna buy anything...", "", "Would you please get out of the my store?", "Then there will be space for other customers.", "", "", "", "",
        									"", "", "", "", "", "", "",
        									"", "", "", "", "", "", "");
												break;
											}
											else
											{

												hud.callHud(  13,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   											Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
        									"Come bakc when you have money...", "", "", "", "", "", "", "",
        									"", "", "", "", "", "", "",
        									"", "", "", "", "", "", "");
													ec = scanner.next();
													break;
											}
										}
										else if (iooiooib == true || iooiooic == true){

											hud.callHud(  13,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
											Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
																		Integer.toString(fo),
																		"As I said it will cost you 20 gold per potion,", "but I brew them at home.", "", "How many would you like to buy?", "", "", "", "",
																		"", "", "", "", "", "", "",
																		"", "", "", "", "", "", "");
										  nnpa = scanner.nextInt();
											if (nnpa * 20 <= go && nnpa > 0)
											{

												hud.callHud(  13,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   											Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
        								"Alright, let me get them for you.", "", "Okay, here are your" + nnpa + "potion's.", "", "", "", "", "",
        								"", "", "", "", "", "", "",
        								"", "", "", "", "", "", "");
												go = go - (nnpa * 20);
												totalPotions = totalPotions + nnpa;
												break;
											}
											else if (nnpa * 20 >= go)
											{
												hud.callHud(  13,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   											Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
        								"Ah, you don't have enough money", "", "press enter to continue", "", "", "", "", "",
        								"", "", "", "", "", "", "",
        								"", "", "", "", "", "", "");
												ec = scanner.next();
												break;
											}
											else if (nnpa < 0)
											{
												hud.callHud(  13,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   											Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
        								"Dont want some today?", "", "Alright, see you later.", "", "", "", "", "",
        								"", "", "", "", "", "", "",
        								"", "", "", "", "", "", "");
												ec = scanner.next();
												break;
											}
											else
											{
												hud.callHud(  13,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
												Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
																		Integer.toString(fo),
												"I'm sorry, i didn't get that...", "", "", "", "", "", "", "",
												"", "", "", "", "", "", "",
												"", "", "", "", "", "", "");
												ec = scanner.next();
												break;
											}
										}
										break;
									case "ask":
										while(true)
										{

											hud.callHud(  13,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   										Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
        								"I was telling that I don't use those ingredients", "that the proditions use...", "",
												"For obvios reason's i asume.", "They use light lilly's instead of dark lilly's...", "",
												"What do you want to do?", "", "<offer help>",
												"<ask>", "<leave>", "",
												"", "", "",
        								"", "", "",
												"", "", "", "");
											nna = scanner.nextLine();
											if (nna.equals ("offer help"))
											{

												hud.callHud(  13,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   											Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
        									"You would like to help me?", "", "Don't worry I will happely pay for it...",
													"", "Uhhh, how does 10 gold per lilly sound to you?", "And the next time you buy potions they will",
													"cost you less...", "", "Would you please help me? y / n",
													"", "", "",
													"", "", "",
        									"", "", "", "", "", "", "");
												nna = scanner.nextLine();
												if (nna.equals("y"))
												{
													iooiooi = true;

													hud.callHud(  13,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   												Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
        										"Thank you so much!", "", "I can think of two location's where there might",
														"still be some dark lilly's left.", "", "Gear up because they both are really far away.",
														"", "The first one is at 246 123,", "and the second one is at 222 128.",
														"", "I'll mark the locations in your quest book.", "",
														"", "Press enter to continue", "",
        										"", "", "", "", "", "", "");
													questBook = questBook + iooiooiz;
													ec = scanner.nextLine();
												}
												else if(nna.equals("n"))
												{

													hud.callHud(  13,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   												Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
        										"Well, okay then.", "", "*Sigh*", "", "", "", "", "",
        										"", "", "", "", "", "", "",
        										"", "", "", "", "", "", "");
												}
												else
												{
													hud.callHud(  13,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
													Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
																				Integer.toString(fo),
														"I'm sorry, i didn't get that...", "", "", "", "", "", "", "",
														"", "", "", "", "", "", "",
														"", "", "", "", "", "", "");
												}
											}
										else if (nna.equals ("ask"))
										{
											hud.callHud(  13,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   										Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
        								"The white lilly's where made by some guys in", "the sky.", "", "I don't really trust that...", "", "", "", "",
        								"", "Press enter to continue", "", "", "", "", "",
        								"", "", "", "", "", "", "");
												ec = scanner.nextLine();
										}
										else if (nna.equals ("leave"))
										{
											break;
										}
										else
										{
											hud.callHud(  13,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
											Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
																		Integer.toString(fo),
												"I'm sorry, i didn't get that...", "", "", "", "", "", "", "",
												"", "", "", "", "", "", "",
												"", "", "", "", "", "", "");
										}
									}
									case "leave":
										if (iooiooic == true && iooiooig == true)
										{
											hud.callHud(  13,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
   										Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
                                      Integer.toString(fo),
        								"Ah, don't leave yet...", "", "I have found out that the black lilly's where",
												"higher quality than i expected.", "", "I still have a dagger for you. here you go.",
												"", "> obtained harvesting dagger <", "",
												"", "", "",
												"", "", "",
        								"", "", "", "", "", "", "");
										}
										else if (iooiooic == true)
										{
											iooiooig = true;
										}
										hud.callHud(  13,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
										Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
																		Integer.toString(fo),
																		"Well. See you next time...", "", "", "", "", "", "", "",
																		"", "", "", "", "", "", "",
																		"", "", "", "", "", "", "");
											System.out.println("");
											if (iooiooi == true)
											{
												hud.callHud(  13,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
												Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
																				Integer.toString(fo),
																				"Well. See you next time, and good luck", "", "", "", "", "", "", "",
																				"", "Press enter to continue", "", "", "", "", "",
																				"", "", "", "", "", "", "");
																				ec = scanner.nextLine();
											}
										break;
									default:
									hud.callHud(  13,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
									Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
																	Integer.toString(fo),
																	"I don't understand what you are saying.", "", "", "", "", "", "", "",
																	"", "", "", "", "", "", "",
																	"", "", "", "", "", "", "");
									break;
							}
						}
						if (themeSong != 1){
							themeSong = 1;
							if (clip.isRunning()) clip.stop();
							try{
								self.playMusic(1);
								url = (URL) self.getClass().getResource("sounds/sound_tracks/"+audio+".wav");
								input = AudioSystem.getAudioInputStream(url);
								info = new DataLine.Info(Clip.class, input.getFormat());
								clip = (Clip) AudioSystem.getLine(info);
								clip.open(input);
								clip.start();
								clip.loop(Clip.LOOP_CONTINUOUSLY);
							}
							catch (Exception e) {
							 System.out.println(e.toString());
							}
						}
						else if (nnm.equals ("Bakkery"))
						{

						}
						else if (nnm.equals ("leave"))
						{
							break;
						}
						else
						{
							hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
							Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
															Integer.toString(fo),
															"That is eather no option or you used capslock.", "", "", "", "", "", "", "",
															"", "", "", "", "", "", "",
															"", "", "", "", "", "", "");
						}
					}
					}
					else if (nn.equals ("travel"))
					{
						travel();
						break;
					}
					else if (nn.equals ("quest book"))
					{
						System.out.println(questBook);
						ec = scanner.nextLine();
						break;
					}
					if (nns.equals ("^"))
					{
						commandPrompt();
					}
						else
						{
							hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
							Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
															Integer.toString(fo),
															"That is either no option or you used capslock.", "So let's try this again.", "", "", "", "", "", "",
															"", "", "", "", "", "", "",
															"", "", "", "", "", "", "");
							continue;
						}
				}
			}

			//to ligonim
			else if (tv1 == 542 && tvy1 == 458)
			{
				while (true)
				{
					String li;
					String list;

					System.out.println("");
					System.out.println("you made it to ligonim");
					System.out.println("what do you want to do?");
					System.out.println("");
					System.out.println("<tavern>");
					System.out.println("<market>");
					System.out.println("<Quest book>");
					System.out.println("<stats>");
					System.out.println("<travel>");
					System.out.println("<inventory>");
					li = scanner.nextLine();

					if (li.equals ("inventory"))
					{
						System.out.println("gold: " + go);
						System.out.println("");
						System.out.println("you have " + fo + " food");
						System.out.println("you have " + po + " potion's");
						System.out.println("what do you want to use");
						System.out.println("or type nothing to dont use anything");
						fopo = scanner.nextLine();
						if (fopo.equals ("food"))
						{
							eatFood();
							continue;
						}
						else if (fopo.equals ("potion"))
						{
							break;
						}
						else if (fopo.equals ("nothing"))
						{
							System.out.println("you used nothing");
							System.out.println("");
							break;
						}
					}
					if (li.equals ("tavern"))
					{
						//making no name taffern
						String lit;

						Scanner nnts = new Scanner(System.in);
						System.out.println("do you want to rest? it will cost you 20 gold for the night. y/n");
						System.out.println("your staimina will be reffilled to 500");
						lit = scanner.nextLine();
							if (lit.equals ("y") && go > 20)
							{
								sn = 25;
								hpPlayer = 20;
								go = go - 20;
								System.out.println("You have rested");
							}
							else if (lit.equals ("n"))
							{
								System.out.println("if you ever want to return, you are welcome.");
							}
							else if (go < 20)
							{
								System.out.println("Sorry you do not have enough gold for that.");
							}
							else
							{
								System.out.println("I didn't catch that, what did you say?");
							}
					}
					else if (li.equals ("market"))
					{
						while (true)
						{
							String lim;

							System.out.println("");
							System.out.println("you aprouch the market");
							System.out.println("What store do you want to visit?");
							System.out.println("");
							System.out.println("<Alchemist>");
							System.out.println("<Bakkery>");
							lim = scanner.nextLine();

							if (lim.equals ("alchemist"))
							{
								String lia;

								System.out.println("Welcome. I don't have much but i could sell you some health potion's");
								System.out.println("It will cost you 30 gold per potion.");
								System.out.println("I know it isn't cheap but this will at least not kill you like what those proditions will make.");
								System.out.println("");
								System.out.println("What do you want to do");
								System.out.println("<potion>");
								System.out.println("<ask>");
								//include option's for potion's and begin a quest
								lia = scanner.nextLine();
								if (lia.equals ("potion"))
							{
									System.out.println("");
							}
							else if (lim.equals ("bakkery"))
							{
								System.out.println("");
							}
							else
							{
								System.out.println("there no such store here");
							}
						}
					}
				}
					else if (li.equals ("travel"))
					{
						travel();
						break;
					}
					else if (li.equals ("Quest book"))
					{
						System.out.println(questBook);
						ec = scanner.nextLine();
						break;
					}
					else if (li.equals ("stats"))
					{
						String lis;

						System.out.println("Here are your stats");
						System.out.println("health: " + hpPlayer);
						System.out.println("stamina: " + sn);
						System.out.println("press any button to continue");
						lis = scanner.nextLine();
						if (lis.equals ("nothing you will ever get"))
						{
							System.out.println("ok not that button");
						}
						break;
					}
						else
						{
							System.out.println("That is either no option or you used caps");
							System.out.println("So let's try this again");
							continue;
						}
				}
			}

			//to dungeon
			else if (tv1 == 566 && tvy1 == 890)
			{
				if (themeSong != 2){
					themeSong = 2;
					if (clip.isRunning()) clip.stop();
					try{
						self.playMusic(2);
						url = (URL) self.getClass().getResource("sounds/sound_tracks/"+audio+".wav");
						input = AudioSystem.getAudioInputStream(url);
						info = new DataLine.Info(Clip.class, input.getFormat());
						clip = (Clip) AudioSystem.getLine(info);
						clip.open(input);
						clip.start();
						clip.loop(Clip.LOOP_CONTINUOUSLY);
					}
					catch (Exception e) {
					 System.out.println(e.toString());
					}
				}
					if (Foetidus == false)
					{
						foetidus.dungeonEntrance();
						Foetidus = true;
						travel();
					}
					else
					{
						hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
						Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
															Integer.toString(fo),
															"You already cleared this dungeon!", "", "", "", "", "", "", "",
															"", "", "", "", "", "", "",
															"", "", "", "", "", "", "");
						travel();
					}
			}

			//to the dark lilly's field without bandits
			else if (tv1 == 246 && tvy1 ==123)
			{
				if (themeSong != 1){
					themeSong = 1;
					if (clip.isRunning()) clip.stop();
					try{
						self.playMusic(1);
						url = (URL) self.getClass().getResource("sounds/sound_tracks/"+audio+".wav");
						input = AudioSystem.getAudioInputStream(url);
						info = new DataLine.Info(Clip.class, input.getFormat());
						clip = (Clip) AudioSystem.getLine(info);
						clip.open(input);
						clip.start();
						clip.loop(Clip.LOOP_CONTINUOUSLY);
					}
					catch (Exception e) {
					 System.out.println(e.toString());
					}
				}
				int lfwb; //lilly field withoud bandits
				int lfwbpa; // lilly field without bandits pirter attack

				hud.callHud(  9,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
				Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
															Integer.toString(fo),
															"That's a lot of lilly's...", "", "I think there are around 7 how many should I grab?",
															"", "It will take some time before i will be done.", "",
															"I think I can only harfest one time.", "", "",
															"", "", "", "", "", "",
															"", "", "", "", "", "", "");
				lfwb = scanner.nextInt();
				if (lfwb <= 7 && lfwb >= 1 && lfwbaw == false)
				{
					switch (lfwb)
					{
						case 7:
						lfwbpa = random.nextInt(100) + 1;
						lfwbaw = true;
						iooiooie = iooiooie - lfwb;
						iooiooid = iooiooid + lfwb;
						if (lfwbpa < 95)
						{
							//tena pirter attack
							TeraPirter.TeraPirterAttack();
						}
						iooiooia = true;
						travel();
							break;
						case 6:
						lfwbpa = random.nextInt(100) + 1;
						lfwbaw = true;
						iooiooie = iooiooie - lfwb;
						iooiooid = iooiooid + lfwb;
						if (lfwbpa < 85)
						{
							//tena pirter attack
							TeraPirter.TeraPirterAttack();
						}
						iooiooia = true;;
						travel();
							break;
						case 5:
						lfwbpa = random.nextInt(100) + 1;
						lfwbaw = true;
						iooiooie = iooiooie - lfwb;
						iooiooid = iooiooid + lfwb;
						if (lfwbpa < 70)
						{
							//tena pirter attack
							TeraPirter.TeraPirterAttack();
						}
						iooiooia = true;;
						travel();
							break;
						case 4:
						lfwbpa = random.nextInt(100) + 1;
						lfwbaw = true;
						iooiooie = iooiooie - lfwb;
						iooiooid = iooiooid + lfwb;
						if (lfwbpa < 55)
						{
							//tena pirter attack
							TeraPirter.TeraPirterAttack();
						}
						iooiooia = true;;
						travel();
							break;
						case 3:
						lfwbpa = random.nextInt(100) + 1;
						lfwbaw = true;
						iooiooie = iooiooie - lfwb;
						iooiooid = iooiooid + lfwb;
						if (lfwbpa < 35)
						{
							//tena pirter attack
							TeraPirter.TeraPirterAttack();
						}
						iooiooia = true;;
						travel();
							break;
						case 2:
						lfwbpa = random.nextInt(100) + 1;
						lfwbaw = true;
						iooiooie = iooiooie - lfwb;
						iooiooid = iooiooid + lfwb;
						if (lfwbpa < 20)
						{
							//tena pirter attack
							TeraPirter.TeraPirterAttack();
						}
						iooiooia = true;;
						travel();
							break;
						case 1:
						lfwbpa = random.nextInt(100) + 1;
						lfwbaw = true;
						iooiooie = iooiooie - lfwb;
						iooiooid = iooiooid + lfwb;
						if (lfwbpa < 5)
						{
							//tena pirter attack
							TeraPirter.TeraPirterAttack();
						}
						iooiooia = true;;
						hud.callHud(  9,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
						Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
																	Integer.toString(fo),
																	"I gathered "+ iooiooid + " lilly's", "", "I think i should go now",
																	"press enter to continue", "", "",
																	"", "", "",
																	"", "", "", "", "", "",
																	"", "", "", "", "", "", "");
																	ec = scanner.nextLine();
						travel();
							break;
						default:
							System.out.println("OH BOI, thats a buggie..");
						break;
					}
				}
			}

			//to the dark lilly's field without bandits
			else if (tv1 == 222 && tvy1 ==128)
			{
				if (themeSong != 1){
					themeSong = 1;
					if (clip.isRunning()) clip.stop();
					try{
						self.playMusic(1);
						url = (URL) self.getClass().getResource("sounds/sound_tracks/"+audio+".wav");
						input = AudioSystem.getAudioInputStream(url);
						info = new DataLine.Info(Clip.class, input.getFormat());
						clip = (Clip) AudioSystem.getLine(info);
						clip.open(input);
						clip.start();
						clip.loop(Clip.LOOP_CONTINUOUSLY);
					}
					catch (Exception e) {
					 System.out.println(e.toString());
					}
				}
				int lfb; //lilly field with bandits
				int lfbpa; // lilly field without bandits pirter attack
				hud.callHud(  9,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
				Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
															Integer.toString(fo),
					"Those are a lot of lilly's...", "", "I think there are around 5 how many should I grab?",
					"", "It will take some time before i will be done.", "",
					"I think I can only harfest one time...", "", "Seems like there are some ugly bandits...",
					"", "", "",
					"", "", "",
					"", "", "", "", "", "", "");
				bandit();
				bandit();
				lfb = scanner.nextInt();
				if (lfb <= 7 && lfb >= 1 && lfbaw == false)
				{
					switch (lfb)
					{
						case 7:
						lfbpa = random.nextInt(100) + 1;
						lfbaw = true;
						iooiooie = iooiooie - lfb;
						iooiooid = iooiooid + lfb;
						if (lfbpa < 95)
						{
							//tena pirter attack
							TeraPirter.TeraPirterAttack();
						}
						iooiooia = true;
						travel();
							break;
						case 6:
						lfbpa = random.nextInt(100) + 1;
						lfbaw = true;
						iooiooie = iooiooie - lfb;
						iooiooid = iooiooid + lfb;
						if (lfbpa < 85)
						{
							//tena pirter attack
							TeraPirter.TeraPirterAttack();
						}
						iooiooia = true;
						travel();
							break;
						case 5:
						lfbpa = random.nextInt(100) + 1;
						lfbaw = true;
						iooiooie = iooiooie - lfb;
						iooiooid = iooiooid + lfb;
						if (lfbpa < 70)
						{
							//tena pirter attack
							TeraPirter.TeraPirterAttack();
						}
						iooiooia = true;
						travel();
							break;
						case 4:
						lfbpa = random.nextInt(100) + 1;
						lfbaw = true;
						iooiooie = iooiooie - lfb;
						iooiooid = iooiooid + lfb;
						if (lfbpa < 55)
						{
							//tena pirter attack
							TeraPirter.TeraPirterAttack();
						}
						iooiooia = true;
						travel();
							break;
						case 3:
						lfbpa = random.nextInt(100) + 1;
						lfbaw = true;
						iooiooie = iooiooie - lfb;
						iooiooid = iooiooid + lfb;
						if (lfbpa < 35)
						{
							//tena pirter attack
							TeraPirter.TeraPirterAttack();
						}
						iooiooia = true;
						travel();
							break;
						case 2:
						lfbpa = random.nextInt(100) + 1;
						lfbaw = true;
						iooiooie = iooiooie - lfb;
						iooiooid = iooiooid + lfb;
						if (lfbpa < 20)
						{
							//tena pirter attack
							TeraPirter.TeraPirterAttack();
						}
						iooiooia = true;
						travel();
							break;
						case 1:
						lfbpa = random.nextInt(100) + 1;
						lfbaw = true;
						iooiooie = iooiooie - lfb;
						iooiooid = iooiooid + lfb;
						if (lfbpa < 5)
						{
							//tena pirter attack
							TeraPirter.TeraPirterAttack();
						}
						iooiooia = true;
						travel();
							break;
						default:
							System.out.println("Ogie boggie buggie..");
						break;
					}
				}
			}
			//to wild
			else
			{
				if (themeSong != 1){
					themeSong = 1;
					if (clip.isRunning()) clip.stop();
					try{
						self.playMusic(1);
						url = (URL) self.getClass().getResource("sounds/sound_tracks/"+audio+".wav");
						input = AudioSystem.getAudioInputStream(url);
						info = new DataLine.Info(Clip.class, input.getFormat());
						clip = (Clip) AudioSystem.getLine(info);
						clip.open(input);
						clip.start();
						clip.loop(Clip.LOOP_CONTINUOUSLY);
					}
					catch (Exception e) {
					 System.out.println(e.toString());
					}
				}
				while (true)
				{

						// wild string
					String wi;
					String wit;

					Scanner wis = new Scanner(System.in);
					hud.callHud(/*int image*/0, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
					/*int food*/Integer.toString(fo),
					/*r 1*/"There is nothing here but grass.", /*r 2*/"what do you want to do?", /*r 3*/"", /*r 4*/"<rest>", /*r 5*/"<quest book>", /*r 6*/"<inventory>", /*r 7*/"<travel>", /*r 8*/ "",
					/*r 9*/"", /*r 10*/"", /*r 11*/"", /*r 12*/"", /*r 13*/"", /*r 14*/"", /*r 15*/"",
					/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");
					wi = scanner.nextLine();

					if (wi.equals ("inventory"))
					{
						Scanner fopos = new Scanner(System.in);
						hud.callHud(/*int image*/0, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
						/*int food*/Integer.toString(fo),
						/*r 1*/"gold: " + go, /*r 2*/"", /*r 3*/"you have " + fo + " food", /*r 4*/"you have " + totalPotions + " potion's", /*r 5*/"", /*r 6*/"what do you want to use", /*r 7*/"", /*r 8*/ "",
						/*r 9*/"press enter to continue", /*r 10*/"", /*r 11*/"", /*r 12*/"", /*r 13*/"", /*r 14*/"", /*r 15*/"",
						/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");
						fopo = scanner.nextLine();
						if (fopo.equals ("food"))
						{
							eatFood();
							continue;
						}
						else if (fopo.equals ("potion"))
						{
							break;
						}
						else if (fopo.equals ("nothing"))
						{
							break;
						}

					}
					if (wi.equals ("rest"))
					{
						// bandit attack
						Random rand = new Random();
						res = rand.nextInt(4);
						if (res == 1)
						{
							Random bandr = new Random();
							bandit();
							sn = sn + bandr.nextInt(100);
							if (sn > 25)
							{
								sn = 25;
							}
						}
						//pirter attack
						if (res == 2 && tv1 >= 442 && tv1 <= 600 && tvy1 <= 558)
						{
							Random pirr = new Random();
							pirter();
							sn = sn + pirr.nextInt(100);
							if (sn > 25)
							{
								sn = 25;
							}
						}
						else
						{
							//normal rest
							hud.callHud(/*int image*/0, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
							/*int food*/Integer.toString(fo),
							/*r 1*/"You rested back to full stamina", /*r 2*/"", /*r 3*/"", /*r 4*/" ", /*r 5*/"", /*r 6*/"", /*r 7*/"", /*r 8*/ "",
							/*r 9*/"Press enter to continue", /*r 10*/"", /*r 11*/"", /*r 12*/"", /*r 13*/"", /*r 14*/"", /*r 15*/"",
							/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");
							ec = scanner.nextLine();
							sn = 25;
						}

					}
					if (wi.equals ("quest book"))
					{
						System.out.println(questBook);
						System.out.println("press enter to continue");
						ec = scanner.nextLine();
					}
					if (wi.equals ("travel"))
					{
						travel();
						break;
					}
					if (wi.equals ("^"))
					{
						commandPrompt();
					}
				}
			}
		}
	}


public static void restart()
{
	//inventory
	po = 0;  //health potion
	fo = 0;  //food
	go = 0;	//gold
	fopo = null;//chooice between the two items
	res = 0; //resting
	//travel
	tv1 = 0; //travel1
	tv2 = 0; //travel2
	sn = 0;  //stamina
	 sl = 0;  //start location
	 el = 0;  //end location
	 l = 0;   //location....
	 slb = null;  //start first travel
	 slbt = null;  //start city
	 x = 0;   //x
	 y = 0;   //y
	 tvy1 = 0;//travel2
	 tvy2 = 0;//travel2
	//battle
	 hpPlayer = 20;
	 totalPotions = 0;
	 maxHp = 20;
	 heal = 7 + (int)Math.ceil(Math.random() * 10);

	//character creation
	 species = null;
	 username = null;
	 factionName = null;
	//Experience
	 expRec = 50;
	 exp = 0;
	 playerLvl = 1;
	//dungeon complete
	 Foetidus = false;
	//quest book
	 questBook = "this is your QuestBook: \n";
	//alchemist no name quest
	 iooiooi = false;// quest alchemist accepted
	 iooiooia = false; // quest alchemist grabbed item
	 iooiooib = false; // quest completed no Bandit
	 iooiooic = false; // quest completed bandits
	 iooiooid = 0; //amount of lilly's
	 iooiooie = 7; //max lilly's without bandits
	 iooiooif = 5; //max lilly's with bandits
	 iooiooig = false; //first leave went off
	 lfwbaw = false; //lilly field without bandits already went
	 lfbaw = false; // lilly field with bandits already went
}

public static void commandPrompt()
{
	String cps;
	cps = scanner.nextLine();
	if (cps.equals("stamina"))
	{
		sn = 9999;
	}
	if (cps.equals("exit"))
	{
		System.out.println("Shutting Down");
		System.exit(0);
	}
	if (cps.equals("reset"))
	{
		restart();
		String[] test = {};
		main(test);
	}
	if (cps.equals("gold"))
	{
		go = go + 1000;
	}
	if (cps.equals("bandit"))
	{
		bandit();
	}
	if (cps.equals("teraPirter"))
	{
		TeraPirter.TeraPirterAttack();
	}
	if (cps.equals("pickedFlowers"))
	{
		//completes the quest where you picked the black lilly's
		iooiooia = true;
	}
}

  	public static void travel()
	{
		if (themeSong != 1){
			themeSong = 1;
			if (clip.isRunning()) clip.stop();
			try{
				self.playMusic(1);
				url = (URL) self.getClass().getResource("sounds/sound_tracks/"+audio+".wav");
				input = AudioSystem.getAudioInputStream(url);
				info = new DataLine.Info(Clip.class, input.getFormat());
				clip = (Clip) AudioSystem.getLine(info);
				clip.open(input);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
			catch (Exception e) {
			 System.out.println(e.toString());
			}
		}
		while (true)
		{
			Scanner tva = new Scanner(System.in);


			hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
			Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
															Integer.toString(fo),
				"Where do you want to go?", "", "<x>", "<y>", "", "", "", "",
				"", "", "", "", "", "", "",
				"", "", "", "", "", "", "");
			tv1 = tva.nextInt();
			tvy1 = tva.nextInt();
			//making end location
			el = (tv1 + tv2);
			l = Math.sqrt((tv1-tv2)*(tv1-tv2) + (tvy1-tvy2)*(tvy1-tvy2));


    	if (l < 1)
			{
				sn = sn + l;
				if (sn < 0)
					{

						hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
							Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
															Integer.toString(fo),
															"You don't have enough stamina!", "", "", "", "", "", "", "",
															"", "", "", "", "", "", "",
															"", "", "", "", "", "", "");
						sn = sn - l;
						continue;
					}
				else
				{
				Scanner tva2 = new Scanner(System.in);
				tv2 = tv1;
				tvy2 = tvy1;
				break;
				}
			}
		else if(l > -1)
			{
				sn = sn - l;
				if (sn < 0)
				{
					hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
						Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
														Integer.toString(fo),
														"You don't have enough stamina!", "", "", "", "", "", "", "",
														"", "", "", "", "", "", "",
														"", "", "", "", "", "", "");
					sn = sn + l;
					continue;
				}
				else
				{
				Scanner tva22 = new Scanner(System.in);
				tv2 = tv1;
				tvy2 = tvy1;
					break;
				}
			}


		}
	}

	public static void eatFood()
	{
		if (fo > 0)
		{
			sn = sn + 5;
			fo = fo - 1;

			hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
			Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
															Integer.toString(fo),
															"You just ate some food you just gained 5 stamina.", "", "Your stamina now is " + sn,
															"", "You still have " + fo + " food", "",
															"", "", "",
															"", "", "", "", "", "",
															"", "", "", "", "", "", "");
		}
		else if (fo < 1)
		{
			hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
			Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
															Integer.toString(fo),
															"You don't have any food left", "", "", "", "", "", "", "",
															"", "", "", "", "", "", "",
															"", "", "", "", "", "", "");
		}
	}
	public static void tutorial()
	{
		if (themeSong != 1){
			themeSong = 1;
			if (clip.isRunning()) clip.stop();
			try{
				self.playMusic(1);
				url = (URL) self.getClass().getResource("sounds/sound_tracks/"+audio+".wav");
				input = AudioSystem.getAudioInputStream(url);
				info = new DataLine.Info(Clip.class, input.getFormat());
				clip = (Clip) AudioSystem.getLine(info);
				clip.open(input);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
			catch (Exception e) {
			 System.out.println(e.toString());
			}
		}
		hud.callHud(/*int image*/0, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
		/*int food*/Integer.toString(fo),
    /*r 1*/"What is your name?", /*r 2*/"", /*r 3*/"", /*r 4*/"", /*r 5*/"", /*r 6*/"", /*r 7*/"", /*r 8*/ "",
    /*r 9*/"", /*r 10*/"", /*r 11*/"", /*r 12*/"", /*r 13*/"", /*r 14*/"", /*r 15*/"",
    /*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");
		Scanner scanner = new Scanner(System.in);
		username = scanner.nextLine();
		hud.callHud(/*int image*/0, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
		/*int food*/Integer.toString(fo),
		/*r 1*/ /*r 2*/"Welcome " + username, /*r 3*/"What is your surname?", /*r 4*/"", /*r 5*/"", /*r 6*/"", /*r 7*/"", /*r 8*/ "",
		/*r 9*/"", /*r 10*/"", /*r 11*/"", /*r 12*/"", /*r 13*/"", /*r 14*/"", /*r 15*/"",
		/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"", "");
		factionName = scanner.nextLine();

		while (true)
		{
			hud.callHud(/*int image*/0, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
			/*int food*/Integer.toString(fo),
			/*r 1*//*r 2*/"Welcome " + username + " " + factionName + ".", /*r 3*/"", /*r 4*/"What kind of species are you?", /*r 5*/"", /*r 6*/"Human, Menekan, Forest Elf, Light Elf", /*r 7*/"Dark Elf, Surama", /*r 8*/ "",
			/*r 9*/"Choose your race by typing it out completely.", /*r 10*/"", "<human>", /*r 11*/"<menekan>", /*r 12*/"<forest elf>", /*r 13*/"<light elf>", /*r 14*/"<dark elf>", /*r 15*/"<suruma>",
			/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", "");
		species = scanner.nextLine();

		if (species.equals("human"))
		{
			//(tv1 == 199 && tvy1 == 100)
			sl = 299;
			tvy2 = 100;
			tv2 = 199;
			slb = "198 100";
			slbt = "199 100";
			break;
		}
		else if (species.equals("menekan")){
		break;
		}
		else if(species.equals("forest elf"))
		{
			sl = 1000;
			tvy2 = 458;
			tv2 = 541;
			slb = "541 458";
			slbt = "542 458";
			break;
		}
		else if(species.equals("light elf")){
		break;
		}
		else if(species.equals("dark elf")){
		break;
		}
		else if (species.equals("suruma")){
			//(tv1 == 566 && tvy1 == 890)
			sl = 1458;
			tvy2 = 890;
			tv2 = 568;
			slb = "566 890";
			slbt = "568 890";
		break;
		}
		else
		hud.callHud(/*int image*/0, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
		/*int food*/Integer.toString(fo),
		/*r 1*/"", /*r 2*/"", /*r 3*/"", /*r 4*/" ", /*r 5*/"", /*r 6*/"", /*r 7*/"", /*r 8*/ "",
		/*r 9*/"Press enter to continue", /*r 10*/"", /*r 11*/"", /*r 12*/"", /*r 13*/"", /*r 14*/"", /*r 15*/"",
		/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");
		ec = scanner.nextLine();
		continue;
		}


		hud.callHud(/*int image*/0, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
		/*int food*/Integer.toString(fo),
		/*r 1*/"Welcome " + username + " " + factionName + ".", /*r 2*/"", /*r 3*/"Greetings " + species, /*r 4*/"Welcome to the realm of Casamoth", /*r 5*/"", /*r 6*/"Do you want to follow the tutorial?", /*r 7*/"", /*r 8*/ "<y>",
		/*r 9*/"<n>", /*r 10*/"", /*r 11*/"", /*r 12*/"", /*r 13*/"", /*r 14*/"", /*r 15*/"",
		/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");
    String readyToContinue = scanner.nextLine();

    if (readyToContinue.equals("y"))
    {
			int totalPotions = 3;
			int hpDummyLvl1 = 20;
			hud.callHud(/*int image*/14, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
			/*int food*/Integer.toString(fo),
			/*r 1*/"Clever Chooice", /*r 2*/"^you gained a Rusty Sword and 3 Health Potions^", /*r 3*/"Now let's start with a dummy ", /*r 4*/"", /*r 5*/"You can attack by typing \"fight\"", /*r 6*/"And heal by typing \"potion\"", /*r 7*/"", /*r 8*/ "All options availible are shown as this: <option>",
			/*r 9*/"", /*r 10*/"A dummy(lvl 1) has engaged you!", /*r 11*/"", /*r 12*/"What will you do?", /*r 13*/"", /*r 14*/"<fight>", /*r 15*/"<potion>",
			/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");

    while (true){
		String choice = scanner.nextLine();
		int finalDamage;

    if (choice.equals("fight"))
    {
			finalDamage = DamageSystem.calculateWeaponDMG(0001001, 0, 0);
			hpDummyLvl1 = hpDummyLvl1 - finalDamage;
			sound.playSoundHit();
			hud.callHud(/*int image*/14, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
			/*int food*/Integer.toString(fo),
			/*r 1*/"You attacked the enemy.", /*r 2*/"", /*r 3*/"You did " + finalDamage + " damage.", /*r 4*/"The Dummy(lvl 1) has " + hpDummyLvl1 + " health remaining.", /*r 5*/"", /*r 6*/"", /*r 7*/"", /*r 8*/ "",
			/*r 9*/"press enter to continue", /*r 10*/"", /*r 11*/"", /*r 12*/"", /*r 13*/"", /*r 14*/"", /*r 15*/"",
			/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");
			ec = scanner.nextLine();

        }

    else if (choice.equals("potion"))
    {

    if (totalPotions == 0){

			hud.callHud(/*int image*/14, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
			/*int food*/Integer.toString(fo),
			/*r 1*/"You have no more potion's left!", /*r 2*/"", /*r 3*/"", /*r 4*/" ", /*r 5*/"", /*r 6*/"", /*r 7*/"", /*r 8*/ "",
			/*r 9*/"Press enter to continue", /*r 10*/"", /*r 11*/"", /*r 12*/"", /*r 13*/"", /*r 14*/"", /*r 15*/"",
			/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");
	    readyToContinue = scanner.nextLine();
    }

    else if (totalPotions > 0){

		Random rand = new Random();
		hpPlayer = hpPlayer + heal;
		totalPotions = totalPotions - 1;
		if (hpPlayer >= 21){
		hpPlayer = 20;
		System.out.println("You gained " + heal + " hp ");
					hud.callHud(/*int image*/14, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
					/*int food*/Integer.toString(fo),
					/*r 1*/"You used a potion and healed.", /*r 2*/"You have " + totalPotions + " remaining.", /*r 3*/"", /*r 4*/"You gained " + heal + " hp.", /*r 5*/"", /*r 6*/"", /*r 7*/"", /*r 8*/ "",
					/*r 9*/"Press enter to continue", /*r 10*/"", /*r 11*/"", /*r 12*/"", /*r 13*/"", /*r 14*/"", /*r 15*/"",
					/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");
			    readyToContinue = scanner.nextLine();
    }
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
			hud.callHud(/*int image*/14, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
			/*int food*/Integer.toString(fo),
			/*r 1*/"That is not an option!", /*r 2*/"", /*r 3*/"", /*r 4*/" ", /*r 5*/"", /*r 6*/"", /*r 7*/"", /*r 8*/ "",
			/*r 9*/"Press enter to continue", /*r 10*/"", /*r 11*/"", /*r 12*/"", /*r 13*/"", /*r 14*/"", /*r 15*/"",
			/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");
	    readyToContinue = scanner.nextLine();
    }




    if (hpDummyLvl1 < 1) {
		hpPlayer = 20;
		hud.callHud(/*int image*/0, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
		/*int food*/Integer.toString(fo),
		/*r 1*/"You deafeated the dummy.", /*r 2*/"", /*r 3*/"", /*r 4*/" ", /*r 5*/"", /*r 6*/"", /*r 7*/"", /*r 8*/ "",
		/*r 9*/"Press enter to continue", /*r 10*/"", /*r 11*/"", /*r 12*/"", /*r 13*/"", /*r 14*/"", /*r 15*/"",
		/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");
		readyToContinue = scanner.nextLine();
    break;
    }

    else if (hpPlayer < 1) {
			hud.callHud(/*int image*/14, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
			/*int food*/Integer.toString(fo),
			/*r 1*/"You where deafeated!!!", /*r 2*/"", /*r 3*/"GAME OVER!!!", /*r 4*/" ", /*r 5*/"", /*r 6*/"", /*r 7*/"", /*r 8*/ "",
			/*r 9*/"Press enter to continue", /*r 10*/"", /*r 11*/"", /*r 12*/"", /*r 13*/"", /*r 14*/"", /*r 15*/"",
			/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");
			readyToContinue = scanner.nextLine();
			restart();
			String[] test = {};
			main(test);
    }

    else

    enemyDamage = random.nextInt(2) + 0;

    hpPlayer = hpPlayer - enemyDamage;

		hud.callHud(/*int image*/14, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
		/*int food*/Integer.toString(fo),
		/*r 1*/"The Dummy(lvl 1) attacked you.", /*r 2*/"The Dummy(lvl 1) did " + enemyDamage + " damage.", /*r 3*/"", /*r 4*/" ", /*r 5*/"", /*r 6*/"", /*r 7*/"", /*r 8*/ "",
		/*r 9*/"What do you want to do?", /*r 10*/"", /*r 11*/"<fight>", /*r 12*/"<potion>", /*r 13*/"", /*r 14*/"", /*r 15*/"",
		/*r 16*/"", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");

    continue;
		}
    }
    else if (readyToContinue.equals ("n"))
    {
		totalPotions = totalPotions + 3;
    }
	}

  public static void tTutorial()
  {
		if (themeSong != 1){
			themeSong = 1;
			if (clip.isRunning()) clip.stop();
			try{
				self.playMusic(1);
				url = (URL) self.getClass().getResource("sounds/sound_tracks/"+audio+".wav");
				input = AudioSystem.getAudioInputStream(url);
				info = new DataLine.Info(Clip.class, input.getFormat());
				clip = (Clip) AudioSystem.getLine(info);
				clip.open(input);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
			catch (Exception e) {
			 System.out.println(e.toString());
			}
		}
		hud.callHud(/*int image*/0, /*int health*/(Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)), /*int stamina*/Double.toString(sn), /*string position*/("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)), /*int potions*/Integer.toString(totalPotions),
		/*int food*/Integer.toString(fo),
		/*r 1*/"Now I will teach you how to travel.", /*r 2*/"You will have to travel by typing coordinates.", /*r 3*/"You will have to type it with a space in between.", /*r 4*/"Like this: 111 111", /*r 5*/"But when you do that you will lose stamina.", /*r 6*/"You could regain that stamina by: ", /*r 7*/"", /*r 8*/ "1. resting",
		/*r 9*/"2. resting at the inn", /*r 10*/"3. eating", /*r 11*/"", /*r 12*/"Try going to the nearest city", /*r 13*/"type: travel to go to the travel menu", /*r 14*/"then type: " + slbt + " to travel to that location", /*r 15*/"",
		/*r 16*/"Press enter to continue", /*r 17*/"", /*r 18*/"", /*r 19*/"", /*r 20*/"", /*r 21*/"", /*r 22*/"");
		ec = scanner.nextLine();
  }


	//Bandit
  public static void bandit()
  {

    int bandit = 20;
    String choice;
    int bgo;
		boolean banditdead = false;
		Random rand = new Random();
		lvlBandit = rand.nextInt(3) + 1;
		bandit = bandit + (2 * lvlBandit);

		while (banditdead == false){
			Scanner scanner = new Scanner(System.in);
			hud.callHud(  12,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
			Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
			Integer.toString(fo),
			"A Bandit (lvl " + lvlBandit + ") has engaged you", "what will you do?", "", "<fight>", "<potion>", "", "", "",
			"", "", "", "", "", "", "",
			"", "", "", "", "", "", "");
			choice = scanner.nextLine();
			if (choice.equals("fight"))
			{
				int finalDamage = DamageSystem.calculateWeaponDMG(0001001, 0, 0);
				bandit = bandit - finalDamage;
				sound.playSoundHit();
				hud.callHud(  12,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
									Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
																	Integer.toString(fo),
																	"You attacked the enemy.", "", "You did " + finalDamage + " damage.", "", "The Bandit(lvl " + lvlBandit + ") has " + bandit + " health remaining", "", "", "",
																	"", "", "", "", "", "", "",
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
					ec = scanner.next();
				}
				else if (totalPotions > 0)
				{
					int heal = rand.nextInt(10) + 7;
					hpPlayer = hpPlayer + heal;
					totalPotions = totalPotions - 1;
					hud.callHud(  8,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
					Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
					Integer.toString(fo),
					"You used a potion and healed.", "", "You have " + totalPotions + " remaining.", "", "You gained " + heal + " hp", "", "", "",
					"", "", "", "", "", "", "",
					"", "", "", "", "", "", "");
					ec = scanner.next();
				}
				//maxhealth
				if (hpPlayer >= maxHp){
					hpPlayer = hpPlayer - hpPlayer + maxHp;
					hud.callHud(  8,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
					Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
					Integer.toString(fo),
					"You now have " + hpPlayer + " health.", "", "", "", "", "", "", "",
					"", "", "", "", "", "", "",
					"", "", "", "", "", "", "");
					ec = scanner.next();
				}
				else {
					hud.callHud(  8,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
					Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
					Integer.toString(fo),
					"You now have " + hpPlayer + " health.", "", "", "", "", "", "", "",
					"", "", "", "", "", "", "",
					"", "", "", "", "", "", "");
					ec = scanner.next();
				}
			}
			//debug exit v
			else if (choice.equals("/exit"))
			{
				System.out.println("Shutting Down");
				ec = scanner.next();
				System.exit(0);
			}
			//debug exit ^
			else
			{
				hud.callHud(  12,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
				Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
				Integer.toString(fo),
				"That is not an option!", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "",
				"", "", "", "", "", "", "");
				ec = scanner.next();
			}
			//defeated enemy
			if (bandit < 1) {
				Random bgor = new Random();
				bgo = bgor.nextInt(12) + 0; //get gold
				go = go + bgo;
				banditdead = true;
				if (bgo == 0)
				{
					hud.callHud(  12,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
					Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
					Integer.toString(fo),
					"You have defeated the Bandit(lvl " + lvlBandit + ")", "", "The Bandit didn't have any gold on him.", "", "", "", "", "",
					"", "", "", "", "", "", "",
					"", "", "", "", "", "", "");
					ec = scanner.next();
	 			}
			else
			{
				banditdead = true;
				hud.callHud(  12,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
				Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
				Integer.toString(fo),
				"You have defeated the Bandit(lvl " + lvlBandit + ")", "The Bandit had some gold on him.", "", "You obtained " + bgo + " gold.", "", "", "", "",
				"", "", "", "", "", "", "",
				"", "", "", "", "", "", "");
				ec = scanner.next();
			}
			Random experience = new Random();
			double expRand = experience.nextInt(12) + 7;
			exp = exp + expRand;
			hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
			Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
			Integer.toString(fo),
			"You gained " + expRand, "", "You now have " + exp + " out of " + expRec + " Experience", "", "", "", "", "",
			"", "", "", "", "", "", "",
			"", "", "", "", "", "", "");
			ec = scanner.next();
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
				"You leveled up to Level " + playerLvl, "", "Your Max Health increased by 2Hp.", "", "", "", "", "",
				"", "", "", "", "", "", "",
				"", "", "", "", "", "", "");
				ec = scanner.next();
			}
			break;
		}
		//enemy attack
		else
		{
			int enemyDamage = rand.nextInt(4) + 0;
			hud.callHud(  12,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
			Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
			Integer.toString(fo),
			"The Bandit(lvl " + lvlBandit + ") attacked you. ", "", "The bandit(lvl " + lvlBandit + ") did " + enemyDamage + " damage.", "", "", "", "", "",
			"", "You have " + hpPlayer + " health remaining", "", "", "", "", "",
			"", "", "", "", "", "", "");
			hpPlayer = hpPlayer - enemyDamage;
			ec = scanner.nextLine();

			//game over
			if (hpPlayer < 1)
			{
				hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
				Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
				Integer.toString(fo),
				"You have " + hpPlayer + " health remaining.", "", "You are defeated, GAME OVER!!!", "", "", "", "", "",
				"", "", "", "", "", "", "",
				"", "", "", "", "", "", "");
				ec = scanner.next();
				restart();
				String[] test = {};
				main(test);
				}
			}
  	}
  }




//Pirter
public static void pirter()
{

  int pirter = 15;
  String choice;

Random rand = new Random();
lvlPirter = rand.nextInt(3) + 1;
{
	if (species.equals("forest elf"))
	{

		hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
									Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
																	Integer.toString(fo),
																	"A Pirter (lvl " + lvlPirter + ") has engaged you", "", "The Pirter (lvl " + lvlPirter + " noticed you're a", "Forest Elf and ran away)", "", "", "", "",
																	"", "", "", "", "", "", "",
																	"", "", "", "", "", "", "");
	}

else{

while (true){
	hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
								Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
																Integer.toString(fo),
																"A Pirter (lvl " + lvlPirter + ") has engaged you", "", "What will you do?", "", "<fight>", "<potion>", "", "",
																"", "", "", "", "", "", "",
																"", "", "", "", "", "", "");
	choice = scanner.nextLine();


if (choice.equals("fight"))
{
		int finalDamage = DamageSystem.calculateWeaponDMG(0001001, 0, 0);
		pirter = pirter - finalDamage;
		sound.playSoundHit();
		hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
									Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
																	Integer.toString(fo),
																	"You attacked the enemy.", "", "You did " + finalDamage + " damage.", "", "The Pirter(lvl " + lvlPirter + ") has " + pirter + " health remaining.", "", "", "",
																	"", "", "", "", "", "", "",
																	"", "", "", "", "", "", "");
  }
//potions to heal
else if (choice.equals("potion"))
{
if (totalPotions == 0){
	hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
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
if (hpPlayer >= 21){
hpPlayer = hpPlayer - hpPlayer + 20;
}
else {
}
hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
							Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
															Integer.toString(fo),
															"You used a potion and healed.", "", "You have " + totalPotions + " remaining.", "", "You gained " + heal + " hp.", "", "You now have " + hpPlayer + " health", "",
															"", "", "", "", "", "", "",
															"", "", "", "", "", "", "");
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
																"", "", "", "", "", "", "",
																"", "", "", "", "", "", "");
}

//defeated enemy
if (pirter < 1) {
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
														"You have defeated the Pirter lvl " + lvlPirter, "", "You gained " + expRand, "", "You now have " + exp + " out of " + expRec + " Experience.", "", "You leveled up to Level " + playerLvl, "",
														"Your Max Health increased by 2Hp.", "", "", "", "", "", "",
														"", "", "", "", "", "", "");
}
else {
		hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
								Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
																Integer.toString(fo),
																"You have defeated the Pirter lvl " + lvlPirter, "", "You gained " + expRand, "", "You now have " + exp + " out of " + expRec + " Experience.", "", "", "",
																"", "", "", "", "", "", "",
																"", "", "", "", "", "", "");
}
break;
}

//enemy attack
else
{
	int enemyDamage = rand.nextInt(4) + 0;
	hpPlayer = hpPlayer - enemyDamage;

	System.out.println(" " );
  System.out.println(" ");

  //game over
  if (hpPlayer < 1) {
		hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
									Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
																	Integer.toString(fo),
																	"The Pirter(lvl " + lvlPirter + ") attacked you.", "", "The Pirter(lvl " + lvlPirter + ") did " + enemyDamage + " damage.", "", "You have " + hpPlayer + " health remaining.", "", "You are defeated, GAME OVER!!!", "",
																	"", "", "", "", "", "", "",
																	"", "", "", "", "", "", "");
																	restart();
																	String[] test = {};
																	main(test);
  }
  else{

		hud.callHud(  0,   (Integer.toString(hpPlayer) + "/" + Integer.toString(maxHp)),
									Double.toString(sn),   ("x: " + Double.toString(tv2) + "y: " + Double.toString(tvy2)),   Integer.toString(totalPotions),
																	Integer.toString(fo),
																	"The Pirter(lvl " + lvlPirter + ") attacked you.", "", "The Pirter(lvl " + lvlPirter + ") did " + enemyDamage + " damage.", "", "You have " + hpPlayer + " health remaining.", "", "", "",
																	"", "", "", "", "", "", "",
																	"", "", "", "", "", "", "");
  			}
  		}
  	continue;
		}
		}
  }
 }

 public static void playMusic(int song){
	 if (song == 1){
		 audio = "MainTheme_001";
		 themeSong = 1;
	 }
	 else if (song == 2){
		 audio = "Dungeon_001";
		 themeSong = 2;
	 }
	 else if (song == 3){
		 audio = "AlchemistTheme_001";
		 themeSong = 3;
	 }
 }

}

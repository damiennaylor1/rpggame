import java.util.Scanner;
public class rpgGame {
    Scanner scan = new Scanner(System.in);
    String[] itemIndex = {"Wooden Sword","Iron Sword","Steel Sword","Gold Sword","Titanium Sword","Health Potion","Super Potion","Viper Potion","Flashbang","Poison Ink","","","",""};
    int[] goldIndex = {5,20,50,100,300,5,15,40,30,40,0,0,0,0};
    String[][] smithInv = new String[5][2]; String[][] shopInv = new String[5][2];
    int gold = 10; int smithclosed = 0; int shopclosed = 0; int innclosed = 0; int guildclosed = 0;
    int hp = 15; int maxhp = 15; int attackstat = 2; int defencestat = 2; int speedstat = 2; int hpstat = 2; int level = 0; int xp = 0;
    String[][] questsboard = new String[8][3];
    String encrypt = "ypxzkds$#@";
    String[] board = {"1: Clear the Beginners Dungeon","F: Hunt Monsters in the Green Zone","F: ???"};
    int[][] questIndex = new int[30][2];
    Boolean innpaid = false;
    int guildrank = 0; int guildexp = 0; // NOTREGISTERED, F, D, C, B, A, S (ranks)
    int[] inventory = new int[30];
    public void setQuests() {
        questIndex[0][0] = 30; questIndex[0][1] = 25; questIndex[1][0] = 20; questIndex[1][1] = 40;
        questIndex[2][0] = 10; questIndex[2][0] = 10;
    }
    public int addToInventory(int item) {
        inventory[item]++;
        return item;
    }
    public void scramble() {
        for (int i=0;i<5;i++) {
            smithInv[i][0] = itemIndex[i];
            smithInv[i][1] = goldIndex[i]+"";
            shopInv[i][0] = itemIndex[i+5];
            shopInv[i][1] = goldIndex[i+5]+"";
            
        }
        
    }
    public void a() {
        scan.nextLine();
    }
    public void main() {
        scramble();
        setQuests();
        System.out.println("Welcome to RPG game!"); a();
        System.out.println("Press enter to start the game."); a();
        int x=0; while (x==0) {
            System.out.println("Where would you like to go?");
            System.out.println("(Blacksmith, Marreds (shop), Inn, Guild)");
            String answer = scan.nextLine().toLowerCase();
            if (answer.equals("blacksmith") || answer.equals("black smith")) {
                if (smithclosed == 0) {
                    System.out.println("\"Welcome to my shop, 'lad. Need you some tools?\"");
                    String yesno = scan.nextLine().toLowerCase();
                    if (yesno.equals("yes") || yesno.equals("y")) {
                        //
                        int done=0;Boolean bought=false;while(done==0){
                            if (bought == true) {
                                System.out.println("(Continue shopping?)");
                                String next = scan.nextLine().toLowerCase();
                                if (next.equals("yes") || next.equals("y")) {} else {
                                    System.out.println("You exit the blacksmith's shop.");
                                    done=1;break;
                                }
                            }
                            for (int i=0;i<5;i++) {
                                System.out.print(smithInv[i][0]+" - "+smithInv[i][1]+" gold. ");
                            }
                            System.out.println("\n\"Want any of my stock?\" (Use integer, enter 0 to exit)");
                            int whichItem = scan.nextInt();
                            if (whichItem > 0 && whichItem < 6) {
                                if (gold >= Integer.parseInt(smithInv[whichItem-1][1])) {
                                    System.out.println("(Are you sure?)"); a();
                                    String yeahea = scan.nextLine().toLowerCase();
                                    if (yeahea.equals("yes")) {
                                        gold -= Integer.parseInt(smithInv[whichItem-1][1]);
                                        for (int i=0;i<10;i++) {
                                            if (smithInv[whichItem-1][0].equals(itemIndex[i])) {
                                                addToInventory(i);
                                                System.out.println(itemIndex[i]+" has been bought.");
                                                i=10;
                                                bought = true;
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("\"Not enough gold for that one, sonny.\""); a();
                                }
                            } else {
                                if (whichItem==0) {
                                    bought = true; a();
                                } else {
                                    System.out.println("\"I don't have that item, young'n.\""); a();
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("It appears the blacksmith is not here..."); a();
                }
            } else if (answer.equals("marreds") || answer.equals("shop")) {
                if (shopclosed == 0) {
                    System.out.println("\"Welcome to the shop. Like what you see?\"");
                    String likewhat = scan.nextLine().toLowerCase();
                    if (likewhat.equals("yes") || likewhat.equals("y")) {
                        //
                        int done=0;Boolean bought=false;while(done==0){
                            if (bought == true) {
                                System.out.println("(Continue shopping?)");
                                String next = scan.nextLine().toLowerCase();
                                if (next.equals("yes") || next.equals("y")) {} else {
                                    System.out.println("You exit Marred's shop.");
                                    done=1;break;
                                }
                            }
                            for (int i=0;i<5;i++) {
                                System.out.print(shopInv[i][0]+" - "+shopInv[i][1]+" gold. ");
                            }
                            System.out.println("\n\"Want my goods?\" (Use integer, enter 0 to exit)");
                            int whichItem = scan.nextInt();
                            if (whichItem > 0 && whichItem < 6) {
                                if (gold >= Integer.parseInt(shopInv[whichItem-1][1])) {
                                    System.out.println("(Are you sure?)"); a();
                                    String yeahea = scan.nextLine().toLowerCase();
                                    if (yeahea.equals("yes")) {
                                        gold -= Integer.parseInt(shopInv[whichItem-1][1]);
                                        for (int i=0;i<10;i++) {
                                            if (shopInv[whichItem-1][0].equals(itemIndex[i])) {
                                                addToInventory(i);
                                                System.out.println(itemIndex[i]+" has been bought.");
                                                i=10;
                                                bought = true;
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("\"I run a buisness here, not a charity.\""); a();
                                }
                            } else {
                                if (whichItem==0) {
                                    bought = true; a();
                                } else {
                                    System.out.println("\"Don't have that one in stock.\""); a();
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("Marred isn't here today...");
                }
            } else if (answer.equals("print")) {
                for (int i=0;i<30;i++) {
                    System.out.print(inventory[i]);
                }
            } else if (answer.equals("inn") || answer.equals("hotel") || answer.equals("home")) {
                if (innclosed == 0) {
                    if (innpaid == false) {
                        System.out.println("\"Welcome to the inn. For 5 gold you can sleep a night and fully recover all HP.\"");
                        System.out.println("(Would you like to sleep here? You have "+gold+" gold.)");
                        String rest = scan.nextLine().toLowerCase();
                        if (rest.equals("yes")) {
                            if (gold >= 5) {
                                gold -= 5;
                                System.out.println("You enter your room and sleep on the bed."); a();
                                System.out.println("(All health was recovered.)"); a();
                                hp = maxhp;
                                System.out.println("(...)"); a();
                                System.out.println("You wake up to the sound of the church bells striking 8 o'clock."); a();
                                System.out.println("\"Thank you for your patronage. We hope to see you again!\""); a();
                            } else {
                                System.out.println("\"We're sorry to inform you, but you do not have enough gold. We cannot offer our beds at this time.\""); a();
                            }
                        } else {
                            System.out.println("\"Please come again.\""); a();
                        }
                    } else {
                        System.out.println("\"Oh, welcome, adventurer. The guild has already paid for your room, so please feel free to sleep for the night.\""); a();
                        System.out.println("You walk towards your room, which is close by the entrance."); a();
                        System.out.println("You enter your room and sleep on the bed."); a();
                        System.out.println("(All health was recovered.)"); a();
                        hp = maxhp;
                        System.out.println("(...)"); a();
                        System.out.println("You wake up to the sound of the church bells striking 8 o'clock."); a();
                        System.out.println("\"Thank you for your patronage. We hope to see you again!\""); a();
                        innpaid = false;
                    }
                }
            } else if (answer.equals("guild")) {
                if (guildclosed == 0) {
                    if (innpaid == false) {
                        System.out.println("\"Welcome to the guild.\""); a();
                        if (guildrank == 0) {
                            System.out.println("\"It does not appear that you are registered.\""); a();
                            System.out.println("\"Would you like to register to the guild?\"");
                            String register = scan.nextLine().toLowerCase();
                            if (register.equals("yes")) {
                                System.out.println("\"You don't have gold to register yet, but it is fine. \""); a();
                                System.out.println("\"Our guild will sponsor you, however you must pay back a fee of 30 gold if you wish to achieve rank C.\""); a();
                                System.out.println("\"Do you wish to register knowing this?\"");
                                String register2 = scan.nextLine().toLowerCase();
                                if (register2.equals("yes")) {
                                    System.out.println("(You are now registered to the guild!)"); a();
                                    System.out.println("\"It is fine if you want to relax a little, but please do take quests frequently. We are in dire need of heroes.\""); a();
                                    System.out.println("\"However, there are no quests today. We will pay your inn fee, so please come back tomorrow for fresh quests.\""); a();
                                    innpaid = true;
                                    guildrank = 1;
                                }
                            }
                        } else {
                            System.out.println("\"We have the following quests available:\"");
                            /*for (int i=0;i<quests;i++) {
                                System.out.println("["+i+"] "+questsonboard[i]);
                            }*/
                        }
                    } else {
                        System.out.println("\"Sorry, but like we said, there are no quests today. Please head towards the inn.\""); a();
                    }
                }
            } else if (answer.equals("save") || answer.equals("savedata")) {
                String savedata = gold+"/"+smithclosed+shopclosed+innclosed+guildclosed+hp+"/"+maxhp+"/"+attackstat+"/"+defencestat+"/"+speedstat+"/"+hpstat+"/"+level+"/"+xp+"/"+guildrank+"/"+guildexp+"/";
                for (int i=0;i<30;i++) {
                    savedata += inventory[i]+"";
                }
                String encrypteddata = "";
                for (int i=0;i<savedata.length();i++) {
                    if (savedata.charAt(i) == '/') {
                        encrypteddata += savedata.charAt(i);
                    } else if (savedata.charAt(i) == '0') {
                        char bla = 'a';
                        switch((int)Math.floor(Math.random()*6)+1) {
                            case 1:
                                bla = '%';
                                break;
                            case 2:
                                bla = 'v';
                                break;
                            case 3:
                                bla = '!';
                                break;
                            case 4:
                                bla = 'f';
                                break;
                            case 5:
                                bla = '#';
                                break;
                            case 6:
                                bla = '@';
                                break;
                        }
                        encrypteddata += bla;
                    } else if (savedata.charAt(i) == '1') {
                        char bla = 'a';
                        switch((int)Math.floor(Math.random()*2)+1) {
                            case 1:
                                bla = 'r';
                                break;
                            case 2:
                                bla = 'j';
                                break;
                            case 3: 
                                bla = 'm';
                        }
                        encrypteddata += bla;
                    } else if (savedata.charAt(i) == '2') {
                        char bla = 'a';
                        switch((int)Math.floor(Math.random()*2)+1) {
                            case 1:
                                bla = 'u';
                                break;
                            case 2:
                                bla = 'w';
                                break;
                            case 3:
                                bla = 'g';
                                break;
                        }
                        encrypteddata += bla;
                    } else {
                        //System.out.print(Integer.valueOf(savedata.charAt(i)+"")+" ");
                        encrypteddata += encrypt.charAt(Integer.valueOf(savedata.charAt(i)+""));
                    }
                }
                //System.out.println(savedata);
                System.out.println(encrypteddata);
                System.out.println("Use this string to load your data.");
            } else if (answer.equals("load") || answer.equals("loaddata")) {
                System.out.println("Please paste your load string.");
                String unencryptthis = scan.nextLine();
                String unencrypted = "";
                for (int i=0;i<unencryptthis.length();i++) {
                    char b = unencryptthis.charAt(i);
                    if (b == '/') {
                        unencrypted += b;
                    } else if (b == '%' || b == 'v' || b == '!' || b == 'f' || b == 'z' || b == '#' || b == '@') {
                       unencrypted += "0"; 
                    } else if (b == 'r' || b == 'j' || b == 'm') {
                       unencrypted += "1";
                    } else if (b == 'u' || b == 'w' || b == 'g') {
                       unencrypted += "2";
                    }
                    else {
                        unencrypted += encrypt.indexOf(b+"");
                    }
                }
                int index = unencrypted.indexOf("/");
                int gold = Integer.parseInt(unencrypted.substring(0,index));
                unencrypted = unencrypted.substring(index+1);
                smithclosed = Integer.parseInt(unencrypted.charAt(0)+"");
                shopclosed = Integer.parseInt(unencrypted.charAt(1)+"");
                innclosed = Integer.parseInt(unencrypted.charAt(2)+"");
                guildclosed = Integer.parseInt(unencrypted.charAt(3)+"");
                index = unencrypted.indexOf("/");
                hp = Integer.parseInt(unencrypted.substring(4,index));
                unencrypted = unencrypted.substring(index+1);
                index = unencrypted.indexOf("/");
                maxhp = Integer.parseInt(unencrypted.substring(0,index));
                unencrypted = unencrypted.substring(index+1);
                index = unencrypted.indexOf("/");
                attackstat = Integer.parseInt(unencrypted.substring(0,index));
                unencrypted = unencrypted.substring(index+1);
                index = unencrypted.indexOf("/");
                defencestat = Integer.parseInt(unencrypted.substring(0,index));
                unencrypted = unencrypted.substring(index+1);
                index = unencrypted.indexOf("/");
                speedstat = Integer.parseInt(unencrypted.substring(0,index));
                unencrypted = unencrypted.substring(index+1);
                index = unencrypted.indexOf("/");
                hpstat = Integer.parseInt(unencrypted.substring(0,index));
                unencrypted = unencrypted.substring(index+1);
                index = unencrypted.indexOf("/");
                level = Integer.parseInt(unencrypted.substring(0,index));
                unencrypted = unencrypted.substring(index+1);
                index = unencrypted.indexOf("/");
                xp = Integer.parseInt(unencrypted.substring(0,index));
                unencrypted = unencrypted.substring(index+1);
                index = unencrypted.indexOf("/");
                guildrank = Integer.parseInt(unencrypted.substring(0,index));
                unencrypted = unencrypted.substring(index+1);
                index = unencrypted.indexOf("/");
                guildexp = Integer.parseInt(unencrypted.substring(0,index));
                unencrypted = unencrypted.substring(index+1);
                /*for (int i=0;i<unencrypted.length();i++) {
                    inventory[i] = Integer.parseInt(unencrypted.charAt(i)+"");
                    System.out.println(inventory[i]);
                }
                System.out.println(unencrypted);*/
                
            } else if (answer.equals("set")) {
            	System.out.println("which");
            	String which = scan.nextLine();
            	if (which.equals("hp")) {
            		System.out.println("set to what");
            		hp = scan.nextInt();
            	}
            	if (which.equals("maxhp")) {
            		System.out.println("set to what");
            		maxhp = scan.nextInt();
            	}
            	if (which.equals("attack")) {
            		System.out.println("set to what");
            		attackstat = scan.nextInt();
            	}
            	if (which.equals("gold")) {
            		System.out.println("set to what");
            		gold = scan.nextInt();
            	}
            }
        }
    }
}

import java.util.Scanner;
public class rpgGame {
    Scanner scan = new Scanner(System.in);
    String[] itemIndex = {"Wooden Sword","Iron Sword","Steel Sword","Gold Sword","Titanium Sword","Health Potion","Super Potion","Viper Potion","Flashbang","Poison Ink","Low-Tier Crafting Materals","Mid-Tier Crafting Materials","High-Tier Crafting Materials",""};
    int[] goldIndex = {5,20,50,100,300,5,15,40,30,40,0,0,0,0};
    String[][] smithInv = new String[5][2]; String[][] shopInv = new String[5][2];
    int gold = 10; int smithclosed = 0; int shopclosed = 0; int innclosed = 0; int guildclosed = 0; int craftclosed = 0; int arrested = 0;
    int hp = 15; int maxhp = 15; int attackstat = 2; int defencestat = 2; int speedstat = 2; int level = 0; int xp = 0; int authority = 0;
    String[][] questsboard = new String[8][3];
    int [][] activeQuest = new int[1][2]; int x=0; int[] guildxpreqs = {0,0,100,200,400,800,2000}; String[] guildranks = {"NOTREGISTERED","F","D","C","B","A","S"};
    String encrypt = "ypxzkds$#@";
    String[] board = {"F: Clear the Beginners Dungeon","F: Hunt Monsters in the Green Zone","F: Free EXP!"};
    String[] monsternames = {"Zombie","Goblin","Skeleton"};
    String[] recipes = {"Wooden Sword + ","Wooden Sword + Titantium Sword","Super Potion + Health Potion + Viper Potion","Flashbang + Poison Ink","Mid-Tier Crafting Materials + Low-Tier Crafting Materials"};
    String[] reciperesults = {"Useless Item"};
    int[][] questIndex = new int[30][2];
    Boolean innpaid = false;
    int guildrank = 0; int guildexp = 0; // NOTREGISTERED, F, D, C, B, A, S (ranks)
    int[] inventory = new int[30];
    public void setQuests() {
        questIndex[0][0] = 30; questIndex[0][1] = 25; questIndex[1][0] = 20; questIndex[1][1] = 40;
        questIndex[2][0] = 0; questIndex[2][1] = 50;

        questsboard[0][0] = board[0]; questsboard[0][1] = questIndex[0][0]+""; questsboard[0][2] = questIndex[0][1]+"";
        questsboard[1][0] = board[1]; questsboard[1][1] = questIndex[1][0]+""; questsboard[1][2] = questIndex[1][1]+"";
        questsboard[2][0] = board[1]; questsboard[2][1] = questIndex[2][0]+""; questsboard[2][2] = questIndex[2][1]+"";
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
        while (x==0) {
            System.out.println("Where would you like to go?");
            System.out.println("(Blacksmith, Marreds (shop), Inn, Guild, Quest)");
            String answer = scan.nextLine().toLowerCase();
            if (answer.equals("blacksmith") || answer.equals("black smith")) {
                if (smithclosed == 0) {
                    System.out.println("\"Welcome to my shop, 'lad. Need you some tools?\"");
                    int gothrough = 0;  while (gothrough == 0) {
                        System.out.print("");
                        String yesno = scan.nextLine().toLowerCase();
                        if (yesno.equals("yes") || yesno.equals("y")) {
                            gothrough = 1;
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
                        } else if (yesno.equals("no") || yesno.equals("n")) {
                            gothrough = 1;
                            System.out.println("You exit the blacksmith's shop.");
                        }
                    }
                } else {
                    System.out.println("It appears the blacksmith is not here..."); a();
                }
            } else if (answer.equals("marreds") || answer.equals("shop")) {
                if (shopclosed == 0) {
                    System.out.println("\"Welcome to the shop. Like what you see?\"");
                    int gothrough = 0;  while (gothrough == 0) {
                        System.out.print("");
                        String likewhat = scan.nextLine().toLowerCase();
                        if (likewhat.equals("yes") || likewhat.equals("y")) {
                            gothrough=1;
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
                        } else if (likewhat.equals("no") || likewhat.equals("n")) {
                            gothrough=1;
                            System.out.println("You exit Marred's shop.");
                        }
                    }
                } else {
                    System.out.println("Marred isn't here today...");
                }
            } else if (answer.equals("print")) {
                for (int i=0;i<30;i++) {
                    System.out.print(inventory[i]);
                }
            } else if (answer.equals("craft") || answer.equals("crafts") || answer.equals("craftsman")) {
                if (craftclosed == 0) {
                    if (arrested == 0) {
                        System.out.println("\"Welcome to the crafting library. \""); a();
                    } else {
                        System.out.println("You enter the crafting library."); a();
                    }
                    if (guildrank == 4 && authority == 0) {
                        System.out.println("\"Good thing you came in. There's been some rumors about a legendary demonic sword recently.\""); a();
                        authority = 1;
                    }
                    if (guildrank == 6 && authority == 1) {
                        System.out.println("\"Come over here for a second.\""); a();
                        System.out.println("(The craftsman hands you a blank scrap of paper.)"); a();
                        System.out.println("You can clearly tell the paper has lasted for hundred of years, but looks recently torn."); a();
                        System.out.println("\"My buddy's been dungeon hunting for months trying to find clues as to the legendary demonic sword.\""); a();
                        System.out.println("(He gestures towards the scrap of paper in your hand.)"); a();
                        System.out.println("\"If you put some demonic energy into it, then...\""); a();
                        System.out.println("The paper's writings begin to show."); a();
                        System.out.println("(...)");
                        System.out.println("Just as the paper was going to finish, the door is barged open."); a();
                        System.out.println("It is the town guards."); a();
                        System.out.println("\"Samael, come out with your hands up.\""); a();
                        System.out.println("\"You are under arrest for demon research and suspected communication with demons.\"");
                        System.out.println("The craftsman walks out with his hands up, but as he passes you, you can clearly see the paper dangling from his pocket."); a();
                        System.out.println("In the cover of his silhouette, you take the paper before he exits the door."); a();
                        System.out.println("While he is loaded onto the cart, he smiles and winks at you."); a();
                        System.out.println("Once the guards have made their way down the street, you hold out the paper and feed it demonic energy."); a();
                        System.out.println("It reads:\nBlade of Odysseus + Blade of Abaddon + Demonic CROWN = Adrammelech"); a();
                        authority = 2;
                    }
                    System.out.println("(Would you like to see the recipes?)");
                    String recipequestion = scan.nextLine();
                    if (recipequestion.equals("yes") || recipequestion.equals("y")) {
                        
                        System.out.println("Mythical Dagger + Poison Ink + Mid Tier Materials (x2) = Samael's Dagger");
                        System.out.println("Titanium Sword + High Tier Materials (x2) + Angelic Essence = Blade of Odysseus");
                        System.out.println("Titanium Sword + High Tier Materials (x2) + Demonic Essence = Blade of Abaddon");
                        if (authority == 1) {
                            System.out.println("Blade of Odysseus + Blade of Abaddon + ??? = ???");
                        } else if (authority == 2) {
                            System.out.println("Blade of Odysseus + Blade of Abaddon + Demonic Crown = Adrammelech");
                        }
                    }
                    System.out.println("Your inventory: \n");
                    for (int i=0;i<30;i++) {
                        if (inventory[i] > 0) {
                            System.out.print(itemIndex[i]+" ");
                            if (inventory[i] > 1) {
                                System.out.print("(x"+inventory[i]+") ");
                            }
                        }
                    }
                    int length = 0; String total = "";
                    for (int i=0;i<3;i++) {
                        System.out.println("Enter string of item, type \"exit\" to exit.");
                        String getItem = scan.nextLine();
                        Boolean theIndex = false;
                        if (!getItem.equals("exit")) {
                            for (int i2=0;i2<itemIndex.length;i2++) {
                                if (itemIndex[i2].equals(getItem)) {
                                    theIndex = true;    
                                }
                            }
                            if (theIndex == true) {
                                total += getItem + "/";
                                length++;
                                //if (i!=2) {
                                    //total += "/";
                                //}
                            } else {
                                i--;
                            }
                        } else {
                            if (length > 0) {
                                total = total.substring(0, total.length() - 1);
                                System.out.println(total);
                            }
                            i=2;
                        }
                        System.out.println(length);
                    }
                    // String backuptotal = total;
                    int[] storage = new int[5]; int storageIndex = 0;
                    if (length > 1) {
                        for (int i2=0;i2<length;i2++) {
                            int slashIndex = total.indexOf("/");
                            String sub = total.substring(0,slashIndex);
                            if (i2 == 0) {
                                System.out.println(recipes.length);
                                for (int i=0;i<recipes.length;i++) {
                                    if (recipes[i].indexOf(sub) > -1) {
                                        storage[storageIndex] = i; /// work this
                                        storageIndex++;
                                    }
                                }
                            } else {
                                for (int i=0;i<storage.length;i++) {
                                    if (storage[i] != -2) {
                                        if (recipes[storage[i]].indexOf(sub) == -1) {
                                            storage[i] = 0;
                                            for (int i3 = i;i3<storageIndex;i3++) {
                                                storage[i3] = -2;
                                            }
                                            i--;
                                            storageIndex--;
                                        }
                                    }
                                } 
                            }
                        }
                        int remainingrecipe = -1;
                        for (int i=0;i<5;i++) {
                            if (storage[i] != -2) {
                                remainingrecipe = i;
                                i = 4;
                            }
                        }
                        if (remainingrecipe != -1) {
                            System.out.println("The recipe: ("+recipes[remainingrecipe]+" = "+reciperesults[remainingrecipe]+") is available.");
                        }
                    }
                } else {
                    System.out.println("(They just got arrested, of course the shop would still be closed...)");
                }
            } else if (answer.equals("inn") || answer.equals("hotel") || answer.equals("home")) {
                if (innclosed == 0) {
                    if (innpaid == false) {
                        System.out.println("\"Welcome to the inn. For 5 gold you can sleep a night and fully recover all HP.\"");
                        System.out.println("(Would you like to sleep here? You have "+gold+" gold.)");
                        int gothrough = 0;  while (gothrough == 0) {
                            System.out.print("");
                            String rest = scan.nextLine().toLowerCase();
                            if (rest.equals("yes")) {
                                gothrough=1;
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
                            } else if (rest.equals("no") || rest.equals("n")) {
                                gothrough = 0;
                                System.out.println("\"Please come again.\""); a();
                            }
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
            } else if (answer.equals("inventory")) {
                System.out.println("Enter index #:");
                int getIndex = scan.nextInt();
                inventory[getIndex]++;
                a();
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
                            if (activeQuest[0][0] == 0) {
                                if (guildexp >= guildxpreqs[guildrank]) {
                                    System.out.println("\"You are eligible for a guild promotion!\""); a();
                                    if (guildrank == 2) {
                                        System.out.println("\"However, per our argeement, you must pay the 30 gold.\""); a();
                                        if (gold>=30) {
                                            System.out.println("\"Do you wish to pay the fee?\" (Owned gold: "+gold+")");
                                            String payfee = scan.nextLine().toLowerCase();
                                            if (payfee.equals("yes") || payfee.equals("y")) {
                                                guildexp -= guildxpreqs[guildrank];
                                                guildrank++;
                                            }
                                        }
                                    } else {
                                        System.out.println("Do you wish to promote?");
                                        String promoteorno = scan.nextLine().toLowerCase();
                                        if (promoteorno.equals("yes") || promoteorno.equals("y")) {
                                            guildexp -= guildxpreqs[guildrank];
                                            guildrank++;
                                            System.out.println("You have achieved guild rank "+guildranks[guildrank]+"!"); a();
                                        }
                                    }
                                }
                                System.out.println("\"We have the following quests available:\"");
                                for (int i=0;i<3;i++) {
                                    System.out.println("["+(i+1)+"] "+questsboard[i][0]);
                                    System.out.println("  "+questsboard[i][1]+" gold, "+questsboard[i][2]+" EXP.");
                                }
                                System.out.println("Do you wish to take a quest at this time?");
                                if ((scan.nextLine().toLowerCase()).equals("yes")) {
                                    System.out.println("Enter the quest (integer)");
                                    int questnmbr = scan.nextInt(); questnmbr--;
                                    System.out.println("You have taken: "+questsboard[questnmbr][0]+"."); a();
                                    activeQuest[0][0] = 1;
                                    activeQuest[0][1] = questnmbr;
                                    if (inventory[0] == 0 && inventory[1] == 0 && inventory[2] == 0) {
                                        System.out.println("\"You are required to own a wooden sword before embarking.\""); a();
                                        if (gold<5) {
                                            System.out.println("You don't have enough gold, so we will give you a spare one."); a();
                                            inventory[0]++;
                                        }
                                    }
                                }
                            } else {
                                if (inventory[0] == 0 && inventory[1] == 0 && inventory[2] == 0) {
                                    System.out.println("\"You are required to own a wooden sword before embarking.\""); a();
                                    if (gold<5) {
                                        System.out.println("You don't have enough gold, so we will give you a spare one."); a();
                                        inventory[0]++;
                                    }
                                } else {
                                    System.out.println("\"You currently have an active quest, so we cannot service you at this time.\""); a();
                                }
                            }
                        }
                    } else {
                        System.out.println("\"Sorry, but like we said, there are no quests today. Please head towards the inn.\""); a();
                    }
                }
            } else if (answer.equals("save") || answer.equals("savedata")) {
                save();
            } else if (answer.equals("load") || answer.equals("loaddata")) {
                load();
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
            else if (answer.equals("quest")) {
                //System.out.println(activeQuest[0][0]+" "+activeQuest[0][1]);
                if (inventory[0]>0) {
                    if (activeQuest[0][0] == 1) {
                        /*int[] data = new int[39];
                        data[0] = activeQuest[0][1]; data[1] = gold; data[2] = hp; data[3] = maxhp; data[4] = attackstat; 
                        data[5] = defencestat; data[6] = speedstat; data[7] = level; data[8] = xp;
                        for (int i=9;i<39;i++) {
                            data[i] = inventory[i-9];
                        }
                        rpgQuests sendTo = new rpgQuests();
                        int[] receivedata = sendTo.start();*/
                        int catchInt = quests(activeQuest[0][1]);
                        if (catchInt == 1) {
                            System.out.println("You have completed the quest!"); a();
                            int xpgain = Integer.parseInt(questsboard[activeQuest[0][1]][2]); int goldgain = Integer.parseInt(questsboard[activeQuest[0][1]][1]);
                            System.out.println("You have gained "+xpgain+" XP and "+(xpgain/2)+" guild XP."); a();
                            System.out.println(xp);
                            xp += xpgain; guildexp += xpgain/2;
                            System.out.println(xp);
                            int done=1;while (done>0) {
                                if (xp >= (10+(level*15))) {
                                    levelUp(done);
                                    done++;
                                } else {
                                        done=0;
                                }
                            }
                            if (guildexp >= guildxpreqs[guildrank+1]) {
                                System.out.println("You are now eligible for rank "+guildranks[guildrank+1]+".");
                            }
                            System.out.println("You have gained "+goldgain+" gold.");
                            gold += goldgain;
                            System.out.println("You now have "+gold+" gold.");
                            activeQuest[0][0] = 0; activeQuest[0][1] = 0;
                        }
                    }
                } else {
                    System.out.println("/'Leaving without a sword is suicide.../'"); a();
                }
            }
        }
    }
    public int[] monsterFight(int[] stats) {
        int health = stats[0]; int attack = stats[1]; int defence = stats[2];
        int xpreward = stats[3]; int goldreward = stats[4]; int lvl = stats[5];
        String name = monsternames[stats[6]];
        System.out.println("You have encountered a LVL."+lvl+" "+name+"!");
        Boolean done = false; while (done == false) {
            Boolean action = false;
            System.out.println("Choose an action:");
            System.out.println("1. Attack; 2. Inventory;");
            String catchLine = scan.nextLine().toLowerCase(); if (catchLine.equals("attack") || catchLine.equals("1")) {
                int boost = 0;
                if (inventory[0] > 0) {
                    if (inventory[1] > 0) {
                        if (inventory[2] > 0) {
                            boost = (int)(Math.random()*(15-8+8)+8);
                        } else {
                            boost = (int)(Math.random()*(10-4+4)+4);
                        }
                    } else {
                        boost = (int)(Math.random()*(5-1+1)+1);
                    }
                }
                int damage = (attackstat - defence) + boost;
                if (damage < 1) {
                    damage = 1;
                }
                System.out.println("You attack the "+name+", dealing "+damage+" damage."); a();
                health -= damage;
                int crit = (int)(Math.random()*(4-1+1)+1);
                if (crit == 1) {
                    int critdmg = (int)(Math.random()*(3-1+1)+1);
                    System.out.println("You strike again, dealing "+critdmg+" CRIT damage!"); a();
                    health -= critdmg;
                }
                if (health < 0) {health=0;}
                System.out.println("The monster is at "+health+" health."); a();
                action = true;
                if (health==0) {
                    done = true; action = false;
                }
            }
            else if (catchLine.equals("inventory") || catchLine.equals("2")) {
                healUp();
            }
            if (action == true) {
                double dodgechance = (lvl-level)-(speedstat/20); if (dodgechance<3){dodgechance=3;}
                int chance = (int)(Math.random()*(dodgechance-1+1)+1);
                if (chance == 1) {
                    System.out.println("The "+name+" misses the player!"); a();
                } else {
                    int damage = (attack - defencestat) + (int)(Math.random()*((1+(attack-defencestat))-1+1)+1);
                    if (damage < 1) {damage=1;}
                    System.out.println("The "+name+" attacks the player, dealing "+damage+" damage!"); a();
                    int crit = (int)(Math.random()*(4-1+1)+1);
                    if (crit == 1) {
                        int critdmg = (int)(Math.random()*(3-1+1)+1);
                        System.out.println("The "+name+" strikes again, dealing "+critdmg+" CRIT damage!"); a();
                        hp -= critdmg;
                    }
                    hp -= damage;
                    if (hp < 0) {hp=0;}
                    System.out.println("You now have "+hp+" HP."); a();
                    if (hp == 0) {
                        System.out.println("You have died."); a();
                        int[] returnint = {2};
                        return returnint;
                    }
                }
            }
        }
        if (health==0) {
            System.out.println("You have killed the "+name+"!"); a();
            System.out.println("You have gained "+xpreward+" XP."); a();
            int done2=1;while (done2<0) {
                if (xp >= (10+(level*15))) {
                    levelUp(done2);
                    done2++;
                } else {
                    done2=0;
                }
            }
            System.out.println("You have gained "+goldreward+" gold."); a();
            gold += goldreward;
            System.out.println("You now have "+gold+" gold."); a();
        }
        return new int[1];
    }
    
    public void healUp() {
        System.out.println("You have:");
        System.out.println("1: "+inventory[5]+" Health Potion(s)");
        System.out.println("2: "+inventory[6]+"  Super Potion(s)");
        System.out.println("3: "+inventory[7]+"  Viper Potion(s)");
        System.out.println("Which do you want to use? (Hit 0 to return)");
        switch (scan.nextInt()) {
            case 1:
                if (inventory[5] > 0) {
                    System.out.println("You have used 1 Health Potion."); a();
                    inventory[5]--;
                    hp += 10;
                    if (hp > maxhp) {
                        hp = maxhp;
                    }
                } else {
                    System.out.println("You don't have any Health Potions..."); a();
                }
                break;
            case 2:
                if (inventory[6] > 0) {
                    System.out.println("You have used 1 Super Potion."); a();
                    inventory[6]--;
                    hp += 25;
                    if (hp > maxhp) {
                        hp = maxhp;
                    }
                } else {
                    System.out.println("You don't have any Super Potions..."); a();
                }
                break;
            case 3:
                if (inventory[7] > 0) {
                    System.out.println("You have used 1 Viper Potion."); a();
                    inventory[7]--;
                    hp += 50;
                    if (hp > maxhp) {
                        hp = maxhp;
                    }
                } else {
                    System.out.println("You don't have any Viper Potions..."); a();
                }
                break;
        }
    }
    
    public int levelUp(int howMany) {
        xp -= (10+(level*15));
        level += 1;
        if (howMany == 1) {
            System.out.println("You have leveled up!");
        }
        System.out.println("You are now level "+level+"!");
        maxhp++; attackstat++; defencestat++; speedstat++; hp = maxhp; int chosen=0;;
        chosen=0;
        System.out.println("Choose a stat to boost by 1 point.");
        while (chosen==0) {
            System.out.print("");
            String statboost = scan.nextLine().toLowerCase();
            int attkbst = 1; int defencebst = 1; int hpbst = 1; int speedbst = 1;
            if (statboost.equals("attack") || statboost.equals("attk")) {
                attkbst++;
                chosen = 1;
                attackstat++;
            } else if (statboost.equals("defence") || statboost.equals("dfnce")) {
                defencebst++;
                chosen = 1;
                defencestat++;
            } else if (statboost.equals("speed") || statboost.equals("spd")) {
                speedbst++;
                chosen = 1;
                speedstat++;
            } else if (statboost.equals("health") || statboost.equals("hp") || statboost.equals("maxhp")) {
                hpbst++;
                chosen = 1;
                maxhp++;
                hp = maxhp;
            }
            if (chosen==1) {
                System.out.println("ATTACK: "+attackstat+"(+"+attkbst+")");
                System.out.println("DEFENCE: "+defencestat+"(+"+defencebst+")");
                System.out.println("SPEED: "+speedstat+"(+"+speedbst+")");
                System.out.println("HEALTH: "+maxhp+"(+"+hpbst+")");
            }
        }
        return 0;
    }

    public int quests(int questnmbr) {
        /* int health = stats[0]; int attack = stats[1]; int defence = stats[2];
        int xpreward = stats[3]; int goldreward = stats[4]; int lvl = stats[5];
        */
        int finished = 0;
        switch (questnmbr) {
            case 0:
                System.out.println("You have arrived at the Beginners Dungeon."); a();
                int roomcount = (int)(Math.random()*(5-3+3)+3);
                int z=0;
                for (int i=0;i<roomcount;i++) {
                    int rng = (int)(Math.random()*(6-1+1)+1);
                    switch (rng) {
                        case 1:
                        case 2:
                        case 3:
                            int[] sendstats = {10,2,1,10,5,1,2};
                            monsterFight(sendstats);
                            if (hp == 0) {
                                death();
                                finished = 0;
                                return finished;
                            }
                            break;
                        case 4:
                        case 5:
                            int[] sendstats2 = {15,3,2,15,10,2,0};
                            monsterFight(sendstats2);
                            if (hp == 0) {
                                death();
                                finished = 0;
                                return finished;
                            }
                            break;
                        case 6:
                            int rng2 = (int)(Math.random()*(5-1+1)+1);
                            switch (rng2) {
                                case 1:
                                case 2:
                                    System.out.println("You open a chest and discover "+itemIndex[10]+"!"); a();
                                    inventory[10]++;
                                    break;
                                case 3:
                                case 4:
                                    System.out.println("You open a chest and discover "+itemIndex[11]+"!"); a();
                                    inventory[11]++;
                                    break;
                                case 5:
                                    System.out.println("You open a chest and discover "+itemIndex[12]+"!"); a();
                                    inventory[12]++;
                                    break;
                            }
                            
                    }
                    int healhp = (int)(Math.random()*(5-1+1)+1); int healbyhowmuch = 0;
                    switch (healhp) {
                        case 1: case 2: healbyhowmuch=1; break;
                        case 3: case 4: healbyhowmuch=2; break;
                        case 5: healbyhowmuch=3; break;
                    }
                    System.out.println("You have recovered "+healbyhowmuch+" HP."); a();
                    hp += healbyhowmuch;
                    System.out.println("You are now at "+hp+" HP."); a();
                    if (i>=roomcount/2&&z==0) {
                        System.out.println("You discover a resting spot, and decide to close your eyes."); a();
                        System.out.println("(...)"); a();
                        System.out.println("(Your HP has fully recovered.)"); a();
                        System.out.println("You wake up, and decide to continue before anything crawls into you during your sleep."); a();
                        hp=maxhp;
                    } else {
                        System.out.println("Do you wish to use a potion?");
                        String ineedahero = scan.nextLine().toLowerCase();
                        if (ineedahero.equals("yes") || ineedahero.equals("1")) {
                            healUp();
                        }
                    }
                }
                if (hp > 0) {
                    finished = 1;
                }
                break;
            case 1:
                //
                break;
            case 2:
                finished = 1;
                break;
        }
        return finished;
    }
    
    public void death() {
        x=1;
    }
    
    public void save() {
        String savedata = gold+"/"+smithclosed+shopclosed+innclosed+guildclosed+hp+"/"+maxhp+"/"+attackstat+"/"+defencestat+"/"+speedstat+"/"+level+"/"+xp+"/"+guildrank+"/"+guildexp+"/";
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
    }
    public void load() {
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
        gold = Integer.parseInt(unencrypted.substring(0,index));
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
        for (int i=0;i<unencrypted.length();i++) {
            inventory[i] = Integer.parseInt(unencrypted.charAt(i)+"");
           // System.out.println(inventory[i]);
        }
        //System.out.println(unencrypted);
        System.out.println("Data loaded.");
    }
}

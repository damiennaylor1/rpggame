import java.util.Scanner;
public class rpgGame {
    Scanner scan = new Scanner(System.in);
    String[] itemIndex = {"Wooden Sword","Iron Sword","Steel Sword","Gold Sword","Titanium Sword","Health Potion","Super Potion","Viper Potion","Flashbang","Poison Ink","","","",""};
    int[] goldIndex = {5,20,50,100,300,5,15,40,30,40,0,0,0,0};
    String[][] smithInv = new String[5][2]; String[][] shopInv = new String[5][2];
    int gold = 0; int smithclosed = 0; int shopclosed = 0; int innclosed = 0; int guildclosed = 0;
    int[] inventory = new int[30];
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
                                    System.out.println("(Are you sure?)");
                                    String yeahea = scan.nextLine().toLowerCase();
                                    if (yeahea.equals("yes")) {
                                        gold -= Integer.parseInt(smithInv[whichItem-1][1]);
                                        for (int i=0;i<10;i++) {
                                            if (smithInv[whichItem-1][0].equals(itemIndex[i])) {
                                                i=10;
                                                addToInventory(i);
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
                                    System.out.println("(Are you sure?)");
                                    String yeahea = scan.nextLine().toLowerCase();
                                    if (yeahea.equals("yes")) {
                                        gold -= Integer.parseInt(shopInv[whichItem-1][1]);
                                        for (int i=0;i<10;i++) {
                                            if (shopInv[whichItem-1][0].equals(itemIndex[i])) {
                                                i=10;
                                                addToInventory(i);
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
            }
        }
    }
}

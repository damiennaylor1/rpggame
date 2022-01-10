import java.util.Scanner;
public class rpgGame {
    Scanner scan = new Scanner(System.in);
    String[] itemIndex = {"Wooden Sword","Iron Sword","Steel Sword","Gold Sword","Titanium Sword","Health Potion","Super Potion","Viper Potion","Flashbang","Poison Ink","","","",""};
    String[][] smithInv = new String[5][2];
    int gold = 0; int smithclosed = 0;
    int[] inventory = new int[30];
    public int addToInventory(int item) {
        inventory[item]++;
        return item;
    }
    public void scramble() {
        
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
                    if (yesno.equals("yes")) {
                        //
                        for (int i=0;i<5;i++) {
                            System.out.print(smithInv[i][0]+" - "+smithInv[i][1]+" gold. ");
                        }
                        System.out.println("\n\"Want any of my stock?\" (Use integer)");
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
                                        }
                                    }
                                }
                            } else {
                                System.out.println("\"Not enough gold for that one, sonny.\"");
                            }
                        } else {
                            System.out.println("\"I don't have that item, young'n.\"");
                        }
                    }
                } else {
                    System.out.println("It appears the blacksmith is not here...");
                }
            }
        }
    }
}

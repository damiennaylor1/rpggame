import java.util.Scanner;
public class rpgGame {
    Scanner scan = new Scanner(System.in);
    String[] itemIndex = new String[30];
    int[] inventory = new int[30];
    public void a() {
        scan.nextLine();
    }
    public void main() {
        System.out.println("Welcome to RPG game!"); a();
        System.out.println("Press enter to start the game."); a();
        int x=0; while (x==0) {
            System.out.println("Where would you like to go?");
            System.out.println("(Blacksmith, Marreds (shop), Inn, Guild)");
            String answer = scan.nextLine().toLowerCase();
            if (answer.equals("blacksmith") || answer.equals("black smith")) {
                if (smithclosed == 0) {
                    System.out.println("\"Welcome to my shop, 'lad. Need you some tools? \"");
                    String yesno = scan.nextLine().toLowerCase();
                    if (yesno.equals("yes")) {
                        //
                    }
                } else {
                    System.out.println("It appears the blacksmith is not here...");
                }
            }
        }
    }
}
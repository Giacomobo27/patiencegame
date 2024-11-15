import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //initialize cards and slots and game
        Game game = new Game();

        game.GamePrint();

        while (!game.isGameover()) {
            //infinite loop to have input cmd and
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter command: ");
            String input = scanner.nextLine();
            System.out.println("Elaborating...");

            //it calls and update every data internally
            game.update(input);
        }

        int score=game.getScore();
        System.out.println("Game Finished => Final Score:"+score);

    }
}

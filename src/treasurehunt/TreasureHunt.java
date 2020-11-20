package treasurehunt;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class TreasureHunt {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static String gameBoard[][];
    static Integer scoreboard[][];
    static int userint;
    static int total = 0;
    static int treasuretotal;

    public static void main(String[] args) {
        playGame();
    }

    public static void createboard() {
        System.out.println("Enter how big you want your grid to be");
        userint = scanner.nextInt();
        gameBoard = new String[userint][userint];
        for (int i = 0; i < userint; i++) {
            for (int j = 0; j < userint; j++) {
                gameBoard[i][j] = "[ ]";
            }
        }
    }

    public static void createscores() {
        scoreboard = new Integer[userint][userint];
        System.out.println("How much treasure do you want there to be");
        int treasureAmount = scanner.nextInt();
        treasuretotal = treasureAmount;
        while (treasureAmount > ((double)(userint * userint)*0.8)) {
            System.out.println("Enter a valid number");
            treasureAmount = scanner.nextInt();
        }
        for (int i = 0; i < userint; i++) {
            for (int j = 0; j < userint; j++) {
                scoreboard[i][j] = 0;
            }
        }

        for (int i = 0; i < treasureAmount; i++) {
            int coordOne = random.nextInt(userint-1);
            int coordTwo = random.nextInt(userint-1);
            int treasureValue = random.nextInt(9) + 1;
            if (scoreboard[coordOne][coordTwo] == 0) {
                scoreboard[coordOne][coordTwo] = treasureValue;
            } else {
                i--;
            }
        }
    }

    public static void playGame() {
        createboard();
        createscores();

        while (treasuretotal > 0) {
            for (int i = 0; i < userint; i++) {
                for (int j = 0; j < userint; j++) {
                    System.out.print(gameBoard[i][j]);
                }
                System.out.println("");
            }
            System.out.println("Enter X coord");
            int userX = scanner.nextInt()-1;
            System.out.println("Enter Y coord");
            int userY = scanner.nextInt()-1;
            total = total + scoreboard[userX][userY];
            System.out.println("Your total is "+ total);
            if (scoreboard[userX][userY] > 0) {
                gameBoard[userX][userY] = "[x]";
                treasuretotal--;
            }
        }
        System.out.println("You win");

    }

}

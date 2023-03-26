import java.util.Scanner;
import java.util.ArrayList;

// MENU CLASS IS CREATED TO BE INHERITED BY OTHER SUB MENU CLASSES
public class Menu {

//    PROPERTIES
    protected static String menuTitle = "Menu Title";
    protected static ArrayList<String> menuItems = new ArrayList<>();
    protected static int userInput;

//    METHODS
    public static void run(){
        displayMenu();
        getInput();
        menuItems.clear();
    }

    private static void displayMenu() {
        UI.displayTitle();
        System.out.println("" + menuTitle + "\n");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println("  "+(i + 1) + ". " + menuItems.get(i));
        }
        System.out.println("\n\n");
    }

    private static void getInput() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                int rawInput = Integer.parseInt(sc.nextLine());
                if (rawInput >= 1 && rawInput <= menuItems.size()) {
                    userInput = rawInput;
                    break;
                } else {
                    UI.displayInfo("Invalid Input");
                }
            } catch (NumberFormatException e) {
                UI.displayInfo("Invalid Input");
            }
        }
    }
}

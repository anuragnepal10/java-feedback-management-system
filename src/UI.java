import java.util.Scanner;
import java.io.IOException;

// UI CLASS IS CREATED TO MAKE THINGS EASIER IN THE USER INTERFACE DEPARTMENT
public class UI {

    //    METHOD TO CLEAR CONSOLE
    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

//    METHOD TO DISPLAY TITLE
    public static void displayTitle() {
        clearConsole();
        System.out.println("\t\t--------------------------------------------------------------");
        System.out.println("\t\t\tPRODUCT RATING AND FEEDBACK MANAGEMENT SYSTEM");
        System.out.println("\t\t--------------------------------------------------------------");
        System.out.println("\n\n");
    }

//    METHOD TO DISPLAY INFORMATION AT THE CENTER
    public static void displayInfo(String message) {
        System.out.println("\t\t\t\t\t"+message);
    }

//    METHOD TO DISPLAY LONG INFORMATION AT THE CENTER
    public static void displayLongInfo(String message) {
        System.out.print("\t\t\t\t"+message);
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

//    METHOD TO DISPLAY LONG INFORMATION FROM THE LEFT
    public static void displayLongInfo(String message, String position) {
        if (position.equals("left")) {
            System.out.print("\n" + message);
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
        }
    }

//    METHOD TO DISPLAY A HORIZONTAL LINE
    public static void displayLine() {
        System.out.println("--------------------------------------------------------------------------------------------");
    }

//    METHOD TO DISPLAY AN EXIT MESSAGE
    public static void displayExit() {
        clearConsole();
        System.out.print("Thank you and Visit again!");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

//    METHOD TO DISPLAY TABLE HEADING
    public static void displayTableHeading(String[] headings) {
        displayLine();
        System.out.printf("%-25s %-40s %-25s\n",headings[0],headings[1],headings[2]);
        displayLine();
    }

//    METHOD TO DISPLAY TABLE ITEMS
    public static void displayTableItem(String[] items) {
        System.out.printf("%-25s %-40s %-25s\n",items[0],items[1],items[2]);
    }
}

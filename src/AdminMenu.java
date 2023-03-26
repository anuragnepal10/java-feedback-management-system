import java.util.Scanner;

// ADMIN MENU CLASS
public class AdminMenu extends Menu{

//    PASSWORD VALIDATION
    public static void authenticate() {
        UI.displayTitle();
        System.out.print("Enter password to proceed: ");
        Scanner sc = new Scanner(System.in);
        String userPassword = sc.nextLine();
        Password password = Password.getInstance();
        if (userPassword.equals(password.getPassword())) {
            run();
        }
        else {
            UI.displayInfo("Incorrect Password!");
            UI.displayLongInfo("Press 'Enter' to return to the Main Menu.","left");
            MainMenu.run();
        }
    }

//    RUN MENU
    public static void run() {
        Menu.menuTitle = "Admin Menu";
        Menu.menuItems.add("Feedback Control");
        Menu.menuItems.add("Product Control");
        Menu.menuItems.add("Change Password");
        Menu.menuItems.add("Return to the Main Menu");
        Menu.run();
        control();
    }

//    CONTROL PROGRAM FLOW
    public static void control() {
        if (userInput == 1) {
            FeedbackControlMenu.run();
        } else if (userInput == 2) {
            ProductControlMenu.run();
        } else if (userInput == 3) {
            Password password = Password.getInstance();
            password.changePassword();
            run();
        } else {
            MainMenu.run();
        }
    }
}

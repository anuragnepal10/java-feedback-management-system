// MAIN MENU CLASS
public class MainMenu extends Menu {

//    RUN MENU
    public static void run() {
        Menu.menuTitle = "Main Menu";
        Menu.menuItems.add("Log in as Customer");
        Menu.menuItems.add("Log in as Admin");
        Menu.menuItems.add("Exit Program");
        Menu.run();
        control();
    }

//    CONTROL PROGRAM FLOW
    private static void control() {
        if (userInput == 1) {
            CustomerMenu.run();
        }
        else if (userInput == 2) {
             AdminMenu.authenticate();
        }
        else {
            UI.displayExit();
        }
    }
}

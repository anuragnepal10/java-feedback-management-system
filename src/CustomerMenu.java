// CUSTOMER MENU CLASS
public class CustomerMenu extends Menu {

//    RUN MENU
    public static void run() {
        Menu.menuTitle = "Customer Menu";
        Menu.menuItems.add("Leave a feedback");
        Menu.menuItems.add("Return to the Main Menu");
        Menu.run();
        control();
    }

//    CONTROL PROGRAM FLOW
    private static void control() {
        if (userInput == 1) {
             FeedbacksContainer.getInstance().addFeedback();
        }
        else {
            MainMenu.run();
        }
    }

}

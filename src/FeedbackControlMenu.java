public class FeedbackControlMenu extends Menu{

//    RUN MENU
    public static void run() {
        Menu.menuTitle = "Feedback Control Menu";
        Menu.menuItems.add("Feedback Dashboard");
        Menu.menuItems.add("Rating Analysis");
        Menu.menuItems.add("Return to the Admin Menu");
        Menu.run();
        control();
    }

//    CONTROL PROGRAM FLOW
    public static void control() {
        if (userInput == 1) {
            FeedbacksContainer.getInstance().displayAllFeedbacks();
        } else if (userInput == 2) {
            FeedbacksContainer.getInstance().displayAllProductsRating();
        } else {
            AdminMenu.run();
        }
    }
}

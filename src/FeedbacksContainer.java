import java.util.ArrayList;
import java.util.Scanner;

// SINGLETON CLASS THAT CONTAINS ARRAY LIST TO HOLD ALL THE FEEDBACKS
public class FeedbacksContainer {

//    PROPERTIES
    private static FeedbacksContainer feedbacksContainer;
    private final ArrayList<Feedback> list = new ArrayList<>();

//    CREATE AN INSTANCE OF THIS CLASS
    public static FeedbacksContainer getInstance() {
        if (feedbacksContainer == null)  {
            feedbacksContainer = new FeedbacksContainer();
        }
        return feedbacksContainer;
    }

//    GET ARRAY LIST OF FEEDBACK OBJECTS
    public ArrayList<Feedback> getList() {
        return list;
    }

//    ADD A FEEDBACK
    public void addFeedback() {
        if (ProductsContainer.getInstance().getList().size() == 0) {
            UI.displayLongInfo("Product Inventory is empty. Launch a Product first.","left");
            CustomerMenu.run();
        }
        else {
            ProductsContainer.getInstance().displayAllProducts();
            Feedback feedback = new Feedback();
            feedback.getProductID();
            feedback.getName();
            feedback.getMessage();
            feedback.getRating();
            getList().add(feedback);
            updateRating();
            Scanner sc = new Scanner(System.in);
            UI.displayInfo("Feedback Added Successfully!");
            while (true) {
                System.out.print("Add another feedback? (y/n): ");
                String userInput = sc.nextLine().toLowerCase();
                if (userInput.equals("n")) {
                    CustomerMenu.run();
                    break;
                } else if (userInput.equals("y")) {
                    addFeedback();
                    break;
                } else {
                    UI.displayInfo("Invalid Input");
                }
            }
        }
    }

//    UPDATE RATING
    public void updateRating() {
        FeedbacksContainer feedbacksContainer = FeedbacksContainer.getInstance();
        ProductsContainer productsContainer = ProductsContainer.getInstance();
        for (int i = 0; i < feedbacksContainer.getList().size(); i++) {
            for (int j = 0; j < productsContainer.getList().size(); j++) {
                if (feedbacksContainer.getList().get(i).productId == productsContainer.getList().get(j).id) {
                    productsContainer.getList().get(j).totalRating += feedbacksContainer.getList().get(i).rating;
                    productsContainer.getList().get(j).ratingCount +=1;
                    productsContainer.getList().get(j).rating = Math.round(productsContainer.getList().get(j).totalRating/productsContainer.getList().get(j).ratingCount * 10)/10.0;
                }
            }
        }
    }

//    DISPLAY ALL FEEDBACKS
    public void displayAllFeedbacks() {
            UI.displayTitle();
        if (getList().size() == 0){
            UI.displayLongInfo("Feedbacks Unavailable! Leave a Feedback first.","left");
        }
        else {
            UI.displayLine();
            ProductsContainer productsContainer = ProductsContainer.getInstance();
            for (int i = 0; i < (getList().size()); i++) {
                int id = getList().get(i).productId;
                UI.displayInfo("Feedback no." + (i + 1));
                UI.displayLine();
                System.out.println("\tBy ->");
                System.out.printf("\t\t\t\t%-10s : %-20s\n", "Name", getList().get(i).name);
                System.out.println("\tProduct Information -> ");
                System.out.printf("\t\t\t\t%-10s : %-20d\n", "ID", id);
                for (int j = 0; j < (productsContainer.getList().size()); j++) {
                    if (productsContainer.getList().get(j).id == id) {
                        System.out.printf("\t\t\t\t%-10s : %-20s\n", "Name", productsContainer.getList().get(j).name);
                        System.out.printf("\t\t\t\t%-10s : Rs.%-20d\n", "Price", productsContainer.getList().get(j).price);
                    }
                }
                System.out.println("\tFeedback ->");
                System.out.printf("\t\t\t\t%-10s : %-20s\n", "Message", getList().get(i).message);
                System.out.printf("\t\t\t\t%-10s : %-20s\n", "Rating", getList().get(i).rating + "/5 star");
                UI.displayLine();
            }
            UI.displayLongInfo("Press 'Enter' to return to the Feedback Control Menu.", "left");
        }
        FeedbackControlMenu.run();
    }

//    DISPLAY AL PRODUCT RATINGS
    public void displayAllProductsRating() {
        UI.displayTitle();
        if (ProductsContainer.getInstance().getList().size() == 0) {
            UI.displayLongInfo("Product Inventory is empty. Launch a Product first.","left");
        }
        else {
            System.out.println("Rating Analysis\n");
            ProductsContainer productsContainer = ProductsContainer.getInstance();
            for (int i = 0; i < productsContainer.getList().size(); i++) {
                if (productsContainer.getList().get(i).rating == 0) {
                    System.out.printf("\t%-20s : %-20s\n", productsContainer.getList().get(i).name, "none");
                } else {
                    System.out.printf("\t%-20s : %-20s\n", productsContainer.getList().get(i).name, (Math.round(productsContainer.getList().get(i).rating * 10) / 10.0) + "/5 star");
                }
            }
            UI.displayLongInfo("Press 'Enter' to return to the Feedback Control Menu.","left");
        }
        FeedbackControlMenu.run();
    }
}
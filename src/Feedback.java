import java.util.Scanner;

// FEEDBACK CLASS HOLDS A PARTICULAR FEEDBACK INFORMATION
public class Feedback {

//    PROPERTIES
    public String name;
    public int productId;
    public String message;
    public int rating;

//    GET PRODUCT ID
    public void getProductID(){
        ProductsContainer productsContainer = ProductsContainer.getInstance();
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                boolean found = false;
                System.out.print("Enter Product ID: ");
                int testId = Integer.parseInt(sc.nextLine());
                for (int i = 0; i < productsContainer.getList().size(); i++) {
                    if (testId == productsContainer.getList().get(i).id) {
                        found = true;
                        productId = testId;
                        UI.displayTitle();
                        productsContainer.getList().get(i).displayProduct();
                        break;
                    }
                }
                if (!found) {
                    UI.displayInfo("ID not found");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                UI.displayInfo("Invalid Input");
            }
        }
    }

//    GET FEEDBACK PROVIDER'S NAME
    public void getName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Name: ");
        String testName = sc.nextLine();
        if (testName.equals("")) {
            name = "Anonymous User";
        } else {
            name = testName;
        }
    }

//    GET FEEDBACK PROVIDER'S MESSAGE
    public void getMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Message: ");
        String testMessage = sc.nextLine();
        if (testMessage.equals("")) {
            message = "<no message>";
        } else {
            message = testMessage;
        }
    }

//    GET FEEDBACK PROVIDER'S RATING
    public void getRating() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Leave a Rating (from 1 to 5): ");
                int testRating = Integer.parseInt(sc.nextLine());
                if (testRating >= 1 && testRating <= 5) {
                    rating = testRating;
                    break;
                } else {
                    UI.displayInfo("Out of Range");
                }
            } catch (NumberFormatException e) {
                UI.displayInfo("Invalid Input");
            }
        }
    }

}

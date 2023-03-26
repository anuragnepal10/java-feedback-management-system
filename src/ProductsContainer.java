import java.util.ArrayList;
import java.util.Scanner;


// SINGLETON CLASS THAT CONTAINS ARRAY LIST TO HOLD ALL THE PRODUCTS
public class ProductsContainer {

//    PROPERTIES
    private static ProductsContainer productsContainer;
    private final ArrayList<Product> list = new ArrayList<>();

//    CREATE AN INSTANCE OF THIS CLASS
    public static ProductsContainer getInstance() {
        if (productsContainer == null)  {
            productsContainer = new ProductsContainer();
        }
        return productsContainer;
    }

//    GET ARRAY LIST OF PRODUCT OBJECT
    public ArrayList<Product> getList() {
        return list;
    }

//    ADD PRODUCT
    public void addProduct() {
        UI.displayTitle();
        Product product = new Product();
        product.getProductName();
        product.getProductPrice();
        product.generateID();
        getList().add(product);
        Scanner sc = new Scanner(System.in);
        UI.displayInfo("Product launched successfully!");
        while (true) {
            System.out.print("Launch another product? (y/n): ");
            String userInput = sc.nextLine().toLowerCase();
            if (userInput.equals("n")) {
                ProductControlMenu.run();
                break;
            } else if (userInput.equals("y")) {
                addProduct();
                break;
            } else {
                UI.displayInfo("Invalid Input");
            }
        }
    }

//    REMOVE PRODUCT
    public void removeProduct() {
        if (getList().size() == 0) {
            UI.displayLongInfo("Product Inventory is empty. Launch a product first.","left");
        }
        else {
            Scanner sc = new Scanner(System.in);
            displayAllProducts();
            System.out.println("Enter ID of the product that you want to remove.");
            System.out.println("Enter '0' if you want to remove all the products.\n");
            while (true) {
                try {
                    boolean found = false;
                    System.out.print("Enter ID: ");
                    int testId = Integer.parseInt(sc.nextLine());
                    if (testId == 0) {
                        getList().clear();
                        FeedbacksContainer.getInstance().getList().clear();
                        UI.displayLongInfo("All the products have been removed successfully!","left");
                        break;
                    }
                    for (int i = 0; i < getList().size(); i++) {
                        if (testId == getList().get(i).id) {
                            found = true;
                            getList().remove(i);
                            for (int j = 0; j < FeedbacksContainer.getInstance().getList().size();j++) {
                                if (testId == FeedbacksContainer.getInstance().getList().get(j).productId) {
                                    FeedbacksContainer.getInstance().getList().remove(j);
                                    j--;
                                }
                            }

                            UI.displayLongInfo("Product removed successfully!");
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
        ProductControlMenu.run();
    }

//    DISPLAY ALL PRODUCTS
    public void displayAllProducts() {
        if (getList().size() != 0) {
            UI.displayTitle();
            UI.displayTableHeading(new String[]{"Product ID", "Product Name", "Price (Rs)"});
            for (int i = 0; i < getList().size(); i++) {
                String id = String.valueOf(getList().get(i).id);
                String name = getList().get(i).name;
                String price = String.valueOf(getList().get(i).price);
                UI.displayTableItem(new String[]{id, name, price});
            }
            UI.displayLine();
        }
    }
}
import java.util.Scanner;

// PRODUCT CLASS HOLDS A PARTICULAR PRODUCT INFORMATION
public class Product {

//    PROPERTIES
    public int id;
    public String name;
    public int price;
    public double rating;
    public double totalRating = 0;
    public int ratingCount = 0;
    public Product() {
    }

//    GET PRODUCT NAME
    public void getProductName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Product Name: ");
        String testName = sc.nextLine();
        if (testName.equals("")) {
            name = "<no name>";
        } else {
            name = testName;
        }
    }

//    GET PRODUCT PRICE
    public void getProductPrice() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter Product Price: Rs.");
                int testPrice = Integer.parseInt(sc.nextLine());
                if (testPrice > 0) {
                    price = testPrice;
                    break;
                } else {
                    UI.displayInfo("Negative Number not supported");
                }
            } catch (NumberFormatException e) {
                UI.displayInfo("Only Integer supported");
            }
        }
    }

//    GENERATE ID
    public void generateID() {
        ProductsContainer productsContainer = ProductsContainer.getInstance();
        if (productsContainer.getList().size() == 0) {
            id = 1;
        }
        else {
            id = productsContainer.getList().get(productsContainer.getList().size()-1).id + 1;
        }
    }

//    DISPLAY PRODUCT INFORMATION
    public void displayProduct() {
        System.out.println("ID: "+id);
        System.out.println("Name: "+name);
        System.out.println("Price: Rs."+price);
        System.out.println();
    }
}

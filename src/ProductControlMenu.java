// PRODUCT CONTROL MENU CLASS
public class ProductControlMenu extends Menu{

//    RUN MENU
    public static void run() {
        Menu.menuTitle = "Product Control Menu";
        Menu.menuItems.add("Launch New Product");
        Menu.menuItems.add("Display Products");
        Menu.menuItems.add("Remove Product");
        Menu.menuItems.add("Return to the Admin Menu");
        Menu.run();
        control();
    }

//    CONTROL PROGRAM FLOW
    public static void control() {
        if (userInput == 1) {
            ProductsContainer.getInstance().addProduct();
        } else if (userInput == 2) {
            if (ProductsContainer.getInstance().getList().size() == 0) {
                UI.displayTitle();
                UI.displayLongInfo("Product Inventory is empty. Launch a Product first.","left");
            }
            else {
                ProductsContainer.getInstance().displayAllProducts();
                UI.displayLongInfo("Press 'Enter' to return to the Product Control Menu.", "left");
            }
            ProductControlMenu.run();
        } else if (userInput == 3) {
            ProductsContainer.getInstance().removeProduct();
        } else {
            AdminMenu.run();
        }
    }
}

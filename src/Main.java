// CLASS CONTAINING MAIN METHOD
public class Main {
    public static void main(String[] args) {

    //        INITIAL PASSWORD GENERATION
         Password password = Password.getInstance();
         password.setPassword("admin");

    //        INITIAL PRODUCT CREATION
         Product product1 = new Product();
         product1.name = "Demo Product 1";
         product1.price = 10000;
         product1.generateID();
         ProductsContainer.getInstance().getList().add(product1);

    //        INITIAL PRODUCT CREATION
         Product product2 = new Product();
         product2.name = "Demo Product 2";
         product2.price = 20000;
         product2.generateID();
         ProductsContainer.getInstance().getList().add(product2);

//         RUNNING CLASS MainMenu
         MainMenu.run();
    }
}
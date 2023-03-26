import java.util.Scanner;

// SINGLETON CLASS THAT CONTAINS PASSWORD INFORMATION
public class Password {

//    PROPERTIES
    private static Password password;
    private String value;

//    CONSTRUCTOR SET TO PRIVATE
    private Password() {
    }

//    CREATE AN INSTANCE OF THIS CLASS
    public static Password getInstance() {
        if (password == null) {
            password = new Password();
        }
        return password;
    }

//    SET PASSWORD
    public void setPassword(String initialValue) {
        value = initialValue;
    }

//    GET PASSWORD
    public String getPassword() {
        return value;
    }

//    CHANGE PASSWORD
    public void changePassword() {
        UI.displayTitle();
        System.out.print("Enter new Password: ");
        Scanner sc = new Scanner(System.in);
        String newPassword = sc.nextLine();
        setPassword(newPassword);
        UI.displayLongInfo("Password changed successfully!");
    }
}

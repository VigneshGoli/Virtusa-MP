import java.util.Scanner;

public class PasswordValidator {

    // Method to validate password
    public static boolean validatePassword(String password) {

        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean isValid = true;

        // Check length
        if (password.length() < 8) {
            System.out.println("Too short. Minimum 8 characters required.");
            isValid = false;
        }

        // Loop through characters
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            }

            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }

        // Check uppercase
        if (!hasUpper) {
            System.out.println("Missing an uppercase letter.");
            isValid = false;
        }

        // Check digit
        if (!hasDigit) {
            System.out.println("Missing a digit.");
            isValid = false;
        }

        return isValid;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String password;

        // Retry loop
        while (true) {

            System.out.print("Enter password: ");
            password = sc.nextLine();

            boolean result = validatePassword(password);

            if (result) {
                System.out.println("Password is valid.");
                break;
            } else {
                System.out.println("Please try again.\n");
            }
        }

        sc.close();
    }
}
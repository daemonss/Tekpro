// ****************************************************************
// Factorials.java
// Reads integers from the user and prints the factorial of each.
//
// ****************************************************************
import java.util.Scanner;
public class Factorials {
    public static void main(String[] args) {
        String keepGoing = "y";

        try (Scanner scan = new Scanner(System.in)) { // Try-with-resources agar Scanner tertutup otomatis
            while (keepGoing.equalsIgnoreCase("y")) {
                System.out.print("Enter an integer: ");
                try {
                    int val = scan.nextInt();
                    System.out.println("Factorial(" + val + ") = " + MathUtils.factorial(val));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Invalid input! Please enter an integer.");
                    scan.next(); // Membersihkan input buffer
                }

                System.out.print("Another factorial? (y/n): ");
                keepGoing = scan.next();
            }
        } // Scanner akan tertutup secara otomatis di sini
    }
}
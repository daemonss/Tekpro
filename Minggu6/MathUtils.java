// ****************************************************************
// MathUtils.java
//
// Provides static mathematical utility functions.
//
// ****************************************************************
public class MathUtils {
    //-------------------------------------------------------------
    // Mengembalikan faktorial dari argumen yang diberikan
    //-------------------------------------------------------------
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Error: Factorial is not defined for negative numbers.");
        }
        if (n > 16) {
            throw new IllegalArgumentException("Error: Factorial result exceeds int limit (overflow).");
        }

        int fac = 1;
        for (int i = n; i > 0; i--) {
            fac *= i;
        }
        return fac;
    }
}
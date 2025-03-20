// ****************************************************************
// ParseInts.java
//
// Reads a line of text and prints the integers in the line.
//
// ****************************************************************
import java.util.Scanner;

public class ParseInts {
    public static void main(String[] args) {
        int val, sum = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a line of text: ");
        String line = scan.nextLine();
        Scanner scanLine = new Scanner(line);

        // Proses parsing setiap token dalam input
        while (scanLine.hasNext()) {
            try {
                val = Integer.parseInt(scanLine.next());
                sum += val;
            } catch (NumberFormatException e) {
                // Menampilkan pesan kesalahan jika ada karakter non-angka
                System.out.println("Ignoring non-integer value.");
            }
        }

        System.out.println("The sum of the integers on this line is " + sum);
        scan.close();
        scanLine.close();
    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TotalCalculation {
    public static void main(String[] args) {
        try {
            // Open the input file
            File inputFile = new File("items.txt");
            Scanner scanner = new Scanner(inputFile);

            // Initialize variables
            double total = 0.0;

            // Read values from the file and calculate the total
            while (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                total += value;
            }

            // Close the input file
            scanner.close();

            // Calculate sales tax
            double salesTaxRate = 5.3;
            double salesTax = (total * salesTaxRate) / 100.0;

            // Calculate final total
            double finalTotal = total + salesTax;

            // Open the output file
            PrintWriter writer = new PrintWriter("total.txt");

            // Write results to the output file
            writer.printf("Sub-total: $%.2f%n", total);
            writer.printf("Sales Tax (%.2f%%): $%.2f%n", salesTaxRate, salesTax);
            writer.printf("Final Total: $%.2f%n", finalTotal);


            writer.close();

            System.out.println("Calculation completed. Results written to total.txt.");
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found. Please make sure items.txt exists.");
        }
    }
}

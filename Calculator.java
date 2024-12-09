import java.util.Scanner;

public class EnhancedCalculator {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Enhanced Calculator");
            System.out.println("1. Basic Arithmetic Operations");
            System.out.println("2. Scientific Calculations");
            System.out.println("3. Unit Conversions");
            System.out.println("4. Exit");
            System.out.print("Select an option (1-4): ");
            int option = scanner.nextInt();
            
            switch (option) {
                case 1:
                    performArithmeticOperations(scanner);
                    break;
                case 2:
                    performScientificCalculations(scanner);
                    break;
                case 3:
                    performUnitConversions(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    // Basic Arithmetic Operations
    public static void performArithmeticOperations(Scanner scanner) {
        System.out.println("Arithmetic Operations: ");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Choose an operation (1-4): ");
        int operation = scanner.nextInt();
        
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        
        double result = 0;
        
        switch (operation) {
            case 1:
                result = num1 + num2;
                break;
            case 2:
                result = num1 - num2;
                break;
            case 3:
                result = num1 * num2;
                break;
            case 4:
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero!");
                    return;
                }
                break;
            default:
                System.out.println("Invalid operation selected!");
                return;
        }
        
        System.out.println("The result is: " + result);
    }
    
    // Scientific Calculations
    public static void performScientificCalculations(Scanner scanner) {
        System.out.println("Scientific Calculations: ");
        System.out.println("1. Square Root");
        System.out.println("2. Exponentiation");
        System.out.print("Choose an operation (1-2): ");
        int operation = scanner.nextInt();
        
        double result = 0;
        
        switch (operation) {
            case 1:
                System.out.print("Enter a number to calculate its square root: ");
                double num1 = scanner.nextDouble();
                if (num1 < 0) {
                    System.out.println("Error: Cannot compute the square root of a negative number.");
                    return;
                }
                result = Math.sqrt(num1);
                break;
            case 2:
                System.out.print("Enter base number: ");
                double base = scanner.nextDouble();
                System.out.print("Enter exponent: ");
                double exponent = scanner.nextDouble();
                result = Math.pow(base, exponent);
                break;
            default:
                System.out.println("Invalid operation selected!");
                return;
        }
        
        System.out.println("The result is: " + result);
    }
    
    // Unit Conversions
    public static void performUnitConversions(Scanner scanner) {
        System.out.println("Unit Conversions: ");
        System.out.println("1. Temperature Conversion (Celsius to Fahrenheit and vice versa)");
        System.out.println("2. Currency Conversion (USD to EUR)");
        System.out.print("Choose an operation (1-2): ");
        int operation = scanner.nextInt();
        
        switch (operation) {
            case 1:
                System.out.println("Temperature Conversion");
                System.out.println("1. Celsius to Fahrenheit");
                System.out.println("2. Fahrenheit to Celsius");
                System.out.print("Choose an option (1-2): ");
                int tempChoice = scanner.nextInt();
                
                if (tempChoice == 1) {
                    System.out.print("Enter temperature in Celsius: ");
                    double celsius = scanner.nextDouble();
                    double fahrenheit = (celsius * 9/5) + 32;
                    System.out.println("Temperature in Fahrenheit: " + fahrenheit);
                } else if (tempChoice == 2) {
                    System.out.print("Enter temperature in Fahrenheit: ");
                    double fahrenheit = scanner.nextDouble();
                    double celsius = (fahrenheit - 32) * 5/9;
                    System.out.println("Temperature in Celsius: " + celsius);
                } else {
                    System.out.println("Invalid choice.");
                }
                break;
            case 2:
                System.out.println("Currency Conversion");
                System.out.print("Enter amount in USD: ");
                double usd = scanner.nextDouble();
                // Assuming conversion rate of 1 USD = 0.91 EUR (can be dynamic if needed)
                double eur = usd * 0.91;
                System.out.println("Amount in EUR: " + eur);
                break;
            default:
                System.out.println("Invalid operation selected!");
        }
    }
}

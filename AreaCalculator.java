package individualproject2;

import java.util.Scanner;

public class AreaCalculator {
	
	// Main method to start the application
    public static void main(String[] args) {
        AreaCalculator calculator = new AreaCalculator(); // Create an instance of AreaCalculator
        calculator.runMenu(); // Run the interactive menu
    }

    // Method to display the menu and handle user inputs for area calculations
    public void runMenu() {
        Scanner sc = new Scanner(System.in); // Scanner object to read user inputs
        String choice; // To store user's menu choice

        do {
            displayMenu(); // Display the options menu
            choice = sc.nextLine().toUpperCase(); // Read user choice and convert to uppercase

            // Switch case to handle user's menu choice
            switch (choice) {
                case "S":
                    System.out.println("Please enter length of the square:");
                    double side = sc.nextDouble();
                    sc.nextLine(); // Consume the newline left by nextDouble
                    System.out.println("Area of your square is: " + formatArea(calculateSquareArea(side)));
                    break;
                case "R":
                    System.out.println("Please enter length of the rectangle:");
                    double length = sc.nextDouble();
                    System.out.println("Please enter width of the rectangle:");
                    double width = sc.nextDouble();
                    sc.nextLine(); // Consume the newline left by nextDouble
                    System.out.println("Area of your rectangle is: " + formatArea(calculateRectangleArea(length, width)));
                    break;
                case "C":
                    System.out.println("Please enter the radius of the circle:");
                    double radius = sc.nextDouble();
                    sc.nextLine(); // Consume the newline left by nextDouble
                    System.out.println("Area of your circle is: " + formatArea(calculateCircleArea(radius)));
                    sc.close(); // Close the scanner object
                    return; // Exit the loop and method
                default:
                    System.out.println("Invalid input, please try again."); // Display error for invalid menu choice
            }

        } while (true); // Infinite loop to keep displaying the menu until the user exits
    }

    // Method to display the interactive menu options
    private void displayMenu() {
        System.out.println("***Area Calculator***");
        System.out.println("S  --  Square");
        System.out.println("R  --  Rectangle");
        System.out.println("C  --  Circle");
    }

    // Method to calculate the area of a square
    private double calculateSquareArea(double side) {
        return side * side;
    }

    // Method to calculate the area of a rectangle
    private double calculateRectangleArea(double length, double width) {
        return length * width;
    }

    // Method to calculate the area of a circle using a value of 3.14 for pi
    private double calculateCircleArea(double radius) {
        return 3.14 * radius * radius;
    }

    // Method to format the area value for display. If whole number, show without decimals. Otherwise, format to 2 decimal places.
    private String formatArea(double area) {
        if (area == Math.floor(area)) {
            return String.format("%.0f", area);
        } else {
            return String.format("%.2f", area);
        }
    }
}


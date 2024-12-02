package FinalProject;
import java.util.Scanner; 
import java.util.InputMismatchException;
public class FinalProject {
	
	
		 // Colors for terminal output
	    public static final String RESET = "\u001B[0m";
	    public static final String RED = "\u001B[31m";
	    public static final String GREEN = "\u001B[32m";
	    public static final String BLUE = "\u001B[34m";
	    public static final String YELLOW = "\u001B[33m";
	    public static final String CYAN_BG = "\u001B[46m";
	    public static final String WHITE_BG = "\u001B[47m";

	    public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
	        boolean isRunning = true;

	        System.out.println(WHITE_BG + BLUE + "Starting the application... just a moment!" + RESET);
	        try { Thread.sleep(1500); } catch (InterruptedException e) { /* Handle exception quietly */ }

	        while (isRunning) {
	            displayMenu();
	            System.out.print(YELLOW + "Choose an option (1-5): " + RESET);

	            try {
	                int option = input.nextInt();

	                switch (option) {
	                    case 1:
	                        calculator(input);
	                        break;
	                    case 2:
	                        circleMeasurements(input);
	                        break;
	                    case 3:
	                        rectangleMeasurements(input);
	                        break;
	                    case 4:
	                        convertCm(input);
	                        break;
	                    case 5:
	                        isRunning = false;
	                        System.out.println(RED + "Thanks for using this app! Exiting now." + RESET);
	                        break;
	                    default:
	                        System.out.println(RED + "Whoops! That's not an option. Please try again." + RESET);
	                }
	            } catch (InputMismatchException e) {
	                System.out.println(RED + "Oops! That doesn't look like a number. Please enter a valid option." + RESET);
	                input.nextLine(); // Clear invalid input
	            }
	        }
	        input.close();
	    }

	    // Method to display main menu options
	    public static void displayMenu() {
	        System.out.println(CYAN_BG + RED + "\n===== MAIN MENU =====" + RESET);
	        System.out.println(GREEN + "1. Calculator" + RESET);
	        System.out.println(GREEN + "2. Circle Measurements" + RESET);
	        System.out.println(GREEN + "3. Rectangle Measurements" + RESET);
	        System.out.println(GREEN + "4. Convert cm to mm & m" + RESET);
	        System.out.println(GREEN + "5. Exit" + RESET);
	    }

	    // Calculator for basic operations
	    public static void calculator(Scanner input) {
	        try {
	            System.out.print(YELLOW + "Enter the first number: " + RESET);
	            double firstNum = input.nextDouble();
	            System.out.print(YELLOW + "Enter the second number: " + RESET);
	            double secondNum = input.nextDouble();
	            System.out.print(YELLOW + "Choose an operation (+, -, *, /): " + RESET);
	            char op = input.next().charAt(0);

	            double result;
	            switch (op) {
	                case '+':
	                    result = firstNum + secondNum;
	                    break;
	                case '-':
	                    result = firstNum - secondNum;
	                    break;
	                case '*':
	                    result = firstNum * secondNum;
	                    break;
	                case '/':
	                    if (secondNum != 0) {
	                        result = firstNum / secondNum;
	                    } else {
	                        System.out.println(RED + "Error: Can't divide by zero!" + RESET);
	                        return;
	                    }
	                    break;
	                default:
	                    System.out.println(RED + "Invalid operation. Please use +, -, *, or /." + RESET);
	                    return;
	            }
	            System.out.println(GREEN + "The result is: " + result + RESET);
	        } catch (InputMismatchException e) {
	            System.out.println(RED + "Please enter numbers only for calculations." + RESET);
	            input.next(); // Clear invalid input
	        }
	    }

	    // Calculate area and circumference of a circle
	    public static void circleMeasurements(Scanner input) {
	        try {
	            System.out.print(YELLOW + "Enter the radius of the circle: " + RESET);
	            double radius = input.nextDouble();
	            double area = Math.PI * radius * radius;
	            double circumference = 2 * Math.PI * radius;
	            System.out.println(GREEN + "Circle area: " + area + RESET);
	            System.out.println(GREEN + "Circle circumference: " + circumference + RESET);
	        } catch (InputMismatchException e) {
	            System.out.println(RED + "Please enter a valid number for the radius." + RESET);
	            input.next(); // Clear invalid input
	        }
	    }

	    // Calculate area and perimeter of a rectangle
	    public static void rectangleMeasurements(Scanner input) {
	        try {
	            System.out.print(YELLOW + "Enter the length of the rectangle: " + RESET);
	            double length = input.nextDouble();
	            System.out.print(YELLOW + "Enter the width of the rectangle: " + RESET);
	            double width = input.nextDouble();
	            double area = length * width;
	            double perimeter = 2 * (length + width);
	            System.out.println(GREEN + "Rectangle area: " + area + RESET);
	            System.out.println(GREEN + "Rectangle perimeter: " + perimeter + RESET);
	        } catch (InputMismatchException e) {
	            System.out.println(RED + "Please enter valid numbers for length and width." + RESET);
	            input.next(); // Clear invalid input
	        }
	    }

	    // Convert centimeters to millimeters and meters
	    public static void convertCm(Scanner input) {
	        try {
	            System.out.print(YELLOW + "Enter the value in centimeters: " + RESET);
	            double cm = input.nextDouble();
	            double mm = cm * 10;
	            double m = cm / 100;
	            System.out.println(GREEN + cm + " cm = " + mm + " mm" + RESET);
	            System.out.println(GREEN + cm + " cm = " + m + " m" + RESET);
	        } catch (InputMismatchException e) {
	            System.out.println(RED + "Oops! Please enter a numeric value." + RESET);
	            input.next(); // Clear invalid input
	        }
	    }
	}



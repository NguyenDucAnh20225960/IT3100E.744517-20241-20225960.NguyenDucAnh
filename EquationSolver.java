import java.util.Scanner;

public class EquationSolver {

    public static void solveLinearEquation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Solving the first-degree equation ax + b = 0");
        
        System.out.print("Enter coefficient a (a ≠ 0): ");
        double a = scanner.nextDouble();
        
        if (a == 0) {
            System.out.println("Coefficient a cannot be 0 for a first-degree equation.");
            return;
        }
        
        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();
        
        // Calculate root
        double root = -b / a;
        System.out.printf("The solution is: x = %.2f%n", root);
    }

    public static void solveLinearSystem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Solving the system of first-degree equations:");
        
        System.out.print("Enter coefficient a11: ");
        double a11 = scanner.nextDouble();
        
        System.out.print("Enter coefficient a12: ");
        double a12 = scanner.nextDouble();
        
        System.out.print("Enter constant b1: ");
        double b1 = scanner.nextDouble();
        
        System.out.print("Enter coefficient a21: ");
        double a21 = scanner.nextDouble();
        
        System.out.print("Enter coefficient a22: ");
        double a22 = scanner.nextDouble();
        
        System.out.print("Enter constant b2: ");
        double b2 = scanner.nextDouble();

        // Calculate determinants
        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("The system has infinitely many solutions.");
            } else {
                System.out.println("The system has no solution.");
            }
        } else {
            // Calculate x1 and x2
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.printf("The solution is: x1 = %.2f, x2 = %.2f%n", x1, x2);
        }
    }

    public static void solveQuadraticEquation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Solving the second-degree equation ax^2 + bx + c = 0");
        
        System.out.print("Enter coefficient a (a ≠ 0): ");
        double a = scanner.nextDouble();
        
        if (a == 0) {
            System.out.println("Coefficient a cannot be 0 for a second-degree equation.");
            return;
        }
        
        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();
        
        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();
        
        // Calculate discriminant
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.printf("The solutions are: x1 = %.2f, x2 = %.2f%n", root1, root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.printf("The equation has a double root: x = %.2f%n", root);
        } else {
            System.out.println("The equation has no real roots.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Solve a first-degree equation");
            System.out.println("2. Solve a system of first-degree equations");
            System.out.println("3. Solve a second-degree equation");
            System.out.println("4. Exit");
            
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    solveLinearEquation();
                    break;
                case 2:
                    solveLinearSystem();
                    break;
                case 3:
                    solveQuadraticEquation();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

package employee;

import java.util.Scanner;

public class EmployeeDemo {

    private static final Scanner scanner = new Scanner(System.in);
    private static final EmployeeStorage storage = new EmployeeStorage();
    private static final int EXIT = 0;
    private static final int ADD_EMPLOYEE = 1;
    private static final int PRINT_ALL_EMPLOYEES = 2;
    private static final int SEARCH_EMPLOYEE_BY_ID = 3;
    private static final int SEARCH_EMPLOYEE_BY_COMPANY_NAME = 4;
    private static final int SEARCH_EMPLOYEES_BY_POSITION_LEVEL = 5;


    public static void main(String[] args) {

        boolean isRunning = true;

        while (isRunning) {
            printCommands();
            int command = Integer.parseInt(scanner.nextLine());

            switch (command) {
                case 0:
                    System.out.println("Program ended.");
                    isRunning = false;
                    break;

                case 1:
                    addEmployee();
                    break;

                case 2:
                    printAllEmployees();
                    break;

                case 3:
                    searchById();
                    break;

                case 4:
                    searchByCompany();
                    break;

                default:
                    System.out.println("Invalid command. Try again.");
            }
        }

        scanner.close();
    }

    private static void printCommands() {
        System.out.println("Please input" + EXIT + "for EXIT");
        System.out.println("Please input " + ADD_EMPLOYEE + " for ADD EMPLOYEE");
        System.out.println("Please input " + PRINT_ALL_EMPLOYEES + " for PRINT ALL EMPLOYEES");
        System.out.println("Please input " + SEARCH_EMPLOYEE_BY_ID + " for SEARCH EMPLOYEE BY ID");
        System.out.println("Please input " + SEARCH_EMPLOYEE_BY_COMPANY_NAME + " for SEARCH EMPLOYEE BY COMPANY NAME");
        System.out.println("Please input " + SEARCH_EMPLOYEES_BY_POSITION_LEVEL + " for SEARCH EMPLOYEES BY POSITION LEVEL");
    }

    private static void addEmployee() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter surname: ");
        String surname = scanner.nextLine();
        System.out.print("Enter employee ID (e.g., A0001): ");
        String id = scanner.nextLine();
        System.out.print("Enter salary: ");
        double salary = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter company: ");
        String company = scanner.nextLine();
        System.out.print("Enter position: ");
        String position = scanner.nextLine();
        System.out.print("Enter position level(JUNIOR, MIDDLE, LEAD): ");
        String levelStr = scanner.nextLine().toUpperCase();


        try {
            PositionLevel level = PositionLevel.valueOf(levelStr);
            Employee emp = new Employee();
            storage.add((EmployeeStorage.Employee) emp);
            System.out.println("Employee added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid position level. Please enter one of: JUNIOR, MIDDLE, SENIOR, LEAD");
        }
    }

    private static void printAllEmployees() {
        System.out.println("All Employees:");
        storage.printAll();
        System.out.println();
    }

    private static void searchById() {
        System.out.print("Enter employee ID: ");
        String searchId = scanner.nextLine();
        EmployeeStorage.Employee found = storage.getById(searchId);
        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("Employee not found with ID: " + searchId);
        }
        System.out.println();
    }

    private static void searchByCompany() {
        System.out.print("Enter company name: ");
        String companyName = scanner.nextLine();
        storage.searchByCompany(companyName);
        System.out.println();
    }

    private static void searchByPositionLevel() {
        System.out.print("Enter position level (JUNIOR, MIDDLE, SENIOR, LEAD): ");
        try {
            String levelStr = scanner.nextLine().trim().toUpperCase();
            PositionLevel level = PositionLevel.valueOf(levelStr);
            storage.searchByPositionLevel(level);
        } catch (IllegalArgumentException e) {
            System.out.println(" Invalid level. Try again.");
        }
    }

    protected static class PositionLevel {
        public static PositionLevel valueOf(String levelStr) {
            return null;
        }
    }
}


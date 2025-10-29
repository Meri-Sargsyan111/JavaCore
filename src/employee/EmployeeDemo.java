package employee;

import homeworks.employee.Commands;

import java.util.Scanner;

public class EmployeeDemo implements Commands {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EmployeeStorage storage = new EmployeeStorage();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            System.out.print("Մուտքագրիր հրամանը՝ ");
            int command = scanner.nextInt();
            scanner.nextLine(); // մաքրում է buffer-ը

            switch (command) {
                case EXIT:
                    System.out.println("Ծրագիրը ավարտվեց։");
                    return;
                case ADD_EMPLOYEE:
                    addEmployee();
                    break;
                case PRINT_ALL:
                    printAllEmployees();
                    break;
                case SEARCH_BY_ID:
                    searchByID();
                    break;
                case SEARCH_BY_COMPANY:
                    searchByCompany();
                    break;
                default:
                    System.out.println("Սխալ հրաման, փորձիր նորից։");
            }
        }
    }

    private static void printMenu() {
        System.out.println("""
                0 - Ելք
                1 - Ավելացնել աշխատող
                2 - Տպել բոլոր աշխատողներին
                3 - Գտնել աշխատող ID-ով
                4 - Գտնել աշխատողներին ըստ ընկերության
                """);
    }

    private static void addEmployee() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Surname: ");
        String surname = scanner.nextLine();
        System.out.print("Employee ID (օր.՝ A0001): ");
        String id = scanner.nextLine();

        if (storage.searchByID(id) != null) {
            System.out.println("Աշխատող այս ID-ով արդեն կա։");
            return;
        }

        System.out.print("Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Company: ");
        String company = scanner.nextLine();
        System.out.print("Position: ");
        String position = scanner.nextLine();

        Employee emp = new Employee(name, surname, id, salary, company, position);
        storage.add(emp);
        System.out.println("Աշխատողը հաջողությամբ ավելացվեց։");
    }

    private static void printAllEmployees() {
        storage.printAll();
    }

    private static void searchByID() {
        System.out.print("Մուտք արա աշխատողի ID-ն: ");
        String id = scanner.nextLine();
        Employee found = storage.searchByID(id);
        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("Այդպիսի աշխատող չկա։");
        }
    }

    private static void searchByCompany() {
        System.out.print("Մուտք արա ընկերության անունը: ");
        String company = scanner.nextLine();
        storage.searchByCompany(company);
    }
}


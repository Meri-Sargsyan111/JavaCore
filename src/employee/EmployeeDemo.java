package employee;

import java.util.Scanner;

public class EmployeeDemo {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            EmployeeStorage storage = new EmployeeStorage();

            while (true) {
                System.out.println("""
                    ՄԵՆՅՈՒ
                    0 - Exit
                    1 - Add employee
                    2 - Print all employees
                    3 - Search employee by ID
                    4 - Search employee by company
                    """);

                System.out.print("Ընտրիր հրամանը: ");
                int command = scanner.nextInt();
                scanner.nextLine(); // buffer clean

                switch (command) {
                    case 0:
                        System.out.println("Ծրագիրը ավարտվեց։");
                        return;

                    case 1:
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Surname: ");
                        String surname = scanner.nextLine();
                        System.out.print("Employee ID  ");
                        String id = scanner.nextLine();
                        System.out.print("Salary: ");
                        double salary = scanner.nextDouble();
                        scanner.nextLine(); // buffer clean
                        System.out.print("Company: ");
                        String company = scanner.nextLine();
                        System.out.print("Position: ");
                        String position = scanner.nextLine();

                        Employee emp = new Employee(name, surname, id, salary, company, position);
                        storage.add(emp);
                        System.out.println("Աշխատակիցը ավելացվեց։");
                        break;

                    case 2:
                        storage.printAll();
                        break;

                    case 3:
                        System.out.print("Մուտք արա աշխատողի ID-ն: ");
                        String idToSearch = scanner.nextLine();
                        Employee found = storage.searchByID(idToSearch);
                        if (found != null) {
                            System.out.println(found);
                        } else {
                            System.out.println("Այդպիսի աշխատող չկա։");
                        }
                        break;

                    case 4:
                        System.out.print("Մուտք արա ընկերության անունը: ");
                        String companyName = scanner.nextLine();
                        storage.searchByCompany(companyName);
                        break;

                    default:
                        System.out.println("Սխալ հրաման։ Փորձիր նորից։");
                        break;
                }
            }
        }
    }

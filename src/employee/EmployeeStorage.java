package employee;

public class EmployeeStorage {
    private Employee[] employees = new Employee[10];
    private int size = 0;

    public void add(Employee employee) {
        if (size == employees.length) {
            extend();
        }
        employees[size++] = employee;
    }

    private void extend() {
        Employee[] newArray = new Employee[employees.length + 10];
        System.arraycopy(employees, 0, newArray, 0, employees.length);
        employees = newArray;
    }

    public void printAll() {
        if (size == 0) {
            System.out.println("Առայժմ աշխատողներ չկան։");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public Employee searchByID(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equalsIgnoreCase(id)) {
                return employees[i];
            }
        }
        return null;
    }

    public void searchByCompany(String company) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (employees[i].getCompany().equalsIgnoreCase(company)) {
                System.out.println(employees[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Այդ ընկերությունում աշխատողներ չկան։");
        }
    }
}

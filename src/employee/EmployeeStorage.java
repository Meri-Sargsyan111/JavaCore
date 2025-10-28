package employee;

public class EmployeeStorage {

    public void add(Employee emp) {
    }

    public void printAll() {
    }

    public Employee searchByID(String id) {
        return null;
    }

    public void searchByCompany(String company) {

    }

    public class EmployeeStorage3 {
        private Employee[] employees = new Employee[10];
        private int size = 0;

        public void add(Employee employee) {
            if (size == employees.length) {
                extend();
            }

            employees[size++] = employee;
        }

        private void extend() {
            Employee[] tmp = new Employee[employees.length + 10];
            System.arraycopy(employees, 0, tmp, 0, employees.length);
            employees = tmp;
        }

        public void printAll() {
            for (int i = 0; i < size; i++) {
                System.out.println(employees[i]);
            }
        }

        public Employee searchByID(String id) {
            for (int i = 0; i < size; i++) {
                if (employees[i].getEmployeeID().equals(id)) {
                    return employees[i];
                }
            }
            return null;
        }

        public void searchByCompany(String companyName) {
            boolean found = false;
            for (int i = 0; i < size; i++) {
                if (employees[i].getCompany().equalsIgnoreCase(companyName)) {
                    System.out.println(employees[i]);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Այդ ընկերությունում աշխատող չկա։");
            }
        }
    }

}

package employee;

public class Employee {

        private String name;
        private String surname;
        private String employeeID;
        private double salary;
        private String company;
        private String position;
    private Employee Objects;

    public Employee(String name, String surname, String id, double salary, String company, String position) {
    }

    public void Employee() {
        }

        public void

        Employee(String name, String surname, String employeeID, double salary, String company, String position) {
            this.name = name;
            this.surname = surname;
            this.employeeID = employeeID;
            this.salary = salary;
            this.company = company;
            this.position = position;
        }

        public String getName() {return name; }
        public void setName(String name) { this.name = name; }

        public String getSurname() {return surname; }
        public void  setSurname(String name) {this.name = name; }

        public String getEmployeeID() {return employeeID;}
        public void setEmployeeID(String employeeID) {this.employeeID = employeeID; }

        public double getSalary() { return salary; }
        public void setSalary(double salary) { this.salary = salary; }

        public String getCompany() {return company; }
        public void setCompany(String company) {this.company = company; }

        public String getPosition() {return position; }
        public void setPosition(String position) {this.position = position; }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", employeeID='" + employeeID + '\'' +
                    ", salary=" + salary +
                    ", company='" + company + '\'' +
                    ", position='" + position + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return Objects.equals(employeeID, employee.employeeID);
        }

    private boolean equals(String employeeID, String employeeID1) {
        return false;
    }
    @Override
        public int hashCode() {
            return Objects.hash(employeeID);
        }

    private int hash(String employeeID) {
        return 0;
    }
}

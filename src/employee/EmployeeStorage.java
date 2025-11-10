package employee;
public class EmployeeStorage {

     public class Employee extends employee.Employee {
         private positionLevel positionLevel;

         public Employee(positionLevel positionLevel) {
             super();
             this.positionLevel = positionLevel;
         }

         public positionLevel getPositionLevel() {
             return positionLevel;
         }

         public String getEmployeeID() {
             return null;
         }

         public String getCompany() {
             return null;
         }

         public boolean getLevel() {
             return false;
         }
     }



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
         for (int i = 0; i < size; i++) {
             tmp[i] = employees[i];
         }
         employees = tmp;
     }

     public void printAll() {
         for (int i = 0; i < size; i++) {
             System.out.println(employees[i]);
         }
     }

     public Employee getById(String id) {
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
             System.out.println("No employees found for company: " + company);
         }
     }

     public void searchByPositionLevel(EmployeeDemo.PositionLevel level) {
         boolean found = false;
         for (int i = 0; i < size; i++) {
             employees[i].getLevel();
         }
         if (!found) {
             System.out.println("No employees found with position level: " + level);
         }
     }
 }



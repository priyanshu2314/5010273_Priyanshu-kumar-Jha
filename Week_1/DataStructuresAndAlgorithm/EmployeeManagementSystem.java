class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{employeeId=" + employeeId + ", name='" + name + "', position='" + position + "', salary=" + salary + "}";
    }
}

class EmployeeManager {
    private Employee[] employees;
    private int size;

    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(int employeeId, String name, String position, double salary) {
        if (size < employees.length) {
            employees[size++] = new Employee(employeeId, name, position, salary);
        } else {
            System.out.println("Employee array is full. Cannot add more employees.");
        }
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(int employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[--size] = null;
            System.out.println("Employee with ID " + employeeId + " has been deleted.");
        } else {
            System.out.println("Employee with ID " + employeeId + " not found.");
        }
    }

    public int getSize() {
        return size;
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager(10);

        employeeManager.addEmployee(1, "Priyanshu", "Software Engineer", 60000);
        employeeManager.addEmployee(2, "Sneha", "Manager", 80000);
        employeeManager.addEmployee(3, "Harshit", "UI Designer", 50000);
        employeeManager.addEmployee(4, "Rahul", "Tester", 40000);

        System.out.println("All Employees:");
        employeeManager.traverseEmployees();

        System.out.println("\nSearch for Employee with ID 2:");
        Employee employee = employeeManager.searchEmployee(2);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nDeleting Employee with ID 3:");
        employeeManager.deleteEmployee(3);

        System.out.println("\nAll Employees after deletion:");
        employeeManager.traverseEmployees();
    }
}

package com.spring.EmployeeSystem.Model;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

@Service
public class EmployeeService {

    private List<Employee> employees;

    @PostConstruct
    public void initializeEmployees() {
        employees = new ArrayList();
        
        // Initialize 10 hourly employees, 10 salaried employees, and 10 managers
        for (int i = 0; i < 10; i++) {
            employees.add(new HourlyEmployee());
            employees.add(new SalariedEmployee());
            employees.add(new Manager());
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void workForEmployee(int employeeIndex, int daysWorked) {
        if (employeeIndex >= 0 && employeeIndex < employees.size()) {
            Employee employee = employees.get(employeeIndex);
            employee.work(daysWorked);
        } else {
            throw new IndexOutOfBoundsException("Invalid employee index.");
        }
    }

    public void takeVacationForEmployee(int employeeIndex, float days) {
        if (employeeIndex >= 0 && employeeIndex < employees.size()) {
            Employee employee = employees.get(employeeIndex);
            employee.takeVacation(days);
        } else {
            throw new IndexOutOfBoundsException("Invalid employee index.");
        }
    }
}

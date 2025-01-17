package com.spring.EmployeeSystem.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.EmployeeSystem.Model.Employee;
import com.spring.EmployeeSystem.Model.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get the list of all employees
    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    // Work for a specific employee (by index)
    @PostMapping("/{employeeIndex}/work")
    public void work(@PathVariable int employeeIndex, @RequestParam int daysWorked) {
        employeeService.workForEmployee(employeeIndex, daysWorked);
    }

    // Take vacation for a specific employee (by index)
    @PostMapping("/{employeeIndex}/vacation")
    public void takeVacation(@PathVariable int employeeIndex, @RequestParam float days) {
        employeeService.takeVacationForEmployee(employeeIndex, days);
    }
}

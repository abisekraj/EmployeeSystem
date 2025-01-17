package com.spring.EmployeeSystem.Model;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class EmployeeServiceTest {

    @Mock
    private EmployeeService employeeService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testWorkForEmployee() {
        Employee hourlyEmployee = new HourlyEmployee();
        employeeService.workForEmployee(0, 100);
        
        assertEquals(10 * 100 / 260, hourlyEmployee.getVacationDays());
    }

    @Test
    public void testTakeVacationForEmployee() {
        Employee salariedEmployee = new SalariedEmployee();
        salariedEmployee.work(100); // 100 days worked

        salariedEmployee.takeVacation(5);
        assertEquals(15 * 100 / 260 - 5, salariedEmployee.getVacationDays());
    }

    @Test
    public void testInvalidVacation() {
        final Employee manager = new Manager();
        manager.work(100); // 100 days worked
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
        		() -> {manager.takeVacation(20);  // Trying to take more vacation than accumulated
        });

        assertEquals("Insufficient vacation days or invalid number.", exception.getMessage());
    }
}

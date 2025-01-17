package com.spring.EmployeeSystem.Model;

public class Manager extends SalariedEmployee {
    public Manager() {
        super(); // Managers accumulate 30 vacation days (inherited behavior)
    }

    @Override
    public void work(int daysWorked) {
        super.work(daysWorked);  // Managers work similarly to salaried employees
    }
}
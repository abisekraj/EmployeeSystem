package com.spring.EmployeeSystem.Model;

public class SalariedEmployee extends Employee {
    public SalariedEmployee() {
        super(15); // Salaried employees accumulate 15 vacation days
    }
}
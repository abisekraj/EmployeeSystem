package com.spring.EmployeeSystem.Model;

public class HourlyEmployee extends Employee {
    public HourlyEmployee() {
        super(10); // Hourly employees accumulate 10 vacation days
    }
}
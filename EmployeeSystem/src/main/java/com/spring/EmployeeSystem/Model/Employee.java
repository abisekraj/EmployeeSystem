package com.spring.EmployeeSystem.Model;

public abstract class Employee {
	private float vacationDays = 0; // Not writable externally, initialized to 0
	protected float vacationRate; // The vacation rate varies based on the type
									// of employee

	// Constructor
	public Employee(float vacationRate) {
		this.vacationRate = vacationRate;
	}

	// Method to work for a given number of days
	public void work(int daysWorked) {
		if (daysWorked < 0 || daysWorked > 260) {
			throw new IllegalArgumentException("Days worked must be between 0 and 260.");
		}
		vacationDays += daysWorked * vacationRate / 260; // Accumulate vacation
															// days
	}

	// Method to take vacation days
	public void takeVacation(float days) {
		if (days < 0 || days > vacationDays) {
			throw new IllegalArgumentException("Insufficient vacation days or invalid number.");
		}
		vacationDays -= days; // Deduct vacation days
	}

	// Getter for vacationDays
	public float getVacationDays() {
		return vacationDays;
	}
}

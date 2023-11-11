package com.sirma.utils;

import com.sirma.entities.Department;
import com.sirma.entities.Employee;
import com.sirma.entities.Role;

import java.time.LocalDate;

public class EmployeeCreator {
    public static Employee addEmployee(int ID, String name, LocalDate startDate, LocalDate endDate, Department department, Role role, double salary) {
        if (ID < 0 || salary < 0) {
            throw new IllegalArgumentException("Salary or ID can't be a negative number.");
        }

        if (name == null || startDate == null || department == null || role == null) {
            throw new IllegalArgumentException("Not enough parameters.");
        }

        return new Employee(ID, name, startDate, endDate, department, role, salary);
    }

    public static Employee addEmployee(int ID, String name, LocalDate startDate, Department department, Role role, double salary) {
        if (ID < 0 || salary < 0) {
            throw new IllegalArgumentException("Salary or ID can't be a negative number.");
        }

        if (name == null || startDate == null || department == null || role == null) {
            throw new IllegalArgumentException("Not enough parameters.");
        }

        return new Employee(ID, name, startDate, department, role, salary);
    }
}

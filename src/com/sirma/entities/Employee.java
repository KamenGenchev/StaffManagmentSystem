package com.sirma.entities;

import java.time.LocalDate;

public class Employee {
    private final int ID;
    private final String name;
    private final LocalDate startDate;

    @Override
    public String toString() {
        return "Employee: " +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", department=" + department +
                ", role=" + role +
                ", salary=" + salary;
    }

    private LocalDate endDate;
    private final Department department;
    private final Role role;

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Department getDepartment() {
        return department;
    }

    public Role getRole() {
        return role;
    }

    public double getSalary() {
        return salary;
    }

    private final double salary;

    public Employee(int ID, String name, LocalDate startDate, Department department, Role role, double salary) {
        this.ID = ID;
        this.name = name;
        this.startDate = startDate;
        this.department = department;
        this.role = role;
        this.salary = salary;
        this.endDate = null;
    }

    public Employee(int ID, String name, LocalDate startDate, LocalDate endDate, Department department, Role role, double salary) {
        this.ID = ID;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.department = department;
        this.role = role;
        this.salary = salary;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}

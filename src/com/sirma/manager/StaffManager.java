package com.sirma.manager;

import com.sirma.cli.UserInterface;
import com.sirma.entities.Department;
import com.sirma.entities.Employee;
import com.sirma.entities.Role;
import com.sirma.utils.EmployeeCreator;
import com.sirma.utils.SearchUtil;

import java.time.LocalDate;

public class StaffManager extends Manager {
    public StaffManager(Service service) {
        super(service);
    }

    @Override
    public void execute(int command) {
        switch (command) {
            case 1:
                addEmployee();
            case 2:
                edit();
            case 3:
                listEmployees();
            case 4:
                searchName();
            case 5:
                searchID();
            case 6:
                searchDepartment();
            case 7:
                fire();
            case 0:
                saveAndExit();
        }
    }

    private void addEmployee() {
        System.out.println("Adding a new employee:");

        System.out.println("Enter ID:");
        int ID = UserInterface.getIntegerInput();

        System.out.println("Enter Name:");
        String name = UserInterface.getInput();

        LocalDate startDate = LocalDate.now();

        System.out.println("Enter Department");
        Department department = Department.valueOf(UserInterface.getInput());

        System.out.println("Enter Role:");
        Role role = Role.valueOf(UserInterface.getInput());

        System.out.println("Enter Salary:");
        double salary = UserInterface.getDoubleInput();

        EmployeeCreator.addEmployee(ID, name, startDate, department, role, salary);
        System.out.println("Employee added successfully!");

    }


    private void edit() {
        System.out.println("Enter ID: ");
        int ID = UserInterface.getIntegerInput();
        if (StaffService.getMap().containsKey(ID)) {
            // UNFINISHED TODO
            addEmployee();
        } else {
            System.out.println("Employee with ID " + ID + " not found.");
        }
    }

  /*  private void editMenu() {
        System.out.println("Select what to edit:");

        System.out.println("""
                1. ID\s
                2. Name\s
                3. Department\s
                4. Role \s
                5. Salary\s
                """);
        int input = UserInterface.getIntegerInput();

        switch (input) {
            System.out.println();
        }


    }
*/

    private void listEmployees() {
        for (Employee employee : StaffService.getMap().values()) {
            System.out.println(employee);
        }
    }

    private void searchName() {
        System.out.println("Enter name: ");
        String name = UserInterface.getInput();

        System.out.println(SearchUtil.searchName(name).isEmpty() ? "No employees found!" : SearchUtil.searchName(name));

    }

    private void searchID() {
        System.out.println("Enter ID:");
        int ID = UserInterface.getIntegerInput();
        if (StaffService.getMap().containsKey(ID)) {
            System.out.println(StaffService.getMap().get(ID));

        } else {
            System.out.println("Employee with ID " + ID + " not found.");
        }
    }

    private void searchDepartment() {
        System.out.println("Enter Department:");
        Department department = Department.valueOf(UserInterface.getInput());

        System.out.println(SearchUtil.searchDepartment(department).isEmpty() ? "No employees found!" : SearchUtil.searchDepartment(department));
    }

    private void fire() {
        System.out.println("Enter ID:");
        int ID = UserInterface.getIntegerInput();

        if (!StaffService.getMap().containsKey(ID)) {
            System.out.println("Employee with ID " + ID + " not found.");

        } else if (StaffService.getMap().get(ID).getEndDate() != null) {
            System.out.println("Can't fire already fired employee");

        } else {
            StaffService.getMap().get(ID).setEndDate(LocalDate.now());
        }
    }

    private void saveAndExit() {
        StaffService.saveValues();
    }

}

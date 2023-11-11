package com.sirma.manager;

import com.sirma.entities.Department;
import com.sirma.entities.Employee;
import com.sirma.utils.EmployeeCreator;
import com.sirma.entities.Role;
import com.sirma.fileio.*;

import java.time.LocalDate;
import java.util.*;

import static com.sirma.utils.ResourcesFiles.EMPLOYEES_CSV;

public class StaffService implements Service {
    private final CsvReader reader;
    private static CsvWriter writer;
    protected static Map<Integer, Employee> map = new HashMap<>();
    private final List<Employee> employeeList;


    public StaffService(CsvReader reader, CsvWriter writer) {
        this.reader = reader;
        this.writer = writer;
        this.employeeList = new ArrayList<>();
    }

    @Override
    public void getInitialValues() {
        List<String[]> employeeData = reader.readDataFile(EMPLOYEES_CSV);

        if (employeeData.isEmpty()) {
            return;
        }

        for(String[] data: employeeData) {
            try {
                int ID = Integer.parseInt(data[0]);
                String name = data[1];
                LocalDate startDate = LocalDate.parse(data[2]);
                LocalDate endDate = LocalDate.parse(data[3]);
                Department department = Department.valueOf(data[4]);
                Role role = Role.valueOf(data[5]);
                double salary = Double.parseDouble(data[6]);

                Employee employee = EmployeeCreator.addEmployee(ID, name, startDate, endDate, department, role, salary);
                employeeList.add(employee);

            } catch (Exception e) {
                throw new RuntimeException("Error in creating employee from data");
            }
        }

    }


    public static void saveValues() {
        List<String[]> employeeExitData = new ArrayList<>();

        for (Employee employee : map.values()) {
            String[] employeeData = new String[7];
            employeeData[0] = String.valueOf(employee.getID());
            employeeData[1] = employee.getName();
            employeeData[2] = employee.getStartDate().toString();
            employeeData[3] = employee.getEndDate().toString();
            employeeData[4] = employee.getDepartment().toString();
            employeeData[5] = employee.getRole().toString();
            employeeData[6] = String.valueOf(employee.getSalary());
            employeeExitData.add(employeeData);
        }

        writer.writeDataFile(employeeExitData, EMPLOYEES_CSV);
    }

    @Override
    public void populate() {
        if (employeeList.isEmpty()) {
            return;
        }

        for (Employee employee : employeeList) {
            map.put(employee.getID(), employee);
        }
    }

    public static Map<Integer,Employee> getMap() {
        return map;
    }
}

package com.sirma.utils;

import com.sirma.entities.Department;
import com.sirma.entities.Employee;
import com.sirma.manager.StaffService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchUtil {
    private static Map<Integer, Employee> employeeMap;
    private static final Map<String, Employee> employeeMapByName = new HashMap<>();
    private static final Map<Department, Employee> employeeMapByDepartment = new HashMap<>();


    public static List<Employee> searchName(String name) {
        employeeMap = StaffService.getMap();
        for (Employee employee : employeeMap.values()) {
            employeeMapByName.put(employee.getName(), employee);
        }

        List<Employee> matchingEmployees = new ArrayList<>();

        for (Employee employee : employeeMapByDepartment.values()) {
            if (employee.getName().equals(name)) {
                matchingEmployees.add(employee);
            }
        }
        return matchingEmployees;
    }

    public static List<Employee> searchDepartment(Department department) {
        employeeMap = StaffService.getMap();
        for (Employee employee : employeeMap.values()) {
            employeeMapByDepartment.put(employee.getDepartment(), employee);
        }
        List<Employee> matchingEmployees = new ArrayList<>();

        for (Employee employee : employeeMapByDepartment.values()) {
            if (employee.getDepartment().equals(department)) {
                matchingEmployees.add(employee);
            }
        }
        return matchingEmployees;
    }



}

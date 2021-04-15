package com.ifmo.jjd.lesson13.employee;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class EmployeeTask {
    public static void main(String[] args) {
        List<Employee> employees = Employee.employeeGenerator(20);


        // сортировка по имени
        Comparator<Employee> nameComparator = new Employee.NameComparator()
                .thenComparing(new Employee.FinalComparator());
        TreeSet<Employee> nameSortingEmployeeList = new TreeSet<>(nameComparator);
        nameSortingEmployeeList.addAll(employees);


        // сортировка по имени и зарплате
        Comparator<Employee> nameAndSalaryComparator = new Employee.NameComparator()
                .thenComparing(new Employee.SalaryComparator())
                .thenComparing(new Employee.FinalComparator());
        TreeSet<Employee> nameAndSalarySortingEmployeeList = new TreeSet<>(nameAndSalaryComparator);
        nameAndSalarySortingEmployeeList.addAll(employees);


        // сортировка по имени, зарплате, возрасту и компании
        Comparator<Employee> nameSalaryAgeCompanyComparator = new Employee.NameComparator()
                .thenComparing(new Employee.SalaryComparator())
                .thenComparing(new Employee.AgeComparator())
                .thenComparing(new Employee.CompanyComparator())
                .thenComparing(new Employee.FinalComparator());
        TreeSet<Employee> nameSalaryAgeCompanySortingEmployeeList = new TreeSet<>(nameSalaryAgeCompanyComparator);
        nameSalaryAgeCompanySortingEmployeeList.addAll(employees);


        System.out.println("По имени");
        System.out.println(nameSortingEmployeeList);

        System.out.println("По имени и зарплате");
        System.out.println(nameAndSalarySortingEmployeeList);


        System.out.println("По имени, зарплате, возрасту и компании");
        System.out.println(nameSalaryAgeCompanySortingEmployeeList);

    }
}

package com.ifmo.jjd.lesson13.employee;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class EmployeeTask {
    public static void main(String[] args) {
        List<Employee> employees = Employee.employeeGenerator(20);

        // сортировка по имени
        Comparator<Employee> employeeNameComparator = new Employee.OnlyNameComparator();
        TreeSet<Employee> nameSortingEmployeeList = new TreeSet<>(employeeNameComparator);
        nameSortingEmployeeList.addAll(employees);
        System.out.println("По имени");
        System.out.println(nameSortingEmployeeList);

        // сортировка по имени и зарплате
        Comparator<Employee> employeeNameAndSalaryComparator = new Employee.NameComparator()
                .thenComparing(new Employee.SalaryComparator());
        TreeSet<Employee> nameAndSalarySortingEmployeeList = new TreeSet<>(employeeNameAndSalaryComparator);
        nameAndSalarySortingEmployeeList.addAll(employees);
        System.out.println("По имени и зарплате");
        System.out.println(nameAndSalarySortingEmployeeList);


        // сортировка по имени, зарплате, возрасту и компании
        Comparator<Employee> employeeNameSalaryAgeCompanyComparator = new Employee.NameComparator()
                .thenComparing(new Employee.SalaryComparator())
                .thenComparing(new Employee.AgeComparator())
                .thenComparing(new Employee.CompanyComparator());
        TreeSet<Employee> nameSalaryAgeCompanySortingEmployeeList = new TreeSet<>(employeeNameSalaryAgeCompanyComparator);
        nameSalaryAgeCompanySortingEmployeeList.addAll(employees);
        System.out.println("По имени, зарплате, возрасту и компании");
        System.out.println(nameSalaryAgeCompanySortingEmployeeList);

    }
}

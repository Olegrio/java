package com.ifmo.jjd.lesson13.employee;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;

    // TODO: конструктор, геттеры и сеттеры

    public Employee(String name, String company, int salary, int age) {
        this.name = name;
        this.company = company;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary &&
                age == employee.age &&
                Objects.equals(name, employee.name) &&
                Objects.equals(company, employee.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, company, salary, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "name -> Employee null");
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = Objects.requireNonNull(company, "company -> Employee null");;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int random(int min, int max){
        return (int)((Math.random() * (max - min + 1)) + min);
    }

    public static List<Employee> employeeGenerator(int num) {
        // метод для создания списка объектов класса Employee
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний
        int minAge = 21, maxAge = 60;
        int minSalary = 15000, maxSalary = 100000;
        int randomAge;
        int randomNameIndex;
        int randomCompanyIndex;
        int randomSalary;


        List<Employee> employees = new ArrayList<>(num);

        // добавление num объектов Employee в список (employees)
        for (int i = 0; i < num; i++) {
            randomCompanyIndex = random(0, companies.length - 1);
            randomNameIndex = random(0, names.length - 1);
            randomSalary = random(minSalary, maxSalary);
            randomAge = random(minAge, maxAge);

            employees.add(new Employee(names[randomNameIndex], companies[randomCompanyIndex], randomSalary, randomAge)); // TODO: объекты создавать с рандомными значениями. Возраст от 21 до 60 и не забудьте про зп
        }
        return employees;
    }

    public static class NameComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.name.compareToIgnoreCase(o2.name);
        }
    }

    public static class OnlyNameComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.name.compareToIgnoreCase(o2.name) == 0
                    ? -1
                    : o1.name.compareToIgnoreCase(o2.name);
        }
    }

    public static class CompanyComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.company.compareToIgnoreCase(o2.company);
        }
    }

    public static class SalaryComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.salary, o2.salary);
        }
    }

    public static class AgeComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.age, o2.age);
        }
    }
}
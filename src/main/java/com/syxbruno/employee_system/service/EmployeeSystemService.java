package com.syxbruno.employee_system.service;

import com.syxbruno.employee_system.dto.EmployeeResponse;
import com.syxbruno.employee_system.mapper.Mapper;
import com.syxbruno.employee_system.model.Employee;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeSystemService {

  Mapper mapper = Mapper.getInstance();
  private final List<Employee> employees = new ArrayList<>();

  public void addEmployees(String path) {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    try(BufferedReader reader = new BufferedReader(new FileReader(path))) {

      String line;

      while((line = reader.readLine()) != null) {

        String[] split = line.split(",");

        String name = split[0];
        LocalDate dateBirth = LocalDate.parse(split[1], dateTimeFormatter);
        BigDecimal wage = new BigDecimal(split[2]);
        String function = split[3];

        employees.add(new Employee(name, dateBirth, wage, function));
      }

      System.out.println("Employees added to the list successfully");

    } catch (IOException e) {

      e.printStackTrace();
    }
  }


  public void removeJoao() {

    boolean removed = employees.removeIf(employee -> employee.getName().equalsIgnoreCase("Joao"));

    if (removed) {

      System.out.println("Employee Joao has been deleted from the list");
      return;
    }

    System.out.println("There is no employee named joao on the list");
  }

  public void printAllEmployees() {

    for (Employee e : employees) {

      EmployeeResponse employeeResponse = mapper.employeeToEmployeeResponse(e);
      System.out.println(employeeResponse);
    }
  }

  public void applyIncrease() {

    for (Employee e : employees) {

      BigDecimal wageIncreased = e.getWage().multiply(new BigDecimal("1.10"));
      e.setWage(wageIncreased);
    }
  }

  public void printGroupsFunction() {

    Map<String, List<Employee>> map = employees.stream()
        .collect(Collectors.groupingBy(Employee::getFunction));

    for (Map.Entry<String, List<Employee>> entry : map.entrySet()) {

      String function = entry.getKey();
      System.out.println("Function: " + function);

      for (Employee e : entry.getValue()) {

        EmployeeResponse employeeResponse = mapper.employeeToEmployeeResponse(e);
        System.out.println(employeeResponse);
      }
    }
  }

  public void printDateBirthOctDec() {

    for (Employee e : employees) {

      int month = e.getDateBirth().getMonthValue();

      if (month == 10 || month == 12) {

        EmployeeResponse employeeResponse = mapper.employeeToEmployeeResponse(e);
        System.out.println(employeeResponse);
      }
    }
  }

  public void printOldEmployee() {

    if (employees.isEmpty()) {

      System.out.println("The list is empty, add elements to the list to use this method");
      return;
    }

    Employee old = employees.getFirst();

    for (Employee e : employees) {

      if (e.getDateBirth().isBefore(old.getDateBirth())) {

        old = e;
      }
    }

    int years = Period.between(old.getDateBirth(), LocalDate.now()).getYears();

    System.out.println(
        "Name: " + old.getName() + ", Age: " + years
    );
  }

  public void sortEmployees() {

    employees.stream()
        .sorted(Comparator.comparing(Employee::getName))
        .map(e -> mapper.employeeToEmployeeResponse(e))
        .forEach(System.out::println);
  }

  public void printTotalWage() {

    BigDecimal total = employees.stream()
        .map(Employee::getWage)
        .reduce(BigDecimal.ZERO, BigDecimal::add);

    System.out.println("Sum of all salaries: " + total);
  }

  public void printMinWage() {

    BigDecimal minWage = new BigDecimal("1518.00");

    employees.stream()
        .forEach(e -> {

          BigDecimal amout = e.getWage().divide(minWage, 2, RoundingMode.HALF_UP);
          System.out.println("Name: " + e.getName() + ", Minimum wages: " + amout);
        });
  }
}


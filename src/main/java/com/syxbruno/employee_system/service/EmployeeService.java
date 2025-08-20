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
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeeService {

  private final List<Employee> employees;
  Mapper mapper = Mapper.getInstance();

  public void addEmployees(String path) {

    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

      String line;
      DateTimeFormatter standard = DateTimeFormatter.ofPattern("dd-MM-yyyy");

      while ((line = reader.readLine()) != null) {

        String[] split = line.split(",");

        String name = split[0];
        LocalDate dateBirth = LocalDate.parse(split[1], standard);
        BigDecimal wage = new BigDecimal(split[2]);
        String function = split[3];

        employees.add(new Employee(name, dateBirth, wage, function));
      }

      System.out.println("Employees added to the list successfully");

    } catch (IOException e) {

      throw new RuntimeException("Failed to read employees file: " + path, e);
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

    employees.stream()
        .map(mapper::employeeToEmployeeResponse)
        .forEach(System.out::println);
  }

  public void applyIncrease() {

    employees
        .forEach(e -> {

          BigDecimal wageIncreased = e.getWage().multiply(new BigDecimal("1.10"));
          e.setWage(wageIncreased);
        });
  }

  public void printGroupsFunction() {

    Map<String, List<Employee>> map = employees.stream()
        .collect(Collectors.groupingBy(Employee::getFunction));

    for (Map.Entry<String, List<Employee>> entry : map.entrySet()) {

      String function = entry.getKey();
      System.out.println("Function: " + function);

      entry.getValue().stream()
          .map(mapper::employeeToEmployeeResponse)
          .forEach(System.out::println);
    }
  }

  public void printDateBirthOctDec() {

    employees.stream()
        .filter(e -> {

          int month = e.getDateBirth().getMonthValue();

          return month == 10 || month == 12;
        })
        .map(mapper::employeeToEmployeeResponse)
        .forEach(System.out::println);
  }

  public void printOldEmployee() {

    Employee old = employees.stream()
        .min(Comparator.comparing(Employee::getDateBirth))
        .orElseThrow(() -> new RuntimeException("The list is empty, add elements to the list to use this method"));

    int years = Period.between(old.getDateBirth(), LocalDate.now()).getYears();
    EmployeeResponse oldEmployee = mapper.employeeToEmployeeResponse(old);

    System.out.println(oldEmployee + ", Age: " + years);
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

    employees
        .forEach(e -> {

          BigDecimal amout = e.getWage().divide(minWage, 2, RoundingMode.HALF_UP);
          System.out.println("Name: " + e.getName() + ", Minimum wages: " + amout);
        });
  }
}
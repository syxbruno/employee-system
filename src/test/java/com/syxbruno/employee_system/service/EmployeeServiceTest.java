package com.syxbruno.employee_system.service;

import com.syxbruno.employee_system.model.Employee;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeServiceTest {

  private EmployeeService service;
  private final List<Employee> employees = new ArrayList<>();

  @BeforeEach
  void setUp() {

    service = new EmployeeService(employees);
  }

  @Test
  public void addEmployeesWhenExistsPath() {

    service.addEmployees("src/test/resources/employeesForTests.txt");

    Assertions.assertEquals(2, employees.size());

    Assertions.assertEquals("Maria", employees.get(0).getName());
    Assertions.assertEquals("Joao", employees.get(1).getName());
  }

  @Test
  public void addEmployeesWhenNotFoundPath() {

    RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {

      service.addEmployees("nonExistent.txt");
    });

    Assertions.assertTrue(exception.getMessage().contains("Failed to read employees file: "));
  }

  @Test
  public void removeJoaoWhenExists() {

    service.addEmployees("src/test/resources/employeesForTests.txt");

    service.removeJoao();

    Assertions.assertEquals(1, employees.size());
    Assertions.assertEquals("Maria", employees.getFirst().getName());
  }

  @Test
  public void removeJoaoWhenNotFound() {

    employees.add(new Employee("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));

    service.removeJoao();

    Assertions.assertEquals(1, employees.size());
    Assertions.assertEquals("Maria", employees.getFirst().getName());
  }

  @Test
  public void applyIncrease() {

    employees.add(new Employee("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));

    BigDecimal mariaWage = employees.getFirst().getWage();
    BigDecimal increase = new BigDecimal("1.10");
    BigDecimal expected = mariaWage.multiply(increase);

    service.applyIncrease();

    Assertions.assertEquals(expected, employees.getFirst().getWage());
  }
}
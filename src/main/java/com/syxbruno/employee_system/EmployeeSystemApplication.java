package com.syxbruno.employee_system;

import com.syxbruno.employee_system.model.Employee;
import com.syxbruno.employee_system.service.EmployeeService;
import java.util.ArrayList;

public class EmployeeSystemApplication {

  public static void main(String[] args) {

    ArrayList<Employee> employees = new ArrayList<>();
    EmployeeService service = new EmployeeService(employees);

    service.addEmployees("src/main/resources/employees.txt");
    System.out.println("________________________________________");
    service.removeJoao();
    System.out.println("________________________________________");
    service.printAllEmployees();
    System.out.println("________________________________________");
    service.applyIncrease();
    service.printAllEmployees();
    System.out.println("________________________________________");
    service.printGroupsFunction();
    System.out.println("________________________________________");
    service.printDateBirthOctDec();
    System.out.println("________________________________________");
    service.printOldEmployee();
    System.out.println("________________________________________");
    service.sortEmployees();
    System.out.println("________________________________________");
    service.printTotalWage();
    System.out.println("________________________________________");
    service.printMinWage();
  }
}

package com.syxbruno.employee_system;

import com.syxbruno.employee_system.service.EmployeeService;

public class EmployeeSystemApplication {

	public static void main(String[] args) {

    EmployeeService service = new EmployeeService();

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

package com.syxbruno.employee_system.dto;

import lombok.Builder;

@Builder
public class EmployeeResponse {

  private String name;
  private String dateBirth;
  private String wage;
  private String function;

  @Override
  public String toString() {

    return "Name: " + name + ", Date Birth: " + dateBirth + ", Wage: " + wage + ", Function: " + function;
  }
 }

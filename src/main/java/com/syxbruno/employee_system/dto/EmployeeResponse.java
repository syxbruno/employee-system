package com.syxbruno.employee_system.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

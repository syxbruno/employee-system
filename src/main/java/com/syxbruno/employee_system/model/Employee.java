package com.syxbruno.employee_system.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee extends Person {

  private BigDecimal wage;
  private String function;

  public Employee(String name, LocalDate datebirth, BigDecimal wage, String function) {
    super(name, datebirth);
    this.wage = wage;
    this.function = function;
  }
}

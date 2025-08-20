package com.syxbruno.employee_system.mapper;

import com.syxbruno.employee_system.dto.EmployeeResponse;
import com.syxbruno.employee_system.model.Employee;
import com.syxbruno.employee_system.utils.Formatter;
import java.util.Objects;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Mapper {

  private static Mapper instance;
  Formatter formatter = Formatter.getInstance();

  public synchronized static Mapper getInstance() {

    if (Objects.isNull(instance)) {

      instance = new Mapper();
    }

    return instance;
  }

  public EmployeeResponse employeeToEmployeeResponse(Employee employee) {

    String dateBirth = formatter.formatDateBirth(employee.getDateBirth());
    String wage = formatter.formatWage(employee.getWage());

    return EmployeeResponse.builder()
        .name(employee.getName())
        .dateBirth(dateBirth)
        .wage(wage)
        .function(employee.getFunction())
        .build();
  }
}

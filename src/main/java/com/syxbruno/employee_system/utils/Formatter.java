package com.syxbruno.employee_system.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Formatter {

  private static Formatter instance;

  public synchronized static Formatter getInstance() {

    if(Objects.isNull(instance)) {

      instance = new Formatter();
    }

    return instance;
  }

  public String formatWage(BigDecimal wage) {

    NumberFormat numberFormatter = NumberFormat.getInstance(Locale.of("pt", "BR"));
    numberFormatter.setMinimumFractionDigits(2);
    numberFormatter.setMaximumFractionDigits(2);

    return numberFormatter.format(wage);
  }

  public String formatDateBirth(LocalDate dateBirth) {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return dateTimeFormatter.format(dateBirth);
  }
}

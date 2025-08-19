package com.syxbruno.employee_system.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

public class FormatterTest {

  private final Formatter formatter = Formatter.getInstance();

  @Test
  public void formatWage() {

    BigDecimal wage = new BigDecimal("124324.3874");
    String wageFormatted = formatter.formatWage(wage);

    String expected = "124.324,39";

    Assert.assertEquals(expected, wageFormatted);
  }

  @Test
  public void formatDateBirth() {

    LocalDate date = LocalDate.of(1999, 8, 29);
    String dateFormatted = formatter.formatDateBirth(date);

    String expected = "29/08/1999";

    Assert.assertEquals(expected, dateFormatted);
  }
}
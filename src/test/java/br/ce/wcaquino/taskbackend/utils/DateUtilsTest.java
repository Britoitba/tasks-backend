package br.ce.wcaquino.taskbackend.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DateUtilsTest {

    @Test
    public void shouldReturnTrueforFutureDate() {
        LocalDate date = LocalDate.of(2030, 01, 01);
        Assertions.assertEquals(true, DateUtils.isEqualOrFutureDate(date));
    }

    @Test
    public void shouldReturnFalseforPastDate() {
        LocalDate date = LocalDate.of(2010, 01, 01);
        Assertions.assertEquals(false, DateUtils.isEqualOrFutureDate(date));
    }

    @Test
    public void shouldReturnTrueforActualDate() {
        Assertions.assertEquals(true, DateUtils.isEqualOrFutureDate(LocalDate.now()));
    }

}
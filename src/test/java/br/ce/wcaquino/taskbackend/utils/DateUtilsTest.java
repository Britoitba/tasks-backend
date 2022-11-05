package br.ce.wcaquino.taskbackend.utils;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class DateUtilsTest {

    @Test
    public void shouldReturnTrueforFutureDate() {
        LocalDate date = LocalDate.of(2030, 01, 01);
        Assert.assertEquals(true, DateUtils.isEqualOrFutureDate(date));
    }

    @Test
    public void shouldReturnFalseforPastDate() {
        LocalDate date = LocalDate.of(2010, 01, 01);
        Assert.assertEquals(false, DateUtils.isEqualOrFutureDate(date));
    }

    @Test
    public void shouldReturnTrueforActualDate() {
        Assert.assertEquals(true, DateUtils.isEqualOrFutureDate(LocalDate.now()));
    }

}
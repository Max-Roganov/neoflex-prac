package ru.neoflex.roganov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FractionTest {
    @Test
    void sum() {
        Assertions.assertAll("sum",
                () -> Assertions.assertEquals("1 1/3", Fraction.sum(new Fraction("2/3"), new Fraction("2/3")).toString()),
                () -> Assertions.assertEquals("-1", Fraction.sum(new Fraction("-5/3"), new Fraction("2/3")).toString()),
                () -> Assertions.assertEquals("2 53/77", Fraction.sum(new Fraction("15/7"), new Fraction("6/11")).toString())
        );
    }
    @Test
    void difference() {
        Assertions.assertAll("difference",
                () -> Assertions.assertEquals("0", Fraction.difference(new Fraction("2/3"), new Fraction("2/3")).toString()),
                () -> Assertions.assertEquals("-2 1/3", Fraction.difference(new Fraction("-5/3"), new Fraction("2/3")).toString()),
                () -> Assertions.assertEquals("1 46/77", Fraction.difference(new Fraction("15/7"), new Fraction("6/11")).toString())
        );
    }
    @Test
    void mult() {
        Assertions.assertAll(
                () -> Assertions.assertEquals("4/9", Fraction.mult(new Fraction("2/3"), new Fraction("2/3")).toString()),
                () -> Assertions.assertEquals("-1 1/9", Fraction.mult(new Fraction("-5/3"), new Fraction("2/3")).toString()),
                () -> Assertions.assertEquals("1 13/77", Fraction.mult(new Fraction("15/7"), new Fraction("6/11")).toString())
        );
    }
    @Test
    void division() {
        Assertions.assertAll(
                () -> Assertions.assertEquals("1", Fraction.division(new Fraction("2/3"), new Fraction("2/3")).toString()),
                () -> Assertions.assertEquals("-2 1/2", Fraction.division(new Fraction("-5/3"), new Fraction("2/3")).toString()),
                () -> Assertions.assertEquals("3 13/14", Fraction.division(new Fraction("15/7"), new Fraction("6/11")).toString())
        );
    }
}

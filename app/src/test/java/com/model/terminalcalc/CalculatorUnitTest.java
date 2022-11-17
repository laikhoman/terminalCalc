package com.model.terminalcalc;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CalculatorUnitTest {
    @Test
    public void add_isCorrect() {
        assertEquals(18, new Calculator().add("5, 2, 3, 5, 3"), 0);
    }
    @Test
    public void subtract_isCorrect() {
        assertEquals(12, new Calculator().subtract("25, 2, 3, 5, 3"),0);
    }
    @Test
    public void multiply_isCorrect() {
        assertEquals(120, new Calculator().multiply("2, 4, 3, 5"), 0);
    }
    @Test
    public void divide_isCorrect() {
        assertEquals(4, new Calculator().divide(17, 4), 0);
    }
    @Test
    public void splitEq_isCorrect() {
        assertEquals("valid", new Calculator().splitEq(120, 4), "30, 30, 30, 30");
    }
    @Test
    public void splitNum_isCorrect() {
        assertEquals(40, new Calculator().splitNum("140, 45, 35, 20"),0);
    }
}
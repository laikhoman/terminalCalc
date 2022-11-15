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
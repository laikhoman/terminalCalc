package com.model.terminalcalc;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    public int add(String param) {
        List<String> numberList = Arrays.asList(param.split(", "));
        Integer value = 0;
        for(int i = 0; i<numberList.size(); i++){
            Integer currentVal = Integer.valueOf(numberList.get(i));
            value += currentVal;
        }
        return value;
    }

    public int subtract(String param) {
        List<String> numberList = Arrays.asList(param.split(", "));
        Integer value = 0;
        for(int i = 0; i<numberList.size(); i++){
            Integer currentVal = Integer.valueOf(numberList.get(i));
            if(i!=0) value -= currentVal;
            else value += currentVal;
        }
        return value;
    }

    public int multiply(String param) {
        List<String> numberList = Arrays.asList(param.split(", "));
        Integer value = 1;
        for(int i = 0; i<numberList.size(); i++){
            Integer currentVal = Integer.valueOf(numberList.get(i));
            value = value * currentVal;
        }
        return value;
    }

    public int divide(Integer a, Integer b) {
        Integer val = a / b;
        return val;
    }

    public String splitEq(Integer a, Integer b) {
        String numberList = "";
        Integer splitVal = a / b;
        for(int i = 0; i<b; i++){
            if(i < b-1) numberList += splitVal + ", ";
            else numberList += splitVal;
        }
        return numberList;
    }

    public int splitNum(String param) {
        List<String> numberList = Arrays.asList(param.split(", "));
        Integer value = 0;
        Integer firstVal = 0;
        for(int i = 0; i<numberList.size(); i++){
            Integer currentVal = Integer.valueOf(numberList.get(i));
            if(i!=0) value += currentVal;
            else firstVal = currentVal;
        }
        value = firstVal - (firstVal / value)*value;
        return value;
    }

}
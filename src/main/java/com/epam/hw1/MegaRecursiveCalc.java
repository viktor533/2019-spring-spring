package com.epam.hw1;

import org.springframework.stereotype.Component;

@Component
public class MegaRecursiveCalc {

    public static final long STEP = 10;
    public static final long BASE = 5;

    public static long rf(long current, long x) {
        if (x == 0) {
            return current;
        }
        long sumResult = 0;
        for (int i = 0; i < BASE; i++) {
            sumResult += rf(current + 1, i-1);
        }
        return sumResult;
    }

    public void startCalc () {
        try {
            System.out.println("Result: " + rf(0, STEP));
        } catch (StackOverflowError e) {
            System.out.println("Can not calc =(");
        }
    }
}

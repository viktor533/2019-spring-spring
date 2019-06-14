package com.epam.hw1;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class Test1 {
    public void f() {
        OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        System.out.println(">> getSystemLoadAverage: " + osBean.getSystemLoadAverage());
    }

    public static void rf(int x) {
        if (x == 0) {
            return ;
        }
        for (int i = 0; i < 5; i++) {
            rf(i-1);
        }
    }

    public static void main(String[] args) {
        Test1 test = new Test1();
        test.f();

        SystemAnalyzer systemAnalyzer = new SystemAnalyzer();
        systemAnalyzer.start();
        try {
            Thread.sleep(2000);

        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
            System.err.println(">>> " + ex.getMessage());
        }
        try {
            rf(11);
        } catch (StackOverflowError e) {
            System.out.println("=(");
        }
        System.out.println("delay - ok");
        systemAnalyzer.stopThread();
        System.out.println("Finish - ok");
        systemAnalyzer.outAll();
    }


}

package com.epam.hw1;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.List;

public class SystemAnalyzer extends Thread {

    private final boolean DEBUG = true;
    private Boolean isRun = true;
    private final long TIME_STEP;
    private List<Double> osStatData = new ArrayList<>();

    public SystemAnalyzer() {
        this.TIME_STEP = 60000;
    }

    public SystemAnalyzer(long timeStep) {
        this.TIME_STEP = timeStep;
    }

    public void stopThread() {
        synchronized(isRun) {
            isRun = false;
        }
    }

    @Override
    public void run() {
//        System.out.println("Start Thread!");
        long now = System.currentTimeMillis();
        OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        while (true) {
            if (System.currentTimeMillis() - now > TIME_STEP) {
                double currentLoad = osBean.getSystemLoadAverage();
                osStatData.add(currentLoad);
                if (DEBUG) {
                    System.out.println(">> getSystemLoadAverage: " + currentLoad);
                }
                now = System.currentTimeMillis();
            }
            synchronized(isRun) {
                if (!isRun) {
                    break;
                }
            }
        }
//        System.out.println("Finish Thread!");
    }

    public List<Double> getOsStatData() {
        return osStatData;
    }

    public void outAll() {
        System.out.println("All data:");
        for (double cur : osStatData) {
            System.out.print(cur + " ");
        }
        System.out.println();
    }


}

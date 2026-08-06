package com.bytedance.apm;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class ApmDebugger {
    private static AtomicInteger sForceReportBattery = new AtomicInteger(0);
    private static volatile int sReportInterval = 120;
    private static volatile boolean sSetReportInterval = false;
    private static volatile long sCpuInterval = 100000;
    private static volatile boolean sSetCpuInterval = false;
    private static volatile long sMemInterval = 100000;
    private static volatile boolean sSetMemInterval = false;
    private static volatile int sTraffic = 1000;
    private static volatile boolean sSetTraffic = false;

    public static void forceReportBattery() {
    }

    public static void setAsyncTimer(long j) {
    }

    public static void setBatteryTimer(long j) {
    }

    public static boolean shouldForceReportBattery() {
        return false;
    }

    public static void endForceReportBattery() {
        sForceReportBattery.decrementAndGet();
    }

    public static void setReportInterval(int i) {
        sReportInterval = i;
        sSetReportInterval = true;
    }

    public static boolean hasReportInterval() {
        return sSetReportInterval;
    }

    public static int getReportInterval() {
        return sReportInterval;
    }

    public static void setCpuInterval(long j) {
        sCpuInterval = j;
        sSetCpuInterval = true;
    }

    public static boolean hasCpuInterval() {
        return sSetCpuInterval;
    }

    public static long getCpuInterval() {
        return sCpuInterval;
    }

    public static void setMemInterval(long j) {
        sMemInterval = j;
        sSetMemInterval = true;
    }

    public static boolean hasMemInterval() {
        return sSetMemInterval;
    }

    public static long getMemInterval() {
        return sMemInterval;
    }
}

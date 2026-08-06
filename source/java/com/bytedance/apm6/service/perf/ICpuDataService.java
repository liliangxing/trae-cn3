package com.bytedance.apm6.service.perf;

import android.util.Pair;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public interface ICpuDataService {
    double getCpuRate();

    double getCpuSpeed();

    Pair<Long, LinkedList<ThreadCpuItem>> getExceptionThreadList();

    Pair<Long, LinkedList<ThreadCpuItem>> getThreadList();

    /* loaded from: classes3.dex */
    public static class ThreadCpuItem {
        private double cpuUsage;
        private String threadName;
        private int tid;

        public ThreadCpuItem(String str, double d, int i) {
            this.threadName = str;
            this.cpuUsage = d;
            this.tid = i;
        }

        public String getThreadName() {
            return this.threadName;
        }

        public double getCpuUsage() {
            return this.cpuUsage;
        }

        public int getTid() {
            return this.tid;
        }
    }
}

package com.bytedance.apm6.cpu.service;

import android.util.Pair;
import com.bytedance.apm6.service.perf.ICpuDataService;
import java.util.Collection;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public class CurrentCpuDataHolder implements ICpuDataService {
    private Pair<Long, LinkedList<ICpuDataService.ThreadCpuItem>> exceptionTopThread;
    private double rate;
    private double speed;
    private Pair<Long, LinkedList<ICpuDataService.ThreadCpuItem>> topThread;

    private CurrentCpuDataHolder() {
        this.rate = -1.0d;
        this.speed = -1.0d;
        this.topThread = new Pair<>(0L, new LinkedList());
        this.exceptionTopThread = new Pair<>(0L, new LinkedList());
    }

    /* loaded from: classes3.dex */
    private static final class SingletonHolder {
        private static final CurrentCpuDataHolder instance = new CurrentCpuDataHolder();

        private SingletonHolder() {
        }
    }

    public static CurrentCpuDataHolder getInstance() {
        return SingletonHolder.instance;
    }

    public void refreshData(double d, double d2) {
        this.rate = d;
        this.speed = d2;
    }

    public synchronized void refreshTopThreadData(LinkedList<ICpuDataService.ThreadCpuItem> linkedList) {
        this.topThread = new Pair<>(Long.valueOf(System.currentTimeMillis()), linkedList);
    }

    public synchronized void refreshExceptionTopThreadData(LinkedList<ICpuDataService.ThreadCpuItem> linkedList) {
        this.exceptionTopThread = new Pair<>(Long.valueOf(System.currentTimeMillis()), linkedList);
    }

    @Override // com.bytedance.apm6.service.perf.ICpuDataService
    public double getCpuRate() {
        return this.rate;
    }

    @Override // com.bytedance.apm6.service.perf.ICpuDataService
    public double getCpuSpeed() {
        return this.speed;
    }

    @Override // com.bytedance.apm6.service.perf.ICpuDataService
    public Pair<Long, LinkedList<ICpuDataService.ThreadCpuItem>> getThreadList() {
        if (((LinkedList) this.topThread.second).isEmpty()) {
            return this.topThread;
        }
        return new Pair<>(this.topThread.first, new LinkedList((Collection) this.topThread.second));
    }

    @Override // com.bytedance.apm6.service.perf.ICpuDataService
    public Pair<Long, LinkedList<ICpuDataService.ThreadCpuItem>> getExceptionThreadList() {
        if (((LinkedList) this.exceptionTopThread.second).isEmpty()) {
            return this.exceptionTopThread;
        }
        return new Pair<>(this.exceptionTopThread.first, new LinkedList((Collection) this.exceptionTopThread.second));
    }
}

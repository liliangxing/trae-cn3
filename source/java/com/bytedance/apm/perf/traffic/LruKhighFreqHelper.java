package com.bytedance.apm.perf.traffic;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class LruKhighFreqHelper {
    public Map<String, TrafficUsageModel> history;
    public long intervalStartTs;
    public Map<String, TrafficUsageModel> usageStore;
    public int historyLimitSize = 50;
    public int storeLimitSize = 20;
    public int highFreqThreshold = 50;
    public int historyFreqThreshold = Math.min(3, 50 / 2);
    private int maxFreq = 0;

    /* loaded from: classes3.dex */
    private static class Holder {
        private static final LruKhighFreqHelper sInstance = new LruKhighFreqHelper();

        private Holder() {
        }
    }

    public static LruKhighFreqHelper getInstance() {
        return Holder.sInstance;
    }

    public void start() {
        this.intervalStartTs = System.currentTimeMillis();
    }

    public void clear() {
        this.intervalStartTs = 0L;
        this.maxFreq = 0;
        Map<String, TrafficUsageModel> map = this.history;
        if (map != null) {
            map.clear();
            this.history = null;
        }
        Map<String, TrafficUsageModel> map2 = this.usageStore;
        if (map2 != null) {
            map2.clear();
            this.usageStore = null;
        }
    }

    public synchronized void add(long j, String str, String str2) {
        if (this.usageStore == null) {
            this.usageStore = new HashMap();
        }
        if (this.usageStore.containsKey(str)) {
            TrafficUsageModel trafficUsageModel = this.usageStore.get(str);
            trafficUsageModel.requestCount++;
            trafficUsageModel.requestTs = System.currentTimeMillis();
            if (trafficUsageModel.requestCount > this.maxFreq) {
                this.maxFreq = trafficUsageModel.requestCount;
            }
        } else {
            Map<String, TrafficUsageModel> map = this.history;
            if (map != null) {
                long j2 = Long.MAX_VALUE;
                String str3 = null;
                if (map.containsKey(str)) {
                    TrafficUsageModel trafficUsageModel2 = this.history.get(str);
                    int i = trafficUsageModel2.requestCount;
                    trafficUsageModel2.requestCount = i + 1;
                    trafficUsageModel2.requestTs = System.currentTimeMillis();
                    if (i > this.historyFreqThreshold) {
                        this.history.remove(str);
                        if (this.usageStore.size() >= this.storeLimitSize) {
                            long currentTimeMillis = this.intervalStartTs + ((System.currentTimeMillis() - this.intervalStartTs) / 2);
                            for (Map.Entry<String, TrafficUsageModel> entry : this.usageStore.entrySet()) {
                                if (entry.getValue().requestTs < currentTimeMillis && entry.getValue().requestCount < j2) {
                                    long j3 = entry.getValue().requestCount;
                                    str3 = entry.getValue().path;
                                    j2 = j3;
                                }
                            }
                            if (str3 != null) {
                                this.usageStore.remove(str3);
                            }
                        }
                        this.usageStore.put(str, trafficUsageModel2);
                    }
                } else {
                    if (this.history.size() >= this.historyLimitSize) {
                        for (Map.Entry<String, TrafficUsageModel> entry2 : this.history.entrySet()) {
                            if (entry2.getValue().requestTs < j2) {
                                j2 = entry2.getValue().requestTs;
                                str3 = entry2.getValue().path;
                            }
                        }
                        if (str3 != null) {
                            this.history.remove(str3);
                        }
                    }
                    this.history.put(str, new TrafficUsageModel(str, j, str2));
                }
            } else {
                HashMap hashMap = new HashMap();
                this.history = hashMap;
                hashMap.put(str, new TrafficUsageModel(str, j, str2));
            }
        }
    }

    public synchronized Map<String, TrafficUsageModel> getHighFreqMap() {
        return this.usageStore;
    }

    public int getMaxFreq() {
        return this.maxFreq;
    }
}

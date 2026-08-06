package com.bytedance.apm.perf.traffic;

/* loaded from: classes3.dex */
public class TrafficUsageModel implements Comparable {
    public String clientType;
    public String path;
    public long trafficBytes;
    public long requestTs = System.currentTimeMillis();
    public int requestCount = 1;

    public TrafficUsageModel(String str, long j, String str2) {
        this.path = str;
        this.trafficBytes = j;
        this.clientType = str2;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        long j = this.trafficBytes;
        long j2 = ((TrafficUsageModel) obj).trafficBytes;
        if (j == j2) {
            return 0;
        }
        return j > j2 ? 1 : -1;
    }
}

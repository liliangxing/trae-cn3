package com.bytedance.watson.assist.core.cpu;

import com.bytedance.watson.assist.file.FileStatInfo;
import com.bytedance.watson.assist.utils.DebugLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class CpuTimeStatInfo implements FileStatInfo {
    private List<LinkedHashMap<Long, Long>> freqTimeMapList = new ArrayList();
    private List<LinkedHashMap<Long, Long>> freqDeltaTimeMapList = new ArrayList();
    private long totalCpuTime = 0;
    private long deltaCpuTime = 0;
    private long mergedDeltaCpuTime = 0;
    private double cpuUsage = 0.0d;

    public long getDeltaCpuTime() {
        return this.deltaCpuTime;
    }

    public long getTotalCpuTime() {
        if (this.totalCpuTime == 0 && !this.freqTimeMapList.isEmpty()) {
            Iterator<LinkedHashMap<Long, Long>> it = this.freqTimeMapList.iterator();
            while (it.hasNext()) {
                Iterator<Map.Entry<Long, Long>> it2 = it.next().entrySet().iterator();
                while (it2.hasNext()) {
                    this.totalCpuTime += it2.next().getValue().longValue();
                }
            }
        }
        return this.totalCpuTime;
    }

    public List<LinkedHashMap<Long, Long>> getFreqTimeMapList() {
        return this.freqTimeMapList;
    }

    public List<LinkedHashMap<Long, Long>> getFreqDeltaTimeMapList() {
        return this.freqDeltaTimeMapList;
    }

    public long getMergedDeltaCpuTime() {
        return this.mergedDeltaCpuTime;
    }

    public void putFreqTimeMap(LinkedHashMap<Long, Long> linkedHashMap) {
        this.freqTimeMapList.add(linkedHashMap);
    }

    @Override // com.bytedance.watson.assist.file.FileStatInfo
    public void calculateDelta(FileStatInfo fileStatInfo) {
        if (fileStatInfo == null) {
            return;
        }
        long totalCpuTime = getTotalCpuTime() - ((CpuTimeStatInfo) fileStatInfo).getTotalCpuTime();
        this.deltaCpuTime = totalCpuTime;
        if (this.mergedDeltaCpuTime == 0) {
            this.mergedDeltaCpuTime = totalCpuTime;
        }
    }

    public void calculateFreqDelta(FileStatInfo fileStatInfo) {
        if (fileStatInfo == null) {
            this.freqDeltaTimeMapList.addAll(this.freqTimeMapList);
            return;
        }
        List<LinkedHashMap<Long, Long>> freqTimeMapList = ((CpuTimeStatInfo) fileStatInfo).getFreqTimeMapList();
        if (freqTimeMapList.isEmpty()) {
            return;
        }
        if (this.freqTimeMapList.size() != freqTimeMapList.size()) {
            DebugLog.w("calculate cpu freqTime delta size error");
            return;
        }
        this.freqDeltaTimeMapList.clear();
        for (int i = 0; i < this.freqTimeMapList.size(); i++) {
            LinkedHashMap<Long, Long> linkedHashMap = this.freqTimeMapList.get(i);
            LinkedHashMap<Long, Long> linkedHashMap2 = freqTimeMapList.get(i);
            LinkedHashMap<Long, Long> linkedHashMap3 = new LinkedHashMap<>();
            for (Map.Entry<Long, Long> entry : linkedHashMap.entrySet()) {
                Long key = entry.getKey();
                Long value = entry.getValue();
                Long l = linkedHashMap2.get(key);
                if (l != null) {
                    linkedHashMap3.put(key, Long.valueOf(value.longValue() - l.longValue()));
                } else {
                    DebugLog.e("calculate cpu freqTime delta not found " + key);
                }
            }
            this.freqDeltaTimeMapList.add(linkedHashMap3);
        }
    }

    @Override // com.bytedance.watson.assist.file.FileStatInfo
    public void merge(FileStatInfo fileStatInfo) {
        if (fileStatInfo == null) {
            return;
        }
        this.mergedDeltaCpuTime += ((CpuTimeStatInfo) fileStatInfo).getMergedDeltaCpuTime();
    }

    public void reset() {
        this.freqTimeMapList.clear();
        this.freqDeltaTimeMapList.clear();
        this.totalCpuTime = 0L;
        this.deltaCpuTime = 0L;
        this.mergedDeltaCpuTime = 0L;
        this.cpuUsage = 0.0d;
    }

    public double getCpuUsage() {
        return this.cpuUsage;
    }

    public void setCpuUsage(long j) {
        if (this.deltaCpuTime < 0 || this.totalCpuTime <= 0) {
            return;
        }
        this.cpuUsage = 1.0d - (j / getDeltaCpuTime());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("cputime:{deltaTime:");
        sb.append(getDeltaCpuTime()).append(" usage:").append(this.cpuUsage).append(" totaltime:").append(getTotalCpuTime()).append("}");
        return sb.toString();
    }

    public String toMergeString() {
        StringBuilder sb = new StringBuilder("cputime:{deltaTime:");
        sb.append(getMergedDeltaCpuTime()).append("}");
        return sb.toString();
    }
}

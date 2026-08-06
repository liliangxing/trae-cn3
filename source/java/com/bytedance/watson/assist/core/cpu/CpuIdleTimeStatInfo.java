package com.bytedance.watson.assist.core.cpu;

import com.bytedance.watson.assist.file.FileStatInfo;
import com.bytedance.watson.assist.utils.DebugLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes6.dex */
public class CpuIdleTimeStatInfo implements FileStatInfo {
    private List<List<Long>> stateTimeLists = new ArrayList();
    private List<List<Long>> stateDeltaTimeLists = new ArrayList();
    private long totalCpuIdleTime = 0;
    private long deltaCpuIdleTime = 0;
    private long mergedDeltaCpuIdleTime = 0;

    @Override // com.bytedance.watson.assist.file.FileStatInfo
    public void calculateDelta(FileStatInfo fileStatInfo) {
        if (fileStatInfo == null) {
            return;
        }
        long totalCpuIdleTime = getTotalCpuIdleTime() - ((CpuIdleTimeStatInfo) fileStatInfo).getTotalCpuIdleTime();
        this.deltaCpuIdleTime = totalCpuIdleTime;
        if (this.mergedDeltaCpuIdleTime == 0) {
            this.mergedDeltaCpuIdleTime = totalCpuIdleTime;
        }
    }

    @Override // com.bytedance.watson.assist.file.FileStatInfo
    public void merge(FileStatInfo fileStatInfo) {
        if (fileStatInfo == null) {
            return;
        }
        this.mergedDeltaCpuIdleTime += ((CpuIdleTimeStatInfo) fileStatInfo).getMergedDeltaCpuIdleTime();
    }

    public long getMergedDeltaCpuIdleTime() {
        return this.mergedDeltaCpuIdleTime;
    }

    public void calculateIdleDelta(FileStatInfo fileStatInfo) {
        if (fileStatInfo == null) {
            this.stateDeltaTimeLists.addAll(this.stateTimeLists);
            return;
        }
        List<List<Long>> cpuIdleTimeLists = ((CpuIdleTimeStatInfo) fileStatInfo).getCpuIdleTimeLists();
        if (cpuIdleTimeLists.isEmpty()) {
            return;
        }
        int size = this.stateTimeLists.size();
        if (size != cpuIdleTimeLists.size()) {
            DebugLog.w("calculate cpu idle time delta size error1");
            return;
        }
        this.stateDeltaTimeLists.clear();
        for (int i = 0; i < size; i++) {
            List<Long> list = this.stateTimeLists.get(i);
            List<Long> list2 = cpuIdleTimeLists.get(i);
            ArrayList arrayList = new ArrayList();
            if (list == null || list2 == null || list.size() != list2.size()) {
                DebugLog.w("calculate cpu idle time delta size error2");
                return;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                arrayList.add(Long.valueOf(list.get(i2).longValue() - list2.get(i2).longValue()));
            }
            this.stateDeltaTimeLists.add(arrayList);
        }
    }

    public long getDeltaCpuIdleTime() {
        return this.deltaCpuIdleTime;
    }

    public long getTotalCpuIdleTime() {
        if (this.totalCpuIdleTime == 0 && !this.stateTimeLists.isEmpty()) {
            Iterator<List<Long>> it = this.stateTimeLists.iterator();
            while (it.hasNext()) {
                Iterator<Long> it2 = it.next().iterator();
                while (it2.hasNext()) {
                    this.totalCpuIdleTime += it2.next().longValue();
                }
            }
        }
        return this.totalCpuIdleTime;
    }

    public List<List<Long>> getCpuIdleTimeLists() {
        return this.stateTimeLists;
    }

    public List<List<Long>> getCpuIdleDeltaTimeLists() {
        return this.stateDeltaTimeLists;
    }

    public void putStateTimeList(List<Long> list) {
        if (list != null) {
            this.stateTimeLists.add(list);
        }
    }

    public void reset() {
        this.stateTimeLists.clear();
        this.stateDeltaTimeLists.clear();
        this.totalCpuIdleTime = 0L;
        this.deltaCpuIdleTime = 0L;
        this.mergedDeltaCpuIdleTime = 0L;
    }

    public String toString() {
        return "CpuIdleTimeStatInfo{stateTimeLists=" + this.stateTimeLists + ", stateDeltaTimeLists=" + this.stateDeltaTimeLists + ", totalCpuIdleTime=" + this.totalCpuIdleTime + ", deltaCpuIdleTime=" + this.deltaCpuIdleTime + ", mergedDeltaCpuIdleTime=" + this.mergedDeltaCpuIdleTime + AbstractJsonLexerKt.END_OBJ;
    }
}

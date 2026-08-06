package com.bytedance.watson.assist.core.cpu;

import com.bytedance.watson.assist.file.FileStatInfo;
import com.bytedance.watson.assist.utils.CpuUtils;
import com.bytedance.watson.assist.utils.DebugLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes6.dex */
public class ProcTimeInStateInfo implements FileStatInfo {
    private List<Integer> clusterCpuNum;
    private List<LinkedHashMap<Long, Long>> freqTimeMapList = new ArrayList();
    private List<LinkedHashMap<Long, Long>> freqDeltaTimeMapList = new ArrayList();
    private List<LinkedHashMap<Long, Long>> freqDeltaTimeMergeMapList = new ArrayList();
    private boolean inited = false;
    private long totalCpuTime = 0;
    private long totalDeltaCpuTime = 0;
    private long totalMergeDeltaCpuTime = 0;

    @Override // com.bytedance.watson.assist.file.FileStatInfo
    public void calculateDelta(FileStatInfo fileStatInfo) {
        if (fileStatInfo == null) {
            this.freqDeltaTimeMapList.addAll(this.freqTimeMapList);
            return;
        }
        List<LinkedHashMap<Long, Long>> freqTimeMapList = ((ProcTimeInStateInfo) fileStatInfo).getFreqTimeMapList();
        if (freqTimeMapList.isEmpty()) {
            return;
        }
        if (this.freqTimeMapList.size() != freqTimeMapList.size()) {
            DebugLog.w("calculate proc freqTime delta size error");
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
                    DebugLog.e("calculate proc freqTime delta not found " + key);
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
        ProcTimeInStateInfo procTimeInStateInfo = (ProcTimeInStateInfo) fileStatInfo;
        List<LinkedHashMap<Long, Long>> freqTimeMapList = procTimeInStateInfo.getFreqTimeMapList();
        List<LinkedHashMap<Long, Long>> freqDeltaTimeMapList = procTimeInStateInfo.getFreqDeltaTimeMapList();
        if (!freqDeltaTimeMapList.isEmpty()) {
            freqTimeMapList = freqDeltaTimeMapList;
        }
        if (this.freqDeltaTimeMergeMapList.isEmpty()) {
            this.freqDeltaTimeMergeMapList.addAll(freqTimeMapList);
            return;
        }
        int size = this.freqDeltaTimeMergeMapList.size();
        if (size != freqTimeMapList.size()) {
            DebugLog.w("merge freqTime size error");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            LinkedHashMap<Long, Long> linkedHashMap = this.freqDeltaTimeMergeMapList.get(i);
            LinkedHashMap<Long, Long> linkedHashMap2 = freqTimeMapList.get(i);
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry<Long, Long> entry : linkedHashMap.entrySet()) {
                Long key = entry.getKey();
                Long value = entry.getValue();
                Long l = linkedHashMap2.get(key);
                if (l != null) {
                    linkedHashMap3.put(key, Long.valueOf(value.longValue() + l.longValue()));
                } else {
                    DebugLog.w("merge freqTimeDetla freq not found " + key);
                }
            }
            arrayList.add(linkedHashMap3);
        }
        this.freqDeltaTimeMergeMapList = arrayList;
    }

    public void addFreqTimeItem(LinkedHashMap<Long, Long> linkedHashMap) {
        if (linkedHashMap != null) {
            this.freqTimeMapList.add(linkedHashMap);
        }
    }

    public List<LinkedHashMap<Long, Long>> getFreqTimeMapList() {
        return this.freqTimeMapList;
    }

    public List<LinkedHashMap<Long, Long>> getFreqDeltaTimeMapList() {
        return this.freqDeltaTimeMapList;
    }

    public List<LinkedHashMap<Long, Long>> getFreqMergeTimeMapList() {
        return this.freqDeltaTimeMergeMapList;
    }

    private long getTotalTime(List<LinkedHashMap<Long, Long>> list) {
        int size;
        if (!this.inited) {
            this.clusterCpuNum = CpuUtils.getClusterCpuNum();
            this.inited = true;
        }
        long j = 0;
        if (list != null && !list.isEmpty() && (size = list.size()) == this.clusterCpuNum.size()) {
            for (int i = 0; i < size; i++) {
                Iterator<Map.Entry<Long, Long>> it = list.get(i).entrySet().iterator();
                while (it.hasNext()) {
                    j += it.next().getValue().longValue();
                }
            }
        }
        return j;
    }

    public long getTotalCpuTime() {
        if (this.totalCpuTime == 0) {
            this.totalCpuTime = getTotalTime(this.freqTimeMapList);
        }
        return this.totalCpuTime;
    }

    public long getTotalDeltaCpuTime() {
        if (this.totalDeltaCpuTime == 0) {
            this.totalDeltaCpuTime = getTotalTime(this.freqDeltaTimeMapList);
        }
        return this.totalDeltaCpuTime;
    }

    public long getTotalMergeDeltaCpuTime() {
        if (this.totalMergeDeltaCpuTime == 0) {
            this.totalMergeDeltaCpuTime = getTotalTime(this.freqDeltaTimeMergeMapList);
        }
        return this.totalMergeDeltaCpuTime;
    }

    public void reset() {
        this.freqTimeMapList.clear();
        this.freqDeltaTimeMapList.clear();
        this.freqDeltaTimeMergeMapList.clear();
        this.totalCpuTime = 0L;
        this.totalDeltaCpuTime = 0L;
        this.totalMergeDeltaCpuTime = 0L;
    }

    public String toString() {
        return "ProcTimeInStateInfo{freqTimeMapList=" + this.freqTimeMapList + ", freqDeltaTimeMapList=" + this.freqDeltaTimeMapList + ", totalCpuTime=" + getTotalCpuTime() + ", totalDeltaCpuTime=" + getTotalDeltaCpuTime() + ", totalMergeCpuTime=" + getTotalMergeDeltaCpuTime() + AbstractJsonLexerKt.END_OBJ;
    }
}

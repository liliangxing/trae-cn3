package com.bytedance.watson.assist.core.cpu;

import android.content.Context;
import com.bytedance.watson.assist.api.IAssistStat;
import com.bytedance.watson.assist.core.BaseInfoManager;
import com.bytedance.watson.assist.file.ProcPidStatFile;
import com.bytedance.watson.assist.file.ProcTidStatFile;
import com.bytedance.watson.assist.file.ProcTimeInStateFile;
import com.bytedance.watson.assist.file.SystemIdleTimeFile;
import com.bytedance.watson.assist.file.SystemPolicyTimeInStateFile;
import com.bytedance.watson.assist.utils.DebugLog;
import com.bytedance.watson.assist.utils.ProcessUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class CpuInfoManager extends BaseInfoManager {
    private static final int CLUSTER_INFO_SIZE = 5;
    private boolean isStart;
    private CpuIdleTimeStatInfo mLastCpuIdleTimeStatInfo;
    private CpuTimeStatInfo mLastCpuTimeInStatInfo;
    private ProcStatInfo mLastProcStatInfo;
    private ProcTimeInStateInfo mLastProcTimeInStateInfo;
    private long mLastRefreshTime;
    private Map<Long, ThreadStatInfo> mLastTidStatInfo;
    private Map<Long, ProcTimeInStateInfo> mLastTidTimeInStateInfo;
    private ProcPidStatFile mProcPidStatFile;
    private Map<Long, ProcTidStatFile> mProcTidStatFileMap;
    private Map<Long, ProcTimeInStateFile> mProcTidTimeInStateFileMap;
    private ProcTimeInStateFile mProcTimeInStateFile;
    private SystemIdleTimeFile mSystemIdleTimeInStatFile;
    private SystemPolicyTimeInStateFile mSystemTimeInStatFile;

    private boolean isBigLittle(int i) {
        return i == 2;
    }

    private boolean isBigMidLittle(int i) {
        return i == 3;
    }

    public CpuInfoManager(Context context, IAssistStat iAssistStat) {
        super(context, iAssistStat);
        this.isStart = false;
        this.mLastRefreshTime = 0L;
        this.mProcTimeInStateFile = new ProcTimeInStateFile();
        this.mLastProcTimeInStateInfo = new ProcTimeInStateInfo();
        this.mProcTidTimeInStateFileMap = new HashMap();
        this.mLastTidTimeInStateInfo = new HashMap();
        this.mSystemTimeInStatFile = new SystemPolicyTimeInStateFile();
        this.mLastCpuTimeInStatInfo = new CpuTimeStatInfo();
        this.mProcPidStatFile = new ProcPidStatFile();
        this.mLastProcStatInfo = new ProcStatInfo();
        this.mProcTidStatFileMap = new HashMap();
        this.mLastTidStatInfo = new HashMap();
        this.mSystemIdleTimeInStatFile = new SystemIdleTimeFile();
        this.mLastCpuIdleTimeStatInfo = new CpuIdleTimeStatInfo();
    }

    @Override // com.bytedance.watson.assist.core.BaseInfoManager
    public void start() {
        if (this.isStart) {
            return;
        }
        this.isStart = true;
        refresh();
    }

    @Override // com.bytedance.watson.assist.core.BaseInfoManager
    public void end() {
        if (this.isStart) {
            this.isStart = false;
            clear();
        }
    }

    private void clear() {
        this.mLastProcTimeInStateInfo.reset();
        this.mProcTidTimeInStateFileMap.clear();
        this.mLastTidTimeInStateInfo.clear();
        this.mLastCpuTimeInStatInfo.reset();
        this.mLastProcStatInfo.reset();
        this.mProcTidStatFileMap.clear();
        this.mLastTidStatInfo.clear();
        this.mLastCpuIdleTimeStatInfo.reset();
    }

    public List<LinkedHashMap<Long, Long>> getProcCpuTimeDetail() {
        if (this.mAssistStat.getConfig().isEnableProcessTimeFreqPercent()) {
            return this.mLastProcTimeInStateInfo.getFreqMergeTimeMapList();
        }
        return null;
    }

    public List<LinkedHashMap<Long, Long>> getThreadCpuTimeDetail(int i) {
        ProcTimeInStateInfo procTimeInStateInfo;
        if (!this.mAssistStat.getConfig().isEnableProcessTimeFreqPercent() || (procTimeInStateInfo = this.mLastTidTimeInStateInfo.get(Long.valueOf(i))) == null) {
            return null;
        }
        return procTimeInStateInfo.getFreqDeltaTimeMapList();
    }

    public List<LinkedHashMap<Long, Long>> getSystemCpuTimeFreqDetail() {
        if (this.mAssistStat.getConfig().isEnableCpuUsageStat() && this.mAssistStat.getConfig().isEnableSystemCpuTimeFreqPercent()) {
            return this.mLastCpuTimeInStatInfo.getFreqDeltaTimeMapList();
        }
        return null;
    }

    public double getSystemCpuUsage() {
        if (this.mAssistStat.getConfig().isEnableSystemCpuUsageStat() && this.mAssistStat.getConfig().isEnableCpuUsageStat()) {
            return this.mLastCpuTimeInStatInfo.getCpuUsage();
        }
        return 0.0d;
    }

    public double getProcCpuUsage() {
        if (this.mAssistStat.getConfig().isEnableCpuUsageStat()) {
            return this.mLastProcStatInfo.getCpuUsage();
        }
        return 0.0d;
    }

    public double getThreadCpuUsage(int i) {
        ThreadStatInfo threadStatInfo;
        if (this.mAssistStat.getConfig().isEnableCpuUsageStat() && this.mAssistStat.getConfig().isEnableThreadCpuUsageStat() && (threadStatInfo = this.mLastTidStatInfo.get(Long.valueOf(i))) != null) {
            return threadStatInfo.getCpuUsage();
        }
        return 0.0d;
    }

    public double getProcCpuSpeed() {
        if (this.mAssistStat.getConfig().isEnableCpuUsageStat()) {
            return this.mLastProcStatInfo.getCpuSpeed();
        }
        return 0.0d;
    }

    public double getThreadCpuSpeed(int i) {
        ThreadStatInfo threadStatInfo;
        if (this.mAssistStat.getConfig().isEnableCpuUsageStat() && this.mAssistStat.getConfig().isEnableThreadCpuUsageStat() && (threadStatInfo = this.mLastTidStatInfo.get(Long.valueOf(i))) != null) {
            return threadStatInfo.getCpuSpeed();
        }
        return 0.0d;
    }

    public ThreadStatInfo getThreadCpuStatInfo(int i) {
        if (this.mAssistStat.getConfig().isEnableCpuUsageStat() && this.mAssistStat.getConfig().isEnableThreadCpuUsageStat()) {
            return this.mLastTidStatInfo.get(Long.valueOf(i));
        }
        return null;
    }

    public List<ThreadStatInfo> getSortedThreadStatInfoList() {
        if (!this.mAssistStat.getConfig().isEnableCpuUsageStat() || !this.mAssistStat.getConfig().isEnableThreadCpuUsageStat()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.mLastTidStatInfo.values());
        Collections.sort(arrayList, new Comparator<ThreadStatInfo>() { // from class: com.bytedance.watson.assist.core.cpu.CpuInfoManager.1
            @Override // java.util.Comparator
            public int compare(ThreadStatInfo threadStatInfo, ThreadStatInfo threadStatInfo2) {
                return (int) (threadStatInfo2.getDeltaCpuTime() - threadStatInfo.getDeltaCpuTime());
            }
        });
        return arrayList;
    }

    public List<ThreadStatInfo> getTopThreadCpuStatInfoList(int i) {
        List<ThreadStatInfo> sortedThreadStatInfoList;
        if (!this.mAssistStat.getConfig().isEnableCpuUsageStat() || !this.mAssistStat.getConfig().isEnableThreadCpuUsageStat() || i <= 0 || (sortedThreadStatInfoList = getSortedThreadStatInfoList()) == null) {
            return null;
        }
        int size = sortedThreadStatInfoList.size();
        if (i > size) {
            i = size;
        }
        return sortedThreadStatInfoList.subList(0, i);
    }

    public void refreshCpuUsageStat(long j) {
        CpuTimeStatInfo cpuTimeStatInfo = (CpuTimeStatInfo) this.mSystemTimeInStatFile.refresh();
        ProcStatInfo procStatInfo = (ProcStatInfo) this.mProcPidStatFile.refresh();
        if (cpuTimeStatInfo == null || procStatInfo == null) {
            return;
        }
        cpuTimeStatInfo.calculateDelta(this.mLastCpuTimeInStatInfo);
        if (this.mAssistStat.getConfig().isEnableSystemCpuTimeFreqPercent()) {
            cpuTimeStatInfo.calculateFreqDelta(this.mLastCpuTimeInStatInfo);
        }
        if (this.mAssistStat.getConfig().isEnableSystemCpuUsageStat()) {
            CpuIdleTimeStatInfo cpuIdleTimeStatInfo = (CpuIdleTimeStatInfo) this.mSystemIdleTimeInStatFile.refresh();
            cpuIdleTimeStatInfo.calculateDelta(this.mLastCpuIdleTimeStatInfo);
            cpuIdleTimeStatInfo.calculateIdleDelta(this.mLastCpuIdleTimeStatInfo);
            DebugLog.m26d("current cpu idle stat : " + cpuIdleTimeStatInfo);
            this.mLastCpuIdleTimeStatInfo = cpuIdleTimeStatInfo;
            cpuTimeStatInfo.setCpuUsage(cpuIdleTimeStatInfo.getDeltaCpuIdleTime());
            DebugLog.m26d("current cpu usage stat : " + cpuTimeStatInfo);
        }
        long deltaCpuTime = cpuTimeStatInfo.getDeltaCpuTime();
        long j2 = j - this.mLastRefreshTime;
        procStatInfo.calculateDelta(this.mLastProcStatInfo);
        procStatInfo.setCpuUsage(deltaCpuTime);
        procStatInfo.setCpuSpeed(j2);
        if (this.mAssistStat.getConfig().isEnableThreadCpuUsageStat()) {
            ArrayList<Long> threadListFromProcFs = ProcessUtils.threadListFromProcFs();
            HashSet hashSet = new HashSet();
            Iterator<Long> it = threadListFromProcFs.iterator();
            while (it.hasNext()) {
                long longValue = it.next().longValue();
                ProcTidStatFile procTidStatFile = this.mProcTidStatFileMap.get(Long.valueOf(longValue));
                if (procTidStatFile == null) {
                    procTidStatFile = new ProcTidStatFile(longValue);
                    this.mProcTidStatFileMap.put(Long.valueOf(longValue), procTidStatFile);
                }
                ThreadStatInfo threadStatInfo = (ThreadStatInfo) procTidStatFile.refresh();
                if (threadStatInfo == null) {
                    hashSet.add(Long.valueOf(longValue));
                    DebugLog.m26d("dead tid found from refresh thread usage: " + longValue);
                } else {
                    threadStatInfo.calculateDelta(this.mLastTidStatInfo.get(Long.valueOf(longValue)));
                    threadStatInfo.setCpuUsage(deltaCpuTime);
                    threadStatInfo.setCpuSpeed(j2);
                    this.mLastTidStatInfo.put(Long.valueOf(longValue), threadStatInfo);
                    DebugLog.m26d("current tid stat : " + threadStatInfo);
                }
            }
            Set<Long> keySet = this.mProcTidStatFileMap.keySet();
            if (keySet != null && !keySet.isEmpty()) {
                for (Long l : keySet) {
                    if (!threadListFromProcFs.contains(l)) {
                        hashSet.add(l);
                        DebugLog.m26d("dead tid found from compare last thread usage: " + l);
                    }
                }
            }
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                long longValue2 = ((Long) it2.next()).longValue();
                this.mProcTidStatFileMap.remove(Long.valueOf(longValue2));
                this.mLastTidStatInfo.remove(Long.valueOf(longValue2));
            }
        }
        this.mLastCpuTimeInStatInfo = cpuTimeStatInfo;
        this.mLastProcStatInfo = procStatInfo;
    }

    public void refreshCpuFreqStat() {
        ProcTimeInStateInfo procTimeInStateInfo = (ProcTimeInStateInfo) this.mProcTimeInStateFile.refresh();
        if (procTimeInStateInfo == null) {
            return;
        }
        procTimeInStateInfo.calculateDelta(this.mLastProcTimeInStateInfo);
        this.mLastProcTimeInStateInfo = procTimeInStateInfo;
        ArrayList<Long> threadListFromProcFs = ProcessUtils.threadListFromProcFs();
        HashSet hashSet = new HashSet();
        Iterator<Long> it = threadListFromProcFs.iterator();
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            ProcTimeInStateFile procTimeInStateFile = this.mProcTidTimeInStateFileMap.get(Long.valueOf(longValue));
            if (procTimeInStateFile == null) {
                procTimeInStateFile = new ProcTimeInStateFile((int) longValue);
                this.mProcTidTimeInStateFileMap.put(Long.valueOf(longValue), procTimeInStateFile);
            }
            ProcTimeInStateInfo procTimeInStateInfo2 = (ProcTimeInStateInfo) procTimeInStateFile.refresh();
            if (procTimeInStateInfo2 == null) {
                hashSet.add(Long.valueOf(longValue));
                DebugLog.m26d("dead tid found from refresh cpu freq stat: " + longValue);
            } else {
                procTimeInStateInfo2.calculateDelta(this.mLastTidTimeInStateInfo.get(Long.valueOf(longValue)));
                this.mLastTidTimeInStateInfo.put(Long.valueOf(longValue), procTimeInStateInfo2);
                if (ProcessUtils.getMainThreadId() == longValue) {
                    DebugLog.m26d("not merge main thread, id:" + longValue);
                } else {
                    this.mLastProcTimeInStateInfo.merge(procTimeInStateInfo2);
                }
                DebugLog.m26d("current tid " + longValue + " stat : " + procTimeInStateInfo2);
                DebugLog.m26d("current tid " + longValue + " delta : " + procTimeInStateInfo2.getTotalDeltaCpuTime());
            }
        }
        Set<Long> keySet = this.mProcTidTimeInStateFileMap.keySet();
        if (keySet != null && !keySet.isEmpty()) {
            for (Long l : keySet) {
                if (!threadListFromProcFs.contains(l)) {
                    hashSet.add(l);
                    DebugLog.m26d("dead tid found from compare last cpu freq stat: " + l);
                }
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            long longValue2 = ((Long) it2.next()).longValue();
            this.mProcTidTimeInStateFileMap.remove(Long.valueOf(longValue2));
            this.mLastTidTimeInStateInfo.remove(Long.valueOf(longValue2));
        }
    }

    public void refresh() {
        if (this.isStart) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mAssistStat.getConfig().isEnableCpuUsageStat()) {
                refreshCpuUsageStat(currentTimeMillis);
            }
            if (this.mAssistStat.getConfig().isEnableProcessTimeFreqPercent()) {
                refreshCpuFreqStat();
            }
            this.mLastRefreshTime = currentTimeMillis;
        }
    }

    public List<List<Integer>> getProcessCpuTimeFreqPercent() {
        if (this.mAssistStat.getConfig().isEnableProcessTimeFreqPercent()) {
            return generateCpuTimeFreqPercent(this.mLastProcTimeInStateInfo.getFreqMergeTimeMapList(), this.mLastProcTimeInStateInfo.getTotalMergeDeltaCpuTime());
        }
        return null;
    }

    public List<List<Integer>> getThreadCpuTimeFreqPercent(int i) {
        ProcTimeInStateInfo procTimeInStateInfo;
        if (!this.mAssistStat.getConfig().isEnableProcessTimeFreqPercent() || (procTimeInStateInfo = this.mLastTidTimeInStateInfo.get(Long.valueOf(i))) == null) {
            return null;
        }
        return generateCpuTimeFreqPercent(procTimeInStateInfo.getFreqDeltaTimeMapList(), procTimeInStateInfo.getTotalDeltaCpuTime());
    }

    public List<List<Integer>> getSystemCpuTimeFreqPercent() {
        if (this.mAssistStat.getConfig().isEnableSystemCpuTimeFreqPercent() && this.mAssistStat.getConfig().isEnableCpuUsageStat()) {
            return generateCpuTimeFreqPercent(this.mLastCpuTimeInStatInfo.getFreqDeltaTimeMapList(), this.mLastCpuTimeInStatInfo.getDeltaCpuTime());
        }
        return null;
    }

    private List<List<Integer>> generateCpuTimeFreqPercent(List<LinkedHashMap<Long, Long>> list, long j) {
        if (list == null) {
            return null;
        }
        long j2 = 0;
        if (j <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (LinkedHashMap<Long, Long> linkedHashMap : list) {
            ArrayList arrayList2 = new ArrayList();
            int size = linkedHashMap.size() / 4;
            int i = 0;
            long j3 = j2;
            long j4 = j3;
            int i2 = 0;
            for (Map.Entry<Long, Long> entry : linkedHashMap.entrySet()) {
                Long key = entry.getKey();
                Long value = entry.getValue();
                if (key != null && value != null) {
                    j4 += value.longValue();
                    if (i < 3) {
                        if (i2 < size) {
                            j3 += value.longValue();
                            i2++;
                        } else {
                            arrayList2.add(Integer.valueOf((int) ((j3 / j) * 100.0d)));
                            j3 = value.longValue();
                            i++;
                            i2 = 1;
                        }
                    } else if (i == 3) {
                        j3 += value.longValue();
                    }
                }
            }
            double d = j;
            arrayList2.add(Integer.valueOf((int) ((j3 / d) * 100.0d)));
            arrayList2.add(Integer.valueOf((int) ((j4 / d) * 100.0d)));
            arrayList.add(arrayList2);
            j2 = 0;
        }
        return arrayList;
    }

    private IAssistStat.CpuTimePercent generateCpuTimePercentFromList(List<List<Integer>> list) {
        if (list == null) {
            return null;
        }
        boolean isBigLittle = isBigLittle(list.size());
        boolean isBigMidLittle = isBigMidLittle(list.size());
        IAssistStat.CpuTimePercent cpuTimePercent = new IAssistStat.CpuTimePercent();
        int i = 0;
        for (List<Integer> list2 : list) {
            if (list2 != null && list2.size() >= 5) {
                if (i == 0) {
                    cpuTimePercent.smallCoreLow = list2.get(0).intValue();
                    cpuTimePercent.smallCoreMidLow = list2.get(1).intValue();
                    cpuTimePercent.smallCoreMidHigh = list2.get(2).intValue();
                    cpuTimePercent.smallCoreHigh = list2.get(3).intValue();
                    float intValue = list2.get(4).intValue();
                    cpuTimePercent.smallCoreLow = intValue;
                    cpuTimePercent.smallCoreSum = intValue;
                }
                if (i == 1 && isBigMidLittle) {
                    cpuTimePercent.middleCoreLow = list2.get(0).intValue();
                    cpuTimePercent.middleCoreMidLow = list2.get(1).intValue();
                    cpuTimePercent.middleCoreMidHigh = list2.get(2).intValue();
                    cpuTimePercent.middleCoreHigh = list2.get(3).intValue();
                    cpuTimePercent.middleCoreSum = list2.get(4).intValue();
                }
                if (i == 1 && isBigLittle) {
                    cpuTimePercent.middleCoreLow = 0.0f;
                    cpuTimePercent.middleCoreMidLow = 0.0f;
                    cpuTimePercent.middleCoreMidHigh = 0.0f;
                    cpuTimePercent.middleCoreHigh = 0.0f;
                    cpuTimePercent.middleCoreSum = 0.0f;
                    cpuTimePercent.bigCoreLow = list2.get(0).intValue();
                    cpuTimePercent.bigCoreMidLow = list2.get(1).intValue();
                    cpuTimePercent.bigCoreMidHigh = list2.get(2).intValue();
                    cpuTimePercent.bigCoreHigh = list2.get(3).intValue();
                    cpuTimePercent.bigCoreSum = list2.get(4).intValue();
                }
                if (i == 2 && isBigMidLittle) {
                    cpuTimePercent.bigCoreLow = list2.get(0).intValue();
                    cpuTimePercent.bigCoreMidLow = list2.get(1).intValue();
                    cpuTimePercent.bigCoreMidHigh = list2.get(2).intValue();
                    cpuTimePercent.bigCoreHigh = list2.get(3).intValue();
                    cpuTimePercent.bigCoreSum = list2.get(4).intValue();
                }
                i++;
            }
        }
        return cpuTimePercent;
    }

    public IAssistStat.CpuTimePercent getProcessCpuTimePercent() {
        if (this.mAssistStat.getConfig().isEnableProcessTimeFreqPercent()) {
            return generateCpuTimePercentFromList(getProcessCpuTimeFreqPercent());
        }
        return null;
    }

    public IAssistStat.CpuTimePercent getThreadCpuTimePercent(int i) {
        if (this.mAssistStat.getConfig().isEnableProcessTimeFreqPercent()) {
            return generateCpuTimePercentFromList(getThreadCpuTimeFreqPercent(i));
        }
        return null;
    }

    public IAssistStat.CpuTimePercent getSystemCpuTimePercent() {
        if (this.mAssistStat.getConfig().isEnableSystemCpuTimeFreqPercent() && this.mAssistStat.getConfig().isEnableCpuUsageStat()) {
            return generateCpuTimePercentFromList(getSystemCpuTimeFreqPercent());
        }
        return null;
    }
}

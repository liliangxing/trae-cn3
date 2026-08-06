package com.bytedance.apm.launch;

import android.os.Debug;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.internal.FunctionSwitcher;
import com.bytedance.apm.util.CommonMonitorUtil;
import com.bytedance.apm.util.ThreadTimeItem;
import com.bytedance.apm6.util.log.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LaunchPerfDataFetcher {
    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(7:2|3|4|5|6|(4:7|8|(3:10|(3:44|45|46)(3:12|13|(3:41|42|43)(3:15|16|(3:38|39|40)(3:18|19|(3:35|36|37)(3:21|22|(3:32|33|34)(3:24|25|(3:27|28|29)(1:31))))))|30)(0)|47)|48)|(2:49|50)|51|52|54|55|(1:57)|(2:62|63)|60|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:57:0x016c A[Catch: all -> 0x0173, TRY_LEAVE, TryCatch #5 {all -> 0x0173, blocks: (B:55:0x0161, B:57:0x016c), top: B:54:0x0161 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0175 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static LaunchTraceData getLaunchTraceData(long j) {
        int myPid;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        LaunchTraceData launchTraceData = new LaunchTraceData();
        try {
            myPid = Process.myPid();
            BufferedReader bufferedReader3 = null;
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/" + myPid + "/task/" + myPid + "/sched"), 100);
            } catch (Throwable unused) {
            }
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (!readLine.contains("se.statistics.iowait_sum")) {
                            if (!readLine.contains("se.statistics.wait_sum")) {
                                if (!readLine.contains("se.statistics.sum_sleep_runtime")) {
                                    if (!readLine.contains("nr_voluntary_switches")) {
                                        if (!readLine.contains("nr_involuntary_switches")) {
                                            if (readLine.contains("se.sum_exec_runtime")) {
                                                launchTraceData.cpuTime = Double.parseDouble(readLine.substring(readLine.lastIndexOf(" ") + 1));
                                            }
                                        } else {
                                            launchTraceData.inVoluntarySwitches = Long.parseLong(readLine.substring(readLine.lastIndexOf(" ") + 1));
                                        }
                                    } else {
                                        launchTraceData.voluntarySwitches = Long.parseLong(readLine.substring(readLine.lastIndexOf(" ") + 1));
                                    }
                                } else {
                                    launchTraceData.sleepTime = Double.parseDouble(readLine.substring(readLine.lastIndexOf(" ") + 1));
                                }
                            } else {
                                launchTraceData.runnableTime = Double.parseDouble(readLine.substring(readLine.lastIndexOf(" ") + 1));
                            }
                        } else {
                            launchTraceData.iowaitTime = Double.parseDouble(readLine.substring(readLine.lastIndexOf(" ") + 1));
                        }
                    }
                } catch (Throwable unused2) {
                    bufferedReader3 = bufferedReader;
                    bufferedReader = bufferedReader3;
                    break;
                    bufferedReader2 = new BufferedReader(new FileReader("/proc/" + myPid + "/task/" + myPid + "/stat"), 100);
                    String[] split = bufferedReader2.readLine().split(" ");
                    launchTraceData.minorFault = Long.parseLong(split[9]);
                    launchTraceData.majorFault = Long.parseLong(split[11]);
                    launchTraceData.gcCount = Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_GC_COUNT));
                    launchTraceData.gcTime = Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_GC_TIME));
                    launchTraceData.blockGcCount = Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_BLOCKING_GC_COUNT));
                    launchTraceData.blockGcTime = Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_BLOCKING_GC_TIME));
                    fetchThreadData(launchTraceData);
                    if (FunctionSwitcher.getSwitch(128)) {
                    }
                    if (bufferedReader2 != null) {
                    }
                    return launchTraceData;
                }
                try {
                    break;
                } catch (Throwable unused3) {
                }
            }
            bufferedReader2 = new BufferedReader(new FileReader("/proc/" + myPid + "/task/" + myPid + "/stat"), 100);
        } finally {
            return launchTraceData;
        }
        try {
            String[] split2 = bufferedReader2.readLine().split(" ");
            launchTraceData.minorFault = Long.parseLong(split2[9]);
            launchTraceData.majorFault = Long.parseLong(split2[11]);
        } catch (Throwable unused4) {
            bufferedReader = bufferedReader2;
            bufferedReader2 = bufferedReader;
            launchTraceData.gcCount = Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_GC_COUNT));
            launchTraceData.gcTime = Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_GC_TIME));
            launchTraceData.blockGcCount = Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_BLOCKING_GC_COUNT));
            launchTraceData.blockGcTime = Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_BLOCKING_GC_TIME));
            fetchThreadData(launchTraceData);
            if (FunctionSwitcher.getSwitch(128)) {
            }
            if (bufferedReader2 != null) {
            }
            return launchTraceData;
        }
        launchTraceData.gcCount = Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_GC_COUNT));
        launchTraceData.gcTime = Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_GC_TIME));
        launchTraceData.blockGcCount = Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_BLOCKING_GC_COUNT));
        launchTraceData.blockGcTime = Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_BLOCKING_GC_TIME));
        fetchThreadData(launchTraceData);
        if (FunctionSwitcher.getSwitch(128)) {
            fetchTaskCpuInfo(launchTraceData, myPid, FunctionSwitcher.getLaunchThreadInfoCount(), j);
        }
        if (bufferedReader2 != null) {
            try {
                bufferedReader2.close();
            } catch (Throwable unused5) {
            }
        }
        return launchTraceData;
    }

    private static void fetchThreadData(LaunchTraceData launchTraceData) {
        int i;
        ThreadGroup threadGroup;
        try {
            i = new File("/proc/self/task/").listFiles().length;
        } catch (Throwable unused) {
            i = 0;
        }
        if (i == 0 || (threadGroup = Looper.getMainLooper().getThread().getThreadGroup()) == null) {
            return;
        }
        while (threadGroup.getParent() != null) {
            threadGroup = threadGroup.getParent();
        }
        int activeCount = threadGroup.activeCount();
        Thread[] threadArr = new Thread[activeCount + (activeCount / 2)];
        int enumerate = threadGroup.enumerate(threadArr);
        LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < enumerate; i2++) {
            String name = threadArr[i2].getName();
            if (!TextUtils.isEmpty(name)) {
                linkedList.add(name);
            }
        }
        launchTraceData.allThreadCount = i;
        launchTraceData.javaThreadNameList = linkedList;
    }

    private static void fetchTaskCpuInfo(LaunchTraceData launchTraceData, int i, int i2, long j) {
        launchTraceData.processCpuTime = CommonMonitorUtil.getAppCpuActiveTime();
        launchTraceData.processDuration = ProcessStartupTime.getProcessStartupTimeInJiffies(i);
        long scClkTck = (j * CommonMonitorUtil.getScClkTck(100L)) / 1000;
        if (launchTraceData.processDuration > 2 * scClkTck) {
            if (ApmContext.isDebugMode()) {
                Logger.m124w("LaunchPerfData", "originProcessDuration: " + launchTraceData.processDuration + " new: " + scClkTck);
            }
            launchTraceData.processDuration = scClkTck;
        }
        if (ApmContext.isDebugMode()) {
            Logger.m122i("LaunchPerfData", "processCpuTime: " + launchTraceData.processCpuTime + " processDuration: " + launchTraceData.processDuration);
        }
        LinkedList<ThreadTimeItem> threadInfo = CommonMonitorUtil.getThreadInfo(i, true, launchTraceData.processDuration);
        Collections.sort(threadInfo, new Comparator<ThreadTimeItem>() { // from class: com.bytedance.apm.launch.LaunchPerfDataFetcher.1
            @Override // java.util.Comparator
            public int compare(ThreadTimeItem threadTimeItem, ThreadTimeItem threadTimeItem2) {
                return (int) (threadTimeItem2.threadTime - threadTimeItem.threadTime);
            }
        });
        launchTraceData.threadTimeItems = threadInfo.subList(0, Math.min(threadInfo.size(), i2));
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class LaunchTraceData {
        private List<ThreadTimeItem> threadTimeItems;
        private long gcCount = -1;
        private long gcTime = -1;
        private long blockGcCount = -1;
        private long blockGcTime = -1;
        private double cpuTime = -1.0d;
        private long voluntarySwitches = -1;
        private long inVoluntarySwitches = -1;
        private double iowaitTime = -1.0d;
        private double runnableTime = -1.0d;
        private double sleepTime = -1.0d;
        private long lockTime = -1;
        private long binderTime = -1;
        private long minorFault = -1;
        private long majorFault = -1;
        private long allThreadCount = -1;
        private List<String> javaThreadNameList = null;
        private long processCpuTime = -1;
        private long processDuration = -1;

        public List<String> getJavaThreadNameList() {
            return this.javaThreadNameList;
        }

        public long getGcCount() {
            return this.gcCount;
        }

        public long getGcTime() {
            return this.gcTime;
        }

        public long getBlockGcCount() {
            return this.blockGcCount;
        }

        public long getBlockGcTime() {
            return this.blockGcTime;
        }

        public double getIowaitTime() {
            return this.iowaitTime;
        }

        public double getRunnableTime() {
            return this.runnableTime;
        }

        public double getSleepTime() {
            return this.sleepTime;
        }

        public long getMinorFault() {
            return this.minorFault;
        }

        public long getMajorFault() {
            return this.majorFault;
        }

        public long getAllThreadCount() {
            return this.allThreadCount;
        }

        public double getCpuTime() {
            return this.cpuTime;
        }

        public long getVoluntarySwitches() {
            return this.voluntarySwitches;
        }

        public long getInVoluntarySwitches() {
            return this.inVoluntarySwitches;
        }

        public long getLockTime() {
            return this.lockTime;
        }

        public void setLockTime(long j) {
            this.lockTime = j;
        }

        public long getBinderTime() {
            return this.binderTime;
        }

        public void setBinderTime(long j) {
            this.binderTime = j;
        }

        public long getProcessCpuTime() {
            return this.processCpuTime;
        }

        public long getProcessDuration() {
            return this.processDuration;
        }

        public List<ThreadTimeItem> getThreadTimeItems() {
            return this.threadTimeItems;
        }

        public String toString() {
            return "LaunchTraceData{gcCount=" + this.gcCount + ", gcTime=" + this.gcTime + ", blockGcCount=" + this.blockGcCount + ", blockGcTime=" + this.blockGcTime + ", cpuTime=" + this.cpuTime + ", voluntarySwitches=" + this.voluntarySwitches + ", inVoluntarySwitches=" + this.inVoluntarySwitches + ", iowaitTime=" + this.iowaitTime + ", runnableTime=" + this.runnableTime + ", sleepTime=" + this.sleepTime + ", minorFault=" + this.minorFault + ", majorFault=" + this.majorFault + ", allThreadCount=" + this.allThreadCount + ", javaThreadNameList=" + this.javaThreadNameList + ", lockTime=" + this.lockTime + ", binderTime=" + this.binderTime + '}';
        }
    }
}

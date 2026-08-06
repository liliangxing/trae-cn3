package com.bytedance.monitor.collector;

import android.util.Log;
import android.util.Pair;
import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.monitor.collector.IHyperMonitor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BinderMonitor extends AbsMonitor {
    private static final int MAX_INFO_SIZE = 200;
    private static final List<BinderInfo> sBinderInfoList = new ArrayList(200);
    private static final Object copyLock = new Object();
    private static volatile int sPos = 0;

    @Override // com.bytedance.monitor.collector.AbsMonitor
    protected void updateConfig(int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BinderMonitor(int i) {
        super(i, MonitorType.BINDER_MONITOR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enable() {
        MonitorJni.enableBinderHook();
    }

    void disable() {
        MonitorJni.disableBinderHook();
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public Pair<String, String> dumpInfo() {
        try {
            return new Pair<>(this.mCollectorType, sBinderInfoList.toString());
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public Pair<String, String> dumpInfosRange(long j, long j2) {
        try {
            return new Pair<>(this.mCollectorType, dumpBinderInfo(j, j2));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.monitor.collector.AbsMonitor
    public void dumpInfosToALog(long j, long j2, long j3) {
        IHyperMonitor.ILogInstance logInstance = PerfMonitorManager.getInstance().getLogInstance();
        if (logInstance != null) {
            String str = "perf" + this.mCollectorType;
            logInstance.m109i(str, "begin");
            logInstance.m109i(str, dumpBinderInfo(j - j3, j2));
            logInstance.m109i(str, MetricConstant.MONITOR_STAGE_LOAD_TEMPLATE);
        }
    }

    private String dumpBinderInfo(long j, long j2) {
        List<BinderInfo> binderInfoListCopy = getBinderInfoListCopy();
        ArrayList arrayList = new ArrayList();
        for (int size = binderInfoListCopy.size() - 1; size >= 0; size--) {
            BinderInfo binderInfo = binderInfoListCopy.get(size);
            if (binderInfo.begin > j2 || binderInfo.end > j) {
                arrayList.add(binderInfo);
            }
            if (binderInfo.end < j) {
                break;
            }
        }
        return arrayList.toString();
    }

    public List<BinderInfo> getBinderInfoListCopy() {
        ArrayList arrayList = new ArrayList();
        synchronized (copyLock) {
            for (int i = 0; i < 200; i++) {
                int i2 = ((sPos - 1) + i) % 200;
                List<BinderInfo> list = sBinderInfoList;
                if (i2 >= list.size()) {
                    break;
                }
                arrayList.add(list.get(((sPos - 1) + i) % 200));
            }
        }
        return arrayList;
    }

    public static void saveBinderInfo(long j, long j2, long j3) {
        addBinderInfo(j, j2, j3, Thread.currentThread().getStackTrace());
    }

    private static String getStacktrace() {
        return Log.getStackTraceString(new Exception());
    }

    private static void addBinderInfo(long j, long j2, long j3, StackTraceElement[] stackTraceElementArr) {
        synchronized (copyLock) {
            List<BinderInfo> list = sBinderInfoList;
            if (list.size() == 200) {
                BinderInfo binderInfo = list.get(sPos % 200);
                binderInfo.begin = j;
                binderInfo.end = j2;
                binderInfo.parcelSize = j3;
                binderInfo.elements = stackTraceElementArr;
            } else {
                BinderInfo binderInfo2 = new BinderInfo();
                binderInfo2.begin = j;
                binderInfo2.end = j2;
                binderInfo2.parcelSize = j3;
                binderInfo2.elements = stackTraceElementArr;
                list.add(binderInfo2);
            }
            sPos++;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class BinderInfo {
        long begin;
        StackTraceElement[] elements;
        long end;
        long parcelSize;

        public long getBegin() {
            return this.begin;
        }

        public long getEnd() {
            return this.end;
        }

        public StackTraceElement[] getElements() {
            return this.elements;
        }

        public String toString() {
            return "{\"start\":" + this.begin + ",\"end\":" + this.end + ",\"parcel_size\":" + this.parcelSize + ",\"cost_millis\":" + (this.end - this.begin) + ",\"java_stack\":\"" + Util.stackToStringWithESC(BinderMonitor.removeUselessStackTrace(this.elements)) + "\"}";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static StackTraceElement[] removeUselessStackTrace(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return stackTraceElementArr;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= stackTraceElementArr.length) {
                break;
            }
            if ("saveBinderInfo".equals(stackTraceElementArr[i2].getMethodName())) {
                i = i2;
                break;
            }
            i2++;
        }
        int i3 = i + 1;
        return i3 <= stackTraceElementArr.length ? (StackTraceElement[]) Arrays.copyOfRange(stackTraceElementArr, i3, stackTraceElementArr.length) : stackTraceElementArr;
    }
}

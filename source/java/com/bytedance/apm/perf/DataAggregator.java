package com.bytedance.apm.perf;

import android.util.Log;
import com.bytedance.apm.logging.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Deprecated
/* loaded from: classes3.dex */
public class DataAggregator {
    private static final String TAG = "DataAggregator";
    private final HashMap<String, CpuItem> mTimerInfo = new HashMap<>();

    private void sendData(String str, double d, double d2, double d3, double d4) {
    }

    public void init() {
    }

    public static DataAggregator getInstance() {
        return Holder.sInstance;
    }

    /* loaded from: classes3.dex */
    private static class Holder {
        private static final DataAggregator sInstance = new DataAggregator();

        private Holder() {
        }
    }

    /* loaded from: classes3.dex */
    public static class CpuItem {
        long firstTs;
        double metricCpuStats;
        double metricMaxCpuStats;
        double metricMaxRate;
        double metricRate;
        String sceneString;
        String service;
        Map<String, String> tagMap;
        int times = 1;

        public CpuItem(String str, long j, double d, double d2, double d3, double d4) {
            this.service = str;
            this.metricRate = d;
            this.metricCpuStats = d3;
            this.metricMaxCpuStats = d4;
            this.firstTs = j;
        }

        public CpuItem injectScene(String str) {
            this.sceneString = str;
            return this;
        }

        private CpuItem injectTags(Map<String, String> map) {
            this.tagMap = map;
            return this;
        }

        public String toString() {
            return "CpuItem{service='" + this.service + "', metricRate=" + this.metricRate + ", metricMaxRate=" + this.metricMaxRate + ", metricCpuStats=" + this.metricCpuStats + ", metricMaxCpuStats=" + this.metricMaxCpuStats + ", sceneString='" + this.sceneString + "', tagMap=" + this.tagMap + ", firstTs=" + this.firstTs + ", times=" + this.times + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public void enqueuePerfLog(double d, double d2, double d3, double d4) {
        String str = PerfFilterManager.getInstance().getSceneString();
        CpuItem cpuItem = this.mTimerInfo.get(str);
        if (cpuItem == null) {
            CpuItem cpuItem2 = new CpuItem("cpu", System.currentTimeMillis(), d, d2, d3, d4);
            cpuItem2.injectScene(PerfFilterManager.getInstance().getSceneString());
            this.mTimerInfo.put(str, cpuItem2);
            return;
        }
        cpuItem.times++;
        cpuItem.metricCpuStats += d3;
        cpuItem.metricRate += d;
        if (cpuItem.metricRate < d) {
            cpuItem.metricRate = d;
        }
        if (cpuItem.metricCpuStats < d3) {
            cpuItem.metricCpuStats = d3;
        }
        this.mTimerInfo.put(str, cpuItem);
    }

    public void handleCpuTimer(long j) {
        long j2;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this.mTimerInfo) {
                if (!this.mTimerInfo.isEmpty()) {
                    Iterator<Map.Entry<String, CpuItem>> it = this.mTimerInfo.entrySet().iterator();
                    while (it.hasNext()) {
                        CpuItem value = it.next().getValue();
                        Logger.d("CpuApm2", "cache data: " + value);
                        if (currentTimeMillis - value.firstTs > j) {
                            it.remove();
                            double d = value.metricRate / value.times;
                            double d2 = value.metricMaxRate / value.times;
                            double d3 = value.metricCpuStats / value.times;
                            double d4 = value.metricMaxCpuStats / value.times;
                            j2 = currentTimeMillis;
                            Logger.d("CpuApm2", "assemble cpu data, rate: " + d + " maxRate: " + d2 + " speed: " + d3 + " maxSpeed: " + d4);
                            sendData(value.sceneString, d, d2, d3, d4);
                        } else {
                            j2 = currentTimeMillis;
                        }
                        currentTimeMillis = j2;
                    }
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "handleLogToQueue function failed :" + e.toString());
        }
    }
}

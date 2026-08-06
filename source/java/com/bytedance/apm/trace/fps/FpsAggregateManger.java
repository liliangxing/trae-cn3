package com.bytedance.apm.trace.fps;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.FpsUtil;
import com.bytedance.apm6.perf.base.CommonDataAssembly;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class FpsAggregateManger implements AsyncEventManager.IMonitorTimeTask {
    private static final long AGGREGATE_INTERVAL = 120000;
    private static final String TAG = "FpsAggregateManger";
    private boolean mNeedUploadDeviceFpsInfo;
    private final HashMap<String, AggregateTask> sTimerInfo;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class AggregateTask {
        public Map<String, String> tags;
        public String type;
        public float value;
        private long firstTime = System.currentTimeMillis();
        private int times = 1;

        AggregateTask(Map<String, String> map, String str, float f) {
            this.tags = map;
            this.type = str;
            this.value = f;
        }

        void append(float f) {
            this.value += f;
            this.times++;
        }

        float avg() {
            int i = this.times;
            if (i > 0) {
                return this.value / i;
            }
            return -1.0f;
        }

        boolean isTimeUp(long j) {
            return j - this.firstTime > 120000;
        }
    }

    private FpsAggregateManger() {
        this.sTimerInfo = new HashMap<>();
        this.mNeedUploadDeviceFpsInfo = true;
        AsyncEventManager.getInstance().addTimeTask(this);
    }

    public static FpsAggregateManger getInstance() {
        return Holder.sInstance;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class Holder {
        private static final FpsAggregateManger sInstance = new FpsAggregateManger();

        private Holder() {
        }
    }

    public void aggregate(final Map<String, String> map, final String str, final float f) {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.trace.fps.FpsAggregateManger.1
            @Override // java.lang.Runnable
            public void run() {
                AggregateTask aggregateTask = (AggregateTask) FpsAggregateManger.this.sTimerInfo.get(str);
                if (aggregateTask == null) {
                    FpsAggregateManger.this.sTimerInfo.put(str, new AggregateTask(map, str, f));
                } else {
                    aggregateTask.append(f);
                }
            }
        });
    }

    @Override // com.bytedance.apm.thread.AsyncEventManager.IMonitorTimeTask
    public void onTimeEvent(long j) {
        if (this.sTimerInfo.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, AggregateTask>> it = this.sTimerInfo.entrySet().iterator();
        int refreshRate = FpsUtil.getRefreshRate();
        while (it.hasNext()) {
            Map.Entry<String, AggregateTask> next = it.next();
            String key = next.getKey();
            AggregateTask value = next.getValue();
            if (value.isTimeUp(j)) {
                it.remove();
                float avg = value.avg();
                if (ApmContext.isDebugMode()) {
                    Logger.m88i(DebugLogger.TAG_PERF, "aggregate fps: " + key + " , value: " + avg);
                }
                if (avg > 0.0f) {
                    float f = refreshRate;
                    if (avg > f) {
                        avg = f;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("fps", avg);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("scene", key);
                        PerfData perfData = new PerfData("fps", key, jSONObject, jSONObject2, null);
                        CommonDataAssembly.wrapFilters(perfData, true);
                        JSONObject jSONObject3 = perfData.filters;
                        jSONObject3.put(CommonKey.KEY_REFRESH_RATE, refreshRate);
                        if (this.mNeedUploadDeviceFpsInfo) {
                            this.mNeedUploadDeviceFpsInfo = false;
                            jSONObject3.put(CommonKey.KEY_DEVICE_MAX_REFRESH_RATE, FpsUtil.getDeviceMaxRefreshRate());
                            jSONObject3.put(CommonKey.KEY_REFRESH_RATE_RESTRICTED, FpsUtil.isUsingMaxRefreshRate() ? false : true);
                        }
                        if (value.tags != null && !value.tags.isEmpty()) {
                            for (Map.Entry<String, String> entry : value.tags.entrySet()) {
                                perfData.filters.put(entry.getKey(), entry.getValue());
                            }
                        }
                        CommonDataPipeline.getInstance().handle(perfData);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }
}

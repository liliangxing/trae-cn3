package com.bytedance.apm.block.trace;

import android.view.FrameMetrics;
import com.bytedance.apm.battery.config.BatteryFactorConfig;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.trace.fps.FpsAggregateManger;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.bytedance.apm.trace.fps.RealFpsTracer;
import com.bytedance.apm.util.FpsUtil;
import com.bytedance.bdinstall.GWorker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class FrameTracer extends AbsTracer {
    private static final String TAG = "FrameTracer";
    private static boolean sNeedMonitorActivity;
    private final long timeSliceMs = GWorker.INTERVAL;
    private final ArrayList<RealFpsTracer> fpsTracerList = new ArrayList<>();
    private HashMap<String, FrameCollectItem> map = new HashMap<>();
    private BlockCollectItem blockCollectItem = new BlockCollectItem();

    public FrameTracer() {
        MainThreadMonitor.getMonitor().setFullFpsTracer(true);
        FpsTracer.setFullFpsTracer(true);
    }

    public static void setsNeedMonitorActivity(boolean z) {
        sNeedMonitorActivity = z;
    }

    @Override // com.bytedance.apm.block.AbsLooperObserver
    public void doFrame(String str, long j, long j2) {
        super.doFrame(str, j, j2);
        long j3 = j2 - j;
        doDropCompute(str, j3);
        for (int i = 0; i < this.fpsTracerList.size(); i++) {
            this.fpsTracerList.get(i).doDropCompute(j3);
        }
    }

    @Override // com.bytedance.apm.block.AbsLooperObserver
    public void onFrameMetricsAvailable(String str, long j, int i) {
        doDropCompute(str, j);
        for (int i2 = 0; i2 < this.fpsTracerList.size(); i2++) {
            this.fpsTracerList.get(i2).doDropCompute(j);
        }
    }

    @Override // com.bytedance.apm.block.AbsLooperObserver
    public void onFrameMetricsAvailable(String str, FrameMetrics frameMetrics, int i) {
        long metric = (((((frameMetrics.getMetric(0) + frameMetrics.getMetric(1)) + frameMetrics.getMetric(2)) + frameMetrics.getMetric(3)) + frameMetrics.getMetric(4)) + frameMetrics.getMetric(5)) / BatteryFactorConfig.WIFI_BPS;
        doDropCompute(str, metric);
        for (int i2 = 0; i2 < this.fpsTracerList.size(); i2++) {
            this.fpsTracerList.get(i2).doDropCompute(metric);
        }
    }

    public void doBlock(final long j, final boolean z) {
        MainThreadMonitor.getMonitor().mThreadWithBlockingQueue.post(new Runnable() { // from class: com.bytedance.apm.block.trace.FrameTracer.1
            @Override // java.lang.Runnable
            public void run() {
                FrameTracer.this.blockCollectItem.collect(j, z);
                for (int i = 0; i < FrameTracer.this.fpsTracerList.size(); i++) {
                    ((RealFpsTracer) FrameTracer.this.fpsTracerList.get(i)).doBlock(j, z);
                }
            }
        });
    }

    public void addFpsTracer(final RealFpsTracer realFpsTracer) {
        MainThreadMonitor.getMonitor().mThreadWithBlockingQueue.post(new Runnable() { // from class: com.bytedance.apm.block.trace.FrameTracer.2
            @Override // java.lang.Runnable
            public void run() {
                FrameTracer.this.fpsTracerList.add(realFpsTracer);
            }
        });
    }

    public void removeFpsTracer(final RealFpsTracer realFpsTracer) {
        MainThreadMonitor.getMonitor().mThreadWithBlockingQueue.post(new Runnable() { // from class: com.bytedance.apm.block.trace.FrameTracer.3
            @Override // java.lang.Runnable
            public void run() {
                FrameTracer.this.fpsTracerList.remove(realFpsTracer);
            }
        });
    }

    private void doDropCompute(String str, long j) {
        if (!sNeedMonitorActivity || j <= 0) {
            return;
        }
        FrameCollectItem frameCollectItem = this.map.get(str);
        if (frameCollectItem == null) {
            frameCollectItem = new FrameCollectItem(str);
            this.map.put(str, frameCollectItem);
        }
        frameCollectItem.collect(j);
        if (frameCollectItem.sumFrameCost >= GWorker.INTERVAL) {
            this.map.remove(str);
            frameCollectItem.report();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class FrameCollectItem {
        int[] dropLevel;
        int maxDropCount;
        int sumDroppedFrames;
        int sumFrame = 0;
        long sumFrameCost;
        String visibleScene;

        FrameCollectItem(String str) {
            this.visibleScene = str;
            int refreshRate = FpsUtil.getRefreshRate() - 1;
            this.maxDropCount = refreshRate;
            this.dropLevel = new int[(refreshRate - 0) + 1];
        }

        void collect(long j) {
            float frameIntervalMillis = FpsUtil.getFrameIntervalMillis();
            this.sumFrameCost += j;
            int min = Math.min(Math.max((int) (((float) j) / frameIntervalMillis), 0), this.maxDropCount);
            int[] iArr = this.dropLevel;
            iArr[min] = iArr[min] + 1;
            this.sumDroppedFrames += min;
            this.sumFrame++;
        }

        void report() {
            try {
                float frameIntervalMillis = FpsUtil.getFrameIntervalMillis();
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i <= this.maxDropCount; i++) {
                    if (this.dropLevel[i] > 0) {
                        jSONObject.put(String.valueOf(i), this.dropLevel[i]);
                    }
                }
                FpsAggregateManger.getInstance().aggregate(null, this.visibleScene, (float) ((((this.sumFrame * 100) * FpsUtil.getRefreshRate()) / (this.sumFrame + this.sumDroppedFrames)) / 100.0d));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("scene", this.visibleScene);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(RealFpsTracer.SCROLL_TIME, this.sumFrameCost);
                jSONObject3.put(CommonKey.KEY_DROP_RATE, 1.0f - ((this.sumFrame * 1.0f) / ((int) (((float) this.sumFrameCost) / frameIntervalMillis))));
                jSONObject3.put(CommonKey.KEY_REFRESH_RATE, this.maxDropCount + 1);
                CommonDataPipeline.getInstance().handle(new PerfData("fps_drop", this.visibleScene, jSONObject, jSONObject2, jSONObject3));
            } catch (Throwable unused) {
            }
            this.sumFrame = 0;
            this.sumDroppedFrames = 0;
            this.sumFrameCost = 0L;
        }

        public String toString() {
            return "visibleScene=" + this.visibleScene + ", sumFrame=" + this.sumFrame + ", sumDroppedFrames=" + this.sumDroppedFrames + ", sumFrameCost=" + this.sumFrameCost + ", dropLevel=" + Arrays.toString(this.dropLevel);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class BlockCollectItem {
        public int frameBlockCount = 0;
        public int blockCount = 0;
        public long blockDuration = 0;

        public void collect(long j, boolean z) {
            if (z) {
                this.frameBlockCount++;
            }
            this.blockCount++;
            this.blockDuration += j;
        }
    }
}

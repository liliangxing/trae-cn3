package com.bytedance.article.common.monitor;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.battery.config.BatteryFactorConfig;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.thread.AsyncEventManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class MonitorFPS {
    private static final long FAKE_FRAME_TIME = 10;
    private static final Long MONITOR_INTERVAL;
    private static final Long MONITOR_INTERVAL_NANOS;
    private static HashMap<String, AggregateFpsTimer> mTimerInfo;
    private Choreographer.FrameCallback mFrameCallback;
    private IFPSCallBack mIFPSCallBack;
    private String mType;
    private static final Long MAX_INTERVAL = 1000L;
    private static int INTEVERAL = 120;
    private static AsyncEventManager.IMonitorTimeTask fpsTimerTask = new AsyncEventManager.IMonitorTimeTask() { // from class: com.bytedance.article.common.monitor.MonitorFPS.3
        @Override // com.bytedance.apm.thread.AsyncEventManager.IMonitorTimeTask
        public void onTimeEvent(long j) {
            if (MonitorFPS.mTimerInfo.isEmpty()) {
                return;
            }
            long j2 = j / 1000;
            Iterator it = MonitorFPS.mTimerInfo.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                AggregateFpsTimer aggregateFpsTimer = (AggregateFpsTimer) entry.getValue();
                if (j2 - aggregateFpsTimer.firstTime >= MonitorFPS.INTEVERAL) {
                    it.remove();
                    float f = aggregateFpsTimer.value / aggregateFpsTimer.times;
                    if (ApmContext.isDebugMode()) {
                        Logger.m88i(DebugLogger.TAG_PERF, "agg fps: " + str + " , value: " + f);
                    }
                    if (f > 60.0f) {
                        f = 60.0f;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("fps", f);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("scene", str);
                        ApmAgent.monitorPerformance("fps", str, jSONObject, jSONObject2, null);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    };
    private FPSRecordView mFPSFpsRecordView = null;
    private WindowManager mWindowManager = null;
    private volatile boolean mFPSState = false;
    private IFrameCallBack mIFrameCallBack = null;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface IFPSCallBack {
        void fpsCallBack(double d);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface IFrameCallBack {
        void onFrame(long j);
    }

    static {
        Long l = 200L;
        MONITOR_INTERVAL = l;
        MONITOR_INTERVAL_NANOS = Long.valueOf(l.longValue() * 1000 * 1000);
        AsyncEventManager.getInstance().addTimeTask(fpsTimerTask);
        mTimerInfo = new HashMap<>();
    }

    public MonitorFPS(Context context, String str) {
        this.mType = str;
    }

    public void setIFrameCallBack(IFrameCallBack iFrameCallBack) {
        this.mIFrameCallBack = iFrameCallBack;
    }

    public boolean getMonitorFPSStatus() {
        return this.mFPSState;
    }

    public void setIFPSCallBack(IFPSCallBack iFPSCallBack) {
        this.mIFPSCallBack = iFPSCallBack;
    }

    public synchronized void stop() {
        if (this.mFPSState) {
            this.mFPSState = false;
            if (this.mFrameCallback != null) {
                Choreographer.getInstance().removeFrameCallback(this.mFrameCallback);
            }
        }
    }

    public void start() {
        if (this.mFPSState) {
            return;
        }
        this.mFPSState = true;
        startJellyBean();
    }

    private void startBase() {
        this.mFPSFpsRecordView.mStartTime = -1L;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2005, 0, -3);
        layoutParams.gravity = 51;
        layoutParams.flags = 24;
        layoutParams.height = 1;
        layoutParams.width = 1;
        try {
            this.mWindowManager.removeView(this.mFPSFpsRecordView);
        } catch (Exception unused) {
        }
        this.mWindowManager.addView(this.mFPSFpsRecordView, layoutParams);
        this.mFPSFpsRecordView.postDelayed(new Runnable() { // from class: com.bytedance.article.common.monitor.MonitorFPS.1
            @Override // java.lang.Runnable
            public void run() {
                if (MonitorFPS.this.mFPSState) {
                    MonitorFPS.this.mFPSFpsRecordView.invalidate();
                    MonitorFPS.this.mFPSFpsRecordView.postDelayed(this, 10L);
                }
            }
        }, 10L);
    }

    private void startJellyBean() {
        this.mFrameCallback = new Choreographer.FrameCallback() { // from class: com.bytedance.article.common.monitor.MonitorFPS.2
            private long mStartTime = -1;
            private int mCounter = 0;

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                if (this.mStartTime == -1) {
                    this.mStartTime = j;
                }
                if (MonitorFPS.this.mIFrameCallBack != null) {
                    MonitorFPS.this.mIFrameCallBack.onFrame(j / BatteryFactorConfig.WIFI_BPS);
                }
                long j2 = j - this.mStartTime;
                if (j2 > MonitorFPS.MONITOR_INTERVAL_NANOS.longValue()) {
                    double longValue = (((this.mCounter * 1000) * 1000) / j2) * MonitorFPS.MAX_INTERVAL.longValue();
                    if (MonitorFPS.this.mIFPSCallBack != null) {
                        MonitorFPS.this.mIFPSCallBack.fpsCallBack(longValue);
                    }
                    MonitorFPS.monitorFPSOnTimer(MonitorFPS.this.mType, (float) longValue);
                    MonitorFPS.this.mFPSState = false;
                    return;
                }
                this.mCounter++;
                Choreographer.getInstance().postFrameCallback(this);
            }
        };
        Choreographer.getInstance().postFrameCallback(this.mFrameCallback);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private class FPSRecordView extends View {
        private int mCounter;
        private long mStartTime;

        public FPSRecordView(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.mCounter = 0;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.mStartTime == -1) {
                this.mStartTime = SystemClock.elapsedRealtime();
                this.mCounter = 0;
            }
            if (MonitorFPS.this.mIFrameCallBack != null) {
                MonitorFPS.this.mIFrameCallBack.onFrame(SystemClock.elapsedRealtime());
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.mStartTime;
            if (elapsedRealtime > MonitorFPS.MONITOR_INTERVAL.longValue()) {
                double longValue = (this.mCounter / elapsedRealtime) * MonitorFPS.MAX_INTERVAL.longValue();
                if (MonitorFPS.this.mIFPSCallBack != null) {
                    MonitorFPS.this.mIFPSCallBack.fpsCallBack(longValue);
                }
                MonitorFPS.monitorFPSOnTimer(MonitorFPS.this.mType, (float) longValue);
                MonitorFPS.this.stop();
            }
            this.mCounter++;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class AggregateFpsTimer {
        public long firstTime;
        public int times;
        public float value;

        public AggregateFpsTimer(int i, float f, long j) {
            this.times = i;
            this.value = f;
            this.firstTime = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void monitorFPSOnTimer(final String str, final float f) {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.article.common.monitor.MonitorFPS.4
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                String str2 = str;
                AggregateFpsTimer aggregateFpsTimer = (AggregateFpsTimer) MonitorFPS.mTimerInfo.get(str2);
                if (aggregateFpsTimer == null) {
                    aggregateFpsTimer = new AggregateFpsTimer(1, f, currentTimeMillis);
                } else {
                    aggregateFpsTimer.value += f;
                    aggregateFpsTimer.times++;
                }
                MonitorFPS.mTimerInfo.put(str2, aggregateFpsTimer);
                if (ApmContext.isDebugMode()) {
                    Logger.m88i(DebugLogger.TAG_PERF, "fps: " + str + " , value: " + f);
                }
            }
        });
    }
}

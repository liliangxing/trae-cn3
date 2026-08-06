package com.bytedance.crash.diagnose;

import android.os.SystemClock;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.runtime.DefaultWorkThread;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class InitMonitor {
    private static InitMonitor sInstance;
    private final JSONObject mJsonObject = new JSONObject();
    private long mLastStepTime;
    private final long mStartTime;

    private InitMonitor() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mStartTime = uptimeMillis;
        this.mLastStepTime = uptimeMillis;
    }

    public static void start() {
        if (sInstance == null) {
            sInstance = new InitMonitor();
        }
    }

    public static void step(String str) {
        if (sInstance == null) {
            return;
        }
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            InitMonitor initMonitor = sInstance;
            initMonitor.mJsonObject.put(str, uptimeMillis - initMonitor.mLastStepTime);
            sInstance.mLastStepTime = uptimeMillis;
        } catch (Throwable unused) {
        }
    }

    public static void end() {
        if (sInstance == null) {
            return;
        }
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            InitMonitor initMonitor = sInstance;
            initMonitor.mJsonObject.put(PerfConsts.PERF_DISK_TOTAL, uptimeMillis - initMonitor.mStartTime);
        } catch (Throwable unused) {
        }
        DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.diagnose.InitMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                InitMonitor.upload();
            }
        });
    }

    public static void upload() {
        if (sInstance != null) {
            new NpthMonitor.Event("npthStart").addMetrics(sInstance.mJsonObject).upload();
            sInstance = null;
        }
    }
}

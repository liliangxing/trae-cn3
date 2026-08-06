package com.bytedance.crash;

import android.content.Context;
import com.bytedance.crash.alog.AlogManager;
import com.bytedance.crash.monitor.AppMonitorConfigService;
import com.bytedance.crash.monitor.CrashListener;
import com.bytedance.crash.monitor.EventConfigService;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.util.ActivityUtils;
import java.io.File;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Flavor {
    public static final boolean isTob = false;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class Tob {
        public static boolean ensureEnable(String str) {
            return false;
        }

        public static void onUpload(File file, CrashType crashType, JSONObject jSONObject) {
        }

        public static void putSpecialCrashBody(JSONObject jSONObject, File file, CrashType crashType) {
        }

        public static JSONArray saveAllData(CrashType crashType, StackTraceElement[] stackTraceElementArr, File file) {
            return null;
        }

        public static JSONArray saveAllData(String str, File file) {
            return null;
        }
    }

    public static void startAppMonitor(Context context, final CrashListener crashListener) {
        NpthCore.initForCrashMonitor(context, Global.getRootDirectory());
        DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.Flavor.1
            @Override // java.lang.Runnable
            public void run() {
                new AppMonitorConfigService(CrashListener.this).init();
            }
        });
    }

    public static void startEventMonitor(Context context, final CrashListener crashListener) {
        NpthCore.initForCrashMonitor(context, Global.getRootDirectory());
        DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.Flavor.2
            @Override // java.lang.Runnable
            public void run() {
                new EventConfigService(CrashListener.this).init();
            }
        });
    }

    public static void dumpAppLog(File file) {
        AlogManager.flushData();
    }

    public static void setActivityImpl() {
        try {
            ActivityUtils.setActivityImpl(new Callable<JSONArray>() { // from class: com.bytedance.crash.Flavor.3
                @Override // java.util.concurrent.Callable
                public JSONArray call() {
                    return ActivityLifecycle.getLifecycleTrack();
                }
            });
        } catch (Throwable unused) {
        }
    }
}

package com.bytedance.apm.battery;

import android.app.Activity;
import android.os.BatteryManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.perf.AbstractPerfCollector;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.CommonMonitorUtil;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.bdturing.EventReport;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ProcessEnergyCollector extends AbstractPerfCollector {
    private static final boolean DEBUG = false;
    private static final long DEFAULT_BATTERY_MONITOR_INTERVAL_MS = 300000;
    private static final long DEFAULT_CPU_MONITOR_INTERVAL = 60000;
    private static final long DEFAULT_PROC_CPU_UPLOAD_INTERVAL_MS = 120000;
    private static final String TAG = "ProcessEnergyCollector";
    private long mBatteryMonitorIntervalMs;
    private long mCpuMonitorIntervalMs;
    private boolean mPowerMonitorEnabled;
    private long mProcCpuUploadIntervalMs;
    private long mUploadUpdateTime;
    private final ConcurrentHashMap<String, Long> mSceneMinDuration = new ConcurrentHashMap<>();
    private final LinkedList<SceneStackItem> mSceneStack = new LinkedList<>();
    private final LinkedList<SceneStackItem> mProcCpuInfos = new LinkedList<>();
    private int mSwitchCounter = 0;
    long mLastProcCpuTimeMs = 0;
    long mLastGetProcCpuTime = 0;
    int mLastFrontSwitch = 0;
    int mLastBatteryLevel = 0;
    long mLastBatteryUpdateTime = 0;
    long mLastBatteryUpdateSwitchCount = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class SceneStackItem {
        public long endCpuTimeMs;
        public long endTimeMs;
        public String sceneName;
        public long startCpuTimeMs;
        public long startTimeMs;

        private SceneStackItem() {
        }

        public long getDuration() {
            return this.endTimeMs - this.startTimeMs;
        }

        public long getCpuTime() {
            return this.endCpuTimeMs - this.startCpuTimeMs;
        }

        public double getCpuSpeed() {
            if (getDuration() / 1000.0d > 0.0d) {
                return (Math.round(getCpuTime() / r0) * 100) / 100.0d;
            }
            return 0.0d;
        }

        public String toString() {
            return String.format("Scene{ name=%s, cpu=%s ms, dur=%s ms, speed=%s", this.sceneName, Long.valueOf(getCpuTime()), Long.valueOf(getDuration()), Double.valueOf(getCpuSpeed()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Holder {
        private static final ProcessEnergyCollector INSTANCE = new ProcessEnergyCollector();

        private Holder() {
        }
    }

    public static ProcessEnergyCollector getInstance() {
        return Holder.INSTANCE;
    }

    public ProcessEnergyCollector() {
        this.mCollectorSettingKey = "battery";
    }

    public void configSceneMinDuration(HashMap<String, Long> hashMap) {
        this.mSceneMinDuration.putAll(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void doConfig(JSONObject jSONObject) {
        boolean z = jSONObject.optInt(SlardarSettingsConsts.PER_POWER_MONITOR_ENABLE, 0) == 1;
        this.mPowerMonitorEnabled = z;
        if (z) {
            this.mCpuMonitorIntervalMs = jSONObject.optLong(SlardarSettingsConsts.PER_POWER_CPU_MONITOR_INTERVAL, 60000L);
            this.mBatteryMonitorIntervalMs = jSONObject.optLong(SlardarSettingsConsts.PER_POWER_BATTERY_MONITOR_INTERVAL, 300000L);
            this.mProcCpuUploadIntervalMs = jSONObject.optLong(SlardarSettingsConsts.PER_POWER_PROC_CPU_UPLOAD_INTERVAL, 120000L);
        } else {
            ActivityLifeObserver.getInstance().unregister(this);
            AsyncEventManager.getInstance().removeTimeTask(this);
        }
    }

    public void startScene(String str) {
        if (!this.mPowerMonitorEnabled || TextUtils.isEmpty(str)) {
            return;
        }
        SceneStackItem sceneStackItem = new SceneStackItem();
        sceneStackItem.startTimeMs = SystemClock.uptimeMillis();
        sceneStackItem.startCpuTimeMs = CommonMonitorUtil.getAppCPUTime();
        sceneStackItem.sceneName = str;
        if (sceneStackItem.startCpuTimeMs <= 0) {
            return;
        }
        synchronized (this.mSceneStack) {
            this.mSceneStack.push(sceneStackItem);
        }
    }

    public void stopScene(String str) {
        SceneStackItem pop;
        if (!this.mPowerMonitorEnabled || TextUtils.isEmpty(str)) {
            return;
        }
        while (this.mSceneStack.size() != 0) {
            synchronized (this.mSceneStack) {
                pop = this.mSceneStack.pop();
            }
            if (pop != null && pop.sceneName.equals(str)) {
                pop.endTimeMs = SystemClock.uptimeMillis();
                pop.endCpuTimeMs = CommonMonitorUtil.getAppCPUTime();
                if (pop.endCpuTimeMs <= 0) {
                    return;
                }
                Long l = this.mSceneMinDuration.get(pop.sceneName);
                if (l == null || pop.getDuration() >= l.longValue()) {
                    synchronized (this.mProcCpuInfos) {
                        this.mProcCpuInfos.add(pop);
                    }
                    return;
                }
                return;
            }
            if (pop != null) {
                Logger.m119d(TAG, String.format("Unexpected scene, top: %s, cur:%s", pop.sceneName, str));
            }
        }
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onFront(Activity activity) {
        super.onFront(activity);
        this.mSwitchCounter++;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onBackground(Activity activity) {
        super.onBackground(activity);
        this.mSwitchCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onStart() {
        super.onStart();
        caculateCpuInfo();
        caculateBatteryInfo();
        uploadProcCpuData();
    }

    public void caculateCpuInfo() {
        long appCPUTime = CommonMonitorUtil.getAppCPUTime();
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.mLastGetProcCpuTime != 0 && this.mLastFrontSwitch == this.mSwitchCounter) {
            if ((uptimeMillis - r4) / 60000.0d > 0.0d) {
                double round = Math.round(((appCPUTime - this.mLastProcCpuTimeMs) / r4) * 100.0d) / 100.0d;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("status", isBackground() ? EventReport.DIALOG_BACKGROUND : "foreground");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("cpu_speed_min", round);
                    CommonEventDeliverer.monitorEvent("apm_cpu_speed", jSONObject, jSONObject2, null);
                } catch (Exception unused) {
                }
            }
        }
        this.mLastFrontSwitch = this.mSwitchCounter;
        this.mLastProcCpuTimeMs = appCPUTime;
        this.mLastGetProcCpuTime = uptimeMillis;
    }

    private void caculateBatteryInfo() {
        int abs;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = this.mLastBatteryUpdateTime;
        if (this.mBatteryMonitorIntervalMs + j > uptimeMillis) {
            return;
        }
        long j2 = uptimeMillis - j;
        this.mLastBatteryUpdateTime = uptimeMillis;
        int intProperty = ((BatteryManager) ApmContext.getContext().getSystemService("batterymanager")).getIntProperty(4);
        int i = intProperty - this.mLastBatteryLevel;
        if (this.mLastBatteryUpdateSwitchCount == this.mSwitchCounter && !isBackground() && i <= 0 && (abs = Math.abs(i)) <= 100) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("battery", Math.abs(abs));
                jSONObject.put("duraion", j2);
                CommonEventDeliverer.monitorEvent("apm_battery_monitor", null, jSONObject, null);
            } catch (Exception unused) {
            }
        }
        this.mLastBatteryLevel = intProperty;
        this.mLastBatteryUpdateSwitchCount = this.mSwitchCounter;
    }

    private void uploadProcCpuData() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.mUploadUpdateTime + this.mProcCpuUploadIntervalMs > uptimeMillis) {
            return;
        }
        this.mUploadUpdateTime = uptimeMillis;
        synchronized (this.mProcCpuInfos) {
            Iterator<SceneStackItem> it = this.mProcCpuInfos.iterator();
            while (it.hasNext()) {
                SceneStackItem next = it.next();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("scene", next.sceneName);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("cpu_speed", next.getCpuSpeed());
                    CommonEventDeliverer.monitorEvent("apm_proc_cpu_info", jSONObject, jSONObject2, null);
                } catch (Exception unused) {
                }
            }
            this.mProcCpuInfos.clear();
        }
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected boolean isTimerMonitor() {
        return this.mPowerMonitorEnabled;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected long workInternalMs() {
        return this.mCpuMonitorIntervalMs;
    }
}

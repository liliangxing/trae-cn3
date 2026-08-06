package com.bytedance.apm.battery;

import android.app.Activity;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.agent.p003v2.instrumentation.BatteryAgent;
import com.bytedance.apm.battery.config.BatteryDetectConfig;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.hook.BinderHookHelper;
import com.bytedance.apm.battery.internal.BatteryDataManager;
import com.bytedance.apm.battery.stats.BatteryAlarmStatsImpl;
import com.bytedance.apm.battery.stats.BatteryConsumeStatsImpl;
import com.bytedance.apm.battery.stats.BatteryCpuStatsImpl;
import com.bytedance.apm.battery.stats.BatteryLocStatsImpl;
import com.bytedance.apm.battery.stats.BatteryPacketsStatsImpl;
import com.bytedance.apm.battery.stats.BatteryTrafficAllInterface;
import com.bytedance.apm.battery.stats.BatteryTrafficStatsImpl;
import com.bytedance.apm.battery.stats.BatteryWakeLockStatsImpl;
import com.bytedance.apm.battery.stats.IBatteryStats;
import com.bytedance.apm.battery.util.BatteryUtils;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.perf.AbstractPerfCollector;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.CommonMonitorUtil;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm.util.ParseUtils;
import com.bytedance.apm.util.ThreadTimeItem;
import com.bytedance.bdturing.EventReport;
import com.bytedance.monitor.util.thread.AsyncTaskType;
import com.bytedance.monitor.util.thread.TaskRunnable;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BatteryCollector extends AbstractPerfCollector implements BatteryUtils.ChargeListener {
    private static final long BACK_RECORD_INTERVAL = 10;
    private static final long DEFAULT_REPORT_INTERVAL = 30;
    public static final String TAG = "BatteryCollector";
    private static final Object innerLock = new Object();
    private volatile boolean isFront;
    private String[] mActivityNameToReport;
    private final Map<String, IBatteryStats> mBatteryStatsMap;
    private HashMap<String, Integer> mCPUMonitorConfigMap;
    private volatile boolean mCollectEnable;
    private String mCurSceneSetStr;
    private boolean mEnableLocalRecord;
    private volatile boolean mEnableTrace;
    private boolean mIsCharging;
    private long mJiffyHz;
    private String mLastOnFrontActivity;
    private volatile long mLastReportTime;
    private volatile long mLastStatusSampleTime;
    private int mMaxSupportApiLevel;
    private volatile long mRecordInterval;
    private volatile long mReportInterval;
    private List<String> mSceneBlackList;
    private List<String> mSceneList;
    private HashMap<Integer, ThreadTimeItem> mThreadCostRecord;
    private final TaskRunnable mTimerRunnable;
    private final TaskRunnable mUpdateThreadRecordRunnable;
    private HashMap<Integer, ThreadTimeItem> pageInThreadState;

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected boolean isTimerMonitor() {
        return false;
    }

    private BatteryCollector() {
        this.mBatteryStatsMap = new ConcurrentHashMap();
        this.mLastStatusSampleTime = -1L;
        this.mCollectEnable = false;
        this.mReportInterval = 30L;
        this.mLastReportTime = -1L;
        this.mMaxSupportApiLevel = 32;
        this.mActivityNameToReport = new String[2];
        this.mSceneList = new ArrayList();
        this.pageInThreadState = new HashMap<>();
        this.mThreadCostRecord = new HashMap<>();
        this.mCPUMonitorConfigMap = new HashMap<>();
        this.mTimerRunnable = new TaskRunnable() { // from class: com.bytedance.apm.battery.BatteryCollector.7
            public String getTaskName() {
                return "BatteryCollector-mTimerRunnable";
            }

            public AsyncTaskType getTaskType() {
                return AsyncTaskType.LIGHT_WEIGHT;
            }

            public void run() {
                BatteryCollector.this.onStart();
            }
        };
        this.mUpdateThreadRecordRunnable = new TaskRunnable() { // from class: com.bytedance.apm.battery.BatteryCollector.9
            public String getTaskName() {
                return "BatteryCollector-UpdateThreadRecord";
            }

            public AsyncTaskType getTaskType() {
                return AsyncTaskType.LIGHT_WEIGHT;
            }

            public void run() {
                try {
                    BatteryCollector.this.updateThreadRecord();
                    AsyncEventManager.getInstance().forcePostDelay(BatteryCollector.this.mUpdateThreadRecordRunnable, (BatteryCollector.this.isFront ? BatteryCollector.this.mCPUMonitorConfigMap.containsKey(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_THREAD_FRONT_CAPTURE_PERIOD) ? ((Integer) BatteryCollector.this.mCPUMonitorConfigMap.get(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_THREAD_FRONT_CAPTURE_PERIOD)).intValue() : 5 : BatteryCollector.this.mCPUMonitorConfigMap.containsKey(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_THREAD_BACKGROUND_CAPTURE_PERIOD) ? ((Integer) BatteryCollector.this.mCPUMonitorConfigMap.get(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_THREAD_BACKGROUND_CAPTURE_PERIOD)).intValue() : 20) * 1000);
                } catch (Throwable th) {
                    EnsureManager.ensureNotReachHere(th, "mUpdateThreadRecordRunnable");
                }
            }
        };
        this.mCollectorSettingKey = "battery";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Holder {
        private static final BatteryCollector INSTANCE = new BatteryCollector();

        private Holder() {
        }
    }

    public static BatteryCollector getInstance() {
        return Holder.INSTANCE;
    }

    public void init(boolean z) {
        this.mEnableLocalRecord = z;
        init();
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onInit() {
        if (isAndroidVersionInvalid()) {
            return;
        }
        ApmAlogHelper.m77i(Constants.TAG_BATTERY, "Battery init process" + ApmContext.getCurrentProcessName());
        this.isFront = ActivityLifeObserver.getInstance().isForeground();
        this.mActivityNameToReport[1] = ActivityLifeObserver.getInstance().getTopActivityClassName();
        this.mJiffyHz = CommonMonitorUtil.getScClkTck(100L);
        this.mIsCharging = BatteryUtils.addChargeListener(ApmContext.getContext(), this);
        BatteryAlarmStatsImpl batteryAlarmStatsImpl = new BatteryAlarmStatsImpl();
        BatteryLocStatsImpl batteryLocStatsImpl = new BatteryLocStatsImpl();
        BatteryWakeLockStatsImpl batteryWakeLockStatsImpl = new BatteryWakeLockStatsImpl();
        try {
            BinderHookHelper binderHookHelper = new BinderHookHelper();
            binderHookHelper.addHook(BatteryTypeInf.BATTERY_ALARM, batteryAlarmStatsImpl);
            binderHookHelper.addHook(BatteryTypeInf.BATTERY_LOC_API, batteryLocStatsImpl);
            binderHookHelper.addHook(BatteryTypeInf.BATTERY_POWER_LOCK, batteryWakeLockStatsImpl);
            binderHookHelper.hookSystemServiceRegistry();
            this.mBatteryStatsMap.put(BatteryTypeInf.BATTERY_ALARM, batteryAlarmStatsImpl);
            this.mBatteryStatsMap.put(BatteryTypeInf.BATTERY_LOC_API, batteryLocStatsImpl);
            this.mBatteryStatsMap.put(BatteryTypeInf.BATTERY_POWER_LOCK, batteryWakeLockStatsImpl);
        } catch (Throwable th) {
            ApmAlogHelper.m76e(Constants.TAG_BATTERY, "SYSTEM_SERVICE_FETCHERS hook failed: " + th.getMessage());
        }
        BatteryCpuStatsImpl batteryCpuStatsImpl = new BatteryCpuStatsImpl();
        BatteryTrafficStatsImpl batteryTrafficStatsImpl = new BatteryTrafficStatsImpl();
        BatteryPacketsStatsImpl batteryPacketsStatsImpl = new BatteryPacketsStatsImpl();
        BatteryConsumeStatsImpl batteryConsumeStatsImpl = new BatteryConsumeStatsImpl();
        this.mBatteryStatsMap.put(BatteryTypeInf.BATTERY_CPU_ACTIVE, batteryCpuStatsImpl);
        this.mBatteryStatsMap.put("traffic", batteryTrafficStatsImpl);
        this.mBatteryStatsMap.put(BatteryTypeInf.BATTERY_PACKETS, batteryPacketsStatsImpl);
        this.mBatteryStatsMap.put(BatteryTypeInf.BATTERY_CONSUME, batteryConsumeStatsImpl);
        this.mLastReportTime = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void doConfig(JSONObject jSONObject) {
        this.mRecordInterval = jSONObject.optLong(SlardarSettingsConsts.PERF_BATTERY_RECORD_INTERVAL, 10L);
        this.mReportInterval = jSONObject.optLong(SlardarSettingsConsts.PERF_BATTERY_REPORT_INTERVAL, 30L);
        int optInt = jSONObject.optInt("enable_upload", 0);
        this.mCollectEnable = optInt == 1 && this.mRecordInterval > 0;
        this.mMaxSupportApiLevel = jSONObject.optInt(SlardarSettingsConsts.PERF_BATTERY_SUPPORT_MAX_API_LEVEL, this.mMaxSupportApiLevel);
        if (ApmContext.isDebugMode()) {
            Logger.m87e(DebugLogger.TAG_BATTERY, "mRecordInterval:" + this.mRecordInterval + ",mBatteryCollectEnabled" + optInt);
        }
        if (!this.mCollectEnable && !this.mEnableLocalRecord) {
            this.mBatteryStatsMap.clear();
            ActivityLifeObserver.getInstance().unregister(this);
            BatteryUtils.removeListener(ApmContext.getContext(), this);
        } else if (jSONObject.optInt(SlardarSettingsConsts.PERF_BATTERY_NET_ALL_INTERFACE_ENABLE, 0) == 1) {
            this.mBatteryStatsMap.put(BatteryTypeInf.BATTERY_NET_ALL_INTERFACE, new BatteryTrafficAllInterface());
        }
        this.mEnableTrace = jSONObject.optInt(SlardarSettingsConsts.PERF_BATTERY_TRACE_ENABLE, 0) == 1;
        if (this.mEnableTrace) {
            BatteryDetectConfig.setMaxSingleWakeLockHoldTimeMs(jSONObject.optLong(BatteryDetectConfig.KEY_MAX_SINGLE_WAKE_LOCK_HOLD_TIME, 120L) * 1000);
            BatteryDetectConfig.setMaxTotalWakeLockAcquireCount(jSONObject.optInt(BatteryDetectConfig.KEY_MAX_TOTAL_WAKE_LOCK_ACQUIRE_COUNT_10_MINS, 5));
            BatteryDetectConfig.setMaxTotalWakeLockHoldTimeMs(jSONObject.optLong(BatteryDetectConfig.KEY_MAX_TOTAL_WAKE_LOCK_HOLD_TIME_10_MINS, 240L) * 1000);
            BatteryDetectConfig.setMaxWakeUpAlarmInvokeCount(jSONObject.optInt(BatteryDetectConfig.KEY_MAX_WAKE_UP_ALARM_INVOKE_COUNT_10_MINS, 5));
            BatteryDetectConfig.setMaxNormalAlarmInvokeCount(jSONObject.optInt(BatteryDetectConfig.KEY_MAX_NORMAL_ALARM_INVOKE_COUNT_10_MINS, 10));
            BatteryDetectConfig.setMaxSingleLocRequestTimeMs(jSONObject.optLong(BatteryDetectConfig.KEY_MAX_SINGLE_LOC_REQUEST_TIME, 120L) * 1000);
            BatteryDetectConfig.setMaxTotalLocRequestCount(jSONObject.optInt(BatteryDetectConfig.KEY_MAX_TOTAL_LOC_REQUEST_COUNT_10_MINS, 5));
            BatteryDetectConfig.setMaxTotalLocRequestTimeMs(jSONObject.optLong(BatteryDetectConfig.KEY_MAX_TOTAL_LOC_REQUEST_TIME_10_MINS, 240L) * 1000);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(SlardarSettingsConsts.PERF_BATTERY_CPU_MONITOR_CONFIG);
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_ENABLE.equals(next)) {
                    this.mCPUMonitorConfigMap.put(next, Integer.valueOf(optJSONObject.optInt(next, 0)));
                } else {
                    int optInt2 = optJSONObject.optInt(next, 0);
                    if (optInt2 > 0) {
                        this.mCPUMonitorConfigMap.put(next, Integer.valueOf(optInt2));
                    }
                }
            }
        }
        this.mSceneBlackList = ParseUtils.parseList(jSONObject, SlardarSettingsConsts.PERF_BATTERY_SCENE_BLACK_LIST);
        if (cpuMonitorEnable()) {
            AsyncEventManager.getInstance().forcePost(this.mUpdateThreadRecordRunnable);
            resetPageInThreadState();
        }
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected long workInternalMs() {
        return this.mRecordInterval * 60000;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onReady() {
        super.onReady();
        if (ApmContext.isMainProcess() && this.mCollectEnable) {
            BatteryDataManager.getInstance().handleReportAndHandleCache(true);
            this.mLastReportTime = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onBackground(Activity activity) {
        super.onBackground(activity);
        recordBackgroundData();
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onFront(Activity activity) {
        super.onFront(activity);
        this.mLastOnFrontActivity = activity.getClass().getName();
        recordFrontData(ActivityLifeObserver.getInstance().getTopActivityClassName());
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onActivityResume(Activity activity) {
        super.onActivityResume(activity);
        String[] strArr = this.mActivityNameToReport;
        strArr[0] = strArr[1];
        strArr[1] = activity.getClass().getName();
        if (!TextUtils.equals(activity.getClass().getName(), this.mLastOnFrontActivity) && !TextUtils.isEmpty(this.mActivityNameToReport[0])) {
            recordFrontData(this.mActivityNameToReport[0]);
        }
        this.mLastOnFrontActivity = null;
    }

    @Override // com.bytedance.apm.battery.util.BatteryUtils.ChargeListener
    public void onChange(final boolean z) {
        if (this.mBatteryStatsMap.isEmpty()) {
            return;
        }
        BatteryDataManager.getInstance().setCurrentActivityName(ActivityLifeObserver.getInstance().getTopActivityClassName());
        AsyncEventManager.getInstance().forcePost(new Runnable() { // from class: com.bytedance.apm.battery.BatteryCollector.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (BatteryCollector.innerLock) {
                    try {
                        if (ApmContext.isDebugMode()) {
                            Logger.m88i(DebugLogger.TAG_BATTERY, "ChargingStatusChange:" + z);
                        }
                        boolean recordStatus = BatteryCollector.this.recordStatus();
                        Iterator it = BatteryCollector.this.mBatteryStatsMap.values().iterator();
                        while (it.hasNext()) {
                            ((IBatteryStats) it.next()).onChargeStatusChange(z, recordStatus);
                        }
                    } finally {
                        BatteryCollector.this.mIsCharging = z;
                    }
                    BatteryCollector.this.mIsCharging = z;
                }
            }
        });
    }

    public void startSceneMonitor(final String str) {
        if (this.mBatteryStatsMap.isEmpty() || str == null) {
            return;
        }
        List<String> list = this.mSceneBlackList;
        if (list == null || list.isEmpty() || !this.mSceneBlackList.contains(str)) {
            AsyncEventManager.getInstance().forcePost(new Runnable() { // from class: com.bytedance.apm.battery.BatteryCollector.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (BatteryCollector.innerLock) {
                        try {
                            if (BatteryCollector.this.mSceneList.contains(str)) {
                                if (ApmContext.isDebugMode()) {
                                    Logger.m88i(DebugLogger.TAG_BATTERY, str + " is already monitoring");
                                }
                            } else {
                                if (ApmContext.isDebugMode()) {
                                    Logger.m88i(DebugLogger.TAG_BATTERY, "start monitor battery:" + str);
                                }
                                boolean recordStatus = BatteryCollector.this.recordStatus();
                                Iterator it = BatteryCollector.this.mBatteryStatsMap.values().iterator();
                                while (it.hasNext()) {
                                    ((IBatteryStats) it.next()).startSceneMonitor(str, recordStatus);
                                }
                                BatteryCollector.this.mSceneList.add(str);
                                BatteryCollector.this.updateSceneStr();
                            }
                        } finally {
                        }
                    }
                }
            });
        }
    }

    public void stopSceneMonitor(final String str) {
        if (this.mBatteryStatsMap.isEmpty() || str == null) {
            return;
        }
        List<String> list = this.mSceneBlackList;
        if (list == null || list.isEmpty() || !this.mSceneBlackList.contains(str)) {
            AsyncEventManager.getInstance().forcePost(new Runnable() { // from class: com.bytedance.apm.battery.BatteryCollector.3
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (BatteryCollector.innerLock) {
                        try {
                            if (BatteryCollector.this.mSceneList.contains(str)) {
                                if (ApmContext.isDebugMode()) {
                                    Logger.m88i(DebugLogger.TAG_BATTERY, "stop monitor battery:" + str);
                                }
                                boolean recordStatus = BatteryCollector.this.recordStatus();
                                Iterator it = BatteryCollector.this.mBatteryStatsMap.values().iterator();
                                while (it.hasNext()) {
                                    ((IBatteryStats) it.next()).stopSceneMonitor(str, recordStatus);
                                }
                                BatteryCollector.this.mSceneList.remove(str);
                                BatteryCollector.this.updateSceneStr();
                            } else if (ApmContext.isDebugMode()) {
                                Logger.m88i(DebugLogger.TAG_BATTERY, str + "is already stopped");
                            }
                        } finally {
                        }
                    }
                }
            });
        }
    }

    private void recordFrontData(String str) {
        if (isAndroidVersionInvalid()) {
            return;
        }
        ApmAlogHelper.m77i(Constants.TAG_BATTERY, "ToFront:" + str);
        BatteryDataManager.getInstance().setCurrentActivityName(str);
        AsyncEventManager.getInstance().forcePost(new Runnable() { // from class: com.bytedance.apm.battery.BatteryCollector.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (BatteryCollector.innerLock) {
                    try {
                        if (ApmContext.isDebugMode()) {
                            Logger.m88i(DebugLogger.TAG_BATTERY, "onChangeToFront, record data");
                        }
                        ApmAlogHelper.m77i(Constants.TAG_BATTERY, "ToFrontIn");
                        boolean recordStatus = BatteryCollector.this.recordStatus(true);
                        Iterator it = BatteryCollector.this.mBatteryStatsMap.values().iterator();
                        while (it.hasNext()) {
                            ((IBatteryStats) it.next()).onFront(recordStatus);
                        }
                    } finally {
                        BatteryDataManager.getInstance().setCurrentActivityName(ActivityLifeObserver.getInstance().getTopActivityClassName());
                        BatteryCollector.this.isFront = true;
                    }
                    BatteryDataManager.getInstance().setCurrentActivityName(ActivityLifeObserver.getInstance().getTopActivityClassName());
                    BatteryCollector.this.isFront = true;
                }
            }
        });
    }

    private void recordBackgroundData() {
        if (isAndroidVersionInvalid()) {
            return;
        }
        ApmAlogHelper.m77i(Constants.TAG_BATTERY, "ToBack");
        BatteryDataManager.getInstance().setCurrentActivityName(ActivityLifeObserver.getInstance().getTopActivityClassName());
        AsyncEventManager.getInstance().forcePost(new Runnable() { // from class: com.bytedance.apm.battery.BatteryCollector.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (BatteryCollector.innerLock) {
                    try {
                        if (ApmContext.isDebugMode()) {
                            Logger.m88i(DebugLogger.TAG_BATTERY, "onChangeToBack, record data");
                        }
                        ApmAlogHelper.m77i(Constants.TAG_BATTERY, "ToBackIn");
                        boolean recordStatus = BatteryCollector.this.recordStatus(true);
                        Iterator it = BatteryCollector.this.mBatteryStatsMap.values().iterator();
                        while (it.hasNext()) {
                            ((IBatteryStats) it.next()).onBack(recordStatus);
                        }
                    } finally {
                        BatteryCollector.this.isFront = false;
                    }
                    BatteryCollector.this.isFront = false;
                }
            }
        });
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onStart() {
        if (isAndroidVersionInvalid() || this.mBatteryStatsMap.isEmpty()) {
            return;
        }
        ApmAlogHelper.m77i(Constants.TAG_BATTERY, "OnTimer");
        long workInternalMs = workInternalMs();
        if (workInternalMs > 0) {
            AsyncEventManager.getInstance().forcePostDelay(this.mTimerRunnable, workInternalMs);
        }
        BatteryDataManager.getInstance().setCurrentActivityName(ActivityLifeObserver.getInstance().getTopActivityClassName());
        AsyncEventManager.getInstance().forcePost(new Runnable() { // from class: com.bytedance.apm.battery.BatteryCollector.6
            @Override // java.lang.Runnable
            public void run() {
                synchronized (BatteryCollector.innerLock) {
                    try {
                        boolean z = true;
                        if (ApmContext.isDebugMode()) {
                            Logger.m88i(DebugLogger.TAG_BATTERY, "onTimer record, current is background? : " + ActivityLifeObserver.getInstance().isForeground());
                        }
                        ApmAlogHelper.m77i(Constants.TAG_BATTERY, "OnTimerIn");
                        boolean recordStatus = BatteryCollector.this.recordStatus(true);
                        Iterator it = BatteryCollector.this.mBatteryStatsMap.values().iterator();
                        while (it.hasNext()) {
                            ((IBatteryStats) it.next()).onTimer(recordStatus);
                        }
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (BatteryCollector.this.mCollectEnable) {
                            if (elapsedRealtime - BatteryCollector.this.mLastReportTime <= BatteryCollector.this.mReportInterval * 60000) {
                                z = false;
                            }
                            if (ApmContext.isMainProcess() && z) {
                                BatteryDataManager.getInstance().handleReportAndHandleCache(false);
                                BatteryCollector.this.mLastReportTime = elapsedRealtime;
                            }
                        }
                    } finally {
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean recordStatus() throws JSONException {
        return recordStatus(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean recordStatus(boolean z) throws JSONException {
        boolean z2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.mLastStatusSampleTime;
        boolean z3 = j > 2000;
        if (this.mLastStatusSampleTime == -1 || !z3) {
            z2 = z3;
        } else {
            z2 = z3;
            BatteryDataManager.getInstance().record(new BatteryLogEntity(this.isFront, System.currentTimeMillis(), BatteryTypeInf.BATTERY_GROUND_RECORD, this.mIsCharging, j, this.mCurSceneSetStr));
            if (this.isFront && j > 7200000) {
                HashMap hashMap = new HashMap();
                hashMap.put("duration", String.valueOf(j));
                EnsureManager.ensureNotReachHere("BatterErrorDuration", hashMap);
            }
        }
        if (this.mLastStatusSampleTime != -1 && z && cpuMonitorEnable()) {
            monitorFunctionExecute(j);
        }
        this.mLastStatusSampleTime = elapsedRealtime;
        return z2;
    }

    private void monitorFunctionExecute(long j) throws JSONException {
        int intValue;
        boolean z;
        if (this.isFront || !TextUtils.isEmpty(this.mCurSceneSetStr)) {
            intValue = this.mCPUMonitorConfigMap.containsKey(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_FUNCTION_FRONT_THRESHOLD) ? this.mCPUMonitorConfigMap.get(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_FUNCTION_FRONT_THRESHOLD).intValue() : 5;
        } else {
            intValue = this.mCPUMonitorConfigMap.containsKey(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_FUNCTION_BACKGROUND_THRESHOLD) ? this.mCPUMonitorConfigMap.get(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_FUNCTION_BACKGROUND_THRESHOLD).intValue() : 2;
        }
        Map<String, BatteryAgent.MethodExecutedValue> filterResultAndClear = BatteryAgent.filterResultAndClear((intValue * j) / 100);
        if (isStayDurationValid(j)) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            boolean z2 = true;
            if (filterResultAndClear == null || filterResultAndClear.isEmpty()) {
                z = false;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, BatteryAgent.MethodExecutedValue> entry : filterResultAndClear.entrySet()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("method", entry.getKey());
                    jSONObject2.putOpt("exe_count", Integer.valueOf(entry.getValue().getCount()));
                    jSONObject2.putOpt("cpu_cost", Integer.valueOf(entry.getValue().getCost()));
                    jSONArray.put(jSONObject2);
                }
                jSONObject.putOpt("functions", jSONArray);
                z = true;
            }
            if (this.mThreadCostRecord.isEmpty()) {
                z2 = z;
            } else {
                ArrayList arrayList = new ArrayList(this.mThreadCostRecord.values());
                Collections.sort(arrayList, new Comparator<ThreadTimeItem>() { // from class: com.bytedance.apm.battery.BatteryCollector.8
                    @Override // java.util.Comparator
                    public int compare(ThreadTimeItem threadTimeItem, ThreadTimeItem threadTimeItem2) {
                        return (int) (threadTimeItem2.threadTime - threadTimeItem.threadTime);
                    }
                });
                JSONArray jSONArray2 = new JSONArray();
                int intValue2 = this.mCPUMonitorConfigMap.containsKey(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_THREAD_COUNT) ? this.mCPUMonitorConfigMap.get(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_THREAD_COUNT).intValue() : 100;
                while (i < Math.min(arrayList.size(), intValue2)) {
                    ThreadTimeItem threadTimeItem = (ThreadTimeItem) arrayList.get(i);
                    if (threadTimeItem.threadTime <= 0) {
                        break;
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    i++;
                    jSONObject3.putOpt("rank", Integer.valueOf(i));
                    jSONObject3.putOpt("thread_name", threadTimeItem.threadName);
                    jSONObject3.putOpt("cpu_cost", Long.valueOf(threadTimeItem.threadTime));
                    jSONArray2.put(jSONObject3);
                }
                jSONObject.putOpt("threads", jSONArray2);
            }
            if (z2) {
                String currentActivityName = this.isFront ? BatteryDataManager.getInstance().getCurrentActivityName() : EventReport.DIALOG_BACKGROUND;
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.putOpt("scene", currentActivityName);
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.putOpt("stay_duration", Long.valueOf(j));
                ApmAlogHelper.m77i(Constants.TAG_BATTERY_LOCAL, "scene:" + currentActivityName + " stayDuration:" + j + " data:" + jSONObject);
                ApmAgent.monitorEvent("monitor_expend_function", jSONObject4, jSONObject5, jSONObject);
            }
        }
        resetPageInThreadState();
    }

    private boolean isStayDurationValid(long j) {
        if (this.isFront) {
            return j > ((long) ((this.mCPUMonitorConfigMap.containsKey(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_FRONT_VALID_DURATION) ? this.mCPUMonitorConfigMap.get(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_FRONT_VALID_DURATION).intValue() : 20) * 1000));
        }
        return j > ((long) ((this.mCPUMonitorConfigMap.containsKey(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_BACKGROUND_VALID_DURATION) ? this.mCPUMonitorConfigMap.get(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_BACKGROUND_VALID_DURATION).intValue() : 60) * 1000));
    }

    private void resetPageInThreadState() {
        this.pageInThreadState.clear();
        this.mThreadCostRecord.clear();
        LinkedList<ThreadTimeItem> threadInfo = CommonMonitorUtil.getThreadInfo(Process.myPid());
        if (threadInfo == null || threadInfo.isEmpty()) {
            return;
        }
        Iterator<ThreadTimeItem> it = threadInfo.iterator();
        while (it.hasNext()) {
            ThreadTimeItem next = it.next();
            this.pageInThreadState.put(Integer.valueOf(next.threadId), next);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateThreadRecord() {
        LinkedList<ThreadTimeItem> threadInfo;
        long j;
        if (this.pageInThreadState.isEmpty() || (threadInfo = CommonMonitorUtil.getThreadInfo(Process.myPid())) == null || threadInfo.isEmpty()) {
            return;
        }
        Iterator<ThreadTimeItem> it = threadInfo.iterator();
        while (it.hasNext()) {
            ThreadTimeItem next = it.next();
            if (this.pageInThreadState.containsKey(Integer.valueOf(next.threadId))) {
                j = next.threadTime - this.pageInThreadState.get(Integer.valueOf(next.threadId)).threadTime;
            } else {
                j = next.threadTime;
            }
            if (j > 0) {
                long j2 = (long) ((j / this.mJiffyHz) * 1000.0d);
                if (this.mThreadCostRecord.containsKey(Integer.valueOf(next.threadId))) {
                    this.mThreadCostRecord.get(Integer.valueOf(next.threadId)).updateThreadTime(j2);
                } else {
                    this.mThreadCostRecord.put(Integer.valueOf(next.threadId), new ThreadTimeItem(next.threadId, next.threadName, j2));
                }
            }
        }
    }

    private boolean cpuMonitorEnable() {
        if (BatteryAgent.hasHook()) {
            return true;
        }
        return this.mCPUMonitorConfigMap.containsKey(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_ENABLE) && this.mCPUMonitorConfigMap.get(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_ENABLE).intValue() == 1;
    }

    public Map<String, IBatteryStats> getBatteryStatsMap() {
        return this.mBatteryStatsMap;
    }

    public boolean isEnableTrace() {
        return this.mEnableTrace;
    }

    private boolean isAndroidVersionInvalid() {
        return Build.VERSION.SDK_INT > this.mMaxSupportApiLevel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSceneStr() {
        if (this.mSceneList.isEmpty()) {
            this.mCurSceneSetStr = null;
        } else {
            Collections.sort(this.mSceneList, new Comparator<String>() { // from class: com.bytedance.apm.battery.BatteryCollector.10
                @Override // java.util.Comparator
                public int compare(String str, String str2) {
                    return str.compareTo(str2);
                }
            });
            this.mCurSceneSetStr = ListUtils.arrayToString(this.mSceneList.toArray(), "#");
        }
    }

    public String getCurSceneSetStr() {
        return this.mCurSceneSetStr;
    }
}

package com.bytedance.apm.battery;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.battery.internal.LocCallback;
import com.bytedance.apm.battery.util.BatteryUtils;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.perf.AbstractPerfCollector;
import com.bytedance.apm.perf.CommonDataAssembly;
import com.bytedance.apm.perf.traffic.TrafficStatisticWrapper;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.ss.thor.Thor;
import com.ss.thor.ThorCallback;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BatteryEnergyCollector extends AbstractPerfCollector implements LocCallback, BatteryUtils.ChargeListener {
    private static final int DEFAULT_SAMPLE_INTERVAL_MS = 3000;
    private static final long DEFAULT_UPLOAD_INTERVAL_MS = 120000;
    private static final String TAG = "BatteryEnergyCollector";
    private boolean isCharging;
    private boolean mCollectEnabled;
    private long mCpuTime;
    private CopyOnWriteArrayList<Long> mLocRequestTime;
    private final Object mLock;
    private int mSampleIntervalMs;
    private String mScene;
    private long mTrafficBytes;
    private TrafficStatisticWrapper mTrafficStatisticWrapper;
    private long mUploadIntervalMs;
    private long samplingTimes;
    private ConcurrentHashMap<String, BatteryInfoItem> sceneMap;
    private ThorCallback thorCallback;
    private float totalCurrentGalvanic;

    static /* synthetic */ long access$804(BatteryEnergyCollector batteryEnergyCollector) {
        long j = batteryEnergyCollector.samplingTimes + 1;
        batteryEnergyCollector.samplingTimes = j;
        return j;
    }

    private BatteryEnergyCollector() {
        this.sceneMap = new ConcurrentHashMap<>();
        this.mLock = new Object();
        this.samplingTimes = 0L;
        this.totalCurrentGalvanic = 0.0f;
        this.mCpuTime = 0L;
        this.mTrafficBytes = 0L;
        this.mTrafficStatisticWrapper = TrafficStatisticWrapper.getInstance();
        this.mLocRequestTime = new CopyOnWriteArrayList<>();
        this.thorCallback = new ThorCallback() { // from class: com.bytedance.apm.battery.BatteryEnergyCollector.1
            public void onStart() {
                BatteryEnergyCollector.this.resetData();
            }

            public void onUpdate(float f, float f2, long j) {
                synchronized (BatteryEnergyCollector.this.mLock) {
                    if (TextUtils.isEmpty(BatteryEnergyCollector.this.mScene)) {
                        return;
                    }
                    if (!BatteryEnergyCollector.this.isBackground() && !BatteryEnergyCollector.this.isCharging) {
                        if (BatteryEnergyCollector.this.samplingTimes == 0) {
                            BatteryEnergyCollector.this.mCpuTime = PerfMonitorManager.getInstance().dumpAppCPUTime();
                            BatteryEnergyCollector batteryEnergyCollector = BatteryEnergyCollector.this;
                            batteryEnergyCollector.mTrafficBytes = batteryEnergyCollector.mTrafficStatisticWrapper.getTotalBytes();
                            BatteryEnergyCollector.this.mLocRequestTime.clear();
                        }
                        BatteryEnergyCollector.access$804(BatteryEnergyCollector.this);
                        BatteryEnergyCollector.this.totalCurrentGalvanic += f;
                        if (BatteryEnergyCollector.this.samplingTimes > 20) {
                            if (BatteryEnergyCollector.this.totalCurrentGalvanic > 200.0f) {
                                float f3 = BatteryEnergyCollector.this.totalCurrentGalvanic / ((float) BatteryEnergyCollector.this.samplingTimes);
                                BatteryInfoItem batteryInfoItem = new BatteryInfoItem();
                                batteryInfoItem.setCurrentGalvanic(f3);
                                batteryInfoItem.setCurrentCapacity(j);
                                batteryInfoItem.setCpuTime(PerfMonitorManager.getInstance().dumpAppCPUTime() - BatteryEnergyCollector.this.mCpuTime);
                                batteryInfoItem.setTraffic(BatteryEnergyCollector.this.mTrafficStatisticWrapper.getTotalBytes() - BatteryEnergyCollector.this.mTrafficBytes);
                                batteryInfoItem.setLoc(BatteryEnergyCollector.this.mLocRequestTime);
                                BatteryEnergyCollector.this.sceneMap.put(BatteryEnergyCollector.this.mScene, batteryInfoItem);
                            }
                            BatteryEnergyCollector.this.resetData();
                        }
                        return;
                    }
                    BatteryEnergyCollector.this.endAll();
                }
            }

            public void onStop() {
                BatteryEnergyCollector.this.resetData();
            }
        };
        this.mCollectorSettingKey = "battery";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Holder {
        private static final BatteryEnergyCollector INSTANCE = new BatteryEnergyCollector();

        private Holder() {
        }
    }

    public static BatteryEnergyCollector getInstance() {
        return Holder.INSTANCE;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected void onInit() {
        this.isCharging = BatteryUtils.addChargeListener(ApmContext.getContext(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void doConfig(JSONObject jSONObject) {
        boolean z = jSONObject.optInt(SlardarSettingsConsts.PERF_BATTERY_ENERGY_ENABLE_UPLOAD, 0) == 1;
        this.mCollectEnabled = z;
        if (z) {
            this.mSampleIntervalMs = jSONObject.optInt(SlardarSettingsConsts.PERF_BATTERY_ENERGY_SAMPLE_INTERVAL, 3000);
            this.mUploadIntervalMs = jSONObject.optLong(SlardarSettingsConsts.PERF_BATTERY_ENERGY_UPLOAD_INTERVAL, 120000L);
        } else {
            ActivityLifeObserver.getInstance().unregister(this);
            AsyncEventManager.getInstance().removeTimeTask(this);
        }
    }

    public void startSceneMonitor(String str) {
        if (!this.mCollectEnabled || isBackground() || this.isCharging) {
            return;
        }
        synchronized (this.mLock) {
            Thor.start(ApmContext.getContext(), this.thorCallback, 5, this.mSampleIntervalMs);
            if (TextUtils.isEmpty(this.mScene)) {
                AsyncEventManager.getInstance().addTimeTask(this);
            }
            this.mScene = str;
            resetData();
        }
    }

    public void endSceneMonitor(String str) {
        if (this.mCollectEnabled) {
            synchronized (this.mLock) {
                if (str.equals(this.mScene)) {
                    this.mScene = null;
                    AsyncEventManager.getInstance().removeTimeTask(this);
                    Thor.stop();
                    resetData();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endAll() {
        if (TextUtils.isEmpty(this.mScene)) {
            return;
        }
        this.mScene = null;
        AsyncEventManager.getInstance().removeTimeTask(this);
        Thor.stop();
        resetData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onStart() {
        super.onStart();
        for (Map.Entry<String, BatteryInfoItem> entry : this.sceneMap.entrySet()) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("scene", entry.getKey());
                jSONObject.put(PerfConsts.KEY_CURRENT_GALVANIC, entry.getValue().getCurrentGalvanic());
                jSONObject.put(PerfConsts.KEY_CURRENT_CAPACITY, entry.getValue().getCurrentCapacity());
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("cpu_time", entry.getValue().getCpuTime());
                jSONObject3.put("traffic", entry.getValue().getTraffic());
                jSONObject3.put("loc", entry.getValue().getLoc());
                PerfData perfData = new PerfData("battery", "", jSONObject, jSONObject2, jSONObject3);
                CommonDataAssembly.wrapFilters(perfData, false);
                CommonDataPipeline.getInstance().handle(perfData);
            } catch (JSONException unused) {
            }
        }
        this.sceneMap.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onStop() {
        super.onStop();
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected boolean isTimerMonitor() {
        return !isBackground();
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onFront(Activity activity) {
        super.onFront(activity);
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onBackground(Activity activity) {
        super.onBackground(activity);
        AsyncEventManager.getInstance().removeTimeTask(this);
        synchronized (this.mLock) {
            endAll();
        }
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected long workInternalMs() {
        return this.mUploadIntervalMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.samplingTimes = 0L;
        this.totalCurrentGalvanic = 0.0f;
    }

    @Override // com.bytedance.apm.battery.internal.LocCallback
    public void onLocRequest(long j) {
        synchronized (this.mLock) {
            this.mLocRequestTime.add(Long.valueOf(j));
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class BatteryInfoItem {
        long cpuTime;
        long currentCapacity;
        float currentGalvanic;
        StringBuilder loc = new StringBuilder();
        long traffic;

        public BatteryInfoItem() {
        }

        float getCurrentGalvanic() {
            return this.currentGalvanic;
        }

        void setCurrentGalvanic(float f) {
            this.currentGalvanic = f;
        }

        long getCpuTime() {
            return this.cpuTime;
        }

        void setCpuTime(long j) {
            this.cpuTime = j;
        }

        long getTraffic() {
            return this.traffic;
        }

        void setTraffic(long j) {
            this.traffic = j;
        }

        public long getCurrentCapacity() {
            return this.currentCapacity;
        }

        public void setCurrentCapacity(long j) {
            this.currentCapacity = j;
        }

        String getLoc() {
            return this.loc.toString();
        }

        void setLoc(List<Long> list) {
            if (list == null || list.size() == 0) {
                return;
            }
            for (int i = 0; i < list.size() - 1; i++) {
                this.loc.append(list.get(i)).append(',');
            }
            this.loc.append(list.get(list.size() - 1));
        }
    }

    @Override // com.bytedance.apm.battery.util.BatteryUtils.ChargeListener
    public void onChange(boolean z) {
        this.isCharging = z;
        if (z) {
            synchronized (this.mLock) {
                endAll();
            }
        }
    }
}

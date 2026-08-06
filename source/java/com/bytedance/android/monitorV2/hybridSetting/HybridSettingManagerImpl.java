package com.bytedance.android.monitorV2.hybridSetting;

import android.content.Context;
import com.bytedance.android.monitorV2.InternalWatcher;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidRegex;
import com.bytedance.android.monitorV2.hybridSetting.entity.CheckFilter;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingInitConfig;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingResponse;
import com.bytedance.android.monitorV2.hybridSetting.entity.SwitchConfig;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.net.TTNetSettingRequestService;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.ttnet.TTNetInit;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class HybridSettingManagerImpl implements IHybridSettingManager {
    private static final int RETRY_SECONDS = 600;
    private static final String TAG = "HybridSettingRequestService";
    private ISettingRequestService hybridSettingRequestService;
    HybridSettingInitConfig mInitConfig;
    private Timer mUpdateTimer;
    private volatile boolean isInitialized = false;
    private volatile boolean lazyParse = false;
    private final ExecutorService settingsThreadExecutor = Executors.newSingleThreadExecutor();
    private volatile HybridSettingResponse hybridSettingResponse = new HybridSettingResponse();

    public HybridSettingManagerImpl(HybridSettingInitConfig hybridSettingInitConfig) {
        this.mInitConfig = hybridSettingInitConfig;
    }

    private void determineRequestService(HybridSettingInitConfig hybridSettingInitConfig) {
        try {
            Field declaredField = TTNetInit.class.getDeclaredField("sNotifiedColdStartFinsish");
            declaredField.setAccessible(true);
            if (declaredField.getBoolean(null)) {
                this.hybridSettingRequestService = new TTNetSettingRequestService(hybridSettingInitConfig);
                MonitorLog.m29i("HybridSettingRequestService_init", "setting request use ttnet");
            } else {
                this.hybridSettingRequestService = new HybridSettingRequestService(hybridSettingInitConfig);
                MonitorLog.m29i("HybridSettingRequestService_init", "setting request use default cause by ttnet not init");
            }
        } catch (Throwable th) {
            ExceptionUtil.handleException(ExceptionUtil.STARTUP_HANDLE, th);
            this.hybridSettingRequestService = new HybridSettingRequestService(hybridSettingInitConfig);
            MonitorLog.m27e("HybridSettingRequestService_init", "setting request use default cause by Throwable");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureSettingRequestService() {
        if (this.hybridSettingRequestService == null) {
            determineRequestService(this.mInitConfig);
        }
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public void init(Context context, boolean z) {
        if (context == null) {
            MonitorLog.m27e("HybridSettingRequestService_init", "init error, no context");
            return;
        }
        if (this.isInitialized) {
            return;
        }
        this.isInitialized = true;
        this.lazyParse = z;
        try {
            this.settingsThreadExecutor.submit(new Runnable() { // from class: com.bytedance.android.monitorV2.hybridSetting.HybridSettingManagerImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    HybridSettingResponse stepTwo;
                    long currentTimeMillis = System.currentTimeMillis();
                    HybridSettingManagerImpl.this.ensureSettingRequestService();
                    HybridSettingResponse stepOneFromLocal = HybridSettingManagerImpl.this.hybridSettingRequestService.stepOneFromLocal();
                    if (stepOneFromLocal != null) {
                        HybridSettingManagerImpl.this.hybridSettingResponse = stepOneFromLocal;
                        SettingsParseManager.INSTANCE.getParseListener().highPriorityTaskDone();
                    }
                    if (!HybridSettingManagerImpl.this.lazyParse && (stepTwo = HybridSettingManagerImpl.this.hybridSettingRequestService.stepTwo()) != null) {
                        HybridSettingManagerImpl.this.hybridSettingResponse = stepTwo;
                        SettingsParseManager.INSTANCE.getParseListener().lowPriorityTaskDone();
                    }
                    MonitorLog.m29i(HybridSettingManagerImpl.TAG, "_init from local");
                    if (HybridSettingManagerImpl.this.hybridSettingResponse.settingId != 0) {
                        i = (int) ((HybridSettingManagerImpl.this.hybridSettingRequestService.getLastFetchTime() + HybridSettingManagerImpl.this.hybridSettingResponse.duration) - (System.currentTimeMillis() / 1000));
                        MonitorLog.m29i(HybridSettingManagerImpl.TAG, "_init local is not null, and durationUntilUpdate is" + i + " secs");
                    } else {
                        i = 0;
                    }
                    if (i <= 0) {
                        MonitorLog.m29i("HybridSettingRequestService_init", "monitor setting init right now");
                        HybridSettingManagerImpl.this.loopUpdate(true);
                    } else {
                        MonitorLog.m29i("HybridSettingRequestService_init", "monitor setting init after " + i + " secs");
                        HashMap hashMap = new HashMap();
                        hashMap.put("setting_id", String.valueOf(HybridSettingManagerImpl.this.hybridSettingResponse.settingId));
                        InternalWatcher.INSTANCE.notice(null, InternalWatcher.EVENT_STARTUP_INIT, hashMap, null);
                        HybridSettingManagerImpl.this.updateForDuration(i);
                    }
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(InternalWatcher.PARAM_SETTING_INIT_TYPE, HybridSettingManagerImpl.TAG);
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put(InternalWatcher.PARAM_SETTING_INIT_TIME, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    InternalWatcher.INSTANCE.notice(null, InternalWatcher.EVENT_SETTING_INIT, hashMap2, hashMap3);
                    MonitorLog.m26d(HybridSettingManagerImpl.TAG, "HybridSettingManagerImpl init JsonOptConfig.isJsonOptEnable(): " + JsonOptConfig.isJsonOptEnable());
                    MonitorLog.m26d(HybridSettingManagerImpl.TAG, "HybridSettingManagerImpl init cost: " + (System.currentTimeMillis() - currentTimeMillis));
                }
            });
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public void parseSettings() {
        try {
            this.settingsThreadExecutor.submit(new Runnable() { // from class: com.bytedance.android.monitorV2.hybridSetting.HybridSettingManagerImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridSettingResponse stepTwo = HybridSettingManagerImpl.this.hybridSettingRequestService.stepTwo();
                    if (stepTwo != null) {
                        HybridSettingManagerImpl.this.hybridSettingResponse = stepTwo;
                    }
                    SettingsParseManager.INSTANCE.getParseListener().lowPriorityTaskDone();
                    HybridSettingManagerImpl.this.lazyParse = false;
                    MonitorLog.m29i(HybridSettingManagerImpl.TAG, "host parse settings");
                }
            });
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public BidInfo getBidInfo() {
        if (this.hybridSettingResponse != null && this.hybridSettingResponse.bidInfo != null) {
            return this.hybridSettingResponse.bidInfo;
        }
        return new BidInfo();
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public SwitchConfig getSwitch() {
        if (this.hybridSettingResponse != null && this.hybridSettingResponse.switchConfig != null) {
            return this.hybridSettingResponse.switchConfig;
        }
        return new SwitchConfig();
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public List<BidRegex> getRexList() {
        if (this.hybridSettingResponse == null || this.hybridSettingResponse.bidInfo == null || this.hybridSettingResponse.bidInfo.regexList == null) {
            return new ArrayList();
        }
        return this.hybridSettingResponse.bidInfo.regexList;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public long getUpdateTime() {
        if (this.hybridSettingResponse != null) {
            return this.hybridSettingResponse.updateTime;
        }
        return 0L;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public int getDuration() {
        return this.hybridSettingResponse != null ? this.hybridSettingResponse.duration : RETRY_SECONDS;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public long getSettingId() {
        if (this.hybridSettingResponse != null) {
            return this.hybridSettingResponse.settingId;
        }
        return 0L;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public void updateForDuration(int i) {
        if (i > 0) {
            if (this.mUpdateTimer == null) {
                this.mUpdateTimer = new Timer();
            }
            MonitorLog.m29i("HybridSettingRequestService_update", "monitor setting update after " + i + " secs");
            this.mUpdateTimer.schedule(new TimerTask() { // from class: com.bytedance.android.monitorV2.hybridSetting.HybridSettingManagerImpl.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    HybridSettingManagerImpl.this.loopUpdate();
                }
            }, i * 1000);
        }
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public void loopUpdate() {
        loopUpdate(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loopUpdate(final boolean z) {
        try {
            this.settingsThreadExecutor.submit(new Runnable() { // from class: com.bytedance.android.monitorV2.hybridSetting.HybridSettingManagerImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    HybridSettingManagerImpl.this.ensureSettingRequestService();
                    HybridSettingResponse stepOneFromRequest = HybridSettingManagerImpl.this.hybridSettingRequestService.stepOneFromRequest();
                    if (stepOneFromRequest != null) {
                        HybridSettingManagerImpl.this.hybridSettingResponse = stepOneFromRequest;
                        SettingsParseManager.INSTANCE.getParseListener().highPriorityTaskDone();
                        MonitorLog.m26d(HybridSettingManagerImpl.TAG, HybridSettingManagerImpl.this.hybridSettingResponse.switchConfig.toString());
                        MonitorLog.m29i("HybridSettingRequestService_update", "monitor setting update succeeded");
                        HybridSettingManagerImpl hybridSettingManagerImpl = HybridSettingManagerImpl.this;
                        hybridSettingManagerImpl.updateForDuration(hybridSettingManagerImpl.hybridSettingResponse.duration);
                    } else {
                        MonitorLog.m27e("HybridSettingRequestService_update", "monitor setting update failed");
                        HybridSettingManagerImpl.this.updateForDuration(HybridSettingManagerImpl.RETRY_SECONDS);
                    }
                    if (!HybridSettingManagerImpl.this.lazyParse) {
                        HybridSettingResponse stepTwo = HybridSettingManagerImpl.this.hybridSettingRequestService.stepTwo();
                        if (stepTwo != null) {
                            HybridSettingManagerImpl.this.hybridSettingResponse = stepTwo;
                        }
                        SettingsParseManager.INSTANCE.getParseListener().lowPriorityTaskDone();
                    }
                    if (z) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("setting_id", String.valueOf(HybridSettingManagerImpl.this.hybridSettingResponse.settingId));
                        InternalWatcher.INSTANCE.notice(null, InternalWatcher.EVENT_STARTUP_INIT, hashMap, null);
                    }
                    MonitorLog.m26d(HybridSettingManagerImpl.TAG, "_loopUpdate JsonOptConfig.isJsonOptEnable(): " + JsonOptConfig.isJsonOptEnable());
                    MonitorLog.m26d(HybridSettingManagerImpl.TAG, "_loopUpdate cost: " + (System.currentTimeMillis() - currentTimeMillis));
                }
            });
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public Map<String, Integer> getAllEventSample() {
        if (this.hybridSettingResponse.allEventSample != null) {
            return this.hybridSettingResponse.allEventSample;
        }
        return new HashMap();
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public Set<String> getHostWhiteSet() {
        if (this.hybridSettingResponse.hostWhiteSet != null) {
            return this.hybridSettingResponse.hostWhiteSet;
        }
        return new HashSet();
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public CheckFilter getCheckFilter() {
        if (this.hybridSettingResponse.checkFilter != null) {
            return this.hybridSettingResponse.checkFilter;
        }
        return new CheckFilter();
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public HybridSettingInitConfig getInitConfig() {
        return this.mInitConfig;
    }
}

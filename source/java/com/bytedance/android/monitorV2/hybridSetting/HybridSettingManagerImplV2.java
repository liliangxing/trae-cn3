package com.bytedance.android.monitorV2.hybridSetting;

import android.content.Context;
import com.bytedance.android.monitorV2.InternalWatcher;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidRegex;
import com.bytedance.android.monitorV2.hybridSetting.entity.CheckFilter;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingInitConfig;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingResponse;
import com.bytedance.android.monitorV2.hybridSetting.entity.SwitchConfig;
import com.bytedance.android.monitorV2.hybridSetting.localcache.LocalHybridSettingManager;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.net.TTNetSettingRequestService;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.ttnet.TTNetInit;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HybridSettingManagerImplV2.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 12\u00020\u0001:\u00011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020#H\u0016J\u001a\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020(H\u0016J\b\u0010.\u001a\u00020(H\u0016J\u0010\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020\u0016H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010¨\u00062"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/HybridSettingManagerImplV2;", "Lcom/bytedance/android/monitorV2/hybridSetting/IHybridSettingManager;", "initConfig", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/HybridSettingInitConfig;", "(Lcom/bytedance/android/monitorV2/hybridSetting/entity/HybridSettingInitConfig;)V", "hybridSettingDelegator", "Lcom/bytedance/android/monitorV2/hybridSetting/IHybridSettingDelegator;", "hybridSettingRequestService", "Lcom/bytedance/android/monitorV2/hybridSetting/ISettingRequestService;", "getHybridSettingRequestService", "()Lcom/bytedance/android/monitorV2/hybridSetting/ISettingRequestService;", "hybridSettingRequestService$delegate", "Lkotlin/Lazy;", "settingsThreadExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "getSettingsThreadExecutor", "()Ljava/util/concurrent/ScheduledExecutorService;", "settingsThreadExecutor$delegate", "determineRequestService", "getAllEventSample", "", "", "", "getBidInfo", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfo;", "getCheckFilter", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/CheckFilter;", "getDuration", "getHostWhiteSet", "", "getInitConfig", "getRexList", "", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidRegex;", "getSettingId", "", "getSwitch", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/SwitchConfig;", "getUpdateTime", "init", "", "context", "Landroid/content/Context;", "lazyParseSettings", "", "loopUpdate", "parseSettings", "updateForDuration", "n", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class HybridSettingManagerImplV2 implements IHybridSettingManager {
    private static final int RETRY_SECONDS = 600;
    private static final String TAG = "HybridSettingRequestServiceV2";
    private volatile IHybridSettingDelegator hybridSettingDelegator;

    /* renamed from: hybridSettingRequestService$delegate, reason: from kotlin metadata */
    private final Lazy hybridSettingRequestService;
    private final HybridSettingInitConfig initConfig;

    /* renamed from: settingsThreadExecutor$delegate, reason: from kotlin metadata */
    private final Lazy settingsThreadExecutor;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AtomicBoolean isInitialized = new AtomicBoolean(false);

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public void parseSettings() {
    }

    public HybridSettingManagerImplV2(HybridSettingInitConfig hybridSettingInitConfig) {
        Intrinsics.checkNotNullParameter(hybridSettingInitConfig, "initConfig");
        this.initConfig = hybridSettingInitConfig;
        this.hybridSettingDelegator = new DefaultHybridSettingDelegator(new HybridSettingResponse());
        this.hybridSettingRequestService = LazyKt.lazy(new Function0<ISettingRequestService>() { // from class: com.bytedance.android.monitorV2.hybridSetting.HybridSettingManagerImplV2$hybridSettingRequestService$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ISettingRequestService m336invoke() {
                HybridSettingInitConfig hybridSettingInitConfig2;
                ISettingRequestService determineRequestService;
                HybridSettingManagerImplV2 hybridSettingManagerImplV2 = HybridSettingManagerImplV2.this;
                hybridSettingInitConfig2 = hybridSettingManagerImplV2.initConfig;
                determineRequestService = hybridSettingManagerImplV2.determineRequestService(hybridSettingInitConfig2);
                return determineRequestService;
            }
        });
        this.settingsThreadExecutor = LazyKt.lazy(new Function0<ScheduledExecutorService>() { // from class: com.bytedance.android.monitorV2.hybridSetting.HybridSettingManagerImplV2$settingsThreadExecutor$2
            public final ScheduledExecutorService invoke() {
                return Executors.newSingleThreadScheduledExecutor();
            }
        });
    }

    /* compiled from: HybridSettingManagerImplV2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/HybridSettingManagerImplV2$Companion;", "", "()V", "RETRY_SECONDS", "", "TAG", "", "isInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AtomicBoolean isInitialized() {
            return HybridSettingManagerImplV2.isInitialized;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ISettingRequestService getHybridSettingRequestService() {
        return (ISettingRequestService) this.hybridSettingRequestService.getValue();
    }

    private final ScheduledExecutorService getSettingsThreadExecutor() {
        Object value = this.settingsThreadExecutor.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-settingsThreadExecutor>(...)");
        return (ScheduledExecutorService) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ISettingRequestService determineRequestService(HybridSettingInitConfig initConfig) {
        HybridSettingRequestService hybridSettingRequestService;
        try {
            Field declaredField = TTNetInit.class.getDeclaredField("sNotifiedColdStartFinsish");
            declaredField.setAccessible(true);
            if (declaredField.getBoolean(null)) {
                MonitorLog.m29i("HybridSettingRequestServiceV2_init", "setting request use ttnet");
                hybridSettingRequestService = new TTNetSettingRequestService(initConfig);
            } else {
                MonitorLog.m29i("HybridSettingRequestServiceV2_init", "setting request use default cause by ttnet not init");
                hybridSettingRequestService = new HybridSettingRequestService(initConfig);
            }
            return hybridSettingRequestService;
        } catch (Throwable th) {
            ExceptionUtil.handleException(ExceptionUtil.STARTUP_HANDLE, th);
            MonitorLog.m27e("HybridSettingRequestServiceV2_init", "setting request use default cause by Throwable");
            return new HybridSettingRequestService(initConfig);
        }
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public void init(Context context, boolean lazyParseSettings) {
        if (isInitialized.compareAndSet(false, true)) {
            try {
                getSettingsThreadExecutor().submit(new Runnable() { // from class: com.bytedance.android.monitorV2.hybridSetting.HybridSettingManagerImplV2$init$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        IHybridSettingDelegator iHybridSettingDelegator;
                        int i;
                        IHybridSettingDelegator iHybridSettingDelegator2;
                        IHybridSettingDelegator iHybridSettingDelegator3;
                        long currentTimeMillis = System.currentTimeMillis();
                        HybridSettingManagerImplV2.this.hybridSettingDelegator = new CacheHybridSettingDelegator();
                        MonitorLog.m29i("HybridSettingRequestServiceV2", "_init from local");
                        iHybridSettingDelegator = HybridSettingManagerImplV2.this.hybridSettingDelegator;
                        if (iHybridSettingDelegator.getSettingId() != 0) {
                            long lastFetchTime = LocalHybridSettingManager.getLastFetchTime();
                            iHybridSettingDelegator3 = HybridSettingManagerImplV2.this.hybridSettingDelegator;
                            i = (int) ((lastFetchTime + iHybridSettingDelegator3.getDuration()) - (System.currentTimeMillis() / 1000));
                            MonitorLog.m29i("HybridSettingRequestServiceV2", "_init local is not null, and durationUntilUpdate is " + i + " secs");
                            SettingsParseManager.INSTANCE.getParseListener().highPriorityTaskDone();
                            SettingsParseManager.INSTANCE.getParseListener().lowPriorityTaskDone();
                        } else {
                            i = 0;
                        }
                        if (i <= 0) {
                            MonitorLog.m29i("HybridSettingRequestServiceV2_init", "monitor setting init right now");
                            HybridSettingManagerImplV2.this.loopUpdate();
                        } else {
                            MonitorLog.m29i("HybridSettingRequestServiceV2_init", "monitor setting init after " + i + " secs");
                            HashMap hashMap = new HashMap();
                            iHybridSettingDelegator2 = HybridSettingManagerImplV2.this.hybridSettingDelegator;
                            hashMap.put("setting_id", String.valueOf(iHybridSettingDelegator2.getSettingId()));
                            InternalWatcher.INSTANCE.notice(null, InternalWatcher.EVENT_STARTUP_INIT, hashMap, null);
                            HybridSettingManagerImplV2.this.updateForDuration(i);
                        }
                        InternalWatcher.INSTANCE.notice(null, InternalWatcher.EVENT_SETTING_INIT, MapsKt.mapOf(TuplesKt.to(InternalWatcher.PARAM_SETTING_INIT_TYPE, "HybridSettingRequestServiceV2")), MapsKt.mapOf(TuplesKt.to(InternalWatcher.PARAM_SETTING_INIT_TIME, Long.valueOf(System.currentTimeMillis() - currentTimeMillis))));
                        MonitorLog.m26d("HybridSettingRequestServiceV2", "_init JsonOptConfig.isJsonOptEnable(): " + JsonOptConfig.isJsonOptEnable());
                        MonitorLog.m26d("HybridSettingRequestServiceV2", "_init cost: " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                });
            } catch (Throwable th) {
                ExceptionUtil.handleException(th);
            }
        }
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public void loopUpdate() {
        try {
            getSettingsThreadExecutor().submit(new Runnable() { // from class: com.bytedance.android.monitorV2.hybridSetting.HybridSettingManagerImplV2$loopUpdate$1
                @Override // java.lang.Runnable
                public final void run() {
                    ISettingRequestService hybridSettingRequestService;
                    IHybridSettingDelegator iHybridSettingDelegator;
                    long currentTimeMillis = System.currentTimeMillis();
                    hybridSettingRequestService = HybridSettingManagerImplV2.this.getHybridSettingRequestService();
                    HybridSettingResponse stepOneFromRequest = hybridSettingRequestService.stepOneFromRequest();
                    if (stepOneFromRequest != null) {
                        HybridSettingManagerImplV2.this.hybridSettingDelegator = new DefaultHybridSettingDelegator(stepOneFromRequest);
                        SettingsParseManager.INSTANCE.getParseListener().highPriorityTaskDone();
                        SettingsParseManager.INSTANCE.getParseListener().lowPriorityTaskDone();
                        MonitorLog.m29i("HybridSettingRequestServiceV2_update", "monitor setting update succeeded");
                        HybridSettingManagerImplV2 hybridSettingManagerImplV2 = HybridSettingManagerImplV2.this;
                        iHybridSettingDelegator = hybridSettingManagerImplV2.hybridSettingDelegator;
                        hybridSettingManagerImplV2.updateForDuration(iHybridSettingDelegator.getDuration());
                    } else {
                        MonitorLog.m27e("HybridSettingRequestServiceV2_update", "monitor setting update failed");
                        HybridSettingManagerImplV2.this.updateForDuration(600);
                    }
                    MonitorLog.m26d("HybridSettingRequestServiceV2", "_loopUpdate JsonOptConfig.isJsonOptEnable(): " + JsonOptConfig.isJsonOptEnable());
                    MonitorLog.m26d("HybridSettingRequestServiceV2", "_loopUpdate cost: " + (System.currentTimeMillis() - currentTimeMillis));
                }
            });
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public void updateForDuration(int n) {
        if (n > 0) {
            MonitorLog.m29i("HybridSettingRequestServiceV2_update", "monitor setting update after " + n + " secs");
            getSettingsThreadExecutor().schedule(new Runnable() { // from class: com.bytedance.android.monitorV2.hybridSetting.HybridSettingManagerImplV2$updateForDuration$r$1
                @Override // java.lang.Runnable
                public final void run() {
                    HybridSettingManagerImplV2.this.loopUpdate();
                }
            }, n, TimeUnit.SECONDS);
        }
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public BidInfo getBidInfo() {
        return this.hybridSettingDelegator.getBidInfo();
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public SwitchConfig getSwitch() {
        return this.hybridSettingDelegator.getSwitchConfig();
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public List<BidRegex> getRexList() {
        List<BidRegex> list = this.hybridSettingDelegator.getBidInfo().regexList;
        Intrinsics.checkNotNullExpressionValue(list, "hybridSettingDelegator.getBidInfo().regexList");
        return list;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public long getUpdateTime() {
        return this.hybridSettingDelegator.getUpdateTime();
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public int getDuration() {
        return this.hybridSettingDelegator.getDuration();
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public long getSettingId() {
        return this.hybridSettingDelegator.getSettingId();
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public Map<String, Integer> getAllEventSample() {
        return this.hybridSettingDelegator.getEventSample();
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public Set<String> getHostWhiteSet() {
        return this.hybridSettingDelegator.getHostWhiteSet();
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public CheckFilter getCheckFilter() {
        return this.hybridSettingDelegator.getCheckFilter();
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public HybridSettingInitConfig getInitConfig() {
        return this.initConfig;
    }
}

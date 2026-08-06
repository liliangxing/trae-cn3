package com.bytedance.timonbase.scene;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.bytedance.timon.foundation.interfaces.TimonBackgroundReferee;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.TMLogger;
import com.bytedance.timonbase.config.TMInitConfigService;
import com.bytedance.timonbase.report.TMMetric;
import com.bytedance.timonbase.scene.config.SenseConfigManager;
import com.bytedance.timonbase.scene.synchronizer.BasicModeSynchronizer;
import com.bytedance.timonbase.scene.synchronizer.ElderModeSynchronizer;
import com.bytedance.timonbase.scene.synchronizer.PrivacyAgreedStatusSynchronizer;
import com.bytedance.timonbase.scene.synchronizer.TeenModeSynchronizer;
import com.bytedance.timonbase.utils.TMThreadUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: ScenesDetector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u00106\u001a\u00020&J\u0006\u00107\u001a\u00020&JB\u00108\u001a\u00020\u00042\b\b\u0002\u00109\u001a\u00020\u000f2\b\b\u0002\u0010:\u001a\u00020\u000f2\b\b\u0002\u0010;\u001a\u00020\u000f2\b\b\u0002\u0010<\u001a\u00020\u000f2\b\b\u0002\u0010=\u001a\u00020\u000f2\b\b\u0002\u0010>\u001a\u00020\u000fJ\u0006\u0010?\u001a\u00020&J\u0006\u0010@\u001a\u00020\u0004J\b\u0010A\u001a\u00020\u000fH\u0002J\b\u0010B\u001a\u00020&H\u0002J\u0018\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\f2\b\b\u0002\u0010F\u001a\u00020\u0004J\u0010\u0010G\u001a\u00020D2\u0006\u0010H\u001a\u00020IH\u0002J\u0006\u0010J\u001a\u00020\u000fJ\u0006\u0010K\u001a\u00020\u000fJ\u0006\u0010L\u001a\u00020\u000fJ\u0006\u0010M\u001a\u00020\u000fJ\u0006\u0010N\u001a\u00020\u000fJ\u0006\u0010O\u001a\u00020\u000fJ\u0006\u0010P\u001a\u00020\u000fJ\u0006\u0010Q\u001a\u00020\u000fJ\u0006\u0010R\u001a\u00020\u000fJ\u0006\u0010S\u001a\u00020\u000fJ\u0010\u0010T\u001a\u00020D2\u0006\u0010:\u001a\u00020\u000fH\u0002J\u000e\u0010U\u001a\u00020D2\u0006\u0010:\u001a\u00020\u000fJ\u0010\u0010V\u001a\u00020D2\u0006\u0010;\u001a\u00020\u000fH\u0002J\u000e\u0010W\u001a\u00020D2\u0006\u0010;\u001a\u00020\u000fJ\u0010\u0010X\u001a\u00020D2\u0006\u0010Y\u001a\u00020\u000fH\u0002J\u000e\u0010Z\u001a\u00020D2\u0006\u0010Y\u001a\u00020\u000fJ\u0010\u0010[\u001a\u00020D2\u0006\u0010<\u001a\u00020\u000fH\u0002J\u000e\u0010\\\u001a\u00020D2\u0006\u0010<\u001a\u00020\u000fJ\u000e\u0010]\u001a\u00020D2\u0006\u0010H\u001a\u00020IJ\u000e\u0010^\u001a\u00020D2\u0006\u0010_\u001a\u00020\u0015J\u0016\u0010`\u001a\u00020D2\u000e\u0010a\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ\u000e\u0010b\u001a\u00020D2\u0006\u0010H\u001a\u00020IJ\u0006\u0010c\u001a\u00020DR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010'\u001a\u00020&2\u0006\u0010\u0014\u001a\u00020&@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020&X\u0082D¢\u0006\u0002\n\u0000R\"\u0010.\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0011\"\u0004\b0\u0010\u0013R$\u00101\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006d"}, d2 = {"Lcom/bytedance/timonbase/scene/ScenesDetector;", "", "()V", "APP_MODE_ENABLE", "", "COLD_LAUNCH", "HOT_LAUNCH", "MODE_BACKGROUND", "MODE_BASIC", "MODE_PRIVACY", "MODE_TEEN", "TAG", "", "agreedPrivacyReferee", "Lkotlin/Function0;", "", "getAgreedPrivacyReferee", "()Lkotlin/jvm/functions/Function0;", "setAgreedPrivacyReferee", "(Lkotlin/jvm/functions/Function0;)V", "<set-?>", "Lcom/bytedance/timon/foundation/interfaces/TimonBackgroundReferee;", "appBackgroundReferee", "getAppBackgroundReferee", "()Lcom/bytedance/timon/foundation/interfaces/TimonBackgroundReferee;", "appSilenceReferee", "Lcom/bytedance/timonbase/scene/AppSilenceReferee;", "basicModeReferee", "getBasicModeReferee", "setBasicModeReferee", "elderModeReferee", "enableTeenModeRead", "getEnableTeenModeRead", "()Z", "setEnableTeenModeRead", "(Z)V", "foregroundCount", "hotLaunchTime", "", "initialTime", "getInitialTime", "()J", "isInit", "sensesUpdateBroadcastReceiver", "Lcom/bytedance/timonbase/scene/SensesUpdateBroadcastReceiver;", "silentThreshold", "teenModeReferee", "getTeenModeReferee", "setTeenModeReferee", "timonAppMode", "getTimonAppMode", "()I", "setTimonAppMode$timonbase_release", "(I)V", "coldLaunchDuration", "enterBackgroundDuration", "getAppMode", "background", "agreedPrivacy", "basicMode", "teenMode", "hotLaunch", "coldLaunch", "getEnterSilenceDuration", "getSilentStage", "getTeenModeForAppMode", "hotLaunchDuration", "infiltratorErrorHappen", "", "errorMsg", AccountMonitorConstants.CommonParameter.ERROR, "initMultiProcessDetectSupport", "application", "Landroid/app/Application;", "isAgreedPrivacy", "isAppBackground", "isBasicMode", "isColdLaunchScene", "isElderMode", "isEnableMultiProcessDetect", "isHotLaunchScene", "isSilent", "isStrictBackground", "isTeenMode", "notifyAgreedPrivacyChanged", "notifyAgreedPrivacyModChanged", "notifyBasicModChanged", "notifyBasicModeChanged", "notifyElderModChanged", "oldMode", "notifyElderModeChanged", "notifyTeenModChanged", "notifyTeenModeChanged", "pureInit", "setAppBackgroundReferee", "backgroundReferee", "setOldModeReferee", "oldModeReferee", "start", "updateThreshold", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ScenesDetector {
    private static final int APP_MODE_ENABLE = 1;
    private static final int COLD_LAUNCH = 32;
    private static final int HOT_LAUNCH = 64;
    private static final int MODE_BACKGROUND = 16;
    private static final int MODE_BASIC = 4;
    private static final int MODE_PRIVACY = 2;
    private static final int MODE_TEEN = 8;
    private static final String TAG = "ScenesDetector";
    private static Function0<Boolean> agreedPrivacyReferee = null;
    private static TimonBackgroundReferee appBackgroundReferee = null;
    private static AppSilenceReferee appSilenceReferee = null;
    private static Function0<Boolean> basicModeReferee = null;
    private static Function0<Boolean> elderModeReferee = null;
    private static boolean enableTeenModeRead = false;
    private static int foregroundCount = 0;
    private static long hotLaunchTime = 0;
    private static long initialTime = 0;
    private static boolean isInit = false;
    private static SensesUpdateBroadcastReceiver sensesUpdateBroadcastReceiver = null;
    private static Function0<Boolean> teenModeReferee;
    private static int timonAppMode;
    public static final ScenesDetector INSTANCE = new ScenesDetector();
    private static final long silentThreshold = 60000;

    public final int getAppMode(boolean background, boolean agreedPrivacy, boolean basicMode, boolean teenMode, boolean hotLaunch, boolean coldLaunch) {
        return (background ? 16 : 0) | 1 | (agreedPrivacy ? 0 : 2) | (basicMode ? 4 : 0) | (teenMode ? 8 : 0) | (hotLaunch ? 64 : 0) | (coldLaunch ? 32 : 0);
    }

    private ScenesDetector() {
    }

    public final int getTimonAppMode() {
        return timonAppMode;
    }

    public final void setTimonAppMode$timonbase_release(int i) {
        timonAppMode = i;
    }

    public final boolean getEnableTeenModeRead() {
        return enableTeenModeRead;
    }

    public final void setEnableTeenModeRead(boolean z) {
        enableTeenModeRead = z;
    }

    public final Function0<Boolean> getAgreedPrivacyReferee() {
        return agreedPrivacyReferee;
    }

    public final void setAgreedPrivacyReferee(Function0<Boolean> function0) {
        agreedPrivacyReferee = function0;
    }

    public final Function0<Boolean> getBasicModeReferee() {
        return basicModeReferee;
    }

    public final void setBasicModeReferee(Function0<Boolean> function0) {
        basicModeReferee = function0;
    }

    public final Function0<Boolean> getTeenModeReferee() {
        return teenModeReferee;
    }

    public final void setTeenModeReferee(Function0<Boolean> function0) {
        teenModeReferee = function0;
    }

    public final TimonBackgroundReferee getAppBackgroundReferee() {
        return appBackgroundReferee;
    }

    public final long getInitialTime() {
        return initialTime;
    }

    public final void pureInit(Application application) {
        AppBackgroundReferee appBackgroundReferee2;
        Intrinsics.checkParameterIsNotNull(application, "application");
        if (isInit) {
            return;
        }
        isInit = true;
        initialTime = SystemClock.elapsedRealtime();
        timonAppMode = getAppMode$default(this, false, false, false, false, false, true, 31, null);
        TMThreadUtils.INSTANCE.postDelay(30000L, new Function0<Unit>() { // from class: com.bytedance.timonbase.scene.ScenesDetector$pureInit$1
            public /* bridge */ /* synthetic */ Object invoke() {
                m1070invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1070invoke() {
                ScenesDetector.INSTANCE.setTimonAppMode$timonbase_release(ScenesDetector.getAppMode$default(ScenesDetector.INSTANCE, false, false, false, false, false, false, 31, null));
            }
        });
        if (appBackgroundReferee == null) {
            if (TMEnv.INSTANCE.getEnableProcessLifecycle()) {
                appBackgroundReferee2 = new ProcessBackgroundReferee();
            } else {
                appBackgroundReferee2 = new AppBackgroundReferee(application);
            }
            appBackgroundReferee = appBackgroundReferee2;
        }
        TimonBackgroundReferee timonBackgroundReferee = appBackgroundReferee;
        if (timonBackgroundReferee != null) {
            timonBackgroundReferee.addStatusChangeListener(new Function1<Boolean, Unit>() { // from class: com.bytedance.timonbase.scene.ScenesDetector$pureInit$2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    int i;
                    if (!z) {
                        ScenesDetector scenesDetector = ScenesDetector.INSTANCE;
                        ScenesDetector.hotLaunchTime = SystemClock.elapsedRealtime();
                        ScenesDetector scenesDetector2 = ScenesDetector.INSTANCE;
                        i = ScenesDetector.foregroundCount;
                        ScenesDetector.foregroundCount = i + 1;
                        ScenesDetector.INSTANCE.setTimonAppMode$timonbase_release(ScenesDetector.getAppMode$default(ScenesDetector.INSTANCE, false, false, false, false, true, false, 46, null));
                    }
                    TMThreadUtils.INSTANCE.postDelay(30000L, new Function0<Unit>() { // from class: com.bytedance.timonbase.scene.ScenesDetector$pureInit$2.1
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1071invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m1071invoke() {
                            ScenesDetector.INSTANCE.setTimonAppMode$timonbase_release(ScenesDetector.getAppMode$default(ScenesDetector.INSTANCE, false, false, false, false, false, false, 63, null));
                        }
                    });
                }
            });
        }
    }

    public final void start(final Application application) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        pureInit(application);
        if (TMEnv.INSTANCE.isInitOpt()) {
            if (TMInitConfigService.INSTANCE.getBoolean(TMInitConfigService.SILENT_MODE_ENABLE, false)) {
                appSilenceReferee = new AppSilenceReferee(TMInitConfigService.INSTANCE.getLong(TMInitConfigService.SILENT_MODE_DURATION, silentThreshold));
            }
            TMThreadUtils.INSTANCE.async(new Function0<Unit>() { // from class: com.bytedance.timonbase.scene.ScenesDetector$start$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m1072invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1072invoke() {
                    SenseConfigManager.INSTANCE.fetchConfig();
                    ScenesDetector.INSTANCE.initMultiProcessDetectSupport(application);
                }
            });
        } else {
            SenseConfigManager.INSTANCE.fetchConfig();
            if (SenseConfigManager.INSTANCE.silentSceneEnable()) {
                appSilenceReferee = new AppSilenceReferee(SenseConfigManager.INSTANCE.silenceThreshold());
            }
        }
        TMThreadUtils.INSTANCE.async(new Function0<Unit>() { // from class: com.bytedance.timonbase.scene.ScenesDetector$start$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m1073invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1073invoke() {
                ScenesDetector.INSTANCE.initMultiProcessDetectSupport(application);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initMultiProcessDetectSupport(Application application) {
        if (isEnableMultiProcessDetect()) {
            AppStatusMonitor.initialize$default(application, SenseConfigManager.INSTANCE.canUseRunningAppProcesses(), false, 4, null);
            SensesUpdateBroadcastReceiver sensesUpdateBroadcastReceiver2 = new SensesUpdateBroadcastReceiver(application);
            sensesUpdateBroadcastReceiver = sensesUpdateBroadcastReceiver2;
            m226xfe3601cb(application, sensesUpdateBroadcastReceiver2, new IntentFilter(SensesUpdateBroadcastReceiver.APP_SENSE_UPDATE_ACTION));
            Function0<Boolean> function0 = agreedPrivacyReferee;
            if (function0 != null) {
                INSTANCE.notifyAgreedPrivacyChanged(((Boolean) function0.invoke()).booleanValue());
            }
            Function0<Boolean> function02 = teenModeReferee;
            if (function02 != null) {
                INSTANCE.notifyTeenModChanged(((Boolean) function02.invoke()).booleanValue());
            }
            Function0<Boolean> function03 = basicModeReferee;
            if (function03 != null) {
                INSTANCE.notifyBasicModChanged(((Boolean) function03.invoke()).booleanValue());
            }
            Function0<Boolean> function04 = elderModeReferee;
            if (function04 != null) {
                INSTANCE.notifyElderModChanged(((Boolean) function04.invoke()).booleanValue());
            }
        }
    }

    public final void updateThreshold() {
        TMThreadUtils.INSTANCE.async(new Function0<Unit>() { // from class: com.bytedance.timonbase.scene.ScenesDetector$updateThreshold$1
            public /* bridge */ /* synthetic */ Object invoke() {
                m1074invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1074invoke() {
                AppSilenceReferee appSilenceReferee2;
                long j;
                AppSilenceReferee appSilenceReferee3;
                SenseConfigManager.INSTANCE.updateConfig();
                if (TMEnv.INSTANCE.isInitOpt()) {
                    TMInitConfigService tMInitConfigService = TMInitConfigService.INSTANCE;
                    ScenesDetector scenesDetector = ScenesDetector.INSTANCE;
                    j = ScenesDetector.silentThreshold;
                    long j2 = tMInitConfigService.getLong(TMInitConfigService.SILENT_MODE_DURATION, j);
                    ScenesDetector scenesDetector2 = ScenesDetector.INSTANCE;
                    appSilenceReferee3 = ScenesDetector.appSilenceReferee;
                    if (appSilenceReferee3 != null) {
                        appSilenceReferee3.updateThreshold(j2);
                        return;
                    }
                    return;
                }
                long silenceThreshold = SenseConfigManager.INSTANCE.silenceThreshold();
                ScenesDetector scenesDetector3 = ScenesDetector.INSTANCE;
                appSilenceReferee2 = ScenesDetector.appSilenceReferee;
                if (appSilenceReferee2 != null) {
                    appSilenceReferee2.updateThreshold(silenceThreshold);
                }
            }
        });
    }

    public final void setAppBackgroundReferee(TimonBackgroundReferee backgroundReferee) {
        Intrinsics.checkParameterIsNotNull(backgroundReferee, "backgroundReferee");
        appBackgroundReferee = backgroundReferee;
    }

    public final void setOldModeReferee(Function0<Boolean> oldModeReferee) {
        elderModeReferee = oldModeReferee;
    }

    public static /* synthetic */ void infiltratorErrorHappen$default(ScenesDetector scenesDetector, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -2;
        }
        scenesDetector.infiltratorErrorHappen(str, i);
    }

    public final void infiltratorErrorHappen(String errorMsg, int errorCode) {
        Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
        if (TMEnv.INSTANCE.isInitOpt()) {
            appSilenceReferee = null;
        } else {
            SenseConfigManager.INSTANCE.forbidSilence();
        }
        TMMetric.INSTANCE.reportSilentInit(errorCode, errorMsg);
    }

    public final void notifyAgreedPrivacyModChanged(boolean agreedPrivacy) {
        timonAppMode = getAppMode$default(this, false, agreedPrivacy, false, false, false, false, 61, null);
        if (isEnableMultiProcessDetect()) {
            notifyAgreedPrivacyChanged(agreedPrivacy);
        }
    }

    public final void notifyTeenModeChanged(boolean teenMode) {
        timonAppMode = getAppMode$default(this, false, false, false, teenMode, false, false, 55, null);
        if (isEnableMultiProcessDetect()) {
            notifyTeenModChanged(teenMode);
        }
    }

    public final void notifyBasicModeChanged(boolean basicMode) {
        timonAppMode = getAppMode$default(this, false, false, basicMode, false, false, false, 59, null);
        if (isEnableMultiProcessDetect()) {
            notifyBasicModChanged(basicMode);
        }
    }

    public final void notifyElderModeChanged(boolean oldMode) {
        if (isEnableMultiProcessDetect()) {
            notifyElderModChanged(oldMode);
        }
    }

    public final boolean isAgreedPrivacy() {
        Boolean bool;
        if (isEnableMultiProcessDetect()) {
            return PrivacyAgreedStatusSynchronizer.INSTANCE.getCurrentSenseStatus().booleanValue();
        }
        Function0<Boolean> function0 = agreedPrivacyReferee;
        if (function0 != null && (bool = (Boolean) function0.invoke()) != null) {
            return bool.booleanValue();
        }
        TMLogger.INSTANCE.m221e(TAG, "未注册隐私协议");
        return true;
    }

    public final boolean isBasicMode() {
        Boolean bool;
        if (isEnableMultiProcessDetect()) {
            return BasicModeSynchronizer.INSTANCE.getCurrentSenseStatus().booleanValue();
        }
        Function0<Boolean> function0 = basicModeReferee;
        if (function0 != null && (bool = (Boolean) function0.invoke()) != null) {
            return bool.booleanValue();
        }
        TMLogger.INSTANCE.m221e(TAG, "未注册基础模式");
        return false;
    }

    public final boolean isTeenMode() {
        Boolean bool;
        if (isEnableMultiProcessDetect()) {
            return TeenModeSynchronizer.INSTANCE.getCurrentSenseStatus().booleanValue();
        }
        Function0<Boolean> function0 = teenModeReferee;
        if (function0 != null && (bool = (Boolean) function0.invoke()) != null) {
            return bool.booleanValue();
        }
        TMLogger.INSTANCE.m221e(TAG, "未注册青少年模式");
        return false;
    }

    private final boolean getTeenModeForAppMode() {
        if (TMEnv.INSTANCE.getEnableDelayInit()) {
            return enableTeenModeRead && isTeenMode();
        }
        return isTeenMode();
    }

    public static /* synthetic */ int getAppMode$default(ScenesDetector scenesDetector, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, Object obj) {
        if ((i & 1) != 0) {
            z = scenesDetector.isAppBackground() && scenesDetector.enterBackgroundDuration() >= 30000;
        }
        if ((i & 2) != 0) {
            z2 = scenesDetector.isAgreedPrivacy();
        }
        boolean z7 = z2;
        if ((i & 4) != 0) {
            z3 = scenesDetector.isBasicMode();
        }
        boolean z8 = z3;
        if ((i & 8) != 0) {
            z4 = scenesDetector.getTeenModeForAppMode();
        }
        boolean z9 = z4;
        if ((i & 16) != 0) {
            z5 = scenesDetector.hotLaunchDuration() < 30000;
        }
        boolean z10 = z5;
        if ((i & 32) != 0) {
            z6 = scenesDetector.coldLaunchDuration() < 30000;
        }
        return scenesDetector.getAppMode(z, z7, z8, z9, z10, z6);
    }

    public final boolean isElderMode() {
        Boolean bool;
        if (isEnableMultiProcessDetect()) {
            return ElderModeSynchronizer.INSTANCE.getCurrentSenseStatus().booleanValue();
        }
        Function0<Boolean> function0 = elderModeReferee;
        if (function0 != null && (bool = (Boolean) function0.invoke()) != null) {
            return bool.booleanValue();
        }
        TMLogger.INSTANCE.m221e(TAG, "未注册老年模式");
        return false;
    }

    public final boolean isAppBackground() {
        if (isEnableMultiProcessDetect()) {
            return AppStatusMonitor.getProcessLifecycle().isAppBackground(SenseConfigManager.INSTANCE.backgroundTolerableDuration());
        }
        TimonBackgroundReferee timonBackgroundReferee = appBackgroundReferee;
        if (timonBackgroundReferee != null) {
            return timonBackgroundReferee.get_isAppBackground();
        }
        return false;
    }

    public final boolean isSilent() {
        if (TMEnv.INSTANCE.isInitOpt()) {
            if (appSilenceReferee == null) {
                return false;
            }
        } else if (!SenseConfigManager.INSTANCE.silentSceneEnable()) {
            return false;
        }
        AppSilenceReferee appSilenceReferee2 = appSilenceReferee;
        if (appSilenceReferee2 != null) {
            return appSilenceReferee2.isAppSilence();
        }
        TMLogger.INSTANCE.m221e(TAG, "静默检测模块未完成初始化");
        return false;
    }

    public final long getEnterSilenceDuration() {
        if (TMEnv.INSTANCE.isInitOpt()) {
            if (appSilenceReferee == null) {
                return 0L;
            }
        } else if (!SenseConfigManager.INSTANCE.silentSceneEnable()) {
            return 0L;
        }
        AppSilenceReferee appSilenceReferee2 = appSilenceReferee;
        if (appSilenceReferee2 != null) {
            return appSilenceReferee2.getAppEnterSilenceTime();
        }
        TMLogger.INSTANCE.m221e(TAG, "静默检测模块未完成初始化");
        return 0L;
    }

    public final int getSilentStage() {
        AppSilenceReferee appSilenceReferee2 = appSilenceReferee;
        if (appSilenceReferee2 == null) {
            return 0;
        }
        if (appSilenceReferee2 != null) {
            return appSilenceReferee2.getAppSilentStage();
        }
        TMLogger.INSTANCE.m221e(TAG, "静默检测模块未完成初始化");
        return 0;
    }

    public final long enterBackgroundDuration() {
        if (isEnableMultiProcessDetect()) {
            return AppStatusMonitor.getProcessLifecycle().getAppInBackgroundTime();
        }
        TimonBackgroundReferee timonBackgroundReferee = appBackgroundReferee;
        if (timonBackgroundReferee == null || timonBackgroundReferee.getEnterBackgroundPts() == 0) {
            return 0L;
        }
        return SystemClock.elapsedRealtime() - timonBackgroundReferee.getEnterBackgroundPts();
    }

    public final boolean isStrictBackground() {
        if (SenseConfigManager.INSTANCE.enableStrictBackgroundScene()) {
            return ((coldLaunchDuration() > ((long) SenseConfigManager.INSTANCE.coldLaunchDurationThreshold()) ? 1 : (coldLaunchDuration() == ((long) SenseConfigManager.INSTANCE.coldLaunchDurationThreshold()) ? 0 : -1)) >= 0) && ((enterBackgroundDuration() > ((long) SenseConfigManager.INSTANCE.enterBackgroundDurationThreshold()) ? 1 : (enterBackgroundDuration() == ((long) SenseConfigManager.INSTANCE.enterBackgroundDurationThreshold()) ? 0 : -1)) >= 0);
        }
        return false;
    }

    public final boolean isColdLaunchScene() {
        return SenseConfigManager.INSTANCE.coldLaunchSceneEnable() && coldLaunchDuration() <= ((long) SenseConfigManager.INSTANCE.coldLaunchSceneDurationThreshold());
    }

    public final boolean isHotLaunchScene() {
        return SenseConfigManager.INSTANCE.hotLaunchSceneEnable() && foregroundCount > 1 && hotLaunchDuration() <= ((long) SenseConfigManager.INSTANCE.hotLaunchSceneDurationThreshold());
    }

    private final long hotLaunchDuration() {
        if (hotLaunchTime <= 0) {
            return Long.MAX_VALUE;
        }
        return SystemClock.elapsedRealtime() - hotLaunchTime;
    }

    public final long coldLaunchDuration() {
        return SystemClock.elapsedRealtime() - initialTime;
    }

    public final boolean isEnableMultiProcessDetect() {
        return TMEnv.INSTANCE.getInitialed() && SenseConfigManager.INSTANCE.multiProcessEnable();
    }

    private final void notifyAgreedPrivacyChanged(boolean agreedPrivacy) {
        SensesUpdateBroadcastReceiver.INSTANCE.updatePrivacyAgreed(agreedPrivacy);
    }

    private final void notifyTeenModChanged(boolean teenMode) {
        SensesUpdateBroadcastReceiver.INSTANCE.updateTeenMode(teenMode);
    }

    private final void notifyBasicModChanged(boolean basicMode) {
        SensesUpdateBroadcastReceiver.INSTANCE.updateBasicMode(basicMode);
    }

    private final void notifyElderModChanged(boolean oldMode) {
        SensesUpdateBroadcastReceiver.INSTANCE.updateElderMode(oldMode);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_timonbase_scene_ScenesDetector_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m226xfe3601cb(Application application, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                return application.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                return ContextCompat.registerReceiver(application, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
            }
            return application.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
}

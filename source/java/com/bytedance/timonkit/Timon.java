package com.bytedance.timonkit;

import android.app.Application;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.timon.foundation.TimonFoundation;
import com.bytedance.timon.foundation.impl.EventMonitorImp;
import com.bytedance.timon.foundation.interfaces.IAppLog;
import com.bytedance.timon.foundation.interfaces.IEventMonitor;
import com.bytedance.timon.foundation.interfaces.IExceptionMonitor;
import com.bytedance.timon.foundation.interfaces.ILogger;
import com.bytedance.timon.foundation.interfaces.IStore;
import com.bytedance.timon.foundation.interfaces.TimonBackgroundReferee;
import com.bytedance.timonbase.ITMBasicModeLifecycleService;
import com.bytedance.timonbase.ITMBusinessService;
import com.bytedance.timonbase.ITMLifecycleService;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.TMInitialExtra;
import com.bytedance.timonbase.TMLogger;
import com.bytedance.timonbase.TimonConstantKt;
import com.bytedance.timonbase.cache.TMCacheService;
import com.bytedance.timonbase.cache.TMCacheTaskManager;
import com.bytedance.timonbase.config.TMConfigService;
import com.bytedance.timonbase.config.TMInitConfigService;
import com.bytedance.timonbase.config.TMSettingFetcher;
import com.bytedance.timonbase.pipeline.TimonBasicModeCenter;
import com.bytedance.timonbase.report.TMDataCollector;
import com.bytedance.timonbase.report.TMMetric;
import com.bytedance.timonbase.report.TMReportCache;
import com.bytedance.timonbase.scene.ScenesDetector;
import com.bytedance.timonbase.utils.EnumUtils;
import com.bytedance.timonbase.utils.ProcessUtil;
import com.bytedance.timonbase.utils.TMThreadUtils;
import com.bytedance.timonbase.utils.TMTimer;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Timon.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0010J\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tJ\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tH\u0007J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tJ\u0006\u0010\u0017\u001a\u00020\u000eJ\u0006\u0010\u0018\u001a\u00020\u0019J#\u0010\u001a\u001a\u0002H\u001b\"\b\b\u0000\u0010\u001b*\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001e¢\u0006\u0002\u0010\u001fJ4\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00192\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(JV\u0010)\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&2\u0010\u0010*\u001a\f\u0012\u0004\u0012\u00020\t0$j\u0002`+2\u0010\u0010,\u001a\f\u0012\u0004\u0012\u00020\t0$j\u0002`+2\u0010\u0010-\u001a\f\u0012\u0004\u0012\u00020\t0$j\u0002`+2\u0006\u0010.\u001a\u00020\t2\b\b\u0002\u0010/\u001a\u000200J\u000e\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u000203J\u000e\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u000206J\u000e\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u000209J\u000e\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020<J\u000e\u0010=\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020?J\u000e\u0010@\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020BJ(\u0010C\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u0019H\u0002J\u0006\u0010F\u001a\u00020\tJ\u000e\u0010G\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\tJ\u000e\u0010I\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020\tJ\u000e\u0010K\u001a\u00020\u000e2\u0006\u0010L\u001a\u00020\tJ\u000e\u0010M\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020\tJ\u0018\u0010O\u001a\u00020\u000e2\u0010\u0010-\u001a\f\u0012\u0004\u0012\u00020\t0$j\u0002`+J\u000e\u0010P\u001a\u00020\u000e2\u0006\u0010Q\u001a\u00020RJ\u000e\u0010S\u001a\u00020\u000e2\u0006\u0010T\u001a\u00020&J\u001a\u0010U\u001a\u00020\u000e2\u0010\u0010V\u001a\f\u0012\u0004\u0012\u00020\t0$j\u0002`WH\u0007J\u0018\u0010X\u001a\u00020\u000e2\u0010\u0010*\u001a\f\u0012\u0004\u0012\u00020\t0$j\u0002`+J\u0018\u0010Y\u001a\u00020\u000e2\u0010\u0010Z\u001a\f\u0012\u0004\u0012\u00020\t0$j\u0002`+J\"\u0010[\u001a\u00020\u000e2\u0018\u0010\\\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010^0]j\u0002`_H\u0007J\"\u0010`\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020\u00042\u0012\u0010b\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010^0$j\u0002`cJ\u0018\u0010d\u001a\u00020\u000e2\u0010\u0010,\u001a\f\u0012\u0004\u0012\u00020\t0$j\u0002`+J\u000e\u0010e\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tJ\u000e\u0010f\u001a\u00020\u000e2\u0006\u0010g\u001a\u00020\u0004J\u0010\u0010h\u001a\u00020\u000e2\b\b\u0002\u0010i\u001a\u00020\tJ\u000e\u0010j\u001a\u00020\u000e2\u0006\u0010k\u001a\u00020^J\u000e\u0010l\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tJ\u000e\u0010m\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tJ\u000e\u0010n\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tJ\u000e\u0010o\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tJ\u000e\u0010p\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tJ\u000e\u0010q\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tJ\u000e\u0010r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tJ\u0010\u0010s\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\tJ\u000e\u0010t\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tJ\u000e\u0010u\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tJ\u000e\u0010v\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006w"}, d2 = {"Lcom/bytedance/timonkit/Timon;", "", "()V", "TAG", "", "initialedServices", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/timonbase/ITMLifecycleService;", "manuallySetDebuggable", "", "minutesTimer", "Lcom/bytedance/timonbase/utils/TMTimer;", "registeredSettingFetcher", "appendCommonParams", "", "params", "", "delayAsyncInit", "enableClipboardCompliance", "enable", "enableLocalSetting", "enablePipeline", "enableRulerParamGetEarlierCompliance", "flushSettings", "getSilenceStage", "", "getTimonBusiness", "T", "Lcom/bytedance/timonbase/ITMBusinessService;", "business", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/timonbase/ITMBusinessService;", "init", Constant.KEY_CHANNEL, "appId", "deviceIdGetter", "Lkotlin/Function0;", "context", "Landroid/app/Application;", "extra", "Lcom/bytedance/timonbase/TMInitialExtra;", "initBasic", "basicModeReferee", "Lcom/bytedance/timonbase/scene/ModeReferee;", "teenModeReferee", "agreedPrivacyReferee", "isFuse", "postSampleRate", "", "injectAppLog", "appLog", "Lcom/bytedance/timon/foundation/interfaces/IAppLog;", "injectEventMonitor", "eventMonitor", "Lcom/bytedance/timon/foundation/interfaces/IEventMonitor;", "injectExceptionMonitor", "exceptionMonitor", "Lcom/bytedance/timon/foundation/interfaces/IExceptionMonitor;", "injectIOExecutor", "executor", "Ljava/util/concurrent/ExecutorService;", "injectKvStore", "store", "Lcom/bytedance/timon/foundation/interfaces/IStore;", "injectLogger", "logger", "Lcom/bytedance/timon/foundation/interfaces/ILogger;", "innerInjectEventMonitor", "deviceId", "hostAId", "isAppBackground", "notifyAgreedPrivacyModChanged", "agreedPrivacyMode", "notifyBasicModeChanged", "basicMode", "notifyElderModeChanged", "elderMode", "notifyTeenModeChanged", "teenMode", "registerAgreedPrivacyReferee", "registerAppBackgroundReferee", "backgroundReferee", "Lcom/bytedance/timon/foundation/interfaces/TimonBackgroundReferee;", "registerApplicationContext", "application", "registerAutoReadClipboardToggleReferee", "referee", "Lcom/bytedance/timonbase/scene/AutoReadClipboardToggleReferee;", "registerBasicModeReferee", "registerElderModeReferee", "elderModeReferee", "registerSettingsFetcher", "fetter", "Lkotlin/Function1;", "Lcom/google/gson/JsonObject;", "Lcom/bytedance/timonbase/scene/SettingFetcher;", "registerSubSettingFetcher", "subKey", "fetcher", "Lcom/bytedance/timonbase/scene/SubSettingFetcher;", "registerTeenModeReferee", "setClipboardSuiteUseRule", "setConfigValidMark", "mark", "setDebugModel", "debug", "setDefaultConfig", "config", "setEnableAntiSurvival", "setEnableBpea", "setEnableClipboardPermissionDetect", "setEnableHelios", "setEnableReadPhoneStateDowngrade", "setEnableRuler", "setEnableRunningProcessDowngrade", "setTimonInitOptEnable", "toggleDelayInit", "toggleProcessLifecycle", "toggleTimonToken", "timonkit_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class Timon {
    private static final String TAG = "Timon";
    private static boolean manuallySetDebuggable;
    private static TMTimer minutesTimer;
    private static boolean registeredSettingFetcher;
    public static final Timon INSTANCE = new Timon();
    private static final CopyOnWriteArrayList<ITMLifecycleService> initialedServices = new CopyOnWriteArrayList<>();

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnumUtils.WorkType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[EnumUtils.WorkType.MAIN.ordinal()] = 1;
            iArr[EnumUtils.WorkType.BACKGROUND.ordinal()] = 2;
        }
    }

    @Deprecated(message = "not supported")
    public final void registerAutoReadClipboardToggleReferee(Function0<Boolean> referee) {
        Intrinsics.checkParameterIsNotNull(referee, "referee");
    }

    private Timon() {
    }

    public final void initBasic(Application context, Function0<Boolean> basicModeReferee, Function0<Boolean> teenModeReferee, Function0<Boolean> agreedPrivacyReferee, boolean isFuse, long postSampleRate) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(basicModeReferee, "basicModeReferee");
        Intrinsics.checkParameterIsNotNull(teenModeReferee, "teenModeReferee");
        Intrinsics.checkParameterIsNotNull(agreedPrivacyReferee, "agreedPrivacyReferee");
        TMEnv.INSTANCE.setApplication(context);
        TimonBasicModeCenter.INSTANCE.setAgreedPrivacy(agreedPrivacyReferee);
        TimonBasicModeCenter.INSTANCE.setBasicMode(basicModeReferee);
        TimonBasicModeCenter.INSTANCE.setTeenMode(teenModeReferee);
        TimonBasicModeCenter.INSTANCE.setPostSampleRate(postSampleRate);
        if (isFuse) {
            TimonBasicModeCenter.INSTANCE.enableFuse();
        }
        Set services = ServiceManager.get().getServices(ITMBasicModeLifecycleService.class);
        Intrinsics.checkExpressionValueIsNotNull(services, "ServiceManager.get().get…cycleService::class.java)");
        for (ITMBasicModeLifecycleService iTMBasicModeLifecycleService : CollectionsKt.sortedWith(services, new Comparator<T>() { // from class: com.bytedance.timonkit.Timon$initBasic$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((ITMBasicModeLifecycleService) t2).priority().getValue()), Integer.valueOf(((ITMBasicModeLifecycleService) t).priority().getValue()));
            }
        })) {
            TMLogger.INSTANCE.m219d(TAG, iTMBasicModeLifecycleService.getClass() + " init called");
            iTMBasicModeLifecycleService.init(isFuse);
        }
        TMEnv.INSTANCE.setBasicModeEnable(true);
    }

    public final void init(final String channel, final int appId, final Function0<String> deviceIdGetter, final Application context, final TMInitialExtra extra) {
        Intrinsics.checkParameterIsNotNull(channel, Constant.KEY_CHANNEL);
        Intrinsics.checkParameterIsNotNull(deviceIdGetter, "deviceIdGetter");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(extra, "extra");
        TMMetric.TimingCounter timingCounter = new TMMetric.TimingCounter(null, 0L, null, 7, null);
        TMEnv.INSTANCE.setInitialed(true);
        TMEnv.INSTANCE.setDidGetter(deviceIdGetter);
        TMEnv.INSTANCE.setAppId(appId);
        TMEnv.INSTANCE.setChannel(channel);
        TMEnv.INSTANCE.setVersionName(extra.getVersionName());
        TMEnv.INSTANCE.setVersionCode(extra.getVersionCode());
        TMEnv.INSTANCE.setUpdateVersionCode(extra.getUpdateVersionCode());
        TMEnv.INSTANCE.setApplication(context);
        if (!manuallySetDebuggable) {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                TMLogger.INSTANCE.setDebug(true);
                TMEnv.INSTANCE.setDEBUG(true);
            }
        }
        TMEnv tMEnv = TMEnv.INSTANCE;
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        String name = currentThread.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "Thread.currentThread().name");
        tMEnv.setInitThread(name);
        initialedServices.clear();
        if (!registeredSettingFetcher) {
            final TMSettingFetcher tMSettingFetcher = new TMSettingFetcher(new Function0<Unit>() { // from class: com.bytedance.timonkit.Timon$init$fetcher$1
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1093invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1093invoke() {
                    Timon.INSTANCE.flushSettings();
                }
            });
            TMConfigService.INSTANCE.setConfigFetcher(tMSettingFetcher);
            TMEnv.INSTANCE.setSettingFetcherSource("timon");
            TMThreadUtils.INSTANCE.async(new Function0<Unit>() { // from class: com.bytedance.timonkit.Timon$init$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m1090invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1090invoke() {
                    if (ProcessUtil.INSTANCE.isMainProcess(context)) {
                        tMSettingFetcher.invoke("", true);
                    }
                }
            });
        }
        if (!TMThreadUtils.INSTANCE.initialed()) {
            TMThreadUtils.INSTANCE.setIoExecutor(TMThreadUtils.INSTANCE.createDefaultIOExecutor());
        }
        innerInjectEventMonitor(context, channel, (String) deviceIdGetter.invoke(), appId);
        ScenesDetector.INSTANCE.start(context);
        final Function2<List<? extends ITMLifecycleService>, EnumUtils.WorkType, Unit> function2 = new Function2<List<? extends ITMLifecycleService>, EnumUtils.WorkType, Unit>() { // from class: com.bytedance.timonkit.Timon$init$startService$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((List<? extends ITMLifecycleService>) obj, (EnumUtils.WorkType) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(List<? extends ITMLifecycleService> list, EnumUtils.WorkType workType) {
                CopyOnWriteArrayList copyOnWriteArrayList;
                Intrinsics.checkParameterIsNotNull(list, "services");
                Intrinsics.checkParameterIsNotNull(workType, "workType");
                TMMetric.TimingCounter timingCounter2 = new TMMetric.TimingCounter(null, 0L, null, 7, null);
                for (ITMLifecycleService iTMLifecycleService : CollectionsKt.sortedWith(list, new Comparator<T>() { // from class: com.bytedance.timonkit.Timon$init$startService$1$$special$$inlined$sortedByDescending$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(((ITMLifecycleService) t2).priority().getValue()), Integer.valueOf(((ITMLifecycleService) t).priority().getValue()));
                    }
                })) {
                    TMLogger.INSTANCE.m219d("Timon", iTMLifecycleService.getClass() + " init called");
                    timingCounter2.startSub(iTMLifecycleService.configKey());
                    iTMLifecycleService.init(appId, channel, deviceIdGetter, context, extra);
                    Timon timon = Timon.INSTANCE;
                    copyOnWriteArrayList = Timon.initialedServices;
                    copyOnWriteArrayList.add(iTMLifecycleService);
                    timingCounter2.endSub();
                }
                TMMetric.INSTANCE.reportServiceInit(timingCounter2, workType);
            }
        };
        Set services = ServiceManager.get().getServices(ITMLifecycleService.class);
        Intrinsics.checkExpressionValueIsNotNull(services, "ServiceManager.get().get…cycleService::class.java)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : services) {
            if (((ITMLifecycleService) obj).enable()) {
                arrayList.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList) {
            EnumUtils.WorkType defaultWorkType = ((ITMLifecycleService) obj2).defaultWorkType();
            Object obj3 = linkedHashMap.get(defaultWorkType);
            if (obj3 == null) {
                obj3 = new ArrayList();
                linkedHashMap.put(defaultWorkType, obj3);
            }
            ((List) obj3).add(obj2);
        }
        for (final Map.Entry entry : linkedHashMap.entrySet()) {
            int i = WhenMappings.$EnumSwitchMapping$0[((EnumUtils.WorkType) entry.getKey()).ordinal()];
            if (i == 1) {
                function2.invoke(entry.getValue(), EnumUtils.WorkType.MAIN);
            } else if (i == 2) {
                TMThreadUtils.INSTANCE.async(new Function0<Unit>() { // from class: com.bytedance.timonkit.Timon$init$$inlined$forEach$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1087invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1087invoke() {
                        function2.invoke(entry.getValue(), EnumUtils.WorkType.BACKGROUND);
                    }
                });
            }
        }
        TMThreadUtils.INSTANCE.async(new Function0<Unit>() { // from class: com.bytedance.timonkit.Timon$init$5
            public /* bridge */ /* synthetic */ Object invoke() {
                m1091invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1091invoke() {
                TMTimer tMTimer;
                if (!TMEnv.INSTANCE.getEnableDelayInit()) {
                    TMCacheTaskManager.INSTANCE.flushApiCallCache();
                }
                Timon timon = Timon.INSTANCE;
                Timon.minutesTimer = new TMTimer(60000L, new Function0<Unit>() { // from class: com.bytedance.timonkit.Timon$init$5.1
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1092invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1092invoke() {
                        TMReportCache.INSTANCE.triggerReport();
                    }
                });
                Timon timon2 = Timon.INSTANCE;
                tMTimer = Timon.minutesTimer;
                if (tMTimer != null) {
                    tMTimer.start();
                }
            }
        });
        TMMetric.INSTANCE.reportInit(timingCounter, TMThreadUtils.INSTANCE.isMainThread());
        TMMetric.INSTANCE.checkReportTimonDyeMark();
    }

    private final void innerInjectEventMonitor(Application context, String channel, String deviceId, int hostAId) {
        TimonFoundation.INSTANCE.setEventMonitor(new EventMonitorImp(context, channel, deviceId, hostAId, TimonConstantKt.TIMON_APP_ID, "4.0.0", TMEnv.INSTANCE.getVersionName(), TMEnv.INSTANCE.getUpdateVersionCode()));
    }

    public final void delayAsyncInit() {
        TMThreadUtils.INSTANCE.async(new Function0<Unit>() { // from class: com.bytedance.timonkit.Timon$delayAsyncInit$1
            public /* bridge */ /* synthetic */ Object invoke() {
                m1088invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1088invoke() {
                Set services = ServiceManager.get().getServices(ITMLifecycleService.class);
                Intrinsics.checkExpressionValueIsNotNull(services, "ServiceManager.get().get…cycleService::class.java)");
                ArrayList arrayList = new ArrayList();
                for (Object obj : services) {
                    if (((ITMLifecycleService) obj).enable()) {
                        arrayList.add(obj);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ITMLifecycleService) it.next()).delayAsyncInit();
                }
            }
        });
    }

    public final void toggleDelayInit(boolean enable) {
        TMEnv.INSTANCE.setEnableDelayInit(enable);
    }

    public final void toggleProcessLifecycle(boolean enable) {
        if (TMEnv.INSTANCE.getInitialed()) {
            TMLogger.INSTANCE.m221e(TAG, "toggleProcessLifecycle too late, timon has initialed");
        }
        TMEnv.INSTANCE.setEnableProcessLifecycle(enable);
    }

    public final void toggleTimonToken(boolean enable) {
        if (TMEnv.INSTANCE.getInitialed()) {
            TMLogger.INSTANCE.m221e(TAG, "toggleTimonToken too late, timon has initialed");
        }
        TMEnv.INSTANCE.setEnableTimonToken(enable);
    }

    public static /* synthetic */ void setTimonInitOptEnable$default(Timon timon, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        timon.setTimonInitOptEnable(z);
    }

    public final void setTimonInitOptEnable(boolean enable) {
        TMEnv.INSTANCE.setInitOpt(enable);
    }

    public final void registerAgreedPrivacyReferee(Function0<Boolean> agreedPrivacyReferee) {
        Intrinsics.checkParameterIsNotNull(agreedPrivacyReferee, "agreedPrivacyReferee");
        if (TMEnv.INSTANCE.getInitialed()) {
            TMLogger.INSTANCE.m221e(TAG, "registerAgreedPrivacyReferee too late, timon has initialed");
        } else {
            ScenesDetector.INSTANCE.setAgreedPrivacyReferee(agreedPrivacyReferee);
        }
    }

    public final void registerApplicationContext(Application application) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        TMEnv.INSTANCE.setApplication(application);
    }

    public final void registerBasicModeReferee(Function0<Boolean> basicModeReferee) {
        Intrinsics.checkParameterIsNotNull(basicModeReferee, "basicModeReferee");
        if (TMEnv.INSTANCE.getInitialed()) {
            TMLogger.INSTANCE.m221e(TAG, "registerBasicModeReferee too late, timon has initialed");
        } else {
            ScenesDetector.INSTANCE.setBasicModeReferee(basicModeReferee);
        }
    }

    public final void registerTeenModeReferee(Function0<Boolean> teenModeReferee) {
        Intrinsics.checkParameterIsNotNull(teenModeReferee, "teenModeReferee");
        if (TMEnv.INSTANCE.getInitialed()) {
            TMLogger.INSTANCE.m221e(TAG, "registerTeenModeReferee too late, timon has initialed");
        } else {
            ScenesDetector.INSTANCE.setTeenModeReferee(teenModeReferee);
        }
    }

    public final void registerAppBackgroundReferee(TimonBackgroundReferee backgroundReferee) {
        Intrinsics.checkParameterIsNotNull(backgroundReferee, "backgroundReferee");
        if (TMEnv.INSTANCE.getInitialed()) {
            TMLogger.INSTANCE.m221e(TAG, "registerAppBackgroundReferee too late, timon has initialed");
        } else {
            ScenesDetector.INSTANCE.setAppBackgroundReferee(backgroundReferee);
        }
    }

    public final void registerElderModeReferee(Function0<Boolean> elderModeReferee) {
        Intrinsics.checkParameterIsNotNull(elderModeReferee, "elderModeReferee");
        if (TMEnv.INSTANCE.getInitialed()) {
            TMLogger.INSTANCE.m221e(TAG, "registerOldModeReferee too late, timon has initialed");
        } else {
            ScenesDetector.INSTANCE.setOldModeReferee(elderModeReferee);
        }
    }

    public final void notifyAgreedPrivacyModChanged(boolean agreedPrivacyMode) {
        ScenesDetector.INSTANCE.notifyAgreedPrivacyModChanged(agreedPrivacyMode);
    }

    public final void notifyTeenModeChanged(boolean teenMode) {
        ScenesDetector.INSTANCE.notifyTeenModeChanged(teenMode);
    }

    public final void notifyBasicModeChanged(boolean basicMode) {
        ScenesDetector.INSTANCE.notifyBasicModeChanged(basicMode);
    }

    public final void notifyElderModeChanged(boolean elderMode) {
        ScenesDetector.INSTANCE.notifyElderModeChanged(elderMode);
    }

    public final boolean isAppBackground() {
        if (TMEnv.INSTANCE.getInitialed()) {
            return ScenesDetector.INSTANCE.isAppBackground();
        }
        return false;
    }

    @Deprecated(message = "will remove in Timon 4.0, please use TMSettingFetcher")
    public final void registerSettingsFetcher(Function1<? super String, JsonObject> fetter) {
        Intrinsics.checkParameterIsNotNull(fetter, "fetter");
        if (TMEnv.INSTANCE.getInitialed()) {
            TMLogger.INSTANCE.m221e(TAG, "registerSettingsFetcher too late, timon has initialed");
            return;
        }
        TMEnv.INSTANCE.setSettingFetcherSource("settings");
        TMConfigService.INSTANCE.setConfigFetcher(fetter);
        registeredSettingFetcher = true;
    }

    public final void registerSubSettingFetcher(String subKey, Function0<JsonObject> fetcher) {
        Intrinsics.checkParameterIsNotNull(subKey, "subKey");
        Intrinsics.checkParameterIsNotNull(fetcher, "fetcher");
        if (TMEnv.INSTANCE.getInitialed()) {
            TMLogger.INSTANCE.m221e(TAG, "registerSubSettingsFetcher too late, timon has initialed");
        } else {
            TMConfigService.INSTANCE.setSubConfigFetcher(subKey, fetcher);
        }
    }

    @Deprecated(message = "replaced by Timon.setDefaultConfig")
    public final void enableLocalSetting(boolean enable) {
        if (TMEnv.INSTANCE.getInitialed()) {
            TMLogger.INSTANCE.m221e(TAG, "enableLocalSetting too late, timon has initialed");
        } else {
            TMConfigService.INSTANCE.setEnableLocalSettingFallback(enable);
        }
    }

    public final void enablePipeline(boolean enable) {
        if (TMEnv.INSTANCE.getInitialed()) {
            TMLogger.INSTANCE.m221e(TAG, "enabelPipeline too late, place call it before Timon.init");
        } else {
            TMEnv.INSTANCE.setEnablePipeline(enable);
        }
    }

    public final void enableClipboardCompliance(boolean enable) {
        if (TMEnv.INSTANCE.getInitialed()) {
            TMLogger.INSTANCE.m221e(TAG, "enableClipboardCompliance too late, place call it before Timon.init");
        } else {
            TMEnv.INSTANCE.setEnableClipboardCompliance(enable);
        }
    }

    public final void enableRulerParamGetEarlierCompliance(boolean enable) {
        if (TMEnv.INSTANCE.getInitialed()) {
            TMLogger.INSTANCE.m221e(TAG, "enableClipboardCompliance too late, place call it before Timon.init");
        } else {
            TMEnv.INSTANCE.setEnableRulerParamGetEarlier(enable);
        }
    }

    public final void setDefaultConfig(JsonObject config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        if (TMEnv.INSTANCE.getInitialed()) {
            TMLogger.INSTANCE.m221e(TAG, "enableLocalSetting too late, timon has initialed");
        } else {
            TMConfigService.INSTANCE.setDefaultConfig(config);
        }
    }

    public final void setConfigValidMark(String mark) {
        Intrinsics.checkParameterIsNotNull(mark, "mark");
        TMCacheService.INSTANCE.setValidMark(mark);
    }

    public final void setEnableRuler(boolean enable) {
        TMEnv.INSTANCE.setEnableRulerService(enable);
    }

    public final void setEnableHelios(boolean enable) {
        TMEnv.INSTANCE.setEnableHeliosService(enable);
    }

    public final void setEnableBpea(boolean enable) {
        TMEnv.INSTANCE.setEnableBpeaService(enable);
    }

    public final void setEnableAntiSurvival(boolean enable) {
        TMEnv.INSTANCE.setEnableAntiSurvivalService(enable);
    }

    public final void setEnableRunningProcessDowngrade(boolean enable) {
        TMEnv.INSTANCE.setEnableRunningProcessDowngrade(enable);
    }

    public final void setEnableReadPhoneStateDowngrade(boolean enable) {
        TMEnv.INSTANCE.setEnableReadPhoneStateDowngrade(enable);
    }

    public final void setClipboardSuiteUseRule(boolean enable) {
        TMEnv.INSTANCE.setEnableClipboardSuiteUseRule(enable);
    }

    public final void setEnableClipboardPermissionDetect(boolean enable) {
        TMEnv.INSTANCE.setEnableClipboardPermissionDetect(enable);
    }

    public final void appendCommonParams(Map<String, String> params) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        TMDataCollector.INSTANCE.setCustomParams(params);
    }

    public final void injectLogger(ILogger logger) {
        Intrinsics.checkParameterIsNotNull(logger, "logger");
        if (TMEnv.INSTANCE.getInitialed()) {
            TMLogger.INSTANCE.m221e(TAG, "injectEventMonitor too late, timon has initialed");
        } else {
            TimonFoundation.INSTANCE.setLogger(logger);
        }
    }

    public final void injectKvStore(IStore store) {
        Intrinsics.checkParameterIsNotNull(store, "store");
        if (TMEnv.INSTANCE.getInitialed()) {
            TMLogger.INSTANCE.m221e(TAG, "injectKvStore too late, timon has initialed");
        } else {
            TimonFoundation.INSTANCE.setKvStore(store);
        }
    }

    public final void injectIOExecutor(ExecutorService executor) {
        Intrinsics.checkParameterIsNotNull(executor, "executor");
        TMThreadUtils.INSTANCE.setIoExecutor(executor);
    }

    public final void injectEventMonitor(IEventMonitor eventMonitor) {
        Intrinsics.checkParameterIsNotNull(eventMonitor, "eventMonitor");
        if (TMEnv.INSTANCE.getInitialed()) {
            TMLogger.INSTANCE.m221e(TAG, "injectEventMonitor too late, timon has initialed");
        } else {
            TimonFoundation.INSTANCE.setEventMonitor(eventMonitor);
        }
    }

    public final void injectExceptionMonitor(IExceptionMonitor exceptionMonitor) {
        Intrinsics.checkParameterIsNotNull(exceptionMonitor, "exceptionMonitor");
        if (TMEnv.INSTANCE.getInitialed()) {
            TMLogger.INSTANCE.m221e(TAG, "injectExceptionMonitor too late, timon has initialed");
        } else {
            TimonFoundation.INSTANCE.setExceptionMonitor(exceptionMonitor);
        }
    }

    public final void injectAppLog(IAppLog appLog) {
        Intrinsics.checkParameterIsNotNull(appLog, "appLog");
        if (TMEnv.INSTANCE.getInitialed()) {
            TMLogger.INSTANCE.m221e(TAG, "injectAppLog too late, timon has initialed");
        } else {
            TimonFoundation.INSTANCE.setAppLog(appLog);
        }
    }

    public final <T extends ITMBusinessService> T getTimonBusiness(Class<T> business) {
        Intrinsics.checkParameterIsNotNull(business, "business");
        Object service = ServiceManager.get().getService(business);
        Intrinsics.checkExpressionValueIsNotNull(service, "ServiceManager.get().getService(business)");
        return (T) service;
    }

    public final void flushSettings() {
        TMConfigService.INSTANCE.flushSettings();
        if (TMEnv.INSTANCE.isInitOpt()) {
            TMThreadUtils.INSTANCE.async(new Function0<Unit>() { // from class: com.bytedance.timonkit.Timon$flushSettings$1
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1089invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1089invoke() {
                    CopyOnWriteArrayList copyOnWriteArrayList;
                    TMInitConfigService.INSTANCE.updateInitConfig();
                    Timon timon = Timon.INSTANCE;
                    copyOnWriteArrayList = Timon.initialedServices;
                    ArrayList<ITMLifecycleService> arrayList = new ArrayList();
                    for (Object obj : copyOnWriteArrayList) {
                        if (((ITMLifecycleService) obj).enable()) {
                            arrayList.add(obj);
                        }
                    }
                    for (ITMLifecycleService iTMLifecycleService : arrayList) {
                        TMLogger.INSTANCE.m219d("Timon", iTMLifecycleService.getClass().getSimpleName() + " invoke update config");
                        iTMLifecycleService.onConfigUpdate();
                    }
                }
            });
            return;
        }
        CopyOnWriteArrayList<ITMLifecycleService> copyOnWriteArrayList = initialedServices;
        ArrayList<ITMLifecycleService> arrayList = new ArrayList();
        for (Object obj : copyOnWriteArrayList) {
            if (((ITMLifecycleService) obj).enable()) {
                arrayList.add(obj);
            }
        }
        for (ITMLifecycleService iTMLifecycleService : arrayList) {
            TMLogger.INSTANCE.m219d(TAG, iTMLifecycleService.getClass().getSimpleName() + " invoke update config");
            iTMLifecycleService.onConfigUpdate();
        }
    }

    public static /* synthetic */ void setDebugModel$default(Timon timon, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        timon.setDebugModel(z);
    }

    public final void setDebugModel(boolean debug) {
        manuallySetDebuggable = true;
        TMLogger.INSTANCE.setDebug(debug);
        TMEnv.INSTANCE.setDEBUG(debug);
    }

    public final int getSilenceStage() {
        return ScenesDetector.INSTANCE.getSilentStage();
    }
}

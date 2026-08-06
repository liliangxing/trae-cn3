package com.bytedance.trae.apm.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Pair;
import com.bytedance.apm.Apm;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.config.ActivityLeakDetectConfig;
import com.bytedance.apm.config.ApmInitConfig;
import com.bytedance.apm.config.ApmStartConfig;
import com.bytedance.apm.core.IDynamicParams;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.pipeline.NetDataPipeline;
import com.bytedance.apm.launch.LaunchInitConfig;
import com.bytedance.apm.perf.memory.IActivityLeakListener;
import com.bytedance.apm.util.AppUtils;
import com.bytedance.apm.util.SlardarProperties;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.memory.MemoryWidget;
import com.bytedance.memory.model.MemoryWidgetConfig;
import com.bytedance.memory.watcher.OnGetMemoryResultListener;
import com.bytedance.monitor.collector.Util;
import com.bytedance.services.apm.api.IRequestTagHeaderProvider;
import com.bytedance.trae.apm.api.IApm;
import com.bytedance.trae.apm.api.IExtraParams;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.applog.api.OnGetAppLogIdListener;
import com.bytedance.trae.common.apphost.AppHost;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.CloudMessageWidget;
import com.monitor.cloudmessage.callback.IAlogConsumer;
import com.monitor.cloudmessage.entity.ConsumerResult;
import com.ss.android.agilelogger.ALog;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ApmImpl.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0007H\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/apm/impl/ApmImpl;", "Lcom/bytedance/trae/apm/api/IApm;", "<init>", "()V", "initLogAndALog", "", "debug", "", "maxALogDirSizeMb", "", "application", "Landroid/app/Application;", "initApm", "configApmOpt", "configBuilder", "Lcom/bytedance/apm/config/ApmInitConfig$Builder;", "configBlockDetect", "configBinderMonitor", "startApm", "did", "", "isMainProcess", "context", "Landroid/content/Context;", "registerDolaCloudControlConsumer", "isMinorMode", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ApmImpl implements IApm {
    private static final String TAG = "ApmImpl";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<Boolean> enableOptApmLooper$delegate = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.apm.impl.ApmImpl$$ExternalSyntheticLambda1
        public final Object invoke() {
            boolean enableOptApmLooper_delegate$lambda$6;
            enableOptApmLooper_delegate$lambda$6 = ApmImpl.enableOptApmLooper_delegate$lambda$6();
            return Boolean.valueOf(enableOptApmLooper_delegate$lambda$6);
        }
    });

    private final void configBinderMonitor(ApmInitConfig.Builder configBuilder) {
    }

    private final void configBlockDetect(ApmInitConfig.Builder configBuilder) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enableOptApmLooper_delegate$lambda$6() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initApm$lambda$3(Activity activity) {
    }

    /* compiled from: ApmImpl.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/apm/impl/ApmImpl$Companion;", "", "<init>", "()V", "enableOptApmLooper", "", "getEnableOptApmLooper", "()Z", "enableOptApmLooper$delegate", "Lkotlin/Lazy;", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getEnableOptApmLooper() {
            return ((Boolean) ApmImpl.enableOptApmLooper$delegate.getValue()).booleanValue();
        }
    }

    @Override // com.bytedance.trae.apm.api.IApm
    public void initLogAndALog(boolean debug, int maxALogDirSizeMb, Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        Logger.INSTANCE.initLogAndALog(debug, maxALogDirSizeMb, application);
    }

    @Override // com.bytedance.trae.apm.api.IApm
    public void initApm() {
        ApmAgent.FAST_MODE = true;
        CommonEventDeliverer.FAST_MODE = true;
        CommonDataPipeline.getInstance().fastMode = true;
        NetDataPipeline.getInstance().fastMode = true;
        ApmInitConfig.Builder fullFpsTracer = ApmInitConfig.builder().launchInitConfig(new LaunchInitConfig.Builder().collectPerfData().collectNetData().collectTimingTrace().collectDeviceInfo().collectSlowLaunchTrace().setSlowLaunchThreshold(3000L).build()).viewIdMonitorPageSwitch(true).fullFpsTracer(true);
        Intrinsics.checkNotNull(fullFpsTracer);
        configBlockDetect(fullFpsTracer);
        ApmInitConfig.Builder enableActivityFps = fullFpsTracer.maxValidPageLoadTimeMs(20000000L).enableActivityFps(false);
        Intrinsics.checkNotNull(enableActivityFps);
        configBinderMonitor(enableActivityFps);
        ApmInitConfig.Builder supportMultiFrameRate = enableActivityFps.debugMode(AppHost.INSTANCE.isDebug()).enableDeviceInfoOnPerfData(true).supportMultiFrameRate(false);
        Intrinsics.checkNotNull(supportMultiFrameRate);
        configApmOpt(supportMultiFrameRate);
        Apm.getInstance().init(AppHost.INSTANCE.getApplication(), supportMultiFrameRate.detectActivityLeak(ActivityLeakDetectConfig.builder().gcDetectActivityLeak(false).reportActivityLeakEvent(true).waitDetectActivityTimeMs(60000L).unbindActivityLeakSwitch(true).activityLeakListener(new IActivityLeakListener() { // from class: com.bytedance.trae.apm.impl.ApmImpl$$ExternalSyntheticLambda0
            public final void onActivityLeaked(Activity activity) {
                ApmImpl.initApm$lambda$3(activity);
            }
        }).build()).build());
        String deviceId = IApplog.INSTANCE.getDeviceId();
        if (deviceId.length() > 0) {
            startApm(deviceId);
        } else {
            IApplog.INSTANCE.addGetAppLogIdListener(new OnGetAppLogIdListener() { // from class: com.bytedance.trae.apm.impl.ApmImpl$initApm$1
                @Override // com.bytedance.trae.applog.api.OnGetAppLogIdListener
                public void onGetId(String did, String iid, String ssid) {
                    Intrinsics.checkNotNullParameter(did, "did");
                    Intrinsics.checkNotNullParameter(iid, "iid");
                    Intrinsics.checkNotNullParameter(ssid, "ssid");
                    ApmImpl.this.startApm(did);
                }
            });
        }
    }

    private final void configApmOpt(ApmInitConfig.Builder configBuilder) {
        if (INSTANCE.getEnableOptApmLooper()) {
            Util.enableLooperObserver = true;
            configBuilder.enableLooperOpt(true).enableLooperDeepOpt(true);
        }
        configBuilder.enableCpuAllocOpt(true);
    }

    static /* synthetic */ void startApm$default(ApmImpl apmImpl, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        apmImpl.startApm(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startApm(String did) {
        ApmStartConfig.Builder dynamicParams = ApmStartConfig.builder().aid(AppHost.INSTANCE.getAppId()).channel(AppHost.INSTANCE.getBuildChannel()).appVersion(AppHost.INSTANCE.getVersionName()).updateVersionCode(String.valueOf(AppHost.INSTANCE.getUpdateVersionCode())).deviceId(did).useDefaultTTNetImpl(true).releaseBuild(SlardarProperties.getReleaseBuild()).widget(new MemoryWidget(MemoryWidgetConfig.newBuilder().build(), (OnGetMemoryResultListener) null)).blockDetect(true).seriousBlockDetect(true).widget(new CloudMessageWidget()).blockDetectOnlySampled(true).batteryDetect(true).requestTagHeaderProvider(new IRequestTagHeaderProvider() { // from class: com.bytedance.trae.apm.impl.ApmImpl$startApm$configBuilder$1
            @Override // com.bytedance.services.apm.api.IRequestTagHeaderProvider
            public Map<String, String> getRequestTagHeader() {
                Pair buildBDNetworkTag = BDNetworkTagManager.getInstance().buildBDNetworkTag(new BDNetworkTagContextProviderAdapter() { // from class: com.bytedance.trae.apm.impl.ApmImpl$startApm$configBuilder$1$getRequestTagHeader$tag$1
                    public int triggerType() {
                        return 0;
                    }
                });
                return MapsKt.mutableMapOf(new kotlin.Pair[]{TuplesKt.to(buildBDNetworkTag.first, buildBDNetworkTag.second)});
            }
        }).dynamicParams(new IDynamicParams() { // from class: com.bytedance.trae.apm.impl.ApmImpl$startApm$configBuilder$2
            public Map<String, String> getCommonParams() {
                return new HashMap(IExtraParams.INSTANCE.getDynamicParams());
            }

            public String getSessionId() {
                return IApplog.INSTANCE.getSessionId();
            }

            public long getUid() {
                Object obj;
                try {
                    Result.Companion companion = Result.Companion;
                    ApmImpl$startApm$configBuilder$2 apmImpl$startApm$configBuilder$2 = this;
                    obj = Result.constructor-impl(Long.valueOf(Long.parseLong(IApplog.INSTANCE.getUserID())));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.isFailure-impl(obj)) {
                    obj = 0L;
                }
                return ((Number) obj).longValue();
            }
        });
        for (Map.Entry<String, String> entry : IExtraParams.INSTANCE.getStaticParams().entrySet()) {
            dynamicParams.param(entry.getKey(), entry.getValue());
        }
        String str = IExtraParams.INSTANCE.getDynamicParams().get("scope");
        if (str != null) {
            dynamicParams.param("scope", str);
        }
        Apm.getInstance().start(dynamicParams.build());
    }

    @Override // com.bytedance.trae.apm.api.IApm
    public boolean isMainProcess(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return AppUtils.isMainProcess(context);
    }

    @Override // com.bytedance.trae.apm.api.IApm
    public void registerDolaCloudControlConsumer(final boolean isMinorMode) {
        CloudMessageManager.setAlogConsumerSafely(new IAlogConsumer() { // from class: com.bytedance.trae.apm.impl.ApmImpl$registerDolaCloudControlConsumer$1
            private List<String> alogList = CollectionsKt.emptyList();

            public List<String> handleAlogData(long startTime, long endTime, JSONObject params) {
                Intrinsics.checkNotNullParameter(params, "params");
                if (isMinorMode) {
                    return this.alogList;
                }
                if (startTime < endTime) {
                    ALog.asyncFlush();
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    List<String> aLogFiles = ALog.getALogFiles(startTime, endTime);
                    Intrinsics.checkNotNullExpressionValue(aLogFiles, "getALogFiles(...)");
                    this.alogList = aLogFiles;
                }
                return this.alogList;
            }

            public ConsumerResult getConsumerResult() {
                boolean z = !this.alogList.isEmpty();
                ConsumerResult build = ConsumerResult.build(z, z ? "" : isMinorMode ? "Cloud Command blocked: Forbidden in Minor Mode" : "alog file not get", z ? null : ALog.getLastFetchErrorInfo());
                Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                return build;
            }
        });
    }
}

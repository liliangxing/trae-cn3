package com.bytedance.ies.bullet.service.monitor;

import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import android.view.View;
import bolts.Task;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.android.anniex.scene.core.SceneManager;
import com.bytedance.android.monitorV2.entity.UnifyErrorDomain;
import com.bytedance.android.monitorV2.exception.HybridCrashHelper;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerStage;
import com.bytedance.ies.bullet.core.BulletContainerContext;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletMonitorContext;
import com.bytedance.ies.bullet.core.IBulletLifeCycleV2;
import com.bytedance.ies.bullet.core.IBulletPerfClient;
import com.bytedance.ies.bullet.core.LoadStage;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.core.kit.Fallback;
import com.bytedance.ies.bullet.core.monitor.BulletTracert;
import com.bytedance.ies.bullet.forest.ForestInfoHelper;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.MonitorConfig;
import com.bytedance.ies.bullet.service.base.api.BidConstants;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate;
import com.bytedance.ies.bullet.service.base.lynx.ILynxKitService;
import com.bytedance.ies.bullet.service.base.lynx.ILynxKitViewService;
import com.bytedance.ies.bullet.service.base.lynx.LynxError;
import com.bytedance.ies.bullet.service.base.settings.CommonConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.settings.MonitorSettingsConfig;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.ies.bullet.service.base.utils.BulletLoadUriIdentifier;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.context.ContextProviderManager;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.ies.bullet.service.monitor.deviceperf.CpuMemoryHelper;
import com.bytedance.ies.bullet.service.monitor.deviceperf.CpuMemoryPerfMetric;
import com.bytedance.ies.bullet.service.monitor.deviceperf.CpuMemoryReporter;
import com.bytedance.ies.bullet.service.monitor.deviceperf.ScrollInfo;
import com.bytedance.ies.bullet.service.monitor.fluency.FluencyHelper;
import com.bytedance.ies.bullet.service.monitor.fluency.FluencyMonitor;
import com.bytedance.ies.bullet.service.monitor.reliability.NpthHelper;
import com.bytedance.ies.bullet.service.monitor.reliability.ReliabilityReporter;
import com.bytedance.ies.bullet.service.monitor.standard.ContainerStandardMonitor;
import com.bytedance.ies.bullet.service.monitor.timeline.DurationMap;
import com.bytedance.ies.bullet.service.monitor.timeline.SecurityTimeStampMap;
import com.bytedance.ies.bullet.service.monitor.timeline.TimeStampMap;
import com.bytedance.ies.bullet.service.monitor.timeline.TimelineHelper;
import com.bytedance.ies.bullet.service.monitor.timeline.TimelineReporter;
import com.bytedance.ies.bullet.service.monitor.utils.JsonUtilsKt;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.push.interfaze.ISignalReportService;
import com.bytedance.salamander.anniex.AccessLayerStringField;
import com.bytedance.salamander.anniex.SLAnnieXMonitor;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: DefaultBulletMonitorCallback.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 b2\u00020\u00012\u00020\u0002:\u0001bB\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001eH\u0016J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020$H\u0016J)\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020(H\u0016J\u0010\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\fH\u0016J\b\u00102\u001a\u00020&H\u0016J\u0017\u00103\u001a\u00020&2\b\u00104\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u00105J\b\u00106\u001a\u00020&H\u0016J$\u00107\u001a\u00020&2\u0006\u00108\u001a\u00020\u001f2\b\u00109\u001a\u0004\u0018\u00010$2\b\u0010:\u001a\u0004\u0018\u00010$H\u0016J\b\u0010;\u001a\u00020&H\u0016J\b\u0010<\u001a\u00020&H\u0016J\b\u0010=\u001a\u00020&H\u0016J\b\u0010>\u001a\u00020&H\u0016J\u0018\u0010?\u001a\u00020&2\u0006\u0010@\u001a\u00020 2\u0006\u0010A\u001a\u00020\u0014H\u0016J \u0010B\u001a\u00020&2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u001f2\u0006\u0010F\u001a\u00020\u0014H\u0016J\b\u0010G\u001a\u00020&H\u0016J\b\u0010H\u001a\u00020&H\u0016J\b\u0010I\u001a\u00020&H\u0016J\b\u0010J\u001a\u00020&H\u0016J\b\u0010K\u001a\u00020&H\u0016J\b\u0010L\u001a\u00020&H\u0016J\u0010\u0010M\u001a\u00020&2\u0006\u00101\u001a\u00020\fH\u0016J\b\u0010N\u001a\u00020&H\u0016J\b\u0010O\u001a\u00020&H\u0002J\u0012\u0010P\u001a\u00020&2\b\u0010Q\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u0010R\u001a\u00020&2\b\u0010S\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010T\u001a\u00020&H\u0002J\b\u0010U\u001a\u00020&H\u0016J\b\u0010V\u001a\u00020&H\u0016J\b\u0010W\u001a\u00020&H\u0016J\u001e\u0010X\u001a\u00020&2\u0006\u0010\"\u001a\u00020\u001f2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020&0ZH\u0016J\b\u0010[\u001a\u00020&H\u0002J\u0010\u0010\\\u001a\u00020&2\u0006\u0010]\u001a\u00020\u001fH\u0016J\u0010\u0010^\u001a\u00020&2\u0006\u0010\"\u001a\u00020\u001fH\u0016J\b\u0010_\u001a\u00020&H\u0016J\b\u0010`\u001a\u00020&H\u0016J\b\u0010a\u001a\u00020&H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/DefaultBulletMonitorCallback;", "Lcom/bytedance/ies/bullet/service/monitor/AbsBulletMonitorCallback;", "Lcom/bytedance/ies/bullet/forest/ForestInfoHelper;", "()V", "bulletCallback", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycleV2$Base;", "getBulletCallback", "()Lcom/bytedance/ies/bullet/core/IBulletLifeCycleV2$Base;", "callbackCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "containerRef", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/ies/bullet/core/container/IBulletContainer;", "cpuMemoryReporter", "Lcom/bytedance/ies/bullet/service/monitor/deviceperf/CpuMemoryReporter;", "durationMap", "Lcom/bytedance/ies/bullet/service/monitor/timeline/DurationMap;", "fluencyMonitor", "Lcom/bytedance/ies/bullet/service/monitor/fluency/FluencyMonitor;", "loadNotReport", "", "lynxDurationMap", "lynxTimeStampMap", "Lcom/bytedance/ies/bullet/service/monitor/timeline/TimeStampMap;", "securityTimeStampMap", "Lcom/bytedance/ies/bullet/service/monitor/timeline/SecurityTimeStampMap;", "timeStampMap", "updateLynxDurationMap", "updateLynxTimeStampMap", "generatePerfMapForGlobalProps", "", "", "", "getPerfMetric", "key", "getPerfMetrics", "Lorg/json/JSONObject;", "onBlankDetected", "", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "isBlank", "", "percent", "", "(Lcom/bytedance/ies/bullet/core/BulletContext;Ljava/lang/Integer;Ljava/lang/Float;)V", "onBulletContextCreated", "context", "onBulletViewAttached", "monitorContainer", "onBulletViewDetached", "onContainerCreated", "containerCreateTime", "(Ljava/lang/Long;)V", "onContainerLoaderStart", "onCpuMemoryInject", SchemaConstants.INNER_PARAM_EVENT_NAME, "category", LynxMonitorService.KEY_METRICS, "onCpuMemoryReport", "onJsbRegisterBegin", "onJsbRegisterEnd", "onKitViewCreateBegin", "onLoadEntryBullet", "containerStartTime", "isRouter", "onLoadError", "errStage", "Lcom/bytedance/ies/bullet/service/monitor/AbsBulletMonitorCallback$ErrStage;", "errMessage", "hasErrorView", "onLynxReadTemplateBegin", "onLynxReadTemplateEnd", "onLynxRenderTemplateBegin", "onLynxRenderTemplateEnd", "onPrepareTemplateBegin", "onPrepareTemplateEnd", "onReload", "onSchemaPrepared", "onSetup", "onUpdate", "flag", "onViewAttached", "url", "onViewDisappear", "onWebLoadUrl", "onWebPageFinished", "onWebPageStarted", "recordDuration", "block", "Lkotlin/Function0;", "recordSecBeforeOnPageStarted", "recordSecurityEventTime", ISignalReportService.BODY_KEY_EVENT, "recordTimeStamp", "reportErrorViewClick", "reportErrorViewShow", "triggerBlankDetect", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DefaultBulletMonitorCallback extends AbsBulletMonitorCallback implements ForestInfoHelper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static ILynxKitService lynxKitService = null;
    private static final String moduleName = "Monitor-Callback";
    private WeakReference<IBulletContainer> containerRef;
    private boolean loadNotReport;
    private final TimeStampMap timeStampMap = new TimeStampMap();
    private final DurationMap durationMap = new DurationMap();
    private final TimeStampMap lynxTimeStampMap = new TimeStampMap();
    private final DurationMap lynxDurationMap = new DurationMap();
    private final TimeStampMap updateLynxTimeStampMap = new TimeStampMap();
    private final DurationMap updateLynxDurationMap = new DurationMap();
    private FluencyMonitor fluencyMonitor = new FluencyMonitor();
    private final SecurityTimeStampMap securityTimeStampMap = new SecurityTimeStampMap();
    private final IBulletLifeCycleV2.Base bulletCallback = new IBulletLifeCycleV2.Base() { // from class: com.bytedance.ies.bullet.service.monitor.DefaultBulletMonitorCallback$bulletCallback$1
        private ILynxClientDelegate lynxClient;

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            this.lynxClient = new ILynxClientDelegate.Base() { // from class: com.bytedance.ies.bullet.service.monitor.DefaultBulletMonitorCallback$bulletCallback$1$lynxClient$1
                @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate.Base, com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
                public void onPageStart(IKitViewService viewService, String url) {
                    TimeStampMap timeStampMap;
                    FluencyMonitor fluencyMonitor;
                    FluencyMonitor fluencyMonitor2;
                    HybridLogger.INSTANCE.m11i("Monitor-Callback", LoggerStage.ON_PAGE_START, MapsKt.mapOf(TuplesKt.to("url", url)), DefaultBulletMonitorCallback.this.getBulletContext().getLogContext());
                    timeStampMap = DefaultBulletMonitorCallback.this.timeStampMap;
                    timeStampMap.record(MetricConstant.LYNX_PAGE_START);
                    CpuMemoryHelper.INSTANCE.recordCpuMemory(DefaultBulletMonitorCallback.this.getSessionId(), CpuMemoryPerfMetric.VIEW_PAGESTART);
                    fluencyMonitor = DefaultBulletMonitorCallback.this.fluencyMonitor;
                    if (fluencyMonitor.getEnableFluencyCollection()) {
                        Log.i("FluencyMonitor", "DefaultBulletMonitorCallBack-onPageStart-startMonitor");
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(FluencyHelper.STAGE, FluencyHelper.BEFORE_FMP);
                        fluencyMonitor2 = DefaultBulletMonitorCallback.this.fluencyMonitor;
                        fluencyMonitor2.startFluencyMonitor(jSONObject);
                    }
                }

                @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate.Base, com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
                public void onLoadSuccess(IKitViewService viewService) {
                    TimeStampMap timeStampMap;
                    HybridLogger.INSTANCE.m11i("Monitor-Callback", LoggerStage.ON_LOAD_SUCCESS, null, DefaultBulletMonitorCallback.this.getBulletContext().getLogContext());
                    timeStampMap = DefaultBulletMonitorCallback.this.timeStampMap;
                    timeStampMap.record(MetricConstant.LYNX_LOAD_SUCCESS);
                }

                @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate.Base, com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
                public void onFirstScreen(IKitViewService viewService) {
                    TimeStampMap timeStampMap;
                    DurationMap durationMap;
                    TimeStampMap timeStampMap2;
                    DurationMap durationMap2;
                    TimeStampMap timeStampMap3;
                    AtomicInteger atomicInteger;
                    HybridLogger.INSTANCE.m11i("Monitor-Callback", LoggerStage.ON_FIRST_SCREEN, null, DefaultBulletMonitorCallback.this.getBulletContext().getLogContext());
                    timeStampMap = DefaultBulletMonitorCallback.this.timeStampMap;
                    timeStampMap.record(MetricConstant.LYNX_FIRST_SCREEN);
                    durationMap = DefaultBulletMonitorCallback.this.durationMap;
                    timeStampMap2 = DefaultBulletMonitorCallback.this.timeStampMap;
                    durationMap.record(MetricConstant.LYNX_RENDER, Long.valueOf(timeStampMap2.computeDuration("render_template_start", MetricConstant.LYNX_FIRST_SCREEN)));
                    durationMap2 = DefaultBulletMonitorCallback.this.durationMap;
                    timeStampMap3 = DefaultBulletMonitorCallback.this.timeStampMap;
                    durationMap2.record(MetricConstant.FIRST_SCREEN, Long.valueOf(timeStampMap3.computeDuration(MetricConstant.BULLET_INIT, MetricConstant.LYNX_FIRST_SCREEN)));
                    atomicInteger = DefaultBulletMonitorCallback.this.callbackCount;
                    atomicInteger.addAndGet(2);
                    DefaultBulletMonitorCallback.this.onSetup();
                }

                @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate.Base, com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
                public void onTimingSetup(Map<String, Object> timingInfo) {
                    TimeStampMap timeStampMap;
                    DurationMap durationMap;
                    AtomicInteger atomicInteger;
                    TimeStampMap timeStampMap2;
                    DurationMap durationMap2;
                    HybridLogger.INSTANCE.m11i("Monitor-Callback", LoggerStage.ON_TIMING_SETUP, null, DefaultBulletMonitorCallback.this.getBulletContext().getLogContext());
                    TimelineHelper timelineHelper = TimelineHelper.INSTANCE;
                    timeStampMap = DefaultBulletMonitorCallback.this.lynxTimeStampMap;
                    durationMap = DefaultBulletMonitorCallback.this.lynxDurationMap;
                    timelineHelper.collectSetupLynxTiming(timingInfo, timeStampMap, durationMap);
                    CpuMemoryHelper.INSTANCE.recordCpuMemory(DefaultBulletMonitorCallback.this.getSessionId(), CpuMemoryPerfMetric.LYNXVIEW_FIRSTSCREEN);
                    atomicInteger = DefaultBulletMonitorCallback.this.callbackCount;
                    atomicInteger.addAndGet(1);
                    DefaultBulletMonitorCallback.this.onSetup();
                    BulletMonitorContext monitorContext = DefaultBulletMonitorCallback.this.getBulletContext().getMonitorContext();
                    TimelineHelper timelineHelper2 = TimelineHelper.INSTANCE;
                    timeStampMap2 = DefaultBulletMonitorCallback.this.lynxTimeStampMap;
                    durationMap2 = DefaultBulletMonitorCallback.this.lynxDurationMap;
                    monitorContext.inject(null, timelineHelper2.getTracertMetric(timeStampMap2, durationMap2));
                }

                @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate.Base, com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
                public void onTimingUpdate(Map<String, Object> timingInfo, Map<String, Long> updateTiming, String flag) {
                    TimeStampMap timeStampMap;
                    DurationMap durationMap;
                    TimeStampMap timeStampMap2;
                    DurationMap durationMap2;
                    TimeStampMap timeStampMap3;
                    DurationMap durationMap3;
                    FluencyMonitor fluencyMonitor;
                    AtomicInteger atomicInteger;
                    TimeStampMap timeStampMap4;
                    DurationMap durationMap4;
                    boolean z;
                    boolean z2;
                    FluencyMonitor fluencyMonitor2;
                    HybridLogger.INSTANCE.m11i("Monitor-Callback", LoggerStage.ON_TIMING_UPDATE, null, DefaultBulletMonitorCallback.this.getBulletContext().getLogContext());
                    TimelineHelper timelineHelper = TimelineHelper.INSTANCE;
                    timeStampMap = DefaultBulletMonitorCallback.this.lynxTimeStampMap;
                    durationMap = DefaultBulletMonitorCallback.this.lynxDurationMap;
                    timelineHelper.collectSetupLynxTiming(timingInfo, timeStampMap, durationMap);
                    TimelineHelper timelineHelper2 = TimelineHelper.INSTANCE;
                    timeStampMap2 = DefaultBulletMonitorCallback.this.lynxTimeStampMap;
                    durationMap2 = DefaultBulletMonitorCallback.this.lynxDurationMap;
                    timelineHelper2.collectUpdateLynxTiming(timingInfo, updateTiming, timeStampMap2, durationMap2);
                    TimelineHelper timelineHelper3 = TimelineHelper.INSTANCE;
                    timeStampMap3 = DefaultBulletMonitorCallback.this.updateLynxTimeStampMap;
                    durationMap3 = DefaultBulletMonitorCallback.this.updateLynxDurationMap;
                    timelineHelper3.collectUpdateLynxTimingForIBulletPerf(timingInfo, updateTiming, timeStampMap3, durationMap3);
                    CpuMemoryHelper.INSTANCE.recordCpuMemory(DefaultBulletMonitorCallback.this.getSessionId(), CpuMemoryPerfMetric.LYNXVIEW_FIRSTSCREEN);
                    fluencyMonitor = DefaultBulletMonitorCallback.this.fluencyMonitor;
                    if (fluencyMonitor.getEnableFluencyCollection()) {
                        Log.i("FluencyMonitor", "DefaultBulletMonitorCallBack-onTimingUpdate-stopFluencyMonitor");
                        JSONObject jSONObject = new JSONObject();
                        DefaultBulletMonitorCallback defaultBulletMonitorCallback = DefaultBulletMonitorCallback.this;
                        jSONObject.put(FluencyHelper.STAGE, FluencyHelper.BEFORE_FMP);
                        String optString = defaultBulletMonitorCallback.getBulletContext().getMonitorContext().getCategory().optString(MetricConstant.SDK_TYPE);
                        if (optString != null) {
                            Intrinsics.checkNotNullExpressionValue(optString, "optString(MetricConstant.SDK_TYPE)");
                            jSONObject.put(MetricConstant.SDK_TYPE, optString);
                        }
                        fluencyMonitor2 = DefaultBulletMonitorCallback.this.fluencyMonitor;
                        fluencyMonitor2.stopFluencyMonitor(jSONObject);
                    }
                    atomicInteger = DefaultBulletMonitorCallback.this.callbackCount;
                    atomicInteger.addAndGet(1);
                    DefaultBulletMonitorCallback.this.onUpdate(flag);
                    BulletMonitorContext monitorContext = DefaultBulletMonitorCallback.this.getBulletContext().getMonitorContext();
                    TimelineHelper timelineHelper4 = TimelineHelper.INSTANCE;
                    timeStampMap4 = DefaultBulletMonitorCallback.this.lynxTimeStampMap;
                    durationMap4 = DefaultBulletMonitorCallback.this.lynxDurationMap;
                    monitorContext.inject(null, timelineHelper4.getTracertMetric(timeStampMap4, durationMap4));
                    if (timingInfo != null) {
                        Object obj = timingInfo.get(LynxMonitorService.KEY_UPDATE_TIMING);
                        Map map = obj instanceof Map ? (Map) obj : null;
                        if (map == null) {
                            z = false;
                        } else {
                            if (map == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                            }
                            z = map.containsKey("__lynx_timing_actual_fmp");
                        }
                        if (!z) {
                            timingInfo = null;
                        }
                        if (timingInfo != null) {
                            DefaultBulletMonitorCallback defaultBulletMonitorCallback2 = DefaultBulletMonitorCallback.this;
                            defaultBulletMonitorCallback2.getBulletContext().getContainerContext().setLoadStatus(MetricConstant.MONITOR_STAGE_UPDATE);
                            defaultBulletMonitorCallback2.getBulletContext().getMonitorContext().setLoadStage(LoadStage.UPDATE);
                            defaultBulletMonitorCallback2.getBulletContext().getMonitorContext().setEndToEndStage("data_update");
                            ReliabilityReporter.INSTANCE.traceEndToEnd(defaultBulletMonitorCallback2.getBulletContext());
                            z2 = defaultBulletMonitorCallback2.loadNotReport;
                            if (z2) {
                                ReliabilityReporter.INSTANCE.reportSuccessStage(defaultBulletMonitorCallback2.getBulletContext(), MetricConstant.MONITOR_STAGE_UPDATE);
                            }
                        }
                    }
                }

                @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate.Base, com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
                public void onScrollStart(ScrollInfo info) {
                    FluencyMonitor fluencyMonitor;
                    FluencyMonitor fluencyMonitor2;
                    if (info != null) {
                        DefaultBulletMonitorCallback defaultBulletMonitorCallback = DefaultBulletMonitorCallback.this;
                        Log.i("Monitor-Callback", defaultBulletMonitorCallback.getSessionId() + " onScrollStart");
                        fluencyMonitor = defaultBulletMonitorCallback.fluencyMonitor;
                        if (fluencyMonitor.getEnableFluencyCollection()) {
                            Log.i("FluencyMonitor", "DefaultBulletMonitorCallBack-onScollStart-startFluencyMonitor");
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(FluencyHelper.TAG_NAME, info.getMScrollMonitorTag());
                            jSONObject.put(FluencyHelper.STAGE, FluencyHelper.AFTER_FMP);
                            fluencyMonitor2 = defaultBulletMonitorCallback.fluencyMonitor;
                            fluencyMonitor2.startFluencyMonitor(jSONObject);
                        }
                    }
                }

                @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate.Base, com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
                public void onScrollStop(ScrollInfo info) {
                    FluencyMonitor fluencyMonitor;
                    FluencyMonitor fluencyMonitor2;
                    fluencyMonitor = DefaultBulletMonitorCallback.this.fluencyMonitor;
                    if (!fluencyMonitor.getEnableFluencyCollection() || info == null) {
                        return;
                    }
                    DefaultBulletMonitorCallback defaultBulletMonitorCallback = DefaultBulletMonitorCallback.this;
                    Log.i("Monitor-Callback", defaultBulletMonitorCallback.getSessionId() + " onScrollStop");
                    Log.i("FluencyMonitor", "DefaultBulletMonitorCallBack-onScollStop-stopFluencyMonitor");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(FluencyHelper.TAG_NAME, info.getMScrollMonitorTag());
                    jSONObject.put(FluencyHelper.STAGE, FluencyHelper.AFTER_FMP);
                    String optString = defaultBulletMonitorCallback.getBulletContext().getMonitorContext().getCategory().optString(MetricConstant.SDK_TYPE);
                    if (optString != null) {
                        Intrinsics.checkNotNullExpressionValue(optString, "optString(MetricConstant.SDK_TYPE)");
                        jSONObject.put(MetricConstant.SDK_TYPE, optString);
                    }
                    fluencyMonitor2 = defaultBulletMonitorCallback.fluencyMonitor;
                    fluencyMonitor2.stopFluencyMonitor(jSONObject);
                }

                @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate.Base, com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
                public void onLoadFailed(IKitViewService viewService, String errorMsg) {
                    FluencyMonitor fluencyMonitor;
                    FluencyMonitor fluencyMonitor2;
                    FluencyMonitor fluencyMonitor3;
                    Log.i("Monitor-Callback", DefaultBulletMonitorCallback.this.getSessionId() + " onLoadFailed: " + errorMsg);
                    fluencyMonitor = DefaultBulletMonitorCallback.this.fluencyMonitor;
                    if (fluencyMonitor.getEnableFluencyCollection()) {
                        fluencyMonitor2 = DefaultBulletMonitorCallback.this.fluencyMonitor;
                        if (fluencyMonitor2.getHasStarted()) {
                            Log.i("FluencyMonitor", "DefaultBulletMonitorCallBack-onLoadFailed-stopFluencyMonitor");
                            JSONObject jSONObject = new JSONObject();
                            DefaultBulletMonitorCallback defaultBulletMonitorCallback = DefaultBulletMonitorCallback.this;
                            jSONObject.put(FluencyHelper.STAGE, FluencyHelper.BEFORE_FMP);
                            String optString = defaultBulletMonitorCallback.getBulletContext().getMonitorContext().getCategory().optString(MetricConstant.SDK_TYPE);
                            if (optString != null) {
                                Intrinsics.checkNotNullExpressionValue(optString, "optString(MetricConstant.SDK_TYPE)");
                                jSONObject.put(MetricConstant.SDK_TYPE, optString);
                            }
                            fluencyMonitor3 = DefaultBulletMonitorCallback.this.fluencyMonitor;
                            fluencyMonitor3.stopFluencyMonitor(jSONObject);
                        }
                    }
                }

                @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate.Base, com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
                public void onReceivedError(IKitViewService viewService, LynxError error) {
                    FluencyMonitor fluencyMonitor;
                    FluencyMonitor fluencyMonitor2;
                    FluencyMonitor fluencyMonitor3;
                    HybridLogger.INSTANCE.m9e("Monitor-Callback", LoggerStage.ON_RECEIVED_ERROR, MapsKt.mapOf(TuplesKt.to("message", String.valueOf(error))), DefaultBulletMonitorCallback.this.getBulletContext().getLogContext());
                    fluencyMonitor = DefaultBulletMonitorCallback.this.fluencyMonitor;
                    if (fluencyMonitor.getEnableFluencyCollection()) {
                        fluencyMonitor2 = DefaultBulletMonitorCallback.this.fluencyMonitor;
                        if (fluencyMonitor2.getHasStarted()) {
                            Log.i("FluencyMonitor", "DefaultBulletMonitorCallBack-onReceivedError-stopFluencyMonitor");
                            JSONObject jSONObject = new JSONObject();
                            DefaultBulletMonitorCallback defaultBulletMonitorCallback = DefaultBulletMonitorCallback.this;
                            jSONObject.put(FluencyHelper.STAGE, FluencyHelper.BEFORE_FMP);
                            String optString = defaultBulletMonitorCallback.getBulletContext().getMonitorContext().getCategory().optString(MetricConstant.SDK_TYPE);
                            if (optString != null) {
                                Intrinsics.checkNotNullExpressionValue(optString, "optString(MetricConstant.SDK_TYPE)");
                                jSONObject.put(MetricConstant.SDK_TYPE, optString);
                            }
                            fluencyMonitor3 = DefaultBulletMonitorCallback.this.fluencyMonitor;
                            fluencyMonitor3.stopFluencyMonitor(jSONObject);
                        }
                    }
                }

                @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate.Base, com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
                public void onReceivedError(IKitViewService viewService, String errorMsg) {
                    FluencyMonitor fluencyMonitor;
                    FluencyMonitor fluencyMonitor2;
                    FluencyMonitor fluencyMonitor3;
                    HybridLogger.INSTANCE.m9e("Monitor-Callback", LoggerStage.ON_RECEIVED_ERROR, MapsKt.mapOf(TuplesKt.to("message", errorMsg)), DefaultBulletMonitorCallback.this.getBulletContext().getLogContext());
                    fluencyMonitor = DefaultBulletMonitorCallback.this.fluencyMonitor;
                    if (fluencyMonitor.getEnableFluencyCollection()) {
                        fluencyMonitor2 = DefaultBulletMonitorCallback.this.fluencyMonitor;
                        if (fluencyMonitor2.getHasStarted()) {
                            Log.i("FluencyMonitor", "DefaultBulletMonitorCallBack-onReceivedError-stopFluencyMonitor");
                            JSONObject jSONObject = new JSONObject();
                            DefaultBulletMonitorCallback defaultBulletMonitorCallback = DefaultBulletMonitorCallback.this;
                            jSONObject.put(FluencyHelper.STAGE, FluencyHelper.BEFORE_FMP);
                            String optString = defaultBulletMonitorCallback.getBulletContext().getMonitorContext().getCategory().optString(MetricConstant.SDK_TYPE);
                            if (optString != null) {
                                Intrinsics.checkNotNullExpressionValue(optString, "optString(MetricConstant.SDK_TYPE)");
                                jSONObject.put(MetricConstant.SDK_TYPE, optString);
                            }
                            fluencyMonitor3 = DefaultBulletMonitorCallback.this.fluencyMonitor;
                            fluencyMonitor3.stopFluencyMonitor(jSONObject);
                        }
                    }
                }
            };
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle.Base, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
        public ILynxClientDelegate getLynxClient() {
            return this.lynxClient;
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle.Base, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
        public void setLynxClient(ILynxClientDelegate iLynxClientDelegate) {
            this.lynxClient = iLynxClientDelegate;
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle.Base, com.bytedance.ies.bullet.core.IBulletLifeCycle
        public void onBulletViewCreate() {
            TimeStampMap timeStampMap;
            HybridLogger.INSTANCE.m11i("Monitor-Callback", "bullet_view_create", null, DefaultBulletMonitorCallback.this.getBulletContext().getLogContext());
            timeStampMap = DefaultBulletMonitorCallback.this.timeStampMap;
            timeStampMap.record("bullet_view_create");
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle.Base, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
        public void onLoadStart(Uri uri, IBulletContainer container) {
            TimeStampMap timeStampMap;
            TimeStampMap timeStampMap2;
            String identifierUrl;
            FluencyMonitor fluencyMonitor;
            Intrinsics.checkNotNullParameter(uri, "uri");
            HybridLogger.INSTANCE.m11i("Monitor-Callback", LoggerStage.LOAD_START, MapsKt.mapOf(TuplesKt.to("url", uri.toString())), DefaultBulletMonitorCallback.this.getBulletContext().getLogContext());
            MonitorReportService monitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(DefaultBulletMonitorCallback.this.getBid(), IMonitorReportService.class);
            if (monitorReportService == null) {
                monitorReportService = MonitorReportService.INSTANCE.getFallbackDefault();
            }
            monitorReportService.getConfig();
            ReliabilityReporter.INSTANCE.reportLoadStart$anniex_release(DefaultBulletMonitorCallback.this.getBulletContext());
            DefaultBulletMonitorCallback.this.getBulletContext().getMonitorContext().setLoadStage(LoadStage.START_LOAD);
            DefaultBulletMonitorCallback.this.getBulletContext().getMonitorContext().setEndToEndStage("load_template_start");
            DefaultBulletMonitorCallback.this.loadNotReport = true;
            if (container != null) {
                DefaultBulletMonitorCallback.this.containerRef = new WeakReference(container);
            }
            ContainerStandardMonitorWrapper.INSTANCE.collect(DefaultBulletMonitorCallback.this.getSessionId(), MetricConstant.CONTAINER_NAME, "AnnieX");
            long currentTimeMillis = System.currentTimeMillis();
            DefaultBulletMonitorCallback defaultBulletMonitorCallback = DefaultBulletMonitorCallback.this;
            timeStampMap = defaultBulletMonitorCallback.timeStampMap;
            timeStampMap.record("container_init_start", Long.valueOf(currentTimeMillis));
            timeStampMap2 = defaultBulletMonitorCallback.timeStampMap;
            timeStampMap2.record(MetricConstant.BULLET_INIT, Long.valueOf(currentTimeMillis));
            ContainerStandardMonitorWrapper.INSTANCE.collect(defaultBulletMonitorCallback.getSessionId(), "container_init_start", Long.valueOf(currentTimeMillis));
            if (!DefaultBulletMonitorCallback.this.getBulletContext().getUseCardMode()) {
                CpuMemoryHelper.INSTANCE.initRecordConfig(DefaultBulletMonitorCallback.this.getBulletContext());
                CpuMemoryHelper.INSTANCE.recordCpuMemory(DefaultBulletMonitorCallback.this.getSessionId(), CpuMemoryPerfMetric.CONTAINER_LOAD);
                fluencyMonitor = DefaultBulletMonitorCallback.this.fluencyMonitor;
                fluencyMonitor.initRecordConfig(DefaultBulletMonitorCallback.this.getBulletContext());
            }
            BulletLoadUriIdentifier uriIdentifier = DefaultBulletMonitorCallback.this.getBulletContext().getUriIdentifier();
            if (uriIdentifier != null && (identifierUrl = uriIdentifier.getIdentifierUrl()) != null) {
                SceneManager.Companion.getInstance().sendViewLoadEvent(DefaultBulletMonitorCallback.this.getSessionId(), identifierUrl);
            }
            ContainerStandardMonitorWrapper.INSTANCE.collect(DefaultBulletMonitorCallback.this.getSessionId(), "view_type", DefaultBulletMonitorCallback.this.getBulletContext().getScene().getTag());
            ContainerStandardMonitorWrapper containerStandardMonitorWrapper = ContainerStandardMonitorWrapper.INSTANCE;
            String sessionId = DefaultBulletMonitorCallback.this.getSessionId();
            String bid = DefaultBulletMonitorCallback.this.getBulletContext().getBid();
            if (bid == null) {
                bid = "default_bid";
            }
            containerStandardMonitorWrapper.collect(sessionId, MetricConstant.FIELD_BIZ, bid);
            ContainerStandardMonitorWrapper.INSTANCE.collect(DefaultBulletMonitorCallback.this.getSessionId(), MetricConstant.FIELD_CORE_VIEW_TYPE, "BulletCard");
            ContainerStandardMonitorWrapper.INSTANCE.collect(DefaultBulletMonitorCallback.this.getSessionId(), MetricConstant.FIELD_CLIENT_COMPONENT, DefaultBulletMonitorCallback.this.getBulletContext().getClientComponent().getTag());
            SceneManager.Companion.getInstance().markSceneType(DefaultBulletMonitorCallback.this.getSessionId(), DefaultBulletMonitorCallback.this.getBulletContext().getClientComponent().getTag());
            SLMonitorCompat sLMonitorCompat = SLMonitorCompat.INSTANCE;
            String sessionId2 = DefaultBulletMonitorCallback.this.getSessionId();
            final DefaultBulletMonitorCallback defaultBulletMonitorCallback2 = DefaultBulletMonitorCallback.this;
            sLMonitorCompat.collectContainerBaseStringField(sessionId2, new Function1<SLAnnieXMonitor, Unit>() { // from class: com.bytedance.ies.bullet.service.monitor.DefaultBulletMonitorCallback$bulletCallback$1$onLoadStart$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SLAnnieXMonitor) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(SLAnnieXMonitor sLAnnieXMonitor) {
                    Intrinsics.checkNotNullParameter(sLAnnieXMonitor, "$this$collectContainerBaseStringField");
                    sLAnnieXMonitor.collectContainerBaseStringField(AccessLayerStringField.CoreViewType, "BulletCard");
                    AccessLayerStringField accessLayerStringField = AccessLayerStringField.Biz;
                    String bid2 = DefaultBulletMonitorCallback.this.getBulletContext().getBid();
                    if (bid2 == null) {
                        bid2 = "default_bid";
                    }
                    sLAnnieXMonitor.collectContainerBaseStringField(accessLayerStringField, bid2);
                    sLAnnieXMonitor.collectContainerBaseStringField(AccessLayerStringField.ClientComponent, DefaultBulletMonitorCallback.this.getBulletContext().getClientComponent().getTag());
                    sLAnnieXMonitor.collectContainerBaseStringField(AccessLayerStringField.SdkVersion, "9.0.0");
                }
            });
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle.Base, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
        public void onLoadModelSuccess(Uri uri, IKitViewService kitView, SchemaModelUnion schemaModelUnion) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(schemaModelUnion, "schemaModelUnion");
            HybridLogger.INSTANCE.m11i("Monitor-Callback", LoggerStage.LOAD_MODEL_SUCCESS, null, DefaultBulletMonitorCallback.this.getBulletContext().getLogContext());
            CpuMemoryHelper.INSTANCE.recordCpuMemory(DefaultBulletMonitorCallback.this.getSessionId(), CpuMemoryPerfMetric.VIEW_CREATE_BEGIN);
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle.Base, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
        public void onKitViewCreate(Uri uri, IKitViewService kitView) {
            TimeStampMap timeStampMap;
            DurationMap durationMap;
            TimeStampMap timeStampMap2;
            DurationMap durationMap2;
            TimeStampMap timeStampMap3;
            View realView;
            KitType kitType;
            Intrinsics.checkNotNullParameter(uri, "uri");
            HybridLogger.INSTANCE.m11i("Monitor-Callback", LoggerStage.KIT_VIEW_CREATE_END, null, DefaultBulletMonitorCallback.this.getBulletContext().getLogContext());
            long currentTimeMillis = System.currentTimeMillis();
            DefaultBulletMonitorCallback defaultBulletMonitorCallback = DefaultBulletMonitorCallback.this;
            timeStampMap = defaultBulletMonitorCallback.timeStampMap;
            timeStampMap.record(MetricConstant.VIEW_CREATE_END, Long.valueOf(currentTimeMillis));
            ContainerStandardMonitorWrapper.INSTANCE.collect(defaultBulletMonitorCallback.getSessionId(), MetricConstant.VIEW_CREATE_END, Long.valueOf(currentTimeMillis));
            String str = kitView instanceof ILynxKitViewService ? MetricConstant.CREATE_LYNXVIEW : MetricConstant.CREATE_WEBVIEW;
            durationMap = defaultBulletMonitorCallback.durationMap;
            timeStampMap2 = defaultBulletMonitorCallback.timeStampMap;
            durationMap.record(str, Long.valueOf(timeStampMap2.computeDuration(MetricConstant.VIEW_CREATE_START, MetricConstant.VIEW_CREATE_END)));
            durationMap2 = defaultBulletMonitorCallback.durationMap;
            timeStampMap3 = defaultBulletMonitorCallback.timeStampMap;
            durationMap2.record(MetricConstant.LOAD_TO_KIT_VIEW_CREATE, Long.valueOf(timeStampMap3.computeDuration("container_init_start", MetricConstant.VIEW_CREATE_END)));
            ILynxKitService lynxKitService2 = DefaultBulletMonitorCallback.INSTANCE.getLynxKitService();
            if (lynxKitService2 != null) {
                lynxKitService2.endSection(MetricConstant.CREATE_LYNXVIEW);
            }
            ILynxKitService lynxKitService3 = DefaultBulletMonitorCallback.INSTANCE.getLynxKitService();
            if (lynxKitService3 != null) {
                lynxKitService3.endSection(MetricConstant.LOAD_TO_KIT_VIEW_CREATE);
            }
            if (kitView != null && (realView = kitView.getRealView()) != null) {
                DefaultBulletMonitorCallback defaultBulletMonitorCallback2 = DefaultBulletMonitorCallback.this;
                ContainerStandardMonitorWrapper containerStandardMonitorWrapper = ContainerStandardMonitorWrapper.INSTANCE;
                String sessionId = defaultBulletMonitorCallback2.getSessionId();
                BulletLoadUriIdentifier uriIdentifier = defaultBulletMonitorCallback2.getBulletContext().getUriIdentifier();
                if (uriIdentifier == null || (kitType = uriIdentifier.getKitType()) == null) {
                    kitType = KitType.UNKNOWN;
                }
                containerStandardMonitorWrapper.attach(sessionId, realView, kitType.getTag());
            }
            CpuMemoryHelper.INSTANCE.recordCpuMemory(DefaultBulletMonitorCallback.this.getSessionId(), CpuMemoryPerfMetric.VIEW_CREATE_END);
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycleV2.Base, com.bytedance.ies.bullet.core.IBulletLifeCycleV2
        public void onEnterForeground(Uri uri, IKitViewService kitView) {
            TimeStampMap timeStampMap;
            String identifierUrl;
            Log.i("Monitor-Callback", DefaultBulletMonitorCallback.this.getSessionId() + " onEnterForeground");
            timeStampMap = DefaultBulletMonitorCallback.this.timeStampMap;
            timeStampMap.recordWithOverride(MetricConstant.VIEW_ENTER_FOREGROUND);
            if (Intrinsics.areEqual(DefaultBulletMonitorCallback.this.getBid(), BidConstants.WEBCAST) && !IConditionCallKt.disableActivityInfoRecordOpt()) {
                MessageQueue myQueue = Looper.myQueue();
                final DefaultBulletMonitorCallback defaultBulletMonitorCallback = DefaultBulletMonitorCallback.this;
                myQueue.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.bytedance.ies.bullet.service.monitor.DefaultBulletMonitorCallback$bulletCallback$1$onEnterForeground$1
                    @Override // android.os.MessageQueue.IdleHandler
                    public final boolean queueIdle() {
                        CpuMemoryHelper.INSTANCE.recordActivityInfo(DefaultBulletMonitorCallback.this.getSessionId());
                        return false;
                    }
                });
            } else {
                CpuMemoryHelper.INSTANCE.recordActivityInfo(DefaultBulletMonitorCallback.this.getSessionId());
            }
            BulletLoadUriIdentifier uriIdentifier = DefaultBulletMonitorCallback.this.getBulletContext().getUriIdentifier();
            if (uriIdentifier == null || (identifierUrl = uriIdentifier.getIdentifierUrl()) == null) {
                return;
            }
            NpthHelper.INSTANCE.injectBulletUrl(identifierUrl, false);
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycleV2.Base, com.bytedance.ies.bullet.core.IBulletLifeCycleV2
        public void onEnterBackground(Uri uri, IKitViewService kitView) {
            TimeStampMap timeStampMap;
            TimeStampMap timeStampMap2;
            FluencyMonitor fluencyMonitor;
            FluencyMonitor fluencyMonitor2;
            FluencyMonitor fluencyMonitor3;
            String identifierUrl;
            DurationMap durationMap;
            TimeStampMap timeStampMap3;
            DurationMap durationMap2;
            TimeStampMap timeStampMap4;
            TimeStampMap timeStampMap5;
            Log.i("Monitor-Callback", DefaultBulletMonitorCallback.this.getSessionId() + " onEnterBackground");
            timeStampMap = DefaultBulletMonitorCallback.this.timeStampMap;
            timeStampMap.recordWithOverride(MetricConstant.VIEW_ENTER_BACKGROUND);
            timeStampMap2 = DefaultBulletMonitorCallback.this.timeStampMap;
            if (timeStampMap2.contains(MetricConstant.VIEW_ENTER_FOREGROUND)) {
                durationMap = DefaultBulletMonitorCallback.this.durationMap;
                timeStampMap3 = DefaultBulletMonitorCallback.this.timeStampMap;
                durationMap.recordWithOverride(MetricConstant.STAY_DURATION, Long.valueOf(timeStampMap3.computeDuration(MetricConstant.VIEW_ENTER_FOREGROUND, MetricConstant.VIEW_ENTER_BACKGROUND)));
                TimelineReporter timelineReporter = TimelineReporter.INSTANCE;
                BulletContext bulletContext = DefaultBulletMonitorCallback.this.getBulletContext();
                durationMap2 = DefaultBulletMonitorCallback.this.durationMap;
                timelineReporter.reportStayDuration(bulletContext, durationMap2);
                timeStampMap4 = DefaultBulletMonitorCallback.this.timeStampMap;
                timeStampMap4.remove(MetricConstant.VIEW_ENTER_FOREGROUND);
                timeStampMap5 = DefaultBulletMonitorCallback.this.timeStampMap;
                timeStampMap5.remove(MetricConstant.VIEW_ENTER_BACKGROUND);
            }
            BulletLoadUriIdentifier uriIdentifier = DefaultBulletMonitorCallback.this.getBulletContext().getUriIdentifier();
            if (uriIdentifier != null && (identifierUrl = uriIdentifier.getIdentifierUrl()) != null) {
                NpthHelper.INSTANCE.uninjectBulletUrl(identifierUrl);
            }
            fluencyMonitor = DefaultBulletMonitorCallback.this.fluencyMonitor;
            if (fluencyMonitor.getEnableFluencyCollection()) {
                fluencyMonitor2 = DefaultBulletMonitorCallback.this.fluencyMonitor;
                if (fluencyMonitor2.getHasStarted()) {
                    Log.i("FluencyMonitor", "DefaultBulletMonitorCallBack-onEnterBackground-stopFluencyMonitor");
                    JSONObject jSONObject = new JSONObject();
                    DefaultBulletMonitorCallback defaultBulletMonitorCallback = DefaultBulletMonitorCallback.this;
                    jSONObject.put(FluencyHelper.STAGE, FluencyHelper.ERROR_STAGE);
                    String optString = defaultBulletMonitorCallback.getBulletContext().getMonitorContext().getCategory().optString(MetricConstant.SDK_TYPE);
                    if (optString != null) {
                        Intrinsics.checkNotNullExpressionValue(optString, "optString(MetricConstant.SDK_TYPE)");
                        jSONObject.put(MetricConstant.SDK_TYPE, optString);
                    }
                    fluencyMonitor3 = DefaultBulletMonitorCallback.this.fluencyMonitor;
                    fluencyMonitor3.stopFluencyMonitor(jSONObject);
                }
            }
            DefaultBulletMonitorCallback.this.onViewDisappear();
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle.Base, com.bytedance.ies.bullet.core.IBulletLifeCycle
        public void onBulletViewRelease() {
            TimeStampMap timeStampMap;
            HybridLogger.INSTANCE.m11i("Monitor-Callback", "bullet_view_release", null, DefaultBulletMonitorCallback.this.getBulletContext().getLogContext());
            timeStampMap = DefaultBulletMonitorCallback.this.timeStampMap;
            timeStampMap.record("bullet_view_release");
            DefaultBulletMonitorCallback.this.onViewDisappear();
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle.Base, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
        public void onLoadUriSuccess(Uri uri, IKitViewService kitView) {
            boolean z;
            Intrinsics.checkNotNullParameter(uri, "uri");
            HybridLogger.INSTANCE.m11i("Monitor-Callback", LoggerStage.LOAD_URI_SUCCESS, MapsKt.mapOf(TuplesKt.to("url", uri.toString())), DefaultBulletMonitorCallback.this.getBulletContext().getLogContext());
            DefaultBulletMonitorCallback.this.getBulletContext().getContainerContext().setLoadStatus("success");
            CpuMemoryHelper.INSTANCE.recordCpuMemory(DefaultBulletMonitorCallback.this.getSessionId(), CpuMemoryPerfMetric.VIEW_LOAD_END);
            z = DefaultBulletMonitorCallback.this.loadNotReport;
            if (z) {
                ReliabilityReporter.INSTANCE.reportLoadSuccess$anniex_release(DefaultBulletMonitorCallback.this.getBulletContext());
            }
            DefaultBulletMonitorCallback.this.getBulletContext().getMonitorContext().setLoadStage(LoadStage.END);
            DefaultBulletMonitorCallback.this.getBulletContext().getMonitorContext().setEndToEndStage("load_success");
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle.Base, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
        public void onLoadFail(Uri uri, Throwable e) {
            boolean z;
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(e, "e");
            HybridLogger.INSTANCE.m9e("Monitor-Callback", LoggerStage.LOAD_FAIL, MapsKt.mapOf(new Pair[]{TuplesKt.to("url", uri.toString()), TuplesKt.to("message", e.getMessage())}), DefaultBulletMonitorCallback.this.getBulletContext().getLogContext());
            CpuMemoryHelper.INSTANCE.recordCpuMemory(DefaultBulletMonitorCallback.this.getSessionId(), CpuMemoryPerfMetric.VIEW_LOAD_FAIL);
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            AbsBulletMonitorCallback.ErrStage errStage = AbsBulletMonitorCallback.ErrStage.Engine;
            if (Intrinsics.areEqual(DefaultBulletMonitorCallback.this.getBulletContext().getContainerContext().getLoaderTaskPerfMetric().getLoaderResult(), false)) {
                errStage = AbsBulletMonitorCallback.ErrStage.Plugin;
            } else if (Intrinsics.areEqual(DefaultBulletMonitorCallback.this.getBulletContext().getResourceContext().getResFrom(), "unknown")) {
                errStage = AbsBulletMonitorCallback.ErrStage.RL;
            } else if (StringsKt.startsWith$default(message, "container_error", false, 2, (Object) null)) {
                errStage = AbsBulletMonitorCallback.ErrStage.Container;
            }
            z = DefaultBulletMonitorCallback.this.loadNotReport;
            if (z) {
                DefaultBulletMonitorCallback defaultBulletMonitorCallback = DefaultBulletMonitorCallback.this;
                defaultBulletMonitorCallback.onLoadError(errStage, message, defaultBulletMonitorCallback.getBulletContext().getContainerContext().getHasErrorView());
            }
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle.Base, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
        public void onFallback(Uri uri, Throwable e) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(e, "e");
            HybridLogger.INSTANCE.m11i("Monitor-Callback", LoggerStage.FALL_BACK, MapsKt.mapOf(new Pair[]{TuplesKt.to("url", uri.toString()), TuplesKt.to("message", e.getMessage())}), DefaultBulletMonitorCallback.this.getBulletContext().getLogContext());
            BulletContainerContext containerContext = DefaultBulletMonitorCallback.this.getBulletContext().getContainerContext();
            Fallback fallback = new Fallback();
            fallback.setPrev(DefaultBulletMonitorCallback.this.getBulletContext().getLoadUri());
            fallback.setFallback(uri);
            fallback.setFallbackReason(e.getMessage());
            containerContext.setFallbackInfo(fallback);
            ContainerStandardMonitorWrapper.INSTANCE.collect(DefaultBulletMonitorCallback.this.getSessionId(), "invoke_fallback", true);
            ContainerStandardMonitorWrapper.INSTANCE.collect(DefaultBulletMonitorCallback.this.getSessionId(), "is_fallback", true);
            ContainerStandardMonitorWrapper containerStandardMonitorWrapper = ContainerStandardMonitorWrapper.INSTANCE;
            String sessionId = DefaultBulletMonitorCallback.this.getSessionId();
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
            containerStandardMonitorWrapper.collect(sessionId, SchemaConstants.QUERY_KEY_FALLBACK_URL, uri2);
            ContainerStandardMonitorWrapper.INSTANCE.collect(DefaultBulletMonitorCallback.this.getSessionId(), "fallback_error_msg", String.valueOf(e.getMessage()));
        }
    };
    private final AtomicInteger callbackCount = new AtomicInteger(0);
    private final CpuMemoryReporter cpuMemoryReporter = new CpuMemoryReporter();

    /* compiled from: DefaultBulletMonitorCallback.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AbsBulletMonitorCallback.ErrStage.values().length];
            try {
                iArr[AbsBulletMonitorCallback.ErrStage.Container.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AbsBulletMonitorCallback.ErrStage.Plugin.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AbsBulletMonitorCallback.ErrStage.RL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AbsBulletMonitorCallback.ErrStage.Engine.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean delayPreload(Uri uri) {
        return ForestInfoHelper.DefaultImpls.delayPreload(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean delayPreload(BulletContext bulletContext) {
        return ForestInfoHelper.DefaultImpls.delayPreload(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean delayPreload(SchemaModelUnion schemaModelUnion) {
        return ForestInfoHelper.DefaultImpls.delayPreload(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(Uri uri) {
        return ForestInfoHelper.DefaultImpls.forestDownloadEngine(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(BulletContext bulletContext) {
        return ForestInfoHelper.DefaultImpls.forestDownloadEngine(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(IServiceToken iServiceToken) {
        return ForestInfoHelper.DefaultImpls.forestDownloadEngine(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(SchemaModelUnion schemaModelUnion) {
        return ForestInfoHelper.DefaultImpls.forestDownloadEngine(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String getResTag(LynxResourceRequest.LynxResourceType lynxResourceType) {
        return ForestInfoHelper.DefaultImpls.getResTag(this, lynxResourceType);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public Scene getSceneType(LynxResourceRequest.LynxResourceType lynxResourceType) {
        return ForestInfoHelper.DefaultImpls.getSceneType(this, lynxResourceType);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public ProcessedResponse<TemplateBundle> getTemplateBundleResponse(Response response) {
        return ForestInfoHelper.DefaultImpls.getTemplateBundleResponse(this, response);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean hasGeckoModelInfo(BulletContext bulletContext) {
        return ForestInfoHelper.DefaultImpls.hasGeckoModelInfo(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean hasGeckoModelInfo(IServiceToken iServiceToken) {
        return ForestInfoHelper.DefaultImpls.hasGeckoModelInfo(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean hasGeckoModelInfo(SchemaModelUnion schemaModelUnion) {
        return ForestInfoHelper.DefaultImpls.hasGeckoModelInfo(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String preloadScope(Uri uri) {
        return ForestInfoHelper.DefaultImpls.preloadScope(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String preloadScope(BulletContext bulletContext) {
        return ForestInfoHelper.DefaultImpls.preloadScope(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String preloadScope(SchemaModelUnion schemaModelUnion) {
        return ForestInfoHelper.DefaultImpls.preloadScope(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String sessionID(BulletContext bulletContext) {
        return ForestInfoHelper.DefaultImpls.sessionID(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String sessionID(IServiceToken iServiceToken) {
        return ForestInfoHelper.DefaultImpls.sessionID(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(Uri uri) {
        return ForestInfoHelper.DefaultImpls.useForest(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(BulletContext bulletContext) {
        return ForestInfoHelper.DefaultImpls.useForest(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(IServiceToken iServiceToken) {
        return ForestInfoHelper.DefaultImpls.useForest(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(SchemaModelUnion schemaModelUnion) {
        return ForestInfoHelper.DefaultImpls.useForest(this, schemaModelUnion);
    }

    /* compiled from: DefaultBulletMonitorCallback.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/DefaultBulletMonitorCallback$Companion;", "", "()V", "lynxKitService", "Lcom/bytedance/ies/bullet/service/base/lynx/ILynxKitService;", "getLynxKitService", "()Lcom/bytedance/ies/bullet/service/base/lynx/ILynxKitService;", "moduleName", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ILynxKitService getLynxKitService() {
            if (DefaultBulletMonitorCallback.lynxKitService == null) {
                DefaultBulletMonitorCallback.lynxKitService = (ILynxKitService) ServiceCenter.INSTANCE.instance().get(ILynxKitService.class);
            }
            return DefaultBulletMonitorCallback.lynxKitService;
        }
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public long getPerfMetric(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        long j = 0;
        if (this.timeStampMap.get(key) > 0) {
            j = this.timeStampMap.get(key);
        } else if (this.durationMap.get(key) > 0) {
            j = this.durationMap.get(key);
        } else if (this.lynxTimeStampMap.get(key) > 0) {
            j = this.lynxTimeStampMap.get(key);
        } else if (this.lynxDurationMap.get(key) > 0) {
            j = this.lynxDurationMap.get(key);
        }
        Log.i(moduleName, getSessionId() + " getPerfMetric " + key + ' ' + j);
        return j;
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public JSONObject getPerfMetrics() {
        JSONObject wrap = JsonUtilsKt.wrap(JsonUtilsKt.wrap(JsonUtilsKt.wrap(JsonUtilsKt.wrap(new JSONObject(), this.timeStampMap.getMMap()), this.durationMap.getMMap()), this.lynxTimeStampMap.getMMap()), this.lynxDurationMap.getMMap());
        Log.i(moduleName, getSessionId() + " getPerfMetrics " + wrap);
        return wrap;
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void recordDuration(String key, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(block, "block");
        long currentTimeMillis = System.currentTimeMillis();
        block.invoke();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        this.durationMap.record(key, Long.valueOf(currentTimeMillis2));
        Log.i(moduleName, getSessionId() + " recordDuration " + key + ' ' + currentTimeMillis2);
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void recordTimeStamp(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Log.i(moduleName, getSessionId() + " recordTimeStamp " + key);
        this.timeStampMap.record(key);
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public Map<String, Long> generatePerfMapForGlobalProps() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(MetricConstant.BULLET_INIT, Long.valueOf(this.timeStampMap.get(MetricConstant.BULLET_INIT)));
        linkedHashMap.put(MetricConstant.ROUTER_OPEN, Long.valueOf(this.timeStampMap.get(MetricConstant.ROUTER_OPEN)));
        linkedHashMap.put("container_init_start", Long.valueOf(this.timeStampMap.get("container_init_start")));
        linkedHashMap.put("container_init_end", Long.valueOf(this.timeStampMap.get("container_init_end")));
        Log.i(moduleName, getSessionId() + " generatePerfMapForGlobalProps " + linkedHashMap);
        return linkedHashMap;
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public IBulletLifeCycleV2.Base getBulletCallback() {
        return this.bulletCallback;
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void onBulletContextCreated(BulletContext context) {
        MonitorSettingsConfig monitorSettingsConfig;
        Map<String, String> containerABConfig;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onBulletContextCreated(context);
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService != null && (monitorSettingsConfig = (MonitorSettingsConfig) iBulletSettingsService.obtainSettings(MonitorSettingsConfig.class)) != null && (containerABConfig = monitorSettingsConfig.getContainerABConfig()) != null) {
            for (Map.Entry<String, String> entry : containerABConfig.entrySet()) {
                ContainerStandardMonitor.INSTANCE.addContext(getSessionId(), entry.getKey(), entry.getValue());
            }
        }
        BulletLogger.INSTANCE.printLog(getSessionId() + " onBulletContextCreated", LogLevel.I, moduleName);
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void onSchemaPrepared() {
        Comparable valueOf;
        Log.i(moduleName, getSessionId() + " onSchemaPrepared");
        ISchemaData schemaData = getBulletContext().getSchemaData();
        if (schemaData != null) {
            long parseTimeStamp = schemaData.getParseTimeStamp();
            this.timeStampMap.record(MetricConstant.SCHEMA_START, Long.valueOf(parseTimeStamp));
            ContainerStandardMonitorWrapper.INSTANCE.collect(getSessionId(), MetricConstant.SCHEMA_START, Long.valueOf(parseTimeStamp));
        }
        ISchemaData schemaData2 = getBulletContext().getSchemaData();
        if (schemaData2 != null) {
            long convertEndTimeStamp = schemaData2.getConvertEndTimeStamp();
            this.timeStampMap.record(MetricConstant.SCHEMA_END, Long.valueOf(convertEndTimeStamp));
            this.durationMap.record(MetricConstant.SCHEMA_CONVERT, Long.valueOf(this.timeStampMap.computeDuration(MetricConstant.SCHEMA_START, MetricConstant.SCHEMA_END)));
            ContainerStandardMonitorWrapper.INSTANCE.collect(getSessionId(), MetricConstant.SCHEMA_END, Long.valueOf(convertEndTimeStamp));
        }
        ContainerStandardMonitorWrapper containerStandardMonitorWrapper = ContainerStandardMonitorWrapper.INSTANCE;
        String sessionId = getSessionId();
        ISchemaData schemaData3 = getBulletContext().getSchemaData();
        if (schemaData3 == null || (valueOf = schemaData3.getInnerOriginUrl()) == null) {
            valueOf = String.valueOf(getBulletContext().getLoadUri());
        }
        containerStandardMonitorWrapper.collect(sessionId, "schema", valueOf);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onContainerCreated(Long containerCreateTime) {
        long j;
        Bundle bundle;
        Log.i(moduleName, getSessionId() + " onContainerCreated " + containerCreateTime);
        long longValue = containerCreateTime != null ? containerCreateTime.longValue() : System.currentTimeMillis();
        if (this.timeStampMap.contains(MetricConstant.CONTAINER_CREATE)) {
            return;
        }
        this.timeStampMap.record(MetricConstant.CONTAINER_CREATE, Long.valueOf(longValue));
        ISchemaData schemaData = getBulletContext().getSchemaData();
        Unit unit = null;
        Long valueOf = (schemaData == null || (bundle = schemaData.get_innerBundle()) == null) ? null : Long.valueOf(bundle.getLong(MetricConstant.ROUTER_OPEN));
        if (valueOf != null) {
            if (!(valueOf.longValue() != 0)) {
                valueOf = null;
            }
            if (valueOf != null) {
                j = valueOf.longValue();
                unit = Unit.INSTANCE;
                if (unit == null) {
                    j = this.timeStampMap.get(MetricConstant.ROUTER_OPEN);
                    if (j <= 0) {
                        j = longValue;
                    }
                }
                ContainerStandardMonitorWrapper.INSTANCE.collect(getSessionId(), MetricConstant.ROUTER_OPEN, Long.valueOf(j));
                ContainerStandardMonitorWrapper.INSTANCE.collect(getSessionId(), MetricConstant.CONTAINER_CREATE, Long.valueOf(longValue));
                if (this.timeStampMap.contains(MetricConstant.ROUTER_OPEN)) {
                    return;
                }
                this.durationMap.record(MetricConstant.ROUTER_TO_CREATE, Long.valueOf(this.timeStampMap.computeDuration(MetricConstant.ROUTER_OPEN, MetricConstant.CONTAINER_CREATE)));
                return;
            }
        }
        j = longValue;
        if (unit == null) {
        }
        ContainerStandardMonitorWrapper.INSTANCE.collect(getSessionId(), MetricConstant.ROUTER_OPEN, Long.valueOf(j));
        ContainerStandardMonitorWrapper.INSTANCE.collect(getSessionId(), MetricConstant.CONTAINER_CREATE, Long.valueOf(longValue));
        if (this.timeStampMap.contains(MetricConstant.ROUTER_OPEN)) {
        }
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void onLoadEntryBullet(long containerStartTime, boolean isRouter) {
        String identifierUrl;
        BulletLogger.INSTANCE.printLog(getSessionId() + " onLoadEntryBullet " + containerStartTime + ' ' + isRouter, LogLevel.I, moduleName);
        if (isRouter) {
            this.timeStampMap.record(MetricConstant.ROUTER_OPEN, Long.valueOf(containerStartTime));
        } else {
            this.timeStampMap.record("container_init_start", Long.valueOf(containerStartTime));
        }
        if (!this.timeStampMap.contains(MetricConstant.BULLET_INIT)) {
            Companion companion = INSTANCE;
            ILynxKitService lynxKitService2 = companion.getLynxKitService();
            if (lynxKitService2 != null) {
                lynxKitService2.beginSection(MetricConstant.INIT_TO_START_RENDER);
            }
            ILynxKitService lynxKitService3 = companion.getLynxKitService();
            if (lynxKitService3 != null) {
                lynxKitService3.beginSection(MetricConstant.LOAD_TO_KIT_VIEW_CREATE);
            }
            this.timeStampMap.record(MetricConstant.BULLET_INIT, Long.valueOf(containerStartTime));
            BulletTracert.INSTANCE.associateSession(getBulletContext(), this.timeStampMap.get(MetricConstant.BULLET_INIT));
            ReliabilityReporter.INSTANCE.reportContainerInit$anniex_release(getBulletContext());
        } else if (this.timeStampMap.contains(MetricConstant.CONTAINER_CREATE)) {
            this.timeStampMap.record(MetricConstant.BULLET_INIT, Long.valueOf(containerStartTime));
            this.durationMap.record(MetricConstant.CREATE_TO_LOAD, Long.valueOf(this.timeStampMap.computeDuration(MetricConstant.CONTAINER_CREATE, "container_init_start")));
        }
        BulletLoadUriIdentifier uriIdentifier = getBulletContext().getUriIdentifier();
        if (uriIdentifier != null && (identifierUrl = uriIdentifier.getIdentifierUrl()) != null) {
            NpthHelper.injectBulletUrl$default(NpthHelper.INSTANCE, identifierUrl, false, 2, null);
        }
        HybridCrashHelper hybridCrashHelper = HybridCrashHelper.INSTANCE;
        BulletLoadUriIdentifier uriIdentifier2 = getBulletContext().getUriIdentifier();
        String identifierUrl2 = uriIdentifier2 != null ? uriIdentifier2.getIdentifierUrl() : null;
        BulletLoadUriIdentifier uriIdentifier3 = getBulletContext().getUriIdentifier();
        hybridCrashHelper.injectInfo(identifierUrl2, uriIdentifier3 != null ? uriIdentifier3.getFullUrl() : null);
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void onContainerLoaderStart() {
        Log.i(moduleName, getSessionId() + " onContainerLoaderStart");
        long currentTimeMillis = System.currentTimeMillis();
        this.timeStampMap.record("container_init_end", Long.valueOf(currentTimeMillis));
        ContainerStandardMonitorWrapper.INSTANCE.collect(getSessionId(), "container_init_end", Long.valueOf(currentTimeMillis));
        ContainerStandardMonitorWrapper.INSTANCE.addContext(getSessionId(), MetricConstant.ANNIE_VIEW_TYPE, getBulletContext().getScene().getTag());
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void onKitViewCreateBegin() {
        HybridLogger.INSTANCE.m11i(moduleName, LoggerStage.KIT_VIEW_CREATE_START, null, getBulletContext().getLogContext());
        long currentTimeMillis = System.currentTimeMillis();
        this.timeStampMap.record(MetricConstant.VIEW_CREATE_START, Long.valueOf(currentTimeMillis));
        ContainerStandardMonitorWrapper.INSTANCE.collect(getSessionId(), MetricConstant.VIEW_CREATE_START, Long.valueOf(currentTimeMillis));
        this.durationMap.record(MetricConstant.LOADER_TASK, Long.valueOf(getBulletContext().getContainerContext().getLoaderTaskPerfMetric().getDuration()));
        ILynxKitService lynxKitService2 = INSTANCE.getLynxKitService();
        if (lynxKitService2 != null) {
            lynxKitService2.beginSection(MetricConstant.CREATE_LYNXVIEW);
        }
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void onBulletViewAttached(IBulletContainer monitorContainer) {
        Intrinsics.checkNotNullParameter(monitorContainer, "monitorContainer");
        Log.i(moduleName, getSessionId() + " onBulletViewAttached");
        this.timeStampMap.recordWithOverride(MetricConstant.CONTAINER_ATTACH);
        this.containerRef = new WeakReference<>(monitorContainer);
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void onViewAttached(String url) {
        super.onViewAttached(url);
        MonitorManager.INSTANCE.onAttachToWindow(getSessionId(), url);
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void onReload(IBulletContainer monitorContainer) {
        Intrinsics.checkNotNullParameter(monitorContainer, "monitorContainer");
        Log.i(moduleName, getSessionId() + " onReload");
        onViewDisappear();
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void reportErrorViewShow() {
        ReliabilityReporter.INSTANCE.reportErrorViewShow(getBulletContext());
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void reportErrorViewClick() {
        ReliabilityReporter.INSTANCE.reportErrorViewClick(getBulletContext());
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void onBulletViewDetached() {
        Log.i(moduleName, getSessionId() + " onBulletViewDetached");
        this.timeStampMap.recordWithOverride(MetricConstant.CONTAINER_DETACH);
        onViewDisappear();
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void onPrepareTemplateBegin() {
        HybridLogger.INSTANCE.m11i(moduleName, "prepare_template_start", null, getBulletContext().getLogContext());
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.timeStampMap.contains("prepare_template_start")) {
            this.timeStampMap.record("prepare_template_start");
            ContainerStandardMonitorWrapper.INSTANCE.collect(getSessionId(), "prepare_template_start", Long.valueOf(currentTimeMillis));
            ContainerStandardMonitorWrapper.INSTANCE.addContext(getSessionId(), "enableForest", useForest(getBulletContext()) ? "1" : ViewVisibleBridge.INVISIBLE);
        }
        BulletLoadUriIdentifier uriIdentifier = getBulletContext().getUriIdentifier();
        if ((uriIdentifier != null ? uriIdentifier.getKitType() : null) == KitType.LYNX) {
            this.durationMap.record(MetricConstant.CREATE_TO_RL, Long.valueOf(this.timeStampMap.computeDuration(MetricConstant.VIEW_CREATE_END, "prepare_template_start")));
            Companion companion = INSTANCE;
            ILynxKitService lynxKitService2 = companion.getLynxKitService();
            if (lynxKitService2 != null) {
                lynxKitService2.beginSection(MetricConstant.RESOURCE_LOAD);
            }
            ILynxKitService lynxKitService3 = companion.getLynxKitService();
            if (lynxKitService3 != null) {
                lynxKitService3.beginSection("download_template");
            }
        }
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void onPrepareTemplateEnd() {
        HybridLogger.INSTANCE.m11i(moduleName, "prepare_template_end", null, getBulletContext().getLogContext());
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.timeStampMap.contains("prepare_template_end")) {
            this.timeStampMap.record("prepare_template_end");
            ContainerStandardMonitorWrapper.INSTANCE.collect(getSessionId(), "prepare_template_end", Long.valueOf(currentTimeMillis));
            ReliabilityReporter.INSTANCE.reportSuccessStage(getBulletContext(), "download_template");
        }
        ContainerStandardMonitorWrapper.INSTANCE.collect(getSessionId(), "template_res_type", getBulletContext().getResourceContext().getResFrom());
        this.durationMap.record("download_template", Long.valueOf(this.timeStampMap.computeDuration("prepare_template_start", "prepare_template_end")));
        ILynxKitService lynxKitService2 = INSTANCE.getLynxKitService();
        if (lynxKitService2 != null) {
            lynxKitService2.endSection("download_template");
        }
        getBulletContext().getMonitorContext().setLoadStage(LoadStage.DOWNLOAD_TEMPLATE);
        getBulletContext().getMonitorContext().setEndToEndStage("load_template_end");
        SLMonitorCompat.INSTANCE.collectResourceField(getSessionId(), getBulletContext().getResourceContext().getResVersion(), getBulletContext().getResourceContext().getResFrom());
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void onJsbRegisterBegin() {
        Log.i(moduleName, getSessionId() + " onJsbRegisterBegin");
        this.timeStampMap.record(MetricConstant.JSB_REGISTER_START);
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void onJsbRegisterEnd() {
        Log.i(moduleName, getSessionId() + " onJsbRegisterEnd");
        this.timeStampMap.recordWithOverride(MetricConstant.JSB_REGISTER_END);
        this.durationMap.record(MetricConstant.JSB_REGISTER, Long.valueOf(this.timeStampMap.computeDuration(MetricConstant.JSB_REGISTER_START, MetricConstant.JSB_REGISTER_END)));
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void onWebLoadUrl() {
        HybridLogger.INSTANCE.m11i(moduleName, LoggerStage.WEB_LOAD_URL, null, getBulletContext().getLogContext());
        ContainerStandardMonitor.INSTANCE.collect(getSessionId(), MetricConstant.StdMetric.ENGINE_VIEW_RENDER_START, Long.valueOf(System.currentTimeMillis()));
        this.timeStampMap.record(MetricConstant.WEB_LOAD_URL);
        this.durationMap.record(MetricConstant.CREATE_TO_LOAD_URL, Long.valueOf(this.timeStampMap.computeDuration(MetricConstant.VIEW_CREATE_END, MetricConstant.WEB_LOAD_URL)));
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void onWebPageStarted() {
        HybridLogger.INSTANCE.m11i(moduleName, LoggerStage.ON_WEB_PAGE_STARTED, null, getBulletContext().getLogContext());
        this.timeStampMap.record(MetricConstant.WEB_PAGE_START);
        this.durationMap.record(MetricConstant.LOAD_URL_TO_PAGE_START, Long.valueOf(this.timeStampMap.computeDuration(MetricConstant.WEB_LOAD_URL, MetricConstant.WEB_PAGE_START)));
        this.durationMap.record(MetricConstant.CREATE_TO_PAGE_START, Long.valueOf(this.timeStampMap.computeDuration(MetricConstant.VIEW_CREATE_END, MetricConstant.WEB_PAGE_START)));
        this.durationMap.record(MetricConstant.INIT_TO_START_RENDER, Long.valueOf(this.timeStampMap.computeDuration(MetricConstant.BULLET_INIT, MetricConstant.WEB_PAGE_START)));
        CpuMemoryHelper.INSTANCE.recordCpuMemory(getSessionId(), CpuMemoryPerfMetric.VIEW_PAGESTART);
        this.callbackCount.set(0);
        recordSecBeforeOnPageStarted();
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void onWebPageFinished() {
        HybridLogger.INSTANCE.m11i(moduleName, LoggerStage.ON_WEB_PAGE_FINISHED, null, getBulletContext().getLogContext());
        this.timeStampMap.record(MetricConstant.WEB_PAGE_FINISH);
        this.durationMap.record(MetricConstant.WEB_RENDER, Long.valueOf(this.timeStampMap.computeDuration(MetricConstant.WEB_PAGE_START, MetricConstant.WEB_PAGE_FINISH)));
        this.durationMap.record(MetricConstant.FIRST_SCREEN, Long.valueOf(this.timeStampMap.computeDuration(MetricConstant.BULLET_INIT, MetricConstant.WEB_PAGE_FINISH)));
        this.callbackCount.addAndGet(2);
        onSetup();
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void onLynxReadTemplateBegin() {
        HybridLogger.INSTANCE.m11i(moduleName, "read_template_start", null, getBulletContext().getLogContext());
        this.timeStampMap.record("read_template_start");
        ILynxKitService lynxKitService2 = INSTANCE.getLynxKitService();
        if (lynxKitService2 != null) {
            lynxKitService2.beginSection(MetricConstant.READ_TEMPLATE);
        }
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void onLynxReadTemplateEnd() {
        HybridLogger.INSTANCE.m11i(moduleName, "read_template_end", null, getBulletContext().getLogContext());
        Log.i(moduleName, getSessionId() + " onLynxReadTemplateEnd");
        this.timeStampMap.record("read_template_end");
        this.durationMap.record(MetricConstant.READ_TEMPLATE, Long.valueOf(this.timeStampMap.computeDuration("prepare_template_end", "read_template_end")));
        this.durationMap.record(MetricConstant.RESOURCE_LOAD, Long.valueOf(this.timeStampMap.computeDuration("prepare_template_start", "read_template_end")));
        Companion companion = INSTANCE;
        ILynxKitService lynxKitService2 = companion.getLynxKitService();
        if (lynxKitService2 != null) {
            lynxKitService2.endSection(MetricConstant.READ_TEMPLATE);
        }
        ILynxKitService lynxKitService3 = companion.getLynxKitService();
        if (lynxKitService3 != null) {
            lynxKitService3.endSection(MetricConstant.RESOURCE_LOAD);
        }
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void onLynxRenderTemplateBegin() {
        HybridLogger.INSTANCE.m11i(moduleName, "render_template_start", null, getBulletContext().getLogContext());
        ContainerStandardMonitor.INSTANCE.collect(getSessionId(), MetricConstant.StdMetric.ENGINE_VIEW_RENDER_START, Long.valueOf(System.currentTimeMillis()));
        this.timeStampMap.record("render_template_start");
        this.durationMap.record(MetricConstant.RL_TO_RENDER, Long.valueOf(this.timeStampMap.computeDuration("read_template_end", "render_template_start")));
        this.durationMap.record(MetricConstant.INIT_TO_START_RENDER, Long.valueOf(this.timeStampMap.computeDuration(MetricConstant.BULLET_INIT, "render_template_start")));
        ILynxKitService lynxKitService2 = INSTANCE.getLynxKitService();
        if (lynxKitService2 != null) {
            lynxKitService2.endSection(MetricConstant.INIT_TO_START_RENDER);
        }
        this.callbackCount.set(0);
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void onLynxRenderTemplateEnd() {
        HybridLogger.INSTANCE.m11i(moduleName, "render_template_end", null, getBulletContext().getLogContext());
        this.timeStampMap.record("render_template_end");
        this.durationMap.record(MetricConstant.RENDER_TEMPLATE_MAIN, Long.valueOf(this.timeStampMap.computeDuration("render_template_start", "render_template_end")));
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void recordSecurityEventTime(String event) {
        Intrinsics.checkNotNullParameter(event, ISignalReportService.BODY_KEY_EVENT);
        this.securityTimeStampMap.record(event);
    }

    private final void recordSecBeforeOnPageStarted() {
        this.durationMap.record(MetricConstant.SEC_LOAD_URL_TO_PAGE_START, Long.valueOf(this.securityTimeStampMap.computeDuration(CollectionsKt.listOf(new Pair[]{new Pair(MetricConstant.SEC_ABOUT_TO_LOAD_URL_START, MetricConstant.SEC_ABOUT_TO_LOAD_URL_END), new Pair(MetricConstant.SEC_WEB_LOAD_URL_START, MetricConstant.SEC_WEB_LOAD_URL_END)}))));
        this.durationMap.record(MetricConstant.SEC_TRULY_LOAD_URL_INTERVAL, Long.valueOf(this.securityTimeStampMap.computeDuration(CollectionsKt.listOf(new Pair(MetricConstant.SEC_ABOUT_TO_LOAD_URL_END, MetricConstant.SEC_WEB_LOAD_URL_START)))));
        this.durationMap.record(MetricConstant.SEC_INIT_TO_START_RENDER, Long.valueOf(this.securityTimeStampMap.computeDuration(CollectionsKt.listOf(new Pair[]{new Pair(MetricConstant.SEC_CREATE_CONTAINER_START, MetricConstant.SEC_CREATE_CONTAINER_END), new Pair(MetricConstant.SEC_CONTAINER_CREATED_START, MetricConstant.SEC_CONTAINER_CREATED_END), new Pair(MetricConstant.SEC_ABOUT_TO_LOAD_URL_START, MetricConstant.SEC_ABOUT_TO_LOAD_URL_END), new Pair(MetricConstant.SEC_WEB_LOAD_URL_START, MetricConstant.SEC_WEB_LOAD_URL_END)}))));
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void onLoadError(AbsBulletMonitorCallback.ErrStage errStage, String errMessage, boolean hasErrorView) {
        int errorDomain;
        String str;
        Intrinsics.checkNotNullParameter(errStage, "errStage");
        Intrinsics.checkNotNullParameter(errMessage, "errMessage");
        Log.i(moduleName, getSessionId() + " onLoadError " + errStage + ", " + errMessage);
        getBulletContext().getContainerContext().setLoadStatus("failure");
        ContainerStandardMonitor containerStandardMonitor = ContainerStandardMonitor.INSTANCE;
        ContainerStandardMonitorWrapper.INSTANCE.collect(getSessionId(), "is_fallback", Boolean.valueOf(getBulletContext().isFallback()));
        MonitorReportService monitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(getBid(), IMonitorReportService.class);
        if (monitorReportService == null) {
            monitorReportService = MonitorReportService.INSTANCE.getFallbackDefault();
        }
        MonitorConfig config = monitorReportService.getConfig();
        IKitViewService viewService = getBulletContext().getViewService();
        View realView = viewService != null ? viewService.getRealView() : null;
        String sessionId = getSessionId();
        String bizTag = config.getBizTag();
        String str2 = bizTag == null ? "" : bizTag;
        String virtualAID = config.getVirtualAID();
        containerStandardMonitor.reportError(realView, sessionId, -1, errMessage, str2, virtualAID == null ? "" : virtualAID);
        BulletMonitorContext monitorContext = getBulletContext().getMonitorContext();
        int i = WhenMappings.$EnumSwitchMapping$0[errStage.ordinal()];
        if (i == 1) {
            errorDomain = UnifyErrorDomain.AnnieXUnifyErrorDomainContainerInit.getErrorDomain();
            str = "load_container_fail";
        } else if (i == 2) {
            errorDomain = UnifyErrorDomain.AnnieXUnifyErrorDomainContainerPlugin.getErrorDomain();
            str = "load_plugin_fail";
        } else if (i == 3) {
            errorDomain = UnifyErrorDomain.AnnieXUnifyErrorDomainResourceLoader.getErrorDomain();
            str = "load_template_fail";
        } else if (i == 4) {
            BulletLoadUriIdentifier uriIdentifier = getBulletContext().getUriIdentifier();
            if ((uriIdentifier != null ? uriIdentifier.getKitType() : null) == KitType.LYNX) {
                errorDomain = UnifyErrorDomain.AnnieXUnifyErrorDomainEngineLynx.getErrorDomain();
            } else {
                errorDomain = UnifyErrorDomain.AnnieXUnifyErrorDomainEngineWeb.getErrorDomain();
            }
            str = "load_engine_fail";
        } else {
            errorDomain = UnifyErrorDomain.AnnieXUnifyErrorDomainReserved.getErrorDomain();
            str = LoggerStage.LOAD_FAIL;
        }
        monitorContext.setEndToEndStage(str);
        monitorContext.setUnifyErrorDomain(errorDomain);
        monitorContext.setEndToEndErrorMessage(errMessage);
        ReliabilityReporter.INSTANCE.reportLoadFail(getBulletContext(), errStage, errMessage, hasErrorView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01e5, code lost:
    
        if (r0.equals("cancel") == false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01ef, code lost:
    
        com.bytedance.ies.bullet.service.monitor.reliability.ReliabilityReporter.INSTANCE.reportLoadCancel(getBulletContext());
        com.bytedance.ies.bullet.service.monitor.deviceperf.CpuMemoryHelper.INSTANCE.recordCpuMemory(getSessionId(), com.bytedance.ies.bullet.service.monitor.deviceperf.CpuMemoryPerfMetric.VIEW_LOAD_CANCEL);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01ec, code lost:
    
        if (r0.equals("success") == false) goto L108;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0178  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onViewDisappear() {
        boolean z;
        CommonConfig commonConfig;
        BulletLoadUriIdentifier uriIdentifier;
        String identifierUrl;
        Log.i(moduleName, getSessionId() + " onViewDisappear");
        CpuMemoryHelper.stopCycleRecord$default(CpuMemoryHelper.INSTANCE, true, null, 2, null);
        if (this.loadNotReport && (uriIdentifier = getBulletContext().getUriIdentifier()) != null && (identifierUrl = uriIdentifier.getIdentifierUrl()) != null) {
            NpthHelper.INSTANCE.uninjectBulletUrl(identifierUrl);
        }
        WeakReference<IBulletContainer> weakReference = this.containerRef;
        if ((weakReference != null ? weakReference.get() : null) == null) {
            BulletLogger.INSTANCE.printLog("empty containerRef", LogLevel.E, moduleName);
        }
        WeakReference<IBulletContainer> weakReference2 = this.containerRef;
        Object obj = weakReference2 != null ? (IBulletContainer) weakReference2.get() : null;
        View view = obj instanceof View ? (View) obj : null;
        if ((view != null && view.getVisibility() == 0) && !getBulletContext().getContainerContext().getIsRelease()) {
            WeakReference<IBulletContainer> weakReference3 = this.containerRef;
            Object obj2 = weakReference3 != null ? (IBulletContainer) weakReference3.get() : null;
            View view2 = obj2 instanceof View ? (View) obj2 : null;
            if (view2 != null && view2.isAttachedToWindow()) {
                z = true;
                IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
                boolean z2 = (iBulletSettingsService != null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) ? false : Intrinsics.areEqual(commonConfig.getDisableInvisibleViewMonitor(), false) ? true : z;
                if (this.loadNotReport) {
                    WeakReference<IBulletContainer> weakReference4 = this.containerRef;
                    if ((weakReference4 != null ? weakReference4.get() : null) == null || (z2 && (Intrinsics.areEqual(getBulletContext().getContainerContext().getLoadStatus(), "success") || Intrinsics.areEqual(getBulletContext().getContainerContext().getLoadStatus(), MetricConstant.MONITOR_STAGE_UPDATE)))) {
                        triggerBlankDetect();
                        if (getBulletContext().getMonitorContext().getInUse()) {
                            this.durationMap.record(MetricConstant.BEFORE_BULLET, Long.valueOf(this.timeStampMap.get(MetricConstant.BULLET_INIT) - getBulletContext().getMonitorContext().getInitTime()));
                        }
                        TimelineReporter.INSTANCE.reportTimeline(getBulletContext(), this.timeStampMap, this.durationMap);
                        if (getBulletContext().getViewService() instanceof ILynxKitViewService) {
                            TimelineReporter.INSTANCE.reportUserFirstScreen(getBulletContext(), this.timeStampMap);
                        }
                        TimelineReporter.INSTANCE.reportTracertTimeline(getBulletContext());
                        onCpuMemoryReport();
                    }
                }
                if (this.loadNotReport) {
                    WeakReference<IBulletContainer> weakReference5 = this.containerRef;
                    if ((weakReference5 != null ? weakReference5.get() : null) == null || z2) {
                        String loadStatus = getBulletContext().getContainerContext().getLoadStatus();
                        ReliabilityReporter reliabilityReporter = ReliabilityReporter.INSTANCE;
                        BulletContext bulletContext = getBulletContext();
                        long initTime = getBulletContext().getMonitorContext().getInitTime();
                        if (initTime <= 0) {
                            initTime = this.timeStampMap.get(MetricConstant.BULLET_INIT);
                        }
                        reliabilityReporter.reportContainerExit(bulletContext, loadStatus, initTime);
                        ReliabilityReporter.INSTANCE.traceEndToEnd(getBulletContext());
                        int hashCode = loadStatus.hashCode();
                        if (hashCode != -1867169789) {
                            if (hashCode != -1367724422) {
                                if (hashCode == -1086574198 && loadStatus.equals("failure")) {
                                    onCpuMemoryReport();
                                }
                            }
                        }
                    }
                }
                this.loadNotReport = false;
                CpuMemoryHelper.INSTANCE.release();
            }
        }
        z = false;
        IBulletSettingsService iBulletSettingsService2 = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if ((iBulletSettingsService2 != null || (commonConfig = (CommonConfig) iBulletSettingsService2.obtainSettings(CommonConfig.class)) == null) ? false : Intrinsics.areEqual(commonConfig.getDisableInvisibleViewMonitor(), false)) {
        }
        if (this.loadNotReport) {
        }
        if (this.loadNotReport) {
        }
        this.loadNotReport = false;
        CpuMemoryHelper.INSTANCE.release();
    }

    private final void triggerBlankDetect() {
        IKitViewService viewService = getBulletContext().getViewService();
        if (viewService != null) {
            viewService.triggerBlankDetect();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSetup() {
        IBulletPerfClient iBulletPerfClient;
        Log.i(moduleName, getSessionId() + " onSetup " + this.callbackCount.get());
        if (this.callbackCount.get() <= 2 || (iBulletPerfClient = (IBulletPerfClient) ContextProviderManager.INSTANCE.getProviderFactory(getSessionId()).provideInstance(IBulletPerfClient.class)) == null) {
            return;
        }
        JSONObject assemblePerfMetric = TimelineHelper.INSTANCE.assemblePerfMetric(this.lynxTimeStampMap, this.lynxDurationMap);
        JSONObject assemblePerfMetric2 = TimelineHelper.INSTANCE.assemblePerfMetric(this.timeStampMap, this.durationMap);
        iBulletPerfClient.onSetup(assemblePerfMetric, assemblePerfMetric2);
        Log.i(moduleName, "IBulletPerfClient onSetup: " + assemblePerfMetric);
        Log.i(moduleName, "IBulletPerfClient onSetup: " + assemblePerfMetric2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onUpdate(String flag) {
        IBulletPerfClient iBulletPerfClient;
        Log.i(moduleName, getSessionId() + " onUpdate " + this.callbackCount.get());
        if (this.callbackCount.get() <= 2 || (iBulletPerfClient = (IBulletPerfClient) ContextProviderManager.INSTANCE.getProviderFactory(getSessionId()).provideInstance(IBulletPerfClient.class)) == null) {
            return;
        }
        JSONObject assemblePerfMetric = TimelineHelper.INSTANCE.assemblePerfMetric(this.updateLynxTimeStampMap, this.updateLynxDurationMap);
        JSONObject assemblePerfMetric2 = TimelineHelper.INSTANCE.assemblePerfMetric(this.timeStampMap, this.durationMap);
        iBulletPerfClient.onUpdate(assemblePerfMetric, assemblePerfMetric2, flag);
        Log.i(moduleName, "IBulletPerfClient onUpdate: " + assemblePerfMetric);
        Log.i(moduleName, "IBulletPerfClient onUpdate: " + assemblePerfMetric2);
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void onBlankDetected(BulletContext bulletContext, Integer isBlank, Float percent) {
        Intrinsics.checkNotNullParameter(bulletContext, "bulletContext");
        Log.i(moduleName, getSessionId() + " onBlankDetected " + isBlank + ", " + percent);
        ReliabilityReporter.INSTANCE.reportBlankDetected(bulletContext, isBlank, percent);
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void onCpuMemoryInject(String eventName, JSONObject category, JSONObject metrics) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        Log.i(moduleName, getSessionId() + " onCpuMemoryInject " + eventName + ' ' + category + ' ' + metrics);
        if (getBulletContext().getContainerContext().getCpuMemoryPerfMetric() == null) {
            getBulletContext().getContainerContext().setCpuMemoryPerfMetric(new CpuMemoryPerfMetric());
        }
        this.cpuMemoryReporter.inject(eventName, category, metrics);
    }

    @Override // com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback
    public void onCpuMemoryReport() {
        Log.i(moduleName, getSessionId() + " onCpuMemoryReport");
        if (getBulletContext().getUseCardMode()) {
            Log.d(moduleName, "useCodeMode is true. Ignore onCpuMemoryReport");
        } else {
            Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.service.monitor.DefaultBulletMonitorCallback$onCpuMemoryReport$1
                @Override // java.util.concurrent.Callable
                public /* bridge */ /* synthetic */ Object call() {
                    call();
                    return Unit.INSTANCE;
                }

                @Override // java.util.concurrent.Callable
                public final void call() {
                    CpuMemoryReporter cpuMemoryReporter;
                    cpuMemoryReporter = DefaultBulletMonitorCallback.this.cpuMemoryReporter;
                    cpuMemoryReporter.reportCpuMemory(DefaultBulletMonitorCallback.this.getBulletContext());
                }
            });
        }
    }
}

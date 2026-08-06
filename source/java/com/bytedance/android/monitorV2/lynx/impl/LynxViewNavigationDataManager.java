package com.bytedance.android.monitorV2.lynx.impl;

import android.view.View;
import com.bytedance.android.monitorV2.InternalWatcher;
import com.bytedance.android.monitorV2.base.BaseNativeInfo;
import com.bytedance.android.monitorV2.checker.PerfMixHandler;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.entity.ContainerBase;
import com.bytedance.android.monitorV2.entity.ContainerInfo;
import com.bytedance.android.monitorV2.entity.EngineInfo;
import com.bytedance.android.monitorV2.entity.PerfMixData;
import com.bytedance.android.monitorV2.entity.PvData;
import com.bytedance.android.monitorV2.event.CommonEvent;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.exception.HybridCrashHelper;
import com.bytedance.android.monitorV2.hybridSetting.SettingsParseManager;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitorConstant;
import com.bytedance.android.monitorV2.lynx.blank.LynxBlankDetect;
import com.bytedance.android.monitorV2.lynx.data.entity.LynxBlankData;
import com.bytedance.android.monitorV2.lynx.data.entity.LynxLifecycleData;
import com.bytedance.android.monitorV2.lynx.data.entity.LynxNativeErrorData;
import com.bytedance.android.monitorV2.lynx.data.entity.LynxPerfData;
import com.bytedance.android.monitorV2.lynx.impl.blank.BlankCheckTask;
import com.bytedance.android.monitorV2.settings.LynxBlankConfig;
import com.bytedance.android.monitorV2.settings.MonitorSettingsCenter;
import com.bytedance.android.monitorV2.standard.ContainerDataCache;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.android.sdk.bdticketguard.TicketGuardEventHelper;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.applog.server.Api;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.methods.JsCallParser;
import com.lynx.tasm.LynxConfigInfo;
import com.lynx.tasm.LynxPerfMetric;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.TraceEvent;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: LynxViewNavigationDataManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\u001e\u0010p\u001a\u00020#2\u0014\u0010q\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020s\u0018\u00010rH\u0002J\b\u0010t\u001a\u000204H\u0002J1\u0010V\u001a\u00020#2\u0006\u0010n\u001a\u00020o2!\u0010Z\u001a\u001d\u0012\u0013\u0012\u001104¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(u\u0012\u0004\u0012\u00020#0[J\u0006\u0010v\u001a\u00020'J\u0010\u0010w\u001a\u00020#2\u0006\u0010x\u001a\u00020\u0006H\u0002J\u0018\u0010y\u001a\u00020#2\b\u0010z\u001a\u0004\u0018\u00010{2\u0006\u0010|\u001a\u00020!J\b\u0010}\u001a\u00020#H\u0016J\b\u0010~\u001a\u00020#H\u0016J$\u0010\u007f\u001a\u00020#2\u001a\u0010\u0080\u0001\u001a\u0015\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0006\u0012\u0004\u0018\u00010s\u0018\u00010\u0081\u0001H\u0016J\u001b\u0010\u0082\u0001\u001a\u00020#2\u0007\u0010\u0083\u0001\u001a\u00020!2\u0007\u0010\u0084\u0001\u001a\u00020sH\u0016J\t\u0010\u0085\u0001\u001a\u00020#H\u0016J\u0013\u0010\u0086\u0001\u001a\u00020#2\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0016J\u0012\u0010\u0089\u0001\u001a\u00020#2\u0007\u0010\u008a\u0001\u001a\u00020UH\u0016J\t\u0010\u008b\u0001\u001a\u00020#H\u0016J\u0011\u0010\u008c\u0001\u001a\u00020#2\u0006\u0010?\u001a\u00020!H\u0016J!\u0010\u008d\u0001\u001a\u00020#2\u0016\u0010\u008e\u0001\u001a\u0011\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020s\u0018\u00010\u0081\u0001H\u0016J\t\u0010\u008f\u0001\u001a\u00020#H\u0016J\u0014\u0010\u0090\u0001\u001a\u00020#2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010!H\u0016J\u0013\u0010\u0092\u0001\u001a\u00020#2\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001H\u0016J\u0015\u0010\u0095\u0001\u001a\u00020#2\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001H\u0016J\t\u0010\u0098\u0001\u001a\u00020#H\u0016J\u001f\u0010\u0099\u0001\u001a\u00020#2\u0014\u0010q\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020s\u0018\u00010rH\u0016J\u001f\u0010\u009a\u0001\u001a\u00020#2\u0014\u0010q\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020s\u0018\u00010rH\u0016J\u0013\u0010\u009b\u0001\u001a\u00020#2\b\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0016J\t\u0010\u009e\u0001\u001a\u00020#H\u0002J\u0010\u0010\u009f\u0001\u001a\u00020#2\u0007\u0010\u0087\u0001\u001a\u00020`J\t\u0010 \u0001\u001a\u00020#H\u0002J\u0012\u0010¡\u0001\u001a\u00020#2\u0007\u0010¢\u0001\u001a\u00020UH\u0002J\t\u0010£\u0001\u001a\u00020#H\u0002J\"\u0010¤\u0001\u001a\u00020#2\u0007\u0010\u0087\u0001\u001a\u00020`2\u0007\u0010¥\u0001\u001a\u00020o2\u0007\u0010¦\u0001\u001a\u00020!R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR)\u0010\u001f\u001a\u001a\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020#0 ¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010)\u001a\u0004\u0018\u00010*8F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0011\u0010-\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u000e\u00100\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0011\u00109\u001a\u00020:¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010A\"\u0004\bF\u0010CR\u0011\u0010G\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\bH\u0010AR\u001e\u0010I\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020!@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010AR\u001e\u0010K\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\"@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u001e\u0010N\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020!@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bO\u0010AR\u000e\u0010P\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010T\u001a\u00020UX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR+\u0010Z\u001a\u001f\u0012\u0013\u0012\u001104¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(^\u0012\u0004\u0012\u00020#\u0018\u00010[X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010_\u001a\u00020`8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u0010\u0014\u001a\u0004\ba\u0010bR\u000e\u0010d\u001a\u00020eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020gX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010h\u001a\u0004\u0018\u00010`X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010i\u001a\u0004\u0018\u00010!8F¢\u0006\u0006\u001a\u0004\bj\u0010AR\u001c\u0010k\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010A\"\u0004\bm\u0010CR\u000e\u0010n\u001a\u00020oX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006§\u0001"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/impl/LynxViewNavigationDataManager;", "Lcom/bytedance/android/monitorV2/lynx/impl/LynxIntegration;", "Lcom/bytedance/android/monitorV2/standard/ContainerDataCache$IdQueryCallback;", "lynxViewDataManager", "Lcom/bytedance/android/monitorV2/lynx/impl/LynxViewDataManager;", "preCreate", "", "(Lcom/bytedance/android/monitorV2/lynx/impl/LynxViewDataManager;Z)V", "(Lcom/bytedance/android/monitorV2/lynx/impl/LynxViewDataManager;)V", "actualFmpEnd", "", "<set-?>", "bidExactly", "getBidExactly", "()Z", "blankConfig", "Lcom/bytedance/android/monitorV2/settings/LynxBlankConfig;", "getBlankConfig", "()Lcom/bytedance/android/monitorV2/settings/LynxBlankConfig;", "blankConfig$delegate", "Lkotlin/Lazy;", "containerVariablesRef", "Lcom/bytedance/android/monitorV2/lynx/impl/ContainerVariablesRef;", "getContainerVariablesRef", "()Lcom/bytedance/android/monitorV2/lynx/impl/ContainerVariablesRef;", "setContainerVariablesRef", "(Lcom/bytedance/android/monitorV2/lynx/impl/ContainerVariablesRef;)V", "dataHandler", "Lcom/bytedance/android/monitorV2/lynx/impl/LynxEventHandler;", "getDataHandler", "()Lcom/bytedance/android/monitorV2/lynx/impl/LynxEventHandler;", "dataHandlerPostProcessor", "Lkotlin/Function3;", "", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfo$BidConfig;", "", "getDataHandlerPostProcessor", "()Lkotlin/jvm/functions/Function3;", "engineInfo", "Lcom/bytedance/android/monitorV2/entity/EngineInfo;", "fmpEnd", "hostView", "Lcom/lynx/tasm/LynxView;", "getHostView", "()Lcom/lynx/tasm/LynxView;", "initTime", "getInitTime", "()J", "isBlankDetected", "isPerfEventLynxStateSet", "isPerfEventUploaded", "jsConf", "Lorg/json/JSONObject;", "getJsConf", "()Lorg/json/JSONObject;", "setJsConf", "(Lorg/json/JSONObject;)V", "lifecycle", "Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxLifecycleData;", "getLifecycle", "()Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxLifecycleData;", "getLynxViewDataManager", "()Lcom/bytedance/android/monitorV2/lynx/impl/LynxViewDataManager;", "monitorId", "getMonitorId", "()Ljava/lang/String;", "setMonitorId", "(Ljava/lang/String;)V", "naviBid", "getNaviBid", "setNaviBid", "naviId", "getNaviId", "navigationBid", "getNavigationBid", "navigationBidConfig", "getNavigationBidConfig", "()Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfo$BidConfig;", "navigationBidSource", "getNavigationBidSource", "onFirstLoadPerfEnd", "onFirstScreenEnd", "onRuntimeReadyEnd", "onTimingSetupEnd", "performance", "Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxPerfData;", "getPerformance", "()Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxPerfData;", "setPerformance", "(Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxPerfData;)V", "performanceCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "performanceData", "performanceEvent", "Lcom/bytedance/android/monitorV2/event/CommonEvent;", "getPerformanceEvent", "()Lcom/bytedance/android/monitorV2/event/CommonEvent;", "performanceEvent$delegate", "performanceMix", "Lcom/bytedance/android/monitorV2/entity/PerfMixData;", "performanceMixHandler", "Lcom/bytedance/android/monitorV2/checker/PerfMixHandler;", "preCreatePvEvent", "sessionId", "getSessionId", "templateUrl", "getTemplateUrl", "setTemplateUrl", "waitCompleteData", "", "checkActualFmp", "timingInfo", "", "", "createPerformanceResult", "performanceResult", "getUnifyInfo", "handlePerfMix", "isCallback", "invokeBlankDetect", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/android/monitorV2/lynx/blank/LynxBlankDetect$OnLynxBlankCallback;", "detectFrom", "onAttachedToView", "onBeforeDestroy", "onCallJSBFinished", "jsbTiming", "", "onConfig", Api.KEY_ENCRYPT_RESP_KEY, "value", "onDestroy", "onEventPost", "event", "Lcom/bytedance/android/monitorV2/event/HybridEvent;", "onFirstLoadPerfReady", "lynxPerf", "onFirstScreen", "onIdQueryFinished", "onJSBInvoked", "jsbInfo", "onLoadSuccess", "onPageStart", "url", "onReceivedError", "data", "Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxNativeErrorData;", "onReportLynxConfigInfo", "info", "Lcom/lynx/tasm/LynxConfigInfo;", "onRuntimeReady", "onTimingSetup", "onTimingUpdate", "onUpdatePerfReady", "metric", "Lcom/lynx/tasm/LynxPerfMetric;", "postPerfEvent", "reportBlank", "tryToUploadPerf", "updatePerf", "lynxPerfData", "updatePerfEvent", "updateUnifyError", AlogMonitor.ALOG_RESULT_CODE, "message", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LynxViewNavigationDataManager extends LynxIntegration implements ContainerDataCache.IdQueryCallback {
    private long actualFmpEnd;
    private volatile boolean bidExactly;

    /* renamed from: blankConfig$delegate, reason: from kotlin metadata */
    private final Lazy blankConfig;
    private ContainerVariablesRef containerVariablesRef;
    private final LynxEventHandler dataHandler;
    private final Function3<String, BidInfo.BidConfig, String, Unit> dataHandlerPostProcessor;
    private final EngineInfo engineInfo;
    private long fmpEnd;
    private final long initTime;
    private boolean isBlankDetected;
    private boolean isPerfEventLynxStateSet;
    private boolean isPerfEventUploaded;
    private JSONObject jsConf;
    private final LynxLifecycleData lifecycle;
    private final LynxViewDataManager lynxViewDataManager;
    private String monitorId;
    private String naviBid;
    private volatile String navigationBid;
    private BidInfo.BidConfig navigationBidConfig;
    private String navigationBidSource;
    private boolean onFirstLoadPerfEnd;
    private boolean onFirstScreenEnd;
    private boolean onRuntimeReadyEnd;
    private boolean onTimingSetupEnd;
    private LynxPerfData performance;
    private Function1<? super JSONObject, Unit> performanceCallback;

    /* renamed from: performanceEvent$delegate, reason: from kotlin metadata */
    private final Lazy performanceEvent;
    private PerfMixData performanceMix;
    private PerfMixHandler performanceMixHandler;
    private CommonEvent preCreatePvEvent;
    private String templateUrl;
    private int waitCompleteData;

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onBeforeDestroy() {
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onReportLynxConfigInfo(LynxConfigInfo info) {
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onUpdatePerfReady(LynxPerfMetric metric) {
        Intrinsics.checkNotNullParameter(metric, "metric");
    }

    public final LynxViewDataManager getLynxViewDataManager() {
        return this.lynxViewDataManager;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LynxViewNavigationDataManager(LynxViewDataManager lynxViewDataManager) {
        super(lynxViewDataManager.getHostViewRef$anniex_release().get());
        Intrinsics.checkNotNullParameter(lynxViewDataManager, "lynxViewDataManager");
        this.lynxViewDataManager = lynxViewDataManager;
        this.initTime = System.currentTimeMillis();
        this.blankConfig = LazyKt.lazy(new Function0<LynxBlankConfig>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxViewNavigationDataManager$blankConfig$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final LynxBlankConfig m369invoke() {
                LynxBlankConfig lynxBlankConfig;
                MonitorSettingsCenter settingsCenter = SettingsParseManager.INSTANCE.getSettingsCenter();
                return (settingsCenter == null || (lynxBlankConfig = (LynxBlankConfig) settingsCenter.obtainSettings(LynxBlankConfig.class)) == null) ? LynxBlankConfig.INSTANCE.getDEFAULT() : lynxBlankConfig;
            }
        });
        this.naviBid = "";
        this.monitorId = "";
        this.jsConf = new JSONObject();
        this.lifecycle = new LynxLifecycleData();
        this.performance = new LynxPerfData();
        LynxView hostView = getHostView();
        this.templateUrl = hostView != null ? hostView.getTemplateUrl() : null;
        this.dataHandler = new LynxEventHandler(this);
        String str = BidInfo.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(str, "DEFAULT");
        this.navigationBid = str;
        this.navigationBidConfig = new BidInfo.BidConfig(BidInfo.DEFAULT);
        this.navigationBidSource = "default_bid";
        this.dataHandlerPostProcessor = new Function3<String, BidInfo.BidConfig, String, Unit>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxViewNavigationDataManager$dataHandlerPostProcessor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((String) obj, (BidInfo.BidConfig) obj2, (String) obj3);
                return Unit.INSTANCE;
            }

            public final void invoke(String str2, BidInfo.BidConfig bidConfig, String str3) {
                Intrinsics.checkNotNullParameter(str2, "bid");
                Intrinsics.checkNotNullParameter(bidConfig, "bidConfig");
                Intrinsics.checkNotNullParameter(str3, "bidSource");
                LynxViewNavigationDataManager.this.navigationBid = str2;
                LynxViewNavigationDataManager.this.navigationBidConfig = bidConfig;
                LynxViewNavigationDataManager.this.navigationBidSource = str3;
                LynxViewNavigationDataManager.this.bidExactly = true;
            }
        };
        this.containerVariablesRef = new ContainerVariablesRef(this.monitorId);
        this.engineInfo = new EngineInfo(lynxViewDataManager.getCommonProps());
        this.performanceMix = new PerfMixData();
        this.performanceMixHandler = new PerfMixHandler(CollectionsKt.listOf(new String[]{ReportConst.Event.RES_LOADER_PERF_TEMPLATE, ReportConst.Event.RES_LOADER_PERF, ReportConst.Event.JSB_PER_V2}));
        this.performanceEvent = LazyKt.lazy(new Function0<CommonEvent>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxViewNavigationDataManager$performanceEvent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final CommonEvent m370invoke() {
                return CommonEvent.INSTANCE.create("performance", LynxViewNavigationDataManager.this.getPerformance());
            }
        });
    }

    public final long getInitTime() {
        return this.initTime;
    }

    public final LynxBlankConfig getBlankConfig() {
        return (LynxBlankConfig) this.blankConfig.getValue();
    }

    public final String getSessionId() {
        return this.lynxViewDataManager.getSessionId();
    }

    public final String getNaviId() {
        String str = this.lynxViewDataManager.getCommonProps().navigationId;
        Intrinsics.checkNotNullExpressionValue(str, "lynxViewDataManager.commonProps.navigationId");
        return str;
    }

    public final String getNaviBid() {
        return this.naviBid;
    }

    public final void setNaviBid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.naviBid = str;
    }

    public final String getMonitorId() {
        return this.monitorId;
    }

    public final void setMonitorId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.monitorId = str;
    }

    public final JSONObject getJsConf() {
        return this.jsConf;
    }

    public final void setJsConf(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<set-?>");
        this.jsConf = jSONObject;
    }

    public final LynxLifecycleData getLifecycle() {
        return this.lifecycle;
    }

    public final LynxPerfData getPerformance() {
        return this.performance;
    }

    public final void setPerformance(LynxPerfData lynxPerfData) {
        Intrinsics.checkNotNullParameter(lynxPerfData, "<set-?>");
        this.performance = lynxPerfData;
    }

    public final String getTemplateUrl() {
        return this.templateUrl;
    }

    public final void setTemplateUrl(String str) {
        this.templateUrl = str;
    }

    public final LynxView getHostView() {
        LynxView view = this.lynxViewDataManager.getView();
        if (view != null) {
            return view;
        }
        MonitorLog.m28e("HybridMonitorSDK_V2", "Host view seem to be destroyed, investigation terminated.", new Throwable());
        return null;
    }

    public final LynxEventHandler getDataHandler() {
        return this.dataHandler;
    }

    public final String getNavigationBid() {
        return this.navigationBid;
    }

    public final BidInfo.BidConfig getNavigationBidConfig() {
        return this.navigationBidConfig;
    }

    public final String getNavigationBidSource() {
        return this.navigationBidSource;
    }

    public final boolean getBidExactly() {
        return this.bidExactly;
    }

    public final Function3<String, BidInfo.BidConfig, String, Unit> getDataHandlerPostProcessor() {
        return this.dataHandlerPostProcessor;
    }

    public final ContainerVariablesRef getContainerVariablesRef() {
        return this.containerVariablesRef;
    }

    public final void setContainerVariablesRef(ContainerVariablesRef containerVariablesRef) {
        Intrinsics.checkNotNullParameter(containerVariablesRef, "<set-?>");
        this.containerVariablesRef = containerVariablesRef;
    }

    private final CommonEvent getPerformanceEvent() {
        return (CommonEvent) this.performanceEvent.getValue();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LynxViewNavigationDataManager(LynxViewDataManager lynxViewDataManager, boolean z) {
        this(lynxViewDataManager);
        Intrinsics.checkNotNullParameter(lynxViewDataManager, "lynxViewDataManager");
        this.preCreatePvEvent = CommonEvent.INSTANCE.create("navigationStart", new PvData());
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onRuntimeReady() {
        MonitorLog.m29i(LynxViewMonitor.TAG, "onRuntimeReady: " + this.templateUrl + ", view: " + getHostView());
        this.onRuntimeReadyEnd = true;
        this.lifecycle.setRuntimeReady(System.currentTimeMillis());
        updatePerfEvent();
        tryToUploadPerf();
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onFirstScreen() {
        MonitorLog.m29i(LynxViewMonitor.TAG, "onFirstScreen: " + this.templateUrl + ", view: " + getHostView());
        this.onFirstScreenEnd = true;
        this.lifecycle.setFirstScreen(System.currentTimeMillis());
        updatePerfEvent();
        tryToUploadPerf();
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onFirstLoadPerfReady(LynxPerfData lynxPerf) {
        Intrinsics.checkNotNullParameter(lynxPerf, "lynxPerf");
        MonitorLog.m29i(LynxViewMonitor.TAG, "onFirstLoadPerfReady: " + this.templateUrl + ", view: " + getHostView());
        this.onFirstLoadPerfEnd = true;
        this.performance.setLifecycle(this.lifecycle);
        LynxLifecycleData lifecycle = this.performance.getLifecycle();
        if (lifecycle != null) {
            lifecycle.setLoadState(LynxLifecycleData.INSTANCE.getSTATE_LOAD_SUCESS());
        }
        lynxPerf.setLynxState(0);
        updatePerfEvent();
        updatePerf(lynxPerf);
        tryToUploadPerf();
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onTimingSetup(Map<String, Object> timingInfo) {
        MonitorLog.m29i(LynxViewMonitor.TAG, "onTimingSetup: " + this.templateUrl + ", view: " + getHostView());
        this.onTimingSetupEnd = true;
        LynxProxy.INSTANCE.updateExtraTiming(getHostViewRef$anniex_release().get());
        this.performance.setTimingInfo(timingInfo);
        LynxLifecycleData lifecycle = this.performance.getLifecycle();
        if (lifecycle != null) {
            lifecycle.setLoadState(LynxLifecycleData.INSTANCE.getSTATE_LOAD_SUCESS());
        }
        this.performance.setLynxState(0);
        this.isPerfEventLynxStateSet = true;
        updatePerfEvent();
        tryToUploadPerf();
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onTimingUpdate(Map<String, Object> timingInfo) {
        this.performance.setTimingInfo(timingInfo);
        updatePerfEvent();
        checkActualFmp(timingInfo);
        handlePerfMix(true);
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onReceivedError(LynxNativeErrorData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.performance.setLynxState(1);
        this.performance.setLifecycle(this.lifecycle);
        LynxLifecycleData lifecycle = this.performance.getLifecycle();
        if (lifecycle != null) {
            lifecycle.setLoadState(LynxLifecycleData.INSTANCE.getSTATE_LAOD_ERROR());
        }
        LynxLifecycleData lifecycle2 = this.performance.getLifecycle();
        if (lifecycle2 != null) {
            lifecycle2.setShowEnd(System.currentTimeMillis());
        }
        this.dataHandler.notifyAllEvents();
        updatePerfEvent();
        postPerfEvent();
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onConfig(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(key, "jsBase")) {
            if (value instanceof JSONObject) {
                if (StringsKt.isBlank(this.naviBid)) {
                    String optString = ((JSONObject) value).optString("bid");
                    Intrinsics.checkNotNullExpressionValue(optString, "it");
                    this.naviBid = optString;
                }
                JSONObject merge = JsonUtils.merge(this.jsConf, (JSONObject) value);
                Intrinsics.checkNotNullExpressionValue(merge, "merge(this.jsConf, value)");
                this.jsConf = merge;
            }
            if (!StringsKt.isBlank(this.naviBid)) {
                HybridCrashHelper.INSTANCE.bindInfo(this.templateUrl, this.naviBid);
            }
        }
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onCallJSBFinished(Map<String, ? extends Object> jsbTiming) {
        CommonEvent commonEvent = new CommonEvent(ReportConst.Event.JSB_PER_V2);
        commonEvent.onEventCreated();
        if (jsbTiming == null) {
            commonEvent.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);
            return;
        }
        commonEvent.setNativeInfo(new LynxViewMonitor.EventNativeInfo(ReportConst.Event.JSB_PER_V2, new JSONObject(jsbTiming)));
        if (commonEvent.terminateIf(Switches.lynxJsb.not(), HybridEvent.TerminateType.SWITCH_OFF)) {
            return;
        }
        onEventPost(commonEvent);
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onJSBInvoked(Map<String, ? extends Object> jsbInfo) {
        CommonEvent commonEvent = new CommonEvent(ReportConst.Event.JSB_PAGE_VISIT);
        commonEvent.onEventCreated();
        if (jsbInfo == null) {
            commonEvent.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);
            return;
        }
        commonEvent.setNativeInfo(new LynxViewMonitor.EventNativeInfo(ReportConst.Event.JSB_PAGE_VISIT, new JSONObject(jsbInfo)));
        if (commonEvent.terminateIf(Switches.lynxJsb.not(), HybridEvent.TerminateType.SWITCH_OFF)) {
            return;
        }
        onEventPost(commonEvent);
    }

    public final void invokeBlankDetect(LynxBlankDetect.OnLynxBlankCallback callback, String detectFrom) {
        Object obj;
        Intrinsics.checkNotNullParameter(detectFrom, "detectFrom");
        if (this.isBlankDetected) {
            LynxView hostView = getHostView();
            if (hostView != null) {
                if (callback != null) {
                    callback.onDetectCost((View) hostView, "0", 0L, 0L);
                }
                if (callback != null) {
                    callback.onDetectResult((View) hostView, "0", 0.0f);
                    return;
                }
                return;
            }
            return;
        }
        this.isBlankDetected = true;
        try {
            Result.Companion companion = Result.Companion;
            new BlankCheckTask(this).start(callback, detectFrom);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            ExceptionUtil.handleException(th2);
        }
    }

    public final void reportBlank(CommonEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        MonitorLog.m29i(LynxViewMonitor.TAG, "reportBlank: " + this.templateUrl + ", view: " + getHostView());
        BaseNativeInfo nativeInfo = event.getNativeInfo();
        LynxBlankData lynxBlankData = nativeInfo instanceof LynxBlankData ? (LynxBlankData) nativeInfo : null;
        if (lynxBlankData != null) {
            lynxBlankData.setEngineInfo(this.engineInfo);
            int i = 0;
            if (!lynxBlankData.getValidChildNode() && ((lynxBlankData.getMaxBlankRectRadio() >= 0.8d && lynxBlankData.getEffectivePercentage() < 0.05d && lynxBlankData.getWidth() * lynxBlankData.getHeight() * lynxBlankData.getEffectivePercentage() < BdTuring.VERIFY_FAIL_IDENTITY_VERIFY) || ((lynxBlankData.getMaxBlankRectRadio() >= 0.5d && lynxBlankData.getEffectivePercentage() < 0.01d && lynxBlankData.getWidth() * lynxBlankData.getHeight() * lynxBlankData.getEffectivePercentage() < TicketGuardEventHelper.ERROR_CODE_SIGN_EMPTY_CERT) || lynxBlankData.getEffectivePercentage() < 0.05d))) {
                i = 1;
            }
            this.lynxViewDataManager.getCommonProps().addContext("is_blank", Integer.valueOf(i));
            this.lynxViewDataManager.getCommonProps().addContext("blank_detect_from", lynxBlankData.getDetectFrom());
        }
        this.dataHandler.postEvent(event);
    }

    private final void updatePerf(LynxPerfData lynxPerfData) {
        Map<String, Object> timingInfo = this.performance.getTimingInfo();
        this.performance = lynxPerfData;
        lynxPerfData.setTimingInfo(timingInfo);
    }

    private final void tryToUploadPerf() {
        boolean z = this.onRuntimeReadyEnd && this.onFirstScreenEnd;
        if (!LynxProxy.INSTANCE.getOnTimingSetupMethod().exist()) {
            if (z && this.onFirstLoadPerfEnd) {
                postPerfEvent();
                this.dataHandler.notifyAllEvents();
                return;
            }
            return;
        }
        if (z && this.onTimingSetupEnd) {
            this.dataHandler.notifyAllEvents();
        }
    }

    private final void updatePerfEvent() {
        this.performance.setLifecycle(this.lifecycle);
        this.performanceMix.setNativePerformance(this.performance);
        getPerformanceEvent().setNativeInfo(this.performanceMix);
        getPerformanceEvent().setNativeBase(this.lynxViewDataManager.getCommonProps());
        getPerformanceEvent().setContainerInfo(new ContainerInfo((Map<String, ? extends Object>) this.containerVariablesRef.getVariables()));
        getPerformanceEvent().setContainerBase(new ContainerBase((Map<String, ? extends Object>) this.containerVariablesRef.getVariablesBase()));
        getPerformanceEvent().onEventUpdated();
    }

    private final void checkActualFmp(Map<String, Object> timingInfo) {
        boolean z;
        if (timingInfo != null) {
            Object obj = timingInfo.get(LynxViewMonitorConstant.UPDATE_TIMINGS);
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
                if (Intrinsics.areEqual(this.lynxViewDataManager.getViewConf().getPerfReportTime(), LynxViewMonitorConstant.PERF_READY)) {
                    postPerfEvent();
                    this.dataHandler.notifyAllEvents();
                }
                this.engineInfo.setStage(4);
            }
        }
    }

    private final void postPerfEvent() {
        MonitorLog.m29i(LynxViewMonitor.TAG, "reportPerf: " + this.templateUrl + ", view: " + getHostView());
        if (Switches.lynxPerf.not()) {
            getPerformanceEvent().onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
            return;
        }
        if (this.isPerfEventUploaded) {
            getPerformanceEvent().onEventTerminated(HybridEvent.TerminateType.EVENT_REPEATED);
        } else {
            this.isPerfEventUploaded = true;
            handlePerfMix(false);
            this.dataHandler.postEvent(getPerformanceEvent());
        }
        View hostView = getHostView();
        if (hostView != null) {
            for (Map.Entry<String, Object> entry : ContainerDataCache.INSTANCE.getContainerInfoByView(hostView).toSingleMap().entrySet()) {
                if (entry.getValue() instanceof Long) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Long");
                    long j = 1000;
                    TraceEvent.instant(0L, key, ((((Long) value).longValue() * j) * j) - LynxViewMonitor.INSTANCE.getJVM_DIFF());
                }
            }
        }
    }

    private final void handlePerfMix(boolean isCallback) {
        Function1<? super JSONObject, Unit> function1;
        Object obj;
        String obj2;
        Object obj3;
        String obj4;
        BaseNativeInfo nativeInfo = getPerformanceEvent().getNativeInfo();
        PerfMixData perfMixData = nativeInfo instanceof PerfMixData ? (PerfMixData) nativeInfo : null;
        BaseNativeInfo nativePerformance = perfMixData != null ? perfMixData.getNativePerformance() : null;
        LynxPerfData lynxPerfData = nativePerformance instanceof LynxPerfData ? (LynxPerfData) nativePerformance : null;
        Map<String, Object> timingInfo = lynxPerfData != null ? lynxPerfData.getTimingInfo() : null;
        Object obj5 = timingInfo != null ? timingInfo.get(LynxViewMonitorConstant.SETUP_TIMING) : null;
        Map map = obj5 instanceof Map ? (Map) obj5 : null;
        long parseLong = (map == null || (obj3 = map.get("draw_end")) == null || (obj4 = obj3.toString()) == null) ? 0L : Long.parseLong(obj4);
        Object obj6 = timingInfo != null ? timingInfo.get(LynxViewMonitorConstant.UPDATE_TIMINGS) : null;
        Map map2 = obj6 instanceof Map ? (Map) obj6 : null;
        Object obj7 = map2 != null ? map2.get("__lynx_timing_actual_fmp") : null;
        Map map3 = obj7 instanceof Map ? (Map) obj7 : null;
        long parseLong2 = (map3 == null || (obj = map3.get("draw_end")) == null || (obj2 = obj.toString()) == null) ? 0L : Long.parseLong(obj2);
        this.actualFmpEnd = parseLong2;
        long max = Math.max(parseLong, parseLong2);
        this.fmpEnd = max;
        if (max > 0) {
            this.performanceMixHandler.stop(max, this.performanceMix.getMixPerformance(), "lynx");
            if (isCallback) {
                int i = this.waitCompleteData;
                if (((i != 1 || this.fmpEnd <= 0) && (i != 2 || this.actualFmpEnd <= 0)) || (function1 = this.performanceCallback) == null) {
                    return;
                }
                function1.invoke(createPerformanceResult());
            }
        }
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onEventPost(HybridEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.dataHandler.postEvent(event);
        this.engineInfo.update(event);
        if (event instanceof CommonEvent) {
            this.performanceMixHandler.capture((CommonEvent) event);
        }
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onAttachedToView() {
        View hostView = getHostView();
        if (hostView != null) {
            ContainerDataCache.INSTANCE.getAttachedMonitorIdAsync(hostView, this);
        }
    }

    @Override // com.bytedance.android.monitorV2.standard.ContainerDataCache.IdQueryCallback
    public void onIdQueryFinished(String monitorId) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        this.monitorId = monitorId;
        this.containerVariablesRef = new ContainerVariablesRef(monitorId);
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onPageStart(final String url) {
        LynxView hostView = getHostView();
        if (hostView == null) {
            return;
        }
        MonitorLog.m29i(LynxViewMonitor.TAG, "onPageStart: " + url + ", view: " + getHostView());
        this.performance.setLifecycle(this.lifecycle);
        this.templateUrl = hostView.getTemplateUrl();
        this.lifecycle.setLoadStart(System.currentTimeMillis());
        LynxLifecycleData lynxLifecycleData = this.lifecycle;
        lynxLifecycleData.setShowStart(lynxLifecycleData.getLoadStart());
        this.lifecycle.setLoadState(LynxLifecycleData.INSTANCE.getSTATE_LOADING());
        this.engineInfo.setStage(1);
        CommonEvent commonEvent = this.preCreatePvEvent;
        if (commonEvent == null) {
            commonEvent = CommonEvent.INSTANCE.create("navigationStart", new PvData(), new Function1<CommonEvent, Unit>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxViewNavigationDataManager$onPageStart$pvEvent$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((CommonEvent) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(CommonEvent commonEvent2) {
                    Intrinsics.checkNotNullParameter(commonEvent2, "it");
                    commonEvent2.getNativeBase().url = url;
                    commonEvent2.getNativeBase().containerType = "lynx";
                }
            });
        }
        this.dataHandler.postEvent(commonEvent);
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onLoadSuccess() {
        MonitorLog.m29i(LynxViewMonitor.TAG, "onLoadSuccess: " + this.templateUrl + ", view: " + getHostView());
        this.lifecycle.setLoadFinish(System.currentTimeMillis());
        this.engineInfo.setStage(3);
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onDestroy() {
        MonitorLog.m29i(LynxViewMonitor.TAG, "onDestroy: " + this.templateUrl + ", view: " + getHostView());
        this.lifecycle.setShowEnd(System.currentTimeMillis());
        if (!this.isPerfEventUploaded) {
            if (!this.isPerfEventLynxStateSet) {
                if (this.lynxViewDataManager.getViewAttached() && this.lynxViewDataManager.getViewVisible()) {
                    this.performance.setLynxState(2);
                } else {
                    this.performance.setLynxState(3);
                }
            }
            this.performance.setLifecycle(this.lifecycle);
            updatePerfEvent();
            postPerfEvent();
            this.dataHandler.notifyAllEvents();
        }
        this.performanceCallback = null;
        InternalWatcher.notice$default(InternalWatcher.INSTANCE, getNaviId(), InternalWatcher.EVENT_BLANK_CHECK, null, null, 12, null);
        invokeBlankDetect(null, "monitor");
    }

    public final void getPerformance(int waitCompleteData, Function1<? super JSONObject, Unit> performanceCallback) {
        Intrinsics.checkNotNullParameter(performanceCallback, "performanceCallback");
        if (waitCompleteData == 0 || (((waitCompleteData == 1 && this.fmpEnd > 0) || (waitCompleteData == 2 && this.actualFmpEnd > 0)) && !this.performanceMixHandler.getWork().get())) {
            performanceCallback.invoke(createPerformanceResult());
        } else {
            this.waitCompleteData = waitCompleteData;
            this.performanceCallback = performanceCallback;
        }
    }

    private final JSONObject createPerformanceResult() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("nativeBase", getPerformanceEvent().getNativeBase().toJsonObject());
        BaseNativeInfo nativeInfo = getPerformanceEvent().getNativeInfo();
        jSONObject.put("nativeInfo", nativeInfo != null ? nativeInfo.toJsonObject() : null);
        jSONObject.put("jsInfo", getPerformanceEvent().getJsInfo());
        jSONObject.put("jsBase", getPerformanceEvent().getJsBase());
        ContainerInfo containerInfo = getPerformanceEvent().getContainerInfo();
        jSONObject.put("containerInfo", containerInfo != null ? containerInfo.toJsonObject() : null);
        ContainerBase containerBase = getPerformanceEvent().getContainerBase();
        jSONObject.put("containerBase", containerBase != null ? containerBase.toJsonObject() : null);
        return jSONObject;
    }

    /* renamed from: getUnifyInfo, reason: from getter */
    public final EngineInfo getEngineInfo() {
        return this.engineInfo;
    }

    public final void updateUnifyError(CommonEvent event, int code, String message) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(message, "message");
        this.engineInfo.updateRawError(event, code, message);
    }
}

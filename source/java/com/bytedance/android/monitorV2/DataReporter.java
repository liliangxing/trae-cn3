package com.bytedance.android.monitorV2;

import android.text.TextUtils;
import com.bytedance.android.monitorV2.checker.ApmReportChecker;
import com.bytedance.android.monitorV2.checker.DoubleReportChecker;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.dataprocessor.IDataHandler;
import com.bytedance.android.monitorV2.dataprocessor.TypedDataDispatcher;
import com.bytedance.android.monitorV2.dedupcheck.DataDeduplicationManager;
import com.bytedance.android.monitorV2.event.CommonEvent;
import com.bytedance.android.monitorV2.event.CustomEvent;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.experiment.HostExperimentManager;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.util.AbsBidFinder;
import com.bytedance.android.monitorV2.util.ConvertUtil;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.HybridBidFinder;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.android.monitorV2.util.ReportDataUtils;
import com.bytedance.android.monitorV2.webview.HybridMonitorDefault;
import com.bytedance.android.monitorV2.webview.IHybridMonitor;
import com.bytedance.ies.argus.bean.ArgusConstants;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DataReporter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001:B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014J6\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u0018\u0010!\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\"\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0006H\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010&\u001a\u00020\u0006H\u0002J\u0018\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J\u0012\u0010,\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010-H\u0002J<\u0010.\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007J+\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020-2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0002\u00102J\u001a\u00103\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020-2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J!\u00104\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u00101\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0002\u00105J\u0010\u00106\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J(\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006;"}, d2 = {"Lcom/bytedance/android/monitorV2/DataReporter;", "", "()V", "PIA_TEA_REPORTING_PROTOCOL_VERSION", "", "TAG", "", "dataDeduplicationManager", "Lcom/bytedance/android/monitorV2/dedupcheck/DataDeduplicationManager;", "enableDedup", "", "sIncIdMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/atomic/AtomicLong;", "typedDataDispatcher", "Lcom/bytedance/android/monitorV2/dataprocessor/TypedDataDispatcher;", "getTypedDataDispatcher", "()Lcom/bytedance/android/monitorV2/dataprocessor/TypedDataDispatcher;", "checkAllEventSample", "customEvent", "Lcom/bytedance/android/monitorV2/event/CustomEvent;", "checkCanSample", "checkEventSample", "dedupMonitor", "", "monitor", "Lcom/bytedance/android/monitorV2/webview/IHybridMonitor;", "jsonObj", "Lorg/json/JSONObject;", "eventType", "containerType", "event", "Lcom/bytedance/android/monitorV2/event/HybridEvent;", "doubleReport", "extractBid", "getIncId", "bid", "getShortMsg", "msg", "hitSample", "data", "bidConfig", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfo$BidConfig;", "isInALogFilter", "isUnsampledEvent4Tea", "Lcom/bytedance/android/monitorV2/event/CommonEvent;", "realMonitor", "reportCommonEvent", "commonEvent", "async", "(Lcom/bytedance/android/monitorV2/event/CommonEvent;Lcom/bytedance/android/monitorV2/webview/IHybridMonitor;Ljava/lang/Boolean;)V", "reportCommonEventInner", "reportCustomEvent", "(Lcom/bytedance/android/monitorV2/event/CustomEvent;Ljava/lang/Boolean;)V", "reportCustomEventInner", "upload", "serviceName", "result", "ReportDataHandler", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class DataReporter {
    public static final DataReporter INSTANCE = new DataReporter();
    public static final int PIA_TEA_REPORTING_PROTOCOL_VERSION = 1;
    private static final String TAG = "DataReporter";
    private static DataDeduplicationManager dataDeduplicationManager = null;
    private static final boolean enableDedup = true;
    private static final ConcurrentHashMap<String, AtomicLong> sIncIdMap;
    private static final TypedDataDispatcher typedDataDispatcher;

    public final void realMonitor(IHybridMonitor iHybridMonitor, JSONObject jSONObject, String str, String str2) {
        realMonitor$default(this, iHybridMonitor, jSONObject, str, str2, null, 16, null);
    }

    public final void reportCommonEvent(CommonEvent commonEvent, IHybridMonitor iHybridMonitor) {
        Intrinsics.checkNotNullParameter(commonEvent, "commonEvent");
        reportCommonEvent$default(this, commonEvent, iHybridMonitor, null, 4, null);
    }

    public final void reportCustomEvent(CustomEvent customEvent) {
        Intrinsics.checkNotNullParameter(customEvent, "customEvent");
        reportCustomEvent$default(this, customEvent, null, 2, null);
    }

    private DataReporter() {
    }

    static {
        TypedDataDispatcher typedDataDispatcher2 = new TypedDataDispatcher();
        typedDataDispatcher = typedDataDispatcher2;
        dataDeduplicationManager = new DataDeduplicationManager();
        sIncIdMap = new ConcurrentHashMap<>();
        typedDataDispatcher2.setDataHandler(TypedDataDispatcher.DataType.REPORT_DATA, new ReportDataHandler());
    }

    public final TypedDataDispatcher getTypedDataDispatcher() {
        return typedDataDispatcher;
    }

    private final boolean hitSample(Object data, BidInfo.BidConfig bidConfig) {
        if (data instanceof CommonEvent) {
            CommonEvent commonEvent = (CommonEvent) data;
            String str = commonEvent.getNativeBase().containerType;
            if (Intrinsics.areEqual(str, "web")) {
                return ConvertUtil.isReportForWebSample(commonEvent.getEventType(), bidConfig);
            }
            if (Intrinsics.areEqual(str, "lynx")) {
                return ConvertUtil.isSampleForLynx(commonEvent.getEventType(), bidConfig);
            }
            return ConvertUtil.isSampleForContainer(commonEvent.getEventType(), bidConfig);
        }
        if (data instanceof CustomEvent) {
            return checkEventSample((CustomEvent) data);
        }
        return false;
    }

    private final String extractBid(String eventType, JSONObject jsonObj) {
        if (!Intrinsics.areEqual("custom", eventType)) {
            try {
                String string = jsonObj.getJSONObject("nativeBase").getJSONObject(ReportConst.Params.BID_INFO).getString(ReportConst.Params.SETTING_BID);
                Intrinsics.checkNotNullExpressionValue(string, "jsonObj.getJSONObject(Re…Const.Params.SETTING_BID)");
                return string;
            } catch (JSONException e) {
                ExceptionUtil.handleException(e);
            }
        } else {
            try {
                String string2 = jsonObj.getJSONObject(ReportConst.Params.BID_INFO).getString(ReportConst.Params.SETTING_BID);
                Intrinsics.checkNotNullExpressionValue(string2, "jsonObj.getJSONObject(Re…Const.Params.SETTING_BID)");
                return string2;
            } catch (JSONException e2) {
                ExceptionUtil.handleException(e2);
            }
        }
        return "";
    }

    private final AtomicLong getIncId(String bid) {
        ConcurrentHashMap<String, AtomicLong> concurrentHashMap = sIncIdMap;
        AtomicLong atomicLong = concurrentHashMap.get(bid);
        if (atomicLong != null) {
            return atomicLong;
        }
        AtomicLong atomicLong2 = new AtomicLong();
        concurrentHashMap.put(bid, atomicLong2);
        return atomicLong2;
    }

    private final void doubleReport(String eventType, JSONObject jsonObj) {
        DoubleReportChecker.INSTANCE.reportSampleCaseBeforeSend(eventType, extractBid(eventType, jsonObj));
    }

    private final String getShortMsg(String msg) {
        if (msg.length() <= 500) {
            return msg;
        }
        if (msg == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = msg.substring(0, 500);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    private final boolean isInALogFilter(String eventType) {
        return Intrinsics.areEqual("jsbPerf", eventType) || Intrinsics.areEqual(ReportConst.Event.JSB_PER_V2, eventType) || Intrinsics.areEqual("custom", eventType);
    }

    public static /* synthetic */ void realMonitor$default(DataReporter dataReporter, IHybridMonitor iHybridMonitor, JSONObject jSONObject, String str, String str2, HybridEvent hybridEvent, int i, Object obj) {
        if ((i & 16) != 0) {
            hybridEvent = null;
        }
        dataReporter.realMonitor(iHybridMonitor, jSONObject, str, str2, hybridEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0066 A[Catch: all -> 0x00a7, TryCatch #1 {all -> 0x00a7, blocks: (B:16:0x0050, B:18:0x0066, B:20:0x006f, B:22:0x0077, B:24:0x009f), top: B:15:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0041 A[Catch: all -> 0x0045, TRY_LEAVE, TryCatch #0 {all -> 0x0045, blocks: (B:32:0x0022, B:34:0x0026, B:9:0x0041, B:7:0x003b), top: B:31:0x0022 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void realMonitor(IHybridMonitor monitor, JSONObject jsonObj, String eventType, String containerType, HybridEvent event) {
        String str;
        if (jsonObj == null || eventType == null || containerType == null) {
            if (event != null) {
                event.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);
                return;
            }
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JsonUtils.safePut(jSONObject, "extra", jsonObj);
        doubleReport(eventType, jsonObj);
        String str2 = "bd_hybrid_monitor_service_all_in_one";
        try {
            if (monitor != null) {
                try {
                } catch (Throwable th) {
                    if (event != null) {
                        event.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
                    }
                    ExceptionUtil.handleException(th);
                }
                if (!(monitor instanceof HybridMonitorDefault)) {
                    MonitorLog.m29i(TAG, "use another " + monitor);
                    monitor.monitorStatusAndDuration("bd_hybrid_monitor_service_all_in_one", 0, null, jSONObject);
                    if (event != null) {
                        event.onEventUploaded();
                    }
                    MonitorLog.m29i(TAG, "upload " + eventType);
                    if (!isInALogFilter(eventType)) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        Object[] objArr = new Object[4];
                        if (event == null || (str = event.getFullLinkId()) == null) {
                            str = ArgusConstants.NULL_PLACE_HOLDER;
                        }
                        objArr[0] = str;
                        objArr[1] = eventType;
                        objArr[2] = containerType;
                        String jSONObject2 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "result.toString()");
                        objArr[3] = getShortMsg(jSONObject2);
                        String format = String.format("report: session: %s event: %s container: %s data: %s", Arrays.copyOf(objArr, 4));
                        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                        MonitorLog.m29i(TAG, format);
                    }
                    HybridMultiMonitor.getInstance().notifyReportInterceptor(str2, eventType, containerType, jSONObject);
                    return;
                }
            }
            MonitorLog.m29i(TAG, "upload " + eventType);
            if (!isInALogFilter(eventType)) {
            }
            HybridMultiMonitor.getInstance().notifyReportInterceptor(str2, eventType, containerType, jSONObject);
            return;
        } catch (Throwable th2) {
            ExceptionUtil.handleException(th2);
            return;
        }
        str2 = upload("bd_hybrid_monitor_service_all_in_one", eventType, containerType, jSONObject);
        if (event != null) {
        }
    }

    private final String upload(String serviceName, String eventType, String containerType, JSONObject result) {
        return ApmReportChecker.INSTANCE.upload(serviceName, eventType, containerType, result);
    }

    static /* synthetic */ void dedupMonitor$default(DataReporter dataReporter, IHybridMonitor iHybridMonitor, JSONObject jSONObject, String str, String str2, HybridEvent hybridEvent, int i, Object obj) {
        if ((i & 16) != 0) {
            hybridEvent = null;
        }
        dataReporter.dedupMonitor(iHybridMonitor, jSONObject, str, str2, hybridEvent);
    }

    private final void dedupMonitor(IHybridMonitor monitor, JSONObject jsonObj, String eventType, String containerType, HybridEvent event) {
        dataDeduplicationManager.postData(monitor, jsonObj, eventType, containerType, event);
    }

    public static /* synthetic */ void reportCommonEvent$default(DataReporter dataReporter, CommonEvent commonEvent, IHybridMonitor iHybridMonitor, Boolean bool, int i, Object obj) {
        if ((i & 4) != 0) {
            bool = true;
        }
        dataReporter.reportCommonEvent(commonEvent, iHybridMonitor, bool);
    }

    public final void reportCommonEvent(final CommonEvent commonEvent, IHybridMonitor monitor, Boolean async) {
        Intrinsics.checkNotNullParameter(commonEvent, "commonEvent");
        if (HostExperimentManager.INSTANCE.getEnablePreSample() && !commonEvent.getHitSample()) {
            HybridBidFinder.INSTANCE.findBid(commonEvent, true, new Function1<AbsBidFinder.BidMatchResult, Unit>() { // from class: com.bytedance.android.monitorV2.DataReporter$reportCommonEvent$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((AbsBidFinder.BidMatchResult) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(AbsBidFinder.BidMatchResult bidMatchResult) {
                    Intrinsics.checkNotNullParameter(bidMatchResult, "matchResult");
                    String bid = bidMatchResult.getBid();
                    String source = bidMatchResult.getSource();
                    if (StringsKt.isBlank(bid)) {
                        bid = BidInfo.DEFAULT;
                        Intrinsics.checkNotNullExpressionValue(bid, "DEFAULT");
                        source = "default_bid";
                    }
                    CommonEvent.this.setBid(bid);
                    CommonEvent.this.getNativeBase().addContext(ReportConst.BidSourceInfo.BID_SOURCE, source);
                    if (ConvertUtil.isSampleForContainer(CommonEvent.this.getEventType(), ReportDataUtils.INSTANCE.determineBidConfig(bid))) {
                        CommonEvent.this.setHitSample(true);
                        DataReporter.INSTANCE.getTypedDataDispatcher().enqueue(TypedDataDispatcher.DataType.REPORT_DATA, new Pair(CommonEvent.this, (Object) null), false);
                    } else {
                        CommonEvent.this.onEventSampled();
                    }
                }
            });
        } else {
            typedDataDispatcher.enqueue(TypedDataDispatcher.DataType.REPORT_DATA, new Pair(commonEvent, monitor), async != null ? async.booleanValue() : true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportCommonEventInner(CommonEvent event, IHybridMonitor monitor) {
        try {
            MonitorLog.m29i(TAG, "reportCommonEventInner: " + event.getNativeBase().containerType + ", " + event.getEventType());
            if (HostExperimentManager.INSTANCE.getEnablePreSample() && event.getPreSample()) {
                ReportDataUtils.INSTANCE.parseRegexPid(event);
                JSONObject commonEventToJsonObj = ReportDataUtils.INSTANCE.commonEventToJsonObj(event);
                String str = event.getNativeBase().containerType;
                dedupMonitor(monitor, commonEventToJsonObj, event.getEventType(), str == null ? "" : str, event);
                return;
            }
            ReportDataUtils.INSTANCE.parseRegexField$anniex_release(event);
            String determineBid = ReportDataUtils.INSTANCE.determineBid(event);
            BidInfo.BidConfig determineBidConfig = ReportDataUtils.INSTANCE.determineBidConfig(determineBid);
            if (isUnsampledEvent4Tea(event)) {
                DoubleReportChecker doubleReportChecker = DoubleReportChecker.INSTANCE;
                String str2 = determineBidConfig.bid;
                Intrinsics.checkNotNullExpressionValue(str2, "bidConfig.bid");
                doubleReportChecker.reportJsbPvV2(event, str2);
                return;
            }
            boolean hitSample = hitSample(event, determineBidConfig);
            DoubleReportChecker doubleReportChecker2 = DoubleReportChecker.INSTANCE;
            String str3 = determineBidConfig.bid;
            Intrinsics.checkNotNullExpressionValue(str3, "bidConfig.bid");
            doubleReportChecker2.reportAllCase("custom", str3);
            DoubleReportChecker.INSTANCE.reportPvEventCase(event, determineBid, hitSample);
            if (!hitSample) {
                event.onEventSampled();
                return;
            }
            DoubleReportChecker doubleReportChecker3 = DoubleReportChecker.INSTANCE;
            String eventType = event.getEventType();
            String str4 = determineBidConfig.bid;
            Intrinsics.checkNotNullExpressionValue(str4, "bidConfig.bid");
            doubleReportChecker3.reportSampleCase(eventType, str4);
            JSONObject commonEventToJsonObj2 = ReportDataUtils.INSTANCE.commonEventToJsonObj(event);
            AtomicLong incId = getIncId(determineBid);
            JSONObject jSONObject = new JSONObject();
            JsonUtils.safePut(jSONObject, "uuid", UUID.randomUUID().toString());
            JsonUtils.safePut(jSONObject, ReportConst.Params.INC_ID, incId.incrementAndGet());
            JsonUtils.safePut(jSONObject, ReportConst.ValidationReport.TRACE_ID, event.getEventId());
            JsonUtils.safePut(commonEventToJsonObj2, ReportConst.Params.DEBUG_LOG, jSONObject);
            String str5 = event.getNativeBase().containerType;
            dedupMonitor(monitor, commonEventToJsonObj2, event.getEventType(), str5 == null ? "" : str5, event);
        } catch (Throwable th) {
            event.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
            ExceptionUtil.handleException(th);
        }
    }

    private final boolean isUnsampledEvent4Tea(CommonEvent event) {
        return Intrinsics.areEqual(event != null ? event.getEventType() : null, ReportConst.Event.JSB_PAGE_VISIT);
    }

    public static /* synthetic */ void reportCustomEvent$default(DataReporter dataReporter, CustomEvent customEvent, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            bool = true;
        }
        dataReporter.reportCustomEvent(customEvent, bool);
    }

    public final void reportCustomEvent(final CustomEvent customEvent, Boolean async) {
        Intrinsics.checkNotNullParameter(customEvent, "customEvent");
        if (HostExperimentManager.INSTANCE.getEnablePreSample() && !customEvent.getHitSample()) {
            if (customEvent.getCustomInfo().getEventName() == null) {
                return;
            }
            HybridBidFinder.INSTANCE.findBid(customEvent, true, new Function1<AbsBidFinder.BidMatchResult, Unit>() { // from class: com.bytedance.android.monitorV2.DataReporter$reportCustomEvent$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((AbsBidFinder.BidMatchResult) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(AbsBidFinder.BidMatchResult bidMatchResult) {
                    Intrinsics.checkNotNullParameter(bidMatchResult, "matchResult");
                    String bid = bidMatchResult.getBid();
                    String source = bidMatchResult.getSource();
                    CustomEvent.this.setBid(bid);
                    CustomEvent.this.getNativeBase().addContext(ReportConst.BidSourceInfo.BID_SOURCE, source);
                    if (DataReporter.INSTANCE.checkEventSample(CustomEvent.this)) {
                        CustomEvent.this.setHitSample(true);
                        DataReporter.INSTANCE.getTypedDataDispatcher().enqueue(TypedDataDispatcher.DataType.REPORT_DATA, new Pair(CustomEvent.this, (Object) null), false);
                    } else {
                        CustomEvent.this.onEventSampled();
                    }
                }
            });
            return;
        }
        typedDataDispatcher.enqueue(TypedDataDispatcher.DataType.REPORT_DATA, new Pair(customEvent, (Object) null), async != null ? async.booleanValue() : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportCustomEventInner(CustomEvent customEvent) {
        try {
            MonitorLog.m29i(TAG, "monitorCustom: " + customEvent.getCustomInfo());
            if (HostExperimentManager.INSTANCE.getEnablePreSample() && customEvent.getPreSample()) {
                ReportDataUtils.INSTANCE.parseRegexPid(customEvent);
                dedupMonitor(customEvent.getCustomInfo().getMonitor(), ReportDataUtils.INSTANCE.customEventToJsonObj(customEvent), "custom", "", customEvent);
                return;
            }
            ReportDataUtils.INSTANCE.parseRegexField$anniex_release(customEvent);
            String determineBid = ReportDataUtils.INSTANCE.determineBid(customEvent);
            JSONObject customEventToJsonObj = ReportDataUtils.INSTANCE.customEventToJsonObj(customEvent);
            customEvent.getCustomInfo().setBid(determineBid);
            customEvent.setBid(determineBid);
            BidInfo.BidConfig determineBidConfig = ReportDataUtils.INSTANCE.determineBidConfig(determineBid);
            DoubleReportChecker doubleReportChecker = DoubleReportChecker.INSTANCE;
            String str = determineBidConfig.bid;
            Intrinsics.checkNotNullExpressionValue(str, "bidConfig.bid");
            doubleReportChecker.reportAllCase("custom", str);
            if (!hitSample(customEvent, determineBidConfig)) {
                customEvent.onEventSampled();
                return;
            }
            DoubleReportChecker doubleReportChecker2 = DoubleReportChecker.INSTANCE;
            String str2 = determineBidConfig.bid;
            Intrinsics.checkNotNullExpressionValue(str2, "bidConfig.bid");
            doubleReportChecker2.reportSampleCase("custom", str2);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("do report bid: %s, event: %s", Arrays.copyOf(new Object[]{customEvent.getCustomInfo().getBid(), customEvent.getCustomInfo().getEventName()}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            MonitorLog.m29i(TAG, format);
            AtomicLong incId = getIncId(determineBid);
            JSONObject jSONObject = new JSONObject();
            JsonUtils.safePut(jSONObject, "uuid", UUID.randomUUID().toString());
            JsonUtils.safePut(jSONObject, ReportConst.Params.INC_ID, incId.incrementAndGet());
            JsonUtils.safePut(jSONObject, ReportConst.ValidationReport.TRACE_ID, customEvent.getEventId());
            JsonUtils.safePut(customEventToJsonObj, ReportConst.Params.DEBUG_LOG, jSONObject);
            dedupMonitor(customEvent.getCustomInfo().getMonitor(), customEventToJsonObj, "custom", "", customEvent);
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
            MonitorLog.m27e(TAG, "monitorCustom error: " + th.getMessage());
        }
    }

    public final boolean checkEventSample(CustomEvent customEvent) {
        Intrinsics.checkNotNullParameter(customEvent, "customEvent");
        String bid = customEvent.getBid();
        String eventName = customEvent.getCustomInfo().getEventName();
        if (TextUtils.isEmpty(eventName)) {
            return false;
        }
        if (ConvertUtil.isSampleForEventName(bid, eventName) == 1) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("bid: %s, event: %s, sample hit", Arrays.copyOf(new Object[]{bid, eventName}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            MonitorLog.m29i(TAG, format);
            return true;
        }
        if (ConvertUtil.isSampleForEventName(bid, eventName) == 0) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("bid: %s, event: %s, sample not hit", Arrays.copyOf(new Object[]{bid, eventName}, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
            MonitorLog.m29i(TAG, format2);
            return false;
        }
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String format3 = String.format("bid: %s, event: %s, sample not found, checking all...", Arrays.copyOf(new Object[]{bid, eventName}, 2));
        Intrinsics.checkNotNullExpressionValue(format3, "java.lang.String.format(format, *args)");
        MonitorLog.m29i(TAG, format3);
        return checkAllEventSample(customEvent);
    }

    private final boolean checkAllEventSample(CustomEvent customEvent) {
        String eventName = customEvent.getCustomInfo().getEventName();
        if (TextUtils.isEmpty(eventName)) {
            return false;
        }
        if (ConvertUtil.isSampleForAllEventName(eventName) == 1) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("event: %s, sample hit", Arrays.copyOf(new Object[]{eventName}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            MonitorLog.m29i(TAG, format);
            return true;
        }
        if (ConvertUtil.isSampleForAllEventName(eventName) == 0) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("event: %s, sample not hit", Arrays.copyOf(new Object[]{eventName}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
            MonitorLog.m29i(TAG, format2);
            return false;
        }
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String format3 = String.format("event: %s, sample not found, checking canSample level...", Arrays.copyOf(new Object[]{eventName}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "java.lang.String.format(format, *args)");
        MonitorLog.m29i(TAG, format3);
        return checkCanSample(customEvent);
    }

    private final boolean checkCanSample(CustomEvent customEvent) {
        BidInfo bidInfo = HybridMultiMonitor.getInstance().getHybridSettingManager().getBidInfo();
        Intrinsics.checkNotNullExpressionValue(bidInfo, "getInstance().hybridSettingManager.bidInfo");
        BidInfo.BidConfig bidConfig = bidInfo.get(customEvent.getBid());
        if (bidConfig == null) {
            return false;
        }
        return ConvertUtil.isSampleForCustom(bidConfig, customEvent.getCustomInfo().getCanSample());
    }

    /* compiled from: DataReporter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/monitorV2/DataReporter$ReportDataHandler;", "Lcom/bytedance/android/monitorV2/dataprocessor/IDataHandler;", "()V", "onDataDispatch", "", "data", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static final class ReportDataHandler implements IDataHandler {
        @Override // com.bytedance.android.monitorV2.dataprocessor.IDataHandler
        public void onDataDispatch(Object data) {
            Object obj;
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                Result.Companion companion = Result.Companion;
                if (data instanceof Pair) {
                    Object first = ((Pair) data).getFirst();
                    if (first instanceof CommonEvent) {
                        DataReporter dataReporter = DataReporter.INSTANCE;
                        Object first2 = ((Pair) data).getFirst();
                        Intrinsics.checkNotNull(first2, "null cannot be cast to non-null type com.bytedance.android.monitorV2.event.CommonEvent");
                        CommonEvent commonEvent = (CommonEvent) first2;
                        Object second = ((Pair) data).getSecond();
                        dataReporter.reportCommonEventInner(commonEvent, second instanceof IHybridMonitor ? (IHybridMonitor) second : null);
                    } else if (first instanceof CustomEvent) {
                        DataReporter dataReporter2 = DataReporter.INSTANCE;
                        Object first3 = ((Pair) data).getFirst();
                        Intrinsics.checkNotNull(first3, "null cannot be cast to non-null type com.bytedance.android.monitorV2.event.CustomEvent");
                        dataReporter2.reportCustomEventInner((CustomEvent) first3);
                    }
                }
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
    }
}

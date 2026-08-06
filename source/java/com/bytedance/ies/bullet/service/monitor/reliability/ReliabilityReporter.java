package com.bytedance.ies.bullet.service.monitor.reliability;

import android.net.Uri;
import com.bytedance.android.monitorV2.entity.EngineInfo;
import com.bytedance.android.monitorV2.entity.UnifyErrorDomain;
import com.bytedance.android.monitorV2.standard.ContainerStandardApi;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletMonitorContext;
import com.bytedance.ies.bullet.core.BulletRLContext;
import com.bytedance.ies.bullet.core.kit.Fallback;
import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.api.BidConstants;
import com.bytedance.ies.bullet.service.base.api.IServiceCenter;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.ies.bullet.service.base.utils.BulletLoadUriIdentifier;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.ies.bullet.service.monitor.fluency.FluencyHelper;
import com.bytedance.ies.bullet.service.monitor.tracert.TracertUtils;
import com.bytedance.ies.bullet.service.monitor.utils.JsonUtilsKt;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.service.sdk.param.UrlParam;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.json.JSONObject;

/* compiled from: ReliabilityReporter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J'\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018J\u001e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\rJ\u0015\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u001dJ\u000e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010 \u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u001e\u0010 \u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0004J&\u0010$\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)J6\u0010$\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)2\u0006\u0010#\u001a\u00020\u0004J6\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0004J6\u0010$\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004J\u0015\u00101\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b2J\u0015\u00103\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b4J\u0016\u00105\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u00106\u001a\u00020\u0004J\u000e\u00107\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0014\u00108\u001a\u0004\u0018\u00010\u00042\b\u0010'\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010<\u001a\u00020=*\u00020=2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J$\u0010<\u001a\u00020=*\u00020=2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0004H\u0002J$\u0010>\u001a\u00020=*\u00020=2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/reliability/ReliabilityReporter;", "", "()V", "MONITOR_EVENT_BLANK_DETECT", "", "MONITOR_EVENT_CONTAINER_EXIT", "MONITOR_EVENT_END_TO_END", "MONITOR_EVENT_ERROR_CLICK", "MONITOR_EVENT_ERROR_SHOW", "MONITOR_EVENT_LOAD_URL", "lynxErrorCodeRegex", "Lkotlin/text/Regex;", "getStayDuration", "", "monitorContext", "Lcom/bytedance/ies/bullet/core/BulletMonitorContext;", "reportBlankDetected", "", "mContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "isBlank", "", "visiblePercent", "", "(Lcom/bytedance/ies/bullet/core/BulletContext;Ljava/lang/Integer;Ljava/lang/Float;)V", "reportContainerExit", "status", "startTime", "reportContainerInit", "reportContainerInit$anniex_release", "reportErrorViewClick", "reportErrorViewShow", "reportLoadCancel", "resourceContext", "Lcom/bytedance/ies/bullet/core/BulletRLContext;", "viewType", "reportLoadFail", "errStage", "Lcom/bytedance/ies/bullet/service/monitor/AbsBulletMonitorCallback$ErrStage;", "errMessage", "hasErrorView", "", "bid", "tracertId", "sdkType", "schema", "tracertCategory", "Lorg/json/JSONObject;", "tracertMetric", "reportLoadStart", "reportLoadStart$anniex_release", "reportLoadSuccess", "reportLoadSuccess$anniex_release", "reportSuccessStage", FluencyHelper.STAGE, "traceEndToEnd", "tryGetLynxErrorCode", "tryParseSchemaWithoutBid", "Landroid/net/Uri;", "rawSchema", "wrapperContextInfo", "Lcom/bytedance/ies/bullet/service/base/ReportInfo;", "wrapperErrorInfo", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ReliabilityReporter {
    private static final String MONITOR_EVENT_BLANK_DETECT = "bdx_monitor_blank_detect";
    private static final String MONITOR_EVENT_CONTAINER_EXIT = "bdx_monitor_container_exit";
    public static final String MONITOR_EVENT_END_TO_END = "bdx_monitor_end_to_end_trace";
    private static final String MONITOR_EVENT_ERROR_CLICK = "bdx_monitor_container_page_error_page_click";
    private static final String MONITOR_EVENT_ERROR_SHOW = "bdx_monitor_container_page_error_page_show";
    private static final String MONITOR_EVENT_LOAD_URL = "bdx_monitor_container_load_url";
    public static final ReliabilityReporter INSTANCE = new ReliabilityReporter();
    private static final Regex lynxErrorCodeRegex = new Regex("\"code\": ...,");

    private ReliabilityReporter() {
    }

    private final Uri tryParseSchemaWithoutBid(String rawSchema) {
        try {
            Uri parse = Uri.parse(rawSchema);
            String str = Intrinsics.areEqual(parse.getScheme(), "sslocal") ? BidConstants.LUCKY : "default_bid";
            SchemaService companion = SchemaService.INSTANCE.getInstance();
            Intrinsics.checkNotNullExpressionValue(parse, "rawUri");
            Uri value = new UrlParam(companion.generateSchemaData(str, parse), "url", null).getValue();
            return value == null ? parse : value;
        } catch (Exception unused) {
            Uri uri = Uri.EMPTY;
            Intrinsics.checkNotNullExpressionValue(uri, "{\n            Uri.EMPTY\n        }");
            return uri;
        }
    }

    public final void reportLoadStart$anniex_release(BulletContext mContext) {
        Uri uri;
        BulletLoadUriIdentifier bulletLoadUriIdentifier;
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        ReportInfo reportInfo = new ReportInfo(MONITOR_EVENT_LOAD_URL, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        if (mContext.getSchemaData() != null) {
            bulletLoadUriIdentifier = mContext.getUriIdentifier();
        } else {
            BulletLoadUriIdentifier uriIdentifier = mContext.getUriIdentifier();
            if (uriIdentifier == null || (uri = uriIdentifier.getUri()) == null) {
                uri = Uri.EMPTY;
            }
            Intrinsics.checkNotNullExpressionValue(uri, "mContext.uriIdentifier?.getRawUri()?: Uri.EMPTY");
            bulletLoadUriIdentifier = new BulletLoadUriIdentifier(uri);
        }
        reportInfo.setPageIdentifier(bulletLoadUriIdentifier);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(FluencyHelper.STAGE, mContext.getContainerContext().getIsReload() ? "reload_begin" : "start_load");
        jSONObject.put("view_type", mContext.getScene().getTag());
        reportInfo.setCategory(jSONObject);
        TracertUtils.INSTANCE.mergeTracertInfo(reportInfo, mContext.getMonitorContext());
        IServiceCenter instance = ServiceCenter.INSTANCE.instance();
        String bid = mContext.getBid();
        if (bid == null) {
            bid = "default_bid";
        }
        IMonitorReportService iMonitorReportService = (IMonitorReportService) instance.get(bid, IMonitorReportService.class);
        if (iMonitorReportService != null) {
            iMonitorReportService.report(reportInfo);
        }
    }

    public final void reportLoadSuccess$anniex_release(BulletContext mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        ReportInfo reportInfo = new ReportInfo(MONITOR_EVENT_LOAD_URL, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", "success");
        jSONObject.put(FluencyHelper.STAGE, mContext.getContainerContext().getIsReload() ? "reload_end" : MetricConstant.MONITOR_STAGE_LOAD_TEMPLATE);
        reportInfo.setCategory(jSONObject);
        INSTANCE.wrapperContextInfo(reportInfo, mContext);
        IServiceCenter instance = ServiceCenter.INSTANCE.instance();
        String bid = mContext.getBid();
        if (bid == null) {
            bid = "default_bid";
        }
        IMonitorReportService iMonitorReportService = (IMonitorReportService) instance.get(bid, IMonitorReportService.class);
        if (iMonitorReportService != null) {
            iMonitorReportService.report(reportInfo);
        }
    }

    public final void reportLoadFail(BulletContext mContext, AbsBulletMonitorCallback.ErrStage errStage, String errMessage, boolean hasErrorView) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(errStage, "errStage");
        Intrinsics.checkNotNullParameter(errMessage, "errMessage");
        ReportInfo reportInfo = new ReportInfo(MONITOR_EVENT_LOAD_URL, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        JSONObject jSONObject = new JSONObject();
        String optString = mContext.getMonitorContext().getCategory().optString(MetricConstant.TRACERT_ID);
        if (optString != null) {
            Intrinsics.checkNotNullExpressionValue(optString, "optString(TRACERT_ID)");
            jSONObject.put(MetricConstant.TRACERT_ID, optString);
        }
        String optString2 = mContext.getMonitorContext().getCategory().optString(MetricConstant.SDK_TYPE);
        if (optString2 != null) {
            Intrinsics.checkNotNullExpressionValue(optString2, "optString(SDK_TYPE)");
            jSONObject.put(MetricConstant.SDK_TYPE, optString2);
        }
        reportInfo.setCategory(jSONObject);
        ReliabilityReporter reliabilityReporter = INSTANCE;
        reliabilityReporter.wrapperContextInfo(reportInfo, mContext);
        reliabilityReporter.wrapperErrorInfo(reportInfo, errStage, errMessage, hasErrorView);
        IServiceCenter instance = ServiceCenter.INSTANCE.instance();
        String bid = mContext.getBid();
        if (bid == null) {
            bid = "default_bid";
        }
        IMonitorReportService iMonitorReportService = (IMonitorReportService) instance.get(bid, IMonitorReportService.class);
        if (iMonitorReportService != null) {
            iMonitorReportService.report(reportInfo);
        }
    }

    public final void reportLoadFail(BulletMonitorContext monitorContext, BulletRLContext resourceContext, AbsBulletMonitorCallback.ErrStage errStage, String errMessage, boolean hasErrorView, String viewType) {
        Intrinsics.checkNotNullParameter(monitorContext, "monitorContext");
        Intrinsics.checkNotNullParameter(resourceContext, "resourceContext");
        Intrinsics.checkNotNullParameter(errStage, "errStage");
        Intrinsics.checkNotNullParameter(errMessage, "errMessage");
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        ReportInfo reportInfo = new ReportInfo(MONITOR_EVENT_LOAD_URL, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        JSONObject jSONObject = new JSONObject();
        String optString = monitorContext.getCategory().optString(MetricConstant.TRACERT_ID);
        if (optString != null) {
            Intrinsics.checkNotNullExpressionValue(optString, "optString(TRACERT_ID)");
            jSONObject.put(MetricConstant.TRACERT_ID, optString);
        }
        String optString2 = monitorContext.getCategory().optString(MetricConstant.SDK_TYPE);
        if (optString2 != null) {
            Intrinsics.checkNotNullExpressionValue(optString2, "optString(SDK_TYPE)");
            jSONObject.put(MetricConstant.SDK_TYPE, optString2);
        }
        reportInfo.setCategory(jSONObject);
        ReliabilityReporter reliabilityReporter = INSTANCE;
        reliabilityReporter.wrapperContextInfo(reportInfo, monitorContext, resourceContext, viewType);
        reliabilityReporter.wrapperErrorInfo(reportInfo, errStage, errMessage, hasErrorView);
        IMonitorReportService iMonitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(monitorContext.getBid(), IMonitorReportService.class);
        if (iMonitorReportService != null) {
            iMonitorReportService.report(reportInfo);
        }
    }

    public final void reportLoadFail(String schema, JSONObject tracertCategory, JSONObject tracertMetric, AbsBulletMonitorCallback.ErrStage errStage, String errMessage, String bid) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(tracertCategory, "tracertCategory");
        Intrinsics.checkNotNullParameter(tracertMetric, "tracertMetric");
        Intrinsics.checkNotNullParameter(errStage, "errStage");
        Intrinsics.checkNotNullParameter(errMessage, "errMessage");
        Intrinsics.checkNotNullParameter(bid, "bid");
        ReportInfo reportInfo = new ReportInfo(MONITOR_EVENT_LOAD_URL, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        ReliabilityReporter reliabilityReporter = INSTANCE;
        reportInfo.setPageIdentifier(new BulletLoadUriIdentifier(reliabilityReporter.tryParseSchemaWithoutBid(schema)));
        reportInfo.setCategory(JsonUtilsKt.wrap(new JSONObject(), tracertCategory));
        reportInfo.setMetrics(JsonUtilsKt.wrap(new JSONObject(), tracertMetric));
        reliabilityReporter.wrapperErrorInfo(reportInfo, errStage, errMessage, false);
        IMonitorReportService iMonitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(bid, IMonitorReportService.class);
        if (iMonitorReportService != null) {
            iMonitorReportService.report(reportInfo);
        }
    }

    public final void reportLoadFail(AbsBulletMonitorCallback.ErrStage errStage, String errMessage, String bid, String tracertId, String sdkType) {
        Intrinsics.checkNotNullParameter(errStage, "errStage");
        Intrinsics.checkNotNullParameter(errMessage, "errMessage");
        Intrinsics.checkNotNullParameter(bid, "bid");
        ReportInfo reportInfo = new ReportInfo(MONITOR_EVENT_LOAD_URL, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        INSTANCE.wrapperErrorInfo(reportInfo, errStage, errMessage, false);
        IMonitorReportService iMonitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(bid, IMonitorReportService.class);
        if (iMonitorReportService != null) {
            iMonitorReportService.report(reportInfo);
        }
    }

    public final void reportLoadCancel(BulletContext mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        ReportInfo reportInfo = new ReportInfo(MONITOR_EVENT_LOAD_URL, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", "cancel");
        boolean areEqual = Intrinsics.areEqual(mContext.getContainerContext().getLoadStatus(), "success");
        String str = MetricConstant.MONITOR_STAGE_LOAD_TEMPLATE;
        if (areEqual) {
            jSONObject.put("cancel_stage", MetricConstant.MONITOR_STAGE_LOAD_TEMPLATE);
            jSONObject.put(FluencyHelper.STAGE, MetricConstant.MONITOR_STAGE_UPDATE);
        } else {
            jSONObject.put("cancel_stage", mContext.getMonitorContext().getLoadStage().getStage());
            if (mContext.getContainerContext().getIsReload()) {
                str = "reload_end";
            }
            jSONObject.put(FluencyHelper.STAGE, str);
        }
        ReliabilityReporter reliabilityReporter = INSTANCE;
        jSONObject.put(MetricConstant.STAY_DURATION, reliabilityReporter.getStayDuration(mContext.getMonitorContext()));
        reportInfo.setCategory(jSONObject);
        reliabilityReporter.wrapperContextInfo(reportInfo, mContext);
        IServiceCenter instance = ServiceCenter.INSTANCE.instance();
        String bid = mContext.getBid();
        if (bid == null) {
            bid = "default_bid";
        }
        IMonitorReportService iMonitorReportService = (IMonitorReportService) instance.get(bid, IMonitorReportService.class);
        if (iMonitorReportService != null) {
            iMonitorReportService.report(reportInfo);
        }
    }

    public final void reportSuccessStage(BulletContext mContext, String stage) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(stage, FluencyHelper.STAGE);
        ReportInfo reportInfo = new ReportInfo(MONITOR_EVENT_LOAD_URL, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        reportInfo.setPageIdentifier(mContext.getUriIdentifier());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("view_type", mContext.getScene().getTag());
        jSONObject.put(FluencyHelper.STAGE, stage);
        jSONObject.put("status", "success");
        reportInfo.setCategory(jSONObject);
        INSTANCE.wrapperContextInfo(reportInfo, mContext);
        TracertUtils.INSTANCE.mergeTracertInfo(reportInfo, mContext.getMonitorContext());
        IServiceCenter instance = ServiceCenter.INSTANCE.instance();
        String bid = mContext.getBid();
        if (bid == null) {
            bid = "default_bid";
        }
        IMonitorReportService iMonitorReportService = (IMonitorReportService) instance.get(bid, IMonitorReportService.class);
        if (iMonitorReportService != null) {
            iMonitorReportService.report(reportInfo);
        }
    }

    public final void reportLoadCancel(BulletMonitorContext monitorContext, BulletRLContext resourceContext, String viewType) {
        Intrinsics.checkNotNullParameter(monitorContext, "monitorContext");
        Intrinsics.checkNotNullParameter(resourceContext, "resourceContext");
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        ReportInfo reportInfo = new ReportInfo(MONITOR_EVENT_LOAD_URL, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", "cancel");
        jSONObject.put(FluencyHelper.STAGE, MetricConstant.MONITOR_STAGE_LOAD_TEMPLATE);
        ReliabilityReporter reliabilityReporter = INSTANCE;
        jSONObject.put(MetricConstant.STAY_DURATION, reliabilityReporter.getStayDuration(monitorContext));
        reportInfo.setCategory(jSONObject);
        reliabilityReporter.wrapperContextInfo(reportInfo, monitorContext, resourceContext, viewType);
        IMonitorReportService iMonitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(monitorContext.getBid(), IMonitorReportService.class);
        if (iMonitorReportService != null) {
            iMonitorReportService.report(reportInfo);
        }
    }

    private final ReportInfo wrapperContextInfo(ReportInfo reportInfo, BulletMonitorContext bulletMonitorContext, BulletRLContext bulletRLContext, String str) {
        if (reportInfo.getCategory() == null) {
            reportInfo.setCategory(new JSONObject());
        }
        JSONObject category = reportInfo.getCategory();
        if (category != null) {
            category.put("view_type", str);
            category.put("res_memory", bulletRLContext.getResMemory() ? "1" : ViewVisibleBridge.INVISIBLE);
            category.put("res_from", bulletRLContext.getResFrom());
            category.put("template_res_type", bulletRLContext.getResFrom());
            category.put("has_error_view", "false");
            category.put("fallback_reason", "");
            category.put("fallback", false);
            category.put("is_lynx_engine_ready", true);
            category.put("is_first_load", true);
            category.put("isLoaderTasksReady", ViewVisibleBridge.INVISIBLE);
            category.put("loaderTasksResult", ViewVisibleBridge.INVISIBLE);
            category.put("res_version", bulletRLContext.getResVersion());
        }
        if (reportInfo.getMetrics() == null) {
            reportInfo.setMetrics(new JSONObject());
        }
        JSONObject metrics = reportInfo.getMetrics();
        if (metrics != null) {
            metrics.put("res_size", bulletRLContext.getResSize());
        }
        TracertUtils.INSTANCE.mergeTracertInfo(reportInfo, bulletMonitorContext);
        return reportInfo;
    }

    private final ReportInfo wrapperContextInfo(ReportInfo reportInfo, BulletContext bulletContext) {
        reportInfo.setPageIdentifier(bulletContext.getUriIdentifier());
        if (reportInfo.getCategory() == null) {
            reportInfo.setCategory(new JSONObject());
        }
        JSONObject category = reportInfo.getCategory();
        if (category != null) {
            category.put("view_type", bulletContext.getScene().getTag());
            category.put("res_memory", bulletContext.getResourceContext().getResMemory() ? "1" : ViewVisibleBridge.INVISIBLE);
            category.put("res_from", bulletContext.getResourceContext().getResFrom());
            category.put("template_res_type", bulletContext.getResourceContext().getResFrom());
            category.put("has_error_view", bulletContext.getContainerContext().getHasErrorView() ? RouterConstants.TRUE : "false");
            category.put("fallback", bulletContext.isFallback());
            Fallback fallbackInfo = bulletContext.getContainerContext().getFallbackInfo();
            category.put("fallback_reason", fallbackInfo != null ? fallbackInfo.getFallbackReason() : null);
            category.put("is_lynx_engine_ready", bulletContext.getLynxContext().getIsLynxEngineReady());
            category.put("is_first_load", bulletContext.getContainerContext().getIsFirstLoad());
            category.put(SchemaConstants.QUERY_KEY_PACKAGES, bulletContext.getSchemeContext().getPackagesString());
            Boolean isLoaderTasksReady = bulletContext.getContainerContext().getLoaderTaskPerfMetric().getIsLoaderTasksReady();
            if (isLoaderTasksReady != null) {
                category.put("isLoaderTasksReady", isLoaderTasksReady.booleanValue() ? "1" : ViewVisibleBridge.INVISIBLE);
            }
            Boolean loaderResult = bulletContext.getContainerContext().getLoaderTaskPerfMetric().getLoaderResult();
            if (loaderResult != null) {
                category.put("loaderTasksResult", loaderResult.booleanValue() ? "1" : ViewVisibleBridge.INVISIBLE);
            }
            category.put("res_version", bulletContext.getResourceContext().getResVersion());
        }
        if (reportInfo.getMetrics() == null) {
            reportInfo.setMetrics(new JSONObject());
        }
        JSONObject metrics = reportInfo.getMetrics();
        if (metrics != null) {
            for (Map.Entry<String, Object> entry : bulletContext.getContainerContext().getLoaderTaskPerfMetric().getLoaderPerfMetric().entrySet()) {
                metrics.put(entry.getKey(), entry.getValue());
            }
            metrics.put("res_size", bulletContext.getResourceContext().getResSize());
        }
        TracertUtils.INSTANCE.mergeTracertInfo(reportInfo, bulletContext.getMonitorContext());
        return reportInfo;
    }

    private final ReportInfo wrapperErrorInfo(ReportInfo reportInfo, AbsBulletMonitorCallback.ErrStage errStage, String str, boolean z) {
        if (reportInfo.getCategory() == null) {
            reportInfo.setCategory(new JSONObject());
        }
        JSONObject category = reportInfo.getCategory();
        if (category != null) {
            if (errStage == AbsBulletMonitorCallback.ErrStage.RL) {
                category.put(FluencyHelper.STAGE, "download_template");
                category.put("status", "error");
            } else {
                category.put(FluencyHelper.STAGE, MetricConstant.MONITOR_STAGE_LOAD_TEMPLATE);
                category.put("status", SccResult.MESSAGE_FAIL);
            }
            category.put("has_error_view", z ? RouterConstants.TRUE : "false");
            category.put("fail_type", errStage.getTag());
            category.put("fail_reason", str);
            category.put(FluencyHelper.ERROR_STAGE, errStage.getTag());
            category.put(CDNLoader.DIAGNOSE_ERROR_MESSAGE, str);
            String tryGetLynxErrorCode = INSTANCE.tryGetLynxErrorCode(str);
            if (tryGetLynxErrorCode != null) {
                category.put("lynx_error_code", tryGetLynxErrorCode);
            }
        }
        return reportInfo;
    }

    public final void reportContainerInit$anniex_release(BulletContext mContext) {
        Uri uri;
        BulletLoadUriIdentifier bulletLoadUriIdentifier;
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        ReportInfo reportInfo = new ReportInfo(MONITOR_EVENT_LOAD_URL, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        if (mContext.getSchemaData() != null) {
            bulletLoadUriIdentifier = mContext.getUriIdentifier();
        } else {
            BulletLoadUriIdentifier uriIdentifier = mContext.getUriIdentifier();
            if (uriIdentifier == null || (uri = uriIdentifier.getUri()) == null) {
                uri = Uri.EMPTY;
            }
            Intrinsics.checkNotNullExpressionValue(uri, "mContext.uriIdentifier?.getRawUri()?: Uri.EMPTY");
            bulletLoadUriIdentifier = new BulletLoadUriIdentifier(uri);
        }
        reportInfo.setPageIdentifier(bulletLoadUriIdentifier);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("view_type", mContext.getScene().getTag());
        jSONObject.put(FluencyHelper.STAGE, "begin");
        reportInfo.setCategory(jSONObject);
        TracertUtils.INSTANCE.mergeTracertInfo(reportInfo, mContext.getMonitorContext());
        IServiceCenter instance = ServiceCenter.INSTANCE.instance();
        String bid = mContext.getBid();
        if (bid == null) {
            bid = "default_bid";
        }
        IMonitorReportService iMonitorReportService = (IMonitorReportService) instance.get(bid, IMonitorReportService.class);
        if (iMonitorReportService != null) {
            iMonitorReportService.report(reportInfo);
        }
    }

    public final void reportContainerExit(BulletContext mContext, String status, long startTime) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(status, "status");
        ReportInfo reportInfo = new ReportInfo(MONITOR_EVENT_CONTAINER_EXIT, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        reportInfo.setPageIdentifier(mContext.getUriIdentifier());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("view_type", mContext.getScene().getTag());
        jSONObject.put("res_memory", mContext.getResourceContext().getResMemory() ? "1" : ViewVisibleBridge.INVISIBLE);
        jSONObject.put("status", status);
        reportInfo.setCategory(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(LynxTimingPerformanceReportProcessor.KEY_DURATION, System.currentTimeMillis() - startTime);
        reportInfo.setMetrics(jSONObject2);
        TracertUtils.INSTANCE.mergeTracertInfo(reportInfo, mContext.getMonitorContext());
        IServiceCenter instance = ServiceCenter.INSTANCE.instance();
        String bid = mContext.getBid();
        if (bid == null) {
            bid = "default_bid";
        }
        IMonitorReportService iMonitorReportService = (IMonitorReportService) instance.get(bid, IMonitorReportService.class);
        if (iMonitorReportService != null) {
            iMonitorReportService.report(reportInfo);
        }
    }

    public final void reportBlankDetected(BulletContext mContext, Integer isBlank, Float visiblePercent) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        ReportInfo reportInfo = new ReportInfo(MONITOR_EVENT_BLANK_DETECT, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        reportInfo.setPageIdentifier(mContext.getUriIdentifier());
        JSONObject jSONObject = new JSONObject();
        if (isBlank != null) {
            isBlank.intValue();
            jSONObject.put("is_blank", isBlank.intValue());
            jSONObject.put("container_type", "web");
        }
        if (visiblePercent != null) {
            visiblePercent.floatValue();
            jSONObject.put("visible_percent", visiblePercent);
            jSONObject.put("container_type", "lynx");
        }
        reportInfo.setMetrics(jSONObject);
        TracertUtils.INSTANCE.mergeTracertInfo(reportInfo, mContext.getMonitorContext());
        IServiceCenter instance = ServiceCenter.INSTANCE.instance();
        String bid = mContext.getBid();
        if (bid == null) {
            bid = "default_bid";
        }
        IMonitorReportService iMonitorReportService = (IMonitorReportService) instance.get(bid, IMonitorReportService.class);
        if (iMonitorReportService != null) {
            iMonitorReportService.report(reportInfo);
        }
    }

    public final void reportErrorViewShow(BulletContext mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        ReportInfo reportInfo = new ReportInfo(MONITOR_EVENT_ERROR_SHOW, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        reportInfo.setPageIdentifier(mContext.getUriIdentifier());
        TracertUtils.INSTANCE.mergeTracertInfo(reportInfo, mContext.getMonitorContext());
        IServiceCenter instance = ServiceCenter.INSTANCE.instance();
        String bid = mContext.getBid();
        if (bid == null) {
            bid = "default_bid";
        }
        IMonitorReportService iMonitorReportService = (IMonitorReportService) instance.get(bid, IMonitorReportService.class);
        if (iMonitorReportService != null) {
            iMonitorReportService.report(reportInfo);
        }
    }

    public final void reportErrorViewClick(BulletContext mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        ReportInfo reportInfo = new ReportInfo(MONITOR_EVENT_ERROR_CLICK, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        reportInfo.setPageIdentifier(mContext.getUriIdentifier());
        TracertUtils.INSTANCE.mergeTracertInfo(reportInfo, mContext.getMonitorContext());
        IServiceCenter instance = ServiceCenter.INSTANCE.instance();
        String bid = mContext.getBid();
        if (bid == null) {
            bid = "default_bid";
        }
        IMonitorReportService iMonitorReportService = (IMonitorReportService) instance.get(bid, IMonitorReportService.class);
        if (iMonitorReportService != null) {
            iMonitorReportService.report(reportInfo);
        }
    }

    public final void traceEndToEnd(BulletContext mContext) {
        int unifyErrorDomain;
        String endToEndErrorMessage;
        String str;
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        if (mContext.getMonitorContext().getEndToEndTraced()) {
            return;
        }
        mContext.getMonitorContext().setEndToEndTraced(true);
        EngineInfo unifyInfo = ContainerStandardApi.INSTANCE.getUnifyInfo(mContext.getSessionId());
        if (unifyInfo.getUnifyError().getUnifyErrorDomain() != UnifyErrorDomain.AnnieXUnifyErrorDomainReserved.getErrorDomain()) {
            unifyErrorDomain = unifyInfo.getUnifyError().getUnifyErrorCode();
            endToEndErrorMessage = unifyInfo.getUnifyError().getUnifyErrorMsg();
        } else {
            unifyErrorDomain = mContext.getMonitorContext().getUnifyErrorDomain();
            endToEndErrorMessage = mContext.getMonitorContext().getEndToEndErrorMessage();
        }
        ReportInfo reportInfo = new ReportInfo(MONITOR_EVENT_END_TO_END, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        reportInfo.setPageIdentifier(mContext.getUriIdentifier());
        JSONObject jSONObject = new JSONObject();
        String loadStatus = mContext.getContainerContext().getLoadStatus();
        if (Intrinsics.areEqual(loadStatus, MetricConstant.MONITOR_STAGE_UPDATE)) {
            str = "success";
        } else {
            str = Intrinsics.areEqual(loadStatus, "failure") ? SccResult.MESSAGE_FAIL : "cancel";
        }
        jSONObject.put(FluencyHelper.STAGE, mContext.getMonitorContext().getEndToEndStage());
        jSONObject.put("status", str);
        if (!Intrinsics.areEqual("unknown", mContext.getMonitorContext().getEndToEndErrorMessage())) {
            endToEndErrorMessage = mContext.getMonitorContext().getEndToEndErrorMessage();
        }
        jSONObject.put(CDNLoader.DIAGNOSE_ERROR_MESSAGE, endToEndErrorMessage);
        jSONObject.put("template_res_type", mContext.getResourceContext().getResFrom());
        jSONObject.put("domain_error_code", unifyErrorDomain);
        reportInfo.setCategory(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(MetricConstant.STAY_DURATION, INSTANCE.getStayDuration(mContext.getMonitorContext()));
        jSONObject2.put("native_error_count", unifyInfo.getNativeErrorCount());
        jSONObject2.put("res_loader_error_count", unifyInfo.getResLoaderErrorTemplateCount());
        jSONObject2.put("res_loader_error_template_count", unifyInfo.getResLoaderErrorTemplateCount());
        jSONObject2.put("static_error_count", unifyInfo.getStaticCount());
        jSONObject2.put("fetch_error_count", unifyInfo.getFetchErrorCount());
        jSONObject2.put("jsb_error_count", unifyInfo.getJsbErrorCount());
        jSONObject2.put("js_exception_error_count", unifyInfo.getJsExceptionCount());
        reportInfo.setMetrics(jSONObject2);
        reportInfo.setMonitorId(mContext.getSessionId());
        IServiceCenter instance = ServiceCenter.INSTANCE.instance();
        String bid = mContext.getBid();
        if (bid == null) {
            bid = "default_bid";
        }
        IMonitorReportService iMonitorReportService = (IMonitorReportService) instance.get(bid, IMonitorReportService.class);
        if (iMonitorReportService != null) {
            iMonitorReportService.report(reportInfo);
        }
    }

    private final String tryGetLynxErrorCode(String errMessage) {
        MatchResult find$default;
        try {
            Result.Companion companion = Result.Companion;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (errMessage == null || (find$default = Regex.find$default(lynxErrorCodeRegex, errMessage, 0, 2, (Object) null)) == null) {
            Result.constructor-impl((Object) null);
            return null;
        }
        return find$default.getValue().subSequence(8, 11).toString();
    }

    private final long getStayDuration(BulletMonitorContext monitorContext) {
        long initTime = monitorContext.getInitTime();
        if (initTime <= 0) {
            initTime = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - initTime;
    }
}

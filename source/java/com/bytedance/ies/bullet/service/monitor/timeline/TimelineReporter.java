package com.bytedance.ies.bullet.service.monitor.timeline;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletMonitorContext;
import com.bytedance.ies.bullet.core.BulletRLContext;
import com.bytedance.ies.bullet.core.kit.Fallback;
import com.bytedance.ies.bullet.core.monitor.BulletTracert;
import com.bytedance.ies.bullet.service.base.CacheType;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.api.IServiceCenter;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.ies.bullet.service.base.utils.BulletLoadUriIdentifier;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.ies.bullet.service.monitor.MonitorReportService;
import com.bytedance.ies.bullet.service.monitor.tracert.TracertUtils;
import com.bytedance.ies.bullet.service.monitor.utils.JsonUtilsKt;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import com.bytedance.perf.monitor.ReportConst;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: TimelineReporter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u0004J\u0016\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0011\u001a\u00020\u0012J\u001e\u0010\"\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J&\u0010\"\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nJ\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!J\u0016\u0010'\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/timeline/TimelineReporter;", "", "()V", "MONITOR_EVENT_FULL_TIMELINE", "", "MONITOR_EVENT_LYNX_TIMELINE", "MONITOR_EVENT_STAY_DURATION", "MONITOR_EVENT_USER_FIRST_SCREEN", "MONITOR_EVENT_WEB_TIMELINE", "getTimelineInfo", "Lcom/bytedance/ies/bullet/service/base/ReportInfo;", "monitorContext", "Lcom/bytedance/ies/bullet/core/BulletMonitorContext;", "resourceContext", "Lcom/bytedance/ies/bullet/core/BulletRLContext;", "timeStampMap", "Lcom/bytedance/ies/bullet/service/monitor/timeline/TimeStampMap;", "durationMap", "Lcom/bytedance/ies/bullet/service/monitor/timeline/DurationMap;", "viewType", ReportConst.KEY_SCENE, "kitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getTracertTimelineInfo", "getUserFirstScreenInfo", "reportReUseTimeline", "", "tracertCategory", "Lorg/json/JSONObject;", "tracertMetric", "bid", "reportStayDuration", "mContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "reportTimeline", "timelineInfo", "userFirstScreenInfo", "tracertTimeline", "reportTracertTimeline", "reportUserFirstScreen", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TimelineReporter {
    public static final TimelineReporter INSTANCE = new TimelineReporter();
    public static final String MONITOR_EVENT_FULL_TIMELINE = "bdx_monitor_timeline_full";
    private static final String MONITOR_EVENT_LYNX_TIMELINE = "bdx_monitor_lynx_timeline";
    private static final String MONITOR_EVENT_STAY_DURATION = "bdx_monitor_stay_duration";
    private static final String MONITOR_EVENT_USER_FIRST_SCREEN = "bdx_monitor_user_first_screen_duration";
    private static final String MONITOR_EVENT_WEB_TIMELINE = "bdx_monitor_web_timeline";

    /* compiled from: TimelineReporter.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CacheType.values().length];
            try {
                iArr[CacheType.PRE_RENDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CacheType.REUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TimelineReporter() {
    }

    public final void reportTimeline(BulletContext mContext, TimeStampMap timeStampMap, DurationMap durationMap) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(timeStampMap, "timeStampMap");
        Intrinsics.checkNotNullParameter(durationMap, "durationMap");
        BulletLoadUriIdentifier uriIdentifier = mContext.getUriIdentifier();
        ReportInfo reportInfo = new ReportInfo((uriIdentifier != null ? uriIdentifier.getKitType() : null) == KitType.LYNX ? MONITOR_EVENT_LYNX_TIMELINE : MONITOR_EVENT_WEB_TIMELINE, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        reportInfo.setPageIdentifier(mContext.getUriIdentifier());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("view_type", mContext.getScene().getTag());
        CacheType cacheType = mContext.getContainerContext().getCacheType();
        int i = cacheType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[cacheType.ordinal()];
        jSONObject.put("view_from", i != 1 ? i != 2 ? "new" : SchemaConstants.QUERY_KEY_REUSE : SchemaConstants.QUERY_KEY_PRERENDER);
        jSONObject.put("kitview_from", mContext.getContainerContext().getIsPreCreate() ? "precreate" : "new");
        jSONObject.put("res_memory", mContext.getResourceContext().getResMemory() ? "1" : ViewVisibleBridge.INVISIBLE);
        jSONObject.put("res_from", mContext.getResourceContext().getResFrom());
        jSONObject.put("fallback", mContext.isFallback());
        Fallback fallbackInfo = mContext.getContainerContext().getFallbackInfo();
        jSONObject.put("fallback_reason", fallbackInfo != null ? fallbackInfo.getFallbackReason() : null);
        Boolean isLoaderTasksReady = mContext.getContainerContext().getLoaderTaskPerfMetric().getIsLoaderTasksReady();
        if (isLoaderTasksReady != null) {
            jSONObject.put("isLoaderTasksReady", isLoaderTasksReady.booleanValue() ? "1" : ViewVisibleBridge.INVISIBLE);
        }
        Boolean loaderResult = mContext.getContainerContext().getLoaderTaskPerfMetric().getLoaderResult();
        if (loaderResult != null) {
            jSONObject.put("loaderTasksResult", loaderResult.booleanValue() ? "1" : ViewVisibleBridge.INVISIBLE);
        }
        jSONObject.put("res_version", mContext.getResourceContext().getResVersion());
        reportInfo.setCategory(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("res_size", mContext.getResourceContext().getResSize());
        jSONObject2.put(MetricConstant.BULLET_INIT, timeStampMap.get(MetricConstant.BULLET_INIT));
        long j = timeStampMap.get(MetricConstant.LYNX_FIRST_SCREEN);
        if (j > 0) {
            jSONObject2.put(MetricConstant.LYNX_FIRST_SCREEN, j);
        }
        long j2 = timeStampMap.get(MetricConstant.WEB_PAGE_FINISH);
        if (j2 > 0) {
            jSONObject2.put(MetricConstant.WEB_PAGE_FINISH, j2);
        }
        for (Map.Entry<String, Object> entry : mContext.getContainerContext().getLoaderTaskPerfMetric().getLoaderPerfMetric().entrySet()) {
            jSONObject2.put(entry.getKey(), entry.getValue());
        }
        JsonUtilsKt.wrap(jSONObject2, durationMap.getMMap());
        reportInfo.setMetrics(jSONObject2);
        mContext.getMonitorContext().inject(reportInfo.getCategory(), reportInfo.getMetrics());
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

    public final ReportInfo getTimelineInfo(BulletMonitorContext monitorContext, BulletRLContext resourceContext, TimeStampMap timeStampMap, DurationMap durationMap, String viewType, String scene, KitType kitType) {
        Intrinsics.checkNotNullParameter(monitorContext, "monitorContext");
        Intrinsics.checkNotNullParameter(resourceContext, "resourceContext");
        Intrinsics.checkNotNullParameter(timeStampMap, "timeStampMap");
        Intrinsics.checkNotNullParameter(durationMap, "durationMap");
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        Intrinsics.checkNotNullParameter(scene, ReportConst.KEY_SCENE);
        Intrinsics.checkNotNullParameter(kitType, "kitType");
        ReportInfo reportInfo = new ReportInfo(kitType == KitType.LYNX ? MONITOR_EVENT_LYNX_TIMELINE : MONITOR_EVENT_WEB_TIMELINE, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        reportInfo.setPageIdentifier(monitorContext.getUriIdentifier());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("view_type", viewType);
        jSONObject.put("view_from", scene);
        jSONObject.put("kitview_from", viewType);
        jSONObject.put("res_memory", resourceContext.getResMemory() ? "1" : ViewVisibleBridge.INVISIBLE);
        jSONObject.put("res_from", resourceContext.getResFrom());
        jSONObject.put("fallback", ViewVisibleBridge.INVISIBLE);
        jSONObject.put("fallback_reason", "");
        jSONObject.put("isLoaderTasksReady", ViewVisibleBridge.INVISIBLE);
        jSONObject.put("loaderTasksResult", ViewVisibleBridge.INVISIBLE);
        jSONObject.put("res_version", resourceContext.getResVersion());
        reportInfo.setCategory(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("res_size", resourceContext.getResSize());
        jSONObject2.put(MetricConstant.BULLET_INIT, timeStampMap.get(MetricConstant.BULLET_INIT));
        long j = timeStampMap.get(MetricConstant.LYNX_FIRST_SCREEN);
        if (j > 0) {
            jSONObject2.put(MetricConstant.LYNX_FIRST_SCREEN, j);
        }
        long j2 = timeStampMap.get(MetricConstant.WEB_PAGE_FINISH);
        if (j2 > 0) {
            jSONObject2.put(MetricConstant.WEB_PAGE_FINISH, j2);
        }
        JsonUtilsKt.wrap(jSONObject2, durationMap.getMMap());
        reportInfo.setMetrics(jSONObject2);
        return reportInfo;
    }

    public final void reportStayDuration(BulletContext mContext, DurationMap durationMap) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(durationMap, "durationMap");
        if (BulletTracert.INSTANCE.supportAdvancedMonitor(String.valueOf(mContext.getLoadUri()))) {
            long j = durationMap.get(MetricConstant.STAY_DURATION);
            ReportInfo reportInfo = new ReportInfo(MONITOR_EVENT_STAY_DURATION, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
            reportInfo.setPageIdentifier(mContext.getUriIdentifier());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MetricConstant.STAY_DURATION, j);
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
    }

    public final void reportUserFirstScreen(BulletContext mContext, TimeStampMap timeStampMap) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(timeStampMap, "timeStampMap");
        ReportInfo reportInfo = new ReportInfo(MONITOR_EVENT_USER_FIRST_SCREEN, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        reportInfo.setPageIdentifier(mContext.getUriIdentifier());
        JSONObject jSONObject = new JSONObject();
        CacheType cacheType = mContext.getContainerContext().getCacheType();
        int i = cacheType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[cacheType.ordinal()];
        jSONObject.put(EventConstants.PARAM_SOURCE, i != 1 ? i != 2 ? "none" : SchemaConstants.QUERY_KEY_REUSE : "precreate");
        jSONObject.put("view_type", mContext.getScene().getTag());
        jSONObject.put("res_memory", mContext.getResourceContext().getResMemory() ? "1" : ViewVisibleBridge.INVISIBLE);
        reportInfo.setCategory(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(LynxTimingPerformanceReportProcessor.KEY_DURATION, timeStampMap.get(MetricConstant.LYNX_FIRST_SCREEN) - timeStampMap.get(MetricConstant.BULLET_INIT));
        reportInfo.setMetrics(jSONObject2);
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

    public final ReportInfo getUserFirstScreenInfo(BulletMonitorContext monitorContext, BulletRLContext resourceContext, TimeStampMap timeStampMap) {
        Intrinsics.checkNotNullParameter(monitorContext, "monitorContext");
        Intrinsics.checkNotNullParameter(resourceContext, "resourceContext");
        Intrinsics.checkNotNullParameter(timeStampMap, "timeStampMap");
        ReportInfo reportInfo = new ReportInfo(MONITOR_EVENT_USER_FIRST_SCREEN, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        reportInfo.setPageIdentifier(monitorContext.getUriIdentifier());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(EventConstants.PARAM_SOURCE, "none");
        jSONObject.put("view_type", "annieX_card");
        jSONObject.put("res_memory", resourceContext.getResMemory() ? "1" : ViewVisibleBridge.INVISIBLE);
        reportInfo.setCategory(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(LynxTimingPerformanceReportProcessor.KEY_DURATION, timeStampMap.get(MetricConstant.LYNX_FIRST_SCREEN) - timeStampMap.get(MetricConstant.BULLET_INIT));
        reportInfo.setMetrics(jSONObject2);
        return reportInfo;
    }

    public static /* synthetic */ void reportReUseTimeline$default(TimelineReporter timelineReporter, JSONObject jSONObject, JSONObject jSONObject2, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "default_bid";
        }
        timelineReporter.reportReUseTimeline(jSONObject, jSONObject2, str);
    }

    public final void reportReUseTimeline(JSONObject tracertCategory, JSONObject tracertMetric, String bid) {
        Intrinsics.checkNotNullParameter(tracertCategory, "tracertCategory");
        Intrinsics.checkNotNullParameter(tracertMetric, "tracertMetric");
        Intrinsics.checkNotNullParameter(bid, "bid");
        ReportInfo reportInfo = new ReportInfo(MONITOR_EVENT_FULL_TIMELINE, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        reportInfo.setPageIdentifier(null);
        JSONObject wrap = JsonUtilsKt.wrap(new JSONObject(), tracertCategory);
        wrap.put("view_from", SchemaConstants.QUERY_KEY_REUSE);
        reportInfo.setCategory(wrap);
        JSONObject wrap2 = JsonUtilsKt.wrap(new JSONObject(), tracertMetric);
        wrap2.put(MetricConstant.FULL_TIME, Math.max(0L, System.currentTimeMillis() - wrap2.optLong(MetricConstant.TRACERT_INIT)));
        reportInfo.setMetrics(wrap2);
        MonitorReportService monitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(bid, IMonitorReportService.class);
        if (monitorReportService == null) {
            monitorReportService = MonitorReportService.INSTANCE.getFallbackDefault();
        }
        monitorReportService.report(reportInfo);
    }

    public final void reportTracertTimeline(BulletContext mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        if (mContext.getMonitorContext().getInUse()) {
            JSONObject category = mContext.getMonitorContext().getCategory();
            JSONObject metric = mContext.getMonitorContext().getMetric();
            ReportInfo reportInfo = new ReportInfo(MONITOR_EVENT_FULL_TIMELINE, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
            reportInfo.setPageIdentifier(mContext.getUriIdentifier());
            JSONObject wrap = JsonUtilsKt.wrap(new JSONObject(), category);
            Object opt = wrap.opt(MetricConstant.TRACERT_ID);
            String str = opt instanceof String ? (String) opt : null;
            if (str == null || str.length() == 0) {
                BulletLoadUriIdentifier uriIdentifier = mContext.getUriIdentifier();
                wrap.put(MetricConstant.TRACERT_ID, uriIdentifier != null ? uriIdentifier.getIdentifierUrl() : null);
            }
            reportInfo.setCategory(wrap);
            JSONObject wrap2 = JsonUtilsKt.wrap(new JSONObject(), metric);
            JSONObject category2 = reportInfo.getCategory();
            long optLong = (!Intrinsics.areEqual(String.valueOf(category2 != null ? category2.opt(MetricConstant.IS_DATA_INJECTED) : null), "1") || wrap2.optLong(MetricConstant.DRAW_END) <= 0) ? wrap2.optLong(MetricConstant.UPDATE_DRAW_END) > 0 ? wrap2.optLong(MetricConstant.UPDATE_DRAW_END) : wrap2.optLong(MetricConstant.WEB_PAGE_FINISH) > 0 ? wrap2.optLong(MetricConstant.WEB_PAGE_FINISH) : 0L : wrap2.optLong(MetricConstant.DRAW_END);
            long optLong2 = wrap2.optLong(MetricConstant.TRACERT_INIT);
            if (wrap2.optLong(MetricConstant.DRAW_END) != 0) {
                wrap2.put(MetricConstant.FCP_TIME, wrap2.optLong(MetricConstant.DRAW_END) - optLong2);
            }
            wrap2.put(MetricConstant.FULL_TIME, Math.max(0L, optLong - optLong2));
            if (wrap2.optLong(MetricConstant.PAGE_COMMIT_START) != 0 && wrap2.optLong(MetricConstant.PAGE_COMMIT_END) != 0) {
                long optLong3 = wrap2.optLong(MetricConstant.PAGE_COMMIT_END) - wrap2.optLong(MetricConstant.PAGE_COMMIT_START);
                if (optLong3 > 0) {
                    wrap2.put(MetricConstant.PAGE_COMMIT_DURATION, optLong3);
                }
            }
            if (wrap2.optLong(MetricConstant.API_REQUEST_END) != 0) {
                wrap2.put(MetricConstant.RENDER_COST, optLong - wrap2.optLong(MetricConstant.API_REQUEST_END));
            }
            if (wrap2.optLong(MetricConstant.API_REQUEST) == 0) {
                long optLong4 = wrap2.optLong(MetricConstant.API_REQUEST_END) - wrap2.optLong(MetricConstant.API_REQUEST_START);
                if (optLong4 > 0) {
                    wrap2.put(MetricConstant.API_REQUEST, optLong4);
                }
            }
            reportInfo.setMetrics(wrap2);
            mContext.getMonitorContext().setInUse(false);
            IServiceCenter instance = ServiceCenter.INSTANCE.instance();
            String bid = mContext.getBid();
            if (bid == null) {
                bid = "default_bid";
            }
            MonitorReportService monitorReportService = (IMonitorReportService) instance.get(bid, IMonitorReportService.class);
            if (monitorReportService == null) {
                monitorReportService = MonitorReportService.INSTANCE.getFallbackDefault();
            }
            monitorReportService.report(reportInfo);
        }
    }

    public final ReportInfo getTracertTimelineInfo(BulletMonitorContext monitorContext) {
        Intrinsics.checkNotNullParameter(monitorContext, "monitorContext");
        JSONObject category = monitorContext.getCategory();
        JSONObject metric = monitorContext.getMetric();
        ReportInfo reportInfo = new ReportInfo(MONITOR_EVENT_FULL_TIMELINE, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        reportInfo.setPageIdentifier(monitorContext.getUriIdentifier());
        JSONObject wrap = JsonUtilsKt.wrap(new JSONObject(), category);
        Object opt = wrap.opt(MetricConstant.TRACERT_ID);
        String str = opt instanceof String ? (String) opt : null;
        if (str == null || str.length() == 0) {
            BulletLoadUriIdentifier uriIdentifier = monitorContext.getUriIdentifier();
            wrap.put(MetricConstant.TRACERT_ID, uriIdentifier != null ? uriIdentifier.getIdentifierUrl() : null);
        }
        reportInfo.setCategory(wrap);
        JSONObject wrap2 = JsonUtilsKt.wrap(new JSONObject(), metric);
        JSONObject category2 = reportInfo.getCategory();
        long optLong = (!Intrinsics.areEqual(String.valueOf(category2 != null ? category2.opt(MetricConstant.IS_DATA_INJECTED) : null), "1") || wrap2.optLong(MetricConstant.DRAW_END) <= 0) ? wrap2.optLong(MetricConstant.UPDATE_DRAW_END) > 0 ? wrap2.optLong(MetricConstant.UPDATE_DRAW_END) : wrap2.optLong(MetricConstant.WEB_PAGE_FINISH) > 0 ? wrap2.optLong(MetricConstant.WEB_PAGE_FINISH) : wrap2.optLong(MetricConstant.DRAW_END) > 0 ? wrap2.optLong(MetricConstant.DRAW_END) : 0L : wrap2.optLong(MetricConstant.DRAW_END);
        long optLong2 = wrap2.optLong(MetricConstant.BULLET_INIT);
        if (wrap2.optLong(MetricConstant.DRAW_END) != 0) {
            wrap2.put(MetricConstant.FCP_TIME, wrap2.optLong(MetricConstant.DRAW_END) - optLong2);
        }
        wrap2.put(MetricConstant.FULL_TIME, Math.max(0L, optLong - optLong2));
        if (wrap2.optLong(MetricConstant.PAGE_COMMIT_START) != 0 && wrap2.optLong(MetricConstant.PAGE_COMMIT_END) != 0) {
            long optLong3 = wrap2.optLong(MetricConstant.PAGE_COMMIT_END) - wrap2.optLong(MetricConstant.PAGE_COMMIT_START);
            if (optLong3 > 0) {
                wrap2.put(MetricConstant.PAGE_COMMIT_DURATION, optLong3);
            }
        }
        if (wrap2.optLong(MetricConstant.API_REQUEST_END) != 0) {
            wrap2.put(MetricConstant.RENDER_COST, optLong - wrap2.optLong(MetricConstant.API_REQUEST_END));
        }
        if (wrap2.optLong(MetricConstant.API_REQUEST) == 0) {
            long optLong4 = wrap2.optLong(MetricConstant.API_REQUEST_END) - wrap2.optLong(MetricConstant.API_REQUEST_START);
            if (optLong4 > 0) {
                wrap2.put(MetricConstant.API_REQUEST, optLong4);
            }
        }
        if (wrap2.optLong(MetricConstant.CREATE_LYNX) > 0 && category.optString("view_from").equals("new")) {
            wrap2.put(MetricConstant.CONTAINER_DURATION, (wrap2.optLong(MetricConstant.CREATE_TO_START_RENDER) - wrap2.optLong(MetricConstant.CREATE_LYNX)) - wrap2.optLong(MetricConstant.CREATE_TO_RL));
        } else {
            wrap2.put(MetricConstant.CONTAINER_DURATION, wrap2.optLong(MetricConstant.CREATE_TO_START_RENDER) - wrap2.optLong(MetricConstant.CREATE_TO_RL));
        }
        reportInfo.setMetrics(wrap2);
        return reportInfo;
    }

    public final void reportTimeline(BulletMonitorContext monitorContext, ReportInfo timelineInfo, ReportInfo userFirstScreenInfo, ReportInfo tracertTimeline) {
        Intrinsics.checkNotNullParameter(monitorContext, "monitorContext");
        Intrinsics.checkNotNullParameter(timelineInfo, "timelineInfo");
        Intrinsics.checkNotNullParameter(userFirstScreenInfo, "userFirstScreenInfo");
        Intrinsics.checkNotNullParameter(tracertTimeline, "tracertTimeline");
        IMonitorReportService iMonitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(monitorContext.getBid(), IMonitorReportService.class);
        if (iMonitorReportService != null) {
            iMonitorReportService.report(timelineInfo);
        }
        IMonitorReportService iMonitorReportService2 = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(monitorContext.getBid(), IMonitorReportService.class);
        if (iMonitorReportService2 != null) {
            iMonitorReportService2.report(userFirstScreenInfo);
        }
        if (monitorContext.getInUse()) {
            MonitorReportService monitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(monitorContext.getBid(), IMonitorReportService.class);
            if (monitorReportService == null) {
                monitorReportService = MonitorReportService.INSTANCE.getFallbackDefault();
            }
            monitorReportService.report(tracertTimeline);
            monitorContext.setInUse(false);
        }
    }
}

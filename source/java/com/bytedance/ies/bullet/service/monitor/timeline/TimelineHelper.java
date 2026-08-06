package com.bytedance.ies.bullet.service.monitor.timeline;

import android.util.Log;
import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.ies.bullet.service.monitor.utils.JsonUtilsKt;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: TimelineHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ,\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJB\u0010\u000e\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0010\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJB\u0010\u0011\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0010\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ<\u0010\u0012\u001a\u00020\u00102\"\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u0014j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001`\u00152\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH\u0002J\u0016\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/timeline/TimelineHelper;", "", "()V", "assemblePerfMetric", "Lorg/json/JSONObject;", "timeStampMap", "Lcom/bytedance/ies/bullet/service/monitor/timeline/TimeStampMap;", "durationMap", "Lcom/bytedance/ies/bullet/service/monitor/timeline/DurationMap;", "collectSetupLynxTiming", "", "setupMetrics", "", "", "collectUpdateLynxTiming", "updateMetrics", "", "collectUpdateLynxTimingForIBulletPerf", "getDurationFromMap", "map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "startKey", "endKey", "getTracertMetric", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TimelineHelper {
    public static final TimelineHelper INSTANCE = new TimelineHelper();

    private TimelineHelper() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006e, code lost:
    
        if ((r1 instanceof java.util.HashMap ? (java.util.HashMap) r1 : null) != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b5, code lost:
    
        if ((r1 instanceof java.util.HashMap ? (java.util.HashMap) r1 : null) != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002a, code lost:
    
        if ((r1 instanceof java.util.HashMap ? (java.util.HashMap) r1 : null) != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void collectSetupLynxTiming(Map<String, Object> setupMetrics, TimeStampMap timeStampMap, DurationMap durationMap) {
        Intrinsics.checkNotNullParameter(timeStampMap, "timeStampMap");
        Intrinsics.checkNotNullParameter(durationMap, "durationMap");
        if (setupMetrics != null) {
            if (setupMetrics.get(LynxMonitorService.KEY_METRICS) == null) {
                Object obj = setupMetrics.get(LynxMonitorService.KEY_METRICS);
            }
            Object obj2 = setupMetrics.get(LynxMonitorService.KEY_METRICS);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
            HashMap hashMap = (HashMap) obj2;
            for (String str : hashMap.keySet()) {
                Intrinsics.checkNotNullExpressionValue(str, "key");
                Object obj3 = hashMap.get(str);
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Long");
                durationMap.record(str, (Long) obj3);
            }
            if (setupMetrics.get("ssr_metrics") == null) {
                Object obj4 = setupMetrics.get("ssr_metrics");
            }
            Object obj5 = setupMetrics.get("ssr_metrics");
            Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
            HashMap hashMap2 = (HashMap) obj5;
            for (String str2 : hashMap2.keySet()) {
                Intrinsics.checkNotNullExpressionValue(str2, "key");
                Object obj6 = hashMap2.get(str2);
                Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Long");
                durationMap.record(str2, (Long) obj6);
            }
            if (setupMetrics.get(LynxMonitorService.KEY_SETUP_TIMING) == null) {
                Object obj7 = setupMetrics.get(LynxMonitorService.KEY_SETUP_TIMING);
            }
            Object obj8 = setupMetrics.get(LynxMonitorService.KEY_SETUP_TIMING);
            Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
            HashMap<String, Object> hashMap3 = (HashMap) obj8;
            Intrinsics.checkNotNull(hashMap3, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any?, kotlin.Any?>");
            timeStampMap.addJson(new JSONObject(hashMap3));
            TimelineHelper timelineHelper = INSTANCE;
            durationMap.record(MetricConstant.CREATE_LYNX, Long.valueOf(timelineHelper.getDurationFromMap(hashMap3, "create_lynx_start", "create_lynx_end")));
            durationMap.record("load_core", Long.valueOf(timelineHelper.getDurationFromMap(hashMap3, "load_core_start", "load_core_end")));
            durationMap.record("decode", Long.valueOf(timelineHelper.getDurationFromMap(hashMap3, "decode_start", "decode_end")));
            durationMap.record("lepus_execute", Long.valueOf(timelineHelper.getDurationFromMap(hashMap3, "lepus_excute_start", "lepus_excute_end")));
            durationMap.record("create_vdom", Long.valueOf(timelineHelper.getDurationFromMap(hashMap3, "create_vdom_start", "create_vdom_end")));
            durationMap.record("dispatch", Long.valueOf(timelineHelper.getDurationFromMap(hashMap3, "dispatch_start", "dispatch_end")));
            durationMap.record("layout", Long.valueOf(timelineHelper.getDurationFromMap(hashMap3, "layout_start", "layout_end")));
            durationMap.record("ui_operation_flush", Long.valueOf(timelineHelper.getDurationFromMap(hashMap3, "ui_operation_flush_start", "ui_operation_flush_end")));
            durationMap.record("load_app", Long.valueOf(timelineHelper.getDurationFromMap(hashMap3, "load_app_start", "load_app_end")));
            durationMap.record("load_template", Long.valueOf(timelineHelper.getDurationFromMap(hashMap3, "load_template_start", "load_template_end")));
            if (setupMetrics.get("ssr_render_page_timing") == null) {
                Object obj9 = setupMetrics.get("ssr_render_page_timing");
                if ((obj9 instanceof HashMap ? (HashMap) obj9 : null) == null) {
                    return;
                }
            }
            Object obj10 = setupMetrics.get("ssr_render_page_timing");
            Intrinsics.checkNotNull(obj10, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
            HashMap<String, Object> hashMap4 = (HashMap) obj10;
            Intrinsics.checkNotNull(hashMap4, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any?, kotlin.Any?>");
            timeStampMap.addJson(new JSONObject(hashMap4));
            TimelineHelper timelineHelper2 = INSTANCE;
            durationMap.record("render_page_ssr", Long.valueOf(timelineHelper2.getDurationFromMap(hashMap4, "render_page_start_ssr", "render_page_end_ssr")));
            durationMap.record("layout_ssr", Long.valueOf(timelineHelper2.getDurationFromMap(hashMap4, "layout_start_ssr", "layout_end_ssr")));
            durationMap.record("create_vdom_ssr", Long.valueOf(timelineHelper2.getDurationFromMap(hashMap4, "create_vdom_start_ssr", "create_vdom_end_ssr")));
            durationMap.record("dispatch_ssr", Long.valueOf(timelineHelper2.getDurationFromMap(hashMap4, "dispatch_start_ssr", "dispatch_end_ssr")));
            durationMap.record("ui_operation_flush_ssr", Long.valueOf(timelineHelper2.getDurationFromMap(hashMap4, "ui_operation_flush_start_ssr", "ui_operation_flush_end_ssr")));
            durationMap.record("decode_ssr", Long.valueOf(timelineHelper2.getDurationFromMap(hashMap4, "decode_start_ssr", "decode_end_ssr")));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
    
        if ((r1 instanceof java.util.HashMap ? (java.util.HashMap) r1 : null) != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void collectUpdateLynxTiming(Map<String, Object> setupMetrics, Map<String, Long> updateMetrics, TimeStampMap timeStampMap, DurationMap durationMap) {
        Long l;
        Intrinsics.checkNotNullParameter(timeStampMap, "timeStampMap");
        Intrinsics.checkNotNullParameter(durationMap, "durationMap");
        if (setupMetrics != null) {
            if (setupMetrics.get(LynxMonitorService.KEY_METRICS) == null) {
                Object obj = setupMetrics.get(LynxMonitorService.KEY_METRICS);
            }
            Object obj2 = setupMetrics.get(LynxMonitorService.KEY_METRICS);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
            HashMap hashMap = (HashMap) obj2;
            for (String str : hashMap.keySet()) {
                Intrinsics.checkNotNullExpressionValue(str, "key");
                Object obj3 = hashMap.get(str);
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Long");
                durationMap.record(str, (Long) obj3);
            }
        }
        if (updateMetrics == null || (l = updateMetrics.get(MetricConstant.DRAW_END)) == null) {
            return;
        }
        timeStampMap.record(MetricConstant.UPDATE_DRAW_END, Long.valueOf(l.longValue()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0027, code lost:
    
        if ((r4 instanceof java.util.HashMap ? (java.util.HashMap) r4 : null) != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void collectUpdateLynxTimingForIBulletPerf(Map<String, Object> setupMetrics, Map<String, Long> updateMetrics, TimeStampMap timeStampMap, DurationMap durationMap) {
        Intrinsics.checkNotNullParameter(timeStampMap, "timeStampMap");
        Intrinsics.checkNotNullParameter(durationMap, "durationMap");
        if (setupMetrics != null) {
            if (setupMetrics.get(LynxMonitorService.KEY_METRICS) == null) {
                Object obj = setupMetrics.get(LynxMonitorService.KEY_METRICS);
            }
            Object obj2 = setupMetrics.get(LynxMonitorService.KEY_METRICS);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
            HashMap hashMap = (HashMap) obj2;
            for (String str : hashMap.keySet()) {
                Intrinsics.checkNotNullExpressionValue(str, "key");
                Object obj3 = hashMap.get(str);
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Long");
                durationMap.record(str, (Long) obj3);
            }
        }
        HashMap<String, Object> hashMap2 = updateMetrics instanceof HashMap ? (HashMap) updateMetrics : null;
        if (hashMap2 != null) {
            for (String str2 : hashMap2.keySet()) {
                Intrinsics.checkNotNullExpressionValue(str2, "key");
                Object obj4 = hashMap2.get(str2);
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Long");
                timeStampMap.record(str2, (Long) obj4);
            }
            TimelineHelper timelineHelper = INSTANCE;
            durationMap.record("create_vdom", Long.valueOf(timelineHelper.getDurationFromMap(hashMap2, "create_vdom_start", "create_vdom_end")));
            durationMap.record("dispatch", Long.valueOf(timelineHelper.getDurationFromMap(hashMap2, "dispatch_start", "dispatch_end")));
            durationMap.record("layout", Long.valueOf(timelineHelper.getDurationFromMap(hashMap2, "layout_start", "layout_end")));
            durationMap.record("ui_operation_flush", Long.valueOf(timelineHelper.getDurationFromMap(hashMap2, "ui_operation_flush_start", "ui_operation_flush_end")));
        }
    }

    private final long getDurationFromMap(HashMap<String, Object> map, String startKey, String endKey) {
        Object obj = map.get(startKey);
        Long l = obj instanceof Long ? (Long) obj : null;
        Object obj2 = map.get(endKey);
        Long l2 = obj2 instanceof Long ? (Long) obj2 : null;
        if (l == null || l2 == null) {
            Log.e("TimelineTracker", "getDurationFromMap: " + l + ", " + l2 + ", " + map);
            return 0L;
        }
        return l2.longValue() - l.longValue();
    }

    public final JSONObject getTracertMetric(TimeStampMap timeStampMap, DurationMap durationMap) {
        Intrinsics.checkNotNullParameter(timeStampMap, "timeStampMap");
        Intrinsics.checkNotNullParameter(durationMap, "durationMap");
        JSONObject wrap = JsonUtilsKt.wrap(new JSONObject(), durationMap.getMMap());
        wrap.put("tti_time", wrap.optLong("tti"));
        wrap.put("lynx_tti_time", wrap.optLong("lynx_tti"));
        Long valueOf = Long.valueOf(timeStampMap.get(MetricConstant.DRAW_END));
        if (!(valueOf.longValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            wrap.put(MetricConstant.DRAW_END, valueOf.longValue());
        }
        Long valueOf2 = Long.valueOf(timeStampMap.get(MetricConstant.UPDATE_DRAW_END));
        Long l = valueOf2.longValue() > 0 ? valueOf2 : null;
        if (l != null) {
            wrap.put(MetricConstant.UPDATE_DRAW_END, l.longValue());
        }
        return wrap;
    }

    public final JSONObject assemblePerfMetric(TimeStampMap timeStampMap, DurationMap durationMap) {
        Intrinsics.checkNotNullParameter(timeStampMap, "timeStampMap");
        Intrinsics.checkNotNullParameter(durationMap, "durationMap");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("timing", timeStampMap.getMMap());
        jSONObject.put(LynxTimingPerformanceReportProcessor.KEY_DURATION, durationMap.getMMap());
        return jSONObject;
    }
}

package com.bytedance.lynx.service.reporter.performance;

import android.content.Context;
import com.bytedance.lynx.service.reporter.performance.ILynxPerformanceReportProcessor;
import com.lynx.tasm.performance.performanceobserver.PerformanceEntry;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxTimingPerformanceReportProcessor.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001e\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R.\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/lynx/service/reporter/performance/LynxTimingPerformanceReportProcessor;", "Lcom/bytedance/lynx/service/reporter/performance/ILynxPerformanceReportProcessor;", "()V", "mLoadBundleEntry", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "calculateCustomMetrics", "", "entry", "Lcom/lynx/tasm/performance/performanceobserver/PerformanceEntry;", "canProcess", "", "processMetricEntry", "processPerformanceEntry", "", "processPipelineEntry", "Companion", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LynxTimingPerformanceReportProcessor implements ILynxPerformanceReportProcessor {
    public static final String FRAMEWORK_RENDERING_TIMING = "frameworkRenderingTiming";
    public static final String KEY_DURATION = "duration";
    public static final String KEY_END_SUFFIX = "End";
    public static final String KEY_END_TIMESTAMP_NAME = "endTimestampName";
    public static final String KEY_START_SUFFIX = "Start";
    public static final String KEY_START_TIMESTAMP_NAME = "startTimestampName";
    public static final String LAYOUT_UI_OPERATION_EXECUTE_END = "layoutUiOperationExecuteEnd";
    public static final String LOAD_BUNDLE = "loadBundle";
    public static final String MTS_RENDER_START = "mtsRenderStart";
    public static final String PAINT_END = "paintEnd";
    public static final String PAINT_WAITING = "paintWaiting";
    public static final String PIPELINE_START = "pipelineStart";
    public static final String RELOAD_BUNDLE_FROM_BTS = "reloadBundleFromBts";
    public static final String RELOAD_BUNDLE_FROM_NATIVE = "reloadBundleFromNative";
    public static final String SUFFIX_END_TIMESTAMP_NAME = "EndTimestampName";
    public static final String SUFFIX_START_TIMESTAMP_NAME = "StartTimestampName";
    public static final String TRIGGER_WAITING = "triggerWaiting";
    public static final String TYPE_METRIC = "metric";
    public static final String TYPE_PIPELINE = "pipeline";
    public static final String UPDATE_WAITING = "updateWaiting";
    private HashMap<String, Object> mLoadBundleEntry;

    @Override // com.bytedance.lynx.service.reporter.performance.ILynxPerformanceReportProcessor
    public boolean canProcess(PerformanceEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        return false;
    }

    @Override // com.bytedance.lynx.service.reporter.performance.ILynxPerformanceReportProcessor
    public void onInitialize(Context context) {
        ILynxPerformanceReportProcessor.DefaultImpls.onInitialize(this, context);
    }

    @Override // com.bytedance.lynx.service.reporter.performance.ILynxPerformanceReportProcessor
    public Map<String, Object> processPerformanceEntry(PerformanceEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = entry.entryType;
        if (!Intrinsics.areEqual(str, "pipeline")) {
            return Intrinsics.areEqual(str, "metric") ? processMetricEntry(entry) : linkedHashMap;
        }
        String str2 = entry.name;
        if (str2 != null) {
            if ((r1 = str2.hashCode()) != -701686520) {
                this.mLoadBundleEntry = entry.toHashMap();
            }
        }
        Map<String, Object> processPipelineEntry = processPipelineEntry(entry);
        processPipelineEntry.putAll(calculateCustomMetrics(entry));
        return processPipelineEntry;
    }

    private final Map<String, Object> processMetricEntry(PerformanceEntry entry) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        HashMap<String, Object> originHashMap = entry.toHashMap();
        Intrinsics.checkNotNullExpressionValue(originHashMap, "originHashMap");
        for (Map.Entry<String, Object> entry2 : originHashMap.entrySet()) {
            String key = entry2.getKey();
            Object value = entry2.getValue();
            if (key != null && (value instanceof HashMap)) {
                Map map = (Map) value;
                Object obj = map.get("duration");
                if (obj != null) {
                    linkedHashMap.put(key, obj);
                }
                Object obj2 = map.get(KEY_START_TIMESTAMP_NAME);
                if (obj2 != null) {
                    linkedHashMap.put(key + SUFFIX_START_TIMESTAMP_NAME, obj2);
                }
                Object obj3 = map.get(KEY_END_TIMESTAMP_NAME);
                if (obj3 != null) {
                    linkedHashMap.put(key + SUFFIX_END_TIMESTAMP_NAME, obj3);
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                Intrinsics.checkNotNullExpressionValue(value, "value");
                linkedHashMap.put(key, value);
            }
        }
        return linkedHashMap;
    }

    private final Map<String, Object> processPipelineEntry(PerformanceEntry entry) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        HashMap<String, Object> originHashMap = entry.toHashMap();
        LynxPerformanceReportProcessorUtils lynxPerformanceReportProcessorUtils = LynxPerformanceReportProcessorUtils.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(originHashMap, "originHashMap");
        linkedHashMap.putAll(LynxPerformanceReportProcessorUtils.processEntry$default(lynxPerformanceReportProcessorUtils, originHashMap, "Start", KEY_END_SUFFIX, null, 8, null));
        return linkedHashMap;
    }

    private final Map<String, Object> calculateCustomMetrics(PerformanceEntry entry) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        HashMap<String, Object> hashMap = entry.toHashMap();
        Object obj = hashMap.get(MTS_RENDER_START);
        Number number = obj instanceof Number ? (Number) obj : null;
        Object obj2 = hashMap.get("pipelineStart");
        Number number2 = obj2 instanceof Number ? (Number) obj2 : null;
        Object obj3 = hashMap.get(LAYOUT_UI_OPERATION_EXECUTE_END);
        Number number3 = obj3 instanceof Number ? (Number) obj3 : null;
        Object obj4 = hashMap.get("paintEnd");
        Number number4 = obj4 instanceof Number ? (Number) obj4 : null;
        HashMap<String, Object> hashMap2 = this.mLoadBundleEntry;
        Object obj5 = hashMap2 != null ? hashMap2.get("paintEnd") : null;
        linkedHashMap.put(UPDATE_WAITING, LynxPerformanceReportProcessorUtils.INSTANCE.calculateDuration(obj5 instanceof Number ? (Number) obj5 : null, number2));
        linkedHashMap.put(PAINT_WAITING, LynxPerformanceReportProcessorUtils.INSTANCE.calculateDuration(number3, number4));
        linkedHashMap.put(TRIGGER_WAITING, LynxPerformanceReportProcessorUtils.INSTANCE.calculateDuration(number2, number));
        Object obj6 = hashMap.get("paintEnd");
        if (obj6 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Number");
        }
        linkedHashMap.put("paintEnd", (Number) obj6);
        return linkedHashMap;
    }
}

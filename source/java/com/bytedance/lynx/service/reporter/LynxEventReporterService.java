package com.bytedance.lynx.service.reporter;

import android.content.Context;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.lynx.service.model.LynxServiceConfig;
import com.bytedance.lynx.service.reporter.performance.ILynxPerformanceReportProcessor;
import com.bytedance.lynx.service.reporter.performance.LynxDefaultPerformanceReportProcessor;
import com.bytedance.lynx.service.reporter.performance.LynxMemoryUsageProcessor;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import com.bytedance.lynx.service.trace.TraceEventDef;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.performance.performanceobserver.PerformanceEntry;
import com.lynx.tasm.service.ILynxEventReporterService;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: LynxEventReporterService.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016JB\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0\u001c2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/lynx/service/reporter/LynxEventReporterService;", "Lcom/lynx/tasm/service/ILynxEventReporterService;", "()V", "PERF_ENTRY_EVENT_NAME_PREFIX", "", "TAG", "defaultProcessor", "Lcom/bytedance/lynx/service/reporter/performance/LynxDefaultPerformanceReportProcessor;", "lynxServiceConfig", "Lcom/bytedance/lynx/service/model/LynxServiceConfig;", "processorList", "", "Lcom/bytedance/lynx/service/reporter/performance/ILynxPerformanceReportProcessor;", "convertBooleanToInt", "Lorg/json/JSONObject;", "jsonObject", "onInitialize", "", "context", "Landroid/content/Context;", "onPerformanceEvent", "entry", "Lcom/lynx/tasm/performance/performanceobserver/PerformanceEntry;", "onReportEvent", SchemaConstants.INNER_PARAM_EVENT_NAME, "instanceId", "", "props", "", "", "extraData", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxEventReporterService implements ILynxEventReporterService {
    public static final String PERF_ENTRY_EVENT_NAME_PREFIX = "lynxsdk_performance_entry_";
    public static final String TAG = "LynxEventReporterService";
    private static LynxServiceConfig lynxServiceConfig;
    public static final LynxEventReporterService INSTANCE = new LynxEventReporterService();
    private static List<ILynxPerformanceReportProcessor> processorList = new ArrayList();
    private static LynxDefaultPerformanceReportProcessor defaultProcessor = new LynxDefaultPerformanceReportProcessor();

    private LynxEventReporterService() {
    }

    static {
        processorList.add(new LynxTimingPerformanceReportProcessor());
        processorList.add(new LynxMemoryUsageProcessor());
    }

    public void onInitialize(Context context) {
        super.onInitialize(context);
        Iterator<ILynxPerformanceReportProcessor> it = processorList.iterator();
        while (it.hasNext()) {
            it.next().onInitialize(context);
        }
    }

    public void onReportEvent(String eventName, int instanceId, Map<String, ? extends Object> props, Map<String, ? extends Object> extraData) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        Intrinsics.checkNotNullParameter(props, "props");
        TraceEvent.beginSection(TraceEventDef.EVENT_REPORTER_SERVICE_REPORT_EVENT);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (extraData != null) {
            linkedHashMap.putAll(extraData);
        }
        linkedHashMap.putAll(props);
        AppLogNewUtils.onEventV3(eventName, convertBooleanToInt(new JSONObject(linkedHashMap)));
        TraceEvent.endSection(TraceEventDef.EVENT_REPORTER_SERVICE_REPORT_EVENT);
    }

    public final JSONObject convertBooleanToInt(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        JSONObject jSONObject = new JSONObject();
        Iterator<String> keys = jsonObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "jsonObject.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jsonObject.get(next);
            if (obj instanceof Boolean) {
                jSONObject.put(next, ((Boolean) obj).booleanValue() ? 1 : 0);
            } else {
                jSONObject.put(next, obj);
            }
        }
        return jSONObject;
    }

    public void onPerformanceEvent(PerformanceEntry entry) {
        Map<String, Object> processPerformanceEntry;
        Intrinsics.checkNotNullParameter(entry, "entry");
        String str = PERF_ENTRY_EVENT_NAME_PREFIX + entry.entryType;
        boolean z = false;
        for (ILynxPerformanceReportProcessor iLynxPerformanceReportProcessor : processorList) {
            if (iLynxPerformanceReportProcessor.canProcess(entry)) {
                Map<String, Object> processPerformanceEntry2 = iLynxPerformanceReportProcessor.processPerformanceEntry(entry);
                if (processPerformanceEntry2 != null) {
                    AppLogNewUtils.onEventV3(str, INSTANCE.convertBooleanToInt(new JSONObject(processPerformanceEntry2)));
                }
                z = true;
            }
        }
        if (z || !defaultProcessor.canProcess(entry) || (processPerformanceEntry = defaultProcessor.processPerformanceEntry(entry)) == null) {
            return;
        }
        AppLogNewUtils.onEventV3(str, INSTANCE.convertBooleanToInt(new JSONObject(processPerformanceEntry)));
    }
}

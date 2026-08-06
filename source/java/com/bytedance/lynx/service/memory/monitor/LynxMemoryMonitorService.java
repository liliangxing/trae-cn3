package com.bytedance.lynx.service.memory.monitor;

import android.content.Context;
import com.bytedance.ies.bullet.service.base.utils.XConstant;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.perf.monitor.ReportConst;
import com.lynx.devtoolwrapper.MemoryListener;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.service.ILynxMemoryMonitorService;
import com.lynx.tasm.service.LynxMemoryInfo;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: LynxMemoryMonitorService.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0017J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J0\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0002J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aH\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/lynx/service/memory/monitor/LynxMemoryMonitorService;", "Lcom/lynx/tasm/service/ILynxMemoryMonitorService;", "()V", "event_name", "", "reportTargetHandlers", "", "Lcom/bytedance/lynx/service/memory/monitor/LynxMemoryMonitorService$IReportTargetHandler;", "dumpMemoryAllocationReport", "", "isBaseline", "", "payload", "Lorg/json/JSONObject;", "formatDataForAppLog", "data", "Lcom/lynx/tasm/service/LynxMemoryInfo;", "formatDataForDevtool", "innerFormatData", "lynxInfoData", "imageInfoData", "imageMetric", LynxMonitorService.KEY_TIME_METRICS, "reportMemoryUsage", "startTrackMemoryAllocation", "applicationContext", "Landroid/content/Context;", "IReportTargetHandler", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxMemoryMonitorService implements ILynxMemoryMonitorService {
    public static final String event_name = "lynx_allocate_memory";
    public static final LynxMemoryMonitorService INSTANCE = new LynxMemoryMonitorService();
    private static final List<IReportTargetHandler> reportTargetHandlers = CollectionsKt.listOf(new IReportTargetHandler[]{new IReportTargetHandler() { // from class: com.bytedance.lynx.service.memory.monitor.LynxMemoryMonitorService$reportTargetHandlers$1
        @Override // com.bytedance.lynx.service.memory.monitor.LynxMemoryMonitorService.IReportTargetHandler
        public boolean enableReport() {
            return MemoryListener.getInstance().hasAvailableReporter();
        }

        @Override // com.bytedance.lynx.service.memory.monitor.LynxMemoryMonitorService.IReportTargetHandler
        public JSONObject prepareData(LynxMemoryInfo data) {
            JSONObject formatDataForDevtool;
            Intrinsics.checkNotNullParameter(data, "data");
            formatDataForDevtool = LynxMemoryMonitorService.INSTANCE.formatDataForDevtool(data);
            return formatDataForDevtool;
        }

        @Override // com.bytedance.lynx.service.memory.monitor.LynxMemoryMonitorService.IReportTargetHandler
        public void reportData(JSONObject data) {
            Intrinsics.checkNotNullParameter(data, "data");
            MemoryListener.getInstance().uploadImageInfo(data);
        }
    }, new IReportTargetHandler() { // from class: com.bytedance.lynx.service.memory.monitor.LynxMemoryMonitorService$reportTargetHandlers$2
        @Override // com.bytedance.lynx.service.memory.monitor.LynxMemoryMonitorService.IReportTargetHandler
        public boolean enableReport() {
            return LynxEnv.inst().enableImageMemoryReport();
        }

        @Override // com.bytedance.lynx.service.memory.monitor.LynxMemoryMonitorService.IReportTargetHandler
        public JSONObject prepareData(LynxMemoryInfo data) {
            JSONObject formatDataForAppLog;
            Intrinsics.checkNotNullParameter(data, "data");
            formatDataForAppLog = LynxMemoryMonitorService.INSTANCE.formatDataForAppLog(data);
            return formatDataForAppLog;
        }

        @Override // com.bytedance.lynx.service.memory.monitor.LynxMemoryMonitorService.IReportTargetHandler
        public void reportData(JSONObject data) {
            Intrinsics.checkNotNullParameter(data, "data");
            AppLogNewUtils.onEventV3(LynxMemoryMonitorService.event_name, data);
        }
    }});

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LynxMemoryMonitorService.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/bytedance/lynx/service/memory/monitor/LynxMemoryMonitorService$IReportTargetHandler;", "", "enableReport", "", "prepareData", "Lorg/json/JSONObject;", "data", "Lcom/lynx/tasm/service/LynxMemoryInfo;", "reportData", "", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface IReportTargetHandler {
        boolean enableReport();

        JSONObject prepareData(LynxMemoryInfo data);

        void reportData(JSONObject data);
    }

    public void dumpMemoryAllocationReport(boolean isBaseline, JSONObject payload) {
    }

    public void startTrackMemoryAllocation(Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
    }

    private LynxMemoryMonitorService() {
    }

    private final void innerFormatData(LynxMemoryInfo data, JSONObject lynxInfoData, JSONObject imageInfoData, JSONObject imageMetric, JSONObject timeMetrics) {
        lynxInfoData.put("type", data.getType());
        if (data.getSessionId() != null) {
            lynxInfoData.put(XConstant.SESSION_ID, data.getSessionId());
        }
        lynxInfoData.put(ReportConst.KEY_TIMESTAMP, String.valueOf(data.getFinishTimeStamp()));
        if (data.getPhase() != null) {
            lynxInfoData.put("phase", data.getPhase());
        }
        if (data.getTemplateURL() != null) {
            lynxInfoData.put("template_url", data.getTemplateURL());
            imageMetric.put("url", data.getTemplateURL());
        }
        imageInfoData.put(LynxMonitorService.KEY_IMAGE_URL, data.getResourceURL());
        imageInfoData.put(LynxMonitorService.KEY_MEMORY_COST_FROM, data.getMemoryCost());
        long viewWidth = data.getViewWidth();
        if (viewWidth <= 0) {
            viewWidth = -1;
        }
        imageMetric.put("viewWidth", viewWidth);
        long viewHeight = data.getViewHeight();
        if (viewHeight <= 0) {
            viewHeight = -1;
        }
        imageMetric.put("viewHeight", viewHeight);
        long width = data.getWidth();
        if (width <= 0) {
            width = -1;
        }
        imageMetric.put("width", width);
        long height = data.getHeight();
        imageMetric.put("height", height > 0 ? height : -1L);
        String config = data.getConfig();
        if (config != null) {
            imageMetric.put("config", config);
        }
        imageMetric.put("flattenAnim", data.getIsFlattenAnim());
        imageInfoData.put("metric", imageMetric);
        imageInfoData.put(LynxMonitorService.KEY_SUCCESS_RATE, data.getIsSuccess());
        timeMetrics.put("fetchTime", data.getFetchDuration() / 1000.0d);
        timeMetrics.put("completeTime", data.getCompleteDuration() / 1000.0d);
        timeMetrics.put("fetchTimeStamp", data.getStartTimeStamp() / 1000.0d);
        timeMetrics.put("finishTimeStamp", data.getFinishTimeStamp() / 1000.0d);
        imageInfoData.put(LynxMonitorService.KEY_TIME_METRICS, timeMetrics);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject formatDataForDevtool(LynxMemoryInfo data) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        innerFormatData(data, jSONObject, jSONObject2, jSONObject3, jSONObject4);
        jSONObject.put("image_info", jSONObject2);
        jSONObject.put("metric", jSONObject3);
        jSONObject.put(LynxMonitorService.KEY_TIME_METRICS, jSONObject4);
        jSONObject.put(SchemaConstants.QUERY_KEY_RES_URL, data.getResourceURL());
        jSONObject.put(LynxMonitorService.KEY_IMAGE_URL, data.getResourceURL());
        jSONObject.put(LynxMonitorService.KEY_MEMORY_COST_FROM, Float.valueOf(data.getMemoryCost()));
        jSONObject.put("is_memory", false);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject formatDataForAppLog(LynxMemoryInfo data) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        innerFormatData(data, jSONObject, jSONObject2, new JSONObject(), new JSONObject());
        jSONObject.put("image_info", jSONObject2.toString());
        jSONObject.put(SchemaConstants.QUERY_KEY_RES_URL, data.getResourceURL());
        jSONObject.put(LynxMonitorService.KEY_MEMORY_COST, Float.valueOf(data.getMemoryCost()));
        return jSONObject;
    }

    public void reportMemoryUsage(LynxMemoryInfo data) {
        Intrinsics.checkNotNullParameter(data, "data");
        for (IReportTargetHandler iReportTargetHandler : reportTargetHandlers) {
            if (iReportTargetHandler.enableReport()) {
                iReportTargetHandler.reportData(iReportTargetHandler.prepareData(data));
            }
        }
    }
}

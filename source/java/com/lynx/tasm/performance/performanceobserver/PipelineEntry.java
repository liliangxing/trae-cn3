package com.lynx.tasm.performance.performanceobserver;

import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import com.lynx.tasm.performance.timing.TimingConstants;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class PipelineEntry extends PerformanceEntry {
    public HashMap<String, Object> frameworkRenderingTiming;
    public HostPlatformTiming hostPlatformTiming;
    public String identifier;
    public double layoutEnd;
    public double layoutStart;
    public double layoutUiOperationExecuteEnd;
    public double layoutUiOperationExecuteStart;
    public double mtsRenderEnd;
    public double mtsRenderStart;
    public double paintEnd;
    public double paintingUiOperationExecuteEnd;
    public double paintingUiOperationExecuteStart;
    public double pipelineEnd;
    public double pipelineStart;
    public double resolveEnd;
    public double resolveStart;

    public PipelineEntry(HashMap<String, Object> hashMap) {
        super(hashMap);
        this.identifier = hashMap.get("identifier") != null ? (String) hashMap.get("identifier") : "";
        this.pipelineStart = hashMap.get("pipelineStart") != null ? ((Double) hashMap.get("pipelineStart")).doubleValue() : -1.0d;
        this.pipelineEnd = hashMap.get("pipelineEnd") != null ? ((Double) hashMap.get("pipelineEnd")).doubleValue() : -1.0d;
        this.mtsRenderStart = hashMap.get(LynxTimingPerformanceReportProcessor.MTS_RENDER_START) != null ? ((Double) hashMap.get(LynxTimingPerformanceReportProcessor.MTS_RENDER_START)).doubleValue() : -1.0d;
        this.mtsRenderEnd = hashMap.get("mtsRenderEnd") != null ? ((Double) hashMap.get("mtsRenderEnd")).doubleValue() : -1.0d;
        this.resolveStart = hashMap.get("resolveStart") != null ? ((Double) hashMap.get("resolveStart")).doubleValue() : -1.0d;
        this.resolveEnd = hashMap.get("resolveEnd") != null ? ((Double) hashMap.get("resolveEnd")).doubleValue() : -1.0d;
        this.layoutStart = hashMap.get(TimingConstants.HOST_PLATFORM_LAYOUT_START) != null ? ((Double) hashMap.get(TimingConstants.HOST_PLATFORM_LAYOUT_START)).doubleValue() : -1.0d;
        this.layoutEnd = hashMap.get(TimingConstants.HOST_PLATFORM_LAYOUT_END) != null ? ((Double) hashMap.get(TimingConstants.HOST_PLATFORM_LAYOUT_END)).doubleValue() : -1.0d;
        this.paintingUiOperationExecuteStart = hashMap.get("paintingUiOperationExecuteStart") != null ? ((Double) hashMap.get("paintingUiOperationExecuteStart")).doubleValue() : -1.0d;
        this.paintingUiOperationExecuteEnd = hashMap.get("paintingUiOperationExecuteEnd") != null ? ((Double) hashMap.get("paintingUiOperationExecuteEnd")).doubleValue() : -1.0d;
        this.layoutUiOperationExecuteStart = hashMap.get("layoutUiOperationExecuteStart") != null ? ((Double) hashMap.get("layoutUiOperationExecuteStart")).doubleValue() : -1.0d;
        this.layoutUiOperationExecuteEnd = hashMap.get(LynxTimingPerformanceReportProcessor.LAYOUT_UI_OPERATION_EXECUTE_END) != null ? ((Double) hashMap.get(LynxTimingPerformanceReportProcessor.LAYOUT_UI_OPERATION_EXECUTE_END)).doubleValue() : -1.0d;
        this.paintEnd = hashMap.get("paintEnd") != null ? ((Double) hashMap.get("paintEnd")).doubleValue() : -1.0d;
        this.frameworkRenderingTiming = hashMap.get(LynxTimingPerformanceReportProcessor.FRAMEWORK_RENDERING_TIMING) != null ? (HashMap) hashMap.get(LynxTimingPerformanceReportProcessor.FRAMEWORK_RENDERING_TIMING) : new HashMap<>();
        this.hostPlatformTiming = hashMap.get("hostPlatformTiming") != null ? new HostPlatformTiming((HashMap) hashMap.get("hostPlatformTiming")) : new HostPlatformTiming(new HashMap());
    }
}

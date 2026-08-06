package com.bytedance.android.anniex.detect;

import com.bytedance.android.anniex.ability.service.TaskConfig;
import com.bytedance.android.anniex.detect.detection.DetectionConstants;
import com.bytedance.android.anniex.pitaya.PitayaPackageInfo;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.pitaya.StrategyError;
import com.bytedance.framwork.core.sdklib.apm6.downgrade.DowngradeInfo;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AnnieXBlankDetectMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002JD\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0016\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/anniex/detect/AnnieXBlankDetectMonitor;", "", "()V", "getErrorType", "", "detectionStatus", "Lcom/bytedance/android/anniex/detect/DetectionStatus;", "reportAnnieXModelInferenceResult", "", DowngradeInfo.FIELD_DURATION, "", StrategyConstants.RESULT, "success", "", "taskConfig", "Lcom/bytedance/android/anniex/ability/service/TaskConfig;", "error", "Lcom/bytedance/android/anniex/pitaya/StrategyError;", "outputDataPTY", "Lorg/json/JSONObject;", "packageInfo", "Lcom/bytedance/android/anniex/pitaya/PitayaPackageInfo;", "reportBlankDetectResult", "config", "Lcom/bytedance/android/anniex/detect/BlankDetectorItemConfig;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXBlankDetectMonitor {
    public static final AnnieXBlankDetectMonitor INSTANCE = new AnnieXBlankDetectMonitor();

    private AnnieXBlankDetectMonitor() {
    }

    public final void reportAnnieXModelInferenceResult(long duration, String result, boolean success, TaskConfig taskConfig, StrategyError error, JSONObject outputDataPTY, PitayaPackageInfo packageInfo) {
        Intrinsics.checkNotNullParameter(result, StrategyConstants.RESULT);
        Intrinsics.checkNotNullParameter(taskConfig, "taskConfig");
        IMonitorReportService iMonitorReportService = ServiceCenter.Companion.instance().get(IMonitorReportService.class);
        if (iMonitorReportService != null) {
            ReportInfo reportInfo = new ReportInfo(DetectionConstants.BDX_MONITOR_MODEL_EXECUTE_RESULT, (String) null, (String) null, (JSONObject) null, (JSONObject) null, (Boolean) null, (JSONObject) null, (JSONObject) null, 254, (DefaultConstructorMarker) null);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DowngradeInfo.FIELD_DURATION, duration);
            jSONObject.put(StrategyConstants.RESULT, result);
            jSONObject.put("success", success);
            jSONObject.put("task_name", taskConfig.getBusinessName());
            jSONObject.put("error", String.valueOf(error));
            jSONObject.put("output_data_pty", outputDataPTY);
            jSONObject.put("package_info", String.valueOf(packageInfo));
            reportInfo.setCategory(jSONObject);
            iMonitorReportService.report(reportInfo);
        }
    }

    public final void reportBlankDetectResult(DetectionStatus detectionStatus, BlankDetectorItemConfig config) {
        Intrinsics.checkNotNullParameter(detectionStatus, "detectionStatus");
        Intrinsics.checkNotNullParameter(config, "config");
        IMonitorReportService iMonitorReportService = ServiceCenter.Companion.instance().get(IMonitorReportService.class);
        if (iMonitorReportService != null) {
            ReportInfo reportInfo = new ReportInfo(DetectionConstants.BDX_MONITOR_BLANK_DETECT_RESULT, (String) null, (String) null, (JSONObject) null, (JSONObject) null, (Boolean) null, (JSONObject) null, (JSONObject) null, 254, (DefaultConstructorMarker) null);
            reportInfo.setPageIdentifier(config.getIdentifier());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("is_detect_finish", detectionStatus.getIsDetectFinish());
            jSONObject.put("is_pitaya_ready", detectionStatus.getIsPitayaReady());
            jSONObject.put("is_enable_pure_blank_check", detectionStatus.getIsEnablePureBlankCheck());
            jSONObject.put("is_enable_partial_blank_check", detectionStatus.getIsEnablePartialBlankCheck());
            jSONObject.put("is_pitaya_ready", detectionStatus.getIsPitayaReady());
            jSONObject.put("is_blank", detectionStatus.isBlank());
            jSONObject.put("is_pixel_copy_success", detectionStatus.getIsPixelCopySuccess());
            jSONObject.put("is_pixel_copy_cost", detectionStatus.getIsPixelCopyCost());
            jSONObject.put("is_pure_blank", detectionStatus.getIsPureBlank());
            jSONObject.put("is_pure_blank_timeout", detectionStatus.getIsPureBlankTimeout());
            jSONObject.put("pure_blank_cost", detectionStatus.getPureBlankCost());
            jSONObject.put("is_partial_blank", detectionStatus.getIsPartialBlank());
            jSONObject.put("is_partial_blank_timeout", detectionStatus.getIsPartialBlankTimeout());
            jSONObject.put("partial_blank_cost", detectionStatus.getPartialBlankCost());
            jSONObject.put(StrategyConstants.ERROR_MSG, detectionStatus.getErrorMsg().toString());
            jSONObject.put("bboxs", detectionStatus.getBboxs());
            jSONObject.put("class_labels", detectionStatus.getClassLabels());
            jSONObject.put("scores", detectionStatus.getScores());
            jSONObject.put("render_error_type", INSTANCE.getErrorType(detectionStatus));
            jSONObject.put("origin_schema_url", config.getOriginUri().toString());
            reportInfo.setCategory(jSONObject);
            reportInfo.setBizTag(config.getBdhmBid());
            iMonitorReportService.report(reportInfo);
        }
    }

    private final String getErrorType(DetectionStatus detectionStatus) {
        return detectionStatus.getIsPartialBlank() ? DetectionConstants.RENDER_TYPE_ERROR_PARTIAL : detectionStatus.getIsPureBlank() ? DetectionConstants.RENDER_TYPE_ERROR_PURE : "";
    }
}

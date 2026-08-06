package com.bytedance.android.monitorV2.checker;

import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.apm.ApmAgent;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ApmReportChecker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J&\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/monitorV2/checker/ApmReportChecker;", "", "()V", "LOG_TYPE_NORMAL", "", "LOG_TYPE_P_ONE", "LOG_TYPE_P_ZERO", "NORMAL_SET", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "P_ONE_SET", "P_ZERO_SET", "SERVICE_NAME", "immediateReport", "", "getImmediateReport", "()Z", "setImmediateReport", "(Z)V", "getLogType", "eventType", "upload", "serviceName", "containerType", "result", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ApmReportChecker {
    private static final String LOG_TYPE_NORMAL = "bd_hybrid_monitor_normal";
    private static final String LOG_TYPE_P_ONE = "bd_hybrid_monitor_p_one";
    private static final String LOG_TYPE_P_ZERO = "bd_hybrid_monitor_p_zero";
    public static final String SERVICE_NAME = "bd_hybrid_monitor_service_all_in_one";
    private static boolean immediateReport;
    public static final ApmReportChecker INSTANCE = new ApmReportChecker();
    private static final HashSet<String> P_ZERO_SET = SetsKt.hashSetOf(new String[]{ReportConst.Event.STATIC, ReportConst.Event.JS_EXCEPTION, "fetchError", "jsbError", "nativeError", "navigationStart", ReportConst.Event.STATIC_SRI, ReportConst.Event.RES_LOADER_ERROR, ReportConst.Event.RES_LOADER_ERROR_TEMPLATE, "containerError"});
    private static final HashSet<String> P_ONE_SET = SetsKt.hashSetOf(new String[]{"perf", "performance", ReportConst.Event.AJAX, "blank", "falconPerf", ReportConst.Event.RES_LOADER_PERF, ReportConst.Event.RES_LOADER_PERF_TEMPLATE});
    private static final HashSet<String> NORMAL_SET = SetsKt.hashSetOf(new String[]{"custom", "resource_performance", "jsbPerf", ReportConst.Event.JSB_PER_V2, ReportConst.Event.JSB_PAGE_VISIT});

    private ApmReportChecker() {
    }

    public final boolean getImmediateReport() {
        return immediateReport;
    }

    public final void setImmediateReport(boolean z) {
        immediateReport = z;
    }

    private final String getLogType(String eventType) {
        return P_ZERO_SET.contains(eventType) ? LOG_TYPE_P_ZERO : P_ONE_SET.contains(eventType) ? LOG_TYPE_P_ONE : LOG_TYPE_NORMAL;
    }

    public final String upload(String serviceName, String eventType, String containerType, JSONObject result) {
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(containerType, "containerType");
        Intrinsics.checkNotNullParameter(result, "result");
        if (Switches.logType.isEnabled()) {
            serviceName = getLogType(eventType);
            if (!immediateReport) {
                ApmAgent.monitorCommonLog(serviceName, result);
            }
        } else if (!immediateReport) {
            ApmAgent.monitorEvent(serviceName, null, null, result);
        }
        return serviceName;
    }
}

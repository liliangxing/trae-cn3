package com.bytedance.security.android.aopcheck.reporter;

import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.tracing.log.Fields;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: SlardarReporter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/security/android/aopcheck/reporter/SlardarReporter;", "Lcom/bytedance/security/android/aopcheck/reporter/IReporter;", "()V", "mMonitor", "Lcom/bytedance/framwork/core/sdkmonitor/SDKMonitor;", "doReport", "", Fields.EVENT, "Lcom/bytedance/security/android/aopcheck/reporter/IEvent;", "doReportInitEvnt", ReportConstant.COMMON_INIT_DURATION, "", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SlardarReporter implements IReporter {
    private SDKMonitor mMonitor;

    @Override // com.bytedance.security.android.aopcheck.reporter.IReporter
    public void doReport(IEvent event) {
        Intrinsics.checkParameterIsNotNull(event, Fields.EVENT);
        if (event instanceof AOPReportEvent) {
            JSONObject jSONObject = new JSONObject();
            AOPReportEvent aOPReportEvent = (AOPReportEvent) event;
            jSONObject.put(ReportConstant.COMMON_ACTION_TYPE, aOPReportEvent.getActionType());
            jSONObject.put(ReportConstant.COMMON_CONTENT, aOPReportEvent.getContent());
            jSONObject.put(ReportConstant.COMMON_BACKTRACE, aOPReportEvent.getBacktrace());
            if (this.mMonitor == null) {
                this.mMonitor = SDKMonitorUtils.getInstance(ReportConstant.AID);
            }
            SDKMonitor sDKMonitor = this.mMonitor;
            if (sDKMonitor != null) {
                sDKMonitor.monitorEvent(ReportConstant.AOP_REPORT_PATH_TRAVERSAL, jSONObject, (JSONObject) null, (JSONObject) null);
            }
        }
    }

    @Override // com.bytedance.security.android.aopcheck.reporter.IReporter
    public void doReportInitEvnt(long duration) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ReportConstant.COMMON_INIT_DURATION, duration);
        if (this.mMonitor == null) {
            this.mMonitor = SDKMonitorUtils.getInstance(ReportConstant.AID);
        }
        SDKMonitor sDKMonitor = this.mMonitor;
        if (sDKMonitor != null) {
            sDKMonitor.monitorEvent(ReportConstant.AOP_REPORT_INIT_DURATION, (JSONObject) null, jSONObject, (JSONObject) null);
        }
    }
}

package com.bytedance.trae.service;

import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.trace.PageLoadTrace;
import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.perf.monitor.ReportConst;
import com.bytedance.push.interfaze.ISignalReportService;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.home.privacy.PrivacyManager;
import com.bytedance.trae.platform.api.IPageLoadTrace;
import com.bytedance.trae.platform.api.ISdkApm;
import com.monitor.cloudmessage.CloudMessageManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ApmServiceImpl.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\nH\u0016J,\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\n2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH\u0016J.\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019H\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/service/ApmServiceImpl;", "Lcom/bytedance/trae/platform/api/ISdkApm;", "<init>", "()V", "handleCloudMessage", "", "payload", "", "msgHeaders", "", "", "startCpuMonitor", ReportConst.KEY_SCENE, "stopCpuMonitor", "getPageLoadTrace", "Lcom/bytedance/trae/service/ApmServiceImpl$PageLoadTraceProxy;", "pageName", "ensureNotReachHere", "msg", "t", "", "selfDefineData", "monitorEventForSlardar", ISignalReportService.BODY_KEY_EVENT, "category", "Lorg/json/JSONObject;", "metric", "extraLog", "PageLoadTraceProxy", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ApmServiceImpl implements ISdkApm {
    public static final int $stable = 0;
    public static final ApmServiceImpl INSTANCE = new ApmServiceImpl();

    private ApmServiceImpl() {
    }

    @Override // com.bytedance.trae.platform.api.ISdkApm
    public void handleCloudMessage(byte[] payload, Map<String, String> msgHeaders) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(msgHeaders, "msgHeaders");
        CloudMessageManager.getInstance().handleCloudMessage(payload, msgHeaders);
    }

    @Override // com.bytedance.trae.platform.api.ISdkApm
    public void startCpuMonitor(String scene) {
        Intrinsics.checkNotNullParameter(scene, ReportConst.KEY_SCENE);
        ApmCpuManager.getInstance().startScene(scene);
    }

    @Override // com.bytedance.trae.platform.api.ISdkApm
    public void stopCpuMonitor(String scene) {
        Intrinsics.checkNotNullParameter(scene, ReportConst.KEY_SCENE);
        ApmCpuManager.getInstance().stopScene(scene);
    }

    @Override // com.bytedance.trae.platform.api.ISdkApm
    public PageLoadTraceProxy getPageLoadTrace(String pageName) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        return new PageLoadTraceProxy(pageName);
    }

    @Override // com.bytedance.trae.platform.api.ISdkApm
    public void ensureNotReachHere(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (AppHost.Companion.isOversea() || PrivacyManager.INSTANCE.checkAgreed()) {
            EnsureManager.ensureNotReachHere(msg);
        }
    }

    @Override // com.bytedance.trae.platform.api.ISdkApm
    public void ensureNotReachHere(Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        if (AppHost.Companion.isOversea() || PrivacyManager.INSTANCE.checkAgreed()) {
            EnsureManager.ensureNotReachHere(t);
        }
    }

    @Override // com.bytedance.trae.platform.api.ISdkApm
    public void ensureNotReachHere(Throwable t, String msg) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (AppHost.Companion.isOversea() || PrivacyManager.INSTANCE.checkAgreed()) {
            EnsureManager.ensureNotReachHere(t, msg);
        }
    }

    @Override // com.bytedance.trae.platform.api.ISdkApm
    public void ensureNotReachHere(Throwable t, String msg, Map<String, String> selfDefineData) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(selfDefineData, "selfDefineData");
        if (AppHost.Companion.isOversea() || PrivacyManager.INSTANCE.checkAgreed()) {
            EnsureManager.ensureNotReachHere(t, msg, selfDefineData);
        }
    }

    @Override // com.bytedance.trae.platform.api.ISdkApm
    public void monitorEventForSlardar(String event, JSONObject category, JSONObject metric, JSONObject extraLog) {
        Intrinsics.checkNotNullParameter(event, ISignalReportService.BODY_KEY_EVENT);
        ApmAgent.monitorEvent(event, category, metric, extraLog);
    }

    /* compiled from: ApmServiceImpl.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/service/ApmServiceImpl$PageLoadTraceProxy;", "Lcom/bytedance/trae/platform/api/IPageLoadTrace;", "pageName", "", "<init>", "(Ljava/lang/String;)V", "trace", "Lcom/bytedance/apm/trace/PageLoadTrace;", "startTrace", "", "endTrace", "launchMode", "", "maxTimeMs", "", "startSpan", "spanName", "endSpan", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class PageLoadTraceProxy implements IPageLoadTrace {
        public static final int $stable = 8;
        private final PageLoadTrace trace;

        public PageLoadTraceProxy(String str) {
            Intrinsics.checkNotNullParameter(str, "pageName");
            this.trace = new PageLoadTrace(str);
        }

        @Override // com.bytedance.trae.platform.api.IPageLoadTrace
        public void startTrace() {
            this.trace.startTrace();
        }

        @Override // com.bytedance.trae.platform.api.IPageLoadTrace
        public void endTrace(int launchMode, long maxTimeMs) {
            this.trace.endTrace(launchMode, maxTimeMs);
        }

        @Override // com.bytedance.trae.platform.api.IPageLoadTrace
        public void startSpan(String spanName) {
            Intrinsics.checkNotNullParameter(spanName, "spanName");
            this.trace.startSpan(spanName);
        }

        @Override // com.bytedance.trae.platform.api.IPageLoadTrace
        public void endSpan(String spanName) {
            Intrinsics.checkNotNullParameter(spanName, "spanName");
            this.trace.endSpan(spanName);
        }
    }
}

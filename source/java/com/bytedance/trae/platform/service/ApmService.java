package com.bytedance.trae.platform.service;

import com.bytedance.perf.monitor.ReportConst;
import com.bytedance.push.interfaze.ISignalReportService;
import com.bytedance.trae.platform.ITraeSdkCommonDepend;
import com.bytedance.trae.platform.api.IPageLoadTrace;
import com.bytedance.trae.platform.api.ISdkApm;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ApmService.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J,\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u000f2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J.\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u001eH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006!"}, d2 = {"Lcom/bytedance/trae/platform/service/ApmService;", "Lcom/bytedance/trae/platform/api/ISdkApm;", "<init>", "()V", "service", "getService", "()Lcom/bytedance/trae/platform/api/ISdkApm;", "service$delegate", "Lkotlin/Lazy;", "handleCloudMessage", "", "payload", "", "msgHeaders", "", "", "startCpuMonitor", ReportConst.KEY_SCENE, "stopCpuMonitor", "getPageLoadTrace", "Lcom/bytedance/trae/platform/api/IPageLoadTrace;", "pageName", "ensureNotReachHere", "msg", "t", "", "selfDefineData", "monitorEventForSlardar", ISignalReportService.BODY_KEY_EVENT, "category", "Lorg/json/JSONObject;", "metric", "extraLog", "platform_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ApmService implements ISdkApm {
    public static final ApmService INSTANCE = new ApmService();

    /* renamed from: service$delegate, reason: from kotlin metadata */
    private static final Lazy service = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.platform.service.ApmService$$ExternalSyntheticLambda0
        public final Object invoke() {
            ISdkApm service_delegate$lambda$0;
            service_delegate$lambda$0 = ApmService.service_delegate$lambda$0();
            return service_delegate$lambda$0;
        }
    });

    private ApmService() {
    }

    private final ISdkApm getService() {
        return (ISdkApm) service.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ISdkApm service_delegate$lambda$0() {
        ITraeSdkCommonDepend iTraeSdkCommonDepend = (ITraeSdkCommonDepend) ServiceManager.get().getService(ITraeSdkCommonDepend.class);
        if (iTraeSdkCommonDepend != null) {
            return iTraeSdkCommonDepend.getApmService();
        }
        return null;
    }

    @Override // com.bytedance.trae.platform.api.ISdkApm
    public void handleCloudMessage(byte[] payload, Map<String, String> msgHeaders) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(msgHeaders, "msgHeaders");
        ISdkApm service2 = getService();
        if (service2 != null) {
            service2.handleCloudMessage(payload, msgHeaders);
        }
    }

    @Override // com.bytedance.trae.platform.api.ISdkApm
    public void startCpuMonitor(String scene) {
        Intrinsics.checkNotNullParameter(scene, ReportConst.KEY_SCENE);
        ISdkApm service2 = getService();
        if (service2 != null) {
            service2.startCpuMonitor(scene);
        }
    }

    @Override // com.bytedance.trae.platform.api.ISdkApm
    public void stopCpuMonitor(String scene) {
        Intrinsics.checkNotNullParameter(scene, ReportConst.KEY_SCENE);
        ISdkApm service2 = getService();
        if (service2 != null) {
            service2.stopCpuMonitor(scene);
        }
    }

    @Override // com.bytedance.trae.platform.api.ISdkApm
    public IPageLoadTrace getPageLoadTrace(String pageName) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        ISdkApm service2 = getService();
        if (service2 != null) {
            return service2.getPageLoadTrace(pageName);
        }
        return null;
    }

    @Override // com.bytedance.trae.platform.api.ISdkApm
    public void ensureNotReachHere(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        ISdkApm service2 = getService();
        if (service2 != null) {
            service2.ensureNotReachHere(msg);
        }
    }

    @Override // com.bytedance.trae.platform.api.ISdkApm
    public void ensureNotReachHere(Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        ISdkApm service2 = getService();
        if (service2 != null) {
            service2.ensureNotReachHere(t);
        }
    }

    @Override // com.bytedance.trae.platform.api.ISdkApm
    public void ensureNotReachHere(Throwable t, String msg) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(msg, "msg");
        ISdkApm service2 = getService();
        if (service2 != null) {
            service2.ensureNotReachHere(t, msg);
        }
    }

    @Override // com.bytedance.trae.platform.api.ISdkApm
    public void ensureNotReachHere(Throwable t, String msg, Map<String, String> selfDefineData) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(selfDefineData, "selfDefineData");
        ISdkApm service2 = getService();
        if (service2 != null) {
            service2.ensureNotReachHere(t, msg, selfDefineData);
        }
    }

    @Override // com.bytedance.trae.platform.api.ISdkApm
    public void monitorEventForSlardar(String event, JSONObject category, JSONObject metric, JSONObject extraLog) {
        Intrinsics.checkNotNullParameter(event, ISignalReportService.BODY_KEY_EVENT);
        ISdkApm service2 = getService();
        if (service2 != null) {
            service2.monitorEventForSlardar(event, category, metric, extraLog);
        }
    }
}

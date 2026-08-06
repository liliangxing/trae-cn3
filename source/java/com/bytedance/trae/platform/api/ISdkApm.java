package com.bytedance.trae.platform.api;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ISdkApm.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH&J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\bH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\bH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\bH&J,\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H&J.\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017H\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/platform/api/ISdkApm;", "", "handleCloudMessage", "", "payload", "", "msgHeaders", "", "", "startCpuMonitor", "scene", "stopCpuMonitor", "getPageLoadTrace", "Lcom/bytedance/trae/platform/api/IPageLoadTrace;", "pageName", "ensureNotReachHere", "msg", "t", "", "selfDefineData", "monitorEventForSlardar", "event", "category", "Lorg/json/JSONObject;", "metric", "extraLog", "platform_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ISdkApm {

    /* compiled from: ISdkApm.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void monitorEventForSlardar(ISdkApm iSdkApm, String event, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
            Intrinsics.checkNotNullParameter(event, "event");
        }
    }

    void ensureNotReachHere(String msg);

    void ensureNotReachHere(Throwable t);

    void ensureNotReachHere(Throwable t, String msg);

    void ensureNotReachHere(Throwable t, String msg, Map<String, String> selfDefineData);

    IPageLoadTrace getPageLoadTrace(String pageName);

    void handleCloudMessage(byte[] payload, Map<String, String> msgHeaders);

    void monitorEventForSlardar(String event, JSONObject category, JSONObject metric, JSONObject extraLog);

    void startCpuMonitor(String scene);

    void stopCpuMonitor(String scene);
}

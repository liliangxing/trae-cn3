package com.bytedance.android.anniex.monitor.salamander;

import android.webkit.JavascriptInterface;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.salamander.anniex.SLAnnieXMonitor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: SLMonitorWebViewBridge.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0007J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0007R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/anniex/monitor/salamander/SLMonitorWebViewBridge;", "", "sessionId", "", "(Ljava/lang/String;)V", "TAG", "getSessionId", "()Ljava/lang/String;", "config", "", "configString", "reportJSError", "reportString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SLMonitorWebViewBridge {
    private final String TAG;
    private final String sessionId;

    public SLMonitorWebViewBridge(String str) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        this.sessionId = str;
        this.TAG = "SLMonitorWebViewBridge";
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    @JavascriptInterface
    public final void config(String configString) {
        Object obj;
        Intrinsics.checkNotNullParameter(configString, "configString");
        try {
            Result.Companion companion = Result.Companion;
            MonitorLog.i(this.TAG, "config: " + configString);
            JSONObject safeToJsonOb = JsonUtils.safeToJsonOb(configString);
            SLAnnieXMonitor monitorWithSessionId = SLMonitorCompatKt.getSLMonitorManager().getMonitorWithSessionId(this.sessionId);
            SLJSONUtils sLJSONUtils = SLJSONUtils.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(safeToJsonOb, "jsonObject");
            SLAnnieXMonitor.collectJSBaseField$default(monitorWithSessionId, sLJSONUtils.jsonToMap(safeToJsonOb), (Function1) null, 2, (Object) null);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            MonitorLog.e(this.TAG, "config failed, exception is " + th2);
        }
    }

    @JavascriptInterface
    public final void reportJSError(String reportString) {
        Object obj;
        Intrinsics.checkNotNullParameter(reportString, "reportString");
        try {
            Result.Companion companion = Result.Companion;
            SLMonitorWebViewBridge sLMonitorWebViewBridge = this;
            MonitorLog.i(this.TAG, "reportJSError: " + reportString);
            SLMonitorCompatKt.getSLMonitorManager().getMonitorWithSessionId(this.sessionId).reportWebJSException(reportString);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            MonitorLog.e(this.TAG, "reportJSError failed, exception is " + th2);
        }
    }
}

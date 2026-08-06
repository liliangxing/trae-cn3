package com.bytedance.sdk.xbridge.cn.utils;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: XBridgeInjectLogger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007J,\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007JR\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00132\b\b\u0002\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0007J,\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007JR\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00132\b\b\u0002\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0007J.\u0010\u0016\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0002J,\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/utils/XBridgeInjectLogger;", "", "()V", "BRIDGE_PARAM", "", "BRIDGE_PREPARE", "BRIDGE_PROCESSING", "BRIDGE_RESULT", "BULLET_SDK_TAG", "CALL_ID", "SESSION_ID", "d", "", "methodName", "msg", "bridgeStatus", "sessionId", "e", ReportConstant.COMMON_CONTENT, "", XBridgeInjectLogger.CALL_ID, "i", "parseLogMessage", "w", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XBridgeInjectLogger {
    public static final String BRIDGE_PARAM = "BridgeParam";
    public static final String BRIDGE_PREPARE = "BridgePrepare";
    public static final String BRIDGE_PROCESSING = "BridgeProcessing";
    public static final String BRIDGE_RESULT = "BridgeResult";
    public static final String BULLET_SDK_TAG = "BulletSdk";
    public static final String CALL_ID = "callId";
    public static final XBridgeInjectLogger INSTANCE = new XBridgeInjectLogger();
    public static final String SESSION_ID = "bulletSession";

    private XBridgeInjectLogger() {
    }

    public static /* synthetic */ void d$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        m171d(str, str2, str3, str4);
    }

    @JvmStatic
    /* renamed from: d */
    public static final void m171d(String methodName, String msg, String bridgeStatus, String sessionId) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(bridgeStatus, "bridgeStatus");
        try {
            Result.Companion companion = Result.Companion;
            XBridgeInject.INSTANCE.getLogger().mo156d(INSTANCE.parseLogMessage(methodName, msg, bridgeStatus, sessionId));
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public static /* synthetic */ void e$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        m172e(str, str2, str3, str4);
    }

    @JvmStatic
    /* renamed from: e */
    public static final void m172e(String methodName, String msg, String bridgeStatus, String sessionId) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(bridgeStatus, "bridgeStatus");
        try {
            Result.Companion companion = Result.Companion;
            XBridgeInject.INSTANCE.getLogger().mo157e(INSTANCE.parseLogMessage(methodName, msg, bridgeStatus, sessionId));
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public static /* synthetic */ void w$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        m176w(str, str2, str3, str4);
    }

    @JvmStatic
    /* renamed from: w */
    public static final void m176w(String methodName, String msg, String bridgeStatus, String sessionId) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(bridgeStatus, "bridgeStatus");
        try {
            Result.Companion companion = Result.Companion;
            XBridgeInject.INSTANCE.getLogger().mo159w(INSTANCE.parseLogMessage(methodName, msg, bridgeStatus, sessionId));
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public static /* synthetic */ void i$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        m174i(str, str2, str3, str4);
    }

    @JvmStatic
    /* renamed from: i */
    public static final void m174i(String methodName, String msg, String bridgeStatus, String sessionId) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(bridgeStatus, "bridgeStatus");
        try {
            Result.Companion companion = Result.Companion;
            XBridgeInject.INSTANCE.getLogger().mo158i(INSTANCE.parseLogMessage(methodName, msg, bridgeStatus, sessionId));
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e A[Catch: all -> 0x0077, TryCatch #0 {all -> 0x0077, blocks: (B:3:0x0015, B:6:0x0021, B:8:0x0026, B:14:0x0034, B:17:0x004b, B:21:0x003e, B:23:0x001b), top: B:2:0x0015 }] */
    @JvmStatic
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m175i(String methodName, String msg, Map<String, ? extends Object> content, String bridgeStatus, String sessionId, String callId) {
        boolean z;
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(bridgeStatus, "bridgeStatus");
        try {
            Result.Companion companion = Result.Companion;
            JSONObject jSONObject = content == null ? null : new JSONObject(content);
            String str = callId;
            if (str != null && str.length() != 0) {
                z = false;
                if (!z && jSONObject != null) {
                    jSONObject.put(CALL_ID, callId);
                }
                XBridgeInject.INSTANCE.getLogger().mo158i(INSTANCE.parseLogMessage(methodName, "xMsg:" + msg + '|' + (jSONObject != null ? "" : "xContent:" + jSONObject), bridgeStatus, sessionId));
                Result.constructor-impl(Unit.INSTANCE);
            }
            z = true;
            if (!z) {
                jSONObject.put(CALL_ID, callId);
            }
            XBridgeInject.INSTANCE.getLogger().mo158i(INSTANCE.parseLogMessage(methodName, "xMsg:" + msg + '|' + (jSONObject != null ? "" : "xContent:" + jSONObject), bridgeStatus, sessionId));
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e A[Catch: all -> 0x0077, TryCatch #0 {all -> 0x0077, blocks: (B:3:0x0015, B:6:0x0021, B:8:0x0026, B:14:0x0034, B:17:0x004b, B:21:0x003e, B:23:0x001b), top: B:2:0x0015 }] */
    @JvmStatic
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m173e(String methodName, String msg, Map<String, ? extends Object> content, String bridgeStatus, String sessionId, String callId) {
        boolean z;
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(bridgeStatus, "bridgeStatus");
        try {
            Result.Companion companion = Result.Companion;
            JSONObject jSONObject = content == null ? null : new JSONObject(content);
            String str = callId;
            if (str != null && str.length() != 0) {
                z = false;
                if (!z && jSONObject != null) {
                    jSONObject.put(CALL_ID, callId);
                }
                XBridgeInject.INSTANCE.getLogger().mo157e(INSTANCE.parseLogMessage(methodName, "xMsg:" + msg + '|' + (jSONObject != null ? "" : "xContent:" + jSONObject), bridgeStatus, sessionId));
                Result.constructor-impl(Unit.INSTANCE);
            }
            z = true;
            if (!z) {
                jSONObject.put(CALL_ID, callId);
            }
            XBridgeInject.INSTANCE.getLogger().mo157e(INSTANCE.parseLogMessage(methodName, "xMsg:" + msg + '|' + (jSONObject != null ? "" : "xContent:" + jSONObject), bridgeStatus, sessionId));
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    static /* synthetic */ String parseLogMessage$default(XBridgeInjectLogger xBridgeInjectLogger, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        if ((i & 8) != 0) {
            str4 = "";
        }
        return xBridgeInjectLogger.parseLogMessage(str, str2, str3, str4);
    }

    private final String parseLogMessage(String methodName, String msg, String bridgeStatus, String sessionId) {
        StringBuilder sb = new StringBuilder();
        String str = sessionId;
        if (str == null || str.length() == 0) {
            sb.append("[bulletSession-unknown]");
        } else {
            sb.append("[bulletSession-" + sessionId + ']');
        }
        sb.append("[bullet-bridge][" + methodName + ']');
        String str2 = bridgeStatus;
        if (!(str2 == null || str2.length() == 0)) {
            sb.append("[" + bridgeStatus + ']');
        }
        sb.append(msg);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }
}

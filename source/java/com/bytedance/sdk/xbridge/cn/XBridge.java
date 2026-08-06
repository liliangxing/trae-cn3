package com.bytedance.sdk.xbridge.cn;

import com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod;
import com.bytedance.sdk.xbridge.cn.protocol.StatelessMethodRepository;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.MethodRepository;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeLogger;
import com.bytedance.trae.im.model.MessagePart;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridge.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0007J,\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'H\u0007J\u000e\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u0010J\u000e\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014¨\u0006,"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/XBridge;", "", "()V", "BRIDGE_CALLBACK", "", "BRIDGE_PARAM", "BRIDGE_PROCESSING", "BRIDGE_RESULT", "XBRIDGE_LOG_PREFIX", "config", "Lcom/bytedance/sdk/xbridge/cn/XBridgeConfig;", "getConfig", "()Lcom/bytedance/sdk/xbridge/cn/XBridgeConfig;", "setConfig", "(Lcom/bytedance/sdk/xbridge/cn/XBridgeConfig;)V", "debuggable", "", "getDebuggable", "()Z", "setDebuggable", "(Z)V", "enableAnnieXJsbParamInNumberAdapterFix", "getEnableAnnieXJsbParamInNumberAdapterFix", "setEnableAnnieXJsbParamInNumberAdapterFix", "hasInit", "initListener", "Lcom/bytedance/sdk/xbridge/cn/XBridgeInitListener;", "isDropLog", "setDropLog", "init", "", MessagePart.TYPE_LOG, "msg", "", "methodName", "bridgeStatus", "sessionId", "preloadStatelessMethod", "method", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "setDrop", "drop", "setInitListener", "listener", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XBridge {
    public static final String BRIDGE_CALLBACK = "BridgeCallback";
    public static final String BRIDGE_PARAM = "BridgeParam";
    public static final String BRIDGE_PROCESSING = "BridgeProcessing";
    public static final String BRIDGE_RESULT = "BridgeResult";
    private static final String XBRIDGE_LOG_PREFIX = "##BDXBridge:";
    private static boolean debuggable;
    private static volatile boolean hasInit;
    private static XBridgeInitListener initListener;
    private static volatile boolean isDropLog;
    public static final XBridge INSTANCE = new XBridge();
    private static XBridgeConfig config = new XBridgeConfig();
    private static boolean enableAnnieXJsbParamInNumberAdapterFix = true;

    private XBridge() {
    }

    public final boolean isDropLog() {
        return isDropLog;
    }

    public final void setDropLog(boolean z) {
        isDropLog = z;
    }

    public final XBridgeConfig getConfig() {
        return config;
    }

    public final void setConfig(XBridgeConfig xBridgeConfig) {
        Intrinsics.checkNotNullParameter(xBridgeConfig, "<set-?>");
        config = xBridgeConfig;
    }

    public final boolean getDebuggable() {
        return debuggable;
    }

    public final void setDebuggable(boolean z) {
        debuggable = z;
    }

    public final boolean getEnableAnnieXJsbParamInNumberAdapterFix() {
        return enableAnnieXJsbParamInNumberAdapterFix;
    }

    public final void setEnableAnnieXJsbParamInNumberAdapterFix(boolean z) {
        enableAnnieXJsbParamInNumberAdapterFix = z;
    }

    @JvmStatic
    public static final void preloadStatelessMethod(IDLXBridgeMethod method) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (method instanceof StatefulMethod) {
            log("不能提前加载stateful method: " + method.getName() + '[' + method.getClass() + ']');
        } else {
            MethodRepository.put$default(StatelessMethodRepository.INSTANCE, null, method, 1, null);
        }
    }

    public final synchronized void init(XBridgeConfig config2) {
        XBridgeConfig onInit;
        Intrinsics.checkNotNullParameter(config2, "config");
        debuggable = config2.getDebuggable();
        if (!hasInit) {
            XBridgeInitListener xBridgeInitListener = initListener;
            if (xBridgeInitListener != null && (onInit = xBridgeInitListener.onInit(config2)) != null) {
                config2 = onInit;
            }
            config = config2;
            hasInit = true;
        }
    }

    public final void setInitListener(XBridgeInitListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        initListener = listener;
    }

    public final void setDrop(boolean drop) {
        isDropLog = drop;
    }

    @JvmStatic
    public static final void log(CharSequence msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isDropLog) {
            return;
        }
        String str = "##BDXBridge: " + ((Object) msg);
        XBridgeLogger logger = config.getLogger();
        if (logger != null) {
            logger.log(str);
        }
    }

    public static /* synthetic */ void log$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        log(str, str2, str3, str4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0072, code lost:
    
        r7 = "[bulletSession-unknown]" + r7;
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void log(String methodName, String msg, String bridgeStatus, String sessionId) {
        String str;
        Unit unit;
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(bridgeStatus, "bridgeStatus");
        if (isDropLog) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            boolean z = true;
            if (bridgeStatus.length() > 0) {
                str = "[bullet-bridge][" + methodName + "][" + bridgeStatus + "] " + msg;
            } else {
                str = "[bullet-bridge][" + methodName + "] " + msg;
            }
            String str2 = sessionId;
            if (str2 != null && str2.length() != 0) {
                z = false;
            }
            String str3 = "[bulletSession-" + sessionId + ']' + str;
            XBridgeLogger logger = config.getLogger();
            if (logger != null) {
                logger.log(str3);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Result.constructor-impl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }
}

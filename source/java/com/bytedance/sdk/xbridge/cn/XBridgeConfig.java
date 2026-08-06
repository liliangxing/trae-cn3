package com.bytedance.sdk.xbridge.cn;

import com.bytedance.sdk.xbridge.cn.monitor.IMonitorReportService;
import com.bytedance.sdk.xbridge.cn.protocol.IBridgeCallInterceptor;
import com.bytedance.sdk.xbridge.cn.utils.DefaultLogger;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeLogger;
import kotlin.Metadata;

/* compiled from: XBridge.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/XBridgeConfig;", "", "()V", "bridgeLifecycle", "Lcom/bytedance/sdk/xbridge/cn/AbsBridgeLifecycleHandler;", "getBridgeLifecycle", "()Lcom/bytedance/sdk/xbridge/cn/AbsBridgeLifecycleHandler;", "setBridgeLifecycle", "(Lcom/bytedance/sdk/xbridge/cn/AbsBridgeLifecycleHandler;)V", "callInterceptor", "Lcom/bytedance/sdk/xbridge/cn/protocol/IBridgeCallInterceptor;", "getCallInterceptor", "()Lcom/bytedance/sdk/xbridge/cn/protocol/IBridgeCallInterceptor;", "setCallInterceptor", "(Lcom/bytedance/sdk/xbridge/cn/protocol/IBridgeCallInterceptor;)V", "debuggable", "", "getDebuggable", "()Z", "setDebuggable", "(Z)V", "enableAuth", "getEnableAuth", "setEnableAuth", "logger", "Lcom/bytedance/sdk/xbridge/cn/utils/XBridgeLogger;", "getLogger", "()Lcom/bytedance/sdk/xbridge/cn/utils/XBridgeLogger;", "setLogger", "(Lcom/bytedance/sdk/xbridge/cn/utils/XBridgeLogger;)V", "monitorReporter", "Lcom/bytedance/sdk/xbridge/cn/XBridgeMonitorReporter;", "getMonitorReporter", "()Lcom/bytedance/sdk/xbridge/cn/XBridgeMonitorReporter;", "setMonitorReporter", "(Lcom/bytedance/sdk/xbridge/cn/XBridgeMonitorReporter;)V", "monitorService", "Lcom/bytedance/sdk/xbridge/cn/monitor/IMonitorReportService;", "getMonitorService", "()Lcom/bytedance/sdk/xbridge/cn/monitor/IMonitorReportService;", "setMonitorService", "(Lcom/bytedance/sdk/xbridge/cn/monitor/IMonitorReportService;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class XBridgeConfig {
    private AbsBridgeLifecycleHandler bridgeLifecycle;
    private IBridgeCallInterceptor<Object, Object> callInterceptor;
    private boolean debuggable;
    private boolean enableAuth = true;
    private XBridgeLogger logger = new DefaultLogger();
    private XBridgeMonitorReporter monitorReporter;
    private IMonitorReportService monitorService;

    public final boolean getEnableAuth() {
        return this.enableAuth;
    }

    public final void setEnableAuth(boolean z) {
        this.enableAuth = z;
    }

    public final boolean getDebuggable() {
        return this.debuggable;
    }

    public final void setDebuggable(boolean z) {
        this.debuggable = z;
    }

    public final XBridgeLogger getLogger() {
        return this.logger;
    }

    public final void setLogger(XBridgeLogger xBridgeLogger) {
        this.logger = xBridgeLogger;
    }

    public final AbsBridgeLifecycleHandler getBridgeLifecycle() {
        return this.bridgeLifecycle;
    }

    public final void setBridgeLifecycle(AbsBridgeLifecycleHandler absBridgeLifecycleHandler) {
        this.bridgeLifecycle = absBridgeLifecycleHandler;
    }

    public final XBridgeMonitorReporter getMonitorReporter() {
        return this.monitorReporter;
    }

    public final void setMonitorReporter(XBridgeMonitorReporter xBridgeMonitorReporter) {
        this.monitorReporter = xBridgeMonitorReporter;
    }

    public final IBridgeCallInterceptor<Object, Object> getCallInterceptor() {
        return this.callInterceptor;
    }

    public final void setCallInterceptor(IBridgeCallInterceptor<Object, Object> iBridgeCallInterceptor) {
        this.callInterceptor = iBridgeCallInterceptor;
    }

    public final IMonitorReportService getMonitorService() {
        return this.monitorService;
    }

    public final void setMonitorService(IMonitorReportService iMonitorReportService) {
        this.monitorService = iMonitorReportService;
    }
}

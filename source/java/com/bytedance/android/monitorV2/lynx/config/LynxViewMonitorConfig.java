package com.bytedance.android.monitorV2.lynx.config;

import com.bytedance.android.monitorV2.executor.HybridMonitorExecutor;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitorConstant;
import com.bytedance.android.monitorV2.lynx.blank.LynxBlankDetect;
import com.bytedance.android.monitorV2.webview.HybridMonitorDefault;
import com.bytedance.android.monitorV2.webview.IHybridMonitor;
import java.util.concurrent.ExecutorService;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxViewMonitorConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR(\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\"\u001a\u0004\u0018\u00010#8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b*\u0010\u0013\u001a\u0004\b+\u0010\t\"\u0004\b,\u0010\u0004R\u001a\u0010-\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0019\"\u0004\b.\u0010\u001bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\t\"\u0004\b5\u0010\u0004R\u001c\u00106\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\t\"\u0004\b8\u0010\u0004R\u001c\u00109\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\t\"\u0004\b;\u0010\u0004¨\u0006<"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/config/LynxViewMonitorConfig;", "", "bid", "", "(Ljava/lang/String;)V", "monitor", "Lcom/bytedance/android/monitorV2/webview/IHybridMonitor;", "(Ljava/lang/String;Lcom/bytedance/android/monitorV2/webview/IHybridMonitor;)V", "getBid", "()Ljava/lang/String;", "setBid", "blankDetectCallback", "Lcom/bytedance/android/monitorV2/lynx/blank/LynxBlankDetect$OnLynxBlankCallback;", "getBlankDetectCallback", "()Lcom/bytedance/android/monitorV2/lynx/blank/LynxBlankDetect$OnLynxBlankCallback;", "setBlankDetectCallback", "(Lcom/bytedance/android/monitorV2/lynx/blank/LynxBlankDetect$OnLynxBlankCallback;)V", "blankDetectType", "getBlankDetectType$annotations", "()V", "getBlankDetectType", "setBlankDetectType", "enableAB", "", "getEnableAB", "()Z", "setEnableAB", "(Z)V", "enableBlankDetect", "getEnableBlankDetect", "setEnableBlankDetect", "enableMonitor", "getEnableMonitor", "setEnableMonitor", "value", "Ljava/util/concurrent/ExecutorService;", "executor", "getExecutor", "()Ljava/util/concurrent/ExecutorService;", "setExecutor", "(Ljava/util/concurrent/ExecutorService;)V", "fallbackContainerName", "getFallbackContainerName$annotations", "getFallbackContainerName", "setFallbackContainerName", "isCompactMode", "setCompactMode", "getMonitor", "()Lcom/bytedance/android/monitorV2/webview/IHybridMonitor;", "setMonitor", "(Lcom/bytedance/android/monitorV2/webview/IHybridMonitor;)V", "perfReportTime", "getPerfReportTime", "setPerfReportTime", "sessionId", "getSessionId", "setSessionId", "virtualAID", "getVirtualAID", "setVirtualAID", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LynxViewMonitorConfig {
    private String bid;
    private LynxBlankDetect.OnLynxBlankCallback blankDetectCallback;
    private String blankDetectType;
    private boolean enableAB;
    private boolean enableBlankDetect;
    private boolean enableMonitor;
    private String fallbackContainerName;
    private boolean isCompactMode;
    private IHybridMonitor monitor;
    private String perfReportTime;
    private String sessionId;
    private String virtualAID;

    @Deprecated(message = "The blank detection moment option will not be supported in the future")
    public static /* synthetic */ void getBlankDetectType$annotations() {
    }

    @Deprecated(message = "该字段已经废弃，容器名称统一为 AnnieX")
    public static /* synthetic */ void getFallbackContainerName$annotations() {
    }

    public LynxViewMonitorConfig(String str, IHybridMonitor iHybridMonitor) {
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(iHybridMonitor, "monitor");
        this.bid = str;
        this.enableMonitor = true;
        this.blankDetectType = LynxViewMonitorConstant.DETECT_WHEN_NEVER;
        this.enableBlankDetect = true;
        this.monitor = iHybridMonitor;
        this.virtualAID = "";
        this.perfReportTime = LynxViewMonitorConstant.PERF_DEFAULT;
        this.fallbackContainerName = "";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LynxViewMonitorConfig(String str) {
        this(str, new HybridMonitorDefault());
        Intrinsics.checkNotNullParameter(str, "bid");
    }

    public final String getBid() {
        return this.bid;
    }

    public final void setBid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bid = str;
    }

    public final boolean getEnableMonitor() {
        return this.enableMonitor;
    }

    public final void setEnableMonitor(boolean z) {
        this.enableMonitor = z;
    }

    public final String getBlankDetectType() {
        return this.blankDetectType;
    }

    public final void setBlankDetectType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.blankDetectType = str;
    }

    public final boolean getEnableBlankDetect() {
        return this.enableBlankDetect;
    }

    public final void setEnableBlankDetect(boolean z) {
        this.enableBlankDetect = z;
    }

    public final IHybridMonitor getMonitor() {
        return this.monitor;
    }

    public final void setMonitor(IHybridMonitor iHybridMonitor) {
        this.monitor = iHybridMonitor;
    }

    public final void setExecutor(ExecutorService executorService) {
        if (executorService != null) {
            HybridMonitorExecutor.INSTANCE.setExecutor(executorService);
        }
    }

    public final ExecutorService getExecutor() {
        return HybridMonitorExecutor.INSTANCE.getExecutor();
    }

    public final boolean getEnableAB() {
        return this.enableAB;
    }

    public final void setEnableAB(boolean z) {
        this.enableAB = z;
    }

    public final String getVirtualAID() {
        return this.virtualAID;
    }

    public final void setVirtualAID(String str) {
        this.virtualAID = str;
    }

    public final LynxBlankDetect.OnLynxBlankCallback getBlankDetectCallback() {
        return this.blankDetectCallback;
    }

    public final void setBlankDetectCallback(LynxBlankDetect.OnLynxBlankCallback onLynxBlankCallback) {
        this.blankDetectCallback = onLynxBlankCallback;
    }

    public final String getPerfReportTime() {
        return this.perfReportTime;
    }

    public final void setPerfReportTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.perfReportTime = str;
    }

    public final String getFallbackContainerName() {
        return this.fallbackContainerName;
    }

    public final void setFallbackContainerName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fallbackContainerName = str;
    }

    /* renamed from: isCompactMode, reason: from getter */
    public final boolean getIsCompactMode() {
        return this.isCompactMode;
    }

    public final void setCompactMode(boolean z) {
        this.isCompactMode = z;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId(String str) {
        this.sessionId = str;
    }
}

package com.bytedance.ies.bullet.core.common;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0005J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/core/common/DebugConfig;", "", "()V", "configMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/ies/bullet/core/common/DebugInfo;", "bind", "", "bid", "debugInfo", "get", "getDebugInfo", "getDefault", "setDebugInfo", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class DebugConfig {
    public static final DebugConfig INSTANCE = new DebugConfig();
    private static final ConcurrentHashMap<String, DebugInfo> configMap = new ConcurrentHashMap<>();

    private DebugConfig() {
    }

    public final void bind(String bid, DebugInfo debugInfo) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(debugInfo, "debugInfo");
        configMap.put(bid, debugInfo);
    }

    public final DebugInfo getDebugInfo(String bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        return configMap.get(bid);
    }

    public final void setDebugInfo(DebugInfo debugInfo) {
        Intrinsics.checkNotNullParameter(debugInfo, "debugInfo");
        bind("default_bid", debugInfo);
    }

    public final DebugInfo getDefault() {
        DebugInfo debugInfo = configMap.get("default_bid");
        return debugInfo == null ? new DebugInfo() : debugInfo;
    }

    public final DebugInfo get(String bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        DebugInfo debugInfo = configMap.get(bid);
        return debugInfo == null ? new DebugInfo() : debugInfo;
    }
}

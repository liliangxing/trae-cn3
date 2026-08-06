package com.bytedance.pitaya.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PTYDebugInfoProvider.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/pitaya/api/PTYDebugInfoProvider;", "", "()V", "debugInfo", "Lcom/bytedance/pitaya/api/IPTYDebugInfo;", "getDebugInfo", "registerDebugInfo", "", "info", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class PTYDebugInfoProvider {
    public static final PTYDebugInfoProvider INSTANCE = new PTYDebugInfoProvider();
    private static IPTYDebugInfo debugInfo;

    private PTYDebugInfoProvider() {
    }

    public final void registerDebugInfo(IPTYDebugInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        debugInfo = info;
    }

    public final IPTYDebugInfo getDebugInfo() {
        return debugInfo;
    }
}

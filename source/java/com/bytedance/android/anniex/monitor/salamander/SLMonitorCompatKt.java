package com.bytedance.android.anniex.monitor.salamander;

import com.bytedance.salamander.anniex.SLAnnieXMonitorManager;
import kotlin.Metadata;

/* compiled from: SLMonitorCompat.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"SLMonitorManager", "Lcom/bytedance/salamander/anniex/SLAnnieXMonitorManager;", "getSLMonitorManager", "()Lcom/bytedance/salamander/anniex/SLAnnieXMonitorManager;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SLMonitorCompatKt {
    private static final SLAnnieXMonitorManager SLMonitorManager = SLAnnieXMonitorManager.Companion.getInstance();

    public static final SLAnnieXMonitorManager getSLMonitorManager() {
        return SLMonitorManager;
    }
}

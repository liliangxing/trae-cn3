package com.bytedance.helios.statichook.api;

import com.bytedance.bdturing.EventReport;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimonTraceTracker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0007J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/helios/statichook/api/TimonTraceTracker;", "", "()V", "impl", "Lcom/bytedance/helios/statichook/api/ITraceTracker;", "getInvokeList", "", "", EventReport.DIALOG_POP, "", "value", "push", "setImpl", "statichook_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class TimonTraceTracker {
    public static final TimonTraceTracker INSTANCE = new TimonTraceTracker();
    private static ITraceTracker impl;

    private TimonTraceTracker() {
    }

    @JvmStatic
    public static final void setImpl(ITraceTracker impl2) {
        Intrinsics.checkParameterIsNotNull(impl2, "impl");
        impl = impl2;
    }

    @JvmStatic
    public static final void push(int value) {
        ITraceTracker iTraceTracker = impl;
        if (iTraceTracker != null) {
            iTraceTracker.push(value);
        }
    }

    @JvmStatic
    public static final void pop(int value) {
        ITraceTracker iTraceTracker = impl;
        if (iTraceTracker != null) {
            iTraceTracker.pop(value);
        }
    }

    @JvmStatic
    public static final List<Integer> getInvokeList() {
        List<Integer> invokeList;
        ITraceTracker iTraceTracker = impl;
        return (iTraceTracker == null || (invokeList = iTraceTracker.getInvokeList()) == null) ? CollectionsKt.emptyList() : invokeList;
    }
}

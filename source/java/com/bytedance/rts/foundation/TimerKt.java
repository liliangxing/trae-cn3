package com.bytedance.rts.foundation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Timer.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0010\u0010\u0004\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u001c\u0010\u0005\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\b\u001a\u00020\t\u001a\u001c\u0010\n\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\u000b"}, d2 = {"clearInterval", "", "task", "", "clearTimeout", "setInterval", "action", "Lkotlin/Function0;", "delayMillis", "", "setTimeout", "lib_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TimerKt {
    public static final Object setTimeout(Function0<Unit> function0, int i) {
        Intrinsics.checkNotNullParameter(function0, "action");
        RTSMessageLooper rTSMessageLooper = ThreadLocalLooper.INSTANCE.getLooper().get();
        Intrinsics.checkNotNullExpressionValue(rTSMessageLooper, "ThreadLocalLooper.looper.get()");
        return RTSMessageLooper.postMacroTask$lib_release$default(rTSMessageLooper, function0, i, false, 4, null);
    }

    public static final void clearTimeout(Object obj) {
        RTSMessageLooper rTSMessageLooper = ThreadLocalLooper.INSTANCE.getLooper().get();
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.bytedance.rts.foundation.Task");
        rTSMessageLooper.removeMacroTask$lib_release((Task) obj);
    }

    public static final Object setInterval(Function0<Unit> function0, int i) {
        Intrinsics.checkNotNullParameter(function0, "action");
        return ThreadLocalLooper.INSTANCE.getLooper().get().postMacroTask$lib_release(function0, i, true);
    }

    public static final void clearInterval(Object obj) {
        RTSMessageLooper rTSMessageLooper = ThreadLocalLooper.INSTANCE.getLooper().get();
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.bytedance.rts.foundation.Task");
        rTSMessageLooper.removeMacroTask$lib_release((Task) obj);
    }
}

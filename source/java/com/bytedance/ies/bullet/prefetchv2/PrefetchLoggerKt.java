package com.bytedance.ies.bullet.prefetchv2;

import com.bytedance.ies.bullet.core.BulletEnv;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrefetchLogger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¨\u0006\u0007"}, d2 = {"debugPrint", "", "getMessage", "Lkotlin/Function0;", "", "debugRun", "execute", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PrefetchLoggerKt {
    public static final void debugPrint(Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "getMessage");
        if (BulletEnv.INSTANCE.getInstance().getDebuggable()) {
            PrefetchLogger.INSTANCE.m36d((String) function0.invoke());
        }
    }

    public static final void debugRun(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "execute");
        if (BulletEnv.INSTANCE.getInstance().getDebuggable()) {
            function0.invoke();
        }
    }
}

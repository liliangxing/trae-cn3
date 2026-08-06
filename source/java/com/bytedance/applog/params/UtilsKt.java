package com.bytedance.applog.params;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¨\u0006\u0005"}, d2 = {"mainThreadRun", "", "f", "Lkotlin/Function0;", "noMainThreadRun", "params_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UtilsKt {
    public static final void noMainThreadRun(final Function0<Unit> f) {
        Intrinsics.checkNotNullParameter(f, "f");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            Executors.newSingleThreadExecutor().submit(new Runnable() { // from class: com.bytedance.applog.params.UtilsKt$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    UtilsKt.m7678noMainThreadRun$lambda0(Function0.this);
                }
            });
        } else {
            f.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: noMainThreadRun$lambda-0, reason: not valid java name */
    public static final void m7678noMainThreadRun$lambda0(Function0 f) {
        Intrinsics.checkNotNullParameter(f, "$f");
        f.invoke();
    }

    public static final void mainThreadRun(final Function0<Unit> f) {
        Intrinsics.checkNotNullParameter(f, "f");
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.applog.params.UtilsKt$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    UtilsKt.m7677mainThreadRun$lambda1(Function0.this);
                }
            });
        } else {
            f.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: mainThreadRun$lambda-1, reason: not valid java name */
    public static final void m7677mainThreadRun$lambda1(Function0 f) {
        Intrinsics.checkNotNullParameter(f, "$f");
        f.invoke();
    }
}

package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.BuildConfig;

/* compiled from: RunSuspend.kt */
@Metadata(m4d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m5d2 = {"runSuspend", BuildConfig.FLAVOR, "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "(Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, m6k = 2, m7mv = {2, 1, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class RunSuspendKt {
    public static final void runSuspend(Function1<? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        RunSuspend runSuspend = new RunSuspend();
        ContinuationKt.startCoroutine(block, runSuspend);
        runSuspend.await();
    }
}

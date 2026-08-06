package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Metadata;
import net.openid.appauth.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Future.kt */
@Metadata(m4d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u001a\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0007¨\u0006\b"}, m5d2 = {"cancelFutureOnCancellation", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CancellableContinuation;", "future", "Ljava/util/concurrent/Future;", "cancelFutureOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, m6k = 5, m7mv = {1, 9, 0}, m9xi = 48, m10xs = "kotlinx/coroutines/JobKt")
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final /* synthetic */ class JobKt__FutureKt {
    public static final DisposableHandle cancelFutureOnCompletion(Job job, Future<?> future) {
        DisposableHandle invokeOnCompletion$default;
        invokeOnCompletion$default = JobKt__JobKt.invokeOnCompletion$default(job, false, false, new CancelFutureOnCompletion(future), 3, null);
        return invokeOnCompletion$default;
    }

    public static final void cancelFutureOnCancellation(CancellableContinuation<?> cancellableContinuation, Future<?> future) {
        CancellableContinuationKt.invokeOnCancellation(cancellableContinuation, new CancelFutureOnCancel(future));
    }
}

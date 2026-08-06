package coil3.util;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: lifecycles.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0080@¢\u0006\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"awaitStarted", "", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeAndAddObserver", "observer", "Landroidx/lifecycle/LifecycleObserver;", "coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LifecyclesKt {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitStarted(Lifecycle lifecycle, Continuation<? super Unit> continuation) {
        LifecyclesKt$awaitStarted$1 lifecyclesKt$awaitStarted$1;
        int i;
        Lifecycle lifecycle2;
        Ref.ObjectRef objectRef;
        Throwable th;
        LifecycleObserver lifecycleObserver;
        LifecycleObserver lifecycleObserver2;
        if (continuation instanceof LifecyclesKt$awaitStarted$1) {
            lifecyclesKt$awaitStarted$1 = (LifecyclesKt$awaitStarted$1) continuation;
            if ((lifecyclesKt$awaitStarted$1.label & Integer.MIN_VALUE) != 0) {
                lifecyclesKt$awaitStarted$1.label -= Integer.MIN_VALUE;
                Object obj = lifecyclesKt$awaitStarted$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = lifecyclesKt$awaitStarted$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (lifecycle.getState().isAtLeast(Lifecycle.State.STARTED)) {
                        return Unit.INSTANCE;
                    }
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    try {
                        lifecyclesKt$awaitStarted$1.L$0 = lifecycle;
                        lifecyclesKt$awaitStarted$1.L$1 = objectRef2;
                        lifecyclesKt$awaitStarted$1.label = 1;
                        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted((Continuation) lifecyclesKt$awaitStarted$1), 1);
                        cancellableContinuationImpl.initCancellability();
                        final CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                        objectRef2.element = new DefaultLifecycleObserver() { // from class: coil3.util.LifecyclesKt$awaitStarted$2$1
                            @Override // androidx.lifecycle.DefaultLifecycleObserver
                            public void onStart(LifecycleOwner owner) {
                                Continuation continuation2 = cancellableContinuation;
                                Result.Companion companion = Result.Companion;
                                continuation2.resumeWith(Result.constructor-impl(Unit.INSTANCE));
                            }
                        };
                        Object obj2 = objectRef2.element;
                        Intrinsics.checkNotNull(obj2);
                        lifecycle.addObserver((LifecycleObserver) obj2);
                        Object result = cancellableContinuationImpl.getResult();
                        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended((Continuation) lifecyclesKt$awaitStarted$1);
                        }
                        if (result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        lifecycle2 = lifecycle;
                        objectRef = objectRef2;
                    } catch (Throwable th2) {
                        lifecycle2 = lifecycle;
                        objectRef = objectRef2;
                        th = th2;
                        lifecycleObserver = (LifecycleObserver) objectRef.element;
                        if (lifecycleObserver != null) {
                        }
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = (Ref.ObjectRef) lifecyclesKt$awaitStarted$1.L$1;
                    lifecycle2 = (Lifecycle) lifecyclesKt$awaitStarted$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        lifecycleObserver = (LifecycleObserver) objectRef.element;
                        if (lifecycleObserver != null) {
                            lifecycle2.removeObserver(lifecycleObserver);
                        }
                        throw th;
                    }
                }
                lifecycleObserver2 = (LifecycleObserver) objectRef.element;
                if (lifecycleObserver2 != null) {
                    lifecycle2.removeObserver(lifecycleObserver2);
                }
                return Unit.INSTANCE;
            }
        }
        lifecyclesKt$awaitStarted$1 = new LifecyclesKt$awaitStarted$1(continuation);
        Object obj3 = lifecyclesKt$awaitStarted$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = lifecyclesKt$awaitStarted$1.label;
        if (i != 0) {
        }
        lifecycleObserver2 = (LifecycleObserver) objectRef.element;
        if (lifecycleObserver2 != null) {
        }
        return Unit.INSTANCE;
    }

    public static final void removeAndAddObserver(Lifecycle lifecycle, LifecycleObserver lifecycleObserver) {
        lifecycle.removeObserver(lifecycleObserver);
        lifecycle.addObserver(lifecycleObserver);
    }
}

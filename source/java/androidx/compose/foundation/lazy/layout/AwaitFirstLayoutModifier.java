package androidx.compose.foundation.lazy.layout;

import androidx.compose.p002ui.layout.LayoutCoordinates;
import androidx.compose.p002ui.layout.OnGloballyPositionedModifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: AwaitFirstLayoutModifier.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "Landroidx/compose/ui/layout/OnGloballyPositionedModifier;", "<init>", "()V", "wasPositioned", "", "continuations", "", "Lkotlin/coroutines/Continuation;", "", "waitForFirstLayout", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class AwaitFirstLayoutModifier implements OnGloballyPositionedModifier {
    public static final int $stable = 0;
    private final List<Continuation<Unit>> continuations = new ArrayList();
    private boolean wasPositioned;

    /* JADX WARN: Removed duplicated region for block: B:22:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object waitForFirstLayout(Continuation<? super Unit> continuation) {
        AwaitFirstLayoutModifier$waitForFirstLayout$1 awaitFirstLayoutModifier$waitForFirstLayout$1;
        int i;
        Ref.ObjectRef objectRef;
        Throwable th;
        if (continuation instanceof AwaitFirstLayoutModifier$waitForFirstLayout$1) {
            awaitFirstLayoutModifier$waitForFirstLayout$1 = (AwaitFirstLayoutModifier$waitForFirstLayout$1) continuation;
            if ((awaitFirstLayoutModifier$waitForFirstLayout$1.label & Integer.MIN_VALUE) != 0) {
                awaitFirstLayoutModifier$waitForFirstLayout$1.label -= Integer.MIN_VALUE;
                Object obj = awaitFirstLayoutModifier$waitForFirstLayout$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = awaitFirstLayoutModifier$waitForFirstLayout$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!this.wasPositioned) {
                        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                        try {
                            awaitFirstLayoutModifier$waitForFirstLayout$1.L$0 = objectRef2;
                            awaitFirstLayoutModifier$waitForFirstLayout$1.label = 1;
                            CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted((Continuation) awaitFirstLayoutModifier$waitForFirstLayout$1), 1);
                            cancellableContinuationImpl.initCancellability();
                            CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                            objectRef2.element = cancellableContinuation;
                            this.continuations.add(cancellableContinuation);
                            Object result = cancellableContinuationImpl.getResult();
                            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                DebugProbesKt.probeCoroutineSuspended((Continuation) awaitFirstLayoutModifier$waitForFirstLayout$1);
                            }
                            if (result == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            objectRef = objectRef2;
                        } catch (Throwable th2) {
                            objectRef = objectRef2;
                            th = th2;
                            TypeIntrinsics.asMutableCollection(this.continuations).remove(objectRef.element);
                            throw th;
                        }
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (Ref.ObjectRef) awaitFirstLayoutModifier$waitForFirstLayout$1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th3) {
                    th = th3;
                    TypeIntrinsics.asMutableCollection(this.continuations).remove(objectRef.element);
                    throw th;
                }
                TypeIntrinsics.asMutableCollection(this.continuations).remove(objectRef.element);
                return Unit.INSTANCE;
            }
        }
        awaitFirstLayoutModifier$waitForFirstLayout$1 = new AwaitFirstLayoutModifier$waitForFirstLayout$1(this, continuation);
        Object obj2 = awaitFirstLayoutModifier$waitForFirstLayout$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = awaitFirstLayoutModifier$waitForFirstLayout$1.label;
        if (i != 0) {
        }
        TypeIntrinsics.asMutableCollection(this.continuations).remove(objectRef.element);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.p002ui.layout.OnGloballyPositionedModifier
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        if (this.wasPositioned) {
            return;
        }
        this.wasPositioned = true;
        List<Continuation<Unit>> list = this.continuations;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Continuation<Unit> continuation = list.get(i);
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }
        this.continuations.clear();
    }
}

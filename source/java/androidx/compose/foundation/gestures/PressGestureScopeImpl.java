package androidx.compose.foundation.gestures;

import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: TapGestureDetector.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0011\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0012\u001a\u00020\u0013*\u00020\u0014H\u0097\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0012\u001a\u00020\u0013*\u00020\u0017H\u0097\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u0014*\u00020\u0013H\u0097\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u001a\u001a\u00020\u0014*\u00020\u001dH\u0097\u0001¢\u0006\u0004\b\u001b\u0010\u001eJ\u0014\u0010\u001a\u001a\u00020\u0014*\u00020\u0017H\u0097\u0001¢\u0006\u0004\b\u001f\u0010 J\u0014\u0010!\u001a\u00020\"*\u00020#H\u0097\u0001¢\u0006\u0004\b$\u0010%J\u0014\u0010&\u001a\u00020\u001d*\u00020\u0014H\u0097\u0001¢\u0006\u0004\b'\u0010\u001eJ\u0014\u0010&\u001a\u00020\u001d*\u00020\u0017H\u0097\u0001¢\u0006\u0004\b(\u0010 J\r\u0010)\u001a\u00020**\u00020+H\u0097\u0001J\u0014\u0010,\u001a\u00020#*\u00020\"H\u0097\u0001¢\u0006\u0004\b-\u0010%J\u0014\u0010.\u001a\u00020\u0017*\u00020\u0013H\u0097\u0001¢\u0006\u0004\b/\u00100J\u0014\u0010.\u001a\u00020\u0017*\u00020\u001dH\u0097\u0001¢\u0006\u0004\b/\u00101J\u0014\u0010.\u001a\u00020\u0017*\u00020\u0014H\u0097\u0001¢\u0006\u0004\b2\u00101R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u001d8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u001d8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b6\u00104¨\u00067"}, d2 = {"Landroidx/compose/foundation/gestures/PressGestureScopeImpl;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "density", "<init>", "(Landroidx/compose/ui/unit/Density;)V", "isReleased", "", "isCanceled", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "cancel", "", "release", "reset", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitRelease", "tryAwaitRelease", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(I)F", "", "(F)F", "toDp-GaN1DYA", "(J)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(I)J", "(F)J", "toSp-0xMU5do", "getDensity", "()F", "fontScale", "getFontScale", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class PressGestureScopeImpl implements PressGestureScope, Density {
    public static final int $stable = 0;
    private final /* synthetic */ Density $$delegate_0;
    private boolean isCanceled;
    private boolean isReleased;
    private final Mutex mutex = MutexKt.Mutex(false);

    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
    public int m746roundToPxR2X_6o(long j) {
        return this.$$delegate_0.roundToPx--R2X_6o(j);
    }

    /* renamed from: roundToPx-0680j_4, reason: not valid java name */
    public int m747roundToPx0680j_4(float f) {
        return this.$$delegate_0.roundToPx-0680j_4(f);
    }

    /* renamed from: toDp-GaN1DYA, reason: not valid java name */
    public float m748toDpGaN1DYA(long j) {
        return this.$$delegate_0.toDp-GaN1DYA(j);
    }

    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public float m749toDpu2uoSUM(float f) {
        return this.$$delegate_0.toDp-u2uoSUM(f);
    }

    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public float m750toDpu2uoSUM(int i) {
        return this.$$delegate_0.toDp-u2uoSUM(i);
    }

    /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
    public long m751toDpSizekrfVVM(long j) {
        return this.$$delegate_0.toDpSize-k-rfVVM(j);
    }

    /* renamed from: toPx--R2X_6o, reason: not valid java name */
    public float m752toPxR2X_6o(long j) {
        return this.$$delegate_0.toPx--R2X_6o(j);
    }

    /* renamed from: toPx-0680j_4, reason: not valid java name */
    public float m753toPx0680j_4(float f) {
        return this.$$delegate_0.toPx-0680j_4(f);
    }

    public Rect toRect(DpRect dpRect) {
        return this.$$delegate_0.toRect(dpRect);
    }

    /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
    public long m754toSizeXkaWNTQ(long j) {
        return this.$$delegate_0.toSize-XkaWNTQ(j);
    }

    /* renamed from: toSp-0xMU5do, reason: not valid java name */
    public long m755toSp0xMU5do(float f) {
        return this.$$delegate_0.toSp-0xMU5do(f);
    }

    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public long m756toSpkPz2Gy4(float f) {
        return this.$$delegate_0.toSp-kPz2Gy4(f);
    }

    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public long m757toSpkPz2Gy4(int i) {
        return this.$$delegate_0.toSp-kPz2Gy4(i);
    }

    public PressGestureScopeImpl(Density density) {
        this.$$delegate_0 = density;
    }

    public final void cancel() {
        this.isCanceled = true;
        if (this.mutex.isLocked()) {
            Mutex.DefaultImpls.unlock$default(this.mutex, (Object) null, 1, (Object) null);
        }
    }

    public final void release() {
        this.isReleased = true;
        if (this.mutex.isLocked()) {
            Mutex.DefaultImpls.unlock$default(this.mutex, (Object) null, 1, (Object) null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object reset(Continuation<? super Unit> continuation) {
        PressGestureScopeImpl$reset$1 pressGestureScopeImpl$reset$1;
        int i;
        if (continuation instanceof PressGestureScopeImpl$reset$1) {
            pressGestureScopeImpl$reset$1 = (PressGestureScopeImpl$reset$1) continuation;
            if ((pressGestureScopeImpl$reset$1.label & Integer.MIN_VALUE) != 0) {
                pressGestureScopeImpl$reset$1.label -= Integer.MIN_VALUE;
                Object obj = pressGestureScopeImpl$reset$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = pressGestureScopeImpl$reset$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Mutex mutex = this.mutex;
                    pressGestureScopeImpl$reset$1.label = 1;
                    if (Mutex.DefaultImpls.lock$default(mutex, (Object) null, pressGestureScopeImpl$reset$1, 1, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.isReleased = false;
                this.isCanceled = false;
                return Unit.INSTANCE;
            }
        }
        pressGestureScopeImpl$reset$1 = new PressGestureScopeImpl$reset$1(this, continuation);
        Object obj2 = pressGestureScopeImpl$reset$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pressGestureScopeImpl$reset$1.label;
        if (i != 0) {
        }
        this.isReleased = false;
        this.isCanceled = false;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.compose.foundation.gestures.PressGestureScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object awaitRelease(Continuation<? super Unit> continuation) {
        PressGestureScopeImpl$awaitRelease$1 pressGestureScopeImpl$awaitRelease$1;
        Object obj;
        int i;
        if (continuation instanceof PressGestureScopeImpl$awaitRelease$1) {
            pressGestureScopeImpl$awaitRelease$1 = (PressGestureScopeImpl$awaitRelease$1) continuation;
            if ((pressGestureScopeImpl$awaitRelease$1.label & Integer.MIN_VALUE) != 0) {
                pressGestureScopeImpl$awaitRelease$1.label -= Integer.MIN_VALUE;
                obj = pressGestureScopeImpl$awaitRelease$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = pressGestureScopeImpl$awaitRelease$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    pressGestureScopeImpl$awaitRelease$1.label = 1;
                    obj = tryAwaitRelease(pressGestureScopeImpl$awaitRelease$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                if (((Boolean) obj).booleanValue()) {
                    throw new GestureCancellationException("The press gesture was canceled.");
                }
                return Unit.INSTANCE;
            }
        }
        pressGestureScopeImpl$awaitRelease$1 = new PressGestureScopeImpl$awaitRelease$1(this, continuation);
        obj = pressGestureScopeImpl$awaitRelease$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pressGestureScopeImpl$awaitRelease$1.label;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // androidx.compose.foundation.gestures.PressGestureScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object tryAwaitRelease(Continuation<? super Boolean> continuation) {
        PressGestureScopeImpl$tryAwaitRelease$1 pressGestureScopeImpl$tryAwaitRelease$1;
        int i;
        if (continuation instanceof PressGestureScopeImpl$tryAwaitRelease$1) {
            pressGestureScopeImpl$tryAwaitRelease$1 = (PressGestureScopeImpl$tryAwaitRelease$1) continuation;
            if ((pressGestureScopeImpl$tryAwaitRelease$1.label & Integer.MIN_VALUE) != 0) {
                pressGestureScopeImpl$tryAwaitRelease$1.label -= Integer.MIN_VALUE;
                Object obj = pressGestureScopeImpl$tryAwaitRelease$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = pressGestureScopeImpl$tryAwaitRelease$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!this.isReleased && !this.isCanceled) {
                        Mutex mutex = this.mutex;
                        pressGestureScopeImpl$tryAwaitRelease$1.label = 1;
                        if (Mutex.DefaultImpls.lock$default(mutex, (Object) null, pressGestureScopeImpl$tryAwaitRelease$1, 1, (Object) null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Boxing.boxBoolean(this.isReleased);
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Mutex.DefaultImpls.unlock$default(this.mutex, (Object) null, 1, (Object) null);
                return Boxing.boxBoolean(this.isReleased);
            }
        }
        pressGestureScopeImpl$tryAwaitRelease$1 = new PressGestureScopeImpl$tryAwaitRelease$1(this, continuation);
        Object obj2 = pressGestureScopeImpl$tryAwaitRelease$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pressGestureScopeImpl$tryAwaitRelease$1.label;
        if (i != 0) {
        }
        Mutex.DefaultImpls.unlock$default(this.mutex, (Object) null, 1, (Object) null);
        return Boxing.boxBoolean(this.isReleased);
    }
}

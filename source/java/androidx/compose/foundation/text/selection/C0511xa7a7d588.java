package androidx.compose.foundation.text.selection;

import android.view.textclassifier.TextClassifier;
import androidx.compose.p002ui.graphics.Fields;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: PlatformSelectionBehaviors.android.kt */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2", f = "PlatformSelectionBehaviors.android.kt", i = {0, 1}, l = {351, Fields.RotationX, 265}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
/* renamed from: androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class C0511xa7a7d588<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    final /* synthetic */ Function2<TextClassifier, Continuation<? super T>, Object> $block;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ PlatformSelectionBehaviorsImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C0511xa7a7d588(PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl, Function2<? super TextClassifier, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super C0511xa7a7d588> continuation) {
        super(2, continuation);
        this.this$0 = platformSelectionBehaviorsImpl;
        this.$block = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0511xa7a7d588<>(this.this$0, this.$block, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0098 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0099 A[PHI: r10
      0x0099: PHI (r10v14 java.lang.Object) = (r10v11 java.lang.Object), (r10v0 java.lang.Object) binds: [B:17:0x0096, B:6:0x0012] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl;
        Mutex mutex2;
        Throwable th;
        TextClassifier textClassifier;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.this$0.mutex;
                platformSelectionBehaviorsImpl = this.this$0;
                this.L$0 = mutex;
                this.L$1 = platformSelectionBehaviorsImpl;
                this.label = 1;
                if (mutex.lock((Object) null, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        textClassifier = (TextClassifier) obj;
                        mutex = mutex2;
                        mutex.unlock((Object) null);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 3;
                        obj = TimeoutKt.withTimeoutOrNull(200L, new AnonymousClass1(textClassifier, this.$block, null), (Continuation) this);
                        return obj != coroutine_suspended ? coroutine_suspended : obj;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock((Object) null);
                        throw th;
                    }
                }
                platformSelectionBehaviorsImpl = (PlatformSelectionBehaviorsImpl) this.L$1;
                Mutex mutex3 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
            }
            textClassifier = platformSelectionBehaviorsImpl.textClassificationSession;
            if (textClassifier == null || textClassifier.isDestroyed()) {
                C0512x2b917ae1 c0512x2b917ae1 = new C0512x2b917ae1(platformSelectionBehaviorsImpl, null);
                this.L$0 = mutex;
                this.L$1 = null;
                this.label = 2;
                Object withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(300L, c0512x2b917ae1, this);
                if (withTimeoutOrNull == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex2 = mutex;
                obj = withTimeoutOrNull;
                textClassifier = (TextClassifier) obj;
                mutex = mutex2;
            }
            mutex.unlock((Object) null);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 3;
            obj = TimeoutKt.withTimeoutOrNull(200L, new AnonymousClass1(textClassifier, this.$block, null), (Continuation) this);
            if (obj != coroutine_suspended) {
            }
        } catch (Throwable th3) {
            mutex2 = mutex;
            th = th3;
            mutex2.unlock((Object) null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlatformSelectionBehaviors.android.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2$1", f = "PlatformSelectionBehaviors.android.kt", i = {}, l = {266}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2$1, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function2<TextClassifier, Continuation<? super T>, Object> $block;
        final /* synthetic */ TextClassifier $textClassificationSession;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(TextClassifier textClassifier, Function2<? super TextClassifier, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$textClassificationSession = textClassifier;
            this.$block = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$textClassificationSession, this.$block, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            TextClassifier textClassifier = this.$textClassificationSession;
            if (textClassifier == null) {
                return null;
            }
            Function2<TextClassifier, Continuation<? super T>, Object> function2 = this.$block;
            this.label = 1;
            Object invoke = function2.invoke(textClassifier, this);
            return invoke == coroutine_suspended ? coroutine_suspended : invoke;
        }
    }
}

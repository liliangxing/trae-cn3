package androidx.compose.foundation.text.input.internal;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.UByte$;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CursorAnimationState.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2", f = "CursorAnimationState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class CursorAnimationState$snapToVisibleAndAnimate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CursorAnimationState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CursorAnimationState$snapToVisibleAndAnimate$2(CursorAnimationState cursorAnimationState, Continuation<? super CursorAnimationState$snapToVisibleAndAnimate$2> continuation) {
        super(2, continuation);
        this.this$0 = cursorAnimationState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> cursorAnimationState$snapToVisibleAndAnimate$2 = new CursorAnimationState$snapToVisibleAndAnimate$2(this.this$0, continuation);
        cursorAnimationState$snapToVisibleAndAnimate$2.L$0 = obj;
        return cursorAnimationState$snapToVisibleAndAnimate$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        AtomicReference atomicReference;
        AtomicReference atomicReference2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            atomicReference = this.this$0.animationJob;
            Job job = (Job) atomicReference.getAndSet(null);
            atomicReference2 = this.this$0.animationJob;
            return Boxing.boxBoolean(UByte$.ExternalSyntheticBackport0.m(atomicReference2, (Object) null, BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C04641(job, this.this$0, null), 3, (Object) null)));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CursorAnimationState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2$1", f = "CursorAnimationState.kt", i = {}, l = {72, 77, 79, 81}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class C04641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Job $oldJob;
        int label;
        final /* synthetic */ CursorAnimationState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04641(Job job, CursorAnimationState cursorAnimationState, Continuation<? super C04641> continuation) {
            super(2, continuation);
            this.$oldJob = job;
            this.this$0 = cursorAnimationState;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04641(this.$oldJob, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0074 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0085 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0083 -> B:10:0x0086). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r11.label
                r2 = 500(0x1f4, double:2.47E-321)
                r4 = 1065353216(0x3f800000, float:1.0)
                r5 = 0
                r6 = 4
                r7 = 3
                r8 = 2
                r9 = 1
                if (r1 == 0) goto L36
                if (r1 == r9) goto L32
                if (r1 == r8) goto L2b
                if (r1 == r7) goto L26
                if (r1 != r6) goto L1e
                kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Throwable -> L2f
                r12 = r11
                goto L86
            L1e:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L26:
                kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Throwable -> L2f
                r12 = r11
                goto L75
            L2b:
                kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Throwable -> L2f
                goto L62
            L2f:
                r12 = move-exception
                r0 = r11
                goto L90
            L32:
                kotlin.ResultKt.throwOnFailure(r12)
                goto L49
            L36:
                kotlin.ResultKt.throwOnFailure(r12)
                kotlinx.coroutines.Job r12 = r11.$oldJob
                if (r12 == 0) goto L49
                r1 = r11
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r11.label = r9
                java.lang.Object r12 = kotlinx.coroutines.JobKt.cancelAndJoin(r12, r1)
                if (r12 != r0) goto L49
                return r0
            L49:
                androidx.compose.foundation.text.input.internal.CursorAnimationState r12 = r11.this$0     // Catch: java.lang.Throwable -> L2f
                androidx.compose.foundation.text.input.internal.CursorAnimationState.access$setCursorAlpha(r12, r4)     // Catch: java.lang.Throwable -> L2f
                androidx.compose.foundation.text.input.internal.CursorAnimationState r12 = r11.this$0     // Catch: java.lang.Throwable -> L2f
                boolean r12 = r12.getAnimate()     // Catch: java.lang.Throwable -> L2f
                if (r12 != 0) goto L68
                r12 = r11
                kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12     // Catch: java.lang.Throwable -> L2f
                r11.label = r8     // Catch: java.lang.Throwable -> L2f
                java.lang.Object r12 = kotlinx.coroutines.DelayKt.awaitCancellation(r12)     // Catch: java.lang.Throwable -> L2f
                if (r12 != r0) goto L62
                return r0
            L62:
                kotlin.KotlinNothingValueException r12 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L2f
                r12.<init>()     // Catch: java.lang.Throwable -> L2f
                throw r12     // Catch: java.lang.Throwable -> L2f
            L68:
                r12 = r11
            L69:
                r1 = r12
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch: java.lang.Throwable -> L8c
                r12.label = r7     // Catch: java.lang.Throwable -> L8c
                java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r2, r1)     // Catch: java.lang.Throwable -> L8c
                if (r1 != r0) goto L75
                return r0
            L75:
                androidx.compose.foundation.text.input.internal.CursorAnimationState r1 = r12.this$0     // Catch: java.lang.Throwable -> L8c
                androidx.compose.foundation.text.input.internal.CursorAnimationState.access$setCursorAlpha(r1, r5)     // Catch: java.lang.Throwable -> L8c
                r1 = r12
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch: java.lang.Throwable -> L8c
                r12.label = r6     // Catch: java.lang.Throwable -> L8c
                java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r2, r1)     // Catch: java.lang.Throwable -> L8c
                if (r1 != r0) goto L86
                return r0
            L86:
                androidx.compose.foundation.text.input.internal.CursorAnimationState r1 = r12.this$0     // Catch: java.lang.Throwable -> L8c
                androidx.compose.foundation.text.input.internal.CursorAnimationState.access$setCursorAlpha(r1, r4)     // Catch: java.lang.Throwable -> L8c
                goto L69
            L8c:
                r0 = move-exception
                r10 = r0
                r0 = r12
                r12 = r10
            L90:
                androidx.compose.foundation.text.input.internal.CursorAnimationState r0 = r0.this$0
                androidx.compose.foundation.text.input.internal.CursorAnimationState.access$setCursorAlpha(r0, r5)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2.C04641.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}

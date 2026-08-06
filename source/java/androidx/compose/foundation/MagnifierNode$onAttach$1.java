package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Magnifier.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.MagnifierNode$onAttach$1", f = "Magnifier.android.kt", i = {}, l = {382, 386}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class MagnifierNode$onAttach$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MagnifierNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagnifierNode$onAttach$1(MagnifierNode magnifierNode, Continuation<? super MagnifierNode$onAttach$1> continuation) {
        super(2, continuation);
        this.this$0 = magnifierNode;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MagnifierNode$onAttach$1(this.this$0, continuation);
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
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:8:0x0024). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x004e -> B:6:0x0051). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L20
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L13
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r5
            goto L51
        L13:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1b:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r5
            goto L38
        L20:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r5
        L24:
            androidx.compose.foundation.MagnifierNode r1 = r6.this$0
            kotlinx.coroutines.channels.Channel r1 = androidx.compose.foundation.MagnifierNode.access$getDrawSignalChannel$p(r1)
            if (r1 == 0) goto L38
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r6.label = r3
            java.lang.Object r1 = r1.receive(r4)
            if (r1 != r0) goto L38
            return r0
        L38:
            androidx.compose.foundation.MagnifierNode r1 = r6.this$0
            androidx.compose.foundation.PlatformMagnifier r1 = androidx.compose.foundation.MagnifierNode.access$getMagnifier$p(r1)
            if (r1 == 0) goto L24
            androidx.compose.foundation.MagnifierNode$onAttach$1$$ExternalSyntheticLambda0 r1 = new androidx.compose.foundation.MagnifierNode$onAttach$1$$ExternalSyntheticLambda0
            r1.<init>()
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r6.label = r2
            java.lang.Object r1 = androidx.compose.runtime.MonotonicFrameClockKt.withFrameMillis(r1, r4)
            if (r1 != r0) goto L51
            return r0
        L51:
            androidx.compose.foundation.MagnifierNode r1 = r6.this$0
            androidx.compose.foundation.PlatformMagnifier r1 = androidx.compose.foundation.MagnifierNode.access$getMagnifier$p(r1)
            if (r1 == 0) goto L24
            r1.updateContent()
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode$onAttach$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(long j) {
        return Unit.INSTANCE;
    }
}

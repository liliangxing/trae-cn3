package com.bytedance.trae.conversation.brainstorm;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrainstormSessionHolder.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder$startTimer$1", f = "BrainstormSessionHolder.kt", i = {}, l = {616}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormSessionHolder$startTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $sessionStartTimeMs;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrainstormSessionHolder$startTimer$1(long j, Continuation<? super BrainstormSessionHolder$startTimer$1> continuation) {
        super(2, continuation);
        this.$sessionStartTimeMs = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrainstormSessionHolder$startTimer$1(this.$sessionStartTimeMs, continuation);
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
    /* JADX WARN: Removed duplicated region for block: B:11:0x002b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0047  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:5:0x002c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r57) {
        /*
            r56 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r56
            int r2 = r1.label
            r3 = 1
            if (r2 == 0) goto L1a
            if (r2 != r3) goto L12
            kotlin.ResultKt.throwOnFailure(r57)
            r2 = r1
            goto L2c
        L12:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L1a:
            kotlin.ResultKt.throwOnFailure(r57)
            r2 = r1
        L1e:
            r4 = r2
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r2.label = r3
            r5 = 300(0x12c, double:1.48E-321)
            java.lang.Object r4 = kotlinx.coroutines.DelayKt.delay(r5, r4)
            if (r4 != r0) goto L2c
            return r0
        L2c:
            long r4 = java.lang.System.currentTimeMillis()
            long r6 = r2.$sessionStartTimeMs
            long r24 = r4 - r6
            kotlinx.coroutines.flow.MutableStateFlow r4 = com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder.access$get_elapsedMs$p()
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r24)
            r4.setValue(r5)
            com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder r4 = com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder.INSTANCE
            com.bytedance.trae.conversation.brainstorm.HolderSnapshot r4 = com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder.access$getCurrentSnapshot$p()
            if (r4 == 0) goto La3
            com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState r8 = r4.getUiState()
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 4177919(0x3fbfff, float:5.854511E-39)
            r34 = 0
            com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState r27 = com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState.copy$default(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r24, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            r29 = 0
            r33 = 0
            r34 = 0
            r36 = 0
            r38 = 0
            r40 = 0
            r42 = 0
            r44 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r51 = 0
            r52 = 0
            r53 = 0
            r54 = 2097150(0x1ffffe, float:2.938733E-39)
            r55 = 0
            r26 = r4
            com.bytedance.trae.conversation.brainstorm.HolderSnapshot r4 = com.bytedance.trae.conversation.brainstorm.HolderSnapshot.copy$default(r26, r27, r28, r29, r30, r31, r32, r33, r34, r36, r38, r40, r42, r44, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55)
            goto La4
        La3:
            r4 = 0
        La4:
            com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder.access$setCurrentSnapshot$p(r4)
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder$startTimer$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

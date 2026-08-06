package com.bytedance.trae.conversation.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CustomActivityRepository.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.network.CustomActivityRepository", f = "CustomActivityRepository.kt", i = {0, 0, 1, 1}, l = {51, 71}, m = "fetchActivities", n = {"this", "attempt", "this", "attempt"}, s = {"L$0", "I$0", "L$0", "I$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CustomActivityRepository$fetchActivities$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CustomActivityRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomActivityRepository$fetchActivities$1(CustomActivityRepository customActivityRepository, Continuation<? super CustomActivityRepository$fetchActivities$1> continuation) {
        super(continuation);
        this.this$0 = customActivityRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchActivities(false, (Continuation) this);
    }
}

package com.bytedance.trae.conversation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CliListRepository.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.CliListRepository", f = "CliListRepository.kt", i = {}, l = {310}, m = "refreshClis", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CliListRepository$refreshClis$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CliListRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CliListRepository$refreshClis$1(CliListRepository cliListRepository, Continuation<? super CliListRepository$refreshClis$1> continuation) {
        super(continuation);
        this.this$0 = cliListRepository;
    }

    public final Object invokeSuspend(Object obj) {
        Object refreshClis;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        refreshClis = this.this$0.refreshClis((Continuation) this);
        return refreshClis;
    }
}

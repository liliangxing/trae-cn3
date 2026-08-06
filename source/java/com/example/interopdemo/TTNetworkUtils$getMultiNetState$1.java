package com.example.interopdemo;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TTNetworkUtils.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.example.interopdemo.TTNetworkUtils", f = "TTNetworkUtils.kt", i = {}, l = {16}, m = "getMultiNetState", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class TTNetworkUtils$getMultiNetState$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TTNetworkUtils this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TTNetworkUtils$getMultiNetState$1(TTNetworkUtils tTNetworkUtils, Continuation<? super TTNetworkUtils$getMultiNetState$1> continuation) {
        super(continuation);
        this.this$0 = tTNetworkUtils;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getMultiNetState((Continuation) this);
    }
}

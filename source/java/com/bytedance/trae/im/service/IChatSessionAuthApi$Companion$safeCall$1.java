package com.bytedance.trae.im.service;

import com.bytedance.trae.im.service.IChatSessionAuthApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IChatSessionAuthApi.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.im.service.IChatSessionAuthApi$Companion", f = "IChatSessionAuthApi.kt", i = {}, l = {35}, m = "safeCall", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IChatSessionAuthApi$Companion$safeCall$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IChatSessionAuthApi.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IChatSessionAuthApi$Companion$safeCall$1(IChatSessionAuthApi.Companion companion, Continuation<? super IChatSessionAuthApi$Companion$safeCall$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.safeCall(null, (Continuation) this);
    }
}

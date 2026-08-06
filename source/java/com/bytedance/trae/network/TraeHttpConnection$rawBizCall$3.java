package com.bytedance.trae.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TraeHttpConnection.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.network.TraeHttpConnection", f = "TraeHttpConnection.kt", i = {}, l = {307}, m = "rawBizCall", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeHttpConnection$rawBizCall$3<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TraeHttpConnection this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TraeHttpConnection$rawBizCall$3(TraeHttpConnection traeHttpConnection, Continuation<? super TraeHttpConnection$rawBizCall$3> continuation) {
        super(continuation);
        this.this$0 = traeHttpConnection;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.rawBizCall(null, null, null, false, null, (Continuation) this);
    }
}

package com.bytedance.trae.network;

import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TraeHttpConnection.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.network.TraeHttpConnection", f = "TraeHttpConnection.kt", i = {0, 0, 0, 0}, l = {526}, m = "safeCall", n = {"this", "interceptorPath", "successCodes", "startTime"}, s = {"L$0", "L$1", "L$2", "J$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeHttpConnection$safeCall$1<S, T> extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TraeHttpConnection this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TraeHttpConnection$safeCall$1(TraeHttpConnection traeHttpConnection, Continuation<? super TraeHttpConnection$safeCall$1> continuation) {
        super(continuation);
        this.this$0 = traeHttpConnection;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.safeCall((String) null, (Class) null, (Map<String, String>) null, (Function2) null, (String) null, (Set<Long>) null, (Continuation) this);
    }
}

package com.bytedance.trae.kmp.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TraeKmpHttpClient.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.kmp.network.TraeKmpHttpClient", f = "TraeKmpHttpClient.kt", i = {0, 0, 0, 0, 0}, l = {47}, m = "postResult", n = {"this", "path", "deserializer", "resolvedOptions", "mark"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeKmpHttpClient$postResult$1<T> extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TraeKmpHttpClient this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TraeKmpHttpClient$postResult$1(TraeKmpHttpClient traeKmpHttpClient, Continuation<? super TraeKmpHttpClient$postResult$1> continuation) {
        super(continuation);
        this.this$0 = traeKmpHttpClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.postResult(null, null, null, null, null, null, null, (Continuation) this);
    }
}

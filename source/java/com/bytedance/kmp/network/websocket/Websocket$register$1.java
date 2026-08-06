package com.bytedance.kmp.network.websocket;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Websocket.kt */
@Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.websocket.Websocket", f = "Websocket.kt", i = {}, l = {44}, m = "register", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class Websocket$register$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Websocket this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Websocket$register$1(Websocket websocket, Continuation<? super Websocket$register$1> continuation) {
        super(continuation);
        this.this$0 = websocket;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.register(null, null, (Continuation) this);
    }
}

package com.bytedance.trae.login.user;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BytecloudUserInfoFetcher.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.user.BytecloudUserInfoFetcher", f = "BytecloudUserInfoFetcher.kt", i = {0}, l = {33}, m = "doFetch", n = {"this"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BytecloudUserInfoFetcher$doFetch$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BytecloudUserInfoFetcher this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BytecloudUserInfoFetcher$doFetch$1(BytecloudUserInfoFetcher bytecloudUserInfoFetcher, Continuation<? super BytecloudUserInfoFetcher$doFetch$1> continuation) {
        super(continuation);
        this.this$0 = bytecloudUserInfoFetcher;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doFetch(null, (Continuation) this);
    }
}

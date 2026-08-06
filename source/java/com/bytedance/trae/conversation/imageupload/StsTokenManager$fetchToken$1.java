package com.bytedance.trae.conversation.imageupload;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StsTokenManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.imageupload.StsTokenManager", f = "StsTokenManager.kt", i = {0}, l = {92}, m = "fetchToken", n = {"this"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class StsTokenManager$fetchToken$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StsTokenManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StsTokenManager$fetchToken$1(StsTokenManager stsTokenManager, Continuation<? super StsTokenManager$fetchToken$1> continuation) {
        super(continuation);
        this.this$0 = stsTokenManager;
    }

    public final Object invokeSuspend(Object obj) {
        Object fetchToken;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchToken = this.this$0.fetchToken(null, (Continuation) this);
        return fetchToken;
    }
}

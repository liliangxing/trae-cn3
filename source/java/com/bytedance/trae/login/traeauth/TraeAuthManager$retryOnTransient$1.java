package com.bytedance.trae.login.traeauth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TraeAuthManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.traeauth.TraeAuthManager", f = "TraeAuthManager.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {804, 818}, m = "retryOnTransient", n = {"stepName", "loginPlatform", "block", "lastException", "maxRetries", "attempt", "stepName", "loginPlatform", "block", "lastException", "maxRetries"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$3", "L$0", "L$1", "L$2", "L$3", "I$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeAuthManager$retryOnTransient$1<T> extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TraeAuthManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TraeAuthManager$retryOnTransient$1(TraeAuthManager traeAuthManager, Continuation<? super TraeAuthManager$retryOnTransient$1> continuation) {
        super(continuation);
        this.this$0 = traeAuthManager;
    }

    public final Object invokeSuspend(Object obj) {
        Object retryOnTransient;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        retryOnTransient = this.this$0.retryOnTransient(0, null, null, null, (Continuation) this);
        return retryOnTransient;
    }
}

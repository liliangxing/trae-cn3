package com.bytedance.trae.login.traeauth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TraeAuthManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.traeauth.TraeAuthManager", f = "TraeAuthManager.kt", i = {0, 0, 0}, l = {1227}, m = "clearRefreshToken", n = {"this", "deviceId", "requestStart"}, s = {"L$0", "L$1", "J$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeAuthManager$clearRefreshToken$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TraeAuthManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TraeAuthManager$clearRefreshToken$1(TraeAuthManager traeAuthManager, Continuation<? super TraeAuthManager$clearRefreshToken$1> continuation) {
        super(continuation);
        this.this$0 = traeAuthManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.clearRefreshToken(null, (Continuation) this);
    }
}

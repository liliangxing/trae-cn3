package com.bytedance.trae.login.traeauth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TraeAuthManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.traeauth.TraeAuthManager", f = "TraeAuthManager.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6}, l = {678, 683, 687, 692, 694, 737, 765, 770, 786}, m = "exchangeTokenOrThrowIgnoreDevice$impl_mainlandRelease", n = {"this", "refreshToken", "callback", "isIgnoreDeviceLimit", "refreshStartTime", "this", "callback", "refreshStartTime", "this", "callback", "refreshStartTime", "this", "refreshToken", "callback", "refreshStartTime", "this", "callback", "refreshStartTime", "this", "callback", "refreshStartTime", "callback", "e"}, s = {"L$0", "L$1", "L$2", "Z$0", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TraeAuthManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1(TraeAuthManager traeAuthManager, Continuation<? super TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1> continuation) {
        super(continuation);
        this.this$0 = traeAuthManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.exchangeTokenOrThrowIgnoreDevice$impl_mainlandRelease(null, null, false, (Continuation) this);
    }
}

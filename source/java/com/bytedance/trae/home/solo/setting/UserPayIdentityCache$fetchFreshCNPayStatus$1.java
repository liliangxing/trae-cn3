package com.bytedance.trae.home.solo.setting;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UserPayIdentityCache.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.UserPayIdentityCache", f = "UserPayIdentityCache.kt", i = {0, 0}, l = {334}, m = "fetchFreshCNPayStatus", n = {"this", "requestUserId"}, s = {"L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UserPayIdentityCache$fetchFreshCNPayStatus$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserPayIdentityCache this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserPayIdentityCache$fetchFreshCNPayStatus$1(UserPayIdentityCache userPayIdentityCache, Continuation<? super UserPayIdentityCache$fetchFreshCNPayStatus$1> continuation) {
        super(continuation);
        this.this$0 = userPayIdentityCache;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchFreshCNPayStatus((Continuation) this);
    }
}

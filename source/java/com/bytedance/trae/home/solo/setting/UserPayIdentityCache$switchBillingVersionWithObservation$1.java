package com.bytedance.trae.home.solo.setting;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UserPayIdentityCache.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.UserPayIdentityCache", f = "UserPayIdentityCache.kt", i = {0, 0}, l = {469}, m = "switchBillingVersionWithObservation", n = {"mode", "startedAt"}, s = {"L$0", "J$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UserPayIdentityCache$switchBillingVersionWithObservation$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserPayIdentityCache this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserPayIdentityCache$switchBillingVersionWithObservation$1(UserPayIdentityCache userPayIdentityCache, Continuation<? super UserPayIdentityCache$switchBillingVersionWithObservation$1> continuation) {
        super(continuation);
        this.this$0 = userPayIdentityCache;
    }

    public final Object invokeSuspend(Object obj) {
        Object switchBillingVersionWithObservation;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        switchBillingVersionWithObservation = this.this$0.switchBillingVersionWithObservation(null, (Continuation) this);
        return switchBillingVersionWithObservation;
    }
}

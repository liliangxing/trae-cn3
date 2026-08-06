package com.bytedance.trae.conversation.chat;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UserPayIdentityService.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.UserPayIdentityService", f = "UserPayIdentityService.kt", i = {}, l = {117}, m = "fetchBillingUpgradePreparation", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UserPayIdentityService$fetchBillingUpgradePreparation$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UserPayIdentityService$fetchBillingUpgradePreparation$1(Continuation<? super UserPayIdentityService$fetchBillingUpgradePreparation$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return UserPayIdentityService.fetchBillingUpgradePreparation(null, (Continuation) this);
    }
}

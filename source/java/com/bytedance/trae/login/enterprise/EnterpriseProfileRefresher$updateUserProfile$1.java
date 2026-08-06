package com.bytedance.trae.login.enterprise;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EnterpriseProfileRefresher.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.enterprise.EnterpriseProfileRefresher", f = "EnterpriseProfileRefresher.kt", i = {}, l = {26}, m = "updateUserProfile", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class EnterpriseProfileRefresher$updateUserProfile$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EnterpriseProfileRefresher this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterpriseProfileRefresher$updateUserProfile$1(EnterpriseProfileRefresher enterpriseProfileRefresher, Continuation<? super EnterpriseProfileRefresher$updateUserProfile$1> continuation) {
        super(continuation);
        this.this$0 = enterpriseProfileRefresher;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateUserProfile(null, (Continuation) this);
    }
}

package com.bytedance.trae.im.service.tenant;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TenantUserConfigRepository.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.im.service.tenant.TenantUserConfigRepository", f = "TenantUserConfigRepository.kt", i = {}, l = {120}, m = "ensureMcpWhitelistFresh", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TenantUserConfigRepository$ensureMcpWhitelistFresh$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TenantUserConfigRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TenantUserConfigRepository$ensureMcpWhitelistFresh$1(TenantUserConfigRepository tenantUserConfigRepository, Continuation<? super TenantUserConfigRepository$ensureMcpWhitelistFresh$1> continuation) {
        super(continuation);
        this.this$0 = tenantUserConfigRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.ensureMcpWhitelistFresh(null, (Continuation) this);
    }
}

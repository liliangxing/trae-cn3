package com.bytedance.trae.im.service.tenant;

import com.bytedance.timonbase.pipeline.TimonPipeline;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TenantUserConfigRepository.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.im.service.tenant.TenantUserConfigRepository", f = "TenantUserConfigRepository.kt", i = {0, 0}, l = {282}, m = "fetchTenantUserConfig", n = {"this", TimonPipeline.KEY_SOURCE}, s = {"L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TenantUserConfigRepository$fetchTenantUserConfig$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TenantUserConfigRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TenantUserConfigRepository$fetchTenantUserConfig$1(TenantUserConfigRepository tenantUserConfigRepository, Continuation<? super TenantUserConfigRepository$fetchTenantUserConfig$1> continuation) {
        super(continuation);
        this.this$0 = tenantUserConfigRepository;
    }

    public final Object invokeSuspend(Object obj) {
        Object fetchTenantUserConfig;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchTenantUserConfig = this.this$0.fetchTenantUserConfig(null, (Continuation) this);
        return fetchTenantUserConfig;
    }
}

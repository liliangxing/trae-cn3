package com.bytedance.trae.im.service.tenant;

import com.bytedance.timonbase.pipeline.TimonPipeline;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TenantUserConfigRepository.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.im.service.tenant.TenantUserConfigRepository", f = "TenantUserConfigRepository.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {351, 191}, m = "refresh", n = {TimonPipeline.KEY_SOURCE, "$this$withLock_u24default$iv", "force", "generation", TimonPipeline.KEY_SOURCE, "$this$withLock_u24default$iv", "generation"}, s = {"L$0", "L$1", "Z$0", "J$0", "L$0", "L$1", "J$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TenantUserConfigRepository$refresh$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TenantUserConfigRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TenantUserConfigRepository$refresh$1(TenantUserConfigRepository tenantUserConfigRepository, Continuation<? super TenantUserConfigRepository$refresh$1> continuation) {
        super(continuation);
        this.this$0 = tenantUserConfigRepository;
    }

    public final Object invokeSuspend(Object obj) {
        Object refresh;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        refresh = this.this$0.refresh(false, null, 0L, (Continuation) this);
        return refresh;
    }
}

package com.bytedance.trae.im.service.tenant;

import com.bytedance.sdk.account.api.AccountDef;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TenantUserConfigRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.im.service.tenant.TenantUserConfigRepository$startPolling$1", f = "TenantUserConfigRepository.kt", i = {0, 1}, l = {86, 87}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TenantUserConfigRepository$startPolling$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TenantUserConfigRepository$startPolling$1(Continuation<? super TenantUserConfigRepository$startPolling$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> tenantUserConfigRepository$startPolling$1 = new TenantUserConfigRepository$startPolling$1(continuation);
        tenantUserConfigRepository$startPolling$1.L$0 = obj;
        return tenantUserConfigRepository$startPolling$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0037  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x005e -> B:7:0x0031). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        TenantUserConfigRepository$startPolling$1 tenantUserConfigRepository$startPolling$1;
        long currentGeneration;
        Object refresh;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            coroutineScope = coroutineScope2;
            tenantUserConfigRepository$startPolling$1 = this;
            TenantUserConfigRepository tenantUserConfigRepository = TenantUserConfigRepository.INSTANCE;
            currentGeneration = TenantUserConfigRepository.INSTANCE.currentGeneration();
            tenantUserConfigRepository$startPolling$1.L$0 = coroutineScope;
            tenantUserConfigRepository$startPolling$1.label = 2;
            refresh = tenantUserConfigRepository.refresh(true, AccountDef.AccountInfoScene.POLLING, currentGeneration, (Continuation) tenantUserConfigRepository$startPolling$1);
            if (refresh == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (CoroutineScopeKt.isActive(coroutineScope)) {
                tenantUserConfigRepository$startPolling$1.L$0 = coroutineScope;
                tenantUserConfigRepository$startPolling$1.label = 1;
                if (DelayKt.delay(600000L, (Continuation) tenantUserConfigRepository$startPolling$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                TenantUserConfigRepository tenantUserConfigRepository2 = TenantUserConfigRepository.INSTANCE;
                currentGeneration = TenantUserConfigRepository.INSTANCE.currentGeneration();
                tenantUserConfigRepository$startPolling$1.L$0 = coroutineScope;
                tenantUserConfigRepository$startPolling$1.label = 2;
                refresh = tenantUserConfigRepository2.refresh(true, AccountDef.AccountInfoScene.POLLING, currentGeneration, (Continuation) tenantUserConfigRepository$startPolling$1);
                if (refresh == coroutine_suspended) {
                }
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    return Unit.INSTANCE;
                }
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            coroutineScope = coroutineScope3;
        }
        tenantUserConfigRepository$startPolling$1 = this;
        if (CoroutineScopeKt.isActive(coroutineScope)) {
        }
    }
}

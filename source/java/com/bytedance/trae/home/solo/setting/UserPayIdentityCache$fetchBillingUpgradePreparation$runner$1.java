package com.bytedance.trae.home.solo.setting;

import com.bytedance.trae.conversation.billing.CreditsBillingStatusResult;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.solo.setting.UserPayIdentityCache;
import com.bytedance.trae.network.response.HttpDataResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UserPayIdentityCache.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.UserPayIdentityCache$fetchBillingUpgradePreparation$runner$1", f = "UserPayIdentityCache.kt", i = {}, l = {403}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UserPayIdentityCache$fetchBillingUpgradePreparation$runner$1 extends SuspendLambda implements Function1<Continuation<? super CreditsBillingStatusResult>, Object> {
    final /* synthetic */ String $requestUserId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserPayIdentityCache$fetchBillingUpgradePreparation$runner$1(String str, Continuation<? super UserPayIdentityCache$fetchBillingUpgradePreparation$runner$1> continuation) {
        super(1, continuation);
        this.$requestUserId = str;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new UserPayIdentityCache$fetchBillingUpgradePreparation$runner$1(this.$requestUserId, continuation);
    }

    public final Object invoke(Continuation<? super CreditsBillingStatusResult> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String currentTocUserId;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ICNUserPayStatusApi.INSTANCE.fetchPayStatusRawCall((Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        HttpDataResult.Success success = (HttpDataResult) obj;
        if (success instanceof HttpDataResult.Success) {
            HttpDataResult.Success success2 = success;
            if (success2.getBizResp().isSuccess()) {
                CNUserPayStatusData cNUserPayStatusData = (CNUserPayStatusData) success2.getBizResp().getData();
                if (cNUserPayStatusData != null) {
                    currentTocUserId = UserPayIdentityCache.INSTANCE.currentTocUserId();
                    if (Intrinsics.areEqual(currentTocUserId, this.$requestUserId)) {
                        UserPayIdentityCache userPayIdentityCache = UserPayIdentityCache.INSTANCE;
                        UserPayIdentityCache.ownedCNPayStatus = new UserPayIdentityCache.OwnedCNPayStatus(this.$requestUserId, cNUserPayStatusData);
                    }
                    return new CreditsBillingStatusResult.Success(cNUserPayStatusData.isCreditsBilling());
                }
                return CreditsBillingStatusResult.RetryableFailure.INSTANCE;
            }
        }
        return CreditsBillingStatusResult.RetryableFailure.INSTANCE;
    }
}

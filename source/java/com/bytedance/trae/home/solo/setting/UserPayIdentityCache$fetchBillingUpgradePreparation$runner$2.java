package com.bytedance.trae.home.solo.setting;

import com.bytedance.trae.conversation.billing.BillingUpgradePromptPolicy;
import com.bytedance.trae.conversation.billing.BillingUpgradeUserStateResult;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
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
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.UserPayIdentityCache$fetchBillingUpgradePreparation$runner$2", f = "UserPayIdentityCache.kt", i = {}, l = {420}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UserPayIdentityCache$fetchBillingUpgradePreparation$runner$2 extends SuspendLambda implements Function1<Continuation<? super BillingUpgradeUserStateResult>, Object> {
    final /* synthetic */ String $requestUserId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserPayIdentityCache$fetchBillingUpgradePreparation$runner$2(String str, Continuation<? super UserPayIdentityCache$fetchBillingUpgradePreparation$runner$2> continuation) {
        super(1, continuation);
        this.$requestUserId = str;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new UserPayIdentityCache$fetchBillingUpgradePreparation$runner$2(this.$requestUserId, continuation);
    }

    public final Object invoke(Continuation<? super BillingUpgradeUserStateResult> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String currentTocUserId;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = IUserEntStatusApi.INSTANCE.fetchEntUsageRawCall((Continuation) this);
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
                UserEntStatusResponse userEntStatusResponse = (UserEntStatusResponse) success2.getBizResp().getData();
                if (userEntStatusResponse == null) {
                    return BillingUpgradeUserStateResult.RetryableFailure.INSTANCE;
                }
                UsageQuotaData fastRequestUsageQuota = UserPayIdentityCacheKt.toFastRequestUsageQuota(userEntStatusResponse);
                currentTocUserId = UserPayIdentityCache.INSTANCE.currentTocUserId();
                if (Intrinsics.areEqual(currentTocUserId, this.$requestUserId)) {
                    UserPayIdentityCache userPayIdentityCache = UserPayIdentityCache.INSTANCE;
                    UserPayIdentityCache.cachedUsageQuota = fastRequestUsageQuota;
                }
                return new BillingUpgradeUserStateResult.Success(BillingUpgradePromptPolicy.INSTANCE.classifyUserState(fastRequestUsageQuota.getInfinite(), fastRequestUsageQuota.getRemaining()));
            }
        }
        return BillingUpgradeUserStateResult.RetryableFailure.INSTANCE;
    }
}

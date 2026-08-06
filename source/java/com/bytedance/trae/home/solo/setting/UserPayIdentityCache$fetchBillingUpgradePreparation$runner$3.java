package com.bytedance.trae.home.solo.setting;

import com.bytedance.trae.conversation.billing.BillingUpgradePreparationMode;
import com.bytedance.trae.conversation.billing.BillingVersionSwitchResult;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UserPayIdentityCache.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.UserPayIdentityCache$fetchBillingUpgradePreparation$runner$3", f = "UserPayIdentityCache.kt", i = {}, l = {442}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UserPayIdentityCache$fetchBillingUpgradePreparation$runner$3 extends SuspendLambda implements Function1<Continuation<? super BillingVersionSwitchResult>, Object> {
    final /* synthetic */ BillingUpgradePreparationMode $mode;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserPayIdentityCache$fetchBillingUpgradePreparation$runner$3(BillingUpgradePreparationMode billingUpgradePreparationMode, Continuation<? super UserPayIdentityCache$fetchBillingUpgradePreparation$runner$3> continuation) {
        super(1, continuation);
        this.$mode = billingUpgradePreparationMode;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new UserPayIdentityCache$fetchBillingUpgradePreparation$runner$3(this.$mode, continuation);
    }

    public final Object invoke(Continuation<? super BillingVersionSwitchResult> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = UserPayIdentityCache.INSTANCE.switchBillingVersionWithObservation(this.$mode, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}

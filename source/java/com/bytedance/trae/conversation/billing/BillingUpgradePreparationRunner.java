package com.bytedance.trae.conversation.billing;

import com.bytedance.trae.conversation.billing.BillingUpgradePreparationResult;
import com.bytedance.trae.conversation.billing.BillingUpgradeUserStateResult;
import com.bytedance.trae.conversation.billing.BillingVersionSwitchResult;
import com.bytedance.trae.conversation.billing.CreditsBillingStatusResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BillingUpgradePreparation.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001Bo\u0012\u001c\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\u001c\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014R&\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR&\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR&\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationRunner;", "", "fetchCreditsBillingStatus", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult;", "fetchUserState", "Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult;", "switchBillingVersion", "Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult;", "isAccountCurrent", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "Lkotlin/jvm/functions/Function1;", "run", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;", "mode", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;", "(Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BillingUpgradePreparationRunner {
    private final Function1<Continuation<? super CreditsBillingStatusResult>, Object> fetchCreditsBillingStatus;
    private final Function1<Continuation<? super BillingUpgradeUserStateResult>, Object> fetchUserState;
    private final Function0<Boolean> isAccountCurrent;
    private final Function1<Continuation<? super BillingVersionSwitchResult>, Object> switchBillingVersion;

    public BillingUpgradePreparationRunner(Function1<? super Continuation<? super CreditsBillingStatusResult>, ? extends Object> function1, Function1<? super Continuation<? super BillingUpgradeUserStateResult>, ? extends Object> function12, Function1<? super Continuation<? super BillingVersionSwitchResult>, ? extends Object> function13, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function1, "fetchCreditsBillingStatus");
        Intrinsics.checkNotNullParameter(function12, "fetchUserState");
        Intrinsics.checkNotNullParameter(function13, "switchBillingVersion");
        Intrinsics.checkNotNullParameter(function0, "isAccountCurrent");
        this.fetchCreditsBillingStatus = function1;
        this.fetchUserState = function12;
        this.switchBillingVersion = function13;
        this.isAccountCurrent = function0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object run(BillingUpgradePreparationMode billingUpgradePreparationMode, Continuation<? super BillingUpgradePreparationResult> continuation) {
        BillingUpgradePreparationRunner$run$1 billingUpgradePreparationRunner$run$1;
        int i;
        Object obj;
        BillingUpgradePreparationMode billingUpgradePreparationMode2;
        BillingUpgradePreparationRunner billingUpgradePreparationRunner;
        BillingUpgradePreparationRunner billingUpgradePreparationRunner2;
        BillingUpgradeUserState billingUpgradeUserState;
        if (continuation instanceof BillingUpgradePreparationRunner$run$1) {
            billingUpgradePreparationRunner$run$1 = (BillingUpgradePreparationRunner$run$1) continuation;
            if ((billingUpgradePreparationRunner$run$1.label & Integer.MIN_VALUE) != 0) {
                billingUpgradePreparationRunner$run$1.label -= Integer.MIN_VALUE;
                Object obj2 = billingUpgradePreparationRunner$run$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = billingUpgradePreparationRunner$run$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Function1<Continuation<? super CreditsBillingStatusResult>, Object> function1 = this.fetchCreditsBillingStatus;
                    billingUpgradePreparationRunner$run$1.L$0 = this;
                    billingUpgradePreparationRunner$run$1.L$1 = billingUpgradePreparationMode;
                    billingUpgradePreparationRunner$run$1.label = 1;
                    Object invoke = function1.invoke(billingUpgradePreparationRunner$run$1);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = invoke;
                    billingUpgradePreparationMode2 = billingUpgradePreparationMode;
                    billingUpgradePreparationRunner = this;
                } else if (i == 1) {
                    BillingUpgradePreparationMode billingUpgradePreparationMode3 = (BillingUpgradePreparationMode) billingUpgradePreparationRunner$run$1.L$1;
                    BillingUpgradePreparationRunner billingUpgradePreparationRunner3 = (BillingUpgradePreparationRunner) billingUpgradePreparationRunner$run$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    billingUpgradePreparationMode2 = billingUpgradePreparationMode3;
                    billingUpgradePreparationRunner = billingUpgradePreparationRunner3;
                    obj = obj2;
                } else {
                    if (i == 2) {
                        billingUpgradePreparationRunner = (BillingUpgradePreparationRunner) billingUpgradePreparationRunner$run$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        BillingVersionSwitchResult billingVersionSwitchResult = (BillingVersionSwitchResult) obj2;
                        if (((Boolean) billingUpgradePreparationRunner.isAccountCurrent.invoke()).booleanValue()) {
                            return BillingUpgradePreparationResult.StaleAccount.INSTANCE;
                        }
                        if (Intrinsics.areEqual(billingVersionSwitchResult, BillingVersionSwitchResult.Success.INSTANCE)) {
                            return BillingUpgradePreparationResult.SwitchAcceptedSilently.INSTANCE;
                        }
                        if (Intrinsics.areEqual(billingVersionSwitchResult, BillingVersionSwitchResult.RetryableFailure.INSTANCE)) {
                            return BillingUpgradePreparationResult.RetryableFailure.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    if (i != 3) {
                        if (i != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        billingUpgradeUserState = (BillingUpgradeUserState) billingUpgradePreparationRunner$run$1.L$1;
                        billingUpgradePreparationRunner2 = (BillingUpgradePreparationRunner) billingUpgradePreparationRunner$run$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        BillingVersionSwitchResult billingVersionSwitchResult2 = (BillingVersionSwitchResult) obj2;
                        if (((Boolean) billingUpgradePreparationRunner2.isAccountCurrent.invoke()).booleanValue()) {
                            return BillingUpgradePreparationResult.StaleAccount.INSTANCE;
                        }
                        if (Intrinsics.areEqual(billingVersionSwitchResult2, BillingVersionSwitchResult.Success.INSTANCE)) {
                            return new BillingUpgradePreparationResult.PromptReady(new BillingUpgradePromptData(billingUpgradeUserState));
                        }
                        if (Intrinsics.areEqual(billingVersionSwitchResult2, BillingVersionSwitchResult.RetryableFailure.INSTANCE)) {
                            return BillingUpgradePreparationResult.RetryableFailure.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    billingUpgradePreparationRunner = (BillingUpgradePreparationRunner) billingUpgradePreparationRunner$run$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    BillingUpgradeUserStateResult billingUpgradeUserStateResult = (BillingUpgradeUserStateResult) obj2;
                    if (((Boolean) billingUpgradePreparationRunner.isAccountCurrent.invoke()).booleanValue()) {
                        return BillingUpgradePreparationResult.StaleAccount.INSTANCE;
                    }
                    if (!(billingUpgradeUserStateResult instanceof BillingUpgradeUserStateResult.Success)) {
                        if (Intrinsics.areEqual(billingUpgradeUserStateResult, BillingUpgradeUserStateResult.RetryableFailure.INSTANCE)) {
                            return BillingUpgradePreparationResult.RetryableFailure.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    BillingUpgradeUserState userState = ((BillingUpgradeUserStateResult.Success) billingUpgradeUserStateResult).getUserState();
                    Function1<Continuation<? super BillingVersionSwitchResult>, Object> function12 = billingUpgradePreparationRunner.switchBillingVersion;
                    billingUpgradePreparationRunner$run$1.L$0 = billingUpgradePreparationRunner;
                    billingUpgradePreparationRunner$run$1.L$1 = userState;
                    billingUpgradePreparationRunner$run$1.label = 4;
                    Object invoke2 = function12.invoke(billingUpgradePreparationRunner$run$1);
                    if (invoke2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    billingUpgradePreparationRunner2 = billingUpgradePreparationRunner;
                    billingUpgradeUserState = userState;
                    obj2 = invoke2;
                    BillingVersionSwitchResult billingVersionSwitchResult22 = (BillingVersionSwitchResult) obj2;
                    if (((Boolean) billingUpgradePreparationRunner2.isAccountCurrent.invoke()).booleanValue()) {
                    }
                }
                CreditsBillingStatusResult creditsBillingStatusResult = (CreditsBillingStatusResult) obj;
                if (((Boolean) billingUpgradePreparationRunner.isAccountCurrent.invoke()).booleanValue()) {
                    return BillingUpgradePreparationResult.StaleAccount.INSTANCE;
                }
                if (!(creditsBillingStatusResult instanceof CreditsBillingStatusResult.Success)) {
                    if (Intrinsics.areEqual(creditsBillingStatusResult, CreditsBillingStatusResult.RetryableFailure.INSTANCE)) {
                        return BillingUpgradePreparationResult.RetryableFailure.INSTANCE;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                if (((CreditsBillingStatusResult.Success) creditsBillingStatusResult).isCreditsBilling()) {
                    return BillingUpgradePreparationResult.AlreadyUpgraded.INSTANCE;
                }
                if (billingUpgradePreparationMode2 == BillingUpgradePreparationMode.SilentRecovery) {
                    Function1<Continuation<? super BillingVersionSwitchResult>, Object> function13 = billingUpgradePreparationRunner.switchBillingVersion;
                    billingUpgradePreparationRunner$run$1.L$0 = billingUpgradePreparationRunner;
                    billingUpgradePreparationRunner$run$1.L$1 = null;
                    billingUpgradePreparationRunner$run$1.label = 2;
                    obj2 = function13.invoke(billingUpgradePreparationRunner$run$1);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    BillingVersionSwitchResult billingVersionSwitchResult3 = (BillingVersionSwitchResult) obj2;
                    if (((Boolean) billingUpgradePreparationRunner.isAccountCurrent.invoke()).booleanValue()) {
                    }
                } else {
                    Function1<Continuation<? super BillingUpgradeUserStateResult>, Object> function14 = billingUpgradePreparationRunner.fetchUserState;
                    billingUpgradePreparationRunner$run$1.L$0 = billingUpgradePreparationRunner;
                    billingUpgradePreparationRunner$run$1.L$1 = null;
                    billingUpgradePreparationRunner$run$1.label = 3;
                    obj2 = function14.invoke(billingUpgradePreparationRunner$run$1);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    BillingUpgradeUserStateResult billingUpgradeUserStateResult2 = (BillingUpgradeUserStateResult) obj2;
                    if (((Boolean) billingUpgradePreparationRunner.isAccountCurrent.invoke()).booleanValue()) {
                    }
                }
            }
        }
        billingUpgradePreparationRunner$run$1 = new BillingUpgradePreparationRunner$run$1(this, continuation);
        Object obj22 = billingUpgradePreparationRunner$run$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = billingUpgradePreparationRunner$run$1.label;
        if (i != 0) {
        }
        CreditsBillingStatusResult creditsBillingStatusResult2 = (CreditsBillingStatusResult) obj;
        if (((Boolean) billingUpgradePreparationRunner.isAccountCurrent.invoke()).booleanValue()) {
        }
    }

    public static /* synthetic */ Object run$default(BillingUpgradePreparationRunner billingUpgradePreparationRunner, BillingUpgradePreparationMode billingUpgradePreparationMode, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            billingUpgradePreparationMode = BillingUpgradePreparationMode.PromptEligible;
        }
        return billingUpgradePreparationRunner.run(billingUpgradePreparationMode, continuation);
    }
}

package com.bytedance.trae.conversation.billing;

import com.bytedance.trae.conversation.billing.BillingUpgradePreparationResult;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BillingUpgradePromptEngine.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.billing.BillingUpgradePromptEngine$awaitReady$2", f = "BillingUpgradePromptEngine.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BillingUpgradePromptEngine$awaitReady$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ BillingUpgradePromptEngine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillingUpgradePromptEngine$awaitReady$2(BillingUpgradePromptEngine billingUpgradePromptEngine, Continuation<? super BillingUpgradePromptEngine$awaitReady$2> continuation) {
        super(2, continuation);
        this.this$0 = billingUpgradePromptEngine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BillingUpgradePromptEngine$awaitReady$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0036 -> B:5:0x0039). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        BillingUpgradePromptEngine$awaitReady$2 billingUpgradePromptEngine$awaitReady$2;
        boolean z;
        Deferred startPreparationIfNeeded;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            billingUpgradePromptEngine$awaitReady$2 = this;
            z = false;
            if (!z) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            billingUpgradePromptEngine$awaitReady$2 = this;
            BillingUpgradePreparationResult billingUpgradePreparationResult = (BillingUpgradePreparationResult) obj;
            if (!Intrinsics.areEqual(billingUpgradePreparationResult, BillingUpgradePreparationResult.RetryableFailure.INSTANCE) && !Intrinsics.areEqual(billingUpgradePreparationResult, BillingUpgradePreparationResult.StaleAccount.INSTANCE)) {
                if ((billingUpgradePreparationResult instanceof BillingUpgradePreparationResult.PromptReady) && !Intrinsics.areEqual(billingUpgradePreparationResult, BillingUpgradePreparationResult.SwitchAcceptedSilently.INSTANCE) && !Intrinsics.areEqual(billingUpgradePreparationResult, BillingUpgradePreparationResult.AlreadyUpgraded.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                z = true;
                if (!z) {
                    startPreparationIfNeeded = billingUpgradePromptEngine$awaitReady$2.this$0.startPreparationIfNeeded();
                    if (startPreparationIfNeeded == null) {
                        return Boxing.boxBoolean(true);
                    }
                    billingUpgradePromptEngine$awaitReady$2.label = 1;
                    obj = startPreparationIfNeeded.await((Continuation) billingUpgradePromptEngine$awaitReady$2);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    BillingUpgradePreparationResult billingUpgradePreparationResult2 = (BillingUpgradePreparationResult) obj;
                    if (!Intrinsics.areEqual(billingUpgradePreparationResult2, BillingUpgradePreparationResult.RetryableFailure.INSTANCE)) {
                        if (billingUpgradePreparationResult2 instanceof BillingUpgradePreparationResult.PromptReady) {
                        }
                        z = true;
                        if (!z) {
                        }
                    }
                } else {
                    return Boxing.boxBoolean(true);
                }
            }
            z = false;
            if (!z) {
            }
        }
    }
}

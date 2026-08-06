package com.bytedance.trae.conversation.billing;

import com.bytedance.trae.conversation.billing.BillingUpgradePreparationResult;
import com.bytedance.trae.conversation.billing.BillingUpgradePromptEngine;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BillingUpgradePromptEngine.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.billing.BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1", f = "BillingUpgradePromptEngine.kt", i = {}, l = {208}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.bytedance.trae.conversation.billing.BillingUpgradePromptEngine$startPreparationIfNeeded$1$preparation$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0639xc2ed9011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BillingUpgradePreparationResult>, Object> {
    final /* synthetic */ BillingUpgradePromptEngine.Entry $entry;
    final /* synthetic */ BillingUpgradePreparationMode $mode;
    final /* synthetic */ BillingUpgradePromptSession $session;
    int label;
    final /* synthetic */ BillingUpgradePromptEngine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0639xc2ed9011(BillingUpgradePromptEngine billingUpgradePromptEngine, BillingUpgradePreparationMode billingUpgradePreparationMode, BillingUpgradePromptSession billingUpgradePromptSession, BillingUpgradePromptEngine.Entry entry, Continuation<? super C0639xc2ed9011> continuation) {
        super(2, continuation);
        this.this$0 = billingUpgradePromptEngine;
        this.$mode = billingUpgradePreparationMode;
        this.$session = billingUpgradePromptSession;
        this.$entry = entry;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0639xc2ed9011(this.this$0, this.$mode, this.$session, this.$entry, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BillingUpgradePreparationResult> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        BillingUpgradePreparationResult.RetryableFailure retryableFailure;
        Function2 function2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                function2 = this.this$0.fetchPreparation;
                BillingUpgradePreparationMode billingUpgradePreparationMode = this.$mode;
                this.label = 1;
                obj = function2.invoke(billingUpgradePreparationMode, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            retryableFailure = (BillingUpgradePreparationResult) obj;
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable unused) {
            retryableFailure = BillingUpgradePreparationResult.RetryableFailure.INSTANCE;
        }
        this.this$0.completePreparation(this.$session, this.$entry, retryableFailure);
        return retryableFailure;
    }
}

package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.ExpressPassBenefitManager;
import com.bytedance.trae.conversation.chat.UserPayIdentityService;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.Iterator;
import java.util.List;
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
/* compiled from: ExpressPassBenefitManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ExpressPassBenefitManager$fetchUserPayIdentity$1", f = "ExpressPassBenefitManager.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ExpressPassBenefitManager$fetchUserPayIdentity$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExpressPassBenefitManager$fetchUserPayIdentity$1(Continuation<? super ExpressPassBenefitManager$fetchUserPayIdentity$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExpressPassBenefitManager$fetchUserPayIdentity$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        List list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ExpressPassBenefitManager expressPassBenefitManager = ExpressPassBenefitManager.INSTANCE;
                ExpressPassBenefitManager.isFetching = true;
                this.label = 1;
                obj = UserPayIdentityService.fetchUserUsageQuotaData((Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            UserPayIdentityService.UsageQuotaData usageQuotaData = (UserPayIdentityService.UsageQuotaData) obj;
            list = ExpressPassBenefitManager.remainingChangedListeners;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((ExpressPassBenefitManager.OnRemainingChangedListener) it.next()).onRemainingChanged(usageQuotaData.getTotal(), usageQuotaData.getRemaining(), usageQuotaData.getInfinite());
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            ExpressPassBenefitManager expressPassBenefitManager2 = ExpressPassBenefitManager.INSTANCE;
            ExpressPassBenefitManager.isFetching = false;
            throw th;
        }
        ExpressPassBenefitManager expressPassBenefitManager3 = ExpressPassBenefitManager.INSTANCE;
        ExpressPassBenefitManager.isFetching = false;
        return Unit.INSTANCE;
    }
}

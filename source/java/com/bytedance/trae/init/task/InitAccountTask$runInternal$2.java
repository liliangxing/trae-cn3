package com.bytedance.trae.init.task;

import com.bytedance.trae.conversation.CreditsBalance;
import com.bytedance.trae.conversation.billing.BillingUpgradePreparationMode;
import com.bytedance.trae.conversation.billing.BillingUpgradePreparationResult;
import com.bytedance.trae.conversation.chat.UserPayIdentityService;
import com.bytedance.trae.home.solo.setting.CreditsBalanceSnapshot;
import com.bytedance.trae.home.solo.setting.UsageQuotaData;
import com.bytedance.trae.home.solo.setting.UserPayIdentityCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* compiled from: InitAccountTask.kt */
@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010\n\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0096@¢\u0006\u0002\u0010\u000bJ\u000e\u0010\r\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0096@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"com/bytedance/trae/init/task/InitAccountTask$runInternal$2", "Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;", "getUserPayIdentity", "", "getKnownUserPayIdentity", "()Ljava/lang/Integer;", "getUserUsageQuotaData", "Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;", "getCreditsBalanceData", "Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;", "fetchUserPayIdentity", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchKnownUserPayIdentity", "fetchUserUsageQuotaData", "fetchCreditsBalanceData", "fetchBillingUpgradePreparation", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;", "mode", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;", "(Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InitAccountTask$runInternal$2 implements UserPayIdentityService.IUserPayIdentityProxy {
    @Override // com.bytedance.trae.conversation.chat.UserPayIdentityService.IUserPayIdentityProxy
    public int getUserPayIdentity() {
        Integer cacheUserPayIdentity = UserPayIdentityCache.INSTANCE.getCacheUserPayIdentity();
        if (cacheUserPayIdentity != null) {
            return cacheUserPayIdentity.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.trae.conversation.chat.UserPayIdentityService.IUserPayIdentityProxy
    public Integer getKnownUserPayIdentity() {
        return UserPayIdentityCache.INSTANCE.getKnownCacheUserPayIdentity();
    }

    @Override // com.bytedance.trae.conversation.chat.UserPayIdentityService.IUserPayIdentityProxy
    public UserPayIdentityService.UsageQuotaData getUserUsageQuotaData() {
        UsageQuotaData currentUsageQuota = UserPayIdentityCache.INSTANCE.currentUsageQuota();
        if (currentUsageQuota != null) {
            return new UserPayIdentityService.UsageQuotaData(currentUsageQuota.getRemaining(), currentUsageQuota.getTotal(), currentUsageQuota.getInfinite());
        }
        return new UserPayIdentityService.UsageQuotaData(0L, 0L, false);
    }

    @Override // com.bytedance.trae.conversation.chat.UserPayIdentityService.IUserPayIdentityProxy
    public UserPayIdentityService.CreditsBalanceData getCreditsBalanceData() {
        CreditsBalanceSnapshot creditsBalanceSnapshot = UserPayIdentityCache.INSTANCE.getCreditsBalanceSnapshot();
        if (creditsBalanceSnapshot == null) {
            return null;
        }
        CreditsBalance balance = creditsBalanceSnapshot.getBalance();
        return new UserPayIdentityService.CreditsBalanceData(creditsBalanceSnapshot.getUserId(), balance.getTotal(), balance.getUsed(), balance.getRemaining(), balance.getInfinite());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.bytedance.trae.conversation.chat.UserPayIdentityService.IUserPayIdentityProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fetchUserPayIdentity(Continuation<? super Integer> continuation) {
        InitAccountTask$runInternal$2$fetchUserPayIdentity$1 initAccountTask$runInternal$2$fetchUserPayIdentity$1;
        int i;
        if (continuation instanceof InitAccountTask$runInternal$2$fetchUserPayIdentity$1) {
            initAccountTask$runInternal$2$fetchUserPayIdentity$1 = (InitAccountTask$runInternal$2$fetchUserPayIdentity$1) continuation;
            if ((initAccountTask$runInternal$2$fetchUserPayIdentity$1.label & Integer.MIN_VALUE) != 0) {
                initAccountTask$runInternal$2$fetchUserPayIdentity$1.label -= Integer.MIN_VALUE;
                Object obj = initAccountTask$runInternal$2$fetchUserPayIdentity$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = initAccountTask$runInternal$2$fetchUserPayIdentity$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    UserPayIdentityCache userPayIdentityCache = UserPayIdentityCache.INSTANCE;
                    initAccountTask$runInternal$2$fetchUserPayIdentity$1.label = 1;
                    if (userPayIdentityCache.fetchAndCache(initAccountTask$runInternal$2$fetchUserPayIdentity$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Integer cacheUserPayIdentity = UserPayIdentityCache.INSTANCE.getCacheUserPayIdentity();
                return Boxing.boxInt(cacheUserPayIdentity == null ? cacheUserPayIdentity.intValue() : 0);
            }
        }
        initAccountTask$runInternal$2$fetchUserPayIdentity$1 = new InitAccountTask$runInternal$2$fetchUserPayIdentity$1(this, continuation);
        Object obj2 = initAccountTask$runInternal$2$fetchUserPayIdentity$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = initAccountTask$runInternal$2$fetchUserPayIdentity$1.label;
        if (i != 0) {
        }
        Integer cacheUserPayIdentity2 = UserPayIdentityCache.INSTANCE.getCacheUserPayIdentity();
        return Boxing.boxInt(cacheUserPayIdentity2 == null ? cacheUserPayIdentity2.intValue() : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.bytedance.trae.conversation.chat.UserPayIdentityService.IUserPayIdentityProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fetchKnownUserPayIdentity(Continuation<? super Integer> continuation) {
        InitAccountTask$runInternal$2$fetchKnownUserPayIdentity$1 initAccountTask$runInternal$2$fetchKnownUserPayIdentity$1;
        int i;
        if (continuation instanceof InitAccountTask$runInternal$2$fetchKnownUserPayIdentity$1) {
            initAccountTask$runInternal$2$fetchKnownUserPayIdentity$1 = (InitAccountTask$runInternal$2$fetchKnownUserPayIdentity$1) continuation;
            if ((initAccountTask$runInternal$2$fetchKnownUserPayIdentity$1.label & Integer.MIN_VALUE) != 0) {
                initAccountTask$runInternal$2$fetchKnownUserPayIdentity$1.label -= Integer.MIN_VALUE;
                Object obj = initAccountTask$runInternal$2$fetchKnownUserPayIdentity$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = initAccountTask$runInternal$2$fetchKnownUserPayIdentity$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    UserPayIdentityCache userPayIdentityCache = UserPayIdentityCache.INSTANCE;
                    initAccountTask$runInternal$2$fetchKnownUserPayIdentity$1.label = 1;
                    if (userPayIdentityCache.fetchAndCache(initAccountTask$runInternal$2$fetchKnownUserPayIdentity$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return UserPayIdentityCache.INSTANCE.getKnownCacheUserPayIdentity();
            }
        }
        initAccountTask$runInternal$2$fetchKnownUserPayIdentity$1 = new InitAccountTask$runInternal$2$fetchKnownUserPayIdentity$1(this, continuation);
        Object obj2 = initAccountTask$runInternal$2$fetchKnownUserPayIdentity$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = initAccountTask$runInternal$2$fetchKnownUserPayIdentity$1.label;
        if (i != 0) {
        }
        return UserPayIdentityCache.INSTANCE.getKnownCacheUserPayIdentity();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.bytedance.trae.conversation.chat.UserPayIdentityService.IUserPayIdentityProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fetchUserUsageQuotaData(Continuation<? super UserPayIdentityService.UsageQuotaData> continuation) {
        InitAccountTask$runInternal$2$fetchUserUsageQuotaData$1 initAccountTask$runInternal$2$fetchUserUsageQuotaData$1;
        int i;
        UsageQuotaData usageQuotaData;
        if (continuation instanceof InitAccountTask$runInternal$2$fetchUserUsageQuotaData$1) {
            initAccountTask$runInternal$2$fetchUserUsageQuotaData$1 = (InitAccountTask$runInternal$2$fetchUserUsageQuotaData$1) continuation;
            if ((initAccountTask$runInternal$2$fetchUserUsageQuotaData$1.label & Integer.MIN_VALUE) != 0) {
                initAccountTask$runInternal$2$fetchUserUsageQuotaData$1.label -= Integer.MIN_VALUE;
                Object obj = initAccountTask$runInternal$2$fetchUserUsageQuotaData$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = initAccountTask$runInternal$2$fetchUserUsageQuotaData$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    UserPayIdentityCache userPayIdentityCache = UserPayIdentityCache.INSTANCE;
                    initAccountTask$runInternal$2$fetchUserUsageQuotaData$1.label = 1;
                    obj = userPayIdentityCache.fetchAndCacheUserEntStatus(initAccountTask$runInternal$2$fetchUserUsageQuotaData$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                usageQuotaData = (UsageQuotaData) obj;
                if (usageQuotaData == null) {
                    return new UserPayIdentityService.UsageQuotaData(usageQuotaData.getRemaining(), usageQuotaData.getTotal(), usageQuotaData.getInfinite());
                }
                return new UserPayIdentityService.UsageQuotaData(0L, 0L, false);
            }
        }
        initAccountTask$runInternal$2$fetchUserUsageQuotaData$1 = new InitAccountTask$runInternal$2$fetchUserUsageQuotaData$1(this, continuation);
        Object obj2 = initAccountTask$runInternal$2$fetchUserUsageQuotaData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = initAccountTask$runInternal$2$fetchUserUsageQuotaData$1.label;
        if (i != 0) {
        }
        usageQuotaData = (UsageQuotaData) obj2;
        if (usageQuotaData == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.bytedance.trae.conversation.chat.UserPayIdentityService.IUserPayIdentityProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fetchCreditsBalanceData(Continuation<? super UserPayIdentityService.CreditsBalanceData> continuation) {
        InitAccountTask$runInternal$2$fetchCreditsBalanceData$1 initAccountTask$runInternal$2$fetchCreditsBalanceData$1;
        int i;
        CreditsBalanceSnapshot creditsBalanceSnapshot;
        if (continuation instanceof InitAccountTask$runInternal$2$fetchCreditsBalanceData$1) {
            initAccountTask$runInternal$2$fetchCreditsBalanceData$1 = (InitAccountTask$runInternal$2$fetchCreditsBalanceData$1) continuation;
            if ((initAccountTask$runInternal$2$fetchCreditsBalanceData$1.label & Integer.MIN_VALUE) != 0) {
                initAccountTask$runInternal$2$fetchCreditsBalanceData$1.label -= Integer.MIN_VALUE;
                Object obj = initAccountTask$runInternal$2$fetchCreditsBalanceData$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = initAccountTask$runInternal$2$fetchCreditsBalanceData$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    UserPayIdentityCache userPayIdentityCache = UserPayIdentityCache.INSTANCE;
                    initAccountTask$runInternal$2$fetchCreditsBalanceData$1.label = 1;
                    obj = userPayIdentityCache.fetchAndCacheCreditsBalanceSnapshot(initAccountTask$runInternal$2$fetchCreditsBalanceData$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                creditsBalanceSnapshot = (CreditsBalanceSnapshot) obj;
                if (creditsBalanceSnapshot != null) {
                    return null;
                }
                CreditsBalance balance = creditsBalanceSnapshot.getBalance();
                return new UserPayIdentityService.CreditsBalanceData(creditsBalanceSnapshot.getUserId(), balance.getTotal(), balance.getUsed(), balance.getRemaining(), balance.getInfinite());
            }
        }
        initAccountTask$runInternal$2$fetchCreditsBalanceData$1 = new InitAccountTask$runInternal$2$fetchCreditsBalanceData$1(this, continuation);
        Object obj2 = initAccountTask$runInternal$2$fetchCreditsBalanceData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = initAccountTask$runInternal$2$fetchCreditsBalanceData$1.label;
        if (i != 0) {
        }
        creditsBalanceSnapshot = (CreditsBalanceSnapshot) obj2;
        if (creditsBalanceSnapshot != null) {
        }
    }

    @Override // com.bytedance.trae.conversation.chat.UserPayIdentityService.IUserPayIdentityProxy
    public Object fetchBillingUpgradePreparation(BillingUpgradePreparationMode billingUpgradePreparationMode, Continuation<? super BillingUpgradePreparationResult> continuation) {
        return UserPayIdentityCache.INSTANCE.fetchBillingUpgradePreparation(billingUpgradePreparationMode, continuation);
    }
}

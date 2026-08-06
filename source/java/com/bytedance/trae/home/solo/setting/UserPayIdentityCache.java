package com.bytedance.trae.home.solo.setting;

import android.os.SystemClock;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.CreditsBalance;
import com.bytedance.trae.conversation.LoginUtils;
import com.bytedance.trae.conversation.TocCreditsPolicy;
import com.bytedance.trae.conversation.billing.BillingUpgradePreparationMode;
import com.bytedance.trae.conversation.billing.BillingUpgradePreparationResult;
import com.bytedance.trae.conversation.billing.BillingUpgradePreparationRunner;
import com.bytedance.trae.conversation.billing.BillingVersionSwitchResult;
import com.bytedance.trae.conversation.tracker.TocCreditsObservation;
import com.bytedance.trae.home.solo.setting.ICNBillingVersionApi;
import com.bytedance.trae.home.solo.setting.ICNUserPayStatusApi;
import com.bytedance.trae.home.solo.setting.IUserEntStatusApi;
import com.bytedance.trae.home.solo.setting.IUserPayStatusApi;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: UserPayIdentityCache.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002=>B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J\u0006\u0010$\u001a\u00020\"J\r\u0010%\u001a\u0004\u0018\u00010&¢\u0006\u0002\u0010'J\r\u0010(\u001a\u0004\u0018\u00010&¢\u0006\u0002\u0010'J\u0010\u0010)\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u0004\u0018\u00010,H\u0086@¢\u0006\u0002\u0010*J\u0010\u0010-\u001a\u0004\u0018\u00010\u001bH\u0086@¢\u0006\u0002\u0010*J\u0010\u0010.\u001a\u0004\u0018\u00010\u0016H\u0086@¢\u0006\u0002\u0010*J\u0010\u0010/\u001a\u0004\u0018\u00010\u0001H\u0086@¢\u0006\u0002\u0010*J\u0016\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0086@¢\u0006\u0002\u00104J\u0016\u00105\u001a\u0002062\u0006\u00102\u001a\u000203H\u0082@¢\u0006\u0002\u00104J\u0006\u00107\u001a\u00020\"J\n\u00108\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u00109\u001a\u0004\u0018\u00010\u00162\u0006\u0010:\u001a\u00020\u0005H\u0002J\n\u0010;\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010<\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010 ¨\u0006?"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;", "", "<init>", "()V", "TAG", "", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "cachedPayStatus", "Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;", "ownedCNPayStatus", "Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCNPayStatus;", "cachedUsageQuota", "Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;", "ownedCreditsBalance", "Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCreditsBalance;", "userPayStatus", "getUserPayStatus", "()Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;", "userCNPayStatus", "Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;", "getUserCNPayStatus", "()Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;", "currentUsageQuota", "creditsBalanceSnapshot", "Lcom/bytedance/trae/home/solo/setting/CreditsBalanceSnapshot;", "getCreditsBalanceSnapshot", "()Lcom/bytedance/trae/home/solo/setting/CreditsBalanceSnapshot;", "isPaidUser", "", "()Z", "fetchPayStatus", "", "fetchUserEntStatus", "fetchCreditsBalance", "getCacheUserPayIdentity", "", "()Ljava/lang/Integer;", "getKnownCacheUserPayIdentity", "fetchAndCacheUserEntStatus", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAndCacheCreditsBalance", "Lcom/bytedance/trae/conversation/CreditsBalance;", "fetchAndCacheCreditsBalanceSnapshot", "fetchFreshCNPayStatus", "fetchAndCache", "fetchBillingUpgradePreparation", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;", "mode", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;", "(Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchBillingVersionWithObservation", "Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult;", "clear", "currentCNPayStatus", "cachedCNPayStatusForRequest", "requestUserId", "currentLoggedInUserId", "currentTocUserId", "OwnedCreditsBalance", "OwnedCNPayStatus", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UserPayIdentityCache {
    public static final int $stable;
    public static final UserPayIdentityCache INSTANCE = new UserPayIdentityCache();
    private static final String TAG = "UserPayIdentityCache";
    private static volatile UserPayStatusData cachedPayStatus;
    private static volatile UsageQuotaData cachedUsageQuota;
    private static final CoroutineExceptionHandler exceptionHandler;
    private static volatile OwnedCNPayStatus ownedCNPayStatus;
    private static volatile OwnedCreditsBalance ownedCreditsBalance;
    private static final CoroutineScope scope;

    private UserPayIdentityCache() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UserPayIdentityCache.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCreditsBalance;", "", "userId", "", "balance", "Lcom/bytedance/trae/conversation/CreditsBalance;", "<init>", "(Ljava/lang/String;Lcom/bytedance/trae/conversation/CreditsBalance;)V", "getUserId", "()Ljava/lang/String;", "getBalance", "()Lcom/bytedance/trae/conversation/CreditsBalance;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class OwnedCreditsBalance {
        private final CreditsBalance balance;
        private final String userId;

        public static /* synthetic */ OwnedCreditsBalance copy$default(OwnedCreditsBalance ownedCreditsBalance, String str, CreditsBalance creditsBalance, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ownedCreditsBalance.userId;
            }
            if ((i & 2) != 0) {
                creditsBalance = ownedCreditsBalance.balance;
            }
            return ownedCreditsBalance.copy(str, creditsBalance);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        /* renamed from: component2, reason: from getter */
        public final CreditsBalance getBalance() {
            return this.balance;
        }

        public final OwnedCreditsBalance copy(String userId, CreditsBalance balance) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(balance, "balance");
            return new OwnedCreditsBalance(userId, balance);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OwnedCreditsBalance)) {
                return false;
            }
            OwnedCreditsBalance ownedCreditsBalance = (OwnedCreditsBalance) other;
            return Intrinsics.areEqual(this.userId, ownedCreditsBalance.userId) && Intrinsics.areEqual(this.balance, ownedCreditsBalance.balance);
        }

        public int hashCode() {
            return (this.userId.hashCode() * 31) + this.balance.hashCode();
        }

        public String toString() {
            return "OwnedCreditsBalance(userId=" + this.userId + ", balance=" + this.balance + ')';
        }

        public OwnedCreditsBalance(String str, CreditsBalance creditsBalance) {
            Intrinsics.checkNotNullParameter(str, "userId");
            Intrinsics.checkNotNullParameter(creditsBalance, "balance");
            this.userId = str;
            this.balance = creditsBalance;
        }

        public final String getUserId() {
            return this.userId;
        }

        public final CreditsBalance getBalance() {
            return this.balance;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UserPayIdentityCache.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$OwnedCNPayStatus;", "", "userId", "", PageDataManager.EXTRA_STATUS, "Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;", "<init>", "(Ljava/lang/String;Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;)V", "getUserId", "()Ljava/lang/String;", "getStatus", "()Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class OwnedCNPayStatus {
        private final CNUserPayStatusData status;
        private final String userId;

        public static /* synthetic */ OwnedCNPayStatus copy$default(OwnedCNPayStatus ownedCNPayStatus, String str, CNUserPayStatusData cNUserPayStatusData, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ownedCNPayStatus.userId;
            }
            if ((i & 2) != 0) {
                cNUserPayStatusData = ownedCNPayStatus.status;
            }
            return ownedCNPayStatus.copy(str, cNUserPayStatusData);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        /* renamed from: component2, reason: from getter */
        public final CNUserPayStatusData getStatus() {
            return this.status;
        }

        public final OwnedCNPayStatus copy(String userId, CNUserPayStatusData status) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(status, PageDataManager.EXTRA_STATUS);
            return new OwnedCNPayStatus(userId, status);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OwnedCNPayStatus)) {
                return false;
            }
            OwnedCNPayStatus ownedCNPayStatus = (OwnedCNPayStatus) other;
            return Intrinsics.areEqual(this.userId, ownedCNPayStatus.userId) && Intrinsics.areEqual(this.status, ownedCNPayStatus.status);
        }

        public int hashCode() {
            return (this.userId.hashCode() * 31) + this.status.hashCode();
        }

        public String toString() {
            return "OwnedCNPayStatus(userId=" + this.userId + ", status=" + this.status + ')';
        }

        public OwnedCNPayStatus(String str, CNUserPayStatusData cNUserPayStatusData) {
            Intrinsics.checkNotNullParameter(str, "userId");
            Intrinsics.checkNotNullParameter(cNUserPayStatusData, PageDataManager.EXTRA_STATUS);
            this.userId = str;
            this.status = cNUserPayStatusData;
        }

        public final String getUserId() {
            return this.userId;
        }

        public final CNUserPayStatusData getStatus() {
            return this.status;
        }
    }

    public final UserPayStatusData getUserPayStatus() {
        return cachedPayStatus;
    }

    public final CNUserPayStatusData getUserCNPayStatus() {
        return currentCNPayStatus();
    }

    public final UsageQuotaData currentUsageQuota() {
        if (LoginUtils.INSTANCE.shouldSkipTocCommercialFeatures()) {
            return null;
        }
        return cachedUsageQuota;
    }

    public final CreditsBalanceSnapshot getCreditsBalanceSnapshot() {
        OwnedCreditsBalance ownedCreditsBalance2;
        String currentTocUserId = currentTocUserId();
        if (currentTocUserId == null || (ownedCreditsBalance2 = ownedCreditsBalance) == null || !Intrinsics.areEqual(ownedCreditsBalance2.getUserId(), currentTocUserId)) {
            return null;
        }
        return new CreditsBalanceSnapshot(ownedCreditsBalance2.getUserId(), ownedCreditsBalance2.getBalance());
    }

    public final boolean isPaidUser() {
        if (LoginUtils.INSTANCE.shouldSkipTocCommercialFeatures()) {
            return false;
        }
        if (AppHost.INSTANCE.isOversea()) {
            UserPayStatusData userPayStatusData = cachedPayStatus;
            if (userPayStatusData == null || !userPayStatusData.isPaidUser()) {
                return false;
            }
        } else {
            CNUserPayStatusData currentCNPayStatus = currentCNPayStatus();
            if (currentCNPayStatus == null || !currentCNPayStatus.isPaidUser()) {
                return false;
            }
        }
        return true;
    }

    public final void fetchPayStatus() {
        BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new UserPayIdentityCache$fetchPayStatus$1(null), 3, (Object) null);
    }

    public final void fetchUserEntStatus() {
        BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new UserPayIdentityCache$fetchUserEntStatus$1(null), 3, (Object) null);
    }

    public final void fetchCreditsBalance() {
        BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new UserPayIdentityCache$fetchCreditsBalance$1(null), 3, (Object) null);
    }

    public final Integer getCacheUserPayIdentity() {
        CNUserPayIdentity identity;
        UserPayIdentity identity2;
        if (LoginUtils.INSTANCE.shouldSkipTocCommercialFeatures()) {
            return 0;
        }
        if (AppHost.INSTANCE.isOversea()) {
            UserPayStatusData userPayStatusData = cachedPayStatus;
            if (userPayStatusData == null || (identity2 = userPayStatusData.getIdentity()) == null) {
                return null;
            }
            return Integer.valueOf(identity2.getValue());
        }
        CNUserPayStatusData currentCNPayStatus = currentCNPayStatus();
        if (currentCNPayStatus == null || (identity = currentCNPayStatus.getIdentity()) == null) {
            return null;
        }
        return Integer.valueOf(identity.getValue());
    }

    public final Integer getKnownCacheUserPayIdentity() {
        if (LoginUtils.INSTANCE.shouldSkipTocCommercialFeatures()) {
            return null;
        }
        if (AppHost.INSTANCE.isOversea()) {
            UserPayStatusData userPayStatusData = cachedPayStatus;
            if (userPayStatusData != null) {
                return userPayStatusData.getUserPayIdentity();
            }
            return null;
        }
        CNUserPayStatusData currentCNPayStatus = currentCNPayStatus();
        if (currentCNPayStatus != null) {
            return currentCNPayStatus.getUserPayIdentity();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007c A[Catch: all -> 0x008e, TryCatch #0 {all -> 0x008e, blocks: (B:11:0x002b, B:12:0x005a, B:14:0x0060, B:17:0x006e, B:19:0x007c, B:22:0x007f, B:24:0x0088, B:32:0x0045, B:34:0x004d, B:37:0x008b), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007f A[Catch: all -> 0x008e, TryCatch #0 {all -> 0x008e, blocks: (B:11:0x002b, B:12:0x005a, B:14:0x0060, B:17:0x006e, B:19:0x007c, B:22:0x007f, B:24:0x0088, B:32:0x0045, B:34:0x004d, B:37:0x008b), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchAndCacheUserEntStatus(Continuation<? super UsageQuotaData> continuation) {
        UserPayIdentityCache$fetchAndCacheUserEntStatus$1 userPayIdentityCache$fetchAndCacheUserEntStatus$1;
        int i;
        HttpDataResult.Success success;
        UserEntStatusResponse userEntStatusResponse;
        try {
            if (continuation instanceof UserPayIdentityCache$fetchAndCacheUserEntStatus$1) {
                userPayIdentityCache$fetchAndCacheUserEntStatus$1 = (UserPayIdentityCache$fetchAndCacheUserEntStatus$1) continuation;
                if ((userPayIdentityCache$fetchAndCacheUserEntStatus$1.label & Integer.MIN_VALUE) != 0) {
                    userPayIdentityCache$fetchAndCacheUserEntStatus$1.label -= Integer.MIN_VALUE;
                    Object obj = userPayIdentityCache$fetchAndCacheUserEntStatus$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = userPayIdentityCache$fetchAndCacheUserEntStatus$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (LoginUtils.INSTANCE.shouldSkipTocCommercialFeatures()) {
                            cachedUsageQuota = null;
                            return null;
                        }
                        if (!AppHost.INSTANCE.isOversea()) {
                            IUserEntStatusApi.Companion companion = IUserEntStatusApi.INSTANCE;
                            userPayIdentityCache$fetchAndCacheUserEntStatus$1.L$0 = this;
                            userPayIdentityCache$fetchAndCacheUserEntStatus$1.label = 1;
                            obj = companion.fetchEntUsageRawCall(userPayIdentityCache$fetchAndCacheUserEntStatus$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            return cachedUsageQuota;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    success = (HttpDataResult) obj;
                    if ((success instanceof HttpDataResult.Success) && success.getBizResp().isSuccess()) {
                        userEntStatusResponse = (UserEntStatusResponse) success.getBizResp().getData();
                        if (userEntStatusResponse != null) {
                            return cachedUsageQuota;
                        }
                        cachedUsageQuota = UserPayIdentityCacheKt.toFastRequestUsageQuota(userEntStatusResponse);
                        return cachedUsageQuota;
                    }
                    return cachedUsageQuota;
                }
            }
            if (i != 0) {
            }
            success = (HttpDataResult) obj;
            if (success instanceof HttpDataResult.Success) {
                userEntStatusResponse = (UserEntStatusResponse) success.getBizResp().getData();
                if (userEntStatusResponse != null) {
                }
            }
            return cachedUsageQuota;
        } catch (Throwable th) {
            FLogger.INSTANCE.e(TAG, "fetchAndCache failed: " + th.getMessage());
            if (AppHost.INSTANCE.isOversea()) {
                return null;
            }
            return cachedUsageQuota;
        }
        userPayIdentityCache$fetchAndCacheUserEntStatus$1 = new UserPayIdentityCache$fetchAndCacheUserEntStatus$1(this, continuation);
        Object obj2 = userPayIdentityCache$fetchAndCacheUserEntStatus$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = userPayIdentityCache$fetchAndCacheUserEntStatus$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006c A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:11:0x002f, B:12:0x005f, B:16:0x006c, B:18:0x0070, B:20:0x007d, B:22:0x008b, B:24:0x0091, B:26:0x009b, B:28:0x009f, B:32:0x00ad, B:37:0x00b2, B:39:0x00b6, B:43:0x00c4), top: B:10:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchAndCacheCreditsBalance(Continuation<? super CreditsBalance> continuation) {
        UserPayIdentityCache$fetchAndCacheCreditsBalance$1 userPayIdentityCache$fetchAndCacheCreditsBalance$1;
        int i;
        String str;
        Throwable th;
        UserPayIdentityCache userPayIdentityCache;
        OwnedCreditsBalance ownedCreditsBalance2;
        CreditsBalance creditsBalance;
        if (continuation instanceof UserPayIdentityCache$fetchAndCacheCreditsBalance$1) {
            userPayIdentityCache$fetchAndCacheCreditsBalance$1 = (UserPayIdentityCache$fetchAndCacheCreditsBalance$1) continuation;
            if ((userPayIdentityCache$fetchAndCacheCreditsBalance$1.label & Integer.MIN_VALUE) != 0) {
                userPayIdentityCache$fetchAndCacheCreditsBalance$1.label -= Integer.MIN_VALUE;
                Object obj = userPayIdentityCache$fetchAndCacheCreditsBalance$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = userPayIdentityCache$fetchAndCacheCreditsBalance$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    String currentTocUserId = currentTocUserId();
                    if (currentTocUserId == null) {
                        ownedCreditsBalance = null;
                        return null;
                    }
                    try {
                        IUserEntStatusApi.Companion companion = IUserEntStatusApi.INSTANCE;
                        userPayIdentityCache$fetchAndCacheCreditsBalance$1.L$0 = this;
                        userPayIdentityCache$fetchAndCacheCreditsBalance$1.L$1 = currentTocUserId;
                        userPayIdentityCache$fetchAndCacheCreditsBalance$1.label = 1;
                        Object fetchEntUsageRawCall = companion.fetchEntUsageRawCall(userPayIdentityCache$fetchAndCacheCreditsBalance$1);
                        if (fetchEntUsageRawCall == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str = currentTocUserId;
                        obj = fetchEntUsageRawCall;
                        userPayIdentityCache = this;
                    } catch (Throwable th2) {
                        str = currentTocUserId;
                        th = th2;
                        userPayIdentityCache = this;
                        if (!(th instanceof CancellationException)) {
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) userPayIdentityCache$fetchAndCacheCreditsBalance$1.L$1;
                    userPayIdentityCache = (UserPayIdentityCache) userPayIdentityCache$fetchAndCacheCreditsBalance$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        if (!(th instanceof CancellationException)) {
                            throw th;
                        }
                        FLogger.INSTANCE.e(TAG, "fetchAndCacheCreditsBalance failed: " + th.getMessage());
                        if (!Intrinsics.areEqual(userPayIdentityCache.currentTocUserId(), str) || (ownedCreditsBalance2 = ownedCreditsBalance) == null) {
                            return null;
                        }
                        if (!Intrinsics.areEqual(ownedCreditsBalance2.getUserId(), str)) {
                            ownedCreditsBalance2 = null;
                        }
                        if (ownedCreditsBalance2 != null) {
                            return ownedCreditsBalance2.getBalance();
                        }
                        return null;
                    }
                }
                HttpDataResult.Success success = (HttpDataResult) obj;
                if (Intrinsics.areEqual(userPayIdentityCache.currentTocUserId(), str)) {
                    return null;
                }
                if ((success instanceof HttpDataResult.Success) && success.getBizResp().isSuccess()) {
                    UserEntStatusResponse userEntStatusResponse = (UserEntStatusResponse) success.getBizResp().getData();
                    if (userEntStatusResponse != null && (creditsBalance = UserPayIdentityCacheKt.toCreditsBalance(userEntStatusResponse)) != null) {
                        ownedCreditsBalance = new OwnedCreditsBalance(str, creditsBalance);
                        return creditsBalance;
                    }
                    OwnedCreditsBalance ownedCreditsBalance3 = ownedCreditsBalance;
                    if (ownedCreditsBalance3 == null) {
                        return null;
                    }
                    if (!Intrinsics.areEqual(ownedCreditsBalance3.getUserId(), str)) {
                        ownedCreditsBalance3 = null;
                    }
                    if (ownedCreditsBalance3 != null) {
                        return ownedCreditsBalance3.getBalance();
                    }
                    return null;
                }
                OwnedCreditsBalance ownedCreditsBalance4 = ownedCreditsBalance;
                if (ownedCreditsBalance4 == null) {
                    return null;
                }
                if (!Intrinsics.areEqual(ownedCreditsBalance4.getUserId(), str)) {
                    ownedCreditsBalance4 = null;
                }
                if (ownedCreditsBalance4 != null) {
                    return ownedCreditsBalance4.getBalance();
                }
                return null;
            }
        }
        userPayIdentityCache$fetchAndCacheCreditsBalance$1 = new UserPayIdentityCache$fetchAndCacheCreditsBalance$1(this, continuation);
        Object obj2 = userPayIdentityCache$fetchAndCacheCreditsBalance$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = userPayIdentityCache$fetchAndCacheCreditsBalance$1.label;
        if (i != 0) {
        }
        HttpDataResult.Success success2 = (HttpDataResult) obj2;
        if (Intrinsics.areEqual(userPayIdentityCache.currentTocUserId(), str)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0049 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchAndCacheCreditsBalanceSnapshot(Continuation<? super CreditsBalanceSnapshot> continuation) {
        UserPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1 userPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1;
        Object obj;
        int i;
        UserPayIdentityCache userPayIdentityCache;
        if (continuation instanceof UserPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1) {
            userPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1 = (UserPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1) continuation;
            if ((userPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1.label & Integer.MIN_VALUE) != 0) {
                userPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1.label -= Integer.MIN_VALUE;
                obj = userPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = userPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    userPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1.L$0 = this;
                    userPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1.label = 1;
                    obj = fetchAndCacheCreditsBalance(userPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userPayIdentityCache = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    userPayIdentityCache = (UserPayIdentityCache) userPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (((CreditsBalance) obj) != null) {
                    return null;
                }
                return userPayIdentityCache.getCreditsBalanceSnapshot();
            }
        }
        userPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1 = new UserPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1(this, continuation);
        obj = userPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = userPayIdentityCache$fetchAndCacheCreditsBalanceSnapshot$1.label;
        if (i != 0) {
        }
        if (((CreditsBalance) obj) != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0066 A[Catch: all -> 0x0033, TryCatch #1 {all -> 0x0033, blocks: (B:11:0x002f, B:12:0x0059, B:16:0x0066, B:18:0x006a, B:20:0x0077, B:22:0x0085, B:25:0x008e), top: B:10:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchFreshCNPayStatus(Continuation<? super CNUserPayStatusData> continuation) {
        UserPayIdentityCache$fetchFreshCNPayStatus$1 userPayIdentityCache$fetchFreshCNPayStatus$1;
        int i;
        String str;
        Throwable th;
        UserPayIdentityCache userPayIdentityCache;
        if (continuation instanceof UserPayIdentityCache$fetchFreshCNPayStatus$1) {
            userPayIdentityCache$fetchFreshCNPayStatus$1 = (UserPayIdentityCache$fetchFreshCNPayStatus$1) continuation;
            if ((userPayIdentityCache$fetchFreshCNPayStatus$1.label & Integer.MIN_VALUE) != 0) {
                userPayIdentityCache$fetchFreshCNPayStatus$1.label -= Integer.MIN_VALUE;
                Object obj = userPayIdentityCache$fetchFreshCNPayStatus$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = userPayIdentityCache$fetchFreshCNPayStatus$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    String currentTocUserId = currentTocUserId();
                    if (currentTocUserId == null) {
                        return null;
                    }
                    try {
                        ICNUserPayStatusApi.Companion companion = ICNUserPayStatusApi.INSTANCE;
                        userPayIdentityCache$fetchFreshCNPayStatus$1.L$0 = this;
                        userPayIdentityCache$fetchFreshCNPayStatus$1.L$1 = currentTocUserId;
                        userPayIdentityCache$fetchFreshCNPayStatus$1.label = 1;
                        Object fetchPayStatusRawCall = companion.fetchPayStatusRawCall(userPayIdentityCache$fetchFreshCNPayStatus$1);
                        if (fetchPayStatusRawCall == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str = currentTocUserId;
                        obj = fetchPayStatusRawCall;
                        userPayIdentityCache = this;
                    } catch (Throwable th2) {
                        str = currentTocUserId;
                        th = th2;
                        userPayIdentityCache = this;
                        if (!(th instanceof CancellationException)) {
                            throw th;
                        }
                        FLogger.INSTANCE.e(TAG, "fetchFreshCNPayStatus failed: " + th.getMessage());
                        return userPayIdentityCache.cachedCNPayStatusForRequest(str);
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) userPayIdentityCache$fetchFreshCNPayStatus$1.L$1;
                    userPayIdentityCache = (UserPayIdentityCache) userPayIdentityCache$fetchFreshCNPayStatus$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        if (!(th instanceof CancellationException)) {
                        }
                    }
                }
                HttpDataResult.Success success = (HttpDataResult) obj;
                if (Intrinsics.areEqual(userPayIdentityCache.currentTocUserId(), str)) {
                    return null;
                }
                if ((success instanceof HttpDataResult.Success) && success.getBizResp().isSuccess()) {
                    CNUserPayStatusData cNUserPayStatusData = (CNUserPayStatusData) success.getBizResp().getData();
                    if (cNUserPayStatusData == null) {
                        return null;
                    }
                    ownedCNPayStatus = new OwnedCNPayStatus(str, cNUserPayStatusData);
                    return cNUserPayStatusData;
                }
                return userPayIdentityCache.cachedCNPayStatusForRequest(str);
            }
        }
        userPayIdentityCache$fetchFreshCNPayStatus$1 = new UserPayIdentityCache$fetchFreshCNPayStatus$1(this, continuation);
        Object obj2 = userPayIdentityCache$fetchFreshCNPayStatus$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = userPayIdentityCache$fetchFreshCNPayStatus$1.label;
        if (i != 0) {
        }
        HttpDataResult.Success success2 = (HttpDataResult) obj2;
        if (Intrinsics.areEqual(userPayIdentityCache.currentTocUserId(), str)) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a0 A[Catch: Exception -> 0x0046, TryCatch #0 {Exception -> 0x0046, blocks: (B:12:0x0032, B:13:0x0093, B:17:0x00a0, B:19:0x00a4, B:21:0x00b1, B:23:0x00bf, B:25:0x00c7, B:27:0x00cc, B:32:0x0042, B:33:0x0071), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchAndCache(Continuation<Object> continuation) {
        Continuation continuation2;
        int i;
        String str;
        UserPayIdentityCache userPayIdentityCache;
        UserPayIdentityCache userPayIdentityCache2;
        try {
            if (continuation instanceof UserPayIdentityCache$fetchAndCache$1) {
                UserPayIdentityCache$fetchAndCache$1 userPayIdentityCache$fetchAndCache$1 = (UserPayIdentityCache$fetchAndCache$1) continuation;
                if ((userPayIdentityCache$fetchAndCache$1.label & Integer.MIN_VALUE) != 0) {
                    userPayIdentityCache$fetchAndCache$1.label -= Integer.MIN_VALUE;
                    continuation2 = userPayIdentityCache$fetchAndCache$1;
                    Object obj = continuation2.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = continuation2.label;
                    if (i == 0) {
                        if (i == 1) {
                            userPayIdentityCache2 = (UserPayIdentityCache) continuation2.L$0;
                            ResultKt.throwOnFailure(obj);
                            UserPayStatusData userPayStatusData = (UserPayStatusData) obj;
                            UserPayIdentityCache userPayIdentityCache3 = userPayIdentityCache2;
                            cachedPayStatus = userPayStatusData;
                            return userPayStatusData;
                        }
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        str = (String) continuation2.L$1;
                        userPayIdentityCache = (UserPayIdentityCache) continuation2.L$0;
                        ResultKt.throwOnFailure(obj);
                        HttpDataResult.Success success = (HttpDataResult) obj;
                        if (Intrinsics.areEqual(userPayIdentityCache.currentLoggedInUserId(), str)) {
                            return null;
                        }
                        if ((success instanceof HttpDataResult.Success) && success.getBizResp().isSuccess()) {
                            CNUserPayStatusData cNUserPayStatusData = (CNUserPayStatusData) success.getBizResp().getData();
                            if (cNUserPayStatusData != null) {
                                ownedCNPayStatus = new OwnedCNPayStatus(str, cNUserPayStatusData);
                                return cNUserPayStatusData;
                            }
                            return userPayIdentityCache.currentCNPayStatus();
                        }
                        return userPayIdentityCache.currentCNPayStatus();
                    }
                    ResultKt.throwOnFailure(obj);
                    if (LoginUtils.INSTANCE.shouldSkipTocCommercialFeatures()) {
                        cachedPayStatus = null;
                        ownedCNPayStatus = null;
                        cachedUsageQuota = null;
                        return null;
                    }
                    try {
                        if (AppHost.INSTANCE.isOversea()) {
                            IUserPayStatusApi.Companion companion = IUserPayStatusApi.INSTANCE;
                            continuation2.L$0 = this;
                            continuation2.label = 1;
                            obj = companion.fetchPayStatus(continuation2);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            userPayIdentityCache2 = this;
                            UserPayStatusData userPayStatusData2 = (UserPayStatusData) obj;
                            UserPayIdentityCache userPayIdentityCache32 = userPayIdentityCache2;
                            cachedPayStatus = userPayStatusData2;
                            return userPayStatusData2;
                        }
                        String currentLoggedInUserId = currentLoggedInUserId();
                        if (currentLoggedInUserId == null) {
                            return null;
                        }
                        ICNUserPayStatusApi.Companion companion2 = ICNUserPayStatusApi.INSTANCE;
                        continuation2.L$0 = this;
                        continuation2.L$1 = currentLoggedInUserId;
                        continuation2.label = 2;
                        Object fetchPayStatusRawCall = companion2.fetchPayStatusRawCall(continuation2);
                        if (fetchPayStatusRawCall == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str = currentLoggedInUserId;
                        obj = fetchPayStatusRawCall;
                        userPayIdentityCache = this;
                        HttpDataResult.Success success2 = (HttpDataResult) obj;
                        if (Intrinsics.areEqual(userPayIdentityCache.currentLoggedInUserId(), str)) {
                        }
                    } catch (Exception e) {
                        e = e;
                        continuation2 = this;
                        FLogger.INSTANCE.e(TAG, "fetchAndCache failed: " + e.getMessage());
                        if (AppHost.INSTANCE.isOversea()) {
                            return cachedPayStatus;
                        }
                        return continuation2.currentCNPayStatus();
                    }
                }
            }
            if (i == 0) {
            }
        } catch (Exception e2) {
            e = e2;
        }
        continuation2 = new UserPayIdentityCache$fetchAndCache$1(this, continuation);
        Object obj2 = continuation2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = continuation2.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchBillingUpgradePreparation(BillingUpgradePreparationMode billingUpgradePreparationMode, Continuation<? super BillingUpgradePreparationResult> continuation) {
        UserPayIdentityCache$fetchBillingUpgradePreparation$1 userPayIdentityCache$fetchBillingUpgradePreparation$1;
        int i;
        try {
            if (continuation instanceof UserPayIdentityCache$fetchBillingUpgradePreparation$1) {
                userPayIdentityCache$fetchBillingUpgradePreparation$1 = (UserPayIdentityCache$fetchBillingUpgradePreparation$1) continuation;
                if ((userPayIdentityCache$fetchBillingUpgradePreparation$1.label & Integer.MIN_VALUE) != 0) {
                    userPayIdentityCache$fetchBillingUpgradePreparation$1.label -= Integer.MIN_VALUE;
                    Object obj = userPayIdentityCache$fetchBillingUpgradePreparation$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = userPayIdentityCache$fetchBillingUpgradePreparation$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        final String currentTocUserId = currentTocUserId();
                        if (currentTocUserId == null) {
                            return BillingUpgradePreparationResult.StaleAccount.INSTANCE;
                        }
                        BillingUpgradePreparationRunner billingUpgradePreparationRunner = new BillingUpgradePreparationRunner(new UserPayIdentityCache$fetchBillingUpgradePreparation$runner$1(currentTocUserId, null), new UserPayIdentityCache$fetchBillingUpgradePreparation$runner$2(currentTocUserId, null), new UserPayIdentityCache$fetchBillingUpgradePreparation$runner$3(billingUpgradePreparationMode, null), new Function0() { // from class: com.bytedance.trae.home.solo.setting.UserPayIdentityCache$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                boolean fetchBillingUpgradePreparation$lambda$9;
                                fetchBillingUpgradePreparation$lambda$9 = UserPayIdentityCache.fetchBillingUpgradePreparation$lambda$9(currentTocUserId);
                                return Boolean.valueOf(fetchBillingUpgradePreparation$lambda$9);
                            }
                        });
                        userPayIdentityCache$fetchBillingUpgradePreparation$1.label = 1;
                        obj = billingUpgradePreparationRunner.run(billingUpgradePreparationMode, userPayIdentityCache$fetchBillingUpgradePreparation$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return (BillingUpgradePreparationResult) obj;
                }
            }
            if (i != 0) {
            }
            return (BillingUpgradePreparationResult) obj;
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            FLogger.INSTANCE.e(TAG, "fetchBillingUpgradePreparation failed: " + th.getMessage());
            return BillingUpgradePreparationResult.RetryableFailure.INSTANCE;
        }
        userPayIdentityCache$fetchBillingUpgradePreparation$1 = new UserPayIdentityCache$fetchBillingUpgradePreparation$1(this, continuation);
        Object obj2 = userPayIdentityCache$fetchBillingUpgradePreparation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = userPayIdentityCache$fetchBillingUpgradePreparation$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean fetchBillingUpgradePreparation$lambda$9(String str) {
        return Intrinsics.areEqual(INSTANCE.currentTocUserId(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a8 A[Catch: all -> 0x0030, CancellationException -> 0x00c4, TryCatch #0 {all -> 0x0030, blocks: (B:12:0x002c, B:13:0x0053, B:15:0x005a, B:21:0x0095, B:24:0x009c, B:26:0x00a8, B:29:0x00ad, B:32:0x006f, B:34:0x0073, B:35:0x0082, B:37:0x0086), top: B:11:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ad A[Catch: all -> 0x0030, CancellationException -> 0x00c4, TRY_LEAVE, TryCatch #0 {all -> 0x0030, blocks: (B:12:0x002c, B:13:0x0053, B:15:0x005a, B:21:0x0095, B:24:0x009c, B:26:0x00a8, B:29:0x00ad, B:32:0x006f, B:34:0x0073, B:35:0x0082, B:37:0x0086), top: B:11:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006f A[Catch: all -> 0x0030, CancellationException -> 0x00c4, TryCatch #0 {all -> 0x0030, blocks: (B:12:0x002c, B:13:0x0053, B:15:0x005a, B:21:0x0095, B:24:0x009c, B:26:0x00a8, B:29:0x00ad, B:32:0x006f, B:34:0x0073, B:35:0x0082, B:37:0x0086), top: B:11:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object switchBillingVersionWithObservation(BillingUpgradePreparationMode billingUpgradePreparationMode, Continuation<? super BillingVersionSwitchResult> continuation) {
        UserPayIdentityCache$switchBillingVersionWithObservation$1 userPayIdentityCache$switchBillingVersionWithObservation$1;
        int i;
        BillingUpgradePreparationMode billingUpgradePreparationMode2;
        long j;
        boolean z;
        String valueOf;
        try {
            if (continuation instanceof UserPayIdentityCache$switchBillingVersionWithObservation$1) {
                userPayIdentityCache$switchBillingVersionWithObservation$1 = (UserPayIdentityCache$switchBillingVersionWithObservation$1) continuation;
                if ((userPayIdentityCache$switchBillingVersionWithObservation$1.label & Integer.MIN_VALUE) != 0) {
                    userPayIdentityCache$switchBillingVersionWithObservation$1.label -= Integer.MIN_VALUE;
                    Object obj = userPayIdentityCache$switchBillingVersionWithObservation$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = userPayIdentityCache$switchBillingVersionWithObservation$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        try {
                            ICNBillingVersionApi.Companion companion = ICNBillingVersionApi.INSTANCE;
                            userPayIdentityCache$switchBillingVersionWithObservation$1.L$0 = billingUpgradePreparationMode;
                            userPayIdentityCache$switchBillingVersionWithObservation$1.J$0 = elapsedRealtime;
                            userPayIdentityCache$switchBillingVersionWithObservation$1.label = 1;
                            obj = companion.switchCnBillingVersionRawCall(userPayIdentityCache$switchBillingVersionWithObservation$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            j = elapsedRealtime;
                        } catch (Throwable th) {
                            th = th;
                            billingUpgradePreparationMode2 = billingUpgradePreparationMode;
                            j = elapsedRealtime;
                            TocCreditsObservation.INSTANCE.trackBillingSwitchResult(false, billingUpgradePreparationMode2, SystemClock.elapsedRealtime() - j, "exception");
                            throw th;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        j = userPayIdentityCache$switchBillingVersionWithObservation$1.J$0;
                        billingUpgradePreparationMode = (BillingUpgradePreparationMode) userPayIdentityCache$switchBillingVersionWithObservation$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th2) {
                            th = th2;
                            billingUpgradePreparationMode2 = billingUpgradePreparationMode;
                            TocCreditsObservation.INSTANCE.trackBillingSwitchResult(false, billingUpgradePreparationMode2, SystemClock.elapsedRealtime() - j, "exception");
                            throw th;
                        }
                    }
                    HttpDataResult.Success success = (HttpDataResult) obj;
                    z = !(success instanceof HttpDataResult.Success) && success.getBizResp().isSuccess();
                    if (!z) {
                        valueOf = null;
                    } else if (success instanceof HttpDataResult.Success) {
                        valueOf = String.valueOf(success.getBizResp().getCode());
                    } else {
                        valueOf = success instanceof HttpDataResult.Error ? String.valueOf(((HttpDataResult.Error) success).getCode()) : "unknown";
                    }
                    TocCreditsObservation.INSTANCE.trackBillingSwitchResult(!z, billingUpgradePreparationMode, SystemClock.elapsedRealtime() - j, valueOf);
                    if (!z) {
                        return BillingVersionSwitchResult.Success.INSTANCE;
                    }
                    return BillingVersionSwitchResult.RetryableFailure.INSTANCE;
                }
            }
            if (i != 0) {
            }
            HttpDataResult.Success success2 = (HttpDataResult) obj;
            if (success2 instanceof HttpDataResult.Success) {
            }
            if (!z) {
            }
            TocCreditsObservation.INSTANCE.trackBillingSwitchResult(!z, billingUpgradePreparationMode, SystemClock.elapsedRealtime() - j, valueOf);
            if (!z) {
            }
        } catch (CancellationException e) {
            throw e;
        }
        userPayIdentityCache$switchBillingVersionWithObservation$1 = new UserPayIdentityCache$switchBillingVersionWithObservation$1(this, continuation);
        Object obj2 = userPayIdentityCache$switchBillingVersionWithObservation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = userPayIdentityCache$switchBillingVersionWithObservation$1.label;
    }

    public final void clear() {
        cachedPayStatus = null;
        ownedCNPayStatus = null;
        cachedUsageQuota = null;
        ownedCreditsBalance = null;
    }

    private final CNUserPayStatusData currentCNPayStatus() {
        OwnedCNPayStatus ownedCNPayStatus2;
        String currentLoggedInUserId = currentLoggedInUserId();
        if (currentLoggedInUserId == null || (ownedCNPayStatus2 = ownedCNPayStatus) == null) {
            return null;
        }
        if (!Intrinsics.areEqual(ownedCNPayStatus2.getUserId(), currentLoggedInUserId)) {
            ownedCNPayStatus2 = null;
        }
        if (ownedCNPayStatus2 != null) {
            return ownedCNPayStatus2.getStatus();
        }
        return null;
    }

    private final CNUserPayStatusData cachedCNPayStatusForRequest(String requestUserId) {
        OwnedCNPayStatus ownedCNPayStatus2 = ownedCNPayStatus;
        return UserPayIdentityCacheKt.selectCachedCNPayStatusForRequest(requestUserId, currentTocUserId(), ownedCNPayStatus2 != null ? ownedCNPayStatus2.getUserId() : null, ownedCNPayStatus2 != null ? ownedCNPayStatus2.getStatus() : null);
    }

    private final String currentLoggedInUserId() {
        AccountInfo accountInfo;
        String userId;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) {
            return null;
        }
        if (!accountInfo.isLogin()) {
            accountInfo = null;
        }
        if (accountInfo == null || (userId = accountInfo.getUserId()) == null || !(!StringsKt.isBlank(userId))) {
            return null;
        }
        return userId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String currentTocUserId() {
        if (TocCreditsPolicy.INSTANCE.isEnabled()) {
            return currentLoggedInUserId();
        }
        return null;
    }

    static {
        CoroutineContext coroutineContext = (CoroutineExceptionHandler) new C0828xcde5aaab(CoroutineExceptionHandler.Key);
        exceptionHandler = coroutineContext;
        scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()).plus(coroutineContext));
        $stable = 8;
    }
}

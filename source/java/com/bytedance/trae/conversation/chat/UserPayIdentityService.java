package com.bytedance.trae.conversation.chat;

import com.bytedance.trae.conversation.billing.BillingUpgradePreparationMode;
import com.bytedance.trae.conversation.billing.BillingUpgradePreparationResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserPayIdentityService.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u001a\u001b\u001cB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\b\u001a\u00020\tH\u0007J\u000f\u0010\n\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0007J\u000e\u0010\u000e\u001a\u00020\rH\u0087@¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\tH\u0087@¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0087@¢\u0006\u0002\u0010\u000fJ\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0087@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0087@¢\u0006\u0002\u0010\u0019R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;", "", "<init>", "()V", "proxy", "Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;", "registerUserPayIdentityProxy", "", "getUserPayIdentity", "", "getKnownUserPayIdentity", "()Ljava/lang/Integer;", "getUserUsageQuotaData", "Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;", "fetchUserUsageQuotaData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchUserPayIdentity", "fetchKnownUserPayIdentity", "getCreditsBalanceData", "Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;", "fetchCreditsBalanceData", "fetchBillingUpgradePreparation", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;", "mode", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;", "(Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "UsageQuotaData", "CreditsBalanceData", "IUserPayIdentityProxy", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UserPayIdentityService {
    public static final UserPayIdentityService INSTANCE = new UserPayIdentityService();
    private static IUserPayIdentityProxy proxy;

    private UserPayIdentityService() {
    }

    /* compiled from: UserPayIdentityService.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;", "", "remaining", "", "total", "infinite", "", "<init>", "(JJZ)V", "getRemaining", "()J", "getTotal", "getInfinite", "()Z", "setInfinite", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class UsageQuotaData {
        private boolean infinite;
        private final long remaining;
        private final long total;

        public static /* synthetic */ UsageQuotaData copy$default(UsageQuotaData usageQuotaData, long j, long j2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                j = usageQuotaData.remaining;
            }
            long j3 = j;
            if ((i & 2) != 0) {
                j2 = usageQuotaData.total;
            }
            long j4 = j2;
            if ((i & 4) != 0) {
                z = usageQuotaData.infinite;
            }
            return usageQuotaData.copy(j3, j4, z);
        }

        /* renamed from: component1, reason: from getter */
        public final long getRemaining() {
            return this.remaining;
        }

        /* renamed from: component2, reason: from getter */
        public final long getTotal() {
            return this.total;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getInfinite() {
            return this.infinite;
        }

        public final UsageQuotaData copy(long remaining, long total, boolean infinite) {
            return new UsageQuotaData(remaining, total, infinite);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UsageQuotaData)) {
                return false;
            }
            UsageQuotaData usageQuotaData = (UsageQuotaData) other;
            return this.remaining == usageQuotaData.remaining && this.total == usageQuotaData.total && this.infinite == usageQuotaData.infinite;
        }

        public int hashCode() {
            return (((Long.hashCode(this.remaining) * 31) + Long.hashCode(this.total)) * 31) + Boolean.hashCode(this.infinite);
        }

        public String toString() {
            return "UsageQuotaData(remaining=" + this.remaining + ", total=" + this.total + ", infinite=" + this.infinite + ')';
        }

        public UsageQuotaData(long j, long j2, boolean z) {
            this.remaining = j;
            this.total = j2;
            this.infinite = z;
        }

        public final long getRemaining() {
            return this.remaining;
        }

        public final long getTotal() {
            return this.total;
        }

        public final boolean getInfinite() {
            return this.infinite;
        }

        public final void setInfinite(boolean z) {
            this.infinite = z;
        }
    }

    /* compiled from: UserPayIdentityService.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;", "", "userId", "", "total", "", "used", "remaining", "infinite", "", "<init>", "(Ljava/lang/String;JJJZ)V", "getUserId", "()Ljava/lang/String;", "getTotal", "()J", "getUsed", "getRemaining", "getInfinite", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class CreditsBalanceData {
        private final boolean infinite;
        private final long remaining;
        private final long total;
        private final long used;
        private final String userId;

        /* renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        /* renamed from: component2, reason: from getter */
        public final long getTotal() {
            return this.total;
        }

        /* renamed from: component3, reason: from getter */
        public final long getUsed() {
            return this.used;
        }

        /* renamed from: component4, reason: from getter */
        public final long getRemaining() {
            return this.remaining;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getInfinite() {
            return this.infinite;
        }

        public final CreditsBalanceData copy(String userId, long total, long used, long remaining, boolean infinite) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            return new CreditsBalanceData(userId, total, used, remaining, infinite);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CreditsBalanceData)) {
                return false;
            }
            CreditsBalanceData creditsBalanceData = (CreditsBalanceData) other;
            return Intrinsics.areEqual(this.userId, creditsBalanceData.userId) && this.total == creditsBalanceData.total && this.used == creditsBalanceData.used && this.remaining == creditsBalanceData.remaining && this.infinite == creditsBalanceData.infinite;
        }

        public int hashCode() {
            return (((((((this.userId.hashCode() * 31) + Long.hashCode(this.total)) * 31) + Long.hashCode(this.used)) * 31) + Long.hashCode(this.remaining)) * 31) + Boolean.hashCode(this.infinite);
        }

        public String toString() {
            return "CreditsBalanceData(userId=" + this.userId + ", total=" + this.total + ", used=" + this.used + ", remaining=" + this.remaining + ", infinite=" + this.infinite + ')';
        }

        public CreditsBalanceData(String str, long j, long j2, long j3, boolean z) {
            Intrinsics.checkNotNullParameter(str, "userId");
            this.userId = str;
            this.total = j;
            this.used = j2;
            this.remaining = j3;
            this.infinite = z;
        }

        public /* synthetic */ CreditsBalanceData(String str, long j, long j2, long j3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j, j2, j3, (i & 16) != 0 ? false : z);
        }

        public final String getUserId() {
            return this.userId;
        }

        public final long getTotal() {
            return this.total;
        }

        public final long getUsed() {
            return this.used;
        }

        public final long getRemaining() {
            return this.remaining;
        }

        public final boolean getInfinite() {
            return this.infinite;
        }
    }

    /* compiled from: UserPayIdentityService.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\u000e\u0010\n\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0096@¢\u0006\u0002\u0010\u000bJ\u000e\u0010\r\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\tH¦@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;", "", "getUserPayIdentity", "", "getKnownUserPayIdentity", "()Ljava/lang/Integer;", "getUserUsageQuotaData", "Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;", "getCreditsBalanceData", "Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;", "fetchUserPayIdentity", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchKnownUserPayIdentity", "fetchUserUsageQuotaData", "fetchCreditsBalanceData", "fetchBillingUpgradePreparation", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;", "mode", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;", "(Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface IUserPayIdentityProxy {
        Object fetchBillingUpgradePreparation(BillingUpgradePreparationMode billingUpgradePreparationMode, Continuation<? super BillingUpgradePreparationResult> continuation);

        Object fetchCreditsBalanceData(Continuation<? super CreditsBalanceData> continuation);

        Object fetchKnownUserPayIdentity(Continuation<? super Integer> continuation);

        Object fetchUserPayIdentity(Continuation<? super Integer> continuation);

        Object fetchUserUsageQuotaData(Continuation<? super UsageQuotaData> continuation);

        CreditsBalanceData getCreditsBalanceData();

        Integer getKnownUserPayIdentity();

        int getUserPayIdentity();

        UsageQuotaData getUserUsageQuotaData();

        /* compiled from: UserPayIdentityService.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class DefaultImpls {
            public static Integer getKnownUserPayIdentity(IUserPayIdentityProxy iUserPayIdentityProxy) {
                return Integer.valueOf(iUserPayIdentityProxy.getUserPayIdentity());
            }

            public static Object fetchKnownUserPayIdentity(IUserPayIdentityProxy iUserPayIdentityProxy, Continuation<? super Integer> continuation) {
                return iUserPayIdentityProxy.fetchUserPayIdentity(continuation);
            }
        }
    }

    @JvmStatic
    public static final void registerUserPayIdentityProxy(IUserPayIdentityProxy proxy2) {
        Intrinsics.checkNotNullParameter(proxy2, "proxy");
        proxy = proxy2;
    }

    @JvmStatic
    public static final int getUserPayIdentity() {
        IUserPayIdentityProxy iUserPayIdentityProxy = proxy;
        if (iUserPayIdentityProxy != null) {
            return iUserPayIdentityProxy.getUserPayIdentity();
        }
        return 0;
    }

    @JvmStatic
    public static final Integer getKnownUserPayIdentity() {
        IUserPayIdentityProxy iUserPayIdentityProxy = proxy;
        if (iUserPayIdentityProxy != null) {
            return iUserPayIdentityProxy.getKnownUserPayIdentity();
        }
        return null;
    }

    @JvmStatic
    public static final UsageQuotaData getUserUsageQuotaData() {
        UsageQuotaData userUsageQuotaData;
        IUserPayIdentityProxy iUserPayIdentityProxy = proxy;
        return (iUserPayIdentityProxy == null || (userUsageQuotaData = iUserPayIdentityProxy.getUserUsageQuotaData()) == null) ? new UsageQuotaData(0L, 0L, false) : userUsageQuotaData;
    }

    @JvmStatic
    public static final Object fetchUserUsageQuotaData(Continuation<? super UsageQuotaData> continuation) {
        IUserPayIdentityProxy iUserPayIdentityProxy = proxy;
        if (iUserPayIdentityProxy == null) {
            return new UsageQuotaData(0L, 0L, false);
        }
        Intrinsics.checkNotNull(iUserPayIdentityProxy);
        return iUserPayIdentityProxy.fetchUserUsageQuotaData(continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object fetchUserPayIdentity(Continuation<? super Integer> continuation) {
        UserPayIdentityService$fetchUserPayIdentity$1 userPayIdentityService$fetchUserPayIdentity$1;
        int i;
        int i2;
        if (continuation instanceof UserPayIdentityService$fetchUserPayIdentity$1) {
            userPayIdentityService$fetchUserPayIdentity$1 = (UserPayIdentityService$fetchUserPayIdentity$1) continuation;
            if ((userPayIdentityService$fetchUserPayIdentity$1.label & Integer.MIN_VALUE) != 0) {
                userPayIdentityService$fetchUserPayIdentity$1.label -= Integer.MIN_VALUE;
                Object obj = userPayIdentityService$fetchUserPayIdentity$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = userPayIdentityService$fetchUserPayIdentity$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    IUserPayIdentityProxy iUserPayIdentityProxy = proxy;
                    if (iUserPayIdentityProxy == null) {
                        i2 = 0;
                        return Boxing.boxInt(i2);
                    }
                    userPayIdentityService$fetchUserPayIdentity$1.label = 1;
                    obj = iUserPayIdentityProxy.fetchUserPayIdentity(userPayIdentityService$fetchUserPayIdentity$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                i2 = ((Number) obj).intValue();
                return Boxing.boxInt(i2);
            }
        }
        userPayIdentityService$fetchUserPayIdentity$1 = new UserPayIdentityService$fetchUserPayIdentity$1(continuation);
        Object obj2 = userPayIdentityService$fetchUserPayIdentity$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = userPayIdentityService$fetchUserPayIdentity$1.label;
        if (i != 0) {
        }
        i2 = ((Number) obj2).intValue();
        return Boxing.boxInt(i2);
    }

    @JvmStatic
    public static final Object fetchKnownUserPayIdentity(Continuation<? super Integer> continuation) {
        IUserPayIdentityProxy iUserPayIdentityProxy = proxy;
        if (iUserPayIdentityProxy != null) {
            return iUserPayIdentityProxy.fetchKnownUserPayIdentity(continuation);
        }
        return null;
    }

    @JvmStatic
    public static final CreditsBalanceData getCreditsBalanceData() {
        IUserPayIdentityProxy iUserPayIdentityProxy = proxy;
        if (iUserPayIdentityProxy != null) {
            return iUserPayIdentityProxy.getCreditsBalanceData();
        }
        return null;
    }

    @JvmStatic
    public static final Object fetchCreditsBalanceData(Continuation<? super CreditsBalanceData> continuation) {
        IUserPayIdentityProxy iUserPayIdentityProxy = proxy;
        if (iUserPayIdentityProxy != null) {
            return iUserPayIdentityProxy.fetchCreditsBalanceData(continuation);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object fetchBillingUpgradePreparation(BillingUpgradePreparationMode billingUpgradePreparationMode, Continuation<? super BillingUpgradePreparationResult> continuation) {
        UserPayIdentityService$fetchBillingUpgradePreparation$1 userPayIdentityService$fetchBillingUpgradePreparation$1;
        int i;
        BillingUpgradePreparationResult billingUpgradePreparationResult;
        if (continuation instanceof UserPayIdentityService$fetchBillingUpgradePreparation$1) {
            userPayIdentityService$fetchBillingUpgradePreparation$1 = (UserPayIdentityService$fetchBillingUpgradePreparation$1) continuation;
            if ((userPayIdentityService$fetchBillingUpgradePreparation$1.label & Integer.MIN_VALUE) != 0) {
                userPayIdentityService$fetchBillingUpgradePreparation$1.label -= Integer.MIN_VALUE;
                Object obj = userPayIdentityService$fetchBillingUpgradePreparation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = userPayIdentityService$fetchBillingUpgradePreparation$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    IUserPayIdentityProxy iUserPayIdentityProxy = proxy;
                    if (iUserPayIdentityProxy != null) {
                        userPayIdentityService$fetchBillingUpgradePreparation$1.label = 1;
                        obj = iUserPayIdentityProxy.fetchBillingUpgradePreparation(billingUpgradePreparationMode, userPayIdentityService$fetchBillingUpgradePreparation$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return BillingUpgradePreparationResult.RetryableFailure.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                billingUpgradePreparationResult = (BillingUpgradePreparationResult) obj;
                if (billingUpgradePreparationResult != null) {
                    return billingUpgradePreparationResult;
                }
                return BillingUpgradePreparationResult.RetryableFailure.INSTANCE;
            }
        }
        userPayIdentityService$fetchBillingUpgradePreparation$1 = new UserPayIdentityService$fetchBillingUpgradePreparation$1(continuation);
        Object obj2 = userPayIdentityService$fetchBillingUpgradePreparation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = userPayIdentityService$fetchBillingUpgradePreparation$1.label;
        if (i != 0) {
        }
        billingUpgradePreparationResult = (BillingUpgradePreparationResult) obj2;
        if (billingUpgradePreparationResult != null) {
        }
        return BillingUpgradePreparationResult.RetryableFailure.INSTANCE;
    }
}

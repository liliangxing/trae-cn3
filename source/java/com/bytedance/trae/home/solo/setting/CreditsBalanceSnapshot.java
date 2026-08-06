package com.bytedance.trae.home.solo.setting;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.conversation.CreditsBalance;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserPayIdentityCache.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0012\u001a\u00020\u0013H×\u0001J\t\u0010\u0014\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/CreditsBalanceSnapshot;", "", "userId", "", "balance", "Lcom/bytedance/trae/conversation/CreditsBalance;", "<init>", "(Ljava/lang/String;Lcom/bytedance/trae/conversation/CreditsBalance;)V", "getUserId", "()Ljava/lang/String;", "getBalance", "()Lcom/bytedance/trae/conversation/CreditsBalance;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CreditsBalanceSnapshot {
    public static final int $stable = 8;
    private final CreditsBalance balance;
    private final String userId;

    public static /* synthetic */ CreditsBalanceSnapshot copy$default(CreditsBalanceSnapshot creditsBalanceSnapshot, String str, CreditsBalance creditsBalance, int i, Object obj) {
        if ((i & 1) != 0) {
            str = creditsBalanceSnapshot.userId;
        }
        if ((i & 2) != 0) {
            creditsBalance = creditsBalanceSnapshot.balance;
        }
        return creditsBalanceSnapshot.copy(str, creditsBalance);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component2, reason: from getter */
    public final CreditsBalance getBalance() {
        return this.balance;
    }

    public final CreditsBalanceSnapshot copy(String userId, CreditsBalance balance) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(balance, "balance");
        return new CreditsBalanceSnapshot(userId, balance);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreditsBalanceSnapshot)) {
            return false;
        }
        CreditsBalanceSnapshot creditsBalanceSnapshot = (CreditsBalanceSnapshot) other;
        return Intrinsics.areEqual(this.userId, creditsBalanceSnapshot.userId) && Intrinsics.areEqual(this.balance, creditsBalanceSnapshot.balance);
    }

    public int hashCode() {
        return (this.userId.hashCode() * 31) + this.balance.hashCode();
    }

    public String toString() {
        return "CreditsBalanceSnapshot(userId=" + this.userId + ", balance=" + this.balance + ')';
    }

    public CreditsBalanceSnapshot(String userId, CreditsBalance balance) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(balance, "balance");
        this.userId = userId;
        this.balance = balance;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final CreditsBalance getBalance() {
        return this.balance;
    }
}

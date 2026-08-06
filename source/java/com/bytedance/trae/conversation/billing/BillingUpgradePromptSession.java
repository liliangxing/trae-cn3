package com.bytedance.trae.conversation.billing;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BillingUpgradePromptEngine.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptSession;", "", "userId", "", "key", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getKey", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BillingUpgradePromptSession {
    private final String key;
    private final String userId;

    public static /* synthetic */ BillingUpgradePromptSession copy$default(BillingUpgradePromptSession billingUpgradePromptSession, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = billingUpgradePromptSession.userId;
        }
        if ((i & 2) != 0) {
            str2 = billingUpgradePromptSession.key;
        }
        return billingUpgradePromptSession.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    public final BillingUpgradePromptSession copy(String userId, String key) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(key, "key");
        return new BillingUpgradePromptSession(userId, key);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BillingUpgradePromptSession)) {
            return false;
        }
        BillingUpgradePromptSession billingUpgradePromptSession = (BillingUpgradePromptSession) other;
        return Intrinsics.areEqual(this.userId, billingUpgradePromptSession.userId) && Intrinsics.areEqual(this.key, billingUpgradePromptSession.key);
    }

    public int hashCode() {
        return (this.userId.hashCode() * 31) + this.key.hashCode();
    }

    public String toString() {
        return "BillingUpgradePromptSession(userId=" + this.userId + ", key=" + this.key + ')';
    }

    public BillingUpgradePromptSession(String userId, String key) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(key, "key");
        this.userId = userId;
        this.key = key;
    }

    public final String getUserId() {
        return this.userId;
    }

    public /* synthetic */ BillingUpgradePromptSession(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? BillingUpgradePromptPolicy.INSTANCE.shownKey(str) : str2);
    }

    public final String getKey() {
        return this.key;
    }
}

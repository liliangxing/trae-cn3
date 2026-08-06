package com.bytedance.trae.conversation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: CreditsBalancePolicy.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J \u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\fJ(\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/conversation/CreditsBalancePolicy;", "", "<init>", "()V", "DEFAULT_CLOSE_INTERVAL_MILLIS", "", "from", "Lcom/bytedance/trae/conversation/CreditsBalance;", "total", "used", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/bytedance/trae/conversation/CreditsBalance;", "isLowBalance", "", "remaining", "belongsToCurrentUser", "ownerUserId", "", "currentUserId", "creditsFeatureEnabled", "shouldShowReminder", "lastCloseTimeMillis", "nowMillis", "closeIntervalMillis", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CreditsBalancePolicy {
    public static final long DEFAULT_CLOSE_INTERVAL_MILLIS = 259200000;
    public static final CreditsBalancePolicy INSTANCE = new CreditsBalancePolicy();

    public final boolean isLowBalance(long remaining) {
        return 1 <= remaining && remaining < 11;
    }

    private CreditsBalancePolicy() {
    }

    public final CreditsBalance from(Long total, Long used) {
        if (total == null) {
            return null;
        }
        Long l = (total.longValue() > 0L ? 1 : (total.longValue() == 0L ? 0 : -1)) >= 0 ? total : null;
        if (l == null) {
            return null;
        }
        long longValue = l.longValue();
        if (used == null) {
            return null;
        }
        Long l2 = used.longValue() >= 0 ? used : null;
        if (l2 == null) {
            return null;
        }
        long longValue2 = l2.longValue();
        return new CreditsBalance(longValue, longValue2, RangesKt.coerceAtLeast(longValue - longValue2, 0L), false, 8, null);
    }

    public final boolean belongsToCurrentUser(String ownerUserId, String currentUserId, boolean creditsFeatureEnabled) {
        Intrinsics.checkNotNullParameter(ownerUserId, "ownerUserId");
        return creditsFeatureEnabled && (StringsKt.isBlank(ownerUserId) ^ true) && Intrinsics.areEqual(ownerUserId, currentUserId);
    }

    public final boolean shouldShowReminder(long remaining, long lastCloseTimeMillis, long nowMillis, long closeIntervalMillis) {
        if (isLowBalance(remaining)) {
            return lastCloseTimeMillis <= 0 || nowMillis - lastCloseTimeMillis >= closeIntervalMillis;
        }
        return false;
    }
}

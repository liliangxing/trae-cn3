package com.bytedance.trae.conversation.upgrade;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;

/* compiled from: UpgradeReminderSettings.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;", "", "enabled", "", "recommendedHighest", "", "<init>", "(ZJ)V", "getEnabled", "()Z", "getRecommendedHighest", "()J", "component1", "component2", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UpgradeReminderConfig {
    private final boolean enabled;
    private final long recommendedHighest;

    public static /* synthetic */ UpgradeReminderConfig copy$default(UpgradeReminderConfig upgradeReminderConfig, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            z = upgradeReminderConfig.enabled;
        }
        if ((i & 2) != 0) {
            j = upgradeReminderConfig.recommendedHighest;
        }
        return upgradeReminderConfig.copy(z, j);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: component2, reason: from getter */
    public final long getRecommendedHighest() {
        return this.recommendedHighest;
    }

    public final UpgradeReminderConfig copy(boolean enabled, long recommendedHighest) {
        return new UpgradeReminderConfig(enabled, recommendedHighest);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpgradeReminderConfig)) {
            return false;
        }
        UpgradeReminderConfig upgradeReminderConfig = (UpgradeReminderConfig) other;
        return this.enabled == upgradeReminderConfig.enabled && this.recommendedHighest == upgradeReminderConfig.recommendedHighest;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.enabled) * 31) + Long.hashCode(this.recommendedHighest);
    }

    public String toString() {
        return "UpgradeReminderConfig(enabled=" + this.enabled + ", recommendedHighest=" + this.recommendedHighest + ')';
    }

    public UpgradeReminderConfig(boolean z, long j) {
        this.enabled = z;
        this.recommendedHighest = j;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final long getRecommendedHighest() {
        return this.recommendedHighest;
    }
}

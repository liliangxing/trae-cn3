package com.bytedance.trae.praise;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.xbridge.XBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PraiseDialogTrigger.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lcom/bytedance/trae/praise/PraiseRatingConfig;", "", "enable", "", "leastChatTimesBeforeTrigger", "", "maxCount", "refuseBlockTimeHours", "", "ignoreUgRule", "<init>", "(ZIIJZ)V", "getEnable", "()Z", "getLeastChatTimesBeforeTrigger", "()I", "getMaxCount", "getRefuseBlockTimeHours", "()J", "getIgnoreUgRule", "component1", "component2", "component3", "component4", "component5", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "Companion", "praise_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PraiseRatingConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final PraiseRatingConfig DEFAULT = new PraiseRatingConfig(false, 3, 2, 168, true);
    private final boolean enable;
    private final boolean ignoreUgRule;
    private final int leastChatTimesBeforeTrigger;
    private final int maxCount;
    private final long refuseBlockTimeHours;

    public static /* synthetic */ PraiseRatingConfig copy$default(PraiseRatingConfig praiseRatingConfig, boolean z, int i, int i2, long j, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = praiseRatingConfig.enable;
        }
        if ((i3 & 2) != 0) {
            i = praiseRatingConfig.leastChatTimesBeforeTrigger;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = praiseRatingConfig.maxCount;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            j = praiseRatingConfig.refuseBlockTimeHours;
        }
        long j2 = j;
        if ((i3 & 16) != 0) {
            z2 = praiseRatingConfig.ignoreUgRule;
        }
        return praiseRatingConfig.copy(z, i4, i5, j2, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2, reason: from getter */
    public final int getLeastChatTimesBeforeTrigger() {
        return this.leastChatTimesBeforeTrigger;
    }

    /* renamed from: component3, reason: from getter */
    public final int getMaxCount() {
        return this.maxCount;
    }

    /* renamed from: component4, reason: from getter */
    public final long getRefuseBlockTimeHours() {
        return this.refuseBlockTimeHours;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIgnoreUgRule() {
        return this.ignoreUgRule;
    }

    public final PraiseRatingConfig copy(boolean enable, int leastChatTimesBeforeTrigger, int maxCount, long refuseBlockTimeHours, boolean ignoreUgRule) {
        return new PraiseRatingConfig(enable, leastChatTimesBeforeTrigger, maxCount, refuseBlockTimeHours, ignoreUgRule);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PraiseRatingConfig)) {
            return false;
        }
        PraiseRatingConfig praiseRatingConfig = (PraiseRatingConfig) other;
        return this.enable == praiseRatingConfig.enable && this.leastChatTimesBeforeTrigger == praiseRatingConfig.leastChatTimesBeforeTrigger && this.maxCount == praiseRatingConfig.maxCount && this.refuseBlockTimeHours == praiseRatingConfig.refuseBlockTimeHours && this.ignoreUgRule == praiseRatingConfig.ignoreUgRule;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.enable) * 31) + Integer.hashCode(this.leastChatTimesBeforeTrigger)) * 31) + Integer.hashCode(this.maxCount)) * 31) + Long.hashCode(this.refuseBlockTimeHours)) * 31) + Boolean.hashCode(this.ignoreUgRule);
    }

    public String toString() {
        return "PraiseRatingConfig(enable=" + this.enable + ", leastChatTimesBeforeTrigger=" + this.leastChatTimesBeforeTrigger + ", maxCount=" + this.maxCount + ", refuseBlockTimeHours=" + this.refuseBlockTimeHours + ", ignoreUgRule=" + this.ignoreUgRule + ')';
    }

    public PraiseRatingConfig(boolean z, int i, int i2, long j, boolean z2) {
        this.enable = z;
        this.leastChatTimesBeforeTrigger = i;
        this.maxCount = i2;
        this.refuseBlockTimeHours = j;
        this.ignoreUgRule = z2;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getLeastChatTimesBeforeTrigger() {
        return this.leastChatTimesBeforeTrigger;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    public final long getRefuseBlockTimeHours() {
        return this.refuseBlockTimeHours;
    }

    public final boolean getIgnoreUgRule() {
        return this.ignoreUgRule;
    }

    /* compiled from: PraiseDialogTrigger.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/praise/PraiseRatingConfig$Companion;", "", "<init>", "()V", XBridge.DEFAULT_NAMESPACE, "Lcom/bytedance/trae/praise/PraiseRatingConfig;", "getDEFAULT", "()Lcom/bytedance/trae/praise/PraiseRatingConfig;", "praise_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PraiseRatingConfig getDEFAULT() {
            return PraiseRatingConfig.DEFAULT;
        }
    }
}

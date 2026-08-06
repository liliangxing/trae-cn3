package com.bytedance.trae.conversation;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CreditsBalancePolicy.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/CreditsBalance;", "", "total", "", "used", "remaining", "infinite", "", "<init>", "(JJJZ)V", "getTotal", "()J", "getUsed", "getRemaining", "getInfinite", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CreditsBalance {
    private final boolean infinite;
    private final long remaining;
    private final long total;
    private final long used;

    /* renamed from: component1, reason: from getter */
    public final long getTotal() {
        return this.total;
    }

    /* renamed from: component2, reason: from getter */
    public final long getUsed() {
        return this.used;
    }

    /* renamed from: component3, reason: from getter */
    public final long getRemaining() {
        return this.remaining;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getInfinite() {
        return this.infinite;
    }

    public final CreditsBalance copy(long total, long used, long remaining, boolean infinite) {
        return new CreditsBalance(total, used, remaining, infinite);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreditsBalance)) {
            return false;
        }
        CreditsBalance creditsBalance = (CreditsBalance) other;
        return this.total == creditsBalance.total && this.used == creditsBalance.used && this.remaining == creditsBalance.remaining && this.infinite == creditsBalance.infinite;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.total) * 31) + Long.hashCode(this.used)) * 31) + Long.hashCode(this.remaining)) * 31) + Boolean.hashCode(this.infinite);
    }

    public String toString() {
        return "CreditsBalance(total=" + this.total + ", used=" + this.used + ", remaining=" + this.remaining + ", infinite=" + this.infinite + ')';
    }

    public CreditsBalance(long j, long j2, long j3, boolean z) {
        this.total = j;
        this.used = j2;
        this.remaining = j3;
        this.infinite = z;
    }

    public /* synthetic */ CreditsBalance(long j, long j2, long j3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, (i & 8) != 0 ? false : z);
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

package com.bytedance.trae.home.solo.setting;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: UserPayIdentityCache.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÇ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0014\u001a\u00020\u0015H×\u0001J\t\u0010\u0016\u001a\u00020\u0017H×\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;", "", "remaining", "", "total", "infinite", "", "<init>", "(JJZ)V", "getRemaining", "()J", "getTotal", "getInfinite", "()Z", "component1", "component2", "component3", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UsageQuotaData {
    public static final int $stable = 0;

    @SerializedName("infinite")
    private final boolean infinite;

    @SerializedName("remaining")
    private final long remaining;

    @SerializedName("total")
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

    public /* synthetic */ UsageQuotaData(long j, long j2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? false : z);
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
}

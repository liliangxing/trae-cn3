package com.bytedance.trae.home.solo.setting;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserEntStatusApi.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÇ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0014\u001a\u00020\u0003H×\u0001J\t\u0010\u0015\u001a\u00020\u0016H×\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;", "", "periodType", "", "quota", "Lcom/bytedance/trae/home/solo/setting/EntQuota;", "<init>", "(Ljava/lang/Integer;Lcom/bytedance/trae/home/solo/setting/EntQuota;)V", "getPeriodType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getQuota", "()Lcom/bytedance/trae/home/solo/setting/EntQuota;", "component1", "component2", "copy", "(Ljava/lang/Integer;Lcom/bytedance/trae/home/solo/setting/EntQuota;)Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class EntSubscriptionExtra {
    public static final int $stable = 0;

    @SerializedName("period_type")
    private final Integer periodType;

    @SerializedName("quota")
    private final EntQuota quota;

    /* JADX WARN: Multi-variable type inference failed */
    public EntSubscriptionExtra() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ EntSubscriptionExtra copy$default(EntSubscriptionExtra entSubscriptionExtra, Integer num, EntQuota entQuota, int i, Object obj) {
        if ((i & 1) != 0) {
            num = entSubscriptionExtra.periodType;
        }
        if ((i & 2) != 0) {
            entQuota = entSubscriptionExtra.quota;
        }
        return entSubscriptionExtra.copy(num, entQuota);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getPeriodType() {
        return this.periodType;
    }

    /* renamed from: component2, reason: from getter */
    public final EntQuota getQuota() {
        return this.quota;
    }

    public final EntSubscriptionExtra copy(Integer periodType, EntQuota quota) {
        return new EntSubscriptionExtra(periodType, quota);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EntSubscriptionExtra)) {
            return false;
        }
        EntSubscriptionExtra entSubscriptionExtra = (EntSubscriptionExtra) other;
        return Intrinsics.areEqual(this.periodType, entSubscriptionExtra.periodType) && Intrinsics.areEqual(this.quota, entSubscriptionExtra.quota);
    }

    public int hashCode() {
        Integer num = this.periodType;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        EntQuota entQuota = this.quota;
        return hashCode + (entQuota != null ? entQuota.hashCode() : 0);
    }

    public String toString() {
        return "EntSubscriptionExtra(periodType=" + this.periodType + ", quota=" + this.quota + ')';
    }

    public EntSubscriptionExtra(Integer num, EntQuota entQuota) {
        this.periodType = num;
        this.quota = entQuota;
    }

    public /* synthetic */ EntSubscriptionExtra(Integer num, EntQuota entQuota, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : entQuota);
    }

    public final Integer getPeriodType() {
        return this.periodType;
    }

    public final EntQuota getQuota() {
        return this.quota;
    }
}

package com.bytedance.trae.home.solo.setting;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserEntStatusApi.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ>\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÇ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001d\u001a\u00020\u0005H×\u0001J\t\u0010\u001e\u001a\u00020\u001fH×\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0013\u0010\u000e¨\u0006 "}, d2 = {"Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;", "", "quota", "Lcom/bytedance/trae/home/solo/setting/EntQuota;", "packageDurationType", "", "duration", "", "packageSourceType", "<init>", "(Lcom/bytedance/trae/home/solo/setting/EntQuota;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;)V", "getQuota", "()Lcom/bytedance/trae/home/solo/setting/EntQuota;", "getPackageDurationType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPackageSourceType", "component1", "component2", "component3", "component4", "copy", "(Lcom/bytedance/trae/home/solo/setting/EntQuota;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;)Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class EntPackageExtra {
    public static final int $stable = 0;

    @SerializedName("duration")
    private final Long duration;

    @SerializedName("package_duration_type")
    private final Integer packageDurationType;

    @SerializedName("package_source_type")
    private final Integer packageSourceType;

    @SerializedName("quota")
    private final EntQuota quota;

    public EntPackageExtra() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ EntPackageExtra copy$default(EntPackageExtra entPackageExtra, EntQuota entQuota, Integer num, Long l, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            entQuota = entPackageExtra.quota;
        }
        if ((i & 2) != 0) {
            num = entPackageExtra.packageDurationType;
        }
        if ((i & 4) != 0) {
            l = entPackageExtra.duration;
        }
        if ((i & 8) != 0) {
            num2 = entPackageExtra.packageSourceType;
        }
        return entPackageExtra.copy(entQuota, num, l, num2);
    }

    /* renamed from: component1, reason: from getter */
    public final EntQuota getQuota() {
        return this.quota;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getPackageDurationType() {
        return this.packageDurationType;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getDuration() {
        return this.duration;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getPackageSourceType() {
        return this.packageSourceType;
    }

    public final EntPackageExtra copy(EntQuota quota, Integer packageDurationType, Long duration, Integer packageSourceType) {
        return new EntPackageExtra(quota, packageDurationType, duration, packageSourceType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EntPackageExtra)) {
            return false;
        }
        EntPackageExtra entPackageExtra = (EntPackageExtra) other;
        return Intrinsics.areEqual(this.quota, entPackageExtra.quota) && Intrinsics.areEqual(this.packageDurationType, entPackageExtra.packageDurationType) && Intrinsics.areEqual(this.duration, entPackageExtra.duration) && Intrinsics.areEqual(this.packageSourceType, entPackageExtra.packageSourceType);
    }

    public int hashCode() {
        EntQuota entQuota = this.quota;
        int hashCode = (entQuota == null ? 0 : entQuota.hashCode()) * 31;
        Integer num = this.packageDurationType;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Long l = this.duration;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Integer num2 = this.packageSourceType;
        return hashCode3 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "EntPackageExtra(quota=" + this.quota + ", packageDurationType=" + this.packageDurationType + ", duration=" + this.duration + ", packageSourceType=" + this.packageSourceType + ')';
    }

    public EntPackageExtra(EntQuota entQuota, Integer num, Long l, Integer num2) {
        this.quota = entQuota;
        this.packageDurationType = num;
        this.duration = l;
        this.packageSourceType = num2;
    }

    public /* synthetic */ EntPackageExtra(EntQuota entQuota, Integer num, Long l, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : entQuota, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : num2);
    }

    public final EntQuota getQuota() {
        return this.quota;
    }

    public final Integer getPackageDurationType() {
        return this.packageDurationType;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final Integer getPackageSourceType() {
        return this.packageSourceType;
    }
}

package com.bytedance.trae.home.solo.setting;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserEntStatusApi.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0012\u001a\u00020\u0013H×\u0001J\t\u0010\u0014\u001a\u00020\u0015H×\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/EntProductExtra;", "", "subscriptionExtra", "Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;", "packageExtra", "Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;", "<init>", "(Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;)V", "getSubscriptionExtra", "()Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;", "getPackageExtra", "()Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class EntProductExtra {
    public static final int $stable = 0;

    @SerializedName("package_extra")
    private final EntPackageExtra packageExtra;

    @SerializedName("subscription_extra")
    private final EntSubscriptionExtra subscriptionExtra;

    /* JADX WARN: Multi-variable type inference failed */
    public EntProductExtra() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ EntProductExtra copy$default(EntProductExtra entProductExtra, EntSubscriptionExtra entSubscriptionExtra, EntPackageExtra entPackageExtra, int i, Object obj) {
        if ((i & 1) != 0) {
            entSubscriptionExtra = entProductExtra.subscriptionExtra;
        }
        if ((i & 2) != 0) {
            entPackageExtra = entProductExtra.packageExtra;
        }
        return entProductExtra.copy(entSubscriptionExtra, entPackageExtra);
    }

    /* renamed from: component1, reason: from getter */
    public final EntSubscriptionExtra getSubscriptionExtra() {
        return this.subscriptionExtra;
    }

    /* renamed from: component2, reason: from getter */
    public final EntPackageExtra getPackageExtra() {
        return this.packageExtra;
    }

    public final EntProductExtra copy(EntSubscriptionExtra subscriptionExtra, EntPackageExtra packageExtra) {
        return new EntProductExtra(subscriptionExtra, packageExtra);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EntProductExtra)) {
            return false;
        }
        EntProductExtra entProductExtra = (EntProductExtra) other;
        return Intrinsics.areEqual(this.subscriptionExtra, entProductExtra.subscriptionExtra) && Intrinsics.areEqual(this.packageExtra, entProductExtra.packageExtra);
    }

    public int hashCode() {
        EntSubscriptionExtra entSubscriptionExtra = this.subscriptionExtra;
        int hashCode = (entSubscriptionExtra == null ? 0 : entSubscriptionExtra.hashCode()) * 31;
        EntPackageExtra entPackageExtra = this.packageExtra;
        return hashCode + (entPackageExtra != null ? entPackageExtra.hashCode() : 0);
    }

    public String toString() {
        return "EntProductExtra(subscriptionExtra=" + this.subscriptionExtra + ", packageExtra=" + this.packageExtra + ')';
    }

    public EntProductExtra(EntSubscriptionExtra entSubscriptionExtra, EntPackageExtra entPackageExtra) {
        this.subscriptionExtra = entSubscriptionExtra;
        this.packageExtra = entPackageExtra;
    }

    public /* synthetic */ EntProductExtra(EntSubscriptionExtra entSubscriptionExtra, EntPackageExtra entPackageExtra, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : entSubscriptionExtra, (i & 2) != 0 ? null : entPackageExtra);
    }

    public final EntSubscriptionExtra getSubscriptionExtra() {
        return this.subscriptionExtra;
    }

    public final EntPackageExtra getPackageExtra() {
        return this.packageExtra;
    }
}

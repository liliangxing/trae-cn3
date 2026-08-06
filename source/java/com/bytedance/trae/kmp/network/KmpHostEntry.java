package com.bytedance.trae.kmp.network;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpHostResolver.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0016\u001a\u00020\u0017H×\u0001J\t\u0010\u0018\u001a\u00020\u0019H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/kmp/network/KmpHostEntry;", "", "publicUser", "Lcom/bytedance/trae/kmp/network/KmpDomainList;", "bytecloudUser", "enterpriseUser", "enterpriseBoeUser", "<init>", "(Lcom/bytedance/trae/kmp/network/KmpDomainList;Lcom/bytedance/trae/kmp/network/KmpDomainList;Lcom/bytedance/trae/kmp/network/KmpDomainList;Lcom/bytedance/trae/kmp/network/KmpDomainList;)V", "getPublicUser", "()Lcom/bytedance/trae/kmp/network/KmpDomainList;", "getBytecloudUser", "getEnterpriseUser", "getEnterpriseBoeUser", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class KmpHostEntry {
    public static final int $stable = 8;
    private final KmpDomainList bytecloudUser;
    private final KmpDomainList enterpriseBoeUser;
    private final KmpDomainList enterpriseUser;
    private final KmpDomainList publicUser;

    public static /* synthetic */ KmpHostEntry copy$default(KmpHostEntry kmpHostEntry, KmpDomainList kmpDomainList, KmpDomainList kmpDomainList2, KmpDomainList kmpDomainList3, KmpDomainList kmpDomainList4, int i, Object obj) {
        if ((i & 1) != 0) {
            kmpDomainList = kmpHostEntry.publicUser;
        }
        if ((i & 2) != 0) {
            kmpDomainList2 = kmpHostEntry.bytecloudUser;
        }
        if ((i & 4) != 0) {
            kmpDomainList3 = kmpHostEntry.enterpriseUser;
        }
        if ((i & 8) != 0) {
            kmpDomainList4 = kmpHostEntry.enterpriseBoeUser;
        }
        return kmpHostEntry.copy(kmpDomainList, kmpDomainList2, kmpDomainList3, kmpDomainList4);
    }

    /* renamed from: component1, reason: from getter */
    public final KmpDomainList getPublicUser() {
        return this.publicUser;
    }

    /* renamed from: component2, reason: from getter */
    public final KmpDomainList getBytecloudUser() {
        return this.bytecloudUser;
    }

    /* renamed from: component3, reason: from getter */
    public final KmpDomainList getEnterpriseUser() {
        return this.enterpriseUser;
    }

    /* renamed from: component4, reason: from getter */
    public final KmpDomainList getEnterpriseBoeUser() {
        return this.enterpriseBoeUser;
    }

    public final KmpHostEntry copy(KmpDomainList publicUser, KmpDomainList bytecloudUser, KmpDomainList enterpriseUser, KmpDomainList enterpriseBoeUser) {
        Intrinsics.checkNotNullParameter(publicUser, "publicUser");
        return new KmpHostEntry(publicUser, bytecloudUser, enterpriseUser, enterpriseBoeUser);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KmpHostEntry)) {
            return false;
        }
        KmpHostEntry kmpHostEntry = (KmpHostEntry) other;
        return Intrinsics.areEqual(this.publicUser, kmpHostEntry.publicUser) && Intrinsics.areEqual(this.bytecloudUser, kmpHostEntry.bytecloudUser) && Intrinsics.areEqual(this.enterpriseUser, kmpHostEntry.enterpriseUser) && Intrinsics.areEqual(this.enterpriseBoeUser, kmpHostEntry.enterpriseBoeUser);
    }

    public int hashCode() {
        int hashCode = this.publicUser.hashCode() * 31;
        KmpDomainList kmpDomainList = this.bytecloudUser;
        int hashCode2 = (hashCode + (kmpDomainList == null ? 0 : kmpDomainList.hashCode())) * 31;
        KmpDomainList kmpDomainList2 = this.enterpriseUser;
        int hashCode3 = (hashCode2 + (kmpDomainList2 == null ? 0 : kmpDomainList2.hashCode())) * 31;
        KmpDomainList kmpDomainList3 = this.enterpriseBoeUser;
        return hashCode3 + (kmpDomainList3 != null ? kmpDomainList3.hashCode() : 0);
    }

    public String toString() {
        return "KmpHostEntry(publicUser=" + this.publicUser + ", bytecloudUser=" + this.bytecloudUser + ", enterpriseUser=" + this.enterpriseUser + ", enterpriseBoeUser=" + this.enterpriseBoeUser + ')';
    }

    public KmpHostEntry(KmpDomainList publicUser, KmpDomainList kmpDomainList, KmpDomainList kmpDomainList2, KmpDomainList kmpDomainList3) {
        Intrinsics.checkNotNullParameter(publicUser, "publicUser");
        this.publicUser = publicUser;
        this.bytecloudUser = kmpDomainList;
        this.enterpriseUser = kmpDomainList2;
        this.enterpriseBoeUser = kmpDomainList3;
    }

    public /* synthetic */ KmpHostEntry(KmpDomainList kmpDomainList, KmpDomainList kmpDomainList2, KmpDomainList kmpDomainList3, KmpDomainList kmpDomainList4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kmpDomainList, (i & 2) != 0 ? null : kmpDomainList2, (i & 4) != 0 ? null : kmpDomainList3, (i & 8) != 0 ? null : kmpDomainList4);
    }

    public final KmpDomainList getPublicUser() {
        return this.publicUser;
    }

    public final KmpDomainList getBytecloudUser() {
        return this.bytecloudUser;
    }

    public final KmpDomainList getEnterpriseUser() {
        return this.enterpriseUser;
    }

    public final KmpDomainList getEnterpriseBoeUser() {
        return this.enterpriseBoeUser;
    }
}

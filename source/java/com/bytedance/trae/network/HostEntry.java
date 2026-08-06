package com.bytedance.trae.network;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostResolver.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/network/HostEntry;", "", "publicUser", "Lcom/bytedance/trae/network/DomainList;", "bytecloudUser", "enterpriseUser", "enterpriseBoeUser", "<init>", "(Lcom/bytedance/trae/network/DomainList;Lcom/bytedance/trae/network/DomainList;Lcom/bytedance/trae/network/DomainList;Lcom/bytedance/trae/network/DomainList;)V", "getPublicUser", "()Lcom/bytedance/trae/network/DomainList;", "getBytecloudUser", "getEnterpriseUser", "getEnterpriseBoeUser", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "Builder", "Companion", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class HostEntry {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DomainList bytecloudUser;
    private final DomainList enterpriseBoeUser;
    private final DomainList enterpriseUser;
    private final DomainList publicUser;

    @JvmStatic
    public static final Builder builder() {
        return INSTANCE.builder();
    }

    public static /* synthetic */ HostEntry copy$default(HostEntry hostEntry, DomainList domainList, DomainList domainList2, DomainList domainList3, DomainList domainList4, int i, Object obj) {
        if ((i & 1) != 0) {
            domainList = hostEntry.publicUser;
        }
        if ((i & 2) != 0) {
            domainList2 = hostEntry.bytecloudUser;
        }
        if ((i & 4) != 0) {
            domainList3 = hostEntry.enterpriseUser;
        }
        if ((i & 8) != 0) {
            domainList4 = hostEntry.enterpriseBoeUser;
        }
        return hostEntry.copy(domainList, domainList2, domainList3, domainList4);
    }

    /* renamed from: component1, reason: from getter */
    public final DomainList getPublicUser() {
        return this.publicUser;
    }

    /* renamed from: component2, reason: from getter */
    public final DomainList getBytecloudUser() {
        return this.bytecloudUser;
    }

    /* renamed from: component3, reason: from getter */
    public final DomainList getEnterpriseUser() {
        return this.enterpriseUser;
    }

    /* renamed from: component4, reason: from getter */
    public final DomainList getEnterpriseBoeUser() {
        return this.enterpriseBoeUser;
    }

    public final HostEntry copy(DomainList publicUser, DomainList bytecloudUser, DomainList enterpriseUser, DomainList enterpriseBoeUser) {
        Intrinsics.checkNotNullParameter(publicUser, "publicUser");
        return new HostEntry(publicUser, bytecloudUser, enterpriseUser, enterpriseBoeUser);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostEntry)) {
            return false;
        }
        HostEntry hostEntry = (HostEntry) other;
        return Intrinsics.areEqual(this.publicUser, hostEntry.publicUser) && Intrinsics.areEqual(this.bytecloudUser, hostEntry.bytecloudUser) && Intrinsics.areEqual(this.enterpriseUser, hostEntry.enterpriseUser) && Intrinsics.areEqual(this.enterpriseBoeUser, hostEntry.enterpriseBoeUser);
    }

    public int hashCode() {
        int hashCode = this.publicUser.hashCode() * 31;
        DomainList domainList = this.bytecloudUser;
        int hashCode2 = (hashCode + (domainList == null ? 0 : domainList.hashCode())) * 31;
        DomainList domainList2 = this.enterpriseUser;
        int hashCode3 = (hashCode2 + (domainList2 == null ? 0 : domainList2.hashCode())) * 31;
        DomainList domainList3 = this.enterpriseBoeUser;
        return hashCode3 + (domainList3 != null ? domainList3.hashCode() : 0);
    }

    public String toString() {
        return "HostEntry(publicUser=" + this.publicUser + ", bytecloudUser=" + this.bytecloudUser + ", enterpriseUser=" + this.enterpriseUser + ", enterpriseBoeUser=" + this.enterpriseBoeUser + ')';
    }

    public HostEntry(DomainList publicUser, DomainList domainList, DomainList domainList2, DomainList domainList3) {
        Intrinsics.checkNotNullParameter(publicUser, "publicUser");
        this.publicUser = publicUser;
        this.bytecloudUser = domainList;
        this.enterpriseUser = domainList2;
        this.enterpriseBoeUser = domainList3;
    }

    public /* synthetic */ HostEntry(DomainList domainList, DomainList domainList2, DomainList domainList3, DomainList domainList4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(domainList, (i & 2) != 0 ? null : domainList2, (i & 4) != 0 ? null : domainList3, (i & 8) != 0 ? null : domainList4);
    }

    public final DomainList getPublicUser() {
        return this.publicUser;
    }

    public final DomainList getBytecloudUser() {
        return this.bytecloudUser;
    }

    public final DomainList getEnterpriseUser() {
        return this.enterpriseUser;
    }

    public final DomainList getEnterpriseBoeUser() {
        return this.enterpriseBoeUser;
    }

    /* compiled from: HostResolver.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/network/HostEntry$Builder;", "", "<init>", "()V", "publicUser", "Lcom/bytedance/trae/network/DomainList;", "bytecloudUser", "enterpriseUser", "enterpriseBoeUser", "domain", "build", "Lcom/bytedance/trae/network/HostEntry;", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Builder {
        private DomainList bytecloudUser;
        private DomainList enterpriseBoeUser;
        private DomainList enterpriseUser;
        private DomainList publicUser;

        public final Builder publicUser(DomainList domain) {
            Intrinsics.checkNotNullParameter(domain, "domain");
            this.publicUser = domain;
            return this;
        }

        public final Builder bytecloudUser(DomainList domain) {
            Intrinsics.checkNotNullParameter(domain, "domain");
            this.bytecloudUser = domain;
            return this;
        }

        public final Builder enterpriseUser(DomainList domain) {
            Intrinsics.checkNotNullParameter(domain, "domain");
            this.enterpriseUser = domain;
            return this;
        }

        public final Builder enterpriseBoeUser(DomainList domain) {
            Intrinsics.checkNotNullParameter(domain, "domain");
            this.enterpriseBoeUser = domain;
            return this;
        }

        public final HostEntry build() {
            DomainList domainList = this.publicUser;
            if (domainList != null) {
                return new HostEntry(domainList, this.bytecloudUser, this.enterpriseUser, this.enterpriseBoeUser);
            }
            throw new IllegalArgumentException("publicUser domain is required".toString());
        }
    }

    /* compiled from: HostResolver.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/network/HostEntry$Companion;", "", "<init>", "()V", "builder", "Lcom/bytedance/trae/network/HostEntry$Builder;", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Builder builder() {
            return new Builder();
        }
    }
}

package com.bytedance.trae.network;

import com.bytedance.forest.model.PreloadConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostResolver.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/network/DomainList;", "", "normal", "", "regions", "", "Lcom/bytedance/trae/network/AiRegion;", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getNormal", "()Ljava/lang/String;", "getRegions", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class DomainList {
    private final String normal;
    private final Map<AiRegion, String> regions;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DomainList(String normal) {
        this(normal, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(normal, "normal");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DomainList copy$default(DomainList domainList, String str, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = domainList.normal;
        }
        if ((i & 2) != 0) {
            map = domainList.regions;
        }
        return domainList.copy(str, map);
    }

    /* renamed from: component1, reason: from getter */
    public final String getNormal() {
        return this.normal;
    }

    public final Map<AiRegion, String> component2() {
        return this.regions;
    }

    public final DomainList copy(String normal, Map<AiRegion, String> regions) {
        Intrinsics.checkNotNullParameter(normal, "normal");
        Intrinsics.checkNotNullParameter(regions, "regions");
        return new DomainList(normal, regions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainList)) {
            return false;
        }
        DomainList domainList = (DomainList) other;
        return Intrinsics.areEqual(this.normal, domainList.normal) && Intrinsics.areEqual(this.regions, domainList.regions);
    }

    public int hashCode() {
        return (this.normal.hashCode() * 31) + this.regions.hashCode();
    }

    public String toString() {
        return "DomainList(normal=" + this.normal + ", regions=" + this.regions + ')';
    }

    public DomainList(String normal, Map<AiRegion, String> regions) {
        Intrinsics.checkNotNullParameter(normal, "normal");
        Intrinsics.checkNotNullParameter(regions, "regions");
        this.normal = normal;
        this.regions = regions;
    }

    public final String getNormal() {
        return this.normal;
    }

    public /* synthetic */ DomainList(String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<AiRegion, String> getRegions() {
        return this.regions;
    }
}

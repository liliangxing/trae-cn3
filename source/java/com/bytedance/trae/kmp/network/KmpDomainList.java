package com.bytedance.trae.kmp.network;

import com.bytedance.forest.model.PreloadConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpHostResolver.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005HÇ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0013\u001a\u00020\u0014H×\u0001J\t\u0010\u0015\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/kmp/network/KmpDomainList;", "", "normal", "", "regions", "", "Lcom/bytedance/trae/kmp/network/KmpAiRegion;", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getNormal", "()Ljava/lang/String;", "getRegions", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class KmpDomainList {
    public static final int $stable = 8;
    private final String normal;
    private final Map<KmpAiRegion, String> regions;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KmpDomainList copy$default(KmpDomainList kmpDomainList, String str, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = kmpDomainList.normal;
        }
        if ((i & 2) != 0) {
            map = kmpDomainList.regions;
        }
        return kmpDomainList.copy(str, map);
    }

    /* renamed from: component1, reason: from getter */
    public final String getNormal() {
        return this.normal;
    }

    public final Map<KmpAiRegion, String> component2() {
        return this.regions;
    }

    public final KmpDomainList copy(String normal, Map<KmpAiRegion, String> regions) {
        Intrinsics.checkNotNullParameter(normal, "normal");
        Intrinsics.checkNotNullParameter(regions, "regions");
        return new KmpDomainList(normal, regions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KmpDomainList)) {
            return false;
        }
        KmpDomainList kmpDomainList = (KmpDomainList) other;
        return Intrinsics.areEqual(this.normal, kmpDomainList.normal) && Intrinsics.areEqual(this.regions, kmpDomainList.regions);
    }

    public int hashCode() {
        return (this.normal.hashCode() * 31) + this.regions.hashCode();
    }

    public String toString() {
        return "KmpDomainList(normal=" + this.normal + ", regions=" + this.regions + ')';
    }

    public KmpDomainList(String normal, Map<KmpAiRegion, String> regions) {
        Intrinsics.checkNotNullParameter(normal, "normal");
        Intrinsics.checkNotNullParameter(regions, "regions");
        this.normal = normal;
        this.regions = regions;
    }

    public final String getNormal() {
        return this.normal;
    }

    public /* synthetic */ KmpDomainList(String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<KmpAiRegion, String> getRegions() {
        return this.regions;
    }
}

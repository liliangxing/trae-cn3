package com.bytedance.timonbase.commoncache;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TMCacheConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/timonbase/commoncache/TMCacheConfig;", "", "enable", "", "cacheGroups", "", "Lcom/bytedance/timonbase/commoncache/CacheGroup;", "(ZLjava/util/List;)V", "getCacheGroups", "()Ljava/util/List;", "getEnable", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class TMCacheConfig {

    @SerializedName("cache_groups")
    private final List<CacheGroup> cacheGroups;

    @SerializedName("enable")
    private final boolean enable;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TMCacheConfig() {
        this(false, r0, 3, r0);
        List list = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TMCacheConfig copy$default(TMCacheConfig tMCacheConfig, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = tMCacheConfig.enable;
        }
        if ((i & 2) != 0) {
            list = tMCacheConfig.cacheGroups;
        }
        return tMCacheConfig.copy(z, list);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    public final List<CacheGroup> component2() {
        return this.cacheGroups;
    }

    public final TMCacheConfig copy(boolean enable, List<CacheGroup> cacheGroups) {
        Intrinsics.checkParameterIsNotNull(cacheGroups, "cacheGroups");
        return new TMCacheConfig(enable, cacheGroups);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TMCacheConfig)) {
            return false;
        }
        TMCacheConfig tMCacheConfig = (TMCacheConfig) other;
        return this.enable == tMCacheConfig.enable && Intrinsics.areEqual(this.cacheGroups, tMCacheConfig.cacheGroups);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.enable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        List<CacheGroup> list = this.cacheGroups;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "TMCacheConfig(enable=" + this.enable + ", cacheGroups=" + this.cacheGroups + ")";
    }

    public TMCacheConfig(boolean z, List<CacheGroup> list) {
        Intrinsics.checkParameterIsNotNull(list, "cacheGroups");
        this.enable = z;
        this.cacheGroups = list;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public /* synthetic */ TMCacheConfig(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<CacheGroup> getCacheGroups() {
        return this.cacheGroups;
    }
}

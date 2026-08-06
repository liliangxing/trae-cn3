package com.bytedance.timonbase.commoncache;

import com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TMCacheConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0018\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u0015\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JW\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\tHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006#"}, d2 = {"Lcom/bytedance/timonbase/commoncache/CacheGroup;", "", "store", "", "strategy", "intercept", "", "apiIds", "", "", "params", "", "filter", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Ljava/util/Map;Ljava/lang/String;)V", "getApiIds", "()Ljava/util/List;", "getFilter", "()Ljava/lang/String;", "getIntercept", "()Z", "getParams", "()Ljava/util/Map;", "getStore", "getStrategy", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class CacheGroup {

    @SerializedName("api_ids")
    private final List<Integer> apiIds;

    @SerializedName("filter")
    private final String filter;

    @SerializedName("intercept")
    private final boolean intercept;

    @SerializedName("params")
    private final Map<String, String> params;

    @SerializedName("store")
    private final String store;

    @SerializedName("strategy")
    private final String strategy;

    public CacheGroup() {
        this(null, null, false, null, null, null, 63, null);
    }

    public static /* synthetic */ CacheGroup copy$default(CacheGroup cacheGroup, String str, String str2, boolean z, List list, Map map, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cacheGroup.store;
        }
        if ((i & 2) != 0) {
            str2 = cacheGroup.strategy;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            z = cacheGroup.intercept;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            list = cacheGroup.apiIds;
        }
        List list2 = list;
        if ((i & 16) != 0) {
            map = cacheGroup.params;
        }
        Map map2 = map;
        if ((i & 32) != 0) {
            str3 = cacheGroup.filter;
        }
        return cacheGroup.copy(str, str4, z2, list2, map2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getStore() {
        return this.store;
    }

    /* renamed from: component2, reason: from getter */
    public final String getStrategy() {
        return this.strategy;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIntercept() {
        return this.intercept;
    }

    public final List<Integer> component4() {
        return this.apiIds;
    }

    public final Map<String, String> component5() {
        return this.params;
    }

    /* renamed from: component6, reason: from getter */
    public final String getFilter() {
        return this.filter;
    }

    public final CacheGroup copy(String store, String strategy, boolean intercept, List<Integer> apiIds, Map<String, String> params, String filter) {
        Intrinsics.checkParameterIsNotNull(store, "store");
        Intrinsics.checkParameterIsNotNull(strategy, "strategy");
        Intrinsics.checkParameterIsNotNull(apiIds, "apiIds");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(filter, "filter");
        return new CacheGroup(store, strategy, intercept, apiIds, params, filter);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CacheGroup)) {
            return false;
        }
        CacheGroup cacheGroup = (CacheGroup) other;
        return Intrinsics.areEqual(this.store, cacheGroup.store) && Intrinsics.areEqual(this.strategy, cacheGroup.strategy) && this.intercept == cacheGroup.intercept && Intrinsics.areEqual(this.apiIds, cacheGroup.apiIds) && Intrinsics.areEqual(this.params, cacheGroup.params) && Intrinsics.areEqual(this.filter, cacheGroup.filter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.store;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.strategy;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.intercept;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode2 + i) * 31;
        List<Integer> list = this.apiIds;
        int hashCode3 = (i2 + (list != null ? list.hashCode() : 0)) * 31;
        Map<String, String> map = this.params;
        int hashCode4 = (hashCode3 + (map != null ? map.hashCode() : 0)) * 31;
        String str3 = this.filter;
        return hashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "CacheGroup(store=" + this.store + ", strategy=" + this.strategy + ", intercept=" + this.intercept + ", apiIds=" + this.apiIds + ", params=" + this.params + ", filter=" + this.filter + ")";
    }

    public CacheGroup(String str, String str2, boolean z, List<Integer> list, Map<String, String> map, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "store");
        Intrinsics.checkParameterIsNotNull(str2, "strategy");
        Intrinsics.checkParameterIsNotNull(list, "apiIds");
        Intrinsics.checkParameterIsNotNull(map, "params");
        Intrinsics.checkParameterIsNotNull(str3, "filter");
        this.store = str;
        this.strategy = str2;
        this.intercept = z;
        this.apiIds = list;
        this.params = map;
        this.filter = str3;
    }

    public final String getStore() {
        return this.store;
    }

    public final String getStrategy() {
        return this.strategy;
    }

    public final boolean getIntercept() {
        return this.intercept;
    }

    public /* synthetic */ CacheGroup(String str, String str2, boolean z, List list, Map map, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? VoiceAttemptMetricsTracker.FINAL_SOURCE_EMPTY : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? MapsKt.emptyMap() : map, (i & 32) == 0 ? str3 : "");
    }

    public final List<Integer> getApiIds() {
        return this.apiIds;
    }

    public final Map<String, String> getParams() {
        return this.params;
    }

    public final String getFilter() {
        return this.filter;
    }
}

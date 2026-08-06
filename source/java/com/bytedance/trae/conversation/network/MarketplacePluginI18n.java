package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\n\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/network/MarketplacePluginI18n;", "", "displayNames", "", "", "<init>", "(Ljava/util/Map;)V", "getDisplayNames", "()Ljava/util/Map;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MarketplacePluginI18n {

    @SerializedName("display_name")
    private final Map<String, String> displayNames;

    /* JADX WARN: Multi-variable type inference failed */
    public MarketplacePluginI18n() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MarketplacePluginI18n copy$default(MarketplacePluginI18n marketplacePluginI18n, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = marketplacePluginI18n.displayNames;
        }
        return marketplacePluginI18n.copy(map);
    }

    public final Map<String, String> component1() {
        return this.displayNames;
    }

    public final MarketplacePluginI18n copy(Map<String, String> displayNames) {
        return new MarketplacePluginI18n(displayNames);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MarketplacePluginI18n) && Intrinsics.areEqual(this.displayNames, ((MarketplacePluginI18n) other).displayNames);
    }

    public int hashCode() {
        Map<String, String> map = this.displayNames;
        if (map == null) {
            return 0;
        }
        return map.hashCode();
    }

    public String toString() {
        return "MarketplacePluginI18n(displayNames=" + this.displayNames + ')';
    }

    public MarketplacePluginI18n(Map<String, String> map) {
        this.displayNames = map;
    }

    public /* synthetic */ MarketplacePluginI18n(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map);
    }

    public final Map<String, String> getDisplayNames() {
        return this.displayNames;
    }
}

package com.bytedance.trae.conversation.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003JF\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\tHÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\r¨\u0006\""}, d2 = {"Lcom/bytedance/trae/conversation/network/ListPluginsData;", "", "items", "", "Lcom/bytedance/trae/conversation/network/PluginItem;", "plugins", "total", "", "nextPageToken", "", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;)V", "getItems", "()Ljava/util/List;", "getPlugins", "getTotal", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNextPageToken", "()Ljava/lang/String;", "allItems", "getAllItems", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;)Lcom/bytedance/trae/conversation/network/ListPluginsData;", "equals", "", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class ListPluginsData {

    @SerializedName("items")
    private final List<PluginItem> items;

    @SerializedName("next_page_token")
    private final String nextPageToken;

    @SerializedName("plugins")
    private final List<PluginItem> plugins;

    @SerializedName("total")
    private final Long total;

    public ListPluginsData() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ListPluginsData copy$default(ListPluginsData listPluginsData, List list, List list2, Long l, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = listPluginsData.items;
        }
        if ((i & 2) != 0) {
            list2 = listPluginsData.plugins;
        }
        if ((i & 4) != 0) {
            l = listPluginsData.total;
        }
        if ((i & 8) != 0) {
            str = listPluginsData.nextPageToken;
        }
        return listPluginsData.copy(list, list2, l, str);
    }

    public final List<PluginItem> component1() {
        return this.items;
    }

    public final List<PluginItem> component2() {
        return this.plugins;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getTotal() {
        return this.total;
    }

    /* renamed from: component4, reason: from getter */
    public final String getNextPageToken() {
        return this.nextPageToken;
    }

    public final ListPluginsData copy(List<PluginItem> items, List<PluginItem> plugins, Long total, String nextPageToken) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(plugins, "plugins");
        return new ListPluginsData(items, plugins, total, nextPageToken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListPluginsData)) {
            return false;
        }
        ListPluginsData listPluginsData = (ListPluginsData) other;
        return Intrinsics.areEqual(this.items, listPluginsData.items) && Intrinsics.areEqual(this.plugins, listPluginsData.plugins) && Intrinsics.areEqual(this.total, listPluginsData.total) && Intrinsics.areEqual(this.nextPageToken, listPluginsData.nextPageToken);
    }

    public int hashCode() {
        int hashCode = ((this.items.hashCode() * 31) + this.plugins.hashCode()) * 31;
        Long l = this.total;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.nextPageToken;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ListPluginsData(items=" + this.items + ", plugins=" + this.plugins + ", total=" + this.total + ", nextPageToken=" + this.nextPageToken + ')';
    }

    public ListPluginsData(List<PluginItem> list, List<PluginItem> list2, Long l, String str) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(list2, "plugins");
        this.items = list;
        this.plugins = list2;
        this.total = l;
        this.nextPageToken = str;
    }

    public /* synthetic */ ListPluginsData(List list, List list2, Long l, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str);
    }

    public final List<PluginItem> getItems() {
        return this.items;
    }

    public final List<PluginItem> getPlugins() {
        return this.plugins;
    }

    public final Long getTotal() {
        return this.total;
    }

    public final String getNextPageToken() {
        return this.nextPageToken;
    }

    public final List<PluginItem> getAllItems() {
        List<PluginItem> list = this.items;
        if (list.isEmpty()) {
            list = this.plugins;
        }
        return list;
    }
}

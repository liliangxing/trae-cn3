package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.android.gms.common.data.DataBufferUtils;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J6\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\bHÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/conversation/network/ListRepositoriesData;", "", "items", "", "Lcom/bytedance/trae/conversation/network/GitRepository;", "total", "", "nextPageToken", "", "<init>", "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;)V", "getItems", "()Ljava/util/List;", "getTotal", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNextPageToken", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;)Lcom/bytedance/trae/conversation/network/ListRepositoriesData;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ListRepositoriesData {

    @SerializedName("items")
    private final List<GitRepository> items;

    @SerializedName(DataBufferUtils.KEY_NEXT_PAGE_TOKEN)
    private final String nextPageToken;

    @SerializedName("total")
    private final Long total;

    public ListRepositoriesData() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ListRepositoriesData copy$default(ListRepositoriesData listRepositoriesData, List list, Long l, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = listRepositoriesData.items;
        }
        if ((i & 2) != 0) {
            l = listRepositoriesData.total;
        }
        if ((i & 4) != 0) {
            str = listRepositoriesData.nextPageToken;
        }
        return listRepositoriesData.copy(list, l, str);
    }

    public final List<GitRepository> component1() {
        return this.items;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getTotal() {
        return this.total;
    }

    /* renamed from: component3, reason: from getter */
    public final String getNextPageToken() {
        return this.nextPageToken;
    }

    public final ListRepositoriesData copy(List<GitRepository> items, Long total, String nextPageToken) {
        Intrinsics.checkNotNullParameter(items, "items");
        return new ListRepositoriesData(items, total, nextPageToken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListRepositoriesData)) {
            return false;
        }
        ListRepositoriesData listRepositoriesData = (ListRepositoriesData) other;
        return Intrinsics.areEqual(this.items, listRepositoriesData.items) && Intrinsics.areEqual(this.total, listRepositoriesData.total) && Intrinsics.areEqual(this.nextPageToken, listRepositoriesData.nextPageToken);
    }

    public int hashCode() {
        int hashCode = this.items.hashCode() * 31;
        Long l = this.total;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.nextPageToken;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ListRepositoriesData(items=" + this.items + ", total=" + this.total + ", nextPageToken=" + this.nextPageToken + ')';
    }

    public ListRepositoriesData(List<GitRepository> items, Long l, String str) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.items = items;
        this.total = l;
        this.nextPageToken = str;
    }

    public /* synthetic */ ListRepositoriesData(List list, Long l, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str);
    }

    public final List<GitRepository> getItems() {
        return this.items;
    }

    public final Long getTotal() {
        return this.total;
    }

    public final String getNextPageToken() {
        return this.nextPageToken;
    }
}

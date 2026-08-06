package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IListConversationsService.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/im/service/ListConversationsRequest;", "", "pageSize", "", "pageIndex", "orderBy", "", "sort", "<init>", "(IILjava/lang/String;Ljava/lang/String;)V", "getPageSize", "()I", "getPageIndex", "getOrderBy", "()Ljava/lang/String;", "getSort", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ListConversationsRequest {

    @SerializedName("order_by")
    private final String orderBy;

    @SerializedName("page_index")
    private final int pageIndex;

    @SerializedName("page_size")
    private final int pageSize;

    @SerializedName("sort")
    private final String sort;

    public ListConversationsRequest() {
        this(0, 0, null, null, 15, null);
    }

    public static /* synthetic */ ListConversationsRequest copy$default(ListConversationsRequest listConversationsRequest, int i, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = listConversationsRequest.pageSize;
        }
        if ((i3 & 2) != 0) {
            i2 = listConversationsRequest.pageIndex;
        }
        if ((i3 & 4) != 0) {
            str = listConversationsRequest.orderBy;
        }
        if ((i3 & 8) != 0) {
            str2 = listConversationsRequest.sort;
        }
        return listConversationsRequest.copy(i, i2, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPageIndex() {
        return this.pageIndex;
    }

    /* renamed from: component3, reason: from getter */
    public final String getOrderBy() {
        return this.orderBy;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSort() {
        return this.sort;
    }

    public final ListConversationsRequest copy(int pageSize, int pageIndex, String orderBy, String sort) {
        Intrinsics.checkNotNullParameter(orderBy, "orderBy");
        Intrinsics.checkNotNullParameter(sort, "sort");
        return new ListConversationsRequest(pageSize, pageIndex, orderBy, sort);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListConversationsRequest)) {
            return false;
        }
        ListConversationsRequest listConversationsRequest = (ListConversationsRequest) other;
        return this.pageSize == listConversationsRequest.pageSize && this.pageIndex == listConversationsRequest.pageIndex && Intrinsics.areEqual(this.orderBy, listConversationsRequest.orderBy) && Intrinsics.areEqual(this.sort, listConversationsRequest.sort);
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.pageSize) * 31) + Integer.hashCode(this.pageIndex)) * 31) + this.orderBy.hashCode()) * 31) + this.sort.hashCode();
    }

    public String toString() {
        return "ListConversationsRequest(pageSize=" + this.pageSize + ", pageIndex=" + this.pageIndex + ", orderBy=" + this.orderBy + ", sort=" + this.sort + ')';
    }

    public ListConversationsRequest(int i, int i2, String orderBy, String sort) {
        Intrinsics.checkNotNullParameter(orderBy, "orderBy");
        Intrinsics.checkNotNullParameter(sort, "sort");
        this.pageSize = i;
        this.pageIndex = i2;
        this.orderBy = orderBy;
        this.sort = sort;
    }

    public /* synthetic */ ListConversationsRequest(int i, int i2, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 300 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? "updated_at" : str, (i3 & 8) != 0 ? "desc" : str2);
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final int getPageIndex() {
        return this.pageIndex;
    }

    public final String getOrderBy() {
        return this.orderBy;
    }

    public final String getSort() {
        return this.sort;
    }
}

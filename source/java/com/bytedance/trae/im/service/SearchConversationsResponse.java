package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IListConversationsService.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011JV\u0010\u001a\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011¨\u0006!"}, d2 = {"Lcom/bytedance/trae/im/service/SearchConversationsResponse;", "", "highlightKeywords", "", "", "items", "Lcom/bytedance/trae/im/service/SearchConversationItem;", "total", "", "pageSize", "pageIndex", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHighlightKeywords", "()Ljava/util/List;", "getItems", "getTotal", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPageSize", "getPageIndex", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/trae/im/service/SearchConversationsResponse;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SearchConversationsResponse {

    @SerializedName("highlight_keywords")
    private final List<String> highlightKeywords;

    @SerializedName("items")
    private final List<SearchConversationItem> items;

    @SerializedName("page_index")
    private final Integer pageIndex;

    @SerializedName("page_size")
    private final Integer pageSize;

    @SerializedName("total")
    private final Integer total;

    public SearchConversationsResponse() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ SearchConversationsResponse copy$default(SearchConversationsResponse searchConversationsResponse, List list, List list2, Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = searchConversationsResponse.highlightKeywords;
        }
        if ((i & 2) != 0) {
            list2 = searchConversationsResponse.items;
        }
        List list3 = list2;
        if ((i & 4) != 0) {
            num = searchConversationsResponse.total;
        }
        Integer num4 = num;
        if ((i & 8) != 0) {
            num2 = searchConversationsResponse.pageSize;
        }
        Integer num5 = num2;
        if ((i & 16) != 0) {
            num3 = searchConversationsResponse.pageIndex;
        }
        return searchConversationsResponse.copy(list, list3, num4, num5, num3);
    }

    public final List<String> component1() {
        return this.highlightKeywords;
    }

    public final List<SearchConversationItem> component2() {
        return this.items;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getTotal() {
        return this.total;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getPageSize() {
        return this.pageSize;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getPageIndex() {
        return this.pageIndex;
    }

    public final SearchConversationsResponse copy(List<String> highlightKeywords, List<SearchConversationItem> items, Integer total, Integer pageSize, Integer pageIndex) {
        return new SearchConversationsResponse(highlightKeywords, items, total, pageSize, pageIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchConversationsResponse)) {
            return false;
        }
        SearchConversationsResponse searchConversationsResponse = (SearchConversationsResponse) other;
        return Intrinsics.areEqual(this.highlightKeywords, searchConversationsResponse.highlightKeywords) && Intrinsics.areEqual(this.items, searchConversationsResponse.items) && Intrinsics.areEqual(this.total, searchConversationsResponse.total) && Intrinsics.areEqual(this.pageSize, searchConversationsResponse.pageSize) && Intrinsics.areEqual(this.pageIndex, searchConversationsResponse.pageIndex);
    }

    public int hashCode() {
        List<String> list = this.highlightKeywords;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<SearchConversationItem> list2 = this.items;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        Integer num = this.total;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.pageSize;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.pageIndex;
        return hashCode4 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        return "SearchConversationsResponse(highlightKeywords=" + this.highlightKeywords + ", items=" + this.items + ", total=" + this.total + ", pageSize=" + this.pageSize + ", pageIndex=" + this.pageIndex + ')';
    }

    public SearchConversationsResponse(List<String> list, List<SearchConversationItem> list2, Integer num, Integer num2, Integer num3) {
        this.highlightKeywords = list;
        this.items = list2;
        this.total = num;
        this.pageSize = num2;
        this.pageIndex = num3;
    }

    public /* synthetic */ SearchConversationsResponse(List list, List list2, Integer num, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : num3);
    }

    public final List<String> getHighlightKeywords() {
        return this.highlightKeywords;
    }

    public final List<SearchConversationItem> getItems() {
        return this.items;
    }

    public final Integer getTotal() {
        return this.total;
    }

    public final Integer getPageSize() {
        return this.pageSize;
    }

    public final Integer getPageIndex() {
        return this.pageIndex;
    }
}

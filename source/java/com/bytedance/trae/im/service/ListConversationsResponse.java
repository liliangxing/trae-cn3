package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.google.android.gms.common.data.DataBufferUtils;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IListConversationsService.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003JP\u0010\u001b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\nHÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/bytedance/trae/im/service/ListConversationsResponse;", "", "conversations", "", "Lcom/bytedance/trae/im/service/Conversation;", "total", "", "pageSize", "pageIndex", "nextPageToken", "", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getConversations", "()Ljava/util/List;", "getTotal", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPageSize", "getPageIndex", "getNextPageToken", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/trae/im/service/ListConversationsResponse;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ListConversationsResponse {

    @SerializedName(alternate = {"conversations"}, value = "items")
    private final List<Conversation> conversations;

    @SerializedName(DataBufferUtils.KEY_NEXT_PAGE_TOKEN)
    private final String nextPageToken;

    @SerializedName("page_index")
    private final Integer pageIndex;

    @SerializedName("page_size")
    private final Integer pageSize;

    @SerializedName("total")
    private final Integer total;

    public ListConversationsResponse() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ListConversationsResponse copy$default(ListConversationsResponse listConversationsResponse, List list, Integer num, Integer num2, Integer num3, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = listConversationsResponse.conversations;
        }
        if ((i & 2) != 0) {
            num = listConversationsResponse.total;
        }
        Integer num4 = num;
        if ((i & 4) != 0) {
            num2 = listConversationsResponse.pageSize;
        }
        Integer num5 = num2;
        if ((i & 8) != 0) {
            num3 = listConversationsResponse.pageIndex;
        }
        Integer num6 = num3;
        if ((i & 16) != 0) {
            str = listConversationsResponse.nextPageToken;
        }
        return listConversationsResponse.copy(list, num4, num5, num6, str);
    }

    public final List<Conversation> component1() {
        return this.conversations;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getTotal() {
        return this.total;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getPageSize() {
        return this.pageSize;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getPageIndex() {
        return this.pageIndex;
    }

    /* renamed from: component5, reason: from getter */
    public final String getNextPageToken() {
        return this.nextPageToken;
    }

    public final ListConversationsResponse copy(List<Conversation> conversations, Integer total, Integer pageSize, Integer pageIndex, String nextPageToken) {
        return new ListConversationsResponse(conversations, total, pageSize, pageIndex, nextPageToken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListConversationsResponse)) {
            return false;
        }
        ListConversationsResponse listConversationsResponse = (ListConversationsResponse) other;
        return Intrinsics.areEqual(this.conversations, listConversationsResponse.conversations) && Intrinsics.areEqual(this.total, listConversationsResponse.total) && Intrinsics.areEqual(this.pageSize, listConversationsResponse.pageSize) && Intrinsics.areEqual(this.pageIndex, listConversationsResponse.pageIndex) && Intrinsics.areEqual(this.nextPageToken, listConversationsResponse.nextPageToken);
    }

    public int hashCode() {
        List<Conversation> list = this.conversations;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Integer num = this.total;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.pageSize;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.pageIndex;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str = this.nextPageToken;
        return hashCode4 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ListConversationsResponse(conversations=" + this.conversations + ", total=" + this.total + ", pageSize=" + this.pageSize + ", pageIndex=" + this.pageIndex + ", nextPageToken=" + this.nextPageToken + ')';
    }

    public ListConversationsResponse(List<Conversation> list, Integer num, Integer num2, Integer num3, String str) {
        this.conversations = list;
        this.total = num;
        this.pageSize = num2;
        this.pageIndex = num3;
        this.nextPageToken = str;
    }

    public /* synthetic */ ListConversationsResponse(List list, Integer num, Integer num2, Integer num3, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : str);
    }

    public final List<Conversation> getConversations() {
        return this.conversations;
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

    public final String getNextPageToken() {
        return this.nextPageToken;
    }
}

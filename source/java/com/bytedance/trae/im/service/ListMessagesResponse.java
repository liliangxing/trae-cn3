package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.im.model.ChatMessage;
import com.google.android.gms.common.data.DataBufferUtils;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IListMessagesService.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J8\u0010\u0015\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/im/service/ListMessagesResponse;", "", "messages", "", "Lcom/bytedance/trae/im/model/ChatMessage;", "nextPageToken", "", "total", "", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;)V", "getMessages", "()Ljava/util/List;", "getNextPageToken", "()Ljava/lang/String;", "getTotal", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/trae/im/service/ListMessagesResponse;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ListMessagesResponse {

    @SerializedName(alternate = {"messages"}, value = "items")
    private final List<ChatMessage> messages;

    @SerializedName(DataBufferUtils.KEY_NEXT_PAGE_TOKEN)
    private final String nextPageToken;

    @SerializedName("total")
    private final Integer total;

    public ListMessagesResponse() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ListMessagesResponse copy$default(ListMessagesResponse listMessagesResponse, List list, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            list = listMessagesResponse.messages;
        }
        if ((i & 2) != 0) {
            str = listMessagesResponse.nextPageToken;
        }
        if ((i & 4) != 0) {
            num = listMessagesResponse.total;
        }
        return listMessagesResponse.copy(list, str, num);
    }

    public final List<ChatMessage> component1() {
        return this.messages;
    }

    /* renamed from: component2, reason: from getter */
    public final String getNextPageToken() {
        return this.nextPageToken;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getTotal() {
        return this.total;
    }

    public final ListMessagesResponse copy(List<ChatMessage> messages, String nextPageToken, Integer total) {
        return new ListMessagesResponse(messages, nextPageToken, total);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListMessagesResponse)) {
            return false;
        }
        ListMessagesResponse listMessagesResponse = (ListMessagesResponse) other;
        return Intrinsics.areEqual(this.messages, listMessagesResponse.messages) && Intrinsics.areEqual(this.nextPageToken, listMessagesResponse.nextPageToken) && Intrinsics.areEqual(this.total, listMessagesResponse.total);
    }

    public int hashCode() {
        List<ChatMessage> list = this.messages;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.nextPageToken;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.total;
        return hashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ListMessagesResponse(messages=" + this.messages + ", nextPageToken=" + this.nextPageToken + ", total=" + this.total + ')';
    }

    public ListMessagesResponse(List<ChatMessage> list, String str, Integer num) {
        this.messages = list;
        this.nextPageToken = str;
        this.total = num;
    }

    public /* synthetic */ ListMessagesResponse(List list, String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num);
    }

    public final List<ChatMessage> getMessages() {
        return this.messages;
    }

    public final String getNextPageToken() {
        return this.nextPageToken;
    }

    public final Integer getTotal() {
        return this.total;
    }
}

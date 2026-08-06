package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/network/ListBranchesResponse;", "", "code", "", "message", "", "data", "Lcom/bytedance/trae/conversation/network/ListBranchesData;", "<init>", "(ILjava/lang/String;Lcom/bytedance/trae/conversation/network/ListBranchesData;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getData", "()Lcom/bytedance/trae/conversation/network/ListBranchesData;", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ListBranchesResponse {

    @SerializedName("code")
    private final int code;

    @SerializedName("data")
    private final ListBranchesData data;

    @SerializedName("message")
    private final String message;

    public static /* synthetic */ ListBranchesResponse copy$default(ListBranchesResponse listBranchesResponse, int i, String str, ListBranchesData listBranchesData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = listBranchesResponse.code;
        }
        if ((i2 & 2) != 0) {
            str = listBranchesResponse.message;
        }
        if ((i2 & 4) != 0) {
            listBranchesData = listBranchesResponse.data;
        }
        return listBranchesResponse.copy(i, str, listBranchesData);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final ListBranchesData getData() {
        return this.data;
    }

    public final ListBranchesResponse copy(int code, String message, ListBranchesData data) {
        return new ListBranchesResponse(code, message, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListBranchesResponse)) {
            return false;
        }
        ListBranchesResponse listBranchesResponse = (ListBranchesResponse) other;
        return this.code == listBranchesResponse.code && Intrinsics.areEqual(this.message, listBranchesResponse.message) && Intrinsics.areEqual(this.data, listBranchesResponse.data);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.code) * 31;
        String str = this.message;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        ListBranchesData listBranchesData = this.data;
        return hashCode2 + (listBranchesData != null ? listBranchesData.hashCode() : 0);
    }

    public String toString() {
        return "ListBranchesResponse(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ')';
    }

    public ListBranchesResponse(int i, String str, ListBranchesData listBranchesData) {
        this.code = i;
        this.message = str;
        this.data = listBranchesData;
    }

    public /* synthetic */ ListBranchesResponse(int i, String str, ListBranchesData listBranchesData, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : listBranchesData);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final ListBranchesData getData() {
        return this.data;
    }
}

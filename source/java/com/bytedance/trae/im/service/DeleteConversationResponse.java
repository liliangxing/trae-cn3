package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.push.api.PushConst;
import com.google.gson.annotations.SerializedName;
import com.ss.android.download.api.constant.Downloads;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IDeleteConversationService.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/im/service/DeleteConversationResponse;", "", "conversationId", "", Downloads.Impl.COLUMN_DELETED, "", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getConversationId", "()Ljava/lang/String;", "getDeleted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/bytedance/trae/im/service/DeleteConversationResponse;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DeleteConversationResponse {

    @SerializedName(PushConst.PUSH_KEY_CONVERSATION_ID)
    private final String conversationId;

    @SerializedName(Downloads.Impl.COLUMN_DELETED)
    private final Boolean deleted;

    /* JADX WARN: Multi-variable type inference failed */
    public DeleteConversationResponse() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ DeleteConversationResponse copy$default(DeleteConversationResponse deleteConversationResponse, String str, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deleteConversationResponse.conversationId;
        }
        if ((i & 2) != 0) {
            bool = deleteConversationResponse.deleted;
        }
        return deleteConversationResponse.copy(str, bool);
    }

    /* renamed from: component1, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getDeleted() {
        return this.deleted;
    }

    public final DeleteConversationResponse copy(String conversationId, Boolean deleted) {
        return new DeleteConversationResponse(conversationId, deleted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeleteConversationResponse)) {
            return false;
        }
        DeleteConversationResponse deleteConversationResponse = (DeleteConversationResponse) other;
        return Intrinsics.areEqual(this.conversationId, deleteConversationResponse.conversationId) && Intrinsics.areEqual(this.deleted, deleteConversationResponse.deleted);
    }

    public int hashCode() {
        String str = this.conversationId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.deleted;
        return hashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "DeleteConversationResponse(conversationId=" + this.conversationId + ", deleted=" + this.deleted + ')';
    }

    public DeleteConversationResponse(String str, Boolean bool) {
        this.conversationId = str;
        this.deleted = bool;
    }

    public /* synthetic */ DeleteConversationResponse(String str, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool);
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final Boolean getDeleted() {
        return this.deleted;
    }
}

package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPinConversationService.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0002\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/im/service/PinConversationResponse;", "", "isPinned", "", "pinnedAt", "", "conversation", "Lcom/bytedance/trae/im/service/Conversation;", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Lcom/bytedance/trae/im/service/Conversation;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPinnedAt", "()Ljava/lang/String;", "getConversation", "()Lcom/bytedance/trae/im/service/Conversation;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Lcom/bytedance/trae/im/service/Conversation;)Lcom/bytedance/trae/im/service/PinConversationResponse;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PinConversationResponse {

    @SerializedName("conversation")
    private final Conversation conversation;

    @SerializedName("is_pinned")
    private final Boolean isPinned;

    @SerializedName("pinned_at")
    private final String pinnedAt;

    public PinConversationResponse() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PinConversationResponse copy$default(PinConversationResponse pinConversationResponse, Boolean bool, String str, Conversation conversation, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = pinConversationResponse.isPinned;
        }
        if ((i & 2) != 0) {
            str = pinConversationResponse.pinnedAt;
        }
        if ((i & 4) != 0) {
            conversation = pinConversationResponse.conversation;
        }
        return pinConversationResponse.copy(bool, str, conversation);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getIsPinned() {
        return this.isPinned;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPinnedAt() {
        return this.pinnedAt;
    }

    /* renamed from: component3, reason: from getter */
    public final Conversation getConversation() {
        return this.conversation;
    }

    public final PinConversationResponse copy(Boolean isPinned, String pinnedAt, Conversation conversation) {
        return new PinConversationResponse(isPinned, pinnedAt, conversation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PinConversationResponse)) {
            return false;
        }
        PinConversationResponse pinConversationResponse = (PinConversationResponse) other;
        return Intrinsics.areEqual(this.isPinned, pinConversationResponse.isPinned) && Intrinsics.areEqual(this.pinnedAt, pinConversationResponse.pinnedAt) && Intrinsics.areEqual(this.conversation, pinConversationResponse.conversation);
    }

    public int hashCode() {
        Boolean bool = this.isPinned;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.pinnedAt;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Conversation conversation = this.conversation;
        return hashCode2 + (conversation != null ? conversation.hashCode() : 0);
    }

    public String toString() {
        return "PinConversationResponse(isPinned=" + this.isPinned + ", pinnedAt=" + this.pinnedAt + ", conversation=" + this.conversation + ')';
    }

    public PinConversationResponse(Boolean bool, String str, Conversation conversation) {
        this.isPinned = bool;
        this.pinnedAt = str;
        this.conversation = conversation;
    }

    public /* synthetic */ PinConversationResponse(Boolean bool, String str, Conversation conversation, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : conversation);
    }

    public final Boolean isPinned() {
        return this.isPinned;
    }

    public final String getPinnedAt() {
        return this.pinnedAt;
    }

    public final Conversation getConversation() {
        return this.conversation;
    }
}

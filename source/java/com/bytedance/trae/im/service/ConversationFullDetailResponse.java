package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IGetConversationFullDetailService.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/im/service/ConversationFullDetailResponse;", "", "conversation", "Lcom/bytedance/trae/im/service/Conversation;", "cliAvailable", "", "cliProductType", "", "<init>", "(Lcom/bytedance/trae/im/service/Conversation;Ljava/lang/Boolean;Ljava/lang/String;)V", "getConversation", "()Lcom/bytedance/trae/im/service/Conversation;", "getCliAvailable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCliProductType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Lcom/bytedance/trae/im/service/Conversation;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/trae/im/service/ConversationFullDetailResponse;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConversationFullDetailResponse {

    @SerializedName("cli_available")
    private final Boolean cliAvailable;

    @SerializedName("cli_product_type")
    private final String cliProductType;

    @SerializedName("conversation")
    private final Conversation conversation;

    public ConversationFullDetailResponse() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ConversationFullDetailResponse copy$default(ConversationFullDetailResponse conversationFullDetailResponse, Conversation conversation, Boolean bool, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            conversation = conversationFullDetailResponse.conversation;
        }
        if ((i & 2) != 0) {
            bool = conversationFullDetailResponse.cliAvailable;
        }
        if ((i & 4) != 0) {
            str = conversationFullDetailResponse.cliProductType;
        }
        return conversationFullDetailResponse.copy(conversation, bool, str);
    }

    /* renamed from: component1, reason: from getter */
    public final Conversation getConversation() {
        return this.conversation;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getCliAvailable() {
        return this.cliAvailable;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCliProductType() {
        return this.cliProductType;
    }

    public final ConversationFullDetailResponse copy(Conversation conversation, Boolean cliAvailable, String cliProductType) {
        return new ConversationFullDetailResponse(conversation, cliAvailable, cliProductType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationFullDetailResponse)) {
            return false;
        }
        ConversationFullDetailResponse conversationFullDetailResponse = (ConversationFullDetailResponse) other;
        return Intrinsics.areEqual(this.conversation, conversationFullDetailResponse.conversation) && Intrinsics.areEqual(this.cliAvailable, conversationFullDetailResponse.cliAvailable) && Intrinsics.areEqual(this.cliProductType, conversationFullDetailResponse.cliProductType);
    }

    public int hashCode() {
        Conversation conversation = this.conversation;
        int hashCode = (conversation == null ? 0 : conversation.hashCode()) * 31;
        Boolean bool = this.cliAvailable;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.cliProductType;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ConversationFullDetailResponse(conversation=" + this.conversation + ", cliAvailable=" + this.cliAvailable + ", cliProductType=" + this.cliProductType + ')';
    }

    public ConversationFullDetailResponse(Conversation conversation, Boolean bool, String str) {
        this.conversation = conversation;
        this.cliAvailable = bool;
        this.cliProductType = str;
    }

    public /* synthetic */ ConversationFullDetailResponse(Conversation conversation, Boolean bool, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : conversation, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : str);
    }

    public final Conversation getConversation() {
        return this.conversation;
    }

    public final Boolean getCliAvailable() {
        return this.cliAvailable;
    }

    public final String getCliProductType() {
        return this.cliProductType;
    }
}

package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.push.helper.MultiProcessPushMessageDatabaseHelper;
import com.bytedance.trae.push.api.PushConst;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IListConversationsService.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0081\u0001\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006+"}, d2 = {"Lcom/bytedance/trae/im/service/SearchConversationItem;", "", "cliId", "", "conversationId", "conversationTitle", "conversationUpdatedAt", "messageId", "messageRole", "replyToMessageId", "messageContent", "messageCreatedAt", "messageCreatedAtMs", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCliId", "()Ljava/lang/String;", "getConversationId", "getConversationTitle", "getConversationUpdatedAt", "getMessageId", "getMessageRole", "getReplyToMessageId", "getMessageContent", "getMessageCreatedAt", "getMessageCreatedAtMs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SearchConversationItem {

    @SerializedName("cli_id")
    private final String cliId;

    @SerializedName(PushConst.PUSH_KEY_CONVERSATION_ID)
    private final String conversationId;

    @SerializedName("conversation_title")
    private final String conversationTitle;

    @SerializedName("conversation_updated_at")
    private final String conversationUpdatedAt;

    @SerializedName("message_content")
    private final String messageContent;

    @SerializedName("message_created_at")
    private final String messageCreatedAt;

    @SerializedName("message_created_at_ms")
    private final String messageCreatedAtMs;

    @SerializedName(MultiProcessPushMessageDatabaseHelper.COL_MESSAGE_ID)
    private final String messageId;

    @SerializedName("message_role")
    private final String messageRole;

    @SerializedName("reply_to_message_id")
    private final String replyToMessageId;

    public SearchConversationItem() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCliId() {
        return this.cliId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getMessageCreatedAtMs() {
        return this.messageCreatedAtMs;
    }

    /* renamed from: component2, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getConversationTitle() {
        return this.conversationTitle;
    }

    /* renamed from: component4, reason: from getter */
    public final String getConversationUpdatedAt() {
        return this.conversationUpdatedAt;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getMessageRole() {
        return this.messageRole;
    }

    /* renamed from: component7, reason: from getter */
    public final String getReplyToMessageId() {
        return this.replyToMessageId;
    }

    /* renamed from: component8, reason: from getter */
    public final String getMessageContent() {
        return this.messageContent;
    }

    /* renamed from: component9, reason: from getter */
    public final String getMessageCreatedAt() {
        return this.messageCreatedAt;
    }

    public final SearchConversationItem copy(String cliId, String conversationId, String conversationTitle, String conversationUpdatedAt, String messageId, String messageRole, String replyToMessageId, String messageContent, String messageCreatedAt, String messageCreatedAtMs) {
        return new SearchConversationItem(cliId, conversationId, conversationTitle, conversationUpdatedAt, messageId, messageRole, replyToMessageId, messageContent, messageCreatedAt, messageCreatedAtMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchConversationItem)) {
            return false;
        }
        SearchConversationItem searchConversationItem = (SearchConversationItem) other;
        return Intrinsics.areEqual(this.cliId, searchConversationItem.cliId) && Intrinsics.areEqual(this.conversationId, searchConversationItem.conversationId) && Intrinsics.areEqual(this.conversationTitle, searchConversationItem.conversationTitle) && Intrinsics.areEqual(this.conversationUpdatedAt, searchConversationItem.conversationUpdatedAt) && Intrinsics.areEqual(this.messageId, searchConversationItem.messageId) && Intrinsics.areEqual(this.messageRole, searchConversationItem.messageRole) && Intrinsics.areEqual(this.replyToMessageId, searchConversationItem.replyToMessageId) && Intrinsics.areEqual(this.messageContent, searchConversationItem.messageContent) && Intrinsics.areEqual(this.messageCreatedAt, searchConversationItem.messageCreatedAt) && Intrinsics.areEqual(this.messageCreatedAtMs, searchConversationItem.messageCreatedAtMs);
    }

    public int hashCode() {
        String str = this.cliId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.conversationId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.conversationTitle;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.conversationUpdatedAt;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.messageId;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.messageRole;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.replyToMessageId;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.messageContent;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.messageCreatedAt;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.messageCreatedAtMs;
        return hashCode9 + (str10 != null ? str10.hashCode() : 0);
    }

    public String toString() {
        return "SearchConversationItem(cliId=" + this.cliId + ", conversationId=" + this.conversationId + ", conversationTitle=" + this.conversationTitle + ", conversationUpdatedAt=" + this.conversationUpdatedAt + ", messageId=" + this.messageId + ", messageRole=" + this.messageRole + ", replyToMessageId=" + this.replyToMessageId + ", messageContent=" + this.messageContent + ", messageCreatedAt=" + this.messageCreatedAt + ", messageCreatedAtMs=" + this.messageCreatedAtMs + ')';
    }

    public SearchConversationItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.cliId = str;
        this.conversationId = str2;
        this.conversationTitle = str3;
        this.conversationUpdatedAt = str4;
        this.messageId = str5;
        this.messageRole = str6;
        this.replyToMessageId = str7;
        this.messageContent = str8;
        this.messageCreatedAt = str9;
        this.messageCreatedAtMs = str10;
    }

    public /* synthetic */ SearchConversationItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) == 0 ? str10 : null);
    }

    public final String getCliId() {
        return this.cliId;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getConversationTitle() {
        return this.conversationTitle;
    }

    public final String getConversationUpdatedAt() {
        return this.conversationUpdatedAt;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getMessageRole() {
        return this.messageRole;
    }

    public final String getReplyToMessageId() {
        return this.replyToMessageId;
    }

    public final String getMessageContent() {
        return this.messageContent;
    }

    public final String getMessageCreatedAt() {
        return this.messageCreatedAt;
    }

    public final String getMessageCreatedAtMs() {
        return this.messageCreatedAtMs;
    }
}

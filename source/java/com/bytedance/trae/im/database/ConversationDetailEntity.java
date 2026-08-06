package com.bytedance.trae.im.database;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.cms.CMSAttributeTableGenerator;

/* compiled from: ConversationDetailEntity.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003J\t\u0010$\u001a\u00020\fHÆ\u0003Je\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001a¨\u0006+"}, d2 = {"Lcom/bytedance/trae/im/database/ConversationDetailEntity;", "", "conversationId", "", "messageId", "messageIndex", "", "role", CMSAttributeTableGenerator.CONTENT_TYPE, "content", "status", "createdAt", "", "updatedAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getConversationId", "()Ljava/lang/String;", "getMessageId", "getMessageIndex", "()I", "getRole", "getContentType", "getContent", "getStatus", "getCreatedAt", "()J", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConversationDetailEntity {
    private final String content;
    private final String contentType;
    private final String conversationId;
    private final long createdAt;
    private final String messageId;
    private final int messageIndex;
    private final String role;
    private final String status;
    private final long updatedAt;

    /* renamed from: component1, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getMessageIndex() {
        return this.messageIndex;
    }

    /* renamed from: component4, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    /* renamed from: component5, reason: from getter */
    public final String getContentType() {
        return this.contentType;
    }

    /* renamed from: component6, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component7, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component8, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component9, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public final ConversationDetailEntity copy(String conversationId, String messageId, int messageIndex, String role, String contentType, String content, String status, long createdAt, long updatedAt) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(content, "content");
        return new ConversationDetailEntity(conversationId, messageId, messageIndex, role, contentType, content, status, createdAt, updatedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationDetailEntity)) {
            return false;
        }
        ConversationDetailEntity conversationDetailEntity = (ConversationDetailEntity) other;
        return Intrinsics.areEqual(this.conversationId, conversationDetailEntity.conversationId) && Intrinsics.areEqual(this.messageId, conversationDetailEntity.messageId) && this.messageIndex == conversationDetailEntity.messageIndex && Intrinsics.areEqual(this.role, conversationDetailEntity.role) && Intrinsics.areEqual(this.contentType, conversationDetailEntity.contentType) && Intrinsics.areEqual(this.content, conversationDetailEntity.content) && Intrinsics.areEqual(this.status, conversationDetailEntity.status) && this.createdAt == conversationDetailEntity.createdAt && this.updatedAt == conversationDetailEntity.updatedAt;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.conversationId.hashCode() * 31) + this.messageId.hashCode()) * 31) + Integer.hashCode(this.messageIndex)) * 31) + this.role.hashCode()) * 31) + this.contentType.hashCode()) * 31) + this.content.hashCode()) * 31;
        String str = this.status;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.createdAt)) * 31) + Long.hashCode(this.updatedAt);
    }

    public String toString() {
        return "ConversationDetailEntity(conversationId=" + this.conversationId + ", messageId=" + this.messageId + ", messageIndex=" + this.messageIndex + ", role=" + this.role + ", contentType=" + this.contentType + ", content=" + this.content + ", status=" + this.status + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ')';
    }

    public ConversationDetailEntity(String conversationId, String messageId, int i, String role, String contentType, String content, String str, long j, long j2) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(content, "content");
        this.conversationId = conversationId;
        this.messageId = messageId;
        this.messageIndex = i;
        this.role = role;
        this.contentType = contentType;
        this.content = content;
        this.status = str;
        this.createdAt = j;
        this.updatedAt = j2;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final int getMessageIndex() {
        return this.messageIndex;
    }

    public final String getRole() {
        return this.role;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getStatus() {
        return this.status;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }
}

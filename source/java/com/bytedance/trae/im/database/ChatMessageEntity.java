package com.bytedance.trae.im.database;

import com.bytedance.forest.model.PreloadConfig;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMessageDao.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003Jc\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\tHÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006+"}, d2 = {"Lcom/bytedance/trae/im/database/ChatMessageEntity;", "", "id", "", DBDefinition.TASK_ID, "", "messageId", "messageType", "messageIndex", "", "content", "status", "createdAt", "updatedAt", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IJJ)V", "getId", "()J", "getTaskId", "()Ljava/lang/String;", "getMessageId", "getMessageType", "getMessageIndex", "()I", "getContent", "getStatus", "getCreatedAt", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ChatMessageEntity {
    private final String content;
    private final long createdAt;
    private final long id;
    private final String messageId;
    private final int messageIndex;
    private final String messageType;
    private final int status;
    private final String taskId;
    private final long updatedAt;

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMessageType() {
        return this.messageType;
    }

    /* renamed from: component5, reason: from getter */
    public final int getMessageIndex() {
        return this.messageIndex;
    }

    /* renamed from: component6, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component7, reason: from getter */
    public final int getStatus() {
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

    public final ChatMessageEntity copy(long id, String taskId, String messageId, String messageType, int messageIndex, String content, int status, long createdAt, long updatedAt) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        Intrinsics.checkNotNullParameter(content, "content");
        return new ChatMessageEntity(id, taskId, messageId, messageType, messageIndex, content, status, createdAt, updatedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatMessageEntity)) {
            return false;
        }
        ChatMessageEntity chatMessageEntity = (ChatMessageEntity) other;
        return this.id == chatMessageEntity.id && Intrinsics.areEqual(this.taskId, chatMessageEntity.taskId) && Intrinsics.areEqual(this.messageId, chatMessageEntity.messageId) && Intrinsics.areEqual(this.messageType, chatMessageEntity.messageType) && this.messageIndex == chatMessageEntity.messageIndex && Intrinsics.areEqual(this.content, chatMessageEntity.content) && this.status == chatMessageEntity.status && this.createdAt == chatMessageEntity.createdAt && this.updatedAt == chatMessageEntity.updatedAt;
    }

    public int hashCode() {
        return (((((((((((((((Long.hashCode(this.id) * 31) + this.taskId.hashCode()) * 31) + this.messageId.hashCode()) * 31) + this.messageType.hashCode()) * 31) + Integer.hashCode(this.messageIndex)) * 31) + this.content.hashCode()) * 31) + Integer.hashCode(this.status)) * 31) + Long.hashCode(this.createdAt)) * 31) + Long.hashCode(this.updatedAt);
    }

    public String toString() {
        return "ChatMessageEntity(id=" + this.id + ", taskId=" + this.taskId + ", messageId=" + this.messageId + ", messageType=" + this.messageType + ", messageIndex=" + this.messageIndex + ", content=" + this.content + ", status=" + this.status + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ')';
    }

    public ChatMessageEntity(long j, String taskId, String messageId, String messageType, int i, String content, int i2, long j2, long j3) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        Intrinsics.checkNotNullParameter(content, "content");
        this.id = j;
        this.taskId = taskId;
        this.messageId = messageId;
        this.messageType = messageType;
        this.messageIndex = i;
        this.content = content;
        this.status = i2;
        this.createdAt = j2;
        this.updatedAt = j3;
    }

    public final long getId() {
        return this.id;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getMessageType() {
        return this.messageType;
    }

    public final int getMessageIndex() {
        return this.messageIndex;
    }

    public final String getContent() {
        return this.content;
    }

    public final int getStatus() {
        return this.status;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }
}

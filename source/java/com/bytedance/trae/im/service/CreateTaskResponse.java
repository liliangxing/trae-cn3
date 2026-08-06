package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.push.helper.MultiProcessPushMessageDatabaseHelper;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICreateAgentTask.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/im/service/CreateTaskResponse;", "", DBDefinition.TASK_ID, "", "messageId", "task", "Lcom/bytedance/trae/im/service/ConversationInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/service/ConversationInfo;)V", "getTaskId", "()Ljava/lang/String;", "getMessageId", "getTask", "()Lcom/bytedance/trae/im/service/ConversationInfo;", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CreateTaskResponse {

    @SerializedName(MultiProcessPushMessageDatabaseHelper.COL_MESSAGE_ID)
    private final String messageId;

    @SerializedName("conversation")
    private final ConversationInfo task;

    @SerializedName(NewTaskTracker.Param.TASK_ID)
    private final String taskId;

    public CreateTaskResponse() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CreateTaskResponse copy$default(CreateTaskResponse createTaskResponse, String str, String str2, ConversationInfo conversationInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createTaskResponse.taskId;
        }
        if ((i & 2) != 0) {
            str2 = createTaskResponse.messageId;
        }
        if ((i & 4) != 0) {
            conversationInfo = createTaskResponse.task;
        }
        return createTaskResponse.copy(str, str2, conversationInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: component3, reason: from getter */
    public final ConversationInfo getTask() {
        return this.task;
    }

    public final CreateTaskResponse copy(String taskId, String messageId, ConversationInfo task) {
        return new CreateTaskResponse(taskId, messageId, task);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateTaskResponse)) {
            return false;
        }
        CreateTaskResponse createTaskResponse = (CreateTaskResponse) other;
        return Intrinsics.areEqual(this.taskId, createTaskResponse.taskId) && Intrinsics.areEqual(this.messageId, createTaskResponse.messageId) && Intrinsics.areEqual(this.task, createTaskResponse.task);
    }

    public int hashCode() {
        String str = this.taskId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.messageId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ConversationInfo conversationInfo = this.task;
        return hashCode2 + (conversationInfo != null ? conversationInfo.hashCode() : 0);
    }

    public String toString() {
        return "CreateTaskResponse(taskId=" + this.taskId + ", messageId=" + this.messageId + ", task=" + this.task + ')';
    }

    public CreateTaskResponse(String str, String str2, ConversationInfo conversationInfo) {
        this.taskId = str;
        this.messageId = str2;
        this.task = conversationInfo;
    }

    public /* synthetic */ CreateTaskResponse(String str, String str2, ConversationInfo conversationInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : conversationInfo);
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final ConversationInfo getTask() {
        return this.task;
    }
}

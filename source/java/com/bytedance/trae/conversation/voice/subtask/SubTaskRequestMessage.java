package com.bytedance.trae.conversation.voice.subtask;

import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.model.QueryItem;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubTaskProtocol.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001-Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jo\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012¨\u0006."}, d2 = {"Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;", "", DBData.FIELD_TYPE, "", "taskId", "roomId", "userId", "taskDescription", "message", "files", "", "Lcom/bytedance/trae/conversation/model/QueryItem;", "timeoutMs", "", "executor", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JLjava/lang/String;)V", "getType", "()Ljava/lang/String;", "getTaskId", "getRoomId", "getUserId", "getTaskDescription", "getMessage", "getFiles", "()Ljava/util/List;", "getTimeoutMs", "()J", "getExecutor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class SubTaskRequestMessage {
    public static final long DEFAULT_TIMEOUT_MS = 600000;
    public static final String EXECUTOR_CLIENT = "client";
    public static final String EXECUTOR_SERVER = "server";
    public static final String TYPE = "sub_task_request";
    public static final String TYPE_UPDATE = "task_update";

    @SerializedName("executor")
    private final String executor;

    @SerializedName("files")
    private final List<QueryItem> files;

    @SerializedName("message")
    private final String message;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("task_description")
    private final String taskDescription;

    @SerializedName(NewTaskTracker.Param.TASK_ID)
    private final String taskId;

    @SerializedName("timeout_ms")
    private final long timeoutMs;

    @SerializedName(DBData.FIELD_TYPE)
    private final String type;

    @SerializedName("user_id")
    private final String userId;

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTaskDescription() {
        return this.taskDescription;
    }

    /* renamed from: component6, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final List<QueryItem> component7() {
        return this.files;
    }

    /* renamed from: component8, reason: from getter */
    public final long getTimeoutMs() {
        return this.timeoutMs;
    }

    /* renamed from: component9, reason: from getter */
    public final String getExecutor() {
        return this.executor;
    }

    public final SubTaskRequestMessage copy(String type, String taskId, String roomId, String userId, String taskDescription, String message, List<QueryItem> files, long timeoutMs, String executor) {
        Intrinsics.checkNotNullParameter(type, DBData.FIELD_TYPE);
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(taskDescription, "taskDescription");
        return new SubTaskRequestMessage(type, taskId, roomId, userId, taskDescription, message, files, timeoutMs, executor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubTaskRequestMessage)) {
            return false;
        }
        SubTaskRequestMessage subTaskRequestMessage = (SubTaskRequestMessage) other;
        return Intrinsics.areEqual(this.type, subTaskRequestMessage.type) && Intrinsics.areEqual(this.taskId, subTaskRequestMessage.taskId) && Intrinsics.areEqual(this.roomId, subTaskRequestMessage.roomId) && Intrinsics.areEqual(this.userId, subTaskRequestMessage.userId) && Intrinsics.areEqual(this.taskDescription, subTaskRequestMessage.taskDescription) && Intrinsics.areEqual(this.message, subTaskRequestMessage.message) && Intrinsics.areEqual(this.files, subTaskRequestMessage.files) && this.timeoutMs == subTaskRequestMessage.timeoutMs && Intrinsics.areEqual(this.executor, subTaskRequestMessage.executor);
    }

    public int hashCode() {
        int hashCode = ((((((((this.type.hashCode() * 31) + this.taskId.hashCode()) * 31) + this.roomId.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.taskDescription.hashCode()) * 31;
        String str = this.message;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<QueryItem> list = this.files;
        int hashCode3 = (((hashCode2 + (list == null ? 0 : list.hashCode())) * 31) + Long.hashCode(this.timeoutMs)) * 31;
        String str2 = this.executor;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "SubTaskRequestMessage(type=" + this.type + ", taskId=" + this.taskId + ", roomId=" + this.roomId + ", userId=" + this.userId + ", taskDescription=" + this.taskDescription + ", message=" + this.message + ", files=" + this.files + ", timeoutMs=" + this.timeoutMs + ", executor=" + this.executor + ')';
    }

    public SubTaskRequestMessage(String str, String str2, String str3, String str4, String str5, String str6, List<QueryItem> list, long j, String str7) {
        Intrinsics.checkNotNullParameter(str, DBData.FIELD_TYPE);
        Intrinsics.checkNotNullParameter(str2, "taskId");
        Intrinsics.checkNotNullParameter(str3, "roomId");
        Intrinsics.checkNotNullParameter(str4, "userId");
        Intrinsics.checkNotNullParameter(str5, "taskDescription");
        this.type = str;
        this.taskId = str2;
        this.roomId = str3;
        this.userId = str4;
        this.taskDescription = str5;
        this.message = str6;
        this.files = list;
        this.timeoutMs = j;
        this.executor = str7;
    }

    public /* synthetic */ SubTaskRequestMessage(String str, String str2, String str3, String str4, String str5, String str6, List list, long j, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : list, (i & 128) != 0 ? 600000L : j, (i & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : str7);
    }

    public final String getType() {
        return this.type;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getTaskDescription() {
        return this.taskDescription;
    }

    public final String getMessage() {
        return this.message;
    }

    public final List<QueryItem> getFiles() {
        return this.files;
    }

    public final long getTimeoutMs() {
        return this.timeoutMs;
    }

    public final String getExecutor() {
        return this.executor;
    }
}

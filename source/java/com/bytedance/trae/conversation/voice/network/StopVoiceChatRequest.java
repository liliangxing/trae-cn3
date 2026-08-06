package com.bytedance.trae.conversation.voice.network;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoiceChatModels.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/voice/network/StopVoiceChatRequest;", "", "appId", "", "roomId", DBDefinition.TASK_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getRoomId", "getTaskId", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class StopVoiceChatRequest {

    @SerializedName("app_id")
    private final String appId;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName(NewTaskTracker.Param.TASK_ID)
    private final String taskId;

    public static /* synthetic */ StopVoiceChatRequest copy$default(StopVoiceChatRequest stopVoiceChatRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stopVoiceChatRequest.appId;
        }
        if ((i & 2) != 0) {
            str2 = stopVoiceChatRequest.roomId;
        }
        if ((i & 4) != 0) {
            str3 = stopVoiceChatRequest.taskId;
        }
        return stopVoiceChatRequest.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public final StopVoiceChatRequest copy(String appId, String roomId, String taskId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        return new StopVoiceChatRequest(appId, roomId, taskId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StopVoiceChatRequest)) {
            return false;
        }
        StopVoiceChatRequest stopVoiceChatRequest = (StopVoiceChatRequest) other;
        return Intrinsics.areEqual(this.appId, stopVoiceChatRequest.appId) && Intrinsics.areEqual(this.roomId, stopVoiceChatRequest.roomId) && Intrinsics.areEqual(this.taskId, stopVoiceChatRequest.taskId);
    }

    public int hashCode() {
        return (((this.appId.hashCode() * 31) + this.roomId.hashCode()) * 31) + this.taskId.hashCode();
    }

    public String toString() {
        return "StopVoiceChatRequest(appId=" + this.appId + ", roomId=" + this.roomId + ", taskId=" + this.taskId + ')';
    }

    public StopVoiceChatRequest(String appId, String roomId, String taskId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        this.appId = appId;
        this.roomId = roomId;
        this.taskId = taskId;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getTaskId() {
        return this.taskId;
    }
}

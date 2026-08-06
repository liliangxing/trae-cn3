package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.push.api.PushConst;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICancelTaskApi.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/im/service/CancelTaskResponse;", "", "conversationId", "", DBDefinition.TASK_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getConversationId", "()Ljava/lang/String;", "getTaskId", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CancelTaskResponse {

    @SerializedName(PushConst.PUSH_KEY_CONVERSATION_ID)
    private final String conversationId;

    @SerializedName(NewTaskTracker.Param.TASK_ID)
    private final String taskId;

    /* JADX WARN: Multi-variable type inference failed */
    public CancelTaskResponse() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CancelTaskResponse copy$default(CancelTaskResponse cancelTaskResponse, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cancelTaskResponse.conversationId;
        }
        if ((i & 2) != 0) {
            str2 = cancelTaskResponse.taskId;
        }
        return cancelTaskResponse.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public final CancelTaskResponse copy(String conversationId, String taskId) {
        return new CancelTaskResponse(conversationId, taskId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CancelTaskResponse)) {
            return false;
        }
        CancelTaskResponse cancelTaskResponse = (CancelTaskResponse) other;
        return Intrinsics.areEqual(this.conversationId, cancelTaskResponse.conversationId) && Intrinsics.areEqual(this.taskId, cancelTaskResponse.taskId);
    }

    public int hashCode() {
        String str = this.conversationId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.taskId;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "CancelTaskResponse(conversationId=" + this.conversationId + ", taskId=" + this.taskId + ')';
    }

    public CancelTaskResponse(String str, String str2) {
        this.conversationId = str;
        this.taskId = str2;
    }

    public /* synthetic */ CancelTaskResponse(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getTaskId() {
        return this.taskId;
    }
}

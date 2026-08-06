package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.push.api.PushConst;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IConfirmTaskApi.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JS\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\""}, d2 = {"Lcom/bytedance/trae/im/service/ConfirmTaskRequest;", "", "conversationId", "", DBDefinition.TASK_ID, "type", "planItemId", "toolName", "decision", "params", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getConversationId", "()Ljava/lang/String;", "getTaskId", "getType", "getPlanItemId", "getToolName", "getDecision", "getParams", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConfirmTaskRequest {

    @SerializedName(PushConst.PUSH_KEY_CONVERSATION_ID)
    private final String conversationId;

    @SerializedName("decision")
    private final String decision;

    @SerializedName("params")
    private final String params;

    @SerializedName("plan_item_id")
    private final String planItemId;

    @SerializedName(NewTaskTracker.Param.TASK_ID)
    private final String taskId;

    @SerializedName("tool_name")
    private final String toolName;

    @SerializedName("type")
    private final String type;

    public static /* synthetic */ ConfirmTaskRequest copy$default(ConfirmTaskRequest confirmTaskRequest, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = confirmTaskRequest.conversationId;
        }
        if ((i & 2) != 0) {
            str2 = confirmTaskRequest.taskId;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = confirmTaskRequest.type;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = confirmTaskRequest.planItemId;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = confirmTaskRequest.toolName;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = confirmTaskRequest.decision;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = confirmTaskRequest.params;
        }
        return confirmTaskRequest.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPlanItemId() {
        return this.planItemId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDecision() {
        return this.decision;
    }

    /* renamed from: component7, reason: from getter */
    public final String getParams() {
        return this.params;
    }

    public final ConfirmTaskRequest copy(String conversationId, String taskId, String type, String planItemId, String toolName, String decision, String params) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(planItemId, "planItemId");
        Intrinsics.checkNotNullParameter(decision, "decision");
        return new ConfirmTaskRequest(conversationId, taskId, type, planItemId, toolName, decision, params);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfirmTaskRequest)) {
            return false;
        }
        ConfirmTaskRequest confirmTaskRequest = (ConfirmTaskRequest) other;
        return Intrinsics.areEqual(this.conversationId, confirmTaskRequest.conversationId) && Intrinsics.areEqual(this.taskId, confirmTaskRequest.taskId) && Intrinsics.areEqual(this.type, confirmTaskRequest.type) && Intrinsics.areEqual(this.planItemId, confirmTaskRequest.planItemId) && Intrinsics.areEqual(this.toolName, confirmTaskRequest.toolName) && Intrinsics.areEqual(this.decision, confirmTaskRequest.decision) && Intrinsics.areEqual(this.params, confirmTaskRequest.params);
    }

    public int hashCode() {
        int hashCode = ((((((this.conversationId.hashCode() * 31) + this.taskId.hashCode()) * 31) + this.type.hashCode()) * 31) + this.planItemId.hashCode()) * 31;
        String str = this.toolName;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.decision.hashCode()) * 31;
        String str2 = this.params;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ConfirmTaskRequest(conversationId=" + this.conversationId + ", taskId=" + this.taskId + ", type=" + this.type + ", planItemId=" + this.planItemId + ", toolName=" + this.toolName + ", decision=" + this.decision + ", params=" + this.params + ')';
    }

    public ConfirmTaskRequest(String conversationId, String taskId, String type, String planItemId, String str, String decision, String str2) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(planItemId, "planItemId");
        Intrinsics.checkNotNullParameter(decision, "decision");
        this.conversationId = conversationId;
        this.taskId = taskId;
        this.type = type;
        this.planItemId = planItemId;
        this.toolName = str;
        this.decision = decision;
        this.params = str2;
    }

    public /* synthetic */ ConfirmTaskRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? "tool_confirm" : str3, str4, (i & 16) != 0 ? null : str5, str6, (i & 64) != 0 ? null : str7);
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getType() {
        return this.type;
    }

    public final String getPlanItemId() {
        return this.planItemId;
    }

    public final String getToolName() {
        return this.toolName;
    }

    public final String getDecision() {
        return this.decision;
    }

    public final String getParams() {
        return this.params;
    }
}

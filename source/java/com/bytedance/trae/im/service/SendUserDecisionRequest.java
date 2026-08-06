package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ISendUserDecisionApi.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JI\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/im/service/SendUserDecisionRequest;", "", "chatSessionId", "", "type", "planItemId", "toolName", "decision", "params", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChatSessionId", "()Ljava/lang/String;", "getType", "getPlanItemId", "getToolName", "getDecision", "getParams", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SendUserDecisionRequest {

    @SerializedName("chat_session_id")
    private final String chatSessionId;

    @SerializedName("decision")
    private final String decision;

    @SerializedName("params")
    private final String params;

    @SerializedName("plan_item_id")
    private final String planItemId;

    @SerializedName("tool_name")
    private final String toolName;

    @SerializedName("type")
    private final String type;

    public static /* synthetic */ SendUserDecisionRequest copy$default(SendUserDecisionRequest sendUserDecisionRequest, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sendUserDecisionRequest.chatSessionId;
        }
        if ((i & 2) != 0) {
            str2 = sendUserDecisionRequest.type;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = sendUserDecisionRequest.planItemId;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = sendUserDecisionRequest.toolName;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = sendUserDecisionRequest.decision;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = sendUserDecisionRequest.params;
        }
        return sendUserDecisionRequest.copy(str, str7, str8, str9, str10, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPlanItemId() {
        return this.planItemId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDecision() {
        return this.decision;
    }

    /* renamed from: component6, reason: from getter */
    public final String getParams() {
        return this.params;
    }

    public final SendUserDecisionRequest copy(String chatSessionId, String type, String planItemId, String toolName, String decision, String params) {
        Intrinsics.checkNotNullParameter(chatSessionId, "chatSessionId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(planItemId, "planItemId");
        Intrinsics.checkNotNullParameter(decision, "decision");
        return new SendUserDecisionRequest(chatSessionId, type, planItemId, toolName, decision, params);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SendUserDecisionRequest)) {
            return false;
        }
        SendUserDecisionRequest sendUserDecisionRequest = (SendUserDecisionRequest) other;
        return Intrinsics.areEqual(this.chatSessionId, sendUserDecisionRequest.chatSessionId) && Intrinsics.areEqual(this.type, sendUserDecisionRequest.type) && Intrinsics.areEqual(this.planItemId, sendUserDecisionRequest.planItemId) && Intrinsics.areEqual(this.toolName, sendUserDecisionRequest.toolName) && Intrinsics.areEqual(this.decision, sendUserDecisionRequest.decision) && Intrinsics.areEqual(this.params, sendUserDecisionRequest.params);
    }

    public int hashCode() {
        int hashCode = ((((this.chatSessionId.hashCode() * 31) + this.type.hashCode()) * 31) + this.planItemId.hashCode()) * 31;
        String str = this.toolName;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.decision.hashCode()) * 31;
        String str2 = this.params;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "SendUserDecisionRequest(chatSessionId=" + this.chatSessionId + ", type=" + this.type + ", planItemId=" + this.planItemId + ", toolName=" + this.toolName + ", decision=" + this.decision + ", params=" + this.params + ')';
    }

    public SendUserDecisionRequest(String chatSessionId, String type, String planItemId, String str, String decision, String str2) {
        Intrinsics.checkNotNullParameter(chatSessionId, "chatSessionId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(planItemId, "planItemId");
        Intrinsics.checkNotNullParameter(decision, "decision");
        this.chatSessionId = chatSessionId;
        this.type = type;
        this.planItemId = planItemId;
        this.toolName = str;
        this.decision = decision;
        this.params = str2;
    }

    public /* synthetic */ SendUserDecisionRequest(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "tool_confirm" : str2, str3, (i & 8) != 0 ? null : str4, str5, (i & 32) != 0 ? null : str6);
    }

    public final String getChatSessionId() {
        return this.chatSessionId;
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

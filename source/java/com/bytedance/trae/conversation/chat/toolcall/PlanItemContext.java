package com.bytedance.trae.conversation.chat.toolcall;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.im.model.ConfirmInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlanItemContext.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "", "planItemId", "", "agentId", "agentRunId", "chatSessionId", "environment", "confirmInfo", "Lcom/bytedance/trae/im/model/ConfirmInfo;", "reasoningContent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/model/ConfirmInfo;Ljava/lang/String;)V", "getPlanItemId", "()Ljava/lang/String;", "getAgentId", "getAgentRunId", "getChatSessionId", "getEnvironment", "getConfirmInfo", "()Lcom/bytedance/trae/im/model/ConfirmInfo;", "getReasoningContent", "setReasoningContent", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PlanItemContext {
    private final String agentId;
    private final String agentRunId;
    private final String chatSessionId;
    private final ConfirmInfo confirmInfo;
    private final String environment;
    private final String planItemId;
    private String reasoningContent;

    public PlanItemContext() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ PlanItemContext copy$default(PlanItemContext planItemContext, String str, String str2, String str3, String str4, String str5, ConfirmInfo confirmInfo, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = planItemContext.planItemId;
        }
        if ((i & 2) != 0) {
            str2 = planItemContext.agentId;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = planItemContext.agentRunId;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = planItemContext.chatSessionId;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = planItemContext.environment;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            confirmInfo = planItemContext.confirmInfo;
        }
        ConfirmInfo confirmInfo2 = confirmInfo;
        if ((i & 64) != 0) {
            str6 = planItemContext.reasoningContent;
        }
        return planItemContext.copy(str, str7, str8, str9, str10, confirmInfo2, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPlanItemId() {
        return this.planItemId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAgentRunId() {
        return this.agentRunId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getEnvironment() {
        return this.environment;
    }

    /* renamed from: component6, reason: from getter */
    public final ConfirmInfo getConfirmInfo() {
        return this.confirmInfo;
    }

    /* renamed from: component7, reason: from getter */
    public final String getReasoningContent() {
        return this.reasoningContent;
    }

    public final PlanItemContext copy(String planItemId, String agentId, String agentRunId, String chatSessionId, String environment, ConfirmInfo confirmInfo, String reasoningContent) {
        return new PlanItemContext(planItemId, agentId, agentRunId, chatSessionId, environment, confirmInfo, reasoningContent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlanItemContext)) {
            return false;
        }
        PlanItemContext planItemContext = (PlanItemContext) other;
        return Intrinsics.areEqual(this.planItemId, planItemContext.planItemId) && Intrinsics.areEqual(this.agentId, planItemContext.agentId) && Intrinsics.areEqual(this.agentRunId, planItemContext.agentRunId) && Intrinsics.areEqual(this.chatSessionId, planItemContext.chatSessionId) && Intrinsics.areEqual(this.environment, planItemContext.environment) && Intrinsics.areEqual(this.confirmInfo, planItemContext.confirmInfo) && Intrinsics.areEqual(this.reasoningContent, planItemContext.reasoningContent);
    }

    public int hashCode() {
        String str = this.planItemId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.agentId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.agentRunId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.chatSessionId;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.environment;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        ConfirmInfo confirmInfo = this.confirmInfo;
        int hashCode6 = (hashCode5 + (confirmInfo == null ? 0 : confirmInfo.hashCode())) * 31;
        String str6 = this.reasoningContent;
        return hashCode6 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "PlanItemContext(planItemId=" + this.planItemId + ", agentId=" + this.agentId + ", agentRunId=" + this.agentRunId + ", chatSessionId=" + this.chatSessionId + ", environment=" + this.environment + ", confirmInfo=" + this.confirmInfo + ", reasoningContent=" + this.reasoningContent + ')';
    }

    public PlanItemContext(String str, String str2, String str3, String str4, String str5, ConfirmInfo confirmInfo, String str6) {
        this.planItemId = str;
        this.agentId = str2;
        this.agentRunId = str3;
        this.chatSessionId = str4;
        this.environment = str5;
        this.confirmInfo = confirmInfo;
        this.reasoningContent = str6;
    }

    public /* synthetic */ PlanItemContext(String str, String str2, String str3, String str4, String str5, ConfirmInfo confirmInfo, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : confirmInfo, (i & 64) != 0 ? null : str6);
    }

    public final String getPlanItemId() {
        return this.planItemId;
    }

    public final String getAgentId() {
        return this.agentId;
    }

    public final String getAgentRunId() {
        return this.agentRunId;
    }

    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    public final String getEnvironment() {
        return this.environment;
    }

    public final ConfirmInfo getConfirmInfo() {
        return this.confirmInfo;
    }

    public final String getReasoningContent() {
        return this.reasoningContent;
    }

    public final void setReasoningContent(String str) {
        this.reasoningContent = str;
    }
}

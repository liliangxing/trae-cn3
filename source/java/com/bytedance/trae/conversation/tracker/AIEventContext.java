package com.bytedance.trae.conversation.tracker;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeAITracker.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/AIEventContext;", "", "projectId", "", "sessionId", "messageId", "chatModel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getProjectId", "()Ljava/lang/String;", "setProjectId", "(Ljava/lang/String;)V", "getSessionId", "setSessionId", "getMessageId", "setMessageId", "getChatModel", "setChatModel", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AIEventContext {
    private String chatModel;
    private String messageId;
    private String projectId;
    private String sessionId;

    public AIEventContext() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ AIEventContext copy$default(AIEventContext aIEventContext, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aIEventContext.projectId;
        }
        if ((i & 2) != 0) {
            str2 = aIEventContext.sessionId;
        }
        if ((i & 4) != 0) {
            str3 = aIEventContext.messageId;
        }
        if ((i & 8) != 0) {
            str4 = aIEventContext.chatModel;
        }
        return aIEventContext.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getProjectId() {
        return this.projectId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getChatModel() {
        return this.chatModel;
    }

    public final AIEventContext copy(String projectId, String sessionId, String messageId, String chatModel) {
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(chatModel, "chatModel");
        return new AIEventContext(projectId, sessionId, messageId, chatModel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIEventContext)) {
            return false;
        }
        AIEventContext aIEventContext = (AIEventContext) other;
        return Intrinsics.areEqual(this.projectId, aIEventContext.projectId) && Intrinsics.areEqual(this.sessionId, aIEventContext.sessionId) && Intrinsics.areEqual(this.messageId, aIEventContext.messageId) && Intrinsics.areEqual(this.chatModel, aIEventContext.chatModel);
    }

    public int hashCode() {
        return (((((this.projectId.hashCode() * 31) + this.sessionId.hashCode()) * 31) + this.messageId.hashCode()) * 31) + this.chatModel.hashCode();
    }

    public String toString() {
        return "AIEventContext(projectId=" + this.projectId + ", sessionId=" + this.sessionId + ", messageId=" + this.messageId + ", chatModel=" + this.chatModel + ')';
    }

    public AIEventContext(String projectId, String sessionId, String messageId, String chatModel) {
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(chatModel, "chatModel");
        this.projectId = projectId;
        this.sessionId = sessionId;
        this.messageId = messageId;
        this.chatModel = chatModel;
    }

    public /* synthetic */ AIEventContext(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }

    public final String getProjectId() {
        return this.projectId;
    }

    public final void setProjectId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.projectId = str;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sessionId = str;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final void setMessageId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.messageId = str;
    }

    public final String getChatModel() {
        return this.chatModel;
    }

    public final void setChatModel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.chatModel = str;
    }
}

package com.bytedance.trae.conversation.chat.grouping;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlanItemGrouper.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J=\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;", "", "mainAgentRunId", "", "messageStatus", "isHistory", "", "isLatestTurn", "isStreaming", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZZ)V", "getMainAgentRunId", "()Ljava/lang/String;", "getMessageStatus", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GroupingContext {
    private final boolean isHistory;
    private final boolean isLatestTurn;
    private final boolean isStreaming;
    private final String mainAgentRunId;
    private final String messageStatus;

    public static /* synthetic */ GroupingContext copy$default(GroupingContext groupingContext, String str, String str2, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = groupingContext.mainAgentRunId;
        }
        if ((i & 2) != 0) {
            str2 = groupingContext.messageStatus;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            z = groupingContext.isHistory;
        }
        boolean z4 = z;
        if ((i & 8) != 0) {
            z2 = groupingContext.isLatestTurn;
        }
        boolean z5 = z2;
        if ((i & 16) != 0) {
            z3 = groupingContext.isStreaming;
        }
        return groupingContext.copy(str, str3, z4, z5, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMainAgentRunId() {
        return this.mainAgentRunId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessageStatus() {
        return this.messageStatus;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsHistory() {
        return this.isHistory;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsLatestTurn() {
        return this.isLatestTurn;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsStreaming() {
        return this.isStreaming;
    }

    public final GroupingContext copy(String mainAgentRunId, String messageStatus, boolean isHistory, boolean isLatestTurn, boolean isStreaming) {
        Intrinsics.checkNotNullParameter(mainAgentRunId, "mainAgentRunId");
        return new GroupingContext(mainAgentRunId, messageStatus, isHistory, isLatestTurn, isStreaming);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupingContext)) {
            return false;
        }
        GroupingContext groupingContext = (GroupingContext) other;
        return Intrinsics.areEqual(this.mainAgentRunId, groupingContext.mainAgentRunId) && Intrinsics.areEqual(this.messageStatus, groupingContext.messageStatus) && this.isHistory == groupingContext.isHistory && this.isLatestTurn == groupingContext.isLatestTurn && this.isStreaming == groupingContext.isStreaming;
    }

    public int hashCode() {
        int hashCode = this.mainAgentRunId.hashCode() * 31;
        String str = this.messageStatus;
        return ((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isHistory)) * 31) + Boolean.hashCode(this.isLatestTurn)) * 31) + Boolean.hashCode(this.isStreaming);
    }

    public String toString() {
        return "GroupingContext(mainAgentRunId=" + this.mainAgentRunId + ", messageStatus=" + this.messageStatus + ", isHistory=" + this.isHistory + ", isLatestTurn=" + this.isLatestTurn + ", isStreaming=" + this.isStreaming + ')';
    }

    public GroupingContext(String mainAgentRunId, String str, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(mainAgentRunId, "mainAgentRunId");
        this.mainAgentRunId = mainAgentRunId;
        this.messageStatus = str;
        this.isHistory = z;
        this.isLatestTurn = z2;
        this.isStreaming = z3;
    }

    public /* synthetic */ GroupingContext(String str, String str2, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? false : z3);
    }

    public final String getMainAgentRunId() {
        return this.mainAgentRunId;
    }

    public final String getMessageStatus() {
        return this.messageStatus;
    }

    public final boolean isHistory() {
        return this.isHistory;
    }

    public final boolean isLatestTurn() {
        return this.isLatestTurn;
    }

    public final boolean isStreaming() {
        return this.isStreaming;
    }
}

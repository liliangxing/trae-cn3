package com.bytedance.trae.conversation.brainstorm.model;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BrainstormEndData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormEndData;", "", "messages", "", "isAbort", "", "parentConversationId", "summarySkippedBecauseNoContent", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Z)V", "getMessages", "()Ljava/lang/String;", "()Z", "getParentConversationId", "getSummarySkippedBecauseNoContent", "component1", "component2", "component3", "component4", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BrainstormEndData {
    private final boolean isAbort;
    private final String messages;
    private final String parentConversationId;
    private final boolean summarySkippedBecauseNoContent;

    public static /* synthetic */ BrainstormEndData copy$default(BrainstormEndData brainstormEndData, String str, boolean z, String str2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = brainstormEndData.messages;
        }
        if ((i & 2) != 0) {
            z = brainstormEndData.isAbort;
        }
        if ((i & 4) != 0) {
            str2 = brainstormEndData.parentConversationId;
        }
        if ((i & 8) != 0) {
            z2 = brainstormEndData.summarySkippedBecauseNoContent;
        }
        return brainstormEndData.copy(str, z, str2, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMessages() {
        return this.messages;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsAbort() {
        return this.isAbort;
    }

    /* renamed from: component3, reason: from getter */
    public final String getParentConversationId() {
        return this.parentConversationId;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getSummarySkippedBecauseNoContent() {
        return this.summarySkippedBecauseNoContent;
    }

    public final BrainstormEndData copy(String messages, boolean isAbort, String parentConversationId, boolean summarySkippedBecauseNoContent) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        return new BrainstormEndData(messages, isAbort, parentConversationId, summarySkippedBecauseNoContent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BrainstormEndData)) {
            return false;
        }
        BrainstormEndData brainstormEndData = (BrainstormEndData) other;
        return Intrinsics.areEqual(this.messages, brainstormEndData.messages) && this.isAbort == brainstormEndData.isAbort && Intrinsics.areEqual(this.parentConversationId, brainstormEndData.parentConversationId) && this.summarySkippedBecauseNoContent == brainstormEndData.summarySkippedBecauseNoContent;
    }

    public int hashCode() {
        int hashCode = ((this.messages.hashCode() * 31) + Boolean.hashCode(this.isAbort)) * 31;
        String str = this.parentConversationId;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.summarySkippedBecauseNoContent);
    }

    public String toString() {
        return "BrainstormEndData(messages=" + this.messages + ", isAbort=" + this.isAbort + ", parentConversationId=" + this.parentConversationId + ", summarySkippedBecauseNoContent=" + this.summarySkippedBecauseNoContent + ')';
    }

    public BrainstormEndData(String messages, boolean z, String str, boolean z2) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        this.messages = messages;
        this.isAbort = z;
        this.parentConversationId = str;
        this.summarySkippedBecauseNoContent = z2;
    }

    public /* synthetic */ BrainstormEndData(String str, boolean z, String str2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? false : z2);
    }

    public final String getMessages() {
        return this.messages;
    }

    public final boolean isAbort() {
        return this.isAbort;
    }

    public final String getParentConversationId() {
        return this.parentConversationId;
    }

    public final boolean getSummarySkippedBecauseNoContent() {
        return this.summarySkippedBecauseNoContent;
    }
}

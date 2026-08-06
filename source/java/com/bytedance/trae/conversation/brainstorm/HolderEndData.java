package com.bytedance.trae.conversation.brainstorm;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HolderTypes.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003JI\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006!"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/HolderEndData;", "", "reason", "Lcom/bytedance/trae/conversation/brainstorm/EndReason;", "cliConversationId", "", "parentConversationId", "messages", "isAbort", "", "summarySkippedBecauseNoContent", "<init>", "(Lcom/bytedance/trae/conversation/brainstorm/EndReason;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getReason", "()Lcom/bytedance/trae/conversation/brainstorm/EndReason;", "getCliConversationId", "()Ljava/lang/String;", "getParentConversationId", "getMessages", "()Z", "getSummarySkippedBecauseNoContent", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class HolderEndData {
    private final String cliConversationId;
    private final boolean isAbort;
    private final String messages;
    private final String parentConversationId;
    private final EndReason reason;
    private final boolean summarySkippedBecauseNoContent;

    public static /* synthetic */ HolderEndData copy$default(HolderEndData holderEndData, EndReason endReason, String str, String str2, String str3, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            endReason = holderEndData.reason;
        }
        if ((i & 2) != 0) {
            str = holderEndData.cliConversationId;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = holderEndData.parentConversationId;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = holderEndData.messages;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            z = holderEndData.isAbort;
        }
        boolean z3 = z;
        if ((i & 32) != 0) {
            z2 = holderEndData.summarySkippedBecauseNoContent;
        }
        return holderEndData.copy(endReason, str4, str5, str6, z3, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final EndReason getReason() {
        return this.reason;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCliConversationId() {
        return this.cliConversationId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getParentConversationId() {
        return this.parentConversationId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMessages() {
        return this.messages;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsAbort() {
        return this.isAbort;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getSummarySkippedBecauseNoContent() {
        return this.summarySkippedBecauseNoContent;
    }

    public final HolderEndData copy(EndReason reason, String cliConversationId, String parentConversationId, String messages, boolean isAbort, boolean summarySkippedBecauseNoContent) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(messages, "messages");
        return new HolderEndData(reason, cliConversationId, parentConversationId, messages, isAbort, summarySkippedBecauseNoContent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HolderEndData)) {
            return false;
        }
        HolderEndData holderEndData = (HolderEndData) other;
        return this.reason == holderEndData.reason && Intrinsics.areEqual(this.cliConversationId, holderEndData.cliConversationId) && Intrinsics.areEqual(this.parentConversationId, holderEndData.parentConversationId) && Intrinsics.areEqual(this.messages, holderEndData.messages) && this.isAbort == holderEndData.isAbort && this.summarySkippedBecauseNoContent == holderEndData.summarySkippedBecauseNoContent;
    }

    public int hashCode() {
        int hashCode = this.reason.hashCode() * 31;
        String str = this.cliConversationId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.parentConversationId;
        return ((((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.messages.hashCode()) * 31) + Boolean.hashCode(this.isAbort)) * 31) + Boolean.hashCode(this.summarySkippedBecauseNoContent);
    }

    public String toString() {
        return "HolderEndData(reason=" + this.reason + ", cliConversationId=" + this.cliConversationId + ", parentConversationId=" + this.parentConversationId + ", messages=" + this.messages + ", isAbort=" + this.isAbort + ", summarySkippedBecauseNoContent=" + this.summarySkippedBecauseNoContent + ')';
    }

    public HolderEndData(EndReason reason, String str, String str2, String messages, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(messages, "messages");
        this.reason = reason;
        this.cliConversationId = str;
        this.parentConversationId = str2;
        this.messages = messages;
        this.isAbort = z;
        this.summarySkippedBecauseNoContent = z2;
    }

    public /* synthetic */ HolderEndData(EndReason endReason, String str, String str2, String str3, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(endReason, str, str2, str3, z, (i & 32) != 0 ? false : z2);
    }

    public final EndReason getReason() {
        return this.reason;
    }

    public final String getCliConversationId() {
        return this.cliConversationId;
    }

    public final String getParentConversationId() {
        return this.parentConversationId;
    }

    public final String getMessages() {
        return this.messages;
    }

    public final boolean isAbort() {
        return this.isAbort;
    }

    public final boolean getSummarySkippedBecauseNoContent() {
        return this.summarySkippedBecauseNoContent;
    }
}

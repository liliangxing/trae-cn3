package com.bytedance.trae.conversation.upgrade;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpgradeReminderUiState.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderUiState;", "", "conversationId", "", "visible", "", "<init>", "(Ljava/lang/String;Z)V", "getConversationId", "()Ljava/lang/String;", "getVisible", "()Z", "component1", "component2", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UpgradeReminderUiState {
    private final String conversationId;
    private final boolean visible;

    public static /* synthetic */ UpgradeReminderUiState copy$default(UpgradeReminderUiState upgradeReminderUiState, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = upgradeReminderUiState.conversationId;
        }
        if ((i & 2) != 0) {
            z = upgradeReminderUiState.visible;
        }
        return upgradeReminderUiState.copy(str, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getVisible() {
        return this.visible;
    }

    public final UpgradeReminderUiState copy(String conversationId, boolean visible) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        return new UpgradeReminderUiState(conversationId, visible);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpgradeReminderUiState)) {
            return false;
        }
        UpgradeReminderUiState upgradeReminderUiState = (UpgradeReminderUiState) other;
        return Intrinsics.areEqual(this.conversationId, upgradeReminderUiState.conversationId) && this.visible == upgradeReminderUiState.visible;
    }

    public int hashCode() {
        return (this.conversationId.hashCode() * 31) + Boolean.hashCode(this.visible);
    }

    public String toString() {
        return "UpgradeReminderUiState(conversationId=" + this.conversationId + ", visible=" + this.visible + ')';
    }

    public UpgradeReminderUiState(String conversationId, boolean z) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        this.conversationId = conversationId;
        this.visible = z;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final boolean getVisible() {
        return this.visible;
    }
}

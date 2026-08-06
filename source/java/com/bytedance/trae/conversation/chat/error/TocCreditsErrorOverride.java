package com.bytedance.trae.conversation.chat.error;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AgentErrorCodeRegistry.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;", "", "messageResId", "", "titleResId", "level", "Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;", "showInfoIcon", "", "<init>", "(IILcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;Z)V", "getMessageResId", "()I", "getTitleResId", "getLevel", "()Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;", "getShowInfoIcon", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TocCreditsErrorOverride {
    private final AgentErrorLevel level;
    private final int messageResId;
    private final boolean showInfoIcon;
    private final int titleResId;

    public static /* synthetic */ TocCreditsErrorOverride copy$default(TocCreditsErrorOverride tocCreditsErrorOverride, int i, int i2, AgentErrorLevel agentErrorLevel, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = tocCreditsErrorOverride.messageResId;
        }
        if ((i3 & 2) != 0) {
            i2 = tocCreditsErrorOverride.titleResId;
        }
        if ((i3 & 4) != 0) {
            agentErrorLevel = tocCreditsErrorOverride.level;
        }
        if ((i3 & 8) != 0) {
            z = tocCreditsErrorOverride.showInfoIcon;
        }
        return tocCreditsErrorOverride.copy(i, i2, agentErrorLevel, z);
    }

    /* renamed from: component1, reason: from getter */
    public final int getMessageResId() {
        return this.messageResId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTitleResId() {
        return this.titleResId;
    }

    /* renamed from: component3, reason: from getter */
    public final AgentErrorLevel getLevel() {
        return this.level;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getShowInfoIcon() {
        return this.showInfoIcon;
    }

    public final TocCreditsErrorOverride copy(int messageResId, int titleResId, AgentErrorLevel level, boolean showInfoIcon) {
        Intrinsics.checkNotNullParameter(level, "level");
        return new TocCreditsErrorOverride(messageResId, titleResId, level, showInfoIcon);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TocCreditsErrorOverride)) {
            return false;
        }
        TocCreditsErrorOverride tocCreditsErrorOverride = (TocCreditsErrorOverride) other;
        return this.messageResId == tocCreditsErrorOverride.messageResId && this.titleResId == tocCreditsErrorOverride.titleResId && this.level == tocCreditsErrorOverride.level && this.showInfoIcon == tocCreditsErrorOverride.showInfoIcon;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.messageResId) * 31) + Integer.hashCode(this.titleResId)) * 31) + this.level.hashCode()) * 31) + Boolean.hashCode(this.showInfoIcon);
    }

    public String toString() {
        return "TocCreditsErrorOverride(messageResId=" + this.messageResId + ", titleResId=" + this.titleResId + ", level=" + this.level + ", showInfoIcon=" + this.showInfoIcon + ')';
    }

    public TocCreditsErrorOverride(int i, int i2, AgentErrorLevel level, boolean z) {
        Intrinsics.checkNotNullParameter(level, "level");
        this.messageResId = i;
        this.titleResId = i2;
        this.level = level;
        this.showInfoIcon = z;
    }

    public final int getMessageResId() {
        return this.messageResId;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    public final AgentErrorLevel getLevel() {
        return this.level;
    }

    public final boolean getShowInfoIcon() {
        return this.showInfoIcon;
    }
}

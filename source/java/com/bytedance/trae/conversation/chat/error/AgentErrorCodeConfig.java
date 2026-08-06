package com.bytedance.trae.conversation.chat.error;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AgentErrorCodeConfig.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J8\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;", "", "level", "Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;", "stringResId", "", "defaultMessage", "", "useOriginMessage", "", "<init>", "(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;Ljava/lang/Integer;Ljava/lang/String;Z)V", "getLevel", "()Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;", "getStringResId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDefaultMessage", "()Ljava/lang/String;", "getUseOriginMessage", "()Z", "component1", "component2", "component3", "component4", "copy", "(Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;Ljava/lang/Integer;Ljava/lang/String;Z)Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AgentErrorCodeConfig {
    private final String defaultMessage;
    private final AgentErrorLevel level;
    private final Integer stringResId;
    private final boolean useOriginMessage;

    public static /* synthetic */ AgentErrorCodeConfig copy$default(AgentErrorCodeConfig agentErrorCodeConfig, AgentErrorLevel agentErrorLevel, Integer num, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            agentErrorLevel = agentErrorCodeConfig.level;
        }
        if ((i & 2) != 0) {
            num = agentErrorCodeConfig.stringResId;
        }
        if ((i & 4) != 0) {
            str = agentErrorCodeConfig.defaultMessage;
        }
        if ((i & 8) != 0) {
            z = agentErrorCodeConfig.useOriginMessage;
        }
        return agentErrorCodeConfig.copy(agentErrorLevel, num, str, z);
    }

    /* renamed from: component1, reason: from getter */
    public final AgentErrorLevel getLevel() {
        return this.level;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getStringResId() {
        return this.stringResId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDefaultMessage() {
        return this.defaultMessage;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getUseOriginMessage() {
        return this.useOriginMessage;
    }

    public final AgentErrorCodeConfig copy(AgentErrorLevel level, Integer stringResId, String defaultMessage, boolean useOriginMessage) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(defaultMessage, "defaultMessage");
        return new AgentErrorCodeConfig(level, stringResId, defaultMessage, useOriginMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentErrorCodeConfig)) {
            return false;
        }
        AgentErrorCodeConfig agentErrorCodeConfig = (AgentErrorCodeConfig) other;
        return this.level == agentErrorCodeConfig.level && Intrinsics.areEqual(this.stringResId, agentErrorCodeConfig.stringResId) && Intrinsics.areEqual(this.defaultMessage, agentErrorCodeConfig.defaultMessage) && this.useOriginMessage == agentErrorCodeConfig.useOriginMessage;
    }

    public int hashCode() {
        int hashCode = this.level.hashCode() * 31;
        Integer num = this.stringResId;
        return ((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.defaultMessage.hashCode()) * 31) + Boolean.hashCode(this.useOriginMessage);
    }

    public String toString() {
        return "AgentErrorCodeConfig(level=" + this.level + ", stringResId=" + this.stringResId + ", defaultMessage=" + this.defaultMessage + ", useOriginMessage=" + this.useOriginMessage + ')';
    }

    public AgentErrorCodeConfig(AgentErrorLevel level, Integer num, String defaultMessage, boolean z) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(defaultMessage, "defaultMessage");
        this.level = level;
        this.stringResId = num;
        this.defaultMessage = defaultMessage;
        this.useOriginMessage = z;
    }

    public /* synthetic */ AgentErrorCodeConfig(AgentErrorLevel agentErrorLevel, Integer num, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(agentErrorLevel, num, str, (i & 8) != 0 ? false : z);
    }

    public final AgentErrorLevel getLevel() {
        return this.level;
    }

    public final Integer getStringResId() {
        return this.stringResId;
    }

    public final String getDefaultMessage() {
        return this.defaultMessage;
    }

    public final boolean getUseOriginMessage() {
        return this.useOriginMessage;
    }
}

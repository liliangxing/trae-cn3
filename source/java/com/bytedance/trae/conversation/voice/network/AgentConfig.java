package com.bytedance.trae.conversation.voice.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: VoiceChatModels.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/voice/network/AgentConfig;", "", "enableConversationStateCallback", "", "<init>", "(Z)V", "getEnableConversationStateCallback", "()Z", "component1", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AgentConfig {

    @SerializedName("EnableConversationStateCallback")
    private final boolean enableConversationStateCallback;

    public AgentConfig() {
        this(false, 1, null);
    }

    public static /* synthetic */ AgentConfig copy$default(AgentConfig agentConfig, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = agentConfig.enableConversationStateCallback;
        }
        return agentConfig.copy(z);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnableConversationStateCallback() {
        return this.enableConversationStateCallback;
    }

    public final AgentConfig copy(boolean enableConversationStateCallback) {
        return new AgentConfig(enableConversationStateCallback);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AgentConfig) && this.enableConversationStateCallback == ((AgentConfig) other).enableConversationStateCallback;
    }

    public int hashCode() {
        return Boolean.hashCode(this.enableConversationStateCallback);
    }

    public String toString() {
        return "AgentConfig(enableConversationStateCallback=" + this.enableConversationStateCallback + ')';
    }

    public AgentConfig(boolean z) {
        this.enableConversationStateCallback = z;
    }

    public /* synthetic */ AgentConfig(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    public final boolean getEnableConversationStateCallback() {
        return this.enableConversationStateCallback;
    }
}

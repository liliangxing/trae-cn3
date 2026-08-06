package com.bytedance.trae.conversation.prompt;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: ManagedPromptArbitrationPolicy.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;", "", "type", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptType;", "campaignId", "", "campaignVersion", "", "<init>", "(Lcom/bytedance/trae/conversation/prompt/ManagedPromptType;Ljava/lang/String;I)V", "getType", "()Lcom/bytedance/trae/conversation/prompt/ManagedPromptType;", "getCampaignId", "()Ljava/lang/String;", "getCampaignVersion", "()I", "stableKey", "getStableKey", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ManagedPromptCandidate {
    private final String campaignId;
    private final int campaignVersion;
    private final ManagedPromptType type;

    public static /* synthetic */ ManagedPromptCandidate copy$default(ManagedPromptCandidate managedPromptCandidate, ManagedPromptType managedPromptType, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            managedPromptType = managedPromptCandidate.type;
        }
        if ((i2 & 2) != 0) {
            str = managedPromptCandidate.campaignId;
        }
        if ((i2 & 4) != 0) {
            i = managedPromptCandidate.campaignVersion;
        }
        return managedPromptCandidate.copy(managedPromptType, str, i);
    }

    /* renamed from: component1, reason: from getter */
    public final ManagedPromptType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCampaignId() {
        return this.campaignId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getCampaignVersion() {
        return this.campaignVersion;
    }

    public final ManagedPromptCandidate copy(ManagedPromptType type, String campaignId, int campaignVersion) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(campaignId, "campaignId");
        return new ManagedPromptCandidate(type, campaignId, campaignVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ManagedPromptCandidate)) {
            return false;
        }
        ManagedPromptCandidate managedPromptCandidate = (ManagedPromptCandidate) other;
        return this.type == managedPromptCandidate.type && Intrinsics.areEqual(this.campaignId, managedPromptCandidate.campaignId) && this.campaignVersion == managedPromptCandidate.campaignVersion;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.campaignId.hashCode()) * 31) + Integer.hashCode(this.campaignVersion);
    }

    public String toString() {
        return "ManagedPromptCandidate(type=" + this.type + ", campaignId=" + this.campaignId + ", campaignVersion=" + this.campaignVersion + ')';
    }

    public ManagedPromptCandidate(ManagedPromptType type, String campaignId, int i) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(campaignId, "campaignId");
        this.type = type;
        this.campaignId = campaignId;
        this.campaignVersion = i;
    }

    public final ManagedPromptType getType() {
        return this.type;
    }

    public final String getCampaignId() {
        return this.campaignId;
    }

    public final int getCampaignVersion() {
        return this.campaignVersion;
    }

    public final String getStableKey() {
        return this.campaignId + AbstractJsonLexerKt.COLON + this.campaignVersion;
    }
}

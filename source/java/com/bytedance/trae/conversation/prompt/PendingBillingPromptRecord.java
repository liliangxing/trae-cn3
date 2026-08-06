package com.bytedance.trae.conversation.prompt;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ManagedPromptLedger.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;", "", "campaignVersion", "", "payload", "", "preparedAtMillis", "", "<init>", "(ILjava/lang/String;J)V", "getCampaignVersion", "()I", "getPayload", "()Ljava/lang/String;", "getPreparedAtMillis", "()J", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PendingBillingPromptRecord {
    private final int campaignVersion;
    private final String payload;
    private final long preparedAtMillis;

    public static /* synthetic */ PendingBillingPromptRecord copy$default(PendingBillingPromptRecord pendingBillingPromptRecord, int i, String str, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = pendingBillingPromptRecord.campaignVersion;
        }
        if ((i2 & 2) != 0) {
            str = pendingBillingPromptRecord.payload;
        }
        if ((i2 & 4) != 0) {
            j = pendingBillingPromptRecord.preparedAtMillis;
        }
        return pendingBillingPromptRecord.copy(i, str, j);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCampaignVersion() {
        return this.campaignVersion;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPayload() {
        return this.payload;
    }

    /* renamed from: component3, reason: from getter */
    public final long getPreparedAtMillis() {
        return this.preparedAtMillis;
    }

    public final PendingBillingPromptRecord copy(int campaignVersion, String payload, long preparedAtMillis) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        return new PendingBillingPromptRecord(campaignVersion, payload, preparedAtMillis);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PendingBillingPromptRecord)) {
            return false;
        }
        PendingBillingPromptRecord pendingBillingPromptRecord = (PendingBillingPromptRecord) other;
        return this.campaignVersion == pendingBillingPromptRecord.campaignVersion && Intrinsics.areEqual(this.payload, pendingBillingPromptRecord.payload) && this.preparedAtMillis == pendingBillingPromptRecord.preparedAtMillis;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.campaignVersion) * 31) + this.payload.hashCode()) * 31) + Long.hashCode(this.preparedAtMillis);
    }

    public String toString() {
        return "PendingBillingPromptRecord(campaignVersion=" + this.campaignVersion + ", payload=" + this.payload + ", preparedAtMillis=" + this.preparedAtMillis + ')';
    }

    public PendingBillingPromptRecord(int i, String payload, long j) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.campaignVersion = i;
        this.payload = payload;
        this.preparedAtMillis = j;
    }

    public final int getCampaignVersion() {
        return this.campaignVersion;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final long getPreparedAtMillis() {
        return this.preparedAtMillis;
    }
}

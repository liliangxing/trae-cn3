package com.bytedance.trae.conversation.prompt;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ManagedPromptLedger.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0080\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0015\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003JA\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\bHÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;", "", "lastShownAtMillis", "", "lastShownCampaignKey", "", "shownVersions", "", "", "pendingBilling", "Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;", "<init>", "(JLjava/lang/String;Ljava/util/Map;Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;)V", "getLastShownAtMillis", "()J", "getLastShownCampaignKey", "()Ljava/lang/String;", "getShownVersions", "()Ljava/util/Map;", "getPendingBilling", "()Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;", "hasShownAtLeast", "", "candidate", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class ManagedPromptLedgerState {
    private final long lastShownAtMillis;
    private final String lastShownCampaignKey;
    private final PendingBillingPromptRecord pendingBilling;
    private final Map<String, Integer> shownVersions;

    public ManagedPromptLedgerState() {
        this(0L, null, null, null, 15, null);
    }

    public static /* synthetic */ ManagedPromptLedgerState copy$default(ManagedPromptLedgerState managedPromptLedgerState, long j, String str, Map map, PendingBillingPromptRecord pendingBillingPromptRecord, int i, Object obj) {
        if ((i & 1) != 0) {
            j = managedPromptLedgerState.lastShownAtMillis;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = managedPromptLedgerState.lastShownCampaignKey;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            map = managedPromptLedgerState.shownVersions;
        }
        Map map2 = map;
        if ((i & 8) != 0) {
            pendingBillingPromptRecord = managedPromptLedgerState.pendingBilling;
        }
        return managedPromptLedgerState.copy(j2, str2, map2, pendingBillingPromptRecord);
    }

    /* renamed from: component1, reason: from getter */
    public final long getLastShownAtMillis() {
        return this.lastShownAtMillis;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLastShownCampaignKey() {
        return this.lastShownCampaignKey;
    }

    public final Map<String, Integer> component3() {
        return this.shownVersions;
    }

    /* renamed from: component4, reason: from getter */
    public final PendingBillingPromptRecord getPendingBilling() {
        return this.pendingBilling;
    }

    public final ManagedPromptLedgerState copy(long lastShownAtMillis, String lastShownCampaignKey, Map<String, Integer> shownVersions, PendingBillingPromptRecord pendingBilling) {
        Intrinsics.checkNotNullParameter(shownVersions, "shownVersions");
        return new ManagedPromptLedgerState(lastShownAtMillis, lastShownCampaignKey, shownVersions, pendingBilling);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ManagedPromptLedgerState)) {
            return false;
        }
        ManagedPromptLedgerState managedPromptLedgerState = (ManagedPromptLedgerState) other;
        return this.lastShownAtMillis == managedPromptLedgerState.lastShownAtMillis && Intrinsics.areEqual(this.lastShownCampaignKey, managedPromptLedgerState.lastShownCampaignKey) && Intrinsics.areEqual(this.shownVersions, managedPromptLedgerState.shownVersions) && Intrinsics.areEqual(this.pendingBilling, managedPromptLedgerState.pendingBilling);
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.lastShownAtMillis) * 31;
        String str = this.lastShownCampaignKey;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.shownVersions.hashCode()) * 31;
        PendingBillingPromptRecord pendingBillingPromptRecord = this.pendingBilling;
        return hashCode2 + (pendingBillingPromptRecord != null ? pendingBillingPromptRecord.hashCode() : 0);
    }

    public String toString() {
        return "ManagedPromptLedgerState(lastShownAtMillis=" + this.lastShownAtMillis + ", lastShownCampaignKey=" + this.lastShownCampaignKey + ", shownVersions=" + this.shownVersions + ", pendingBilling=" + this.pendingBilling + ')';
    }

    public ManagedPromptLedgerState(long j, String str, Map<String, Integer> map, PendingBillingPromptRecord pendingBillingPromptRecord) {
        Intrinsics.checkNotNullParameter(map, "shownVersions");
        this.lastShownAtMillis = j;
        this.lastShownCampaignKey = str;
        this.shownVersions = map;
        this.pendingBilling = pendingBillingPromptRecord;
    }

    public final long getLastShownAtMillis() {
        return this.lastShownAtMillis;
    }

    public final String getLastShownCampaignKey() {
        return this.lastShownCampaignKey;
    }

    public /* synthetic */ ManagedPromptLedgerState(long j, String str, Map map, PendingBillingPromptRecord pendingBillingPromptRecord, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? MapsKt.emptyMap() : map, (i & 8) != 0 ? null : pendingBillingPromptRecord);
    }

    public final Map<String, Integer> getShownVersions() {
        return this.shownVersions;
    }

    public final PendingBillingPromptRecord getPendingBilling() {
        return this.pendingBilling;
    }

    public final boolean hasShownAtLeast(ManagedPromptCandidate candidate) {
        Intrinsics.checkNotNullParameter(candidate, "candidate");
        Integer num = this.shownVersions.get(candidate.getCampaignId());
        return (num != null ? num.intValue() : 0) >= candidate.getCampaignVersion();
    }
}

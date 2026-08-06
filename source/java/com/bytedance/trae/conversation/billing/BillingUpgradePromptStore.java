package com.bytedance.trae.conversation.billing;

import com.bytedance.keva.Keva;
import com.bytedance.trae.conversation.prompt.ManagedPromptLedgerStore;
import com.bytedance.trae.conversation.prompt.PendingBillingPromptRecord;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BillingUpgradePromptStore.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptStore;", "", "<init>", "()V", "REPO_NAME", "", "hasShown", "", "userId", "markShown", "", "savePending", "promptData", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;", "loadPending", "clearPending", "clearAll", "repo", "Lcom/bytedance/keva/Keva;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BillingUpgradePromptStore {
    public static final BillingUpgradePromptStore INSTANCE = new BillingUpgradePromptStore();
    private static final String REPO_NAME = "trae_billing_upgrade_prompt";

    private BillingUpgradePromptStore() {
    }

    public final boolean hasShown(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        return repo().getBoolean(BillingUpgradePromptPolicy.INSTANCE.shownKey(userId), false) || ManagedPromptLedgerStore.INSTANCE.snapshot(userId).hasShownAtLeast(BillingUpgradePromptPolicy.INSTANCE.getManagedCandidate$conversation_mainlandRelease());
    }

    public final void markShown(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        ManagedPromptLedgerStore.recordShown$default(ManagedPromptLedgerStore.INSTANCE, userId, BillingUpgradePromptPolicy.INSTANCE.getManagedCandidate$conversation_mainlandRelease(), 0L, 4, null);
        repo().storeBoolean(BillingUpgradePromptPolicy.INSTANCE.shownKey(userId), true);
    }

    public final void savePending(String userId, BillingUpgradePromptData promptData) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(promptData, "promptData");
        ManagedPromptLedgerStore.INSTANCE.savePendingBilling(userId, new PendingBillingPromptRecord(2, promptData.getUserState().name(), System.currentTimeMillis()));
    }

    public final BillingUpgradePromptData loadPending(String userId) {
        Object obj;
        Intrinsics.checkNotNullParameter(userId, "userId");
        PendingBillingPromptRecord pendingBilling = ManagedPromptLedgerStore.INSTANCE.snapshot(userId).getPendingBilling();
        if (pendingBilling == null) {
            return null;
        }
        if (!(pendingBilling.getCampaignVersion() == 2)) {
            pendingBilling = null;
        }
        if (pendingBilling == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            BillingUpgradePromptStore billingUpgradePromptStore = this;
            obj = Result.constructor-impl(BillingUpgradeUserState.valueOf(pendingBilling.getPayload()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        BillingUpgradeUserState billingUpgradeUserState = (BillingUpgradeUserState) obj;
        if (billingUpgradeUserState == null) {
            return null;
        }
        return new BillingUpgradePromptData(billingUpgradeUserState);
    }

    public final void clearPending(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        ManagedPromptLedgerStore.INSTANCE.clearPendingBilling(userId, 2);
    }

    public final void clearAll() {
        repo().clear();
        ManagedPromptLedgerStore.INSTANCE.clearAllForDebug();
    }

    private final Keva repo() {
        Keva repo = Keva.getRepo(REPO_NAME);
        Intrinsics.checkNotNullExpressionValue(repo, "getRepo(...)");
        return repo;
    }
}

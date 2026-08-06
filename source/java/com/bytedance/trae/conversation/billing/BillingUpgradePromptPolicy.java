package com.bytedance.trae.conversation.billing;

import com.bytedance.trae.conversation.prompt.ManagedPromptCandidate;
import com.bytedance.trae.conversation.prompt.ManagedPromptType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BillingUpgradePromptPolicy.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptPolicy;", "", "<init>", "()V", "BILLING_VERSION_2", "", "CAMPAIGN_ID", "", "SHOWN_KEY_PREFIX", "managedCandidate", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;", "getManagedCandidate$conversation_mainlandRelease", "()Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;", "shouldShow", "", "alreadyShown", "classifyUserState", "Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;", "infinite", "remaining", "", "shownKey", "userId", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BillingUpgradePromptPolicy {
    public static final int BILLING_VERSION_2 = 2;
    private static final String SHOWN_KEY_PREFIX = "billing_upgrade_prompt_shown";
    public static final BillingUpgradePromptPolicy INSTANCE = new BillingUpgradePromptPolicy();
    private static final String CAMPAIGN_ID = "billing_upgrade";
    private static final ManagedPromptCandidate managedCandidate = new ManagedPromptCandidate(ManagedPromptType.BillingUpgrade, CAMPAIGN_ID, 2);

    public final boolean shouldShow(boolean alreadyShown) {
        return !alreadyShown;
    }

    private BillingUpgradePromptPolicy() {
    }

    public final ManagedPromptCandidate getManagedCandidate$conversation_mainlandRelease() {
        return managedCandidate;
    }

    public final BillingUpgradeUserState classifyUserState(boolean infinite, long remaining) {
        if (infinite) {
            return BillingUpgradeUserState.Express;
        }
        if (remaining > 0) {
            return BillingUpgradeUserState.HasFastRequests;
        }
        return BillingUpgradeUserState.NoFastRequests;
    }

    public final String shownKey(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        return "billing_upgrade_prompt_shown_" + userId + "_2";
    }
}

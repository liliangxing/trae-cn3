package com.bytedance.trae.conversation.prompt;

import com.bytedance.trae.conversation.prompt.ManagedPromptCandidateState;
import com.bytedance.trae.conversation.prompt.ManagedPromptDecision;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ManagedPromptArbitrationPolicy.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/prompt/ManagedPromptArbitrationPolicy;", "", "<init>", "()V", "GLOBAL_COOLDOWN_MILLIS", "", "decide", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision;", "nowMillis", "ledger", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;", "billing", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;", "guide", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ManagedPromptArbitrationPolicy {
    public static final long GLOBAL_COOLDOWN_MILLIS = 86400000;
    public static final ManagedPromptArbitrationPolicy INSTANCE = new ManagedPromptArbitrationPolicy();

    private ManagedPromptArbitrationPolicy() {
    }

    public final ManagedPromptDecision decide(long nowMillis, ManagedPromptLedgerState ledger, ManagedPromptCandidateState billing, ManagedPromptCandidateState guide) {
        Intrinsics.checkNotNullParameter(ledger, "ledger");
        Intrinsics.checkNotNullParameter(billing, "billing");
        Intrinsics.checkNotNullParameter(guide, "guide");
        long lastShownAtMillis = ledger.getLastShownAtMillis();
        if (lastShownAtMillis > 0 && nowMillis - lastShownAtMillis < 86400000) {
            return new ManagedPromptDecision.CoolingDown(lastShownAtMillis + 86400000);
        }
        if (Intrinsics.areEqual(billing, ManagedPromptCandidateState.Preparing.INSTANCE)) {
            return ManagedPromptDecision.WaitForBilling.INSTANCE;
        }
        if (billing instanceof ManagedPromptCandidateState.Eligible) {
            ManagedPromptCandidateState.Eligible eligible = (ManagedPromptCandidateState.Eligible) billing;
            if (!ledger.hasShownAtLeast(eligible.getCandidate())) {
                return new ManagedPromptDecision.Show(eligible.getCandidate());
            }
        } else if (!Intrinsics.areEqual(billing, ManagedPromptCandidateState.Ineligible.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        if (Intrinsics.areEqual(guide, ManagedPromptCandidateState.Preparing.INSTANCE)) {
            return ManagedPromptDecision.WaitForGuide.INSTANCE;
        }
        if (guide instanceof ManagedPromptCandidateState.Eligible) {
            ManagedPromptCandidateState.Eligible eligible2 = (ManagedPromptCandidateState.Eligible) guide;
            if (ledger.hasShownAtLeast(eligible2.getCandidate())) {
                return ManagedPromptDecision.NothingToShow.INSTANCE;
            }
            return new ManagedPromptDecision.Show(eligible2.getCandidate());
        }
        if (Intrinsics.areEqual(guide, ManagedPromptCandidateState.Ineligible.INSTANCE)) {
            return ManagedPromptDecision.NothingToShow.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }
}

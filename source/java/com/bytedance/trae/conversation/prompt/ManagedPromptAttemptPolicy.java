package com.bytedance.trae.conversation.prompt;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ManagedPromptArbitrationPolicy.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/prompt/ManagedPromptAttemptPolicy;", "", "<init>", "()V", "afterAttempt", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptRoundAction;", "candidate", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;", "outcome", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ManagedPromptAttemptPolicy {
    public static final ManagedPromptAttemptPolicy INSTANCE = new ManagedPromptAttemptPolicy();

    /* compiled from: ManagedPromptArbitrationPolicy.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ManagedPromptDisplayOutcome.values().length];
            try {
                iArr[ManagedPromptDisplayOutcome.Shown.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ManagedPromptDisplayOutcome.TemporarilyBlocked.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ManagedPromptDisplayOutcome.NotShown.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ManagedPromptAttemptPolicy() {
    }

    public final ManagedPromptRoundAction afterAttempt(ManagedPromptCandidate candidate, ManagedPromptDisplayOutcome outcome) {
        Intrinsics.checkNotNullParameter(candidate, "candidate");
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        int i = WhenMappings.$EnumSwitchMapping$0[outcome.ordinal()];
        if (i == 1) {
            return ManagedPromptRoundAction.Complete;
        }
        if (i == 2) {
            return ManagedPromptRoundAction.Retry;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        if (candidate.getType() == ManagedPromptType.BillingUpgrade) {
            return ManagedPromptRoundAction.ContinueToLowerPriority;
        }
        return ManagedPromptRoundAction.Complete;
    }
}

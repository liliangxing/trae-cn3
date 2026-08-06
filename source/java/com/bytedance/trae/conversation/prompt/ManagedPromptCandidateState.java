package com.bytedance.trae.conversation.prompt;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ManagedPromptArbitrationPolicy.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;", "", "<init>", "()V", "Preparing", "Ineligible", "Eligible", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Eligible;", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Ineligible;", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Preparing;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ManagedPromptCandidateState {
    public /* synthetic */ ManagedPromptCandidateState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: ManagedPromptArbitrationPolicy.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Preparing;", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Preparing extends ManagedPromptCandidateState {
        public static final Preparing INSTANCE = new Preparing();

        private Preparing() {
            super(null);
        }
    }

    private ManagedPromptCandidateState() {
    }

    /* compiled from: ManagedPromptArbitrationPolicy.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Ineligible;", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Ineligible extends ManagedPromptCandidateState {
        public static final Ineligible INSTANCE = new Ineligible();

        private Ineligible() {
            super(null);
        }
    }

    /* compiled from: ManagedPromptArbitrationPolicy.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Eligible;", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;", "candidate", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;", "<init>", "(Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;)V", "getCandidate", "()Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Eligible extends ManagedPromptCandidateState {
        private final ManagedPromptCandidate candidate;

        public static /* synthetic */ Eligible copy$default(Eligible eligible, ManagedPromptCandidate managedPromptCandidate, int i, Object obj) {
            if ((i & 1) != 0) {
                managedPromptCandidate = eligible.candidate;
            }
            return eligible.copy(managedPromptCandidate);
        }

        /* renamed from: component1, reason: from getter */
        public final ManagedPromptCandidate getCandidate() {
            return this.candidate;
        }

        public final Eligible copy(ManagedPromptCandidate candidate) {
            Intrinsics.checkNotNullParameter(candidate, "candidate");
            return new Eligible(candidate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Eligible) && Intrinsics.areEqual(this.candidate, ((Eligible) other).candidate);
        }

        public int hashCode() {
            return this.candidate.hashCode();
        }

        public String toString() {
            return "Eligible(candidate=" + this.candidate + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Eligible(ManagedPromptCandidate candidate) {
            super(null);
            Intrinsics.checkNotNullParameter(candidate, "candidate");
            this.candidate = candidate;
        }

        public final ManagedPromptCandidate getCandidate() {
            return this.candidate;
        }
    }
}

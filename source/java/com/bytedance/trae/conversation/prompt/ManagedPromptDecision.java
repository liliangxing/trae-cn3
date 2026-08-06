package com.bytedance.trae.conversation.prompt;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.push.interfaze.IPushService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ManagedPromptArbitrationPolicy.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision;", "", "<init>", "()V", "WaitForBilling", "WaitForGuide", "CoolingDown", IPushService.TAG_PUSH_SHOW, "NothingToShow", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$CoolingDown;", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$NothingToShow;", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$Show;", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$WaitForBilling;", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$WaitForGuide;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ManagedPromptDecision {
    public /* synthetic */ ManagedPromptDecision(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: ManagedPromptArbitrationPolicy.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$WaitForBilling;", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class WaitForBilling extends ManagedPromptDecision {
        public static final WaitForBilling INSTANCE = new WaitForBilling();

        private WaitForBilling() {
            super(null);
        }
    }

    private ManagedPromptDecision() {
    }

    /* compiled from: ManagedPromptArbitrationPolicy.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$WaitForGuide;", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class WaitForGuide extends ManagedPromptDecision {
        public static final WaitForGuide INSTANCE = new WaitForGuide();

        private WaitForGuide() {
            super(null);
        }
    }

    /* compiled from: ManagedPromptArbitrationPolicy.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$CoolingDown;", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision;", "nextEligibleAtMillis", "", "<init>", "(J)V", "getNextEligibleAtMillis", "()J", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class CoolingDown extends ManagedPromptDecision {
        private final long nextEligibleAtMillis;

        public static /* synthetic */ CoolingDown copy$default(CoolingDown coolingDown, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = coolingDown.nextEligibleAtMillis;
            }
            return coolingDown.copy(j);
        }

        /* renamed from: component1, reason: from getter */
        public final long getNextEligibleAtMillis() {
            return this.nextEligibleAtMillis;
        }

        public final CoolingDown copy(long nextEligibleAtMillis) {
            return new CoolingDown(nextEligibleAtMillis);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CoolingDown) && this.nextEligibleAtMillis == ((CoolingDown) other).nextEligibleAtMillis;
        }

        public int hashCode() {
            return Long.hashCode(this.nextEligibleAtMillis);
        }

        public String toString() {
            return "CoolingDown(nextEligibleAtMillis=" + this.nextEligibleAtMillis + ')';
        }

        public CoolingDown(long j) {
            super(null);
            this.nextEligibleAtMillis = j;
        }

        public final long getNextEligibleAtMillis() {
            return this.nextEligibleAtMillis;
        }
    }

    /* compiled from: ManagedPromptArbitrationPolicy.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$Show;", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision;", "candidate", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;", "<init>", "(Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;)V", "getCandidate", "()Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Show extends ManagedPromptDecision {
        private final ManagedPromptCandidate candidate;

        public static /* synthetic */ Show copy$default(Show show, ManagedPromptCandidate managedPromptCandidate, int i, Object obj) {
            if ((i & 1) != 0) {
                managedPromptCandidate = show.candidate;
            }
            return show.copy(managedPromptCandidate);
        }

        /* renamed from: component1, reason: from getter */
        public final ManagedPromptCandidate getCandidate() {
            return this.candidate;
        }

        public final Show copy(ManagedPromptCandidate candidate) {
            Intrinsics.checkNotNullParameter(candidate, "candidate");
            return new Show(candidate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Show) && Intrinsics.areEqual(this.candidate, ((Show) other).candidate);
        }

        public int hashCode() {
            return this.candidate.hashCode();
        }

        public String toString() {
            return "Show(candidate=" + this.candidate + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Show(ManagedPromptCandidate candidate) {
            super(null);
            Intrinsics.checkNotNullParameter(candidate, "candidate");
            this.candidate = candidate;
        }

        public final ManagedPromptCandidate getCandidate() {
            return this.candidate;
        }
    }

    /* compiled from: ManagedPromptArbitrationPolicy.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$NothingToShow;", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class NothingToShow extends ManagedPromptDecision {
        public static final NothingToShow INSTANCE = new NothingToShow();

        private NothingToShow() {
            super(null);
        }
    }
}

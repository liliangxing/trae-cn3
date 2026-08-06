package com.bytedance.trae.conversation.billing;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BillingUpgradePromptEngine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState;", "", "<init>", "()V", "Preparing", "Ineligible", "Eligible", "Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState$Eligible;", "Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState$Ineligible;", "Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState$Preparing;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BillingUpgradeCandidateState {
    public /* synthetic */ BillingUpgradeCandidateState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: BillingUpgradePromptEngine.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState$Preparing;", "Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Preparing extends BillingUpgradeCandidateState {
        public static final Preparing INSTANCE = new Preparing();

        private Preparing() {
            super(null);
        }
    }

    private BillingUpgradeCandidateState() {
    }

    /* compiled from: BillingUpgradePromptEngine.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState$Ineligible;", "Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Ineligible extends BillingUpgradeCandidateState {
        public static final Ineligible INSTANCE = new Ineligible();

        private Ineligible() {
            super(null);
        }
    }

    /* compiled from: BillingUpgradePromptEngine.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState$Eligible;", "Lcom/bytedance/trae/conversation/billing/BillingUpgradeCandidateState;", "promptData", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;", "<init>", "(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)V", "getPromptData", "()Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Eligible extends BillingUpgradeCandidateState {
        private final BillingUpgradePromptData promptData;

        public static /* synthetic */ Eligible copy$default(Eligible eligible, BillingUpgradePromptData billingUpgradePromptData, int i, Object obj) {
            if ((i & 1) != 0) {
                billingUpgradePromptData = eligible.promptData;
            }
            return eligible.copy(billingUpgradePromptData);
        }

        /* renamed from: component1, reason: from getter */
        public final BillingUpgradePromptData getPromptData() {
            return this.promptData;
        }

        public final Eligible copy(BillingUpgradePromptData promptData) {
            Intrinsics.checkNotNullParameter(promptData, "promptData");
            return new Eligible(promptData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Eligible) && Intrinsics.areEqual(this.promptData, ((Eligible) other).promptData);
        }

        public int hashCode() {
            return this.promptData.hashCode();
        }

        public String toString() {
            return "Eligible(promptData=" + this.promptData + ')';
        }

        public final BillingUpgradePromptData getPromptData() {
            return this.promptData;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Eligible(BillingUpgradePromptData promptData) {
            super(null);
            Intrinsics.checkNotNullParameter(promptData, "promptData");
            this.promptData = promptData;
        }
    }
}

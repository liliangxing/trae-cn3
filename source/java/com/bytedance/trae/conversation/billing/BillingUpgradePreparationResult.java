package com.bytedance.trae.conversation.billing;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BillingUpgradePreparation.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;", "", "PromptReady", "SwitchAcceptedSilently", "AlreadyUpgraded", "StaleAccount", "RetryableFailure", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$AlreadyUpgraded;", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$PromptReady;", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$StaleAccount;", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$SwitchAcceptedSilently;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface BillingUpgradePreparationResult {

    /* compiled from: BillingUpgradePreparation.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$PromptReady;", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;", "promptData", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;", "<init>", "(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)V", "getPromptData", "()Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class PromptReady implements BillingUpgradePreparationResult {
        private final BillingUpgradePromptData promptData;

        public static /* synthetic */ PromptReady copy$default(PromptReady promptReady, BillingUpgradePromptData billingUpgradePromptData, int i, Object obj) {
            if ((i & 1) != 0) {
                billingUpgradePromptData = promptReady.promptData;
            }
            return promptReady.copy(billingUpgradePromptData);
        }

        /* renamed from: component1, reason: from getter */
        public final BillingUpgradePromptData getPromptData() {
            return this.promptData;
        }

        public final PromptReady copy(BillingUpgradePromptData promptData) {
            Intrinsics.checkNotNullParameter(promptData, "promptData");
            return new PromptReady(promptData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PromptReady) && Intrinsics.areEqual(this.promptData, ((PromptReady) other).promptData);
        }

        public int hashCode() {
            return this.promptData.hashCode();
        }

        public String toString() {
            return "PromptReady(promptData=" + this.promptData + ')';
        }

        public PromptReady(BillingUpgradePromptData promptData) {
            Intrinsics.checkNotNullParameter(promptData, "promptData");
            this.promptData = promptData;
        }

        public final BillingUpgradePromptData getPromptData() {
            return this.promptData;
        }
    }

    /* compiled from: BillingUpgradePreparation.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$SwitchAcceptedSilently;", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class SwitchAcceptedSilently implements BillingUpgradePreparationResult {
        public static final SwitchAcceptedSilently INSTANCE = new SwitchAcceptedSilently();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SwitchAcceptedSilently)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1158265882;
        }

        public String toString() {
            return "SwitchAcceptedSilently";
        }

        private SwitchAcceptedSilently() {
        }
    }

    /* compiled from: BillingUpgradePreparation.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$AlreadyUpgraded;", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class AlreadyUpgraded implements BillingUpgradePreparationResult {
        public static final AlreadyUpgraded INSTANCE = new AlreadyUpgraded();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AlreadyUpgraded)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -437655165;
        }

        public String toString() {
            return "AlreadyUpgraded";
        }

        private AlreadyUpgraded() {
        }
    }

    /* compiled from: BillingUpgradePreparation.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$StaleAccount;", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class StaleAccount implements BillingUpgradePreparationResult {
        public static final StaleAccount INSTANCE = new StaleAccount();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StaleAccount)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1003768817;
        }

        public String toString() {
            return "StaleAccount";
        }

        private StaleAccount() {
        }
    }

    /* compiled from: BillingUpgradePreparation.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class RetryableFailure implements BillingUpgradePreparationResult {
        public static final RetryableFailure INSTANCE = new RetryableFailure();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RetryableFailure)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 839115845;
        }

        public String toString() {
            return "RetryableFailure";
        }

        private RetryableFailure() {
        }
    }
}

package com.bytedance.trae.conversation.billing;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;

/* compiled from: BillingUpgradePreparation.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult;", "", "Success", "RetryableFailure", "Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult$RetryableFailure;", "Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult$Success;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface BillingVersionSwitchResult {

    /* compiled from: BillingUpgradePreparation.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult$Success;", "Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Success implements BillingVersionSwitchResult {
        public static final Success INSTANCE = new Success();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1963437755;
        }

        public String toString() {
            return "Success";
        }

        private Success() {
        }
    }

    /* compiled from: BillingUpgradePreparation.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult$RetryableFailure;", "Lcom/bytedance/trae/conversation/billing/BillingVersionSwitchResult;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class RetryableFailure implements BillingVersionSwitchResult {
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
            return 1859368998;
        }

        public String toString() {
            return "RetryableFailure";
        }

        private RetryableFailure() {
        }
    }
}

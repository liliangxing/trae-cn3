package com.bytedance.trae.conversation.billing;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;

/* compiled from: BillingUpgradePreparation.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult;", "", "Success", "RetryableFailure", "Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$RetryableFailure;", "Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$Success;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface CreditsBillingStatusResult {

    /* compiled from: BillingUpgradePreparation.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$Success;", "Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult;", "isCreditsBilling", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Success implements CreditsBillingStatusResult {
        private final boolean isCreditsBilling;

        public static /* synthetic */ Success copy$default(Success success, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = success.isCreditsBilling;
            }
            return success.copy(z);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsCreditsBilling() {
            return this.isCreditsBilling;
        }

        public final Success copy(boolean isCreditsBilling) {
            return new Success(isCreditsBilling);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && this.isCreditsBilling == ((Success) other).isCreditsBilling;
        }

        public int hashCode() {
            return Boolean.hashCode(this.isCreditsBilling);
        }

        public String toString() {
            return "Success(isCreditsBilling=" + this.isCreditsBilling + ')';
        }

        public Success(boolean z) {
            this.isCreditsBilling = z;
        }

        public final boolean isCreditsBilling() {
            return this.isCreditsBilling;
        }
    }

    /* compiled from: BillingUpgradePreparation.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult$RetryableFailure;", "Lcom/bytedance/trae/conversation/billing/CreditsBillingStatusResult;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class RetryableFailure implements CreditsBillingStatusResult {
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
            return 1221081476;
        }

        public String toString() {
            return "RetryableFailure";
        }

        private RetryableFailure() {
        }
    }
}

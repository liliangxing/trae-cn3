package com.bytedance.trae.conversation.billing;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BillingUpgradePreparation.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult;", "", "Success", "RetryableFailure", "Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$RetryableFailure;", "Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$Success;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface BillingUpgradeUserStateResult {

    /* compiled from: BillingUpgradePreparation.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$Success;", "Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult;", "userState", "Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;", "<init>", "(Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;)V", "getUserState", "()Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Success implements BillingUpgradeUserStateResult {
        private final BillingUpgradeUserState userState;

        public static /* synthetic */ Success copy$default(Success success, BillingUpgradeUserState billingUpgradeUserState, int i, Object obj) {
            if ((i & 1) != 0) {
                billingUpgradeUserState = success.userState;
            }
            return success.copy(billingUpgradeUserState);
        }

        /* renamed from: component1, reason: from getter */
        public final BillingUpgradeUserState getUserState() {
            return this.userState;
        }

        public final Success copy(BillingUpgradeUserState userState) {
            Intrinsics.checkNotNullParameter(userState, "userState");
            return new Success(userState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && this.userState == ((Success) other).userState;
        }

        public int hashCode() {
            return this.userState.hashCode();
        }

        public String toString() {
            return "Success(userState=" + this.userState + ')';
        }

        public Success(BillingUpgradeUserState userState) {
            Intrinsics.checkNotNullParameter(userState, "userState");
            this.userState = userState;
        }

        public final BillingUpgradeUserState getUserState() {
            return this.userState;
        }
    }

    /* compiled from: BillingUpgradePreparation.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult$RetryableFailure;", "Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserStateResult;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class RetryableFailure implements BillingUpgradeUserStateResult {
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
            return -1180140746;
        }

        public String toString() {
            return "RetryableFailure";
        }

        private RetryableFailure() {
        }
    }
}

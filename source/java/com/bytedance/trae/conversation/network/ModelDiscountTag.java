package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModelPricingPolicy.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/network/ModelDiscountTag;", "", "Member", "Exclusive", "Lcom/bytedance/trae/conversation/network/ModelDiscountTag$Exclusive;", "Lcom/bytedance/trae/conversation/network/ModelDiscountTag$Member;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ModelDiscountTag {

    /* compiled from: ModelPricingPolicy.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/network/ModelDiscountTag$Member;", "Lcom/bytedance/trae/conversation/network/ModelDiscountTag;", "discountFactor", "", "offPercent", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDiscountFactor", "()Ljava/lang/String;", "getOffPercent", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Member implements ModelDiscountTag {
        private final String discountFactor;
        private final String offPercent;

        public static /* synthetic */ Member copy$default(Member member, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = member.discountFactor;
            }
            if ((i & 2) != 0) {
                str2 = member.offPercent;
            }
            return member.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getDiscountFactor() {
            return this.discountFactor;
        }

        /* renamed from: component2, reason: from getter */
        public final String getOffPercent() {
            return this.offPercent;
        }

        public final Member copy(String discountFactor, String offPercent) {
            Intrinsics.checkNotNullParameter(discountFactor, "discountFactor");
            Intrinsics.checkNotNullParameter(offPercent, "offPercent");
            return new Member(discountFactor, offPercent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Member)) {
                return false;
            }
            Member member = (Member) other;
            return Intrinsics.areEqual(this.discountFactor, member.discountFactor) && Intrinsics.areEqual(this.offPercent, member.offPercent);
        }

        public int hashCode() {
            return (this.discountFactor.hashCode() * 31) + this.offPercent.hashCode();
        }

        public String toString() {
            return "Member(discountFactor=" + this.discountFactor + ", offPercent=" + this.offPercent + ')';
        }

        public Member(String discountFactor, String offPercent) {
            Intrinsics.checkNotNullParameter(discountFactor, "discountFactor");
            Intrinsics.checkNotNullParameter(offPercent, "offPercent");
            this.discountFactor = discountFactor;
            this.offPercent = offPercent;
        }

        public final String getDiscountFactor() {
            return this.discountFactor;
        }

        public final String getOffPercent() {
            return this.offPercent;
        }
    }

    /* compiled from: ModelPricingPolicy.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/network/ModelDiscountTag$Exclusive;", "Lcom/bytedance/trae/conversation/network/ModelDiscountTag;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Exclusive implements ModelDiscountTag {
        public static final Exclusive INSTANCE = new Exclusive();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Exclusive)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1765891953;
        }

        public String toString() {
            return "Exclusive";
        }

        private Exclusive() {
        }
    }
}

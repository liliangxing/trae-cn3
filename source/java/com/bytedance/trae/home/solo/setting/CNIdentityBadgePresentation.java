package com.bytedance.trae.home.solo.setting;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CNIdentityBadgePresentation.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u0000 \u00072\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0005¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/CNIdentityBadgePresentation;", "", "<init>", "()V", "Hidden", "Free", "Tier", "Companion", "Lcom/bytedance/trae/home/solo/setting/CNIdentityBadgePresentation$Free;", "Lcom/bytedance/trae/home/solo/setting/CNIdentityBadgePresentation$Hidden;", "Lcom/bytedance/trae/home/solo/setting/CNIdentityBadgePresentation$Tier;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class CNIdentityBadgePresentation {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ CNIdentityBadgePresentation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CNIdentityBadgePresentation() {
    }

    /* compiled from: CNIdentityBadgePresentation.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/CNIdentityBadgePresentation$Hidden;", "Lcom/bytedance/trae/home/solo/setting/CNIdentityBadgePresentation;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Hidden extends CNIdentityBadgePresentation {
        public static final int $stable = 0;
        public static final Hidden INSTANCE = new Hidden();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Hidden)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -386554754;
        }

        public String toString() {
            return "Hidden";
        }

        private Hidden() {
            super(null);
        }
    }

    /* compiled from: CNIdentityBadgePresentation.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/CNIdentityBadgePresentation$Free;", "Lcom/bytedance/trae/home/solo/setting/CNIdentityBadgePresentation;", "label", "", "<init>", "(Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Free extends CNIdentityBadgePresentation {
        public static final int $stable = 0;
        private final String label;

        public static /* synthetic */ Free copy$default(Free free, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = free.label;
            }
            return free.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        public final Free copy(String label) {
            Intrinsics.checkNotNullParameter(label, "label");
            return new Free(label);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Free) && Intrinsics.areEqual(this.label, ((Free) other).label);
        }

        public int hashCode() {
            return this.label.hashCode();
        }

        public String toString() {
            return "Free(label=" + this.label + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Free(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "label");
            this.label = str;
        }

        public final String getLabel() {
            return this.label;
        }
    }

    /* compiled from: CNIdentityBadgePresentation.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/CNIdentityBadgePresentation$Tier;", "Lcom/bytedance/trae/home/solo/setting/CNIdentityBadgePresentation;", "label", "", "<init>", "(Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Tier extends CNIdentityBadgePresentation {
        public static final int $stable = 0;
        private final String label;

        public static /* synthetic */ Tier copy$default(Tier tier, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tier.label;
            }
            return tier.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        public final Tier copy(String label) {
            Intrinsics.checkNotNullParameter(label, "label");
            return new Tier(label);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Tier) && Intrinsics.areEqual(this.label, ((Tier) other).label);
        }

        public int hashCode() {
            return this.label.hashCode();
        }

        public String toString() {
            return "Tier(label=" + this.label + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Tier(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "label");
            this.label = str;
        }

        public final String getLabel() {
            return this.label;
        }
    }

    /* compiled from: CNIdentityBadgePresentation.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/CNIdentityBadgePresentation$Companion;", "", "<init>", "()V", "from", "Lcom/bytedance/trae/home/solo/setting/CNIdentityBadgePresentation;", "payStatus", "Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;", "canRenderForUser", "", "requestUserId", "", "currentUserId", "featureEnabled", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CNIdentityBadgePresentation from(CNUserPayStatusData payStatus) {
            String userPayIdentityStr;
            String obj;
            if (payStatus != null && (userPayIdentityStr = payStatus.getUserPayIdentityStr()) != null && (obj = StringsKt.trim(userPayIdentityStr).toString()) != null) {
                if (!(obj.length() > 0)) {
                    obj = null;
                }
                if (obj != null) {
                    Integer userPayIdentity = payStatus.getUserPayIdentity();
                    int value = CNUserPayIdentity.FREE.getValue();
                    if (userPayIdentity != null && userPayIdentity.intValue() == value) {
                        return new Free(obj);
                    }
                    return new Tier(obj);
                }
            }
            return Hidden.INSTANCE;
        }

        public final boolean canRenderForUser(String requestUserId, String currentUserId, boolean featureEnabled) {
            Intrinsics.checkNotNullParameter(requestUserId, "requestUserId");
            Intrinsics.checkNotNullParameter(currentUserId, "currentUserId");
            if (featureEnabled) {
                return (requestUserId.length() > 0) && Intrinsics.areEqual(currentUserId, requestUserId);
            }
            return false;
        }
    }
}

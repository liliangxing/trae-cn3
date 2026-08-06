package com.bytedance.trae.home.solo.setting.data.model;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayIdentity.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\r\u001a\u00020\u000eH×\u0001J\t\u0010\u000f\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/model/PayIdentity;", "", "badgeText", "", "<init>", "(Ljava/lang/String;)V", "getBadgeText", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PayIdentity {
    public static final int $stable = 0;
    private final String badgeText;

    public static /* synthetic */ PayIdentity copy$default(PayIdentity payIdentity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payIdentity.badgeText;
        }
        return payIdentity.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getBadgeText() {
        return this.badgeText;
    }

    public final PayIdentity copy(String badgeText) {
        Intrinsics.checkNotNullParameter(badgeText, "badgeText");
        return new PayIdentity(badgeText);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PayIdentity) && Intrinsics.areEqual(this.badgeText, ((PayIdentity) other).badgeText);
    }

    public int hashCode() {
        return this.badgeText.hashCode();
    }

    public String toString() {
        return "PayIdentity(badgeText=" + this.badgeText + ')';
    }

    public PayIdentity(String badgeText) {
        Intrinsics.checkNotNullParameter(badgeText, "badgeText");
        this.badgeText = badgeText;
    }

    public final String getBadgeText() {
        return this.badgeText;
    }
}

package com.bytedance.trae.home.solo.setting;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.home.solo.setting.CNUserPayIdentity;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CNUserPagStatusApi.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J0\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÇ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001c\u001a\u00020\u0003H×\u0001J\t\u0010\u001d\u001a\u00020\u0005H×\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;", "", "userPayIdentity", "", "userPayIdentityStr", "", "isCreditsBilling", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Z)V", "getUserPayIdentity", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUserPayIdentityStr", "()Ljava/lang/String;", "()Z", "identity", "Lcom/bytedance/trae/home/solo/setting/CNUserPayIdentity;", "getIdentity", "()Lcom/bytedance/trae/home/solo/setting/CNUserPayIdentity;", "isPaidUser", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Z)Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CNUserPayStatusData {
    public static final int $stable = 0;

    @SerializedName("is_credits_billing")
    private final boolean isCreditsBilling;

    @SerializedName("user_pay_identity")
    private final Integer userPayIdentity;

    @SerializedName("user_pay_identity_str")
    private final String userPayIdentityStr;

    public CNUserPayStatusData() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ CNUserPayStatusData copy$default(CNUserPayStatusData cNUserPayStatusData, Integer num, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            num = cNUserPayStatusData.userPayIdentity;
        }
        if ((i & 2) != 0) {
            str = cNUserPayStatusData.userPayIdentityStr;
        }
        if ((i & 4) != 0) {
            z = cNUserPayStatusData.isCreditsBilling;
        }
        return cNUserPayStatusData.copy(num, str, z);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getUserPayIdentity() {
        return this.userPayIdentity;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUserPayIdentityStr() {
        return this.userPayIdentityStr;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsCreditsBilling() {
        return this.isCreditsBilling;
    }

    public final CNUserPayStatusData copy(Integer userPayIdentity, String userPayIdentityStr, boolean isCreditsBilling) {
        return new CNUserPayStatusData(userPayIdentity, userPayIdentityStr, isCreditsBilling);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CNUserPayStatusData)) {
            return false;
        }
        CNUserPayStatusData cNUserPayStatusData = (CNUserPayStatusData) other;
        return Intrinsics.areEqual(this.userPayIdentity, cNUserPayStatusData.userPayIdentity) && Intrinsics.areEqual(this.userPayIdentityStr, cNUserPayStatusData.userPayIdentityStr) && this.isCreditsBilling == cNUserPayStatusData.isCreditsBilling;
    }

    public int hashCode() {
        Integer num = this.userPayIdentity;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.userPayIdentityStr;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.isCreditsBilling);
    }

    public String toString() {
        return "CNUserPayStatusData(userPayIdentity=" + this.userPayIdentity + ", userPayIdentityStr=" + this.userPayIdentityStr + ", isCreditsBilling=" + this.isCreditsBilling + ')';
    }

    public CNUserPayStatusData(Integer num, String str, boolean z) {
        this.userPayIdentity = num;
        this.userPayIdentityStr = str;
        this.isCreditsBilling = z;
    }

    public /* synthetic */ CNUserPayStatusData(Integer num, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z);
    }

    public final Integer getUserPayIdentity() {
        return this.userPayIdentity;
    }

    public final String getUserPayIdentityStr() {
        return this.userPayIdentityStr;
    }

    public final boolean isCreditsBilling() {
        return this.isCreditsBilling;
    }

    public final CNUserPayIdentity getIdentity() {
        CNUserPayIdentity.Companion companion = CNUserPayIdentity.INSTANCE;
        Integer num = this.userPayIdentity;
        return companion.fromValue(num != null ? num.intValue() : 0);
    }

    public final boolean isPaidUser() {
        Integer num = this.userPayIdentity;
        return (num != null ? num.intValue() : 0) > 0;
    }
}

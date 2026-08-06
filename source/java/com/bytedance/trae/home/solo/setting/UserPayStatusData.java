package com.bytedance.trae.home.solo.setting;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.home.solo.setting.UserPayIdentity;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserPayStatusApi.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÇ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001a\u001a\u00020\u0003H×\u0001J\t\u0010\u001b\u001a\u00020\u0005H×\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;", "", "userPayIdentity", "", "userPayIdentityStr", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getUserPayIdentity", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUserPayIdentityStr", "()Ljava/lang/String;", "identity", "Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;", "getIdentity", "()Lcom/bytedance/trae/home/solo/setting/UserPayIdentity;", "isPaidUser", "", "()Z", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UserPayStatusData {
    public static final int $stable = 0;

    @SerializedName("user_pay_identity")
    private final Integer userPayIdentity;

    @SerializedName("user_pay_identity_str")
    private final String userPayIdentityStr;

    /* JADX WARN: Multi-variable type inference failed */
    public UserPayStatusData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ UserPayStatusData copy$default(UserPayStatusData userPayStatusData, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = userPayStatusData.userPayIdentity;
        }
        if ((i & 2) != 0) {
            str = userPayStatusData.userPayIdentityStr;
        }
        return userPayStatusData.copy(num, str);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getUserPayIdentity() {
        return this.userPayIdentity;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUserPayIdentityStr() {
        return this.userPayIdentityStr;
    }

    public final UserPayStatusData copy(Integer userPayIdentity, String userPayIdentityStr) {
        return new UserPayStatusData(userPayIdentity, userPayIdentityStr);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserPayStatusData)) {
            return false;
        }
        UserPayStatusData userPayStatusData = (UserPayStatusData) other;
        return Intrinsics.areEqual(this.userPayIdentity, userPayStatusData.userPayIdentity) && Intrinsics.areEqual(this.userPayIdentityStr, userPayStatusData.userPayIdentityStr);
    }

    public int hashCode() {
        Integer num = this.userPayIdentity;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.userPayIdentityStr;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "UserPayStatusData(userPayIdentity=" + this.userPayIdentity + ", userPayIdentityStr=" + this.userPayIdentityStr + ')';
    }

    public UserPayStatusData(Integer num, String str) {
        this.userPayIdentity = num;
        this.userPayIdentityStr = str;
    }

    public /* synthetic */ UserPayStatusData(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str);
    }

    public final Integer getUserPayIdentity() {
        return this.userPayIdentity;
    }

    public final String getUserPayIdentityStr() {
        return this.userPayIdentityStr;
    }

    public final UserPayIdentity getIdentity() {
        UserPayIdentity.Companion companion = UserPayIdentity.INSTANCE;
        Integer num = this.userPayIdentity;
        return companion.fromValue(num != null ? num.intValue() : 0);
    }

    public final boolean isPaidUser() {
        Integer num = this.userPayIdentity;
        return (num != null ? num.intValue() : 0) > 0;
    }
}

package com.bytedance.trae.login.enterprise;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterpriseAuthModels.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0004\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/login/enterprise/EnterpriseAccountLoginResult;", "", "userStatus", "", "isAllowLogin", "", "extra", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;)V", "getUserStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getExtra", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/trae/login/enterprise/EnterpriseAccountLoginResult;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EnterpriseAccountLoginResult {

    @SerializedName("Extra")
    private final String extra;

    @SerializedName("IsAllowLogin")
    private final Boolean isAllowLogin;

    @SerializedName("UserStatus")
    private final Integer userStatus;

    public EnterpriseAccountLoginResult() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ EnterpriseAccountLoginResult copy$default(EnterpriseAccountLoginResult enterpriseAccountLoginResult, Integer num, Boolean bool, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = enterpriseAccountLoginResult.userStatus;
        }
        if ((i & 2) != 0) {
            bool = enterpriseAccountLoginResult.isAllowLogin;
        }
        if ((i & 4) != 0) {
            str = enterpriseAccountLoginResult.extra;
        }
        return enterpriseAccountLoginResult.copy(num, bool, str);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getUserStatus() {
        return this.userStatus;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getIsAllowLogin() {
        return this.isAllowLogin;
    }

    /* renamed from: component3, reason: from getter */
    public final String getExtra() {
        return this.extra;
    }

    public final EnterpriseAccountLoginResult copy(Integer userStatus, Boolean isAllowLogin, String extra) {
        return new EnterpriseAccountLoginResult(userStatus, isAllowLogin, extra);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnterpriseAccountLoginResult)) {
            return false;
        }
        EnterpriseAccountLoginResult enterpriseAccountLoginResult = (EnterpriseAccountLoginResult) other;
        return Intrinsics.areEqual(this.userStatus, enterpriseAccountLoginResult.userStatus) && Intrinsics.areEqual(this.isAllowLogin, enterpriseAccountLoginResult.isAllowLogin) && Intrinsics.areEqual(this.extra, enterpriseAccountLoginResult.extra);
    }

    public int hashCode() {
        Integer num = this.userStatus;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Boolean bool = this.isAllowLogin;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.extra;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "EnterpriseAccountLoginResult(userStatus=" + this.userStatus + ", isAllowLogin=" + this.isAllowLogin + ", extra=" + this.extra + ')';
    }

    public EnterpriseAccountLoginResult(Integer num, Boolean bool, String str) {
        this.userStatus = num;
        this.isAllowLogin = bool;
        this.extra = str;
    }

    public /* synthetic */ EnterpriseAccountLoginResult(Integer num, Boolean bool, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : str);
    }

    public final Integer getUserStatus() {
        return this.userStatus;
    }

    public final Boolean isAllowLogin() {
        return this.isAllowLogin;
    }

    public final String getExtra() {
        return this.extra;
    }
}

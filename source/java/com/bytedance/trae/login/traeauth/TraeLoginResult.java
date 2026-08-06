package com.bytedance.trae.login.traeauth;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeAuthModels.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/login/traeauth/TraeLoginResult;", "", "firstLogin", "", "nickNameEditStatus", "", "ssoSuccess", "redirectUrl", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getFirstLogin", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNickNameEditStatus", "()Ljava/lang/String;", "getSsoSuccess", "getRedirectUrl", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/trae/login/traeauth/TraeLoginResult;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TraeLoginResult {

    @SerializedName("FirstLogin")
    private final Boolean firstLogin;

    @SerializedName("NickNameEditStatus")
    private final String nickNameEditStatus;

    @SerializedName("RedirectURL")
    private final String redirectUrl;

    @SerializedName("SSOSuccess")
    private final Boolean ssoSuccess;

    public TraeLoginResult() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ TraeLoginResult copy$default(TraeLoginResult traeLoginResult, Boolean bool, String str, Boolean bool2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = traeLoginResult.firstLogin;
        }
        if ((i & 2) != 0) {
            str = traeLoginResult.nickNameEditStatus;
        }
        if ((i & 4) != 0) {
            bool2 = traeLoginResult.ssoSuccess;
        }
        if ((i & 8) != 0) {
            str2 = traeLoginResult.redirectUrl;
        }
        return traeLoginResult.copy(bool, str, bool2, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getFirstLogin() {
        return this.firstLogin;
    }

    /* renamed from: component2, reason: from getter */
    public final String getNickNameEditStatus() {
        return this.nickNameEditStatus;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getSsoSuccess() {
        return this.ssoSuccess;
    }

    /* renamed from: component4, reason: from getter */
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    public final TraeLoginResult copy(Boolean firstLogin, String nickNameEditStatus, Boolean ssoSuccess, String redirectUrl) {
        return new TraeLoginResult(firstLogin, nickNameEditStatus, ssoSuccess, redirectUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TraeLoginResult)) {
            return false;
        }
        TraeLoginResult traeLoginResult = (TraeLoginResult) other;
        return Intrinsics.areEqual(this.firstLogin, traeLoginResult.firstLogin) && Intrinsics.areEqual(this.nickNameEditStatus, traeLoginResult.nickNameEditStatus) && Intrinsics.areEqual(this.ssoSuccess, traeLoginResult.ssoSuccess) && Intrinsics.areEqual(this.redirectUrl, traeLoginResult.redirectUrl);
    }

    public int hashCode() {
        Boolean bool = this.firstLogin;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.nickNameEditStatus;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool2 = this.ssoSuccess;
        int hashCode3 = (hashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str2 = this.redirectUrl;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "TraeLoginResult(firstLogin=" + this.firstLogin + ", nickNameEditStatus=" + this.nickNameEditStatus + ", ssoSuccess=" + this.ssoSuccess + ", redirectUrl=" + this.redirectUrl + ')';
    }

    public TraeLoginResult(Boolean bool, String str, Boolean bool2, String str2) {
        this.firstLogin = bool;
        this.nickNameEditStatus = str;
        this.ssoSuccess = bool2;
        this.redirectUrl = str2;
    }

    public /* synthetic */ TraeLoginResult(Boolean bool, String str, Boolean bool2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : str2);
    }

    public final Boolean getFirstLogin() {
        return this.firstLogin;
    }

    public final String getNickNameEditStatus() {
        return this.nickNameEditStatus;
    }

    public final Boolean getSsoSuccess() {
        return this.ssoSuccess;
    }

    public final String getRedirectUrl() {
        return this.redirectUrl;
    }
}

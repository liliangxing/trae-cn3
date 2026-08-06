package com.bytedance.trae.login.enterprise;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterpriseAuthModels.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\nR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;", "", "isEnableSso", "", "ssoAuthUrl", "", "isSsoLoginRequired", "isDefaultDomainLoginBlocked", "<init>", "(ZLjava/lang/String;ZZ)V", "()Z", "getSsoAuthUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CheckLoginConfigResult {

    @SerializedName("is_default_domain_login_blocked")
    private final boolean isDefaultDomainLoginBlocked;

    @SerializedName("is_enable_sso")
    private final boolean isEnableSso;

    @SerializedName("is_sso_login_required")
    private final boolean isSsoLoginRequired;

    @SerializedName("sso_auth_url")
    private final String ssoAuthUrl;

    public CheckLoginConfigResult() {
        this(false, null, false, false, 15, null);
    }

    public static /* synthetic */ CheckLoginConfigResult copy$default(CheckLoginConfigResult checkLoginConfigResult, boolean z, String str, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = checkLoginConfigResult.isEnableSso;
        }
        if ((i & 2) != 0) {
            str = checkLoginConfigResult.ssoAuthUrl;
        }
        if ((i & 4) != 0) {
            z2 = checkLoginConfigResult.isSsoLoginRequired;
        }
        if ((i & 8) != 0) {
            z3 = checkLoginConfigResult.isDefaultDomainLoginBlocked;
        }
        return checkLoginConfigResult.copy(z, str, z2, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsEnableSso() {
        return this.isEnableSso;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSsoAuthUrl() {
        return this.ssoAuthUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsSsoLoginRequired() {
        return this.isSsoLoginRequired;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsDefaultDomainLoginBlocked() {
        return this.isDefaultDomainLoginBlocked;
    }

    public final CheckLoginConfigResult copy(boolean isEnableSso, String ssoAuthUrl, boolean isSsoLoginRequired, boolean isDefaultDomainLoginBlocked) {
        return new CheckLoginConfigResult(isEnableSso, ssoAuthUrl, isSsoLoginRequired, isDefaultDomainLoginBlocked);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckLoginConfigResult)) {
            return false;
        }
        CheckLoginConfigResult checkLoginConfigResult = (CheckLoginConfigResult) other;
        return this.isEnableSso == checkLoginConfigResult.isEnableSso && Intrinsics.areEqual(this.ssoAuthUrl, checkLoginConfigResult.ssoAuthUrl) && this.isSsoLoginRequired == checkLoginConfigResult.isSsoLoginRequired && this.isDefaultDomainLoginBlocked == checkLoginConfigResult.isDefaultDomainLoginBlocked;
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.isEnableSso) * 31;
        String str = this.ssoAuthUrl;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isSsoLoginRequired)) * 31) + Boolean.hashCode(this.isDefaultDomainLoginBlocked);
    }

    public String toString() {
        return "CheckLoginConfigResult(isEnableSso=" + this.isEnableSso + ", ssoAuthUrl=" + this.ssoAuthUrl + ", isSsoLoginRequired=" + this.isSsoLoginRequired + ", isDefaultDomainLoginBlocked=" + this.isDefaultDomainLoginBlocked + ')';
    }

    public CheckLoginConfigResult(boolean z, String str, boolean z2, boolean z3) {
        this.isEnableSso = z;
        this.ssoAuthUrl = str;
        this.isSsoLoginRequired = z2;
        this.isDefaultDomainLoginBlocked = z3;
    }

    public /* synthetic */ CheckLoginConfigResult(boolean z, String str, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3);
    }

    public final boolean isEnableSso() {
        return this.isEnableSso;
    }

    public final String getSsoAuthUrl() {
        return this.ssoAuthUrl;
    }

    public final boolean isSsoLoginRequired() {
        return this.isSsoLoginRequired;
    }

    public final boolean isDefaultDomainLoginBlocked() {
        return this.isDefaultDomainLoginBlocked;
    }
}

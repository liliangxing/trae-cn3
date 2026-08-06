package com.bytedance.trae.login.enterprise;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterpriseAuthModels.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ>\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0006\u0010\u000fR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;", "", "userInfo", "Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo;", "tenantInfoBase", "Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;", "isAllowLogin", "", "privacyMode", "<init>", "(Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo;Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getUserInfo", "()Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo;", "getTenantInfoBase", "()Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPrivacyMode", "component1", "component2", "component3", "component4", "copy", "(Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo;Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EnterpriseGetUserInfoData {

    @SerializedName("IsAllowLogin")
    private final Boolean isAllowLogin;

    @SerializedName("PrivacyMode")
    private final Boolean privacyMode;

    @SerializedName("TenantInfoBase")
    private final EnterpriseTenantInfo tenantInfoBase;

    @SerializedName("UserInfo")
    private final EnterpriseUserInfo userInfo;

    public EnterpriseGetUserInfoData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ EnterpriseGetUserInfoData copy$default(EnterpriseGetUserInfoData enterpriseGetUserInfoData, EnterpriseUserInfo enterpriseUserInfo, EnterpriseTenantInfo enterpriseTenantInfo, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            enterpriseUserInfo = enterpriseGetUserInfoData.userInfo;
        }
        if ((i & 2) != 0) {
            enterpriseTenantInfo = enterpriseGetUserInfoData.tenantInfoBase;
        }
        if ((i & 4) != 0) {
            bool = enterpriseGetUserInfoData.isAllowLogin;
        }
        if ((i & 8) != 0) {
            bool2 = enterpriseGetUserInfoData.privacyMode;
        }
        return enterpriseGetUserInfoData.copy(enterpriseUserInfo, enterpriseTenantInfo, bool, bool2);
    }

    /* renamed from: component1, reason: from getter */
    public final EnterpriseUserInfo getUserInfo() {
        return this.userInfo;
    }

    /* renamed from: component2, reason: from getter */
    public final EnterpriseTenantInfo getTenantInfoBase() {
        return this.tenantInfoBase;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getIsAllowLogin() {
        return this.isAllowLogin;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getPrivacyMode() {
        return this.privacyMode;
    }

    public final EnterpriseGetUserInfoData copy(EnterpriseUserInfo userInfo, EnterpriseTenantInfo tenantInfoBase, Boolean isAllowLogin, Boolean privacyMode) {
        return new EnterpriseGetUserInfoData(userInfo, tenantInfoBase, isAllowLogin, privacyMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnterpriseGetUserInfoData)) {
            return false;
        }
        EnterpriseGetUserInfoData enterpriseGetUserInfoData = (EnterpriseGetUserInfoData) other;
        return Intrinsics.areEqual(this.userInfo, enterpriseGetUserInfoData.userInfo) && Intrinsics.areEqual(this.tenantInfoBase, enterpriseGetUserInfoData.tenantInfoBase) && Intrinsics.areEqual(this.isAllowLogin, enterpriseGetUserInfoData.isAllowLogin) && Intrinsics.areEqual(this.privacyMode, enterpriseGetUserInfoData.privacyMode);
    }

    public int hashCode() {
        EnterpriseUserInfo enterpriseUserInfo = this.userInfo;
        int hashCode = (enterpriseUserInfo == null ? 0 : enterpriseUserInfo.hashCode()) * 31;
        EnterpriseTenantInfo enterpriseTenantInfo = this.tenantInfoBase;
        int hashCode2 = (hashCode + (enterpriseTenantInfo == null ? 0 : enterpriseTenantInfo.hashCode())) * 31;
        Boolean bool = this.isAllowLogin;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.privacyMode;
        return hashCode3 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        return "EnterpriseGetUserInfoData(userInfo=" + this.userInfo + ", tenantInfoBase=" + this.tenantInfoBase + ", isAllowLogin=" + this.isAllowLogin + ", privacyMode=" + this.privacyMode + ')';
    }

    public EnterpriseGetUserInfoData(EnterpriseUserInfo enterpriseUserInfo, EnterpriseTenantInfo enterpriseTenantInfo, Boolean bool, Boolean bool2) {
        this.userInfo = enterpriseUserInfo;
        this.tenantInfoBase = enterpriseTenantInfo;
        this.isAllowLogin = bool;
        this.privacyMode = bool2;
    }

    public /* synthetic */ EnterpriseGetUserInfoData(EnterpriseUserInfo enterpriseUserInfo, EnterpriseTenantInfo enterpriseTenantInfo, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : enterpriseUserInfo, (i & 2) != 0 ? null : enterpriseTenantInfo, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : bool2);
    }

    public final EnterpriseUserInfo getUserInfo() {
        return this.userInfo;
    }

    public final EnterpriseTenantInfo getTenantInfoBase() {
        return this.tenantInfoBase;
    }

    public final Boolean isAllowLogin() {
        return this.isAllowLogin;
    }

    public final Boolean getPrivacyMode() {
        return this.privacyMode;
    }
}

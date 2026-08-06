package com.bytedance.trae.login.enterprise;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterpriseAuthModels.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\""}, d2 = {"Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo;", "", "userId", "", "name", "avatar", "email", "tenantId", "region", "aiRegion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getName", "getAvatar", "getEmail", "getTenantId", "getRegion", "getAiRegion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EnterpriseUserInfo {

    @SerializedName("AIRegion")
    private final String aiRegion;

    @SerializedName("Avatar")
    private final String avatar;

    @SerializedName("Email")
    private final String email;

    @SerializedName("Name")
    private final String name;

    @SerializedName("Region")
    private final String region;

    @SerializedName("TenantID")
    private final String tenantId;

    @SerializedName("UserID")
    private final String userId;

    public EnterpriseUserInfo() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ EnterpriseUserInfo copy$default(EnterpriseUserInfo enterpriseUserInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = enterpriseUserInfo.userId;
        }
        if ((i & 2) != 0) {
            str2 = enterpriseUserInfo.name;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = enterpriseUserInfo.avatar;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = enterpriseUserInfo.email;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = enterpriseUserInfo.tenantId;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = enterpriseUserInfo.region;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = enterpriseUserInfo.aiRegion;
        }
        return enterpriseUserInfo.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: component4, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTenantId() {
        return this.tenantId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getRegion() {
        return this.region;
    }

    /* renamed from: component7, reason: from getter */
    public final String getAiRegion() {
        return this.aiRegion;
    }

    public final EnterpriseUserInfo copy(String userId, String name, String avatar, String email, String tenantId, String region, String aiRegion) {
        return new EnterpriseUserInfo(userId, name, avatar, email, tenantId, region, aiRegion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnterpriseUserInfo)) {
            return false;
        }
        EnterpriseUserInfo enterpriseUserInfo = (EnterpriseUserInfo) other;
        return Intrinsics.areEqual(this.userId, enterpriseUserInfo.userId) && Intrinsics.areEqual(this.name, enterpriseUserInfo.name) && Intrinsics.areEqual(this.avatar, enterpriseUserInfo.avatar) && Intrinsics.areEqual(this.email, enterpriseUserInfo.email) && Intrinsics.areEqual(this.tenantId, enterpriseUserInfo.tenantId) && Intrinsics.areEqual(this.region, enterpriseUserInfo.region) && Intrinsics.areEqual(this.aiRegion, enterpriseUserInfo.aiRegion);
    }

    public int hashCode() {
        String str = this.userId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.avatar;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.email;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.tenantId;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.region;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.aiRegion;
        return hashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "EnterpriseUserInfo(userId=" + this.userId + ", name=" + this.name + ", avatar=" + this.avatar + ", email=" + this.email + ", tenantId=" + this.tenantId + ", region=" + this.region + ", aiRegion=" + this.aiRegion + ')';
    }

    public EnterpriseUserInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.userId = str;
        this.name = str2;
        this.avatar = str3;
        this.email = str4;
        this.tenantId = str5;
        this.region = str6;
        this.aiRegion = str7;
    }

    public /* synthetic */ EnterpriseUserInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7);
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getTenantId() {
        return this.tenantId;
    }

    public final String getRegion() {
        return this.region;
    }

    public final String getAiRegion() {
        return this.aiRegion;
    }
}

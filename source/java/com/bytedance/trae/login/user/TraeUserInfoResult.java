package com.bytedance.trae.login.user;

import androidx.autofill.HintConstants;
import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserInfoModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b*\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010'JÎ\u0001\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020\u00132\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020>HÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'¨\u0006@"}, d2 = {"Lcom/bytedance/trae/login/user/TraeUserInfoResult;", "", "screenName", "", HintConstants.AUTOFILL_HINT_GENDER, "avatarUrl", "userId", "description", "tenantId", "registerTime", "lastLoginTime", "lastLoginType", "auditInfo", "region", "aiRegion", "nonPlainTextEmail", "nonPlainTextMobile", "storeCountry", "migrateToSG", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getScreenName", "()Ljava/lang/String;", "getGender", "getAvatarUrl", "getUserId", "getDescription", "getTenantId", "getRegisterTime", "getLastLoginTime", "getLastLoginType", "getAuditInfo", "getRegion", "getAiRegion", "getNonPlainTextEmail", "getNonPlainTextMobile", "getStoreCountry", "getMigrateToSG", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/bytedance/trae/login/user/TraeUserInfoResult;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TraeUserInfoResult {

    @SerializedName("AIRegion")
    private final String aiRegion;

    @SerializedName("AuditInfo")
    private final String auditInfo;

    @SerializedName("AvatarUrl")
    private final String avatarUrl;

    @SerializedName("Description")
    private final String description;

    @SerializedName("Gender")
    private final String gender;

    @SerializedName("LastLoginTime")
    private final String lastLoginTime;

    @SerializedName("LastLoginType")
    private final String lastLoginType;

    @SerializedName("MigrateToSG")
    private final Boolean migrateToSG;

    @SerializedName("NonPlainTextEmail")
    private final String nonPlainTextEmail;

    @SerializedName("NonPlainTextMobile")
    private final String nonPlainTextMobile;

    @SerializedName("Region")
    private final String region;

    @SerializedName("RegisterTime")
    private final String registerTime;

    @SerializedName("ScreenName")
    private final String screenName;

    @SerializedName("StoreCountry")
    private final String storeCountry;

    @SerializedName("TenantID")
    private final String tenantId;

    @SerializedName("UserID")
    private final String userId;

    public TraeUserInfoResult() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getScreenName() {
        return this.screenName;
    }

    /* renamed from: component10, reason: from getter */
    public final String getAuditInfo() {
        return this.auditInfo;
    }

    /* renamed from: component11, reason: from getter */
    public final String getRegion() {
        return this.region;
    }

    /* renamed from: component12, reason: from getter */
    public final String getAiRegion() {
        return this.aiRegion;
    }

    /* renamed from: component13, reason: from getter */
    public final String getNonPlainTextEmail() {
        return this.nonPlainTextEmail;
    }

    /* renamed from: component14, reason: from getter */
    public final String getNonPlainTextMobile() {
        return this.nonPlainTextMobile;
    }

    /* renamed from: component15, reason: from getter */
    public final String getStoreCountry() {
        return this.storeCountry;
    }

    /* renamed from: component16, reason: from getter */
    public final Boolean getMigrateToSG() {
        return this.migrateToSG;
    }

    /* renamed from: component2, reason: from getter */
    public final String getGender() {
        return this.gender;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTenantId() {
        return this.tenantId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getRegisterTime() {
        return this.registerTime;
    }

    /* renamed from: component8, reason: from getter */
    public final String getLastLoginTime() {
        return this.lastLoginTime;
    }

    /* renamed from: component9, reason: from getter */
    public final String getLastLoginType() {
        return this.lastLoginType;
    }

    public final TraeUserInfoResult copy(String screenName, String gender, String avatarUrl, String userId, String description, String tenantId, String registerTime, String lastLoginTime, String lastLoginType, String auditInfo, String region, String aiRegion, String nonPlainTextEmail, String nonPlainTextMobile, String storeCountry, Boolean migrateToSG) {
        return new TraeUserInfoResult(screenName, gender, avatarUrl, userId, description, tenantId, registerTime, lastLoginTime, lastLoginType, auditInfo, region, aiRegion, nonPlainTextEmail, nonPlainTextMobile, storeCountry, migrateToSG);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TraeUserInfoResult)) {
            return false;
        }
        TraeUserInfoResult traeUserInfoResult = (TraeUserInfoResult) other;
        return Intrinsics.areEqual(this.screenName, traeUserInfoResult.screenName) && Intrinsics.areEqual(this.gender, traeUserInfoResult.gender) && Intrinsics.areEqual(this.avatarUrl, traeUserInfoResult.avatarUrl) && Intrinsics.areEqual(this.userId, traeUserInfoResult.userId) && Intrinsics.areEqual(this.description, traeUserInfoResult.description) && Intrinsics.areEqual(this.tenantId, traeUserInfoResult.tenantId) && Intrinsics.areEqual(this.registerTime, traeUserInfoResult.registerTime) && Intrinsics.areEqual(this.lastLoginTime, traeUserInfoResult.lastLoginTime) && Intrinsics.areEqual(this.lastLoginType, traeUserInfoResult.lastLoginType) && Intrinsics.areEqual(this.auditInfo, traeUserInfoResult.auditInfo) && Intrinsics.areEqual(this.region, traeUserInfoResult.region) && Intrinsics.areEqual(this.aiRegion, traeUserInfoResult.aiRegion) && Intrinsics.areEqual(this.nonPlainTextEmail, traeUserInfoResult.nonPlainTextEmail) && Intrinsics.areEqual(this.nonPlainTextMobile, traeUserInfoResult.nonPlainTextMobile) && Intrinsics.areEqual(this.storeCountry, traeUserInfoResult.storeCountry) && Intrinsics.areEqual(this.migrateToSG, traeUserInfoResult.migrateToSG);
    }

    public int hashCode() {
        String str = this.screenName;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.gender;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.avatarUrl;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.userId;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.description;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.tenantId;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.registerTime;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.lastLoginTime;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.lastLoginType;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.auditInfo;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.region;
        int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.aiRegion;
        int hashCode12 = (hashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.nonPlainTextEmail;
        int hashCode13 = (hashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.nonPlainTextMobile;
        int hashCode14 = (hashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.storeCountry;
        int hashCode15 = (hashCode14 + (str15 == null ? 0 : str15.hashCode())) * 31;
        Boolean bool = this.migrateToSG;
        return hashCode15 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TraeUserInfoResult(screenName=");
        sb.append(this.screenName).append(", gender=").append(this.gender).append(", avatarUrl=").append(this.avatarUrl).append(", userId=").append(this.userId).append(", description=").append(this.description).append(", tenantId=").append(this.tenantId).append(", registerTime=").append(this.registerTime).append(", lastLoginTime=").append(this.lastLoginTime).append(", lastLoginType=").append(this.lastLoginType).append(", auditInfo=").append(this.auditInfo).append(", region=").append(this.region).append(", aiRegion=");
        sb.append(this.aiRegion).append(", nonPlainTextEmail=").append(this.nonPlainTextEmail).append(", nonPlainTextMobile=").append(this.nonPlainTextMobile).append(", storeCountry=").append(this.storeCountry).append(", migrateToSG=").append(this.migrateToSG).append(')');
        return sb.toString();
    }

    public TraeUserInfoResult(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, Boolean bool) {
        this.screenName = str;
        this.gender = str2;
        this.avatarUrl = str3;
        this.userId = str4;
        this.description = str5;
        this.tenantId = str6;
        this.registerTime = str7;
        this.lastLoginTime = str8;
        this.lastLoginType = str9;
        this.auditInfo = str10;
        this.region = str11;
        this.aiRegion = str12;
        this.nonPlainTextEmail = str13;
        this.nonPlainTextMobile = str14;
        this.storeCountry = str15;
        this.migrateToSG = bool;
    }

    public /* synthetic */ TraeUserInfoResult(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11, (i & 2048) != 0 ? null : str12, (i & 4096) != 0 ? null : str13, (i & 8192) != 0 ? null : str14, (i & 16384) != 0 ? null : str15, (i & 32768) != 0 ? null : bool);
    }

    public final String getScreenName() {
        return this.screenName;
    }

    public final String getGender() {
        return this.gender;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getTenantId() {
        return this.tenantId;
    }

    public final String getRegisterTime() {
        return this.registerTime;
    }

    public final String getLastLoginTime() {
        return this.lastLoginTime;
    }

    public final String getLastLoginType() {
        return this.lastLoginType;
    }

    public final String getAuditInfo() {
        return this.auditInfo;
    }

    public final String getRegion() {
        return this.region;
    }

    public final String getAiRegion() {
        return this.aiRegion;
    }

    public final String getNonPlainTextEmail() {
        return this.nonPlainTextEmail;
    }

    public final String getNonPlainTextMobile() {
        return this.nonPlainTextMobile;
    }

    public final String getStoreCountry() {
        return this.storeCountry;
    }

    public final Boolean getMigrateToSG() {
        return this.migrateToSG;
    }
}

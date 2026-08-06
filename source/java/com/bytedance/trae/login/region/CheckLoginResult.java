package com.bytedance.trae.login.region;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CheckLoginModels.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b)\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0092\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0002\u0010\u0012R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001f\u0010\u0012R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b \u0010\u0012¨\u00063"}, d2 = {"Lcom/bytedance/trae/login/region/CheckLoginResult;", "", "isLogin", "", "expiredAt", "", "region", "", "host", "nickNameEditStatus", "userId", "aiRegion", "aiHost", "aiPayHost", "passwordChanged", "migrateToSG", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getExpiredAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRegion", "()Ljava/lang/String;", "getHost", "getNickNameEditStatus", "getUserId", "getAiRegion", "getAiHost", "getAiPayHost", "getPasswordChanged", "getMigrateToSG", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/bytedance/trae/login/region/CheckLoginResult;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CheckLoginResult {

    @SerializedName("AIHost")
    private final String aiHost;

    @SerializedName("AIPayHost")
    private final String aiPayHost;

    @SerializedName("AIRegion")
    private final String aiRegion;

    @SerializedName("ExpiredAt")
    private final Long expiredAt;

    @SerializedName("Host")
    private final String host;

    @SerializedName("IsLogin")
    private final Boolean isLogin;

    @SerializedName("MigrateToSG")
    private final Boolean migrateToSG;

    @SerializedName("NickNameEditStatus")
    private final String nickNameEditStatus;

    @SerializedName("PasswordChanged")
    private final Boolean passwordChanged;

    @SerializedName("Region")
    private final String region;

    @SerializedName("UserID")
    private final String userId;

    public CheckLoginResult() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getIsLogin() {
        return this.isLogin;
    }

    /* renamed from: component10, reason: from getter */
    public final Boolean getPasswordChanged() {
        return this.passwordChanged;
    }

    /* renamed from: component11, reason: from getter */
    public final Boolean getMigrateToSG() {
        return this.migrateToSG;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getExpiredAt() {
        return this.expiredAt;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRegion() {
        return this.region;
    }

    /* renamed from: component4, reason: from getter */
    public final String getHost() {
        return this.host;
    }

    /* renamed from: component5, reason: from getter */
    public final String getNickNameEditStatus() {
        return this.nickNameEditStatus;
    }

    /* renamed from: component6, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getAiRegion() {
        return this.aiRegion;
    }

    /* renamed from: component8, reason: from getter */
    public final String getAiHost() {
        return this.aiHost;
    }

    /* renamed from: component9, reason: from getter */
    public final String getAiPayHost() {
        return this.aiPayHost;
    }

    public final CheckLoginResult copy(Boolean isLogin, Long expiredAt, String region, String host, String nickNameEditStatus, String userId, String aiRegion, String aiHost, String aiPayHost, Boolean passwordChanged, Boolean migrateToSG) {
        return new CheckLoginResult(isLogin, expiredAt, region, host, nickNameEditStatus, userId, aiRegion, aiHost, aiPayHost, passwordChanged, migrateToSG);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckLoginResult)) {
            return false;
        }
        CheckLoginResult checkLoginResult = (CheckLoginResult) other;
        return Intrinsics.areEqual(this.isLogin, checkLoginResult.isLogin) && Intrinsics.areEqual(this.expiredAt, checkLoginResult.expiredAt) && Intrinsics.areEqual(this.region, checkLoginResult.region) && Intrinsics.areEqual(this.host, checkLoginResult.host) && Intrinsics.areEqual(this.nickNameEditStatus, checkLoginResult.nickNameEditStatus) && Intrinsics.areEqual(this.userId, checkLoginResult.userId) && Intrinsics.areEqual(this.aiRegion, checkLoginResult.aiRegion) && Intrinsics.areEqual(this.aiHost, checkLoginResult.aiHost) && Intrinsics.areEqual(this.aiPayHost, checkLoginResult.aiPayHost) && Intrinsics.areEqual(this.passwordChanged, checkLoginResult.passwordChanged) && Intrinsics.areEqual(this.migrateToSG, checkLoginResult.migrateToSG);
    }

    public int hashCode() {
        Boolean bool = this.isLogin;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Long l = this.expiredAt;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.region;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.host;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.nickNameEditStatus;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.userId;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.aiRegion;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.aiHost;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.aiPayHost;
        int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Boolean bool2 = this.passwordChanged;
        int hashCode10 = (hashCode9 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.migrateToSG;
        return hashCode10 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CheckLoginResult(isLogin=");
        sb.append(this.isLogin).append(", expiredAt=").append(this.expiredAt).append(", region=").append(this.region).append(", host=").append(this.host).append(", nickNameEditStatus=").append(this.nickNameEditStatus).append(", userId=").append(this.userId).append(", aiRegion=").append(this.aiRegion).append(", aiHost=").append(this.aiHost).append(", aiPayHost=").append(this.aiPayHost).append(", passwordChanged=").append(this.passwordChanged).append(", migrateToSG=").append(this.migrateToSG).append(')');
        return sb.toString();
    }

    public CheckLoginResult(Boolean bool, Long l, String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool2, Boolean bool3) {
        this.isLogin = bool;
        this.expiredAt = l;
        this.region = str;
        this.host = str2;
        this.nickNameEditStatus = str3;
        this.userId = str4;
        this.aiRegion = str5;
        this.aiHost = str6;
        this.aiPayHost = str7;
        this.passwordChanged = bool2;
        this.migrateToSG = bool3;
    }

    public /* synthetic */ CheckLoginResult(Boolean bool, Long l, String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool2, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : bool2, (i & 1024) == 0 ? bool3 : null);
    }

    public final Boolean isLogin() {
        return this.isLogin;
    }

    public final Long getExpiredAt() {
        return this.expiredAt;
    }

    public final String getRegion() {
        return this.region;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getNickNameEditStatus() {
        return this.nickNameEditStatus;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getAiRegion() {
        return this.aiRegion;
    }

    public final String getAiHost() {
        return this.aiHost;
    }

    public final String getAiPayHost() {
        return this.aiPayHost;
    }

    public final Boolean getPasswordChanged() {
        return this.passwordChanged;
    }

    public final Boolean getMigrateToSG() {
        return this.migrateToSG;
    }
}

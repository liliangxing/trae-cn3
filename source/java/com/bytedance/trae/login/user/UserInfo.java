package com.bytedance.trae.login.user;

import androidx.autofill.HintConstants;
import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserInfo.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b&\b\u0086\b\u0018\u0000 52\u00020\u0001:\u00015B\u0081\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\fHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010!J\u0088\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u00020\u00102\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\fHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!¨\u00066"}, d2 = {"Lcom/bytedance/trae/login/user/UserInfo;", "", "userId", "", "screenName", "avatarUrl", HintConstants.AUTOFILL_HINT_GENDER, "email", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "tenantId", "tenantName", "productType", "", "aiRegion", "employeeId", "saasPrivacyMode", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getUserId", "()Ljava/lang/String;", "getScreenName", "getAvatarUrl", "getGender", "getEmail", "getPhoneNumber", "getTenantId", "getTenantName", "getProductType", "()I", "getAiRegion", "getEmployeeId", "getSaasPrivacyMode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/bytedance/trae/login/user/UserInfo;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @SerializedName("aiRegion")
    private final String aiRegion;

    @SerializedName("avatarUrl")
    private final String avatarUrl;

    @SerializedName("email")
    private final String email;

    @SerializedName("employeeId")
    private final String employeeId;

    @SerializedName(HintConstants.AUTOFILL_HINT_GENDER)
    private final String gender;

    @SerializedName(HintConstants.AUTOFILL_HINT_PHONE_NUMBER)
    private final String phoneNumber;

    @SerializedName("productType")
    private final int productType;

    @SerializedName("saas_privacy_mode")
    private final Boolean saasPrivacyMode;

    @SerializedName("screenName")
    private final String screenName;

    @SerializedName("tenantId")
    private final String tenantId;

    @SerializedName("tenantName")
    private final String tenantName;

    @SerializedName("userId")
    private final String userId;

    public UserInfo() {
        this(null, null, null, null, null, null, null, null, 0, null, null, null, UnixStat.PERM_MASK, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getAiRegion() {
        return this.aiRegion;
    }

    /* renamed from: component11, reason: from getter */
    public final String getEmployeeId() {
        return this.employeeId;
    }

    /* renamed from: component12, reason: from getter */
    public final Boolean getSaasPrivacyMode() {
        return this.saasPrivacyMode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getScreenName() {
        return this.screenName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final String getGender() {
        return this.gender;
    }

    /* renamed from: component5, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* renamed from: component7, reason: from getter */
    public final String getTenantId() {
        return this.tenantId;
    }

    /* renamed from: component8, reason: from getter */
    public final String getTenantName() {
        return this.tenantName;
    }

    /* renamed from: component9, reason: from getter */
    public final int getProductType() {
        return this.productType;
    }

    public final UserInfo copy(String userId, String screenName, String avatarUrl, String gender, String email, String phoneNumber, String tenantId, String tenantName, int productType, String aiRegion, String employeeId, Boolean saasPrivacyMode) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(tenantId, "tenantId");
        Intrinsics.checkNotNullParameter(tenantName, "tenantName");
        Intrinsics.checkNotNullParameter(aiRegion, "aiRegion");
        Intrinsics.checkNotNullParameter(employeeId, "employeeId");
        return new UserInfo(userId, screenName, avatarUrl, gender, email, phoneNumber, tenantId, tenantName, productType, aiRegion, employeeId, saasPrivacyMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) other;
        return Intrinsics.areEqual(this.userId, userInfo.userId) && Intrinsics.areEqual(this.screenName, userInfo.screenName) && Intrinsics.areEqual(this.avatarUrl, userInfo.avatarUrl) && Intrinsics.areEqual(this.gender, userInfo.gender) && Intrinsics.areEqual(this.email, userInfo.email) && Intrinsics.areEqual(this.phoneNumber, userInfo.phoneNumber) && Intrinsics.areEqual(this.tenantId, userInfo.tenantId) && Intrinsics.areEqual(this.tenantName, userInfo.tenantName) && this.productType == userInfo.productType && Intrinsics.areEqual(this.aiRegion, userInfo.aiRegion) && Intrinsics.areEqual(this.employeeId, userInfo.employeeId) && Intrinsics.areEqual(this.saasPrivacyMode, userInfo.saasPrivacyMode);
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((this.userId.hashCode() * 31) + this.screenName.hashCode()) * 31) + this.avatarUrl.hashCode()) * 31) + this.gender.hashCode()) * 31) + this.email.hashCode()) * 31) + this.phoneNumber.hashCode()) * 31) + this.tenantId.hashCode()) * 31) + this.tenantName.hashCode()) * 31) + Integer.hashCode(this.productType)) * 31) + this.aiRegion.hashCode()) * 31) + this.employeeId.hashCode()) * 31;
        Boolean bool = this.saasPrivacyMode;
        return hashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UserInfo(userId=");
        sb.append(this.userId).append(", screenName=").append(this.screenName).append(", avatarUrl=").append(this.avatarUrl).append(", gender=").append(this.gender).append(", email=").append(this.email).append(", phoneNumber=").append(this.phoneNumber).append(", tenantId=").append(this.tenantId).append(", tenantName=").append(this.tenantName).append(", productType=").append(this.productType).append(", aiRegion=").append(this.aiRegion).append(", employeeId=").append(this.employeeId).append(", saasPrivacyMode=");
        sb.append(this.saasPrivacyMode).append(')');
        return sb.toString();
    }

    public UserInfo(String userId, String screenName, String avatarUrl, String gender, String email, String phoneNumber, String tenantId, String tenantName, int i, String aiRegion, String employeeId, Boolean bool) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(tenantId, "tenantId");
        Intrinsics.checkNotNullParameter(tenantName, "tenantName");
        Intrinsics.checkNotNullParameter(aiRegion, "aiRegion");
        Intrinsics.checkNotNullParameter(employeeId, "employeeId");
        this.userId = userId;
        this.screenName = screenName;
        this.avatarUrl = avatarUrl;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.tenantId = tenantId;
        this.tenantName = tenantName;
        this.productType = i;
        this.aiRegion = aiRegion;
        this.employeeId = employeeId;
        this.saasPrivacyMode = bool;
    }

    public /* synthetic */ UserInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, String str10, Boolean bool, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) != 0 ? "" : str6, (i2 & 64) != 0 ? "" : str7, (i2 & 128) != 0 ? "" : str8, (i2 & 256) != 0 ? 0 : i, (i2 & 512) != 0 ? "" : str9, (i2 & 1024) == 0 ? str10 : "", (i2 & 2048) != 0 ? null : bool);
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getScreenName() {
        return this.screenName;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getGender() {
        return this.gender;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getTenantId() {
        return this.tenantId;
    }

    public final String getTenantName() {
        return this.tenantName;
    }

    public final int getProductType() {
        return this.productType;
    }

    public final String getAiRegion() {
        return this.aiRegion;
    }

    public final String getEmployeeId() {
        return this.employeeId;
    }

    public final Boolean getSaasPrivacyMode() {
        return this.saasPrivacyMode;
    }

    /* compiled from: UserInfo.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/login/user/UserInfo$Companion;", "", "<init>", "()V", "from", "Lcom/bytedance/trae/login/user/UserInfo;", "result", "Lcom/bytedance/trae/login/user/TraeUserInfoResult;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UserInfo from(TraeUserInfoResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            String userId = result.getUserId();
            if (userId == null) {
                userId = "";
            }
            String screenName = result.getScreenName();
            if (screenName == null) {
                screenName = "";
            }
            String avatarUrl = result.getAvatarUrl();
            if (avatarUrl == null) {
                avatarUrl = "";
            }
            String gender = result.getGender();
            if (gender == null) {
                gender = "";
            }
            String nonPlainTextEmail = result.getNonPlainTextEmail();
            if (nonPlainTextEmail == null) {
                nonPlainTextEmail = "";
            }
            String nonPlainTextMobile = result.getNonPlainTextMobile();
            if (nonPlainTextMobile == null) {
                nonPlainTextMobile = "";
            }
            String tenantId = result.getTenantId();
            if (tenantId == null) {
                tenantId = "";
            }
            String str = null;
            int i = 0;
            String aiRegion = result.getAiRegion();
            return new UserInfo(userId, screenName, avatarUrl, gender, nonPlainTextEmail, nonPlainTextMobile, tenantId, str, i, aiRegion == null ? "" : aiRegion, null, null, 3456, null);
        }
    }
}

package com.bytedance.trae.home.solo.setting;

import androidx.autofill.HintConstants;
import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsViewModel.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0017JV\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÇ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010$\u001a\u00020\tH×\u0001J\t\u0010%\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/UserProfileState;", "", "screenName", "", "avatarUrl", "email", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "userId", "productType", "", "saasPrivacyMode", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;)V", "getScreenName", "()Ljava/lang/String;", "getAvatarUrl", "getEmail", "getPhoneNumber", "getUserId", "getProductType", "()I", "getSaasPrivacyMode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;)Lcom/bytedance/trae/home/solo/setting/UserProfileState;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UserProfileState {
    public static final int $stable = 0;
    private final String avatarUrl;
    private final String email;
    private final String phoneNumber;
    private final int productType;
    private final Boolean saasPrivacyMode;
    private final String screenName;
    private final String userId;

    public UserProfileState() {
        this(null, null, null, null, null, 0, null, 127, null);
    }

    public static /* synthetic */ UserProfileState copy$default(UserProfileState userProfileState, String str, String str2, String str3, String str4, String str5, int i, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = userProfileState.screenName;
        }
        if ((i2 & 2) != 0) {
            str2 = userProfileState.avatarUrl;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = userProfileState.email;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = userProfileState.phoneNumber;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = userProfileState.userId;
        }
        String str9 = str5;
        if ((i2 & 32) != 0) {
            i = userProfileState.productType;
        }
        int i3 = i;
        if ((i2 & 64) != 0) {
            bool = userProfileState.saasPrivacyMode;
        }
        return userProfileState.copy(str, str6, str7, str8, str9, i3, bool);
    }

    /* renamed from: component1, reason: from getter */
    public final String getScreenName() {
        return this.screenName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* renamed from: component5, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component6, reason: from getter */
    public final int getProductType() {
        return this.productType;
    }

    /* renamed from: component7, reason: from getter */
    public final Boolean getSaasPrivacyMode() {
        return this.saasPrivacyMode;
    }

    public final UserProfileState copy(String screenName, String avatarUrl, String email, String phoneNumber, String userId, int productType, Boolean saasPrivacyMode) {
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(userId, "userId");
        return new UserProfileState(screenName, avatarUrl, email, phoneNumber, userId, productType, saasPrivacyMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserProfileState)) {
            return false;
        }
        UserProfileState userProfileState = (UserProfileState) other;
        return Intrinsics.areEqual(this.screenName, userProfileState.screenName) && Intrinsics.areEqual(this.avatarUrl, userProfileState.avatarUrl) && Intrinsics.areEqual(this.email, userProfileState.email) && Intrinsics.areEqual(this.phoneNumber, userProfileState.phoneNumber) && Intrinsics.areEqual(this.userId, userProfileState.userId) && this.productType == userProfileState.productType && Intrinsics.areEqual(this.saasPrivacyMode, userProfileState.saasPrivacyMode);
    }

    public int hashCode() {
        int hashCode = ((((((((((this.screenName.hashCode() * 31) + this.avatarUrl.hashCode()) * 31) + this.email.hashCode()) * 31) + this.phoneNumber.hashCode()) * 31) + this.userId.hashCode()) * 31) + Integer.hashCode(this.productType)) * 31;
        Boolean bool = this.saasPrivacyMode;
        return hashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "UserProfileState(screenName=" + this.screenName + ", avatarUrl=" + this.avatarUrl + ", email=" + this.email + ", phoneNumber=" + this.phoneNumber + ", userId=" + this.userId + ", productType=" + this.productType + ", saasPrivacyMode=" + this.saasPrivacyMode + ')';
    }

    public UserProfileState(String screenName, String avatarUrl, String email, String phoneNumber, String userId, int i, Boolean bool) {
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.screenName = screenName;
        this.avatarUrl = avatarUrl;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
        this.productType = i;
        this.saasPrivacyMode = bool;
    }

    public /* synthetic */ UserProfileState(String str, String str2, String str3, String str4, String str5, int i, Boolean bool, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) == 0 ? str5 : "", (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : bool);
    }

    public final String getScreenName() {
        return this.screenName;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final int getProductType() {
        return this.productType;
    }

    public final Boolean getSaasPrivacyMode() {
        return this.saasPrivacyMode;
    }
}

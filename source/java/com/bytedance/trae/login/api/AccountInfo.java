package com.bytedance.trae.login.api;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountInfo.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/bytedance/trae/login/api/AccountInfo;", "", "isLogin", "", "loginPlatform", "", "userId", "secUserId", "odinUserType", "", "avatarUrl", "screenName", "email", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "tenantId", "aiRegion", "productType", "accountType", "Lcom/bytedance/trae/login/api/AccountType;", "tenantName", "saasPrivacyMode", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/bytedance/trae/login/api/AccountType;Ljava/lang/String;Ljava/lang/Boolean;)V", "()Z", "getLoginPlatform", "()Ljava/lang/String;", "getUserId", "getSecUserId", "getOdinUserType", "()I", "getAvatarUrl", "getScreenName", "getEmail", "getPhoneNumber", "getTenantId", "getAiRegion", "getProductType", "getAccountType", "()Lcom/bytedance/trae/login/api/AccountType;", "getTenantName", "getSaasPrivacyMode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AccountInfo {
    private final AccountType accountType;
    private final String aiRegion;
    private final String avatarUrl;
    private final String email;
    private final boolean isLogin;
    private final String loginPlatform;
    private final int odinUserType;
    private final String phoneNumber;
    private final int productType;
    private final Boolean saasPrivacyMode;
    private final String screenName;
    private final String secUserId;
    private final String tenantId;
    private final String tenantName;
    private final String userId;

    public AccountInfo(boolean z, String loginPlatform, String userId, String secUserId, int i, String avatarUrl, String screenName, String email, String phoneNumber, String tenantId, String aiRegion, int i2, AccountType accountType, String tenantName, Boolean bool) {
        Intrinsics.checkNotNullParameter(loginPlatform, "loginPlatform");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(secUserId, "secUserId");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(tenantId, "tenantId");
        Intrinsics.checkNotNullParameter(aiRegion, "aiRegion");
        Intrinsics.checkNotNullParameter(accountType, "accountType");
        Intrinsics.checkNotNullParameter(tenantName, "tenantName");
        this.isLogin = z;
        this.loginPlatform = loginPlatform;
        this.userId = userId;
        this.secUserId = secUserId;
        this.odinUserType = i;
        this.avatarUrl = avatarUrl;
        this.screenName = screenName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.tenantId = tenantId;
        this.aiRegion = aiRegion;
        this.productType = i2;
        this.accountType = accountType;
        this.tenantName = tenantName;
        this.saasPrivacyMode = bool;
    }

    /* renamed from: isLogin, reason: from getter */
    public final boolean getIsLogin() {
        return this.isLogin;
    }

    public final String getLoginPlatform() {
        return this.loginPlatform;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getSecUserId() {
        return this.secUserId;
    }

    public final int getOdinUserType() {
        return this.odinUserType;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getScreenName() {
        return this.screenName;
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

    public final String getAiRegion() {
        return this.aiRegion;
    }

    public final int getProductType() {
        return this.productType;
    }

    public final AccountType getAccountType() {
        return this.accountType;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ AccountInfo(boolean z, String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, String str9, int i2, AccountType accountType, String str10, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, str, str2, str3, i, str4, r7, r8, r9, r10, r11, r12, r13, (i3 & 8192) != 0 ? "" : str10, (i3 & 16384) != 0 ? null : bool);
        AccountType accountType2;
        AccountType accountType3;
        String str11 = (i3 & 64) != 0 ? "" : str5;
        String str12 = (i3 & 128) != 0 ? "" : str6;
        String str13 = (i3 & 256) != 0 ? "" : str7;
        String str14 = (i3 & 512) != 0 ? "" : str8;
        String str15 = (i3 & 1024) != 0 ? "" : str9;
        int i4 = (i3 & 2048) != 0 ? 0 : i2;
        if ((i3 & 4096) != 0) {
            if (!z) {
                accountType3 = AccountType.UNKNOWN;
            } else if (Intrinsics.areEqual(str, "bytecloud")) {
                accountType3 = AccountType.BYTEDANCE;
            } else {
                accountType3 = Intrinsics.areEqual(str, "enterprise") ? AccountType.TOB : AccountType.TOC;
            }
            accountType2 = accountType3;
        } else {
            accountType2 = accountType;
        }
    }

    public final String getTenantName() {
        return this.tenantName;
    }

    public final Boolean getSaasPrivacyMode() {
        return this.saasPrivacyMode;
    }
}

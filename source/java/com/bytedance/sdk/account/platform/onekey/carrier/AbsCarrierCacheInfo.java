package com.bytedance.sdk.account.platform.onekey.carrier;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CarrierCacheInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u001d\u001a\u00020\u0006H&J\b\u0010\u001e\u001a\u00020\u0006H&J\b\u0010\u001f\u001a\u00020 H\u0002J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\n\u0010$\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\"H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u0004¨\u0006'"}, d2 = {"Lcom/bytedance/sdk/account/platform/onekey/carrier/AbsCarrierCacheInfo;", "", "subscriptionId", "", "(I)V", "authToken", "", "getAuthToken", "()Ljava/lang/String;", "setAuthToken", "(Ljava/lang/String;)V", "authTokenExpireTime", "", "getAuthTokenExpireTime", "()J", "setAuthTokenExpireTime", "(J)V", "maskPhone", "getMaskPhone", "setMaskPhone", "phoneInfoRawResult", "getPhoneInfoRawResult", "setPhoneInfoRawResult", "getSubscriptionId", "()I", "setSubscriptionId", "cleanTokenCache", "", "getCarrierAppId", "getCarrierFrom", "getNetType", "isTokenValidate", "", "parseToAuthTokenResponse", "Landroid/os/Bundle;", "parseToPhoneInfoResponse", "parseToValidateTokenResponse", "putCommonResponse", "bundle", "account-platform-onekey-login_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public abstract class AbsCarrierCacheInfo {
    private String authToken;
    private long authTokenExpireTime;
    private String maskPhone;
    private String phoneInfoRawResult;
    private int subscriptionId;

    public AbsCarrierCacheInfo() {
        this(0, 1, null);
    }

    public abstract String getCarrierAppId();

    public abstract String getCarrierFrom();

    public abstract String getNetType();

    public AbsCarrierCacheInfo(int i) {
        this.subscriptionId = i;
        this.authTokenExpireTime = -1L;
    }

    public /* synthetic */ AbsCarrierCacheInfo(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i);
    }

    public final int getSubscriptionId() {
        return this.subscriptionId;
    }

    public final void setSubscriptionId(int i) {
        this.subscriptionId = i;
    }

    public final String getMaskPhone() {
        return this.maskPhone;
    }

    public final void setMaskPhone(String str) {
        this.maskPhone = str;
    }

    public final String getAuthToken() {
        return this.authToken;
    }

    public final void setAuthToken(String str) {
        this.authToken = str;
    }

    public final long getAuthTokenExpireTime() {
        return this.authTokenExpireTime;
    }

    public final void setAuthTokenExpireTime(long j) {
        this.authTokenExpireTime = j;
    }

    public final String getPhoneInfoRawResult() {
        return this.phoneInfoRawResult;
    }

    public final void setPhoneInfoRawResult(String str) {
        this.phoneInfoRawResult = str;
    }

    public Bundle parseToPhoneInfoResponse() {
        if (TextUtils.isEmpty(this.maskPhone)) {
            return null;
        }
        Bundle bundle = new Bundle();
        putCommonResponse(bundle);
        return bundle;
    }

    public Bundle parseToAuthTokenResponse() {
        if (!isTokenValidate()) {
            return null;
        }
        Bundle bundle = new Bundle();
        putCommonResponse(bundle);
        cleanTokenCache();
        return bundle;
    }

    public Bundle parseToValidateTokenResponse() {
        if (!isTokenValidate()) {
            return null;
        }
        Bundle bundle = new Bundle();
        putCommonResponse(bundle);
        cleanTokenCache();
        return bundle;
    }

    private final void putCommonResponse(Bundle bundle) {
        bundle.putString("carrier_app_id", getCarrierAppId());
        bundle.putString("net_type", getNetType());
        bundle.putString(IOnekeyLoginService.ResponseConstants.CARRIER_FROM, getCarrierFrom());
        bundle.putString(IOnekeyLoginService.ResponseConstants.RAW_RESULT, this.phoneInfoRawResult);
        bundle.putString(IOnekeyLoginService.ResponseConstants.SECURITY_PHONE, this.maskPhone);
        if (isTokenValidate()) {
            bundle.putString("access_token", this.authToken);
            bundle.putString("expires_in", String.valueOf((this.authTokenExpireTime - System.currentTimeMillis()) / 1000));
            bundle.putString(IOnekeyLoginService.ResponseConstants.TOKEN_EXPIRES_TIME, String.valueOf(this.authTokenExpireTime));
        }
    }

    private final boolean isTokenValidate() {
        return !TextUtils.isEmpty(this.authToken) && this.authTokenExpireTime > System.currentTimeMillis();
    }

    private final void cleanTokenCache() {
        this.authToken = null;
        this.authTokenExpireTime = -1L;
    }
}

package com.bytedance.sdk.account.platform.onekey.carrier;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.api.IAuthorizeService;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.onekey.OnekeyLoginConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CarrierCacheInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/account/platform/onekey/carrier/MobileCarrierCacheInfo;", "Lcom/bytedance/sdk/account/platform/onekey/carrier/AbsCarrierCacheInfo;", "subscriptionId", "", "(I)V", "scripExpiresTime", "", "getScripExpiresTime", "()J", "setScripExpiresTime", "(J)V", "getCarrierAppId", "", "getCarrierFrom", "getNetType", "parseToAuthTokenResponse", "Landroid/os/Bundle;", "parseToPhoneInfoResponse", "parseToValidateTokenResponse", "account-platform-onekey-login_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MobileCarrierCacheInfo extends AbsCarrierCacheInfo {
    private long scripExpiresTime;

    public MobileCarrierCacheInfo() {
        this(0, 1, null);
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrierCacheInfo
    public String getCarrierFrom() {
        return "mobile";
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrierCacheInfo
    public String getNetType() {
        return "mobile";
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrierCacheInfo
    public Bundle parseToAuthTokenResponse() {
        return null;
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrierCacheInfo
    public Bundle parseToValidateTokenResponse() {
        return null;
    }

    public MobileCarrierCacheInfo(int i) {
        super(i);
        this.scripExpiresTime = -1L;
    }

    public /* synthetic */ MobileCarrierCacheInfo(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i);
    }

    public final long getScripExpiresTime() {
        return this.scripExpiresTime;
    }

    public final void setScripExpiresTime(long j) {
        this.scripExpiresTime = j;
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrierCacheInfo
    public Bundle parseToPhoneInfoResponse() {
        Bundle parseToPhoneInfoResponse = super.parseToPhoneInfoResponse();
        if (parseToPhoneInfoResponse == null) {
            return null;
        }
        parseToPhoneInfoResponse.putString("scripExpiresIn", String.valueOf((this.scripExpiresTime - System.currentTimeMillis()) / 1000));
        return parseToPhoneInfoResponse;
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrierCacheInfo
    public String getCarrierAppId() {
        OnekeyLoginConfig config;
        OnekeyLoginConfig.CTSettingConfig cTSettingConfig;
        IAuthorizeService service = AuthorizeFramework.getService(IOnekeyLoginService.class);
        if (!(service instanceof IServiceContainer)) {
            service = null;
        }
        IServiceContainer iServiceContainer = (IServiceContainer) service;
        if (iServiceContainer == null || (config = iServiceContainer.getConfig()) == null || (cTSettingConfig = config.getCTSettingConfig()) == null) {
            return null;
        }
        return cTSettingConfig.mCTAppKey;
    }
}

package com.bytedance.sdk.account.platform.onekey.carrier;

import com.bytedance.sdk.account.platform.api.IAuthorizeService;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.platform.onekey.OnekeyLoginConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CarrierCacheInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/sdk/account/platform/onekey/carrier/TelecomCarrierCacheInfo;", "Lcom/bytedance/sdk/account/platform/onekey/carrier/AbsCarrierCacheInfo;", "subscriptionId", "", "(I)V", "getCarrierAppId", "", "getCarrierFrom", "getNetType", "account-platform-onekey-login_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TelecomCarrierCacheInfo extends AbsCarrierCacheInfo {
    public TelecomCarrierCacheInfo() {
        this(0, 1, null);
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrierCacheInfo
    public String getCarrierFrom() {
        return OnekeyLoginConstants.TELECOM_V2;
    }

    @Override // com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrierCacheInfo
    public String getNetType() {
        return OnekeyLoginConstants.TELECOM_V2;
    }

    public TelecomCarrierCacheInfo(int i) {
        super(i);
    }

    public /* synthetic */ TelecomCarrierCacheInfo(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i);
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

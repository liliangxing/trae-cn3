package com.bytedance.sdk.account.impl;

import android.content.Context;
import com.bytedance.sdk.account.api.BDAccountAPIV2Impl;
import com.bytedance.sdk.account.api.IAccountShare;
import com.bytedance.sdk.account.api.IBDAccount;
import com.bytedance.sdk.account.api.IBDAccountAPI;
import com.bytedance.sdk.account.api.IBDAccountPlatformAPI;
import com.bytedance.sdk.account.api.ICommonRequestApi;
import com.bytedance.sdk.account.information.BDInformationAPIImpl;
import com.bytedance.sdk.account.information.IBDInformationAPI;
import com.bytedance.sdk.account.platform.api.IAccountSettingsService;
import com.bytedance.sdk.account.save.BDSaveImpl;
import com.bytedance.sdk.account.save.IBDSaveAPI;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BDAccountDelegate {
    public static IBDAccount instance(Context context) {
        return BDAccountManager.instance(context);
    }

    @Deprecated
    public static IBDAccountAPI createBDAccountApi(Context context) {
        return new BDAccountAPIV2Impl();
    }

    public static IAccountSettingsService getSettingsInstance(Context context) {
        return BDAccountSettingsManager.instance(context);
    }

    public static IBDAccountPlatformAPI createPlatformAPI(Context context) {
        return BDAccountPlatformImpl.instance();
    }

    public static IBDInformationAPI createInformationAPI(Context context) {
        return BDInformationAPIImpl.instance();
    }

    public static IBDSaveAPI getSaveAPI() {
        return BDSaveImpl.instance();
    }

    public static IAccountShare getAccountShareIns() {
        return AccountShareImpl.instance();
    }

    public static ICommonRequestApi getCommonRequestProxy() {
        return CommonRequestImpl.instance();
    }
}

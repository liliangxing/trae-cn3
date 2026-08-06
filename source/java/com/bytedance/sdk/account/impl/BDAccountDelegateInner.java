package com.bytedance.sdk.account.impl;

import android.content.Context;
import com.bytedance.sdk.account.api.IBDAccount;
import com.bytedance.sdk.account.api.ICommonRequestApi;
import com.bytedance.sdk.account.platform.api.IAccountSettingsService;
import com.bytedance.sdk.account.save.BDSaveImpl;
import com.bytedance.sdk.account.save.IBDSaveAPI;
import com.ss.android.account.TTAccountInit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BDAccountDelegateInner {
    public static IBDAccount instance(Context context) {
        return BDAccountManager.instance(context);
    }

    public static IBDAccount instance() {
        return BDAccountManager.instance(TTAccountInit.getConfig().getApplicationContext());
    }

    public static IAccountSettingsService getSettingsInstance(Context context) {
        return BDAccountSettingsManager.instance(context);
    }

    public static IBDSaveAPI getSaveAPI() {
        return BDSaveImpl.instance();
    }

    public static ICommonRequestApi getCommonRequestProxy() {
        return CommonRequestImpl.instance();
    }
}

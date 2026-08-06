package com.bytedance.sdk.account.impl;

import com.bytedance.sdk.account.bus.AccountSdkInfoService;
import com.bytedance.sdk.account.bus.AccountSdkServiceBus;
import com.bytedance.sdk.account.bus.IAccountSdkService;
import com.bytedance.sdk.account.error.handler.ErrorHandlerCenter;
import com.bytedance.sdk.account.error.handler.impl.CaptchaErrorHandler;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BDAccountFrameworkManager {
    private static volatile BDAccountFrameworkManager sInstance;

    public static BDAccountFrameworkManager instance() {
        if (sInstance == null) {
            synchronized (BDAccountFrameworkManager.class) {
                if (sInstance == null) {
                    sInstance = new BDAccountFrameworkManager();
                }
            }
        }
        return sInstance;
    }

    private BDAccountFrameworkManager() {
    }

    public void init() {
        registerSdkService("account_sdk_info", AccountSdkInfoService.INSTANCE);
        ErrorHandlerCenter.registerGlobalHandler(new CaptchaErrorHandler());
    }

    public void registerSdkService(String str, IAccountSdkService iAccountSdkService) {
        AccountSdkServiceBus.INSTANCE.registerService(str, iAccountSdkService);
    }
}

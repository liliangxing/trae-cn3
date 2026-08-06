package com.bytedance.sdk.open.douyin.impl;

import com.bytedance.sdk.open.aweme.core.OpenSdkTicketService;
import com.bytedance.sdk.open.aweme.core.OpenServiceManager;
import com.bytedance.sdk.open.aweme.init.DouYinOpenSDKConfig;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.douyin.settings.OpenSettings;
import com.bytedance.sdk.open.douyin.settings.OpenSettingsManager;

/* renamed from: com.bytedance.sdk.open.douyin.impl.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0119c {

    /* renamed from: a */
    private static final String f79a = "DouYinOpenSDKInit";

    /* renamed from: a */
    public static void m40a(DouYinOpenSDKConfig douYinOpenSDKConfig) {
        C0118b.m38a(douYinOpenSDKConfig);
        OpenSettings.get().updateSettings(true, "initConfig");
        if (OpenSettingsManager.inst().getSDKConfig().initTicketSDK == 1) {
            LogUtils.m29i(f79a, "initTicketSDK");
            OpenSdkTicketService openSdkTicketService = (OpenSdkTicketService) OpenServiceManager.getInst().getService(OpenSdkTicketService.class);
            if (openSdkTicketService == null) {
                LogUtils.m28e(f79a, "please implement OpenTicketService");
                return;
            }
            openSdkTicketService.initTicketGuard(douYinOpenSDKConfig.getContext());
        }
        if (douYinOpenSDKConfig.getEnableDefaultTicketGuard().booleanValue()) {
            LogUtils.m29i(f79a, "getEnableDefaultTicketGuard");
            C0118b.m37a();
        }
    }
}

package com.bytedance.sdk.open.douyin;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.core.OpenEventService;
import com.bytedance.sdk.open.aweme.core.OpenHostInfoService;
import com.bytedance.sdk.open.aweme.core.OpenImageService;
import com.bytedance.sdk.open.aweme.core.OpenNetworkService;
import com.bytedance.sdk.open.aweme.core.OpenSdkTicketService;
import com.bytedance.sdk.open.aweme.core.OpenServiceManager;
import com.bytedance.sdk.open.aweme.init.DouYinSdkContext;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import com.bytedance.sdk.open.douyin.api.IOpenConfig;
import com.bytedance.sdk.open.douyin.impl.C0118b;
import com.bytedance.sdk.open.douyin.impl.C0122f;
import com.bytedance.sdk.open.douyin.settings.OpenSettings;
import com.bytedance.sdk.open.douyin.settings.OpenSettingsManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class DouYinOpenApiFactory extends AbstractC0113a {
    private static final String TAG = "DouYinOpenApiFactory";
    private static IOpenConfig sOpenConfig;

    public static DouYinOpenApi createDouYinLite(Activity activity, DouYinOpenConfig douYinOpenConfig) {
        if (activity == null || douYinOpenConfig == null || TextUtils.isEmpty(douYinOpenConfig.clientKey)) {
            return null;
        }
        DouYinSdkContext.inst().setClientKey(douYinOpenConfig.clientKey);
        DouYinSdkContext.inst().setContext(activity);
        return new C0122f(activity, douYinOpenConfig.clientKey);
    }

    @Deprecated
    public static void enableDefaultTicketGuard() {
        C0118b.m37a();
    }

    @Deprecated
    public static void initConfig(Context context, IOpenConfig iOpenConfig) {
        if (iOpenConfig == null || context == null) {
            return;
        }
        sOpenConfig = iOpenConfig;
        DouYinSdkContext.inst().setContext(context.getApplicationContext());
        if (sOpenConfig.getHostInfo() == null) {
            throw new RuntimeException("please implement OpenHostInfoService interface");
        }
        OpenServiceManager.getInst().registerService(OpenHostInfoService.class, sOpenConfig.getHostInfo());
        if (sOpenConfig.getNetWork() == null) {
            throw new RuntimeException("please implement OpenNetworkService interface");
        }
        OpenServiceManager.getInst().registerService(OpenNetworkService.class, sOpenConfig.getNetWork());
        if (sOpenConfig.getEventService() != null) {
            OpenServiceManager.getInst().registerService(OpenEventService.class, sOpenConfig.getEventService());
        }
        if (sOpenConfig.getImageService() != null) {
            OpenServiceManager.getInst().registerService(OpenImageService.class, sOpenConfig.getImageService());
        }
        OpenSettings.get().updateSettings(true, "initConfig");
        if (OpenSettingsManager.inst().getSDKConfig().initTicketSDK == 1) {
            LogUtils.m29i(TAG, "initTicketSDK");
            C0118b.m39b();
            OpenSdkTicketService openSdkTicketService = (OpenSdkTicketService) OpenServiceManager.getInst().getService(OpenSdkTicketService.class);
            if (openSdkTicketService == null) {
                LogUtils.m28e(TAG, "please implement OpenTicketService");
            } else {
                openSdkTicketService.initTicketGuard(context);
            }
        }
    }
}

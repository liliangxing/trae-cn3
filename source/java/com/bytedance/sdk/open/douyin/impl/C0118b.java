package com.bytedance.sdk.open.douyin.impl;

import android.content.Context;
import android.widget.Toast;
import com.bytedance.sdk.open.aweme.core.OpenEventService;
import com.bytedance.sdk.open.aweme.core.OpenHostInfoService;
import com.bytedance.sdk.open.aweme.core.OpenHostSettingService;
import com.bytedance.sdk.open.aweme.core.OpenHostTicketService;
import com.bytedance.sdk.open.aweme.core.OpenImageService;
import com.bytedance.sdk.open.aweme.core.OpenLogService;
import com.bytedance.sdk.open.aweme.core.OpenNetworkService;
import com.bytedance.sdk.open.aweme.core.OpenOptionService;
import com.bytedance.sdk.open.aweme.core.OpenSdkTicketService;
import com.bytedance.sdk.open.aweme.core.OpenServiceManager;
import com.bytedance.sdk.open.aweme.core.impl.SystemOpenLogServiceImpl;
import com.bytedance.sdk.open.aweme.init.DouYinOpenSDKConfig;
import com.bytedance.sdk.open.aweme.init.DouYinSdkContext;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.douyin.AbstractC0113a;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;

/* renamed from: com.bytedance.sdk.open.douyin.impl.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0118b {

    /* renamed from: a */
    private static final String f78a = "DouYinOpenSDKInit";

    /* renamed from: a */
    public static void m37a() {
        OpenSdkTicketService openSdkTicketService = (OpenSdkTicketService) OpenServiceManager.getInst().getService(OpenSdkTicketService.class);
        if (openSdkTicketService == null) {
            LogUtils.m28e(f78a, "please implement OpenTicketService");
        } else {
            openSdkTicketService.enableDefaultTicketGuard();
        }
    }

    /* renamed from: a */
    public static void m38a(DouYinOpenSDKConfig douYinOpenSDKConfig) {
        OpenServiceManager inst;
        OpenLogService systemOpenLogServiceImpl;
        if (douYinOpenSDKConfig == null) {
            throw new IllegalArgumentException("config不能为空");
        }
        Context applicationContext = douYinOpenSDKConfig.getContext().getApplicationContext();
        DouYinSdkContext.inst().setContext(applicationContext);
        AbstractC0113a.init(new DouYinOpenConfig(douYinOpenSDKConfig.getClientKey()));
        DouYinSdkContext.inst().setClientKey(douYinOpenSDKConfig.getClientKey());
        DouYinSdkContext.inst().setUseClientTicket(douYinOpenSDKConfig.isUseClientTicket());
        if (douYinOpenSDKConfig.getLogService() != null) {
            inst = OpenServiceManager.getInst();
            systemOpenLogServiceImpl = douYinOpenSDKConfig.getLogService();
        } else {
            inst = OpenServiceManager.getInst();
            systemOpenLogServiceImpl = new SystemOpenLogServiceImpl();
        }
        inst.registerService(OpenLogService.class, systemOpenLogServiceImpl);
        if (douYinOpenSDKConfig.getHostInfoService() != null) {
            OpenServiceManager.getInst().registerService(OpenHostInfoService.class, douYinOpenSDKConfig.getHostInfoService());
        }
        if (douYinOpenSDKConfig.getNetworkService() != null) {
            OpenServiceManager.getInst().registerService(OpenNetworkService.class, douYinOpenSDKConfig.getNetworkService());
        }
        if (douYinOpenSDKConfig.getEventService() != null) {
            OpenServiceManager.getInst().registerService(OpenEventService.class, douYinOpenSDKConfig.getEventService());
        }
        if (douYinOpenSDKConfig.getImageService() != null) {
            OpenServiceManager.getInst().registerService(OpenImageService.class, douYinOpenSDKConfig.getImageService());
        }
        if (douYinOpenSDKConfig.getOpenOptionService() != null) {
            OpenServiceManager.getInst().registerService(OpenOptionService.class, douYinOpenSDKConfig.getOpenOptionService());
        }
        m39b();
        if (douYinOpenSDKConfig.getHostTicketService() != null) {
            OpenServiceManager.getInst().registerService(OpenHostTicketService.class, douYinOpenSDKConfig.getHostTicketService());
        } else if (LogUtils.sDebuggable && douYinOpenSDKConfig.isUseClientTicket()) {
            Toast.makeText(applicationContext, "please implement OpenHostTicketService", 1).show();
        }
        if (douYinOpenSDKConfig.getHostSettingService() != null) {
            OpenServiceManager.getInst().registerService(OpenHostSettingService.class, douYinOpenSDKConfig.getHostSettingService());
        }
    }

    /* renamed from: b */
    public static void m39b() {
        try {
            OpenServiceManager.getInst().registerService(OpenSdkTicketService.class, (OpenSdkTicketService) Class.forName("com.bytedance.sdk.open.aweme.openticket.OpenSdkTicketServiceImpl").newInstance());
        } catch (Exception e) {
            LogUtils.m28e(f78a, e);
        }
    }
}

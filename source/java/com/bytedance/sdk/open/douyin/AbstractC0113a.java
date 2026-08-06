package com.bytedance.sdk.open.douyin;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.init.DouYinOpenSDKConfig;
import com.bytedance.sdk.open.aweme.init.DouYinSdkContext;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import com.bytedance.sdk.open.douyin.impl.C0117a;
import com.bytedance.sdk.open.douyin.impl.C0119c;

/* renamed from: com.bytedance.sdk.open.douyin.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbstractC0113a {
    private static DouYinOpenConfig sConfig;

    public static DouYinOpenApi create(Activity activity) {
        if (sConfig == null || activity == null) {
            return null;
        }
        DouYinSdkContext.inst().setContext(activity);
        return new C0117a(activity, sConfig.clientKey);
    }

    @Deprecated
    public static DouYinOpenApi create(Activity activity, DouYinOpenConfig douYinOpenConfig) {
        if (douYinOpenConfig == null || activity == null) {
            return null;
        }
        if (!TextUtils.isEmpty(douYinOpenConfig.clientKey)) {
            DouYinSdkContext.inst().setClientKey(douYinOpenConfig.clientKey);
        }
        DouYinSdkContext.inst().setContext(activity);
        return new C0117a(activity, douYinOpenConfig.clientKey);
    }

    @Deprecated
    public static DouYinOpenConfig getConfig() {
        return sConfig;
    }

    @Deprecated
    public static boolean init(DouYinOpenConfig douYinOpenConfig) {
        if (douYinOpenConfig == null || TextUtils.isEmpty(douYinOpenConfig.clientKey)) {
            return false;
        }
        sConfig = douYinOpenConfig;
        DouYinSdkContext.inst().setClientKey(douYinOpenConfig.clientKey);
        return true;
    }

    public static void initConfig(DouYinOpenSDKConfig douYinOpenSDKConfig) {
        C0119c.m40a(douYinOpenSDKConfig);
    }

    public static boolean isBoe() {
        return DouYinSdkContext.inst().isBoe();
    }

    public static boolean isPpe() {
        return DouYinSdkContext.inst().isPpe();
    }

    public static void setBoe(boolean z) {
        DouYinSdkContext.inst().setBoe(z);
    }

    public static void setBoeProd(String str) {
        DouYinSdkContext.inst().setBoeProd(str);
    }

    public static void setDebuggable(boolean z) {
        LogUtils.sDebuggable = z;
    }

    public static void setPpe(boolean z) {
        DouYinSdkContext.inst().setPpe(z);
    }

    public static void setPpeProd(String str) {
        DouYinSdkContext.inst().setPpeProd(str);
    }
}

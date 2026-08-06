package com.ss.android.pushmanager;

import com.bytedance.common.support.PushCommonSupport;

/* loaded from: classes7.dex */
public class ApiConstants {
    private static String sHost;

    public static String i(String str) {
        return getHost() + str;
    }

    private static String getHost() {
        if (sHost == null) {
            synchronized (ApiConstants.class) {
                if (sHost == null) {
                    sHost = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mHost;
                }
            }
        }
        return sHost;
    }

    public static void setHost(String str) {
        sHost = str;
    }
}

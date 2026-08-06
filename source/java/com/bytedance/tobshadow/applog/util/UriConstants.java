package com.bytedance.tobshadow.applog.util;

import com.bytedance.tobshadow.applog.UriConfig;

/* loaded from: classes5.dex */
public class UriConstants {
    public static final int DEFAULT = 0;
    public static final int REGION_DEFAULT = 0;
    public static final UriConfig TOB_CHINA_NEW = new UriConfig.Builder().setRegisterUri("https://klink.volceapplog.com/service/2/device_register/").setReportOaidUri("https://klink.volceapplog.com/service/2/device_update").setActiveUri("https://klink.volceapplog.com/service/2/app_alert_check/").setSendUris(new String[]{"https://toblog.volceapplog.com/service/2/app_log/", "https://tobapplog.volceapplog.com/service/2/app_log/"}).setProfileUri("https://toblog.volceapplog.com/service/2/profile/").setSettingUri("https://toblog.volceapplog.com/service/2/log_settings/").setAbUri("https://abtest.volceapplog.com/service/2/abtest_config/").setALinkAttributionUri("https://alink.volceapplog.com/service/2/attribution_data").setALinkQueryUri("https://alink.volceapplog.com/service/2/alink_data").build();

    public static UriConfig createUriConfig(int i) {
        return TOB_CHINA_NEW;
    }
}

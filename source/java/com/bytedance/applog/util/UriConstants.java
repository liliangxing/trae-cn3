package com.bytedance.applog.util;

import com.bytedance.applog.UriConfig;
import com.bytedance.bdinstall.Env;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class UriConstants {
    private static final UriConfig BASE_CHINA = new UriConfig.Builder().setInstallEnv(Env.DEFAULT).setSendUris(new String[]{"https://log.zijieapi.com/service/2/app_log/", "https://applog.zijieapi.com/service/2/app_log/"}).setMonitor("https://log.zijieapi.com" + UriConfig.getMonitorPath()).setRealUris(new String[]{"https://rtlog.zijieapi.com/service/2/app_log/"}).setSettingUri("https://log.zijieapi.com/service/2/log_settings/").build();
    public static final int DEFAULT = 0;
    public static final int REGION_DEFAULT = 0;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface UriRegion {
    }

    public static final UriConfig createUriConfig(int i) {
        return BASE_CHINA;
    }
}

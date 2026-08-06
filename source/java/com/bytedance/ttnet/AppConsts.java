package com.bytedance.ttnet;

import android.text.TextUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AppConsts {
    public static final int APP_SECURITY_LEVEL_TTP_RESTRICTION = 2;
    public static final int APP_SECURITY_LEVEL_UNSPECIFIED = 0;
    public static final int APP_SECURITY_LEVEL_USER_PRIVACY_RESTRICTION = 1;
    public static final String KEY_DATA = "data";
    public static final String KEY_MESSAGE = "message";
    public static final String STATUS_ERROR = "error";
    public static final String STATUS_SUCCESS = "success";

    public static String getHostSuffix() {
        String hostSuffix = TTNetInit.getTTNetDepend().getHostSuffix();
        if (hostSuffix == null || TextUtils.isEmpty(hostSuffix)) {
            throw new IllegalArgumentException("hostSuffix is not init !!!");
        }
        return hostSuffix;
    }

    public static String getCdnHostSuffix() {
        String cdnHostSuffix = TTNetInit.getTTNetDepend().getCdnHostSuffix();
        if (cdnHostSuffix == null || TextUtils.isEmpty(cdnHostSuffix)) {
            throw new IllegalArgumentException("cdnHostSuffix is not init !!!");
        }
        return cdnHostSuffix;
    }
}

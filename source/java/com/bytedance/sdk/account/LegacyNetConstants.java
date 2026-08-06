package com.bytedance.sdk.account;

import com.bytedance.sdk.account.api.BDAccountNetApi;

/* loaded from: classes5.dex */
public class LegacyNetConstants extends BDAccountNetApi {
    public static final String CHECK_ENV_PATH = "/passport/safe/check_env/v1/";
    public static final String DEL_DEVICE_PATH = "/passport/safe/login_device/del/";
    public static final String DEVICES_LIST_PATH = "/passport/safe/login_device/list/";
    public static final String MOBILE_AUTH_PATH = "/passport/mobile/authorize/";
    public static final String MOBILE_CHECK_PATH = "/passport/mobile/check/";
    public static final String SMS_AUTH_PATH = "/passport/sms/authorize/";
    public static final String SWITCH_TICKET = "/passport/auth/switch_ticket/";
    private static final String USER_REFRESH_CAPTCHA_PATH_NEW = "/passport/mobile/refresh_captcha/";

    public static String getUserRefreshCaptcha() {
        return getUrl(USER_REFRESH_CAPTCHA_PATH_NEW);
    }

    public static String getSwitchTicket() {
        return getUrl(SWITCH_TICKET);
    }

    public static String getMobileCheckPath() {
        return getUrl(MOBILE_CHECK_PATH);
    }

    public static String getSMSAuthPath() {
        return getUrl(SMS_AUTH_PATH);
    }

    public static String getMobileAuthPath() {
        return getUrl(MOBILE_AUTH_PATH);
    }

    public static String getDeviceListPath() {
        return getUrl(DEVICES_LIST_PATH);
    }

    public static String getDelDevicePath() {
        return getUrl(DEL_DEVICE_PATH);
    }

    public static String getCheckEnvPath() {
        return getUrl(CHECK_ENV_PATH);
    }
}

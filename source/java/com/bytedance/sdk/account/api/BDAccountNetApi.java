package com.bytedance.sdk.account.api;

import com.ss.android.account.TTAccountInit;

/* loaded from: classes5.dex */
public class BDAccountNetApi {
    private static final String ACCOUNT_USERINFO_URL_PATH = "/passport/account/info/";
    private static final String ACCOUNT_USERINFO_URL_PATH_NEW = "/passport/account/info/v2/";
    protected static final String BEAT_URL = "/passport/token/beat/v2/";
    public static final String CHECK_CODE = "/passport/mobile/check_code/";
    public static final String CHECK_USER_NAME = "/2/user/check_name/";
    private static final String DEVICE_LOGIN_INFO_PATH = "/passport/device/login_info/";
    public static final String EMAIL_CHECK_CODE = "/passport/email/check_code/";
    public static final String EMAIL_RESET_PASSWORD = "/passport/password/reset_by_email_ticket/";
    private static final String SCHEME = "https://";
    public static final String SHARE_LOGIN_PATH = "/passport/share_login/";
    public static final String TICKET_RESET_PASSOWRD = "/passport/password/reset_by_ticket/";
    private static final String USER_LOGOUT_URL_PATH = "/2/user/logout/";
    private static final String USER_LOGOUT_URL_PATH_NEW = "/passport/user/logout/";
    public static final String USER_PWD_LOGIN_PATH = "/passport/user/login/";

    protected static String getHost() {
        return TTAccountInit.getConfig().host();
    }

    public static String getUrl(String str) {
        return "https://" + getHost() + str;
    }

    public static String getAccountUserInfo() {
        return getUrl(ACCOUNT_USERINFO_URL_PATH);
    }

    public static String getNewAccountUserInfo() {
        return getUrl("/passport/account/info/v2/");
    }

    public static String getUserLogoutUrl() {
        return getUrl("/passport/user/logout/");
    }

    public static String getTokenBeatHost() {
        return "https://" + getHost();
    }

    private static String getDebugPath(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String getCheckCode() {
        return getUrl(CHECK_CODE);
    }

    public static String getTicketResetPassowrd() {
        return getUrl(TICKET_RESET_PASSOWRD);
    }

    public static String getEmailCheckCode() {
        return getUrl(EMAIL_CHECK_CODE);
    }

    public static String getEmailTicketResetPassword() {
        return getUrl(EMAIL_RESET_PASSWORD);
    }

    public static String getCheckUserName() {
        return getUrl(CHECK_USER_NAME);
    }

    public static String getUserPasswordLogin() {
        return getUrl(USER_PWD_LOGIN_PATH);
    }

    public static String getDeviceLoginInfoPath() {
        return getUrl(DEVICE_LOGIN_INFO_PATH);
    }
}

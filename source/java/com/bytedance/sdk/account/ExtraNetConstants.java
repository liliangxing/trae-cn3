package com.bytedance.sdk.account;

import com.bytedance.sdk.account.api.BDAccountNetApi;

/* loaded from: classes5.dex */
public class ExtraNetConstants extends BDAccountNetApi {
    private static final String ACCOUNT_REMOVE = "/passport/account/remove/";
    public static final int API_EMAIL_CHANGE_BIND = 30002;
    public static final int API_EMAIL_CHANGE_PASSWORD = 30003;
    public static final int API_LOGIN_GUIDE_STRATEGY = 30001;
    public static final int API_SENSITIVE_CHECK = 30004;
    private static final String EMAIL_BIND = "/passport/email/bind/";
    private static final String EMAIL_CHANGE_BIND = "/passport/email/change/";
    private static final String EMAIL_CHANGE_PASSWORD = "/passport/email/change_password/";
    public static final String EMAIL_CHECK_REGISTER_PATH = "/passport/user/check_email_registered";
    private static final String EMAIL_REGISTER_CODE_VERIFY_PATH = "/passport/app/email/register/code_verify/";
    public static final String EMAIL_REGISTER_PATH_NEW = "/passport/email/register/v2/";
    public static final String EMAIL_REGISTER_VERIFY_LOGIN_PATH = "/passport/email/register_verify_login/";
    public static final String EMAIL_REGISTER_VERIFY_PATH = "/passport/email/register_verify/";
    public static final String EMAIL_SEND_CODE_PATH = "/passport/email/send_code/";
    private static final String EMAIL_TICKET_REGISTER_PATH = "/passport/app/email/register/ticket_register/";
    private static final String EMAIL_VERIFY = "/passport/email/verify/";
    private static final String LOGIN_GUIDE_STRATEGY_PATH = "/passport/general/login_guiding_strategy/";
    public static final String LOGOUT_OTHERS_PATH = "/passport/account/logout_others/";
    private static final String SENSITIVE_INFO_CHECK_PATH = "/user/check/sensitive_info/";
    public static final String SWITCH_AUTH_PATH = "/passport/account/switch/";
    public static final String USER_PWD_REGISTER_PATH = "/passport/username/register/";

    /* loaded from: classes5.dex */
    public interface EventName {
        public static final String EMAIL_CHANGE_BIND = "passport_email_change";
        public static final String EMAIL_CHANGE_PASSWORD = "passport_email_change_password";
        public static final String LOGIN_GUIDE_STRATEGY = "passport_general_login_guiding_strategy";
    }

    public static String getSwitchAuthHost() {
        return getUrl(SWITCH_AUTH_PATH);
    }

    public static String getSwitchAuthPath() {
        return getUrl(SWITCH_AUTH_PATH);
    }

    public static String getEmailVerifyPath() {
        return getUrl(EMAIL_VERIFY);
    }

    public static String getEmailRegisterCodeVerifyPath() {
        return getUrl(EMAIL_REGISTER_CODE_VERIFY_PATH);
    }

    public static String getEmailTicketRegisterPath() {
        return getUrl(EMAIL_TICKET_REGISTER_PATH);
    }

    public static String getEmailBindPath() {
        return getUrl(EMAIL_BIND);
    }

    public static String getAccountRemovePath() {
        return getUrl(ACCOUNT_REMOVE);
    }

    public static String getEmailRegister() {
        return getUrl(EMAIL_REGISTER_PATH_NEW);
    }

    public static String getEmailSendCode() {
        return getUrl(EMAIL_SEND_CODE_PATH);
    }

    public static String getEmailRegisterVerifyPath() {
        return getUrl(EMAIL_REGISTER_VERIFY_PATH);
    }

    public static String getEmailRegisterVerifyLoginPath() {
        return getUrl(EMAIL_REGISTER_VERIFY_LOGIN_PATH);
    }

    public static String getEmailCheckRegisterPath() {
        return getUrl(EMAIL_CHECK_REGISTER_PATH);
    }

    public static String getUserPasswordRegister() {
        return getUrl(USER_PWD_REGISTER_PATH);
    }

    public static String getLogoutOthersPath() {
        return getUrl(LOGOUT_OTHERS_PATH);
    }

    public static String getLoginGuideStrategyUrl() {
        return getUrl(LOGIN_GUIDE_STRATEGY_PATH);
    }

    public static String getEmailChangeBindUrl() {
        return getUrl(EMAIL_CHANGE_BIND);
    }

    public static String getEmailChangePasswordUrl() {
        return getUrl(EMAIL_CHANGE_PASSWORD);
    }

    public static String getSensitiveCheckUrl() {
        return getUrl(SENSITIVE_INFO_CHECK_PATH);
    }
}

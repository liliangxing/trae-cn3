package com.bytedance.sdk.account;

import com.bytedance.sdk.account.api.BDAccountNetApi;

/* loaded from: classes5.dex */
public class SpecialNetConstants extends BDAccountNetApi {
    private static final String ACCOUNT_AUTHORIZE = "/passport/account/authorize/";
    public static final String AFTER_REGISTER_LOGIN_BY_TICKET_PATH = "/passport/mobile/login_by_ticket/";
    private static final String AUTHORIZE_APP_SCAN_QRCODE = "/passport/mobile/scan_qrcode/";
    private static final String AUTHORIZE_QRCODE_TO_LOGIN = "/passport/mobile/confirm_qrcode/";
    private static final String BIND_EMAIL_FOR_DEVICE_LOGIN = "/passport/email/bind_email_for_device_login/";
    private static final String BIND_VISITOR_ACCOUNT = "/passport/user/bind_visitor_account/";
    public static final String CHECK_TV_QRCONNECT = "/passport/related_login/check_qrconnect/";
    private static final String CHECK_VISITOR_UPGRADE_PATH = "/passport/user/check_visitor_upgraded/";
    public static final String GENERATE_USER_INFO_TICKET_PATH = "/passport/mobile/generate_user_info_ticket/";
    private static final String GET_QRCODE = "/passport/mobile/get_qrcode/";
    private static final String GET_QRCODE_STATUS = "/passport/mobile/check_qrconnect/";
    public static final String GET_TV_QRCODE = "/passport/related_login/get_qrcode/";
    private static final String SSO_AUTHORIZE_APP_SCAN_QRCODE = "/passport/sso/scan_qrcode/";
    private static final String SSO_AUTHORIZE_QRCODE_TO_LOGIN = "/passport/sso/confirm_qrcode/";
    private static final String USER_DEVICE_LOGIN = "/passport/user/device_login/";
    public static final String VERIFY_ACCOUNT_PASSWORD_PATH = "/passport/account/verify/";

    public static String getAccountAuthorizePath() {
        return getUrl(ACCOUNT_AUTHORIZE);
    }

    public static String getUserDeviceLogin() {
        return getUrl(USER_DEVICE_LOGIN);
    }

    public static String getBindVisitorAccount() {
        return getUrl(BIND_VISITOR_ACCOUNT);
    }

    public static String getBindEmailForDeviceLoginPath() {
        return getUrl(BIND_EMAIL_FOR_DEVICE_LOGIN);
    }

    public static String getCheckVisitorUpgradePath() {
        return getUrl(CHECK_VISITOR_UPGRADE_PATH);
    }

    public static String getVerifyAccountPasswordPath() {
        return getUrl(VERIFY_ACCOUNT_PASSWORD_PATH);
    }

    public static String getGenerateUserInfoTicketPath() {
        return getUrl(GENERATE_USER_INFO_TICKET_PATH);
    }

    public static String getAfterRegisterLoginByTicketPath() {
        return getUrl(AFTER_REGISTER_LOGIN_BY_TICKET_PATH);
    }

    public static String getTVQrcodePath() {
        return getUrl(GET_TV_QRCODE);
    }

    public static String getTVCheckQrconnectPath() {
        return getUrl(CHECK_TV_QRCONNECT);
    }

    public static String getQRCodePath() {
        return getUrl(GET_QRCODE);
    }

    public static String getQRCodeStatusPath() {
        return getUrl(GET_QRCODE_STATUS);
    }

    public static String getAuthorizeScanQRCodePath() {
        return getUrl(AUTHORIZE_APP_SCAN_QRCODE);
    }

    public static String getAuthorizeQRCodeToLoginPath() {
        return getUrl(AUTHORIZE_QRCODE_TO_LOGIN);
    }

    public static String getSsoAuthorizeScanQRCodePath() {
        return getUrl(SSO_AUTHORIZE_APP_SCAN_QRCODE);
    }

    public static String getSsoAuthorizeQRCodeToLoginPath() {
        return getUrl(SSO_AUTHORIZE_QRCODE_TO_LOGIN);
    }
}

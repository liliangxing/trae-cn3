package com.bytedance.sdk.account;

import android.net.Uri;
import com.bytedance.sdk.account.api.BDAccountNetApi;

/* loaded from: classes5.dex */
public class ThirdPartyNetConstants extends BDAccountNetApi {
    public static final int API_AUTH_BIND_LOGIN = 70001;
    public static final int API_AUTH_CHANGE_BIND = 70004;
    public static final int API_AUTH_CODE_ACCESS_TOKEN = 70006;
    public static final int API_AUTH_LOGIN_AUTHORIZE = 70005;
    public static final int API_GET_OAUTH_TOKEN = 70002;
    public static final int API_OPEN_TOKEN_INFO = 70007;
    public static final int API_UPDATE_AUTHORIZE_INFO = 70003;
    private static final String AUTH_BIND_LOGIN = "/passport/auth/bind_login/";
    private static final String AUTH_BIND_WITH_MOBILE_LOGIN_PATH = "/passport/auth/bind_with_mobile_login/";
    public static String AUTH_CHANGE_BIND = "/passport/auth/change_bind/";
    private static final String AUTH_CHECK_BIND_LOGIN = "/passport/auth/check_mobile_login/";
    public static String AUTH_CODE_ACCESS_TOKEN = "/passport/auth/code_access_token/";
    public static String AUTH_LOGIN_AUTHORIZE = "/passport/auth/login_authorize/";
    public static final String AUTH_PATH = "/passport/auth/authorize/";
    private static final String BIND_WITH_MOBILE_PATH = "/passport/auth/bind_with_mobile/";
    public static final String CAN_AWEME_QUICK_LOGIN_PATH = "/passport/can_aweme_quick_login/";
    private static final String GET_OAUTH_TOKEN_PATH = "/passport/auth/get_oauth_token/";
    private static final String GET_OAUTH_TOKEN_PATH_V2 = "/passport/auth/get_oauth_token/v2/";
    public static final String KEY_TRIGGER_SCENE = "trigger_scene";
    private static final String LOGIN_URL_PATH = "/passport/auth/wap_login/";
    public static String OAUTH_PROFILE_PATH = "/user/get/oauth_profile/";
    public static String OPEN_TOKEN_INFO = "/passport/open/token_info/";
    private static final String SHARE_LOGIN_PATH = "/passport/auth/share_login/";
    private static final String SSO_AUTH_REGISTER = "/passport/auth/register/";
    private static final String SSO_CALLBACK_BIND_PATH = "/passport/auth/bind/";
    private static final String SSO_CALLBACK_URL_PATH = "/passport/auth/login/";
    public static final String SSO_LOGIN_ONLY_PATH = "/passport/auth/login_only/";
    private static final String SSO_SWITCH_BIND_PATH = "/passport/auth/switch_bind/";
    private static final String UNBIND_URL_PATH_NEW = "/passport/auth/unbind/";
    private static final String UPDATE_AUTHORIZE_INFO_PATH = "/passport/auth/update_authorize_info/";
    private static final String USERINFO_URL_PATH = "/2/user/info/";

    /* loaded from: classes5.dex */
    public interface EventName {
        public static final String AUTH_BIND_LOGIN = "passport_auth_bind_login";
        public static final String AUTH_CHANGE_BIND = "passport_auth_change_bind";
        public static final String AUTH_CODE_ACCESS_TOKEN = "passport_auth_code_access_token";
        public static final String AUTH_LOGIN_AUTHORIZE = "passport_auth_login_authorize";
        public static final String GET_OAUTH_TOKEN = "passport_auth_get_oauth_token";
        public static final String OPEN_TOKEN_INFO = "passport_open_token_info";
        public static final String UPDATE_AUTHORIZE_INFO = "update_authorize_info";
    }

    public static String getLoginUrl() {
        return getUrl(LOGIN_URL_PATH);
    }

    public static String getUnbindUrl() {
        return getUrl(UNBIND_URL_PATH_NEW);
    }

    public static String getSsoSwitchBind() {
        return getUrl(SSO_SWITCH_BIND_PATH);
    }

    public static String getSsoCallbackUrl() {
        return getUrl(SSO_CALLBACK_URL_PATH);
    }

    public static String getSsoOnlyLoginUrl() {
        return getUrl(SSO_LOGIN_ONLY_PATH);
    }

    public static String getSsoAuthRegister() {
        return getUrl(SSO_AUTH_REGISTER);
    }

    public static String getSsoCallbackBind() {
        return getUrl(SSO_CALLBACK_BIND_PATH);
    }

    public static String getUserinfoUrl() {
        return getUrl(USERINFO_URL_PATH);
    }

    public static String getAuthBindWithMobileLogin() {
        return getUrl(AUTH_BIND_WITH_MOBILE_LOGIN_PATH);
    }

    public static String getBindWithMobilePath() {
        return getUrl(BIND_WITH_MOBILE_PATH);
    }

    public static String getShareLoginPath() {
        return getUrl(SHARE_LOGIN_PATH);
    }

    public static String getAuthCheckBindLoginPath() {
        return getUrl(AUTH_CHECK_BIND_LOGIN);
    }

    public static String getOpenTokenInfoPath() {
        return getUrl(OPEN_TOKEN_INFO);
    }

    public static String getLoginUrl(String str) {
        StringBuilder sb = new StringBuilder(getLoginUrl());
        sb.append("?platform=").append(Uri.encode(str));
        return sb.toString();
    }

    public static String getOauthProfilePath() {
        return getUrl(OAUTH_PROFILE_PATH);
    }

    public static String getCanAwemeQuickLoginPath() {
        return getUrl(CAN_AWEME_QUICK_LOGIN_PATH);
    }

    public static String getMergeAuthPath() {
        return getUrl(AUTH_PATH);
    }

    public static String getAuthBindLoginUrl() {
        return getUrl(AUTH_BIND_LOGIN);
    }

    public static String getGetOauthTokenUrl() {
        return getUrl(GET_OAUTH_TOKEN_PATH);
    }

    public static String getGetOauthTokenUrlV2() {
        return getUrl(GET_OAUTH_TOKEN_PATH_V2);
    }

    public static String getUpdateAuthorizeInfoUrl() {
        return getUrl(UPDATE_AUTHORIZE_INFO_PATH);
    }

    public static String getAuthChangeBindPath() {
        return getUrl(AUTH_CHANGE_BIND);
    }

    public static String getAuthLoginAuthorizePath() {
        return getUrl(AUTH_LOGIN_AUTHORIZE);
    }

    public static String getAuthCodeAccessToken() {
        return getUrl(AUTH_CODE_ACCESS_TOKEN);
    }
}

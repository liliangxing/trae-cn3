package com.bytedance.sdk.account.bdplatform.model;

/* loaded from: classes5.dex */
public interface BDPlatformConstants {
    public static final String RESPONSE_TYPE = "response_type";

    /* loaded from: classes5.dex */
    public interface ClientErrorCode {
        public static final int CANCEL_ERROR_BACK_PRESSED = -33;
        public static final int CANCEL_ERROR_CANCEL_LOGIN = -31;
        public static final int CANCEL_ERROR_CLICK_CANCEL = -32;
        public static final int CANCEL_ERROR_LOGIN_FAIL = -30;
    }

    /* loaded from: classes5.dex */
    public interface ClientErrorDesc {
        public static final String CANCEL_ERROR_BACK_PRESSED = "back pressed";
        public static final String CANCEL_ERROR_CANCEL_LOGIN = "cancel login";
        public static final String CANCEL_ERROR_CLICK_CANCEL = "click cancel";
        public static final String CANCEL_ERROR_LOGIN_FAIL = "login fail";
    }

    /* loaded from: classes5.dex */
    public interface EventKey {
        public static final String EVENT_KEY_CLICK_BUTTON = "click_button";
        public static final String EVENT_KEY_CLIENT_KEY = "client_key";
        public static final String EVENT_KEY_ERRCODE = "errCode";
        public static final String EVENT_KEY_ERRDESC = "errDesc";
        public static final String EVENT_KEY_IS_AGREE = "is_agree";
        public static final String EVENT_KEY_POPUP_SCOPE = "popup_scope";
        public static final String EVENT_KEY_RESULT = "result";
        public static final String EVENT_KEY_SDK_VERSION = "sdk_version";
        public static final String EVENT_KEY_SPECIAL = "params_for_special";
        public static final String EVENT_KY_IS_FREE_AUTH = "is_free_auth";
    }

    /* loaded from: classes5.dex */
    public interface EventName {
        public static final String EVENT_PLATFORM_AUTH_CODE = "platform_auth_code";
        public static final String EVENT_PLATFORM_AUTH_INFO = "platform_auth_info";
        public static final String EVENT_PLATFORM_AUTH_RESULT = "platform_auth_result";
        public static final String EVENT_PLATFORM_AUTH_TICKET = "platform_auth_ticket";
        public static final String EVENT_PLATFORM_LOGIN_CLICK = "platform_login_click";
        public static final String EVENT_PLATFORM_LOGIN_NOTIFY = "platform_login_notify";
        public static final String EVENT_PLATFORM_LOGIN_POPUP = "platform_login_popup";
        public static final String EVENT_PLATFORM_LOGIN_POPUP_CLICK = "platform_login_popup_click";
    }

    /* loaded from: classes5.dex */
    public interface EventValue {
        public static final String EVENT_RESULT_CANCEL = "cancel";
        public static final String EVENT_RESULT_FAIL = "fail";
        public static final String EVENT_RESULT_SUCCESS = "success";
        public static final String EVENT_VALUE_CLICK_AUTH = "auth";
        public static final String EVENT_VALUE_CLICK_CANCEL = "cancel";
        public static final String EVENT_VALUE_SPECIAL = "uc_login";
    }

    /* loaded from: classes5.dex */
    public interface LoginResult {
        public static final int LOGIN_CANCEL = -2;
        public static final int LOGIN_FAILED = -1;
        public static final int LOGIN_SUCCESS = 0;
    }

    /* loaded from: classes5.dex */
    public interface ResponseType {
        public static final int AUTH_CODE_RESPONSE = 3;
        public static final int AUTH_INFO_RESPONSE = 1;
        public static final int AUTH_TICKET_RESPONSE = 2;
    }
}

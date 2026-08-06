package com.bytedance.sdk.account.common.constants;

/* loaded from: classes5.dex */
public interface BDOpenConstants {
    public static final String META_PLATFORM_SDK_VERSION = "BD_PLATFORM_SDK_VERSION";
    public static final int META_PLATFORM_SDK_VERSION_ERROR = -1;
    public static final String OAUTH_PATH = "/oauth/authorize/";
    public static final String REDIRECT_URL_PATH = "/oauth/authorize/callback/";

    /* loaded from: classes5.dex */
    public interface ErrorCode {
        public static final int ERROR_CODE_AUTH_DENIED = -4;
        public static final int ERROR_CODE_CANCEL = -2;
        public static final int ERROR_CODE_EXPIRED = 10007;
        public static final int ERROR_CODE_OK = 0;
        public static final int ERROR_CODE_SEND_FAILED = -3;
        public static final int ERROR_CODE_UNKNOW = -1;
        public static final int ERROR_CODE_UNSUPPORTED = -5;
        public static final int ERROR_CONFIG = 10003;
        public static final int ERROR_N_PARAMS = 10005;
        public static final int ERROR_PARAM = 10002;
        public static final int ERROR_REDIRECT_URL = 10006;
        public static final int ERROR_SCOPE = 10004;
        public static final int ERROR_SYSTEM = 10001;
        public static final int ERROR_TICKET = 10009;
        public static final int ERROR_TOKEN = 10008;
    }

    /* loaded from: classes5.dex */
    public interface ModeType {
        public static final int SEND_AUTH_REQUEST = 1;
        public static final int SEND_AUTH_RESPONSE = 2;
    }

    /* loaded from: classes5.dex */
    public interface Params {
        public static final String AUTH_CODE = "_bytedance_params_authcode";
        public static final String CALLER_BASE_OPEN_VERSION = "__bytedance_base_caller_version";
        public static final String CALLER_PKG = "_bytedance_params_type_caller_package";
        public static final String CLIENT_KEY = "_bytedance_params_client_key";
        public static final String CLIENT_SECRET = "_bytedance_params_client_secret";
        public static final String ERROR_CODE = "_bytedance_params_error_code";
        public static final String ERROR_MSG = "_bytedance_params_error_msg";
        public static final String EXTRA = "_bytedance_params_extra";
        public static final String FROM_ENTRY = "_bytedance_params_from_entry";
        public static final String GRANTED_PERMISSION = "_bytedance_params_granted_permission";
        public static final String NEXT_URL = "_bytedance_params_next_url";
        public static final String OPTIONAL_SCOPE0 = "_bytedance_params_optional_scope0";
        public static final String OPTIONAL_SCOPE1 = "_bytedance_params_optional_scope1";
        public static final String REDIRECT_URI = "_bytedance_params_redirect_uri";
        public static final String SCOPE = "_bytedance_params_scope";
        public static final String STATE = "_bytedance_params_state";
        public static final String TYPE = "_bytedance_params_type";
        public static final String WAP_REQUESETED_ORIENTATION = "wap_requested_orientation";
        public static final String WAP_TO_NATIVE_FROM_TAG = "wap_to_native_from_tag";
    }
}

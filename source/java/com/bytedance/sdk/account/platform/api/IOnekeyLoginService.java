package com.bytedance.sdk.account.platform.api;

import com.bytedance.sdk.account.platform.base.AuthorizeCallback;

/* loaded from: classes5.dex */
public interface IOnekeyLoginService extends IAuthorizeService {

    /* loaded from: classes5.dex */
    public interface ResponseConstants {
        public static final String ACCESS_TOKEN = "access_token";
        public static final String CARRIER_APP_ID = "carrier_app_id";
        public static final String CARRIER_FROM = "carrier_from";
        public static final String CM_AUTH_TYPE = "authType";
        public static final String CM_AUTH_TYPE_DES = "authTypeDes";
        public static final String CM_SCRIP_EXPIRES_IN = "scripExpiresIn";
        public static final String CT_REFRESH_TOKEN = "refreshToken";
        public static final String NET_STATUS = "net_status";
        public static final String NET_TYPE = "net_type";
        public static final String OPEN_ID = "openId";
        public static final String RAW_RESULT = "raw_result";
        public static final String SECURITY_PHONE = "security_phone";
        public static final String TOKEN_EXPIRES_IN = "expires_in";
        public static final String TOKEN_EXPIRES_TIME = "expires_time";
    }

    void cancel();

    void getAuthToken(AuthorizeCallback authorizeCallback);

    String getCacheMaskPhone();

    String getCarrier();

    int getNetworkStatus();

    void getPhoneInfo(AuthorizeCallback authorizeCallback);

    void getPhoneInfo(String str, AuthorizeCallback authorizeCallback);

    void getPhoneInfo(String str, boolean z, AuthorizeCallback authorizeCallback);

    void getValidateToken(AuthorizeCallback authorizeCallback);
}

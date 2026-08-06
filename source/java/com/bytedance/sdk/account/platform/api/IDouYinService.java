package com.bytedance.sdk.account.platform.api;

import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.Request;

@Deprecated
/* loaded from: classes5.dex */
public interface IDouYinService extends IAuthorizeService {

    /* loaded from: classes5.dex */
    public interface Extra {
        public static final String REQURE_MOBILE_BIND = "require_tel_num_bind";
    }

    /* loaded from: classes5.dex */
    public interface ResponseConstants {
        public static final String AUTH_CODE = "auth_code";
        public static final String EXTRA = "extras";
        public static final String GRANTED_PERMISSION = "granted_permission";
        public static final String STATE = "state";
    }

    /* loaded from: classes5.dex */
    public interface Scope {
        public static final String MOBILE = "mobile";
        public static final String MOBILE_ALERT = "mobile_alert";
        public static final String USER_INFO = "user_info";
    }

    /* loaded from: classes5.dex */
    public enum TargetAPP {
        AWEME,
        TIKTOK
    }

    boolean authorize(Request request, AuthorizeCallback authorizeCallback);

    boolean authorizeNative(Request request, AuthorizeCallback authorizeCallback);

    boolean authorizeWeb(Request request, AuthorizeCallback authorizeCallback);

    boolean authorizeWeb(Request request, Class cls, AuthorizeCallback authorizeCallback);

    String getSdkVersion();

    boolean isAppInstalled();

    boolean isAppSupportAuthBindMobile();

    boolean isAppSupportAuthorization();

    void onDestroy();
}

package com.bytedance.sdk.account.platform.api;

import android.app.Activity;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.Request;

/* loaded from: classes5.dex */
public interface ITiktokService extends IAuthorizeService {

    /* loaded from: classes5.dex */
    public interface AuthType {
        public static final int chromeTab = 2;
        public static final int tiktokApp = 0;
    }

    /* loaded from: classes5.dex */
    public interface Extra {
        public static final String REQURE_MOBILE_BIND = "require_tel_num_bind";
    }

    /* loaded from: classes5.dex */
    public interface ResponseConstants {
        public static final String AUTH_CODE = "auth_code";
        public static final String CODE_VERIFIER = "code_verifier";
        public static final String EXTRA = "extras";
        public static final String GRANTED_FIELDS = "granted_fields";
        public static final String GRANTED_PERMISSION = "granted_permission";
        public static final String REDIRECT_URL = "redirect_url";
        public static final String STATE = "state";
        public static final String TTOP_VERSION = "ttop_version";
    }

    @Deprecated
    /* loaded from: classes5.dex */
    public interface Scope {
        public static final String MOBILE = "mobile";
        public static final String MOBILE_ALERT = "mobile_alert";
        public static final String USER_INFO = "user_info";
    }

    boolean authorize(Activity activity, Request request, AuthorizeCallback authorizeCallback);

    boolean isAppSupportAuthorization(Activity activity);

    void onDestroy();
}

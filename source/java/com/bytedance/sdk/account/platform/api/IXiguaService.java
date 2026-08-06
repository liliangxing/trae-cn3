package com.bytedance.sdk.account.platform.api;

import android.app.Activity;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.Request;

/* loaded from: classes5.dex */
public interface IXiguaService extends IAuthorizeService {

    /* loaded from: classes5.dex */
    public interface ResponseConstants {
        public static final String AUTH_CODE = "auth_code";
        public static final String AUTH_METHOD = "auth_method";
        public static final String EXTRA = "extra";
        public static final String GRANTED_PERMISSION = "granted_permission";
        public static final String STATE = "state";
    }

    /* loaded from: classes5.dex */
    public interface Scope {
        public static final String MOBILE = "mobile";
        public static final String USER_INFO = "user_info";
    }

    void authorize(Activity activity, Request request, AuthorizeCallback authorizeCallback);
}

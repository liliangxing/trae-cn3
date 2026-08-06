package com.bytedance.sdk.account.platform.api;

import android.app.Activity;
import android.content.Intent;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.Request;

/* loaded from: classes5.dex */
public interface IDouYin2Service extends IAuthorizeService {

    /* loaded from: classes5.dex */
    public interface Extra {
        public static final String COMMENT_ID = "comment_id";
        public static final String IS_SKIP_UI_IN_THIRD_AUTH = "is_skip_ui_in_third_auth";
        public static final String IS_THIRD_AUTH_DIALOG = "is_third_auth_dialog";
        public static final String REQURE_MOBILE_BIND = "require_tel_num_bind";
        public static final String THIRD_AUTH_SCENE = "third_auth_scene";
        public static final String VERIFY_OPENID = "verify_openid";
        public static final String VERIFY_SCOPE = "verify_scope";
        public static final String VERIFY_TIC = "verify_tic";
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

    boolean authorize(Activity activity, Request request, AuthorizeCallback authorizeCallback);

    String getSdkVersion(Activity activity);

    @Deprecated
    boolean isAppInstalled(Activity activity, boolean z);

    boolean isAppSupportAuthBindMobile(Activity activity, boolean z);

    boolean isAppSupportAuthorization(Activity activity, boolean z);

    boolean isAppSupportSwitchAccount(Activity activity, boolean z);

    void onActivityResult(int i, int i2, Intent intent);

    void onDestroy();
}

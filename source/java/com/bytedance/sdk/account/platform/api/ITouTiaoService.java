package com.bytedance.sdk.account.platform.api;

import android.app.Activity;
import android.content.Intent;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.Request;

/* loaded from: classes5.dex */
public interface ITouTiaoService extends IAuthorizeService {

    /* loaded from: classes5.dex */
    public interface ResponseConstants {
        public static final String AUTH_CODE = "auth_code";
        public static final String EXTRA = "extras";
        public static final String GRANTED_PERMISSION = "grantedPermissions";
        public static final String STATE = "state";
    }

    /* loaded from: classes5.dex */
    public interface Scope {
        public static final String TT_SCOPE_INFO = "user_info";
    }

    boolean authorize(Activity activity, Request request, AuthorizeCallback authorizeCallback);

    boolean isAppInstalled();

    boolean isAppSupportAuthorization();

    void onActivityResult(int i, int i2, Intent intent);

    void onDestroy();
}

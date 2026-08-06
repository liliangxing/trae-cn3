package com.bytedance.sdk.account.platform.api;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.sdk.account.platform.base.ActivityResultHandler;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import java.util.Set;

/* loaded from: classes5.dex */
public interface IGoogleService extends IAuthorizeService {
    public static final int APP_AUTH_0 = 0;
    public static final int APP_AUTH_1 = 1;
    public static final int APP_AUTH_2 = 2;

    /* loaded from: classes5.dex */
    public interface CallbackHandler extends ActivityResultHandler {
        void onDestroy();
    }

    /* loaded from: classes5.dex */
    public interface CheckOneTapCallback {
        void onResult(int i, String str);
    }

    /* loaded from: classes5.dex */
    public interface RequestKey {
        public static final String AUTO_SELECT_ENABLED = "auto_select_enabled";
        public static final String FILTER_BY_AUTHORIZED_ACCOUNTS = "filter_by_authorized_accounts";
        public static final String NONCE = "nonce";
    }

    /* loaded from: classes5.dex */
    public interface ResponseKey {
        public static final String DISPLAY_NAME = "display_name";
        public static final String EMAIL = "email";
        public static final String EXPIRE_IN = "expire_in";
        public static final String FAMILY_NAME = "family_name";
        public static final String GIVEN_NAME = "given_name";
        public static final String GRANTED_SCOPES = "granted_scopes";
        public static final String ID = "id";
        public static final String ID_TOKEN = "idToken";
        public static final String NONCE = "nonce";
        public static final String PASSWORD = "password";
        public static final String PHONE_NUMBER = "phone_number";
        public static final String PROFILE_PICTURE_URI = "profile_picture_uri";
        public static final String SERVER_AUTH_CODE = "server_auth_code";
    }

    CallbackHandler authorize(Activity activity, int i, AuthorizeCallback authorizeCallback);

    CallbackHandler authorize(Activity activity, int i, Set<String> set, boolean z, AuthorizeCallback authorizeCallback);

    CallbackHandler authorizeOneTap(Activity activity, Bundle bundle, AuthorizeCallback authorizeCallback);

    void canShowGoogleOneTap(Activity activity, Bundle bundle, CheckOneTapCallback checkOneTapCallback);

    void googleSignOut(Activity activity);

    boolean isGooglePlayServiceAvailable();

    void revokeAccess();
}

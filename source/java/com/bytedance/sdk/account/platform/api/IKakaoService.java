package com.bytedance.sdk.account.platform.api;

import android.app.Activity;
import com.bytedance.sdk.account.platform.base.ActivityResultHandler;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;

/* loaded from: classes5.dex */
public interface IKakaoService extends IAuthorizeService {

    /* loaded from: classes5.dex */
    public interface CallbackHandler extends ActivityResultHandler {
    }

    /* loaded from: classes5.dex */
    public interface ResponseKey {
        public static final String ACCESS_TOKEN = "access_token";
        public static final String EXPIRES_IN = "expires_in";
    }

    CallbackHandler authorize(Activity activity, AuthorizeCallback authorizeCallback);

    void onDestroy();
}

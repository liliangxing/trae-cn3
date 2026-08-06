package com.bytedance.sdk.account.platform.api;

import android.app.Activity;
import com.bytedance.sdk.account.platform.base.ActivityResultHandler;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import java.util.Collection;

/* loaded from: classes5.dex */
public interface IFacebookService extends IAuthorizeService {

    /* loaded from: classes5.dex */
    public interface CallbackHandler extends ActivityResultHandler {
    }

    /* loaded from: classes5.dex */
    public interface Permission {
        public static final String PUBLIC = "public_profile";
    }

    /* loaded from: classes5.dex */
    public interface ResponseKey {
        public static final String ACCESS_TOKEN = "access_token";
        public static final String EXPIRES_IN = "expires_in";
        public static final String USER_ID = "user_id";
    }

    CallbackHandler loginWithPublishPermissions(Activity activity, Collection<String> collection, AuthorizeCallback authorizeCallback);

    CallbackHandler loginWithReadPermissions(Activity activity, Collection<String> collection, AuthorizeCallback authorizeCallback);
}

package com.bytedance.sdk.account.platform.api;

import android.app.Activity;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;

/* loaded from: classes5.dex */
public interface ITaptapService extends IAuthorizeService {
    public static final String TAPTAP_VERSION = "taptap_version";
    public static final String TAPTAP_VERSION_V2 = "v2";
    public static final String TAPTAP_VERSION_V3 = "v3";

    /* loaded from: classes5.dex */
    public interface ResponseConstants {
        public static final String ACCESS_TOKEN = "access_token";
        public static final String EXPIRE_IN = "expire_in";
        public static final String KID = "kid";
        public static final String MAC_ALGORITHM = "mac_algorithm";
        public static final String MAC_KEY = "mac_key";
        public static final String ORIGINAL_JSON = "original_json";
        public static final String TOKEN_TYPE = "token_type";
    }

    void authorize(Activity activity, AuthorizeCallback authorizeCallback);

    void logout(Activity activity);

    void onDestroy();
}

package com.bytedance.sdk.account.platform;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.api.AccountErrorCode;
import com.bytedance.sdk.account.api.IBDAccountPlatformAPI;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.impl.BDAccountPlatformImpl;
import com.bytedance.sdk.account.platform.FacebookPlatformDelegate;
import com.bytedance.sdk.account.platform.GooglePlatformDelegate;
import com.bytedance.sdk.account.platform.KakaoPlatformDelegate;
import com.bytedance.sdk.account.platform.LinePlatformDelegate;
import com.bytedance.sdk.account.platform.PlatformDelegate;
import com.bytedance.sdk.account.platform.TiktokPlatformDelegate;
import com.bytedance.sdk.account.platform.TwitterPlatformDelegate;
import com.bytedance.sdk.account.platform.VKPlatformDelegate;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class BaseAccountAdapter implements AuthorizeCallback {
    public static final int APP_AUTH_0 = 0;
    public static final int APP_AUTH_1 = 1;
    public static final int APP_AUTH_2 = 2;
    public static Map<String, PlatformDelegate.IFactory> delegateMap;
    protected IBDAccountPlatformAPI api;
    protected int appAuth;
    protected Map<String, String> mExtendParam;
    protected String platform;
    protected String platformId;

    static {
        HashMap hashMap = new HashMap();
        delegateMap = hashMap;
        hashMap.put("google", new GooglePlatformDelegate.Factory());
        delegateMap.put("facebook", new FacebookPlatformDelegate.Factory());
        delegateMap.put("twitter", new TwitterPlatformDelegate.Factory());
        delegateMap.put("line", new LinePlatformDelegate.Factory());
        delegateMap.put("kakaotalk", new KakaoPlatformDelegate.Factory());
        delegateMap.put("vk", new VKPlatformDelegate.Factory());
        delegateMap.put("tiktok", new TiktokPlatformDelegate.Factory());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseAccountAdapter(Context context, String str, String str2) {
        this.api = BDAccountPlatformImpl.instance();
        this.platformId = str;
        this.platform = str2;
        this.appAuth = 0;
    }

    BaseAccountAdapter(Context context, String str, String str2, int i) {
        this.api = BDAccountPlatformImpl.instance();
        this.platformId = str;
        this.platform = str2;
        this.appAuth = i;
    }

    public void setAppAuth(int i) {
        this.appAuth = i;
    }

    public void setExtendParam(Map<String, String> map) {
        this.mExtendParam = map;
    }

    public UserApiResponse getErrorResponse(AuthorizeErrorResponse authorizeErrorResponse) {
        UserApiResponse userApiResponse = new UserApiResponse(false, BaseApiResponse.API_ACCOUNT_AUTHORIZE);
        userApiResponse.error = authorizeErrorResponse.isCancel ? -1001 : AccountErrorCode.CommonError.COMMON_ERROR_AUTHORIZE;
        userApiResponse.mDetailErrorCode = userApiResponse.error;
        try {
            if (!TextUtils.isEmpty(authorizeErrorResponse.platformErrorCode)) {
                userApiResponse.mDetailErrorCode = Integer.parseInt(authorizeErrorResponse.platformErrorCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        userApiResponse.mDetailErrorMsg = TextUtils.isEmpty(authorizeErrorResponse.platformErrorMsg) ? authorizeErrorResponse.platformErrorDetail : authorizeErrorResponse.platformErrorMsg;
        return userApiResponse;
    }
}

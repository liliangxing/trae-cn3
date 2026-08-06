package com.bytedance.sdk.account.platform.douyin;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.IDouYin2Service;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.Request;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class DouYin2ServiceImpl implements IDouYin2Service {
    private static final int AUTH_BIND_MOBILE_API_VERSION = 4;
    private static final String ENTRY_ACTIVITY = "com.ss.android.ugc.aweme.openauthorize.AwemeAuthorizedActivity";
    private static final String META_PLATFORM_SDK_VERSION = "BD_PLATFORM_SDK_VERSION";
    private static final String PACKAGE_NAME_DOUYIN = "com.ss.android.ugc.aweme";
    private static final String PACKAGE_NAME_DOUYIN_LITE = "com.ss.android.ugc.aweme.lite";
    private String mClientKey;

    public DouYin2ServiceImpl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mClientKey = str;
        DouYinOpenApiFactory.init(new DouYinOpenConfig(str));
    }

    @Override // com.bytedance.sdk.account.platform.api.IDouYin2Service
    public boolean isAppInstalled(Activity activity, boolean z) {
        DouYinOpenApi douYinOpenApi;
        if (z) {
            douYinOpenApi = getDouYinLiteOpenApi(activity);
        } else {
            douYinOpenApi = getDouYinOpenApi(activity);
        }
        if (douYinOpenApi != null) {
            return douYinOpenApi.isAppInstalled();
        }
        return false;
    }

    @Override // com.bytedance.sdk.account.platform.api.IDouYin2Service
    public boolean isAppSupportAuthorization(Activity activity, boolean z) {
        DouYinOpenApi douYinOpenApi;
        if (z) {
            douYinOpenApi = getDouYinLiteOpenApi(activity);
        } else {
            douYinOpenApi = getDouYinOpenApi(activity);
        }
        if (douYinOpenApi != null) {
            return douYinOpenApi.isAppSupportAuthorization();
        }
        return false;
    }

    @Override // com.bytedance.sdk.account.platform.api.IDouYin2Service
    public boolean isAppSupportSwitchAccount(Activity activity, boolean z) {
        DouYinOpenApi douYinOpenApi;
        if (z) {
            douYinOpenApi = getDouYinLiteOpenApi(activity);
        } else {
            douYinOpenApi = getDouYinOpenApi(activity);
        }
        if (douYinOpenApi != null) {
            return douYinOpenApi.isSupportSwitchAccount();
        }
        return false;
    }

    @Override // com.bytedance.sdk.account.platform.api.IDouYin2Service
    public boolean isAppSupportAuthBindMobile(Activity activity, boolean z) {
        boolean isSupportAuthBindMobile = !z ? isSupportAuthBindMobile(activity, "com.ss.android.ugc.aweme", ENTRY_ACTIVITY, 4) : false;
        return !isSupportAuthBindMobile ? isSupportAuthBindMobile(activity, "com.ss.android.ugc.aweme.lite", ENTRY_ACTIVITY, 4) : isSupportAuthBindMobile;
    }

    @Override // com.bytedance.sdk.account.platform.api.IDouYin2Service
    public boolean authorize(Activity activity, Request request, AuthorizeCallback authorizeCallback) {
        int i = request.authType;
        if (i == 1) {
            return authorizeWithSwitchAccount(getDouYinOpenApi(activity), request, authorizeCallback);
        }
        if (i == 2) {
            return authorize(getDouYinLiteOpenApi(activity), request, authorizeCallback);
        }
        if (i == 3) {
            return authorizeWithSwitchAccount(getDouYinLiteOpenApi(activity), request, authorizeCallback);
        }
        if (i == 4) {
            return authorizeWeb(activity, request, authorizeCallback);
        }
        if (i == 5) {
            return authorizeInThirdApp(activity, request, authorizeCallback);
        }
        return authorize(getDouYinOpenApi(activity), request, authorizeCallback);
    }

    private boolean authorize(DouYinOpenApi douYinOpenApi, Request request, AuthorizeCallback authorizeCallback) {
        if (douYinOpenApi != null) {
            return Douyin.authorize(douYinOpenApi, request, authorizeCallback);
        }
        return false;
    }

    private boolean authorizeInThirdApp(Activity activity, Request request, AuthorizeCallback authorizeCallback) {
        DouYinOpenApi douYinOpenApi = getDouYinOpenApi(activity);
        if (douYinOpenApi != null) {
            return Douyin.authorizeInThirdApp(douYinOpenApi, request, authorizeCallback);
        }
        return false;
    }

    @Override // com.bytedance.sdk.account.platform.api.IDouYin2Service
    public void onDestroy() {
        Douyin.reset();
    }

    private boolean authorizeWeb(Activity activity, Request request, AuthorizeCallback authorizeCallback) {
        try {
            DouYinOpenApi douYinOpenApi = getDouYinOpenApi(activity);
            if (douYinOpenApi != null) {
                return Douyin.authorizeWeb(douYinOpenApi, request, authorizeCallback);
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean authorizeWithSwitchAccount(DouYinOpenApi douYinOpenApi, Request request, AuthorizeCallback authorizeCallback) {
        if (douYinOpenApi == null) {
            return false;
        }
        try {
            if (douYinOpenApi.isSupportSwitchAccount()) {
                request.extra.putBoolean(ParamKeyConstants.AuthParams.EXTRA_AUTH_NOT_SKIP_CONFIRM, true);
                return Douyin.authorize(douYinOpenApi, request, authorizeCallback);
            }
            return Douyin.authorizeWeb(douYinOpenApi, request, authorizeCallback);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.bytedance.sdk.account.platform.api.IDouYin2Service
    public String getSdkVersion(Activity activity) {
        DouYinOpenApi douYinOpenApi = getDouYinOpenApi(activity);
        return douYinOpenApi != null ? douYinOpenApi.getSdkVersion() : "";
    }

    private boolean isSupportAuthBindMobile(Activity activity, String str, String str2, int i) {
        if (activity == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = new ComponentName(str, str2);
            intent.setComponent(componentName);
            ActivityInfo resolveActivityInfo = intent.resolveActivityInfo(activity.getPackageManager(), 65536);
            int platformSDKVersion = getPlatformSDKVersion(activity, componentName);
            if (resolveActivityInfo != null) {
                return resolveActivityInfo.exported && platformSDKVersion >= i;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private int getPlatformSDKVersion(Activity activity, ComponentName componentName) {
        try {
            ActivityInfo activityInfo = activity.getPackageManager().getActivityInfo(componentName, 128);
            if (activityInfo != null && activityInfo.metaData != null) {
                return activityInfo.metaData.getInt("BD_PLATFORM_SDK_VERSION", -1);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private DouYinOpenApi getDouYinOpenApi(Activity activity) {
        if (activity != null) {
            return DouYinOpenApiFactory.create(activity);
        }
        return null;
    }

    private DouYinOpenApi getDouYinLiteOpenApi(Activity activity) {
        if (activity != null) {
            return DouYinOpenApiFactory.createDouYinLite(activity, new DouYinOpenConfig(this.mClientKey));
        }
        return null;
    }

    @Override // com.bytedance.sdk.account.platform.api.IDouYin2Service
    public void onActivityResult(int i, int i2, Intent intent) {
        if (Douyin.didCallback) {
            return;
        }
        Authorization.Response response = new Authorization.Response();
        response.errorCode = -2;
        Douyin.authorizeCallback(response);
    }
}

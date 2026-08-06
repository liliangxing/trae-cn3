package com.bytedance.sdk.open.aweme.authorize;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.helper.OpenEventHelper;
import com.bytedance.sdk.open.aweme.utils.AppUtil;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.trae.home.solo.setting.SettingsTracker;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class AuthImpl {
    private static final String TAG = "AuthImpl";
    private final String mClientKey;

    public AuthImpl(String str) {
        this.mClientKey = str;
    }

    private String buildComponentClassName(String str) {
        return "com.ss.android.ugc.aweme." + str;
    }

    public boolean authorizeNative(Activity activity, Authorization.Request request, String str, String str2, String str3, String str4, String str5) {
        if (activity == null) {
            LogUtils.m30w(TAG, "authorizeNative: activity is null");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            LogUtils.m30w(TAG, "authorizeNative: packageName is " + str);
            return false;
        }
        if (request == null) {
            LogUtils.m30w(TAG, "authorizeNative: req is null");
            return false;
        }
        if (!request.checkArgs()) {
            LogUtils.m30w(TAG, "authorizeNative: checkArgs fail");
            return false;
        }
        Bundle bundle = new Bundle();
        request.toBundle(bundle);
        bundle.putString("_bytedance_params_client_key", this.mClientKey);
        bundle.putString("_bytedance_params_type_caller_package", activity.getPackageName());
        if (TextUtils.isEmpty(request.callerLocalEntry)) {
            bundle.putString("_bytedance_params_from_entry", AppUtil.buildComponentClassName(activity.getPackageName(), str3));
        }
        bundle.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_NAME, str4);
        bundle.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_VERSION, str5);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, buildComponentClassName(str2)));
        intent.putExtras(bundle);
        try {
            activity.startActivityForResult(intent, 100);
            String str6 = TextUtils.equals(ParamKeyConstants.DOUYIN_PACKAGE_NAME, str) ? SettingsTracker.BINDING_TYPE_DOUYIN : TextUtils.equals(ParamKeyConstants.DOUYIN_LITE_PACKAGE_NAME, str) ? "douyinLite" : TextUtils.equals(ParamKeyConstants.DOUYIN_HOTSOON_PACKAGE_NAME, str) ? "dyhts" : "";
            OpenEventHelper.mobApiAuth(request, str6);
            OpenEventHelper.mobSdkCallHost(str6, "auth");
            return true;
        } catch (Exception e) {
            LogUtils.m30w(TAG, "authorizeNative: fail to startActivityForResult", e);
            return false;
        }
    }

    public boolean authorizeWeb(Activity activity, Class<?> cls, Authorization.Request request) {
        if (activity == null) {
            LogUtils.m30w(TAG, "authorizeWeb: activity is null");
            return false;
        }
        if (request == null) {
            LogUtils.m30w(TAG, "authorizeWeb: req is null");
            return false;
        }
        if (!request.checkArgs()) {
            LogUtils.m30w(TAG, "authorizeWeb: checkArgs fail");
            return false;
        }
        Bundle bundle = new Bundle();
        request.toBundle(bundle);
        bundle.putString("_bytedance_params_client_key", this.mClientKey);
        bundle.putString("_bytedance_params_type_caller_package", activity.getPackageName());
        Intent intent = new Intent(activity, cls);
        intent.putExtras(bundle);
        intent.addFlags(67108864);
        try {
            activity.startActivity(intent);
            OpenEventHelper.mobApiAuth(request, "H5");
            return true;
        } catch (Exception e) {
            LogUtils.m30w(TAG, "authorizeWeb: fail to startActivity", e);
            return false;
        }
    }
}

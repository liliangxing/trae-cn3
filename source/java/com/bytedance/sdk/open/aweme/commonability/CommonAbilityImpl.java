package com.bytedance.sdk.open.aweme.commonability;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.commonability.CommonAbility;
import com.bytedance.sdk.open.aweme.helper.OpenEventHelper;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.trae.home.solo.setting.SettingsTracker;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class CommonAbilityImpl {
    private static final String TAG = "CommonAbilityImpl";
    private final String mClientKey;
    private final Context mContext;

    public CommonAbilityImpl(Context context, String str) {
        this.mContext = context;
        this.mClientKey = str;
    }

    private String buildComponentClassName(String str) {
        return "com.ss.android.ugc.aweme." + str;
    }

    public boolean open(Activity activity, String str, String str2, String str3, CommonAbility.Request request, String str4, String str5) {
        if (activity == null) {
            LogUtils.m30w(TAG, "share: activity is null");
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            LogUtils.m30w(TAG, "share: remotePackageName is " + str2);
            return false;
        }
        if (request == null) {
            LogUtils.m30w(TAG, "share: request is null");
            return false;
        }
        if (!request.checkArgs()) {
            LogUtils.m30w(TAG, "share: checkArgs fail");
            return false;
        }
        Bundle bundle = new Bundle();
        request.toBundle(bundle);
        bundle.putString(ParamKeyConstants.CommonAbilityParam.CLIENT_KEY, this.mClientKey);
        bundle.putString(ParamKeyConstants.CommonAbilityParam.CALLER_PKG, this.mContext.getPackageName());
        bundle.putString(ParamKeyConstants.CommonAbilityParam.CALLER_SDK_VERSION, "1");
        bundle.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_NAME, str4);
        bundle.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_VERSION, str5);
        if (TextUtils.isEmpty(request.callerLocalEntry)) {
            bundle.putString("_bytedance_params_from_entry", this.mContext.getPackageName() + "." + str);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str2, buildComponentClassName(str3)));
        intent.putExtras(bundle);
        try {
            activity.startActivityForResult(intent, 104);
            OpenEventHelper.mobSdkCallHost(TextUtils.equals(ParamKeyConstants.DOUYIN_PACKAGE_NAME, str2) ? SettingsTracker.BINDING_TYPE_DOUYIN : TextUtils.equals(ParamKeyConstants.DOUYIN_LITE_PACKAGE_NAME, str2) ? "douyinLite" : TextUtils.equals(ParamKeyConstants.DOUYIN_HOTSOON_PACKAGE_NAME, str2) ? "dyhts" : "", "common");
            return true;
        } catch (Exception e) {
            LogUtils.m30w(TAG, "fail to startActivity", e);
            return false;
        }
    }
}

package com.bytedance.sdk.open.aweme.share;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.helper.OpenEventHelper;
import com.bytedance.sdk.open.aweme.share.Share;
import com.bytedance.sdk.open.aweme.utils.AppUtil;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.trae.home.solo.setting.SettingsTracker;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ShareImpl {
    private static final String TAG = "ShareImpl";
    private final String mClientKey;
    private final Context mContext;
    private IShareApplier shareApplier;

    public ShareImpl(Context context, IShareApplier iShareApplier) {
        this(context, iShareApplier.getClientKey());
        this.shareApplier = iShareApplier;
    }

    public ShareImpl(Context context, String str) {
        this.mContext = context.getApplicationContext();
        this.mClientKey = str;
    }

    private String buildComponentClassName(String str, String str2) {
        IShareApplier iShareApplier = this.shareApplier;
        return iShareApplier != null ? iShareApplier.getComponentClassName() : "com.ss.android.ugc.aweme." + str2;
    }

    protected void requestToBundle(String str, String str2, Share.Request request, Bundle bundle) {
        IShareApplier iShareApplier = this.shareApplier;
        if (iShareApplier != null) {
            iShareApplier.fillBundle(this.mContext, request, bundle);
        } else if (AppUtil.getPlatformSDKVersion(this.mContext, str, buildComponentClassName(str, str2)) >= 3) {
            request.toBundle(bundle);
        }
    }

    public boolean share(Activity activity, String str, String str2, String str3, Share.Request request, String str4, String str5, String str6) {
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
        requestToBundle(str2, str4, request, bundle);
        bundle.putString(ParamKeyConstants.ShareParams.CLIENT_KEY, this.mClientKey);
        bundle.putString(ParamKeyConstants.ShareParams.CALLER_PKG, this.mContext.getPackageName());
        bundle.putString(ParamKeyConstants.ShareParams.CALLER_SDK_VERSION, "1");
        if (TextUtils.isEmpty(request.callerLocalEntry)) {
            bundle.putString(ParamKeyConstants.ShareParams.CALLER_LOCAL_ENTRY, this.mContext.getPackageName() + "." + str);
        }
        Bundle bundle2 = request.extras;
        if (bundle2 != null) {
            bundle.putBundle("_bytedance_params_extra", bundle2);
        }
        bundle.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_NAME, str5);
        bundle.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_VERSION, str6);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str2, buildComponentClassName(str2, str3)));
        intent.putExtras(bundle);
        IShareApplier iShareApplier = this.shareApplier;
        if (iShareApplier != null) {
            iShareApplier.addIntentFlags(this.mContext, intent);
        } else {
            intent.addFlags(67108864);
        }
        try {
            activity.startActivityForResult(intent, 103);
            OpenEventHelper.mobSdkCallHost(TextUtils.equals(ParamKeyConstants.DOUYIN_PACKAGE_NAME, str2) ? SettingsTracker.BINDING_TYPE_DOUYIN : TextUtils.equals(ParamKeyConstants.DOUYIN_LITE_PACKAGE_NAME, str2) ? "douyinLite" : TextUtils.equals(ParamKeyConstants.DOUYIN_HOTSOON_PACKAGE_NAME, str2) ? "dyhts" : "", "share");
            return true;
        } catch (Exception e) {
            LogUtils.m30w(TAG, "fail to startActivity", e);
            return false;
        }
    }
}

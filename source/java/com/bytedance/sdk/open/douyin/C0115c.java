package com.bytedance.sdk.open.douyin;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.helper.OpenEventHelper;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.douyin.model.OpenRecord;
import com.bytedance.trae.home.solo.setting.SettingsTracker;

/* renamed from: com.bytedance.sdk.open.douyin.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0115c {

    /* renamed from: b */
    private static final String f54b = "OpenRecordImpl";

    /* renamed from: a */
    private final String f55a;

    public C0115c(String str) {
        this.f55a = str;
    }

    /* renamed from: a */
    private String m31a(String str) {
        return "com.ss.android.ugc.aweme." + str;
    }

    /* renamed from: a */
    public void m32a(Activity activity, String str, String str2, String str3, OpenRecord.Request request, String str4, String str5) {
        if (activity == null) {
            LogUtils.m30w(f54b, "openRecord: activity is null");
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            LogUtils.m30w(f54b, "openRecord: remotePackageName is " + str2);
            return;
        }
        if (request == null) {
            LogUtils.m30w(f54b, "openRecord: request is null");
            return;
        }
        Bundle bundle = new Bundle();
        request.toBundle(bundle);
        bundle.putString(ParamKeyConstants.ShareParams.CLIENT_KEY, this.f55a);
        bundle.putString(ParamKeyConstants.ShareParams.CALLER_PKG, activity.getPackageName());
        if (TextUtils.isEmpty(request.callerLocalEntry)) {
            bundle.putString(ParamKeyConstants.ShareParams.CALLER_LOCAL_ENTRY, activity.getPackageName() + "." + str);
        }
        Bundle bundle2 = request.extras;
        if (bundle2 != null) {
            bundle.putBundle("_bytedance_params_extra", bundle2);
        }
        bundle.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_NAME, str4);
        bundle.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_VERSION, str5);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str2, m31a(str3)));
        intent.putExtras(bundle);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        try {
            activity.startActivityForResult(intent, 102);
            OpenEventHelper.mobSdkCallHost(TextUtils.equals(ParamKeyConstants.DOUYIN_PACKAGE_NAME, str2) ? SettingsTracker.BINDING_TYPE_DOUYIN : TextUtils.equals(ParamKeyConstants.DOUYIN_LITE_PACKAGE_NAME, str2) ? "douyinLite" : TextUtils.equals(ParamKeyConstants.DOUYIN_HOTSOON_PACKAGE_NAME, str2) ? "dyhts" : "", "open_record");
        } catch (Exception e) {
            LogUtils.m28e(f54b, e);
        }
    }
}

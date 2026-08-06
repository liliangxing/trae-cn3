package com.bytedance.sdk.open.douyin;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.helper.OpenEventHelper;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.douyin.ShareToContact;
import com.bytedance.sdk.open.tt.InterfaceC0136b;
import com.bytedance.trae.home.solo.setting.SettingsTracker;

/* renamed from: com.bytedance.sdk.open.douyin.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0116d {

    /* renamed from: b */
    private static final String f56b = "ShareToContactImpl";

    /* renamed from: a */
    private final String f57a;

    public C0116d(String str) {
        this.f57a = str;
    }

    /* renamed from: a */
    private String m33a(String str) {
        return "com.ss.android.ugc.aweme." + str;
    }

    /* renamed from: a */
    public boolean m34a(Activity activity, String str, String str2, String str3, ShareToContact.Request request) {
        if (activity == null) {
            LogUtils.m30w(f56b, "shareToContacts: activity is null");
        } else if (TextUtils.isEmpty(str2)) {
            LogUtils.m30w(f56b, "shareToContacts: remotePackageName is " + str2);
        } else if (request == null) {
            LogUtils.m30w(f56b, "shareToContacts: request is null");
        } else {
            if (request.checkArgs()) {
                Bundle bundle = new Bundle();
                request.toBundle(bundle);
                bundle.putString(InterfaceC0136b.a.f203c, this.f57a);
                if (TextUtils.isEmpty(request.callerLocalEntry)) {
                    bundle.putString(InterfaceC0136b.a.f213m, activity.getPackageName() + "." + str);
                }
                Bundle bundle2 = request.extras;
                if (bundle2 != null) {
                    bundle.putBundle(InterfaceC0136b.a.f205e, bundle2);
                }
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(str2, m33a(str3)));
                intent.putExtras(bundle);
                intent.addFlags(32768);
                activity.startActivityForResult(intent, 101);
                OpenEventHelper.mobSdkCallHost(TextUtils.equals(ParamKeyConstants.DOUYIN_PACKAGE_NAME, str2) ? SettingsTracker.BINDING_TYPE_DOUYIN : TextUtils.equals(ParamKeyConstants.DOUYIN_LITE_PACKAGE_NAME, str2) ? "douyinLite" : TextUtils.equals(ParamKeyConstants.DOUYIN_HOTSOON_PACKAGE_NAME, str2) ? "dyhts" : "", "im");
                return true;
            }
            LogUtils.m30w(f56b, "shareToContacts: checkArgs fail");
        }
        return false;
    }
}
